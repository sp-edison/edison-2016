<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:renderURL var="statisticsViewURL" portletMode='view'></liferay-portlet:renderURL>
<liferay-portlet:resourceURL var="getStatisticsTimeURL"		id="getStatisticsTime"	escapeXml="false" copyCurrentRenderParameters="false"/>

<script type="text/javascript" src="${contextPath}/js/highcharts.js"></script>
<script type="text/javascript" src="${contextPath}/js/modules/exporting.js"></script>
<script type="text/javascript" src="${contextPath}/js/themes/gray.js"></script>

<% 
	//Tab Setting
	String tabNames = (String)request.getAttribute("tabNames");
	String visitSite = CustomUtil.strNull(request.getAttribute("visitSite"));
	String tabsValues = (String)request.getAttribute("tabsValues");
	String portletNameSpace = "_"+portletDisplay.getId()+"_"+"tagScript";
%>   
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

<div style="clear: both;height:20px;"></div>
<div class="tabletopbox clear">
		<form name="<portlet:namespace/>statisticsForm" method="post">
			<input type="hidden" name="<portlet:namespace/>status" id="<portlet:namespace/>status">
			<input type="hidden" name="<portlet:namespace/>visitSite" id="<portlet:namespace/>visitSite" value="<%=visitSite%>">
			
			<div id="data_wrap">
				<div class="tabletoptab">
						<div style="float: left;width: 100%">
								<input class="box01" type="text" id="<portlet:namespace/>startDt" name="<portlet:namespace/>startDt" readonly="readonly" value="${preDay}"/> 
								~	<input class="box01" type="text" id="<portlet:namespace/>endDt" name="<portlet:namespace/>endDt" readonly="readonly" value="${toDay}"/>
						</div>
				</div>
				<div class="search03" style="padding: 11px 10px 9px 780px;">
					<input type="button" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-search" />" class="button01" onclick="<portlet:namespace/>dataSearch();"/>
				</div>					
			</div>
		</form>
</div>

<div style="clear: both;height:20px;"></div>

<br> <br>
<div id="data_wrap" style="clear: both; ">
	<div id="userTable_wrap">
		<div class="table1_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<thead>
				<tr> 
					<th width="10%"><liferay-ui:message key="edison-table-list-header-index" /></th>
					<th width="20%"><liferay-ui:message key="edison-simulation-monitoring-table-header-averate-running-time" /></th>
					<th width="20%"><liferay-ui:message key="edison-simulation-monitoring-table-header-averate-standby-time" /></th>
					<th width="50%"></th>
				</tr> 
			</thead>
			<tbody id="<portlet:namespace/>userTableBody">
			</tbody>
		</table>
		</div>
	</div>
</div>

<div style="clear: both; width:100%;text-align:right; font-size: 14px; font-weight: bold;">
	<div style="float:right;height:33px;padding-top: 7px;">Result : <span id="totalSpan"></span></div>
</div>	
<br><br>

  
<script type="text/javascript">
//liferay-ui 탭 이벤트 return Script
function <portlet:namespace/>tagScript(tabUrl, tabNames, value, scriptName){	
	location.href="<%=statisticsViewURL%>&<portlet:namespace/>thisGroupId="+value;
}

function <portlet:namespace/>dataSearch(){
	var searchForm = $("form[name=<portlet:namespace/>statisticsForm]").serialize();
	jQuery.ajax({
		type: "POST",
		url: "<%=getStatisticsTimeURL%>",
		data: searchForm,
		async : false,
		success: function(data) {
			setTable(data.tableOrganigationList);
		},error:function(msg){
			alert("System Exception dataSearch: " + msg);
		}

	});
}


function setTable(dataList){
	
	$("#<portlet:namespace/>userTableBody tr:not(:has(#1))").remove();				
	
	if(dataList != null){
		var rownum = 0;
		if(dataList.length > 0){
			for(var a=0; a<dataList.length; a++){
				$userTableTr = $("<tr/>");
				$("<td/>").addClass("TC").html(++rownum).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(dataList[a].averageRuntime).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(dataList[a].averageStandbyTime).appendTo($userTableTr);
				$("<td/>").addClass("TC").html("").appendTo($userTableTr);
				
				$("#<portlet:namespace/>userTableBody").append($userTableTr);
				
			}//for 
		}//if(dataList.length > 0){
		
		$("#totalSpan").html("<b>"+rownum+" <liferay-ui:message key='edison-search-article'/></b>");
	}else{
		$("#totalSpan").html("<b>0 <liferay-ui:message key='edison-search-article'/></b>");
		$("<tr/>").append(
							$("<td/>").attr("colspan","4").html('<liferay-ui:message key="edison-there-are-no-data" />')
						).appendTo($userTableBody);
	}
}

function dtCheckBox(){
	if($("input:checkbox[name=dtCheck]").is(":checked")){
		$("#dt_wrap").hide();
	}else{
		$("#dt_wrap").show();
	}
}


	
	AUI().ready(function() {
		$("#<portlet:namespace/>startDt").datepicker({
			showButtonPanel: true,
			showOn: 'button',
			dateFormat:"yy-mm-dd",
			changeMonth: true,
			changeYear: true,
			buttonImage: "${contextPath}/images/calendar.png",
			buttonImageOnly: true,
			onClose: function( selectedDate ) {
				$("#<portlet:namespace/>endDt").datepicker("option", "minDate", selectedDate);
			}
			});
	
			$("#<portlet:namespace/>endDt").datepicker({
			showButtonPanel: true,
			showOn: 'button',
			dateFormat:"yy-mm-dd",
			changeMonth: true,
			changeYear: true,
			buttonImage: "${contextPath}/images/calendar.png",
			buttonImageOnly: true,
			onClose: function( selectedDate ) {
				$("#<portlet:namespace/>startDt").datepicker("option", "maxDate", selectedDate);
			}
			});
	
			$("img.ui-datepicker-trigger").attr("style", "margin-left:2px; vertical-align:middle; cursor: Pointer; width: 18px;");
	
			<portlet:namespace/>dataSearch();
	});


</script>  
  
  