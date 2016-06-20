<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>


<div style="margin-bottom : 30px; padding-right:45px;">
	<div class="noticetit">
		System Resource Statistics
	</div>
	<div class="table0_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th width="20%">Site</th>
				<th width="20%">Cluster</th>
				<th width="15%">Total</th>
				<th width="15%">Used</th>
				<th width="15%">Avail</th>
			</tr>
			<c:choose>
				<c:when test="${!empty clusterList}">
					<c:set var="siteTemp" value="0" />
					<c:forEach items="${clusterList}" var="model">
						<c:if test="${siteTemp ne model.siteName }">
							<tr>
								<td class="TC" rowspan="${model.clusterCount}"><liferay-ui:message key='${model.siteName}'/></td>
								<td class="TC">${model.clusterName}</td>
								<td class="TC">${model.total}</td>
								<td class="TC">${model.used}</td>
								<td class="TC">${model.avail}</td>
							</tr>
						</c:if>
						<c:if test="${siteTemp eq model.siteName }">
							<tr>
								<td class="TC">${model.clusterName}</td>
								<td class="TC">${model.total}</td>
								<td class="TC">${model.used}</td>
								<td class="TC">${model.avail}</td>
							</tr>
						</c:if>
						<c:set var="siteTemp" value="${model.siteName}" />
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5" style="text-align: center;">
							<liferay-ui:message key='edison-there-are-no-data'/>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</div>
<script type="text/javascript">

</script>
