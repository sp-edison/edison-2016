<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<!-- ckeditor -->
<%@ page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.Group"%>
<!-- ------- -->
<head>
<liferay-portlet:renderURL plid="${simulationPlid}" portletName="_SIMULATION_WAR_edisonportlet_" portletMode="view" var="exeURL">
	<liferay-portlet:param name="p_p_state" value="normal"/>
</liferay-portlet:renderURL>
<liferay-portlet:resourceURL var="getListStatisticSwExeURL" 		escapeXml="false" id="getListStatisticSwExe" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="solverFavoriteURL" 		escapeXml="false" id="solverFavorite"  copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>
	
<liferay-portlet:actionURL copyCurrentRenderParameters="false" var="updateSovelInfoActionUrl" portletMode="view" >
	<portlet:param name="myAction" value="updateSolverInfoAction"/>
	<portlet:param name="descriptionId" value="${solver.descriptionId}"/>
	<portlet:param name="solverId" value="${solver.scienceAppId}"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL var="renderViewURL">
	<portlet:param name="myaction" value="detailView" />
	<portlet:param name="edionCopyParam" value="true" />
</liferay-portlet:renderURL>
<liferay-portlet:resourceURL var="addFavoriteAppURL" id="addFavoriteApp" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="deleteFavoriteAppURL" id="deleteFavoriteApp" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="scienceAppCategoryURL" id="scienceAppCategory" copyCurrentRenderParameters="false" />

<c:set var="actionUrl" value="<%=updateSovelInfoActionUrl%>"/>
<%
	Locale[] locales = LanguageUtil.getAvailableLocales();
	String localesStr = "";
	
	/* QNA 이동시 P_P_ID 확인 */
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	String p_p_id = CustomUtil.strNull(httpRequest.getParameter("p_p_id"), "");
	/* QNA 이동시 P_P_ID 확인 */
%>
<!-- ckeditor -->
 <%
 		Map<String, String> fileBrowserParamsMap = (Map<String, String>)request.getAttribute("liferay-ui:input-editor:fileBrowserParams");
 		
 		String fileBrowserParams = marshallParams(fileBrowserParamsMap);
		
 		StringBundler sb = new StringBundler(8);
		String portletId = portletDisplay.getRootPortletId();
		String mainPath = themeDisplay.getPathMain();

		String doAsUserId = themeDisplay.getDoAsUserId();
		long doAsGroupId = themeDisplay.getDoAsGroupId();
 		Locale siteLocale = themeDisplay.getLocale();
		String doasLocale = siteLocale.getLanguage();

		if (doAsGroupId == 0) {
			doAsGroupId = (Long)themeDisplay.getSiteGroupId();
		}
		
		Group group = GroupLocalServiceUtil.getGroup(doAsGroupId);
		String currentFolder = "/"+doAsGroupId+" - "+"edison"+"/";
		
		sb.append(mainPath);
		sb.append("/portal/fckeditor?p_p_id=");
		sb.append(HttpUtil.encodeURL(portletId));
		sb.append("&doAsUserId=");
		sb.append(HttpUtil.encodeURL(doAsUserId));
		sb.append("&doAsGroupId=");
		sb.append(HttpUtil.encodeURL(String.valueOf(doAsGroupId)));
		sb.append(fileBrowserParams);

		String connectorURL = HttpUtil.encodeURL(sb.toString());
%>
<!-- ------------- -->


<style type="text/css">
.yellowbtn{padding:5px 20px 8px 20px; background:#ffc75d;  border-radius:3px; -webkit-border-radius:3px; border:solid 1px #ccc; color:#704c1d; font-weight:600; font-size:15px;}
.yellowbtn a:hover{ color:#000;}

.favorites {
	cursor:pointer;
	display:none;
	
}

.appcell01 {
	text-align:center;
	font-size: 13px;
	font-weight: 600;
	color: #0e445a;
	background-color: #c7c7c7;
	padding: 9px;
	border-bottom: solid 1px #c0c0c0;
	max-width: 100px;
}

.appcell02 {
	font-size: 13px;
	font-weight: 600;
	color: #0e445a;
	background-color: #ddd;
	max-width: 100px;
	padding: 9px;
	border-bottom: solid 1px #c0c0c0;
}

.rolling-image {width: 1220px;margin: 0 auto;}
.rolling-image>.rolling-button { float: left; padding-left: 5px; margin-top:32px; margin-right:21px;}

.modifyBtnbox-kor{
	float: left; width: 94% !important;
}
.modifyBtnbox-eng{
	float: left; width: 91% !important;
}
</style>

<link href="${contextPath}/css/owl-carousel/owl.carousel.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/css/owl-carousel/owl.theme.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/css/fancybox/jquery.fancybox.css" rel="stylesheet" type="text/css" />


</head>
<body>
	<form name="exeform" method="post" action="<%=exeURL%>" style="margin:0px;">
		<input name="<portlet:namespace />id"    type="hidden"/>
	</form>
	<form method="post" name="form" action="<portlet:renderURL portletMode='view'/>" style="margin:0px;">
		<!-- 검색어 저장 Start -->
		<input name="<portlet:namespace/>p_curPage"			type="hidden" value="${returnParams.p_curPage}"/>
		<input name="<portlet:namespace/>categoryId"		type="hidden" value="${returnParams.categoryId}"/>
		<input name="<portlet:namespace/>searchValue"		type="hidden" value="${returnParams.searchValue}"/>
		<input name="<portlet:namespace/>linePerPage"		type="hidden" value="${returnParams.linePerPage}"/>
		<input name="<portlet:namespace/>searchOption"		type="hidden" value="${returnParams.searchOption}"/>
		<!-- 검색어 저장 End -->
	</form>
	<form method="post" name="formFavorite" id="formFavorite" style="margin:0px;">
		<!-- 검색어 저장 Start -->
		<input name="<portlet:namespace/>solverId"	 id="<portlet:namespace/>solverId"			type="hidden" value="${params.solverId}"/>
		<input name="<portlet:namespace/>groupId"	 id="<portlet:namespace/>groupId"			type="hidden" value="${params.groupId}"/>
		<input name="<portlet:namespace/>userId"	 id="<portlet:namespace/>userId"			type="hidden" value="${params.userId}"/>
		<!-- 검색어 저장 End -->
	</form>
	
	<h1>ScienceApp</h1>
	
	<div class="table1">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed;">
			<colgroup>
				<col width="245" />
				<col width="100" />
				<col width="*" />
				<col width="150" />
				<col width="100" />
				<col width="150" />
				<col width="150" />
			</colgroup>
			<thead>
				<tr>
					<th height="33" class="favT">
						<% if(isLogin) {%>
							<div id="favorites_off" class="favorites" style="display:none;" onclick="<portlet:namespace/>addFavoriteApp(${solver.scienceAppId}, ${params.solverGroupId}); return false;">
								<img src="${contextPath}/images/scienceappstorelist/favoriteicon.png" width="20" height="18" /> <liferay-ui:message key='edison-appstore-bookmark' />
							</div>
							<div id="favorites_on" class="favorites" style="display:none;" onclick="<portlet:namespace/>deleteFavoriteApp(${solver.scienceAppId}, ${params.solverGroupId}); return false;">
								<img src="${contextPath}/images/scienceappstorelist/favoriteiconon.png" width="20" height="18" /> <liferay-ui:message key='edison-appstore-bookmark' />
							</div>
						<% } %>
					</th>
					<th class="leftT" colspan="6" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">${solver.currentTitle }</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td rowspan="2">
						<div width="158">
							<c:choose>
								<c:when test="${!empty solver.iconId}">
										<img src="/documents/${solver.iconRepositoryId }/${solver.iconUuid }" style="width:158px; height:107px;"/> 
								</c:when>
								<c:otherwise>
									<img src="${contextPath}/images/scienceappstorelist/subapp_box2.jpg" style="width:158px; height:107px;"/>
								</c:otherwise>
							</c:choose>
						</div>
					</td>
					<td class="TC black"><liferay-ui:message key='edison-virtuallab-version' /></td>
					<td class="TC black"><liferay-ui:message key='edison-table-list-header-orgNm' /></td>
					<td class="TC black"><liferay-ui:message key='developer' /></td>
					<td class="TC black"><liferay-ui:message key='edison-table-list-header-date' /></td>
					<td class="TC black"><liferay-ui:message key='edison-table-list-header-manual' /></td>
					<td class="TC black"><liferay-ui:message key='edison-table-list-header-run' /></td>
				</tr>
				<tr>
					<td class="TC left">${solver.version }</td>
					<td class="TC left">${solver.affiliation }</td>
					<td class="TC left">
						<c:forEach var="developer" items="${solver.developers }" varStatus="status">
							${developer}
							<c:if test="${!status.last}">
							<br>
							</c:if> 
						</c:forEach>
					</td>
					<td class="TC left">${solver.createDate}</td>
					<td class="TC left">
						<c:if test="${!empty solver.current_manualId}">
							<img src="${contextPath}/images/scienceappstorelist/btn_manual.jpg" width="98" height="30" style="cursor:pointer;" onClick="<portlet:namespace/>fileDownload('${solver.current_manualId}')" />
						</c:if>
						<c:if test="${empty solver.current_manualId}">
							<img src="${contextPath}/images/btn_manual_none.jpg" width="98" height="30" />
						</c:if>
					</td>
					<td class="TC left">
						<img src="${contextPath}/images/scienceappstorelist/btn_run.jpg" width="98" height="30" style="cursor:pointer;" onClick="<portlet:namespace/>moveSimulation('${params.solverId}', '${params.groupId}');"/>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="h30"></div>
	<!--tab메뉴-->
	<div class="tabmenu02">
		<ul>
			<li id="tabs-1"><liferay-ui:message key="edison-science-appstore-view-tab-detail-view" /></li>
<%-- 			<li id="tabs-2"><liferay-ui:message key="edison-science-appstore-view-tab-category" /></li> --%>
			<li id="tabs-3"><liferay-ui:message key="edison-science-appstore-view-tab-sw-statistics" /></li>
			<li id="tabs-4"><liferay-ui:message key="edison-science-appstore-view-tab-qna" /></li>
		</ul>
	</div>
	
	<div id="tabs_wrapper">
		
		<div id="tabs_content_container" style="min-height: 450px">
		<form id="<portlet:namespace/>solverInfoForm" name="<portlet:namespace/>solverInfoForm" method="POST"  action="${actionUrl}" onsubmit="return <portlet:namespace/>solverInfoFormCheck()">
			<input type="hidden" id="<portlet:namespace/>selectLocaleId" name="<portlet:namespace/>selectLocaleId" value="${selectLocaleId}"/>
			<div id="tabs-1"  class="tab_content">
				<div class="h4" style="float: left;"><liferay-ui:message key='edison-science-appstore-view-tab-detail-view' /></div>
				<c:if test="${contentCheckAuth eq 'TRUE' }">
				<div class="buttonbox ${locale.toString() eq 'en_US' ? 'modifyBtnbox-eng' : 'modifyBtnbox-kor'}">
					<input type="button" id="tabs-1" class="button02" value="<liferay-ui:message key='edison-button-board-modify' />" onClick="<portlet:namespace/>detailInfoModify(); return false;"/>
				</div>	
				</c:if>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				  <c:if test="${contentCheckAuth eq 'FALSE' }">
				  <tr>
			  		<td width="100%">
				  		<%
							for(Locale aLocale : locales){
								String languageId = LocaleUtil.toLanguageId(aLocale);
								String descriptionKey = "description_"+languageId;
					    %>	
					    	<c:set var="descriptionKey" value="<%=descriptionKey%>"></c:set>
					    	<div id="<portlet:namespace/>descriptionDiv_<%=languageId%>">
					    		${solver.description[descriptionKey] }
					    	</div>
					    <%
							}
					    %>
				    </td>	
				  </tr>
				  </c:if>
				  <c:if test="${contentCheckAuth eq 'TRUE' }">
				  	  <tr>
					  	<td width="100%">
					  		<aui:select name="serviceLocaleId" label="" onChange="changeLocale(this.value)">
								<%
								for(Locale aLocale : locales){
									String languageId = LocaleUtil.toLanguageId(aLocale);
									if(localesStr.equals("")){
										localesStr += languageId;
									}else{
										localesStr += ","+languageId;
									}
									
									String languageNm =aLocale.getDisplayName(themeDisplay.getLocale());
								%>
									<c:set var="langId" value="<%=languageId%>"></c:set>
									<aui:option label="<%=languageNm%>" value="<%=languageId%>" selected="${solver.selectLocaleId eq langId ? true : false}"/>
								<%} %>
							</aui:select>
							<br>
					  	</td>
					  </tr>
					  <tr>
					    <td width="100%">
					    <%
							for(Locale aLocale : locales){
								String languageId = LocaleUtil.toLanguageId(aLocale);
								String descriptionKey = "description_"+languageId;
					    %>	
					    	<c:set var="descriptionKey" value="<%=descriptionKey%>"></c:set>
					    	<div id="<portlet:namespace/>descriptionDiv_<%=languageId%>">
					    		<textarea id="<portlet:namespace/>description_<%=languageId%>" name="<portlet:namespace/>description_<%=languageId%>" style="width:100%;height:300px;">${solver.description[descriptionKey] }</textarea>
					    	</div>
					    <%
							}
					    %>	
					    </td>
					  </tr>
				  </c:if>
				</table>
				<div class="h4" style="float: left;">
				<c:if test="${!empty solver.openLevel && !empty solver.srcFileId}">
					<c:if test="${solver.openLevel eq 'OPEN_SOURCE'}">
						<liferay-ui:message key='edison-science-appstore-view-source-code-download' />
					</c:if>
					<c:if test="${solver.openLevel eq 'OPEN_RUN_ONLY'}">
						<liferay-ui:message key='edison-science-appstore-view-execute-file-download' />
					</c:if>
					<c:if test="${!empty solver.srcFileId }">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top: 10px;">
							<tr>
								<td>
									<span style="cursor:pointer; margin-right:5px;" onclick="<portlet:namespace/>fileDownload('${solver.srcFileId }')" class="onMouseHover">
										<img src="${contextPath}/images/fileicon2.png" width="16" height="16" />&nbsp;${solver.srcFileTitle }
									</span>
								</td>
							</tr>	
						</table>
					</c:if>
				</c:if>	
				</div>
			</div>
		</form>
			
			<div id="tabs-2" class="tab_content">
				<div class="h20"></div>
				<div id="filters_wrap" class="table1_list">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" >
						<colgroup>
							<col width="20%">
							<col width="*">
						</colgroup>
						<tbody id="configFilter">
						</tbody>
					</table>
				</div>
			</div>
			
			<div id="tabs-3" class="tab_content" style="text-align:center;">
				<div class="h20"></div>
				<div id="container2" style="width: 1100px; height: 450px;"></div>
			</div>
			
			<div id="tabs-4" class="tab_content" >
				<liferay-portlet:runtime portletName="edisonmultiboard_WAR_edisonboard2016portlet_INSTANCE_appstoreQna" queryString="&solverId=${params.solverId}&boardGroupId=${params.solverGroupId}"/>
			</div>
		</div>
	</div>
	
	<div class="buttonbox">
		<input type="button" id="scienceAppstoreListBtn" class="button02" value="<liferay-ui:message key='edison-button-board-list' />" onclick="goList();"/>
	</div>
</body>
<style>
	tab_content{
		display:none;
	}
</style>

<!-- ckeditor  -->
<%!
public String marshallParams(Map<String, String> params) {
	StringBundler sb = new StringBundler();

	if (params != null) {
		for (Map.Entry<String, String> configParam : params.entrySet()) {
				sb.append(StringPool.AMPERSAND);
				sb.append(configParam.getKey());
				sb.append(StringPool.EQUAL);
				sb.append(HttpUtil.encodeURL(configParam.getValue()));
		}
	}

	return sb.toString();
}
%>
<!-- -------------  -->
<script type="text/javascript" src="${contextPath}/js/highcharts.js"></script>
<script src="${contextPath}/js/owl-carousel/owl.carousel.min.js"></script>
<script src="${contextPath}/js/fancybox/jquery.fancybox.pack.js"></script>
<script type="text/javascript" src="${contextPath}/editor/ckeditor/ckeditor.js" charset="utf-8"></script>

<script>
var chart1;
// var solverId = "${params.solverId}";

$(document).ready(function(){
	/* QNA 이동시 탭 선택 */
	var p_p_id = "<%=p_p_id %>";
	var boardSeq = "${boardSeq}";
	var qnaPortletId = "edisonmultiboard_WAR_edisonboard2016portlet_INSTANCE_appstoreQna";
	if(p_p_id == qnaPortletId || boardSeq != "") {
		$("#tabs-4").addClass("on");
		$("div#tabs-4").show();
		$("#scienceAppstoreListBtn").hide();
	} else {
		$("#tabs-1").addClass("on");
		$("div#tabs-1").show();
	}
	/* QNA 이동시 탭 선택 */
	
	var fa = "${favorite}";
	
	if(fa == 0){
		$("#favorites_off").show();
		$("#favorites_off").css("display", "inline");
	}else{
		$("#favorites_on").show();
		$("#favorites_on").css("display", "inline");;
	}
	
//  	appCategory("${solver.scienceAppId}", "${params.groupId}"); 카테고리 탭 일단 주석처리
	chartLoad();
	setCKeditor();
	
});
function chartLoad(){		
		chart2 = new Highcharts.Chart({
			chart: {
				renderTo: 'container2',
				type: 'column'
				},
			title: {
	                text: null
	            },
			yAxis: {
				min: 0,
				title: {
				text: 'Total fruit consumption'
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
					this.series.name +': '+ this.y +'<br/>'+
					'Total: '+ this.point.stackTotal;
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
		
		
		var searchForm = {
				"<portlet:namespace/>groupId":"${params.groupId}",
				"<portlet:namespace/>solverId":"${params.solverId}"
				};
		
		jQuery.ajax({
			type: "POST",
			url: "<%=getListStatisticSwExeURL%>",
			data: searchForm,
			async : false,
			dataType: 'json',
			success: function(data) {
				var resultMap = data;
				var monthList = resultMap.perMonthList;
				
				if(monthList.length>0){
					
					//차트 초기화
					while(chart2.series.length > 0)chart2.series[0].remove(true);
					
					var newData=[];
					var preData=[];
					var xNameAxis = [];
					for(var i=0;i<monthList.length;i++){
						newData.push(monthList[i].monthCnt);
						preData.push(monthList[i].preMonthCnt);
						xNameAxis.push(monthList[i].month);
					}
					chart2.xAxis[0].setCategories(xNameAxis);
					chart2.addSeries({name:'<liferay-ui:message key="edison-science-appstore-view-new-execute" />',data:newData});
					chart2.addSeries({name:'<liferay-ui:message key="edison-science-appstore-view-Existing-execute" />',data:preData});
					
					$(chart2.yAxis[0].axisTitle.element).text('<liferay-ui:message key="edison-science-appstore-view-Execution-count" />');
					
					chart2.redraw();
				}
			},error:function(msg){
				alert("System Exception dataSearchStick: " + msg);
			}
		});		
		
	}//function
	
function appCategory(solverId, groupId){
		
		var dataForm = {
			"<portlet:namespace/>solverId" : solverId,
			"<portlet:namespace/>groupId" : groupId
		};
		jQuery.ajax({
			type: "POST",
			url: "<%=scienceAppCategoryURL%>",
			async : false,
			data : dataForm,
			success: function(msg) {
				var parentCategoryList = msg.parentCategoryList;
				var categoryList = msg.categoryList;
				var appCategoryIds = msg.appCategoryIds;
				
				$.each( parentCategoryList , function(key, parentCategory){
					var rowSpan = 0;
					var parentCategoryInit = false;
					
					$.each( categoryList , function(key, category){
						if(category.parentCategoryId == parentCategory.categoryId){
							rowSpan = rowSpan+1;
						}
					});
					
					$.each( categoryList , function(key, category){
						if(category.parentCategoryId == parentCategory.categoryId){
							$vRow = $("<tr/>");
							$("#configFilter").append($vRow);
							
							if(parentCategoryInit == false){
								$vTh = $("<th/>");
								$vTh.attr("rowspan", rowSpan)
									.text(parentCategory.categoryTitle)
									.appendTo($vRow);
								
								parentCategoryInit = true;
							}
							$vTd = $("<td/>");
							if(appCategoryIds != null && typeof appCategoryIds != undefined){
								for(var i = 0 ; i < appCategoryIds.length ; i++){
									if(category.categoryId == appCategoryIds[i].categoryId){
										$vTd.css({"background-color" : "#ebf5e6" , "color" : "#468847"});
									}
								}
							}
							$vTd.text(category.categoryTitle)
								.appendTo($vRow);
						}
					});
					
				});
				
			},error:function(msg,e){ 
				alert(e);
				return false;
			}
		});
}
    
$(document).on({
	mouseenter: function(){
		$(this).attr("src","${contextPath}/images/scienceappstoreview/<%=themeDisplay.getLanguageId()%>/btn_original_over.png");
	},
	mouseleave: function(){
		$(this).attr("src","${contextPath}/images/scienceappstoreview/<%=themeDisplay.getLanguageId()%>/btn_original.png");
	}
}, "#linkImg");

//ReferenceLink popup
$(document).on( "click", "#linkImg", function(){
	var url = spaceDelete($(this).attr("data-url"));
	window.open(url,"_blank");
});

$(document).on( "click", ".tabmenu02 ul li", function(){
	$(".tabmenu02 ul li").removeClass("on");
	$(this).addClass("on");
	$(".tab_content").hide();
	var selected_tab = $(this).attr("id");
	
	$("div#"+selected_tab).show();
	if(selected_tab == 'tabs-4') {
		$("#scienceAppstoreListBtn").hide();
	} else {
		$("#scienceAppstoreListBtn").show();
	}
	
	return false;
});

function goList(){
	var form = document.form;
	form.submit();
}
/*radio*/
$(function() {
    $( "#radio" ).buttonset();
    $("#detail").hide();
	$("input[type='radio']").change(function () {
		var selection=$(this).val();
		//$(selection).show();
		if(selection=='month'){
			$("#month").show();
			$("#detail").hide();
		}else{
			$("#detail").show();
			$("#month").hide();
		}
	});
});

/*datapicker*/
$(function() {
    $( "#dateFrom" ).datepicker();
    $( "#dateTo" ).datepicker();
});

function MM_swapImgRestore() { //v3.0
	var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_swapImage() { //v3.0
	var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
	if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

function <portlet:namespace/>submitForm(){
    if(
    	document.<portlet:namespace/>solverInfoForm.onsubmit &&
    	!document.<portlet:namespace/>solverInfoForm.onsubmit()
    ){
        return false;
    }
 	document.<portlet:namespace/>solverInfoForm.submit();
}

function <portlet:namespace/>detailInfoModify(){
	var form = document.form;
	var formFavorite = document.formFavorite;
	var solverInfoForm = document.<portlet:namespace/>solverInfoForm;
	
	var solverId = formFavorite.<portlet:namespace/>solverId.value;
	var groupId = formFavorite.<portlet:namespace/>groupId.value;
	
	var p_curPage = form.<portlet:namespace/>p_curPage.value;
	var categoryId = form.<portlet:namespace/>categoryId.value;
	var searchValue = form.<portlet:namespace/>searchValue.value;
	var linePerPage = form.<portlet:namespace/>linePerPage.value;
	var searchOption = form.<portlet:namespace/>searchOption.value;
		
	$('<input />').attr('type', 'hidden').attr('name', "<portlet:namespace/>groupId").attr('value', groupId).appendTo('#<portlet:namespace/>solverInfoForm');
	$('<input />').attr('type', 'hidden').attr('name', "<portlet:namespace/>p_curPage").attr('value', p_curPage).appendTo('#<portlet:namespace/>solverInfoForm');
	$('<input />').attr('type', 'hidden').attr('name', "<portlet:namespace/>categoryId").attr('value', categoryId).appendTo('#<portlet:namespace/>solverInfoForm');
	$('<input />').attr('type', 'hidden').attr('name', "<portlet:namespace/>searchValue").attr('value', searchValue).appendTo('#<portlet:namespace/>solverInfoForm');
	$('<input />').attr('type', 'hidden').attr('name', "<portlet:namespace/>linePerPage").attr('value', linePerPage).appendTo('#<portlet:namespace/>solverInfoForm');
	$('<input />').attr('type', 'hidden').attr('name', "<portlet:namespace/>searchOption").attr('value', searchOption).appendTo('#<portlet:namespace/>solverInfoForm');
	
	<portlet:namespace/>submitForm();
}

function <portlet:namespace/>solverInfoFormCheck(){
	   // 에디터의 내용이 textarea에 적용된다.
	   
	<%
		for(Locale aLocale : locales){
			String languageId = LocaleUtil.toLanguageId(aLocale);
	%>	
			var languageId = "<%=languageId%>";   
			var contentValue = CKEDITOR.instances["<portlet:namespace/>description_"+languageId].getData();
			var content = $.trim(contentValue.replace(/&nbsp;/g, ''));
			$("#<portlet:namespace/>description_"+languageId).val(content);
	<%	
		}
	%>
	return true;
}

function setCKeditor(){  
	var fileBrowserConectorURL = "<%=connectorURL%>";
	fileBrowserConectorURL = fileBrowserConectorURL +"&currentFolder=${currentFolder}";
	var ckEditorLanguage = "<%=doasLocale%>";
	CKEDITOR.config.autoParagraph = false;
	CKEDITOR.config.tabSpaces = 0;
	if("${contentCheckAuth}" == 'TRUE'){
		<%
			for(Locale aLocale : locales){
				String languageId = LocaleUtil.toLanguageId(aLocale);
		%>	
			var languageId = "<%=languageId%>";
			CKEDITOR.replace( "<portlet:namespace/>description_"+languageId , {
				filebrowserImageBrowseUrl: "/edison-appstore-2016-portlet/editor/ckeditor/filemanger/browser.html?Connector="+fileBrowserConectorURL,
				language: ckEditorLanguage,
			    filebrowserUploadUrl: null,
			    toolbar : [
			        		['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
			         		['Bold', 'Italic', 'Underline', 'Strike'],
			         		['Subscript', 'Superscript'],
			         		'/',
			         		['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
			         		['Find', 'Replace', 'SpellChecker', 'Scayt'],
			         		['Outdent','Indent','Blockquote'],
			         		['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
			         		'/',
			         		['Source'],
			         		['Link', 'Unlink', 'Anchor'],
			         		['Image', 'Flash',  'Table', '-', 'Smiley', 'SpecialChar', 'LiferayPageBreak'],
			         		['A11YBtn']
			         	]
			});
			
			if(languageId != "${solver.selectLocaleId}" ){
				$("#<portlet:namespace/>descriptionDiv_"+languageId).hide();
			}
		<%	
			}
		%>
	}else{
		<%
		for(Locale aLocale : locales){
			String languageId = LocaleUtil.toLanguageId(aLocale);
		%>	
			var languageId = "<%=languageId%>";
			if(languageId != "${solver.selectLocaleId}" ){
				$("#<portlet:namespace/>descriptionDiv_"+languageId).hide();
			}
		<%	
			}
		%>
	}
}
function changeLocale(selectLocaleId){
	<%
	for(Locale aLocale : locales){
		String languageId = LocaleUtil.toLanguageId(aLocale);
	%>	
		var languageId = "<%=languageId%>";
		
		if(languageId != selectLocaleId ){
			console.log($("#<portlet:namespace/>descriptionDiv_"+languageId));
			$("#<portlet:namespace/>descriptionDiv_"+languageId).hide();
		}else{
			$("#<portlet:namespace/>descriptionDiv_"+languageId).show();
		}
	<%	
		}
	%>
	var solverInfoForm = document.<portlet:namespace/>solverInfoForm;
	solverInfoForm.<portlet:namespace/>selectLocaleId.value = selectLocaleId;
}

function <portlet:namespace/>addFavoriteApp(solverId,groupId) {
	var dataForm = {
		"<portlet:namespace/>solverId" : solverId,
		"<portlet:namespace/>groupId" : groupId
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=addFavoriteAppURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var result = msg.result;
			if(result == '200') {
				$("#favorites_off").hide();
				$("#favorites_on").show();
				$("#favorites_on").css("display", "inline");
			}else{
				alert("<liferay-ui:message key='edison-data-insert-error' />");
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>deleteFavoriteApp(solverId,groupId) {
	if(confirm("<liferay-ui:message key='edison-appstore-favorite-app-delete-alert' />")){	
		var dataForm = {
			"<portlet:namespace/>solverId" : solverId,
			"<portlet:namespace/>groupId" : groupId
		};
		
		jQuery.ajax({
			type: "POST",
			url: "<%=deleteFavoriteAppURL%>",
			async : false,
			data : dataForm,
			success: function(msg) {
				var result = msg.result;
				if(result == '200') {
					$("#favorites_off").show();
					$("#favorites_on").hide();
					$("#favorites_off").css("display", "inline");
					alert("<liferay-ui:message key='edison-data-delete-success' />");
				}
			},error:function(msg,e){ 
				alert(e);
				return false;
			}
		});

	}
}
</script>

<aui:script>
function <portlet:namespace/>moveSimulation(solverId, groupId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${simulationPlid}"); /* 시뮬레이션 Plid */ 
		portletURL.setPortletId("edisonbestsimulation_WAR_edisonsimulationportlet"); /* 시뮬레이션 포틀릿 ID */ 
		portletURL.setParameter("directGroupId", groupId);  /* 현재 groupId */ 
		portletURL.setParameter("directScienceAppId", solverId); /* 선택된 solverId */
		window.location.href = portletURL.toString();
	});
}
</aui:script>