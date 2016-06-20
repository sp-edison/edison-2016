<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="com.kisti.science.platform.app.model.CommonModule" %>
<%@ page import="com.kisti.science.platform.app.portlet.manager.Constants" %>
<portlet:defineObjects />

<portlet:renderURL var="viewURL">
    <portlet:param name="jspPage" value="/html/scienceapp/manager/test.jsp" />
</portlet:renderURL>

<%
	List<CommonModule> cmList = (List<CommonModule>)renderRequest.getAttribute("foundModList");
	//if(clListStr != null){
	if(cmList != null){
%>
		<table>
			<tr>
				<th>Installed or Available Module Name</th>
				<th>Installed Module Path</th>
			</tr>
		<%
			for(int i=0;i<cmList.size();i++){
				String modName = (cmList.get(i)).getModuleName();
				String modPath = (cmList.get(i)).getModuleRootDir();
		%>
				<tr>
					<td><%= modName %></td>
					<td><%= modPath %></td>
				</tr>
			<%
			}
			%>
		</table>
	<%
	}
	%>
<p><a href="<%= viewURL %>">Back</a></p>