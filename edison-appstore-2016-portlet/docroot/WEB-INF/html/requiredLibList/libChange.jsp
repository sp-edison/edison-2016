<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.kisti.edison.science.service.constants.RequiredLibConstants" %>
<%@ include file="/common/init.jsp" %>

<style type="text/css">
.aui input[type="text"], .aui select, .aui textarea{
	font-size: inherit;
}
.edison .box01{
	width: 100px;
	margin-right: 5px;
}

.edison .buttonGroup{
	margin-top: 10px;
	text-align: right;
}

</style>

<liferay-portlet:renderURL copyCurrentRenderParameters="false" var="libChangeRenderUrl" windowState="<%=LiferayWindowState.POP_UP.toString() %>">	
	<portlet:param name="myRender" value="libChangeRender"/>
</liferay-portlet:renderURL>

<head>
<title><liferay-ui:message key='edison-appstore-request' /></title>

</head>
<body>
	<form name="frm" method="POST" action="<%=libChangeRenderUrl%>">
		<input type="hidden" name="<portlet:namespace/>requiredLibId" value="${requiredLib.requiredLibId }">
		<input type="hidden" name="<portlet:namespace/>scienceAppId" value="${requiredLib.scienceAppId }">
		<input type="hidden" name="<portlet:namespace/>mode" value="">
		
		
		<div id="data_warp_popup">
			<div class="virtitlebox">
				<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
				<div class="virtitle">
					<liferay-ui:message key='edison-appstore-request-info' />
				</div>
			</div>
		
			<div style="height: 10px;clear: both;"></div>
			
			<div class="table1_list" >
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
				<colgroup>
					<col width="25%">
					<col width="*">
				</colgroup>
				<tr>
					<th><liferay-ui:message key='edison-appstore-solver-name' /></th>
					<td>
						${requiredLib.scienceAppName }
					</td>
				</tr>
				<tr>
					<th><liferay-ui:message key='edison-science-appstore-library-name' /></th>
					<td>
						${requiredLib.libraryName }
					</td>
				</tr>
				<tr>
					<th><liferay-ui:message key='edison-table-list-header-version' /></th>
					<td>
						${requiredLib.libraryVersion }
					</td>
				</tr>
				<tr>
					<th><liferay-ui:message key='edison-science-appstore-toolkit-change-request-date' /></th>
					<td>
						${requiredLib.requiredDate }
					</td>
				</tr>
				<tr height="120">
					<th><liferay-ui:message key='edison-science-appstore-toolkit-change-request-content' /></th>
					<td>
						${requiredLib.requiredContent }					
					</td>
				</tr>
				</table>
			</div>
			
			<div class="virtitlebox">
				<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
				<div class="virtitle">
					<liferay-ui:message key='edison-science-appstore-toolkit-change-result-of-management' />
				</div>
			</div>
		
			<div style="height: 10px;clear: both;"></div>
			
			<div class="table1_list" >
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >		
				<colgroup>
					<col width="25%">
					<col width="25%">
					<col width="28%">
					<col width="*">
				</colgroup>		
				
				<c:choose>
					<c:when test="${isAdministrator || isSiteAdministrator}">
						<tr>
							<th><liferay-ui:message key='edison-science-appstore-toolkit-change-processing-date' /></th>
							<td>${requiredLib.confirmDate }</td>
							<th><liferay-ui:message key='edison-science-appstore-toolkit-change-processing-status' /></th>
							<td>
								<c:set var="requiredState" value="<%=RequiredLibConstants.LIB_STATE_REQUIRE%>"></c:set>
								<c:set var="completeState" value="<%=RequiredLibConstants.LIB_STATE_COMPLETE%>"></c:set>
								<c:set var="rejectState" value="<%=RequiredLibConstants.LIB_STATE_REJECT%>"></c:set>
								<select name="<portlet:namespace/>changeStatus" style="width: 130px">
									<option value="${requiredState}" ${requiredLib.state eq requiredState ? 'selected' : '' }>
										<liferay-ui:message key="edison-science-appstore-library-require" /></option>
									<option value="${completeState}" ${requiredLib.state eq completeState ? 'selected' : '' }>
										<liferay-ui:message key="edison-science-appstore-library-complete" /></option>
									<option value="${rejectState}" ${requiredLib.state eq rejectState ? 'selected' : '' }>
										<liferay-ui:message key="edison-virtuallab-denial" /></option>
								</select>
							</td>
						</tr>
						<tr>
							<th><liferay-ui:message key='edison-virtuallab-confirm-info' /></th>
							<td colspan="3"> 
								<div class="localDiv">
									<textarea name="<portlet:namespace/>confirmContent" style="resize: none;width: 95%;height:75px;margin: 0px;" spellcheck="false">${requiredLib.confirmContent }</textarea>
								</div> 
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th><liferay-ui:message key='edison-science-appstore-toolkit-change-processing-date' /></th>
							<td>${requiredLib.confirmDate }</td>
							<th><liferay-ui:message key='edison-science-appstore-toolkit-change-processing-status' /></th>
							<td>
								<input type="hidden" name="<portlet:namespace/>changeStatus" value="${requiredLib.state }">
								${requiredLib.state }
							</td>
						</tr>
						<tr height="120">
							<th><liferay-ui:message key='edison-virtuallab-confirm-info' /></th>
							<td colspan="3">
								<div class="localDiv">
									${requiredLib.confirmContent }
								</div> 
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
				</table>   
			</div>  
		</div>
	</form>

	<div class="buttonGroup" style="margin:0px;">
		<c:choose>	
		<c:when test="${changeSeq == '' }">
			<input type="button" class="button0801" onclick="<portlet:namespace/>saveSubmit('SAVE')" value="<liferay-ui:message key='edison-virtuallab-save' />" />
		</c:when>
		<c:otherwise>
			<c:if test="${isAdministrator || isSiteAdministrator}">	
				<input type="button" class="button0801" onclick="<portlet:namespace/>saveSubmit('UPDATE')" value="<liferay-ui:message key='edison-virtuallab-save' />" />
				<input type="button" class="button0801" onclick="<portlet:namespace/>saveSubmit('DELETE')" value="<liferay-ui:message key='edison-button-board-delete' />" />
			</c:if>
		</c:otherwise>
		</c:choose>
	</div>
</body>

<script>
	function <portlet:namespace/>saveSubmit(p_mode){		
		frm.<portlet:namespace/>mode.value=p_mode;
		frm.submit();	
	}
		
	/************** ready   ***************/
	$(document).ready(function() {
	    var postMode = "${postMode}";

	    if(postMode == 'UPDATE'){
			opener.location.reload();
	    }
	    if(postMode == 'DELETE'){
	    	opener.location.reload();
	    	self.close();
	    }
	});
	/************** ready end   ***************/
	
</script>