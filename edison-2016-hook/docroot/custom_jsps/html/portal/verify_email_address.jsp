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

<%@ include file="/html/portal/init.jsp" %>

<%
String referer = ParamUtil.getString(request, WebKeys.REFERER, themeDisplay.getPathMain());

if (referer.equals(themeDisplay.getPathMain() + "/portal/update_email_address")) {
	referer = themeDisplay.getPathMain() + "?doAsUserId=" + themeDisplay.getDoAsUserId();
}

PasswordPolicy passwordPolicy = user.getPasswordPolicy();

String ticketKey = ParamUtil.getString(request, "ticketKey");
%>
<style type="text/css">
	.aui .portlet-topper{
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
	
	.edison .button08:hover{
		color: #fff;
		background: #606060;
		border: solid 1px #6a6a6b;
	}
	
	.borderline{
		height: 1px;
		border-bottom: 1px solid #e6e6e6;
	}
</style>

<c:if test="<%= !SessionErrors.isEmpty(request) %>">
	<c:choose>
		<c:when test='<%=SessionMessages.contains(request, "user_verified_send")%>'>
			<div class="portlet-msg-success">
				<liferay-ui:message key="edison-user-verified-success" />
			</div>
		</c:when>
		<c:when test="<%= SessionErrors.contains(request, DuplicateUserEmailAddressException.class.getName()) %>">
			<div class="alert alert-error">
				<liferay-ui:message key="the-email-address-you-requested-is-already-taken" />
			</div>
		</c:when>
		<c:when test="<%= SessionErrors.contains(request, ReservedUserEmailAddressException.class.getName()) %>">
			<div class="alert alert-error">
				<liferay-ui:message key="the-email-address-you-requested-is-reserved" />
			</div>
		</c:when>
		<c:when test="<%= SessionErrors.contains(request, UserEmailAddressException.class.getName()) %>">
			<div class="alert alert-error">
				<liferay-ui:message key="please-enter-a-valid-email-address" />
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-error">
				<liferay-ui:message key="please-enter-a-valid-verification-code" />
			</div>
		</c:otherwise>
	</c:choose>
</c:if>

<div class="logintitlebox">
	<div class="logintitle"><liferay-ui:message key="edison-user-verified"/></div>
	<div class="loginintro"><liferay-ui:message key="please-enter-your-verification-code" /></div>
</div>


<aui:form action='<%= themeDisplay.getPathMain() + "/portal/verify_email_address" %>' method="post" name="fm">
	<aui:input name="p_l_id" type="hidden" value="<%= layout.getPlid() %>" />
	<aui:input name="p_auth" type="hidden" value="<%= AuthTokenUtil.getToken(request) %>" />
	<aui:input name="doAsUserId" type="hidden" value="<%= themeDisplay.getDoAsUserId() %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="<%= WebKeys.REFERER %>" type="hidden" value="<%= referer %>" />
	
	<div class="h20"></div>
	<div style="clear:left;"></div>
	<div class="joinbox">
		<aui:input autoFocus="<%= true %>" class="lfr-input-text-container" label="email-verification-code" name="ticketKey" size="36" type="text" value="<%= ticketKey %>" />
		<div style="clear:left;"></div>
		<div class="h20"></div>
		<div class="borderline"></div>
		<div class="h10"></div>
		<div class="buttonbox08">
			<aui:button type="submit" value="verify" cssClass="button08"/>
	
			<c:if test="<%= themeDisplay.isSignedIn() && !user.isEmailAddressVerified() %>">
				<aui:button href='<%= PropsUtil.get(PropsKeys.COMPANY_DEFAULT_HOME_URL) + "?struts_action=/portal/verify_email_address&cmd=" + Constants.SEND + "&referer=" + HttpUtil.encodeURL(referer) %>' value="send-new-verification-code" type="button" cssClass="button08" style="text-shadow: none;"/>
	<%-- 		<aui:button href='<%= themeDisplay.getPathMain() + "/portal/update_email_address?referer=" + HttpUtil.encodeURL(referer) %>' value="change-email-address" /> --%>
			</c:if>
		</div>
	</div>
</aui:form>
