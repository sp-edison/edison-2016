<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ include file="/common/science_platform_events.jspf" %>
<liferay-portlet:resourceURL var="searchConfigURL"		id="searchConfig"	escapeXml="false" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="searchListURL" 		id="searchList"		escapeXml="false" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getScienceAppURL" 		id="getScienceApp"		escapeXml="false" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getScienceAppDetailViewURL" escapeXml="false" id="getScienceAppDetailView" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getClickScienceAppURL" escapeXml="false" id="getClickScienceApp" copyCurrentRenderParameters="false"/>
<liferay-portlet:renderURL var="simulationListURL" portletMode='view'></liferay-portlet:renderURL>
<liferay-portlet:resourceURL var="simulationCreateURL" escapeXml="false" id="simulationCreate" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="simulationUpdateURL" escapeXml="false" id="simulationUpdate" copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="getListCustomScienceAppCommandOptionsURL" escapeXml="false" id="getListCustomScienceAppCommandOptions" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getServerFileListURL" escapeXml="false" id="getServerFileList" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getParameterScienceAppURL" escapeXml="false" id="getParameterScienceApp" copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="getChangeControlAssociate" id="getChangeControlAssociate" ><portlet:param name="id" value="getChangeControlAssociate"/></liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="getChangeControlAssign" id="getChangeControlAssign" ><portlet:param name="id" value="getChangeControlAssign"/></liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="createJobURL" escapeXml="false" id="createJob"/>
<liferay-portlet:resourceURL var="deleteJobURL" escapeXml="false" id="deleteJob"/>
<liferay-portlet:resourceURL var="submitJobURL" escapeXml="false" id="submitJob"/>
<liferay-portlet:resourceURL var="getListSubmitSimulationJobURL" escapeXml="false" id="getListSubmitSimulationJob"/>
<liferay-portlet:resourceURL var="saveClickTab" id="cickTab" copyCurrentRenderParameters="false" escapeXml="false"/>

<liferay-portlet:resourceURL var="getCountUserUseCoreURL" escapeXml="false" id="getCountUserUseCore"/>

<liferay-portlet:resourceURL var="monitoringSearchParam" escapeXml="false" id="searchJobParam" copyCurrentRenderParameters="false"/>
 
<liferay-portlet:resourceURL var="getRerunCommandParameterURL" escapeXml="false" id="getRerunCommandParameter" copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="myFileAddURL" id="myFileAdd" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="resorceConfigURL" 		escapeXml="false" id="searchConfig"  copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>

<script src="${contextPath}/js/jquery.blockUI.js"></script>
<% 
	//Tab Setting
	String tabNames = (String)request.getAttribute("tabNames");
	String visitSite = CustomUtil.strNull(request.getAttribute("visitSite"));
	String tabsValues = (String)request.getAttribute("tabsValues");
	String portletNameSpace = "_"+portletDisplay.getId()+"_"+"tagScript";
	
%>   
<style>
     
/*Workflow*/
	#accordion {
		border: solid 1px #000;
		border-bottom: 0px;
	}
	
	.ui-state-active .simultitleboxon {
		background: #e3eff9;
	}
	
	.ui-state-active .simulrighton {
		background: #f5fbfe;
	}
	
	.ui-state-active .simulicon .iconDiv {
		background: url(${contextPath}/images/btn_simulopen.png);
	}
	
	.simulheader {
		cursor:pointer;
	}
	
	.iconDiv {
		width:21px;
		height:14px;
		background:url(${contextPath}/images/btn_simulclose.png);
	}
	
	.simulcont {
		display:none;
		height:423px;
		overflow:auto;
	}
	
	.wrapContent {
		white-space:nowrap; text-overflow:ellipsis; -o-text-overflow: ellipsis; overflow:hidden; -moz-binding: url('ellipsis.xml#ellipsis');
	}
	
	.aui .control-group {
		margin-bottom:0px
	}
	
	.table2_list table input[type="text"] {
		margin-bottom:0px;
	}
	
	.ui-tooltip {
		background: white;
		font-weight: 600;
	}
	
	#accordion input[type="button"], .simulheader input[type="button"], .buttonbox input[type="button"] {
		font-weight: 600;
		font-size: 14px;
		line-height: normal;
	}
</style>
<script type="text/javascript">

var currentFrameNumber = 0;

var workflowStepState = new Array(false, false, false, false);

var preFormCount = 0;
var parameterFormCount = 0;

var slideTitle = new Array(
							'<liferay-ui:message key="edison-simulation-left-tab-label-1" />',
							'<liferay-ui:message key="edison-simulation-left-tab-label-2" />',
							'<liferay-ui:message key="edison-simulation-left-tab-label-3" />',
							'<liferay-ui:message key="edison-simulation-left-tab-label-4" />'
							);

var workflowButtonSpeed = 400;

//선택한 Tab Id
var selectedTabId = "";

//입력포트 객체
var portMapList;

//liferay-ui 탭 이벤트 return Script
function <portlet:namespace/>tagScript(tabUrl,tabNames,value,scriptName){
	var searchData = {"<portlet:namespace/>groupId":value};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=saveClickTab%>",
		async : false,
		data  : searchData,
		success: function(data) {
			location.href="<%=simulationListURL%>&<portlet:namespace/>thisGroupId="+value;
		},error:function(data,e){
			alert("tagScript ERROR-->"+e);
		}
	});
}
 
function simulationAllInit(){
	workflowStepState = new Array(false, false, false, false);
	
	simulationSelectInit();
	simulationInsertInit();
	simulationDataInsertInit();
	simulationJobCreateInit();
} 

function simulationSelectInit(){	
	$("#<portlet:namespace/>scienceAppId").val("");
	$("#<portlet:namespace/>scienceApp_name").val("");

	$("#<portlet:namespace/>isSubmit").val("false");
	$("#<portlet:namespace/>simulationUuid").val("");
	$("#<portlet:namespace/>cluster").val("");
	$("#<portlet:namespace/>exec_path").val("");
	$("#<portlet:namespace/>isCommandOption").val("false");

	$("#scienceAppListBody > tr > td").css("backgroundColor", "transparent");	
}
function simulationInsertInit(){


	$("#<portlet:namespace/>simulation_title").val("");
	$("#<portlet:namespace/>simulation_description").val("");
	
	$("#<portlet:namespace/>metaScienceApp_title").text("");
	$("#<portlet:namespace/>metaVersion").text("");
	$("#<portlet:namespace/>metaMgtDate").text("");
	$("#<portlet:namespace/>metaScienceApp_affilation").text("");
	$("#<portlet:namespace/>metaDeveloperNames").text("");
}
function simulationDataInsertInit(){

}
function simulationJobCreateInit(){

}

</script>

<%
	if((Boolean)request.getAttribute("isPortalMain")){
%>
<div class="contabmenu"> 
	<edison-ui:tabs 
		names="<%=tabNames%>" 
		tabsValues="<%=tabsValues%>" 
		value="<%=visitSite%>" 
		refresh="<%=false%>" 
		onClick="<%=portletNameSpace%>"
		minwidth="230"
	/>
</div> 
<%
	}
%>

<h1 id="<portlet:namespace/>simulation_subtitle">
	<liferay-ui:message key="edison-simulation-workflow" />
</h1>  
<!-- <div style="float:left; width:800px;height:55px;text-align: left; padding-left:45px;padding-bottom: 0px;"> -->
<%-- 	<img id="preButtonImage" src="${contextPath}/images/wfpre_btn.png" width="153" height="48" onClick="workflowerButtonClick(currentFrameNumber-1)" style="cursor: pointer;"  onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('preButtonImage','','${contextPath}/images/wfpre_btnon.png',1)"> --%>
<!-- </div> -->
 
<aui:form method="post" id="simulationForm" name="simulationForm">
	<aui:input type="hidden" name="scienceAppId"			id="scienceAppId"/>
	<aui:input type="hidden" name="scienceApp_name"			id="scienceApp_name"/>
	<aui:input type="hidden" name="exec_path"			id="exec_path"/>
	<aui:input type="hidden" name="isSubmit"		id="isSubmit" value="false"/>
	<aui:input type="hidden" name="simulationUuid"		id="simulationUuid"/>
	<aui:input type="hidden" name="cluster"				id="cluster"/>
	<aui:input type="hidden" name="curPage" 			id="curPage" value="1"				/>
	<aui:input type="hidden" name="groupId" 			id="groupId" value="<%=visitSite%>"	/>
	<aui:input type="hidden" name="isCommandOption"		id="isCommandOption"	value="false"/>
	<aui:input type="hidden" name="NOFILTERSEARCH_SCIENCEAPPSTORE"			id="NOFILTERSEARCH_SCIENCEAPPSTORE" value="Y"/>
	  
		<div id="accordion">	
			<div class="group">
				<div class="simulheader">
					<div class="simultitleboxon">
						<div class="simultitle">
							<liferay-ui:message key="edison-simulation-left-tab-label-1-accordion" />
						</div>
					</div>
					<div class="simulrighton">
<!-- 						<div class="btn_simul"> -->
<!-- 							<div class="buttonbox02"> -->
<!-- 								<input type="button" value="Category" onclick="$('#dialog-message').dialog('open');" class="button04"> -->
<!-- 							</div> -->
<!-- 						</div> -->
						<div class="simul_search search_class">
							<div class="searchbox">
								<input type="text" label="" id="<portlet:namespace/>searchValue" name="<portlet:namespace/>searchValue" value="${searchValue }" placeholder="SW or Organization or Name" size="25" maxlength="100" onKeydown="if(event.keyCode ==13)dataSearchList();"/>
								<a href="#" id="keyWordB" onClick="dataSearchList(1); return false;"><input type="button" class="btnsearch"></a>
							</div>
						</div>
						<div class="buttonbox02 search_class">
							<input type="button" name="fullsize" id="fullsize" value="All" onclick="searchListAll(1); return false;" class="button04">
						</div>
						<div class="simul00_name">
							<div id="workflowerButtonValue1" class="workflowerButtonValue" style="white-space:nowrap; text-overflow:ellipsis; -o-text-overflow: ellipsis; overflow:hidden; -moz-binding: url('ellipsis.xml#ellipsis');"></div>
						</div>
						<div class="simulicon"><div class="iconDiv" ></div></div>
					</div>
				</div>
				<div class="simulcont">
					<div class="contentWrap">
						<%@ include file="./simulation/simulationSelect.jsp" %>
					</div>
				</div>
			</div>
			
			<div class="group">
				<div class="simulheader">
					<div class="simultitleboxon">
						<div class="simultitle">
							<liferay-ui:message key="edison-simulation-left-tab-label-2-accordion" />
						</div>
					</div>
					<div class="simulrighton">
						<div class="simul02_name">
						</div>
						<div class="simulicon"><div class="iconDiv" ></div></div>
					</div>
				</div>
				<div class="simulcont">
					<div class="contentWrap">
						<%@ include file="./simulation/simulationCreate.jsp" %>
					</div>
				</div>
			</div>
			
			<div class="group">
				<div class="simulheader">
					<div class="simultitleboxon">
						<div class="simultitle">
							<liferay-ui:message key="edison-simulation-left-tab-label-3-accordion" />
						</div>
					</div>
					<div class="simulrighton">
						<div class="simul02_name">
						</div>
						<div class="simulicon"><div class="iconDiv" ></div></div>
					</div>
				</div>
				<div class="simulcont">
					<div class="contentWrap">
						<%@ include file="./simulation/simulationPreprocessor.jsp" %>
					</div>
				</div>
			</div>
			
			<div class="group">
				<div class="simulheader">
					<div class="simultitleboxon">
						<div class="simultitle">
							<liferay-ui:message key="edison-simulation-left-tab-label-6-accordion" />
						</div>
					</div>
					<div class="simulrighton">
						<div class="simul02_name">
						</div>
						<div class="simulicon"><div class="iconDiv" ></div></div>
					</div>
				</div>
				<div class="simulcont">
					<div class="contentWrap">
						<%@ include file="./simulation/simulationStatus.jsp" %>
					</div>
				</div>
			</div>
		</div> 
</aui:form>

<img id="loadingBox" src="${contextPath}/images/monitoring/processing.gif" width="400" style="display: none;"/>

<!-- <div style="float:right; height:55px;clear: both; padding-right: 30px;"> -->
<%-- 	<img id="newButtonImage"			src="${contextPath}/images/new_btn.png"			width="152" height="48"	onClick="simulationAllInit();workflowerButtonClick(1)"	style="cursor: pointer;"	onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('newButtonImage','','${contextPath}/images/new_btnon.png',1)">	 --%>
<%-- 	<img id="monitoringButtonImage"		src="${contextPath}/images/monitoring_btn.png"	width="152" height="48"	onClick="<portlet:namespace/>moveMonitoring()"			style="cursor: pointer;" 	onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('monitoringButtonImage','','${contextPath}/images/monitoring_btnon.png',1)">	 --%>
<%-- 	<img id="nextButtonImage"			src="${contextPath}/images/wfnext_btn.png"		width="153" height="48"	onClick="workflowerButtonClick(currentFrameNumber+1)"	style="cursor: pointer;"	onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('nextButtonImage','','${contextPath}/images/wfnext_btnon.png',1)"> --%>
<!-- </div> -->
	<div id="dialog-message" title="ScienceApp Filter" style="display:none; background:white; padding:0px;" class="newWindow">
		<form method="post" name="<portlet:namespace/>searchParamForm" style="margin:0px;">
			<div class="newWheader">
				<div class="newWtitlebox"><img src="${contextPath}/images/title_newWindow.png" width="34" height="34" />
				<div class="newWtitle">ScienceApp Filter(Category)</div></div>
				<div class="newWclose"><img id="<portlet:namespace/>dialog-message-close-btn" name="<portlet:namespace/>dialog-message-close-btn" src="${contextPath}/images/btn_closeWindow.png" width="21" height="21" style="cursor: pointer;" /></div>
			</div>
			
			<div class="newWcont01">
				<table border="0" cellspacing="0" cellpadding="0" id="configFilter" >
				</table>
				<div class="tbcell070301"></div>
				<div class="buttonbox" >
					<input type="button" value="<liferay-ui:message key="edison-button-search" />"  onclick="filterSearch();" class="button06"/>
					<input type="button" value="<liferay-ui:message key="edison-button-board-initialize" />"  onclick="filterInit();" class="button06"/>
				</div>
			</div>
			
		</form>
	</div>

<aui:script>
var simulationJobData;
var p_scienceAppId;
var testYn = "N";
function <portlet:namespace/>myFileAdd(p_fileEntryId,p_fileNm,p_optionNm,p_workflowType){
	var insertData = {
		"<portlet:namespace/>groupId":"<%=visitSite%>",
		"<portlet:namespace/>cluster":$("#<portlet:namespace/>cluster").val(),
		"<portlet:namespace/>fileEntryId":p_fileEntryId
	}
	
	$responseFormId = $("#<portlet:namespace/>"+p_optionNm);
	$responseFileName = $("#<portlet:namespace/>"+p_optionNm+"_logical_file_value");
	
	jQuery.ajax({
		type: "POST",
		url: "<%=myFileAddURL%>",
		async : false,
		data  : insertData,
		datatype:'json',
		success: function(val) {
			if(p_workflowType=="inputport"){
				$responseFormId.val(val.fileAPIId).change();
			}else{
				$responseFormId.val(val.filePath).change();
			}
			
			$responseFileName.val(p_fileNm).change();
		},error:function(data,e){
			alert("myFileAdd_ERROR==>"+e);
		}
	});
	
}


function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

	AUI().use('aui-base','liferay-form',function(A){
		var rules = {
			<portlet:namespace/>simulation_title: {
				required: true
			}
		};
		new A.FormValidator(
			{
				boundingBox: '#<portlet:namespace/>simulationForm',
				rules: rules,
				showAllMessages:true,
				validateOnInput: true,
				extractRules: true,
				validateOnBlur: true,
				selectText: true,
			}
		);
	});
	
	AUI().ready(function() {

		$("#<portlet:namespace/>dialog-message-close-btn").click(function() {
			$("#dialog-message").dialog("close");
		});
		
		$("#accordion").accordion({
			header : "> div > .simulheader",
			heightStyle: "content",
			animate: 200,
			beforeActivate: function( event, ui ) {
				var updownFlag = false;
				var targetFrameNumber = ui.newHeader.attr("id").substring(ui.newHeader.attr("id").length - 1, ui.newHeader.attr("id").length);
//				alert("target : " + targetFrameNumber + " current : " + currentFrameNumber);

				if(targetFrameNumber == currentFrameNumber){
					event.preventDefault();
					return;
				}
				if(workflowStepState[0] && workflowStepState[1] && targetFrameNumber == 3) {
					if(preProcessorCheck()) {
						workflowStepState[2] = true;
					} else {
						alert(slideTitle[2]);
						if(2 != currentFrameNumber) {
							$( "#accordion" ).accordion( "option", "active", 2);
						}
						event.preventDefault();
						return;
					}
				}
				
				if(targetFrameNumber > currentFrameNumber){//앞으로이동
					//입력포트나 파라미터에 입력대상이 없는 경우 skip
					for (var i = 0; i < targetFrameNumber; i++) {
						if(!workflowStepState[i]) {
							alert(slideTitle[i]);
							if(i != currentFrameNumber) {
								$( "#accordion" ).accordion( "option", "active", i);
							}
							event.preventDefault();
							return;
						}
					}
				}
				currentFrameNumber = targetFrameNumber;
// 				alert("target2 : " + targetFrameNumber + " current2 : " + currentFrameNumber);
//				$( "#accordion" ).accordion( "option", "active", targetFrameNumber);
			}
		});
		
		$("#accordion").accordion( "option", "icons", null ); 
		simulationAllInit(); 
		
		p_scienceAppId = "${directScienceAppId}";
		testYn = "${testYn}";
		
		if(p_scienceAppId != "" && testYn == "Y") {
			setScienceApp(p_scienceAppId);
			
			$("#scienceAppListBody tr").each(function( index, value ) {
				if($(this).attr("scienceappid") == p_scienceAppId) {
					scienceAppListClick(this);
 					$("#<portlet:namespace/>simulation_title").val("[Test] " + $(this).attr("scienceApp_name"));
					
					simulationTitleOnblur();
					simulationMetaInfoSet();
					preProcessorCheck();
					
					$("#accordion > .group:nth-child(1)").hide();
					$("#accordion > .group:nth-child(2)").hide();
					$("#<portlet:namespace/>simulation_subtitle").hide();
					$("#moveMonitoring").hide();
					workflowStepState[0] = true;
					$( "#accordion" ).accordion( "option", "active", 2);
 					return false;
				}
			});
			
		} else if(p_scienceAppId != ""){
			$("#<portlet:namespace/>searchValue").val("${directScienceApp_name}");
			
			setScienceApp(p_scienceAppId);
			simulationJobData = ${simulationJobData};
			
			$("#scienceAppListBody tr").each(function( index, value ) {
				if($(this).attr("scienceappid") == p_scienceAppId && Object.keys(simulationJobData).length > 0) {
					scienceAppListClick(this);
					$(".search_class").hide();
					
 					$("#<portlet:namespace/>simulation_title").val((simulationJobData["simulation_title"].toString().startsWith("[Rerun]")) ? simulationJobData["simulation_title"] : "[Rerun] " + simulationJobData["simulation_title"]);
					$("#<portlet:namespace/>simulation_description").val(simulationJobData["simulation_description"]);
					
					simulationTitleOnblur();
					simulationMetaInfoSet();
					preProcessorCheck();
					
					workflowStepState[0] = true;
					$( "#accordion" ).accordion( "option", "active", 3);
 					return false;
				} else if($(this).attr("scienceappid") == p_scienceAppId) {
					scienceAppListClick(this);
					$(".search_class").hide();
					
					$( "#accordion" ).accordion( "option", "active", 0);
				}
			});

		}
	});
	
	function setScienceApp(scienceAppId){
		var searchParam = {
			"<portlet:namespace/>scienceAppId" : scienceAppId
		}
		
		simulationAllInit();
		
		jQuery.ajax({
			type: "POST",
			url: "<%=getScienceAppURL%>",
			data: searchParam,
			async:false,
			success: function(msg) {
				var scienceApp = msg.scienceApp;
							
				var vRow, vCell;
				
				$("#scienceAppListBody tr:not(:has(#1))").remove();
				$vRow = $("<tr/>").attr("scienceAppId",scienceApp.scienceAppId)
									.attr("scienceApp_name",scienceApp.name)
									.attr("scienceAppTitle",scienceApp.currentTitle)
									.css("backgroundColor", "#bed8f5")
									.css("cursor", "pointer");
				
				$("<td/>").text(1)
				 			.addClass("TC")
							.appendTo($vRow);
				
				var vScienceAppIconId = 0;
				var vScienceAppImageSrc = "";
				vScienceAppIconId = scienceApp.iconId;
				
				if(typeof vScienceAppIconId != "undefined"){
					vScienceAppImageSrc = "/documents/"+scienceApp.iconRepositoryId+"/"+scienceApp.iconUuid; 
				} else {
					vScienceAppImageSrc = "${contextPath}/images/sc_appbox.jpg";
				}
				
				$("<td/>").append(
								$("<img/>").attr("src",vScienceAppImageSrc)
										   .attr("onerror","this.src='${contextPath}/images/sc_appbox.jpg'")
										   .css("width","33px")
										   .css("height","27px")
										   .attr("alt","Icon")
								).addClass("TC")
								.appendTo($vRow);

				$("<td/>").text(scienceApp.currentTitle + "(" + scienceApp.name+")")
							.addClass("TL")
							.addClass("wrapContent")
							.appendTo($vRow);

				
				$("<td/>").text(scienceApp.affiliation)
							.addClass("TC")
							.appendTo($vRow);

				$("<td/>").text(scienceApp.firstName)
						 	.addClass("TC")
							.appendTo($vRow);
				
				if(typeof scienceApp.manualId == "undefined"){
					$("<td/>").append(
							$("<img/>").attr("src","${contextPath}/images/btn_manual_none.jpg").css("cursor", "default")
							).addClass("TC").appendTo($vRow);
				} else {
					$("<td/>").append(
									$("<img/>").attr("src","${contextPath}/images/btn_manual.jpg")
											   .attr("onClick", "<portlet:namespace/>fileDownload('"+scienceApp.manualId+"')")
											   .css("cursor","pointer")
									).addClass("TC").appendTo($vRow);
				}
		
				$("<td/>").append(
						$("<img/>").attr("src","${contextPath}/images/btn_simuldetail.jpg")
								   .attr("onClick", "scienceAppDetailViewClick('"+scienceApp.scienceAppId+"')")
								   .css("cursor","pointer")
								   .hover(
										  function(){
										  	$(this).attr("src","${contextPath}/images/btn_simuldetail.jpg");
										  },
										  function(){
										  	$(this).attr("src","${contextPath}/images/btn_simuldetail.jpg");
										  }
										  )
						).addClass("TC").appendTo($vRow);
				
				
				$("#scienceAppListBody").append($vRow);
				document.getElementById("<portlet:namespace/>pageListDiv").innerHTML = "";
			},
			error:function(msg){
				alert("System Exception : " + msg);
			}
		});
	}
	
	function <portlet:namespace/>moveMonitoring() {
		AUI().use("liferay-portlet-url", function(a) {
			var portletURL = Liferay.PortletURL.createRenderURL();
			portletURL.setPlid("${monitoringPlid}"); 
			portletURL.setPortletId("edisonmonitoring_WAR_edisonsimulationportlet"); 
			window.location.href = portletURL.toString();
		});
	}
	
	function addScienceAppData(portName, data){
		$('#<portlet:namespace/>' + portName).val(JSON.stringify(data));
		if(typeof data != 'undefined' && data != "") {
			$('#<portlet:namespace/>' + portName + '_info').text("SUCCESS").css("color", "green");
		} else {
			$('#<portlet:namespace/>' + portName + '_info').text("FAIL").css("color", "red");
		}
		$('#<portlet:namespace/>' + portName + '_info_btn').show();
	}
	
	Liferay.on(
		'edison-simulation-test',
			function(event) {
				testYn = event.testYn;
				if(event.testYn == "Y" && event.scienceAppId != "") {
					var scienceAppId = event.scienceAppId;
					setScienceApp(scienceAppId);
					
					$("#scienceAppListBody tr").each(function( index, value ) {
						if($(this).attr("scienceappid") == scienceAppId) {
							scienceAppListClick(this);
		 					$("#<portlet:namespace/>simulation_title").val("[Test] " + $(this).attr("scienceApp_name"));
							
							simulationTitleOnblur();
							simulationMetaInfoSet();
							preProcessorCheck();
							
  							$("#accordion > .group:nth-child(1)").hide();
							$("#accordion > .group:nth-child(2)").hide();  
							$("#moveMonitoring").hide();
							workflowStepState[0] = true;
							$( "#accordion" ).accordion( "option", "active", 2);
		 					return false;
						}
					});

				}
			}
	);
	
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
					"stringPort",
					SciencePlatformEvents.TYPE_BROADCAST,
					'<portlet:namespace/>',
					'',
					content);
			
			Liferay.fire(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, payload);
	   	},
		['aui-base','liferay-util-window','aui-dialog-iframe-deprecated','liferay-util-window']
	);
		
	Liferay.provide(
		window,
		'closePopup',
	   	function(popupId) {
	       	var popupDialog = Liferay.Util.Window.getById(popupId);
            popupDialog.destroy();
            $("body").css('overflow','');
	   	},
		['aui-base','aui-dialog','aui-dialog-iframe','liferay-util-window']
	);
	
	Liferay.on(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, function(event){
		var json = event.getEventData();
		if(typeof json["value"] == "object") {
			$('#<portlet:namespace/>' + json["portName"]).val(JSON.stringify(json["value"]));
		} else {
			$('#<portlet:namespace/>' + json["portName"]).val(json["value"]);
		}
		$('#<portlet:namespace/>' + json["portName"] + "_type").val(json["taskId"]);
		
		if(typeof json["value"] != 'undefined' && json["value"] != "") {
			$('#<portlet:namespace/>' + json["portName"] + '_info').text("SUCCESS").css("color", "green");
		} else {
			$('#<portlet:namespace/>' + json["portName"] + '_info').text("FAIL").css("color", "red");
		}
		$('#<portlet:namespace/>' + json["portName"] + '_info_btn').show();
	});
</aui:script>
