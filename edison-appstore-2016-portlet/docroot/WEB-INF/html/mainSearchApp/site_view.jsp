<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="bestSolverListURL" id="bestSolverList" copyCurrentRenderParameters="false" />

<style type="text/css">
#l_search {
	position:absolute;
	width:390px;
	height:47px;
	z-index:1;
	top: 45px;
	left: 66px;
}
#l_Simulation {
	position:relative;
	width:213px;
	height:42px;
	z-index:3;
	left: 327px;
	top: 105px;
}
#l_Simulation01 {
	position:relative;
	width:190px;
	height:195px;
	z-index:4;
	left: 493px;
	top: 54px;
}
#l_Simulation02 {
	position:relative;
	width:50px;
	height:30px;
	z-index:5;
	left: 400px;
	top: -70px;
}
#l-app {
	position:absolute;
	width:340px;
	height:352px;
	z-index:5;
	left: 805px;
	top: 58px;
}
#l-apptitle {
	position:absolute;
	width:176px;
	height:40px;
	z-index:1;
	left: 62px;
	top: -1px;
}
#l-app-in {
	position:absolute;
	width:340px;
	height:152px;
	z-index:2;
	top: 40px;
	left: 0px;
}
#l-left {
	position:absolute;
	width:63px;
	height:211px;
	z-index:1;
	left: -1px;
	top: 91px;
}
#l-right {
	position:absolute;
	width:63px;
	height:210px;
	z-index:1;
	left: 284px;
	top: 91px;
}
#l-appinfo {
	position: absolute;
	top: 45px;
	left: 50px;
	width:206px;
	height:206px;
	overflow: hidden;
}
#l-appinfo ul{
	width:412px;
	margin:0px;
}
#l-appinfo ul li{
	float:left;
}

#l-appimg {
	position:absolute;
	width:190px;
	height:142px;
	z-index:2;
	left: 58px;
	top: 57px;
}
#l-apptxt {
	position:absolute;
	width:204px;
	height:105px;
	z-index:3;
	top: 300px;
	left: 45px;
}
.appimg img {
	width:168px;
	height:114px;
}
img[usemap], map area{
	outline:none;
}

#contents .mainvisualwrap{width:100%; background:url(/edison-appstore-2016-portlet/images/mainSearchApp/mainvisualbg_sub.jpg) repeat-x;height:362px;}
#contents .mainvisual{width:1220px; margin:0 auto;background:url(/edison-appstore-2016-portlet/images/mainSearchApp/mainvisualbg_${groupName}.jpg) repeat-x;height:317px;}

/* UI Object */
.mainvisual_grey_sub .select{z-index:7; display:inline-block; position:absolute; border:1px solid #e0e0e0; margin-top:-7px; margin-left:510px;}
.mainvisual_grey_sub .select *{ margin:0; padding:0; cursor:pointer}
.mainvisual_grey_sub .select .my_value{overflow:visible; position:relative; top:0; left:0; border:1px solid #bababa; background:transparent; color:#666; text-align:left; line-height:19px; _line-height:normal}
.mainvisual_grey_sub .select .my_value.selected{}
.mainvisual_grey_sub .select.openlist .my_value,
.mainvisual_grey_sub .select .my_value.outLine{}
.mainvisual_grey_sub .select button.my_value{margin:3px; min-width:180px; cursor:pointer; color: #a3a3a3; font-size: 14px; height: 25px; text-indent: 5px; border: 0; outline:0;}
.mainvisual_grey_sub .select div.my_value{ height:19px; text-indent:8px}
.mainvisual_grey_sub .select .ctrl{float: right; display:inline-block; width:18px; height:19px; background:transparent;}
.mainvisual_grey_sub .select .arrow{width:0; height:0; border-top:6px solid #000; border-left:5px solid transparent; border-right:5px solid transparent; font-size:0; line-height:0}
.mainvisual_grey_sub .select ul{overflow:hidden; border:0; border-top:1px solid #bababa; border-bottom:1px solid #bababa; background:#fff; list-style:none}
.mainvisual_grey_sub .select ul.a_list{ display:none}
.mainvisual_grey_sub .select.openlist ul.a_list{ display:block}
.mainvisual_grey_sub .select ul.i_list{ left:-2000%}
.mainvisual_grey_sub .select.openlist ul.i_list{ left:0}
.mainvisual_grey_sub .select li{font-size: 14px; overflow:hidden; position:relative; height:31px; line-height:31px; border-left:1px solid #bababa; border-right:1px solid #bababa; white-space:nowrap}
.mainvisual_grey_sub .select li input.option{ position:absolute; width:100%; height:20px; line-height:20px}
.mainvisual_grey_sub .select li label{ position:absolute; top:0; left:0; width:100%; height:18px; background:#fff; color:#767676; line-height:18px; text-indent:8px; *text-indent:6px}
.mainvisual_grey_sub .select li a{ display:block; height:31px; background:#fff; color:#767676; line-height:31px; text-indent:8px; *text-indent:6px; text-decoration:none}
.mainvisual_grey_sub .select li.hover *{ background:#999; color:#fff}
/* //UI Object */
</style>

<script type="text/javascript">
var currentBestSolver = 1;
var maxBestSolver = 1;
var widthBestSolver = 206;
var animateBestSolver = false;

$(document).ready(function () {
	$('#<portlet:namespace/>arrowleft').on("click",function(){
		if(animateBestSolver == false) {
			animateBestSolver = true;
			currentBestSolver--;
			$('#<portlet:namespace/>bestSolverList').animate({'marginLeft': (-1 *currentBestSolver * widthBestSolver) + 'px'}, 700, 'easeInOutExpo', function() {
				if(currentBestSolver == 0) {
					$('#<portlet:namespace/>bestSolverList').css("margin-left", (-1 * (maxBestSolver -2) * widthBestSolver) + 'px');
					currentBestSolver = maxBestSolver -2;
				}
				animateBestSolver = false;
			});
		}
	});
	$('#<portlet:namespace/>arrowright').on("click",function(){
		if(animateBestSolver == false) {
			animateBestSolver = true;
			currentBestSolver++;
			$('#<portlet:namespace/>bestSolverList').animate({'marginLeft': (-1 * (currentBestSolver * widthBestSolver)) + 'px'}, 700, 'easeInOutExpo', function() {
				if(currentBestSolver == (maxBestSolver - 1)) {
					$('#<portlet:namespace/>bestSolverList').css("margin-left", (-1 * widthBestSolver) + 'px');
					currentBestSolver = 1;
				}
				animateBestSolver = false;
			});
		}
	});
	<portlet:namespace/>dataSearchList();
	
    var select_root = $('div.select');
    var select_value = $('.my_value');
    var select_a = $('div.select>ul>li>a');
    var select_input = $('div.select>ul>li>input[type=radio]');
    var select_label = $('div.select>ul>li>label');
     
    // Radio Default Value
    $('div.my_value').each(function(){
        var default_value = $(this).next('.i_list').find('input[checked]').next('label').text();
        $(this).append(default_value);
    });
     
    // Line
    select_value.bind('focusin',function(){$(this).addClass('outLine')});
    select_value.bind('focusout',function(){$(this).removeClass('outLine')});
    select_input.bind('focusin',function(){$(this).parents('div.select').children('div.my_value').addClass('outLine')});
    select_input.bind('focusout',function(){$(this).parents('div.select').children('div.my_value').removeClass('outLine')});
     
    // Show
    function show_option(){
        $(this).parents('div.select:first').toggleClass('openlist');
    }
     
    // Hover
    function i_hover(){
        $(this).parents('ul:first').children('li').removeClass('hover');
        $(this).parents('li:first').toggleClass('hover');
    }
     
    // Hide
    function hide_option(){
        var t = $(this);
        setTimeout(function(){
            t.parents('div.select:first').removeClass('openlist');
        }, 1);
    }
     
    // Set Input
    function set_label(){
        var v = $(this).next('label').text();
        $(this).parents('ul:first').prev('.my_value').text('').append(v);
        $(this).parents('ul:first').prev('.my_value').addClass('selected');
    }
     
    // Set Anchor
    function set_anchor(){
        var v = $(this).text();
        $(this).parents('ul:first').prev('.my_value').text('').append(v).append('<span class="ctrl"><span class="arrow"></span></span>');
        $(this).parents('ul:first').prev('.my_value').addClass('selected');
    }
 
    // Anchor Focus Out
    $('*:not("div.select a")').focus(function(){
        $('.a_list').parent('.select').removeClass('openlist');
    });
             
    select_value.click(show_option);
    select_root.removeClass('openlist');
    select_root.mouseleave(function(){$(this).removeClass('openlist')});
    select_a.click(set_anchor).click(hide_option).focus(i_hover).hover(i_hover);
    select_input.change(set_label).focus(set_label);
    select_label.hover(i_hover).click(hide_option);
});

function <portlet:namespace/>searchApp(){
	
}

function <portlet:namespace/>searchAppDetailView(scienceAppStoreSearchURL,scienceAppStoreNameSpace,solverId){
	var url = scienceAppStoreSearchURL;
	var urlParameter = "&"+scienceAppStoreNameSpace+"search_solverId="+solverId;
	window.location.href = url+urlParameter;
}

function <portlet:namespace/>dataSearchList() {
	
	var searchForm = {};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=bestSolverListURL%>",
		async : false,
		data : searchForm,
		success: function(msg) {
			var bestSolverList = msg.bestSolverList;
			
			var rowResult;
			$("#<portlet:namespace/>bestSolverList").empty();
			
			if(bestSolverList.length == 0) {
				$rowResult = $("<li/>");
				$("<div/>").addClass("appimg")
						  .css("width","190px")
						  .css("height","142px")
						  .append(
								  $("<img/>")
								  .attr("src","${contextPath}/images/scienceappstorelist/app_empty.jpg")
								  .attr("width", "168")
								  .attr("height", "114")
							)
						  .appendTo($rowResult);
				$("<div/>").addClass("appinfo_sub")
						  .css("text-align", "center")
						  .html("None Best Solver")
						  .appendTo($rowResult);
				
				$("#<portlet:namespace/>bestSolverList").append($rowResult);
				
				$('#<portlet:namespace/>arrowright').off();
				$('#<portlet:namespace/>arrowleft').off();
			} else {
				/* 마지막 열 입력*/
				if(bestSolverList != 1) {
					$rowResult = $("<li/>");
					if(bestSolverList[bestSolverList.length -1].solverScreenList.length == 0) {
						$("<div/>").addClass("appimg")
								  .css("width","190px")
								  .css("height","142px")
								  .append(
										  $("<img/>")
										  .attr("src","${contextPath}/images/scienceappstorelist/app_empty.jpg")
								  		  .attr("width", "168")
								  		  .attr("height", "114")
								  )
								  .appendTo($rowResult);
					} else {
						$("<div/>").addClass("appimg")
								  .css("width","190px")
								  .css("height","142px")
								  .append(
										  $("<img/>")
										  .attr("src","/documents/"+bestSolverList[bestSolverList.length -1].solverScreenList[0].fileRepositoryId+"/"+bestSolverList[bestSolverList.length -1].solverScreenList[0].fileUuid)
								  		  .attr("width", "168")
								  		  .attr("height", "114")
								  )
								  .appendTo($rowResult);
					}
					$("<div/>").addClass("appinfo_sub")
							  .html(bestSolverList[bestSolverList.length -1].solverTitle)
							  .appendTo($rowResult);
					$("#<portlet:namespace/>bestSolverList").append($rowResult);
				}
				
				/* 리스트 데이터 입력 */
				for (var i = 0; i < bestSolverList.length; i++) {
					$rowResult = $("<li/>").attr("onclick", "<portlet:namespace/>moveSolverDetail('" + bestSolverList[i].solverId + "','" + bestSolverList[i].groupId +"')").css("cursor", "pointer");
					if(bestSolverList[i].solverScreenList.length == 0) {
						$("<div/>").addClass("appimg")
								  .css("width","190px")
								  .css("height","142px")
								  .append(
										  $("<img/>")
										  .attr("src","${contextPath}/images/scienceappstorelist/app_empty.jpg")
								  		  .attr("width", "168")
								  		  .attr("height", "114")
								  )
								  .appendTo($rowResult);
					} else {
						$("<div/>").addClass("appimg")
								  .css("width","190px")
								  .css("height","142px")
								  .append(
										  $("<img/>")
										  .attr("src","/documents/"+bestSolverList[i].solverScreenList[0].fileRepositoryId+"/"+bestSolverList[i].solverScreenList[0].fileUuid)
								  		  .attr("width", "168")
								  		  .attr("height", "114")
								  )
								  .appendTo($rowResult);
					}

					$("<div/>").addClass("appinfo_sub")
							  .html(bestSolverList[i].solverTitle)
							  .appendTo($rowResult);
					$("#<portlet:namespace/>bestSolverList").append($rowResult);
				}
				
				/* 처음 열 입력*/
				if(bestSolverList != 1) {
					$rowResult = $("<li/>");
					if(bestSolverList[0].solverScreenList.length == 0) {
						$("<div/>").addClass("appimg")
								  .css("width","190px")
								  .css("height","142px")
								  .append(
										  $("<img/>")
										  .attr("src","${contextPath}/images/scienceappstorelist/app_empty.jpg")
								  		  .attr("width", "168")
								  		  .attr("height", "114")
								  )
								  .appendTo($rowResult);
					} else {
						$("<div/>").addClass("appimg")
								  .css("width","190px")
								  .css("height","142px")
								  .append(
										  $("<img/>")
										  .attr("src","/documents/"+bestSolverList[0].solverScreenList[0].fileRepositoryId+"/"+bestSolverList[0].solverScreenList[0].fileUuid)
								  		  .attr("width", "168")
								  		  .attr("height", "114")
								  )
								  .appendTo($rowResult);
					}
					$("<div/>").addClass("appinfo_sub")
							  .html(bestSolverList[0].solverTitle)
							  .appendTo($rowResult);
					$("#<portlet:namespace/>bestSolverList").append($rowResult);
					$("#<portlet:namespace/>bestSolverList").css("width", (206 * (bestSolverList.length + 2)) + "px").css("margin-left", "-206px");
					maxBestSolver = bestSolverList.length + 2;
				} else {
					$("#<portlet:namespace/>bestSolverList").css("width", "206px");
					maxBestSolver = 1;
				}
				
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>simulationGo(){
	<%if(isLogin){%>
	window.location.href = "${simulationURL}";
	<%}else{%>
		alert('<liferay-ui:message key="edison-simulation-please-login" />');
	<%}%>
}

function <portlet:namespace/>appStoreGo() {
	window.location.href = "${appStoreURL}";
}

</script>
<aui:script>
function <portlet:namespace/>moveSolverDetail(solverId, groupId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${appstorePlid}"); <!-- 앱스토어 Plid -->
		portletURL.setPortletId("edisonscienceAppstore_WAR_edisonappstoreportlet"); <!-- 앱스토어 포틀릿 ID -->
		portletURL.setParameter("groupId", groupId); <!-- 현재 groupId -->
		portletURL.setParameter("solverId", solverId); <!-- 선택된 solverId -->
		portletURL.setParameter("myaction", "detailView"); <!-- 상세보기 페이지 action -->
		window.location.href = portletURL.toString();
	});
}
</aui:script>
	<!--메인배너영역-->
<div id="contents">
		<div class="mainvisualwrap">
				<div class="mainvisual">
						<div style="position: relative;">
							<div class="main-simul">
								<div id="l_Simulation" class="simtitle" style="cursor:pointer;" onclick="<portlet:namespace/>simulationGo()">Simulation</div>
										<div id="l_Simulation01" class="simbtn">
											<img src="${contextPath}/images/mainSearchApp/btn_transp.gif" style="height:212px; width:212px; max-width:212px;" border="0" usemap="#Map"/>
											<map name="Map" id="Map">
											<area shape="circle" coords="104,104,104" href="javascript:;" onfocus="blur();" onclick="<portlet:namespace/>simulationGo()" />
											</map>
										</div>
										<div id="l_Simulation02" class="siminfo" onclick="<portlet:namespace/>simulationGo()" style="cursor:pointer;">GO</div>
								</div>
								<div id="l-app" class="main_app">
									<div id="l-apptitle" class="apptitle" style="cursor:pointer;" onclick="<portlet:namespace/>appStoreGo()">ScienceApp</div>
									<div id="l-appgroup" class="appgroup">
										<div id="l-left"><a id="<portlet:namespace/>arrowleft" href="javascript:;"><img src="${contextPath}/images/mainSearchApp/arrow_left.png" width="19" height="37"/></a></div>
										<div id="l-right" class="arrowright"><a id="<portlet:namespace/>arrowright" href="javascript:;"><img src="${contextPath}/images/mainSearchApp/arrow_right.png" width="19" height="37"/></a></div>
										<div id="l-appinfo">
											<ul id="<portlet:namespace/>bestSolverList">
											</ul>
									</div>
							</div>
						</div>
				</div>
				
		</div>
		<div class="mainvisual_grey_sub">
			${groupName} <span> :::  Bridge to Computational Science for Higher Education and Advanced Research</span>
			<div class="footerlink select" >
				<button type="button" class="my_value"><liferay-ui:message key='related-site-link'/><span class="ctrl"><span class="arrow"></span></span></button>
				<ul class="a_list">
					<li><a href="http://espine.kisti.re.kr" target="_blank">e-Spine Simulation System</a></li>
				</ul>
			</div>
		</div>
</div>
