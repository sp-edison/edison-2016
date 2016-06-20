<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:renderURL var="boardListURL" portletMode='view' >
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="boardListMaxURL" portletMode='view' windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:renderURL>

<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:resourceURL>
<liferay-portlet:renderURL var="getBoardMaxRenderUrl" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
	<liferay-portlet:param name="boardSeq" value="${boardMap.boardSeq}" />
	<liferay-portlet:param name="myRender" value="getBoardRender"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="getBoardRenderUrl" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myRender" value="getBoardRender"/>
	<liferay-portlet:param name="boardSeq" value="${boardMap.boardSeq}" />
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="deleteBoardActionUrl" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myAction" value="deleteBoardAction"/>
	<liferay-portlet:param name="boardSeq" value="${boardMap.boardSeq}" />
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:actionURL>

<liferay-portlet:resourceURL var="deleteSingleEdisonFileURL" escapeXml="false" id="deleteSingleEdisonFile" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="boardSeq" value="${boardMap.boardSeq}" />
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:resourceURL>

<liferay-portlet:actionURL copyCurrentRenderParameters="false" var="addReplyBoardActionUrl">
	<liferay-portlet:param name="myAction" value="addReplyBoardAction"/>
	<liferay-portlet:param name="boardSeq" value="${boardMap.boardSeq}" />
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL copyCurrentRenderParameters="false" var="updateReplyBoardActionUrl">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
	<liferay-portlet:param name="boardSeq" value="${boardMap.boardSeq}" />
	<liferay-portlet:param name="myAction" value="updateReplyBoardAction"/>
</liferay-portlet:actionURL>

<liferay-portlet:actionURL copyCurrentRenderParameters="false" var="deleteReplyBoardActionUrl">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
	<liferay-portlet:param name="boardSeq" value="${boardMap.boardSeq}" />
	<liferay-portlet:param name="myAction" value="deleteReplyBoardAction"/>
</liferay-portlet:actionURL>

<%
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	String classId = CustomUtil.strNull(httpRequest.getParameter("classId"), "0");
	String solverId = CustomUtil.strNull(httpRequest.getParameter("solverId"), "0");
	boolean isCustomAdmin = GetterUtil.get(request.getAttribute("isCustomAdmin"), false);
%>

<c:choose>
	<c:when test="${replyBoardSeq == null || replyBoardSeq == ''}">
		<c:set var="actionUrl" value="<%=addReplyBoardActionUrl%>"/>
	</c:when>
	<c:otherwise>
		<c:set var="actionUrl" value="<%=updateReplyBoardActionUrl%>"/>	
	</c:otherwise>
</c:choose>

<%
	Map boardMap = (Map)request.getAttribute("boardMap");
%>
<script type="text/javascript" src="${contextPath}/editor/js/HuskyEZCreator.js" charset="utf-8"></script>

<h1>${boardDivTitle}</h1>

<form name="<portlet:namespace/>viewForm" action="<%=getBoardRenderUrl%>" method="post" style="margin:0px;">
	<input type="hidden" id="<portlet:namespace/>groupBoardSeq" name="<portlet:namespace/>groupBoardSeq" value="${boardMap.boardSeq}">
	<input type="hidden" id="<portlet:namespace/>RENDER_SORT" name="<portlet:namespace/>RENDER_SORT" value="VIEW">
	<input type="hidden" id="<portlet:namespace/>replyBoardSeq" name="<portlet:namespace/>replyBoardSeq" value="">
	<input type="hidden" id="<portlet:namespace/>currentPage" name="<portlet:namespace/>currentPage" value="${currentPage }">
	<input type="hidden" id="<portlet:namespace/>searchValue" name="<portlet:namespace/>searchValue" value="${searchValue }">
	<input type="hidden" id="<portlet:namespace/>select_languageId" name="<portlet:namespace/>select_languageId" value="<%= themeDisplay.getLanguageId()%>">
	<input type="hidden" id="<portlet:namespace/>solverId" name="<portlet:namespace/>solverId" value="${solverId}">
	<input type="hidden" id="<portlet:namespace/>classId" name="<portlet:namespace/>classId" value="${classId }">	
</form>

<div class="table1_list">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" >
	<tr class="tablebgtr01">
		<c:choose>
			<c:when test="${boardDiv.divNm=='FAQ' || boardDiv.divNm=='QNA'}">
				<td width="51%" class="title"><liferay-ui:message key='edison-appstore-myapp-question' /> : ${boardMap.title} </td>
			</c:when>
			<c:otherwise>
				<td width="51%" class="title"><liferay-ui:message key='edison-table-list-header-title' /> : ${boardMap.title} </td>
			</c:otherwise>
		</c:choose>
		
		<td width="49%" class="bold TR">${boardMap.writerName} ｜ ${boardMap.writerDate} </td>
	</tr>
	<tbody>
	<tr style="height: 230px;">
		<td colspan="2" style="vertical-align: top;">
			${ boardMap.content }
		</td>
	</tr>
	
	<c:choose>
		<c:when test="${boardDiv.fileUpLoadUseYn == true}">
			<c:if test="${fn:length(fileList) > 0}">
			<tr>
				<td colspan="2">
					<img src="${contextPath}/images/fileicon.png" width="19" height="21" />&nbsp;<liferay-ui:message key='edison-table-content-header-attachments' />&nbsp;&nbsp;｜&nbsp;&nbsp;
					<c:forEach items="${fileList}" var="fileMap">
						<span style="cursor:pointer; margin-right:5px;" onclick="<portlet:namespace/>fileDownload('${fileMap.fileEntryId }')" class="onMouseHover">
							<img src="${contextPath}/images/fileicon2.png" width="16" height="16" />
							${fileMap.fileTitle }
						</span>
					</c:forEach>
				</td>
			</tr>	
			</c:if>
		</c:when>
	</c:choose>
	</tbody>
	</table>
</div>  
<br>
<div class="boardbtnbox" style="text-align: right; width: 99%;"> 
<%	
	if(themeDisplay.isSignedIn()) {
		if(themeDisplay.getUserId() == Long.parseLong(CustomUtil.strNull(boardMap.get("writerId"), "0")) || isAdministrator || isSiteAdministrator || isCustomAdmin){
%>	
	<c:choose>	
		<c:when test="${isPortal == false && boardMap.groupId ne boardGroupId}"></c:when>
		<c:otherwise>
			<input type="button" class="button02" style="margin-right:5px;" onClick="javascript:<portlet:namespace/>deleteBoard(); return false;" value="<liferay-ui:message key='edison-button-board-delete' />" />
			<input type="button" class="button02" style="margin-right:5px;" onClick="javascript:<portlet:namespace/>modify(); return false;" value="<liferay-ui:message key='edison-button-board-modify' />" />
		</c:otherwise>
	</c:choose>
<%
		}
	}
%>
<%
	if(!classId.equals("0")) {
%>
		<input type="button" class="button02" onClick="location.href='<%=boardListMaxURL%>&<portlet:namespace/>maxList=Y&<portlet:namespace/>currentPage=${currentPage }&<portlet:namespace/>searchValue=${searchValue}&classId=${classId }'; return false;" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-list' />" />
<%
	} else if(!solverId.equals("0")){
%>
		<input type="button" class="button02" onClick="location.href='<%=boardListURL%>&<portlet:namespace/>maxList=Y&<portlet:namespace/>currentPage=${currentPage }&<portlet:namespace/>searchValue=${searchValue}&solverId=${solverId }&back=Y'; return false;" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-list' />" />
<%
	} else {
%>
		<input type="button" class="button02" onClick="location.href='<%=boardListURL%>&<portlet:namespace/>currentPage=${currentPage }&<portlet:namespace/>searchValue=${searchValue}'; return false;" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-list' />" />
<%		
	}
%>
</div>


<c:if test="${boardDiv.replyYn==true}">
	<div class="h4">
		<liferay-ui:message key='edison-button-board-reply' />
	<%
		if(isLogin){
	%>
		<c:if test="${replyBoardSeq == null || replyBoardSeq == ''}">			
		<div id="replyInputButton" style="float: right;">
			<input type="button" onclick="replyInputFormSlideDown();" value="<liferay-ui:message key='edison-button-board-write' />" class="button04">
		</div>
		</c:if>
	<%
		}
	%>
	</div>
</c:if>

	<c:if test="${boardDiv.replyYn==true}">
		<form name="<portlet:namespace/>replyForm" method="post"  action="${actionUrl }" onsubmit="return boardInputFormCheck<portlet:namespace/>()" enctype="multipart/form-data">
			<input type="hidden" name="<portlet:namespace/>groupBoardSeq" value="${boardMap.boardSeq}">
			<input type="hidden" name="<portlet:namespace/>RENDER_SORT" value="REPLY">
			<input type="hidden" id="<portlet:namespace/>currentPage" name="<portlet:namespace/>currentPage" value="${currentPage }">
			<input type="hidden" id="<portlet:namespace/>replyBoardSeq" name="<portlet:namespace/>replyBoardSeq" value="${replyBoardSeq }">
			<input type="hidden" id="solverId" name="<portlet:namespace />solverId" value="${solverId }">
			<input type="hidden" id="classId" name="<portlet:namespace />classId" value="${classId }">
			<div class="table1_list">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" >
					<colgroup id="boardColgroup">
						<col width="7%" />
						<col width="20%" />
						<col width="8%" />
						<col/>
					</colgroup>

<%
				ArrayList	replyList	= (ArrayList) request.getAttribute("replyList");
				Map map = null;
				List replyFileList = null;
				Map replyFileMap = null;
				
				if(isLogin && (replyList == null || replyList.size()==0 || CustomUtil.strNull(request.getAttribute("replyBoardSeq")).equals(""))){
%>

						<tr>
							<td colspan="4" id="replyInputTd" style="border-bottom: 0px solid rgb(204, 204, 204);padding:0px;">
								<div id="replyInputForm" style="border-bottom: 1px solid rgb(204, 204, 204);padding:10px;">
									<textarea id="<portlet:namespace/>content" name="<portlet:namespace/>content" style="width:95%;height:200px;"></textarea>
									<c:choose>
										<c:when test="${boardDiv.fileUpLoadUseYn == true}">
											<div>
												<div style="float: left;"><input type="button" value="<liferay-ui:message key='edison-button-file-add' />" class="button06" onClick="moreFileTag()" style="cursor:pointer;"/>&nbsp;&nbsp;</div>
												<div id="fileTDArea" style="float: left;"/>	
											</div>
										</c:when>
									</c:choose>
									<div class="boardbtnbox">
										<div class="boardbtn1 boardbtnboxtoppd">
											<input type="button" name="<portlet:namespace />fullsize" id="fullsize" onclick="submitForm<portlet:namespace/>();" value="<liferay-ui:message key='edison-virtuallab-save' />" class="button04">
											<input type="button" name="<portlet:namespace />fullsize" id="fullsize" onclick="replyInputFormSlideUp();" value="<liferay-ui:message key='cancel' />" class="button04">											
										</div>
									</div>
								</div>	
							</td>
						</tr>
<%
					}					
					
					if(replyList != null || replyList.size()>0){
						for(int i=0;i<replyList.size();i++){
							map = (Map)replyList.get(i);
							
							if(
								(themeDisplay.getUserId() == Long.parseLong(CustomUtil.strNull(map.get("writerId"))) || isAdministrator || isSiteAdministrator || isCustomAdmin)
								&& CustomUtil.strNull(request.getAttribute("replyBoardSeq")).equals(CustomUtil.strNull(map.get("boardSeq")))
								){
%>	
								<tr>
									<td colspan="4">
										<textarea id="<portlet:namespace/>content" name="<portlet:namespace/>content" style="width:95%;height:200px;"><%=CustomUtil.strNull(map.get("content")) %></textarea>
<%
										replyFileList = (List)map.get("fileList");
										if(replyFileList != null && replyFileList.size() > 0){
%>
											<div id="fileListDiv">
<%
												for(int r=0;r<replyFileList.size();r++){
													replyFileMap = (Map)replyFileList.get(r);
%>
													<span style="cursor:pointer" onclick="<portlet:namespace/>fileDownload('<%=CustomUtil.strNull(replyFileMap.get("fileEntryId"))%>')" class="onMouseHover">
														<%=CustomUtil.strNull(replyFileMap.get("fileTitle"))%>
														<img src="<%=themeDisplay.getPathThemeImages() %>/custom/portlet/fileicon2.png" width="16" height="16" />
													</span>
													<span style="cursor:pointer" onclick="deleteSingleEdisonFile('<%=CustomUtil.strNull(replyFileMap.get("fileEntryId"))%>', '<%=CustomUtil.strNull(replyFileMap.get("fileUserId"))%>', '<%=CustomUtil.strNull(map.get("boardSeq"))%>')">
														<u>[delete]</u>
													</span>
													<br>	
<%
												}
%>											
											</div>
<%
										}//if(replyFileList != null && replyFileList.size() > 0){										
%>
										<div>
											<div style="float: left;"><input type="button" value="<liferay-ui:message key='edison-button-file-add' />" class="button02" onClick="moreFileTag()" style="cursor:pointer;"/>&nbsp;&nbsp;</div>
											<div id="fileTDArea" style="float: left;"/>	
										</div>
										<div class="boardbtnbox">
											<div class="boardbtn1 boardbtnboxtoppd">
												<input type="button" name="<portlet:namespace />fullsize" id="fullsize" onclick="submitForm<portlet:namespace/>();" value="<liferay-ui:message key='edison-button-board-modify' />" class="button04">
												<input type="button" name="<portlet:namespace />fullsize" id="fullsize" onclick="replyWriteCancel();" value="<liferay-ui:message key='cancel' />" class="button04">
											</div>
										</div>
									</td>
								</tr>
<%	
							}else{									
%>
								<tr>
									<td colspan="4">
										<div style="width: 100%;text-align: right;">
										
											<%=CustomUtil.strNull(map.get("writerDate")) %>&nbsp;&nbsp;<%=CustomUtil.strNull(map.get("writerName")) %>  
<%			
											if(themeDisplay.getUserId() == Long.parseLong(CustomUtil.strNull(map.get("writerId"))) || isAdministrator || isSiteAdministrator || isCustomAdmin){
%>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<a href="#" onclick="replyUpdate('<%=CustomUtil.strNull(map.get("boardSeq")) %>'); return false;"><u><liferay-ui:message key='edison-button-board-modify' /></u></a>
												<a href="#" onclick="replyDelete('<%=CustomUtil.strNull(map.get("boardSeq")) %>'); return false;"><u><liferay-ui:message key='edison-button-board-delete' /></u></a>
<%
											}
%>
										</div>
										<%=CustomUtil.strNull(map.get("content")) %>
<%
								replyFileList = (List)map.get("fileList");
								if(replyFileList != null && replyFileList.size() > 0){
%>
										<div id="fileListDiv">
<%
											for(int r=0;r<replyFileList.size();r++){
												replyFileMap = (Map)replyFileList.get(r);
%>
												<div style="cursor:pointer" onclick="<portlet:namespace/>fileDownload('<%=CustomUtil.strNull(replyFileMap.get("fileEntryId"))%>')" class="onMouseHover">
													<%=CustomUtil.strNull(replyFileMap.get("fileTitle"))%>
													<img src="<%=themeDisplay.getPathThemeImages() %>/custom/portlet/fileicon2.png" width="16" height="16" />
												</div>
<%
											}
%>
										</div>	
<%
								}//if(replyFileList != null && replyFileList.size() > 0){
%>
									</td>
								</tr>
<%
							}//if
						}//for
					}//if(replyList != null || replyList.size()>0){
%>
					
				</table>
			</div>
		</form>

	</c:if>


<script type="text/javascript">


function replyInputFormSlideDown(){
	$("#replyInputButton").css("display","none");

	$( "#replyInputForm" ).slideDown( "slow", function() {
		//complete process
	});	
}

function replyInputFormSlideUp(){		
	$( "#replyInputForm" ).slideUp( "slow", function() {
		$("#replyInputButton").css("display","block");
	});		
}


function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

function <portlet:namespace/>modify(){
	$("#<portlet:namespace/>replyBoardSeq").val("");
	$("#<portlet:namespace/>RENDER_SORT").val("UPDATE");
	if("${classId}" > 0) {
		<portlet:namespace/>viewForm.action = "<%=getBoardMaxRenderUrl%>" + "&classId=${classId }";
	} else if("${solverId}" > 0) {
		<portlet:namespace/>viewForm.action = "<%=getBoardRenderUrl%>" + "&solverId=${solverId }";
	} else {
		<portlet:namespace/>viewForm.action = "<%=getBoardRenderUrl%>";
	}
	<portlet:namespace/>viewForm.submit();
}

function <portlet:namespace/>deleteBoard(){
	if(confirm("Delete ?")){
		if("${classId}" > 0) {
			<portlet:namespace/>viewForm.action = "<%=deleteBoardActionUrl%>" + "&classId=${classId }";
		} else if("${solverId}" > 0) {
			<portlet:namespace/>viewForm.action = "<%=deleteBoardActionUrl%>" + "&solverId=${solverId }";
		} else {
			<portlet:namespace/>viewForm.action = "<%=deleteBoardActionUrl%>";
		}
		<portlet:namespace/>viewForm.submit();
	}
}

function replyUpdate(p_replyBoardSeq){
	$("#<portlet:namespace/>replyBoardSeq").val(p_replyBoardSeq);
	$("#<portlet:namespace/>RENDER_SORT").val("REPLY");
	if("${classId}" > 0) {
		<portlet:namespace/>viewForm.action = "<%=getBoardMaxRenderUrl%>" + "&classId=${classId }" ;
	} else if("${solverId}" > 0) {
		<portlet:namespace/>viewForm.action = "<%=getBoardRenderUrl%>" + "&solverId=${solverId }" ;
	} else {
		<portlet:namespace/>viewForm.action = "<%=getBoardRenderUrl%>" ;
	}
	<portlet:namespace/>viewForm.submit();
}

function replyWriteCancel(){
	$("#<portlet:namespace/>replyBoardSeq").val("");
	$("#<portlet:namespace/>RENDER_SORT").val("REPLY");
	if("${classId}" > 0) {
		<portlet:namespace/>viewForm.action = "<%=getBoardMaxRenderUrl%>" + "&classId=${classId }";
	} else if("${solverId}" > 0) {
		<portlet:namespace/>viewForm.action = "<%=getBoardRenderUrl%>" + "&solverId=${solverId }";
	} else {
		<portlet:namespace/>viewForm.action = "<%=getBoardRenderUrl%>";
	}
	<portlet:namespace/>viewForm.submit();
}


function replyDelete(p_replyBoardSeq){
	if(confirm("Delete ?")){		
		$("#<portlet:namespace/>replyBoardSeq").val(p_replyBoardSeq);
		$("#<portlet:namespace/>RENDER_SORT").val("REPLY_DELETE");
		if("${classId}" > 0) {
			<portlet:namespace/>viewForm.action = "<%=deleteReplyBoardActionUrl%>" + "&classId=${classId }";
		} else if("${solverId}" > 0) {
			<portlet:namespace/>viewForm.action = "<%=deleteReplyBoardActionUrl%>" + "&solverId=${solverId }";
		} else {
			<portlet:namespace/>viewForm.action = "<%=deleteReplyBoardActionUrl%>";
		}
		<portlet:namespace/>viewForm.action = "<%=deleteReplyBoardActionUrl%>";
		<portlet:namespace/>viewForm.submit();
	}
}

var fileIndex = 0;
function moreFileTag()
{
	fileIndex++;
	var frmTag = "<div id=\"fileDiv"+fileIndex+"\">";
	frmTag += "<input type=\"file\" name=\"addfile\" style =\"width:500px;border:1px solid #CCCCCC;margin-bottom:2px;\">&nbsp;";
	frmTag += "<input type=\"button\" value=\"delete\" style=\"cursor:pointer;\" class=\"button06\" onClick=\"deleteFileTag(\'fileDiv"+fileIndex+"\')\"/>";
	frmTag += "</div>";

	$("#fileTDArea").append(frmTag);
}

function deleteFileTag(objId){	
	$("#"+objId).remove();
	if($(':input[name*=addfile]').length == 0){
		moreFileTag();
	} 
}
 
function submitForm<portlet:namespace/>(){
	if(
		document.<portlet:namespace/>replyForm.onsubmit &&
		!document.<portlet:namespace/>replyForm.onsubmit()
	){
		return;
	}
 document.<portlet:namespace/>replyForm.submit();
}

function boardInputFormCheck<portlet:namespace/>(){
	oEditors.getById["<portlet:namespace/>content"].exec("UPDATE_CONTENTS_FIELD", []);
	
	if($("#<portlet:namespace/>content").val()==""){
		alert("<liferay-ui:message key='edison-board-enter-content-alert' />");
		return false;
	}else{
		return true;
	}
	
	return false;
}

<%if(isLogin){ %> 
	<c:if test="${boardDiv.replyYn==true}">
	
		moreFileTag();
		var oEditors = [];	
	
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: "<portlet:namespace/>content",
			sSkinURI: "${contextPath}/editor/SmartEditor2Skin.html",
			fCreator: "createSEditor2",
			fOnAppLoad : function(){
				$("#replyInputForm").css("display", "none");
			}
		});
		
	</c:if>
<%}%>

function deleteSingleEdisonFile(p_fileEntryId, p_fileUserId, p_boardSeq){
	if(!confirm("Delete File?")) return;
	
	var deleteForm = {
					"<portlet:namespace/>fileEntryId" : p_fileEntryId,
					"<portlet:namespace/>fileUserId" : p_fileUserId,
					"<portlet:namespace/>solverId" : $('#solverId').val(),
					"<portlet:namespace/>classId" : $('#classId').val(),
					"<portlet:namespace/>boardSeq" : p_boardSeq
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
				$("#fileListDiv").html("");		

				var fileHtml = "";
				if(fileList.length == 0){
				}else{
					for(var i = 0 ; i < fileList.length; i++ ){					
						fileHtml += "<span style=\"cursor:pointer\" onclick=\"<portlet:namespace/>fileDownload(\'"+fileList[i].fileEntryId+"\')\">";
						fileHtml += fileList[i].fileTitle;
						fileHtml += " <img src=\"<%=themeDisplay.getPathThemeImages() %>/custom/portlet/fileicon2.png\" width=\"16\" height=\"16\" />";						
						fileHtml += "</span>";						
						fileHtml += "&nbsp;&nbsp;";
						fileHtml += "<span style=\"cursor:pointer\" onclick=\"deleteSingleEdisonFile(\'"+fileList[i].fileEntryId+"\', \'"+fileList[i].fileUserId+"\', \'"+p_boardSeq+"\')\"><u>[delete]</u></span>";
						fileHtml += "<br>";
					}
					
					console.log(fileHtml);
					
					$("#fileListDiv").html(fileHtml);
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

</script>
