<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${contextPath}/css/postprocessor/post.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/postprocessor/oneDPlot/oneDplot.js"></script>
<script type="text/javascript" src="${contextPath}/js/highcharts_NEW.js"></script>
<script type="text/javascript" src="${contextPath}/js/modules/exporting.js"></script>
<script type="text/javascript" src="${contextPath}/js/themes/gray.js"></script>

<%-- <script type="text/javascript" src="${contextPath }/js/jquery/jquery.filestyle.js"></script> --%>

<style type="text/css">
@charset "utf-8";
/* CSS Document */

#postTable{
	line-height: 17px;
}
#page_title{
	margin: -10px 15px 0px 15px;
}

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

$(document).ready(function(){
	chartExecute("line");	
});


function chartTypeChange(newType){
	chartExecute(newType);
}

function chartExecute(chartTypeDefine){
		/* initiolize animation mode to false */
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
							ani_mode = display_mode_change(ani_mode, '${contextPath}/images/postprocessor/kitty.gif');
						}
					}
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
		var options = getOptions(oned_raw_data, title, subtitle, init_options);
		////////////////////////////////////////////////////////////////////////////////
		/* Draw Chart..  */
		////////////////////////////////////////////////////////////////////////////////
		
		chart1 = new Highcharts.Chart(options);
		chart1.setOptions(theme);
		
};
 
function fileLoadFunction(){	
	var fileContentAll = "";		
	$("input:checkbox[class=fileContents]:checked").each(
		function(pi,po){
			fileContentAll += po.value;
		}			
	);
	return fileContentAll;
}



function selectAll(){
	var c = $('#checkAll').is(":checked");
	$('input[name=checkboxName]').each(function(){
		this.checked = c;
	})
}

function selectLocalAll(){
	var c = $('#checkLocalAll').is(":checked");
	$('input[name=checkLocal]').each(function(){
		this.checked = c;
	})
}


var fileObj = new Object(); 
var localFileArr = new Array();
var fileContentAll = "";

function setLocalFile(){  
    
	//파일명 가져오기
    var filePath = document.getElementById("fileToLoad").value;
    var fileStartPoint = filePath.lastIndexOf("\\");
    var fileFullName = filePath.substring(fileStartPoint+1, filePath.length);
    
    //파일내용 가져오기
    var fileToLoad = document.getElementById("fileToLoad").files[0];
    var fileReader = new FileReader();
    fileReader.onload = function(fileLoadedEvent){
		//document.getElementById("inputTextToSave").value = fileLoadedEvent.target.result;
		fileObj = new Object(); 
		fileObj.fileName = fileFullName;
		fileObj.fileContent = fileLoadedEvent.target.result;
		localFileArr[localFileArr.length] = fileObj;
		
		setLocalListView("checkLocal"+localFileArr.length, fileLoadedEvent.target.result, fileFullName);
    };
	fileReader.readAsText(fileToLoad, "EUC-KR");//UTF-8
	
}

function setLocalListView(fLength, fCont, fName){	
	var str  = "<div>";
		str += "	<input type='checkbox' id='checkLocal"+fLength+"' name='checkLocal' class='fileContents' value='"+fCont+"'>";
		str += "		<label for='checkLocal"+fLength+"' ";		
		str += "			onmouseover=\"this.style.backgroundColor='#c2d7f5'; \" ";		
		str += "			onmouseout=\"this.style.backgroundColor='#ffffff'; \" >";
		str += "			&nbsp;"+fName+"";
		str += "		</label>";
		str += "	</input>";
		str += "</div>";
	
	$("#localList").html($("#localList").html()+str);
}

</script>
</head>
<body> 
<div id="postwrap">
	<div id="postinfo">
		<div id="postinfocon">		
			<Table id="postTable">
				<tr>
					<td>
						<img src="${contextPath}/images/title_dot.jpg" width="20" height="15" />
						<input type="checkbox" id="checkAll" onclick="selectAll()"/>					
						${jobTitle}
					</td>
				</tr>
				<c:if test="${!empty resultList}">
					<c:forEach items="${resultList}" var="model">
						<tr>
							<td>						
								<c:set var="checkedVal" value=""/>								
								<c:choose>
									<c:when test="${fn:indexOf(checkedFileIds, model.fileId)> -1}">
										<c:set var="checkedVal" value="checked"/>
									</c:when>
									<c:otherwise>
										<c:set var="checkedVal" value=""/>
									</c:otherwise>
								</c:choose>
								<input type="checkbox" id="${model.fileId}" name="checkboxName" class="fileContents" value="${model.fileContent}">&nbsp;
									<label for="${model.fileId}"
											onmouseover="this.style.backgroundColor='#c2d7f5';" 
											onmouseout="this.style.backgroundColor='#ffffff';">${model.fileName}</label>
								</input>
							</td>
						</tr>
					</c:forEach>					
				</c:if>
			</Table>
						
			<br/>
			
			<Table id="postTable">			
				<tr>
					<td>
						<img src="${contextPath}/images/title_dot.jpg" width="20" height="15" />	
						<input type="checkbox" id="checkLocalAll" onclick="selectLocalAll()"/>					
						<liferay-ui:message key="edison-simulation-monitoring-post-processor-user-local-file" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="file" id="fileToLoad" onChange="setLocalFile()">				
<!-- 						<script> -->
// 							$("#fileToLoad").filestyle({ 
<%-- 								image: "${contextPath}/images/<%=themeDisplay.getLanguageId()%>/join07.gif", --%>
// 								imageheight : 30,
// 								imagewidth : 82,
// 								width : 150
// 							});
<!-- 						</script> -->
					</td>
				</tr>
			</Table>
						

			<div id="localList"></div>						
						
							
		</div>
	</div>
	<div id="postbtn_<%=themeDisplay.getLanguageId()%>" onclick="chartExecute()"></div>
	<div id="postlist">
		 <div id="postlistcon">
		 
		 
		 	<div class="actions">
				<input type="button" value="scatter" onClick="chartTypeChange('scatter')">
				<input type="button" value="line" onClick="chartTypeChange('line')">
				<input type="button" value="area" onClick="chartTypeChange('area')">
				<input type="button" value="spline" onClick="chartTypeChange('spline')">
				<input type="button" value="areaspline" onClick="chartTypeChange('areaspline')">
				<input type="button" value="logarithmic" onClick="chartTypeChange('logarithmic')">
			</div>
			<div style="height:5px"></div>
			<div id="container" style="min-width: 420px; height: 670px; margin: 0 auto"></div>
			 
			
		 </div>
	</div>
	 <div id="clear"></div>
</div>
</body>
</html>