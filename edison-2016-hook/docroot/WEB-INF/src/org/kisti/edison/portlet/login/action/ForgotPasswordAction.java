package org.kisti.edison.portlet.login.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.EdisonUserUtil;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.RolePermissionsException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ForgotPasswordAction extends BaseStrutsPortletAction{
	
	
	@Override
	public void processAction(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		try {
			checkTempUser(actionRequest);
			originalStrutsPortletAction.processAction(portletConfig, actionRequest, actionResponse);
			
			
			String redirect = ParamUtil.getString(actionRequest, "redirect");
			if (Validator.isNotNull(redirect)) {
				actionResponse.sendRedirect(redirect);
			}
		}catch (Exception e) {
			 if(e instanceof NoSuchUserException ||
				e instanceof RolePermissionsException){
				SessionErrors.add(actionRequest, e.getClass());
			}else {
				PortalUtil.sendError(e, actionRequest, actionResponse);
			}
		}
	}
	
	protected void checkTempUser(ActionRequest actionRequest) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String screenName = ParamUtil.getString(actionRequest, "screenName").trim();
		User user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), screenName);
		
		/**
		 * Temp User 일 경우 Password 찾기 기능을 이용 못하도록 수정
		 */
		PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(checker);
		if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.TEMP_USER)){
			throw new RolePermissionsException();
		}
	}
	
	
	@Override
	public String render(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {
		return originalStrutsPortletAction.render(portletConfig, renderRequest, renderResponse);
	}

}
