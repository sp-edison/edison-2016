<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="h30"></div>
<div style="text-align: right; margin: 5px;">
	<input id="<portlet:namespace/>virtualLabCalssCreateBtn" name="<portlet:namespace/>virtualLabCalssCreateBtn" type="button" class="button06" value="<liferay-ui:message key="edison-virtuallab-surveyResultList-survey-registration" />" onClick="<portlet:namespace/>insertSurvey('SVY_03_002')"/>
</div>
<div class="table6_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="5%" />
			<col width="55%" />
			<col width="10%" />
			<col width="20%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key="edison-table-list-header-index" /></th>
				<th align="center" scope="col"><liferay-ui:message key="edison-virtuallab-surveyResultList-survey-title" /></th>
				<th align="center" scope="col"><liferay-ui:message key="edison-table-list-header-date" /></th>
				<th align="center" scope="col"><liferay-ui:message key="edison-virtuallab-surveyResultList-survey-period" /></th>
				<th align="center" scope="col"><liferay-ui:message key="edison-virtuallab-surveyResultList-survey-result" /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>managementListBody">
		</tbody>
	</table>
	
	<div id="<portlet:namespace/>spaceDiv" align="center"></div>
	<div id="<portlet:namespace/>pageListDiv" style="text-align: center;"></div>
</div>

<script type="text/javascript">
function <portlet:namespace/>dataSearchList(curPage) {
	var dataForm = {
		"<portlet:namespace/>curPage" : curPage,
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getListSurveyURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var surveyList = msg.surveyList;
			var curPage = msg.curPage;
			var selectLine = msg.selectLine;
			var totalCnt = msg.totalCnt - ((curPage -1) * selectLine);
			var pageList = msg.pageList;
			
			var rowResult;
			$("#<portlet:namespace/>managementListBody tr:not(:has(#1))").remove();
			if(surveyList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "6")
						  .css("text-align","center")
						  .css("height", "40px")
						  .html("<p><liferay-ui:message key='edison-there-are-no-data' /></p>")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>managementListBody").append($rowResult);
			} else {
				for(var i = 0; i < surveyList.length; i++) {
					$rowResult = $("<tr/>").attr("onClick", "<portlet:namespace/>surveyView('" + surveyList[i].surveySeqNo + "')")
										   .css("cursor","pointer");
 					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
 					
					$("<td/>").text(totalCnt--)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(surveyList[i].surveyTitle)
							  .css("text-align","left")
							  .appendTo($rowResult);
					$("<td/>").text(surveyList[i].surveyCreateDate)
							  .css("text-align","center")
							  .appendTo($rowResult);
					if (surveyList[i].surveyStartDate == "" || surveyList[i].surveyEndDate == "") {
						$("<td/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-no-deadline' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else {
						$("<td/>").text(surveyList[i].surveyStartDate + " ~ " + surveyList[i].surveyEndDate)
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					$("<td/>").append($("<input/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>surveyResult('" + surveyList[i].surveySeqNo + "');")
												   .attr("type", "button")
												   .attr("value", "<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-result' />")
												   .addClass("button01b")
							  )
							  .css("text-align","center")
							  .css("cursor","pointer")
							  .appendTo($rowResult);
					$("#<portlet:namespace/>managementListBody").append($rowResult);
				}
			}
			$("#<portlet:namespace/>pageListDiv").html(pageList);
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>surveyView(surveySeqNo){
	window.location.href = "<%=surveyViewURL%>&<portlet:namespace/>surveySeqNo="+surveySeqNo;
}

function <portlet:namespace/>insertSurvey(surveyDivCd) {
	window.location.href = "<%=surveyInsertViewURL%>&<portlet:namespace/>surveyDivCd="+surveyDivCd;
}

function <portlet:namespace/>surveyResult(surveySeqNo) {
	window.location.href = "<%=surveyResultViewURL%>&<portlet:namespace/>surveySeqNo="+surveySeqNo;
}

<portlet:namespace/>dataSearchList(1);
</script>