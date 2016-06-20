package org.kisti.edison.virtuallaboratory.portlet.virtualLabManagerManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
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
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class VirtualLabManagerManagementController {
	private static Log log = LogFactoryUtil.getLog(VirtualLabManagerManagementController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model) throws PortalException, SystemException {
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
		httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
		long virtualLabId = 0;
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		User user = PortalUtil.getUser(request);
		Role virtualLabOwner = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
		
		Map<String, Object> params = RequestUtil.getParameterMap(httpRequest);
		for (Map.Entry<String,Object> str : params.entrySet()) {
			if(str.getKey().contains("virtualLabId")) {
				virtualLabId = GetterUtil.get(str.getValue(), 0L);
				model.addAttribute("virtualLabId", virtualLabId);
			}
		}
		
		if(virtualLabId <= 0) {
			return "virtualLabManagerManagement/virtualLabManagerNonePage";
		}
		
		if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)	// PORTAL ADMINISTRATOR 체크
			|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)	// SITE ADMINSTRATOR	체크
			|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)	// SITE OWNER 체크
			|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwner.getRoleId(), virtualLabId)) // VIRTUAL LAB OWNER CHECK
		{
			return "virtualLabManagerManagement/virtualLabManagerList";
		} else {
			return "virtualLabManagerManagement/virtualLabManagerNonePage";
		}
	}
	
	@ResourceMapping(value="virtualLabManagerList")
	public void getVirtualLabManagerList(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		String virtualLabId = ParamUtil.get(request, "virtualLabId", "");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		Role role = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);		// Role Id 확인
		
		JSONObject obj = new JSONObject();
		if (virtualLabId != null && virtualLabId.length() > 0) {
			
			List<Map<String, String>> virtualLabManagerList = UserGroupRoleCustomLocalServiceUtil.getUserList(groupId, role.getRoleId(), Long.parseLong(virtualLabId));
			if (virtualLabManagerList == null) {
				virtualLabManagerList = new ArrayList<Map<String, String>>();
			}
			obj.put("virtualLabId", virtualLabId);
			obj.put("virtualLabManagerList", virtualLabManagerList);
		}
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
			} else if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, managerRole.getRoleId(), Long.parseLong(virtualLabId))) {	// Manager 체크
				obj.put("result", "manager");
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

	@ActionMapping(params = "myaction=virtualLabManagerAdd")
	public void insertVirtualLabManager(ActionRequest request, ActionResponse response, ModelMap model) {
		try {
			String userId = ParamUtil.get(request, "managerUserId", "0");
			String virtualLabId = ParamUtil.get(request, "virtualLabId", "");
	
			long groupId;
			groupId = PortalUtil.getScopeGroupId(request);
			long companyId = PortalUtil.getCompanyId(request);
			
			User requestUser = UserLocalServiceUtil.fetchUser(Long.parseLong(userId));
			
			Role role = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);		// Role Id 확인
			
			EdisonUserUtil.addSiteRole(requestUser, groupId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);	// VIRTUAL LAB MANAGER 권한 추가
			UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(Long.parseLong(userId), groupId, role.getRoleId(), Long.parseLong(virtualLabId));	// VIRTUAL LAB MANAGER CUSTOM ROLE 추가
			
			SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);

			response.setRenderParameter("virtualLabId", virtualLabId);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
		}
	}
	
	@ResourceMapping(value="deleteVirtualLabAuth")
	public void deleteVirtualLabAuth(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		String virtualLabId = ParamUtil.get(request, "virtualLabAuthId", "0");
		String virtualLabManagerId = ParamUtil.get(request, "virtualLabManagerId", "0");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		Role role = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);		// Role Id 확인
		
		UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(Long.parseLong(virtualLabManagerId), groupId, role.getRoleId(), Long.parseLong(virtualLabId));
		
		List<Map<String,String>> customList =  UserGroupRoleCustomLocalServiceUtil.getCustomList(Long.parseLong(virtualLabManagerId), groupId, role.getRoleId());
		
		if (customList == null || customList.size() == 0) {	// VIRTUAL LAB MANAGER CUSTOM ROLE이 남아있는지 체크
			EdisonUserUtil.deleteSiteRole(UserLocalServiceUtil.getUser(Long.parseLong(virtualLabManagerId)), groupId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);	// 없으면 삭제
		}
		
		JSONObject obj = new JSONObject();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
}
