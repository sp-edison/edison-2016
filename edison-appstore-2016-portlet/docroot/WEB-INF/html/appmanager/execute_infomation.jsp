<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%@ page import="org.kisti.edison.science.service.constants.ScienceAppConstants"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<%
	String mode = GetterUtil.get(request.getAttribute("mode"), "");
	String fileErrorMsg = LanguageUtil.get(themeDisplay.getLocale(),"edison-science-appstore-toolkit-file-size-error-message");
%>
<portlet:actionURL var="submitURL" copyCurrentRenderParameters="false" name="appAction">
	<portlet:param name="clickTab" value="${clickTab}"/>
	<portlet:param name="actionType" value="exeInfomation"/>
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
	<portlet:param name="swTest" value="${swTest}"/>
	
	<portlet:param name="searchValue" value="${searchValue}"/>
	<portlet:param name="searchOption" value="${searchOption}"/>
	<portlet:param name="searchStatus" value="${searchStatus}"/>
	<portlet:param name="p_curPage" 	value="${p_curPage}" />
</portlet:actionURL>

<liferay-portlet:renderURL var="libChangeRenderURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<portlet:param name="myRender" value="libChangeRender"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="commonLibRenderURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<portlet:param name="myRender" value="commonLibRender"/>
</liferay-portlet:renderURL>

<liferay-portlet:resourceURL var="searchRequestLibURL" escapeXml="false" id="searchRequestLib" copyCurrentRenderParameters="false"/>


<liferay-portlet:resourceURL var="addScienceAppFileURL" id="addScienceAppFile" copyCurrentRenderParameters="false">
	<portlet:param name="appName" value="${data.name}"/>
	<portlet:param name="appVersion" value="${data.version}"/>
</liferay-portlet:resourceURL>


<style type="text/css">
	.aui input[type="text"],
	.aui textarea{
		margin-bottom: 0px;
	}
	
	.aui .long_field{
		width: 350px;
	}
	
	.aui .short_field{
		width: 150px;
	}
	
	.aui .too_long_field{
		width: 500px;
	}
	
	.aui .text_field{
		width: 700px;
		height: 100px;
		resize: none;
	}
	
	.aui .swrightcont .alert{
		margin-top: 10px;
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

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-appstore-execute-information' />
	</div>
	<div style="width:60%; float:right; text-align:right; padding-top:15px;">
		<input class="addIp button02_2" onclick="<portlet:namespace/>goList();" value="<liferay-ui:message key='edison-button-board-list'/>" type="button">
		<c:if test="${appStatusButtonView}">
			<c:if test="${data.status eq '1901001'}">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901002');" value="<liferay-ui:message key='edison-appstore-status-request'/>" type="button">
			</c:if>
			<c:if test="${data.status eq '1901002' && isAdmin}">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901003');" value="<liferay-ui:message key='edison-appstore-status-private'/>" type="button">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901004');" value="<liferay-ui:message key='edison-appstore-status-service'/>" type="button">
			</c:if>
			<c:if test="${data.status eq '1901003'}">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901004');" value="<liferay-ui:message key='edison-appstore-status-service'/>" type="button">
<%-- 				<c:if test="${data.swTest == false}"> --%>
<%-- 					<input class="addIp button02_1" onclick="<portlet:namespace/>actionCall('<%=Constants.ADD%>');return false;" value="<liferay-ui:message key='edison-button-save'/>" type="button"> --%>
<%-- 				</c:if> --%>
			</c:if>
			<c:if test="${data.status eq '1901004'}">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901003');" value="<liferay-ui:message key='edison-appstore-status-private'/>" type="button">
<%-- 				<c:if test="${data.swTest == false}"> --%>
<%-- 					<input class="addIp button02_1" onclick="<portlet:namespace/>actionCall('<%=Constants.ADD%>');return false;" value="<liferay-ui:message key='edison-button-save'/>" type="button"> --%>
<%-- 				</c:if> --%>
			</c:if>
		</c:if>
		
		<c:if test="${data.status le 1901002}">
			<input class="addIp button02_1" onclick="<portlet:namespace/>actionCall('<%=Constants.ADD%>');return false;" value="<liferay-ui:message key='edison-button-save'/>" type="button">
		</c:if>
		
		<c:if test="${ownerThan}">
			<input class="addIp button02_1" onclick="<portlet:namespace/>actionCall('<%=Constants.DELETE%>');return false;" value="<liferay-ui:message key='delete'/>" type="button">
		</c:if>
	</div>
</div>
<div class="h10"></div>
<div class="table1_list">
	<aui:form name="frm" method="POST" action="<%=submitURL%>">
		<aui:input name="actionMode" value="${mode}" type="hidden"/>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
			<colgroup>
				<col width="15%">
				<col width="35%">
				<col width="15%">
				<col width="35%">
			</colgroup>
			<tr>
				<th><liferay-ui:message key='edison-table-list-header-file-nm' /><span class="requiredField"> *</span></th>
				<td colspan="3">
					<aui:input name="exeFileName" type="text" cssClass="long_field noupdate" label="" value="${data.exeFileName}">
						<aui:validator name="required"/>
					</aui:input>
				</td>
			</tr>
			<tr>
				<th>Open Level</th>
				<td id="opendLevelTd">
					<aui:select name="openLevel" label="" onChange="changeOpenLevel(this.value);" cssClass="noupdate">
						${openLevelOptions}
					</aui:select>
				</td>
				<th id="sourceFileTh">Source File</th>
				<td id="sourceFileTd">
					<input type="file" id="<portlet:namespace/>sourceFile" name="<portlet:namespace/>sourceFile" disabled="disabled">
					<c:if test="${data.sourceFileId ne null}">
						<div class="down_date sourceFileClass"  onclick="<portlet:namespace/>fileDownload('${data.sourceFileId }')" style="cursor: pointer;display: inline-block;">
							${data.sourceFileTitle}
						</div>
						<img src='${contextPath}/images/icon_dustbin.png' class="sourceFileClass noUpdateHidden" width='13' height='14' style="cursor:pointer" onClick="<portlet:namespace/>deleteFile('${data.sourceFileId}','soruceFile','sourceFileClass');"/>
					</c:if>
				</td>
			</tr>
			<c:choose>
				<c:when test="${data.swTest}">
					<tr>
						<th>App Type</th>
						<td colspan="3">
							<aui:select name="appType" label="" cssClass="noupdate">
								${appTypeOptions}
							</aui:select>
						</td>
					</tr>
					<tr>
						<th>Run Type</th>
						<td>
							<aui:select name="runType" label="" onChange="changeRunType(this.value);" cssClass="noupdate">
								${runTypeOptions}
							</aui:select>
						</td>
						<th>PARALLEL_Module</th>
						<td>
							<aui:select name="parallelModule" label="" disabled="<%=true%>" cssClass="runTypeDisabled">
								<option value=""><liferay-ui:message key='nobody' /></option>
								${parallelOptions}
							</aui:select>
						</td>
					</tr>
					<tr>
						<th>Max CPU</th>
						<td>
							<aui:input name="maxCpus" type="text" label="" cssClass="short_field runTypeDisabled" disabled="<%=true%>" value="${data.maxCpus}">
								<aui:validator name="number"/>
								<aui:validator name="maxLength">2</aui:validator>
								<aui:validator name="max">20</aui:validator>
							</aui:input>
						</td>
						<th>Default CPU</th>
						<td>
							<aui:input name="defaultCpus" type="text" label="" cssClass="short_field runTypeDisabled" disabled="<%=true%>" value="${data.defaultCpus}">
								<aui:validator name="number"/>
								<aui:validator name="maxLength">2</aui:validator>
								<aui:validator name="max">20</aui:validator>
							</aui:input>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<th>App Type</th>
						<td>
							<aui:select name="appType" label="" onChange="changeAppType(this.value);" cssClass="noupdate">
								${appTypeOptions}
							</aui:select>
						</td>
						<th>Editor Type</th>
						<td>
							<aui:select name="editorType" label="" disabled="<%=false%>">
								${editorTypeOptions}
							</aui:select>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</aui:form>
</div>

<c:if test="${data.swTest}">
	<div class="h10"></div>
	<div class="table1_list">
		<aui:form name="scienceAppFileForm" method="POST" action="<%=addScienceAppFileURL%>" enctype="multipart/form-data" onSubmit="return false;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
				<colgroup>
					<col width="15%">
					<col width="*">
					<col width="20%">
					<col width="15%">
				</colgroup>
				<tr>
					<th><liferay-ui:message key='edison-science-appstore-exe-file' /></th>
					<td>
						<aui:input name="scienceAppFile" type="file" label="">
							<aui:validator name="required"/>
							<aui:validator name="acceptFiles" >'gz,tar,zip'</aui:validator>
							<aui:validator  name="custom"  errorMessage="<%=fileErrorMsg%>"> 
									function (val, fieldNode, ruleValue) {
										var fileObj = document.getElementById("<portlet:namespace/>scienceAppFile");
										var returnStatus = false;
										if(typeof fileObj.files[0] != "undefined"){
											var fileSize = Math.ceil(fileObj.files[0].size/1024);
											if(fileSize<=200*1024){
												returnStatus = true;
											}
										}else{
											returnStatus = true;
										}
										
										return returnStatus;
									}
								</aui:validator>
						</aui:input>
					</td>
					<td class="TC">
						<input class="addIp button02_1" value="file save" type="submit" id="<portlet:namespace/>fileSave"/>
					</td>
					<td>
						<span id="fileUpladMsg">
							<c:if test="${exeFileUpload}">
								<liferay-ui:message key='edison-science-appstore-toolkit-file-upload-success-message' />
							</c:if>
						</span>
					</td>
				</tr>
			</table>
		</aui:form>
	</div>
</c:if>



<c:if test="${data.swTest}">
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" />
		<div class="virtitle">
			<liferay-ui:message key='edison-science-appstore-library-request' />
		</div>
		<div style="margin: 0 auto;overflow: hidden;padding-top: 18px;padding-bottom: 5px;text-align: center;float: right;">
			<c:if test="${!isOsWindow}">
				<input class="button0801" type="button" onclick="<portlet:namespace/>openCommonLibPopup();" value="<liferay-ui:message key='views' />">
			</c:if>
			<input class="button0801" type="button" onclick="<portlet:namespace/>RequestLibPopup();" value="<liferay-ui:message key='edison-appstore-request' />">
		</div>
	</div>
	<div class="h10"></div>
	<div class="table1_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<colgroup>
				<col width="10%" />
				<col width="*"/>
				<col width="20%" />
				<col width="20%" />
				<col width="15%" />
			</colgroup>
			<thead>
				<tr>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-file-nm' /></th>
					<th align="center" scope="col"><liferay-ui:message key='version' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-date'/></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-status' /></th>
				</tr>
			</thead>
			<tbody id="<portlet:namespace/>libraryRequestList">
				
			</tbody>
		</table>
		<div id="pageListDiv" class="paging">
			
		</div>
	</div>
</c:if>

<div id="request-lib-dialog" title="request-lib" class="bigpopupbox" style="display: none;">
	
</div>

<div id="common-lib-dialog" title="common-lib" class="bigpopupbox" style="display: none;">
	
</div>
<!-- 	Progress Bar	  -->
<div id="progress_bar_wrap2" style="display: none;">
    <div id="progress_bar_line">
        <div id="progress_bar2"><span id="percent"></span></div>    
    </div>
</div>


<script type="text/javascript" src="${contextPath}/js/jquery.form.min.js"></script>
<script type="text/javascript">
<%
if(mode.equals(Constants.UPDATE)){
%>
	$(document).ready(function () {
		changeOpenLevel('${data.openLevel}');
		changeRunType('${data.runType}');
		changeAppType('${data.appType}');
		<portlet:namespace/>searchRequestLib();
		<portlet:namespace/>noUpdateDisabled('${data.status}');
	});
<%}%>

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
	
	
	var bar = $('#progress_bar2');
	var percent = $('#percent');
	
	 var options = {
		timeout:   3000
	};
	 
	 
	$('#<portlet:namespace/>scienceAppFileForm').ajaxForm({
		beforeSubmit: function(arr, $form, options){
			if($("#<portlet:namespace/>scienceAppFile").hasClass("success-field")){
	    		return true;
	    	}else{
	    		return false;
	    	}
		},
	    beforeSend: function() {
	    	if(!$("#<portlet:namespace/>scienceAppFile").hasClass("error-field")){
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
			var fileName = out.fileName;
			$("#fileUpladMsg").text(Liferay.Language.get('edison-science-appstore-toolkit-file-upload-success-message'));
		}
	}); 
});

function <portlet:namespace/>actionCall(mode){
	if(mode=='<%=Constants.ADD%>'){
		<portlet:namespace/>frm.encoding = "multipart/form-data";
		if($("#<portlet:namespace/>runType").val()=="<%=ScienceAppConstants.APP_RUNTYPE_PARALLEL%>"){
			$maxCpus = $("#<portlet:namespace/>maxCpus");
			$defaultCpus = $("#<portlet:namespace/>defaultCpus");
			
			if($maxCpus.val()==""){
				alert(Liferay.Language.get('this-field-is-mandatory'));
				$maxCpus.focus();
				return false;
			}
			
			if($defaultCpus.val()==""){
				alert(Liferay.Language.get('this-field-is-mandatory'));
				$defaultCpus.focus();
				return false;
			}
			
			if(Number($defaultCpus.val())>Number($maxCpus.val())){
				alert(Liferay.Language.get('edison-science-appstore-toolkit-execute-cpu-error'));
				$maxCpus.focus();
				return false;
			}
		}
		
		submitForm(<portlet:namespace/>frm);
	}else{
		if(confirm(Liferay.Language.get('edison-appstore-delete-data-alert'))){
			<portlet:namespace/>frm.<portlet:namespace/>actionMode.value = mode;
		}else{
			return false;
		}
		<portlet:namespace/>frm.submit();
	}
}

function <portlet:namespace/>searchRequestLib(p_curPage){
	if("${data.swTest}"=="true"){
		var searchForm = {
				"<portlet:namespace/>scienceAppId" : "${scienceAppId}",
				"<portlet:namespace/>p_curPage": p_curPage
		};
		
		$("#<portlet:namespace/>libraryRequestList tr:not(:has(#1))").remove();
		
		jQuery.ajax({
			type: "POST",
			url: "<%=searchRequestLibURL%>",
			async : false,
			data  : searchForm,
			dataType: 'json',
			success: function(result) {
				$tbody = $("#<portlet:namespace/>libraryRequestList");
				document.getElementById("pageListDiv").innerHTML="";
				var length = result.dataList.length;
				
				if(length == 0) {
					$rowResult = $("<tr/>");
					$("<td/>").css("text-align","center")
							  .text(Liferay.Language.get('edison-there-are-no-data'))
							  .attr("colspan","5")
							  .appendTo($rowResult);
					$tbody.append($rowResult);
				}else{
					for(var i = 0; i < length; i++) {
						var data = result.dataList[i];
						
						$rowResult = $("<tr/>");
						
						if(i%2 == 1){
							$rowResult.addClass("tablebgtr");
	 					}
						
						$rowResult.css("cursor","pointer")
								  .on("click",function(){<portlet:namespace/>RequestLibPopup(data.requiredLibId);});
						
						
						$("<td/>").addClass("TC").text(result.seq-i).appendTo($rowResult);
						$("<td/>").text(data.libraryName).appendTo($rowResult);
						$("<td/>").addClass("TC").text(data.libraryVersion).appendTo($rowResult);
						$("<td/>").addClass("TC").text(formatDate(data.requiredDate)).appendTo($rowResult);
						$("<td/>").addClass("TC").text(data.requiredState).appendTo($rowResult);
						
						$tbody.append($rowResult);
					}
					
					
					document.getElementById("pageListDiv").innerHTML=result.page;
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

$("#common-lib-dialog").dialog({
	autoOpen: false,
	width: 900,
	height: 600,
    modal: true,
    resizable: false,
    show: {effect:'fade', speed: 800}, 
    hide: {effect:'fade', speed: 800},
    open: function(event, ui) {
    	$(this).parent().css('overflow', 'visible');
    	$(this).css('overflow', 'visible');
    	$(this).removeClass("ui-widget-content");
    	$(this).parent().removeClass("ui-widget-content");
    	
    	$('.ui-widget-overlay').bind('click',function(){
    		$("#common-lib-dialog").dialog("close");
    	})
    },
    close: function() {
    	$("#request-lib-dialog").empty();
    }
}).dialog("widget").find(".ui-dialog-titlebar").remove();


$("#request-lib-dialog").dialog({
	autoOpen: false,
	width: 500,
	height: 'auto',
    modal: true,
    resizable: false,
    show: {effect:'fade', speed: 800}, 
    hide: {effect:'fade', speed: 800},
    open: function(event, ui) {
    	$(this).parent().css('overflow', 'visible');
    	$(this).css('overflow', 'visible');
    	$(this).removeClass("ui-widget-content");
    	$(this).parent().removeClass("ui-widget-content");
    	
    	$('.ui-widget-overlay').bind('click',function(){
    		$("#request-lib-dialog").dialog("close");
    	})
    },
    close: function() {
    	$("#request-lib-dialog").empty();
    }
}).dialog("widget").find(".ui-dialog-titlebar").remove();


function <portlet:namespace/>RequestLibPopup(p_requiredLibId){
	var renderParameter = "";
	renderParameter += "&<portlet:namespace/>scienceAppId=${scienceAppId}";
	
	if(p_requiredLibId!=""){
		renderParameter += "&<portlet:namespace/>requiredLibId="+p_requiredLibId;
	}
	var URL = "<%=libChangeRenderURL%>"+renderParameter;
	
	$("#request-lib-dialog").load(URL, function (e) {
		$("#request-lib-dialog").dialog("open");
	});
}

function <portlet:namespace/>openCommonLibPopup(){
	var URL = "<%=commonLibRenderURL%>";
	
	$("#common-lib-dialog").load(URL, function (e) {
		$("#common-lib-dialog").dialog("open");
	});
}

function changeOpenLevel(val){
	var file = $("#<portlet:namespace/>sourceFile");
	if(val!="<%=ScienceAppConstants.OPENLEVEL_RUN%>"){
		if(val==''){
			file.attr("disabled",true);
		}else{
			if(Number('${data.status}')>=1901003){
				file.attr("disabled",true);
			}else{
				file.attr("disabled",false);
			}
			
		}
	}else{
		file.attr("disabled",true);
	}
}


function changeAppType(val){
	var select = $("#<portlet:namespace/>editorType");
	if(val=="<%=ScienceAppConstants.APP_TYPE_EDITOR%>"){
		select.attr("disabled",false);
	}else{
		select.attr("disabled",true);
	}
}


function changeRunType(val){
	if(val=="<%=ScienceAppConstants.APP_RUNTYPE_PARALLEL%>"){
		$(".runTypeDisabled").attr("disabled",false);
	}else{
		if(val!=''){
			$(".runTypeDisabled").attr("disabled",true);
		}else{
			$(".runTypeDisabled").attr("disabled",false);
		}
	}
}



</script>