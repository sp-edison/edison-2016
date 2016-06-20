<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>

<liferay-portlet:resourceURL var="virtualLabScienceAppListURL" id="virtualLabScienceAppList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>

<liferay-portlet:renderURL var="popupScienceAppListURL" copyCurrentRenderParameters="false" windowState="<%=LiferayWindowState.POP_UP.toString() %>" portletMode="view">
	<liferay-portlet:param name="myaction" value="popupScienceAppList" />
	<liferay-portlet:param name="classId" value="${classId}" />
</liferay-portlet:renderURL>

<style type="text/css">
.buttonbox0801{margin:0 auto; overflow:hidden; padding-top:18px; padding-bottom:5px; text-align:center; float:right;}
</style>

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList();
});

function <portlet:namespace/>dataSearchList() {
	var dataForm = {
		"<portlet:namespace/>classId" : "${classId}"
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=virtualLabScienceAppListURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var virtualLabScienceAppList = msg.virtualLabScienceAppList;
			var virtualScienceAppManualList = msg.virtualScienceAppManualList;
			
			var rowResult;
			$("#<portlet:namespace/>virtualLabClassScienceAppBody tr:not(:has(#1))").remove();
			
			if(virtualLabScienceAppList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").addClass("appbgcolor01")
						  .attr("colspan", "6")
						  .css("text-align","center")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>virtualLabClassScienceAppBody").append($rowResult);
			} else {
				for(var i = 0; i < virtualLabScienceAppList.length; i++) {
					$rowResult = $("<tr/>").css("border-bottom", "1px solid rgb(224, 224, 224)");
					
					$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveScienceAppDetail('" + virtualLabScienceAppList[i].scienceAppId + "');")
											   .text(virtualLabScienceAppList[i].scienceAppTitle)
											   .css("cursor", "pointer")
							 ).appendTo($rowResult)
							  .css("white-space","nowrap")
							  .css("overflow","hidden")
							  .css("text-overflow","ellipsis")
					$("<td/>").text("Ver " + virtualLabScienceAppList[i].scienceAppVersion)
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabScienceAppList[i].scienceAppUniversityNm)
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabScienceAppList[i].userFirstName)
							  .appendTo($rowResult);
					
					if(virtualScienceAppManualList[i].fileEntryId != undefined) {
						$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>fileDownload('" + virtualScienceAppManualList[i].fileEntryId + "');")
												   .text("<liferay-ui:message key='edison-virtuallab-manual' />")
												   .css("cursor", "pointer")
								 ).appendTo($rowResult);
					} else {
						$("<td/>").html("<liferay-ui:message key='edison-virtuallab-manual' />").appendTo($rowResult);
					}
					
					$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveSimulation('" + virtualLabScienceAppList[i].scienceAppId + "');")
											   .text("<liferay-ui:message key='edison-virtuallab-running' />")
											   .css("cursor", "pointer")
							 ).appendTo($rowResult);
					$("#<portlet:namespace/>virtualLabClassScienceAppBody").append($rowResult);
				}
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}
<%
long scienceAppPlid = themeDisplay.getLayout().getPlid();
%>
function <portlet:namespace/>openScienceAppListPopup() {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid(<%=scienceAppPlid%>); <!-- 가상실험실 생성 관리 페이지 Plid -->
		portletURL.setPortletMode("view");
		portletURL.setWindowState("pop_up");
		portletURL.setPortletId("edisonvirtuallabclassscienceapplist_WAR_edisonvirtuallab2016portlet"); <!-- 워크스페이스 포틀릿 ID -->
		portletURL.setParameter("myaction", "popupScienceAppList"); <!-- 개발자 요청 코드 -->
		portletURL.setParameter("classId", "${classId}"); <!-- 분야 이름 -->
		Liferay.Util.openWindow(
			{
				dialog: {
					width:1024,
					height:720,
					cache: false,
					draggable: false,
					resizable: false,
					modal: true,
					destroyOnClose: true,
					after: {
						render: function(event) {
							$("button.btn.close").on("click", function(e){
								<portlet:namespace/>dataSearchList(1);
							});
						}
					}
				},
				id: "scienceAppDialog",
				uri: portletURL.toString(),
				title:"<liferay-ui:message key='edison-virtuallab-scienceapp' />" + " " + "<liferay-ui:message key='edison-virtuallab-scienceapp-management' />",
			}
		);
	});
}

function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

</script>

<aui:script>
function <portlet:namespace/>moveScienceAppManual(scienceAppId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${appstorePlid}"); <!-- 앱스토어 Plid -->
		portletURL.setPortletId("edisonscienceAppstore_WAR_edisonappstore2016portlet"); <!-- 앱스토어 포틀릿 ID -->
		portletURL.setParameter("groupId", <%= themeDisplay.getScopeGroupId()%>); <!-- 현재 groupId -->
		portletURL.setParameter("scienceAppId", scienceAppId); <!-- 선택된 scienceAppId -->
		portletURL.setParameter("myaction", "detailView"); <!-- 상세보기 페이지 action -->
		window.location.href = portletURL.toString();
	});
}

function <portlet:namespace/>moveScienceAppDetail(scienceAppId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${appstorePlid}"); <!-- 가상실험실 생성 관리 페이지 Plid -->
		portletURL.setPortletId("edisonscienceAppstore_WAR_edisonappstore2016portlet"); <!-- 앱스토어 포틀릿 ID -->
		portletURL.setParameter("groupId", <%= themeDisplay.getScopeGroupId()%>); <!-- 현재 groupId -->
		portletURL.setParameter("scienceAppId", scienceAppId); <!-- 선택된 scienceAppId -->
		portletURL.setParameter("myaction", "detailView"); <!-- 상세보기 페이지 action -->
		window.location.href = portletURL.toString();
	});
}

function <portlet:namespace/>moveSimulation(scienceAppId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${simulationPlid}"); <!-- 가상실험실 생성 관리 페이지 Plid -->
		portletURL.setPortletId("edisonbestsimulation_WAR_edisonsimulationportlet"); <!-- 시뮬레이션 포틀릿 ID -->
		portletURL.setParameter("directGroupId", <%= themeDisplay.getScopeGroupId()%>); <!-- 현재 groupId -->
		portletURL.setParameter("directScienceAppId", scienceAppId); <!-- 선택된scienceAppId -->
		window.location.href = portletURL.toString();
	});
}

</aui:script>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-virtuallab-scienceapp' />
	</div>
	<c:if test="${role eq 'admin' }">
		<div class="buttonbox0801">
			<input id="<portlet:namespace/>scienceAppManagementButton" name="<portlet:namespace/>scienceAppManagementButton" type="button" class="button0801" value="<liferay-ui:message key='edison-virtuallab-scienceapp-management' />" onClick="<portlet:namespace/>openScienceAppListPopup()"/>
		</div>
	</c:if>
</div>

<div class="h10"></div>

<div class="table6_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout: fixed;">
		<colgroup>
			<col width="*" />
			<col width="100" />
			<col width="200" />
			<col width="150" />
			<col width="120" />
			<col width="120" />
		</colgroup>
		<tbody id="<portlet:namespace/>virtualLabClassScienceAppBody">
		</tbody>
	</table>
</div>
