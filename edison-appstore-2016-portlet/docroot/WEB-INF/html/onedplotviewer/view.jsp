<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<liferay-portlet:resourceURL var="getOneDplotDataURL" id="getOneDplotData" copyCurrentRenderParameters="false" escapeXml="false"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/editor/inputdeck/hashmap.js"></script>  
<portlet:defineObjects />
<style>
.actionBtns{
	width: 760px;
	height: 30px;
	text-align: center;
	padding-top: 5px;
	margin-bottom: 10px;
}

.button01b:hover 
{
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}

</style>
<script type="text/javascript">
//var rawDatas = [];
var <portlet:namespace/>rawDataMap = new HashMap();
var <portlet:namespace/>allNodeIds = [];
var <portlet:namespace/>allDatas = "";
$(function () {
	<portlet:namespace/>rawDataMap.clear();
	<portlet:namespace/>initJstree();
});

function <portlet:namespace/>initJstree()
{
	var dataList = <%=request.getAttribute("resultDataList")%>;
	var dataArr = [];
	for(var i=0 ; i< dataList.length ; i++ ){
		var obj = {
			"id": dataList[i].id,
			"text": dataList[i].name,
			"type":"file",
			"li_attr": {
				"childLength": 0
			}
		};
		dataArr.push(obj);
		<portlet:namespace/>allNodeIds.push(dataList[i].id);
		//<portlet:namespace/>rawDataMap.set( dataList[i].name, dataList[i].rawdata);
	}
	
	var rootData = [{
		"id":"ROOT",
		"text":"Result",
		"type":"open",
		"children": dataArr,
		"li_attr":{
			"childLength" : dataArr.length			
		}
	}];
	$("#<portlet:namespace/>analyzerFileList").jstree({
		"core" : {
			"data": rootData,
			"check_callback" : true,
	   	},
		"state" : "open",
	    "types" : {
	        "open" : {
	        	"icon" : "${contextPath}/images/fileselector/myfile-icon01.png"
	        },
	        "close" : {
	          	"icon" : "${contextPath}/images/fileselector/myfile-icon02.png"
	        },
	        "file" : {
	          	"icon" : "${contextPath}/images/fileselector/fileicon.png"
	        }
	    },
        "checkbox" : { 
        	 "keep_selected_style": false
        },
       "progressive_render" : true,
	   "plugins" : [ "contextmenu", "state", "dnd", "types","progressive_render" ,"hotkeys","checkbox"]
	}).bind("loaded.jstree", function(event, data) { 
		$("#<portlet:namespace/>analyzerFileList").jstree("open_all");
		$("#<portlet:namespace/>analyzerFileList").jstree("deselect_all");
	}).bind("changed.jstree", function(event, data) {
		if(typeof(data.node) != 'undefined')
        	chartExecute("line");	
		//if(typeof(data.node) != 'undefined' && data.node.id != "ROOT")
    });
}

var chart1;
var ani_mode;
var init_options;

function chartTypeChange(newType){
	chartExecute(newType);
}

function chartExecute(chartTypeDefine){
		ani_mode = false;
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
					chart1.renderer.text(item.name, 140, 95).attr({
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
	            }
	            element.onmouseout = function () {
	               each(series, function (seriesItem) {
	                    if (seriesItem !== item) {
	                        each(['group', 'markerGroup'], function (group) {
	                            seriesItem[group].attr('opacity', 1);
	                        });
	                    }
	                });
	            }           
	        });
	    }(Highcharts));
		
		init_options = {
			chart: {
				renderTo:'<portlet:namespace/>viewer',
				type: (chartTypeDefine=='logarithmic'?'line':chartTypeDefine),
				marginRight: 150,
				marginBottom: 50,
				zoomType: 'xy',
				animation: {
					duration: 1000
				}
			},
			title: {
				text: 'SOLVER Result',
				x: -20 //center
			},
			subtitle: {
				text: 'Job Title',
				x: -20
			},
			xAxis: {
				title: {
					enabled: true,
					text: 'X axis title',
					style:{"font-size": "1.5em"}
				}
			},
			yAxis: {
				title: {
					text: 'Y axis title',
					style:{"font-size": "1.5em"}
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
			},
			exporting: {
				buttons: {
					customButton: {
						menuItems: null,
						symbol: 'circle',
						onclick: function() {
							ani_mode = display_mode_change(ani_mode, '${contextPath}/images/imageviewer/kitty.gif');
						}
					}
				}
			}
		};
		
		<portlet:namespace/>getSelectedRawDatas();
};

function <portlet:namespace/>drawChart(oned_raw_data)
{
	if( 0 < oned_raw_data.length)
	{
		var options = getOptions(oned_raw_data, "", "", init_options);
		chart1 = new Highcharts.Chart(options);
	}
	else
		<portlet:namespace/>clearChart(chart1);
}

function <portlet:namespace/>getSelectedRawDatas()
{
	bStart();
	var resultData = "";
	//var fileIds = String($('#<portlet:namespace/>analyzerFileList').jstree(true).get_selected()).replace("ROOT","");
	var fileIds = $('#<portlet:namespace/>analyzerFileList').jstree(true).get_selected();
	//var searchFileIds;
	
	if( -1 < fileIds.indexOf("ROOT"))
	{
		var searchFileIds = [];
		var extraDatas = "";
		for(var i = 0; i<fileIds.length;i++)
		{
	 		var isExist = <portlet:namespace/>rawDataMap.has( String(fileIds[i]) );
			if(fileIds[i]!="ROOT" && !isExist)
			{
				searchFileIds.push(String(fileIds[i]));
			}
			else if(isExist)
				extraDatas += <portlet:namespace/>rawDataMap.has( String(fileIds[i]) );
		}
		$.ajax({
			type: "POST",
			url: "<%=getOneDplotDataURL%>",
			async : true,
			data  : {
				"<portlet:namespace/>fileIds": String(searchFileIds),
			},
			dataType : "text",
			success: function(data) {
				<portlet:namespace/>rawDataMap.set(fileIds[i] , String(data));
				<portlet:namespace/>setSelectedRawDatas(extraDatas);
			}
		});
	}
	else
	{
		for(var i = 0; i<fileIds.length;i++)
		{
			if( !<portlet:namespace/>rawDataMap.has( fileIds[i]) )
			{
				$.ajax({
					type: "POST",
					url: "<%=getOneDplotDataURL%>",
					async : true,
					data  : {
						"<portlet:namespace/>fileIds": String(fileIds[i]),
					},
					dataType : "text",
					success: function(data) {
						<portlet:namespace/>rawDataMap.set(fileIds[i] , String(data));
						<portlet:namespace/>setSelectedRawDatas("");
					}
				});
			}
		}
	}
	
	if(fileIds ==null || fileIds == "")
	{
		bEnd();
		<portlet:namespace/>clearChart(chart1);
	}
}

function <portlet:namespace/>setSelectedRawDatas(extraData)
{
	var resultData="";
	var datas = <portlet:namespace/>rawDataMap.values();
	for(var i = 0; i<datas.length;i++)
	{
		resultData += 	datas[i];
	}
 	<portlet:namespace/>drawChart(resultData+extraData);
	bEnd();
}

function <portlet:namespace/>clearChart(chart)
{
	while( chart.series.length > 0 ) {
	    chart.series[0].remove( false );
	}

	chart.redraw();
}

function bStart(){
	$.blockUI({ 
        message: $('#loadingBox'),
        css: { 
        	color: '#FFF',
            top:  ($(window).height() - 400) /2 + 'px', 
            left: (window.innerWidth - 700) /2 + 'px',  
//            left: '500px',
            width: '700px' 
        }, 
        onBlock: function() { 
        	$("body").css('overflow','hidden')
        } 
    });	
}

function bEnd(){	
	$.unblockUI({ 
		onUnblock: function(){$("body").css('overflow','');} 
	}); 
}

</script>
<div class="analyzerWrapper">
	<div class="analyzerFileList">
		<div id="<portlet:namespace/>analyzerFileList"  class="mflefttree">
		</div>
	</div>
	<div class="analyzerContent" style="padding:5px;">
		<div class="actionBtns">
			<input style="width:106px;margin:0 5px;" class="addIp button01b" type="button" value="scatter" onClick="chartTypeChange('scatter')">
			<input style="width:106px;margin:0 10px;" class="addIp button01b" type="button" value="line" onClick="chartTypeChange('line')">
			<input style="width:106px;margin:0 10px;" class="addIp button01b" type="button" value="area" onClick="chartTypeChange('area')">
			<input style="width:106px;margin:0 10px;" class="addIp button01b" type="button" value="spline" onClick="chartTypeChange('spline')">
			<input style="width:106px;margin:0 10px;" class="addIp button01b" type="button" value="areaspline" onClick="chartTypeChange('areaspline')">
			<input style="width:106px;margin:0 5px;" class="addIp button01b" type="button" value="logarithmic" onClick="chartTypeChange('logarithmic')">
		</div>
		<div id="<portlet:namespace/>viewer" class="analyzerViewer" style="width:760px;height:645px;"></div>
	</div>
</div>
<img id="loadingBox" src="${contextPath}/images/processing.gif" width="400" style="display: none;"/>