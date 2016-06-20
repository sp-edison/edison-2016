<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="h30"></div>
<div class="tabletopbox">
	<form id="searchForm" name="searchForm" method="post" onsubmit="return false;">
		<input id="<portlet:namespace/>groupId" name="<portlet:namespace/>groupId" type="hidden" value="<%= tabs1 %>"/>
		<input id="<portlet:namespace/>curPage" name="<portlet:namespace/>curPage" type="hidden" value="1"/>
		<div class="search">
			<div class="searchbox">
				<input id="<portlet:namespace/>searchField" name="<portlet:namespace/>searchField" type="text" maxlength="20" placeholder="<liferay-ui:message key='edison-virtuallab-placeholder' />" onKeypress="<portlet:namespace/>onKeyDown(event);" />
				<input id="search_button" name="search_button" type="button" class="btnsearch"  onClick="<portlet:namespace/>dataSearchList()"/>
			</div>
			<input id="total_search_button" name="total_search_button" type="button" value="<liferay-ui:message key='edison-button-all-search' />" class="button01"  onClick="<portlet:namespace/>dataSearchList(0)" />
		</div>
		<div class="tabletopright" style="right: 150px;">
			<select id="<portlet:namespace/>surveySeqNo" name="<portlet:namespace/>surveySeqNo" title="option" onchange="<portlet:namespace/>dataSearchList(0)" class="selectview">
				<c:if test="${null eq surveySelectList}">
					<option value="0"><liferay-ui:message key='edison-virtuallab-surveyResultList-no-data' /></option>
				</c:if>
				<c:if test="${null ne surveySelectList}">
					<c:forEach items="${surveySelectList}" var="survey">
						<c:choose>
							<c:when test="${survey.surveySeqNo eq surveySeqNo}">
								<option value=${survey.surveySeqNo} selected>${survey.surveyTitle}</option>
							</c:when>
							<c:otherwise>
								<option value=${survey.surveySeqNo}>${survey.surveyTitle}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach> 
				</c:if>
			</select>
		</div>
		<div class="tabletopright">
			<select id="<portlet:namespace/>linePerPage" name="<portlet:namespace/>linePerPage" title="option" onchange="<portlet:namespace/>dataSearchList(0)" class="selectview">
				<option value="10">10<liferay-ui:message key='edison-search-views' /></option>
				<option value="20">20<liferay-ui:message key='edison-search-views' /></option>
				<option value="30">30<liferay-ui:message key='edison-search-views' /></option>
				<option value="40">40<liferay-ui:message key='edison-search-views' /></option>
			</select>
		</div>
	</form>
</div>

<div style="text-align: right; margin: 5px;">
	<input id="<portlet:namespace/>surveyResultGroupBtn" name="<portlet:namespace/>surveyResultGroupBtn" type="button" class="button06" value="<liferay-ui:message key="edison-virtuallab-surveyResultList-group" />" onClick="<portlet:namespace/>searchGroupSurveyResult();"/>
</div>

<div class="table1_list borderno">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="7%" />
			<col width="18%" />
			<col width="14%" />
			<col width="12%" />
			<col width="6%" />
			<col width="18%" />
			<col width="16%" />
			<col width="8%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-virtuallab' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-affiliate' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-professor' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-running' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-virtualclass' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-answer-period' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-surveyResultList-survey-result' /><br/><liferay-ui:message key='edison-virtuallab-surveyResultList-participation-all' /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>surveyResultListBody">
		</tbody>
	</table>
	
	<div id="<portlet:namespace/>spaceDiv" align="center"></div>
	<div id="<portlet:namespace/>pageListDiv" class="paging"></div>
</div>

<script type="text/javascript">
function <portlet:namespace/>dataSearchList(curPage) {
	
	if(curPage == 0) {
		$("#<portlet:namespace/>curPage").val(1);
		$("#<portlet:namespace/>searchField").val("");
	} else {
		$("#<portlet:namespace/>curPage").val(curPage);
	}
	
	var searchForm = $("form[name=searchForm]").serialize();
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getListSurveyResultURL%>",
		async : false,
		data : searchForm,
		success: function(msg) {
			var surveyResultList = msg.surveyResultList;
			var curPage = msg.curPage;
			var selectLine = msg.selectLine;
			var totalCnt = msg.totalCnt - ((curPage -1) * selectLine);
			var pageList = msg.pageList;
			var rowResult;
			var row;
			
			var tempVirtualLabId = 0;
			var classCount = 1;
			var labAnswerCount = 0;
			var labStudentCount = 0;
			var labStatistics = 0;
			
			$("#<portlet:namespace/>surveyResultListBody tr:not(:has(#1))").remove();
			if(surveyResultList === undefined || surveyResultList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "8")
						  .css("height", "40px")
						  .css("text-align","center")
						  .html("<p><liferay-ui:message key='edison-virtuallab-surveyResultList-no-data-result' /></p>")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>surveyResultListBody").append($rowResult);
			} else {
				for(var i = 0; i < surveyResultList.length; i++) {
					if((tempVirtualLabId != surveyResultList[i].virtualLabId) && i != 0) {
						labStatistics++;
						$rowResult = $("<tr/>");
						$("<td/>").attr("colspan", "7")
								  .css("text-align","right")
								  .append($("<p/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-total' />" + " : ")
										  		   .css("margin-bottom", "20px")
										  		   .css("font-size", "16px"))
								  .appendTo($rowResult);
						$("<td/>").css("text-align","center")
								  .append($("<p/>").text("(" + labAnswerCount + "/" +labStudentCount + ")")
										  		   .css("margin-bottom", "20px")
										  		   .css("font-size", "16px"))
								  .appendTo($rowResult);
						$("#<portlet:namespace/>surveyResultListBody").append($rowResult);
						
						labAnswerCount = 0;
						labStudentCount = 0;
					}
					labAnswerCount += surveyResultList[i].answerCount;
					labStudentCount += surveyResultList[i].userTotalCount;
					
					$rowResult = $("<tr/>");
 					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
 					if(tempVirtualLabId != surveyResultList[i].virtualLabId) {
						$("<td/>").text(totalCnt--)
								  .css("text-align","center")
								  .appendTo($rowResult);
						$("<td/>").text(surveyResultList[i].virtualLabTitle)
								  .css("text-align","center")
								  .appendTo($rowResult);
						$("<td/>").text(surveyResultList[i].virtualLabUniversityFieldNm)
								  .css("text-align","center")
								  .appendTo($rowResult);
						$("<td/>").text(surveyResultList[i].virtualLabPersonName)
								  .css("text-align","center")
								  .appendTo($rowResult);
						if(surveyResultList[i].surveyCheck > 0) {
							$("<td/>").text("O")
									  .css("text-align","center")
									  .appendTo($rowResult);
						} else {
							$("<td/>").text("X")
									  .css("text-align","center")
									  .appendTo($rowResult);
						}
						$("<td/>").text(surveyResultList[i].classTitle)
								  .css("text-align","center")
								  .appendTo($rowResult);
						if(surveyResultList[i].answerCount > 0) {
							$("<td/>").text(surveyResultList[i].voteStartDate + " ~ " + surveyResultList[i].voteEndDate)
									  .css("text-align","center")
									  .appendTo($rowResult);
														   <!-- (" + surveyResultList[i].answerCount + "/" + surveyResultList[i].userTotalCount + ") -->
							$("<td/>").append($("<input/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>surveyResult('" + surveyResultList[i].surveySeqNo + "','" + surveyResultList[i].classId + "');")
														   .attr("type", "button")
														   .attr("value", "<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-result' />")
														   .addClass("button01b")
									  )
									  .append( $("<p/>").text("(" + surveyResultList[i].answerCount + "/" + surveyResultList[i].userTotalCount + ")")
									  )
									  .css("text-align","center")
									  .css("padding","8px")
									  .css("cursor","pointer")
								  	  .appendTo($rowResult);
						} else {
							$("<td/>").text("")
									  .css("text-align","center")
									  .appendTo($rowResult);
							$("<td/>").append($("<p/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-no-result' />")
									  )
									  .append($("<p/>").text("(" + surveyResultList[i].answerCount + "/" + surveyResultList[i].userTotalCount + ")")
									  )
									  .css("text-align","center")
									  .appendTo($rowResult);
						}
					} else {
						$("<td/>").text(surveyResultList[i].classTitle)
								  .css("text-align","center")
								  .appendTo($rowResult);
						if(surveyResultList[i].answerCount > 0) {
							$("<td/>").text(surveyResultList[i].voteStartDate + " ~ " + surveyResultList[i].voteEndDate)
									  .css("text-align","center")
									  .appendTo($rowResult);
							$("<td/>").append($("<input/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>surveyResult('" + surveyResultList[i].surveySeqNo + "','" + surveyResultList[i].classId + "');")
														   .attr("type", "button")
														   .attr("value", "<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-result' />")
														   .addClass("button01b")
														   <!-- (" + surveyResultList[i].answerCount + "/" + surveyResultList[i].userTotalCount + ") -->
									  )
									  .append( $("<p/>").text("(" + surveyResultList[i].answerCount + "/" + surveyResultList[i].userTotalCount + ")")
									  )
									  .css("text-align","center")
									  .css("cursor","pointer")
								  	  .appendTo($rowResult);
						} else {
							$("<td/>").text("")
									  .css("text-align","center")
									  .appendTo($rowResult);
							$("<td/>").append($("<p/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-no-result' />")
									  )
									  .append($("<p/>").text("(" + surveyResultList[i].answerCount + "/" + surveyResultList[i].userTotalCount + ")")
									  )
									  .css("text-align","center")
									  .appendTo($rowResult);
						}
 					}
					$("#<portlet:namespace/>surveyResultListBody").append($rowResult);
					
					if(tempVirtualLabId == surveyResultList[i].virtualLabId) {
						classCount++;
					} else {
						if(i != 0) {
							$row = $("tbody tr:eq(" + (i - classCount + labStatistics - 1) + ")");
							$row.children("td:eq(0)").attr("rowspan", classCount);
							$row.children("td:eq(1)").attr("rowspan", classCount);
							$row.children("td:eq(2)").attr("rowspan", classCount);
							$row.children("td:eq(3)").attr("rowspan", classCount);
							$row.children("td:eq(4)").attr("rowspan", classCount);
							classCount = 1;
						}
						tempVirtualLabId = surveyResultList[i].virtualLabId;
					}
				}
				
				$row = $("tbody tr:eq(" + (i - classCount + labStatistics) + ")");
				$row.children("td:eq(0)").attr("rowspan", classCount);
				$row.children("td:eq(1)").attr("rowspan", classCount);
				$row.children("td:eq(2)").attr("rowspan", classCount);
				$row.children("td:eq(3)").attr("rowspan", classCount);
				$row.children("td:eq(4)").attr("rowspan", classCount);
				
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "7")
						  .css("text-align","right")
						  .append($("<p/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-total' />" + " : ")
								  		   .css("margin-bottom", "20px")
								  		   .css("font-size", "16px"))
						  .appendTo($rowResult);
				$("<td/>").css("text-align","center")
						  .append($("<p/>").text("(" + labAnswerCount + "/" + labStudentCount + ")")
								  		   .css("margin-bottom", "20px")
								  		   .css("font-size", "16px"))
						  .appendTo($rowResult);
				$("#<portlet:namespace/>surveyResultListBody").append($rowResult);
			}
			$("#<portlet:namespace/>pageListDiv").html(pageList);
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}


function <portlet:namespace/>surveyResult(surveySeqNo, classId) {
	window.location.href = "<%=surveyResultViewURL%>&<portlet:namespace/>surveySeqNo=" + surveySeqNo + "&<portlet:namespace/>classId=" + classId + "&<portlet:namespace/>tabs1=" + "<%= tabs1 %>";
}

function <portlet:namespace/>searchGroupSurveyResult() {
	var surveySeqNo = $("#<portlet:namespace/>surveySeqNo").val();
	var url = "<%=surveyResultViewURL%>&<portlet:namespace/>surveySeqNo="+ surveySeqNo +"&<portlet:namespace/>tabs1=" + "<%= tabs1 %>";
	window.location.href = url;
}



function <portlet:namespace/>onKeyDown(e){
	if(e.keyCode == 13){
		<portlet:namespace/>dataSearchList();
		return false;
	}
} 

<portlet:namespace/>dataSearchList(1);
</script>