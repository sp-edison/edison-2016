<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.Group"%>

<%!
	public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.journal.edit_article_content.jsp";
%>

<%
	long originalBoardPlid = 0;
	String boardPlid = CustomUtil.strNull((portletPreferences.getValue("originalBoardPlid", "0")));
	
	if(boardPlid.equals("")){
		originalBoardPlid = 0;
	}else{
		originalBoardPlid = Long.parseLong(boardPlid);
	}
	String originalBoardPortletName = CustomUtil.strNull((portletPreferences.getValue("originalBoardPortletName", "")));
	
	if(originalBoardPlid == 0) originalBoardPlid = plid;
	
	String defaultLanguageId = (String)request.getAttribute("edit_article.jsp-defaultLanguageId");
	String toLanguageId = (String)request.getAttribute("edit_article.jsp-toLanguageId");
%>

 <%
 		Map<String, String> fileBrowserParamsMap = (Map<String, String>)request.getAttribute("liferay-ui:input-editor:fileBrowserParams");
 		
 		String fileBrowserParams = marshallParams(fileBrowserParamsMap);
		
 		StringBundler sb = new StringBundler(8);
		String portletId = portletDisplay.getRootPortletId();
		String mainPath = themeDisplay.getPathMain();

		String doAsUserId = themeDisplay.getDoAsUserId();
		long doAsGroupId = themeDisplay.getDoAsGroupId();
 		Locale siteLocale = themeDisplay.getLocale();
		String doasLocale = siteLocale.getLanguage();

		if (doAsGroupId == 0) {
			doAsGroupId = (Long)themeDisplay.getSiteGroupId();
		}
		
		Group group = GroupLocalServiceUtil.getGroup(doAsGroupId);
		String currentFolder = "/"+doAsGroupId+" - "+"edison"+"/";
		
		sb.append(mainPath);
		sb.append("/portal/fckeditor?p_p_id=");
		sb.append(HttpUtil.encodeURL(portletId));
		sb.append("&doAsUserId=");
		sb.append(HttpUtil.encodeURL(doAsUserId));
		sb.append("&doAsGroupId=");
		sb.append(HttpUtil.encodeURL(String.valueOf(doAsGroupId)));
		sb.append(fileBrowserParams);

		String connectorURL = HttpUtil.encodeURL(sb.toString());
%>

<liferay-portlet:renderURL var="boardListURL" portletMode='view'>
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="boardListMaxURL" portletMode='view' windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:renderURL>
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="deleteSingleEdisonFileURL" escapeXml="false" id="deleteSingleEdisonFile" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:resourceURL>
<liferay-portlet:actionURL copyCurrentRenderParameters="false" var="addBoardActionUrl" portletMode="view">
	<portlet:param name="myAction" value="addBoardAction" />
	<portlet:param name="boardSeq" value="${boardMap.boardSeq }" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL copyCurrentRenderParameters="false" var="updateBoardActionUrl" portletMode="view" >
	<portlet:param name="myAction" value="updateBoardAction"/>
	<portlet:param name="boardSeq" value="${boardMap.boardSeq }" />
</liferay-portlet:actionURL>
<liferay-portlet:renderURL copyCurrentRenderParameters="false" var="getBoardMaxRenderUrl" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
	<liferay-portlet:param name="boardSeq" value="${boardMap.boardSeq }" />
	<liferay-portlet:param name="myRender" value="getBoardRender"/>
</liferay-portlet:renderURL>
<liferay-portlet:renderURL copyCurrentRenderParameters="false" var="getBoardRenderUrl">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
	<liferay-portlet:param name="boardSeq" value="${boardMap.boardSeq }" />
	<liferay-portlet:param name="myRender" value="getBoardRender"/>
</liferay-portlet:renderURL>

<style>
.dp_ib {display: inline-block !important; margin: 1px;}
</style>

<c:choose>
	<c:when test="${boardMap.boardSeq == null || boardMap.boardSeq == ''}">
		<c:set var="actionUrl" value="<%=addBoardActionUrl%>"/>
	</c:when>
	<c:otherwise>
		<c:set var="actionUrl" value="<%=updateBoardActionUrl%>"/>	
	</c:otherwise>
</c:choose>

<h1>${boardDivTitle}</h1>

<form id="boardInputForm<portlet:namespace/>" name="boardInputForm<portlet:namespace/>" method="POST"  action="${actionUrl}" onsubmit="return boardInputFormCheck<portlet:namespace/>()" enctype="multipart/form-data">
	<input type="hidden" id="<portlet:namespace/>boardGroupId" name="<portlet:namespace/>boardGroupId" value="${boardGroupId }">
	<input type="hidden" id="<portlet:namespace/>classId" name="<portlet:namespace/>classId" value="${classId }">	
	<input type="hidden" id="<portlet:namespace/>solverId" name="<portlet:namespace/>solverId" value="${solverId}">
	<input type="hidden" name="<portlet:namespace/>RENDER_SORT" value="UPDATE">
	<input type="hidden" id="<portlet:namespace/>currentLocale" name="<portlet:namespace/>current_languageId" value="${select_languageId }">
	<input type="hidden" id="<portlet:namespace/>currentPage" name="<portlet:namespace/>currentPage" value="${currentPage }">
	<input type="hidden" id="<portlet:namespace/>searchValue" name="<portlet:namespace/>searchValue" value="${searchValue }">

	<div class="table1_list">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup id="boardColgroup">
				<col width="240px" />
				<col width="240px" />
				<col width="240px" />
				<col width="*" />
			</colgroup>
			
			<c:choose>
				<c:when test="${boardDiv.divNm=='NOTICE' || boardDiv.divNm=='FAQ'}">
					<tr>			
						<th><liferay-ui:message key='edison-board-select-language' /></th>
						<td colspan="3">
								<%
								Locale[] availLocales = LanguageUtil.getAvailableLocales();
								for(int i=0;i<availLocales.length;i++){
								%>
								<label style="display:inline;">
								<input type="radio" id="<portlet:namespace/>select_languageId" name="<portlet:namespace/>select_languageId" value="<%=availLocales[i]%>" <%if(CustomUtil.strNull(request.getAttribute("select_languageId")).equals(availLocales[i].toString())) out.print("checked"); %>
								<c:if test="${boardMap.boardSeq != null }">
								 	onChange="changeLanguage()"
								</c:if>
								/>
								<img width="17px" height="12px" src="<%=themeDisplay.getPathThemeImages() %>/language/<%=availLocales[i]%>.png" />
								<liferay-ui:message key='<%="edison-board-radiobutton-" + availLocales[i].toString()%>' />
								</label>
								<%
								}
								%>
						</td>
					</tr>
			
					<c:if test="${boardDiv.popupYn==true }">	
					<tr>
						<th><liferay-ui:message key='edison-board-select-popup' /></th>
						<td>
							<label for="<portlet:namespace/>popupYn">
								<input type="checkbox" id="<portlet:namespace/>popupYn" name="<portlet:namespace/>popupYn" value="true" <c:if test="${boardMap.popupYn=='true'}">checked</c:if>> 
								<liferay-ui:message key='edison-board-use-popup' />
							</label>
						</td>
						<th><liferay-ui:message key='edison-board-use-popup-date' /></th>
						<td>
							<input name="<portlet:namespace/>popupStartDt" id="<portlet:namespace/>popupStartDt" readonly="readonly" value="${boardMap.popupStartDt }"/> ~ <input name="<portlet:namespace/>popupEndDt" id="<portlet:namespace/>popupEndDt" readonly="readonly" value="${boardMap.popupEndDt }"/>
						</td>
					</tr>	
					</c:if>
					<c:if test="${boardDiv.divCd=='100' && isPortal == true}">
						<th><liferay-ui:message key='edison-virtuallab-tablerow-site' /></th>
						<td colspan="2">
							<input type="checkbox" id="<portlet:namespace/>allSite"><label class="dp_ib" for="<portlet:namespace/>allSite">&nbsp;<liferay-ui:message key='full' /></label>
							<c:forEach var="group" items="${groupList}">
								<c:set var="groupChecked" value=""></c:set>
								<c:if test="${!empty siteGroups}">
									<c:forEach var="siteGroup" items="${siteGroups}">
										<c:if test="${group.groupId eq siteGroup}">
											<c:set var="groupChecked" value="checked"></c:set>
										</c:if>
									</c:forEach>
								</c:if>
								&nbsp;<input type="checkbox" id="<portlet:namespace/>siteGroup_${group.groupId }" name= "<portlet:namespace/>siteGroup" value="${group.groupId }" ${groupChecked}>
								<label class="dp_ib" for="<portlet:namespace/>siteGroup_${group.groupId }" >&nbsp;${group.name }</label>
							</c:forEach>
						</td>
					</c:if>
				</c:when>
				<c:otherwise>
						<input type="hidden" id="<portlet:namespace/>select_languageId" name="<portlet:namespace/>select_languageId" value="<%=themeDisplay.getLocale()%>">
				</c:otherwise>
			</c:choose>

			<tr>
				<c:choose>
					<c:when test="${boardDiv.divNm=='FAQ'}">
						<th><liferay-ui:message key='edison-appstore-myapp-question' /></th>
					</c:when>
					<c:otherwise>
						<th><liferay-ui:message key='title' /></th>
					</c:otherwise>
				</c:choose>
				<td colspan="3"><input type="text" id="<portlet:namespace/>title" name="<portlet:namespace/>title" style="width:80%; margin:0px;" value="${boardMap.title }"> </td>
			</tr>
			<tr>
				<td colspan="4" style="height:300px;">
					<textarea id="<portlet:namespace/>content" name="<portlet:namespace/>content" style="width:100%;height:300px;">${boardMap.content }</textarea>
				</td>
			</tr>
			<c:choose>
				<c:when test="${boardDiv.fileUpLoadUseYn == true}">
				<tr>								
					<th width="20%" rowspan="2" valign="top">
						<liferay-ui:message key='edison-table-list-header-file' />&nbsp;
						<input type="button" value="<liferay-ui:message key='edison-button-file-add' />" class="button06" onClick="moreFileTag()" style="cursor:pointer;"/>	
					</th>
				</tr>	
				<tr>
					<td id="fileTDArea" colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4">
						<div id="fileListDiv">
							<img src="${contextPath}/images/fileicon.png" width="19" height="21" />&nbsp;<liferay-ui:message key='edison-table-content-header-attachments' />&nbsp;&nbsp;｜&nbsp;&nbsp;
							<c:forEach items="${fileList}" var="fileMap">
								<span style="cursor: pointer;" onclick="<portlet:namespace/>fileDownload('${fileMap.fileEntryId }')" class="onMouseHover">
									<img src="${contextPath}/images/fileicon2.png" width="16" height="16" />
									${fileMap.fileTitle }
								</span>
								&nbsp;&nbsp;
								<span style="cursor:pointer" onclick="deleteSingleEdisonFile<portlet:namespace/>('${fileMap.fileEntryId }', '${fileMap.fileUserId }')">
									<u>[delete]</u>
								</span>
								<br>
							</c:forEach>
						</div>
					</td>
				</tr>
				</c:when>
			</c:choose>
		</table>
	</div>
<br> 
	<div class="boardbtnbox" style="text-align: right;">
		<input type="button" class="button02" style="margin-right:5px;" onClick="submitForm<portlet:namespace/>(); return false;" value="<liferay-ui:message key='edison-virtuallab-save' />" />
		<c:if test="${classId eq '0' && solverId eq '0'}">
			<input type="button" class="button02" onClick="location.href='<%=boardListURL%>&<portlet:namespace/>maxList=Y&<portlet:namespace/>currentPage=${currentPage }&<portlet:namespace/>searchValue=${searchValue}'; return false;" value="<liferay-ui:message key='edison-button-board-list' />" />
		</c:if>
		<c:if test="${classId ne '0'}">
			<input type="button" class="button02" onClick="location.href='<%=boardListMaxURL%>&<portlet:namespace/>maxList=Y&<portlet:namespace/>currentPage=${currentPage }&<portlet:namespace/>searchValue=${searchValue}&classId=${classId }&solverId=${solverId }'; return false;" value="<liferay-ui:message key='edison-button-board-list' />" />
		</c:if>
		<c:if test="${solverId ne '0'}">
			<input type="button" class="button02" onClick="location.href='<%=boardListURL%>&<portlet:namespace/>currentPage=${currentPage }&<portlet:namespace/>searchValue=${searchValue}&classId=${classId }&solverId=${solverId }'; return false;" value="<liferay-ui:message key='edison-button-board-list' />" />
		</c:if>
	</div>
</form>

<%!

public String marshallParams(Map<String, String> params) {
	StringBundler sb = new StringBundler();

	if (params != null) {
		for (Map.Entry<String, String> configParam : params.entrySet()) {
				sb.append(StringPool.AMPERSAND);
				sb.append(configParam.getKey());
				sb.append(StringPool.EQUAL);
				sb.append(HttpUtil.encodeURL(configParam.getValue()));
		}
	}

	return sb.toString();
}
%>

<script type="text/javascript" src="${contextPath}/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="${contextPath}/editor/ckeditor/ckeditor.js" charset="utf-8"></script> 
<script type="text/javascript">
$(document).ready(function(){
	var allChkLength = $("input[name=<portlet:namespace/>siteGroup]").length;
	var uncheckedLength = $("input[name=<portlet:namespace/>siteGroup]:checkbox:not(:checked)").length;
	var checkedLength = $("input[name=<portlet:namespace/>siteGroup]:checkbox:checked").length;

	/*분야를 낱개로 모두선택시 전체선택체크박스 체크*/
	if(allChkLength == checkedLength){
		$("#<portlet:namespace/>allSite").prop("checked",true)
	}	
});

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
    	document.boardInputForm<portlet:namespace/>.onsubmit &&
    	!document.boardInputForm<portlet:namespace/>.onsubmit()
    ){
        return false;
    }
 	document.boardInputForm<portlet:namespace/>.submit();
}

function fRemoveHtmlTag(string) { 
	   var objReplace = new RegExp(); 
	   objReplace = /[<][^>]*[>]/gi; 
	   string.replace(objReplace, "");
	   return string.replace(objReplace, ""); 
}

function boardInputFormCheck<portlet:namespace/>(){
	   // 에디터의 내용이 textarea에 적용된다.
	var title = $("#<portlet:namespace/>title").val();
	var contentValue = CKEDITOR.instances['<portlet:namespace/>content'].getData();
// 	var content = $.trim(contentValue.replace(/&nbsp;/g, ''));
	var content = contentValue;
	if($.trim(title)==""){
		alert("<liferay-ui:message key='edison-board-enter-title-alert' />");
		$("#<portlet:namespace/>title").val("");
		$("#<portlet:namespace/>title").focus();
		$("input:radio[name='<portlet:namespace/>select_languageId']:radio[value='${select_languageId }']").prop("checked",true);
		return false;
	}else if($.trim(content)==""){
		alert("<liferay-ui:message key='edison-board-enter-content-alert' />");
		$("input:radio[name='<portlet:namespace/>select_languageId']:radio[value='${select_languageId }']").prop("checked",true);
		return false;
	}else{
		$("#<portlet:namespace/>content").val(content);
 		return true;
	}
	
	return false;
}


function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

function changeLanguage(){
	if(confirm("<liferay-ui:message key='edison-board-save-alert' />")){		
		submitForm<portlet:namespace/>();
	}else{
		var vClassId = "${classId }"==""?"":Number("${classId }");
		var reloadUrl = "<%=getBoardRenderUrl%>"
		
		if(vClassId > 0) {
			reloadUrl = "<%=getBoardMaxRenderUrl%>";
		}
		
		reloadUrl += "&<portlet:namespace/>RENDER_SORT=UPDATE";
			reloadUrl += "&<portlet:namespace/>select_languageId="+$("input[name=<portlet:namespace/>select_languageId]:radio:checked").val();
			reloadUrl += "&<portlet:namespace/>classId=${classId}";
			reloadUrl += "&<portlet:namespace/>solverId=${solverId}";	
		location.href = reloadUrl;
	}
}

function deleteSingleEdisonFile<portlet:namespace/>(p_fileEntryId, p_fileUserId){
		
	if(!confirm("Delete File?")) return;
	
	var deleteForm = {
					"<portlet:namespace/>fileEntryId" : p_fileEntryId,
					"<portlet:namespace/>fileUserId" : p_fileUserId,
					"<portlet:namespace/>solverId" : $('#solverId').val(),
					"<portlet:namespace/>classId" : $('#classId').val(),
					"<portlet:namespace/>boardSeq" : "${boardMap.boardSeq }"
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
						fileHtml += "<span style=\"cursor:pointer\" onclick=\"deleteSingleEdisonFile<portlet:namespace/>(\'"+fileList[i].fileEntryId+"\', \'"+fileList[i].fileUserId+"\')\"><u>[delete]</u></span>";
						fileHtml += "<br>";
					}
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

//####################################################################################
// Document Ready Define #############################################################
//####################################################################################		

moreFileTag();

/*분야 체크박스 전체선택해제*/

$("#<portlet:namespace/>allSite").click(function(){
    if($("#<portlet:namespace/>allSite").prop("checked")){
        $("input[name=<portlet:namespace/>siteGroup]").prop("checked",true);
    }else{
        $("input[name=<portlet:namespace/>siteGroup]").prop("checked",false);
    }
});
$("input[name=<portlet:namespace/>siteGroup]").click(function(){
	var allChkLength = $("input[name=<portlet:namespace/>siteGroup]").length;
	var uncheckedLength = $("input[name=<portlet:namespace/>siteGroup]:checkbox:not(:checked)").length;
	var checkedLength = $("input[name=<portlet:namespace/>siteGroup]:checkbox:checked").length;
	
	/*분야1개라도체크안되있으면 전체선택체크박스 해제*/
	if(uncheckedLength > 0){
		$("#<portlet:namespace/>allSite").prop("checked",false)
	}
	
	/*분야를 낱개로 모두선택시 전체선택체크박스 체크*/
	if(allChkLength == checkedLength){
		$("#<portlet:namespace/>allSite").prop("checked",true)
	}
});

var fileBrowserConectorURL = "<%=connectorURL%>";
fileBrowserConectorURL = fileBrowserConectorURL +"&currentFolder=${currentFolder}";
var ckEditorLanguage = "<%=doasLocale%>";
CKEDITOR.config.autoParagraph = false;
CKEDITOR.config.tabSpaces = 0;

CKEDITOR.replace( '<portlet:namespace/>content', {
	filebrowserImageBrowseUrl: "/edison-board-2016-portlet/editor/ckeditor/filemanger/browser.html?Connector="+fileBrowserConectorURL,
	language: ckEditorLanguage,
    filebrowserUploadUrl: null,
    toolbar : [
        		['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
         		['Bold', 'Italic', 'Underline', 'Strike'],
         		['Subscript', 'Superscript'],
         		'/',
         		['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
         		['Find', 'Replace', 'SpellChecker', 'Scayt'],
         		['Outdent','Indent','Blockquote'],
         		['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
         		'/',
         		['Source'],
         		['Link', 'Unlink', 'Anchor'],
         		['Image', 'Flash',  'Table', '-', 'Smiley', 'SpecialChar', 'LiferayPageBreak'],
         		['A11YBtn']
         	]
});

$("#<portlet:namespace/>popupStartDt").datepicker({
	showButtonPanel: true,
	showOn: 'button',
	dateFormat:"yy-mm-dd",
	changeMonth: true,
	changeYear: true,
	buttonImage: "${contextPath}/images/calendar.png",
	buttonImageOnly: true,
	onClose: function( selectedDate ) {
		$("#<portlet:namespace/>popupEndDt").datepicker("option", "minDate", selectedDate);
		
	}
});

$("#<portlet:namespace/>popupEndDt").datepicker({
	showButtonPanel: true,
	showOn: 'button',
	dateFormat:"yy-mm-dd",
	changeMonth: true,
	changeYear: true,
	buttonImage: "${contextPath}/images/calendar.png",
	buttonImageOnly: true,
	onClose: function( selectedDate ) {
		$("#<portlet:namespace/>popupStartDt").datepicker("option", "maxDate", selectedDate);
		
	}
});
</script>
