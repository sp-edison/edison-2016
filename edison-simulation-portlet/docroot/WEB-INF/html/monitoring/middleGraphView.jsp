<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${contextPath}/css/postprocessor/post.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="${contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/postprocessor/middleGraph/middleGraph.js"></script>
<script type="text/javascript" src="${contextPath}/js/highcharts_NEW.js"></script>
<script type="text/javascript" src="${contextPath}/js/modules/exporting.js"></script>
<script type="text/javascript" src="${contextPath}/js/themes/gray.js"></script>

<%
	String selectedGroupId =CustomUtil.strNull(request.getAttribute("selectedGroupId"));
	String fileId =CustomUtil.strNull(request.getAttribute("fileId"));
	String jobUuid =CustomUtil.strNull(request.getAttribute("jobUuid"));
	
%>
<liferay-portlet:resourceURL var="middleFileDataURL" 		escapeXml="false" id="middleFileData" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="groupId" value="<%=selectedGroupId%>"/>
	<liferay-portlet:param name="fileId" value="<%=fileId%>"/>
	<liferay-portlet:param name="jobUuid" value="<%=jobUuid%>"/>
</liferay-portlet:resourceURL>

<style type="text/css">
@charset "utf-8";
/* CSS Document */
body {
	font-size:12px;
}

</style>

<script type="text/javascript">
/* theme type */
var theme = 'gray';

/* onedplot global variable */
var chart1;
var ani_mode;
var middleInterval;
var chartType;

$(window).load(function (){
	chartExecute("line");
});

$(window).unload(function (e){
	//alert("Chart dialog closing");
	clearInterval(middleInterval);
	chart1.destroy();
});


$(document).ready(function(){
	setIntervalFun(30);
	$("input:radio").change(function(){
		//alert("new interval: "+$(this).val());
		setIntervalFun($(this).val());
	});
});


function setIntervalFun(timeV){
	clearInterval(middleInterval);
	var time= Number(timeV);
	middleInterval = setInterval(function() 
			{
				chartExecute(chartType);
			}, 1000*time);
}

function setRefresh(){
// 	var oned_raw_data = fileLoadFunction();
	chartExecute(chartType);
}

function chartTypeChange(newType){
	chartType = newType;
	chartExecute(chartType);
}

function chartExecute(chartTypeDefine){
		/* initiolize animation mode to false */
		//alert("chart refreshed");
		ani_mode = false;
		////////////////////////////////////////////////////////////////////////////////
		/**
		* Highcharts plugin for setting a lower opacity for other series than the one that is hovered in the legend
		*/
		////////////////////////////////////////////////////////////////////////////////
		(function (Highcharts) {
	        var each = Highcharts.each;
	        
	        Highcharts.wrap(Highcharts.Legend.prototype, 'renderItem', function (proceed, item) {
	            proceed.call(this, item);
	            
	            var series = this.chart.series,
	                element = item.legendGroup.element;
	            
	            element.onmouseover = function () {
	               each(series, function (seriesItem) {
	                    if (seriesItem !== item) {
	                        each(['group', 'markerGroup'], function (group) {
				    if(ani_mode){
	                            	seriesItem[group].attr('opacity', 0.05);
					
					$("#series_name").remove();
					chart1.renderer.text(item.name, 200, 100).attr({
	    					id: 'series_name'
					}).css({
	    					fontSize: '16pt',
	    					color: 'white'
					}).add();

				    }
				    else {
	                            	seriesItem[group].attr('opacity', 1.0);
				   }
	                        });
	                    }
	                });
	            };
	            element.onmouseout = function () {
	               each(series, function (seriesItem) {
	                    if (seriesItem !== item) {
	                        each(['group', 'markerGroup'], function (group) {
	                            seriesItem[group].attr('opacity', 1);
	                        });
	                    }
	                });
	            };           
	        });
	    }(Highcharts));
		
		////////////////////////////////////////////////////////////////////////////////
		/* Initial Chart Options */
		////////////////////////////////////////////////////////////////////////////////
		var init_options = {
			chart: {
				renderTo:'container',
				type: (chartTypeDefine=='logarithmic'?'line':chartTypeDefine),
				marginRight: 150,
				marginBottom: 50,
				zoomType: 'xy',
				animation: {
					duration: 1000
				}
			},
			title: {
				text: 'ScienceApp Result',
				x: -20 //center
			},
			subtitle: {
				text: 'Job Title',
				x: -20
			},
			xAxis: {
				title: {
					enabled: true,
					text: 'X axis title'
				}
			},
			yAxis: {
				title: {
					text: 'Y axis title'
				},
				type: (chartTypeDefine=='logarithmic'?'logarithmic':''),
				plotLines: [{
					value: 0,
					width: 1,
					color: '#3d6fc2' //#808080
				}]
			},
			tooltip: {
				valueSuffix: ''
			},
			legend: {
				layout: 'vertical',
				align: 'right',
				verticalAlign: 'top',
				x: -10,
				y: 100,
				borderWidth: 0
			},
			plotOptions: {
				series: {
					turboThreshold : 10000
				}
			},
			series: [{
				name: '',
				data: []
			}],
			navigation: {
				buttonOptions: {
					enabled: true
				}
			}
		};
		
		
		////////////////////////////////////////////////////////////////////////////////
		/* Examples..  */
		////////////////////////////////////////////////////////////////////////////////

        var oned_raw_data = fileLoadFunction();
		var title = "${scienceAppNm}";
		var subtitle = "${jobTitle}";
		if(subtitle.length > 100) subtitle = subtitle.substring(0, 100) + "...";
			
		////////////////////////////////////////////////////////////////////////////////
		/* Setting Options..  */
		////////////////////////////////////////////////////////////////////////////////
		var options = getConOptions(oned_raw_data, title, subtitle, init_options);
		//if ( options == null )		$(window).close();
		////////////////////////////////////////////////////////////////////////////////
		/* Draw Chart..  */
		////////////////////////////////////////////////////////////////////////////////
		chart1 = new Highcharts.Chart(options);
		Highcharts.setOptions(theme);		
		
};


function fileLoadFunction(){
	var result = "";
	jQuery.ajax({
		type: "POST",
		url: "<%=middleFileDataURL%>",
		async : false,
		datatype:"text",
		success:function(data){
			result = data;
		},
		error:function(msg){
			alert("System Exception error fileLoadFunction: " + msg);
		}
	});
	
	
	return result;
}
</script>
</head>
<body> 
	<div id="postwrap">
	 	<div class="actions" style="float: left;">
			<input type="button" value="scatter" onClick="chartTypeChange('scatter')">
			<input type="button" value="line" onClick="chartTypeChange('line')">
			<input type="button" value="area" onClick="chartTypeChange('area')">
			<input type="button" value="spline" onClick="chartTypeChange('spline')">
			<input type="button" value="areaspline" onClick="chartTypeChange('areaspline')">
			<input type="button" value="logarithmic" onClick="chartTypeChange('logarithmic')">
		</div>
		<div class="time" style="float: right;">
			<input type="radio" name="timeChange" id="timeChange" value="15">15 sec
			<input type="radio" name="timeChange" id="timeChange" value="30" checked="checked">30 sec
			<input type="radio" name="timeChange" id="timeChange" value="60">60 sec
			<input type="radio" name="timeChange" id="timeChange" value="600">10 min
<!-- 			<select id="timeChange"> -->
<!-- 				<option value="30" selected="selected">30 sec</option> -->
<!-- 				<option value="15">15 sec</option> -->
<!-- 				<option value="30">30 sec</option> -->
<!-- 				<option value="60">60 sec</option> -->
<!-- 				<option value="600">10 min</option> -->
<!-- 			</select> -->
			<input type="button" value="refresh" onClick="setRefresh();">
		</div>
		<div style="height:5px"></div>
		<div id="container" style="min-width: 420px; height: 670px; margin: 0 auto"></div>
		<div id="clear"></div>
	</div>
</body>
</html>