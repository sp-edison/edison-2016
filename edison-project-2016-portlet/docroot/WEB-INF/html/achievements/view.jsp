<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="getMajorAchievementURL"		id="getMajorAchievement"	escapeXml="false" copyCurrentRenderParameters="false"/>

<script type="text/javascript" src="${contextPath}/js/chart/highcharts.js"></script>
<script type="text/javascript" src="${contextPath}/js/chart/modules/exporting.js"></script>

<h1 class="perfoh1">EDISON <liferay-ui:message key="edison-project-achievemnet-title"/></h1>

<div>
	<img src="${contextPath }/images/output/intro_01.jpg" width="1221"
		height="744">
</div>

<h1 class="perfoh1">EDISON 프로젝트 주요 성과</h1>

<!--챠트영역-->
<div class="perfochartbox">
	<div id="container1" class="usesBarChartDiv"  onclick="<portlet:namespace/>pageMove('${usesPlid }')" style="cursor: pointer;"></div>
	<div id="container2" class="usesBarChartDiv"  onclick="<portlet:namespace/>pageMove('${usesPlid }')" style="cursor: pointer;"></div>
	<div id="container3" class="usesBarChartDiv"  onclick="<portlet:namespace/>pageMove('${usesPlid }')" style="cursor: pointer;"></div>
</div>


<div class="boxs">
	<ul id="<portlet:namespace/>boxList">
	</ul>
</div>

<script type="text/javascript">
$(function(){
	<portlet:namespace/>dataSearch();
});

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
			},
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

function <portlet:namespace/>dataSearch(){
	jQuery.ajax({
		type: "POST",
		url: "<%=getMajorAchievementURL%>",
		async : false,
		success: function(data) {
			var dataSize = data.dataList.length;
			var dataMap = data.dataList;
			
			
			$boxList = $("#<portlet:namespace/>boxList");
			if(dataSize>0){
				for(var i=0 ; i<dataSize; i++ ){
					$site = (dataMap[i].propertyValue).toLowerCase();
					$li = $("<li/>").addClass($site+"bg");
					
					console.log($li)
					
					/*로고*/
					$boxLogo = $("<div/>").addClass("boxlogo")
								.append($("<img/>").attr("src","${contextPath }/images/output/"+$site+"logo.png"))
								.append("<br/>")
								.append(dataMap[i].propertyValue);
					$li.append($boxLogo);
					
					/*head*/
					$boxInTable = $("<div/>").addClass("boxintable")
							.append($("<table/>").attr("id","<portlet:namespace/>siteTable_"+$site).attr("width","100%").attr("border", "0").attr("cellspacing", "0").css("margin-top", "30px")
							.append($("<tr/>").css("height", "43px")
// 								.append($("<td/>").attr("width", "25%").append("&nbsp;"))
								.append($("<td/>").attr("width", "29%").addClass("TC").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;APP"))
								.append($("<td/>").addClass("TC").append(
										$("<a/>").attr("href","javascript:void(0);").attr("onclick", "<portlet:namespace/>moveAppDetail('"+dataMap[i].appDetailPlid+"','"+dataMap[i].projectCategoryId+"')").css("color","#fff").append(dataMap[i].appCnt + dataMap[i].hisAppCnt)))
								
								)//thead end
							.append($("<tr/>")
								.append($("<td/>").attr("width", "41%").addClass("TR").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Content"))
								.append($("<td/>").addClass("TC").append(
										$("<a/>").attr("href","javascript:void(0);").attr("onclick", "<portlet:namespace/>moveContentDetail('"+dataMap[i].contentDetailPlid+"','"+dataMap[i].projectCategoryId+"')").css("color","#fff").append(dataMap[i].conCnt + dataMap[i].hisConCnt))))
							);

					
					$li.append($boxInTable);
					$li.appendTo($boxList);
					
					
				}
			}
		},error:function(msg){
			alert("System Exception dataSearch: " + msg);
		}

	});
}
</script>

<aui:script>
function <portlet:namespace/>moveAppDetail(appDetailPlid, categoryId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid(appDetailPlid);
		portletURL.setPortletId("edisonprojectapp_WAR_edisonproject2016portlet");
		portletURL.setParameter("categoryId", categoryId);
		window.location.href = portletURL.toString();
	});
}
function <portlet:namespace/>moveContentDetail(contentDetailPlid, categoryId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid(contentDetailPlid);
		portletURL.setPortletId("edisonprojectcontent_WAR_edisonproject2016portlet");
		portletURL.setParameter("categoryId", categoryId);
		window.location.href = portletURL.toString();
	});
}
function <portlet:namespace/>pageMove(usesPlid){
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid(usesPlid);
		portletURL.setPortletId("edisonprojectuses_WAR_edisonproject2016portlet");
		window.location.href = portletURL.toString();
	});
}
</aui:script>