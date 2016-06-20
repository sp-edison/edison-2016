<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%
	String searchSwNm = LanguageUtil.get(themeDisplay.getLocale(), "edison-appstore-solver-name");
	String searchSwTitle = LanguageUtil.get(themeDisplay.getLocale(), "edison-table-list-header-app-title");
	String searchOrgNm = LanguageUtil.get(themeDisplay.getLocale(), "edison-table-list-header-orgNm");
	String searchDev = LanguageUtil.get(themeDisplay.getLocale(), "developer");
	String searchAll = "("+searchSwTitle+"+"+searchSwNm+"+"+searchOrgNm+"+"+searchDev+")";
%>
<head>
<!-- <link rel="stylesheet" href="https://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" /> -->

<liferay-portlet:resourceURL var="resorceSearchURL" 		escapeXml="false" id="searchList" 	 copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="resorceConfigURL" 		escapeXml="false" id="searchConfig"  copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="solverTypeListURL" 		escapeXml="false" id="solverTypeList" 	 copyCurrentRenderParameters="false"/>

<liferay-portlet:renderURL plid="${simulationPlid}" portletName="_SIMULATION_WAR_edisonportlet_" portletMode="view" var="exeURL"/>

<liferay-portlet:actionURL var="redirectSolverExeURL"  portletMode="view" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="redirectSolverExe"/>
	<liferay-portlet:param name="redirect" value="<%=exeURL%>"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL var="renderViewURL">
	<portlet:param name="myaction" value="detailView" />
	<portlet:param name="edionCopyParam" value="true" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="saveClickTabURL" portletMode="view" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="saveClickTab"/>
</liferay-portlet:actionURL>

<liferay-portlet:resourceURL var="saveClickTab" id="cickTab" copyCurrentRenderParameters="false" escapeXml="false"/>

<liferay-portlet:resourceURL var="favoriteAppListURL" id="favoriteAppList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="deleteFavoriteAppURL" id="deleteFavoriteApp" copyCurrentRenderParameters="false" />

<style type="text/css">
.aui .tabletopbox .radio{
	float:left;
	padding-right: 20px;
}

#solverTypeBody .portalClass:hover ,.onClass{
	background-color:#e5eff8;
}
.tail {
	border-color:#e5eff8 transparent transparent transparent;
	border-width:8px;
	border-style:solid;
	margin-left:-7px;
	width:0px;
	height:0px;
	position:absolute;
	display:none;
}
.onClass .tail {
	display:block;
}
#solverTypeBody .portalClass:hover .tail {
	display:block;
}

#solverTypeBody .siteClass:hover , .onClass2{
	background-color:#f2efeb;
}
.tail2 {
	border-color:#f2efeb transparent transparent transparent;
	border-width:8px;
	border-style:solid;
	margin-left:-7px;
	width:0px;
	height:0px;
	position:absolute;
	display:none;
}
.onClass2 .tail2 {
	display:block;
}
#solverTypeBody .siteClass:hover .tail2 {
	display:block;
}
.sideline{
	width:1px; background-color:#e5e5e5;
}
</style>


</head>
<body>
	<%
	//Tab Setting
		String tabNames = (String)request.getAttribute("tabNames");
// 		String visitSite = CustomUtil.strNull(request.getAttribute("visitSite"), String.valueOf(themeDisplay.getScopeGroupId()));
		String tabsValues = (String)request.getAttribute("tabsValues");
		String portletNameSpace = "_"+portletDisplay.getId()+"_"+"tagScript";
		String visitSite = CustomUtil.strNull(request.getAttribute("visitSite"));
	%>
	<form name="form" method="post" action="<%=exeURL%>">
		<input name="<portlet:namespace/>id"    type="hidden"/>
	</form>
	<c:if test="${not empty tabsValues}">
		<div class="contabmenu"> 
			<edison-ui:tabs names="<%=tabNames%>" tabsValues="<%=tabsValues%>" value="<%=visitSite%>" refresh="<%=false%>" onClick="<%=portletNameSpace%>" minwidth="230"/>
		</div>
	</c:if>
	<!--table view -->
	<h1>ScienceApp</h1> 
	
	<div class="scAppmenu">
		<div class="table5app" style="border:none;">
			<table width="100%" height="146" border="0" cellpadding="0" cellspacing="0" >
				<tr id="solverTypeBody" style="border-left:1px solid #e5e5e5; border-right:1px solid #e5e5e5;">
				</tr>
			</table>
		</div>
	</div>
	
	<div class="h40"></div>
		
	<form method="post" name="searchParamForm" style="margin:0px;" onsubmit="return false;">
		<input type="hidden" id="<portlet:namespace/>groupId" 			name="<portlet:namespace/>groupId"						value=""/>
		<input type="hidden" id="<portlet:namespace/>p_curPage" 		name="<portlet:namespace/>p_curPage" 					value="${params.p_curPage}"/>
		<input type="hidden" id="<portlet:namespace/>categoryId"		name="<portlet:namespace/>categoryId"					 value="${params.categoryId}"/>
		
		<div class="tabletopbox clear">
			<div class="search"> 
				<input type="button" value="<liferay-ui:message key="edison-button-all-search" />" class="button01" id="initB">
				<div class="searchbox">
					<input name="<portlet:namespace/>searchValue" type="text" id="<portlet:namespace/>searchValue" size="40" onKeydown="if(event.keyCode ==13)<portlet:namespace/>dataSearchList();" value ="${params.searchValue}" autocomplete="off"/>
					<input type="button" id="keyWordB">
				</div>
			</div>
			<div class="tabletopright">
				<select id="<portlet:namespace/>linePerPage" name="<portlet:namespace/>linePerPage" onchange="<portlet:namespace/>dataSearchList()" class="selectview">
					<option value="10" <c:if test="${params.linePerPage == '10' }"> selected="selected"</c:if> >10<liferay-ui:message key='edison-search-views' /></option>
					<option value="20" <c:if test="${params.linePerPage == '20' }"> selected="selected"</c:if>>20<liferay-ui:message key='edison-search-views' /></option>
					<option value="30" <c:if test="${params.linePerPage == '30' }"> selected="selected"</c:if>>30<liferay-ui:message key='edison-search-views' /></option>
					<option value="40" <c:if test="${params.linePerPage == '40' }"> selected="selected"</c:if>>40<liferay-ui:message key='edison-search-views' /></option>
				</select>
			</div>
			<div class="search_toggle" style="padding:7px 0px; display:none; width:99%; height:100%; background-color: #FFFFFF; margin: 0 auto;color: #777; border: 5px solid #67788a;" >
				<fieldset class="group" style="padding-left: 20px;">
					<aui:input name="searchOption" type="radio" label="<%=searchAll%>" cssClass="searchoption" value="ALL" checked="true"/>
					<aui:input name="searchOption" type="radio" label="<%=searchSwTitle%>" cssClass="searchoption" value="SWTITLE"/>
					<aui:input name="searchOption" type="radio" label="<%=searchSwNm%>" cssClass="searchoption" value="SWNM" />
					<aui:input name="searchOption" type="radio" label="<%=searchOrgNm%>" cssClass="searchoption" value="SWORGNM"/>
					<aui:input name="searchOption" type="radio" label="<%=searchDev%>" cssClass="searchoption" value="SWDEV"/>
				</fieldset>
			</div>
		</div>
	</form>

	 <!-- sw 선택 리스트 ---->
	<div class="table0_list borderno">
		<table  width="100%"  border="0" cellspacing="0" cellpadding="0">
			 <colgroup>
              <col width="70" />
              <col width="70" />
              <col width="*" />
              <col width="70" />
              <col width="120" />
              <col width="100" />
              <col width="150" />
              <col width="100" />
              <col width="100" />
            </colgroup>
			
			<thead>
				<tr>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-index" /></th> 		<!-- 순번 -->
					<th scope="col">&nbsp;</th> 															<!-- nbsp --> 	
					<th scope="col"><liferay-ui:message key="edison-table-list-header-app-title" /></th> 		<!-- SW 명 --> 
					<th scope="col"><liferay-ui:message key="edison-table-list-header-version" /></th>			<!-- 버전 --> 
					<th scope="col"><liferay-ui:message key="edison-table-list-header-orgNm" /></th> 		<!-- 기관명 -->
					<th scope="col"><liferay-ui:message key='edison-table-list-header-name' /></th>								<!-- 개발자 -->
					<th scope="col"><liferay-ui:message key="edison-table-list-header-date" /></th>		<!-- 등록일시 -->
					<th scope="col"><liferay-ui:message key="edison-table-list-header-manual" /></th>		<!-- 매뉴얼 -->
					<th scope="col"><liferay-ui:message key="edison-table-list-header-run" /></th>		<!-- 실행 -->
				</tr>
			</thead>
			<tbody id="<portlet:namespace/>summaryListBody">
			</tbody>
	  </table>
	</div>
	
	<div id="pageListDiv" class="paging"></div>
	
</body>
<script>
	//선택한 Tab Id
	var selectedTabId = "";
	
	$(document).ready(function(){
		
		(function(jQuery) {
			jQuery.fn.<portlet:namespace/>clickoutside = function(callback) {
				var outside = 1, self = $(this);
					self.cb = callback;
					this.click(function() {
						outside = 0;
					});
				$(document).click(function() {
					outside && self.cb();
					outside = 1;
					});
				return $(this);
			}
		})(jQuery);
		
		$("#<portlet:namespace/>searchValue").focus(function(){
			if($(".search_toggle").is(":hidden")){
				$('.search_toggle').slideToggle('fast');
			}
		});
		
		$(".tabletopbox").<portlet:namespace/>clickoutside(function(){
			var search_val = $("#<portlet:namespace/>searchValue").val();
			if(search_val==""&&!$(".search_toggle").is(":hidden")){$('.search_toggle').slideToggle('fast');}
		});
		
		
		selectedTabId = "<%=visitSite%>";
		
		<portlet:namespace/>dataSearchList("${params.p_curPage}");
		solverTypeList();
	});
	
	//liferay-ui 탭 이벤트 return Script
	function <portlet:namespace/>tagScript(tabUrl,tabNames,value,scriptName){
		window.location.href = "<%= saveClickTabURL.toString() %>"+"&<portlet:namespace/>groupId=" + value;
 	}
	
	//필터 조회
	function solverTypeList(){
		var searchData = {
				"<portlet:namespace/>groupId":selectedTabId
		};

		jQuery.ajax({
			type: "POST",
			url: "<%=solverTypeListURL%>",
			async:true,
			data: searchData,
			success:function(solverTypeList){
				$("#solverTypeBody").empty();
				var evalDataMap = eval('(' + solverTypeList + ')');
				var dataMap = evalDataMap.solverTypeList;
				var solverTypeCount = dataMap.length;
				var solverTypeWidth = 99 / solverTypeCount;
				if("${tabViewYn}" == "Y") {
					for (var i = 0; i < solverTypeCount; i++) {
						var imageValue = "";
						if(typeof dataMap[i].image != "undefined") imageValue = dataMap[i].image.value;
						$categoryTd = $("<td/>").attr("id", "solvertype_" + dataMap[i].categoryId)
								  .attr("onClick", "solverTypeClick(" + dataMap[i].categoryId + ")")
								  .attr("width", solverTypeWidth + "%")
								  .css("cursor","pointer")
								  .css("border", "none")
								  .addClass("portalClass")
								  .append(
										$("<div/>").append(
														   $("<img/>").attr("src", "${contextPath}/images/solverType/" + imageValue +  ".png").css("margin", "15px 0px 0px 0px").css("height", "76px").css("max-width", "100px")
										  )
								  ).append(
										   $("<div/>").css("height", "55px").css("margin", "0 auto")
													  .append(
															  $("<p/>").html(dataMap[i].title).css("padding","3px").css("margin", "0px").css("word-break","keep-all")
										   )
								  ).append(
										   $("<div/>").addClass("tail")
													  .css("left", ((solverTypeWidth / 2) + (solverTypeWidth * i)) + (0.1 * i) + "%")
								  ).appendTo($("#solverTypeBody"));
						
						if(dataMap[i].categoryId=="${params.categoryId}"){
							$categoryTd.addClass("onClass");
						}
						
						if(i != (dataMap.length -1)) {
							$("<td/>").css("width", "1px")
									  .css("padding", "20px 0px")
									  .css("border","none")
									  .append(
										$("<div/>").append(
												   $("<img/>").attr("src", "${contextPath}/images/categ_divline01.gif")
										  )
										)
									  .appendTo($("#solverTypeBody"));
						}
						
					}
				} else {
					for (var i = 0; i < dataMap.length; i++) {
						$categoryTd = $("<td/>").attr("id", "solvertype_" + dataMap[i].categoryId)
								  .attr("onClick", "solverTypeClick(" + dataMap[i].categoryId + ")")
								  .attr("width", solverTypeWidth + "%")
								  .css("cursor","pointer")
								  .css("border", "none")
								  .addClass("siteClass")
								  .append(
										$("<div/>").append(
														   $("<img/>").attr("src", "${contextPath}/images/solverType/" + dataMap[i].image.value + ".png").css("margin", "15px 0px 0px 0px").css("height", "76px").css("max-width", "100px")
										  )
								  ).append(
										   $("<div/>").css("height", "55px").css("margin", "0 auto")
													  .append(
															  $("<p/>").html(dataMap[i].title).css("padding","3px").css("margin", "0px").css("word-break","keep-all")
										   )
								  ).append(
										   $("<div/>").addClass("tail2")
													  .css("left", ((solverTypeWidth / 2) + (solverTypeWidth * i)) + (0.1 * i) + "%")
								  ).appendTo($("#solverTypeBody"));
						
						if(dataMap[i].categoryId=="${params.categoryId}"){
							$categoryTd.addClass("onClass2");
						}
						
						if(i != (dataMap.length -1)) {
							$("<td/>").css("width", "1px")
									  .css("padding", "20px 0px")
									  .css("border","none")
									  .append(
										$("<div/>").append(
												$("<img/>").attr("src", "${contextPath}/images/categ_divline01.gif")
											)
										)
									  .appendTo($("#solverTypeBody"));
						}
						
					}
				}
			}
		});
	}
	
	//DataList
	function <portlet:namespace/>dataSearchList(p_curPage){
			if(p_curPage == null || p_curPage == 0){
				p_curPage = "1";
			}
			
			var currentTabGroupId = <%=visitSite%>;
			
			<% if(isLogin) {%>
			var dataForm = {
			};
			
			jQuery.ajax({
				type: "POST",
				url: "<%=favoriteAppListURL%>",
				async : false,
				data : dataForm,
				success: function(msg) {
					var favoriteAppList = msg.favoriteAppList;
					var favoriteAppManualList = msg.favoriteAppManualList;
					
					var rowResult;
					$("#<portlet:namespace/>summaryListBody tr:not(:has(#1))").remove();
					
					if(typeof favoriteAppList == "undefined" || favoriteAppList.length == 0) {
						
					} else {
						for(var i = 0; i < favoriteAppList.length; i++) {
							$rowResult = $("<tr/>").css("border-bottom", "1px solid rgb(224, 224, 224)");
							$("<td/>").append($("<img/>").attr("src", "${contextPath}/images/scienceappstoreview/favoriteiconon.png")
									  .attr("onClick", "event.cancelBubble=true; <portlet:namespace/>deleteFavoriteApp('" + favoriteAppList[i].scienceAppId + "','"+ favoriteAppList[i].groupId +"');")
									  .text(favoriteAppList[i].title)
									  .attr("width","20")
									  .attr("height","18")
									  .attr("alt","Icon")
									  .css("cursor", "pointer")
							 		 ).addClass("TC").appendTo($rowResult);
							
							var vSolverIconId = 0;
							var vSolverImageSrc = "";
							vSolverIconId = favoriteAppList[i].iconId;
							
							if(typeof vSolverIconId != "undefined"){
								vSolverImageSrc = spaceDelete("/documents/"+favoriteAppList[i].iconRepositoryId+"/"+favoriteAppList[i].iconUuid); 
							}else{
								vSolverImageSrc = "${contextPath}/images/scienceappstorelist/sc_appbox.jpg";
							}
							
							$("<td/>").addClass("TC").append(
								$("<img/>").attr("src",vSolverImageSrc)
										   .attr("onerror","this.src='${contextPath}/images/scienceappstorelist/sc_appbox.jpg'")
										   .css("width","33px")
										   .css("height","27px")
										   .attr("alt","Icon")
							).addClass("TC").appendTo($rowResult);
							
							$("<td/>").css("word-break", "break-all")
							   		  .css("text-align","left")
									  .text(favoriteAppList[i].title + '(' + favoriteAppList[i].name + ')')
							   		  .attr("onclick","javascript:detailView('goView','"+favoriteAppList[i].scienceAppId +"', '"+ currentTabGroupId +"' )")
									  .css("cursor", "pointer")
							 		  .appendTo($rowResult);
							
							$("<td/>").text(favoriteAppList[i].version)
									  .addClass("TC").appendTo($rowResult);
							$("<td/>").text(favoriteAppList[i].affiliation)
									  .addClass("TC").appendTo($rowResult);
							$("<td/>").text(favoriteAppList[i].screenName)
									  .addClass("TC").appendTo($rowResult);
							var createDate = new Date(favoriteAppList[i].createDate.time);
							$("<td/>").text(formatDate(createDate) ).addClass("TC").appendTo($rowResult);
							
							if(typeof favoriteAppManualList[i].fileEntryId == "undefined") {
								$("<td/>").css("text-align","center").append(
										$("<img/>").attr("align","center")
												   .attr("id","manualLinkBtn")
												   .attr("src","${contextPath}/images/btn_manual_none.jpg")
												   .css("height", "28px")
												   .css("cursor","default")
									).appendTo($rowResult);
							} else {
								$("<td/>").css("text-align","center").append(
										$("<img/>").attr("align","center")
												   .attr("id","manualLinkBtn")
												   .attr("src","${contextPath}/images/btn_manual.jpg")
												   .attr("onclick", "<portlet:namespace/>fileDownload('" + favoriteAppManualList[i].fileEntryId + "')")
												   .css("height", "28px")
												   .css("cursor", "pointer")
												   .hover(
													  function(){
													  	$(this).attr("src","${contextPath}/images/btn_manual.jpg");
													  },
													  function(){
													  	$(this).attr("src","${contextPath}/images/btn_manual.jpg");
													  }
													)
									).appendTo($rowResult);
							}
							
							//실행
							$("<td/>").css("text-align","center").append(
									$("<img/>").attr("src","${contextPath}/images/btn_run.jpg")
												.attr("id","manualLinkBtn")
												.attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveSimulation('" + favoriteAppList[i].scienceAppId + "', '" + currentTabGroupId + "');")
												.css("height", "28px")
												.css("cursor","pointer")
												.css("vertical-align","middle")
												.hover(
												  function(){
												  	$(this).attr("src","${contextPath}/images/btn_run.jpg");
												  },
												  function(){
												  	$(this).attr("src","${contextPath}/images/btn_run.jpg");
												  }
												)
							).appendTo($rowResult);
							
							
							$("#<portlet:namespace/>summaryListBody").append($rowResult);
						}
					}
				},error:function(msg,e){ 
					alert(e);
					return false;
				}
			});			
		<% }else{ %>
			$("#<portlet:namespace/>summaryListBody tr:not(:has(#1))").remove();
		<%}%>
			
			document.searchParamForm.<portlet:namespace/>groupId.value = selectedTabId;
			document.searchParamForm.<portlet:namespace/>p_curPage.value = p_curPage;
			var searchForm = $("form[name=searchParamForm]").serialize();
		jQuery.ajax({
			type: "POST",
			url: "<%=resorceSearchURL%>",
			data: searchForm,
			success: function(msg) {
				var dataMap = eval("(" + msg + ")");
				var vSummaryListBody =  document.getElementById("<portlet:namespace/>summaryListBody");
				var vRow, vCell;
				
// 				$("#<portlet:namespace/>summaryListBody tr:not(:has(#1))").remove();
				
				if(dataMap.dataList.length==0){
					$vRow = $("<tr/>");
					$("<td/>").attr("colSpan","9")
							  .html("<p><liferay-ui:message key='edison-there-are-no-data' /></p>")
							  .css("textAlign","center")
							  .appendTo($vRow);
					
					$("#<portlet:namespace/>summaryListBody").append($vRow);
				}else{
					var pageNum = dataMap.totalCnt - (p_curPage-1) * dataMap.select_line;
					
					for(var i=0; i<dataMap.dataList.length;i++){
						
						$vRow = $("<tr/>");
						
						$("<td/>").text(pageNum--).addClass("TC").appendTo($vRow);
						
						var vSolverIconId = 0;
						var vSolverImageSrc = "";
						vSolverIconId = dataMap.dataList[i].iconId;
						
						if(typeof vSolverIconId != "undefined"){
							vSolverImageSrc = spaceDelete("/documents/"+dataMap.dataList[i].iconRepositoryId+"/"+dataMap.dataList[i].iconUuid); 
						}else{
							vSolverImageSrc = "${contextPath}/images/scienceappstorelist/sc_appbox.jpg";
						}
						
						$("<td/>").addClass("TC").append(
							$("<img/>").attr("src",vSolverImageSrc)
									   .attr("onerror","this.src='${contextPath}/images/scienceappstorelist/sc_appbox.jpg'")
									   .css("width","33px")
									   .css("height","27px")
									   .attr("alt","Icon")
						).appendTo($vRow);
						
						$tdRow = $("<td/>").css("word-break", "break-all")
										   .css("text-align","left")
										   .text(dataMap.dataList[i].title+"("+dataMap.dataList[i].name+")")
										   .attr("onclick","javascript:detailView('goView','"+dataMap.dataList[i].scienceAppId+"', '"+currentTabGroupId+"')")
										   .css("cursor", "pointer")
						$tdRow.appendTo($vRow);
						
						$("<td/>").text(dataMap.dataList[i].version).addClass("TC").appendTo($vRow);
						$("<td/>").text(dataMap.dataList[i].affiliation).addClass("TC").appendTo($vRow);
						
						$("<td/>").text(dataMap.dataList[i].screenName).addClass("TC").appendTo($vRow);
						var createDate = new Date(dataMap.dataList[i].createDate);
						$("<td/>").text(formatDate(createDate) ).addClass("TC").appendTo($vRow);

						
						//메뉴얼
						if(typeof dataMap.dataList[i].manualId == "undefined"){
							$("<td/>").css("text-align","center").append(
								$("<img/>").attr("align","center")
										   .attr("id","manualLinkBtn")
										   .attr("src","${contextPath}/images/btn_manual_none.jpg")
										   .css("height", "28px")
										   .css("cursor","default")
							).appendTo($vRow);
						}else{
							$("<td/>").css("text-align","center").append(
									$("<img/>").attr("align","center")
											   .attr("id","manualLinkBtn")
											   .attr("src","${contextPath}/images/btn_manual.jpg")
											   .attr("onclick", "<portlet:namespace/>fileDownload('" + dataMap.dataList[i].manualId + "')")
											   .css("height", "28px")
											   .css("cursor", "pointer")
											   .hover(
												  function(){
												  	$(this).attr("src","${contextPath}/images/btn_manual.jpg");
												  },
												  function(){
												  	$(this).attr("src","${contextPath}/images/btn_manual.jpg");
												  }
												)
								).appendTo($vRow);
						}
						
						//실행
						$("<td/>").css("text-align","center").append(
								$("<img/>").attr("src","${contextPath}/images/btn_run.jpg")
											.attr("id","manualLinkBtn")
											.attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveSimulation('" + dataMap.dataList[i].scienceAppId + "','" + currentTabGroupId + "');")
											.css("height", "28px")
											.css("cursor","pointer")
											.css("vertical-align","middle")
											.hover(
											  function(){
											  	$(this).attr("src","${contextPath}/images/btn_run.jpg");
											  },
											  function(){
											  	$(this).attr("src","${contextPath}/images/btn_run.jpg");
											  }
											)
						).appendTo($vRow);
						
						
						$("#<portlet:namespace/>summaryListBody").append($vRow);
					}
					
					
					//즐겨 찿기 솔버 추가 후에 검색한 솔버가 없을 경우 no-data 표시
					if(dataMap.totalCnt==0){
						$vRow = $("<tr/>");
						$("<td/>").attr("colSpan","9")
								  .html("<p><liferay-ui:message key='edison-there-are-no-data' /></p>")
								  .css("textAlign","center")
								  .appendTo($vRow);
						
						$("#<portlet:namespace/>summaryListBody").append($vRow);
					}
					
				}
				//페이징 초기화pageListDiv
				document.getElementById("pageListDiv").innerHTML = dataMap.pageList;
			},
			error:function(msg){
				alert("System Exception : " + msg);
			}
		});
	}
	
	function solverTypeClick(categoryId) {
		if("${tabViewYn}" == "Y") {
			$(".onClass").removeClass("onClass");
			$("#solvertype_" + categoryId).addClass("onClass");
		} else {
			$(".onClass2").removeClass("onClass2");
			$("#solvertype_" + categoryId).addClass("onClass2");
		}
		
		/* 필터 초기화 */
		var searchForm = document.searchParamForm;
		var categoryIdValue = searchForm.<portlet:namespace/>categoryId;
		categoryIdValue.value		=	categoryId;
		<portlet:namespace/>dataSearchList();
	}
	
	
	function detailView(mode, solverId, groupId){
		var searchForm = document.searchParamForm;
		
		var URL = "<%=renderViewURL%>&<portlet:namespace/>solverId="+solverId+"&<portlet:namespace/>groupId="+groupId;
		var curPage = searchForm.<portlet:namespace/>p_curPage.value;
		var categoryId = searchForm.<portlet:namespace/>categoryId.value;
		var searchValue = searchForm.<portlet:namespace/>searchValue.value;
		var linePerPage = searchForm.<portlet:namespace/>linePerPage.value;
		var searchOption = searchForm.<portlet:namespace/>searchOption.value;
		
		
		URL +="&<portlet:namespace/>p_curPage="+curPage;
		URL +="&<portlet:namespace/>categoryId="+categoryId;
		URL +="&<portlet:namespace/>searchValue="+searchValue;
		URL +="&<portlet:namespace/>linePerPage="+linePerPage;
		URL +="&<portlet:namespace/>searchOption="+searchOption;
		location.href=URL;
	}
	
	filter = function(){
		$("#<portlet:namespace/>dialog-message").dialog("open");
	};
	
	
	//초기화
	 function filterInit (){
		
		var searchForm = document.searchParamForm;
		var searchValue = searchForm.<portlet:namespace/>searchValue;
		var categoryId = searchForm.<portlet:namespace/>categoryId;
		
		
		searchValue.value 			=	"";
		categoryId.value			=	"";
		
		$("#<portlet:namespace/>linePerPage").find('option:first').attr('selected', 'selected');
		
		if("${parentChildTab}" == 0) {
			$(".onClass").removeClass("onClass");
		} else {
			$(".onClass2").removeClass("onClass2");
		}
		
// 		<portlet:namespace/>dataSearchList();
		
		//form 초기화 적용
		searchForm.submit();
	};
	
	
	//검색
	$(document).on( "click", "#keyWordB", function(){
		<portlet:namespace/>dataSearchList();
	});
	
	//전체보기
	$(document).on( "click", "#initB", function(){
		filterInit();
		if(!$(".search_toggle").is(":hidden")&&!$(".search_toggle").is(":animated")){$('.search_toggle').slideToggle('fast');}
	});
	
	
	$(function() {
		//매뉴얼 Event
		$("img[id=manualLinkBtn]").on("click", function(){
			var url = spaceDelete($(this).attr("manual-link"));
			window.open(url,"_blank");
		}),
		//실행 Event
		$("img[id=exeLinkBtn]").on("click", function(){
			var form = document.form;
			form.id.value = $(this).attr("exe-id");
			if(loginDefaultUserStatus=="true"){
				alert('<liferay-ui:message key="edison-simulation-please-login" />');
				form.action = "<%=redirectSolverExeURL%>";
			}
			form.submit();
		}),
		//세부화면
		$("#simulationView").on("click",function(){
			detailView('goView', $(this).attr("data-id"));
		}),
		
		//문제필터
		$("#configFilter").find("td").on("click",function(event){
			alert("click configFilter")
			if(!$(event.target).is("input")){
				if($(this).has(":input").length>0){
					var checkbox = $(':checkbox', $(this)).get(0);
					var checked = checkbox.checked;
					if (checked == false) checkbox.checked = true;
					else checkbox.checked = false;
				}
			}
		});
		
	});

	$(document).on( "click", "#configFilter td", function(event){
		if(!$(event.target).is("input")){
			if($(this).has(":input").length>0){
				var checkbox = $(':checkbox', $(this)).get(0);
				var checked = checkbox.checked;
				if (checked == false){ checkbox.checked = true;}
				else checkbox.checked = false;
			}
		}
	});
	
	function <portlet:namespace/>fileDownload(p_fileEntryId){
		location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
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
						alert("<liferay-ui:message key='edison-data-delete-success' />");
					}
					<portlet:namespace/>dataSearchList();
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
		portletURL.setPlid("${simulationPlid}");
		portletURL.setPortletId("edisonbestsimulation_WAR_edisonsimulationportlet"); 
		portletURL.setParameter("directGroupId", groupId);
		portletURL.setParameter("directScienceAppId", solverId);
		window.location.href = portletURL.toString();
	});
}
</aui:script>