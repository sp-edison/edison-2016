package org.kisti.edison.virtuallaboratory.portlet.virtualLabClassRegistrationList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.EdisonUserUtil;
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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class VirtualLabClassRegistrationListController {
	private static Log log = LogFactoryUtil.getLog(VirtualLabClassRegistrationListController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = PortalUtil.getScopeGroupId(request);
			
			Group group = GroupLocalServiceUtil.getGroup(groupId);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "virtualLabClassRegistrationList/virtualLabClassRegistrationList";
	}
	
	@ResourceMapping(value="classRegistrationList")
	public void getClassRegistrationList(ResourceRequest request, ResourceResponse response) throws Exception {
		User user = PortalUtil.getUser(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();
		List<Map<String, Object>> virtualLabClassRegisterList;
		
		// 포털 체크 parentGroupId가 0이면 포털 아니면 분야별 사이트
		if(parentGroupId == 0) {
			virtualLabClassRegisterList = VirtualLabLocalServiceUtil.getVirtualLabClassRegisterList(0, user.getUserId(), locale);
		} else {
			virtualLabClassRegisterList = VirtualLabLocalServiceUtil.getVirtualLabClassRegisterList(groupId, user.getUserId(), locale);
		}
		
		JSONObject obj = new JSONObject();
		obj.put("virtualLabClassRegisterList", virtualLabClassRegisterList);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ResourceMapping(value="virtualLabClassRegisterCheck")
	public void registerCheck(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		User user = PortalUtil.getUser(request);
		long userId = PortalUtil.getUserId(request);
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
		long classId = ParamUtil.get(request, "classId", 0);
		long groupId = ParamUtil.get(request, "groupId", PortalUtil.getScopeGroupId(request));
		long companyId = PortalUtil.getCompanyId(request);
		
		long classPlid = PortalUtil.getPlidFromPortletId(groupId, "edisonvirtuallabclassmainvisual_WAR_edisonvirtuallab2016portlet");
		PortletURL classURL = PortletURLFactoryUtil.create(request, "edisonvirtuallabclassmainvisual_WAR_edisonvirtuallab2016portlet", classPlid, PortletRequest.RENDER_PHASE);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		Role virtualLabOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
		Role virtualClassOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
		Role virtualClassManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);

		
		JSONObject obj = new JSONObject();

		obj.put("classPlid", classPlid);
		
		if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) ||	// 포털 Admin Check
			EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR) ||	// 사이트 Admin Check
			EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER) ||	// 사이트 Owner Check
			(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(userId, groupId, virtualLabOwnerRole.getRoleId(), virtualLabId) ||
			UserGroupRoleCustomLocalServiceUtil.isRoleCustom(userId, groupId, virtualClassOwnerRole.getRoleId(), classId) || 
			UserGroupRoleCustomLocalServiceUtil.isRoleCustom(userId, groupId, virtualClassManagerRole.getRoleId(), classId))) {	// Custom Role Check
			obj.put("result", "ADMINISTRATOR");
		} else {
			Map<String, Object> virtualLabClassUserInfo = VirtualLabLocalServiceUtil.getVirtualLabClassRegisterInfo(classId, userId, groupId, locale);
			Object[] userCountArray = VirtualLabUserLocalServiceUtil.getCountVirtualClassRegisterUserList(classId);
			virtualLabClassUserInfo.put("totalUserCount", (Integer)userCountArray[0] + (Integer)userCountArray[1]);	// 현재 클래스 수강 인원
			
			obj.put("virtualLabClassUserInfo", virtualLabClassUserInfo);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ActionMapping(params = "myaction=registerRequest")
	public void registerRequest(ActionRequest request, ActionResponse response) {
		try {
			long userId = PortalUtil.getUserId(request);
			long virtualUserId = Long.parseLong(ParamUtil.get(request, "registerVirtualUserId", "0"));
			long classId = Long.parseLong(ParamUtil.get(request, "registerClassRequestNo", "0"));
			if (classId != 0 || userId != 0 ) {
				if (virtualUserId > 0) {
					VirtualLabUserLocalServiceUtil.removeVirtualLabUser(classId, virtualUserId);
					SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
				}else {
					VirtualLabUserLocalServiceUtil.addVirtualLabUser(classId, userId);
					SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
				}
			}
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
		}
	}
}
