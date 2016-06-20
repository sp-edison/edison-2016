<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
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
		<div class="newWtitlebox">
			<div class="newWtitle"></div>
		</div>
		<div class="newWclose">
			<img id="site-leave-owner-view-dialog-close-btn" name="site-leave-owner-view-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<div class="newWcont01" style="height:500px; overflow-y:auto">
		<span style="color:red;font-size: 15px;font-weight: bold;">※ <liferay-ui:message key="edison-default-site-leave-owner-text"/><br/></span>
		<br>
		<div style="margin-bottom: 5px;float: right;">
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table1 borderno" style="word-break: break-all;">
			<colgroup>
				<col width="100px" />
				<col width="250px" />
			</colgroup>
			<tbody id="generalFileListTableBody">
				<tr class="puptrline tablebgtr">
					<th scope="col"><liferay-ui:message key="edison-table-list-header-file"/></th>
					<th scope="col" class="left"><liferay-ui:message key="edison-table-list-header-title"/></th>
				</tr>
				<c:forEach var="app" items="${scienceAppOwnerList }" varStatus="status">
					<tr>
						<td  class="TC">
							APP
						</td>
						<td>
							${app.title }
						</td>
					</tr>	
				</c:forEach>
				<c:forEach var="content" items="${contentOwnerList }" varStatus="status">
					<tr>
						<td  class="TC">
							Content
						</td>
						<td>
							${content.title }
						</td>
					</tr>	
				</c:forEach>
				<c:forEach var="lab" items="${virtualLabOwnerList }" varStatus="status">
					<tr>
						<td  class="TC">
							Virtual Lab
						</td>
						<td>
							${lab.virtualLabTitle }
						</td>
					</tr>	
				</c:forEach>
				<c:forEach var="classowner" items="${virtualClassOwnerList }" varStatus="status">
					<tr>
						<td  class="TC">
							Virtual Class
						</td>
						<td>
							${classowner.classTitle }
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		</div>
</div>
<script type="text/javascript">

AUI().ready(function() {
	$("#site-leave-owner-view-dialog-close-btn").click(function() {
		$("#site-leave-owner-view-dialog").dialog("close");
	});
	
});


</script>