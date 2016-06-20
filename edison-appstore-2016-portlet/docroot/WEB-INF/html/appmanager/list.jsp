<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

<%@ page import="org.kisti.edison.science.Exception.ScienceAppException" %>
<%
	String searchSwNm = LanguageUtil.get(themeDisplay.getLocale(), "edison-appstore-solver-name");
	String searchSwTitle = LanguageUtil.get(themeDisplay.getLocale(), "edison-table-list-header-app-title");
	String searchOrgNm = LanguageUtil.get(themeDisplay.getLocale(), "edison-table-list-header-orgNm");
	String searchUserNm = LanguageUtil.get(themeDisplay.getLocale(), "edison-table-list-header-name");
	String searchAll = "("+searchSwTitle+"+"+searchSwNm+"+"+searchOrgNm+"+"+searchUserNm+")";
	
	
	//Tab Setting
	String tabNames = (String)request.getAttribute("tabNames");
	String listTabValue = CustomUtil.strNull(request.getAttribute("listTabValue"));
%>

<liferay-portlet:renderURL var="swTabSearchURL" portletMode='view'/>

<liferay-portlet:renderURL var="swSearchURL" portletMode='view'>
	<portlet:param name="tabValue" value="<%=listTabValue%>"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="solverRenderURL" copyCurrentRenderParameters="<%=true%>">	
	<portlet:param name="myRender" value="solverRender" />
</liferay-portlet:renderURL>

<c:choose>
	<c:when test="<%= SessionErrors.contains(renderRequest, ScienceAppException.class.getName()) %>">
		<%
			ScienceAppException sae = (ScienceAppException)SessionErrors.get(renderRequest, ScienceAppException.class.getName());
		%>
		<div class="alert alert-error">
			<c:if test="<%= sae.getType() == ScienceAppException.SCIENCE_APP_NO_AUTH%>">
				<liferay-ui:message key="edison-app-no-access-exception-msg" />
			</c:if>
		</div>
	</c:when>
	<c:otherwise>
		<style type="text/css">
			.aui .tabletopbox .radio{
				float:left;
				padding-right: 20px;
			}
			</style>
			
			<!-- 페이지 타이틀 & 네비게이션 -->
			<div class="contabmenu"> 
				<edison-ui:tabs names="<%=tabNames%>" url="<%=swTabSearchURL%>" tabsValues="owner_sw,manager_sw" value="<%=listTabValue%>" param="tabValue" minwidth="230"/>
			</div>
			
			<h1>
				<liferay-ui:message key='edison-appstore-sw-list' />
			</h1>
			
			<div class="tabletopbox">
				<div class="search">
					<div class="searchbox">
						<input type="text" id="<portlet:namespace/>searchValue" name="<portlet:namespace/>searchValue" value="${searchValue }" onKeydown="if(event.keyCode ==13)<portlet:namespace/>searchList();" autocomplete="off"/>
						<input type="button" onClick="<portlet:namespace/>searchList()" class="btnsearch" />
					</div>
					<input type="button" onClick="<portlet:namespace/>searchListAll()" class="button01" value="<liferay-ui:message key='edison-button-all-search' />" />
				</div>
				
				<div class="search_toggle" style="padding:7px;display:none;width:99%;height:100%;background-color: #FFFFFF;border: solid 2px #29547e;margin: 0 auto;color: #777;" >
					<fieldset class="group" style="padding-left: 20px;">
						<aui:input name="searchOption" type="radio" label="<%=searchAll%>" cssClass="searchoption" value="APP_MANAGER_SEARCH_ALL" checked="true"/>
						<aui:input name="searchOption" type="radio" label="<%=searchSwNm%>" cssClass="searchoption" value="SWNM" />
						<aui:input name="searchOption" type="radio" label="<%=searchSwTitle%>" cssClass="searchoption" value="SWTITLE"/>
						<aui:input name="searchOption" type="radio" label="<%=searchOrgNm%>" cssClass="searchoption" value="SWORGNM"/>
						<aui:input name="searchOption" type="radio" label="<%=searchUserNm%>" cssClass="searchoption" value="SWUSERNM"/>
					</fieldset>
				</div>
			</div>
			
			
			
			
			<div class="table0_list borderno" >	
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<thead>
						<tr style="word-break: break-word;">
							<th width="5%"><liferay-ui:message key='edison-table-list-header-index' /></th>
							<th width="10%"><liferay-ui:message key="edison-table-list-header-type" /></th>
							<th width="*"><liferay-ui:message key="edison-appstore-solver-name" />(<liferay-ui:message key="edison-table-list-header-app-title" />)</th>
							<th width="6%"><liferay-ui:message key='edison-virtuallab-version' /></th>
							<th width="15%"> 
								<select name="<portlet:namespace/>searchStatus" id="<portlet:namespace/>searchStatus" onChange="<portlet:namespace/>searchList()"  style="width:150px;">
									<option value=""><liferay-ui:message key='edison-virtuallab-confirm-status' /></option>
									<option value="1901001" <c:if test="${searchStatus == '1901001' }"> selected</c:if> ><liferay-ui:message key='edison-appstore-status-write' /></option>
									<option value="1901002" <c:if test="${searchStatus == '1901002' }"> selected</c:if> ><liferay-ui:message key='edison-appstore-status-request' /></option>
									<option value="1901003" <c:if test="${searchStatus == '1901003' }"> selected</c:if> ><liferay-ui:message key='edison-appstore-status-private' /></option>
									<option value="1901004" <c:if test="${searchStatus == '1901004' }"> selected</c:if> ><liferay-ui:message key='edison-appstore-status-service' /></option>
								</select>
							</th>
							<th width="20%"><liferay-ui:message key='edison-table-list-header-name' />(<liferay-ui:message key='edison-table-list-header-orgNm' />)</th>
							<th width="8%"><liferay-ui:message key='edison-appstore-last-modified' /></th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${!empty swEditorList }">
						<c:forEach items="${swEditorList}" var="editorMap" varStatus="status" >
							<c:choose>
								<c:when test="${status.last}">
									<tr style="word-break: break-all;cursor:pointer;border-bottom: 3pt solid #9393DC;" onClick="<portlet:namespace/>detailView('${editorMap.scienceAppId}');">
								</c:when>
								<c:otherwise>
									<tr style="word-break: break-all;cursor:pointer;" onClick="<portlet:namespace/>detailView('${editorMap.scienceAppId}');">
								</c:otherwise>
							</c:choose>
									<td class="TC">-</td>
									<td class="TC">${editorMap.appType}</td>
									<td style="text-align:left;">${editorMap.name}(${editorMap.title})</td>
									<td style="text-align:center;">${editorMap.version}</td>
									<td style="width: 155px;">
										<div>
											<c:choose>
												<c:when test="${editorMap.status=='1901001'}"><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_001_on.png" width="35" height="35" style="vertical-align: middle;"/></c:when>
												<c:otherwise><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_001_off.png" width="35" height="35" style="vertical-align: middle;"/></c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${editorMap.status=='1901002'}"><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_002_on.png" width="35" height="35" style="vertical-align: middle;"/></c:when>
												<c:otherwise><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_002_off.png" width="35" height="35" style="vertical-align: middle;"/></c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${editorMap.status=='1901003'}"><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_003_on.png" width="35" height="35" style="vertical-align: middle;"/></c:when>
												<c:otherwise><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_003_off.png" width="35" height="35" style="vertical-align: middle;"/></c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${editorMap.status=='1901004'}"><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_004_on.png" width="35" height="35" style="vertical-align: middle;"/></c:when>
												<c:otherwise><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_004_off.png" width="35" height="35" style="vertical-align: middle;"/></c:otherwise>
											</c:choose>
										</div>
									</td>
									<td style="text-align: left;">${editorMap.firstName}(${editorMap.affiliation})</td>
									<td style="text-align: center;">
										<fmt:formatDate pattern="yyyy-MM-dd"   value="${editorMap.modifiedDate}" />
									</td>
								</tr>
						</c:forEach>
					</c:if>
					
					<c:choose>
						<c:when test="${!empty swList}">
							<c:set value="${pageNum }" var="num"></c:set>
							<c:forEach items="${swList}" var="solverMap" varStatus="status" >
								<tr style="word-break: break-all;cursor:pointer;"
									<c:if test="${status.count%2 == 1}"> class="backgroundOdd" </c:if>
									onClick="<portlet:namespace/>detailView('${solverMap.scienceAppId}');"
								>
									<td class="TC">${num}</td>
									<td class="TC">${solverMap.appType}</td>
									<td style="text-align:left;">${solverMap.name}(${solverMap.title})</td>
									<td style="text-align:center;">${solverMap.version}</td>
									<td style="width: 155px;">
										<div>
											<c:choose>
												<c:when test="${solverMap.status=='1901001'}"><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_001_on.png" width="35" height="35" style="vertical-align: middle;"/></c:when>
												<c:otherwise><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_001_off.png" width="35" height="35" style="vertical-align: middle;"/></c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${solverMap.status=='1901002'}"><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_002_on.png" width="35" height="35" style="vertical-align: middle;"/></c:when>
												<c:otherwise><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_002_off.png" width="35" height="35" style="vertical-align: middle;"/></c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${solverMap.status=='1901003'}"><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_003_on.png" width="35" height="35" style="vertical-align: middle;"/></c:when>
												<c:otherwise><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_003_off.png" width="35" height="35" style="vertical-align: middle;"/></c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${solverMap.status=='1901004'}"><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_004_on.png" width="35" height="35" style="vertical-align: middle;"/></c:when>
												<c:otherwise><img src="${contextPath}/images/toolkit/<%=themeDisplay.getLanguageId() %>/TKT_01_004_off.png" width="35" height="35" style="vertical-align: middle;"/></c:otherwise>
											</c:choose>
										</div>
									</td>
									<td style="text-align: left;">${solverMap.firstName}(${solverMap.affiliation})</td>
									<td style="text-align: center;">
										<fmt:formatDate pattern="yyyy-MM-dd"   value="${solverMap.modifiedDate}" />
									</td>
									<c:set value="${num-1 }" var="num"></c:set>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="7" class="TC"><liferay-ui:message key='edison-there-are-no-data' /></td>
							</tr>
						</c:otherwise>
					</c:choose>
					</tbody>
				</table>
				<c:forEach begin="1" end="${20 - fn:length(swList) * 2}" step="1">
				<br>
				</c:forEach>	
			
				<div class="paging">${pagingStr}</div>
				<div class="buttonbox" style="position: absolute; bottom: 24px; width:auto; right:1%;">
					<input type="button" class="button0801" onClick="<portlet:namespace/>addApp('true');" value="<liferay-ui:message key='edison-appstore-sw-register' />" />
					<input type="button" class="button0801" onClick="<portlet:namespace/>addApp('');" value="<liferay-ui:message key='edison-appstore-sw-editor-register' />" />
				</div>
			</div>
			
			
			<script type="text/javascript">
			function <portlet:namespace/>addApp(swTest){
				var URL = "<%=solverRenderURL%>";
				
				if(swTest!=""){
					URL += "&<portlet:namespace/>swTest=true";
				}
				location.href=URL;
			}
			
				function <portlet:namespace/>detailView(scienceAppId){
					var URL = "<%=solverRenderURL%>&<portlet:namespace/>scienceAppId="+scienceAppId;
					location.href=URL;
				}
			
				function <portlet:namespace/>searchListAll(){
					$("#<portlet:namespace/>searchStatus").val("");
					$("#<portlet:namespace/>searchValue").val("");
					location.href="<%=swSearchURL %>"
				}
				
				function <portlet:namespace/>searchList(scienceAppId){
					var searchParameter = "";
					if($("#<portlet:namespace/>searchStatus").val()!=""){
						searchParameter += "&<portlet:namespace/>searchStatus="+$("#<portlet:namespace/>searchStatus").val();
					}
					
					if($("#<portlet:namespace/>searchValue").val()!=""){
						searchParameter += "&<portlet:namespace/>searchValue="+$("#<portlet:namespace/>searchValue").val();
			 			var searchOption_val = $(':radio[name="<portlet:namespace/>searchOption"]:checked').val();
			 			searchParameter += "&<portlet:namespace/>searchOption="+searchOption_val;
					}
					
					location.href="<%=swSearchURL %>"+searchParameter;
				}	
			
				function <portlet:namespace/>dataSearchList(p_curPage){
					var searchParameter = "&<portlet:namespace/>p_curPage="+p_curPage;
					
					if($("#<portlet:namespace/>solverStatus").val()!=""){
						searchParameter += "&<portlet:namespace/>solverStatus="+$("#<portlet:namespace/>solverStatus").val();
					}
					
					if($("#<portlet:namespace/>searchValue").val()!=""){
						searchParameter += "&<portlet:namespace/>searchValue="+$("#<portlet:namespace/>searchValue").val();
			 			var searchOption_val = $(':radio[name="<portlet:namespace/>searchOption"]:checked').val();
			 			searchParameter += "&<portlet:namespace/>searchOption="+searchOption_val;
					}
					
					location.href="<%=swSearchURL %>"+searchParameter;	
				}
				
				$(document).ready(function(){
					(function(jQuery) {
						jQuery.fn.<portlet:namespace/>clickoutside = function(callback) {
							var outside = 1, self = $(this);
								self.cb = callback;
								this.click(function() {
									outside = 0;
								});
							$(document).click(function() {
								outside && self.cb();
								outside = 1;
								});
							return $(this);
						}
					})(jQuery);
					
					$("#<portlet:namespace/>searchValue").focus(function(){
						if($(".search_toggle").is(":hidden")){
							$('.search_toggle').slideToggle('fast');
						}
					});
					
					$(".tabletopbox").<portlet:namespace/>clickoutside(function(){
						var search_val = $("#<portlet:namespace/>searchValue").val();
						if(search_val==""&&!$(".search_toggle").is(":hidden")){$('.search_toggle').slideToggle('fast');}
					});
				});
				
			
			</script>
	</c:otherwise>
</c:choose>
