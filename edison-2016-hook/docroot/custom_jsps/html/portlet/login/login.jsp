<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="/html/portlet/login/init.jsp" %>
<%
	String loginMsg = LanguageUtil.get(themeDisplay.getLocale(),"Sign-in");
	String termsOfUseURL = themeDisplay.getURLHome()+"/-/termsofuse/view";
%>

<style type="text/css">
	.loginbox {
		margin: 0 auto;
		width: 99%;
		height:270px;
		border: solid 6px #e5e5e5;
		text-align: center;
		padding-top: 40px;
		padding-bottom: 25px;
		text-align: center;
	}
	
	.logintitlebox {
		margin: 0 auto;
		width: 100%;
	}
	
	.logintitle {
		font-size: 27px;
		color: #000;
		padding: 0px 20px 12px 0px;
		font-family: Arial, Nanum Barun Gothic,NanumGothic;
		float: left;
	}
	
	.loginintro {
		vertical-align: bottom;
		font-size: 13px;
		color: #777777;
		padding: 15px 0px 12px 0px;
		float: left;
	}
	
	.loginboxin {
		float: left;
		position: absolute;
		border: none;
	}
	
	.loginboxin ul {
		margin: 0 auto;
		padding: 0 0 5px 17px;
		width: 730px;
		float: left;
	}
	
	.loginboxin ul li {
		margin: 0 auto;
		float: left;
		position: relative;
	}
	
	.loginboxin label {
		font-weight: 600;
		font-size: 16px;
		color: #000;
		width: 90px;
		height: 45px;
		display: inline-block;
		padding-left: 290px;
		text-align: left;
		margin: 0px;
		cursor: default;
	}
	
	.buttonbox09 {
		padding-right: 310px;
		float: right;
	}
	
	.loginboxin01{
		float: left;
		width: 100%;
		height: 130px;
		border: none;
		padding-top: 145px;
	}
	
	
	.aui .control-group{
		display: inline-block;
	}
	
	.aui .portlet-borderless-bar{
		display: none;
	}
	
	.aui .control-group .help-inline{
		display: none;
	}

	.aui .control-group.error .help-inline{
		display: block;
		position: absolute;
		top: 15px;
	}
	
	.aui input[type="text"],
	.aui input[type="password"]{
		margin-bottom: 0px;
	}
	.edison .button07:hover{
		background: #5479c1;
		border: solid 1px #3860af;
		color: #fff;
	}
	
</style>


<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">

		<%
		String signedInAs = HtmlUtil.escape(user.getFullName());

		if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
			String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

			if (PropsValues.DOCKBAR_ADMINISTRATIVE_LINKS_SHOW_IN_POP_UP) {
				signedInAs = "<a class=\"signed-in\" href=\"javascript:Liferay.Util.openWindow({dialog: {destroyOnHide: true}, title: '" + HtmlUtil.escapeJS(LanguageUtil.get(pageContext, "my-account")) + "', uri: '" + HtmlUtil.escapeJS(myAccountURL) + "'});\">" + signedInAs + "</a>";
			}
			else {
				myAccountURL = HttpUtil.setParameter(myAccountURL, "controlPanelCategory", PortletCategoryKeys.MY);

				signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
			}
		}
		%>

		<%= LanguageUtil.format(pageContext, "you-are-signed-in-as-x", signedInAs, false) %>
	</c:when>
	<c:otherwise>

		<%
		String redirect = ParamUtil.getString(request, "redirect");

		String login = LoginUtil.getLogin(request, "login", company);
		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}
		%>

		<portlet:actionURL secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
			<portlet:param name="struts_action" value="/login/login" />
		</portlet:actionURL>
		
		<portlet:renderURL var="forgotIdURL">
			<portlet:param name="struts_action" value="/login/forgot_id" />
		</portlet:renderURL>
		
		<portlet:renderURL var="forgotPasswordURL">
			<portlet:param name="struts_action" value="/login/forgot_password" />
		</portlet:renderURL>
		

		<aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="sign-in-form" method="post" name="fm" onSubmit="event.preventDefault();">
			<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
			<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
			<aui:input name="doActionAfterLogin" type="hidden" value="<%= portletName.equals(PortletKeys.FAST_LOGIN) ? true : false %>" />

			<c:choose>
				<c:when test='<%= SessionMessages.contains(request, "userAdded") %>'>

					<%
					String userEmailAddress = (String)SessionMessages.get(request, "userAdded");
					String userPassword = (String)SessionMessages.get(request, "userAddedPassword");
					%>

					<div class="alert alert-success">
						<c:choose>
							<c:when test="<%= company.isStrangersVerify() || Validator.isNull(userPassword) %>">
								<%= LanguageUtil.get(pageContext, "thank-you-for-creating-an-account") %>

								<c:if test="<%= company.isStrangersVerify() %>">
									<%= LanguageUtil.format(pageContext, "your-email-verification-code-has-been-sent-to-x", userEmailAddress) %>
								</c:if>
							</c:when>
							<c:otherwise>
								<%= LanguageUtil.format(pageContext, "thank-you-for-creating-an-account.-your-password-is-x", userPassword, false) %>
							</c:otherwise>
						</c:choose>

						<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED) %>">
							<%= LanguageUtil.format(pageContext, "your-password-has-been-sent-to-x", userEmailAddress) %>
						</c:if>
					</div>
				</c:when>
				<c:when test='<%= SessionMessages.contains(request, "userPending") %>'>

					<%
					String userEmailAddress = (String)SessionMessages.get(request, "userPending");
					%>

					<div class="alert alert-success">
						<%= LanguageUtil.format(pageContext, "thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved", userEmailAddress) %>
					</div>
				</c:when>
				
				<c:when test='<%= SessionMessages.contains(renderRequest, "userEmailSender") %>'>
					<div class="alert alert-success">
						<liferay-ui:message key="your-request-completed-successfully" />
					</div>
				</c:when>
			</c:choose>
			
			<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
			<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-login-because-the-maximum-number-of-users-has-been-reached" />
			<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
			<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
			<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
			<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="authentication-failed" />
			<liferay-ui:error exception="<%= UserLockoutException.class %>" message="this-account-has-been-locked" />
			<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
			<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="authentication-failed" />

			<aui:fieldset>

				<%
				String loginLabel = null;

				if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
					loginLabel = "email-address";
				}
				else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
					//loginLabel = "screen-name";
					loginLabel = "";
				}
				else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
					loginLabel = "id";
				}
				%>
				
				<div class="logintitlebox">
					<div class="logintitle"><liferay-ui:message key="Sign-in"/></div>
					<div class="loginintro"><liferay-ui:message key="Sign-in-message"/></div>
				</div>
				<div class="h20"></div>
				
				<span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>
				
				<div class="loginbox">
					<div class="loginboxin">
						<ul>
							<li>
								<label><liferay-ui:message key="edison-id"/></label>
								<aui:input label="" size="37" cssClass="clearable" type="text" name="login" value="<%= login %>" style="background-color: transparent;padding-top: .7em;padding-bottom: .7em;width: 320px;font-size: 17px;" autoFocus="<%= windowState.equals(LiferayWindowState.EXCLUSIVE) || windowState.equals(WindowState.MAXIMIZED) %>" showRequiredLabel="<%= false %>" maxLength="32">
									<aui:validator name="required"/>
								</aui:input>
							</li>
							<li>
								<label><liferay-ui:message key="edison-password"/></label>
								<aui:input label="" size="37" cssClass="clearable" type="password" value="<%= password %>" style="background-color: transparent;padding-top: .7em;padding-bottom: .7em;width: 320px;font-size: 17px;" name="password" showRequiredLabel="<%= false %>">
									<aui:validator name="required"/>
								</aui:input>
							</li>
						</ul>
						<div class="buttonbox09">
							<aui:button type="submit" value="<%=loginMsg%>" cssClass="button07"/>
						</div>
					</div>
					
					<div class="loginboxin01">
						<table class="table7" width="935">
							<tbody>
								<tr>
									<td colspan="8" class="loginline"></td>
								</tr>
								<tr>
									<td class="loginimg"><img src="/edison-2016-hook/images/login/join_findicon.png" width="81" height="80"></td>
									<td width="150"><a href="<%=forgotIdURL%>&saveLastPath=false" target="_self"><liferay-ui:message key="forgot-id"/></a></td>
									<td class="loginlinevt"></td>
									<td class="loginimg"><img src="/edison-2016-hook/images/login/join_findicon.png" width="81" height="80"></td>
									<td width="150"><a href="<%=forgotPasswordURL%>&saveLastPath=false" target="_self"><liferay-ui:message key="edison-forgot-password"/></a></td>
									<td class="loginlinevt"></td>
									<td class="loginimg"><img src="/edison-2016-hook/images/login/join_icon.png" width="81" height="80"></td>
									<td>
										<a href="<%=termsOfUseURL%>" target="_self">
											<liferay-ui:message key="Register-edison"/>
										</a>
										
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</aui:fieldset>
		</aui:form>
		
		<aui:script use="aui-base">
			A.all('.clearable').on('focus',function(event){
				var currentTargetNode = event.currentTarget;
				var parentNode = currentTargetNode.get('parentNode');
				if(parentNode.hasClass('error')){
					parentNode.removeClass('error');
				}
			});
			
			var form = A.one(document.<portlet:namespace />fm);

			form.on(
				'submit',
				function(event) {
					var redirect = form.one('#<portlet:namespace />redirect');

					if (redirect) {
						var redirectVal = redirect.val();

						redirect.val(redirectVal + window.location.hash);
					}

					submitForm(form);
				}
			);

			var password = form.one('#<portlet:namespace />password');

			if (password) {
				password.on(
					'keypress',
					function(event) {
						Liferay.Util.showCapsLock(event, '<portlet:namespace />passwordCapsLockSpan');
					}
				);
			}
		</aui:script>
	</c:otherwise>
</c:choose>