<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%
	String groupNm = (String)request.getAttribute("groupNm");
	String groupId = (String)request.getAttribute("groupId");
	String mode = (String)request.getAttribute("mode");
	String contentSeq = (String)request.getAttribute("contentSeq");
	String selectLang = (String)request.getAttribute("select_languageId");
	
	String create = LanguageUtil.format(locale, "edison-advanced-content-create", "");
	String update = LanguageUtil.format(locale, "edison-advanced-content-update", "");
%>
<style type="text/css">
	.aui .control-group{
		margin-bottom: 0px;
	}
	
	.aui input[type="text"],
	.aui input[type="password"],
	.aui textarea{
		margin-bottom: 0px;
	}
	
	.aui .long_field{
		width: 350px;
	}
	
	.aui .short_field{
		width: 200px;
	}
	
	.aui .edison_file{
		border:1px solid #CCCCCC;
		margin-bottom:2px;
	}
	
	.aui .input-localized-input{
		display: table-row;
	}
</style>
<liferay-portlet:actionURL secure="<%= request.isSecure() %>" var="modifyAdvancedContentUrl">
	<portlet:param name="myaction" value="advancedModify" />
</liferay-portlet:actionURL>
<div class="newWindow" style="background-color: #fff; overflow-x: hidden;overflow-y: hidden;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<c:choose>
				<c:when test="${mode eq 'add' }">
					<div class="newWtitle"><liferay-ui:message key="<%=groupNm%>"/> <liferay-ui:message key="edison-advanced-content-create"/></div>
				</c:when>
				<c:otherwise>
					<div class="newWtitle"><liferay-ui:message key="<%=groupNm%>"/> <liferay-ui:message key="edison-advanced-content-update"/></div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="newWclose">
			<img id="advanced-writer-dialog-close-btn" name="advanced-writer-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<aui:form action="<%= modifyAdvancedContentUrl %>" method="post" name="createAdvancedContentForm" id="createAdvancedContentForm"  enctype="multipart/form-data" style="margin:0px;">
		<aui:input name="groupId" type="hidden" value="<%=groupId%>"/>
		<aui:input name="mode" type="hidden" value="<%=mode%>"/>
		<aui:input name="contentSeq" type="hidden" value="<%=contentSeq%>"/>
		<aui:input name="deleteFile" type="hidden" value=""/>
		<aui:input name="deleteAdvancedFile" type="hidden" value=""/>
		<aui:input name="nowLanguage" type="hidden" value="<%=selectLang %>"/>
		
		
		<div class="newWcont01">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<colgroup>
				<col width="20%" />
				<col width="80%" />
			</colgroup>
			<tbody>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key="edison-content-service-language"/></td>
					<td class="puptxt">
 						<c:forEach var="lang" items="${ableLang }">
							<label style="display:inline;">
								<input type="radio" id="<portlet:namespace/>select_languageId" name="<portlet:namespace/>select_languageId" value="${lang }" />
								
								<img width="17px" height="12px" src="${contextPath}/images/toplink_${lang }.gif" />
								<liferay-ui:message key='edison-board-radiobutton-${lang }' />
							</label>
						</c:forEach>
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key="edison-table-list-header-topic"/></td>
					<td class="puptxt">
						<div class="control-group">
							<input name="<portlet:namespace/>title" value="${advancedContent.title}" style="display: inline-block;" cssClass="long_field" type="text"/>
						</div> 
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key="edison-table-list-header-resume"/></td>
					<td class="puptxt">
					<div class="control-group">
<%-- 						<liferay-ui:input-localized name="resume" type="textarea" xml="${advancedContent.resume}"  rows="3" spellcheck="false" style="width: 95%; resize:none;margin-bottom:0px;"/> --%>
						<textarea name="<portlet:namespace/>resume" style="width: 95%; resize:none;margin-bottom:0px;" rows="3" spellcheck="false" >${advancedContent.resume}</textarea>
					</div>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key="edison-content-file"/></td>
					<td class="puptxt">
						<c:choose>
							<c:when test="${mode eq 'add' }">
								<aui:input type="file" label="" name="contentFile" cssClass="edison_file" value=""/>
							</c:when>
							<c:otherwise>
								<div id="advancedFilediv">
									<span>
										${advancedContent.contentFileNm}
										<img src="<%=themeDisplay.getPathThemeImages() %>/custom/portlet/fileicon2.png" width="16" height="16" />
									</span>
										&nbsp;&nbsp;
									<span style="cursor:pointer" onclick="<portlet:namespace/>deleteAdvancedFile('')">
										<u>[delete]</u>
									</span>
								</div>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key="edison-content-execute-file"/></td>
					<td class="puptxt">
						<aui:input label="" value="${advancedContent.contentStartFileNm}" name="contentStartFileNm" id="contentStartFileNm" type="text" readonly="true" >
								<aui:validator name="custom" errorMessage="edison-advanced-content-start-executefile-empty" >
									function(val, fieldNode, ruleValue){
										var result = false;
										var userLimitChk  = "";
										if("${mode eq 'add' }"){ 
											userLimitChk = $("input[name=<portlet:namespace/>contentFile]").val();
										}else if("${mode eq 'update' }"){
											userLimitChk = "${advancedContent.contentFileNm}";
										}
										
										if(userLimitChk != ""){
											dot = userLimitChk.lastIndexOf(".");
				 							ext = userLimitChk.substring(dot).toLowerCase();
									 		if(ext != ".zip"){
												return true;
									 		}else if(ext == ".zip" && val != ""){
									 			return true;
									 		}else if(ext == ".zip" && val == ""){
									 			return false;
									 		}
										}										
									}
								</aui:validator>
						</aui:input>
						
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key="edison-content-main-image"/></td>
					<td class="puptxt">
					<c:choose>
						<c:when test="${mode eq 'add' }">
							<aui:input label="" name="addfile" cssClass="edison_file" type="file" value=""/>
						</c:when>
						<c:otherwise>
							<c:forEach items="${imgFileList}" var="fileMap">
								<div id="filediv">
									<span>
										${fileMap.fileTitle}
										<img src="<%=themeDisplay.getPathThemeImages() %>/custom/portlet/fileicon2.png" width="16" height="16" />
									</span>
										&nbsp;&nbsp;
									<span style="cursor:pointer" onclick="<portlet:namespace/>deleteSingleEdisonFile('${fileMap.fileEntryId}')">
										<u>[delete]</u>
									</span>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tr>
			</tbody>
		</table>
		</div>
		<div>
			<c:choose>
				<c:when test="${mode eq 'add' }">
					<div class="popupbtnGroup" style="height:55px;">
						<aui:input label="" value="<%=create%>" name="content_submit" id="content_submit" type="submit" cssClass="graybtn" />
<%-- 						<input name="content_submit" id="content_submit"type="button" value="<%=create%>" class="graybtn" onclick="<portlet:namespace/>addAdvancedContent();"/> --%>
					</div>
				</c:when>
				<c:otherwise>
				<div class="popupbtnGroup" style="height:55px;">
					<input name="content_delete" type="button" value="<liferay-ui:message key="edison-advanced-content-delete"/>" class="graybtn" onclick="<portlet:namespace/>deleteAdvancedContent();"/>
					<aui:input label="" value="<%=update%>" name="content_submit" type="submit" cssClass="graybtn" />
				</div>
				</c:otherwise>
			</c:choose>
			
		</div>
	</aui:form>
</div>


<div id="advanced-writer-dialog1" title="<liferay-ui:message key="edison-content"/>" class="popupWrap">
	
	
</div>

<script type="text/javascript">
AUI().ready(function() {
	$nowLang = $("#<portlet:namespace/>nowLanguage").val(); 
	
	$("input[name=<portlet:namespace/>select_languageId]").each(function() {
		$lang = $(this).val();
		if($lang == $nowLang){
			$(this).attr("checked", true);
		}
	});
	
	$("#advanced-writer-dialog-close-btn").click(function() {
		$("#advanced-writer-dialog").dialog("close");
	});
// 	var customAttrValue = $("#advanced-writer-dialog").dialog("option", "tabId");

	 var startFileNm =  $("input[name=<portlet:namespace/>contentStartFileNm]").val();
	 if(startFileNm != ""){
		 $("#<portlet:namespace/>contentStartFileNm").removeAttr("readonly");
	 }
	 
	 $("input[name=<portlet:namespace/>contentFile]").change(function() {
		 	startExecuteFileNm(this);
	 });
	 
});

function startExecuteFileNm(obj){
	 var fileNm = obj.value;
	 var fileExist = false;
	 if(fileNm != ''){
		 dot = fileNm.lastIndexOf(".");
		 ext = fileNm.substring(dot).toLowerCase();
	     if(ext == ".zip"){
	    	 fileExist = true;
	     }
	 }
	 
	 if(fileExist){
   	 	$("#<portlet:namespace/>contentStartFileNm").removeAttr("readonly");
	 }else{
		 $("#<portlet:namespace/>contentStartFileNm").val("")
		 $("#<portlet:namespace/>contentStartFileNm").attr("readonly", "true");
	 }
}
//콘텐츠 삭제
function <portlet:namespace/>deleteAdvancedContent(){
	if(!confirm(Liferay.Language.get("edison-content-delete-alert"))) return;
	$("#<portlet:namespace/>mode").val("<%=Constants.DELETE%>");
	$("#<portlet:namespace/>createAdvancedContentForm").submit();
}

function <portlet:namespace/>deleteSingleEdisonFile(p_fileEntryId){
	if(!confirm(Liferay.Language.get("edison-content-delete-file-alert"))) return;
	
	
		$fileDiv = $("#filediv");
		$fileDiv.empty();
		
		$("<div></div>").addClass("control-group")
		.append(
				$("<input/>").addClass("field edison_file")
							 .attr("id","<portlet:namespace/>addfile")
							 .attr("name","<portlet:namespace/>addfile")
							 .attr("type","file")
				)
		.appendTo($fileDiv);
		
		//hidden 삭제할 파일 추가
		$("#<portlet:namespace/>deleteFile").val(p_fileEntryId);
}


function <portlet:namespace/>deleteAdvancedFile(){
	if(!confirm(Liferay.Language.get("edison-content-delete-file-alert"))) return;
	
	$fileDiv = $("#advancedFilediv");
	$fileDiv.empty();
	
	$("<div></div>").addClass("control-group")
		.append(
				$("<input/>").addClass("field edison_file")
							 .attr("id","<portlet:namespace/>contentFile")
							 .attr("name","<portlet:namespace/>contentFile")
							 .attr("type","file")
				)
		.appendTo($fileDiv);
	
	//hidden 삭제할 파일 추가
	$("#<portlet:namespace/>deleteAdvancedFile").val("<%=Constants.DELETE%>");  
	
	//콘텐츠 파일 수정
	$("#<portlet:namespace/>contentFile").change(function() {
		startExecuteFileNm(this);
	})
}

//contentFile - Multiple ADD
$("#<portlet:namespace/>contentReferenceFile").attr("multiple","multiple");

</script>

<aui:script>
AUI().use('aui-base','liferay-form',function(A){
	var rules = {
		<portlet:namespace/>title: {
			required: true
		},
		<portlet:namespace/>resume: {
			required: true
		},
		<portlet:namespace/>contentFile: {
			required: true
		}, 
		<portlet:namespace/>addfile: {
			required: true,
			acceptFiles:'jpg,png,gif,jpeg'
		},
	};
	
	new A.FormValidator(
		{
			boundingBox: '#<portlet:namespace/>createAdvancedContentForm',
			rules: rules,
			showAllMessages:true,
			validateOnInput: true,
			extractRules: true,
			validateOnBlur: true,
			selectText: true,
		}
	);
});
</aui:script>