<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.template.TemplateHandler" %>
<%@ page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil" %>
<%@ page import="com.liferay.portal.theme.PortletDisplay" %>
<%@ page import="org.kisti.edison.multiboard.model.Board" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<script type="text/javascript">

var trIndex = "0";
var portletIdTr = "<%=PortalUtil.getPortletId(request)%>";

function <portlet:namespace/>addPreferences(){
	$newTr = $("<tr/>").attr("id", "<portlet:namespace/>tr_" + trIndex);
	
	$("<td/>").append(
		 $("<input/>").attr("name", "<portlet:namespace/>numberArray")
		 			  .attr("id","<portlet:namespace/>numberArray")
		 			  .attr("type","text")
		 			  .attr("readOnly", "true")
		 			  .val(trIndex)
	).appendTo($newTr);

	$("<td/>").append(
		 $("<input/>").attr("name", "<portlet:namespace/>" + trIndex + "_friendlyURL")
		 			  .attr("id","<portlet:namespace/>friendlyURL")
	).appendTo($newTr);

	$("<td/>").append(
		 $("<input/>").attr("name", "<portlet:namespace/>delete")
		 			  .attr("id","<portlet:namespace/>delete")
		 			  .attr("type", "button")
		 			  .attr("onclick", "<portlet:namespace/>preferenceDelete(" + trIndex + ")")
		 			  .val("Delete")
	).appendTo($newTr);

	$("#keySetBody").append($newTr);
	
	trIndex = String(Number(trIndex) + 1);
}


function <portlet:namespace/>preferenceDelete(trId){
	$("#<portlet:namespace/>tr_"+trId).remove();
}

</script>



<div>
	<input type="button" value="Add preferences" onclick="<portlet:namespace/>addPreferences()">
</div>
<aui:form action="<%= configurationURL %>" method="post" name="fm">

	<div class="table1_list borderno">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list" >
		<colgroup>
			<col width="10%" />	//순번
			<col width="70%" />	//friendlyURL
			<col width="20%" /> //삭제 버튼
		</colgroup>
		<thead>
			<tr>
				<th>Number</th>
				<th>FriendlyURL</th>
				<th>Delete</th>
			</tr>
	    </thead>
		<tbody id="keySetBody">
<%
	int i=1;

	String[] numberArray = portletPreferences.getValues("numberArray", new String[]{});
	if(numberArray.length > 0 && numberArray != null) {
		for(int num = 0; num < numberArray.length; num++) {
			String number = numberArray[num];
			String friendlyURL = portletPreferences.getValue(number + "_friendlyURL" , "");
			
			out.print("<tr id=\"_"+PortalUtil.getPortletId(request)+"_tr_"+number+"\">\n");
			out.print("	<td><input type=\"text\" id=\"_"+PortalUtil.getPortletId(request)+"_numberArray\" name=\"_"+PortalUtil.getPortletId(request)+"_numberArray\" value=\""+number+"\" size=\"20\" readonly=\"true\"></td>\n");
			out.print("	<td><input type=\"text\" id=\"_"+PortalUtil.getPortletId(request) + "_" + number + "_friendlyURL\" name=\"_"+PortalUtil.getPortletId(request)+ "_" + number + "_friendlyURL\" value=\""+friendlyURL+"\" size=\"20\"></td>\n");
			out.print("	<td><input type=\"button\" value=\"Delete\" onclick=\"_"+PortalUtil.getPortletId(request)+"_preferenceDelete(\'"+number+"\')\"></td>\n");
			out.print("</tr>\n");
			i = Integer.parseInt(CustomUtil.strNull(number, "0")) + 1;
		}
	}

%>
		</tbody>
	</table>
	</div>

<script type="text/javascript">
trIndex = "<%=i%>";
</script>

<%-- 	<aui:button-row> --%>
<%-- 		<aui:button type="submit" /> --%>
<%-- 	</aui:button-row> --%>

<input type="submit" value="저장" />

</aui:form>
