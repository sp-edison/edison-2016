<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="virtualLabRequestListURL" id="virtualLabRequestList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="getSitePagePlidURL" id="getSitePagePlid" copyCurrentRenderParameters="false" />

<liferay-portlet:actionURL var="updateVirtualLabStatusURL" portletMode="view" copyCurrentRenderParameters="false" >
	<liferay-portlet:param name="myaction" value="updateVirtualLabStatus" />
</liferay-portlet:actionURL>

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList(1);
});

function <portlet:namespace/>dataSearchList(pageNumber) {
	if(pageNumber == 0) {
		$("#<portlet:namespace/>cur_page").val(1);
	} else {
		$("#<portlet:namespace/>cur_page").val(pageNumber);
	}
	
	var searchForm = $("form[name=searchForm]").serialize();
	
	jQuery.ajax({
		type: "POST",
		url: "<%=virtualLabRequestListURL%>",
		async : false,
		data : searchForm,
		success: function(msg) {
			var virtualLabRequestList = msg.virtualLabRequestList;
			var curPage = msg.curPage;
			var selectLine = msg.selectLine;
			var virtualLabCount = msg.virtualLabCount - ((curPage -1) * selectLine);
			var pageList = msg.pageList;
			
			var rowResult;
			$("#<portlet:namespace/>virtualLabListBody tr:not(:has(#1))").remove();
			
			if(virtualLabRequestList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "8")
						  .css("text-align","center")
						  .addClass("TC left")
						  .css("height", "40px")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>virtualLabListBody").append($rowResult);
			} else {
				for(var i = 0; i < virtualLabRequestList.length; i++) {
					$rowResult = $("<tr/>");
 					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
					$rowResult.attr("onClick","<portlet:namespace/>goRequestManagementURL('" + virtualLabRequestList[i].groupId + "','" + virtualLabRequestList[i].groupName + "')")
							  .css("cursor","pointer");
					$("<td/>").text(virtualLabRequestList[i].groupName)
							  .addClass("TC left")
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabRequestList[i].virtualLabTitle)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabRequestList[i].virtualLabUniversityField)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabRequestList[i].virtualLabPersonName)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(privateTextConverter2(virtualLabRequestList[i].userFirstName))
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabRequestList[i].userScreenName)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabRequestList[i].virtualLabRequestDt)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabRequestList[i].virtualLabStatusNm)
							  .css("text-align","center")
							  .appendTo($rowResult);
					
					$("#<portlet:namespace/>virtualLabListBody").append($rowResult);
				}
			}
			$("#<portlet:namespace/>pageListDiv").html(pageList);
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

</script>

<aui:script>
<!-- 가상실험실 요청관리 페이지 URL 생성 및 이동 -->
function <portlet:namespace/>goRequestManagementURL(groupId, groupName) {
	var dataForm = {
		"<portlet:namespace/>groupId" : groupId
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getSitePagePlidURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
		var requestPlid = msg.requestPlid;
		
		if(requestPlid > 0) {
			AUI().use("liferay-portlet-url", function(a) {
				var portletURL = Liferay.PortletURL.createRenderURL();
				portletURL.setPlid(requestPlid); <!-- 가상실험실 생성 관리 페이지 Plid -->
				portletURL.setPortletMode("view");
				portletURL.setWindowState("pop_up");
				portletURL.setPortletId("edisonvirtuallabrequestmanagement_WAR_edisonvirtuallab2016portlet"); <!-- 가상실험실 생성 관리 포틀릿 ID -->
				portletURL.setParameter("selectOption", 1401001); <!-- 가상실험실 생성 요청 코드 -->
				portletURL.setParameter("groupName", groupName); <!-- 분야 이름 -->
				
				Liferay.Util.openWindow(
					{
						dialog: {
							width:1280,
							height:850,
							cache: false,
							modal: true,
							draggable: false,
							resizable: false,
							destroyOnClose: true,
							after: {
								render: function(event) {
									$("button.btn.close").on("click", function(e){
										<portlet:namespace/>dataSearchList(1);
									});
								}
							}
						},
						id: 'edisonvirtuallabrequestmanagement_WAR_edisonvirtuallab2016portlet',
						uri: portletURL.toString()
					}
				);
				
			});
		} else{
			alert("<liferay-ui:message key='edison-virtuallab-not-page-permission' />");
		}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}
</aui:script>

<h1>
	<liferay-ui:message key='edison-virtuallab-request-list' />
</h1>

<div class="table1_list onhover">
	<form id="searchForm" name="searchForm" method="post" onsubmit="return false;">
		<input id="<portlet:namespace/>cur_page" name="<portlet:namespace/>cur_page" type="hidden" value="1" />
	</form>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="10%" />
			<col width="15%" />
			<col width="15%" />
			<col width="15%" />
			<col width="15%" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-site' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-virtuallab' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-affiliate' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-tutor' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-applicant' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-applicant-id' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-req-date' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-status' /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>virtualLabListBody" >
		</tbody>
	</table>
</div>
<div id="<portlet:namespace/>spaceDiv" align="center"></div>
<div id="<portlet:namespace/>pageListDiv" class="paging"></div>
