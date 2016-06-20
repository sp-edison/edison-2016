<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<liferay-portlet:resourceURL var="workspaceListURL" id="workspaceList" copyCurrentRenderParameters="false"/>

<liferay-portlet:renderURL var="workspaceViewURL">
	<liferay-portlet:param name="myaction" value="workspaceView" />
	<liferay-portlet:param name="edionCopyParam" value="true" />
	<liferay-portlet:param name="groupName" value="${groupName}" />
</liferay-portlet:renderURL>


<script type="text/javascript">
/************** ready   ***************/
$(document).ready(function() {
	<portlet:namespace/>dataSearchList("${params.curPage}");
});
/************** ready end   ***************/

function workspaceView(userId){
	var searchForm = document.searchParamForm;
	var URL = "<%=workspaceViewURL%>&<portlet:namespace/>userId="+userId;
	
	var curPage = searchForm.<portlet:namespace/>curPage.value;
	var searchField = searchForm.<portlet:namespace/>searchField.value;
	var selectLine = searchForm.<portlet:namespace/>select_line.value;
	var selectStatus = searchForm.<portlet:namespace/>selectStatus.value;
	
	URL +="&<portlet:namespace/>curPage="+curPage;
	URL +="&<portlet:namespace/>searchField="+searchField;
	URL +="&<portlet:namespace/>selectLine="+selectLine;
	URL +="&<portlet:namespace/>selectStatus="+selectStatus;
	
	window.location.href = URL;
}

//목록검색
function <portlet:namespace/>dataSearchList(curPage){
	if(curPage == 0) {
		curPage = 1
		$("#<portlet:namespace/>curPage").val("1");
		$("#<portlet:namespace/>searchField").val("");
		$("#<portlet:namespace/>selectStatus").val("0");
		$("#<portlet:namespace/>select_line").find('option:first').attr('selected', 'selected');
	} else {
		$("#<portlet:namespace/>curPage").val(curPage);
	}

	var paramData = $("form[name=searchParamForm]").serialize();
	jQuery.ajax({
		type: "POST",
		url: "<%=workspaceListURL%>",
		async : false,
		data  : paramData,
		success: function(data) {	    			
			var dataMap = eval('(' + data + ')');
			var dataCount = dataMap.totalCnt - ((curPage -1) * dataMap.select_line);
			
			$("#<portlet:namespace/>workspaceList").empty();		
			if(dataMap.dataList.length==0){
				
				$("#<portlet:namespace/>workspaceList").append('<tr><td colspan=7 style="text-align:center"><liferay-ui:message key="edison-there-are-no-data" /></td></tr>');
				
			}else{
				
				for(var i = 0 ; i < dataMap.dataList.length; i++ ){									
					$trNode = $("<tr/>").attr("onclick", "workspaceView('"+dataMap.dataList[i].userId+"')").css("cursor", "pointer");
 					if(i%2 == 1){
 						$trNode.addClass("tablebgtr");
 					}
					$("<td/>").addClass("TC").text(dataCount--).appendTo($trNode);					
					$("<td/>").addClass("TC").append($("<a/>").attr("href","#").text(dataMap.dataList[i].screenName)).appendTo($trNode);
					$("<td/>").addClass("TC").text(dataMap.dataList[i].firstName).appendTo($trNode);
					$("<td/>").addClass("TC").text(dataMap.dataList[i].emailAddress).appendTo($trNode);
					$("<td/>").addClass("TC").text(dataMap.dataList[i].requestStatusNm).appendTo($trNode);
					$("<td/>").addClass("TC").text(dataMap.dataList[i].requestDate).appendTo($trNode);
					$("<td/>").addClass("TC").text(dataMap.dataList[i].useStart+" ~ "+dataMap.dataList[i].useEnd).appendTo($trNode);
					$("#<portlet:namespace/>workspaceList").append($trNode);
				}
			}
		
			//페이징 초기화pageListDiv
			document.getElementById("<portlet:namespace/>page_navi").innerHTML = dataMap.pageList;
			
		},error:function(data,e){   
			alert(e);				  
			return false;
		}
	});
}
</script>

<!-- 페이지 타이틀 & 네비게이션 -->
<h1>
<c:if test="${groupName ne null}">
<liferay-ui:message key='edison-appstore-developer-request-management' />(${groupName})
</c:if>
<c:if test="${groupName eq null }">
<liferay-ui:message key='edison-appstore-workspace-request-list' />
</c:if>
</h1>

<div class="tabletopbox">
	<form method="post" name="searchParamForm" style="margin: 0px;" onsubmit="return false;">
		<input id="<portlet:namespace/>curPage" name="<portlet:namespace/>curPage" type="hidden" value="1"/>
		
		<div class="search">
			<div class="searchbox">
				<input id="<portlet:namespace/>searchField" name="<portlet:namespace/>searchField" type="text" maxlength="15" placeholder="<liferay-ui:message key='edison-appstore-workspace-placeholder' />" onKeydown="if(event.keyCode ==13)<portlet:namespace/>dataSearchList('1');" value="${params.searchField}"/>
				<input id="search_button" name="<portlet:namespace />search_button" type="button" class="btnsearch" onclick="<portlet:namespace/>dataSearchList(1)"/>
			</div>
			<input id="total_search_button" name="<portlet:namespace />total_search_button" type="button" value="<liferay-ui:message key='edison-button-all-search' />" class="button01" onclick="<portlet:namespace/>dataSearchList(0)" />
		</div>
		<div class="tabletopright" style="right: 150px;">
			<select id="<portlet:namespace/>selectStatus" name="<portlet:namespace/>selectStatus" onchange="<portlet:namespace/>dataSearchList(1)" class="selectview">
				<option value="0" selected >ALL</option>
				${statusOptionStr}
			</select>
		</div>
		<div class="tabletopright">
			<select id="<portlet:namespace/>select_line" name="<portlet:namespace/>select_line" onchange="<portlet:namespace/>dataSearchList(1)" class="selectview">
				<option value="10" <c:if test="${params.selectLine == '10' }"> selected="selected" </c:if>>10<liferay-ui:message key='edison-search-views' /></option>
				<option value="20" <c:if test="${params.selectLine == '20' }"> selected="selected" </c:if>>20<liferay-ui:message key='edison-search-views' /></option>
				<option value="30" <c:if test="${params.selectLine == '30' }"> selected="selected" </c:if>>30<liferay-ui:message key='edison-search-views' /></option>
				<option value="40" <c:if test="${params.selectLine == '40' }"> selected="selected" </c:if>>40<liferay-ui:message key='edison-search-views' /></option>
			</select>
		</div>
	</form>
</div>

<div class="table1_list borderno" style="min-height: 530px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list" >
		<thead>
		    <tr>
			    <th width="4%" ><liferay-ui:message key='edison-table-list-header-index' /></th>
			    <th width="12%"><liferay-ui:message key='edison-table-list-header-userid' /></th>
			    <th width="12%"><liferay-ui:message key='edison-table-list-header-usernm' /></th>
			    <th width="15%"><liferay-ui:message key='edison-table-list-header-email' /></th>
			    <th width="12%"><liferay-ui:message key='edison-table-list-header-status' /></th>
			    <th width="12%"><liferay-ui:message key='edison-table-list-header-req-date' /></th>
			    <th width="25%"><liferay-ui:message key='edison-appstore-developer-use-date' /></th>
		    </tr>
	    </thead>
	    <tbody id="<portlet:namespace/>workspaceList">
	    </tbody>
	</table>
</div>

 <!-- 페이지 네비게이션 ---->
<div class="paging">
	<div id="<portlet:namespace/>page_navi"></div>
</div>
