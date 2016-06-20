<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>

<liferay-portlet:renderURL var="sentEmailListURL" portletMode='view'>
</liferay-portlet:renderURL>

<head>

</head>
<body>
	<h1>Email</h1>
	
	<div class="table1_list">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed;">
			<colgroup>
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
			</colgroup>
			<thead>
				<tr>
					<th><liferay-ui:message key="edison-email-sendCount"/></th>
					<th><liferay-ui:message key="edison-email-successCount"/></th>
					<th><liferay-ui:message key="edison-email-failCount"/></th>
					<th><liferay-ui:message key="edison-email-name"/></th>
					<th><liferay-ui:message key="edison-email-sendDate"/></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="TC left">${sendMailContent.sendCount }</td>
					<td class="TC left">
						${sendMailContent.successCount }
					</td>
					<td class="TC left">${sendMailContent.failCount }</td>
					<td class="TC left">${mailSender}</td>
					<td class="TC left"><fmt:formatDate value="${sendMailContent.sendDate }" pattern="yyyy-MM-dd"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="h30"></div>
	<div class="table1_list">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed;">
			<colgroup>
				<col width="20%" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th><liferay-ui:message key='edison-virtuallab-tablerow-site' /></th>
					<td class="TC left">
						<c:forEach var="siteGroup" items="${siteGroupList}" varStatus="status">
							${siteGroup.name }<c:if test="${! status.last }">,&nbsp;</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th><liferay-ui:message key="edison-email-userGroup"/></th>
					<td class="TC left">
						<c:forEach var="userGroup" items="${userGroupList}" varStatus="status">
							${userGroup.name }<c:if test="${! status.last }">,&nbsp;</c:if>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
	</div>	
	<div class="h30"></div>
	<div class="table1_list">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed;">
			<tbody>
				<tr class="tablebgtr01">
					<td class="title"><liferay-ui:message key="edison-table-list-header-title"/> : ${sendMailContent.title}</td>
				</tr>
				<tr>
					<td style="vertical-align: top; height: 320px;">${sendMailContent.content}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="buttonbox">
		<input type="button" id="scienceAppstoreListBtn" class="button02" value="<liferay-ui:message key='edison-button-board-list' />" onclick="<portlet:namespace/>goList();"/>
	</div>
</body>

<script type="text/javascript">

$(document).ready(function(){
	
});

function <portlet:namespace/>goList(){
	var listUrl="<%=sentEmailListURL%>";
	location.href= listUrl+"&<portlet:namespace/>listSize=${listSize }&<portlet:namespace/>currentPage=${currentPage }&<portlet:namespace/>searchValue=${searchValue}";
}

</script>
