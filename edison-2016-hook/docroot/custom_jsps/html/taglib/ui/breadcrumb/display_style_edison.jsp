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
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ include file="/html/taglib/ui/breadcrumb/init.jsp" %>
<c:if test="<%= Validator.isNotNull(breadcrumbString) %>">
	<%if(currentURL.indexOf("control_panel")>0){ %>
		<ul aria-label="<%= LanguageUtil.get(pageContext, "breadcrumb") %>" class="breadcrumb">
			<%= breadcrumbString %>
		</ul>
	<%}else{ %>
		<div class="subnaviwrap">
			<div class="subnavi">
				<%
					String ppid = GetterUtil.getString(request.getParameter("p_p_id"));
					boolean showBreadCrumbString = true;
					if(ppid.equals("58") || ppid.equals("1001") || ppid.equals("1004")){
						showBreadCrumbString = false;
					}else{
						boolean isLogin = themeDisplay.isSignedIn();
						if(isLogin){
							if(!themeDisplay.getUser().isEmailAddressVerificationComplete()){
								showBreadCrumbString = false;
							}
							
							if(themeDisplay.getUser().isPasswordReset()){
								showBreadCrumbString = false;
							}
						}
					}
				%>
				<ul>
					<%if(showBreadCrumbString){ %>
						<li class="home">
							<a href="<%=PortalUtil.getHomeURL(request)%>">
								<i class="icon-home icon-large"></i>
							</a>
						</li>
						<%= breadcrumbString %>
					<% }%>
				</ul>
			</div>
		</div>
	<%} %>
	
	
</c:if>