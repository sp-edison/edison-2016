<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<h1 class="h1">EDISON <liferay-ui:message key="edison-project-statistics-title"/></h1>
<!--table-->
<liferay-portlet:runtime portletName="edisonmultitab_WAR_edisonboard2016portlet_INSTANCE_multitab" />

<script type="text/javascript" src="${contextPath}/js/chart/highcharts.js"></script>
<script type="text/javascript" src="${contextPath}/js/chart/modules/exporting.js"></script>
<div class="tablepr_list borderno">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="6%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2" scope="col"><liferay-ui:message key="edison-table-list-header-group"/></th>
				<th colspan="3" scope="col"><liferay-ui:message key="edison-project-first-year"/>&nbsp;<liferay-ui:message key="edison-project-year"/></th>
				<th colspan="3" scope="col"><liferay-ui:message key="edison-project-second-year"/>&nbsp;<liferay-ui:message key="edison-project-year"/></th> 
				<th colspan="3" scope="col"><liferay-ui:message key="edison-project-third-year"/>&nbsp;<liferay-ui:message key="edison-project-year"/></th> 
				<th colspan="3" scope="col"><liferay-ui:message key="edison-project-fourth-year"/>&nbsp;<liferay-ui:message key="edison-project-year"/></th> 
				<th colspan="3" scope="col"><liferay-ui:message key="edison-project-fifth-year"/>&nbsp;<liferay-ui:message key="edison-project-year"/>&nbsp;(<liferay-ui:message key="edison-virtuallab-tablerow-running"/>)</th> 
			</tr>
			<tr>
				<th scope="col"><liferay-ui:message key="edison-project-achievement-university"/></th>
				<th scope="col"><liferay-ui:message key="edison-project-achievement-subject"/></th>
				<th scope="col"><liferay-ui:message key="edison-project-achievement-student"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-university"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-subject"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-student"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-university"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-subject"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-student"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-university"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-subject"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-student"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-university"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-subject"/></th> 
				<th scope="col"><liferay-ui:message key="edison-project-achievement-student"/></th> 
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="name TC"><liferay-ui:message key="CFD"/></td>
				<td class="TC">28</td>
				<td class="TC" >57</td>
				<td class="TC">1,919</td>
				<td class="TC">34</td>
				<td class="TC">67</td>
				<td class="TC">2,078</td>
				<td class="TC">31</td>
				<td class="TC">66</td>
				<td class="TC">2,015</td>
				<td class="TC">26</td>
				<td class="TC">52</td>
				<td class="TC">1,769</td>
				<td class="TC">14</td>
				<td class="TC">26</td>
				<td class="TC">697</td>
			</tr>
			
			<tr class="bgcolor">
				<td class="name TC"><liferay-ui:message key="NANO"/></td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">14</td>
				<td class="TC">29</td>
				<td class="TC">1,301</td>
				<td class="TC">13</td>
				<td class="TC">51</td>
				<td class="TC">3,041</td>
				<td class="TC">18</td>
				<td class="TC">55</td>
				<td class="TC">2,684</td>
				<td class="TC">8</td>
				<td class="TC">30</td>
				<td class="TC">1,146</td>
			</tr>
			
			<tr>
				<td class="name TC"><liferay-ui:message key="CHEM"/></td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">17</td>
				<td class="TC">34</td>
				<td class="TC">4,305</td>
				<td class="TC">20</td>
				<td class="TC">167</td>
				<td class="TC">5,032</td>
				<td class="TC">20</td>
				<td class="TC">69</td>
				<td class="TC">3,242</td>
				<td class="TC">11</td>
				<td class="TC">53</td>
				<td class="TC">2,010</td>
			</tr>
			
			<tr class="bgcolor">
				<td class="name TC"><liferay-ui:message key="CSD"/></td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">7</td>
				<td class="TC">9</td>
				<td class="TC">389</td>
				<td class="TC">8</td>
				<td class="TC">9</td>
				<td class="TC">223</td>
			</tr>
			
			<tr class="bgcolor">
				<td class="name TC"><liferay-ui:message key="DESIGN"/></td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">-</td>
				<td class="TC">4</td>
				<td class="TC">5</td>
				<td class="TC">277</td>
				<td class="TC">3</td>
				<td class="TC">6</td>
				<td class="TC">170</td>
			</tr>
			
		</tbody>
	</table>
</div>
<!--챠트영역-->
<!--챠트영역-->
<div class="perfochartbox">
	<div id="container1" class="usesBarChartDiv"></div>
	<div id="container2" class="usesBarChartDiv"></div>
	<div id="container3" class="usesBarChartDiv"></div>
</div>

<script>
AUI().ready(function() {
$('#container1').highcharts({
		chart: {
			type: 'column',
			backgroundColor:'rgba(255, 255, 255, 0.1)'
		},
		title: {
			text: ''
		}, 
		xAxis: {
			categories: [
			             Liferay.Language.get("edison-project-first-year"),
			             Liferay.Language.get("edison-project-second-year"),
			             Liferay.Language.get("edison-project-third-year"),
			             Liferay.Language.get("edison-project-fourth-year"),
			             Liferay.Language.get("edison-project-fifth-year")],
			title: {
				text: Liferay.Language.get('edison-project-university-cumulative-count')
			}
		},
		yAxis: {
			min: 0,
			title: {
				text: ''
			},
			stackLabels: {
				enabled: false,
				style: {
					fontWeight: 'bold',
					color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
				}
			}
		},
		 legend: {
			 enabled : false
		}, 
		tooltip: {
			headerFormat: '<b>{point.x}</b><br/>',
			pointFormat: '{series.name}: {point.y}'
		},
		plotOptions: {
			column: {
				stacking: 'normal',
				dataLabels: {
					enabled: true,
					color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
					style: {
						textShadow: '0 0 3px black'
					}
				}
			},series: {
				dataLabels:{
					enabled:true,
					formatter:function(){
						if(this.y > 0)
						return this.y;
					}
				}
			}
		},
		series: [{
					name: Liferay.Language.get("DESIGN"),
					data: [0 ,0, 0, 4, 3],
					pointWidth: 45
				},{
					name: Liferay.Language.get("CSD"),
					data: [0, 0, 0, 7, 8],
					pointWidth: 45
				},{
					name: Liferay.Language.get("CHEM"),
					data: [0, 17, 20, 20, 11],
					pointWidth: 45
				},{
					name: Liferay.Language.get("NANO"),
					data: [0, 14, 51, 18, 8],
					pointWidth: 45
				} ,{
					name: Liferay.Language.get("CFD"),
					data: [28, 34, 31, 26, 14],
					pointWidth: 45
				}]
		});
	$('#container2').highcharts({
		chart: {
			type: 'column',
			backgroundColor:'rgba(255, 255, 255, 0.1)'
		},
		title: {
			text: ''
		}, 
		xAxis: {
			categories: [
			             Liferay.Language.get("edison-project-first-year"),
			             Liferay.Language.get("edison-project-second-year"),
			             Liferay.Language.get("edison-project-third-year"),
			             Liferay.Language.get("edison-project-fourth-year"),
			             Liferay.Language.get("edison-project-fifth-year")],
			title: {
				text: Liferay.Language.get('edison-project-subject-cumulative-count')
			}
		},
		yAxis: {
			min: 0,
			title: {
				text: ''
			},
			stackLabels: {
				enabled: false,
			}
		}, 
		 legend: {
			 enabled : false
		}, 
		tooltip: {
			headerFormat: '<b>{point.x}</b><br/>',
			pointFormat: '{series.name}: {point.y}'
		},
		plotOptions: {
			column: {
				stacking: 'normal',
				dataLabels: {
					enabled: true,
					color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
					style: {
						textShadow: '0 0 3px black'
					}
				}
			},series: {
				dataLabels:{
					enabled:true,
					formatter:function(){
						if(this.y > 0)
						return this.y;
					}
				}
			}
		},
		series: [{
			name: Liferay.Language.get("DESIGN"),
			data: [0 ,0, 0, 5, 6],
			pointWidth: 45
		},{
			name: Liferay.Language.get("CSD"),
			data: [0, 0, 0, 9, 9],
			pointWidth: 45
		},{
			name: Liferay.Language.get("CHEM"),
			data: [0, 34, 167, 69, 53],
			pointWidth: 45
		},{
			name: Liferay.Language.get("NANO"),
			data: [0, 29, 51, 55, 30],
			pointWidth: 45
		} ,{
			name: Liferay.Language.get("CFD"),
			data: [57, 67, 66, 52, 26],
			pointWidth: 45
		}]
	});
	$('#container3').highcharts({
		chart: {
			type: 'column',
			backgroundColor:'rgba(255, 255, 255, 0.1)'
		},
		title: {
			text: ''
		}, 
		xAxis: {
			categories: [
			             Liferay.Language.get("edison-project-first-year"),
			             Liferay.Language.get("edison-project-second-year"),
			             Liferay.Language.get("edison-project-third-year"),
			             Liferay.Language.get("edison-project-fourth-year"),
			             Liferay.Language.get("edison-project-fifth-year")],
			title: {
				text: Liferay.Language.get('edison-project-user-cumulative-count')
			}
		},
		yAxis: {
			min: 0,
			title: {
				text: ''
			},
			stackLabels: {
				enabled: false,
			}
		}, 
		 legend: {
			 enabled : false
		}, 
		tooltip: {
			headerFormat: '<b>{point.x}</b><br/>',
			pointFormat: '{series.name}: {point.y}'
		},
		plotOptions: {
			column: {
				stacking: 'normal',
				dataLabels: {
					enabled: true,
					color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
					style: {
						textShadow: '0 0 3px black'
					}
				}
			},series: {
				dataLabels:{
					enabled:true,
					formatter:function(){
						if(this.y > 0)
						return this.y;
					}
				}
			}
		},
		series: [{
				name: Liferay.Language.get("DESIGN"),
				data: [0 ,0, 0, 227, 170],
				pointWidth: 45
			},{
				name: Liferay.Language.get("CSD"),
				data: [0, 0, 0, 389, 223],
				pointWidth: 45
			},{
				name: Liferay.Language.get("CHEM"),
				data: [0, 4305, 5032, 3242, 2010],
				pointWidth: 45
			},{
				name: Liferay.Language.get("NANO"),
				data: [0, 1301, 3041, 2684, 1146],
				pointWidth: 45
			} ,{
				name: Liferay.Language.get("CFD"),
				data: [1919, 2078, 2015, 1769, 697],
				pointWidth: 45
			}]
		});
	});
</script>