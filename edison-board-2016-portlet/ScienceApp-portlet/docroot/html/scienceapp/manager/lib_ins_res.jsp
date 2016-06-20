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
    <portlet:param name="jspPage" value="/html/scienceapp/manager/test.jsp" />
</portlet:renderURL>

<%
	String strLibInsRes = (String)renderRequest.getAttribute("insLibRes");
%>
<p><%= strLibInsRes %></p>

<p><a href="<%= viewURL %>">Back</a></p>