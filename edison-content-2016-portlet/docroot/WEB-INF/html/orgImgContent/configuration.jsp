<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%
	String groupId = String.valueOf(request.getAttribute("groupId"));
	String update = LanguageUtil.format(locale, "edison-content-update", "");
%>
<liferay-portlet:actionURL var="modifyOrgImgScroll" portletConfiguration="true"/>

<style type="text/css">
	.tDnD_whileDrag {
		background-color:  #E0E0E0;
	}
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
	
	.aui .icon-edison{
		font-family: fontawesome-alloy;
		display: inline;
	}
	
	.aui .icon-edison.icon-picture:before{
		content: "\F03E";
		font-size: 2em;
	}
</style>
<div style="width: 70%;margin: 0 auto;">
	<aui:form action="<%= modifyOrgImgScroll %>" method="post" name="modifyOption">
		<aui:input name="groupId" type="hidden" value="<%=groupId%>"/>
		<aui:input name="myaction" type="hidden" value="modifyOption"/>
		
		<div class="h2">Image Scroll File option Settings</div>
		<div class="table1_list">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="20%" class="title1">items</td>
					<td width="80%">
						<aui:input label="items?" value="${items}" name="items" type="text" helpMessage="edison-imgscroll-help-message-items">
							<aui:validator name="required"/>
							<aui:validator name="number"/>
						</aui:input>
					</td>
				</tr>
				<tr>
					<td width="20%" class="title1">autoPlay</td>
					<td width="80%">
						<aui:input label="autoPlay?" value="${autoPlay}" name="autoPlay" type="text" helpMessage="edison-imgscroll-help-message-autoPlay">
							<aui:validator name="required"/>
							<aui:validator name="number"/>
						</aui:input>
					</td>
				</tr>
				<tr>
					<td width="20%" class="title1">rewindSpeed</td>
					<td width="80%">
						<aui:input label="rewindSpeed?" value="${rewindSpeed}" name="rewindSpeed" type="text" helpMessage="edison-imgscroll-help-message-rewindSpeed">
							<aui:validator name="required"/>
							<aui:validator name="number"/>
						</aui:input>
					</td>
				</tr>
			</table>
		</div>
		<div class="popupbtnGroup" style="margin-top: 5px;">
			<aui:input label="" name="content_submit" type="submit" cssClass="graybtn" value="<%=update%>"/>
		</div>
	</aui:form>
	
	<div class="h20"></div>
	<div class="h2">Image Scroll File List</div>
	<aui:form action="<%=modifyOrgImgScroll%>" method="post" name="modifyFileList">
		<aui:input name="groupId" type="hidden" value="<%=groupId%>"/>
		<aui:input name="myaction" type="hidden" value="modifyFileList"/>
		<aui:input name="mode" type="hidden" value="<%=Constants.UPDATE%>"/>
		<aui:input name="orgImgSeq" type="hidden" value=""/>
		<aui:input name="fileEntryId" type="hidden" value=""/>
		<aui:input name="order" type="hidden" value=""/>
		<div class="table1_list">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="Image Scroll File List">
				<colgroup>
					<col width="70" />
					<col width="70" />
					<col width="350" />
					<col width="*" />
					<col width="70" />
				</colgroup>
				<thead>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-index"/></th>
					<th scope="col">&nbsp;</th>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-orgNm"/></th>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-orgLink"/></th>
					<th scope="col">&nbsp;</th>
				</thead>
				<tbody id="dndBody">
					<c:choose>
						<c:when test="${!empty orgImgContnetList}">
							<c:forEach items="${orgImgContnetList}" var="model" varStatus="data">
								<tr id="${model.orgImgSeq}_row">
									<td class="tc">${model.order}</td>
									<td>
										<i class="icon-edison icon-picture"></i>
										<aui:input name="${model.orgImgSeq}_row_nOrder" type="hidden" value=""/>
									</td>
									<td>
										<aui:input label="" name="${model.orgImgSeq}_orgNm" type="text" value="${model.orgNm}">
											<aui:validator name="required"/>
										</aui:input>
									</td>
									<td>
										<aui:input label="" name="${model.orgImgSeq}_orgLink" cssClass="long_field" type="text" value="${model.orgLink}">
											<aui:validator name="required"/>
										</aui:input>
									</td>
									<td class="tc">
										<input type="button" class="button02" value="<liferay-ui:message key="edison-button-board-delete"/>" onclick="<portlet:namespace/>deleteContent('${model.orgImgSeq}','${model.fileEntryId}','${model.order}');"/>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5" class="tc"><liferay-ui:message key='edison-there-are-no-data'/></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div class="popupbtnGroup" style="margin-top: 5px;">
			<aui:input label="" name="content_submit" type="submit" cssClass="graybtn" value="<%=update%>"/>
		</div>
	</aui:form>
	
	
	<div class="h20"></div>
	<div class="h2">Image Scroll File Add</div>
	<aui:form action="<%=modifyOrgImgScroll%>" method="post" name="modifyFileAdd" enctype="multipart/form-data">
		<aui:input name="groupId" type="hidden" value="<%=groupId%>"/>
		<aui:input name="myaction" type="hidden" value="modifyFileAdd"/>
		<div class="table1_list">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="20%" class="title1"><liferay-ui:message key="edison-table-list-header-orgNm"/></td>
					<td width="80%">
						<aui:input label="" name="orgNm" type="text">
							<aui:validator name="required"/>
						</aui:input>
					</td>
				</tr>
				<tr>
					<td width="20%" class="title1"><liferay-ui:message key="edison-table-list-header-orgLink"/></td>
					<td width="80%">
						<aui:input label="" name="orgLink" type="text" cssClass="long_field">
							<aui:validator name="required"/>
						</aui:input>
					</td>
				</tr>
				<tr>
					<td width="20%" class="title1"><liferay-ui:message key="edison-table-list-header-file"/></td>
					<td width="80%">
						<aui:input label="" name="orgFileImg" cssClass="edison_file" type="file" value="">
							<aui:validator name="required"/>
							<aui:validator name="acceptFiles">'jpg,png,gif,jpeg'</aui:validator>
						</aui:input>
					</td>
				</tr>
			</table>
		</div>
		<div class="popupbtnGroup" style="margin-top: 5px;">
			<aui:input label="" name="content_submit" type="submit" cssClass="graybtn" value="<%=update%>"/>
		</div>
	</aui:form>
</div>
<script src="/edison-content-2016-portlet/js/tableDnD/jquery.tablednd.js"></script>
<script type="text/javascript">
$("#dndBody").tableDnD({
	onDrop:function(table,row){
		var rows = table.rows;
		$form = $("#<portlet:namespace/>modifyFileList");
		for (var i=0; i<rows.length; i++) {
			$newOrder = $form.find("#<portlet:namespace/>"+rows[i].id+"_nOrder");
			$newOrder.val(i+1);
		}
	}
});


function <portlet:namespace/>deleteContent(imgSeq,fileEntryId,order){
	if(!confirm("Delete Content?")) return;
	$form = $("#<portlet:namespace/>modifyFileList");
	$form.find("#<portlet:namespace/>mode").val("<%=Constants.DELETE%>");
	$form.find("#<portlet:namespace/>orgImgSeq").val(imgSeq);
	$form.find("#<portlet:namespace/>fileEntryId").val(fileEntryId);
	$form.find("#<portlet:namespace/>order").val(order);
	$form.submit();
}
</script>
