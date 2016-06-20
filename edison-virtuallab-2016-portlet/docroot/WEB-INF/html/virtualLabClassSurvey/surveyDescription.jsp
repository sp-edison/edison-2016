<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%
	String surveyError = CustomUtil.strNull(request.getAttribute("surveyError"));
	if(CustomUtil.strNull(surveyError).equals("Y")){
		out.print("<script>alert('<liferay-ui:message key='edison-virtuallab-no-survey' />'); self.close()();</script>");
		return;
	}
%>

<liferay-portlet:resourceURL var="surveyQuestionListURL" id="surveyQuestionList" />

<liferay-portlet:renderURL var="surveyVoteURL" copyCurrentRenderParameters="false" windowState="<%=LiferayWindowState.NORMAL.toString() %>" />

<script>

$(document).ready(function () {		
	var surveySeqNo = "${surveyMap.surveySeqNo}";
	surveySetting(surveySeqNo);
});

function surveySetting(surveySeqNo){
	
	jQuery.ajax({
		type: "POST",
		url: "<%=surveyQuestionListURL%>",
		async : false,
		data  : {"surveySeqNo" : surveySeqNo},
		success: function(data) {	    			
			var dataMap = eval('(' + data + ')');
			$questionTable = $("#<portlet:namespace/>questionTable");
			$questionTable.empty();		
			if(dataMap.dataList.length==0){
				
				$questionTable.append('<tr><td colspan=7><liferay-ui:message key='edison' /></td></tr>');
				
			}else{
				
				for(var i = 0 ; i < dataMap.dataList.length; i++ ){
					var num = i+1;									
					$trNode = $("<tr/>");
					$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-survey' /> "+num+"</th>").appendTo($trNode);					
					$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-question-title' /></th>").appendTo($trNode);					
					$("<td/>").addClass("question").attr("colspan", "3").text(dataMap.dataList[i].questionTitle).appendTo($trNode);
					$questionTable.append($trNode);	
					if(dataMap.dataList[i].questionDivCd == "SVY_02_001"){
						var rowCnt = 1;
						if(dataMap.dataList[i].question1 != null && dataMap.dataList[i].question1 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 1"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question1)).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question2 != null && dataMap.dataList[i].question2 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 2"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question2)).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question3 != null && dataMap.dataList[i].question3 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 3"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question3)).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question4 != null && dataMap.dataList[i].question4 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 4"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question4)).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question5 != null && dataMap.dataList[i].question5 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 5"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question5)).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question6 != null && dataMap.dataList[i].question6 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 6"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question6)).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question7 != null && dataMap.dataList[i].question7 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 7"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question7)).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question8 != null && dataMap.dataList[i].question8 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 8"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question8)).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question9 != null && dataMap.dataList[i].question9 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 9"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question9)).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question10 != null && dataMap.dataList[i].question10 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 10"))
									  .append($("<td/>").attr("colspan", "3").text(dataMap.dataList[i].question10)).appendTo($questionTable);
							rowCnt++;
						}	
						
						$trNode.find("th:first").attr("rowspan", rowCnt);
						
					}else if(dataMap.dataList[i].questionDivCd == "SVY_02_002"){
						$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer' /> "))
						  .append($("<td/>").attr("colspan", "3").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-short-answer' />" + " " + "<liferay-ui:message key='edison-virtuallab-surveyResultList-answer' />")).appendTo($questionTable);
						$trNode.find("th:first").attr("rowspan", "2");
					}
											
				}			
			}
			
		},error:function(data,e){ 
			alert(e);				
			return false;
		}
	});
}

function historyback(){
	window.location.href = "<%= surveyVoteURL%>&classId=${classId}";	
}

</script>
<h1>
	<liferay-ui:message key='edison-virtuallab-survey' />
</h1>

<div class="table1_list" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
		<colgroup>
			<col width="15%" />
			<col width="75%" />
		</colgroup>
		<tr>
			<th><liferay-ui:message key='edison-virtuallab-surveyResultList-survey-title2' /></th>
			<td>
				${surveyMap.surveyTitle}
			</td>					
		</tr>
	</table>
</div>

<div class="table1_list" style="border-top: 0px;">
	<table id="questionTable" width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
		<colgroup>
			<col width="15%" />
			<col width="10%" />
			<col width="60%" />
			<col width="10%" />
		</colgroup>
		<tbody id="<portlet:namespace/>questionTable">
		</tbody>
	</table>
</div>
<div style="height: 15px;"></div>
<div style="text-align: right; margin-top: 10px;">
	<input type="button" class="button0801" onclick="historyback()" value="<liferay-ui:message key='cancel' />" />
</div>
