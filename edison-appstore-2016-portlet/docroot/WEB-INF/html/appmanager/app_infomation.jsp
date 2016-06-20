<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<%@ page import="org.kisti.edison.science.Exception.ScienceAppException" %>

<!-- ckeditor -->
<%@ page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.Group"%>
<!-- ------- -->


<portlet:actionURL var="submitURL" copyCurrentRenderParameters="false" name="appAction">
	<portlet:param name="clickTab" value="${clickTab}"/>
	<portlet:param name="swTest" value="${swTest}"/>
	<portlet:param name="actionType" value="appInfomation"/>
	
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
	<portlet:param name="searchValue" value="${searchValue}"/>
	<portlet:param name="searchOption" value="${searchOption}"/>
	<portlet:param name="searchStatus" value="${searchStatus}"/>
	<portlet:param name="p_curPage" 	value="${p_curPage}" />
</portlet:actionURL>

<liferay-portlet:resourceURL var="subCategortSearchURL" id="subCategortSearch" copyCurrentRenderParameters="false" escapeXml="false"/>

<liferay-portlet:resourceURL var="appManagerListURL" id="appManagerList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="deleteAppAuthURL" id="deleteAppAuth" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="appUserInfoURL" id="appUserInfo" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="appManagerAddURL" id="appManagerAdd" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="appOwnerUpdateURL" id="appOwnerUpdate" copyCurrentRenderParameters="false" />

<%
	Locale[] locales = LanguageUtil.getAvailableLocales();
	String localesStr = "";

	String exceptionNameMsg = LanguageUtil.get(themeDisplay.getLocale(),"edison-app-validation-name-exception-msg");
	String exceptionVersionMsg = LanguageUtil.get(themeDisplay.getLocale(),"edison-app-validation-version-exception-msg");
	String textAreaPlaceholder = LanguageUtil.get(themeDisplay.getLocale(),"Enter-one-value-per-line");
	
	String mode = GetterUtil.get(request.getAttribute("mode"), "");
	
	boolean swTest = GetterUtil.getBoolean(request.getAttribute("swTest"), false);
%>
<!-- ckeditor -->
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
<!-- ------------- -->
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
</style>
<!-- ckeditor  -->
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
<script type="text/javascript" src="${contextPath}/editor/ckeditor/ckeditor.js" charset="utf-8"></script>

<c:if test="<%= SessionErrors.contains(renderRequest, ScienceAppException.class.getName()) %>">
	<%
		ScienceAppException sae = (ScienceAppException)SessionErrors.get(renderRequest, ScienceAppException.class.getName());
	%>
	<div class="alert alert-error">
		<c:if test="<%= sae.getType() == ScienceAppException.EXISTS_NAME_VERSION_DATABASE %>">
			<liferay-ui:message key="edison-app-duplication-app-name-exception-msg" />
		</c:if>
		
		<c:if test="<%= sae.getType() == ScienceAppException.FAIL_VALIDATION_SCIENCE_APP_NAME %>">
			<liferay-ui:message key="edison-app-validation-name-exception-msg" />
		</c:if>
	</div>
</c:if>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-science-appstore-toolkit-default-information' />
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
			</c:if>
			<c:if test="${data.status eq '1901004'}">
				<input class="addIp button02_3" onclick="<portlet:namespace/>statusSubmit('1901003');" value="<liferay-ui:message key='edison-appstore-status-private'/>" type="button">
			</c:if>
		</c:if>
		<input class="addIp button02_1" onclick="<portlet:namespace/>actionCall('<%=Constants.ADD%>');return false;" value="<liferay-ui:message key='edison-button-save'/>" type="button">
		<c:if test="${!empty scienceAppId && ownerThan }">
			<input class="addIp button02_1" onclick="<portlet:namespace/>actionCall('<%=Constants.DELETE%>');return false;" value="<liferay-ui:message key='delete'/>" type="button">
		</c:if>
	</div>
</div>
<div class="h10"></div>
<div class="table1_list">
	<aui:form name="frm" method="POST" action="<%=submitURL%>">
		<aui:input name="actionMode" value="${mode}" type="hidden"/>
		
		<c:if test="${mode eq 'update'}">
			<aui:input name="previousVersion" type="hidden" value="${data.version}" label=""/>
		</c:if>
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
			<colgroup>
				<col width="20%">
				<col width="40%">
				<col width="15%">
				<col width="25%">
			</colgroup>
			<tr>
				<th><liferay-ui:message key='edison-appstore-solver-name' /><span class="requiredField"> *</span></th>
				<td>
					<c:choose>
						<c:when test="${empty scienceAppId}">
							<aui:input name="name" type="text" cssClass="long_field" label="" value="" maxLength="100">
								<aui:validator name="required"/>
								<aui:validator  name="custom"  errorMessage="<%=exceptionNameMsg%>">
									function (val, fieldNode, ruleValue) {
										 var retbool = true;
										 var kor_check = /[a-zA-Z][a-zA-Z0-9\\-\\.\\+\\_]+/;
										 if (!kor_check.test(val)){
											 retbool = false;
										 }
										return retbool;
									}
								</aui:validator>
							</aui:input>
							<p style="color: red;">※ <liferay-ui:message key='edison-appstore-solver-nm-save-not-modify' /></p>
						</c:when>
						<c:otherwise>
							<input name="name" value="${data.name}" type="text" class="long_field" readonly="readonly"/>
						</c:otherwise>
					</c:choose>
				</td>
				<th><liferay-ui:message key='version' /><span class="requiredField">*</span></th>
				<td>
					<c:choose>
						<c:when test="${empty scienceAppId}">
							<aui:input name="version" type="text" cssClass="short_field" label="" value="" placeholder="ex) 1.0.0" >
								<aui:validator name="required"/>
								<aui:validator  name="custom"  errorMessage="<%=exceptionVersionMsg%>">
									function (val, fieldNode, ruleValue) {
										 var retbool = true;
										 var kor_check = /[1-9][0-9]*[.](0|[1-9][0-9]*)[.](0|[1-9][0-9]*)$/;
										 if (!kor_check.test(val)){
											 retbool = false;
										 }
										return retbool;
									}
								</aui:validator>
							</aui:input>
						</c:when>
						<c:otherwise>
							<input name="<portlet:namespace/>version" value="${data.version}" type="text" class="short_field" readonly="readonly"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th><liferay-ui:message key='edison-content-service-language' /><span class="requiredField"> *</span></th>
				<td colspan="3">
					<aui:select name="targetLanguage" label="" >
						<option value=""><liferay-ui:message key='full' /></option>
						<%
						for(Locale aLocale : locales){
							String languageId = LocaleUtil.toLanguageId(aLocale);
							if(localesStr.equals("")){
								localesStr += languageId;
							}else{
								localesStr += ","+languageId;
							}
							
							String languageNm =aLocale.getDisplayName(themeDisplay.getLocale());
						%>
							<aui:option label="<%=languageNm%>" value="<%=languageId%>"/>
						<%} %>
					</aui:select>
				</td>
			</tr>
			<tr>
				<th>
					<liferay-ui:message key='edison-table-list-header-app-title' /><span class="requiredField"> *</span>
				</th>
				<td colspan="3">
					<liferay-ui:input-localized name="title" xml="${data.title}" cssClass="too_long_field"  type="input"/>
				</td>
			</tr>
			<c:if test="${swTest}">
				<tr>
					<th rowspan="${fn:length(parentCategoryList)+1}">
						<liferay-ui:message key='edison-science-appstore-view-tab-category' /><span class="requiredField"> *</span>
						
					</th>
					
				</tr>
				<c:forEach items="${parentCategoryList}" var="parentCategory">
					<tr>
						<td id="<portlet:namespace/>${parentCategory.value}_parentTd" colspan="3">
							<span id="<portlet:namespace/>${parentCategory.value}_parent_open" style="cursor: pointer;" onclick="<portlet:namespace/>openRootCategory('OPEN','${parentCategory.value}');">${parentCategory.name}(OPEN)</span>
							<span id="<portlet:namespace/>${parentCategory.value}_parent_close" style="cursor: pointer;display: none;" onclick="<portlet:namespace/>openRootCategory('CLOSE','${parentCategory.value}');">${parentCategory.name}(CLOSE)</span>
						</td>
						<td colspan="2" id="<portlet:namespace/>${parentCategory.value}_childrenTd" style="display: none;">
							<c:set value="${parentCategory.value}" var="parentCategoryValue"/>
							<c:forEach items="${childrenCategoryGroupMap[parentCategoryValue]}" var="childrenCategory">
								<c:set value="${parentCategory.value}_${childrenCategory.value}_Children_Category" var="childrenCategoryName"/>
								<aui:input name="childrenCategory" id="${childrenCategoryName}" label="${childrenCategory.name}" value="${parentCategory.value}_${childrenCategory.value}" type="checkbox"/>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<th><liferay-ui:message key='edison-virtuallab-owner' /></th>
				<td colspan="3">
					<c:choose>
						<c:when test="${mode == 'add'}">
							<aui:input name="now_userScreenName" type="text" value="${userScreenName}" label="" cssClass="short_field" readonly="readonly"/>
						</c:when>
						<c:otherwise>
							<input id="<portlet:namespace/>now_userScreenName" name="<portlet:namespace/>now_userScreenName" type="text" value="${data.userScreenName}" style="width: 120px;" readonly="readonly"/>
							
							<c:if test="${mode eq 'update' && ownerThan }">
								<input id="<portlet:namespace/>userScreenName_owner" name="<portlet:namespace/>userScreenName_owner" type="text" maxlength="15" placeholder="<liferay-ui:message key='edison-table-list-header-userid' />" style="margin-bottom:0px;" onkeypress="<portlet:namespace/>onKeyDown('owner');"/>
								<input id="search_button"  name="<portlet:namespace />search_button" type="button" class="button01b" value="<liferay-ui:message key='edison-appstore-solver-transfer' />" onClick="<portlet:namespace/>getUserInfo('owner')"/>
							</c:if>
						</c:otherwise>
					</c:choose>
					
				</td>
			</tr>
			<tr>
				<th><liferay-ui:message key='developer' /></th>
				<td colspan="3">
					<liferay-ui:input-localized name="developers" xml="${data.developersTextArea}" type="textarea" cssClass="text_field" placeholder="<%=textAreaPlaceholder%>"/>
				</td>
			</tr>
			<tr>
				<th><liferay-ui:message key='descriptive' /></th>
				<td colspan="3">
					<aui:select name="descriptionLanuage" label="" onChange="changeDescriptionLocale(this.value);">
						
					</aui:select>
					<%
						for(Locale aLocale : locales){
							String languageId = LocaleUtil.toLanguageId(aLocale);
							String descriptionKey = "description_"+languageId;
				    %>
				    	
				    	<c:set var="descriptionKey" value="<%=descriptionKey%>"></c:set>
				    	<div id="<portlet:namespace/>descriptionDiv_<%=languageId%>" style="display: none;">
				    		<textarea id="<portlet:namespace/>description_<%=languageId%>" name="<portlet:namespace/>description_<%=languageId%>" style="width:100%;height:300px;">
				    			${data.description[descriptionKey] }
				    		</textarea>
				    	</div>
				    <%
						}
				    %>
				</td>
			</tr>
			<tr>
				<th><liferay-ui:message key='icon' /></th>
				<td colspan="3">
					<input type="file" id="<portlet:namespace/>app_icon" name="<portlet:namespace/>app_icon">
					<c:if test="${data.iconId ne null}">
						<div class="down_date appIconClass"  onclick="<portlet:namespace/>fileDownload('${data.iconId }')" style="cursor: pointer;display: inline-block;">
							${data.iconTitle}
						</div>
						<img src='${contextPath}/images/icon_dustbin.png' class="appIconClass" width='13' height='14' style="cursor:pointer" onClick="<portlet:namespace/>deleteFile('${data.iconId}','appIcon','appIconClass');" />
					</c:if>
					<div id="clear"></div>
				</td>
			</tr>
			<tr>
				<th rowspan="<%=locales.length+1%>"><liferay-ui:message key='edison-table-list-header-manual' /></th>
			</tr>
				<%for(Locale aLocale : locales){
					String languageId = LocaleUtil.toLanguageId(aLocale);
					String languageNm =aLocale.getDisplayName(themeDisplay.getLocale());
					String manualId = "manualId_"+languageId;
					String manualTitle = "manualTitle_"+languageId;
				%>
					<tr>
						<td colspan="3">
							<%=languageNm%>&nbsp;&nbsp;<input type="file" id="<portlet:namespace/>app_manual<%=languageId%>" name="<portlet:namespace/>app_manual<%=languageId %>"><br/>
							<c:set value="<%=manualId%>" var="manualId"/>
							<c:if test="${data[manualId] ne null}">
								<c:set value="<%=manualTitle%>" var="manualTitle"/>
								
								<div class="down_date appManualClass_<%=languageId%>"  onclick="<portlet:namespace/>fileDownload('${data[manualId]}')" style="cursor: pointer;display: inline-block;">
									${data[manualTitle]}
								</div>
								<img src='${contextPath}/images/icon_dustbin.png' class="appManualClass_<%=languageId%>" width=13 height=14 style="cursor:pointer"
								onClick="<portlet:namespace/>deleteFile('${data[manualId]}','appManual','appManualClass_<%=languageId%>','<%=languageId%>');"/>
							</c:if>
						</td>
					</tr>
				<%} %>
			<tr>
				<th><liferay-ui:message key='edison-appstore-license' /></th>
				<td colspan="3">
					<aui:input name="license" type="text" value="${data.license}" label="" cssClass="long_field" size="40"/>
				</td>
			</tr>
		</table>
	</aui:form>
	
	
	<c:if test="${!empty scienceAppId && ownerThan }">
		<div class="virtitlebox">
			<img src="${contextPath}/images/title_virtual.png" width="20" height="20" />
			<div class="virtitle">
				<liferay-ui:message key='edison-appstore-solver-manager' />
			</div>
			<div class="search01">
				<div class="searchbox01">
					<form id="userSearchManagerForm" name="userSearchManagerForm" method="post" onsubmit="return false;">
						<input id="<portlet:namespace/>type" name="<portlet:namespace/>type" type="hidden" value="manager"  />
						<input id="<portlet:namespace/>scienceAppId" name="<portlet:namespace/>scienceAppId" type="hidden" value="${scienceAppId}" />
						<input id="<portlet:namespace/>userScreenName_manager" name="<portlet:namespace/>userScreenName_manager" type="text" maxlength="15" placeholder="<liferay-ui:message key='edison-table-list-header-userid' />" style="margin-bottom:0px;" onkeypress="<portlet:namespace/>onKeyDown('manager');"/>
						<input type="button" class="btnsearch" value="" onclick="<portlet:namespace/>getUserInfo('manager');">
					</form>
				</div>
			</div>
		</div>
		
		<div class="h10"></div>
		<div class="table1_list">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<colgroup>
					<col width="10%" />
					<col width="20%" />
					<col width="20%" />
					<col width="20%" />
					<col width="15%" />
					<col width="15%" />
				</colgroup>
				<thead>
					<tr>
						<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
						<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-userid' /></th>
						<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-usernm' /></th>
						<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-email' /></th>
						<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-date' /></th>
						<th align="center" scope="col"><liferay-ui:message key='edison-button-board-delete' /></th>
					</tr>
				</thead>
				<tbody id="<portlet:namespace/>appManagerListBody">
				</tbody>
			</table>
		</div>
		
	</c:if>
</div>



<div id="<portlet:namespace/>app-manager-add-dialog" title="<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-manager-register' />" class="newWindow" style="display:none; background-color:white; padding:0px;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle"><liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-manager-register' /></div>
		</div>
		<div class="newWclose" style="cursor: pointer;">
			<img id="app-manager-add-dialog-close-btn" name="app-manager-add-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="25" height="25" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<div style="padding: 30px;" class="newWcont01">
		<form id="managerAddForm" name="managerAddForm" method="post" action="<%=appManagerAddURL%>" > 
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
							<td colspan="2"  style="text-align: center; color:#f03030;"><liferay-ui:message key='edison-appstore-solver-manager-register-confirm' /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<input id="<portlet:namespace/>managerUserId" name="<portlet:namespace/>managerUserId" type="hidden">
			<input id="<portlet:namespace/>scienceAppId" name="<portlet:namespace/>scienceAppId" type="hidden" value="${scienceAppId}">
			<div style="text-align:center;">
				<input id="register_request_button" name="<portlet:namespace />register_request_button" class="yellowbtn" type="button" value="<liferay-ui:message key='edison-button-register' />" onclick="<portlet:namespace/>addAppManager()"/>
			</div>
		</form>
	</div>
</div>


<div id="<portlet:namespace/>app-owner-add-dialog" title="<liferay-ui:message key='edison-appstore-solver-owner-change' />" class="newWindow" style="display:none; background-color:white; padding:0px;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle"><liferay-ui:message key="edison-appstore-solver-owner-change"/></div>
		</div>
		<div class="newWclose" style="cursor: pointer;">
			<img id="app-owner-add-dialog-close-btn" name="app-owner-add-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="25" height="25" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<div style="padding: 30px;" class="newWcont01">
		<form id="ownerUpdateForm" name="ownerUpdateForm" method="post" action="<%=appOwnerUpdateURL%>" > 
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
						<tr>
							<td colspan="2"  style="text-align: center; color:#f03030;"><liferay-ui:message key='edison-appstore-solver-owner-register-confirm' /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<input id="<portlet:namespace/>ownerUserId" name="<portlet:namespace/>ownerUserId" type="hidden">
			<input id="<portlet:namespace/>pre_userScreenName" name="<portlet:namespace/>pre_userScreenName" type="hidden">
			<input id="<portlet:namespace/>scienceAppId" name="<portlet:namespace/>scienceAppId" type="hidden" value="${scienceAppId}">
			<div style="text-align:center;">
				<input id="register_request_button" name="<portlet:namespace />register_request_button" class="yellowbtn" type="button" value="<liferay-ui:message key='edison-button-register' />" onclick="<portlet:namespace/>updateAppOwner()"/>
			</div>
		</form>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function () {
		<portlet:namespace/>setCKeditor();
	});

	<%
	if(mode.equals(Constants.UPDATE)){
	%>
		$(document).ready(function () {
			changeCategory('${data.parentCategory}','${data.childrenCategory}');
			changeLanguage('${data.targetLanguage}');
			<portlet:namespace/>appManagerList();
			
			
			$("#<portlet:namespace/>app-manager-add-dialog").dialog({
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
			
			$("#app-manager-add-dialog-close-btn").click(function() {
				$("#<portlet:namespace/>app-manager-add-dialog").dialog("close");
			});
			
			
			
			$("#<portlet:namespace/>app-owner-add-dialog").dialog({
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
			
			$("#app-owner-add-dialog-close-btn").click(function() {
				$("#<portlet:namespace/>app-owner-add-dialog").dialog("close");
			});
		});
	<%}%>
	function <portlet:namespace/>setCKeditor(){
		var fileBrowserConectorURL = "<%=connectorURL%>";
		fileBrowserConectorURL = fileBrowserConectorURL +"&currentFolder=${currentFolder}";
		var ckEditorLanguage = "<%=doasLocale%>";
		CKEDITOR.config.autoParagraph = false;
		CKEDITOR.config.tabSpaces = 0;
		var localeStr = "<%=localesStr%>";
		var localeArray = localeStr.split(",");
		$descriptionSelect = $("#<portlet:namespace/>descriptionLanuage");
		
		for(var i=0; i< localeArray.length; i++){
			var locale = localeArray[i];
			CKEDITOR.replace( '<portlet:namespace/>description_'+locale, {
				filebrowserImageBrowseUrl: "/edison-appstore-2016-portlet/editor/ckeditor/filemanger/browser.html?Connector="+fileBrowserConectorURL,
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
			
			var option = $("<option/>").val(locale).text(Liferay.Language.get(locale)).appendTo($descriptionSelect);
			
			if(locale==Liferay.ThemeDisplay.getLanguageId()){
				$("#<portlet:namespace/>descriptionDiv_"+locale).show();
				option.prop("selected",true);
			}
			
			
		}
	}
	function changeDescriptionLocale(selectLocaleId){
		$("div[id*=<portlet:namespace/>descriptionDiv_]").hide();
		$("#<portlet:namespace/>descriptionDiv_"+selectLocaleId).show();
	}
	
	function <portlet:namespace/>actionCall(mode){
		if(mode=='<%=Constants.ADD%>'){
			//앱제목 Validation
			$targetLanguage = $("#<portlet:namespace/>targetLanguage option:selected");
			var lanuageCode = $targetLanguage.val();
			
			if(lanuageCode==""){
				var id = "<portlet:namespace/>title_" + lanuageCode;
				
				var localeStr = "<%=localesStr%>";
				var localeArray = localeStr.split(",");
				
				for(var i=0; i< localeArray.length; i++){
					var id = "<portlet:namespace/>title_" + localeArray[i];
					var inputValue = $("input[name="+id+"]").val();
					if(inputValue == "" || inputValue == undefined){
						alert(Liferay.Language.get('edison-error-another-language-alret-message'));
						$("#<portlet:namespace/>title").focus();
						return false;
					}
				}
			}else{
				var id = "<portlet:namespace/>title_" + lanuageCode;
				var inputValue = $("input[name="+id+"]").val();
				if(inputValue == "" || inputValue == undefined){
					alert(Liferay.Language.get('edison-error-another-language-alret-message'));
					$("#<portlet:namespace/>title").focus();
					return false;
				}
			}
			
			if(<%=swTest%>){
				if( $(":checkbox[name*='childrenCategoryCheckbox']:checked").length==0 ){
					alert(Liferay.Language.get('edison-science-appstore-category-error'));
					return false;
				}
			}
			<portlet:namespace/>frm.encoding = "multipart/form-data";
			$("input[name=<portlet:namespace/>childrenCategory]").prop("disabled",true);
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
	
	function changeLanguage(val){
		var $tLanguage = $("select[id='<portlet:namespace/>targetLanguage']");
		if(val.indexOf(",")>-1){
			$tLanguage.val("");
		}else{
			$tLanguage.val(val);
		}
		
	}
	
	function changeCategory(parentCategory,childrenCategory){
		var childrenArray = childrenCategory.split(',');
		var parentCategoryId = "";
		var parentCategoryArray = new Array();
		for(var i=0; i< childrenArray.length; i++){
			$("input:checkbox[value="+childrenArray[i]+"]").attr("checked",true);
		}
		
		var parentArray = parentCategory.split(',');
		for(var i=0; i< parentArray.length; i++){
			<portlet:namespace/>openRootCategory("OPEN",parentArray[i]);
		}
	}
	
	function <portlet:namespace/>openRootCategory(status,rootCatogoryId) {
		$parentTd = $("#<portlet:namespace/>"+rootCatogoryId+"_parentTd");
		$childrenTd = $("#<portlet:namespace/>"+rootCatogoryId+"_childrenTd");
		
		var hiddenSpan;
		var showSpan;
		if(status=="OPEN"){
			hiddenSpan = $("#<portlet:namespace/>"+rootCatogoryId+"_parent_open");
			showSpan 	= $("#<portlet:namespace/>"+rootCatogoryId+"_parent_close");
			
			$parentTd.removeAttr("colspan");
			$childrenTd.show();
		}else{
			hiddenSpan = $("#<portlet:namespace/>"+rootCatogoryId+"_parent_close");
			showSpan 	= $("#<portlet:namespace/>"+rootCatogoryId+"_parent_open");
			
			$parentTd.attr("colspan","3");
			$childrenTd.hide();
		}
		
		hiddenSpan.hide();
		showSpan.show();
	}
	
	function <portlet:namespace/>appManagerList() {
		
		var dataForm = {
				"<portlet:namespace/>scienceAppId" : "${scienceAppId}"
		};
		
		jQuery.ajax({
			type: "POST",
			url: "<%=appManagerListURL%>",
			async : false,
			data : dataForm,
			success: function(msg) {
				var appManagerList = msg.appManagerList;
				
				var rowResult;
				$("#<portlet:namespace/>appManagerListBody tr:not(:has(#1))").remove();
				
				if(appManagerList.length == 0) {
					$rowResult = $("<tr/>");
					$("<td/>").attr("colspan", "6")
							  .css("text-align","center")
							  .text(Liferay.Language.get('edison-there-are-no-data'))
							  .appendTo($rowResult);
					$("#<portlet:namespace/>appManagerListBody").append($rowResult);
				} else {
					for(var i = 0; i < appManagerList.length; i++) {
						$rowResult = $("<tr/>");
						
	 					if(i%2 == 1){
	 						$rowResult.addClass("tablebgtr");
	 					}
						
						$("<td/>").text(i+1)
								  .css("text-align","center")
								  .appendTo($rowResult);
						$("<td/>").text(appManagerList[i].userScreenName)
								  .css("text-align","center")
								  .appendTo($rowResult);
						$("<td/>").text(appManagerList[i].userFullName)
								  .css("text-align","center")
								  .appendTo($rowResult);
						$("<td/>").text(appManagerList[i].userEmailAddress)
								  .css("text-align","center")
								  .appendTo($rowResult);
						$("<td/>").text(appManagerList[i].createDate)
								  .css("text-align","center")
								  .appendTo($rowResult);
						
							$("<td/>").html("<input type='button' value='<liferay-ui:message key='edison-button-board-delete' />' onClick='<portlet:namespace/>deleteAppManager("+appManagerList[i].scienceAppManagerId+");' class='button01b' />")
									  .addClass("TC")
									  .appendTo($rowResult);
						
						$("#<portlet:namespace/>appManagerListBody").append($rowResult);
					}
				}
			},error:function(msg,e){ 
				alert("function appManagerList "+e);
				return false;
			}
		});
	}
	
	
	function <portlet:namespace/>deleteAppManager(scienceAppManagerId) {
		var con = confirm('<liferay-ui:message key="edison-science-appstore-toolkit-delete-solver-manager" />');
		
		if(con){
			var dataForm = {
					"<portlet:namespace/>scienceAppManagerId" : scienceAppManagerId
				};
				
				jQuery.ajax({
					type: "POST",
					url: "<%=deleteAppAuthURL%>",
					async : false,
					data : dataForm,
					success: function(msg) {
						<portlet:namespace/>appManagerList();
					},error:function(msg,e){ 
						alert("function deleteAppManager "+e);
						return false;
					}
				});
		}else{
		return;
		}
	}
	
	function <portlet:namespace/>getUserInfo(role) {
		
		if(role == 'owner'){
			var pre = $("#<portlet:namespace/>now_userScreenName").val();
			var post = $("#<portlet:namespace/>userScreenName_owner").val();
			if( pre == post ){
				alert("<liferay-ui:message key='edison-appstore-fail-owner' />")
				return false;
			}
			//현재아이디와 입력아이디가 같은경우 제외
			var data = {
					<portlet:namespace/>type : "owner",
					<portlet:namespace/>scienceAppId : "${scienceAppId}",
					<portlet:namespace/>now_userScreenName : "${data.userScreenName}",
					<portlet:namespace/>userScreenName_owner : post
			}
			
			jQuery.ajax({
				type: "POST",
				url: "<%=appUserInfoURL%>",
				async : false,
				data :  data,
				success: function(msg) {
					var result = msg.result;
					var appUserInfo = msg.appUserInfo;
					if(result === undefined) {
						alert("user not found");
					} else if(result == "none") {
						alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-user-notfound' />");
					}else{
						$("#ownerId").text(appUserInfo.userScreenName);
						$("#ownerFullName").text(appUserInfo.userFullName);
						$("#ownerEmail").text(appUserInfo.userEmailAddress);
						$("#<portlet:namespace/>ownerUserId").val(appUserInfo.userId);
						$("#<portlet:namespace/>pre_userScreenName").val("${data.userId}");
						$("#<portlet:namespace/>app-owner-add-dialog").dialog("open");
					}
				},error:function(msg,e){ 
					alert("function getUserInfo "+e);
					return false;
				}
			});
		}else if(role == 'manager'){
			jQuery.ajax({
				type: "POST",
				url: "<%=appUserInfoURL%>",
				async : false,
				dataType: 'json',
				data : $("#userSearchManagerForm").serialize(),
				success: function(msg) {
					var result = msg.result;
					var appUserInfo = msg.appUserInfo;
					if(result === undefined) {
						alert("user not found");
					} else if(result == "admin") {
						alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-admin-alert' />");
					} else if(result == "owner" || result == "manager") {
						alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-admin-already' />");
					} else if(result == "none") {
						alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-user-notfound' />");
					} else if(result == "notdeveloper") {
						alert("<liferay-ui:message key='edison-appstore-workspace-permission-alert' />");
					} else if(result == "user") {
						$("#managerId").text(appUserInfo.userScreenName);
						$("#managerFullName").text(privateTextConverter2(appUserInfo.userFullName));
						$("#managerEmail").text(privateEmailConverter2(appUserInfo.userEmailAddress));
						$("#<portlet:namespace/>managerUserId").val(appUserInfo.userId);
						$("#<portlet:namespace/>app-manager-add-dialog").dialog("open");
					}
				},error:function(msg,e){ 
					alert("function getUserInfo "+e);
					return false;
				}
			});
		}
	}
	
	function <portlet:namespace/>onKeyDown(role) {
		if(role == 'owner'){
			if(event.keyCode == 13 && $("#<portlet:namespace/>userScreenName_owner").val() != ""){
				var pre = $("#<portlet:namespace/>now_userScreenName").val();
				var post = $("#<portlet:namespace/>userScreenName_owner").val();
				if( pre == post ){
					alert("<liferay-ui:message key='edison-appstore-fail-owner' />")
					return false;
				}
				<portlet:namespace/>getUserInfo('owner');
			}
		}if(role == 'manager'){
			if(event.keyCode == 13 && $("#<portlet:namespace/>userScreenName_manager").val() != ""){
				<portlet:namespace/>getUserInfo('manager');
			}
		}
	}
	
	function <portlet:namespace/>addAppManager(){
		
		var dataForm = $("form[name=managerAddForm]").serialize();
		
		jQuery.ajax({
			type: "POST",
			url: "<%= appManagerAddURL %>",
			async : false,
			data : dataForm,
			success: function(msg) {
				<portlet:namespace/>appManagerList();
			},error:function(msg,e){ 
				alert("function addAppManager "+e);
				return false;
			}
		});
		$("#<portlet:namespace/>userScreenName_manager").val("");
		$("#<portlet:namespace/>app-manager-add-dialog").dialog("close");
	}
	
	function <portlet:namespace/>updateAppOwner(){
		var dataForm = $("form[name=ownerUpdateForm]").serialize();
		
		jQuery.ajax({
			type: "POST",
			url: "<%= appOwnerUpdateURL%>",
			async : false,
			data : dataForm,
			success: function(msg) {
				<portlet:namespace/>goList();
			},error:function(msg,e){ 
				alert("function updateAppOwner "+e);
			}
		});
	}
</script>
<aui:script use="aui-base,node-event-simulate">
	var updateLanguageFlag = function(event) {
		var target = event.target;
		var selectedValue = target.val();
		if(selectedValue!=""){
			A.one('li.palette-item[data-value="'+selectedValue+'"] > a').simulate('click');
		}
	};

	A.all('#<portlet:namespace/>targetLanguage').each(
		function(item) {
			if (item) {
				item.on('change', updateLanguageFlag);
			}
		}
	);	
</aui:script>

