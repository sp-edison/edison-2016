<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%
	String groupNm = (String)request.getAttribute("groupNm");
	String groupId = (String)request.getAttribute("groupId");
	String mode = (String)request.getAttribute("mode");
	String contentSeq = (String)request.getAttribute("contentSeq");
	String contentDiv = (String)request.getAttribute("contentDiv");
	String codeOption = (String)request.getAttribute("codeOption");
	
	String selectDisable = "";
	if(mode.equals(Constants.UPDATE)){
		selectDisable = "disabled=\"disabled\"";
	}
	
	String create = LanguageUtil.format(locale, "edison-content-create", "");
	String update = LanguageUtil.format(locale, "edison-content-update", "");
	String fileAdd = LanguageUtil.format(locale, "edison-button-file-add", "");
%>
<style type="text/css">
	.aui .control-group{
		margin-bottom: 0px;
	}
	
	.aui select,
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
	
	.aui .tooltip {
		display: none; 
	}
</style>
<liferay-portlet:actionURL secure="<%= request.isSecure() %>" var="modifyGeneralContentUrl">
	<portlet:param name="myaction" value="generalModify" />
</liferay-portlet:actionURL>
<liferay-portlet:resourceURL var="deleteSingleEdisonFileURL" escapeXml="false" id="deleteSingleEdisonFile" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="contentUserInfoURL" id="contentUserInfo" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="updateContentOwnerURL" id="updateContentOwner" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="updateContentManagerURL" id="updateContentManager" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="deleteContentManagerURL" id="deleteContentManager" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="contentAuthCheckURL" escapeXml="false" id="contentAuthCheck" copyCurrentRenderParameters="false"/>
<div class="newWindow" style="background-color: #fff; overflow-x: hidden;overflow-y: hidden;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<c:choose>
				<c:when test="${mode eq 'add' }">
					<div class="newWtitle"><liferay-ui:message key="<%=groupNm%>"/> <liferay-ui:message key="edison-content-create"/></div>
				</c:when>
				<c:otherwise>
					<div class="newWtitle"><liferay-ui:message key="<%=groupNm%>"/> <liferay-ui:message key="edison-content-update"/></div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="newWclose">
			<img id="general-writer-dialog-close-btn" name="general-writer-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<aui:form action="<%= modifyGeneralContentUrl %>" method="post" name="createGeneralContentForm" enctype="multipart/form-data"  >
		<aui:input name="groupId" type="hidden" value="<%=groupId%>"/>
		<aui:input name="mode" type="hidden" value="<%=mode%>"/>
		<aui:input name="contentSeq" type="hidden" value="<%=contentSeq%>"/>
		
		<div class="newWcont01">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<colgroup>
				<col width="22%" />
				<col width="78%" />
			</colgroup>
			<tbody>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key="edison-content-service-language"/></td>
					<td colspan="3">&nbsp;&nbsp;
							<label style="display:inline;">
								<input type="checkbox" id="<portlet:namespace/>serviceLanguageAll" name="<portlet:namespace/>select_languageId" value="all">
							</label>
							<liferay-ui:message key="full" />
							<c:forEach var="lang" items="${ableLang }">
								<label style="display:inline;">
									<input type="checkbox" id="<portlet:namespace/>select_languageId" name="<portlet:namespace/>select_languageId" value="${lang }"/>
								<%--  <%if(CustomUtil.strNull(request.getAttribute("select_languageId")).equals(availLocales[i].toString())) out.print("checked"); %> --%>
									<img width="17px" height="12px" src="${contextPath}/images/toplink_${lang }.gif" />
									<liferay-ui:message key='edison-board-radiobutton-${lang }' />
								</label>
							</c:forEach>
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key="edison-content-type"/></td>
					<td class="puptxt">
						<select id="<portlet:namespace/>contentDiv" name="<portlet:namespace/>contentDiv" title="languageId" style="margin-bottom: 0px;" >
							<%=codeOption%>
						</select>
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key="edison-table-list-header-title"/></td>
					<td class="puptxt">
						<div class="control-group">
							<liferay-ui:input-localized name="title" xml="${generalContent.title}" type="textarea" rows="3" spellcheck="false" style="width: 95%; resize:none;margin-bottom:0px;">
							</liferay-ui:input-localized>
						</div>
					</td>
				</tr>
				<tr >
					<td class="puptitle"><liferay-ui:message key="edison-table-list-header-file"/></td>
					<td class="puptxt">
						<aui:input label="" name="file_add" value="<%=fileAdd%>" cssClass="button03" type="button" style="cursor:pointer;" onClick="moreFileTag();"/><br/>
						<c:if test="${mode eq 'update' }">
							<div id="fileListDiv" style="font-size: 12px;margin-top: 6px;">
								<c:forEach items="${fileList}" var="fileMap">
									<span style="cursor:pointer" onclick="<portlet:namespace/>fileDownload('${fileMap.fileEntryId }')" class="onMouseHover">
										${fileMap.fileTitle}
										<img src="<%=themeDisplay.getPathThemeImages() %>/custom/portlet/fileicon2.png" width="16" height="16" />
									</span>
										&nbsp;&nbsp;
									<span style="cursor:pointer" onclick="<portlet:namespace/>deleteSingleEdisonFile('${fileMap.fileEntryId}')">
										<u>[delete]</u>
									</span>
									<br>
								</c:forEach>
							</div>
						</c:if>
					</td>
				</tr>
				<tr class="puptrline">
					<td></td>
					<td id="fileTDArea">
						<c:if test="${mode eq 'add' }">
							<div id="fileDiv0">
								<input type="file" name="addfile" style ="width:500px;border:1px solid #CCCCCC;margin-bottom:2px;">
							</div>
						</c:if>
					</td>
				</tr>	
				<h1 class="40"></h1>
				
				<!-- Owner 및 Manager 지정 -->
				<c:if test="${mode eq 'update' && isOwner == true}">
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key="edison-virtuallab-owner"/></td>
						<td class="puptxt">
							<input id="<portlet:namespace/>nowOwnerName" name="<portlet:namespace/>nowOwnerName" type="text" value="${insertNm}" style="width: 120px;" readOnly/>
							<input id="<portlet:namespace/>newOwnerName" name="<portlet:namespace/>newOwnerName" type="text" maxlength="15" placeholder="<liferay-ui:message key='edison-table-list-header-userid' />" style="margin-bottom:0px;" onkeypress="if(event.keyCode==13) {<portlet:namespace/>getUserInfo('owner'); return false;}" />
							<input id="search_button"  name="<portlet:namespace />search_button" type="button" class="button01b" value="<liferay-ui:message key='edison-content-owner-transfer' />" onClick="<portlet:namespace/>getUserInfo('owner')"/>
						</td>
					</tr>	
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key="edison-content-manager"/></td>
						<td class="puptxt">
							<%-- <div class="searchbox03">
								<input id="<portlet:namespace/>now_MgrUserScreenName" name="<portlet:namespace/>now_MgrUserScreenName" type="hidden"/>
								<input type="button" class="btnsearch" value="" onclick="<portlet:namespace/>getUserInfo('manager');">
							</div> --%>
							
							<c:forEach var="manager" items="${contenManagerList }">
								<input id="<portlet:namespace/>nowMgrId" name="<portlet:namespace/>nowMgrId" type="hidden" value="${manager.userId}" style="width: 120px;" readonly/>
								<input id="<portlet:namespace/>nowMgrName" name="<portlet:namespace/>nowMgrName" type="text" value="${manager.userScreenName}" style="width: 120px;" readonly />
							</c:forEach>
							<input id="<portlet:namespace/>newMgrName" name="<portlet:namespace/>newMgrName" type="text" maxlength="15" placeholder="<liferay-ui:message key='edison-table-list-header-userid' />" style="margin-bottom:0px;" onkeypress="if(event.keyCode==13) {<portlet:namespace/>getUserInfo('manager'); return false;}"/>
							<input id="search_button"  name="<portlet:namespace />search_button" type="button" class="button01b" value="<liferay-ui:message key='edison-content-manager-transfer' />" onClick="<portlet:namespace/>getUserInfo('manager')"/>
							
							<c:if test="${contenManagerList!=null && fn:length(contenManagerList) > 0 }">
								<input id="search_button"  name="<portlet:namespace />search_button" type="button" class="button01b" value="<liferay-ui:message key='edison-button-board-delete' />" onClick="<portlet:namespace/>deleteContentMgr()"/>
							</c:if>
						</td>
					</tr>	
				</c:if>
			</tbody>
		</table>
		</div>
		<div>
			<c:choose>
				<c:when test="${mode eq 'add' }">
					<div class="popupbtnGroup" style="height:40px;">
<%-- 						<aui:input label="" value="<%=create%>" name="content_submit" id="content_submit" type="submit" cssClass="graybtn" /> --%>
						<input name="content_add" type="button" value="<%=create%>" class="graybtn" onclick="<portlet:namespace/>addGeneralContent();"/>
					</div>
				</c:when>
				<c:otherwise>
					<div class="popupbtnGroup" style="height:40px;">
						<c:if test="${isOwner == true }"> 
							<input name="content_delete" type="button" value="<liferay-ui:message key="edison-content-delete"/>" class="graybtn" onclick="<portlet:namespace/>deleteGeneralContent();"/>
						</c:if>
						<aui:input label="" value="<%=update%>" name="content_submit" id="content_submit" type="submit" cssClass="graybtn"/>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</aui:form>

		
		<div id="<portlet:namespace/>content-owner-add-dialog" title="<liferay-ui:message key='edison-appstore-solver-owner-change' />" class="newWindow" style="display:none; background-color:white; padding:0px;">
			<div class="newWheader">
				<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
					<div class="newWtitle"><liferay-ui:message key="edison-appstore-solver-owner-change"/></div>
				</div>
				<div class="newWclose" style="cursor: pointer;">
					<img id="content-owner-add-dialog-close-btn" name="content-owner-add-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="25" height="25" style="cursor:pointer; float: right;"/>
				</div>
			</div>
			<div style="padding: 30px;" class="newWcont01">
				<form id="ownerUpdateForm" name="ownerUpdateForm" method="post" action="<%=updateContentOwnerURL%>" > 
					<div class="table1_list" style="width:85%; padding:15px; margin:0 auto;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<colgroup>
								<col width="30%" />
								<col width="70%" />
							</colgroup>
							<tbody>
								<tr>
									<td><liferay-ui:message key='edison-table-list-header-userid' /></td>
									<td id="ownerId"></td>
								</tr>
								<tr>
									<td><liferay-ui:message key='edison-table-list-header-usernm' /></td>
									<td id="ownerFullName"></td>
								</tr>
								<tr>
									<td><liferay-ui:message key='edison-table-list-header-email' /></td>
									<td id="ownerEmail"></td>
								</tr>
								<tr id="projectNotConfirm"> 
									<td colspan="2"  style="text-align: center; color:#f03030;">
										<liferay-ui:message key='edison-content-project-affiliation-yn-user-get-info-alert' />
										<br/>
										<liferay-ui:message key='edison-content-owner-register-confirm' />
									</td>
								</tr>
								<tr  id="projectConfirm">
									<td colspan="2"  style="text-align: center; color:#f03030;">
										<liferay-ui:message key='edison-content-owner-register-confirm' />
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<input id="<portlet:namespace/>ownerUserId" name="<portlet:namespace/>ownerUserId" type="hidden">
					<input id="<portlet:namespace/>ownerUserName" name="<portlet:namespace/>ownerUserName" type="hidden">
					<input id="<portlet:namespace/>pastOnwerId" name="<portlet:namespace/>pastOnwerId" type="hidden">
					<div style="text-align:center;">
						<input id="register_request_button" name="<portlet:namespace />register_request_button" class="yellowbtn" type="button" value="<liferay-ui:message key='edison-button-register' />" onclick="<portlet:namespace/>updateContentOwner()"/>
					</div>
				</form>
			</div>
		</div>
		
		

	 <div id="<portlet:namespace/>content-manager-add-dialog" title="<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-manager-register' />" class="newWindow" style="display:none; background-color:white; padding:0px;">
			<div class="newWheader">
				<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
					<div class="newWtitle"><liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-manager-register' /></div>
				</div>
				<div class="newWclose" style="cursor: pointer;">
					<img id="content-manager-add-dialog-close-btn" name="content-manager-add-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="25" height="25" style="cursor:pointer; float: right;"/>
				</div>
			</div>
			<div style="padding: 30px;" class="newWcont01">
				<form id="managerUpdateForm" name="managerUpdateForm" method="post" action="<%= updateContentManagerURL %>" > 
					<div class="table1_list" style="width:85%; padding:15px; margin:0 auto;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<colgroup>
								<col width="30%" />
								<col width="70%" />
							</colgroup>
							<tbody>
								<tr>
									<td><liferay-ui:message key='edison-table-list-header-userid' /></td>
									<td id="managerId"></td>
								</tr>
								<tr>
									<td><liferay-ui:message key='edison-table-list-header-usernm' /></td>
									<td id="managerFullName"></td>
								</tr>
								<tr>
									<td><liferay-ui:message key='edison-table-list-header-email' /></td>
									<td id="managerEmail"></td>
								</tr>
								<tr>
									<td colspan="2"  style="text-align: center; color:#f03030;"><liferay-ui:message key='edison-content-manager-register-confirm' /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<input id="<portlet:namespace/>managerUserId" name="<portlet:namespace/>managerUserId" type="hidden" >
					<input id="<portlet:namespace/>pastManagerId" name="<portlet:namespace/>pastManagerId" type="hidden" >
					<div style="text-align:center;">
						<input id="register_request_button" name="<portlet:namespace />register_request_button" class="yellowbtn" type="button" value="<liferay-ui:message key='edison-button-register' />" onclick="<portlet:namespace/>updateContentManager()"/>
					</div>
				</form>
			</div>
		</div> 
</div>
<script type="text/javascript">
AUI().ready(function() {
	$("#general-writer-dialog-close-btn").click(function() {
		<portlet:namespace/>generalContentSearch("");
		$("#general-writer-dialog").dialog("close");
	});
	
	//서비스언어 체크박스 설정
	serviceLanguageCheckBox();
	
	//오너,매니저 다이얼로그 초기화
	$("#<portlet:namespace/>content-manager-add-dialog").dialog({
		autoOpen: false,
	    width: 450,
	    height: 'auto',
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
        open: function(event, ui) {
	    	$(this).css('overflow', 'hidden');
	    	$(this).css("padding", "0px");
	    	$(this).css("width", "450px");
	    	$(this).parent().removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget");
	    	$(this).removeClass("ui-widget-content");
	    	$(this).removeClass("ui-dialog-content");
	    },
	    close: function() {

	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	$("#content-manager-add-dialog-close-btn").click(function() {
		$("#<portlet:namespace/>content-manager-add-dialog").dialog("close");
	});
	
	$("#<portlet:namespace/>content-owner-add-dialog").dialog({
		autoOpen: false,
	    width: 450,
	    height: 'auto',
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
        open: function(event, ui) {
	    	$(this).css('overflow', 'hidden');
	    	$(this).css("padding", "0px");
	    	$(this).css("width", "450px");
	    	$(this).parent().removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget");
	    	$(this).removeClass("ui-widget-content");
	    	$(this).removeClass("ui-dialog-content");
	    },
	    close: function() {

	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	$("#content-owner-add-dialog-close-btn").click(function() {
		$("#<portlet:namespace/>content-owner-add-dialog").dialog("close");
	});
	
	//projectYn update check init
	if("<%=mode%>" == "update"){
		$projectYnValue = "${generalContent.projectYn}";
		$("input[name=<portlet:namespace/>projectYn]").each(function() {
			$ynValue = $(this).val();
			if($ynValue == $projectYnValue){
				$(this).attr("checked", true);
			}
		});
	}
	
	if("<%=isProjectThan%>" == "true"){
		$("#<portlet:namespace/>projectYnTr").show();
	}else{
		$("#<portlet:namespace/>projectYnTr").hide();
	}
});


function serviceLanguageCheckBox(){
		

	/*서비스 언어 선택*/
	<%if(mode.equals("update")){%>
		$service = "${generalContent.serviceLanguage}";
		if($service != ""){
			$checkedVal = $service.split(",");
			
			if($checked =! ""){
				$("input[name=<portlet:namespace/>select_languageId]").each(function() {

					$box = $(this).val();
					for(var i=0; i< $checkedVal.length; i++){
						if($box == $checkedVal[i]){
							$(this).attr("checked", true);
						}
					}
				});
			}
		}
	<%}%>
	
	/*서비스 언어 전체선택/해제 */	
    $("#<portlet:namespace/>serviceLanguageAll").click(function(){
        if($("#<portlet:namespace/>serviceLanguageAll").prop("checked")){
            $("input[id=<portlet:namespace/>select_languageId]").prop("checked",true);
        }else{
            $("input[id=<portlet:namespace/>select_languageId]").prop("checked",false);
        }
    });
	
	var ableLangLength = '<c:out value="${fn:length(ableLang)}"/>'; //available Language Length
    $("input[id=<portlet:namespace/>select_languageId]").click(function(){
    	var checkLength = $("input[id=<portlet:namespace/>select_languageId]:checked").length;
    	
    	if(ableLangLength == checkLength){
    		$("#<portlet:namespace/>serviceLanguageAll").prop("checked",true);
    	}else{
    		$("#<portlet:namespace/>serviceLanguageAll").prop("checked",false);
    	}
    });
	
}


function <portlet:namespace/>deleteSingleEdisonFile(p_fileEntryId){
	if(!confirm(Liferay.Language.get("edison-content-delete-file-alert"))) return;
	var deleteForm = {
			"<portlet:namespace/>fileEntryId" : p_fileEntryId,
			"<portlet:namespace/>groupId" : $('#<portlet:namespace/>groupId').val(),
			"<portlet:namespace/>contentSeq" : $('#<portlet:namespace/>contentSeq').val(),
			"<portlet:namespace/>contentDiv" : $('#<portlet:namespace/>contentDiv').val()
			};
	jQuery.ajax({
		type: "POST",
		url: "<%=deleteSingleEdisonFileURL%>",
		data: deleteForm,
  		async : false,
		success: function(data) {
			var fileList = data.fileList;
			var resultMsg = data.resultMsg;
			
			if(resultMsg=="SUCCESS"){
				$fileListDiv = $("#fileListDiv");
				$fileListDiv.empty();
				if(fileList.length == 0){				
				}else{
					for(var i = 0 ; i < fileList.length; i++ ){
						$("<span></span>").css("cursor","pointer")
										  .attr("onclick","<portlet:namespace/>fileDownload('"+fileList[i].fileEntryId+"');")
										  .addClass("onMouseHover")
										  .html(fileList[i].fileTitle+"&nbsp;&nbsp;")
										  .append(
												  $("<img/>").attr("src","<%=themeDisplay.getPathThemeImages() %>/custom/portlet/fileicon2.png")
												  			 .attr("width","16")
												  			 .attr("height","16")
												 )
										  .append()
										  .appendTo($fileListDiv);
						
						$("<span></span>").css("cursor","pointer")
										  .html("&nbsp;&nbsp;")
										  .attr("onclick","<portlet:namespace/>deleteSingleEdisonFile('"+fileList[i].fileEntryId+"');")
										  .append(
												  $("<u></u>").html("[delete]<br/>")
												  )
										  .appendTo($fileListDiv);
					}
				}
			}else if(resultMsg=="DELETE_FAIL"){
				alert("delete file error!");	
			}
		},error:function(data,e){ 
			alert("deleteSingleEdisonFile System error!");	
		},complete:function(){
		}
	});
}

function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}


var fileIndex = 1;
//파일등록
function moreFileTag(){
	//if($(':input[name*=addfile]').length<2){
		fileIndex++;
		var frmTag = "<div id=\"fileDiv"+fileIndex+"\">";
		frmTag += "<input type=\"file\" name=\"addfile\" style =\"width:500px;border:1px solid #CCCCCC;margin-bottom:2px;\">&nbsp;";
		frmTag += "<input type=\"button\" value=\"delete\" style=\"cursor:pointer;\" class=\"button03\" onClick=\"deleteFileTag(\'fileDiv"+fileIndex+"\')\"/>";
		frmTag += "</div>";
		
		$("#fileTDArea").append(frmTag);
}

//삭제
function deleteFileTag(objId){	
	$("#"+objId).remove();
	if($(':input[name*=addfile]').length == 0){
		moreFileTag();
	} 
}

function <portlet:namespace/>addGeneralContent(){
	$prefix = "<portlet:namespace/>title";
	var input = "input[id=<portlet:namespace/>select_languageId]";
	var checkLength = $("input[id=<portlet:namespace/>select_languageId]:checked").length;
	
	if(checkLength > 0){
		input = "input[id=<portlet:namespace/>select_languageId]:checked";
	}
	
	if("<%=isProjectThan%>" == true){
		if($("input[name=<portlet:namespace/>projectYn]:checked").length == 0){
			alert(Liferay.Language.get('edison-content-project-affiliation-yn-alert'));
			return false;
		}
	}
	
	var bool = false;
	$(input).each(function() {
		$id = $prefix + "_" + $(this).val();
		$inputValue = $("input[name="+$id+"]").val();

		//console.log($id +" ----> " + $inputValue);
		if($inputValue == "" || $inputValue == undefined){
			alert(Liferay.Language.get('edison-content-another-language-title-alret'));
			bool = false;
			return false;
		}else{
			bool = true;
		}
		
	});
	
	if(bool){
		$("#<portlet:namespace/>createGeneralContentForm").submit();
	}
}
//콘텐츠 삭제
function <portlet:namespace/>deleteGeneralContent(){
	if(!confirm(Liferay.Language.get("edison-content-delete-alert"))) return;
	$("#<portlet:namespace/>mode").val("<%=Constants.DELETE%>");
	$("#<portlet:namespace/>createGeneralContentForm").submit();
}


/*콘텐츠 관리자*/
function <portlet:namespace/>getUserInfo(role) {
	var contentSeq = $('#<portlet:namespace/>contentSeq').val();
	var groupId =  $('#<portlet:namespace/>groupId').val();
	if(role == 'owner'){
		var pre = $("#<portlet:namespace/>nowOwnerName").val();
		var post = $("#<portlet:namespace/>newOwnerName").val();
		if( pre == post ){
			alert(Liferay.Language.get('edison-appstore-fail-owner'));
			
			return false;
		} 
		//현재아이디와 입력아이디가 같은경우 제외
		var data = {
				<portlet:namespace/>type : "owner",
				<portlet:namespace/>contentSeq : contentSeq,
				<portlet:namespace/>groupId : groupId,
				<portlet:namespace/>nowOwnerName : pre,
				<portlet:namespace/>newOwnerName : post
		}
		
		jQuery.ajax({
			type: "POST",
			url: "<%=contentUserInfoURL%>",
			async : false,
			data :  data,
			success: function(msg) {
				var result = msg.result;
				var contentUserInfo = msg.contentUserInfo;
				console.log(msg)
				if(result === undefined) {
					alert("user not found");
				} else if(result == "none") {
					alert(Liferay.Language.get('edison-virtuallab-virtualLabClassManagement-user-notfound'));
				} else if(result == "not siteMember"){
					alert(Liferay.Language.get('edison-default-site-no-user'));
				} 
//					else if(result == "notdeveloper") {
//						alert("<liferay-ui:message key='edison-appstore-workspace-permission-alert' />");
//					}
				else{
					$("#ownerId").text(contentUserInfo.userScreenName);
					$("#ownerFullName").text(contentUserInfo.userFullName);
					$("#ownerEmail").text(contentUserInfo.userEmailAddress);
					$("#<portlet:namespace/>ownerUserId").val(contentUserInfo.userId);
					$("#<portlet:namespace/>ownerUserName").val(contentUserInfo.userScreenName);
					$("#<portlet:namespace/>pastOnwerId").val(contentUserInfo.pastOnwerId);
					
					console.log(msg.projectUser)
					if(msg.projectUser == false){
						$("#projectConfirm").hide();
						$("#projectNotConfirm").show();
					}else{
						$("#projectConfirm").show();
						$("#projectNotConfirm").hide();
					}
					
					$("#<portlet:namespace/>content-owner-add-dialog").dialog("open");
				}
			},error:function(msg,e){ 
				alert(e);
				return false;
			}
		}); 
	}else if(role == 'manager'){
		var pre = $("#<portlet:namespace/>nowMgrName").val();
		var post = $("#<portlet:namespace/>newMgrName").val();
		if( pre == post ){
			alert(Liferay.Language.get('edison-appstore-fail-owner'));
			return false;
		} 
		var data = {
			<portlet:namespace/>type : "manager",
			<portlet:namespace/>contentSeq : contentSeq,
			<portlet:namespace/>groupId : groupId,
			<portlet:namespace/>nowMgrName : pre,
			<portlet:namespace/>newMgrName : post
		}
		jQuery.ajax({
			type: "POST",
			url: "<%=contentUserInfoURL%>",
			async : false,
// 			data : $("#userSearchManagerForm").serialize(),
			data : data,
			success: function(msg) {
				var result = msg.result;
				var contentUserInfo = msg.contentUserInfo;
				
				if(result === undefined) {
					alert("user not found");
				} else if(result == "admin") {
					alert(Liferay.Language.get('edison-virtuallab-virtualLabClassManagement-admin-alert'));
				} else if(result == "owner" || result == "manager") {
					alert(Liferay.Language.get('edison-virtuallab-virtualLabClassManagement-admin-already'));
				} else if(result == "none") {
					alert(Liferay.Language.get('edison-virtuallab-virtualLabClassManagement-user-notfound'));
				} else if(result == "user") {
					$("#managerId").text(contentUserInfo.userScreenName);
					$("#managerFullName").text(privateTextConverter2(contentUserInfo.userFullName));
					$("#managerEmail").text(privateEmailConverter2(contentUserInfo.userEmailAddress));
					$("#<portlet:namespace/>managerUserId").val(contentUserInfo.userId);
					$("#<portlet:namespace/>pastManagerId").val(contentUserInfo.pastMgrId);
					$("#<portlet:namespace/>content-manager-add-dialog").dialog("open");
				}else if(result == "not siteMember"){
					alert(Liferay.Language.get('edison-default-site-no-user'));
				} 
			},error:function(msg,e){ 
				alert(e);
				return false;
			}
		});
}
}
function <portlet:namespace/>updateContentManager(){
	var groupId = $('#<portlet:namespace/>groupId').val();
	var seq = $('#<portlet:namespace/>contentSeq').val();
	var pre = $('#<portlet:namespace/>pastManagerId').val();
	var post = $('#<portlet:namespace/>managerUserId').val();
	
	var data = {
			<portlet:namespace/>groupId : groupId,
			<portlet:namespace/>contentSeq : seq,
			<portlet:namespace/>pastManagerId : pre,
			<portlet:namespace/>managerUserId : post,
		}
	
	jQuery.ajax({
		type: "POST",
		url: "<%=updateContentManagerURL%>",
		async : false,
		data : data,
		success: function(msg) {
			location.reload();
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
	$("#<portlet:namespace/>newMgrName").val("");
	$("#<portlet:namespace/>content-manager-add-dialog").dialog("close");
} 

function <portlet:namespace/>updateContentOwner(){
	var groupId = $('#<portlet:namespace/>groupId').val();
	var seq = $('#<portlet:namespace/>contentSeq').val();
	var pre = $('#<portlet:namespace/>pastOnwerId').val();
	var post = $('#<portlet:namespace/>ownerUserId').val();
	var postNm = $('#<portlet:namespace/>ownerUserName').val();
	
	var projectYn = "";
	if($("input[name=<portlet:namespace/>projectYn]:checked").length > 0){
		projectYn = $("input[name=<portlet:namespace/>projectYn]:checked").val();
	}
	
	var data = {
		<portlet:namespace/>groupId : groupId,
		<portlet:namespace/>contentSeq : seq,
		<portlet:namespace/>pastOnwerId : pre,
		<portlet:namespace/>ownerUserId : post,
		<portlet:namespace/>ownerUserName : postNm,
		<portlet:namespace/>projectYn : projectYn
	}
	jQuery.ajax({
		type: "POST",
		url: "<%=updateContentOwnerURL%>",
		async : false,
		data : data,
		success: function(data) {
			location.reload();
			//$("#<portlet:namespace/>nowOwnerName").val(data.newOwnerScreenName);
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
	$("#<portlet:namespace/>newOwnerName").val("");
	$("#<portlet:namespace/>content-owner-add-dialog").dialog("close");
}

function <portlet:namespace/>deleteContentMgr(){ //manager삭제
	if(!confirm(Liferay.Language.get('edison-content-manager-delete-confirm'))) return;
	
	//groupId, ContentSeq, managerUserId
	var groupId = $('#<portlet:namespace/>groupId').val();
	var seq = $('#<portlet:namespace/>contentSeq').val();
	var manager = $('#<portlet:namespace/>nowMgrId').val();
	var data = {
		<portlet:namespace/>groupId : groupId,
		<portlet:namespace/>contentSeq : seq,
		<portlet:namespace/>managerUserId : manager,
	}
	jQuery.ajax({
		type: "POST",
		url: "<%=deleteContentManagerURL%>",
		async : false,
		data : data,
		success: function(data) {
			location.reload();
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}
</script>

<aui:script>
	AUI().use('aui-base','liferay-form',function(A){
		var rules = {
			/* <portlet:namespace/>title: {
				required: true
			} */
		};
		new A.FormValidator(
			{
				boundingBox: '#<portlet:namespace/>createGeneralContentForm',
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
