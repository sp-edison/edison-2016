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

<%@ include file="/html/portlet/login/init.jsp" %>

<%@page import="com.liferay.portal.RolePermissionsException" %>

<%@page import="com.liferay.portal.kernel.util.StringParser"%>
<%@page import="com.liferay.portal.kernel.bean.PortletBeanLocatorUtil" %>


<%
User user2 = (User)request.getAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_USER);

if (Validator.isNull(authType)) {
	authType = company.getAuthType();
}

Integer reminderAttempts = (Integer)portletSession.getAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS);

if (reminderAttempts == null) {
	reminderAttempts = 0;
}

String sendEmailMessage = LanguageUtil.get(themeDisplay.getLocale(),"send-email");
%>

<style type="text/css">
	.aui .control-group{
		margin-bottom: 0px;
	}
	
	.aui input[type="text"]{
		margin-bottom: 0px;
	}
	
	.aui .portlet-borderless-bar{
		display: none;
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
	
	.joinbox {
		width: 94%;
		border: solid 6px #e5e5e5;
		text-align: center;
		padding: 22px 30px;
		text-align: left;
	}
	
	.jointitle{
		background: url(/edison-2016-hook/images/termsofuse/member_icon.gif) 0px 8px no-repeat;
		font-size: 19px;
		color: #6e6e6e;
		font-weight: 600;
		padding-left: 25px;
		text-align: left;
		line-height: 30px;
		font-family: Arial, Nanum Barun Gothic,NanumGothic;
	}
	
	.edison .button08:hover{
		color: #fff;
		background: #606060;
		border: solid 1px #6a6a6b;
	}
</style>

<portlet:actionURL var="forgotPasswordURL">
	<portlet:param name="struts_action" value="/login/forgot_password" />
</portlet:actionURL>

<aui:form action="<%= forgotPasswordURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
<!-- 	해당 주석은 비밀번호 찾기 성공 후 parameter에 p_p_id=58이 들어가 있어서 로그인 후 메인 화면에 로그인 포틀릿 노출 -->
<!-- 	<portlet:renderURL var="redirectURL" /> -->
<%-- 	<aui:input name="redirect" type="hidden" value="<%= redirectURL %>" /> --%>

	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />

	<liferay-ui:error exception="<%= NoSuchUserException.class %>" message='<%= "the-user-id-you-requested-is-not-registered-in-our-database" %>' />
	<liferay-ui:error exception="<%= RequiredReminderQueryException.class %>" message="you-have-not-configured-a-reminder-query" />
	<liferay-ui:error exception="<%= SendPasswordException.class %>" message="your-password-can-only-be-sent-to-an-external-email-address" />
	<liferay-ui:error exception="<%= UserActiveException.class %>" message="your-account-is-not-active" />
	<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%= UserLockoutException.class %>" message="this-account-has-been-locked" />
	<liferay-ui:error exception="<%= UserReminderQueryException.class %>" message="your-answer-does-not-match-what-is-in-our-database" />
	<liferay-ui:error exception="<%= RolePermissionsException.class %>" message="you-cannot-use-the-permissions-of-this-role" />
	
	<aui:fieldset>
		<c:choose>
			<c:when test="<%= user2 == null %>">

				<%
				String loginParameter = null;
				String loginLabel = null;

				if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
					loginParameter = "emailAddress";
					loginLabel = "email-address";
				}
				else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
					loginParameter = "screenName";
					loginLabel = "screen-name";
				}
				else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
					loginParameter = "userId";
					loginLabel = "id";
				}

				String loginValue = ParamUtil.getString(request, loginParameter);
				%>

				<aui:input name="step" type="hidden" value="1" />
				<div class="logintitlebox">
						<div class="logintitle"><liferay-ui:message key="edison-forgot-password"/></div>
						<div class="loginintro"><liferay-ui:message key="edison-forgot-find-message"/></div>
				</div>
				<div class="h20"></div>
				<div style="clear:left;"></div>
				<div class="joinbox">
					<div class="jointitle"><liferay-ui:message key="edison-forgot-password"/></div>
					<div class="table3_list">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="18%" class="title2"><liferay-ui:message key="edison-id"/></td>
								<td width="*">
									<aui:input label="" name="<%= loginParameter %>" size="30" type="text" value="<%= loginValue %>">
										<aui:validator name="required" />
										<aui:validator name="maxLength">32</aui:validator>
										<aui:validator name="minLength">3</aui:validator>
									</aui:input>
								</td>
							</tr>
							<c:if test="<%= PropsValues.CAPTCHA_CHECK_PORTAL_SEND_PASSWORD %>">
								<tr>
									<td width="18%" class="title2"><liferay-ui:message key="edison-create-account-field-title-captcha" /></td>
									<td>
										<portlet:resourceURL var="captchaURL">
											<portlet:param name="struts_action" value="/login/captcha" />
										</portlet:resourceURL>
										
										<aui:column>
											<liferay-ui:captcha url="<%= captchaURL %>" />
										</aui:column>
									</td>
								</tr>
							</c:if>
						</table>
					</div>
					<div style="clear:left;"></div>
					<div class="buttonbox08">
						<aui:button type="submit" value="<%=sendEmailMessage%>" cssClass="button08"/>
						<input type="button" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-cancel" />" class="button08" onclick="cancle();">
					</div>
				</div>
			</c:when>
			<c:when test="<%= (user2 != null) && Validator.isNotNull(user2.getEmailAddress()) %>">
				<aui:input name="step" type="hidden" value="2" />
				<aui:input name="emailAddress" type="hidden" value="<%= user2.getEmailAddress() %>" />

				<c:if test="<%= Validator.isNotNull(user2.getReminderQueryQuestion()) && Validator.isNotNull(user2.getReminderQueryAnswer()) %>">

					<%
					String login = null;

					if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
						login = user2.getEmailAddress();
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
						login = user2.getScreenName();
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
						login = String.valueOf(user2.getUserId());
					}
					%>

					<div class="alert alert-info">
						<%= LanguageUtil.format(pageContext, "a-new-password-will-be-sent-to-x-if-you-can-correctly-answer-the-following-question", login) %>
					</div>

					<aui:input autoFocus="<%= true %>" label="<%= HtmlUtil.escape(LanguageUtil.get(pageContext, user2.getReminderQueryQuestion())) %>" name="answer" type="text" />
				</c:if>

				<c:choose>
					<c:when test="<%= PropsValues.USERS_REMINDER_QUERIES_REQUIRED && !user2.hasReminderQuery() %>">
						<div class="alert alert-info">
							<liferay-ui:message key="the-password-cannot-be-reset-because-you-have-not-configured-a-reminder-query" />
						</div>
					</c:when>
					<c:otherwise>
						<c:if test="<%= reminderAttempts >= 3 %>">
							<portlet:resourceURL var="captchaURL">
								<portlet:param name="struts_action" value="/login/captcha" />
							</portlet:resourceURL>

							<liferay-ui:captcha url="<%= captchaURL %>" />
						</c:if>

						<aui:button-row>
							<aui:button type="submit" value='<%= company.isSendPasswordResetLink() ? "send-password-reset-link" : "send-new-password" %>' />
						</aui:button-row>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<div class="alert alert-block">
					<liferay-ui:message key="the-system-cannot-send-you-a-new-password-because-you-have-not-provided-an-email-address" />
				</div>
			</c:otherwise>
		</c:choose>
	</aui:fieldset>
</aui:form>
<script type="text/javascript">
function cancle(){
	window.history.back();
}	
</script>
<!-- <liferay-util:include page="/html/portlet/login/navigation.jsp" /> -->