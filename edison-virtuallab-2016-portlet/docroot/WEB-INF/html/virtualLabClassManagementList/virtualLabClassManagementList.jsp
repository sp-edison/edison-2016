<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="virtualLabClassManagementListURL" id="virtualLabClassManagementList" copyCurrentRenderParameters="false" />

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
		url: "<%=virtualLabClassManagementListURL%>",
		async : false,
		data : searchForm,
		success: function(msg) {
			var virtualLabClassManagementList = msg.virtualLabClassManagementList;
			var curPage = msg.curPage;
			var selectLine = msg.selectLine;
			var virtualLabClassCount = msg.virtualLabClassCount - ((curPage -1) * selectLine);
			var pageList = msg.pageList;
			
			var rowResult;
			$("#<portlet:namespace/>virtualLabListBody tr:not(:has(#1))").remove();
			
			if(virtualLabClassManagementList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "7")
						  .css("text-align","center")
						  .css("height", "40px")
						  .text("<liferay-ui:message key='edison-search-no-result' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>virtualLabListBody").append($rowResult);
			} else {
				for(var i = 0; i < virtualLabClassManagementList.length; i++) {
					$rowResult = $("<tr/>").attr("onClick", "<portlet:namespace/>moveVirtualLabClass('" + virtualLabClassManagementList[i].classId + "')")
										   .css("cursor","pointer");
					
 					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
 					
					$("<td/>").text(virtualLabClassCount--)
							  .addClass("nothover")
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassManagementList[i].virtualLabTitle)
							  .addClass("nothover")
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassManagementList[i].virtualLabUniversityFieldNm)
							  .addClass("nothover")
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassManagementList[i].virtualLabPersonName)
							  .addClass("nothover")
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassManagementList[i].classTitle)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassManagementList[i].classCreateDt)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassManagementList[i].userCount + virtualLabClassManagementList[i].tempUserCount + "(" + virtualLabClassManagementList[i].userCount + "/" + virtualLabClassManagementList[i].tempUserCount + ")")
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

function <portlet:namespace/>moveVirtualLabClass(classId) {
	window.location.href = "${classURL}" + "&classId=" + classId;
}

function <portlet:namespace/>onKeyDown(e){
	if(e.keyCode == 13){
		<portlet:namespace/>dataSearchList();
		return false;
	}
}

</script>
<h1>
	<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-virtual-class-management' />
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
			<select id="<portlet:namespace/>select_line" name="<portlet:namespace/>select_line" onchange="<portlet:namespace/>dataSearchList(0)" class="selectview">
				<option value="10">10<liferay-ui:message key='edison-search-views' /></option>
				<option value="20">20<liferay-ui:message key='edison-search-views' /></option>
				<option value="30">30<liferay-ui:message key='edison-search-views' /></option>
				<option value="40">40<liferay-ui:message key='edison-search-views' /></option>
			</select>
		</div>
	</form>
</div>

<div class="table1_list borderno onhover">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="5%" />
			<col width="20%" />
			<col width="15%" />
			<col width="15%" />
			<col width="20%" />
			<col width="12%" />
			<col width="13%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-virtuallab' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-affiliation' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-professor' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-virtualclass' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-creation-date' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-total-number2' /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>virtualLabListBody">
		</tbody>
	</table>
</div>
<div id="<portlet:namespace/>spaceDiv" align="center"></div>
<div id="<portlet:namespace/>pageListDiv" class="paging"></div>
