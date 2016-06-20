<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>

<liferay-portlet:resourceURL var="developerRequestStatusURL" id="developerRequestStatus" copyCurrentRenderParameters="false" />

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList();
	
	var display = "${display}";
	if(display == "VIEW") {
		$("#<portlet:namespace/>display").css("display", "block");
	} else {
		$(".portlet-borderless-container").css("min-height", "0");
	}
});

function <portlet:namespace/>dataSearchList() {
	var dataForm = {
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=developerRequestStatusURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var developerStatus = msg.developerStatus;
			
			var rowResult;
			$("#<portlet:namespace/>developerInfomationBody tr:not(:has(#1))").remove();
			
			if(developerStatus.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "9")
						  .css("text-align","center")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>developerInfomationBody").append($rowResult);
			} else {
				for(var i = 0; i < developerStatus.length; i++) {
					$rowResult = $("<tr/>");
					
					$("<td/>").text(developerStatus[i].groupName)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(developerStatus[i].developerSort)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(developerStatus[i].developerId)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(developerStatus[i].developerPassword)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(developerStatus[i].requestDate)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(developerStatus[i].useStart)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(developerStatus[i].useEnd)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(developerStatus[i].requestStatus)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(developerStatus[i].processNote)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("#<portlet:namespace/>developerInfomationBody").append($rowResult);
				}
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

</script>

<div id="<portlet:namespace/>display" style="display:none;" >
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-appstore-developer-request-info' />
		</div>
	</div>
	
	<div class="h10"></div>
	
	<div class="table7_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<colgroup>
				<col width="9%" />
				<col width="12%" />
				<col width="12%" />
				<col width="12%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="15%" />
			</colgroup>
			<thead>
				<tr>
					<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-site' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-appstore-developer-request-purpose' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-userid' /></th>
					<th align="center" scope="col"><liferay-ui:message key='password' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-req-date' /></th>
					<th align="center" scope="col" colspan="2"><liferay-ui:message key='edison-appstore-developer-preferred-date' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-science-appstore-toolkit-change-processing-status' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-science-appstore-toolkit-change-result-of-management' /></th>
				</tr>
			</thead>
			<tbody id="<portlet:namespace/>developerInfomationBody">
			</tbody>
		</table>
	</div>
</div>