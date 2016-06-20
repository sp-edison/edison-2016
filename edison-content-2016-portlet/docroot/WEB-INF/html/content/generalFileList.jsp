<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%
	String groupNm = (String)request.getAttribute("groupNm");
	String groupId = (String)request.getAttribute("groupId");
	String contentSeq = (String)request.getAttribute("contentSeq");
	String contentDiv = (String)request.getAttribute("contentDiv");
	String codeOption = (String)request.getAttribute("codeOption");
	
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
</style>
<liferay-portlet:actionURL secure="<%= request.isSecure() %>" var="modifyGeneralContentUrl">
	<portlet:param name="myaction" value="generalModify" />
</liferay-portlet:actionURL>
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="retrieveGeneralFileListURL" id="retrieveGeneralFileList" copyCurrentRenderParameters="false" escapeXml="false"/>

<div class="newWindow" style="background-color: #fff; overflow-x: hidden;overflow-y: hidden;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle"><liferay-ui:message key="<%=groupNm%>"/> <liferay-ui:message key="edison-content-file"/></div>
		</div>
		<div class="newWclose">
			<img id="general-file-download-dialog-close-btn" name="general-file-download-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<aui:form action="<%= modifyGeneralContentUrl %>" method="post" name="createGeneralContentForm" enctype="multipart/form-data">
		<aui:input name="groupId" type="hidden" value="<%=groupId%>"/>
		<aui:input name="contentSeq" type="hidden" value="<%=contentSeq%>"/>
		<aui:input name="contentDiv" type="hidden" value="<%=contentDiv%>"/>
		
		<div class="newWcont01">
		<div style="margin-bottom: 5px;float: right;">
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table1 borderno" style="word-break: break-all;">
			<colgroup>
				<col width="70px" />
				<col width="250px" />
				<col width="100px" />
			</colgroup>
			<tbody id="generalFileListTableBody">
				<tr class="puptrline tablebgtr">
					<th scope="col"><liferay-ui:message key="edison-table-list-header-file"/></th>
					<th scope="col" class="left"><liferay-ui:message key="edison-table-list-header-file-nm"/></th>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-download"/></th>
				</tr>
				<c:forEach var="file" items="${resultFileList }" varStatus="status">
					
					<tr class="puptrline <c:if test="${status.index % 2 == 1 }">tablebgtr</c:if>">
							<td class="puptxt TC" style="word-break:break-all">
							<c:choose>
								<c:when test="${fn:indexOf('JPG|PNG|GIF',fn:toUpperCase(file.fileExtension)) > -1 }">
									<i class="icon-edison icon-picture"></i>
								</c:when>
								<c:when test="${fn:indexOf('PDF|HWP|TXT|PPT|PPTX|XLSX|XLS', fn:toUpperCase(file.fileExtension)) > -1 }">
									<i class="icon-edison icon-text"></i>
								</c:when>
								<c:otherwise>
									<i class="icon-edison icon-file"></i>
								</c:otherwise>
							</c:choose>
							</td>
							<td class="puptxt">
								${file.fileTitle}
							</td>
							<td class="puptxt TC">
								<input type="button" value="<liferay-ui:message key="edison-table-list-header-download"/>" class="button03" onclick="<portlet:namespace/>fileDownload('${file.fileEntryId }');"/>
							</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</aui:form>
</div>
<script type="text/javascript">

AUI().ready(function() {
	$("#general-file-download-dialog-close-btn").click(function() {
		<portlet:namespace/>generalContentSearch("");
		$("#general-file-download-dialog").dialog("close");
	});
	
});

//일반컨텐츠 파일다운로드
function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

/**
 * 파일 확장자에 따른 JSP 에서 보여줄 파일 확장자 값으로 변경
 * JPG,PNG,GIF -> image
 * PDF, HWP, TXT,PPT, PPTX, XLSX, XLS -> text
 * 그외 -> default
 */
function <portlet:namespace/>fileExtensionImageReturn(str){
	var checkStr = str.toUpperCase();
	var IMAGE = "JPG|PNG|GIF";
	var TEXT = "PDF|HWP|TXT|PPT|PPTX|XLSX|XLS";
	var returnStr = "";
	
	if(IMAGE.indexOf(checkStr)>-1){
		returnStr = "IMAGE";
	}else if(TEXT.indexOf(checkStr)>-1){
		returnStr = "TEXT";
	}else{
		returnStr = "DEFAULT";
	}
	return returnStr;
}
</script>