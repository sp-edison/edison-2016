<%@ include file="/html/common/init.jsp" %>
<%@ include file="/html/common/science_platform_events.jspf" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<portlet:resourceURL id="callResource" var="callResourceURL" ></portlet:resourceURL>
<div>
	<input id="<portlet:namespace/>founderBtn"type="button" value="Get Editor&Analyer Info!!" />
</div>
<div>
	<h3>Editor</h3>
	<ul id="<portlet:namespace/>editorDiv"></ul>
</div>
<div>
	<h3>Analyzer</h3>
	<ul id="<portlet:namespace/>analyzerDiv"></ul>
</div>
<script>
	var editorList = (<%=request.getAttribute("scienceAppList") %>).editorList;
	var analyzerList = (<%=request.getAttribute("scienceAppList") %>).analyzerList;
	var contextPath = "<portlet:namespace/>";
	
	$("#<portlet:namespace/>founderBtn").click(function() {
		
		var payload = new SciencePlatformEvent(
			"",
			SciencePlatformEvents.TYPE_BROADCAST,
			'<portlet:namespace/>',
			'',
		{});
		
		Liferay.fire(
			SciencePlatformEvents.IPC_EVENT_REQUEST_CONTENT, payload
	    );
	});
	
	function initilizeForm()
	{
		createEditorBtn();
		createAnalyzerBtn();
	}
	
	function createEditorBtn()
	{
		var btnHtml = "";
		for( var i = 0; i< editorList.length; i++)
		{
			btnHtml += "<li><input id='"+contextPath+editorList[i].name+"' type='button' value='"+editorList[i].name+" Button' "
			+"onClick='openEditorWindow(\""+editorList[i].exeFileName+"\",\""+editorList[i].title+"\",\""+editorList[i].exeFileName+"\",\""+editorList[i].name+"\",\""+editorList[i].token+"\",\""+editorList[i].plid+"\")' /></li>";			
		}
		
		$("#"+contextPath+"editorDiv").html(btnHtml);
	}
	
	function createAnalyzerBtn()
	{
		var btnHtml = "";
		for( var i = 0; i< analyzerList.length; i++)
		{
			btnHtml += "<li><input id='"+contextPath+analyzerList[i].name+"' type='button' value='"+analyzerList[i].name+" Button' "
			+"onClick='openAnalyzerWindow(\""+analyzerList[i].exeFileName+"\",\""+analyzerList[i].title+"\",\""+analyzerList[i].exeFileName+"\",\""+analyzerList[i].name+"\", \"groupdId\", \"folder\",\"JOBSEQNO\", \"SIMUUID\",\""+analyzerList[i].token+"\",\""+analyzerList[i].plid+"\")' /></li>";
		}
		$("#"+contextPath+"analyzerDiv").html(btnHtml);
	}
	
	function openAnalyzerWindow(portletId, portletTitle, taskId, portName, groupId, dataForm, jobSeqNo, simulationUuid, token, plid)
	{
		//analyzer 제작시 해당 editor의 width와 height을 받는다
		var width = 1230;
		var height = 850;
		
		if(portletTitle == 'INPUTDECK VIEWER')
		{
			width = 600;
		}
		
		var renderURL = Liferay.PortletURL.createRenderURL();
  	  	renderURL.setPortletId( portletId );
  	  	renderURL.setPlid(plid);
	  	renderURL.setParameter("taskId", taskId);
	  	renderURL.setParameter("dataForm", dataForm);
	  	renderURL.setParameter("groupId", groupId);
	  	renderURL.setParameter("portName", portName);
	  	renderURL.setParameter("jobSeqNo", jobSeqNo);
	  	renderURL.setParameter("simulationUuid", simulationUuid);
	  	renderURL.setParameter("portletTitle", portletTitle);
	  	renderURL.setParameter("token", token);
	  	renderURL.setParameter("width", width);
	  	renderURL.setParameter("height", height);
	  	openWindow(renderURL);
	}
	
	function openEditorWindow(portletId, portletTitle, taskId, portName, token, plid)
	{
		//editor 제작시 해당 editor의 width와 height을 받는다
		var width = 480;
		var height = 180;
		
		if(portletTitle == 'INPUTDECK EDITOR')
		{
			width = 750;
			height = 610;
		}
		
		var renderURL = Liferay.PortletURL.createRenderURL();
  	  	renderURL.setPortletId( portletId );
  	  	renderURL.setPlid(plid);
	  	renderURL.setParameter("taskId", taskId);
	  	renderURL.setParameter("portName", portName);
	  	renderURL.setParameter("portletTitle", portletTitle);
	  	renderURL.setParameter("token", token);
	  	renderURL.setParameter("width", width);
	  	renderURL.setParameter("height", height);
	  	openWindow(renderURL);
	}
	
	function openWindow(renderURL)
	{
		//dialog 관리를 위한 id
		var dialogId = renderURL.params.portName+Date.now();
		renderURL.setName( renderURL.params.portName );
  	  	renderURL.setWindowState("pop_up"); 
  	  	renderURL.setParameter("dialogId", dialogId);
  	 	renderURL.setParameter("workflowType", "workflow");
  	 	
  	 	var url = renderURL.toString();
  	 	//console.log( url );
		Liferay.Util.openWindow({
			dialog: {
				cache: false,
              	destroyOnClose: true,
				centered: true,
				modal: true,
				resizable: false,
				width:renderURL.params.width, 
				height:renderURL.params.height
			},
			id: dialogId ,
			title: renderURL.params.portletTitle,
			uri : url+ '&p_p_auth='+ renderURL.params.token
			//uri : url
		});
	}
	
	Liferay.provide(
		window,
		'fetchResult',
	   	function( taskId, portName, value ) 
	   	{
			var content = {
					taskId : taskId,
					portName : portName,
					value: value
			};
			var payload = new SciencePlatformEvent(
					"",
					SciencePlatformEvents.TYPE_BROADCAST,
					'<portlet:namespace/>',
					'',
					content);
			getPortletSessionValue( portName );
			//Liferay.fire(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, payload);
	   	},
		['liferay-util-window','dialog-iframe']
	);
	
	Liferay.provide(
		window,
		'closePopup',
	   	function(popupId) {
	       	var popupDialog = Liferay.Util.Window.getById(popupId);
            popupDialog.destroy();
	   	},
	   	['liferay-util-window','dialog-iframe']
	);
	
	Liferay.on(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, function(event){
		var jsonData = JSON.stringify(event.getEventData());
		console.log(jsonData);
	});
	
	function getPortletSessionValue( portName )
	{
		$.ajax({
			url:"<%=callResourceURL%>",
			type:"post",
			dataType: "text",
			data:{ 
				"<portlet:namespace/>portName" : portName
			},
			success:function(data)
			{
				console.log(data);
			}
		});
	}

	initilizeForm();
</script>