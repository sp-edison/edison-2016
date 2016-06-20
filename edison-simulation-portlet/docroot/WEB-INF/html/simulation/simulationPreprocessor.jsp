<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		
<div>
	<div id="runTypeDiv"></div>
	<div id="preprocessorDiv"></div>
</div>

<div id="<portlet:namespace/>jobparameter-dialog" title="Job Detail" class="newWindow" style="padding:0px; display:none; background-color: #f9f9f9;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="${contextPath}/images/title_newWindow.png" width="34" height="34" />
		<div class="newWtitle">Detail Job</div></div>
		<div class="newWclose"><img id="<portlet:namespace/>jobparameter-dialog-dialog-close-btn" name="<portlet:namespace/>jobparameter-dialog-dialog-close-btn" src="${contextPath}/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer;"/></div>
	</div>
	<div id="<portlet:namespace/>jobparameter-dialog-content" class="newWcont01" style="width:400px; max-height:500px; background:white; overflow:auto; white-space:pre-wrap; font-size: 15px; word-break: break-all;">
	</div>
</div>

<div id="<portlet:namespace/>editor-dialog" style="display:none; background-color:white; padding:0px;" class="newWindow">
	<div class="newWheader" id="<portlet:namespace/>editor-dialog-title" style="cursor: move;">
		<div class="newWtitlebox"><img src="${contextPath}/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle"><liferay-ui:message key="edison-simulation-editor-choice"/></div>
		</div>
		<div class="newWclose" style="cursor: pointer;">
			<img id="<portlet:namespace/>editor-dialog-close-btn" name="<portlet:namespace/>editor-dialog-close-btn" src="${contextPath}/images/btn_closeWindow.png" width="21" height="21">
		</div>
	</div>
	<div style="padding: 30px;" class="newWcont01">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
			<colgroup>
				<col width="*" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col" class="left"><liferay-ui:message key="edison-simulation-editor-name"/></th>
				</tr>
			</thead>
			<tbody id="<portlet:namespace/>editor-dialog-content" style="font-size: 25px;">
				
			</tbody>
		</table>
	</div>
</div>

<style type="text/css">
	.edison h4.subTitle {
		margin-left:10px;
	}
	
</style>
<script type="text/javascript">
$("#<portlet:namespace/>jobparameter-dialog").dialog({
	autoOpen: false,
	width: 'auto',
	height: 'auto',
	modal: true,
	resizable: false,
	show: {effect:'fade', speed: 800}, 
	hide: {effect:'fade', speed: 800},
	open: function(event, ui) {
    	$(this).removeClass("ui-widget-content");
    	$(this).parent().removeClass("ui-widget-content");
    },
    close: function() {
    }
}).dialog("widget").find(".ui-dialog-titlebar").remove();

$("#<portlet:namespace/>jobparameter-dialog-dialog-close-btn").click(function() {
	$("#<portlet:namespace/>jobparameter-dialog").dialog("close");
});

$("#<portlet:namespace/>editor-dialog").dialog({
	autoOpen: false,
	width: 500,
	height: 'auto',
	modal: true,
	resizable: true,
	show: {effect:'fade', speed: 800}, 
	hide: {effect:'fade', speed: 800},
	open: function(event, ui) {
    	$(this).removeClass("ui-widget-content");
    	$(this).parent().removeClass("ui-widget-content");
    	$(this).parent().css('overflow','visible');
    	
    	$("#<portlet:namespace/>editor-dialog-close-btn").bind('click',function(){
    		$("#<portlet:namespace/>editor-dialog").dialog("close");
    	});
    	
    	$('.ui-widget-overlay').bind('click',function(){
    		$("#<portlet:namespace/>editor-dialog").dialog("close");
		})
    },
    close: function() {
    	$("#<portlet:namespace/>editor-dialog-content").empty();
    }
}).draggable({
		handle: "#<portlet:namespace/>editor-dialog-title"
}).dialog("widget").find(".ui-dialog-titlebar").remove();

function codeMpiNumberCheck(obj, p_code_mpi_default, p_code_mpi_min, p_code_mpi_max){
	
	var v_code_mpi_min = new Number(nullToStrReplace(p_code_mpi_min, "NULL"));
	var v_code_mpi_max = new Number(nullToStrReplace(p_code_mpi_max, "NULL"));

	var inputCore = new Number(obj.value);

	if(isNaN(inputCore)==true){
		alert("is Only Number");
		obj.value = p_code_mpi_default;	
		return;
	}else{
		if(v_code_mpi_min != "NULL"){
			if(inputCore < v_code_mpi_min){
				alert("Greater than or equals " + v_code_mpi_min);
				obj.value = p_code_mpi_default;	
				return;
			}	
		}
		
		if(p_code_mpi_max != "NULL"){
			if(inputCore >  v_code_mpi_max){
				alert("Less than or equals " + v_code_mpi_max);
				obj.value = p_code_mpi_default;	
				return;
			}
		}
	}
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getCountUserUseCoreURL%>",
		async : false,
		data  : {
				"<portlet:namespace/>groupId": $("#<portlet:namespace/>groupId").val(),
				"<portlet:namespace/>requestCore": inputCore		 
				 },
		success: function(data) {
						
			if(data.checkCore==false){
				
				var msg = "There are no idle resources.";
				msg += "\nAssigned cores : " + data.userAssignmentCores;
				msg += "\nRequest total core : " + data.requestCores;
				msg += "\nInput core : " + inputCore;
				obj.value = "";
			}
			preProcessorCheck();
	
		}//success
	});//jQuery.ajax
	
}


function preprocessorFormCreate(portMapList){
	$("#preprocessorDiv").empty();	
	$("#runTypeDiv").empty();	
	
	preFormCount = 0;
 	if($("#<portlet:namespace/>scienceAppRunType").val() == "<%=ScienceAppConstants.APP_RUNTYPE_SEQUENTIAL%>"){//SINGLE
		$("#runTypeDiv").append(
	  			 				$("<input/>")
											.attr("type","hidden")
											.attr("name","<portlet:namespace/>code_mpi_number")
											.attr("id","<portlet:namespace/>code_mpi_number")
											.val(1)
								);
	}else{//PARALLEL
		var defaultCpu = $("#<portlet:namespace/>scienceAppDefaultCpus").val();
		var maxCpu = $("#<portlet:namespace/>scienceAppMaxCpus").val();
		
		preFormCount++;
			 		
		$mpiTableNode = $("<table/>")
									.attr("width", "100%")
									.attr("border", "0")
									.attr("cellspacing", "0")
									.attr("cellpadding", "2")
									.addClass("table2_list")
									.append(
											$("<colgroup/>")
															.append($("<col>").attr("width", "18%"))
															.append($("<col>"))
											);
			
		$mpiTrNode = $("<tr/>");
			
		$mpiTrNode.append(
							$("<td/>")
									.addClass("title2")
									.append("CPU Number")
							);
		$mpiTrNode.append(
							$("<td/>").append(
											$("<input/>")
														.attr("type","text")
														.attr("name","<portlet:namespace/>code_mpi_number")
														.attr("id","<portlet:namespace/>code_mpi_number")
														.addClass("preValueGroup")
														.css("margin-bottom", "0")
														.attr("onBlur", "codeMpiNumberCheck(this, '"+ defaultCpu +"', '"+ defaultCpu +"', '"+ maxCpu +"')") //수정 필요 mpi 갯수
														.css("width", "30")
														.val((typeof simulationJobData == "undefined") ? defaultCpu : simulationJobData["code_mpi_number"])
											)
									.append(" &nbsp;&nbsp;<font color=\"#7B7B7B\"> Scope : " + defaultCpu + " ~ " + maxCpu + "</font>")
							);					
		$("#runTypeDiv").append('<h4 class="subTitle">MPI Setting</h4>');
		$mpiTableNode.append($mpiTrNode);
		
		$("#runTypeDiv").append($mpiTableNode);
	//	$("#preprocessorDiv").append("<input type=\"button\" onclick=\"<portlet:namespace/>goPortPortlet('" + "edisoninputDeck_WAR_edisonappstore2016portlet" +"'," + 101 + "" + ")\" value=\"test\" >");
	}

 	
 	if(typeof portMapList != "undefined" && portMapList.length > 0) {
		$('#preprocessorDiv').append('<div id="inputport_div">');
		$('#preprocessorDiv').append('<h4 class="subTitle">Input port Setting</h4>');
		
		$inputPortTableNode = $("<table/>")
		.attr("width", "100%")
		.attr("border", "0")
		.attr("cellspacing", "0")
		.attr("cellpadding", "2")
		.addClass("table2_list")
		.append(
				$("<colgroup/>")
								.append($("<col>").attr("width", "18%"))
								.append($("<col>").attr("width", "18%"))
								.append($("<col>").attr("width", "18%"))
								.append($("<col>").attr("width", "18%"))
								.append($("<col>").attr("width", "18%"))
								.append($("<col>").attr("width", "10%"))
				).append(
				$("<thead/>")
								.append($("<tr/>").append($("<th/>").text(Liferay.Language.get("edison-simulation-execute-port-label-portname"))).append($("<th/>").text(Liferay.Language.get("edison-simulation-execute-port-label-mandatory"))).append($("<th/>").text(Liferay.Language.get("edison-simulation-execute-port-label-insertdata"))).append($("<th/>").text(Liferay.Language.get("edison-simulation-execute-port-label-status"))).append($("<th/>").text(Liferay.Language.get("edison-simulation-execute-port-label-dataview"))).append($("<th/>").text(Liferay.Language.get("edison-simulation-execute-port-label-sample"))))
				);
		
	 	for (var i = 0; i < portMapList.length; i++) {
			var portMap = portMapList[i][0];
			var portData = "";
			var portType = "";
			if(typeof simulationJobData != "undefined" && typeof simulationJobData[portMap.portName] != "undefined") {
				if(portMap.editorType == "Inputdeck") {
					if(simulationJobData[portMap.portName] != "") {
						portData = JSON.stringify(simulationJobData[portMap.portName]);
					}
				} else {
					portData = simulationJobData[portMap.portName];
				}
				portType = simulationJobData[portMap.portName + "_type"];
			}
			$inputPortTrNode = $("<tr/>");
			$inputPortTrNode.append($("<td/>").addClass("TC").append(portMap.portName));
			
			if(portMap.mandatory) {
				$inputPortTrNode.append($("<td/>").addClass("TC").append(Liferay.Language.get("edison-simulation-execute-port-true")));
			} else {
				$inputPortTrNode.append($("<td/>").addClass("TC").append(Liferay.Language.get("edison-simulation-execute-port-false")));
			}
			
			$inputPortTrNode.append($("<td/>").addClass("TC").append('<input type="button" id="<portlet:namespace/>' + portMap.portName + '_popup" value="' + Liferay.Language.get("edison-simulation-execute-port-label-insertdata") + '" class="button04" onClick=\'openEditorPopup(\"'+portMap.portName+'\")\' />'));
			
			if(portData == '""' || portData == '') {
				$inputPortTrNode.append($("<td/>").addClass("TC").append('<span id="<portlet:namespace/>' + portMap.portName + '_info" style="margin:0px 10px;">None</span>'));
				$inputPortTrNode.append($("<td/>").addClass("TC").append('<img id="<portlet:namespace/>' + portMap.portName + '_info_btn" src=\"${contextPath }/images/fileicon.png\" style=\"cursor:pointer;  display:none;\" onclick=\"popupDataInfo(\'' + portMap.portName + '\')" />'));
			} else {
				$inputPortTrNode.append($("<td/>").addClass("TC").append('<span id="<portlet:namespace/>' + portMap.portName + '_info" style="margin:0px 10px; color:green;">SUCCESS</span>'));
				$inputPortTrNode.append($("<td/>").addClass("TC").append('<img id="<portlet:namespace/>' + portMap.portName + '_info_btn" src=\"${contextPath }/images/fileicon.png\" style=\"cursor:pointer; \" onclick=\"popupDataInfo(\'' + portMap.portName + '\')" />'));
			}
				if(typeof portMap.sampleFilePath != "undefined" && portMap.sampleFilePath != 0) {
					$inputPortTrNode.append($("<td/>").addClass("TC").append('<img id="<portlet:namespace/>' + portMap.portName + '_info_btn" src=\"${contextPath }/images/fileicon2.png\" style=\"cursor:pointer; \" onclick=\"samplefileDown(\'' + portMap.sampleFilePath + '\')" />'));
				} else {
					$inputPortTrNode.append($("<td/>").addClass("TC"));
				}
			
			$inputPortTrNode.appendTo($inputPortTableNode);
			$('#preprocessorDiv').append('<input type="hidden" id="<portlet:namespace/>portName" value="' + portMap.portName + '" />');
			$('#preprocessorDiv').append('<input type="hidden" id="<portlet:namespace/>' + portMap.portName + '" value=\'' + portData + '\'' + ' data-portTypeId=\'' + portMap.port_type_id + '\' />');
			$('#preprocessorDiv').append('<input type="hidden" id="<portlet:namespace/>' + portMap.portName + '_type" value="' + portType + '" />');
			$('#preprocessorDiv').append('<input type="hidden" id="<portlet:namespace/>' + portMap.portName + '_file" value="" />');

		}
	 	$inputPortTableNode.appendTo($('#preprocessorDiv'));
	}
 	
 	
	$('#preprocessorDiv').append('</div>');
}

function popupDataInfo(id) {
	$('#<portlet:namespace/>jobparameter-dialog-content').empty();
	var type = $('#<portlet:namespace/>' + id + '_type').val();
	var content = $('#<portlet:namespace/>' + id).val();
	
	if(type == "Inputdeck") {
		content = JSON.parse(content);
		for (var i = 0; i < content.length; i++) {
			$('#<portlet:namespace/>jobparameter-dialog-content').append(content[i]["file-content"]);
		}
	} else if (type == "File") {
		content = JSON.parse(content);
		if(content["fileName"] == "SAMPLE") {
			$('#<portlet:namespace/>jobparameter-dialog-content').append("SAMPLE FILE");
		} else {
			$('#<portlet:namespace/>jobparameter-dialog-content').append("File Name : " + content["fileName"]);
		}
	} else {
		$('#<portlet:namespace/>jobparameter-dialog-content').append(id + " : " + content);
	}
	$("#<portlet:namespace/>jobparameter-dialog").dialog("open");
}

function samplefileDown(samplefilePath) {
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+samplefilePath;
}

function preProcessorCheck(){
	var returnValue = true;
	
	var inputPortJson = $("#<portlet:namespace/>inputPortJson").val();
	if(inputPortJson != "") {
		inputPortJson = JSON.parse(inputPortJson);
		var portNameList = Object.keys(inputPortJson);
		for (var i = 0; i < portNameList.length; i++) {
			var portName = portNameList[i];
			var mandatory = inputPortJson[portName]["mandatory"];
			if(mandatory == true) {
				var message = $('#<portlet:namespace/>' + portName).val();
				
				if(message == "") {
					returnValue = false;
					break;
				}
			}
		}
	}
	
	if(returnValue) {
		var isSubmit = $("#<portlet:namespace/>isSubmit").val();
		if(isSubmit == "false") {
			createJobForm();
		}
		return returnValue;
	} else {
		return returnValue;
	}
}	
	

function getServerFileList(cmd_directory, name, node){
	$.ajax({
		type: "POST",
   		url: "<%=getServerFileListURL%>",
   		
   		async : false,
   		dataType: 'json',
   		data  : {
   				"<portlet:namespace/>groupId":  $("#<portlet:namespace/>groupId").val(),
   				"<portlet:namespace/>cmd_directory": cmd_directory,
   				"<portlet:namespace/>cluster" : $("#<portlet:namespace/>cluster").val()
   				},
   		success: function(data) {
			$selectNode = $("<select/>").attr("name","<portlet:namespace/>"+name )
										.attr("id","<portlet:namespace/>"+name )
										.appendTo(node.find("td"));
			if(data.count.count!=0){
				for(var i = 0 ; i <data.count; i++){
	   				$selectNode.append($("<option/>").val(data.files[i].id).text(data.files[i].name));
	   			}
				
   				$selectNode.addClass("preValueGroup");
   				$selectNode.attr("onChange", "preProcessorCheck()");
   			}
   		},error:function(data,e){ 
   			alert("ServerFileList Search Error"); 
   			return false;
   		},complete:function(){

		}
    });       
}

function myFilePopup(responseFormId, responseFileName,simulationWorkflowType){
	$("#"+responseFormId).val("").change();
	$("#"+responseFileName).val("").change();
		
	var <portlet:namespace/>url = "${preprocessorPopupRenderURL}&${preprocessorPortletNamespace}returnId="+responseFormId+"&${preprocessorPortletNamespace}returnFileName="+responseFileName+"&${preprocessorPortletNamespace}cluster="+$("#<portlet:namespace/>cluster").val()+"&${preprocessorPortletNamespace}workflowType="+simulationWorkflowType;
	var <portlet:namespace/>width = 1000;
	var <portlet:namespace/>height = 800;
	var <portlet:namespace/>top = (screen.availHeight / 2) - (<portlet:namespace/>height / 2);
	var <portlet:namespace/>left = (screen.availWidth / 2) - (<portlet:namespace/>width / 2); 
	var <portlet:namespace/>popupWindowName = "myFilePopup";
	var <portlet:namespace/>popupOption = "directories=no, width="+<portlet:namespace/>width+", height="+<portlet:namespace/>height+", top="+<portlet:namespace/>top+", left="+<portlet:namespace/>left+", location=0, menubar=0, resizable=0, scrollbars=1, status=0, toolbar=0"

	var popup = window.open(<portlet:namespace/>url, <portlet:namespace/>popupWindowName, <portlet:namespace/>popupOption);
	
	popup.focus();
}


</script>

<aui:script>

function openEditorPopup(portName) {
	var portNum = -1;
	for (var i = 0; i < portMapList.length; i++) {
		if(portName == portMapList[i][0].portName) {
			var portNum = i;
			break;
		}
	}
	
	if(portNum != -1) {
		if(portMapList[portNum].length == 1) {
			if(portMapList[portNum][0].status == "1901003"){
				alert(Liferay.Language.get("edison-simulation-editor-closed"));
			}else {
				openEditorWindow(portMapList[portNum][0].exeFileName,
								 portMapList[portNum][0].title,
								 portMapList[portNum][0].port_type_id, 
								 portMapList[portNum][0].portName, 
								 portMapList[portNum][0].token, 
								 portMapList[portNum][0].plid,
								 portMapList[portNum][0].editorType,
								 portMapList[portNum][0].sampleFilePath);
			}
		} else {
			$dialogBody = $("#<portlet:namespace/>editor-dialog-content");
			
			for(var i=0; i< portMapList[portNum].length; i++){
				if(portMapList[portNum][i].status == "1901003") {
					$tr = $("<tr></tr>").appendTo($dialogBody);
					$("<td></td>").addClass("TC").css("cursor","pointer").text(portMapList[portNum][i].name).appendTo($tr)
								  .attr("onClick","event.cancelBubble=true;alert(Liferay.Language.get('edison-simulation-editor-closed'));");
				} else {
					$tr = $("<tr></tr>").appendTo($dialogBody);
					$("<td></td>").addClass("TC").css("cursor","pointer").text(portMapList[portNum][i].name).appendTo($tr)
								  .attr("onClick","event.cancelBubble=true;$('#<portlet:namespace/>editor-dialog').dialog('close');openEditorWindow('"+ portMapList[portNum][i].exeFileName +"', '"+ portMapList[portNum][i].title +"', '"+ portMapList[portNum][i].port_type_id +"', '"+ portMapList[portNum][i].portName +"', '" + portMapList[portNum][i].token +"', '"+ portMapList[portNum][i].plid +"' , '" + portMapList[portNum][i].editorType + "' , '" + portMapList[portNum][0].sampleFilePath + "');");
				}
			}
			
			$("#<portlet:namespace/>editor-dialog").dialog("open");
		}
	}
}


function openEditorWindow(portletId, portletTitle, taskId, portName, token, plid, editorType, sampleFilePath)
{
	var portType = $("#<portlet:namespace/>" + portName + "_type").val();
	var portData = $("#<portlet:namespace/>" + portName).val();
	var portTypeId = $("#<portlet:namespace/>" + portName).attr("data-portTypeId");
	
	AUI().use("liferay-portlet-url", function(a) {
	var renderURL = Liferay.PortletURL.createRenderURL();
	  	renderURL.setPortletId( portletId );
	  	renderURL.setPlid(plid);
  	renderURL.setParameter("taskId", editorType);
  	renderURL.setParameter("portTypeId", portTypeId);
  	renderURL.setParameter("portName", portName);
  	renderURL.setParameter("portletTitle", portletTitle);
  	renderURL.setParameter("token", token);
  	renderURL.setParameter("groupId", $("#<portlet:namespace/>groupId").val());
  	
  	if(editorType == "Inputdeck") {
	  	renderURL.setParameter("width", 900);
	  	renderURL.setParameter("height", 600);
	  	if(portType != "" && portType == editorType) {
		  	renderURL.setParameter("portData", (((portData == "" || typeof portData == "undefined") ? "" : JSON.stringify(JSON.parse(portData)[0]))));
	  	} else {
	  		renderURL.setParameter("portData", "");
	  	}
  	} else if (editorType == "File") {
  		if(sampleFilePath > 0) {
	  		renderURL.setParameter("useSampleFile", "Y");
  		} else {
	  		renderURL.setParameter("useSampleFile", "N");
  		}
	  	renderURL.setParameter("width", 900);
	  	renderURL.setParameter("height", 800);
  	} else {
	  	renderURL.setParameter("width", 400);
	  	renderURL.setParameter("height", 230);
	  	if(portType != "" && portType == editorType) {
		  	renderURL.setParameter("portData", ((typeof portData == "undefined") ? "" : portData));
	  	} else {
	  		renderURL.setParameter("portData", "");
	  	}
  	}
  	openWindow(renderURL);
	});
}

function openWindow(renderURL)
{
	var dialogId = 	renderURL.params.portName+Date.now();
					renderURL.setName("Popup");
				  	renderURL.setWindowState("pop_up"); 
				  	renderURL.setParameter("dialogId", dialogId);
				 	renderURL.setParameter("workflowType", "workflow");
	 	
	 	var url = renderURL.toString();
	Liferay.Util.openWindow({
		dialog: {
			cache: false,
          	destroyOnClose: true,
			after: {
				render: function(event) {
					$("button.btn.close").on("click", function(e){
						$("body").css('overflow','');
					});
				}
			},
			on: {
				close: function() {
					$("body").css('overflow','');
				}
			},  
			centered: true,
			modal: true,
			resizable: false,
			width:renderURL.params.width, 
			height:renderURL.params.height
		},
		id: dialogId ,
		title: renderURL.params.portletTitle,
		uri : url+ '&p_p_auth='+ renderURL.params.token,
		dialogIframe: {
			on: {
				load : function(evt) {
					$("body").css('overflow','hidden');
				}
			}
		}
	});
}

</aui:script>