package org.kisti.edison.virtuallaboratory.portlet.virtualLabMainVisual;

import java.io.PrintWriter;
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
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabLocalServiceUtil;
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
import com.liferay.portal.kernel.util.GetterUtil;
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
public class VirtualLabMainVisualController {
	private static Log log = LogFactoryUtil.getLog(VirtualLabMainVisualController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) throws PortalException, SystemException {
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
		httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
		User user = PortalUtil.getUser(request);
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		Group group = GroupLocalServiceUtil.getGroup(groupId);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			String virtualLabId = httpRequest.getParameter("virtualLabId");
			Map<String, Object> params = RequestUtil.getParameterMap(httpRequest);
			for (Map.Entry<String,Object> str : params.entrySet()) {
				if(str.getKey().contains("virtualLabId")) {
					virtualLabId =  (String) str.getValue();
				}
			}
			
			Locale locale = themeDisplay.getLocale();
			
			Role virtualLabOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
			Role virtualLabManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);
			
			Map<String, Object> labInfo = null;
			model.addAttribute("homeURL", themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + group.getFriendlyURL() + "/home");
			model.addAttribute("backURL", themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + group.getFriendlyURL() + "/virtual-lab");
			
			// 가상실험실 관리 목록으로 가는 plid
			model.addAttribute("lablistPlid", PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonvirtuallabmanagementlist_WAR_edisonvirtuallab2016portlet"));
			
			if(virtualLabId == null || virtualLabId.length() == 0) {
//				if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)) {
//					return "virtualLabMainVisual/virtualLabMainVisual";
//				}
				return "virtualLabMainVisual/virtualLab_Exception";
			} else if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) ||	// 포털 Admin Check
				EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR) ||	// 사이트 Admin Check
				EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER) ||	// 사이트 Owner Check
				UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwnerRole.getRoleId(), Long.parseLong(virtualLabId))	|| //
				UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabManagerRole.getRoleId(), Long.parseLong(virtualLabId))) {
				boolean manager = UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabManagerRole.getRoleId(), Long.parseLong(virtualLabId));
				
				if(manager) {
					model.addAttribute("role", "MANAGER");
				} else {
					model.addAttribute("role", "ADMIN");
				}
				
				labInfo = VirtualLabLocalServiceUtil.getVirtualLabInfomation(Long.parseLong(virtualLabId), locale);
				if (labInfo != null && CustomUtil.strNull(labInfo.get("virtualLabUseYn")).equals("Y")) {
					model.addAttribute("labInfo", labInfo);
				} else {
					return "virtualLabMainVisual/virtualLab_Exception";
				}
				model.addAttribute("languageId", themeDisplay.getLanguageId());
			} else {
				return "virtualLabMainVisual/virtualLab_Exception";
			}
		} catch (Exception e) {
			return "virtualLabMainVisual/virtualLab_Exception";
		}
		return "virtualLabMainVisual/virtualLabMainVisual";
	}
	
	@ActionMapping(params = "myaction=updateVirtualLabInfomation")
	public void updateVirtualLabInfomation(ActionRequest request, ActionResponse response) {
		try {
			Map<String, String> params = RequestUtil.getParameterMap(request);
			String select_languageId = CustomUtil.strNull(params.get("select_languageId"));
			String status = GetterUtil.get(params.get("status"), "");
			
			long companyId = PortalUtil.getCompanyId(request);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			
			if(status.equals("UPDATE")) {
				VirtualLabLocalServiceUtil.updateVirtualLabInfomation(params, locale);
			}else if (status.equals("TRANSFER")) {
				String virtualLabOwnerName = GetterUtil.get(params.get("virtualLabOwnerName"), "");
				User user = UserLocalServiceUtil.getUserByScreenName(companyId, virtualLabOwnerName);
				Role role = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);		// Role Id 확인
				long virtualLabId = GetterUtil.get(params.get("virtualLabId"), 0);
				
				VirtualLabLocalServiceUtil.transferVirtualLabOwner(virtualLabId, user.getUserId(), role.getRoleId(), companyId);
			}
			
			// 주소창에 virtualLabId 를 get 방식으로 넘겨줘야 네비게이션에서 클릭했을때 다시 가상실험실 관리 페이지로 돌아갈수 있음
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setParameter("virtualLabId", CustomUtil.strNull(params.get("virtualLabId")));
			
			SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);

			response.sendRedirect(portletURL.toString() + "&virtualLabId=" + CustomUtil.strNull(params.get("virtualLabId")));
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
		}
	}
	
	@ResourceMapping(value="virtualLabDisable")
	public void virtualLabDisable(ResourceRequest request, ResourceResponse response) throws Exception {
		User user = PortalUtil.getUser(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		String result = "400";	// 삭제 실패
		
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0L);
		Role virtualLabOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
		
		if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) ||	// 포털 Admin Check
				EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR) ||	// 사이트 Admin Check
				EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER) ||	// 사이트 Owner Check
				UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwnerRole.getRoleId(), virtualLabId)) {
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("groupId", groupId);
			params.put("virtualLabId", ParamUtil.get(request, "virtualLabId", "0"));
			
			int studentCount = VirtualLabUserLocalServiceUtil.getStudentCount(virtualLabId, 0);
			if(studentCount > 0) {
				result = "500";	// 해당 가상실험실에 수강하는 학생이 존재하여 삭제 실패
			} else {
				VirtualLabLocalServiceUtil.updateVirtualLabDisable(virtualLabId, "N");
				result = "200";	// 삭제 성공
				
				Map<String, Object> paramMap = new HashMap<String, Object>();
				params.put("groupId", groupId);
				params.put("virtualLabId", ParamUtil.get(request, "virtualLabId", "0"));
				List<Map<String, Object>> virtualLabClassList = null;
				
				Role virtualLabOwner = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
				
				if (!(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)
						|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)
						|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)
						|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwner.getRoleId(), virtualLabId))) {
					params.put("userId", user.getUserId());
					params.put("virtualLabClassOwnerName", EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
					params.put("virtualLabClassManagerName", EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);
				}
				
				virtualLabClassList = VirtualLabClassLocalServiceUtil.getVirtualClassList(params, locale);
				
				for (Map<String, Object> resultMap : virtualLabClassList) {
					long classId = GetterUtil.get(resultMap.get("classId"), 0L);
					
					if(classId > 0) {
						VirtualLabClassLocalServiceUtil.updateVirtualLabClassDisable(classId, "N");
						
						// 게시판 파일 삭제
						List<Long> boardSeqList = VirtualLabClassLocalServiceUtil.getVirtualClassBoardSeqList(groupId, classId);
						if(boardSeqList != null && boardSeqList.size() > 0) {
							for (Long boardSeq : boardSeqList) {
								EdisonFileUtil.deleteGroupEdisonFile(groupId, "_" + classId + "_NOTICE", CustomUtil.strNull(boardSeq));
							}
						}
					}
				}
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
	
	@ResourceMapping(value="virtualLabUserInfo")
	public void getVirtualLabUserInfo(ResourceRequest request, ResourceResponse response) throws Exception {
		String virtualLabId = ParamUtil.get(request, "virtualLabId", "");
		String userScreenName = ParamUtil.get(request, "userScreenName", "");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		User user = null;
		user = UserLocalServiceUtil.fetchUserByScreenName(companyId, userScreenName);
		
		JSONObject obj = new JSONObject();
		Map<String, String> virtualLabUserInfo = null;
		if (user == null) {
			obj.put("result", "none");
		} else {
			Role ownerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);		// Owner Role Id 확인
			Role managerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);		// Manager Role Id 확인
			
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(checker);
			
			if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)
					|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)
					|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)) {
				obj.put("result", "admin");
			}else if (EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.TEMP_USER)) {	// Temp User 체크
				obj.put("result", "tempuser");
			}else if (UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, ownerRole.getRoleId(), Long.parseLong(virtualLabId))) {	// Owner 체크
				obj.put("result", "owner");
			} else {
				virtualLabUserInfo = new HashMap<String, String>();
				
				virtualLabUserInfo.put("virtualLabAuthId", virtualLabId);
				virtualLabUserInfo.put("userId", String.valueOf(user.getUserId()));
				virtualLabUserInfo.put("userScreenName", user.getScreenName());
				virtualLabUserInfo.put("userFullName", user.getFullName());
				virtualLabUserInfo.put("userFirstName", user.getFirstName());
				virtualLabUserInfo.put("userEmailAddress", user.getEmailAddress());
				virtualLabUserInfo.put("userJobTitle", user.getJobTitle());
				obj.put("virtualLabUserInfo", virtualLabUserInfo);
				obj.put("result", "user");
			}
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

}
