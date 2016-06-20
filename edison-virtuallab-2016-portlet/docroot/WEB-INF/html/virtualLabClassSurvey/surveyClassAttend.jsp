<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:resourceURL var="getSurveyAttendURL" id="getSurveyAttend" copyCurrentRenderParameters="false" />

<liferay-portlet:renderURL var="surveyVoteURL" copyCurrentRenderParameters="false" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
	<liferay-portlet:param name="myaction" value="surveyVote"/>
	<liferay-portlet:param name="virtualLabId" value="${classInfo.virtualLabId}"/>
	<liferay-portlet:param name="classId" value="${classInfo.classId}"/>
	<liferay-portlet:param name="surveyDivCd" value="SVY_03_002"/>
	<liferay-portlet:param name="surveyStatus" value="SVY_01_003"/>
</liferay-portlet:renderURL>

<style type="text/css">
.edison .button01b {
	padding: 3px 7px;
}
</style>

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList();
	var surveyCount = "${surveyCount}";
	if(surveyCount > 0) {
		$("#<portlet:namespace/>display").css("display", "block");
	} else {
		$(".portlet-borderless-container").css("min-height", "0");
	}
});

function <portlet:namespace/>dataSearchList() {
	var dataForm = {
			"<portlet:namespace/>virtualLabId" : "${classInfo.virtualLabId}",
			"<portlet:namespace/>classId" : "${classInfo.classId}"
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getSurveyAttendURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var surveyAttend = msg.surveyAttend;
			var role = msg.role;
			var attend = msg.attend;
			
			var rowResult;
			$("#<portlet:namespace/>surveyListBody tr:not(:has(#1))").remove();
			
			if(surveyAttend.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "3")
						  .css("text-align","center")
						  .css("height", "40px")
						  .text("<liferay-ui:message key='edison-virtuallab-ongoing-survey' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>surveyListBody").append($rowResult);
			} else {
				for(var i = 0; i < surveyAttend.length; i++) {
					$rowResult = $("<tr/>");
					
					$("<td/>").text(surveyAttend[i].surveyTitle)
							  .css("text-align","left")
							  .css("padding-left","50px")
							  .appendTo($rowResult);
					if(surveyAttend[i].surveyStartDate == "" || surveyAttend[i].surveyEndDate == "") {
						$("<td/>").text("<liferay-ui:message key='edison-virtuallab-survey-no-deadline' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					}else {
						$("<td/>").text(surveyAttend[i].surveyStartDate + " ~ " + surveyAttend[i].surveyEndDate)
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					
					if (role == "STUDENT" && surveyAttend[i].surveyCheck <= 0) {
						$("<td/>").append(
								  $("<input/>").attr("type","button")
								  			   .attr("name","<portlet:namespace/>surveySeqNo")
								  			   .addClass("button01b")
								  			   .attr("value","<liferay-ui:message key='edison-virtuallab-participate-in-survey' />")
								  			   .attr("onclick","surveyVote('" + surveyAttend[i].surveySeqNo + "');")
								  )
								  .css("text-align","center")
								  .css("padding-left","50px")
								  .appendTo($rowResult);
					} else if (role == "STUDENT" && surveyAttend[i].surveyCheck > 0){
						$("<td/>").text("<liferay-ui:message key='edison-virtuallab-complete-in-survey' />")
								  .css("text-align","center")
								  .css("padding-left","50px")
								  .appendTo($rowResult);
					} else if (role == "ADMIN" || role == "MANAGER") {
						$("<td/>").append(
								  $("<input/>").attr("type","button")
											   .addClass("button01b")
								  			   .attr("name","<portlet:namespace/>surveySeqNo")
								  			   .attr("value","<liferay-ui:message key='edison-virtuallab-view-survey' />")
								  			   .attr("onclick","surveyVote('" + surveyAttend[i].surveySeqNo + "');")
								  )
								  .css("text-align","center")
								  .css("padding-left","50px")
								  .appendTo($rowResult);
					} else {
						$("<td/>").text("")
						  .css("text-align","center")
						  .css("padding-left","50px")
						  .appendTo($rowResult);
					}
					
					$("#<portlet:namespace/>surveyListBody").append($rowResult);
				}
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function surveyVote(surveySeqNo) {
	window.location.href = "<%=surveyVoteURL%>&classId=${classInfo.classId}&<portlet:namespace/>surveySeqNo="+surveySeqNo;
}

</script>
<div id="<portlet:namespace/>display" style="display:none;">
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-virtuallab-survey' />
		</div>
	</div>
	
	<div class="h10"></div>
	
	<div class="table1_list" style="display: inline-block; margin-bottom: 10px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<colgroup>
				<col width="60%" />
				<col width="25%" />
				<col width="15%" />
			</colgroup>
			<tbody id="<portlet:namespace/>surveyListBody">
			</tbody>
		</table>
	</div>
</div>
