<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/common/init.jsp" %>
<%@ include file="/html/common/science_platform_events.jspf" %>
<portlet:resourceURL id="callResource" var="callResourceURL" ></portlet:resourceURL>
<portlet:defineObjects />
<script>
	var defaultLanguage = '<%= request.getAttribute("defaultLanguage")%>';
	var availableLanguages =  '<%= request.getAttribute("availableLanguages")%>';
	var availableLanguages =  '<%= request.getAttribute("availableLanguages")%>';
	var portletNameSpace = '<portlet:namespace/>';
	var userinputdeckUserData = null;
	//window onload 전에는 hidden이 적용안되기 때문에 onload 후에 개별적으로 hidden
	var onloadHiddenForm = new Array(); 
	
	<% 
		String portName = request.getParameter("portName")==null?"InputDeckEditorPort":request.getParameter("portName").toString();
	%>
	var portName = '<%= portName%>';
	var workflowType = '<%= request.getParameter("workflowType")%>';
	var dialogId = '';
	var taskId = '<%= request.getParameter("taskId")%>';
</script>
<div class="mainContent">
	<div>
		<h3>InputDeckForm</h3>
		<div id="<portlet:namespace/>formDiv" style="display:none"></div>
		<div id="<portlet:namespace/>variableDiv">
			<form id="<portlet:namespace/>inputdeckForm">
				<table id="<portlet:namespace/>variableTable">
					<thead>
						<tr>
							<th>Variable Name</th>
							<th>Value</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>daf</td>
							<td>daf</td>
							<td>daf</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>	
	</div>
	<div class="submitDiv" >
		<input type="button" id="<portlet:namespace/>cancelBtn" value="Cencel" class="cancelBtn"/>
		<input type="button" id="<portlet:namespace/>confirmBtn" value="Confirm"  class="confirmBtn"/>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/editor/inputdeck/inputdeck_form.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/editor/inputdeck/hashmap.js"></script>
<!-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/editor/inputdeck/inputdeck_editor.js"></script>  -->
<%@ include file="/js/editor/inputdeck/inputdeck_editor.jspf" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/editor/editor.css" />
<script>
	//workflowType value : workflow or single
	// editor가 창으로 열릴지 여부를 받는다(workflow일 경우 창, single일 경우 일반 포틀릿)
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
	
	$("#<portlet:namespace/>confirmBtn").click(function() {
			savePortletSessionValue( taskId, portName, JSON.stringify(generateInputFile( inputdeckUserData )) );
	});
	
	$("#<portlet:namespace/>cancelBtn").click(function() {
		Liferay.Util.getOpener().closePopup( dialogId );
	});
	
	function savePortletSessionValue( taskId, portName, value )
	{
		$.ajax({
			url:"<%=callResourceURL%>",
			type:"post",
			dataType: "text",
			data:{
				"<portlet:namespace/>taskId" : taskId,
				"<portlet:namespace/>portName" : portName,
				"<portlet:namespace/>value": value
			},
			success:function(data)
			{
				Liferay.Util.getOpener().fetchResult( taskId,portName, value );
				Liferay.Util.getOpener().closePopup( dialogId );
			}
		});
	}
	
	//인풋덱을 생성
	inputdeckFormData = $.extend( {}, createInputDeckFormData());
	// 인풋덱 에디터 생성
	inputdeckUserData =  $.extend( {}, createInputDeckEditor(inputdeckFormData));
</script>
