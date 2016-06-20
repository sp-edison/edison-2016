<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<style>
.aui .variableTable input[type="text"] {
	width:115px;
	margin-right:10px;
}
.aui .variableTable select {
	width:267px;
	margin-right:10px;
}
</style>
<script type="text/javascript">

var defaultLanguage = "<%=themeDisplay.getLocale().toString()%>";
var availableLanguages =  '<%= request.getAttribute("availableLanguages")%>';
var portletNameSpace = '<portlet:namespace/>';

var userinputdeckUserData = null;
//window onload 전에는 hidden이 적용안되기 때문에 onload 후에 개별적으로 hidden
var onloadHiddenForm = new Array(); 

var portName = '<%= request.getParameter("portName")%>';
var workflowType = '<%= request.getParameter("workflowType")%>';
var dialogId = '';
var taskId = '<%= request.getParameter("taskId")%>';

var contextPath = "${contextPath}";

AUI().ready(function() {
	if( workflowType == "workflow")
	{
		dialogId = '<%= request.getParameter("dialogId")%>';
		taskId = '<%= request.getParameter("taskId")%>';
		$("#<portlet:namespace/>confirmBtn").show();
		$("#<portlet:namespace/>cancelBtn").show();
	}
	else
	{
		Liferay.on(SciencePlatformEvents.IPC_EVENT_REQUEST_CONTENT, function(event){
			//IPC로 부모창에 InputDeckForm을 읽어들여 실제 만들어지는 파일 포맷을 첨부하여(file-content:\n 개행) json 반환
			var inputdeckResult = JSON.stringify(generateInputFile( inputdeckUserData ));
			
			 var content = {
					taskId : taskId=='null'?"":taskId,
					portName : portName=='null'?"":portName,
					value: inputdeckResult
			};
		 
			var payload = new SciencePlatformEvent(
					event.getPortName(),
					SciencePlatformEvents.TYPE_TARGET,
					'<portlet:namespace/>', 
					event.getEventEmitter(),
					content);
			
			Liferay.fire(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, payload);
		});
	}
	
	var JsonData = ${JsonData};
	inputdeckFormData = new InputdeckForm();
	inputdeckFormData.setData(JsonData);
	inputdeckFormData = createInputDeckEditor(inputdeckFormData);
	
	$("#<portlet:namespace/>confirmBtn").click(function() {
		Liferay.Util.getOpener().fetchResult( taskId,portName, JSON.stringify(generateInputFile( inputdeckFormData )) );
		Liferay.Util.getOpener().closePopup( dialogId );
	});
	
	$("#<portlet:namespace/>cancelBtn").click(function() {
		Liferay.Util.getOpener().closePopup( dialogId );
	});

});

$( document ).tooltip();

</script>
<div id="<portlet:namespace/>variableDiv" class="table2_list">
	<form id="<portlet:namespace/>inputdeckForm">
		<table id="<portlet:namespace/>variableTable" class="variableTable" style="width: 100%;table-layout: fixed;" >
			<thead>
				<tr>
					<th width="20%">Variable Name</th>
					<th width="67%">Value</th>
					<th width="13%" class="TC">Description</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</form>
</div>
<div class="buttonbox">
	<input type="button" id="<portlet:namespace/>confirmBtn" value="Confirm"  class="button04" style="margin-right:15px;"/>
	<input type="button" id="<portlet:namespace/>cancelBtn" value="Cancel" class="button04" style="margin-right:15px;"/>
</div>