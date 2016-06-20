<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="saveRequestLibURL" id="saveRequestLib" copyCurrentRenderParameters="false" escapeXml="false">
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
</liferay-portlet:resourceURL>
<style type="text/css">
	#request-lib-dialog .puptrline {
		border-bottom: solid 1px #ccc;
	}
	
	#request-lib-dialog .puptitle {
		font-size: 17px;
		font-weight: 600;
		color: #334b7e;
		padding-left: 8px;
		padding: 10px;
	}
	
	#request-lib-dialog .puptxt {
		font-size: 14px;
		font-weight: 600;
		color: #666;
		line-height: 25px;
		padding: 10px 0 10px 8px;
	}
	
	.aui input[type="text"],
	.aui textarea{
		margin-bottom: 0px;
	}
	
	.aui .text_field{
		width: 280px;
		height: 100px;
		resize: none;
	}
</style>
<<c:choose>
	<c:when test="${mode eq 'add' }">
		<c:set var="disabled" value=""/>
	</c:when>
	<c:otherwise>
		<c:set var="disabled" value="disabled=disabled"/>
	</c:otherwise>
</c:choose>
		

<div class="newWindow" style="background-color: #fff; overflow-x: hidden;overflow-y: hidden;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-appstore-request-info' />
			</div>
		</div>
		<div class="newWclose">
			<img id="request-lib-close-btn" name="request-lib-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	
	<div class="newWcont01">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
			<colgroup>
				<col width="28%">
				<col width="*">
			</colgroup>
			<tr class="puptrline">
				<td class="puptitle">
					<liferay-ui:message key='edison-table-list-header-file-nm'/><span class="requiredField"> *</span>
				</td>
				<td class="puptxt">
					<input type="text" id="lib_file_nm" maxlength="40" style="width: 280px;" value="${data.libraryName}" ${disabled}/>
				</td>
			</tr>
			<tr class="puptrline">
				<td class="puptitle">
					<liferay-ui:message key='version'/><span class="requiredField"> *</span>
				</td>
				<td class="puptxt">
					<input type="text" id="lib_file_version" maxlength="20" style="width: 280px;" value="${data.libraryVersion}" ${disabled}/>
				</td>
			</tr>
			<tr class="puptrline">
				<td class="puptitle">
					<liferay-ui:message key='edison-table-list-header-content'/>
				</td>
				<td class="puptxt">
					<textarea rows="" cols="" id="lib_file_content" class="text_field" maxlength="500" ${disabled}>
						${data.requiredContent}
					</textarea>
				</td>
			</tr>
			<c:if test="${!empty data.confirmContent}">
				<tr class="puptrline">
					<td class="puptitle">
						<liferay-ui:message key='edison-virtuallab-confirm-info' />
					</td>
					<td class="puptxt">
						<textarea rows="" cols="" id="lib_file_content" class="text_field" maxlength="500" disabled="disabled">
							${data.confirmContent}
						</textarea>
					</td>
				</tr>
			</c:if>
			
		</table>
		<c:if test="${mode eq 'add' }">
			<div class="popupbtnGroup" style="height:20px;margin-top: 10px;">
				<input type="button" class="graybtn" onclick="<portlet:namespace/>saveRequestLib()" value="<liferay-ui:message key='edison-virtuallab-save' />" />
			</div>
		</c:if>
	</div>
</div>

<script type="text/javascript">
AUI().ready(function() {
	$("#request-lib-close-btn").click(function() {
		$("#request-lib-dialog").dialog("close");
	});
});

function <portlet:namespace/>saveRequestLib() {
	if(confirm(Liferay.Language.get('would-you-like-to-save'))){
		var name = $("#lib_file_nm").val();
		var version = $("#lib_file_version").val();
		var content = $("#lib_file_content").html();
		
		if(name.trim()==""){
			alert(Liferay.Language.get('this-field-is-mandatory'));
			$("#lib_file_nm").focus();
			return false;
		}else if(version.trim()==""){
			alert(Liferay.Language.get('this-field-is-mandatory'));
			$("#lib_file_version").focus();
			return false;
		}
		
		var saveForm = {
				"<portlet:namespace/>name" : name,
				"<portlet:namespace/>version" : version,
				"<portlet:namespace/>content" : content
		};
		
		jQuery.ajax({
			type: "POST",
			url: "<%=saveRequestLibURL%>",
			async : false,
			data  : saveForm,
			success: function(result) {
				if(result=="SUCCESS"){
					alert(Liferay.Language.get('edison-data-insert-success'));
					<portlet:namespace/>searchRequestLib();
					$('.ui-widget-overlay').click();
				}
			},error:function(jqXHR, textStatus, errorThrown){
				if(jqXHR.responseText !== ''){
					alert(textStatus+": "+jqXHR.responseText);
				}else{
					alert(textStatus+": "+errorThrown);
				}  
			}
		});
	}
	
}
</script>

