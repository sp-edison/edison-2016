<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="virtualLabManagementListURL" id="virtualLabManagementList" copyCurrentRenderParameters="false" />

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList(1);
});

function <portlet:namespace/>dataSearchList(pageNumber) {
	if(pageNumber == 0) {
		$("#<portlet:namespace/>cur_page").val(1);
		$("#<portlet:namespace/>search_parameter").val("");
	} else {
		$("#<portlet:namespace/>cur_page").val(pageNumber);
	}
	
	var searchForm = $("form[name=searchForm]").serialize();
	
	jQuery.ajax({
		type: "POST",
		url: "<%=virtualLabManagementListURL%>",
		async : false,
		data : searchForm,
		success: function(msg) {
			var virtualLabManagementList = msg.virtualLabManagementList;
			var curPage = msg.curPage;
			var selectLine = msg.selectLine;
			var virtualLabCount = msg.virtualLabCount - ((curPage -1) * selectLine);
			var pageList = msg.pageList;
			
			var rowResult;
			$("#<portlet:namespace/>virtualLabListBody tr:not(:has(#1))").remove();
			
			if(virtualLabManagementList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "7")
						  .css("text-align","center")
						  .css("height", "40px")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>virtualLabListBody").append($rowResult);
			} else {
				for(var i = 0; i < virtualLabManagementList.length; i++) {
					$rowResult = $("<tr/>");
					
 					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
 					
					$rowResult.attr("onClick","<portlet:namespace/>moveVirtualLab('" + virtualLabManagementList[i].virtualLabId + "')")
							  .css("cursor","pointer");
					$("<td/>").text(virtualLabCount--)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabManagementList[i].virtualLabTitle)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabManagementList[i].virtualLabUniversityField)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabManagementList[i].virtualLabPersonName)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabManagementList[i].virtualLabOwnerName)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabManagementList[i].virtualLabRequestDt)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabManagementList[i].classCount + "<liferay-ui:message key='edison-virtuallab-course' />")
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

function <portlet:namespace/>moveVirtualLab(virtualLabId) {
	window.location.href = "${labURL}" + "&virtualLabId=" + virtualLabId;
}

function <portlet:namespace/>onKeyDown() {
	if(event.keyCode == 13 && $("#<portlet:namespace/>search_parameter").val() != ""){
		<portlet:namespace/>dataSearchList();
	}
}

</script>
<h1>
	<liferay-ui:message key='edison-virtuallab-management' />
</h1>
<div class="tabletopbox">
	<form id="searchForm" name="searchForm" method="post" onsubmit="return false;">
		<div class="search">
			<div class="searchbox">
				<input type="text" id="<portlet:namespace/>search_parameter" name="<portlet:namespace/>search_parameter" maxlength="15" placeholder="<liferay-ui:message key='edison-virtuallab-placeholder' />" onkeypress="<portlet:namespace/>onKeyDown(event);"/>
				<input id="<portlet:namespace/>cur_page" name="<portlet:namespace/>cur_page" type="hidden" value="1"/>
				<input type="button" onClick="<portlet:namespace/>dataSearchList()" class="btnsearch" />
			</div>
			<input type="button" onClick="<portlet:namespace/>dataSearchList(0)" class="button01" value="<liferay-ui:message key='edison-button-all-search' />" />
		</div>
		<div class="tabletopright">
			<select id="<portlet:namespace/>select_line" name="<portlet:namespace/>select_line" onchange="<portlet:namespace/>dataSearchList(1)" class="selectview">
				<option value="10">10<liferay-ui:message key='edison-search-views' /></option>
				<option value="20">20<liferay-ui:message key='edison-search-views' /></option>
				<option value="30">30<liferay-ui:message key='edison-search-views' /></option>
				<option value="40">40<liferay-ui:message key='edison-search-views' /></option>
			</select>
		</div>
	</form>
</div>

<div class="table1_list borderno">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="5%" />
			<col width="20%" />
			<col width="15%" />
			<col width="15%" />
			<col width="15%" />
			<col width="15%" />
			<col width="15%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-virtuallab' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-affiliate' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-tutor' /></th>
				<th align="center" scope="col"><liferay-ui:message key='category.admin' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-creation-date' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-virtualclasscnt' /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>virtualLabListBody">
		</tbody>
	</table>

	<div id="<portlet:namespace/>spaceDiv" align="center"></div>
	<div id="<portlet:namespace/>pageListDiv" class="paging"></div>
</div>
