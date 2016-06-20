<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="workspaceRequestURL" id="workspaceRequest" />

<liferay-portlet:actionURL var="addRequestURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="addRequest"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL var="redirectURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="${param.redirectAction}"/>
</liferay-portlet:renderURL>

<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>

<script type="text/javascript">
/************** ready   ***************/
$(document).ready(function() {
	$( "#<portlet:namespace/>processDate" ).datepicker({
    	showButtonPanel: true,
    	showOn: 'button',
    	dateFormat:"yy-mm-dd",
    	changeMonth: true,
    	changeYear: true,
    	buttonImage: "${contextPath}/images/calendar.png",
        buttonImageOnly: true
    });
	
	$("#workspaceDetail").hide();
	 $("#addRequest_dialog").dialog({
			resizable: false,
			height:'auto',
			width:'auto',
			modal: true,
			draggable: false,
			autoOpen : false,
		    show: {effect:'fade', speed: 800}, 
		    hide: {effect:'fade', speed: 200},
		    open: function(event, ui) {
		    	$(this).removeClass("ui-widget-content");
		    	$(this).parent().removeClass("ui-widget-content");
		    },
		}).dialog("widget").find(".ui-dialog-titlebar").remove();	
});
/************** ready end   ***************/

function addrequestBtn() {
	var workspaceform = $("form[name=workspaceform]").serialize();
	jQuery.ajax({
		type: "POST",
		url: "<%=addRequestURL%>",
		async : false,
		data  : workspaceform,
		success: function(result) {
			alert("<liferay-ui:message key='edison-data-insert-success' />");
			window.location.href='';
		},error:function(data,e){
			alert(e);
			return false;
		},complete:function(){
			$( "#addRequest_dialog" ).dialog( "close" );
		}
	});
}

function workspaceDetailView(){		
	if($("#workspaceDetailButton").val() == "<liferay-ui:message key='edison-appstore-open' />"){
		$("#workspaceDetail").show();
		$("#workspaceDetailButton").val("<liferay-ui:message key='edison-appstore-close' />");
	}else{
		$("#workspaceDetail").hide();
		$("#workspaceDetailButton").val("<liferay-ui:message key='edison-appstore-open' />");
	}
}

function addRequest(){
	$("#addRequest_dialog").dialog("open");
}

function historyBack(){
	window.location.href = "<liferay-portlet:renderURL/>";
}

function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}
</script>

<!-- 페이지 타이틀 & 네비게이션 -->
<h1>
	<liferay-ui:message key='edison-appstore-workspace-detail-view' />
</h1>

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
			<td>${delevoperMap.requestSortNm}</td>
			<th><liferay-ui:message key='edison-appstore-developer-preferred-date' /></th>
			<td>${delevoperMap.useStart} ~ ${delevoperMap.useEnd}	      
			</td>
		</tr>
		<tr>
			<th><liferay-ui:message key='edison-appstore-workspace-use-language' /></th>
			<td colspan="3">
				<input name="<portlet:namespace/>languageFortran" type="checkbox" disabled="disabled" ${delevoperMap.languageFortran == 'Y' ? 'checked=checked' : ''}>fortran</input>
				<input name="<portlet:namespace/>languageCpp" type="checkbox" disabled="disabled" ${delevoperMap.languageCpp == 'Y' ? 'checked=checked' : ''}>c/c++</input>
				<input name="<portlet:namespace/>languagePython" type="checkbox" disabled="disabled" ${delevoperMap.languagePython == 'Y' ? 'checked=checked' : ''}>python</input>
				<input name="<portlet:namespace/>languageJava" type="checkbox" disabled="disabled" ${delevoperMap.languageJava == 'Y' ? 'checked=checked' : ''}>java</input>
				<input name="<portlet:namespace/>languageOther" type="checkbox" disabled="disabled" ${delevoperMap.languageOther == 'Y' ? 'checked=checked' : ''}><liferay-ui:message key='edison-appstore-workspace-etc' />&nbsp;&nbsp;&nbsp;${delevoperMap.languageOtherDescription}</input></td>
			</td>
		</tr>

		<c:forEach items="${ipList}" var="data" varStatus="status">		   
			<tr>
				<c:if test="${status.index == 0}"><th rowspan="${fn:length(ipList)}"><liferay-ui:message key='edison-appstore-workspace-access-ip' /></th></c:if>
				<td colspan="7">${data.ip1}.${data.ip2}.${data.ip3}.${data.ip4}</td>		     
			</tr>
		</c:forEach>
		<tr>
			<th><liferay-ui:message key='edison-appstore-remark' /></th>
			<td width="91%" colspan="5">
				<textarea name="<portlet:namespace/>rem" rows="10" cols="150" readonly="readonly" style="resize: none;width: 95%;margin: 0px;" spellcheck="false">${delevoperMap.rem}</textarea>
			</td>
		</tr>
	</table>
</div>

	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-appstore-workspace-detail-view' />
			<input type="button" id="workspaceDetailButton" value="<liferay-ui:message key='edison-appstore-open' />" class="button01b" onclick="workspaceDetailView();return false;" />
		</div>
	</div>

	<div class="h10"></div>
	
<div class="table1_list">
	<table id="workspaceDetail" width="100%" border="0" cellspacing="0" cellpadding="0" class="data" style="table-layout: fixed;">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tr>
			<th><liferay-ui:message key='edison-appstore-workspace-server-ip' /></th>
			<td colspan="3">${delevoperMap.detailIp}</td>
		</tr>
		<tr>
			<th>OS</th>
			<td colspan="3">${delevoperMap.detailOs}</td>
		</tr>
		<tr>
			<th>CPU</th>
			<td colspan="3">${delevoperMap.detailCpu}</td>
		</tr>
		<tr>
			<th><liferay-ui:message key='edison-appstore-workspace-storage-capacity' /></th>
			<td colspan="3">${delevoperMap.detailStorate}</td>
		</tr>
		<tr>
			<th><liferay-ui:message key='edison-appstore-workspace-access-manual' /></th>
			<td colspan="3">
				<c:if test="${!empty manualFileList}">
					<c:forEach items="${manualFileList}" var="fileMap">
						<p onclick="<portlet:namespace/>fileDownload('${fileMap.fileEntryId }')" style="cursor: pointer;">[${fileMap.fileTitle}]</p>
					</c:forEach>
				</c:if>
			</td>
		</tr>
		<tr>
			<th><liferay-ui:message key='edison-appstore-workspace-etc' /></th>
			<td colspan="3">${delevoperMap.detailLibrary}</td>
		</tr>
	</table>
</div>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-virtuallab-confirm-info' />
		<c:if test="${delevoperMap.requestStatus !='1202001'}">
			<input type="button" onclick="addRequest();return false;" class="btnA_4 button01b" value="<liferay-ui:message key='edison-appstore-workspace-add-request' />" />
		</c:if>
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
			<th><liferay-ui:message key='edison-virtuallab-confirm-status' /></th>
			<td>${delevoperMap.requestStatusNm}</td>
			<th><liferay-ui:message key='edison-science-appstore-toolkit-change-processing-date' /></th>
			<td>${delevoperMap.processDate}</td>
		</tr>
		<tr>
			<th><liferay-ui:message key='edison-table-list-header-userid' /></th>
			<td>${delevoperMap.developerId}</td>
			<th><liferay-ui:message key='password' /></th>
			<td colspan="3">${delevoperMap.developerPassword}</td>
		</tr>
		<tr>
			<th><liferay-ui:message key='edison-appstore-workspace-request-use' /></th>
			<td colspan="5">
				${delevoperMap.requestSortNm}
			</td>
		</tr>
		<tr>
			<th><liferay-ui:message key='edison-science-appstore-toolkit-change-request-content' /></th>
			<td width="85%" colspan="5">
				<textarea cols="150" rows="5" readOnly>${delevoperMap.requestNote}</textarea>
			</td>
		</tr>
		<tr>
			<th><liferay-ui:message key='edison-process-note-info' /></th>
			<td colspan="3" style="line-height: 15px;">
				<c:forEach var="data" items="${requestList}">
					<div style="padding:10px 0px; border-bottom: 1px dashed #e0e0e0">
						<span style="font-weight: 600;"><liferay-ui:message key='edison-science-appstore-toolkit-change-result-of-management' /> : </span><span>${data.requestStatusNm}</span><br>
						<span style="font-weight: 600;"><liferay-ui:message key='edison-process-note' /> : </span><span>${data.processNote}</span><br/>
						<span style="font-weight: 600;">${data.requestStatusNm} <liferay-ui:message key='edison-science-appstore-toolkit-change-date' /> : </span><span>${fn:substring(data.updateDate,0,19)}</span><br>		      
						<span style="font-weight: 600;"><liferay-ui:message key='edison-appstore-workspace-request-use' /> : </span><span>${data.requestSortNm}</span><br/>
						<span style="font-weight: 600;"><liferay-ui:message key='edison-science-appstore-toolkit-change-request-content' /> : </span>
						<pre style="margin:5px; width:85%; font-family: Arial,Nanum Barun Gothic,NanumGothic;">${data.requestNote}</pre>
					</div>				</c:forEach>
			</td>
		</tr>
	</table>
</div>

<div id="addRequest_dialog" class="newWindow" style="background-color:#fff; padding:0px;">

	<div class="newWheader">
		<div class="newWtitlebox"><img src="${contextPath}/images/title_newWindow.png" width="34" height="34" />
			<div class="newWtitle">
				<liferay-ui:message key='edison-appstore-workspace-add-request-view' />
			</div>
		</div>
		<div class="newWclose"><img src="${contextPath}/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer;" onclick="$('#addRequest_dialog').dialog('close');" /></div>
	</div>
	
	<form name="workspaceform" method="post" style="margin:0px;">
		<input name="<portlet:namespace/>userId" type="hidden" value="${delevoperMap.userId}"/>	
		<input name="<portlet:namespace/>requestStatus" type="hidden" value="1202004"/>
		<div class="newWcont01">
			<div class="table1_list borderno">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data">
					<colgroup>
						<col width="30%" />
						<col width="70%" />
					</colgroup>
					<tr>
						<th><liferay-ui:message key='edison-appstore-workspace-division' /></th>
						<td>
							<select name="<portlet:namespace/>requestSort">
							${requestSortStr}
							</select>
						</td>
					</tr>
					<tr>
						<th><liferay-ui:message key='edison-science-appstore-toolkit-change-request-content' /></th>
						<td><textarea name="<portlet:namespace/>requestNote" rows="7" cols="50" style="resize: none;width: 95%;margin: 0px;" spellcheck="false"></textarea></td>
					</tr>
				</table>
			</div>
			<div class="buttonbox">
				<input type="button" value="<liferay-ui:message key='edison-appstore-request' />" class="button06" onclick="addrequestBtn();"/>
			</div>
		</div>
	</form>
</div>