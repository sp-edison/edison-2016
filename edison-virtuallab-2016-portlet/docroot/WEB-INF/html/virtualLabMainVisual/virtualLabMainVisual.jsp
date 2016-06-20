<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.liferay.portal.util.PortletKeys"%>
<liferay-portlet:actionURL var="updateVirtualLabInfomationURL" portletMode="view" copyCurrentRenderParameters="false" >
	<liferay-portlet:param name="myaction" value="updateVirtualLabInfomation" />
</liferay-portlet:actionURL>

<liferay-portlet:resourceURL var="virtualLabDisableURL" id="virtualLabDisable" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="virtualLabUserInfoURL" id="virtualLabUserInfo" copyCurrentRenderParameters="false" />

<liferay-portlet:renderURL 
	portletName="edisonorgcodesearch_WAR_edisondefault2016portlet" 
	portletMode="view"
	windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="syscommoncdURL">
	<liferay-portlet:param name="up_code" value="1501"/>
	<liferay-portlet:param name="com_search_type" value="orgSearch"/>
	<liferay-portlet:param name="popup_title" value="edison-org-code-search"/>
	<liferay-portlet:param name="universityFieldNm" value="virtualLabUniversityField"/>
	<liferay-portlet:param name="universityField" value="universityField"/>
</liferay-portlet:renderURL>

<style type="text/css">
.input-localized-content{
	margin:5px;
}
	
.virtualvisual {
	width: 1220px;
	height: 193px;
	background: url(/edison-virtuallab-2016-portlet/images/<%=themeDisplay.getLanguageId()%>/virtualvisual01.jpg)
		no-repeat
}
</style>

<div class="contentwrap">
	<div class="virtualvisual">
		<div class="vltxt01">
			<img src="<%=renderRequest.getContextPath()%>/images/lighticon.png" width="17" height="25" style="margin:0 10px 0 0;"/>${labInfo.virtualLabTitle }
		</div>
		<div class="vltxt02">
			<img src="<%=renderRequest.getContextPath()%>/images/lighticon.png" width="17" height="25" style="margin:0 10px 0 0;"/><liferay-ui:message key='edison-virtuallab-tablerow-professor' /> : ${labInfo.virtualLabPersonName }(${labInfo.virtualLabUniversityFieldNm })
		</div>
		<div class="vlbtn">
			<img src="<%=renderRequest.getContextPath()%>/images/<%=themeDisplay.getLanguageId()%>/virtualbtn.png" width="156" height="30" style="cursor:pointer;" onclick="openDialog()" />
		</div>
		<div class="vlbtn" style="float:right; margin-right:10px;">
			<input type="button" value="<liferay-ui:message key='edison-button-board-list' />" class="button06" onclick="<portlet:namespace/>moveLabList()" />
		</div>
		
	</div>
	<div class="h20"></div>
</div>
<div id="<portlet:namespace/>virtualLab-infomation-dialog" class="newWindow" style="background-color:#fff; display:none;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-infomation-management' />
			</div>
		</div>
		<div class="newWclose">
			<img id="<portlet:namespace/>virtualLab-infomation-dialog-close-btn" name="<portlet:namespace/>virtualLab-infomation-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<form id="createVirtualLabForm" name="createVirtualLabForm" method="post" action="<%= updateVirtualLabInfomationURL %>" onsubmit="return <portlet:namespace/>checkValidation(this);">
		<input id="<portlet:namespace/>virtualLabId" name="<portlet:namespace/>virtualLabId" type="hidden" value="${labInfo.virtualLabId}">
		<input id="<portlet:namespace/>universityField" name="<portlet:namespace/>universityField" type="hidden" value="${labInfo.virtualLabUniversityField}">
		<input id="<portlet:namespace/>status" name="<portlet:namespace/>status" type="hidden" value="UPDATE">
		<div class="newWcont01">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="width:715px; table-layout: fixed;">
			<colgroup>
				<col width="20%" />
				<col width="30%" />
				<col width="20%" />
				<col width="30%" />
			</colgroup>
			<tbody>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key='edison-table-list-header-tutor' /></td>
					<td class="puptxt">
						<liferay-ui:input-localized id="virtualLabPersonName" name="virtualLabPersonName" xml="${labInfo.virtualLabPersonNameMap}"  style="display: inline-block; margin:4px; width:150px;" type="input" />
					</td>
					<c:if test="${role eq 'MANAGER' }">
					<td class="puptitle"><liferay-ui:message key='edison-virtuallab-owner' /></td>
					<td class="puptxt">
						<input id="<portlet:namespace/>virtualLabOwnerName" name="<portlet:namespace/>virtualLabOwnerName" type="text" readonly="readonly" maxlength="10" style="width:150px; margin-bottom:0px;" value="${labInfo.userScreenName}"/>
					</td>
					</c:if>
					<c:if test="${role eq 'ADMIN' }">
					<td class="puptitle"><liferay-ui:message key='edison-virtuallab-owner' /></td>
					<td class="puptxt">
						<input id="<portlet:namespace/>virtualLabOwnerName" name="<portlet:namespace/>virtualLabOwnerName" type="text" maxlength="10" style="width:120px; margin-bottom:0px;" value="${labInfo.userScreenName}"/>
						<input id="virtualLab_owner_transfer_button" name="virtualLab_owner_transfer_button" onclick="<portlet:namespace/>virtualLabOwnerTransfer();" type="button" value="<liferay-ui:message key='edison-virtuallab-transfer' />" class="button06" />
					</td>
					</c:if>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key='edison-virtuallab-tablerow-virtuallab' /></td>
					<td class="puptxt">
						<liferay-ui:input-localized id="virtualLabTitle" name="virtualLabTitle" xml="${labInfo.virtualLabTitleMap}"  style="display: inline-block; margin:4px; width:150px;" type="input" />
					</td>
					<td class="puptitle" style="word-wrap: break-word;"><liferay-ui:message key='edison-create-account-field-title-university' /></td>
					<td class="puptxt">
						<input id="<portlet:namespace/>virtualLabUniversityField" name="<portlet:namespace/>virtualLabUniversityField" type="text" maxlength="10" readonly="readonly" style="width:120px; margin-bottom:0px;" value="${labInfo.virtualLabUniversityFieldNm}"/>
						<input id="virtualLab_search_university_button" name="virtualLab_search_university_button" onclick="<portlet:namespace/>syscommoncdPopup();" type="button" value="<liferay-ui:message key='edison-button-search' />" class="button06" />
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key='edison-table-list-header-resume' /></td>
					<td class="puptxt" colspan="3">
					<liferay-ui:input-localized id="virtualLabDescription" name="virtualLabDescription" xml="${labInfo.virtualLabDescriptionMap}"  rows="5" spellcheck="false" style="width: 95%; resize:none; margin:5px;" type="textarea"/>
				</tr>
				
			</tbody>
		</table>
		</div>
		<div style="text-align: right; margin:0px 25px 30px 0px;">
			<input id="<portlet:namespace/>virtualLab_infomation_update_button" name="<portlet:namespace/>virtualLab_infomation_update_button" type="submit" value="<liferay-ui:message key='edison-button-board-modify' />" class="button06" />
			<c:if test="${role eq 'ADMIN' }">
				<input id="<portlet:namespace/>virtualLab_delete_button" name="<portlet:namespace/>virtualLab_delete_button" type="button" value="<liferay-ui:message key='edison-button-board-delete' />" class="button06" onclick="<portlet:namespace/>virtualLabDisable(${labInfo.virtualLabId})"/>
			</c:if>
		</div>
	</form>
</div>

<script>
function <portlet:namespace/>syscommoncdPopup(){
	var URL = "<%=syscommoncdURL%>";
	w = 850;
	h = 550;
	x = (screen.availWidth - w) / 2;
	y = (screen.availHeight - h) / 2;
	var options = "width="+w+", height="+h+", left="+x+",top="+y+",toolbar=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no";
	var openPop;
	if(openPop != null){
		openPop.focus();
	}else{
		openPop = window.open(URL, "syscommoncdPopup",options);
		openPop.focus();
	}
}

function openDialog(){
	$("#<portlet:namespace/>select_languageId").val("${languageId}");
	$("#<portlet:namespace/>virtualLab-infomation-dialog").dialog("open");
}

$("#<portlet:namespace/>virtualLab-infomation-dialog").dialog({
	autoOpen: false,
	width: 'auto',
	height: 'auto',
	modal: true,
	resizable: false,
	show: {effect:'fade', speed: 800}, 
	hide: {effect:'fade', speed: 800},
	open: function(event, ui) {
		$(this).css('overflow', 'hidden');
		$(this).parent().removeClass("ui-widget-content");
		$(this).parent().removeClass("ui-widget");
		$(this).removeClass("ui-widget-content");
		$(this).removeClass("ui-dialog-content");
	},
	close: function() {
	}
}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
$("#<portlet:namespace/>virtualLab-infomation-dialog-close-btn").click(function() {
	$("#<portlet:namespace/>virtualLab-infomation-dialog").dialog("close");
});

function <portlet:namespace/>virtualLabDisable(virtualLabId) {
	var dataForm = {
		"<portlet:namespace/>virtualLabId" : virtualLabId
	}
	
	if(confirm("<liferay-ui:message key='edison-virtuallab-delete-alert' />")){	
		jQuery.ajax({
			type: "POST",
			url: "<%=virtualLabDisableURL%>",
			async : false,
			data : dataForm,
			success: function(msg) {
				var result = msg.result;
				if(result == "300" || result == "400") {
					alert("<liferay-ui:message key='edison-data-delete-error=Data' />");
				} else if (result == "200") {
					alert("<liferay-ui:message key='edison-data-delete-success' />");
					window.location.href = "${homeURL}";
				} else if (result == "500") {
					alert("<liferay-ui:message key='edison-virtuallab-delete-alert-fail' />");
				} else {
					alert("<liferay-ui:message key='edison-data-delete-error' />");
				}
			},error:function(msg,e){ 
				alert(e);
				return false;
			}
		});
	}
}

function <portlet:namespace/>virtualLabOwnerTransfer() {
	
	var searchForm = {
		"<portlet:namespace/>userScreenName" : $("#<portlet:namespace/>virtualLabOwnerName").val(),
		"<portlet:namespace/>virtualLabId" : "${labInfo.virtualLabId}"
	};
		
	jQuery.ajax({
		type: "POST",
		url: "<%=virtualLabUserInfoURL%>",
		async : false,
		data : searchForm,
		success: function(msg) {
			var result = msg.result;
			var virtualLabUserInfo = msg.virtualLabUserInfo;
			
			if(result === undefined) {
				alert("<liferay-ui:message key='edison-search-no-result' />");
			} else if(result == "admin") {
				alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-admin-alert' />");
			} else if(result == "tempuser") {
				alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-tempuser-alert' />");
			} else if(result == "owner" || result == "manager") {
				alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-admin-already' />");
			} else if(result == "none") {
				alert("<liferay-ui:message key='edison-search-no-result' />");
			} else if(result == "user") {
				if(confirm("<liferay-ui:message key='edison-virtuallab-owner-transfer' />")){
					$("#<portlet:namespace/>status").val("TRANSFER");
					document.createVirtualLabForm.submit();
				}
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}
</script>

<aui:script>
function <portlet:namespace/>moveLabList() {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${lablistPlid}"); <!-- 앱스토어 Plid -->
		portletURL.setPortletId("edisonvirtuallabmanagementlist_WAR_edisonvirtuallab2016portlet"); <!-- 앱스토어 포틀릿 ID -->
		window.location.href = portletURL.toString();
	});
}
</aui:script>