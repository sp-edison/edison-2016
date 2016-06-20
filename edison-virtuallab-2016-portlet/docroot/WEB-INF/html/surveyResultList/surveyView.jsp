<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="java.util.Locale"%>

<liferay-portlet:actionURL var="updateURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="update"/>
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="deleteURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="delete"/>
	<liferay-portlet:param name="surveySeqNo" value="${surveyMap.surveySeqNo}"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL var="surveyViewURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="surveyView" />
</liferay-portlet:renderURL>

<script>
var questionSeq = 0;

$(document).ready(function () {
	$mainDiv = $(".surveyMain");
	questionSeq = $mainDiv.find("table.survey").length;
	
	$( "#<portlet:namespace/>surveyStartDate" ).datepicker({
    	showButtonPanel: true,
    	showOn: 'button',
    	dateFormat:"yy-mm-dd",
    	changeMonth: true,
    	changeYear: true,
    	buttonImage: "${contextPath}/images/calendar.png",
        buttonImageOnly: true,
        onClose: function( selectedDate) {
        	
          }
    });
    $( "#<portlet:namespace/>surveyEndDate" ).datepicker({
    	showButtonPanel: true,
    	showOn: 'button',
    	dateFormat:"yy-mm-dd",
    	changeMonth: true,
    	changeYear: true,
    	buttonImage: "${contextPath}/images/calendar.png",
        buttonImageOnly: true,
        onClose: function( selectedDate) {
        	
          }
    });  
    
    if ("${answerCnt}" != 0) {
    	$(".plusBtn").css("display","none");
    	$(".minusBtn").css("display","none");
    	$(".minus_surveyBtn").css("display","none");
    	$(".ui-datepicker-trigger").css("display","none");
    	$("input[name^=<portlet:namespace/>]").attr("readonly",true);
    	$("input[name^=<portlet:namespace/>]").attr("disabled",true);
    }
});

$(document).on( "click", ".plusBtn",  function(){
	$tableNode = $(this).parent().parent().parent();
	var queCnt = $tableNode.find("tr.question").length;		
	if(queCnt >= 10){
		alert("<liferay-ui:message key='edison-virtuallab-surveyResultList-no-add' />")
	}else{			
		$cloneNode =  $(this).parent().parent().clone();
		
		queCnt = queCnt+1;
		$cloneNode.find("th").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" + " "+queCnt);
		$cloneNode.find("input[type=text]").val("");
		$tableNode.find("img.minusBtn").remove();
		$cloneNode.find("img").removeClass("plusBtn").addClass("minusBtn").attr("src", "${contextPath}/images/btn_minus.png").css("cursor", "pointer")
		$tableNode.find("tr.question_title").find("th:first").attr("rowspan",(queCnt+1));
		$tableNode.append($cloneNode);
	}
	//alert($tableNode.find("tr.question").length);	
});

$(document).on( "click", ".minusBtn", function(){
	$tableNode = $(this).parent().parent().parent();
	var queCnt = $tableNode.find("tr.question").length;		
	if(queCnt == 1){
		alert("<liferay-ui:message key='edison-virtuallab-surveyResultList-no-remove' />");
	}else{
		$tableNode.find("tr.question_title").find("th:first").attr("rowspan",(queCnt));
		$(this).parent().parent().remove();
		if(queCnt > 2){
			$tableNode.find("tr:last").find("td:last").append($("<img/>").addClass("minusBtn").css("cursor","pointer").attr("src", "${contextPath}/images/btn_minus.png").css("cursor", "pointer"));
		}
		
	}
});

$(document).on( "click", ".minus_surveyBtn", function(){
	$(this).parent().parent().parent().parent().remove();

});

$(document).on( "click", ".radio_div", function(){
	$tableNode = $(this).parent().parent().parent().parent();
	if($(this).val() == 'SVY_02_001'){
		if($tableNode.find("tr.question").length == 0) {
			$trNode =  $("<tr/>").addClass("question");
			
			$("<th/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />" + " 1").appendTo($trNode);
			$("<td/>").attr("colspan","2").append(
					$("<input/>").css("width","600px")
								 .attr("type","text")
								 .attr("name","<portlet:namespace/>question" + $tableNode.find("tr.question_title").attr("data-questionSeq"))
								 .attr("maxlength","100"))
								 .appendTo($trNode);
			
			$("<td/>").append($("<img/>").addClass("plusBtn").attr("src","${contextPath}/images/btn_plus.png").css("cursor","pointer")).appendTo($trNode);
			$tableNode.find("tr.question_title").find("th:first").attr("rowspan","2");
			$tableNode.append($trNode);
		}
	}else{
		$tableNode.find("tr.question").remove();
	}
});

function <portlet:namespace/>surveyAdd(){
	$mainDiv = $(".surveyMain");
	$cloneTable =  $("#<portlet:namespace/>survey_1").clone();
	$cloneTable.attr("id", "<portlet:namespace/>survey_" + (++questionSeq));
	$cloneTable.find("input[type=radio]").attr("name", "<portlet:namespace/>questionDivCd" + questionSeq);	
	$cloneTable.find("tr.question_title").find("th:first").attr("rowspan","2").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-survey' />" + " " + (questionSeq));
	$cloneTable.find("tr.question_title").find("input:first").attr("name", "<portlet:namespace/>questionTitle" + questionSeq);
	$cloneTable.find("tr.question:not(:first)").remove();
	$cloneTable.find("tr.question").find("input:first").attr("name","<portlet:namespace/>question" + questionSeq);	
	$cloneTable.find("tr.question_title").find("td:last").append($("<img/>").addClass("minus_surveyBtn").attr("src", "${contextPath}/images/btn_minus.png").css("cursor", "pointer"));
	$cloneTable.find("tr.question_title").attr("data-questionSeq", questionSeq);
	$cloneTable.find("input[type=text]").val("");
	$cloneTable.appendTo($mainDiv);
	
}

function onclickConfirm(){
	var validationChk = true;
	$("input[type=text]").filter(function() { 
		if($(this).val().replace(/(^\s*)|(\s*$)/gi, "") == ""){
			
			if(validationChk){
				validationChk = false;
				this.focus();
				alert("<liferay-ui:message key='edison-create-account-description-message-first-line' />");
				$("input:radio[name='<portlet:namespace/>select_languageId']:radio[value='${select_languageId }']").prop("checked",true);
			}
		}else{
			$(this).val($(this).val().replace(/,/gi, "."));
		}
	});
	
	if(validationChk){
		var f = document.surveyForm;
		f.submit();
	}
}

function fnDelete(){
	if(confirm("<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-delete' />")){		
		window.location.href = "<%=deleteURL%>";
	}
}

function historyback(){
	window.location.href = "<liferay-portlet:renderURL/>&<portlet:namespace/>visitSite=survey";	
}

function changeLanguage(){
	if(confirm("<liferay-ui:message key='edison-board-save-alert' />")){		
		onclickConfirm();
	}else{
		var reloadUrl = "<%=surveyViewURL%>"
		
		reloadUrl += "&<portlet:namespace/>surveySeqNo=${surveyMap.surveySeqNo}";
		reloadUrl += "&<portlet:namespace/>select_languageId="+$("input[name=<portlet:namespace/>select_languageId]:radio:checked").val();
		location.href = reloadUrl;
	}
}

</script>
<!-- 페이지 타이틀 & 네비게이션 -->

<h1>
	<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-management' />
</h1>

<div class="h10"></div>

<form name="surveyForm" action="<%=updateURL %>" method="post">		
<input type="hidden" name="<portlet:namespace/>surveySeqNo" value="${surveyMap.surveySeqNo}"/>
<input type="hidden" name="<portlet:namespace/>surveyDivCd" value="${surveyMap.surveyDivCd}"/>
<input type="hidden" name="<portlet:namespace/>current_languageId" value="${select_languageId}"/>
<div id="data_text_wrap" class="surveyMain">

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-registration' />
		<c:if test="${answerCnt == '0'}">
			<input type="button" class="button06" onclick="<portlet:namespace/>surveyAdd()" id="<portlet:namespace/>surveyAddBtn" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-add-question' />">
		</c:if>
	</div>
	<div style="padding: 10px; float:right; border: 2px dashed #6a8ec6; border-radius: 10px;">
		<%
		Locale[] availLocales = LanguageUtil.getAvailableLocales();
		for(int i=0;i<availLocales.length;i++){
		%>
		<label style="display:inline;">
		<input type="radio" id="<portlet:namespace/>select_languageId" name="<portlet:namespace/>select_languageId" value="<%=availLocales[i]%>" <%if(CustomUtil.strNull(request.getAttribute("select_languageId")).equals(availLocales[i].toString())) out.print("checked"); %>
			onChange="changeLanguage()" style="margin-left:10px;"
		/>
		<img width="17px" height="12px" src="${contextPath}/images/toplink_<%=availLocales[i]%>.gif" style="float:none; padding:0px;"/>
		<liferay-ui:message key='<%="edison-board-radiobutton-" + availLocales[i].toString()%>' />
		</label>
		<%
		}
		%>
	</div>
</div>

<div class="h10"></div>

	<table class="table6_list" width="100%" border="0" cellspacing="0" cellpadding="0" class="data" style="table-layout:fixed;">
		<colgroup>
			<col width="20%" />
			<col width="35%" />
			<col width="20%" />
			<col width="25%" />
		</colgroup>
		<tr>
			<th><liferay-ui:message key='edison-virtuallab-surveyResultList-survey-title2' /></th>
			<td>
				<input type="text" name="<portlet:namespace/>surveyTitle" size="50" maxlength="150" value="${surveyMap.surveyTitle}" style="width: auto;"/>
			</td>
			<th><liferay-ui:message key='edison-virtuallab-surveyResultList-survey-period' /></th>
			<td>
				<input name="<portlet:namespace/>surveyStartDate" id="<portlet:namespace/>surveyStartDate" readonly="readonly" value="${surveyMap.surveyStartDate}" style="width:105px; text-align:center;"/>
			 	~ <input name="<portlet:namespace/>surveyEndDate" id="<portlet:namespace/>surveyEndDate" readonly="readonly" value="${surveyMap.surveyEndDate}" style="width:105px; text-align:center;"/>
			</td>
		</tr>
	</table>
	<c:forEach var="data" items="${surveyQuestionList}" varStatus="status">
	<div id="<portlet:namespace/>survey_${status.index+1}" class="table1_list" style="border-top: 0px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data survey"  style="table-layout:fixed; margin-top:20px; border-top: 1px solid gray;">
			<colgroup>
				<col width="12%" />
				<col width="8%" />
				<col width="35%" />
				<col width="20%" />
				<col width="25%" />
			</colgroup>
		
			<c:choose>
				 <c:when test="${data.questionDivCd =='SVY_02_001'}">
					 <tr class="question_title" data-questionSeq="-${data.questionSeqNo}">
						<th rowspan="${data.questionCnt+1}"><liferay-ui:message key='edison-virtuallab-surveyResultList-survey' /> ${status.index+1}</th>
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-question-title' /></th>
						<td>
							<input type="text" name="<portlet:namespace/>questionTitle-${data.questionSeqNo}" size="50" maxlength="150" value="${data.questionTitle}" style="width: auto;" class="input_question_title"/>
						</td>
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-type' /></th>
						<td>
							<div style="display:block;">
							<liferay-ui:message key='edison-virtuallab-surveyResultList-multiple-choice' />: <input type="radio" name="<portlet:namespace/>questionDivCd-${data.questionSeqNo}" value="SVY_02_001" index="${status.index+1}" class="radio_div" checked="checked" />
							</div>
							<div style="display:block;">
							<liferay-ui:message key='edison-virtuallab-surveyResultList-short-answer' />: <input type="radio" name="<portlet:namespace/>questionDivCd-${data.questionSeqNo}" value="SVY_02_002" index="${status.index+1}" class="radio_div"/>
							</div>
							<c:if test="${status.index > 0 }">
							<img class="minus_surveyBtn" src="${contextPath}/images/btn_minus.png" style="cursor:pointer;"/>
							</c:if>
						</td>

					</tr>
					<c:if test="${!empty data.question1}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />1</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question1}" style="width: 600px;"/>
						</td>
						<td>
						<img class="plusBtn" src="${contextPath}/images/btn_plus.png" style="cursor: pointer;"/>			
						</td>
					</tr>
					</c:if>
					<c:if test="${!empty data.question2}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />2</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question2}"  style="width: 600px;"/>
						</td>
						<td>
						<c:if test="${data.questionCnt == '2'}">
						<img class="minusBtn" src="${contextPath}/images/btn_minus.png" style="cursor: pointer;"/>
						</c:if>		
						</td>
						
					</tr>
					</c:if>
					<c:if test="${!empty data.question3}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />3</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question3}" style="width: 600px;"/>
						</td>
						<td>
						<c:if test="${data.questionCnt == '3'}">
						<img class="minusBtn" src="${contextPath}/images/btn_minus.png" style="cursor: pointer;"/>
						</c:if>			
						</td>
					</tr>
					</c:if>
					<c:if test="${!empty data.question4}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />4</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question4}" style="width: 600px;"/>
						</td>
						<td>
						<c:if test="${data.questionCnt == '4'}">
						<img class="minusBtn" src="${contextPath}/images/btn_minus.png" style="cursor: pointer;"/>
						</c:if>			
						</td>
					</tr>
					</c:if>
					<c:if test="${!empty data.question5}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />5</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question5}" style="width: 600px;"/>
						</td>
						<td>
						<c:if test="${data.questionCnt == '5'}">
						<img class="minusBtn" src="${contextPath}/images/btn_minus.png" style="cursor: pointer;"/>
						</c:if>			
						</td>
					</tr>
					</c:if>
					<c:if test="${!empty data.question6}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />6</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question6}" style="width: 600px;"/>
						</td>
						<td>
						<c:if test="${data.questionCnt == '6'}">
						<img class="minusBtn" src="${contextPath}/images/btn_minus.png" style="cursor: pointer;"/>
						</c:if>			
						</td>
					</tr>
					</c:if>
					<c:if test="${!empty data.question7}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />7</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question7}" style="width: 600px;"/>
						</td>
						<td>
						<c:if test="${data.questionCnt == '7'}">
						<img class="minusBtn" src="${contextPath}/images/btn_minus.png" style="cursor: pointer;"/>
						</c:if>			
						</td>
					</tr>
					</c:if>
					<c:if test="${!empty data.question8}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />8</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question8}" style="width: 600px;"/>
						</td>
						<td>
						<c:if test="${data.questionCnt == '8'}">
						<img class="minusBtn" src="${contextPath}/images/btn_minus.png" style="cursor: pointer;"/>
						</c:if>			
						</td>
					</tr>
					</c:if>
					<c:if test="${!empty data.question9}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />9</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question9}" style="width: 600px;"/>
						</td>
						<td>
							<c:if test="${data.questionCnt == '9'}">
						<img class="minusBtn" src="${contextPath}/images/btn_minus.png" style="cursor: pointer;"/>
						</c:if>			
						</td>
					</tr>
					</c:if>
					<c:if test="${!empty data.question10}">
					<tr class="question">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />10</th>
						<td colspan="2">
							<input type="text" name="<portlet:namespace/>question-${data.questionSeqNo}" maxlength="256" value="${data.question10}" style="width: 600px;"/>
						</td>
						<td>
						<c:if test="${data.questionCnt == '10'}">
						<img class="minusBtn" src="${contextPath}/images/btn_minus.png" style="cursor: pointer;"/>
						</c:if>			
						</td>
					</tr>
					</c:if>
				 </c:when>
				 <c:otherwise>
					 <tr class="question_title" data-questionSeq="-${data.questionSeqNo}">
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-survey' /> ${status.index+1}</th>
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-question-title' /></th>
						<td>
							<input type="text" name="<portlet:namespace/>questionTitle-${data.questionSeqNo}" size="50" maxlength="256" value="${data.questionTitle}" style="width: auto"/>
						</td>
						<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-type' /></th>
						<td>
							<div style="display:block;">
							<liferay-ui:message key='edison-virtuallab-surveyResultList-multiple-choice' />: <input type="radio" name="<portlet:namespace/>questionDivCd-${data.questionSeqNo}" index="${status.index+1}" value="SVY_02_001" class="radio_div"  />
							</div>
							<div style="display:block;">
							<liferay-ui:message key='edison-virtuallab-surveyResultList-short-answer' />: <input type="radio" name="<portlet:namespace/>questionDivCd-${data.questionSeqNo}" index="${status.index+1}" value="SVY_02_002" class="radio_div" checked="checked"/>
							</div>
							<c:if test="${status.index > 0 }">
							<img class="minus_surveyBtn" src="${contextPath}/images/btn_minus.png" style="cursor:pointer;"/>
							</c:if>							
						</td>
					</tr>
				 </c:otherwise>
			</c:choose>
		</table>
	</div>
	</c:forEach>
</div>
<div style="text-align: right; margin-top: 10px;">
	<c:if test="${answerCnt != '0'}">
		<font color="red" size="4"><b>* <liferay-ui:message key='edison-virtuallab-surveyResultList-no-survey-delete' /></b></font>
	</c:if>
		<input class="button06" type="button" onclick="historyback()" value="<liferay-ui:message key='edison-button-board-list' />" />
	<c:if test="${answerCnt == '0'}">
		<input class="button06" type="button" onclick="onclickConfirm()" value="<liferay-ui:message key='edison-button-board-modify' />" />
		<input class="button06" type="button" onclick="fnDelete()" value="<liferay-ui:message key='edison-button-board-delete' />" />
	</c:if>
</div>
</form>
