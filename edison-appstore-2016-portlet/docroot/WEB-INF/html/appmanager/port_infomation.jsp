<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/common/init.jsp"%>


<portlet:actionURL var="submitURL" copyCurrentRenderParameters="<%=false%>" name="appAction">
	<portlet:param name="clickTab" value="${clickTab}"/>
	<portlet:param name="actionType" value="portInfomation"/>
	<portlet:param name="swTest" value="${swTest}"/>
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
	
	<portlet:param name="searchValue" value="${searchValue}"/>
	<portlet:param name="searchOption" value="${searchOption}"/>
	<portlet:param name="searchStatus" value="${searchStatus}"/>
	<portlet:param name="p_curPage" 	value="${p_curPage}" />
</portlet:actionURL>

<liferay-portlet:renderURL var="portNameAddURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="portNameAdd" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="portSearchURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="portSearch" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="portTypeEditorURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="portTypeEditor" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="portTypeAddURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="portTypeAddView" />
</liferay-portlet:renderURL>

<liferay-portlet:resourceURL var="deletePortSampleFileURL" escapeXml="false" id="deleteFile" copyCurrentRenderParameters="false">
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
</liferay-portlet:resourceURL>

<style type="text/css">
	.aui input[type="text"],
	.aui textarea{
		margin-bottom: 0px;
	}
	
	.aui .long_field{
		width: 350px;
	}
	
	.aui .short_field{
		width: 150px;
	}
	
	.aui .too_long_field{
		width: 500px;
	}
	
	.aui .text_field{
		width: 98%;
		resize: none;
	}
	
	.aui .swrightcont .alert{
		margin-top: 10px;
	}
</style>

<aui:form name="frm" method="POST" action="<%=submitURL%>">
	<aui:input name="inputPorts" type="hidden" value="" label=""/>
	<aui:input name="outputPorts" type="hidden" value="" label=""/>
	<aui:input name="actionMode" value="${mode}" type="hidden"/>
</aui:form>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		Command Line
	</div>
	<div style="width:60%; float:right; text-align:right; padding-top:15px;">
		<input class="addIp button02_2" onclick="<portlet:namespace/>goList();" value="<liferay-ui:message key='edison-button-board-list'/>" type="button">
		<c:if test="${appStatusButtonView}">
			<c:if test="${data.status eq '1901001'}">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901002');" value="<liferay-ui:message key='edison-appstore-status-request'/>" type="button">
			</c:if>
			<c:if test="${data.status eq '1901002' && isAdmin}">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901003');" value="<liferay-ui:message key='edison-appstore-status-private'/>" type="button">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901004');" value="<liferay-ui:message key='edison-appstore-status-service'/>" type="button">
			</c:if>
			<c:if test="${data.status eq '1901003'}">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901004');" value="<liferay-ui:message key='edison-appstore-status-service'/>" type="button">
			</c:if>
			<c:if test="${data.status eq '1901004'}">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901003');" value="<liferay-ui:message key='edison-appstore-status-private'/>" type="button">
			</c:if>
		</c:if>
		
		<c:if test="${data.status le 1901002}">
			<input class="addIp button02_1" onclick="<portlet:namespace/>actionCall('<%=Constants.ADD%>');return false;" value="<liferay-ui:message key='edison-button-save'/>" type="button">
		</c:if>
		
		<c:if test="${ownerThan}">
			<input class="addIp button02_1" onclick="<portlet:namespace/>actionCall('<%=Constants.DELETE%>');return false;" value="<liferay-ui:message key='delete'/>" type="button">
		</c:if>
	</div>
</div>
<div class="h10"></div>
<div style="margin:0 auto;text-align: center;">
	<textarea id="commandTextArea" disabled="disabled" class="text_field">
	
	</textarea>
</div>
<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" />
	<div class="virtitle">
		<liferay-ui:message key='edison-science-appstore-toolkit-input-port' />
	</div>
	<div style="margin: 0 auto;overflow: hidden;padding-top: 18px;padding-bottom: 5px;text-align: center;float: right;">
		<input class="button0801 noUpdateHidden" type="button" value="<liferay-ui:message key='edison-science-appstore-toolkit-input-port'/> <liferay-ui:message key='add'/>" onclick="<portlet:namespace/>portNameOpen('${scienceAppId}','INPUT','<%=Constants.SEARCH%>');">
	</div>
</div>
<div class="h10"></div>
<div class="table1_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="10%" />
			<col width="30%"/>
			<col width="*" />
			<col width="15%" />
			<col width="5%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-port-name' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-port-Type-name' /></th>
				<th align="center" scope="col"><liferay-ui:message key='InputDeck Port' /></th>
				<th align="center" scope="col"><liferay-ui:message key='required' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-button-board-delete' /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>inputPortListBody">
			
		</tbody>
	</table>
</div>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" />
	<div class="virtitle">
		<liferay-ui:message key='edison-science-appstore-toolkit-out-port' />
	</div>
	<div style="margin: 0 auto;overflow: hidden;padding-top: 18px;padding-bottom: 5px;text-align: center;float: right;">
		<input class="button0801 noUpdateHidden" type="button" value="<liferay-ui:message key='edison-science-appstore-toolkit-out-port'/> <liferay-ui:message key='add'/>" onclick="<portlet:namespace/>portNameOpen('${scienceAppId}','OUTPUT','<%=Constants.SEARCH%>');">
	</div>
</div>
<div class="h10"></div>
<div class="table1_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="10%" />
			<col width="*" />
			<col width="20%"/>
			<col width="15%" />
			<col width="10%" />
			<col width="5%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-port-name' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-port-Type-name' /></th>
				<th align="center" scope="col">Data Type</th>
				<th align="center" scope="col">File Name</th>
				<th align="center" scope="col"><liferay-ui:message key='required' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-button-board-delete' /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>outputPortListBody">
			
		</tbody>
	</table>
</div>

<div id="port-name-dialog" title="port-name" class="bigpopupbox" style="display: none;">
	
</div>

<div id="port-search-dialog" title="port-search" class="bigpopupbox" style="display: none;">

</div>

<div id="port-type-editor-dialog" title="port-type-editor" class="bigpopupbox" style="display: none;">

</div>

<div id="port-type-add-dialog" title="port-type-add" class="bigpopupbox" style="display: none;">
	
</div>

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>drawPort('INPUT','${data.inputPorts}','init');
	<portlet:namespace/>drawPort('OUTPUT','${data.outputPorts}','init');
	<portlet:namespace/>noUpdateDisabled('${data.status}');
});

	var inputPortMap = new PortMap();
	var outputPortMap = new PortMap();
	
	function <portlet:namespace/>portNameOpen(scienceAppId,portType,portMode){
		var renderParameter = "";
		renderParameter += "&<portlet:namespace/>scienceAppId="+scienceAppId;
		renderParameter += "&<portlet:namespace/>portType="+portType;
		renderParameter += "&<portlet:namespace/>portMode="+portMode;
		
		var URL = "<%=portNameAddURL%>"+renderParameter;
		
		$("#port-name-dialog").load(URL, function (e) {
			$("#port-name-dialog").dialog("open");
		});
	}
	
	function <portlet:namespace/>portAddOpen(scienceAppId,portType,portName){
		var renderParameter = "";
		renderParameter += "&<portlet:namespace/>scienceAppId="+scienceAppId;
		renderParameter += "&<portlet:namespace/>portType="+portType;
		renderParameter += "&<portlet:namespace/>portName="+portName;
		
		var URL = "<%=portSearchURL%>"+renderParameter;
		$("#port-search-dialog").load(URL, function (e) {
			$("#port-search-dialog").dialog("open");
		});
	}
	
	function <portlet:namespace/>portTypeEditorOpen(portType,portTypeName){
		var renderParameter = "";
		renderParameter += "&<portlet:namespace/>portType="+portType;
		renderParameter += "&<portlet:namespace/>portTypeName="+portTypeName;
		
		
		var URL = "<%=portTypeEditorURL%>"+renderParameter;
		$("#port-type-editor-dialog").load(URL, function (e) {
			$("#port-type-editor-dialog").dialog("open");
		});
	}
	
	function <portlet:namespace/>portTypeAddOpen(editor,defaultEditor,portTypeName,targetLanuage,inputDeckExist,analyzer,defaultAnalyzer,fileExist){
		var renderParameter = "";
		renderParameter += "&<portlet:namespace/>editor="+editor;
		renderParameter += "&<portlet:namespace/>defaultEditor="+defaultEditor;
		renderParameter += "&<portlet:namespace/>portTypeName="+portTypeName;
		renderParameter += "&<portlet:namespace/>targetLanuage="+targetLanuage;
		renderParameter += "&<portlet:namespace/>inputDeckExist="+inputDeckExist;
		renderParameter += "&<portlet:namespace/>analyzer="+analyzer;
		renderParameter += "&<portlet:namespace/>defaultAnalyzer="+defaultAnalyzer;
		renderParameter += "&<portlet:namespace/>fileExist="+fileExist;
		
		
		
		var URL = "<%=portTypeAddURL%>"+renderParameter;
		
		$("#port-type-add-dialog").load(URL, function (e) {
			$("#port-type-add-dialog").dialog("open");
		});
	}
	
	$("#port-name-dialog").dialog({
		autoOpen: false,
		width: 420,
		height: 'auto',
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
	    open: function(event, ui) {
	    	$(this).parent().css('overflow', 'visible');
	    	$(this).css('overflow', 'visible');
	    	$(this).removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    	
	    	$('.ui-widget-overlay').bind('click',function(){
	    		$("#port-name-dialog").dialog("close");
	    	})
	    },
	    close: function() {
	    	$("#port-name-dialog").empty();
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	
	$("#port-search-dialog").dialog({
		autoOpen: false,
		width: 1220,
		height: 'auto',
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
	    open: function(event, ui) {
	    	$(this).parent().css('overflow', 'visible');
	    	$(this).css('overflow', 'visible');
	    	$(this).removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    	
	    	$("body").css('overflow','hidden')
	    	
	    },
	    close: function() {
	    	$("#port-search-dialog").empty();
	    	$("body").css('overflow','');
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	$("#port-type-editor-dialog").dialog({
		autoOpen: false,
		width: 1220,
		height: 'auto',
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
	    open: function(event, ui) {
	    	$(this).parent().css('overflow', 'visible');
	    	$(this).css('overflow', 'visible');
	    	$(this).removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    	
	    	$('.ui-widget-overlay').bind('click',function(){
	    		$("#port-type-editor-dialog").dialog("close");
	    	})
	    },
	    close: function() {
	    	$("#port-type-editor-dialog").empty();
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	$("#port-type-add-dialog").dialog({
		autoOpen: false,
		width: 1220,
		height: 'auto',
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
	    open: function(event, ui) {
	    	$(this).parent().css('overflow', 'visible');
	    	$(this).css('overflow', 'visible');
	    	$(this).removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    },
	    close: function() {
	    	var sampleFilePath = $("#<portlet:namespace/>sampleFilePath").val();
	    	var sampleFileDelete = $("#<portlet:namespace/>sampleFileDelete").val();
	    	if(sampleFilePath!=""&&sampleFileDelete=="true"){
	    		<portlet:namespace/>closeDueDeletePortSampeFile(sampleFilePath)
	    	}
	    	$("#port-type-add-dialog").empty();
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	
	function <portlet:namespace/>closeDueDeletePortSampeFile(p_fileEntryId){
		var deleteForm = {
				"<portlet:namespace/>fileEntryId" : p_fileEntryId,
				"<portlet:namespace/>fileType" : "portType"
				};
		
		jQuery.ajax({
			type: "POST",
 			url: "<%=deletePortSampleFileURL%>",
			data: deleteForm,
	  		async : false,
			success: function(data) {
				
			},error:function(data,e){ 
				alert("deleteFile System error!");	
			}
		});
	}
	
	
	function <portlet:namespace/>drawPort(portType,data,init){
		$("#port-search-dialog").dialog("close");
		
		var draw = false;
		if(data!=''){
			if(portType=='INPUT'){
				inputPortMap.setData(JSON.parse(data),true);
				$("#<portlet:namespace/>inputPorts").val(JSON.stringify(inputPortMap));
			}else{
				outputPortMap.setData(JSON.parse(data),false);
				$("#<portlet:namespace/>outputPorts").val(JSON.stringify(outputPortMap));
			}
			draw = true;
		}else{
			if(init==''){
				if(portType=='INPUT'){
					$("#<portlet:namespace/>inputPorts").val("");
					$("#<portlet:namespace/>inputPorts").val(JSON.stringify(inputPortMap));
				}else{
					$("#<portlet:namespace/>outputPorts").val("");
					$("#<portlet:namespace/>outputPorts").val(JSON.stringify(outputPortMap));
				}
				draw = true;
			}else{
				var colspan = 0;
				//초기조회시
				if(portType=='INPUT'){
					$body = $("#<portlet:namespace/>inputPortListBody");
					colspan = 6;
				}else{
					$body = $("#<portlet:namespace/>outputPortListBody");
					colspan = 7;
				}
				
				$body.find("tr:not(:has(#1))").remove();
				
				$rowResult = $("<tr/>").appendTo($body);
				$("<td/>").text(Liferay.Language.get('edison-there-are-no-data')).attr("colspan",colspan).addClass("TC").appendTo($rowResult);
			}
		}
		
		if(draw){
			var $body;
			var array;
			var colspan = 0;
			if(portType=='INPUT'){
				$body = $("#<portlet:namespace/>inputPortListBody");
				array = inputPortMap.getPortArray();
				//Command Line 그리기
				$("#commandTextArea").empty();
				$("#commandTextArea").text("${data.exeFileName}");
				colspan = 6;
			}else{
				$body = $("#<portlet:namespace/>outputPortListBody");
				array = outputPortMap.getPortArray();
				colspan = 7;
			}
			$body.find("tr:not(:has(#1))").remove();
			
			if(array.length==0){
				$rowResult = $("<tr/>").appendTo($body);
				$("<td/>").text(Liferay.Language.get('edison-there-are-no-data')).attr("colspan",colspan).addClass("TC").appendTo($rowResult);
			}else{
				var outPutforms = PortConstants.getDefinedDataForms();
				for(var i=0; i<array.length;i++){
					$rowResult = $("<tr/>");
					var data = array[i];
					
					$("<td/>").css("text-align","center")
					 		  .text(i+1).appendTo($rowResult);
					
					$("<td/>").css("text-align","center")
					 		  .text(data[PortConstants.NAME]).appendTo($rowResult);
					
					$("<td/>").css("text-align","center")
					 		  .text(data[PortConstants.PORT_TYPE_NAME]).appendTo($rowResult);
					
					if(portType=='INPUT'){
						$("<td/>").css("text-align","center")
				 				  .text(data[PortConstants.INPUTDECKPORTTYPE]).appendTo($rowResult);
					}else{
						$select = $("<select/>").attr("onChange","<portlet:namespace/>changeOutputDataType('"+data[PortConstants.NAME]+"',this.value)")
												.attr("id","<portlet:namespace/>"+data[PortConstants.NAME]+"_dataType")
												.addClass("noupdate")
												.css("width","100px");
						
						for(var j=0; j<outPutforms.length;j++){
							$("<option/>").val(outPutforms[j]).html(outPutforms[j]).appendTo($select);
						}
						
						$select.find("option[value="+data[PortConstants.OUTPUT_FORM]+"]").attr("selected","selected");
						
						
						$("<td/>").css("text-align","center")
								  .append($select).appendTo($rowResult);
						
						$("<td/>").css("text-align","center")
								  .append(
										$("<input/>").attr("type","text")
													 .addClass("short_field outputFileName noupdate")
													 .attr("id","<portlet:namespace/>"+data[PortConstants.NAME]+"_fileName")
													 .attr("data_name",data[PortConstants.NAME])
													 .on("focusout",function(){
														 <portlet:namespace/>changeFileName($(this).attr("data_name"),$(this).val());
													 })
													 .val(data[PortConstants.FILE_NAME])
										  )
								  .appendTo($rowResult);
					}
					
					$select = $("<select/>").attr("onChange","<portlet:namespace/>changeMandatory('"+data[PortConstants.NAME]+"','"+portType+"',this.value)")
											 .addClass("noupdate")
											.css("width","60px");
					
					$("<option/>").val("N")
								 .html("N")
								 .appendTo($select);
					
					$("<option/>").val("Y")
								 .html("Y")
								 .appendTo($select);
					
					$("<td/>").append($select).appendTo($rowResult);
					
					$("<td/>").css("text-align","center")
							  .append(
									 $("<input/>").attr("type","button")
									 			  .addClass("graybtn noUpdateHidden")
									 			  .val(Liferay.Language.get('edison-button-board-delete'))
									 			  .attr("onClick","<portlet:namespace/>deleteMap('"+data[PortConstants.NAME]+"','"+portType+"')")
									  ).appendTo($rowResult);
					
					if(data.isMandatory()){
						$select.find("option[value=Y]").attr("selected","selected");
					}
					
					$body.append($rowResult);
					
					if(portType=='INPUT'){
						$('#commandTextArea').append(" "+data[PortConstants.NAME]+" "+data[PortConstants.PORT_TYPE_NAME]); 
					}
				}
			}
		}
	}
	
	function <portlet:namespace/>changeOutputDataType(name,value){
		outputPortMap.getPort(name).setOutputForm(value);
		var fileName = $("#<portlet:namespace/>"+name+"_fileName").val();
		if(fileName.trim!=""){
			outputPortMap.getPort(name).setFileName(fileName);
		}
		
		<portlet:namespace/>drawPort('OUTPUT','','');
	}
	
	function <portlet:namespace/>changeFileName(name,value){
		var dataType = $("#<portlet:namespace/>"+name+"_dataType option:selected").val();
		outputPortMap.getPort(name).setOutputForm(dataType);
		outputPortMap.getPort(name).setFileName(value);
		
		<portlet:namespace/>drawPort('OUTPUT','','');
	}
	
	function <portlet:namespace/>changeMandatory(name,portType,status){
		var manadatory = false;
		if(status=='Y'){
			manadatory = true;
		}
		if(portType=='INPUT'){
			inputPortMap.getPort(name).setMandatory(manadatory);
		}else{
			outputPortMap.getPort(name).setMandatory(manadatory);
		}
		
		<portlet:namespace/>drawPort(portType,'','');
	}
	
	function <portlet:namespace/>deleteMap(name,portType){
		if(confirm(Liferay.Language.get('data-delete-confirm'))){
			if(portType=='INPUT'){
				inputPortMap.removePort(name);
			}else{
				outputPortMap.removePort(name);
			}
			
			<portlet:namespace/>drawPort(portType,'','');
		}
	}
	
	function <portlet:namespace/>actionCall(mode){
		if(mode=='<%=Constants.DELETE%>'){
			if(confirm(Liferay.Language.get('edison-appstore-delete-data-alert'))){
				<portlet:namespace/>frm.<portlet:namespace/>actionMode.value = mode;
			}else{
				return false;
			}
		}
		
		var checkVal = true;
		$("input[class*=outputFileName][id$=fileName]").each(function(){
			var val = $(this).val();
			if(val.trim()==""){
				alert(Liferay.Language.get('this-field-is-mandatory'));
				$(this).focus();
				checkVal = false;
				return false;
			}
		})
		
		if(checkVal){
			submitForm(<portlet:namespace/>frm);
		}
		
	}
</script>

