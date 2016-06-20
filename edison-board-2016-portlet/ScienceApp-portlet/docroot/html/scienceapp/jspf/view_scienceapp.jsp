<%@page import="com.kisti.science.platform.app.model.ScienceApp"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="science.platform.service.SpUserLocalServiceUtil"%>
<%@page import="science.platform.model.SpUser"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/common/init.jsp" %>

<%
	ScienceApp scienceApp = (ScienceApp)request.getAttribute("SCIENCEAPP_ENTRY");
	User author = UserLocalServiceUtil.getUser(scienceApp.getAuthorId());
	SpUser spAuthor = SpUserLocalServiceUtil.getSpUser(scienceApp.getAuthorId());
%>
<h4><%= scienceApp.getName() %></h4>

<dl class="scienceapp">
	<dt>
		<liferay-ui:message key="science-platform-user-email" />
	</dt>
	<dd><%=HtmlUtil.escape(author.getEmailAddress())%></dd>
	<dt>
		<liferay-ui:message key="science-platform-user-country" />
	</dt>
	<dd><%=spAuthor.getSpCountryId() %></dd>
	<dt>
		<liferay-ui:message key="science-platform-user-affiliation" />
	</dt>
	<dd><%=spAuthor.getSpAffiliationId() %></dd>
</dl>
	    