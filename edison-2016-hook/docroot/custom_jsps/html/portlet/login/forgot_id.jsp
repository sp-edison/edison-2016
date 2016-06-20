<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/login/init.jsp" %>

<%@page import="com.liferay.portal.RolePermissionsException" %>
<%@page import="com.liferay.portal.AccountNameException" %>

<%
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
<portlet:actionURL var="findIdURL">
	<portlet:param name="struts_action" value="/login/find_id" />
</portlet:actionURL>

<aui:form action="<%= findIdURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
	<!-- 	해당 주석은 아이디 찾기 성공 후 parameter에 p_p_id=58이 들어가 있어서 로그인 후 메인 화면에 로그인 포틀릿 노출 -->
<!-- 	<portlet:renderURL var="redirectURL" /> -->
<%-- 	<aui:input name="redirect" type="hidden" value="<%= redirectURL %>" /> --%>
	
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
	
	<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="the-email-address-you-requested-is-not-registered-in-our-database"/>
	<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%= UserActiveException.class %>" message="your-account-is-not-active" />
	<liferay-ui:error exception="<%= UserLockoutException.class %>" message="this-account-has-been-locked" />
	<liferay-ui:error exception="<%= AccountNameException.class %>" message="the-name-you-requested-is-not-registered-in-our-database" />
	<liferay-ui:error exception="<%= RolePermissionsException.class %>" message="you-cannot-use-the-permissions-of-this-role" />
	
	
	<div class="logintitlebox">
			<div class="logintitle"><liferay-ui:message key="forgot-id"/></div>
			<div class="loginintro"><liferay-ui:message key="edison-forgot-find-message"/></div>
	</div>
	<div class="h20"></div>
	<div style="clear:left;"></div>
	<div class="joinbox">
		<div class="jointitle"><liferay-ui:message key="forgot-id"/></div>
		<div class="table3_list">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td width="18%" class="title2"><liferay-ui:message key="edison-create-account-field-title-email" /></td>
						<td width="*">
							<aui:input label="" name="emailAddress" size="50" type="text" value="">
								<aui:validator name="required"/>
								<aui:validator name="email" />
							</aui:input>
						</td>
					</tr>
					<tr>
						<td width="18%" class="title2"><liferay-ui:message key="edison-create-account-field-title-name" /></td>
						<td width="*">
							<aui:input label="" name="firstName" size="40" type="text" value="">
								<aui:validator name="required"/>
								<aui:validator name="maxLength">32</aui:validator>
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
				</tbody>
			</table>
		</div>
		<div style="clear:left;"></div>
		<div class="buttonbox08">
			<aui:button type="submit" value="<%=sendEmailMessage%>" cssClass="button08"/>
			<input type="button" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-cancel" />" class="button08" onclick="cancle();">
		</div>
	</div>
				
</aui:form>
<script type="text/javascript">
function cancle(){
	window.history.back();
}	
</script>
<!-- <liferay-util:include page="/html/portlet/login/navigation.jsp" /> -->