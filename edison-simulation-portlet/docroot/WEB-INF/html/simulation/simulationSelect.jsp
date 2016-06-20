<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<style>
<!--

#banner-wrap { width: 860px; height: 96px; margin: 0 auto;}
#banner-wrap ul{ height: 140px; }
#banner-wrap li{ list-style: none;}
#banner-wrap .rolling-button { float: left; padding-left: 5px; margin-top: 35px;}
#rolling-banner { width: 790px; float: left;}

@media all and (max-width:750px){
	#banner-wrap { width: 100%;}
	#rolling-banner { width: 80%;}
}
	 
.popupWrap {
    clear: left;
    padding: 5px;
    border-width: 1px;
    border-color: #f9f9f9;
    
    background-color: #f9f9f9;
} 
.popupTitle {
	width: 80%;
	height:50px;
	float: left;
	padding-left: 47px;
	padding-right: 10px;	
	font-size: 20px;
	font-weight: 600;
	line-height: 50px;
	background: url(/edison-simulation-portlet/images/bcicon.png) no-repeat 10px 10px;
}

.dataTitle{
	width: 18%;
	height:50px;
	float: left;
	padding-left: 10px;
	padding-right: 10px;	
	font-size: 17px;
	font-weight: 600;
	line-height: 50px;
}
.popupClose {
	width: 30px;
	float: right;
 	padding: 10px 10px 0px 0px;
	font-size: 24px;
	font-weight: 600;
}
.popupTrLine {
	width:95%;
	padding-bottom:10px;
	margin-top:10px;
	border-bottom: solid 1px #ccc;
}

.popupTxt {
	font-size: 14px;
	font-weight: 600;
	color: #666;
	line-height: 25px;
	padding: 10px 10px 10px 10px;
}

--> 
</style>
		
<div class="table2_list" style="min-height: 315px; clear: both;">	
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list" style="table-layout: fixed;">
		<colgroup>
			<col width="70">
			<col width="70">
			<col width="*">
			<col width="180">
			<col width="120">
			<col width="120">
			<col width="120">
		</colgroup>
		<thead>
			<tr>
				<th><liferay-ui:message key="edison-table-list-header-index" /></th>
				<th colspan="2"><liferay-ui:message key="edison-table-list-header-app-title" /></th>
				<th><liferay-ui:message key="edison-table-list-header-orgNm" /></th>
				<th><liferay-ui:message key="edison-table-list-header-name" /></th>
				<th><liferay-ui:message key="edison-table-list-header-manual" /></th>
				<th><liferay-ui:message key="edison-science-appstore-view-tab-detail-view" /></th>
			</tr>
		</thead>
		<tbody id="scienceAppListBody">
		</tbody>
	</table>
</div>

<%-- <div style="width:100%;text-align: center;">${pagingStr }</div> --%>
 <!-- 페이지 네비게이션 ---->
<div id="<portlet:namespace/>pageListDiv" class="paging" ></div>

<div id="scienceAppDetailView" class="newWindow" style="background-color:#fff; width:990; height:700; overflow-x:hidden;overflow-y:hidden;padding:0px;">	

	<div class="newWheader">
		<div class="newWtitlebox"><img src="${contextPath}/images/title_newWindow.png" width="34" height="34" />
			<div class="newWtitle"><liferay-ui:message key="edison-science-appstore-view-tab-detail-view" /></div>
		</div>
		<div class="newWclose"><img id="advanced-writer-dialog-close-btn" name="advanced-writer-dialog-close-btn" src="${contextPath}/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer;" onClick="$('#scienceAppDetailView').dialog('close');" /></div>
	</div>
	<div class="newWcont">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="min-height: 300px;">
			<colgroup>
				<col width="100" />
				<col width="600"/>
			</colgroup>
			<tbody>
				<tr>
					<th class="tbcell0301">Description</th>
					<td  class="tbcell0401" id="<portlet:namespace/>scienceApp_description" />
				</tr>
			</tbody>
		</table>
	</div>
</div>

<script type="text/javascript">


// 사이언스앱 리스트에서 사이언스앱 선택
function scienceAppListClick(trObject){
	if($(trObject).attr("scienceAppId") != null && $(trObject).attr("scienceAppId") != ""){
		
		simulationAllInit();
		
		$("#<portlet:namespace/>scienceApp_name").val($(trObject).attr("scienceApp_name"));
		$("#<portlet:namespace/>scienceAppId").val($(trObject).attr("scienceAppId"));
		
		$("#scienceAppListBody > tr > td").css("backgroundColor", "transparent");	
		$(trObject).find("td").css("backgroundColor", "#bed8f5");
		
		$("#workflowerButtonValue1").text($(trObject).attr("scienceAppTitle"));
		
		//시뮬레이션 생성의 솔버정보 출력
		simulationMetaInfoSet(); //simulationCreate.jsp
	}
}

function searchListAll(p_curPage){
	$("#<portlet:namespace/>searchValue").val("");
//	filterInit(); // 문제필터 관련 초기화
	dataSearchList(p_curPage);
}


//DataList
function dataSearchList(p_curPage){
	if(p_curPage==null){
		p_curPage = "1";
	} 
		
	$("#<portlet:namespace/>curPage").val(p_curPage);
	
	var searchParamForm = $("form[name=<portlet:namespace/>searchParamForm]").serialize();
	var simulationForm = $("form[name=<portlet:namespace/>simulationForm]").serialize();
	if(searchParamForm != "") {
		searchForm = searchParamForm + "&" + simulationForm;
	} else {
		searchForm = simulationForm;
	}
	
	simulationAllInit();
	
	jQuery.ajax({
		type: "POST",
		url: "<%=searchListURL%>",
		data: searchForm,
		async:false,
		success: function(msg) {
			var totalCnt = msg.totalCnt;
			var scienceAppList = msg.scienceAppList;
			var pagingStr = msg.pagingStr;
						
			var vRow, vCell;
			
			$("#scienceAppListBody tr:not(:has(#1))").remove();
			
			if(scienceAppList.length==0){
				$vRow = $("<tr/>");
				$("<td/>").attr("colSpan","7")
						  .html("<p><liferay-ui:message key='edison-there-are-no-data' /></p>")
						  .addClass("TC")
						  .appendTo($vRow);
				
				$("#scienceAppListBody").append($vRow);
			}else{
				if($("#searchValue").val() != ""){
//					insertAutoComplete();
				}
				for(var i=0; i<scienceAppList.length;i++){
  					
					$vRow = $("<tr/>").attr("onclick", "scienceAppListClick(this)")
										.attr("scienceAppId",scienceAppList[i].scienceAppId)
										.attr("scienceApp_name",scienceAppList[i].name)
										.attr("scienceAppTitle",scienceAppList[i].title)
										.css("cursor", "pointer");
					
					
					if(i%2==1) $vRow.addClass("tablebgtr");
					var rowNum = parseInt(totalCnt) - (i +(6*(parseInt(p_curPage)-1)));
					
					$("<td/>").text(rowNum)
					 			.addClass("TC")
								.appendTo($vRow);
					
					var vScienceAppIconId = 0;
					var vScienceAppImageSrc = "";
					vScienceAppIconId = scienceAppList[i].iconId;
					
					if(typeof vScienceAppIconId != "undefined"){
						vScienceAppImageSrc = "/documents/"+scienceAppList[i].iconRepositoryId+"/"+scienceAppList[i].iconUuid; 
					} else {
						vScienceAppImageSrc = "${contextPath}/images/sc_appbox.jpg";
					}
					
					$("<td/>").append(
									$("<img/>").attr("src",vScienceAppImageSrc)
											   .attr("onerror","this.src='${contextPath}/images/sc_appbox.jpg'")
											   .css("width","33px")
											   .css("height","27px")
											   .attr("alt","Icon")
									).addClass("TC")
									.appendTo($vRow);

					$("<td/>").text(scienceAppList[i].title + "(" + scienceAppList[i].name+")")
								.addClass("TL")
								.addClass("wrapContent")
								.appendTo($vRow);

					
					$("<td/>").text(scienceAppList[i].affiliation)
								.addClass("TC")
								.appendTo($vRow);

					$("<td/>").text(scienceAppList[i].firstName)
							 	.addClass("TC")
								.appendTo($vRow);
					
					if(typeof scienceAppList[i].manualId == "undefined"){
						$("<td/>").append(
								$("<img/>").attr("src","${contextPath}/images/btn_manual_none.jpg").css("cursor", "default")
								).addClass("TC").appendTo($vRow);
					} else {
						$("<td/>").append(
										$("<img/>").attr("src","${contextPath}/images/btn_manual.jpg")
												   .attr("onClick", "<portlet:namespace/>fileDownload('"+scienceAppList[i].manualId+"')")
												   .css("cursor","pointer")
										).addClass("TC").appendTo($vRow);
					}
			
					$("<td/>").append(
							$("<img/>").attr("src","${contextPath}/images/btn_simuldetail.jpg")
									   .attr("onClick", "scienceAppDetailViewClick('"+scienceAppList[i].scienceAppId+"')")
									   .css("cursor","pointer")
									   .hover(
											  function(){
											  	$(this).attr("src","${contextPath}/images/btn_simuldetail.jpg");
											  },
											  function(){
											  	$(this).attr("src","${contextPath}/images/btn_simuldetail.jpg");
											  }
											  )
							).addClass("TC").appendTo($vRow);
					
					
					$("#scienceAppListBody").append($vRow);
				}
			}
			//페이징 초기화pageListDiv
			document.getElementById("<portlet:namespace/>pageListDiv").innerHTML = pagingStr;
		},
		error:function(msg){
			alert("System Exception : " + msg);
		}
	});
}

function scienceAppDetailViewClick(p_scienceAppId){

	jQuery.ajax({
		type: "POST",
		url: "<%=getScienceAppDetailViewURL%>",
		data: {	"<portlet:namespace/>scienceAppId": p_scienceAppId, "<portlet:namespace/>groupId":"<%=visitSite%>"	},
		async:false,
		success: function(data) {
			if(data.resultMsg == "SUCCESS"){				
				$("#<portlet:namespace/>scienceApp_description").html(data.description);
				$('#scienceAppDetailView').dialog('open');
				
			}else{
				alert("scienceAppDetailViewClick ERROR ");
			}
			
		},
		error:function(msg){
			alert("System Exception : " + msg);
		}
	});
}

$("#scienceAppDetailView").dialog({
	resizable: false,
	height:'auto',
	width:'auto',
	modal: true,
	draggable: true,
	autoOpen : false,
    show: {effect:'fade', speed: 800}, 
    hide: {effect:'fade', speed: 200},
    close: function() {
    }
}).dialog("widget").find(".ui-dialog-titlebar").remove();

dataSearchList("1");


</script>
