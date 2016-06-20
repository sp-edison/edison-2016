package org.kisti.edison.portlet.myaccount.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.util.EdisonUserUtil;

import com.liferay.portal.RolePermissionsException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.PasswordTrackerLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class HookEditUserAction extends BaseStrutsPortletAction{
	
	private static Log _log = LogFactoryUtil.getLog(HookEditUserAction.class);
	
	@Override
	public void processAction(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		if (redirectToLogin(actionRequest, actionResponse)) {
			return;
		}
		
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		/**
		 * GPLUS
		 * My Account -> member_Leave
		 */
		if(cmd.equals(Constants.DEACTIVATE)){
			Company company = PortalUtil.getCompany(actionRequest);
			String authType = company.getAuthType();
			
			User user = PortalUtil.getSelectedUser(actionRequest);
			String login = null;
			
			if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
				login = user.getEmailAddress();
			}else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
				login = String.valueOf(user.getUserId());
			}else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
				login = user.getScreenName();
			}
			
			String currentPassword = ParamUtil.getString(actionRequest,"current-password");
			
			boolean validPassword = PasswordTrackerLocalServiceUtil.isSameAsCurrentPassword(user.getUserId(), currentPassword);

			
			try{
				if (!validPassword) {
					Exception e = new UserPasswordException(10);
					SessionErrors.add(actionRequest, e.getClass(), e);
				}else{
					if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)){
						Exception e = new RolePermissionsException();
						SessionErrors.add(actionRequest, e.getClass(), e);
					}else{
						UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_INACTIVE);
						
						ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
						String redirect = "";
						String closeRedirect = themeDisplay.getURLSignOut();
						
						redirect = HttpUtil.addParameter(redirect, 
								actionResponse.getNamespace() + "closeRedirect",closeRedirect);
						
						sendRedirect(
								portletConfig, actionRequest, actionResponse, redirect,
								closeRedirect);
						
					}
				}
				
			}catch(Exception e){
				if (e instanceof UserPasswordException){
					SessionErrors.add(actionRequest, e.getClass(), e);
				}else if(e instanceof RolePermissionsException){
					SessionErrors.add(actionRequest, e.getClass());
				}else{
					PortalUtil.sendError(e, actionRequest, actionResponse);
				}
			}
			
			
		}else{
			originalStrutsPortletAction.processAction(portletConfig, actionRequest, actionResponse);
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
	
	protected boolean redirectToLogin(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException {

		if (actionRequest.getRemoteUser() == null) {
			HttpServletRequest request = PortalUtil.getHttpServletRequest(
				actionRequest);

			SessionErrors.add(request, PrincipalException.class.getName());

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			actionResponse.sendRedirect(themeDisplay.getURLSignIn());

			return true;
		}
		else {
			return false;
		}
	}
	
	protected void sendRedirect(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse, String redirect,
			String closeRedirect)
		throws IOException, SystemException {

		if (isDisplaySuccessMessage(actionRequest)) {
			addSuccessMessage(actionRequest, actionResponse);
		}

		if (Validator.isNull(redirect)) {
			redirect = (String)actionRequest.getAttribute(WebKeys.REDIRECT);
		}

		if (Validator.isNull(redirect)) {
			redirect = ParamUtil.getString(actionRequest, "redirect");
		}

		if ((portletConfig != null) && Validator.isNotNull(redirect) &&
			Validator.isNotNull(closeRedirect)) {

			redirect = HttpUtil.setParameter(
				redirect, "closeRedirect", closeRedirect);

			SessionMessages.add(
				actionRequest,
				PortalUtil.getPortletId(actionRequest) +
					SessionMessages.KEY_SUFFIX_CLOSE_REDIRECT,
				closeRedirect);
		}

		if (Validator.isNull(redirect)) {
			return;
		}

		// LPS-1928

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		if (BrowserSnifferUtil.isIe(request) &&
			(BrowserSnifferUtil.getMajorVersion(request) == 6.0) &&
			redirect.contains(StringPool.POUND)) {

			String redirectToken = "&#";

			if (!redirect.contains(StringPool.QUESTION)) {
				redirectToken = StringPool.QUESTION + redirectToken;
			}

			redirect = StringUtil.replace(
				redirect, StringPool.POUND, redirectToken);
		}

		redirect = PortalUtil.escapeRedirect(redirect);

		if (Validator.isNotNull(redirect)) {
			actionResponse.sendRedirect(redirect);
		}
	}
	
	protected boolean isDisplaySuccessMessage(PortletRequest portletRequest)
		throws SystemException {

		if (!SessionErrors.isEmpty(portletRequest)) {
			return false;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		if (layout.isTypeControlPanel()) {
			return true;
		}

		String portletId = (String)portletRequest.getAttribute(
			WebKeys.PORTLET_ID);

		try {
			LayoutTypePortlet layoutTypePortlet =
				themeDisplay.getLayoutTypePortlet();

			if (layoutTypePortlet.hasPortletId(portletId)) {
				return true;
			}
		}
		catch (PortalException pe) {
			if (_log.isDebugEnabled()) {
				_log.debug(pe, pe);
			}
		}

		Portlet portlet = PortletLocalServiceUtil.getPortletById(
			themeDisplay.getCompanyId(), portletId);

		if (portlet.isAddDefaultResource()) {
			return true;
		}

		return false;
	}
	
	protected void addSuccessMessage(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(
			JavaConstants.JAVAX_PORTLET_CONFIG);

		boolean addProcessActionSuccessMessage = GetterUtil.getBoolean(
			portletConfig.getInitParameter("add-process-action-success-action"),
			true);

		if (!addProcessActionSuccessMessage) {
			return;
		}

		String successMessage = ParamUtil.getString(
			actionRequest, "successMessage");

		SessionMessages.add(actionRequest, "requestProcessed", successMessage);
	}
	
}
