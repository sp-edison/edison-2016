<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
	String clickTab = GetterUtil.get(request.getParameter("clickTab"), "m01");
	String jspFile = "";
	if(clickTab.equals("m01")){
		jspFile = "app_infomation";
	}else if(clickTab.equals("m02")){
		jspFile = "execute_infomation";
	}else if(clickTab.equals("m03")){
		jspFile = "port_infomation";
	}else if(clickTab.equals("m04")){
		jspFile = "sw_test";
	}
	
%>

<liferay-portlet:renderURL var="listURL" copyCurrentRenderParameters="<%=false%>" portletMode='view'>
	<portlet:param name="searchValue" value="${searchValue}"/>
	<portlet:param name="searchOption" value="${searchOption}"/>
	<portlet:param name="searchStatus" value="${searchStatus}"/>
	<portlet:param name="p_curPage" 	value="${p_curPage}" />
</liferay-portlet:renderURL>


<liferay-portlet:renderURL var="solverRenderURL" copyCurrentRenderParameters="<%=true%>"/>
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="deleteFileURL" escapeXml="false" id="deleteFile" copyCurrentRenderParameters="false">
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="updateAppStatusURL" escapeXml="false" id="updateAppStatus" copyCurrentRenderParameters="false">
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
</liferay-portlet:resourceURL>
	

<style type="text/css">
</style>

<div class="swleft">
	${tabStr}
</div>
<div class="swrightcont">
	<liferay-util:include page='<%= "/WEB-INF/html/appmanager/" + jspFile + ".jsp" %>' servletContext="<%=this.getServletContext() %>">
<%-- 		<liferay-util:param name="clickTab" value="<%=clickTab%>" /> --%>
<%-- 		<liferay-util:param name="jspFile" value="<%=jspFile%>" /> --%>
	</liferay-util:include>
</div>

<script type="text/javascript">
	function tabAction(tabValue){
		<%
		    String renderUrl = HttpUtil.removeParameter(solverRenderURL, renderResponse.getNamespace()+"clickTab");
		%>
		
		var searchParameter = "";
		searchParameter += "&<portlet:namespace/>clickTab="+tabValue;
		location.href="<%=renderUrl%>"+searchParameter;
	}
	function <portlet:namespace/>statusSubmit(status){
		var statusMsg = "";
		if(status=='1901002'){
			statusMsg = Liferay.Language.get('edison-appstore-status-request');
		}else if(status=='1901003'){
			statusMsg = Liferay.Language.get('edison-appstore-status-private');
		}else if(status=='1901004'){
			statusMsg = Liferay.Language.get('edison-appstore-status-service');
		}
		
		var confirmMsg = Liferay.Language.get('edison-science-appstore-status-change-msg',[''+statusMsg+'']);
		
		if(confirm(confirmMsg)){
			var dataForm = {	
					"<portlet:namespace/>status"	: status
				};
			
			jQuery.ajax({
				type: "POST",
				url: "<%=updateAppStatusURL%>",
				async : false,
				data  : dataForm,
				success: function(result) {
					if(result=="SUCCESS"){
						location.reload();
					}
				},error:function(jqXHR, textStatus, errorThrown){
					if(jqXHR.responseText !== ''){
						alert(textStatus+": "+jqXHR.responseText);
					}else{
						alert(textStatus+": "+errorThrown);
					}  
				}
			});
		}else{
			return false;
		}
	}
	
	
	function <portlet:namespace/>fileDownload(p_fileEntryId){
		location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
	}
	
	function <portlet:namespace/>goList(){
		location.href = "<%=listURL%>";	
	}
	
	function <portlet:namespace/>deleteFile(p_fileEntryId,fileType,objectClass,language){
		if(!confirm(Liferay.Language.get('file-delete-confirm'))) return;
		var deleteForm = {
				"<portlet:namespace/>fileEntryId" : p_fileEntryId,
				"<portlet:namespace/>fileType" : fileType,
				"<portlet:namespace/>language" : language
				};
		
		jQuery.ajax({
			type: "POST",
 			url: "<%=deleteFileURL%>",
			data: deleteForm,
	  		async : false,
			success: function(data) {
				alert(Liferay.Language.get('edison-data-delete-success'));
				$("."+objectClass).remove();
				
				if(fileType=="portType"){
					var percentVal = '0%';
					$('.bar').width(percentVal);
					$('.percent').html(percentVal);
					$("#<portlet:namespace/>fileSave").show();
				}
			},error:function(data,e){ 
				alert("deleteFile System error!");	
			}
		});
	}
	
	function <portlet:namespace/>noUpdateDisabled(status){
		if(Number(status)>=1901003){
			$(".noupdate").prop('disabled', true);
			$(".noUpdateHidden").css('display', 'none');
		}
	}
</script>
