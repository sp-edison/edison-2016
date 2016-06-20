<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/common/init.jsp" %>
<%@ include file="/html/common/science_platform_events.jspf" %>
<portlet:resourceURL id="callResource" var="callResourceURL" ></portlet:resourceURL>
<portlet:defineObjects />
<style>
.mainTable
{	
	width: 400px;
	height: 100%;
	padding: 10px;
	text-align: right;
}
.mainTable input[type="text"]
{	
	width:290px;
}

.mainTable input[type="button"]
{	
	display:none;
	width:150px;
	height:30px;
}
</style>
<div style="float:right;">
	<table class="mainTable">
		<tr>
			<td>
				<strong>String Value : </strong>
			</td>
			<td>
				<input type="text" id="<portlet:namespace/>stringValue" value=""  class="stringInputText" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" id="<portlet:namespace/>confirmBtn" value="Confirm"  class="confirmBtn"/>
				<input type="button" id="<portlet:namespace/>cancelBtn" value="Cencel" class="cancelBtn"/>
			</td>
		</tr>
	</table>
</div>
<!-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/editor/editor.css" /> -->
<script>
	<% 
		String portName = request.getParameter("portName")==null?"StringEditorPort":request.getParameter("portName").toString();
	%>
	var portName = '<%= portName%>';
	var workflowType = '<%= request.getParameter("workflowType")%>';
	var dialogId = '';
	var taskId = '<%= request.getParameter("taskId")%>';
	
	// workflowType value : workflow or single
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
			var stringValue = $('#<portlet:namespace/>stringValue').val();
			 var content = {
					taskId : taskId=='null'?"":taskId,
					portName : portName,
					value : stringValue
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
		var stringValue = $('#<portlet:namespace/>stringValue').val();
		
		if( stringValue == '')
			alert("no empty value");
		else
		{
			savePortletSessionValue( taskId, portName, stringValue );
			//Liferay.Util.getOpener().fetchResult( taskId,portName, stringValue );
			//Liferay.Util.getOpener().closePopup( dialogId );
		}
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
</script>
