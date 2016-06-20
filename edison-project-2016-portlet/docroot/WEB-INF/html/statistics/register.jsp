<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:resourceURL var="getStatisticsURL"		id="getStatistics"	escapeXml="false" copyCurrentRenderParameters="false"/>
<h1 class="h1">EDISON <liferay-ui:message key="edison-project-statistics-title"/></h1>


<script type="text/javascript" src="${contextPath}/js/chart/highcharts.js"></script>
<script type="text/javascript" src="${contextPath}/js/chart/modules/exporting.js"></script>

<liferay-portlet:runtime portletName="edisonmultitab_WAR_edisonboard2016portlet_INSTANCE_multitab" />

<div class="chartDiv">
	<div id="container1" style="width: 44%; height: 350px; float: left;"></div>
	<div id="container2" style="width: 44%; height: 350px; float: left;"></div>
</div>

<script type="text/javascript">
	
	AUI().ready(function() {

		$('#container1').highcharts({
			chart: {
				plotBackgroundColor: null,
				plotBorderWidth: null,
				plotShadow: false,
				type: 'pie'
			},
			title: {
				text: Liferay.Language.get("edison-project-site-scienceapp-register"),
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
				text: Liferay.Language.get("edison-project-site-content-register"),
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
		
	});
	
	function <portlet:namespace/>dataSearch(){
		jQuery.ajax({
			type: "POST",
			url: "<%=getStatisticsURL%>",
			async : false,
			success: function(data) {
				setPie(data.scienceAppCenterList, "container1");
				setPie(data.contentCenterList, "container2");
			},error:function(msg){
				alert("System Exception dataSearch: " + msg);
			}

		});
	}
	
	function setPie(statisticsList, chart){	
		
		/* var yearObj ={
			1:"first",
			2:"second",
			3:"third",
			4:"fourth",
			5:"fifth",
		} */
		var chart = $('#'+chart ).highcharts();
		//init
		while(chart.series.length > 0)chart1.series[0].remove(true);
		
		if(statisticsList != null){
			var seriesData = {
					type:"pie",
					name:'<liferay-ui:message key="percentage" />',
					data:[]
			}
			
			var pieData = [];
			if(statisticsList.length > 0){
				for(var c=0; c<statisticsList.length; c++){			
					var titleValue = statisticsList[c].propertyValue;
					
					var  title = titleValue;
					
					//Liferay.Language.get("edison-project-"+yearObj[titleValue]+"-year");
					
					var cnt = statisticsList[c].projectCnt;	
					pieData.push([title, cnt]);
				}//for
			}//if(pieChartOrganigationList.length > 0){				
			
			seriesData.data = pieData;
			
			chart.addSeries(seriesData);
			chart.redraw();	
			
			
		}
	}
</script>  
  
