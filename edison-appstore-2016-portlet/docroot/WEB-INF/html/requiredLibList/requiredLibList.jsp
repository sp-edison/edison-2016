<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="org.kisti.edison.science.service.constants.RequiredLibConstants" %>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="requiredLibListURL" id="requiredLibList" copyCurrentRenderParameters="false" />
<liferay-portlet:renderURL copyCurrentRenderParameters="false" var="libChangeRenderUrl" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="myRender" value="libChangeRender"/>
</liferay-portlet:renderURL>
<h1>
	<liferay-ui:message key='edison-science-appstore-library-request-list' />
</h1>
<div class="table1_list onhover">
	<form id="searchForm" name="searchForm" method="post" onsubmit="return false;">
		<input id="<portlet:namespace/>cur_page" name="<portlet:namespace/>cur_page" type="hidden" value="1" />
		<div class="tabletopbox clear">
			<div class="search"> 
				<input type="button" value="<liferay-ui:message key="edison-button-all-search" />" class="button01" id="initB" onclick="<portlet:namespace/>dataALLSearchList();">
				<div class="searchbox">
					<input name="<portlet:namespace/>searchAppName" type="text" id="<portlet:namespace/>searchAppName" 
						style="margin-bottom: 2px;" size="40" onKeydown="if(event.keyCode ==13)<portlet:namespace/>dataSearchList();" value ="${params.searchValue}" autocomplete="off" placeholder='<liferay-ui:message key="edison-appstore-solver-name"/>'/>
					<input type="button" id="keyWordB" onclick="<portlet:namespace/>dataSearchList();">
				</div>
			</div>
			<div class="tabletopright">
				<select id="<portlet:namespace/>searchState" name="<portlet:namespace/>searchState" onchange="<portlet:namespace/>dataSearchList()" class="selectview" style="margin-bottom: 15px;">
					<option value="" <c:if test="${params.searchState == 'All' }"> selected="selected"</c:if> ><liferay-ui:message key='full' /></option>
					<option value="Require" <c:if test="${params.searchState == 'Require' }"> selected="selected"</c:if> ><liferay-ui:message key='edison-science-appstore-library-require' /></option>
					<option value="Complete" <c:if test="${params.searchState == 'Complete' }"> selected="selected"</c:if>><liferay-ui:message key='edison-science-appstore-library-complete' /></option>
					<option value="Reject" <c:if test="${params.searchState == 'Reject' }"> selected="selected"</c:if>><liferay-ui:message key='edison-virtuallab-denial' /></option>
				</select>
			</div>
		</div>
	</form>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="20%" />
			<col width="*" />
			<col width="15%" />
			<col width="15%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-appstore-solver-name' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-science-appstore-library-name' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-version' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-req-date' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-status' /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>RequiredLibListBody" >
		</tbody>
	</table>
</div>
<div id="<portlet:namespace/>spaceDiv" align="center"></div>
<div id="<portlet:namespace/>pageListDiv" class="paging"></div>

<script type="text/javascript">
var lib_state_require = "<%=RequiredLibConstants.LIB_STATE_REQUIRE%>";
var lib_state_complete = "<%=RequiredLibConstants.LIB_STATE_COMPLETE%>";
var lib_state_reject = "<%=RequiredLibConstants.LIB_STATE_REJECT%>";

AUI().ready(function() {
	<portlet:namespace/>dataSearchList(1);
});

function <portlet:namespace/>dataALLSearchList() {
	$("#<portlet:namespace/>cur_page").val(1);
	$("#<portlet:namespace/>searchAppName").val("");
	$("#<portlet:namespace/>searchState").val("").prop("selected", true);
	<portlet:namespace/>dataSearchList();
}

function <portlet:namespace/>dataSearchList(pageNumber) {
	if(pageNumber == 0) {
		$("#<portlet:namespace/>cur_page").val(1);
	} else {
		$("#<portlet:namespace/>cur_page").val(pageNumber);
	}
	
	var searchForm = $("form[name=searchForm]").serialize();
	jQuery.ajax({
		type: "POST",
		url: "<%=requiredLibListURL%>",
		async : false,
		data : searchForm,
		success: function(msg) {
			var requiredLibList = msg.requiredLibList;
			var curPage = msg.curPage;
			var selectLine = msg.selectLine;
			var developerRequestCount = msg.requiredLibCount - ((curPage -1) * selectLine);
			var pageList = msg.pageList;
			
			var rowResult;
			$("#<portlet:namespace/>RequiredLibListBody tr:not(:has(#1))").remove();
			
			if(requiredLibList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "5")
						  .css("text-align","center")
						  .addClass("TC left")
						  .css("height", "40px")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>RequiredLibListBody").append($rowResult);
			} else {
				for(var i = 0; i < requiredLibList.length; i++) {
					$rowResult = $("<tr/>");
 					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
 					
 					
					$rowResult.attr("onClick","<portlet:namespace/>changePopup('"+requiredLibList[i].requiredLibId+"','"+requiredLibList[i].scienceAppId+"')")
							  .css("cursor","pointer");
					$("<td/>").text(requiredLibList[i].scienceAppName)
							  .addClass("TC left")
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(requiredLibList[i].libraryName)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(requiredLibList[i].libraryVersion)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(requiredLibList[i].requiredDate)
							  .css("text-align","center")
							  .appendTo($rowResult);
					var stateText = "";
					if(lib_state_require == requiredLibList[i].state){
						stateText = "<liferay-ui:message key='edison-science-appstore-library-require' />";
					}else if(lib_state_complete == requiredLibList[i].state){
						stateText = "<liferay-ui:message key='edison-science-appstore-library-complete' />";
					}else if(lib_state_reject == requiredLibList[i].state){
						stateText = "<liferay-ui:message key='edison-virtuallab-denial' />";
					}
					$("<td/>").text(stateText)
							  .css("text-align","center")
							  .appendTo($rowResult);
					
					$("#<portlet:namespace/>RequiredLibListBody").append($rowResult);
				}
			}
			$("#<portlet:namespace/>pageListDiv").html(pageList);
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>changePopup(p_requiredLibId, p_scienceAppId){
	var width = 630;
	var height = 530;
	var left = (screen.width/2)-(width/2);
	var top = (screen.height/2)-(height/2);
	var url = "<%=libChangeRenderUrl%>&<portlet:namespace/>requiredLibId="+p_requiredLibId+"&<portlet:namespace/>scienceAppId="+p_scienceAppId;
 	var popup = window.open(url,"CHANGE_POPUP","directories=no, height="+height+", width="+width+", top="+top+",left="+left+", location=no, menubar=no, resizable=yes, scrollbars=yes, status=no, toolbar=no"); 	
	popup.focus();		
}
</script>
