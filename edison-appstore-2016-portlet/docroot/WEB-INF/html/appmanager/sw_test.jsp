<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<%@ page import="com.liferay.portal.model.Layout"%>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>


<liferay-portlet:resourceURL var="searchAppTestURL" escapeXml="false" id="searchAppTest" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="errorSimulationAPI" 		escapeXml="false" id="errorAPICall" copyCurrentRenderParameters="false"/>

<portlet:actionURL var="submitURL" copyCurrentRenderParameters="false" name="appAction">
	<portlet:param name="clickTab" value="${clickTab}"/>
	<portlet:param name="swTest" value="${swTest}"/>
	<portlet:param name="actionType" value="appInfomation"/>
	
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
	<portlet:param name="searchValue" value="${searchValue}"/>
	<portlet:param name="searchOption" value="${searchOption}"/>
	<portlet:param name="searchStatus" value="${searchStatus}"/>
	<portlet:param name="p_curPage" 	value="${p_curPage}" />
</portlet:actionURL>

<%
	Layout scienceApplayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(themeDisplay.getScopeGroupId(), false, "/simulation-excute");
	long requestPlid = scienceApplayout.getPlid(); 
	long groupId = themeDisplay.getScopeGroupId();
%>
<aui:form name="frm" method="POST" action="<%=submitURL%>">
		<aui:input name="actionMode" value="${mode}" type="hidden"/>
</aui:form>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key="edison-science-appstore-view-tab-app-test" />
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
		<c:if test="${!empty scienceAppId && ownerThan }">
<%-- 			<input class="addIp button02_3 disable" onclick="<portlet:namespace/>reRun();" value="<liferay-ui:message key='edison-science-appstore-toolkit-re-test-title'/>" type="button"> --%>
			<input class="addIp button02_1" onclick="<portlet:namespace/>actionCall('<%=Constants.DELETE%>');return false;" value="<liferay-ui:message key='delete'/>" type="button">
		</c:if>
	</div>
</div>
<div class="h10"></div>

<liferay-portlet:runtime portletName="edisonbestsimulation_WAR_edisonsimulationportlet" queryString="_edisonbestsimulation_WAR_edisonsimulationportlet_directScienceAppId=${scienceAppId}&_edisonbestsimulation_WAR_edisonsimulationportlet_testYn=Y"/>

<div class="h10" style="clear: both;"></div>
<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" />
	<div class="virtitle">
		<liferay-ui:message key='edison-science-appstore-toolkit-app-test-title' />
	</div>
</div>
<div class="h10"></div>
<div class="table1_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="10%" />
			<col width="*" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-date-time' /></th>
				<th align="center" scope="col"><liferay-ui:message key='total' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-simulation-monitoring-queued' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-simulation-monitoring-running' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-simulation-monitoring-success' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-simulation-monitoring-fail' /></th>
				<th align="center" scope="col">log</th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>appTestListBody">
		</tbody>
	</table>
	<div id="testPageListDiv" class="paging">
		
	</div>
</div>



<div id="<portlet:namespace/>error-dialog" style="display:none; background-color:white; padding:0px;" class="newWindow">
	<div class="newWheader" id="<portlet:namespace/>error-dialog-title" style="cursor: move;">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">Log</div>
		</div>
		<div class="newWclose" style="cursor: pointer;">
			<img id="<portlet:namespace/>error-dialog-close-btn" name="<portlet:namespace/>jobparameter-dialog-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21">
		</div>
	</div>
	<div id="<portlet:namespace/>error-dialog-content" style="padding: 30px;" class="newWcont01">
			
	</div>
</div>
<script type="text/javascript">
$(document).ready(function () {
	
	searchAppTest(1);
	
	if("${data.status}"=="1901001"){
		setInterval(function(){
			searchAppTest(1);
		},10*1000);
	}
	
	$("#<portlet:namespace/>error-dialog").dialog({
		autoOpen: false,
		width: '855',
		height: '580',
		modal: true,
		resizable: true,
		show: {effect:'fade', speed: 800}, 
		hide: {effect:'fade', speed: 800},
		draggable:true,
		open: function(event, ui) {
	    	$(this).removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    	$(this).parent().css('overflow','visible');
	    	
	    	$("body").css('overflow','hidden');
	    	$("#<portlet:namespace/>error-dialog-close-btn").bind('click',function(){
	    		$("#<portlet:namespace/>error-dialog").dialog("close");
	    	});
	    	
	    	$('.ui-widget-overlay').bind('click',function(){
	    		$("#<portlet:namespace/>error-dialog").dialog("close");
			})
	    },
	    close: function() {
	    	$("#<portlet:namespace/>error-dialog-content").empty();
	    	$("body").css('overflow','');
	    }
	}).draggable({
			handle: "#<portlet:namespace/>error-dialog-title"
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
});

function <portlet:namespace/>reRun(){
	Liferay.fire(
			'edison-simulation-test', {
			testYn: 'Y',
			scienceAppId : "${scienceAppId}"
	    }
	);
}

function searchAppTest(p_curPage){
	var searchForm = {
			"<portlet:namespace/>scienceAppId" : "${scienceAppId}",
			"<portlet:namespace/>p_curPage" : p_curPage
	};
	
	$("#<portlet:namespace/>appTestListBody tr:not(:has(#1))").remove();
	
	jQuery.ajax({
		type: "POST",
		url: "<%=searchAppTestURL%>",
		async : false,
		data  : searchForm,
		dataType: 'json',
		success: function(result) {
			$tbody = $("#<portlet:namespace/>appTestListBody");
			document.getElementById("testPageListDiv").innerHTML="";
			var length = result.dataList.length;
			
			if(length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").css("text-align","center")
						  .text(Liferay.Language.get('edison-there-are-no-data'))
						  .attr("colspan","8")
						  .appendTo($rowResult);
				$tbody.append($rowResult);
			}else{
				for(var i = 0; i < length; i++) {
					var data = result.dataList[i];
					
					$rowResult = $("<tr/>");
					
					if(i%2 == 1){
						$rowResult.addClass("tablebgtr");
 					}
					
					$("<td/>").addClass("TC").text(result.seq-i).appendTo($rowResult);
					$("<td/>").addClass("TC").text(data.simulationCreateDt).appendTo($rowResult);
					$("<td/>").addClass("TC").text(data.totalCnt).appendTo($rowResult);
					$("<td/>").addClass("TC").text(data.queuedCnt).appendTo($rowResult);
					$("<td/>").addClass("TC").text(data.runCnt).appendTo($rowResult);
					$("<td/>").addClass("TC").text(data.successCnt).appendTo($rowResult);
					$("<td/>").addClass("TC").text(data.failedCnt).appendTo($rowResult);
					$("<td/>").addClass("TC").append(
							$("<img/>").attr("src","${contextPath}/images/appmanager/btn_monitor_error.png")
									   .attr("width","22px")
									   .attr("height","22px")
									   .attr("onclick","<portlet:namespace/>error_event('"+data.jobUuid+"')")
// 									   .click(function(){<portlet:namespace/>error_event(data.jobUuid);})
									   .css("cursor","pointer")
											).appendTo($rowResult);
					$tbody.append($rowResult);
				}
				
				
				document.getElementById("testPageListDiv").innerHTML=result.page;
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

//결과보기 - 에러보기
function <portlet:namespace/>error_event(jobUuid){
	var searchData = {"<portlet:namespace/>jobUuid": jobUuid};
	jQuery.ajax({
		type: "POST",
		url: "<%=errorSimulationAPI%>",
		data  : searchData,
		datatype:"text",
		success:function(data){
			if ( data.length == 0 ){
				alert("<liferay-ui:message key='edison-simulation-monitoring-log-file-is-not-exist'/>");
				return;
			}
			
			$content = $("#<portlet:namespace/>error-dialog-content");
			data = data.replace(/'/g, "&apos;").replace(/"/g, "&quot;");
			$content.html(data);
			$("#<portlet:namespace/>error-dialog").dialog("open");
		},
		error:function(msg){
			alert("System Exception error error_event: " + msg);
		}
	});
}

function <portlet:namespace/>actionCall(mode){
	if(mode=='<%=Constants.DELETE%>'){
		if(confirm(Liferay.Language.get('edison-appstore-delete-data-alert'))){
			<portlet:namespace/>frm.<portlet:namespace/>actionMode.value = mode;
		}else{
			return false;
		}
	}
	
	document.<portlet:namespace/>frm.submit();
// 	submitForm(<portlet:namespace/>frm);
	
}
</script>