<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="table2_list">
	<input type="hidden" name="<portlet:namespace/>scienceAppRunType"		id="<portlet:namespace/>scienceAppRunType"	/> <!-- MPI RunType -->
	<input type="hidden" name="<portlet:namespace/>scienceAppDefaultCpus"	id="<portlet:namespace/>scienceAppDefaultCpus"	/> <!-- MPI DefaultCpu -->
	<input type="hidden" name="<portlet:namespace/>scienceAppMaxCpus"	id="<portlet:namespace/>scienceAppMaxCpus"	/> <!-- MPI MaxCpu -->
	<input type="hidden" name="<portlet:namespace/>scienceAppParallelModule"		id="<portlet:namespace/>scienceAppParallelModule"	/> <!-- MPI Parallel Module -->
	<input type="hidden" name="<portlet:namespace/>scienceAppInputPorts"		id="<portlet:namespace/>scienceAppInputPorts"	/> <!-- MPI MaxCpu -->
	<input type="hidden" name="<portlet:namespace/>inputPortJson"		id="<portlet:namespace/>inputPortJson"	/>

	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout: fixed;">
			<tr>
				<td width="210" class="title1">&nbsp;</td>
				<td width="*"  class="title1 wrapContent"><span id="<portlet:namespace/>metaScienceApp_title"></span></td>
			</tr>
			<tr>
				<td class="TC img1">
					<div id="<portlet:namespace/>simulationCreateScreenshot"></div>
				</td>
				<td class="txt15no">
					<liferay-ui:message key="edison-table-list-header-version" /> : <span id="<portlet:namespace/>metaVersion"></span><br />
					<liferay-ui:message key="edison-table-list-header-date" /> : <span id="<portlet:namespace/>metaMgtDate"></span><br />
					<liferay-ui:message key="edison-table-list-header-orgNm" /> : <span id="<portlet:namespace/>metaScienceApp_affilation"></span><br />
					<liferay-ui:message key="developer" /> : <span id="<portlet:namespace/>metaDeveloperNames"></span></td>
				</td>
			</tr>
	</table>
</div>

<div class="h10"></div>
<div class="table3_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="180" class="title2"><liferay-ui:message key="edison-simulation-execute-simulation-name" /></td>
				<td class="titleInput">
					<aui:input type="text" label="" name="simulation_title" id="simulation_title" style="margin-bottom:0px; width:500px;" maxlength="100" />
				</td>
			</tr>
			<tr>
				<td class="title2"><liferay-ui:message key="edison-simulation-execute-simulation-description" /></td>
				<td class="titleInput"><aui:input type="textarea" name="simulation_description" label="" style="margin-bottom:0px; width:99%; resize:none;" rows="7"/></td>
			</tr>
	</table>    
</div>

<img id="loadingBox" src="${contextPath}/images/monitoring/processing.gif" width="400" style="display: none;"/>
 
<script type="text/javascript">

var clicky;
$(document).mousedown(function(e) {
	clicky = $(e.target).parent().attr("id");
});
	
$(document).on( "blur", "#<portlet:namespace/>simulation_title", function(event){
	simulationTitleOnblur();
});


function simulationTitleOnblur(){
	if($("#<portlet:namespace/>simulation_title").val() == ""){
		workflowStepState[1] = false;
	}else{
		workflowStepState[1] = true;
	}
	return workflowStepState[1];
}

function simulationMetaInfoSet(){

	var simulationCreateScreenshotHtml = "";
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getClickScienceAppURL%>",
		data: {	"<portlet:namespace/>scienceAppId": $("#<portlet:namespace/>scienceAppId").val(), "<portlet:namespace/>groupId":"<%=visitSite%>"	},
		async:false,
		success: function(data) {
			
			if(data.resultMsg == "SUCCESS"){
				var vScienceAppIconId = data.scienceAppMap.iconId;
				
				if(typeof vScienceAppIconId != "undefined"){
					simulationCreateScreenshotHtml = "<img src=\"" + spaceDelete("/documents/"+data.scienceAppMap.iconRepositoryId+"/"+data.scienceAppMap.iconUuid) + "\" style=\"width:158px;height:107px;\" onerror='this.src=\"${contextPath}/images/subapp_box2.jpg\"'>"; 
				} else {
					simulationCreateScreenshotHtml = "<img src=\"${contextPath}/images/subapp_box2.jpg\" style=\"width:158px;height:107px;\">";
				}
				
				$("#<portlet:namespace/>simulationCreateScreenshot").html(simulationCreateScreenshotHtml);
				$("#<portlet:namespace/>metaScienceApp_title").text(data.scienceAppMap.currentTitle);
				$("#<portlet:namespace/>metaVersion").text(data.scienceAppMap.version);
				$("#<portlet:namespace/>metaMgtDate").text(data.scienceAppMap.createDt);
				$("#<portlet:namespace/>metaScienceApp_affilation").text(data.scienceAppMap.affiliation);
				$("#<portlet:namespace/>metaDeveloperNames").text(data.scienceAppMap.developers);
				
				$("#<portlet:namespace/>scienceAppMaxCpus").val(data.scienceAppMap.maxCpus);
				$("#<portlet:namespace/>scienceAppDefaultCpus").val(data.scienceAppMap.defaultCpus);
				$("#<portlet:namespace/>scienceAppRunType").val(data.scienceAppMap.runType);
				$("#<portlet:namespace/>scienceAppParallelModule").val(data.scienceAppMap.parallelModule);
				$("#<portlet:namespace/>scienceAppInputPorts").val(data.portMapList);
				var inputport = data.inputPortJson;
				if(typeof inputport == "object") {
					$("#<portlet:namespace/>inputPortJson").val(JSON.stringify(inputport));
				} else {
					$("#<portlet:namespace/>inputPortJson").val(inputport);
				}
				workflowStepState[0] = true;
				portMapList = data.portMapList;
				preprocessorFormCreate(data.portMapList);
			}else{
				workflowStepState[0] = false;
				alert("simulationMetaInfoSet error");
			}
		},
		error:function(msg){
			console.log("simulationMetaInfoSet System Exception");
		}
	});
}
</script>
