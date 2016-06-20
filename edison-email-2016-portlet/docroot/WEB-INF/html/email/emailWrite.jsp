<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>

<liferay-portlet:renderURL var="sentEmailListURL" portletMode='view'>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL copyCurrentRenderParameters="false" var="emailSendURL" portletMode="view" >
	<portlet:param name="myAction" value="emailSend"/>
</liferay-portlet:actionURL>
<style>
.dp_ib {display: inline-block !important; margin: 1px;}
</style>


<c:set var="actionUrl" value="<%=emailSendURL%>"/>
<h3>Email</h3>
<form id="<portlet:namespace/>mailSendForm" name="<portlet:namespace/>mailSendForm" method="POST"  action="${actionUrl}" onsubmit="return <portlet:namespace/>mailSendFormCheck()" >
	<div class="table1_list">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup id="boardColgroup">
				<col width="240px" />
				<col width="*" />
			</colgroup>
			<tr>
				<th><liferay-ui:message key='title' /></th>
				<td><input type="text" id="<portlet:namespace/>emailSubject" name="<portlet:namespace/>emailSubject" value="${param.emailSubject}" style="width:80%; margin:0px;"/></td>
			</tr>
			<tr>
				<th><liferay-ui:message key='edison-virtuallab-tablerow-site' /></th>
				<td>
					<input type="checkbox" id="<portlet:namespace/>allSite"><label class="dp_ib" for="<portlet:namespace/>allSite">&nbsp;<liferay-ui:message key='full' /></label>
					<c:forEach var="group" items="${groupList}">
						<c:set var="groupChecked" value=""></c:set>
						<c:if test="${!empty paramValues.selectSiteGroups}">
							<c:forEach var="siteGroup" items="${paramValues.selectSiteGroups}">
								<c:if test="${group.groupId eq siteGroup}">
									<c:set var="groupChecked" value="checked"></c:set>
								</c:if>
							</c:forEach>
						</c:if>	
						&nbsp;<input type="checkbox" id="<portlet:namespace/>siteGroup_${group.groupId }" name= "<portlet:namespace/>siteGroup" value="${group.groupId }" ${groupChecked }>
						<label class="dp_ib" for="<portlet:namespace/>siteGroup_${group.groupId }" >&nbsp;${group.name }</label>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="edison-email-userGroup"/></th>
				<td>
					<input type="checkbox" id="<portlet:namespace/>allUserGroup"><label class="dp_ib" for="<portlet:namespace/>allUserGroup">&nbsp;<liferay-ui:message key='full' /></label>
					<c:forEach var="userGroup" items="${userGroupList}">
						<c:set var="userGroupChecked" value=""></c:set>
						<c:if test="${!empty paramValues.selectUserGroups}">
							<c:forEach var="selectUserGroup" items="${paramValues.selectUserGroups}">
								<c:if test="${userGroup.userGroupId eq selectUserGroup}">
									<c:set var="userGroupChecked" value="checked"></c:set>
								</c:if>
							</c:forEach>
						</c:if>
						&nbsp;<input type="checkbox" id="<portlet:namespace/>userGroup_${userGroup.userGroupId }" name= "<portlet:namespace/>userGroup"	value="${userGroup.userGroupId }" ${userGroupChecked}>
						<label class="dp_ib" for="<portlet:namespace/>userGroup_${userGroup.userGroupId }" >&nbsp;${userGroup.name }</label>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<liferay-ui:input-editor editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY %>" name="emailContent" initMethod="emailContentInit" toolbarSet="email" width="470" />
				</td>
			</tr>
		</table>
	</div>
</form>	
	<br>
	<div class="boardbtnbox" style="text-align: right;">
		<input type="button" class="button02" style="margin-right:5px;" onClick="<portlet:namespace/>emailSend(); return false;" value="<liferay-ui:message key='send' />" />
		<input type="button" class="button02" onClick="<portlet:namespace/>goList(); return false;" value="<liferay-ui:message key='edison-button-board-list' />" />
	</div>
<script type="text/javascript">

/*분야 체크박스 전체선택해제*/

$("#<portlet:namespace/>allSite").click(function(){
    if($("#<portlet:namespace/>allSite").prop("checked")){
        $("input[name=<portlet:namespace/>siteGroup]").prop("checked",true);
    }else{
        $("input[name=<portlet:namespace/>siteGroup]").prop("checked",false);
    }
});
$("input[name=<portlet:namespace/>siteGroup]").click(function(){
	var allChkLength = $("input[name=<portlet:namespace/>siteGroup]").length;
	var uncheckedLength = $("input[name=<portlet:namespace/>siteGroup]:checkbox:not(:checked)").length;
	var checkedLength = $("input[name=<portlet:namespace/>siteGroup]:checkbox:checked").length;
	
	/*분야1개라도체크안되있으면 전체선택체크박스 해제*/
	if(uncheckedLength > 0){
		$("#<portlet:namespace/>allSite").prop("checked",false)
	}
	
	/*분야를 낱개로 모두선택시 전체선택체크박스 체크*/
	if(allChkLength == checkedLength){
		$("#<portlet:namespace/>allSite").prop("checked",true)
	}
});

/*유저그룹 체크박스 전체선택해제*/
$("#<portlet:namespace/>allUserGroup").click(function(){
    if($("#<portlet:namespace/>allUserGroup").prop("checked")){
        $("input[name=<portlet:namespace/>userGroup]").prop("checked",true);
    }else{
        $("input[name=<portlet:namespace/>userGroup]").prop("checked",false);
    }
});
$("input[name=<portlet:namespace/>userGroup]").click(function(){
	var allChkLength = $("input[name=<portlet:namespace/>userGroup]").length;
	var uncheckedLength = $("input[name=<portlet:namespace/>userGroup]:checkbox:not(:checked)").length;
	var checkedLength = $("input[name=<portlet:namespace/>userGroup]:checkbox:checked").length;
	
	/*유저그룹 1개라도체크안되있으면 전체선택체크박스 해제*/
	if(uncheckedLength > 0){
		$("#<portlet:namespace/>allUserGroup").prop("checked",false)
	}
	
	/*유저그룹을 낱개로 모두선택시 전체선택체크박스 체크*/
	if(allChkLength == checkedLength){
		$("#<portlet:namespace/>allUserGroup").prop("checked",true)
	}
});

$(document).ready(function(){
	
	var allChkLengthSite = $("input[name=<portlet:namespace/>siteGroup]").length;
	var uncheckedLengthSite = $("input[name=<portlet:namespace/>siteGroup]:checkbox:not(:checked)").length;
	var checkedLengthSite = $("input[name=<portlet:namespace/>siteGroup]:checkbox:checked").length;
	
	/*분야를 낱개로 모두선택시 전체선택체크박스 체크*/
	if(allChkLengthSite == checkedLengthSite){
		$("#<portlet:namespace/>allSite").prop("checked",true)
	}
	
	var allChkLengthUser = $("input[name=<portlet:namespace/>userGroup]").length;
	var uncheckedLengthUser = $("input[name=<portlet:namespace/>userGroup]:checkbox:not(:checked)").length;
	var checkedLengthUser = $("input[name=<portlet:namespace/>userGroup]:checkbox:checked").length;
	
	/*유저그룹을 낱개로 모두선택시 전체선택체크박스 체크*/
	if(allChkLengthUser == checkedLengthUser){
		$("#<portlet:namespace/>allUserGroup").prop("checked",true)
	}
});

function <portlet:namespace/>emailContentInit(){
    	return "${param.emailContent}";
}

function <portlet:namespace/>emailSend(){
    	if(
        	document.<portlet:namespace/>mailSendForm.onsubmit &&
        	!document.<portlet:namespace/>mailSendForm.onsubmit()
        ){
            return false;
        }
     	document.<portlet:namespace/>mailSendForm.submit();
}

function <portlet:namespace/>goList(){
	var listUrl="<%=sentEmailListURL%>";
	location.href= listUrl+"&<portlet:namespace/>listSize=${listSize }&<portlet:namespace/>currentPage=${currentPage }&<portlet:namespace/>searchValue=${searchValue}";
}

function <portlet:namespace/>mailSendFormCheck(){
   // 에디터의 내용이 textarea에 적용된다.
	var subject = $("#<portlet:namespace/>emailSubject").val();   
	var contentValue = window.<portlet:namespace />emailContent.getHTML();
	var content = $.trim(contentValue.replace(/&nbsp;/g, ''));
	
	if($.trim(subject)==""){
		alert("<liferay-ui:message key='edison-board-enter-title-alert' />");
		return false;
	}
	
	var siteGroupCheckedLength = $("input[name=<portlet:namespace/>siteGroup]:checkbox:checked").length;
	var userGroupCheckedLength = $("input[name=<portlet:namespace/>userGroup]:checkbox:checked").length;
	
	if(siteGroupCheckedLength < 1 && userGroupCheckedLength < 1){
		alert("<liferay-ui:message key='edison-email-sendMail-alert'/>");
		return false;
	}
	
	if($.trim(content)==""){
		alert("<liferay-ui:message key='edison-board-enter-content-alert' />");
		return false;
	}else{
		window.<portlet:namespace />emailContent.setHTML(content);
 		return true;
	}
	return false;
}
</script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.portal_settings.email_notifications.jsp";
%>