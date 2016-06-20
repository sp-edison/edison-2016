<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>


<script type="text/javascript" src="${contextPath}/js/jquery.form.min.js"></script>


<liferay-portlet:resourceURL var="addPortTypeURL" id="addPortType" copyCurrentRenderParameters="false">
	<portlet:param name="editor" value="${editor}"/>
	<portlet:param name="defaultEditor" value="${defaultEditor}"/>
	<portlet:param name="portTypeName" value="${portTypeName}"/>
	<portlet:param name="availableLanguages" value="${availableLanguages}"/>
	<portlet:param name="inputDeckExist" value="${inputDeckExist}"/>
	<portlet:param name="analyzer" value="${analyzer}"/>
	<portlet:param name="defaultAnalyzer" value="${defaultAnalyzer}"/>
</liferay-portlet:resourceURL>
<script type="text/javascript">
	//inputdeck edit.jsp 에서 사용
	var portletNameSpace = "_edisoninputDeck_WAR_edisonappstore2016portlet_";
	var contextPath  = "${contextPath}";
</script>

<style type="text/css">
	#port-type-add-dialog .puptrline {
		border-bottom: solid 1px #ccc;
	}
	
	#port-type-add-dialog .puptitle {
		font-size: 17px;
		font-weight: 600;
		color: #334b7e;
		padding-left: 8px;
		padding: 10px;
	}
	
	#port-type-add-dialog .puptxt {
		font-size: 14px;
		font-weight: 600;
		color: #666;
		line-height: 25px;
		padding: 10px 0 10px 8px;
	}
	
	#progress_bar_wrap2 {
		width:500px;  
		padding: 10px 30px 30px 30px; 
		background-color:#f7f7f7;
		border-top: 1px solid #e8e8e8; 
	    border-right: 1px solid #e8e8e8; 
	    border-left: 1px solid #e8e8e8; 
	    border-bottom: 1px solid #e8e8e8; 
	    overflow-y: hidden;
	}
	#progress_bar_line {
		padding:1px; 
		border-top: 1px solid #CCCCCC; 
	    border-right: 1px solid #CCCCCC; 
	    border-left: 1px solid #CCCCCC; 
	    border-bottom: 1px solid #CCCCCC; 
	}
	#progress_bar2 {
		width: 0%;
		background-image:url(/edison-appstore-2016-portlet/images/progress_bar.jpg);
		height:20px; 
		text-align:right; 
		line-height:15px; 
		font-size:11px; color:#000000;
	}
</style>
<div class="newWindow" style="background-color: #fff; overflow-x: hidden;overflow-y: hidden;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key="edison-table-list-header-port-Type-add"/>
			</div>
		</div>
		<div class="newWclose">
			<img id="port-type-add-close-btn" name="port-type-add-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	
	<div class="newWcont01">
		<div style="width:50%; float:right; text-align:right; padding-top:15px;">
			<input class="addIp button02_1" onclick="<portlet:namespace/>portTypeSave();return false;" value="<liferay-ui:message key='edison-button-save'/>" type="button"/>
		</div>
		<form name="<portlet:namespace/>portTypeForm" id="<portlet:namespace/>portTypeForm" method="POST" action="<%=addPortTypeURL%>" enctype="multipart/form-data" >
			<aui:input name="inputdeckFormJSON" type="hidden"/>
			<aui:input name="sampleFilePath" type="hidden"/>
			<aui:input name="sampleFileDelete" type="hidden" value="true"/>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
				<colgroup>
					<col width="15%">
					<col width="20%">
					<col width="*">
				</colgroup>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key='edison-table-list-header-port-Type-name'/></td>
					<td colspan="3" class="puptxt">
						<input name="name" value="${portTypeName}" type="text" class="long_field" readonly="readonly"/>
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key='add-sample-data'/></td>
					<td class="puptxt">
						<input type="file" id="<portlet:namespace/>sample_file" name="<portlet:namespace/>sample_file"/>
					</td>
					<td class="puptxt">
						<input class="addIp button02_1" value="file save" type="submit" id="<portlet:namespace/>fileSave" onc/>
					</td>
					<td id="status" class="puptxt">
						
					</td>
				</tr>
			</table>
		</form>
		<c:if test="${inputDeckExist}">
			<div style="min-height: 700px;" class="inputdeck-portlet">
				<liferay-portlet:runtime portletName="edisoninputDeck_WAR_edisonappstore2016portlet"/>
				
<%-- 				<liferay-util:include page='<%= "/WEB-INF/html/appmanager/inputdeck_editor.jsp" %>' servletContext="<%=this.getServletContext() %>"> --%>
					
<%-- 				</liferay-util:include> --%>
			</div>
		</c:if>
	</div>
	
</div>

<div id="progress_bar_wrap2" style="display: none;">
    <div id="progress_bar_line">
        <div id="progress_bar2"><span id="percent">0%</span></div>    
    </div>
</div>

<script type="text/javascript">
AUI().ready(function() {
	//파일 업로드 시  프로그래스바 설정
	$("#progress_bar_wrap2").dialog({
			resizable: false,
			height:50,
			width:700,
			modal: true,			
			draggable: false,
			autoOpen : false
	});
	
	//프로그래스바 탑 툴바제거
	$("#progress_bar_wrap2").siblings('div.ui-dialog-titlebar').remove();
	
	$("#port-type-add-close-btn").click(function() {
		$("#port-type-add-dialog").dialog("close");
	});
	
	var bar = $('#progress_bar2');
	var percent = $('#percent');
	var status = $('#status');
	
	   
	$('#<portlet:namespace/>portTypeForm').ajaxForm({
		beforeSubmit: function(arr, $form, options){
			if($("#<portlet:namespace/>sample_file").val()!=""){
	    		return true;
	    	}else{
	    		return false;
	    	}
		},
	    beforeSend: function() {
	    	if($("#<portlet:namespace/>sample_file").val()!=""){
	    		status.empty();
	    		$("#progress_bar_wrap2").dialog("open");
		        var percentVal = '0%';
		        bar.width(percentVal);
		        percent.html(percentVal);
	    		return true;
	    	}else{
	    		return false;
	    	}
	    },
	    uploadProgress: function(event, position, total, percentComplete) {
	    	var percentVal = percentComplete + '%';
	        bar.width(percentVal)
	        percent.html(percentVal);
	    },
	    error:function(jqXHR, textStatus, errorThrown){
			if(jqXHR.responseText !== ''){
				alert(textStatus+": "+jqXHR.responseText);
			}else{
				alert(textStatus+": "+errorThrown);
			}
			return false;
		},
	    success: function(msg) {
	        var percentVal = '100%';
	        bar.width(percentVal)
	        percent.html(percentVal);
	    },
		complete: function(xhr) {
			$("#progress_bar_wrap2").dialog("close");
			
			var out =  $.parseJSON(xhr.responseText);
			var fileEntryId = out.fileEntryId;
			var title = out.title;
			
			<portlet:namespace/>portTypeForm.<portlet:namespace/>sampleFilePath.value = out.fileEntryId;
			
			<portlet:namespace/>showFile(fileEntryId,title);
		}
	}); 
});

function <portlet:namespace/>showFile(fileEntryId,title){
	$("#<portlet:namespace/>fileSave").hide();
	
	$status = $('#status');
	$("<div/>").addClass("down_date potyTypeFile")
			   .attr("onclick","<portlet:namespace/>fileDownload('"+fileEntryId+"')")
			   .css("cursor","pointer")
			   .css("display","inline-block")
			   .html(title)
			   .appendTo($status);

	$("<img/>").attr("src","${contextPath}/images/icon_dustbin.png")
			   .addClass("potyTypeFile")
			   .attr("width","13")
			   .attr("height","14")
			   .css("cursor","pointer")
			   .attr("onclick","<portlet:namespace/>deleteFile('"+fileEntryId+"','portType','potyTypeFile')")
			   .appendTo($status);
}

function <portlet:namespace/>portTypeSave(){
	if(confirm(Liferay.Language.get('would-you-like-to-save'))){
		
		if("${inputDeckExist}"=="true"){
			<portlet:namespace/>portTypeForm.<portlet:namespace/>inputdeckFormJSON.value = JSON.stringify(inputdeckForm);
		}
		
		if("${fileExist}"=="true"){
			if($(".potyTypeFile").length == 0){
				alert(Liferay.Language.get('this-field-is-mandatory'));
				$("#<portlet:namespace/>sample_file").focus();
				return false;
			}
		}
		
		<portlet:namespace/>portTypeForm.<portlet:namespace/>sampleFileDelete.value = "false";
		
		var addForm = $("form[name=<portlet:namespace/>portTypeForm]").serialize();
		jQuery.ajax({
			type: "POST",
			url: "<%=addPortTypeURL%>",
			async : false,
			data : addForm,
			success: function(msg) {
				alert(Liferay.Language.get('edison-data-insert-success'));
				$("#port-type-add-dialog").dialog("close");
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