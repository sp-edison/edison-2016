<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%
	Locale[] locales = LanguageUtil.getAvailableLocales();

%>
<style type="text/css">
	#port-type-editor-dialog .puptrline {
		border-bottom: solid 1px #ccc;
	}
	
	#port-type-editor-dialog .puptitle {
		font-size: 17px;
		font-weight: 600;
		color: #334b7e;
		padding-left: 8px;
		padding: 10px;
	}
	
	#port-type-editor-dialog .puptxt {
		font-size: 14px;
		font-weight: 600;
		color: #666;
		line-height: 25px;
		padding: 10px 0 10px 8px;
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
			<img id="port-type-editor-close-btn" name="port-type-editor-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	
	<div class="newWcont01">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
			<colgroup>
				<col width="15%">
				<col width="*">
				<col width="17%">
				<col width="*">
			</colgroup>
			<tr class="puptrline">
				<td class="puptitle"><liferay-ui:message key='edison-table-list-header-port-Type-name'/></td>
				<td colspan="3" class="puptxt">
					<input name="name" value="${portTypeName}" type="text" class="long_field" readonly="readonly"/>
				</td>
			</tr>
			<tr class="puptrline">
				<td class="puptitle"><liferay-ui:message key='edison-content-service-language'/></td>
				<td colspan="3" class="puptxt">
					<aui:select name="targetLanguage" label="" >
						<option value="full"><liferay-ui:message key='full'/></option>
						<%
						for(Locale aLocale : locales){
							String languageId = LocaleUtil.toLanguageId(aLocale);
							String languageNm =aLocale.getDisplayName(themeDisplay.getLocale());
						%>
							<aui:option label="<%=languageNm%>" value="<%=languageId%>"/>
						<%} %>
					</aui:select>
				</td>
			</tr>
			<tr class="puptrline">
				<td class="puptitle"><liferay-ui:message key='edison-science-appstore-toolkit-editor-list'/></td>
				<td class="puptxt">
					<c:forEach var="data" items="${editorDataList}">
						<aui:input name="editor" id="editor_${data.scienceAppId}" label="${data.name}" value="<%=false%>" appid="${data.scienceAppId}" editorType="${data.editorType}" type="checkbox" onClick="checkEditor('${data.scienceAppId}','${data.name}',this.id);"/>
					</c:forEach>
				</td>
				<c:choose>
					<c:when test="${portType eq 'INPUT' }">
						<td class="puptitle">Default Editor<span class="requiredField"> *</span></td>
					</c:when>
					<c:otherwise>
						<td class="puptitle">Default Editor</td>
					</c:otherwise>
				</c:choose>
				<td class="puptxt">
					<select id="<portlet:namespace/>defaultEditorSelect">
						<option value=""></option>
					</select>
				</td>
			</tr>
			<tr class="puptrline">
				<td class="puptitle"><liferay-ui:message key='edison-science-appstore-toolkit-analyzer-list'/></td>
				<td class="puptxt">
					<c:forEach items="${analyzerDataList}" var="data">
						<aui:input name="analyzer" id="analyzer_${data.scienceAppId}" label="${data.name}" value="<%=false%>" appid="${data.scienceAppId}" type="checkbox" onClick="checkAnalyzer('${data.scienceAppId}','${data.name}',this.id);"/>
					</c:forEach>
				</td>
				<c:choose>
					<c:when test="${portType ne 'INPUT' }">
						<td class="puptitle">Default Analyzer<span class="requiredField"> *</span></td>
					</c:when>
					<c:otherwise>
						<td class="puptitle">Default Analyzer</td>
					</c:otherwise>
				</c:choose>
				<td class="puptxt">
					<select id="<portlet:namespace/>defaultAnalyzerSelect">
						<option value=""></option>
					</select>
				</td>
			</tr>
		</table>
	</div>
	<div class="popupbtnGroup" style="height:40px;">
		<input name="add" type="button" value="<liferay-ui:message key="add"/>" class="graybtn" onclick="<portlet:namespace/>editorSubmit();"/>
	</div>
</div>
<script type="text/javascript">
AUI().ready(function() {
	$("#port-type-editor-close-btn").click(function() {
		$("#port-type-editor-dialog").dialog("close");
	});
});


function checkEditor(appId,name,id){
	$checkbox = $("#"+id);
	$selectbox = $("#<portlet:namespace/>defaultEditorSelect");
	
	if($checkbox.prop('checked')){
		$("<option/>").val(appId)
					  .attr("id","<portlet:namespace/>defaultEditorOption_"+appId)
					  .text(name)
					  .appendTo($selectbox);
	}else{
		$("#<portlet:namespace/>defaultEditorOption_"+appId).remove();
		$selectbox.focus();
	}
	
}
function checkAnalyzer(appId,name,id){
	$checkbox = $("#"+id);
	$selectbox = $("#<portlet:namespace/>defaultAnalyzerSelect");
	
	if($checkbox.prop('checked')){
		$("<option/>").val(appId)
					  .attr("id","<portlet:namespace/>defaultAnalyzerOption_"+appId)
					  .text(name)
					  .appendTo($selectbox);
	}else{
		$("#<portlet:namespace/>defaultAnalyzerOption_"+appId).remove();
		$selectbox.focus();
	}
}


function <portlet:namespace/>editorSubmit(){
	var portType = "${portType}";
	var checkDefaultItem;
	var checkDefaultItemStatus = false;
	var checkDefaultVal = "";
	
	
	if(portType=='INPUT'){
		checkDefaultItem = $("#<portlet:namespace/>defaultEditorSelect");
		checkDefaultVal = checkDefaultItem.find("option:selected").val();
	}else{
		checkDefaultItem = $("#<portlet:namespace/>defaultAnalyzerSelect");
		checkDefaultVal = checkDefaultItem.find("option:selected").val();
	}
	
	if(checkDefaultVal!=""){
		checkDefaultItemStatus = true;
	}
	
	
	if(!checkDefaultItemStatus){
		alert(Liferay.Language.get('this-field-is-mandatory'));
		checkDefaultItem.focus();
		return false;
	}else{
		$('.ui-widget-overlay').click();
		var targetLanuage = $("#<portlet:namespace/>targetLanguage option:selected").val();
		
		
		var defaultEditor = $("#<portlet:namespace/>defaultEditorSelect option:selected").val();
		var defaultAnalyzer = $("#<portlet:namespace/>defaultAnalyzerSelect option:selected").val();
		
		var editor = [];
		var inputDeckExist = false;
		var fileExist = false;
		$("input[type='hidden'][name='<portlet:namespace/>editor']").each(function(){
			var value = $(this).val();
			if(value!="false"){
				var editortype = $("#"+$(this).attr("id")+"Checkbox").attr("editortype");
				if(editortype=="Inputdeck"){
					inputDeckExist = true;
				}
				
				if(editortype=="File"){
					fileExist = true;
				}
				
				var appId = $("#"+$(this).attr("id")+"Checkbox").attr("appid");
				if(appId!=defaultEditor){
					editor.push(appId);
				}
			}
		})
		
		var analyzer = [];
		$("input[type='hidden'][name='<portlet:namespace/>analyzer']").each(function(){
			var value = $(this).val();
			if(value!="false"){
				var appId = $("#"+$(this).attr("id")+"Checkbox").attr("appid");
				if(appId!=defaultAnalyzer){
					analyzer.push(appId);
				}
			}
		})
		
		<portlet:namespace/>portTypeAddOpen(editor,defaultEditor,"${portTypeName}",targetLanuage,inputDeckExist,analyzer,defaultAnalyzer,fileExist);
// 		<portlet:namespace/>portTypeAddOpen(items,defaultItem,"${portTypeName}",targetLanuage,inputDeckExist,analyzer,defaultAnalyzer);
	}
}
</script>