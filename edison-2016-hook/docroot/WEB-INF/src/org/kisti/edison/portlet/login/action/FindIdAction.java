package org.kisti.edison.portlet.login.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kisti.edison.model.EdisonPropskeys;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.EdisonUserUtil;

import com.liferay.portal.AccountNameException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.RolePermissionsException;
import com.liferay.portal.UserActiveException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserLockoutException;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;

public class FindIdAction extends BaseStrutsPortletAction{
	
	private static Log _log = LogFactory.getLog(FindIdAction.class);
	
	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		
		Company company = themeDisplay.getCompany();
		
		
		try {
			checkCaptcha(actionRequest);
			
			
			sendId(actionRequest,actionResponse);
		}catch (Exception e) {
			if (e instanceof CaptchaTextException ||
				e instanceof UserEmailAddressException){
				
				SessionErrors.add(actionRequest, e.getClass());
				
			}else if(e instanceof NoSuchUserException ||
					 e instanceof UserActiveException ||
					 e instanceof UserLockoutException ||
					 e instanceof AccountNameException||
					 e instanceof RolePermissionsException){
				
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				
				SessionErrors.add(actionRequest, e.getClass());
			}else {
				PortalUtil.sendError(e, actionRequest, actionResponse);
			}
		}
	}
	
	@Override
	public String render(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {
			String returnJSP = "";
			if(!SessionErrors.isEmpty(renderRequest)){
				returnJSP = "/portlet/login/forgot_id.jsp";
			}else{
				SessionMessages.add(renderRequest, "userEmailSender");
				returnJSP = "/portlet/login/login.jsp";
			}
			
		return returnJSP;
	}
	
	protected void checkCaptcha(ActionRequest actionRequest)
		throws CaptchaException {
		CaptchaUtil.check(actionRequest);
	}
	
	protected void sendId(
			ActionRequest actionRequest, ActionResponse actionResponse)throws Exception{
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		
		User user = getUser(actionRequest);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		
		long companyId = themeDisplay.getCompanyId();
		String fromName = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
		
		String subject = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_FORGOT_ID_SUBJECT);
		String body = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_FORGOT_ID_BODY);
		
		String toName = user.getFullName();
		String toAddress = user.getEmailAddress();
		String toId = user.getScreenName();
		
		Role role = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
		List<com.liferay.portal.model.User> userList = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
		User adminUser = userList.get(0);
		SubscriptionSender subscriptionSender = new SubscriptionSender();
		subscriptionSender.setBody(body);
		subscriptionSender.setCompanyId(companyId);
		subscriptionSender.setContextAttributes(
			"[$USER_ADDR$]", toAddress,
			"[$USER_NAME$]", toName,
			"[$USER_ID$]", toId,
			"[$REMOTE_HOST$]", serviceContext.getRemoteHost()
		);
		
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setMailId("user", adminUser.getUserId());
		subscriptionSender.setServiceContext(serviceContext);
		subscriptionSender.setSubject(subject);
		subscriptionSender.setUserId(adminUser.getUserId());
		subscriptionSender.addRuntimeSubscribers(toAddress,toName);

		subscriptionSender.flushNotificationsAsync();
		
		sendRedirect(actionRequest, actionResponse);
	}
	
	protected User getUser(ActionRequest actionRequest) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		
		long userId = ParamUtil.getLong(actionRequest, "userId");
		
		String firstName = ParamUtil.getString(actionRequest, "firstName").trim();
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		
		User user = null;
		
		if (Validator.isNotNull(emailAddress)) {
			user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), emailAddress);
			
			if(!user.getFirstName().trim().equals(firstName)){
				throw new AccountNameException();
			}
		}else{
			throw new NoSuchUserException();
		}
		
		if (!user.isActive()) {
			throw new UserActiveException();
		}
		
		UserLocalServiceUtil.checkLockout(user);
		
		
		/**
		 * Temp User 일 경우 ID 찾기 기능을 이용 못하도록 수정
		 */
		PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(checker);
		if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.TEMP_USER)){
			throw new RolePermissionsException();
		}
		
		return user;
	}
	
	protected void sendRedirect(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, SystemException {

		sendRedirect(actionRequest, actionResponse, null);
	}
	
	protected void sendRedirect(
			ActionRequest actionRequest, ActionResponse actionResponse,
			String redirect)
		throws IOException, SystemException {

		sendRedirect(null, actionRequest, actionResponse, redirect, null);
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
