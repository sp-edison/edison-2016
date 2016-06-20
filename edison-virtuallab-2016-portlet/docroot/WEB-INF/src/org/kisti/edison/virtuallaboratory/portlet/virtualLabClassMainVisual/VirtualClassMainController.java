package org.kisti.edison.virtuallaboratory.portlet.virtualLabClassMainVisual;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUser;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabUserLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

@Controller
@RequestMapping("VIEW")
public class VirtualClassMainController {
	private static Log log = LogFactoryUtil.getLog(VirtualClassMainController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
			String classId = httpRequest.getParameter("classId");
			User user = PortalUtil.getUser(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long companyId = PortalUtil.getCompanyId(request);
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Map<String, Object> params = RequestUtil.getParameterMap(httpRequest);
			
//			if(EdisonUserUtil.isRegularRole(user, RoleConstants.TEMP_USER)) {
//				classId = (String) user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
//			} else {
				for (Map.Entry<String,Object> str : params.entrySet()) {
					if(str.getKey().contains("classId")) {
						classId =  (String) str.getValue();
					}
				}
//			}
			
			long classId_ = GetterUtil.get(classId, 0L);
			
			Locale locale = themeDisplay.getLocale();
			
			Map<String, String> classInfo = null;
			
			if(classId_ > 0L) {
				classInfo = VirtualLabClassLocalServiceUtil.getVirtualClassMainVisual(classId_, locale);
			} else {
				// classId가 잘못된 값이 들어왔을때 가상실험실 목록 화면으로 이동
				if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)) {
					model.addAttribute("backURL", themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + group.getFriendlyURL() + "/virtual-lab");
				} else {
					model.addAttribute("backURL", themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + group.getFriendlyURL() + "/home");
				}
				return "virtualLabClassMainVisual/virtualClass_Exception";
			}
			
			if (classInfo == null || classInfo.size() == 0) {
				// 클래스 정보가 없을때 가상실험실 목록 화면으로 이동
				if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)) {
					model.addAttribute("backURL", themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + group.getFriendlyURL() + "/virtual-lab");
				} else {
					model.addAttribute("backURL", themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + group.getFriendlyURL() + "/home");
				}
				return "virtualLabClassMainVisual/virtualClass_Exception";
			}
			
			Role virtualLabOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
			Role virtualLabClassOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
			Role virtualLabClassManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);
			
			// 관리자 권한 확인
			if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) ||	// 포털 Admin Check
					EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR) ||	// 사이트 Admin Check
					EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER) ||	// 사이트 Owner Check
					UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwnerRole.getRoleId(), Long.parseLong(CustomUtil.strNull(classInfo.get("virtualLabId"))))	|| //
					UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabClassOwnerRole.getRoleId(), Long.parseLong(CustomUtil.strNull(classInfo.get("classId"))))	||
					UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabClassManagerRole.getRoleId(), Long.parseLong(CustomUtil.strNull(classInfo.get("classId"))))) {
				model.addAttribute("role", "ADMIN");
				model.addAttribute("classInfo", classInfo);
				model.addAttribute("classlistPlid", PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonvirtuallabclassmanagementlist_WAR_edisonvirtuallab2016portlet"));
				return "virtualLabClassMainVisual/virtualClassMainVisual";
			}
			
			// 클래스 멤버 확인
			VirtualLabUser virtualLabUser = VirtualLabUserLocalServiceUtil.getVirtualLabUserInfo(classId_, user.getUserId());
			if(virtualLabUser != null) {
				String requestSort = virtualLabUser.getRequestSort();
				if (requestSort.equals("CONFIRM") || requestSort.equals("TEMP")) {
					model.addAttribute("role", requestSort);
					model.addAttribute("classInfo", classInfo);
					return "virtualLabClassMainVisual/virtualClassMainVisual";
				}
			}
			
			model.addAttribute("backURL", themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + group.getFriendlyURL() + "/home");
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "virtualLabClassMainVisual/virtualClass_Exception";
	}
	
	/**
	 * 학생 비밀번호 수정
	 **/
	@ResourceMapping(value ="studentPasswordUpdate" )
	public void studentPasswordUpdate(ResourceRequest request, ResourceResponse response) throws Exception{
		
		String resultCode = "200";
		Map params = RequestUtil.getParameterMap(request);	
		User user = PortalUtil.getUser(request);
		long companyId = PortalUtil.getCompanyId(request);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		String currentPassword = GetterUtil.get(params.get("currentPassword"),"");
		String newPassword = GetterUtil.get(params.get("newPassword"),"");
		String reNewPassword = GetterUtil.get(params.get("reNewPassword"),"");
		
		int oldPwdAuth = 0;
		oldPwdAuth = UserLocalServiceUtil.authenticateByScreenName(companyId, user.getScreenName(), currentPassword, null, null, null);
		
		try{
			if(oldPwdAuth == 1) {
				UserServiceUtil.updatePassword(user.getUserId(), newPassword, reNewPassword, false);
			} else {
				resultCode = "300";
			}
		}catch (NullPointerException ne) {
			resultCode = "400";
		}catch (Exception e) {
			resultCode = "900";
		}		
		writer.write(resultCode);
	}
	
}
