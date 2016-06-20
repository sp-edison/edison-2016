<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="com.kisti.science.platform.app.model.CommonLibrary" %>
<%@ page import="com.kisti.science.platform.app.portlet.manager.Constants" %>
<portlet:defineObjects />

<portlet:renderURL var="viewURL">
    <portlet:param name="jspPage" value="/html/scienceapp/manager/test.jsp" />
</portlet:renderURL>

<%
	//String clListStr = (String)renderRequest.getAttribute("foundLibList");
	List<CommonLibrary> clList = (List<CommonLibrary>)renderRequest.getAttribute("foundLibList");
	//if(clListStr != null){
	if(clList != null){
		/* StringTokenizer st = new StringTokenizer(clListStr, "\n");
		String libName = "";
		String libPath = "";
		String sysArch = "";
		int LIB_NAME_IDX = 1;
		int LIB_SYS_ARCH_IDX = 3;
		int LIB_PATH_IDX = 5; */ 
%>
		<table>
			<tr>
				<th>Installed Library Name</th>
				<th>Support System Architecture</th>
				<th>Installed Library Path</th>
			</tr>
		<%
			// Iterate until we consume all tokens
			for(int i=0;i<clList.size();i++){
				String libName = (clList.get(i)).getLibName();
				String sysArch = (clList.get(i)).getSysArch();
				String libPath = (clList.get(i)).getLibPath();
		%>
				<tr>
					<td><%= libName %></td>
					<td><%= sysArch %></td>
					<td><%= libPath %></td>
				</tr>
			<%
			}
			%>
		</table>
	<%
	}
	%>
<p><a href="<%= viewURL %>">Back</a></p>