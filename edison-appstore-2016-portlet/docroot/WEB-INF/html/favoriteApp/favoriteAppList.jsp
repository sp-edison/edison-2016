<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>

<liferay-portlet:resourceURL var="favoriteAppListURL" id="favoriteAppList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="deleteFavoriteAppURL" id="deleteFavoriteApp" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>

<style type="text/css">
</style>

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList();
});

function <portlet:namespace/>dataSearchList() {
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
			$("#<portlet:namespace/>favoriteAppBody tr:not(:has(#1))").remove();
			
			if(typeof favoriteAppList == "undefined" || favoriteAppList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "5")
						  .css("text-align","center")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>favoriteAppBody").append($rowResult);
			} else {
				for(var i = 0; i < favoriteAppList.length; i++) {
					$rowResult = $("<tr/>").css("border-bottom", "1px solid rgb(224, 224, 224)");
					$("<td/>").append($("<img/>").attr("src", "${contextPath}/images/scienceappstoreview/favoriteiconon.png")
							  .attr("onClick", "event.cancelBubble=true; <portlet:namespace/>deleteFavoriteApp('" + favoriteAppList[i].scienceAppId + "','"+ favoriteAppList[i].groupId +"');")
							  .text(favoriteAppList[i].title)
							  .css("cursor", "pointer")
					 		 ).appendTo($rowResult);
					$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveSolverDetail('" + favoriteAppList[i].scienceAppId + "','" + favoriteAppList[i].groupId + "');")
							  .text(favoriteAppList[i].name + '(' + favoriteAppList[i].title + ')')
							  .css("cursor", "pointer")
					 		 ).css("white-space","nowrap")
							  .css("overflow","hidden")
							  .css("text-overflow","ellipsis")
							  .appendTo($rowResult);
					$("<td/>").text("Ver " + favoriteAppList[i].version)
							  .appendTo($rowResult);
					/* $("<td/>").text(favoriteAppList[i].affiliation)
							  .appendTo($rowResult);
					$("<td/>").text(favoriteAppList[i].userFirstName)
							  .appendTo($rowResult); */
					
					if(favoriteAppManualList[i].fileEntryId != undefined) {
						$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>fileDownload('" + favoriteAppManualList[i].fileEntryId + "');")
													   .text("<liferay-ui:message key='edison-table-list-header-manual' />")
													   .css("cursor", "pointer")
								 ).appendTo($rowResult);
					} else {
						$("<td/>").html("<liferay-ui:message key='edison-table-list-header-manual' />").appendTo($rowResult);
					}
					$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveSimulation('" + favoriteAppList[i].groupId + "','" + favoriteAppList[i].scienceAppId + "');")
												   .text("<liferay-ui:message key='edison-table-list-header-run' />")
												   .css("cursor", "pointer")
							 ).appendTo($rowResult);
					$("#<portlet:namespace/>favoriteAppBody").append($rowResult);
				}
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

function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

</script>

<aui:script>
function <portlet:namespace/>moveSolverManual(scienceAppId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${appstorePlid}");
		portletURL.setPortletId("edisonscienceAppstore_WAR_edisonappstore2016portlet");
		portletURL.setParameter("groupId", <%= themeDisplay.getScopeGroupId()%>);
		portletURL.setParameter("solverId", scienceAppId); /*선택된 solverId*/
		portletURL.setParameter("myaction", "detailView"); /*상세보기 페이지 action*/
		window.location.href = portletURL.toString();
	});
}

function <portlet:namespace/>moveSolverDetail(scienceAppId, groupId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${appstorePlid}"); /*가상실험실 생성 관리 페이지 Plid*/
		portletURL.setPortletId("edisonscienceAppstore_WAR_edisonappstore2016portlet"); /*앱스토어 포틀릿 ID*/
		portletURL.setParameter("groupId", groupId); /*현재 groupId*/
		portletURL.setParameter("solverId", scienceAppId); /*선택된 solverId*/
		portletURL.setParameter("myaction", "detailView"); /*상세보기 페이지 action*/
		window.location.href = portletURL.toString();
	});
}

function <portlet:namespace/>moveSimulation(groupId, solverId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${simulationPlid}"); /*가상실험실 생성 관리 페이지 Plid*/
		portletURL.setPortletId("edisonbestsimulation_WAR_edisonsimulation2016portlet"); /*시뮬레이션 포틀릿 ID*/
		portletURL.setParameter("directGroupId", groupId); /*solver groupId*/
		portletURL.setParameter("directScienceAppId", solverId); /*선택된 solverId*/
		portletURL.setPlid("${simulationPlid}"); <!-- 가상실험실 생성 관리 페이지 Plid -->
		portletURL.setPortletId("edisonbestsimulation_WAR_edisonsimulationportlet"); <!-- 시뮬레이션 포틀릿 ID -->
		portletURL.setParameter("directGroupId", groupId); <!-- solver groupId -->
		portletURL.setParameter("directScienceAppId", solverId); <!-- 선택된 solverId -->
		window.location.href = portletURL.toString();
	});
}
</aui:script>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-appstore-favorite-app' />
	</div>
</div>

<div class="h10"></div>

<div class="table7_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout: fixed;">
		<colgroup>
			<col width="40" />
			<col width="*" />
<!-- 			<col width="100" /> -->
<!-- 			<col width="200" /> -->
			<col width="100" />
			<col width="80" />
			<col width="80" />
		</colgroup>
		<tbody id="<portlet:namespace/>favoriteAppBody">
		</tbody>
	</table>
</div>