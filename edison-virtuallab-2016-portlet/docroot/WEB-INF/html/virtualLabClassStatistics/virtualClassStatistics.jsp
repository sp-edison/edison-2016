<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<%
//Tab Setting
	String tabNames = (String)request.getAttribute("tabNames");
	String visitSite = CustomUtil.strNull(request.getAttribute("visitSite"), "test");
	String tabsValues = (String)request.getAttribute("tabsValues");
	String portletNameSpace = "_"+portletDisplay.getId()+"_"+"tagScript";
%>
<head>
<liferay-portlet:actionURL var="saveClickTabURL" portletMode="view" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="saveClickTabSatis"/>
</liferay-portlet:actionURL>

<liferay-portlet:resourceURL var="classStatisticsListURL" 	escapeXml="false"	 id="classStatisticsList"  copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="classStatisticsExcelDownLoadURL"		id="classStatisticsExcelDownLoad"	escapeXml="false" copyCurrentRenderParameters="false"/>
<script src="${contextPath}/js/jquery.blockUI.js"></script>
<script type="text/javascript">


AUI().ready(function() {
	<portlet:namespace/>dataSearchList();
	
	$("#<portlet:namespace/>jobStartDt").datepicker({
		showButtonPanel: true,
		showOn: 'button',
		dateFormat:"yy-mm-dd",
		changeMonth: true,
		changeYear: true,
		buttonImage: "${contextPath}/images/calendar.png",
		buttonImageOnly: true,
		onClose: function( selectedDate ) {
			$("#<portlet:namespace/>jobEndDt").datepicker("option", "minDate", selectedDate);
		}
		});

	$("#<portlet:namespace/>jobEndDt").datepicker({
		showButtonPanel: true,
		showOn: 'button',
		dateFormat:"yy-mm-dd",
		changeMonth: true,
		changeYear: true,
		buttonImage: "${contextPath}/images/calendar.png",
		buttonImageOnly: true,
		onClose: function( selectedDate ) {
			$("#<portlet:namespace/>jobStartDt").datepicker("option", "maxDate", selectedDate);
		}
	});

		$("img.ui-datepicker-trigger").attr("style", "margin-left:2px; vertical-align:middle; cursor: Pointer; width: 18px;");
});
function <portlet:namespace/>dataSearchList(pageNumber){
	bStart();
	if(pageNumber == 0) {
		$("#<portlet:namespace/>curPage").val(1);
	} else {
		$("#<portlet:namespace/>curPage").val(pageNumber);
	}
	
	var searchForm = $("form[name=<portlet:namespace/>statisticsForm]").serialize();
	
	$.ajax({
		type: "POST",
		url: "<%=classStatisticsListURL%>",
		async:true,
		data: searchForm,
		success:function(data){
			var statisticsList = data.dataList;
			var curPage = data.curPage;
			var selectLine = data.select_line;
			var totalCnt = data.totalCnt - ((curPage -1) * selectLine);
			var pageList = data.pageList;
			var $rowResult;
			$("#classStatisticsListBody tr:not(:has(#1))").remove();
			if(statisticsList.length != 0) {
				console.log(statisticsList);
				for(var i = 0; i < statisticsList.length; i++) {
					$rowResult = $("<tr/>");
					
					$("<td/>").text(totalCnt--).css("text-align","center").appendTo($rowResult);
					$("<td/>").text(statisticsList[i].university).css("text-align","center").appendTo($rowResult);
					$("<td/>").text(statisticsList[i].classTitle).css("text-align","center").appendTo($rowResult);
					$("<td/>").text(statisticsList[i].virtualLabPersonName).css("text-align","center").appendTo($rowResult);
					
					$("<td/>").html(statisticsList[i].scienceAppTitle).appendTo($rowResult);
					$("<td/>").text(statisticsList[i].registerStudentCnt).css("text-align","center").appendTo($rowResult);
					$("<td/>").text(statisticsList[i].executeStudentcount).css("text-align","center").appendTo($rowResult);
					
					
					$("<td/>").text(statisticsList[i].classId).css("text-align","center").appendTo($rowResult);
					$("<td/>").text(statisticsList[i].executeCount).css("text-align","center").appendTo($rowResult);
					$("<td/>").text(statisticsList[i].avgerageRuntime).css("text-align","center").appendTo($rowResult);
					$("#classStatisticsListBody").append($rowResult);
				} 
			}else if(statisticsList.length== 0){
				$rowResult = $("<tr/>");
				$("<td/>").text("<liferay-ui:message key='edison-class-statistics-no-status' />")
				  .css("text-align","center")
				  .attr("colSpan", "10")
				  .appendTo($rowResult);
				$("#classStatisticsListBody").append($rowResult);
			}	
			console.log(pageList)
			$("#pageListDiv").html(pageList);
		},complete: function(){
			bEnd();
		}
	});
}

function excelDown(){
	var form = $("form[name=<portlet:namespace/>statisticsForm]").serialize();
	var url = "<%=classStatisticsExcelDownLoadURL%>"+"&"+form;
	window.location.href = spaceDelete(url);
}

</script>
</head>
<body>
<div class="contabmenu"> 
	<edison-ui:tabs names="<%=tabNames%>" tabsValues="<%=tabsValues%>" value="<%=visitSite%>" refresh="<%=false%>" onClick="<%=portletNameSpace%>" minwidth="230"/>
</div>

<div class="table1_list" style="border-top: 0px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
		<tr>
			<td style="text-align: right;">
				<input type="button" name="fullsize" id="fullsize" value="Excel Download" class="button02" onClick="excelDown()"/>
			</td>
		</tr>
	</table>
</div>
<div class="tabletopbox clear">
	<form name="<portlet:namespace/>statisticsForm" method="post">
		<input type="hidden" name="<portlet:namespace/>visitSite" id="<portlet:namespace/>visitSite" value="<%=visitSite%>">
		<input id="<portlet:namespace/>curPage" name="<portlet:namespace/>curPage" type="hidden" value="1"/>
		
		<div id="data_wrap">
			<div class="tabletoptab">
		  		<input class="box01" type="text" id="<portlet:namespace/>jobStartDt" name="<portlet:namespace/>jobStartDt" readonly="readonly" value="${preDay}"/> 
					~	<input class="box01" type="text" id="<portlet:namespace/>jobEndDt" name="<portlet:namespace/>jobEndDt" readonly="readonly" value="${toDay}"/>
			</div>
			
			<div class="search03" style="padding: 11px 10px 9px 550px;">
	<%-- 			<input type="button" name="<portlet:namespace />fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-search" />" class="button01" onclick="<portlet:namespace/>dataSearchList();"> --%>
					<input type="button" name="<portlet:namespace />fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-search" />"  class="button01" onclick="<portlet:namespace/>dataSearchList(0);" />
			</div>
		</div>
		<div class="tabletopright">
			<select id="<portlet:namespace/>select_line" name="<portlet:namespace/>select_line" onChange="<portlet:namespace/>dataSearchList(0)" class="selectview">
				<option value="5">5<liferay-ui:message key='edison-search-views' /></option>
				<option value="10">10<liferay-ui:message key='edison-search-views' /></option>
				<option value="20">20<liferay-ui:message key='edison-search-views' /></option>
				<option value="40">40<liferay-ui:message key='edison-search-views' /></option>
			</select>
		</div>
	</form>
</div>
<div class="table1_list clear">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="8%" />
			<col width="10%" />
			<col width="15%" />
			<col width="10%" />
			<col width="20%" />
			<col width="8%" />
			<col width="8%" />
			<col width="8%" />
			<col width="8%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
			
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-create-account-field-title-university' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-virtualclass' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-professor' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-class-statistics-sw-data' /></th><!-- 활용SW -->
				<th align="center" scope="col"><liferay-ui:message key='edison-class-statistics-student-count' /></th><!-- 학생수 -->
				<th align="center" scope="col"><liferay-ui:message key='edison-class-statistics-execute-student-count' /></th><!-- 실행학생수 -->
				<th align="center" scope="col"><liferay-ui:message key='edison-class-statistics-class-code' /></th><!-- 수업코드 -->
				<th align="center" scope="col"><liferay-ui:message key='edison-science-appstore-view-Execution-count' /></th> <!-- 실행수 -->
				<th align="center" scope="col">CPU Time</th> <!-- CPU Time -->
			</tr>
		</thead>
		<tbody id="classStatisticsListBody">
		</tbody>
	</table>
</div>

<div id="pageListDiv" class="paging"></div>
<img id="loadingBox" src="${contextPath}/images/processing.gif" width="400" style="display: none;"/>

<script type="text/javascript">

//liferay-ui 탭 이벤트 return Script
function <portlet:namespace/>tagScript(tabUrl,tabNames,value,scriptName){
	window.location.href = "<%= saveClickTabURL.toString() %>&<portlet:namespace/>groupId=" + value;
}
</script>
</body>