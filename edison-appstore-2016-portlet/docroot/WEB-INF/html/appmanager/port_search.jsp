<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="org.kisti.edison.science.service.constants.ScienceAppConstants"%>

<liferay-portlet:resourceURL var="portTypeSearchURL" escapeXml="false" id="portTypeSearch" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="searchInputdeckFormURL" escapeXml="false" id="searchInputdeckForm" copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="portTypeEditorLinkSearchURL" escapeXml="false" id="portTypeEditorLinkSearch" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="portTypeAnalyzerLinkSearchURL" escapeXml="false" id="portTypeAnalyzerLinkSearch" copyCurrentRenderParameters="false"/>

<style type="text/css">
	#port-search-dialog .divLine{
		line-height: 2.0em;
	    width: 100%;
	    border-bottom: 2px solid #6a8ec6;
	    border-collapse: collapse;
	    font-size: 18px;
	}
	
	#port-search-dialog .inputPreview h4{
	    padding: 5px 0px;
	}
</style>
<div class="newWindow" style="background-color: #fff; overflow-x: hidden;overflow-y: hidden;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<c:choose>
					<c:when test="${portType eq 'INPUT' }">
						<liferay-ui:message key="edison-science-appstore-toolkit-input-port"/> 
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="edison-science-appstore-toolkit-out-port"/>
					</c:otherwise>
				</c:choose>
				<liferay-ui:message key="edison-table-list-header-select"/>
			</div>
		</div>
		<div class="newWclose">
			<img id="port-search-close-btn" name="port-search-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<div class="swpopleft">
		<div class="tablesw_list borderno">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<colgroup>
					<col width="100%" >
				</colgroup>
				<thead>
					<tr>
						<th scope="col" class="TL"><liferay-ui:message key="edison-table-list-header-port-Type-name"/></th>
					</tr>
				</thead>
				<tbody id="<portlet:namespace/>portTypeListBody">
				</tbody>
			</table>
		</div>
		<div id="pageListDiv" class="paging">
			
		</div>
	</div>
	
	<div class="swpopright">
	
		<div class="swtabtitle"><liferay-ui:message key="preview"/></div>
		
		<div class="swsearchbox">
			
			<input class="addIp button005_1" onclick="<portlet:namespace/>addPortType();" value="<liferay-ui:message key="edison-table-list-header-port-Type-add"/>" type="button">
			<div class="searchbox" style="float:right;">
				<input type="text" id="<portlet:namespace/>searchName" size="30" maxlength="30" onKeydown="if(event.keyCode ==13){<portlet:namespace/>searchPortTypeList(1);return false;}" autofocus="autofocus"/>
				<input type="button" id="keyWordB" onclick="<portlet:namespace/>searchPortTypeList(1);return false;"/>
			</div>
		</div>
		<div class="swrightcon" style="height: 450px;">
			<div id="<portlet:namespace/>sampleFilePreviewDiv" style="display: none;">
				<div class="divLine">
					<img src="${contextPath}/images/title_virtual.png" width="20" height="20" />
					SAMPLE FILE
				</div>
			
			</div>
			<div id="<portlet:namespace/>editorPreviewDiv" style="display: none;">
				<div class="divLine">
					<img src="${contextPath}/images/title_virtual.png" width="20" height="20" />
					EDITOR
				</div>
			</div>
			<div id="<portlet:namespace/>analyzerPreviewDiv" style="display: none;">
				<div class="divLine">
					<img src="${contextPath}/images/title_virtual.png" width="20" height="20" />
					ANALYZER
				</div>
			</div>
			<div id="<portlet:namespace/>variableDiv" style="display: none;">
				<div class="divLine">
					<img src="${contextPath}/images/title_virtual.png" width="20" height="20" />
					INPUTDECK
				</div>
				<div id="<portlet:namespace/>inputPreview" class="inputPreview">
					
				</div>
			</div>
		</div>
		<div class="swrightconbtnbox">
			<input class="addIp button08_2" onclick="<portlet:namespace/>portChoice('${portType}');" value="선택" type="button"/>
		</div>
	</div>
</div>

<script type="text/javascript" src="${contextPath}/js/editor/inputdeck/inputdeck_form.js"></script>
<script type="text/javascript" src="${contextPath}/js/editor/inputdeck/inputdeck_viewer.js"></script>
<script type="text/javascript">
AUI().ready(function() {
	$("#port-search-close-btn").click(function() {
		$("#port-search-dialog").dialog("close");
	});
	
	<portlet:namespace/>searchPortTypeList(1);
});

var portTypeId = "";
var portTypeName = "";
var defaultEditorId = "";
var inputDeckEditorExist = 0;
var defaultAnalyzerId = "";

function <portlet:namespace/>addPortType(){
	$("#port-search-dialog").dialog("close");
	<portlet:namespace/>portNameOpen('${scienceAppId}','${portType}','<%=Constants.ADD%>');
}

function <portlet:namespace/>searchPortTypeList(p_curPage){
	var searchForm = {
				"<portlet:namespace/>searchName": $("#<portlet:namespace/>searchName").val(),
				"<portlet:namespace/>p_curPage": p_curPage
				};
	jQuery.ajax({
		type: "POST",
		url: "<%=portTypeSearchURL%>",
		async : false,
		data  : searchForm,
		dataType: 'json',
		success: function(result) {
			$("#<portlet:namespace/>portTypeListBody tr:not(:has(#1))").remove();
			
			var length = result.dataList.length;
			if(length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").css("text-align","center")
						  .text(Liferay.Language.get('edison-there-are-no-data'))
						  .appendTo($rowResult);
				$("#<portlet:namespace/>portTypeListBody").append($rowResult);
				document.getElementById("pageListDiv").innerHTML="";
			}else{
				for(var i = 0; i < length; i++) {
					var data = result.dataList[i];
					
					$rowResult = $("<tr/>").addClass("bgcolor2").attr("id","portTypeTr_"+data.portTypeId);
					$("<td/>").text(data.name)
							  .css("cursor","pointer")
							  .attr("onClick",
									  "<portlet:namespace/>portTypeView('"+data.portTypeId+"','"+data.name+"','"+data.defaultEditorId+"','"+data.sampleFilePath+"','"+data.sampleTitle+"','"+data.inputdeckCnt+"','"+data.defaultAnalyzerId+"','"+data.editorCnt+"','"+data.analyzerCnt+"')")
							  .appendTo($rowResult);
					
					$("#<portlet:namespace/>portTypeListBody").append($rowResult);
				}
				document.getElementById("pageListDiv").innerHTML = result.pagingStr;
				
			}
		},error:function(data,e){ 
			alert(e);
		}
	});
}

function <portlet:namespace/>portTypeView(portTypeIdVal,portTypeNameVal,defaultEditorIdVal,sampleFileId,sampleTitle,inputdeckCnt,defaultAnalyzerIdVal,editorCnt,analyzerCnt){
	$("tr[class$=selected]").removeClass("selected");
	$portTypeTr = $("#portTypeTr_"+portTypeIdVal);
	$portTypeTr.addClass(" selected");
	
	portTypeId = portTypeIdVal;
	portTypeName = portTypeNameVal;
	defaultEditorId = defaultEditorIdVal;
	defaultAnalyzerId = defaultAnalyzerIdVal;
	inputDeckEditorExist = inputdeckCnt;
	
	
	
	//파일 초기화
	$("#<portlet:namespace/>sampleFilePreviewDiv").hide();
	$("#<portlet:namespace/>sampleFilePreviewDiv").find("div[class='down_date']").empty();
	
	//EDITOR
	$("#<portlet:namespace/>editorPreviewDiv").hide();
	$("#<portlet:namespace/>editorPreviewDiv").find("div[class='editor']").empty();
	
	//분석기
	$("#<portlet:namespace/>analyzerPreviewDiv").hide();
	$("#<portlet:namespace/>analyzerPreviewDiv").find("div[class='analyzer']").empty();
	
	//inputdeck view 초기화
	$("#<portlet:namespace/>variableDiv").hide();
	
	if(inputDeckEditorExist!=0){
		<portlet:namespace/>portTypeInputDeckDraw(portTypeIdVal);
	}
	
	if(sampleFileId!=0){
		<portlet:namespace/>portTypeSampleFileDraw(sampleFileId,sampleTitle);
	}
	//Editor 목록
	if(editorCnt!=0){
		<portlet:namespace/>portTypeEditorDraw(portTypeIdVal);
	}
	
	//Analyzer 목록
	if(analyzerCnt!=0){
		<portlet:namespace/>portTypeAnalyzerDraw(portTypeIdVal);
	}
	
	
}

function <portlet:namespace/>portTypeSampleFileDraw(sampleFileId,sampleTitle){
	$div = $("#<portlet:namespace/>sampleFilePreviewDiv");
	$div.show();
	$("<div/>").addClass("down_date").css("cursor","pointer").css("display","inline-block")
			   .css("text-decoration","underline").css("color","blue")
			   .attr("onclick","<portlet:namespace/>fileDownload('"+sampleFileId+"')")
			   .text(sampleTitle)
			   .appendTo($div);
}

function <portlet:namespace/>portTypeEditorDraw(portTypeIdVal){
	var searchForm = {
		"<portlet:namespace/>portTypeId": portTypeIdVal
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=portTypeEditorLinkSearchURL%>",
		async : false,
		data  : searchForm,
		dataType: 'json',
		success: function(result) {
			$parentDiv = $("#<portlet:namespace/>editorPreviewDiv");
			var length = result.dataList.length;
			if(length!=0){
				var text = "";
				for(var i=0;i<length;i++){
					var data = result.dataList[i];
					if(text==""){
						text+=data.name;
					}else{
						text+=","+data.name;
					}
				}
				$("<div/>").addClass("editor").html(text).appendTo($parentDiv);
				
				$parentDiv.show();
			}
		},error:function(jqXHR, textStatus, errorThrown){
			if(jqXHR.responseText !== ''){
				alert(textStatus+": "+jqXHR.responseText);
			}else{
				alert(textStatus+": "+errorThrown);
			}  
		}
	});
	
	
}

function <portlet:namespace/>portTypeAnalyzerDraw(portTypeIdVal){
	var searchForm = {
			"<portlet:namespace/>portTypeId": portTypeIdVal
		};
		
		jQuery.ajax({
			type: "POST",
			url: "<%=portTypeAnalyzerLinkSearchURL%>",
			async : false,
			data  : searchForm,
			dataType: 'json',
			success: function(result) {
				$parentDiv = $("#<portlet:namespace/>analyzerPreviewDiv");
				var length = result.dataList.length;
				if(length!=0){
					var text = "";
					for(var i=0;i<length;i++){
						var data = result.dataList[i];
						if(text==""){
							text+=data.name;
						}else{
							text+=","+data.name;
						}
					}
					$("<div/>").addClass("analyzer").html(text).appendTo($parentDiv);
					
					$parentDiv.show();
				}
			},error:function(jqXHR, textStatus, errorThrown){
				if(jqXHR.responseText !== ''){
					alert(textStatus+": "+jqXHR.responseText);
				}else{
					alert(textStatus+": "+errorThrown);
				}  
			}
		});
}

function <portlet:namespace/>portTypeInputDeckDraw(portTypeIdVal){
	$("#<portlet:namespace/>variableDiv").show();
	
	var searchForm = {
			"<portlet:namespace/>portTypeId": portTypeIdVal
		};
	jQuery.ajax({
		type: "POST",
		url: "<%=searchInputdeckFormURL%>",
		async : false,
		data  : searchForm,
		dataType: 'json',
		success: function(result) {
			var inputdeckPreForm = new InputdeckForm();
			inputdeckPreForm.setData(result);
			<portlet:namespace/>showInputDeckForm(inputdeckPreForm);
// 			Inputdeck = createInputDeckEditor(Inputdeck);
			
		},error:function(jqXHR, textStatus, errorThrown){
			if(jqXHR.responseText !== ''){
				alert(textStatus+": "+jqXHR.responseText);
			}else{
				alert(textStatus+": "+errorThrown);
			}  
		}
	});
}

function <portlet:namespace/>showInputDeckForm(inputdeckPreForm){
	$("#<portlet:namespace/>inputPreview ").html('');
	var preInputHtml = getInputDeckHtml(inputdeckPreForm);
	$("#<portlet:namespace/>inputPreview ").html(preInputHtml);
}

function <portlet:namespace/>portChoice(portType){
	if(portTypeId==""){
		alert(Liferay.Language.get('edison-science-appstore-toolkit-port-type-select-error-message'))
		return false;
	}
	
	var portMap = new PortMap();
	var port;
	if(portType == 'INPUT'){
		if(inputDeckEditorExist!=0){
			if(inputPortMap.isInputDeckPortType()){
				alert(Liferay.Language.get('edison-science-appstore-toolkit-port-type-select-inputport-error-message'))
				return false;
			}
		}
		
		port = portMap.createInputPort("${portName}");
		port.setDefaultEditorId(defaultEditorId);
		port.setPortTypeId(portTypeId);
		port.setPortTypeName(portTypeName);
		port.setMandatory(false);
		if(inputDeckEditorExist!=0){
			port.setInputDeckPortType(true);
		}else{
			port.setInputDeckPortType(false);
		}
		inputPortMap.addPort(port);
		
	}else{
		port = portMap.createOutputPort("${portName}");
		port.setDefaultAnalyzerId(defaultAnalyzerId);
		port.setPortTypeId(portTypeId);
 		port.setPortTypeName(portTypeName);
 		port.setMandatory(false);
 		port.setInputDeckPortType(false);
		outputPortMap.addPort(port);
	}
	
	<portlet:namespace/>drawPort(portType,'','');
	
}
</script>