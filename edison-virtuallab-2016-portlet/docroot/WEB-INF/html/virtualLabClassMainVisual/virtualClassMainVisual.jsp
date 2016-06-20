<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@page import="com.liferay.portal.model.PasswordPolicy"%>
<%@page import="com.liferay.portal.service.PasswordPolicyLocalServiceUtil"%>

<liferay-portlet:resourceURL var="studentPasswordUpdateURL" id="studentPasswordUpdate" copyCurrentRenderParameters="false" />

<% 
PasswordPolicy edionPasswordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(company.getCompanyId());
%>

<style type="text/css">
input[type="password"]{
	margin-bottom: 0px;
}
.classvisual {
	width: 1220px;
	height: 206px;
	background: url(${contextPath}/images/virtualvisual.jpg)
		no-repeat
}

.cvtxt01 {
	margin-top: 160px;
	font-size: 14px;
	font-weight: 600;
	color: #fff;
	padding-left: 25px;
	float: left;
}

.cvtxt02 {
	margin-top: 160px;
	font-size: 14px;
	font-weight: 600;
	color: #fff;
	padding-left: 25px;
	float: left;
}

.cvtxt02 span {
	font-size: 17px;
	font-weight: 600;
	color: #ffeab8;
}

</style>

<script type="text/javascript">
AUI().ready(function() {
	$("#<portlet:namespace/>tempUserPasswordUpdate-dialog").dialog({
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
	
	$("#<portlet:namespace/>tempUserPasswordUpdate-dialog-close-btn").click(function() {
		$("#<portlet:namespace/>tempUserPasswordUpdate-dialog").dialog("close");
	});
});

function <portlet:namespace/>tempUserPasswordUpdate() {
}

function <portlet:namespace/>dialogOpen() {
	$("#<portlet:namespace/>tempUserPasswordUpdate-dialog").dialog("open");
}

function passWordCheck(val){
	var retbool = true;
	var minLength = <%=edionPasswordPolicy.getMinLength()%>;
	var reg = new RegExp("<%=edionPasswordPolicy.getRegex()%>");
	if(val.length<minLength){
		retbool = false;
	}else{
		if(!reg.test(val)){
			retbool = false;
		}
	}
	return retbool;
}

function <portlet:namespace/>checkValidation() {
	var checkForm = document.tempUserPasswordUpdateForm;
	
	var curPassStr ="<liferay-ui:message key='current-password'/>";
	var newPassStr ="<liferay-ui:message key='new-password'/>";
	var passConStr ="<liferay-ui:message key='edison-create-account-field-title-password-confirm'/>";
	
	if(checkForm.<portlet:namespace/>currentPassword.value=="") {
		alert("<liferay-ui:message key='edison-this-field-is-required' arguments='"+curPassStr+"'/>");
		checkForm.<portlet:namespace/>currentPassword.focus();
		return false;
	}
	
	if(checkForm.<portlet:namespace/>newPassword.value=="") {
		alert("<liferay-ui:message key='edison-this-field-is-required' arguments='"+newPassStr+"'/>");
		checkForm.<portlet:namespace/>newPassword.focus();
		return false;
	}
		
	if(checkForm.<portlet:namespace/>reNewPassword.value=="") {
		alert("<liferay-ui:message key='edison-this-field-is-required' arguments='"+passConStr+"'/>");
		checkForm.<portlet:namespace/>reNewPassword.focus();
		return false;
	}
	
	if(checkForm.<portlet:namespace/>newPassword.value != checkForm.<portlet:namespace/>reNewPassword.value) {
		alert("<liferay-ui:message key='please-enter-the-same-value-again' />");
		checkForm.<portlet:namespace/>reNewPassword.focus();
		return false;
	}
	
	if(checkForm.<portlet:namespace/>currentPassword.value == checkForm.<portlet:namespace/>newPassword.value) {
		alert("<liferay-ui:message key='please-enter-the-same-value-again' />");
		checkForm.<portlet:namespace/>newPassword.focus();
		return false;
	}
	
	
	
	if(!passWordCheck(checkForm.<portlet:namespace/>currentPassword.value)) {
		alert("<liferay-ui:message key='edison-create-account-description-message-Fourth-line' />");
		checkForm.<portlet:namespace/>currentPassword.focus();
		return false;
	}
	
	if(!passWordCheck(checkForm.<portlet:namespace/>newPassword.value)) {
		alert("<liferay-ui:message key='edison-create-account-description-message-Fourth-line' />");
		checkForm.<portlet:namespace/>newPassword.focus();
		return false;
	}
	if(!passWordCheck(checkForm.<portlet:namespace/>reNewPassword.value)) {
		alert("<liferay-ui:message key='edison-create-account-description-message-Fourth-line' />");
		checkForm.<portlet:namespace/>reNewPassword.focus();
		return false;
	}
	
	var updateForm = $("form[name=tempUserPasswordUpdateForm]").serialize();
	
	jQuery.ajax({
		type: "POST",
		url: "<%=studentPasswordUpdateURL%>",
		async : false,
		data : updateForm,
		success: function(msg) {
			if (msg == "200") {
				alert("<liferay-ui:message key='edison-virtuallab-classMainVisual-password-changed' />");
				$("#<portlet:namespace/>tempUserPasswordUpdate-dialog").dialog("close");
			} else if(msg == "300"){
				alert("<liferay-ui:message key='edison-create-account-password-unfit' />");
				checkForm.<portlet:namespace/>currentPassword.focus();
			} else {
				alert("<liferay-ui:message key='edison-data-event-error' />");
			}
			return true;
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}
</script>

<aui:script>
function <portlet:namespace/>moveClassList() {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${classlistPlid}"); <!-- 앱스토어 Plid -->
		portletURL.setPortletId("edisonvirtuallabclassmanagementlist_WAR_edisonvirtuallab2016portlet");
		window.location.href = portletURL.toString();
	});
}
</aui:script>

<div class="contentwrap">
	<div class="classvisual">
		<div class="cvtxt01"><img src="<%=renderRequest.getContextPath()%>/images/lighticon.png" width="17" height="25" style="margin:0 10px 0 0;"/>${classInfo.classTitle }</div>
		<div class="cvtxt02"><img src="<%=renderRequest.getContextPath()%>/images/lighticon.png" width="17" height="25" style="margin:0 10px 0 0;"/><span>Professor :</span> ${classInfo.virtualLabPersonName }(${classInfo.virtualLabUniversityFieldNM })</div>
		<c:if test="${role eq 'TEMP'}">
			<div class="cvtxt02"><img src="<%=renderRequest.getContextPath()%>/images/lighticon.png" width="17" height="25" style="margin:0 10px 0 0;"/>
				<span><liferay-ui:message key="edison-table-list-header-usernm"/> : </span><%=themeDisplay.getUser().getFirstName()%>
			</div>
			<div class="vlbtn">
				<input id="<portlet:namespace/>tempUserPasswordUpdate" name="<portlet:namespace/>tempUserPasswordUpdate" type="button" value="<liferay-ui:message key='update-password' />" class="button06" onclick="<portlet:namespace/>dialogOpen()"/>
			</div>
		</c:if>
		<c:if test="${role eq 'ADMIN'}">
			<div class="vlbtn" style="float:right; margin-right:10px;">
				<input type="button" value="<liferay-ui:message key='edison-button-board-list' />" class="button06" onclick="<portlet:namespace/>moveClassList()" />
			</div>
		</c:if>
	</div>
</div>

<div id="<portlet:namespace/>tempUserPasswordUpdate-dialog" class="newWindow" style="background-color:#fff; display:none;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='update-password' />
			</div>
		</div>
		<div class="newWclose">
			<img id="<portlet:namespace/>tempUserPasswordUpdate-dialog-close-btn" name="<portlet:namespace/>tempUserPasswordUpdate-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	
	<form id="tempUserPasswordUpdateForm" name="tempUserPasswordUpdateForm" method="post">
		<div class="newWcont01">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<colgroup>
					<col width="40%" />
					<col width="60%" />
				</colgroup>
				<tbody>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='current-password' /></td>
						<td class="puptitle">
							<input id="<portlet:namespace/>currentPassword" name="<portlet:namespace/>currentPassword" type="password" maxlength="15" autocomplete="off" readonly onfocus="this.removeAttribute('readonly');"/>
						</td>
					</tr>
					<tr>
						<td class="puptxt2"><liferay-ui:message key='new-password' /></td>
						<td class="puptxt2">
							<input id="<portlet:namespace/>newPassword" name="<portlet:namespace/>newPassword" type="password" maxlength="15" autocomplete="off" readonly onfocus="this.removeAttribute('readonly');"/>
						</td>
					</tr>
					<tr>
						<td class="puptxt2"><liferay-ui:message key='edison-create-account-field-title-password-confirm' /></td>
						<td class="puptxt2">
							<input id="<portlet:namespace/>reNewPassword" name="<portlet:namespace/>reNewPassword" type="password" maxlength="15" autocomplete="off" readonly onfocus="this.removeAttribute('readonly');"/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="text-align: right; margin:0px 25px 30px 0px;">
			<input id="<portlet:namespace/>tempUserPasswordUpdate_button" name="<portlet:namespace/>tempUserPasswordUpdate_button" type="button"  class="button06" value="<liferay-ui:message key='edison-button-board-modify' />" onClick="<portlet:namespace/>checkValidation();" />
		</div>
	</form>
</div>
