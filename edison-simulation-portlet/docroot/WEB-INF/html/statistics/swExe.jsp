<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<script type="text/javascript" src="${contextPath}/js/chart/highcharts.js"></script>
<script type="text/javascript" src="${contextPath}/js/chart/modules/exporting.js"></script>

<liferay-portlet:renderURL var="statisticsViewURL" portletMode='view'></liferay-portlet:renderURL>
<liferay-portlet:resourceURL var="getStatisticsSwExeURL"		id="getStatisticsSwExe"	escapeXml="false" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="excelDownURL"		id="excelDown"	escapeXml="false" copyCurrentRenderParameters="false"/>

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
		
		<div class="tabletoptab">
	  		<input class="box01" type="text" id="<portlet:namespace/>startDt" name="<portlet:namespace/>startDt" readonly="readonly" value="${preDay}"/> 
				~	<input class="box01" type="text" id="<portlet:namespace/>endDt" name="<portlet:namespace/>endDt" readonly="readonly" value="${toDay}"/>
				
				<select name="<portlet:namespace/>scienceAppId" id="<portlet:namespace/>scienceAppId">
					<option value=""><liferay-ui:message key="full" /></option>
					<c:if test="${!empty scienceAppList}">
						<c:forEach var="model" items="${scienceAppList}">
							<option value="${model.scienceAppId}">${model.name}</option>
						</c:forEach>
					</c:if>
				</select>
		</div>
		
		<div class="search03" style="padding: 11px 10px 9px 780px;">
			<input type="button" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-search" />" class="button01" onclick="<portlet:namespace/>dataSearch();"/>
		</div>
	</form>
</div>


<div style="width:100%;margin-top:20px; ">
	<div id="container1" style="width: 55%; height: 350px; float: left;"></div>
	<div id="container2" style="width: 45%; height: 350px; float: right;"></div>
</div>

<div style="clear: both; width:100%;text-align:right; font-size: 14px; font-weight: bold;margin-bottom: 5px;">
	<div class="boardbtn2" style="float:right;">
<!-- 		<div class="boardbtnNormal" style="width:140px;"><a href="#" onClick="excelDown()">Excel Download</a></div>&nbsp;&nbsp; -->
		<input type="button" name="fullsize" id="fullsize" value="Excel Download" class="button02" onClick="excelDown()"/>
	</div>
</div>
<br> <br>
	
<div class="table1_list ">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="실행 현황 테이블">
		<colgroup>
			<col width="10%" />
			<col width="*" />
			<col width="20%" />
			<col width="10%" />
			<col width="7%" />
			<col width="7%" />
			<col width="10%" />
			<col width="7%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-index" /></th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-app-title"/></th>
				<th scope="col"><liferay-ui:message key="edison-create-account-field-title-university"/></th>
				<th scope="col"><liferay-ui:message key="edison-virtuallab-owner"/></th>
				<th scope="col"><liferay-ui:message key="edison-appstore-solver-version"/></th>
				<th scope="col"><liferay-ui:message key="edison-statistics-user-count"/></th>
				<th scope="col"><liferay-ui:message key="edison-simulation-monitoring-table-header-averate-running-time"/><br/>(sec)</th>
				<th scope="col"><liferay-ui:message key="edison-science-appstore-view-Execution-count"/></th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-date"/></
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>userTableBody">
		</tbody>
	</table>
</div>

<div style="clear: both; width:100%;text-align:right; font-size: 14px; font-weight: bold;margin-bottom:5px;">
	<div style="float:right;height:33px;padding-top: 7px;">Result : <span id="totalSpan"></span></div>
</div>

<script type="text/javascript">
//liferay-ui 탭 이벤트 return Script
function <portlet:namespace/>tagScript(tabUrl, tabNames, value, scriptName){	
	location.href="<%=statisticsViewURL%>&<portlet:namespace/>thisGroupId="+value;
}

function <portlet:namespace/>dataSearch(){
	var searchForm = $("form[name=<portlet:namespace/>statisticsForm]").serialize();
	jQuery.ajax({
		type: "POST",
		url: "<%=getStatisticsSwExeURL%>",
		data: searchForm,
		async : false,
		success: function(data) {
			setTable(data.tableOrganigationList);
			setPie(data.pieChartOrganigationList);
			setBar(data.barChartDateList);
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
				$("<td/>").addClass("TC").html(dataList.length-rownum).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(dataList[a].scienceApp_name).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(dataList[a].scienceApp_affiliation_name).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(dataList[a].mgtName).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(dataList[a].scienceApp_version).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(dataList[a].user_count).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(addComma(dataList[a].averageRuntime)).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(dataList[a].exe_count).appendTo($userTableTr);
				$("<td/>").addClass("TC").html(dataList[a].mgtDate).appendTo($userTableTr);
				
				$("#<portlet:namespace/>userTableBody").append($userTableTr);
				++rownum
			}//for 
		}//if(dataList.length > 0){
	}else{

		$("<tr/>").append(
							$("<td/>").attr("colspan","4").html('<liferay-ui:message key="edison-there-are-no-data" />')
						).appendTo($userTableBody);
	}
		
	$("#totalSpan").html("<b>"+rownum+" <liferay-ui:message key='edison-search-article'/></b>");
}

function setPie(pieChartOrganigationList){	
	//init
	while(chart1.series.length > 0)chart1.series[0].remove(true);
	
	if(pieChartOrganigationList != null){
	
		var seriesData = {
				type:"pie",
				name:'<liferay-ui:message key="percentage" />',
				data:[]
		}
		
		var pieData = [];		
		if(pieChartOrganigationList.length > 0){
			for(var c=0; c<pieChartOrganigationList.length; c++){			
				var title = pieChartOrganigationList[c].scienceApp_name;			
				var cnt = pieChartOrganigationList[c].exe_count;	
				pieData.push([title, cnt]);
			}//for
		}//if(pieChartOrganigationList.length > 0){				
		
		seriesData.data = pieData;
		chart1.addSeries(seriesData);
		chart1.redraw();	
	}
}

function setBar(barChartDateList){
	var searchForm = $("form[name=<portlet:namespace/>statisticsForm]").serialize();
	//init
	while(chart2.series.length > 0) chart2.series[0].remove(true);

	var newData=[];
	var xNameAxis = [];
		
	if(barChartDateList != null){
		for(var i=0;i<barChartDateList.length;i++){
			newData.push(barChartDateList[i].count);
			xNameAxis.push(barChartDateList[i].month);
		}
		chart2.xAxis[0].setCategories(xNameAxis);
		chart2.addSeries(
				{name:'<liferay-ui:message key="edison-science-appstore-view-Execution-count" />',data:newData}
				);
		
// 		$(chart2.yAxis[0].axisTitle.element).text('<liferay-ui:message key="edison-science-appstore-view-Execution-count" />');
		
		chart2.redraw();			
	}
}

function excelDown(){
	var url = "<%=excelDownURL%>"+"&"+$("form[name=<portlet:namespace/>statisticsForm]").serialize();
	window.location.href = spaceDelete(url);
}


	var chart1, chart2;
	
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
	
	
	
			chart1 = new Highcharts.Chart({
				chart: {
					renderTo: 'container1',
				type: 'pie'
				},
			title: {
				text: '<liferay-ui:message key="edison-appstore-search-sts"/>',
	            percentageDecimals: 1
			    },
			plotOptions: {
				pie: {
					allowPointSelect: true,
					cursor: 'pointer',
					dataLabels: {
						enabled: true,
						formatter: function() {
							return '<b>'+ cutStr(this.point.name,10) +'</b>: '+ this.point.y;
						},
						style: {
							fontWeight: 'bold',
							color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
						}
					}
				}
			},
			tooltip: {
				pointFormat: '{series.name}: <b>{point.percentage}%</b>',
				percentageDecimals: 1
			}
			});
	
			
			
			chart2 = new Highcharts.Chart({
			chart: {
				renderTo: 'container2',
				type: 'line'
				},
			title: {
				text: '<liferay-ui:message key="edison-appstore-month-sts"/>',
			    },
			yAxis: {
				min: 0,
				title: {
					text: '<liferay-ui:message key="edison-science-appstore-view-Execution-count" />',
				},
				labels: {
		                format: '{value}'
		        },
				stackLabels: {
					enabled: true,
						style: {
							fontWeight: 'bold',
							color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
					}
				}
			},
			legend: {
				align: 'right',
				x: -100,
				verticalAlign: 'top',
				y: 20,
				floating: true,
				backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid) || 'white',
				borderColor: '#CCC',
				borderWidth: 0,
				shadow: true
			},
			tooltip: {
				formatter: function() {
					return '<b>'+ this.x +'</b><br/>'+
					this.series.name +': '+ addComma(this.y);
				}
			},
			plotOptions: {
				column: {
				cursor: 'pointer',
				stacking: 'normal',
				dataLabels: {
					enabled: true,
					color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
					}
				}
			}
			});
	
			<portlet:namespace/>dataSearch();
	});


</script>  
  
  