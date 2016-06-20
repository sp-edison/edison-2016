<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="myContentForProjectListURL" id="myContentForProjectList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="updateMyContentProjectCategoryURL" id="updateMyContentProjectCategory" copyCurrentRenderParameters="false" />


<style type="text/css">

</style>

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList(1);
	
	/* var display = "${display}";
	if(display == "VIEW") {
		$("#<portlet:namespace/>display").css("display", "block");
	} else {
		$(".portlet-borderless-container").css("min-height", "0");
	} */
});

function <portlet:namespace/>updateContentProjectCategoryId(selectId, contentSeq){
	if(confirm(Liferay.Language.get("edison-project-management-app-update-confirm"))){
		var selectedCategoryId = $("#"+selectId).val();
		var groupId = $("#<portlet:namespace/>groupId").val();
		
		jQuery.ajax({
			type: "POST",
			url: "<%=updateMyContentProjectCategoryURL%>",
			async : false,
			data : {
				"<portlet:namespace/>groupId": groupId,
				"<portlet:namespace/>selectedCategoryId": selectedCategoryId,
				"<portlet:namespace/>contentSeq":contentSeq
			},
			success: function(data) {
				alert(data.msg);
				$("#<portlet:namespace/>select_project").val("0");
				//<portlet:namespace/>dataSearchList(1);
			},
			error: function(data) {
				alert(data.msg);
			}
		});
	
	}
}
function <portlet:namespace/>dataSearchListAll(){
	$("#<portlet:namespace/>textfield").val("");
	<portlet:namespace/>dataSearchList(1);
}
function <portlet:namespace/>dataSearchList(p_currentPage) {

	//라인검색 값
	var searchLine = $("#<portlet:namespace/>select_line").val();
	var searchText = $("#<portlet:namespace/>textfield").val();
	var projectCategoryId = $("#<portlet:namespace/>select_project").val();
	var dataForm = {
		"<portlet:namespace/>searchText":searchText,
		"<portlet:namespace/>searchLine":searchLine,
		"<portlet:namespace/>currentPage" : p_currentPage,
		"<portlet:namespace/>projectCategoryId" : projectCategoryId
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=myContentForProjectListURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var myContentList = msg.dataList;
			var rowResult;
			
			$("#<portlet:namespace/>myContentListBody tr:not(:has(#1))").remove();
			$("#<portlet:namespace/>paging").empty();
			
			if(typeof myContentList == "undefined" || myContentList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "5")
						  .css("text-align","center")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>myContentListBody").append($rowResult);
			} else {
				for(var i = 0; i < myContentList.length; i++) {
					$rowResult = $("<tr/>").css("border-bottom", "1px solid #e0e0e0").addClass("contentItem" + i).attr("id", "contentItem" + i);

					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
					$("<td></td>").addClass("TC").html(msg.seq-i).appendTo($rowResult);
					
					
					$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveContent('" + myContentList[i].groupId + "','" + myContentList[i].contentManagerPlid + "','" + myContentList[i].contentSeq + "','" + myContentList[i].contentDiv + "');")
									  .text(myContentList[i].title)
									  .css("cursor", "pointer")
							 ).appendTo($rowResult)
							  .css("white-space","nowrap")
							  .css("overflow","hidden")
							  .css("text-overflow","ellipsis");
					
					$("<td/>").addClass("TC").text(myContentList[i].affiliation).appendTo($rowResult);
					$("<td/>").addClass("TC").text(myContentList[i].firstName).appendTo($rowResult);
					
					$("<td/>").addClass("TC").append($("<select/>").attr("id","categorySelect"+myContentList[i].contentSeq).addClass("categorySelect").append($("<option/>").attr("value","0").attr("없음")).append(myContentList[i].categorySelectOption).attr("onChange", "<portlet:namespace/>updateContentProjectCategoryId('categorySelect"+myContentList[i].contentSeq+"', '"+myContentList[i].contentSeq+"')")).appendTo($rowResult);
					
 					$("#<portlet:namespace/>myContentListBody").append($rowResult);
				}

				$("#<portlet:namespace/>paging").html(msg.paging);
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}
</script>
<aui:script>
function <portlet:namespace/>moveContent(groupId, contentManagerPlid, contentSeq, contentDiv) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid(contentManagerPlid);
		portletURL.setPortletId("edisoncontent_WAR_edisoncontent2016portlet");
		portletURL.setParameter("groupId", groupId); 
		portletURL.setParameter("contentSeq", contentSeq);
		portletURL.setParameter("contentDiv", contentDiv);
		portletURL.setParameter("projectView", "detail");
		/*portletURL.setParameter("myRender", "solverRender");*/
		window.location.href = portletURL.toString();
	});
}
</aui:script>

<div id="<portlet:namespace/>display" >
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-project-management-content' />
		</div>
	</div>
	
	<div class="h10"></div>
	
	<div class="tabletopbox">
		<div class="search">
			<div class="searchbox">
				<input name="<portlet:namespace/>textfield" type="text" id="<portlet:namespace/>textfield" placeholder="<liferay-ui:message key="edison-table-list-header-title"/> or <liferay-ui:message key="edison-table-list-header-name"/>" size="40" onKeydown="if(event.keyCode ==13)<portlet:namespace/>dataSearchList(1);" />
				<input type="button" name="fullsize" id="fullsize" value="" class="btnsearch" onclick="<portlet:namespace/>dataSearchList(1);">
			</div>
			
			<input type="button" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-all-search"/>" class="button01" onclick="<portlet:namespace/>dataSearchListAll(1);">
		</div>
		
		
		<!--우편 셀렉트-->
		<div class="selectProjectWrapper" >
			<select id="<portlet:namespace/>select_project" name="<portlet:namespace/>select_project" onchange="<portlet:namespace/>dataSearchList(1)" class="selectProject">
				<option value="0"><liferay-ui:message key="edison-content-project-affiliation-yn"/></option>
				${categorySelectOption }
			</select>
		</div>
		<!--우편 셀렉트-->
		<div class="tabletopright">
			<select id="<portlet:namespace/>select_line" name="<portlet:namespace/>select_line" onchange="<portlet:namespace/>dataSearchList(1)" class="selectview">
				<option value="5">5<liferay-ui:message key="edison-search-views"/></option>
				<option value="10">10<liferay-ui:message key="edison-search-views"/></option>
				<option value="15">15<liferay-ui:message key="edison-search-views"/></option>
				<option value="20">20<liferay-ui:message key="edison-search-views"/></option>
			</select>
		</div>
	</div>


	<input type="hidden" id="<portlet:namespace/>groupId" name="<portlet:namespace/>groupId" value="${groupId }">
	
	<div class="table7_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout: fixed;">
			<colgroup>
				<col width="100" />
				<col width="*" />
				<!-- <col width="100" /> -->
				<col width="300" />
				<col width="250" />
				<col width="200" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-index"/></th>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-title"/></th>
					<%-- <th scope="col"><liferay-ui:message key="edison-content-service-language"/></th> <!-- 서비스언어 --> --%>
					<th scope="col"><liferay-ui:message key="edison-create-account-field-title-university"/></th><!-- 대학교/기관 -->
					<th scope="col"><liferay-ui:message key="edison-table-list-header-name"/></th><!-- 입력자 -->
					<th scope="col"><liferay-ui:message key="edison-content-project-affiliation-yn"/></th><!-- 소속프로젝트 -->
				</tr>
			</thead>
			<tbody id="<portlet:namespace/>myContentListBody">
			</tbody>
		</table>
	</div>
	<div class="paging">
		<div id="<portlet:namespace/>paging" style="width:100%;text-align: center;"></div>
	</div>
</div>