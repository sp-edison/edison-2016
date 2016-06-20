<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ include file="/common/init.jsp"%> --%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://www.edison.re.kr/tld/edison-ui" prefix="edison-ui" %>
<%@ page import="org.kisti.edison.util.CustomUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%

	String returnId = request.getAttribute("returnId")!= null?(String)request.getAttribute("returnId"):"";
	String returnFileName = request.getAttribute("returnFileName")!= null?(String)request.getAttribute("returnFileName"):"";
	String cluster = request.getAttribute("cluster")!= null?(String)request.getAttribute("cluster"):"";
	String workflowType = request.getAttribute("workflowType")!= null?(String)request.getAttribute("workflowType"):"";
	
%>
<liferay-portlet:actionURL secure="<%= request.isSecure() %>" var="fileIBUploadURL">
	<liferay-portlet:param name="myaction" value="fileIBUpload" />
	<liferay-portlet:param name="returnId" value="<%=returnId%>" />
	<liferay-portlet:param name="returnFileName" value="<%=returnFileName%>" />
	<liferay-portlet:param name="cluster" value="<%=cluster%>" />
	<liferay-portlet:param name="workflowType" value="<%=workflowType%>" />
</liferay-portlet:actionURL>

<%-- <script type="text/javascript" src="${renderRequest.getContextPath()}/js/jquery.blockUI.js"></script> --%>
<%-- <script type="text/javascript" src="${renderRequest.getContextPath()}/js/jstree.min.js"></script> --%>
<%-- <script type="text/javascript" src="${renderRequest.getContextPath()}/js/main.js"></script> --%>

<%-- <liferay-portlet:resourceURL var="fileIBUploadURL" id="fileIBUpload" copyCurrentRenderParameters="false" escapeXml="false"/> --%>
<div class="newWindow" style="background-color: #fff; overflow-x: hidden;overflow-y: hidden;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
		<div class="newWtitle"><liferay-ui:message key="edison-simulation-execute-pre-processor-form-create-attachments-upload"/></div>
		</div>
		<div class="newWclose">
			<img id="icebreaker-file-upload-dialog-close-btn" name="icebreaker-file-upload-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<aui:form method="post" name="fileUploadForm" enctype="multipart/form-data" action="<%=fileIBUploadURL %>" >
		<aui:input type="hidden" name="groupId" value="${groupId }"></aui:input>
		<aui:input type="hidden" name="vcToken" value="${vcToken }"></aui:input>
		<aui:input type="hidden" name="destFolerId" value="${destFolerId }"></aui:input>
		<aui:input type="hidden" name="destFolerParents" value="${destFolerParents }"></aui:input>
		<aui:input type="hidden" name="isPopUp" value="${isPopUp }"></aui:input>

		<%-- <div class="mfpopup01 mfpd" style="color : red">		
			※ <liferay-ui:message key="edison-simulation-myfile-korean-file-upload"/>
		</div> --%>
		<div id="uploadList">
			 <div class="mfpopup01 mfpd" id="fileUpload0">
					<div class="mfp01">
						<input type="file" name="<portlet:namespace/>addFile" id="<portlet:namespace/>file0"/>
<%-- 						<aui:input name="file" name="<portlet:namespace/>addFile" id="<portlet:namespace/>file0"></aui:input> --%>
					</div>
					<div class="mfp03">
						<input class="addIp button02_1" onClick="addFile();" value="<liferay-ui:message key='edison-button-file-add'/>" type="button">
					</div>
			 </div>
		</div>
		
		<div class="mfpbtnbox">
			<div class="popupbtnGroup">
				<input class="addIp button04_1" value="<liferay-ui:message key='edison-button-upload'/>" type="button" onclick="submitCheck()">
			</div>
		</div>  
		
		<div id="iframeDiv"></div>     
	</aui:form>
		
</div>

<script type="text/javascript">
AUI().ready(function() {
	$("#icebreaker-file-upload-dialog-close-btn").click(function() {
		$("#icebreaker-file-upload-dialog").dialog("close");
	});
});
	
var fileIndex = 1;
function addFile(){
	$upload = $("#uploadList");
	$mfpopupWrapper = $("<div/>").addClass("mfpopup01").attr("id","fileUpload"+fileIndex);
	$("<div/>").addClass("mfp01").append($("<input/>").attr("type","file").attr("name","<portlet:namespace/>addFile").attr("id","<portlet:namespace/>file"+fileIndex)).appendTo($mfpopupWrapper);
	$("<div/>").addClass("mfp03").append($("<input/>").attr("type","button").addClass("addIp").addClass("button02_1").attr("value",Liferay.Language.get('edison-button-file-delete')).attr("onClick","removeFile('fileUpload"+fileIndex+"')")).appendTo($mfpopupWrapper);
	
	$mfpopupWrapper.appendTo($upload);
	fileIndex++;
}
function removeFile(objId){
	$("#"+objId).remove();
}
function submitCheck(){

	var bool = false;
	$("input[name = <portlet:namespace/>addFile]").each(function(){
		if($(this).val() == ""){
			bool = false;
			alert(Liferay.Language.get("edison-simulation-execute-user-define-select-your-own-attachments"));
			return false;
		}else{
			bool = true;
		}
	});
	
	
	if(bool){
		bStart();
		$("form[name = <portlet:namespace/>fileUploadForm]").submit();
		bEnd();
	}else{
		bEnd();
	}
}
</script>