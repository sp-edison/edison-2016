<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<liferay-portlet:actionURL var="workspaceRequestURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="workspaceRequest"/>
</liferay-portlet:actionURL>

<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>

<style type="text/css">
label.checkbox-label{
	display:inline;
}

label.checkbox-label input[type=checkbox]{
	position: relative;
	vertical-align: middle;
	bottom: 2px;
	margin-right: 2px;
}
</style>
<script type="text/javascript">
/************** ready   ***************/
$(document).ready(function() {
	$("#<portlet:namespace/>useStart").datepicker({
		showButtonPanel: true,
		showOn: 'button',
		dateFormat:"yy-mm-dd",
		changeMonth: true,
		changeYear: true,
		buttonImage: "${contextPath}/images/calendar.png",
		buttonImageOnly: true,
		onClose: function( selectedDate ) {
			$("#<portlet:namespace/>useEnd").datepicker("option", "minDate", selectedDate);
			
		}
	});
	$("#<portlet:namespace/>useEnd").datepicker({
		showButtonPanel: true,
		showOn: 'button',
		dateFormat:"yy-mm-dd",
		changeMonth: true,
		changeYear: true,
		buttonImage: "${contextPath}/images/calendar.png",
		buttonImageOnly: true,
		onClose: function( selectedDate ) {
			$("#<portlet:namespace/>useStart").datepicker("option", "maxDate", selectedDate);
			
		}
	});
	
	$("#workspaceDetail").hide();
});
/************** ready end   ***************/
$(document).on("keydown", "input[name^=<portlet:namespace/>ip]", function(event){
	// Allow: backspace, delete, tab, escape, and enter

	if(event.keyCode == 46 
			|| event.keyCode == 8 
			|| event.keyCode == 9 
			|| event.keyCode == 27 
			|| event.keyCode == 13 
			|| (event.keyCode == 65 && event.ctrlKey === true) 
			|| (event.keyCode >= 35 && event.keyCode <= 39)) {
			 return;
	}else{
		if (event.shiftKey 
				|| (event.keyCode < 48 || event.keyCode > 57) 
				&& (event.keyCode < 96 || event.keyCode > 105 )){
			event.preventDefault(); 
		}else{
			
		}   
	}
});

$(document).on("click", ".addIp", function(){
	$cloneEl =  $(this).parent().clone();
	$cloneEl.find("input[type=button]").removeClass("addIp").addClass("deleteIp").attr("value","<liferay-ui:message key='edison-button-board-delete' />");
	var rowCnt =  $(this).parent().parent().find("th").attr("rowspan");
	$(this).parent().parent().find("th").attr("rowspan", parseInt(rowCnt)+1); 
	$cloneEl.find("input[type=text]").val("");
	$(this).parent().parent().after($("<tr/>").append($cloneEl));	
});


$(document).on("click", ".deleteIp", function(){
	var rowCnt =  $("#mainIp").attr("rowspan");	
	$("#mainIp").attr("rowspan", parseInt(rowCnt)-1);
	$(this).parent().parent().remove();
	
});

function workspaceRequest(){
	var validationChk =  true;
	var form = document.workspaceform;
	var paramData = $("form[name=workspaceform]").serialize();
	
	if(form.<portlet:namespace/>useStart.value == ""){
		alert("<liferay-ui:message key='edison-create-account-description-message-first-line'/>"+"("+"<liferay-ui:message key='edison-appstore-developer-preferred-date' />"+")");
		validationChk = false;
		form.<portlet:namespace/>useStart.focus();
		return false;
	}
	
	if(validationChk){
		if(form.<portlet:namespace/>useEnd.value == ""){
			alert("<liferay-ui:message key='edison-create-account-description-message-first-line'/>"+"("+"<liferay-ui:message key='edison-appstore-developer-preferred-date' />"+")");
			validationChk = false;
			form.<portlet:namespace/>useEnd.focus();
			return false;
		}
	}
	
	$("input[name^=<portlet:namespace/>ip]").each(function(){
		if(validationChk){
			if($(this).val() == ""){
				alert("<liferay-ui:message key='edison-create-account-description-message-first-line' />"+"(IP)");
				this.focus();
				validationChk = false;
				return false;
			}
		}
		
	});
	
	if(validationChk){
		if($(":radio[name=<portlet:namespace/>agreementYn]:checked").val() == 'N'){
			alert("<liferay-ui:message key='edison-appstore-workspace-agreement-security-alert' />");
			form.<portlet:namespace/>agreementYn[0].focus();
			return false;
		}
	}
	
	if(validationChk){
		if(form.<portlet:namespace/>addfile.value == ""){
			alert("<liferay-ui:message key='edison-appstore-workspace-security-pledge-attach-alert' />");
			validationChk = false;
			return false;
		}
	}
	
	if(validationChk){
		form.submit();
	}
}

function otherEvent(obj){
	
	if($(obj).is(":checked")){
		$("input[name=<portlet:namespace/>languageOtherDescription]").attr("readonly",false);
	}else{
		$("input[name=<portlet:namespace/>languageOtherDescription]").attr("readonly",true).val("");
	}
}

function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

</script>
<!-- 페이지 타이틀 & 네비게이션 -->

<h1>
	<liferay-ui:message key='edison-appstore-workspace-request' />
</h1>

<form name="workspaceform" action="<%=workspaceRequestURL%>" method="post" enctype="multipart/form-data">
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='user-information' />
		</div>
	</div>
	
	<div class="h10"></div>
		
	<div class="table1_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" style="table-layout: fixed;">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
			<tr>
				<th><liferay-ui:message key='edison-table-list-header-userid' /></th>
				<td>${userMap.screenName}</td>
				<th><liferay-ui:message key='edison-table-list-header-usernm' /></th>
				<td>${userMap.name}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key='edison-table-list-header-email' /></th>
				<td>${userMap.emailAddress}</td>
				<th><liferay-ui:message key='edison-create-account-field-title-university' /></th>
				<td colspan="5">${userMap.universityFieldNm}/${userMap.majorField}</td>
			</tr>
		</table>
	</div>

	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-appstore-workspace-request-info' />
		</div>
	</div>
	
	<div class="h10"></div>
	
		<div class="table1_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" style="table-layout: fixed;">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
			<tr>
				<th><liferay-ui:message key='edison-appstore-workspace-request-use' /></th>
				<td>
					<select id="<portlet:namespace/>developerSort" name="<portlet:namespace/>developerSort">
						<option value="1201001" ><liferay-ui:message key='edison-appstore-workspace-solver-development' /></option>
						<option value="1201002" ><liferay-ui:message key='edison-appstore-workspace-solver-development-test' /></option>
						<option value="1201003" ><liferay-ui:message key='edison-appstore-workspace-etc' /></option>
					</select>
				</td>
				<th><liferay-ui:message key='edison-appstore-developer-preferred-date' /><font color="red">*</font></th>
				<td colspan="3">
				<input name="<portlet:namespace/>useStart" id="<portlet:namespace/>useStart" readonly="readonly"/> ~ <input name="<portlet:namespace/>useEnd" id="<portlet:namespace/>useEnd" readonly="readonly"/>			  
				</td>
			</tr>
			<tr>
				<th><liferay-ui:message key='edison-appstore-workspace-use-language' /></th>
				<td colspan="6">
					<label class="checkbox-label"><input name="<portlet:namespace/>languageFortran" type="checkbox" value="Y"/>fortran</label>
					<label class="checkbox-label"><input name="<portlet:namespace/>languageCpp" type="checkbox" value="Y"/>c/c++</label>
					<label class="checkbox-label"><input name="<portlet:namespace/>languagePython" type="checkbox" value="Y"/>python</label>
					<label class="checkbox-label"><input name="<portlet:namespace/>languageJava" type="checkbox" value="Y"/>java</label>
					<label class="checkbox-label"><input name="<portlet:namespace/>languageOther" onclick="otherEvent(this)" type="checkbox" value="Y"/><liferay-ui:message key='edison-appstore-workspace-etc' /></label>
					<input type="text" name="<portlet:namespace/>languageOtherDescription" readonly="readonly" class="text_box_04" maxlength="100" />
			</tr>
			<tr>
				<th id="mainIp" rowspan="1"><liferay-ui:message key='edison-appstore-workspace-access-ip' /><font color="red">*</font></th>
				<td colspan="7">
					<input name="<portlet:namespace/>ip1" maxlength="3" type="text"></input>.
					<input name="<portlet:namespace/>ip2" maxlength="3" type="text"></input>.
					<input name="<portlet:namespace/>ip3" maxlength="3" type="text"></input>.
					<input name="<portlet:namespace/>ip4" maxlength="3" type="text"></input>
					<input type="button" class="addIp button01b" onclick="return false;" value="<liferay-ui:message key='edison-appstore-add' />" />
				</td>
			</tr>
			<tr>
				<th><liferay-ui:message key='edison-appstore-remark' /></th>
				<td width="91%" colspan="5">
				<textarea name="<portlet:namespace/>rem" cols="150" rows="10" style="resize: none;width: 95%;margin: 0px;" spellcheck="false"></textarea>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-appstore-workspace-agreement-info' />
		</div>
	</div>
	
	<div class="h10"></div>
	
	<div class="table1_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" style="table-layout: fixed;">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
			<tr>
				<th rowspan="2"><liferay-ui:message key='edison-appstore-workspace-agreement-security' /><font color="red">*</font></th>
				<td colspan="3">
				  	<textarea rows="10" cols="150"  name="<portlet:namespace/>termsOfuse" readonly="readonly" style="resize: none;width: 95%;margin: 0px;" spellcheck="false">
	보 안 서 약 서
	
	 상기 본인은 “첨단 사이언스•교육 허브 개발 사업 플랫폼 연구개발 및 사이버 인프라 기반 사용자 서비스” 연구과제 개발 인원으로 참여하면서 다음사항을 준수할 것을 서약합니다.
	
	 1. 본 연구과제를 수행하는 과정에서 알 수 있었던 연구기밀에 대해 연구과제 수행중은 물론 종료후에도 연구원장 허락없이 자신 또는 제3자를 위하여 사용하지 않는다.
	
	 2. 본 연구과제 추진성과가 적법하게 공개된 경우라고 하여도 미공개 부분에 대해서는 앞에서와 같이 비밀유지의무를 부담한다.
	
	 3. 본 연구과제가 완료되거나 연구과제을 수행할 수 없게 된 경우, 그 시점에서 본인이 보유하고 있는 연구기밀을 포함한 관련 자료를 즉시 연구개발책임자에게 반납하며 앞에서와 같이 비밀유지의무를 부담한다.
	
	 4. 다음 법규에 의한 비밀유지의무 등 위반 시 관계법규에 의한 처벌을 감수한다.
		가. 형법 제127조(공무상 비밀의 누설)
		나. 부정경쟁방지 및 영업비밀 보호에 관한 법률 제18조(벌칙)
		다. 산업기술의 유출방지 및 보호에 관한 법률 제14조(산업기술의 유출 및 침해행위 금지)
		라. 산업기술의 유출방지 및 보호에 관한 법률 제34조(비밀유지의무) 
	
	한국과학기술정보연구원장 귀하
			  	</textarea>
			  	</td>
			</tr>
			<tr>
				<td colspan="3" >
					<label class="checkbox-label" style="margin-right:10px;"><input type="radio" name="<portlet:namespace/>agreementYn" value="Y"/><liferay-ui:message key='edison-appstore-workspace-agree' /></label>
					<label class="checkbox-label"><input type="radio" name="<portlet:namespace/>agreementYn" value="N" checked="checked"/><liferay-ui:message key='edison-appstore-workspace-not-agree' /></label>
				</td>
			</tr>
			<tr>
			  <th><liferay-ui:message key='edison-appstore-workspace-security-pledge' /><font color="red">*</font></th>
			  <td colspan="2"><input type="file" name="<portlet:namespace/>addfile"/></td>
			  <td>
			  	<c:if test="${!empty securityFileList}">
					<c:forEach items="${securityFileList}" var="fileMap">
						<p style="float: right; cursor: pointer;" onclick="<portlet:namespace/>fileDownload('${fileMap.fileEntryId }')" >[${fileMap.fileTitle}]</p>
					</c:forEach>
				</c:if>
			 </td>
			</tr>	   
		  </table>
	</div>
	<div style="padding:10px; float:right;">
		<input type="button" value="<liferay-ui:message key='edison-appstore-request' />" class="button0801" onclick="workspaceRequest();return false;" />
	</div>
</form>
