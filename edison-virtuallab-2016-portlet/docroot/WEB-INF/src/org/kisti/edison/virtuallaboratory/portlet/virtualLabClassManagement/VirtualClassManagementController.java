package org.kisti.edison.virtuallaboratory.portlet.virtualLabClassManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonTempUserUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClass;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabUserLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class VirtualClassManagementController {
	private static Log log = LogFactoryUtil.getLog(VirtualClassManagementController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			long groupId = themeDisplay.getScopeGroupId();
			long selectClassId = ParamUtil.get(request, "selectClassId", 0);
			long curPage = ParamUtil.get(request, "curPage", 1);
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			
			Map<String, Object> params = RequestUtil.getParameterMap(httpRequest);
			
			User user = PortalUtil.getUser(request);
			
			for (Map.Entry<String,Object> str : params.entrySet()) {
				if(str.getKey().contains("virtualLabId")) {
					model.addAttribute("virtualLabId", str.getValue());
				}
			}
			
			if(selectClassId > 0) {
				Map<String, Object> virtualLabClassInfo = VirtualLabClassLocalServiceUtil.getVirtualLabClassInfo(selectClassId, locale);
				virtualLabClassInfo.put("curPage", curPage);
				model.addAttribute("virtualLabClassInfo", virtualLabClassInfo);
			}
			
			long classPlid = PortalUtil.getPlidFromPortletId(groupId, "edisonvirtuallabclassmainvisual_WAR_edisonvirtuallab2016portlet");
			PortletURL classURL = PortletURLFactoryUtil.create(request, "edisonvirtuallabclassmainvisual_WAR_edisonvirtuallab2016portlet", classPlid, PortletRequest.RENDER_PHASE);
			
			model.addAttribute("classURL", classURL.toString());
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		
		return "virtualLabClassManagement/virtualLabClassManagement";
	}
	
	@ResourceMapping(value="virtualLabClassList")
	public void getVirtualLabClassList(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		User user = PortalUtil.getUser(request);
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		int curPage = ParamUtil.get(request, "curPage", 1);
		int linePerPage = 5;
		
		int pagePerBlock = 10;
		int begin = linePerPage * (curPage - 1);
		String portletNameSpace = response.getNamespace();
		
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		params.put("virtualLabId", ParamUtil.get(request, "virtualLabId", "0"));
		params.put("begin", begin);
		params.put("end", linePerPage);
		
		Role virtualLabOwner = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
		Role virtualLabManager = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);
		
		List<Map<String, Object>> virtualLabClassList = null;
		int virtualLabClassCount = 0;
		
		if (!(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)
				|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)
				|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)
				|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwner.getRoleId(), virtualLabId))) {
			params.put("userId", user.getUserId());
			params.put("virtualLabClassOwnerName", EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
			params.put("virtualLabClassManagerName", EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);
		}
		
		virtualLabClassList = VirtualLabClassLocalServiceUtil.getVirtualClassList(params, locale);
		virtualLabClassCount = VirtualLabClassLocalServiceUtil.getVirtualClassListCount(params);
		
		JSONObject obj = new JSONObject();
		
		String pageList = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", virtualLabClassCount, curPage, linePerPage, pagePerBlock);
		
		obj.put("selectLine", linePerPage);
		obj.put("curPage", curPage);
		obj.put("pageList", pageList);
		obj.put("virtualLabClassList", virtualLabClassList);
		obj.put("totalCnt", virtualLabClassCount);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ResourceMapping(value="virtualLabClassInfo")
	public void getVirtualLabClassInfo(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		long classId = ParamUtil.get(request, "classId", 0L);
		Map<String, Object> virtualLabClassInfo = VirtualLabClassLocalServiceUtil.getVirtualLabClassInfo(classId, locale);
		
		JSONObject obj = new JSONObject();
		
		obj.put("virtualLabClassInfo", virtualLabClassInfo);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ActionMapping(params = "myaction=virtualClassSave")
	public void virtualClassSave(ActionRequest request, ActionResponse response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			User user = PortalUtil.getUser(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long companyId = PortalUtil.getCompanyId(request);
			
			Role virtualClassOwner = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
			Role virtualLabOwner = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
			Role virtualLabManager = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);
			
			Map<String, Object> params = RequestUtil.getParameterMap(request);
			
			long classId = ParamUtil.get(request, "classId", 0L);
			long virtualLabId = ParamUtil.get(request, "virtualLabId", 0L);
			
			params.put("classId", classId);
			params.put("virtualLabId",ParamUtil.get(request, "virtualLabId", 0L));
			params.put("classDescription",ParamUtil.get(request, "classDescription", ""));
			params.put("classTitle",ParamUtil.get(request, "classTitle", ""));
			params.put("classStartDt",ParamUtil.get(request, "classStartDt", ""));
			params.put("classEndDt",ParamUtil.get(request, "classEndDt", ""));
			params.put("classPersonnel",ParamUtil.get(request, "classPersonnel", 50));
			
			VirtualLabClass virtualLabClass = VirtualLabClassLocalServiceUtil.insertVirtualLabClass(params, locale);
			
			if(classId == 0 && (UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwner.getRoleId(), virtualLabId)
							|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabManager.getRoleId(), virtualLabId))) {
				EdisonUserUtil.addSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);	// 가상 클래스 오너 권한 부여
				UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(user.getUserId(), groupId, virtualClassOwner.getRoleId(), virtualLabClass.getClassId());	// 가상 클래스 오너 커스텀 롤 부여
			}
			
			// 주소창에 virtualLabId 를 get 방식으로 넘겨줘야 네비게이션에서 클릭했을때 다시 가상실험실 관리 페이지로 돌아갈수 있음
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setParameter("virtualLabId", CustomUtil.strNull(virtualLabId));
			portletURL.setParameter("selectClassId", CustomUtil.strNull(virtualLabClass.getClassId()));

			SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
			
			response.sendRedirect(portletURL.toString() + "&virtualLabId=" + ParamUtil.get(request, "virtualLabId", "0"));
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
		}
	}
	
	@ResourceMapping(value="virtualClassUserInfo")
	public void getVirtualClassUserInfo(ResourceRequest request, ResourceResponse response) throws Exception {
		String virtualLabId = ParamUtil.get(request, "virtualLabId", "0");
		String classId = ParamUtil.get(request, "classId", "0");
		String userScreenName = ParamUtil.get(request, "searchField", "");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		JSONObject obj = new JSONObject();
		
		User user = null;
		user = UserLocalServiceUtil.fetchUserByScreenName(companyId, userScreenName);
		
		Map<String, String> virtualLabClassUserInfo = null;
		if (user == null) {
			obj.put("result", "none");
		} else {
			Role labOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);		// Lab Owner Role Id 확인
			Role labManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);		// Lab Manager Role Id 확인
			Role classOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);		// Class Owner Role Id 확인
			Role calssManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);		// Class Manager Role Id 확인
			
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(checker);
			
			if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)
				|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)
				|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)) {
				obj.put("result", "admin");
			} else if (UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, labOwnerRole.getRoleId(), Long.parseLong(virtualLabId))) {	// Owner 체크
				obj.put("result", "labowner");
//			실험실 매니저를 클래스 매니저로 등록 할 수 있도록 수정
//			} else if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, labManagerRole.getRoleId(), Long.parseLong(virtualLabId))) {	// Manager 체크
//				obj.put("result", "labmanager");
			} else if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, classOwnerRole.getRoleId(), Long.parseLong(classId))) {
				obj.put("result", "classowner");
			} else if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, calssManagerRole.getRoleId(), Long.parseLong(classId))) {
				obj.put("result", "classmanager");
			} else {
				virtualLabClassUserInfo = new HashMap<String, String>();
				
				virtualLabClassUserInfo.put("classId", classId);
				virtualLabClassUserInfo.put("userId", String.valueOf(user.getUserId()));
				virtualLabClassUserInfo.put("userScreenName", user.getScreenName());
				virtualLabClassUserInfo.put("userFullName", user.getFullName());
				virtualLabClassUserInfo.put("userFirstName", user.getFirstName());
				virtualLabClassUserInfo.put("userEmailAddress", user.getEmailAddress());
				virtualLabClassUserInfo.put("userJobTitle", user.getJobTitle());
				obj.put("virtualLabClassUserInfo", virtualLabClassUserInfo);
				obj.put("result", "user");
			}
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ResourceMapping(value="virtualClassManagerList")
	public void getVirtualClassManagerList(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, IOException {
		String classId = ParamUtil.get(request, "classId", "0");
		String classUserId = ParamUtil.get(request, "classUserId", "0");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		if (!classUserId.equals("0")) {
			User requestUser = UserLocalServiceUtil.fetchUser(Long.parseLong(classUserId));
			
			EdisonUserUtil.addSiteRole(requestUser, groupId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);	// VIRTUAL_LAB_OWNER 권한 체크
			EdisonUserUtil.addGroup(requestUser, EdisonRoleConstants.TUTOR_GROUP);						// TUTOR Group 추가
			
			Role role = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);		// Role Id 확인
			UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(Long.parseLong(classUserId), groupId, role.getRoleId(), Long.parseLong(classId));
		}
		
		JSONObject obj = new JSONObject();
		if (classId != null && !classId.equals("0")) {
			Role role = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);
			List<Map<String, String>> virtualLabClassAuthList =UserGroupRoleCustomLocalServiceUtil.getUserList(groupId, role.getRoleId(), Long.parseLong(classId));
			if (virtualLabClassAuthList == null) {
				virtualLabClassAuthList = new ArrayList<Map<String, String>>();
			}
			obj.put("virtualLabClassAuthList", virtualLabClassAuthList);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ResourceMapping(value="deleteVirtualClassManager")
	public void deleteVirtualClassManager(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		String virtualClassId = ParamUtil.get(request, "virtualClassId", "0");
		String classManagerId = ParamUtil.get(request, "classManagerId", "0");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);

		if (!virtualClassId.equals("0")) {
			Role role = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);		// Role Id 확인
			UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(Long.parseLong(classManagerId), groupId, role.getRoleId(), Long.parseLong(virtualClassId));
			
			List<Map<String,String>> customList =  UserGroupRoleCustomLocalServiceUtil.getCustomList(Long.parseLong(classManagerId), groupId, role.getRoleId());
			
			// 커스텀 롤 테이블에 가상 클래스 매니저 권한이 없을경우 매니저 사이트롤을 지워줌
			if (customList == null || customList.size() == 0) {
				EdisonUserUtil.deleteSiteRole(UserLocalServiceUtil.getUser(Long.parseLong(classManagerId)), groupId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);
			}
		}
		
		JSONObject obj = new JSONObject();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ResourceMapping(value="deleteStudent")
	public void deleteStudent(ResourceRequest request, ResourceResponse response) throws Exception {
		//일반 학생 수강신청 삭제
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0L);
		long classId = ParamUtil.get(request, "classId", 0L);
		String result = "200";
		long groupId = PortalUtil.getScopeGroupId(request);
		
		List<Map<String, Object>> classUserList = VirtualLabUserLocalServiceUtil.getVirtualClassStudentList(virtualLabId, classId, 0, null, groupId);
		
		if(classUserList != null && classUserList.size() > 0) {
		//임시 학생 수강신청, TEMP USER DEACTIVE 아이디 삭제
			for (Map<String,Object> virtualLabUser : classUserList) {
				if(virtualLabUser.get("requestSort").equals("TEMP")) {
					User tempUser = UserLocalServiceUtil.fetchUser((Long) virtualLabUser.get("userId"));
					if(tempUser != null) {
						EdisonTempUserUtil.deleteUser(tempUser);
//						SimulationJobLocalServiceUtil.deleteMonitoringByJobClassId(groupId, classId, tempUser);	// 임시 유저 모니터링 정보 삭제
					}
				}
				VirtualLabUserLocalServiceUtil.deleteVirtualLabUser((Long)virtualLabUser.get("virtualLabUserId"));
			}
		}
		
		JSONObject obj = new JSONObject();
		
		obj.put("result", result);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ResourceMapping(value="virtualLabClassDisable")
	public void virtualLabClassDisable(ResourceRequest request, ResourceResponse response) throws Exception {
		User user = PortalUtil.getUser(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		String result = "400";	// 삭제 실패
		
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0L);
		long classId = ParamUtil.get(request, "classId", 0L);
		Role virtualLabOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
		Role virtualLabClassOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
		
		if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) ||	// 포털 Admin Check
				EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR) ||	// 사이트 Admin Check
				EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER) ||	// 사이트 Owner Check
				UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwnerRole.getRoleId(), virtualLabId) ||
				UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabClassOwnerRole.getRoleId(), classId)) {
			int studentCount = VirtualLabUserLocalServiceUtil.getStudentCount(virtualLabId, classId);
			if(studentCount > 0) {
				result = "500"; // 수강하고 있는 학생들이 존재함
			} else {
				VirtualLabClassLocalServiceUtil.updateVirtualLabClassDisable(classId, "N");
				
				// 게시판 파일 삭제
				List<Long> boardSeqList = VirtualLabClassLocalServiceUtil.getVirtualClassBoardSeqList(groupId, classId);
				if(boardSeqList != null && boardSeqList.size() > 0) {
					for (Long boardSeq : boardSeqList) {
						EdisonFileUtil.deleteGroupEdisonFile(groupId, "_" + classId + "_NOTICE", CustomUtil.strNull(boardSeq));
					}
				}
				
				result = "200";	// 삭제 성공
			}
		} else {
			result = "300";	// 삭제 실패 (권한 없음)
		}
		
		JSONObject obj = new JSONObject();
		
		obj.put("result", result);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
}
