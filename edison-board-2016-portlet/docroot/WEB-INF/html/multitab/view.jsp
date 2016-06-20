<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<c:set var="layout_plid" value="<%=String.valueOf(plid)%>" />

<div class="contabmenuZ">
	<div class="contabbrd">
		<div class="contabbrdL"><img src="${contextPath}/images/subtab_brdL.jpg" width="11" height="56" /></div>
		<div class="contabbrdC">
			<div class="table4">
				<table width="1198" height="56" border="0" cellpadding="0" cellspacing="0" >
					<tr>
						<c:forEach items="${tabList}" var="tabMap" varStatus="status">
							<c:if test="${tabMap.tabPlid eq layout_plid}">
								<c:if test="${tabMap.tabType eq 'URL'}">
									<td class="brdmon" style="cursor:pointer;" onclick="javascript:window.open('${tabMap.tabURL}','_blank');">${tabMap.tabTitle}</td>
								</c:if>
								<c:if test="${tabMap.tabType ne 'URL'}">
									<td class="brdmon" style="cursor:pointer;" onclick="javascript:window.location.href='${tabMap.tabURL}'; return false;">${tabMap.tabTitle}</td>
								</c:if>
								<c:if test="${not status.last }">
									<td><img src="${contextPath}/images/subtab_brddvd.png" width="3" height="24" /></td>
								</c:if>
							</c:if>
							<c:if test="${tabMap.tabPlid ne layout_plid}">
								<c:if test="${tabMap.tabType eq 'URL'}">
									<td class="brdm" style="cursor:pointer;" onclick="javascript:window.open('${tabMap.tabURL}','_blank');">${tabMap.tabTitle}</td>
								</c:if>
								<c:if test="${tabMap.tabType ne 'URL'}">
									<td class="brdm" style="cursor:pointer;" onclick="javascript:window.location.href='${tabMap.tabURL}'; return false;">${tabMap.tabTitle}</td>
								</c:if>
								<c:if test="${not status.last }">
									<td><img src="${contextPath}/images/subtab_brddvd.png" width="3" height="24" /></td>
								</c:if>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>
		</div>
		<div class="contabbrdR"><img src="${contextPath}/images/subtab_brdR.jpg" width="11" height="56" /></div>                                   
	</div>	
</div>
