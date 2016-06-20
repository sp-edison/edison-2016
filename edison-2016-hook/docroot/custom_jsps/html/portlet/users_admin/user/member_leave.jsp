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

<%@ include file="/html/portlet/users_admin/init.jsp" %>
<%@page import="com.liferay.portal.RolePermissionsException" %>
<%@page import="com.liferay.portal.UserPasswordException" %>

<style type="text/css">
.yellowbtn{
	padding: 5px 20px 8px 20px;
	background: #ffc75d;
	border-radius: 3px;
	-webkit-border-radius: 3px;
	border: solid 1px #ccc;
	color: #FF0000;
	font-weight: 600;
	font-size: 15px;
}
</style>
<liferay-ui:error-marker key="errorSection" value="memberLeave" />

<h3><liferay-ui:message key="edison-leave" /></h3>

<liferay-ui:error exception="<%= RolePermissionsException.class %>" message="you-cannot-use-the-permissions-of-this-role" />

<liferay-ui:error exception="<%=UserPasswordException.class%>">
	<%
	UserPasswordException upe = (UserPasswordException)errorException;
	%>
	<c:if test="<%=upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH%>">
		<liferay-ui:message key="that-password-is-invalid-please-enter-in-a-different-password" />
	</c:if>
</liferay-ui:error>
<%
	String message = (String)SessionMessages.get(renderRequest, portletDisplay.getId() + SessionMessages.KEY_SUFFIX_CLOSE_REDIRECT);
	if ( message!= null) {
%>
	<aui:script use="aui-base">
		var dialog = Liferay.Util.getWindow();
		var hideDialogSignature = '<portlet:namespace />hideRefreshDialog|*';
		dialog.detach(hideDialogSignature);
		
		dialog.on(
			'<portlet:namespace />hideRefreshDialog|visibleChange',
			function(event) {
				var refreshWindow = dialog._refreshWindow || Liferay.Util.getTop();
				refreshWindow.location.href = '<%= message %>';
				
			}
		);
	</aui:script>
<%}else{ %>

	<aui:input autocomplete="off" label="current-password" name="current-password" size="30" type="password"/>

	<aui:input autocomplete="off" label="enter-again" name="enter-again-password" size="30" type="password">
		<aui:validator name="equalTo">
			'#<portlet:namespace />current-password'
		</aui:validator>
	</aui:input>
	
	<input type="button" onclick="<portlet:namespace />deleteUser();" value='<liferay-ui:message key="edison-button-leave"/>' class="yellowbtn"/>
<%} %>



