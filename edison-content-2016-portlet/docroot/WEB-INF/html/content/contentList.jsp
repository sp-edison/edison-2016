<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<link href="${contextPath}/css/owl-carousel/owl.carousel.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/css/owl-carousel/owl.theme.css" rel="stylesheet" type="text/css" />
<script src="${contextPath}/js/owl-carousel/owl.carousel.min.js"></script>
<%

	//Tab Setting
	String tabNames = (String)request.getAttribute("tabNames");
	String visitSite = CustomUtil.strNull(request.getAttribute("visitSite"));
	String parentGroupId = CustomUtil.strNull(request.getAttribute("parentGroupId"));
	String tabsValues = (String)request.getAttribute("tabsValues");
	String portletNameSpace = "_"+portletDisplay.getId()+"_"+"tagScript";
%>

<style type="text/css">
	.aui .contleftbox .contimg img{
		width: 220px;
		height: 200px;
		max-width: none; 
	}

	.aui .control-group{
		margin-bottom: 0px;
	}
	
	.aui input[type="text"],
	.aui input[type="password"],
	.aui textarea{
		margin-bottom: 0px;
	}
	
	.aui .long_field{
		width: 350px;
	}
	
	.aui .short_field{
		width: 200px;
	}
	
	.aui .edison_file{
		border:1px solid #CCCCCC;
		margin-bottom:2px;
	}
	
	.aui .input-localized-input{
		display: table-row;
	}
	
	.aui .icon-edison{
		font-family: fontawesome-alloy;
		display: inline;
		cursor: pointer;
		margin:0 1px 0 1px;
	}
	
	.aui .icon-edison.icon-file:before{
		content: "\f15b";
		font-size: 2em;
	}
	
	.aui .icon-edison.icon-picture:before{
		content: "\F03E";
		font-size: 2em;
	}
	
	.aui .icon-edison.icon-text:before{
		content: "\F15C";
		font-size: 2em;
	}
	
	#advanced-wrap {height: 72px; margin: 0 auto;}
	#advanced-wrap .contarrleft { width: 24px; height: 303px; display: table-cell; text-align: center; vertical-align: middle;}
	#advanced-wrap .contarrright { width: 24px; height: 303px; display: table-cell; text-align: center; vertical-align: middle;}
	#advanced-content-area{width: 1170px; float: left}
</style>
<liferay-portlet:resourceURL var="saveClickTab" id="cickTab" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="retrieveAdvancedURL" id="retrieveListAdvanced" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="retrieveGeneralURL" id="retrieveListGeneral" copyCurrentRenderParameters="false" escapeXml="false"/>

<liferay-portlet:renderURL var="advancedWriterURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="advancedModifyView" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="generalWriterURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="generalModifyView" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="generalFileDownloadURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="generalFileDownload" />
</liferay-portlet:renderURL>

<liferay-portlet:resourceURL var="edisonFileCountDownloadURL" escapeXml="false" id="edisonFileCountDownload" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="advancedContentViewCountURL" escapeXml="false" id="advancedContentViewCount" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="contentAuthCheckURL" escapeXml="false" id="contentAuthCheck" copyCurrentRenderParameters="false"/>
<c:if test="${not empty tabsValues}">
	<div class="contabmenu">
		<edison-ui:tabs names="<%=tabNames%>" tabsValues="<%=tabsValues%>" value="<%=visitSite%>" refresh="<%=false%>" onClick="<%=portletNameSpace%>" minwidth="230"/>
	</div>
</c:if>
<h1><liferay-ui:message key="edison-content"/></h1>
<div id="advanced-wrap" style="display: table;">
	<div class="contarrleft rolling-button">
		<a id="rollingPrev" href="#rollingPrev" title="preview" ><img src="${contextPath}/images/content/subarrow_left.gif" alt="preview" /></a>
	</div>
	<div id="advanced-content-area" class="owl-carousel owl-theme" style="display:table-cell;">
	</div>
	<div class="contarrright rolling-button">
		<a id="rollingNext" href="#rollingNext" title="nextview"><img src="${contextPath}/images/content/subarrow_right.gif" alt="nextview" /></a>
	</div>
</div>
<c:if test="${isSiteAdministratorThan}">
	<div style="float: right;margin: 5px;">
		<input type="button" class="button06" value="<liferay-ui:message key="edison-advanced-content-create"/>" onclick="<portlet:namespace/>advancedModify('<%=Constants.ADD%>','');return false;"/>
	</div>
</c:if>

<div class="clear"></div>
<div class="h40"></div>
<!--table view -->
<div class="tabletopbox clear">
	<div class="search03">
		<div class="searchbox03">
			<input name="<portlet:namespace/>textfield" type="text" id="<portlet:namespace/>textfield" placeholder="<liferay-ui:message key="edison-table-list-header-title"/> or <liferay-ui:message key="edison-table-list-header-name"/>" size="40" onKeydown="if(event.keyCode ==13)<portlet:namespace/>generalContentSearch('','');" />
			<input type="button" name="fullsize" id="fullsize" value="" class="btnsearch" onclick="<portlet:namespace/>generalContentSearch('','');">
		</div>
		
		<input type="button" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-all-search"/>" class="button01" onclick="<portlet:namespace/>dafaultContentAllSearch();">
	</div>
	
	<!--중앙탭-->
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
	<input type="hidden" id="projectDetailViewValue" value="${projectDetailView.projectView}"/>
	<input type="hidden" id="projectDetailViewSeqValue" value="${projectDetailView.contentSeq}"/>
	<input type="hidden" id="projectDetailViewDivValue" value="${projectDetailView.contentDiv}"/>
	<input type="hidden" id="projectDetailViewGroupIdValue" value="${projectDetailView.groupId}"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="일반콘텐츠 테이블">
		<colgroup>
			<col width="70" />
			<col width="70" />
			<col width="*" />
			<col width="100" />
			<col width="100" />
			<col width="100" />
			<col width="110" />
			<col width="100" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-index" /></th>
				<th scope="col">&nbsp;</th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-title"/></th>
				<th scope="col">&nbsp;</th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-name"/></th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-date"/></th>
				<th scope="col"><liferay-ui:message key="edison-table-list-header-file"/></th>
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


<c:if test="${addGeneralContentAuth}">
	<div class="buttonbox" style="position: absolute; bottom: 24px; width:auto; right:1%;">
		<input type="button" class="button06" value="<liferay-ui:message key="edison-content-create" />" onclick="<portlet:namespace/>generalModify('<%=Constants.ADD%>','');return false;"/>
	</div>
</c:if>
	
<div id="advanced-writer-dialog" title="고급 콘텐츠 등록" class="bigpopupbox" style="display: none;">

</div>

<div id="general-writer-dialog" title="일반 콘텐츠 등록" class="bigpopupbox" style="display:none;">

</div>

<div id="general-file-download-dialog" title="일반 콘텐츠 파일 다운로드" class="bigpopupbox" style="display:none;">

</div>

<script type="text/javascript">
//선택한 Tab Id
var selectedTabId = "";

//liferay-ui 탭 이벤트 return Script
function <portlet:namespace/>tagScript(tabUrl,tabNames,value,scriptName){
	var searchData = {"<portlet:namespace/>groupId":value};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=saveClickTab%>",
		async : false,
		data  : searchData,
		success: function(data) {
			selectedTabId = value;
			
			<portlet:namespace/>advancedContentSearch(selectedTabId);
			<portlet:namespace/>generalContentSearch("","");
		},error:function(data,e){
			alert("tagScript ERROR-->"+e);
		}
	});
}

//고급 콘텐츠 조회
function <portlet:namespace/>advancedContentSearch(groupId){
	if(selectedTabId==""){
		selectedTabId = "<%=visitSite%>";
	}
	
	if(selectedTabId==""){
		if("<%=visitSite%>"==""){
			var tabsValues = "<%=tabsValues%>";
			var groupIdArray = tabsValues.split(",");
			groupId = groupIdArray[0];
		}else{
			selectedTabId = "<%=visitSite%>";
			groupId = selectedTabId;
		}
	}
	var searchData = {
					"<portlet:namespace/>groupId":groupId
					};
	jQuery.ajax({
		type: "POST",
		url: "<%=retrieveAdvancedURL%>",
		async : false,
		data  : searchData,
		dataType: 'json',
		success: function(data) {
			var dataSize = data.dataList.length;
			var dataMap = data.dataList;
			$advancedContentArea = $("#advanced-content-area");
			$advancedContentArea.empty();
			
			$advancedWrap = $("#advanced-wrap");
			if(dataSize>0){
				//rolling View
				$advancedWrap.show();
				
				if(dataSize<3){
					//rollgin button hide
					$("#advanced-wrap .rolling-button").hide();
				}else{
					$("#advanced-wrap .rolling-button").show();
				}
				
				for(var i = 0 ; i < dataSize; i++ ){
					$contentboxDiv = $("<div></div>").addClass("owl-item contentbox");
					
					$contleftboxDiv = $("<div></div>").addClass("contleftbox").appendTo($contentboxDiv);
					$("<div></div>").addClass("contimg").appendTo($contleftboxDiv)
					.append(
							$("<img/>").attr("src",dataMap[i].fileUrl+"&imageThumbnail=2") 
									   .css("cursor","pointer")
									   .attr("onclick","<portlet:namespace/>advancedContentView('"+dataMap[i].contentFilePath+"/"+dataMap[i].contentStartFileNm+"','"+dataMap[i].title+"','"+dataMap[i].groupId+"','"+dataMap[i].contentSeq+"')")
					);
					
					
					$contrightboxDiv = $("<div></div>").addClass("contrightbox").appendTo($contentboxDiv);
					
					$contrighttxtDiv = $("<div></div>").addClass("contrighttxt").appendTo($contrightboxDiv);
					$ulFirst = $("<ul></ul>").appendTo($contrighttxtDiv);

					if(dataMap[i].updateAuth == "true"){
						 $lang = null;
						if(dataMap[i].serviceLanguage == "ko_KR"){
							$lang = "&nbsp;<liferay-ui:message key='edison-board-radiobutton-ko_KR'/>";
						}else if(dataMap[i].serviceLanguage == "en_US"){
							$lang = "&nbsp;<liferay-ui:message key='edison-board-radiobutton-en_US'/>";
						} 
						
						
						$("<li></li>").addClass("title01").html("<liferay-ui:message key="edison-content-service-language"/>").appendTo($ulFirst);
						$("<li></li>").addClass("border0").appendTo($ulFirst)
						.append(
								$("<img/>").attr("src","${contextPath}/images/toplink_"+dataMap[i].serviceLanguage+".gif") 
						).append($lang);
					}
					
					$("<li></li>").addClass("title01").html("<liferay-ui:message key="edison-table-list-header-topic"/>").appendTo($ulFirst);
					$("<li></li>").addClass("border0").css("word-break","break-all").html(dataMap[i].title).appendTo($ulFirst);
					
					
					$ulFirst2 = $("<ul></ul>").appendTo($contrighttxtDiv);
					$("<li></li>").addClass("title01").html("<liferay-ui:message key="edison-table-list-header-resume"/>").appendTo($ulFirst2);
					$("<li></li>").addClass("border0")
								  .css("word-break","break-all").html(dataMap[i].resume).appendTo($ulFirst2);
					
					if(dataMap[i].updateAuth=="true"){
						$ulSecond = $("<ul></ul>").appendTo($contrighttxtDiv);
						$updateLi = $("<li></li>").addClass("border0").appendTo($ulSecond);
						$("<input/>").attr("type","button")
									 .attr("value",Liferay.Language.get('edison-button-board-modify'))
									 .attr("onclick","<portlet:namespace/>advancedModify('<%=Constants.UPDATE%>','"+dataMap[i].contentSeq+"')")
									 .addClass("button02")
									 .appendTo($updateLi);
					}
					
					$advancedContentArea.append($contentboxDiv);
				}
				
				//rolling
				var rolling = $("#advanced-content-area");
				rolling.owlCarousel({
					items : 2,
					autoPlay : 8000,
					rewindSpeed : 2000,
					pagination : false
				});
				rolling.data('owlCarousel').reinit();
				
			}else{
				$advancedWrap.hide();
			}
		},error:function(data,e){
			alert("advancedContentSearch ERROR-->"+e);
		}
	});
}

//고급 콘텐츠 상세보기
function <portlet:namespace/>advancedContentView(fileFullPath,title,groupId,contentSeq){
	window.open("/content"+fileFullPath);	
	
	//고급 컨텐츠 카운트 Update
	var updateCntForm = {
		"<portlet:namespace/>groupId" : groupId,
		"<portlet:namespace/>contentSeq" : contentSeq
		};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=advancedContentViewCountURL%>",
		data: updateCntForm,
  		async : false,
		error:function(data,e){ 
			alert("fileCntUpdate ERROR"+e);	
		}
	});
}


//일반컨텐츠 파일 다운로드 카운트 올리기
function <portlet:namespace/>fileCntUpdate(p_fileEntryId,groupId,contentDiv,contentSeq){
		var updateCntForm = {
				"<portlet:namespace/>groupId" : groupId,
				"<portlet:namespace/>contentDiv" : contentDiv,
				"<portlet:namespace/>contentSeq" : contentSeq
				};
	
		jQuery.ajax({
			type: "POST",
			url: "<%=edisonFileCountDownloadURL%>",
			data: updateCntForm,
	  		async : false,
			success: function(data) {
				var cnt = data.downloadCnt;
				$("#downloadTd_"+contentSeq).html(cnt);
				<portlet:namespace/>fileDownload(p_fileEntryId);
			},error:function(data,e){ 
				alert("fileCntUpdate ERROR"+e);	
			}
		});
	
}

//고급콘텐츠 modify  
function <portlet:namespace/>advancedModify(mode,seq){
	if(selectedTabId==""){
		selectedTabId = "<%=visitSite%>";
	}
	if(<portlet:namespace/>checkAuth("advanced",selectedTabId)){
		<portlet:namespace/>advancedDialogOpen(mode,selectedTabId,seq);
	}else{
		alert(Liferay.Language.get('edison-content-insert-advancedcontent-auth-error'));
	}
 	
}

//고급콘텐츠 수정 팝업 open
function <portlet:namespace/>advancedDialogOpen(mode,groupId,seq){
	//$("#advanced-writer-dialog").dialog("option","tabId","123");
	var URL = "<%=advancedWriterURL%>&<portlet:namespace/>mode="+mode+"&<portlet:namespace/>groupId="+groupId;
	if(seq!=""){
		URL +="&<portlet:namespace/>contentSeq="+seq;
	}
	$("#advanced-writer-dialog").load(URL, function (e) {
		$("#advanced-writer-dialog").dialog("open");
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

//일반 콘텐츠 조회
var currentPage = "";
function <portlet:namespace/>generalContentSearch(searchDiv,p_currentPage){
	//page
	currentPage = p_currentPage;
	
	//검색어
	var searchText = $("#<portlet:namespace/>textfield").val();
	
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
		"<portlet:namespace/>searchText":searchText,
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
					if(dataMap[i].updateAuth=="true"  || dataMap[i].siteOwnerRole==true || dataMap[i].siteManagerRole==true){ 
						$modifyTd = $("<td></td>").addClass("TC").appendTo($tr);
						
						$("<input/>").attr("type","button")
									 .addClass("button02")
									 .attr("value",Liferay.Language.get('edison-button-board-modify'))
									 .attr("onclick","<portlet:namespace/>generalModify('<%=Constants.UPDATE%>','"+dataMap[i].contentSeq+"','"+dataMap[i].contentDiv+"');")
									 .appendTo($modifyTd);
					}else{
						$titleTd.attr("colspan","2");
					}
					
					$("<td></td>").addClass("TC").html(privateInformationConverter(dataMap[i].screenName)).appendTo($tr);
					
					$("<td></td>").addClass("TC").html(dataMap[i].insertDate).appendTo($tr);
					
					$downLoadImageTd = $("<td></td>").addClass("TC").appendTo($tr);
					var fileDataSize = dataMap[i].fileList.length;
					var fileDataMap = dataMap[i].fileList;
					
					if(fileDataSize>0){
						iClass = "icon-text";
						$("<i></i>").addClass("icon-edison")
										.addClass(iClass)
										.attr("onclick","<portlet:namespace/>fileCntUpdate('"+dataMap[i].groupId+"','"+dataMap[i].contentDiv+"','"+dataMap[i].contentSeq+"');")
										.appendTo($downLoadImageTd);
					} 
					
					$("<td></td>").attr("id","downloadTd_"+dataMap[i].contentSeq).addClass("TC").html(dataMap[i].downloadCnt).appendTo($tr);
				}
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

//일반콘텐츠 Modify
function <portlet:namespace/>generalModify(mode,seq,searchDivCd){
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
	
	if(<portlet:namespace/>checkAuth("general",groupId)){
		if(mode=="<%=Constants.UPDATE%>"){
			<portlet:namespace/>generalDialogOpen(mode,groupId,seq,searchDivCd);
		}else{
			<portlet:namespace/>generalDialogOpen(mode,groupId,seq,"");
		}
	}else{
		alert(Liferay.Language.get('edison-content-insert-defaultcontent-auth-error'));
	}
	
}

//일반 콘텐츠 페이징조회
function <portlet:namespace/>generalContentPageSearch(p_currentPage){
	<portlet:namespace/>generalContentSearch("",p_currentPage);
}

//일반콘텐츠 등록 Dialog open
function <portlet:namespace/>generalDialogOpen(mode,tabId,seq,contentDiv){
	if(selectedTabId==""){
		selectedTabId = "<%=visitSite%>";
	}
	
	var URL = "<%=generalWriterURL%>&<portlet:namespace/>mode="+mode+"&<portlet:namespace/>groupId="+tabId;
	if(seq!=""){
		URL +="&<portlet:namespace/>contentSeq="+seq;
		URL +="&<portlet:namespace/>contentDiv="+contentDiv;
	}
	
	$("#general-writer-dialog").load(URL, function (e) {
		$("#general-writer-dialog").dialog("open")
	});
}

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

//일반컨텐츠 파일 다운로드 카운트 올리기
function <portlet:namespace/>fileCntUpdate(groupId,contentDiv,contentSeq){
		 var updateCntForm = {
				"<portlet:namespace/>groupId" : groupId,
				"<portlet:namespace/>contentDiv" : contentDiv,
				"<portlet:namespace/>contentSeq" : contentSeq
				};
	
		jQuery.ajax({
			type: "POST",
			url: "<%=edisonFileCountDownloadURL%>",
			data: updateCntForm,
	  		async : false,
			success: function(data) {
				var cnt = data.downloadCnt;
				$("#downloadTd_"+contentSeq).html(cnt);
				
				//file download
				/* <portlet:namespace/>fileDownload(p_fileEntryId); */
				
				<portlet:namespace/>generalDialogFileDownloadOpen(groupId,contentSeq,contentDiv);
				
			},error:function(data,e){ 
				alert("fileCntUpdate ERROR"+e);	
			}
		});
	
}

//일반컨텐츠 파일다운로드
function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

//일반콘텐츠 파일 Dialog open
function <portlet:namespace/>generalDialogFileDownloadOpen(tabId,seq,contentDiv){
	if(tabId==""){
		if("<%=visitSite%>"==""){
			var tabsValues = "<%=tabsValues%>";
			var groupIdArray = tabsValues.split(",");
			groupId = groupIdArray[0];
		}else{
			tabId = "<%=visitSite%>";
			groupId = tabId;
		}
	}else{
		groupId = tabId;
	}
	
	var URL = "<%=generalFileDownloadURL%>&<portlet:namespace/>groupId="+groupId;
	if(seq!=""){
		URL +="&<portlet:namespace/>contentSeq="+seq;
		URL +="&<portlet:namespace/>contentDiv="+contentDiv;
	}
	
	$("#general-file-download-dialog").load(URL, function (e) {
		$("#general-file-download-dialog").dialog("open")
	});
}

//권한 체크
function <portlet:namespace/>checkAuth(mode,selectedTabId){
	if(<%=isAdministrator%>){
		return true;
	}else{
		var searchData = {
				"<portlet:namespace/>mode":mode,
				"<portlet:namespace/>groupId":selectedTabId
				};
		var returnVal;
		jQuery.ajax({
			type: "POST",
			url: "<%=contentAuthCheckURL%>",
			async : false,
			data  : searchData,
			dataType: 'json',
			success: function(data) {
				var returnAuth = data.contentCheckAuth;
				if(returnAuth=="TRUE"){
					returnVal = true;
				}else{
					returnVal = false;
				}
			},error:function(data,e){
				alert("checkAuth ERROR-->"+e);
			}
		});
		return returnVal;
	}
}

AUI().ready(function() {
	var rolling = $("#advanced-content-area");
	
	//초기조회
	<portlet:namespace/>advancedContentSearch("<%=visitSite%>");
	<portlet:namespace/>generalContentSearch("","");
	$("#rollingNext").click(function(e){
		e.preventDefault();
		rolling.trigger('owl.next');
		rolling.trigger('owl.play',5000);
	});
	
	$("#rollingPrev").click(function(e){
		e.preventDefault();
		rolling.trigger('owl.prev');
		rolling.trigger('owl.play',5000);
	});
	
	$("#general-writer-dialog").dialog({
		autoOpen: false,
		width: 914,
	    height: 'auto',
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
	    open: function(event, ui) {
	    	$(this).parent().css('overflow', 'visible');
	    	$(this).css('overflow', 'visible');
	    	$(this).removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    	
	    	$('.ui-widget-overlay').bind('click',function(){
	    		<portlet:namespace/>generalContentSearch("","");
	    		$("#general-writer-dialog").dialog("close");
	    	})
	    },
	    close: function() {
	    	$("#general-writer-dialog").empty();
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	$("#general-file-download-dialog").dialog({
		autoOpen: false,
		width: 500,
	    height: 540,
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
	    open: function(event, ui) {
	    	$(this).parent().css('overflow', 'visible');
	    	$(this).css('overflow', 'visible');
	    	$(this).removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    	

	    	$('.ui-widget-overlay').bind('click',function(){
	    		<portlet:namespace/>generalContentSearch("","");
	    		$("#general-file-download-dialog").dialog("close");
	    	})
	    },
	    close: function() {
	    	$("#general-file-download-dialog").empty();
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	
	$("#advanced-writer-dialog").dialog({
		autoOpen: false,
		width: 914,
		height: 'auto',
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
	    open: function(event, ui) {
	    	$(this).parent().css('overflow', 'visible');
	    	$(this).css('overflow', 'visible');
	    	$(this).removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    	
	    	$('.ui-widget-overlay').bind('click',function(){
	    		$("#advanced-writer-dialog").dialog("close");
	    	})
	    },
	    close: function() {
	    	$("#advanced-writer-dialog").empty();
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	

	
	////프로젝트관리에서 콘텐츠 항목 상세보기 누를시 팝업띄우기
	if($("#projectDetailViewValue").val() == "detail"){
		<portlet:namespace/>generalModify("update",$("#projectDetailViewSeqValue").val(),$("#projectDetailViewDivValue").val());
	}
});
</script>
