<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="com.kisti.science.platform.app.portlet.manager.Constants" %>
<portlet:defineObjects />

<portlet:renderURL var="viewURL">
    <portlet:param name="jspPage" value="/html/scienceappengine/view.jsp" />
</portlet:renderURL>

<%
	String fileRes = (String)renderRequest.getAttribute("unzipSciAppRes");
%>
<p> Unzipped Science App Path: <%= fileRes %></p>

<p><a href="<%= viewURL %>">Back</a></p>