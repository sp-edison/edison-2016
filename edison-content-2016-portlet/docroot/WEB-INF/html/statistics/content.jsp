<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<script type="text/javascript" src="${contextPath}/js/chart/highcharts.js"></script>
<script type="text/javascript" src="${contextPath}/js/chart/modules/exporting.js"></script>

<liferay-portlet:renderURL var="statisticsViewURL" portletMode='view'></liferay-portlet:renderURL>
<liferay-portlet:resourceURL var="saveClickTab" id="cickTab" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="getStatisticsContentURL"		id="getStatisticsContent"	escapeXml="false" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="retrieveGeneralURL" id="retrieveListGeneral" copyCurrentRenderParameters="false" escapeXml="false"/>
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
<style type="text/css">

</style>

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

<div style="width:100%;margin-top:20px; ">
	<div id="container1" style="width: 50%; height: 350px; float: left;"></div>
	<div id="container2" style="width: 50%; height: 350px; float: left;"></div>
</div>

<div style="clear: both;height:20px;"></div>

<div class="buttonbox">
		<input type="button" name="fullsize" id="fullsize" value="Excel Download" class="button02" onClick="<portlet:namespace/>excelDown()"> 
</div>

<div style="clear: both;height:20px;"></div>

<div class="tabletopbox clear">
	<div class="search03">
		<input type="button" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-all-search"/>" class="button01" onclick="<portlet:namespace/>dafaultContentAllSearch();">
	</div>
	<!--중앙탭-->
	<form name="<portlet:namespace/>statisticsForm" method="post">
		<input type="hidden" name="<portlet:namespace/>visitSite" id="<portlet:namespace/>visitSite" value="<%=visitSite%>">
	</form>
	
	<div class="tabletoptab">
  		<ul>
  			<li><img src="${contextPath}/images/content/tabletoptabbgL.png" /><a href="#boardicon01"><img src="${contextPath}/images/content/boardicon01off.png" />&nbsp;<liferay-ui:message key="edison-content-classnote"/><img src="${contextPath}/images/content/tabletoptabbgR.png" /></a></li>
  			<li><img src="${contextPath}/images/content/tabletoptabbgL.png" /><a href="#boardicon02"><img src="${contextPath}/images/content/boardicon02off.png" />&nbsp;<liferay-ui:message key="edison-content-manual"/><img src="${contextPath}/images/content/tabletoptabbgR.png" /></a></li>
  			<li><img src="${contextPath}/images/content/tabletoptabbgL.png" /><a href="#boardicon03"><img src="${contextPath}/images/content/boardicon03off.png" />&nbsp;<liferay-ui:message key="edison-content-reference"/><img src="${contextPath}/images/content/tabletoptabbgR.png" /></a></li>
  		</ul>
	</div>
	
	<!--우편 셀렉트-->
	<div class="tabletopright">
		<select id="<portlet:namespace/>select_line" name="<portlet:namespace/>select_line" title="옵션" onchange="<portlet:namespace/>generalContentSearch('','');" class="selectview">
			<option value="5">5<liferay-ui:message key="edison-search-views"/></option>
			<option value="10">10<liferay-ui:message key="edison-search-views"/></option>
			<option value="15">15<liferay-ui:message key="edison-search-views"/></option>
			<option value="20">20<liferay-ui:message key="edison-search-views"/></option>
		</select>
	</div>
</div>
<div class="table1_list borderno">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="일반콘텐츠 테이블">
		<colgroup>
			<col width="70" />
			<col width="70" />
			<col width="*" />
			<col width="100" />
			<col width="100" />
			<col width="100" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-index" /></th>
				<th scope="col">&nbsp;</th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-title"/></th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-name"/></th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-date"/></th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-views"/></th>
			</tr>
		</thead>
		<tbody id="generalTableBody">
		</tbody>
	</table>
</div>
<div class="paging">
	<div id="<portlet:namespace/>paging" style="width:100%;text-align: center;"></div>
</div>

<script type="text/javascript">
//선택한 Tab Id
var selectedTabId = "";

//liferay-ui 탭 이벤트 return Script
function <portlet:namespace/>tagScript(tabUrl,tabNames,value,scriptName){
	location.href="<%=statisticsViewURL%>&<portlet:namespace/>thisGroupId="+value;
}


AUI().ready(function() {
	$('#container1').highcharts({
		 chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false,
	            type: 'pie'
	        },
	        title: {
	            text: Liferay.Language.get('edison-advanced-content-search'),
	            percentageDecimals: 1
	        },
	        tooltip: {
	            pointFormat: '<b>{point.percentage:.1f}%</b>'
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
	                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                    }
	                }
	            }
	        }
	});
	
	$('#container2').highcharts({
		 chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false,
	            type: 'pie'
	        },
	        title: {
	            text: Liferay.Language.get('edison-content-search'),
	            percentageDecimals: 1
	        },
	        tooltip: {
	            pointFormat: '<b>{point.percentage:.1f}%</b>'
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
	                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                    }
	                }
	            }
	        }
	});
	
	<portlet:namespace/>dataSearch();
	<portlet:namespace/>generalContentSearch("","");
});

function <portlet:namespace/>dataSearch(){
	var searchForm = $("form[name=<portlet:namespace/>statisticsForm]").serialize();
	jQuery.ajax({
		type: "POST",
		url: "<%=getStatisticsContentURL%>",
		data: searchForm,
		dataType: 'json',
		async : false,
		success: function(data) {
			<portlet:namespace/>setPie(data.pieChartOrganigationList);
		},error:function(msg){
			alert("System Exception dataSearch: " + msg);
		}
	});
}

function <portlet:namespace/>setPie(dataList){
	var chart = $('#container1').highcharts();
	//init
	while(chart.series.length > 0)chart.series[0].remove(true);
	
	if(dataList != null){
		var seriesData = {
				colorByPoint: true,
				data:[]
		}
		
		var pieData = [];
		if(dataList.length > 0){
			for(var i=0; i<dataList.length; i++){
				var title = dataList[i].title;
				var cnt = dataList[i].viewCnt;
				pieData.push([title, cnt]);
			}
		}
		
		seriesData.data = pieData;
		chart.addSeries(seriesData);
		chart.redraw();
	}
}

function <portlet:namespace/>setPie2(dataList){
	var chart = $('#container2').highcharts();
	//init
	while(chart.series.length > 0)chart.series[0].remove(true);
	
	if(dataList != null){
		var seriesData = {
				colorByPoint: true,
				data:[]
		}
		
		var pieData = [];
		if(dataList.length > 0){
			for(var i=0; i<dataList.length; i++){
				var title = dataList[i].title;
				var cnt = dataList[i].downloadCnt;
				pieData.push([title, cnt]);
			}
		}
		
		seriesData.data = pieData;
		chart.addSeries(seriesData);
		chart.redraw();
	}
}

//일반 콘텐츠 조회
function <portlet:namespace/>generalContentSearch(searchDiv,p_currentPage){
	//분야별 tab ID 값
	var groupId = "";
	if(selectedTabId==""){
		if("<%=visitSite%>"==""){
			var tabsValues = "<%=tabsValues%>";
			var groupIdArray = tabsValues.split(",");
			groupId = groupIdArray[0];
		}else{
			selectedTabId = "<%=visitSite%>";
			groupId = selectedTabId;
		}
	}else{
		groupId = selectedTabId;
	}
	
	//자료구분 값
	if(searchDiv==""){
		searchDiv = $(".tabletoptab li.on>a").attr("href");
	}
	
	var searchDivCd = "";
	if (typeof searchDiv != 'undefined'){
		if(searchDiv=="#boardicon01"){
			searchDivCd = "2001001";
		}else if(searchDiv=="#boardicon02"){
			searchDivCd = "2001002";
		}else if(searchDiv=="#boardicon03"){
			searchDivCd = "2001003";
		}
	}
	
	//라인검색 값
	var searchLine = $("#<portlet:namespace/>select_line").val();
	
	var searchData = {
		"<portlet:namespace/>groupId":groupId,
		"<portlet:namespace/>contentDiv":searchDivCd,
		"<portlet:namespace/>searchLine":searchLine,
		"<portlet:namespace/>currentPage" : p_currentPage
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=retrieveGeneralURL%>",
		async : false,
		data  : searchData,
		dataType: 'json',
		success: function(data) {
			var dataSize = data.dataList.length;
			var dataMap = data.dataList;
			$generalTableBody = $("#generalTableBody");
			$generalTableBody.empty();
			$("#paging").empty();
			
			if(dataSize>0){
				for(var i = 0 ; i < dataSize; i++ ){
					$tr = $("<tr></tr>").appendTo($generalTableBody);
					if(i%2 == 1){
 						$tr.addClass("tablebgtr");
 					}
					$("<td></td>").addClass("TC").html(data.seq-i).appendTo($tr);
					var src = "";
					if(dataMap[i].contentDiv=="2001001"){
						src = "${contextPath}/images/content/boardicon01.png";
					}else if(dataMap[i].contentDiv=="2001002"){
						src = "${contextPath}/images/content/boardicon02.png";
					}else if(dataMap[i].contentDiv=="2001003"){
						src = "${contextPath}/images/content/boardicon03.png";
					}
					
					$("<td></td>").addClass("TC")
								  .append(
											$("<img/>").attr("src",src)
													   .attr("width","26")
													   .attr("height","25")
										).appendTo($tr);
					
					$titleTd = $("<td></td>").css("word-break","break-all").html(dataMap[i].title).appendTo($tr);
					$("<td></td>").addClass("TC").html(dataMap[i].insertNm).appendTo($tr);
					
					$("<td></td>").addClass("TC").html(dataMap[i].insertDate).appendTo($tr);
					
					$("<td></td>").addClass("TC").html(dataMap[i].downloadCnt).appendTo($tr);
				}
				
				<portlet:namespace/>setPie2(dataMap);
				
			}else{
				$tr = $("<tr></tr>").appendTo($generalTableBody);
				$("<td></td>").addClass("TC")
							  .text(Liferay.Language.get('edison-there-are-no-data'))
							  .attr("colspan","8")
							  .appendTo($tr);
			}
			
			$("#<portlet:namespace/>paging").html(data.paging);
		},error:function(data,e){ 
			alert("<portlet:namespace/>generalContentSearch ERROR=>"+e);	
		}
	});
}

//일반콘텐츠 중앙 탭 이벤트
$(function() {
	$(".tabletoptab li").click(function(){
		if(!$(this).hasClass('on')){
			var imagePath = "${contextPath}/images/content/";
			
			$preOnAtag = $(".tabletoptab li.on>a");
			
			if($preOnAtag.length > 0){
				$preOnAtag.find("img:first-child").attr("src",imagePath+$preOnAtag.attr("href").replace("#", "")+"off.png")
				$(".tabletoptab li").removeClass('on');
			}
			
			$postOnAtag = $(this).find("a");
			$postOnAtag.find("img:first-child").attr("src",imagePath+$postOnAtag.attr("href").replace("#", "")+".png")
			$(this).addClass('on');
			
			//일반 콘텐츠 조회
			<portlet:namespace/>generalContentSearch($postOnAtag.attr("href"),"");
		}
	});
});

//일반 콘텐츠 전체보기
function <portlet:namespace/>dafaultContentAllSearch(){
	$("#<portlet:namespace/>textfield").val("");
	//탭 초기화
	var imagePath = "${contextPath}/images/content/";
	$preOnAtag = $(".tabletoptab li.on>a");
	if($preOnAtag.length > 0){
		$preOnAtag.find("img:first-child").attr("src",imagePath+$preOnAtag.attr("href").replace("#", "")+"off.png")
		$(".tabletoptab li").removeClass('on');
	}
	
	<portlet:namespace/>generalContentSearch("","");
}

//일반 콘텐츠 페이징조회
function <portlet:namespace/>generalContentPageSearch(p_currentPage){
	<portlet:namespace/>generalContentSearch("",p_currentPage);
}

function <portlet:namespace/>excelDown(){
	var url = "<%=excelDownURL%>"+"&"+$("form[name=<portlet:namespace/>statisticsForm]").serialize();
	window.location.href = spaceDelete(url);
}
</script>
