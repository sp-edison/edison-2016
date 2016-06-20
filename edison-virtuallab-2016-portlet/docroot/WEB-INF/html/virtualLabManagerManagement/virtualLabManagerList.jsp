<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:resourceURL var="virtualLabManagerListURL" id="virtualLabManagerList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="virtualLabUserInfoURL" id="virtualLabUserInfo" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="deleteVirtualLabAuthURL" id="deleteVirtualLabAuth" copyCurrentRenderParameters="false" />

<liferay-portlet:actionURL var="virtualLabManagerAddURL" portletMode="view" copyCurrentRenderParameters="false" >
	<liferay-portlet:param name="myaction" value="virtualLabManagerAdd" />
</liferay-portlet:actionURL>
<style type="text/css">
.h5{
    height: 5px;
    clear: both;
}
</style>
<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList();
	
	$("#virtualLab-manager-add-dialog").dialog({
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
	
	$("#virtualLab-manager-add-dialog-close-btn").click(function() {
		$("#virtualLab-manager-add-dialog").dialog("close");
	});
});

function <portlet:namespace/>dataSearchList() {
	
	var dataForm = {
			"<portlet:namespace/>virtualLabId" : "${virtualLabId}"
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=virtualLabManagerListURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var virtualLabManagerList = msg.virtualLabManagerList;
			var virtualLabId = msg.virtualLabId;
			
			var rowResult;
			$("#<portlet:namespace/>virtualLabManagerListBody tr:not(:has(#1))").remove();
			
			if(virtualLabManagerList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "6")
						  .css("text-align","center")
						  .addClass("TC left")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>virtualLabManagerListBody").append($rowResult);
			} else {
				
				for(var i = 0; i < virtualLabManagerList.length; i++) {
					$rowResult = $("<tr/>");
					
 					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
					
					$("<td/>").text(i+1)
							  .addClass("TC left")
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabManagerList[i].userScreenName)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(privateTextConverter2(virtualLabManagerList[i].userFullName))
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(privateEmailConverter2(virtualLabManagerList[i].userEmailAddress))
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabManagerList[i].createDate)
							  .css("text-align","center")
							  .appendTo($rowResult);
					if(virtualLabManagerList[i].userId == virtualLabManagerList[i].adminId) {
						$("<td/>").text("<liferay-ui:message key='category.admin' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else {
						$("<td/>").html("<input type='button' value='<liferay-ui:message key='edison-button-board-delete' />' onClick='<portlet:namespace/>deleteVirtualLabManager("+ virtualLabId + ","+ virtualLabManagerList[i].userId + ")' class='button01b' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					
					$("#<portlet:namespace/>virtualLabManagerListBody").append($rowResult);
				}
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>getUserInfo() {
	
	var searchForm = $("form[name=searchForm]").serialize();
		
	jQuery.ajax({
		type: "POST",
		url: "<%=virtualLabUserInfoURL%>",
		async : false,
		data : searchForm,
		success: function(msg) {
			var result = msg.result;
			var virtualLabUserInfo = msg.virtualLabUserInfo;
			
			if(result === undefined) {
				alert("user not found");
			} else if(result == "admin") {
				alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-admin-alert' />");
			} else if(result == "tempuser") {
				alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-tempuser-alert' />");
			} else if(result == "owner" || result == "manager") {
				alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-admin-already' />");
			} else if(result == "none") {
				alert("<liferay-ui:message key='edison-search-no-result' />");
			} else if(result == "user") {
				$("#managerId").text(virtualLabUserInfo.userScreenName);
				$("#managerFullName").text(privateTextConverter2(virtualLabUserInfo.userFullName));
				$("#managerEmail").text(privateEmailConverter2(virtualLabUserInfo.userEmailAddress));
				$("#<portlet:namespace/>managerUserId").val(virtualLabUserInfo.userId);
				$("#virtualLab-manager-add-dialog").dialog("open");
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>deleteVirtualLabManager(virtualLabAuthId, userId) {
	if(confirm("<liferay-ui:message key='edison-virtuallab-manager-delete' />")){	
		var dataForm = {
			"<portlet:namespace/>virtualLabManagerId" : userId,
			"<portlet:namespace/>virtualLabAuthId" : virtualLabAuthId
		};
		
		jQuery.ajax({
			type: "POST",
			url: "<%=deleteVirtualLabAuthURL%>",
			async : false,
			data : dataForm,
			success: function(msg) {
				<portlet:namespace/>dataSearchList();
			},error:function(msg,e){ 
				alert(e);
				return false;
			}
		});
	}
}

function <portlet:namespace/>onKeyDown() {
	if(event.keyCode == 13 && $("#<portlet:namespace/>userScreenName").val() != ""){
		<portlet:namespace/>getUserInfo();
	}
}

</script>
<div class="virtitlebox"><img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<form id="searchForm" name="searchForm" method="post" onsubmit="return false;">
		<input id="<portlet:namespace/>virtualLabId" name="<portlet:namespace/>virtualLabId" type="hidden" value="${virtualLabId}" />
		<div class="virtitle"><liferay-ui:message key='edison-virtuallab-admin' /></div>
		<div class="search01">
			<div class="searchbox01">
				<input id="<portlet:namespace/>userScreenName" name="<portlet:namespace/>userScreenName" type="text" maxlength="15" placeholder="<liferay-ui:message key='edison-table-list-header-userid' />" style="margin:1px 0;" onkeypress="<portlet:namespace/>onKeyDown();"/>
				<input id="search_button" name="search_button" type="button" class="btnsearch" onClick="<portlet:namespace/>getUserInfo()"/>
			</div>
			<div class="virsearch"><liferay-ui:message key='edison-virtuallab-search-manager' /></div>
		</div>
	</form>
</div>

<div class="h5"></div> 

	<div class="table6_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" >
			<colgroup>
				<col width="70" />
				<col width="*" />
				<col width="200" />
				<col width="200" />
				<col width="120" />
				<col width="100" />
			</colgroup>
			<thead>
				<tr>
					<th align="center" scope="col" class="TC left"><liferay-ui:message key='edison-table-list-header-index' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-userid' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-usernm' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-email' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-date' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-button-board-delete' /></th>
				</tr>
			</thead>
			<tbody id="<portlet:namespace/>virtualLabManagerListBody">
			</tbody>
		</table>
	</div>
	<div class="h10"></div>
	
	<div id="virtualLab-manager-add-dialog" title="<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-manager-register' />" class="newWindow" style="background-color:#fff; display:none;">
		<div class="newWheader">
			<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
				<div class="newWtitle">
					<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-lab-manager-register' />
				</div>
			</div>
			<div class="newWclose">
				<img id="virtualLab-manager-add-dialog-close-btn" name="virtualLab-manager-add-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
			</div>
		</div>
		
			<form id="managerAddForm" name="managerAddForm" method="post" action="<%= virtualLabManagerAddURL %>" onsubmit="return formCheck(this)">
				<input id="<portlet:namespace/>managerUserId" name="<portlet:namespace/>managerUserId" type="hidden">
				<input id="<portlet:namespace/>virtualLabId" name="<portlet:namespace/>virtualLabId" type="hidden" value="${virtualLabId}">
				<input id="virtualLabId" name="virtualLabId" type="hidden" value="${virtualLabId}">
			<div class="newWcont01" style="min-width:450px;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center;">
					<colgroup>
						<col width="30%" />
						<col width="70%" />
					</colgroup>
					<tbody>
						<tr class="puptrline">
							<td class="puptitle"><liferay-ui:message key='edison-table-list-header-userid' /></td>
							<td class="puptitle" id="managerId"></td>
						</tr>
						<tr>
							<td class="puptxt2"><liferay-ui:message key='edison-table-list-header-usernm' /></td>
							<td class="puptxt2" id="managerFullName"></td>
						</tr>
						<tr>
							<td class="puptxt2"><liferay-ui:message key='edison-table-list-header-email' /></td>
							<td class="puptxt2" id="managerEmail"></td>
						</tr>
						<tr>
							<td class="puptxt2" colspan="2" style="text-align: center; color:#f03030;"><liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-lab-manager-register-confirm' /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div style="text-align: right; margin:0px 30px 25px 0px;">
				<input id="register_request_button" name="register_request_button" type="submit" class="button06" value="<liferay-ui:message key='edison-button-register' />" />
			</div>
		</form>
	</div>
