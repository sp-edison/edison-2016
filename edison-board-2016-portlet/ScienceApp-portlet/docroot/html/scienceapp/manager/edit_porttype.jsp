<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.kisti.science.platform.app.model.ScienceApp"%>
<%@ include file="/html/common/init.jsp" %>

<%
%>

<aui:a href="<%=redirect %>">Back to list</aui:a>

<%
	HttpServletRequest servletRequest = PortalUtil.getOriginalServletRequest(request);
	String scienceAppId = servletRequest.getParameter("scienceAppId");
	String scienceAppName = servletRequest.getParameter("scienceAppName");
	String scienceAppVersion = servletRequest.getParameter("scienceAppVersion");
	System.out.println("Request ID: "+scienceAppId);
	System.out.println("redirect: " + redirect);
	
%>

<aui:form action=""  method="post" id="<portlet:namespace/>fm">
	<aui:fieldset column="true"  label="Current App" >
		<aui:row>
			<aui:col width="25">
				<aui:input name="appId" type="text" label="scienceapp-id" disabled="true" value='<%= scienceAppId %>' inlineField="true"/>
			</aui:col>
			<aui:col width="25">
				<aui:input name="appName" type="text" label="scienceapp-name" disabled="true" value='<%= scienceAppName %>' inlineField="true"/>
			</aui:col>
			<aui:col width="25">
				<aui:input name="appVersion" type="text" label="scienceapp-version" disabled="true" value='<%= scienceAppVersion %>' inlineField="true"/>
			</aui:col>
		</aui:row>
	</aui:fieldset>
	
	<aui:fieldset column="true"  label="Describe Your App" >
			<aui:input localized="true" name="appTitle" model="<%= ScienceApp.class %>" type="text" label="scienceapp-title"  fieldParam="title" />
	</aui:fieldset>
	
	<aui:button-row>
		
	</aui:button-row>
</aui:form>

<script>
	
</script>