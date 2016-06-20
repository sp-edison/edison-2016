<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:resourceURL var="surveyQuestionListURL" id="surveyQuestionList" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="surveyAnswerListURL" id="surveyAnswerList" copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="surveyExcelDownURL" id="surveyExcelDownLoad" copyCurrentRenderParameters="false">	
	<liferay-portlet:param name="surveySeqNo" value="${surveyMap.surveySeqNo}"/>
	<liferay-portlet:param name="surveyTitle" value="${surveyMap.surveyTitle}"/>
	<liferay-portlet:param name="classId" value="${classId}"/>
	
	<liferay-portlet:param name="tabs" value="${visitSite}"/>
</liferay-portlet:resourceURL>


<liferay-portlet:renderURL var="listURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="visitSite" value="${visitSite}"/>
	<liferay-portlet:param name="surveySeqNo" value="${surveyMap.surveySeqNo}"/>
</liferay-portlet:renderURL>

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
		data  : {"<portlet:namespace/>surveySeqNo" : surveySeqNo, "<portlet:namespace/>classId" : "${classId}", "<portlet:namespace/>tabs" : "${visitSite}"},
		success: function(data) {	    			
			var dataMap = eval('(' + data + ')');
			$questionTable = $("#questionTable");
			$questionTable.empty();		
			if(dataMap.dataList.length==0){
				
				$questionTable.append('<tr><td colspan=7><liferay-ui:message key="edison-there-are-no-data" /></td></tr>');
				
			}else{
				
				for(var i = 0 ; i < dataMap.dataList.length; i++ ){
					var num = i+1;									

					if(dataMap.dataList[i].questionDivCd == "SVY_02_001"){
						$trNode = $("<tr/>");
						$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-survey' /> "+num+"</th>").appendTo($trNode);					
						$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-question-title' /></th>").appendTo($trNode);					
						$("<td/>").addClass("question").attr("colspan", "3").text(dataMap.dataList[i].questionTitle).appendTo($trNode);
						$questionTable.append($trNode);							
						
						var rowCnt = 1;
						if(dataMap.dataList[i].question1 != null && dataMap.dataList[i].question1 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" + " 1"))
									  .append($("<td/>").text(dataMap.dataList[i].question1))
									  .append($("<td/>").text(dataMap.dataList[i].question1Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question2 != null && dataMap.dataList[i].question2 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" + " 2"))
									  .append($("<td/>").text(dataMap.dataList[i].question2))
									  .append($("<td/>").text(dataMap.dataList[i].question2Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question3 != null && dataMap.dataList[i].question3 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" +" 3"))
									  .append($("<td/>").text(dataMap.dataList[i].question3))
									  .append($("<td/>").text(dataMap.dataList[i].question3Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question4 != null && dataMap.dataList[i].question4 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" +" 4"))
									  .append($("<td/>").text(dataMap.dataList[i].question4))
									  .append($("<td/>").text(dataMap.dataList[i].question4Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question5 != null && dataMap.dataList[i].question5 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" +" 5"))
									  .append($("<td/>").text(dataMap.dataList[i].question5))
									  .append($("<td/>").text(dataMap.dataList[i].question5Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question6 != null && dataMap.dataList[i].question6 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" +" 6"))
									  .append($("<td/>").text(dataMap.dataList[i].question6))
									  .append($("<td/>").text(dataMap.dataList[i].question6Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question7 != null && dataMap.dataList[i].question7 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" +" 7"))
									  .append($("<td/>").text(dataMap.dataList[i].question7))
									  .append($("<td/>").text(dataMap.dataList[i].question7Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question8 != null && dataMap.dataList[i].question8 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" +" 8"))
									  .append($("<td/>").text(dataMap.dataList[i].question8))
									  .append($("<td/>").text(dataMap.dataList[i].question8Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question9 != null && dataMap.dataList[i].question9 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" +" 9"))
									  .append($("<td/>").text(dataMap.dataList[i].question9))
									  .append($("<td/>").text(dataMap.dataList[i].question9Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						if(dataMap.dataList[i].question10 != null && dataMap.dataList[i].question10 != ''){
							$("<tr/>").append($("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" +" 10"))
									  .append($("<td/>").text(dataMap.dataList[i].question10))
									  .append($("<td/>").text(dataMap.dataList[i].question10Cnt+"<liferay-ui:message key='edison-virtuallab-surveyResultList-people' />")).appendTo($questionTable);
							rowCnt++;
						}	
						
						$trNode.find("th:first").attr("rowspan", rowCnt);
						
					}else if(dataMap.dataList[i].questionDivCd == "SVY_02_002"){						
						$newThNode = $("<tr/>");
						$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-survey' /> "+num+"</th>").appendTo($newThNode);					
						$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-question-title' /></th>").appendTo($newThNode);					
						$("<td/>").addClass("question").attr("colspan", "2").text(dataMap.dataList[i].questionTitle).appendTo($newThNode);
						$(".surveyMain").append($newThNode);
						
						$newThNode.find("th:first").attr("rowspan", subjectAnswerSetting(dataMap.dataList[i].surveySeqNo, dataMap.dataList[i].questionSeqNo));
					}
				}
			}
			
		},error:function(data,e){ 
			alert(e);				
			return false;
		}
	});
}

function subjectAnswerSetting(surveySeqNo,questionSeqNo){
	var rowCnt = 0;
	jQuery.ajax({
		type: "POST",
		url: "<%=surveyAnswerListURL%>",
		async : false,
		data  : {"<portlet:namespace/>surveySeqNo" : surveySeqNo , "<portlet:namespace/>questionSeqNo" : questionSeqNo , "<portlet:namespace/>classId" : "${classId}", "<portlet:namespace/>tabs" : "${visitSite}"},
		success: function(data) {	    			
			var dataMap = eval('(' + data + ')');						
			rowCnt = dataMap.dataList.length;
			if(rowCnt==0){
				
			}else{
				
				for(var i = 0 ; i < dataMap.dataList.length; i++ ){
					var num = i+1;		
					$trNode = $("<tr/>");
					$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-response' /> "+num+"</th>").appendTo($trNode);										
					$("<td/>").attr("colspan", "3").text(dataMap.dataList[i].subjectivityAnswer).appendTo($trNode);
					$(".surveyMain").append($trNode);
				}			
			}
			
		},error:function(data,e){ 
			alert(e);				
			return false;
		}
	});
	
	return rowCnt+1;
}

function <portlet:namespace/>onclickConfirm(){
	window.location.href = "<%=surveyExcelDownURL%>";	
}

function <portlet:namespace/>historyback(){
// 	window.location.href = "<liferay-portlet:renderURL/>&<portlet:namespace/>visitSite=${visitSite}";
	window.location.href = "${listURL}";

}
</script>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
	<tr>
		<td style="text-align: right;">
			<input class="button06" type="button" onclick="<portlet:namespace/>historyback()" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-list' />" />
			<input class="button06" type="button" onclick="<portlet:namespace/>onclickConfirm()" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-excel-down' />" />
		</td>
	</tr>
</table>
<h1>
	<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-result' />
</h1>
<c:if test="${null ne classInfo}" >
<div class="table6_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
		<colgroup>
			<col width="25%" />
			<col width="25%" />
			<col width="25%" />
			<col width="25%" />
		</colgroup>
		<thead>
			<tr>
				<th><liferay-ui:message key='edison-virtuallab-tablerow-virtuallab' /></th>
				<th><liferay-ui:message key='edison-virtuallab-tablerow-affiliation' /></th>
				<th><liferay-ui:message key='edison-virtuallab-tablerow-professor' /></th>
				<th><liferay-ui:message key='edison-virtuallab-tablerow-virtualclass' /></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td style="text-align: center">${classInfo.virtualLabTitle}</td>
				<td style="text-align: center">${classInfo.virtualLabPersonName}</td>
				<td style="text-align: center">${classInfo.virtualLabUniversityFieldNM}</td>
				<td style="text-align: center">${classInfo.classTitle}</td>
			</tr>
		</tbody>
	</table>
</div>
</c:if>
<div style="height: 15px;" ></div>		
<div id="data_text_wrap">
<div class="table1_list" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
		<colgroup>
			<col width="30%" />
			<col width="70%" />
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
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
		<colgroup>
			<col width="15%" />
			<col width="15%" />
			<col width="60%" />
			<col width="10%" />
		</colgroup>
		<tbody id="questionTable">
		</tbody>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
		<colgroup>
			<col width="15%" />
			<col width="15%" />
			<col width="70%" />
		</colgroup>
		<tbody class="surveyMain">
		</tbody>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
		<tr>
			<td style="text-align: right;">
				<input class="button06" type="button" onclick="<portlet:namespace/>historyback()" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-list' />" />
				<input class="button06" type="button" onclick="<portlet:namespace/>onclickConfirm()" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-excel-down' />" />
			</td>
		</tr>
	</table>
</div>
</div>
