<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="java.util.Map" %>
<%@ page import="javax.portlet.PortletURL" %>

<liferay-portlet:resourceURL var="getListSurveyURL" id="getListSurvey" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="getListSurveyResultURL" id="getListSurveyResult" copyCurrentRenderParameters="false" />

<liferay-portlet:renderURL var="surveyInsertViewURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="surveyInsertView" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="surveyViewURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="surveyView" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="surveyResultViewURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="surveyResultView" />
</liferay-portlet:renderURL>


<style type="text/css">
.edison .button01b {
	font-size:15px;
}
	
.edison .table1_list td p {
	margin-bottom : 0px;
	line-height: 1.5em;
}
.edison .button01b {
	padding:3px 7px;
}

</style>
	<%
		//공통
		String tabNames = (String)request.getAttribute("tabNames");
		String tabsValues = (String)request.getAttribute("tabsValues");
		String visitSite = (String)request.getAttribute("visitSite");
		JSONObject obj = new JSONObject();
		
		//JSP
		String tabs1 = ParamUtil.getString(request, "tabs1", visitSite);
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setWindowState(WindowState.NORMAL);
		portletURL.setParameter("tabs1", tabs1);
	%>
	
	<div class="contabmenu">
		<edison-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>" tabsValues="<%=tabsValues%>" value="<%=tabs1%>" refresh="<%=true%>" minwidth="180">
		</edison-ui:tabs>
	</div>
	<c:if test='<%= tabs1.equals("survey") %>'>
		<%@ include file="./surveyManagement.jsp"%>
	</c:if>
	<c:if test='<%=!tabs1.equals("survey")%>'>
		<%@ include file="./surveyResultList.jsp"%>
	</c:if>
