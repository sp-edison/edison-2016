<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="org.kisti.edison.util.RequestUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="java.util.Locale"%>

<liferay-portlet:actionURL var="insertURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="insert"/>
</liferay-portlet:actionURL>

<script>
var questionSeq = 1;

$(document).ready(function () {
	$( "#<portlet:namespace/>surveyStartDate" ).datepicker({
		showButtonPanel: true,
		showOn: 'button',
		dateFormat:"yy-mm-dd",
		changeMonth: true,
		changeYear: true,
		buttonImage: "${contextPath}/images/calendar.png",
		buttonImageOnly: true,
		onClose: function( selectedDate ) {
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
		onClose: function( selectedDate ) {
		  }
	});
});

$(document).on( "click", ".plusBtn",  function(){
	$tableNode = $(this).parent().parent().parent();
	var queCnt = $tableNode.find("tr.question").length;		
	if(queCnt >= 10){
		alert('<liferay-ui:message key="edison-virtuallab-surveyResultList-no-add" />');
	}else{
		$cloneNode =  $(this).parent().parent().clone();
		
		queCnt = queCnt+1;
		$cloneNode.find("th").text('<liferay-ui:message key="edison-virtuallab-surveyResultList-answer-number" />'+queCnt);
		$cloneNode.find("input[type=text]").val("");
		$tableNode.find("img.minusBtn").remove();
		$cloneNode.find("img").removeClass("plusBtn").addClass("minusBtn").attr("src", "${contextPath}/images/btn_minus.png")
		$tableNode.find("tr.question_title").find("th:first").attr("rowspan",(queCnt+1));
		$tableNode.append($cloneNode);
	}
	//alert($tableNode.find("tr.question").length);	
});

$(document).on( "click", ".minusBtn", function(){
	$tableNode = $(this).parent().parent().parent();
	var queCnt = $tableNode.find("tr.question").length;		
	if(queCnt == 1){
		alert('<liferay-ui:message key="edison-virtuallab-surveyResultList-no-remove" />');
	}else{
		$tableNode.find("tr.question_title").find("th:first").attr("rowspan",(queCnt));
		$(this).parent().parent().remove();
		if(queCnt > 2){
			$tableNode.find("tr:last").find("td:last").append($("<img/>").addClass("minusBtn").css("cursor","pointer").attr("src", "${contextPath}/images/btn_minus.png"));
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
			
			$("<th/>").text('<liferay-ui:message key="edison-virtuallab-surveyResultList-answer-number" />' + " 1").appendTo($trNode);
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

function <portlet:namespace/>visibleChaneDivCd(value){
	if(value=="SVY_03_001"){
		$("#<portlet:namespace/>survey_1").empty();
		
		$questionTitleTr = $("<tr/>");
		$questionTitleTr.addClass("question_title");
		
		$("<th rowspan='2'><liferay-ui:message key='edison-virtuallab-surveyResultList-survey' /> 1</th>").appendTo($questionTitleTr);
		$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-survey-title' /></th>").appendTo($questionTitleTr);
		$("<td></td>").append("<input type=\"text\" name=\"<portlet:namespace/>questionTitle\" maxlength=\"100\" value=\"\" style\"width:600px;\"/>").appendTo($questionTitleTr);
		$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-type' /></th>").appendTo($questionTitleTr);
		
		$("<td/>").html("<liferay-ui:message key='edison-virtuallab-surveyResultList-multiple-choice' />" + ": <input type=\"radio\" name=\"<portlet:namespace/>questionDivCd1\" value=\"SVY_02_001\" class=\"radio_div\" checked=\"checked\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
		.appendTo($questionTitleTr);
		
		$questionTitleTr.appendTo($("#<portlet:namespace/>survey_1"));
		
		$questionTr =  $("<tr/>");
		$questionTr.addClass("question");
		$("<th>보기1</th>").appendTo($questionTr);
		$("<td colspan=\"2\"></td>").append("<input type=\"text\" name=\"<portlet:namespace/>question1\" maxlength=\"100\" value=\"\" style=\"width:600px;\"/>").appendTo($questionTr);
		$("<td></td>").append("<img class=\"plusBtn\" src=\"${contextPath}/images/btn_plus.png\" style=\"cursor: pointer;\"/>").appendTo($questionTr);
		$questionTr.appendTo($("#<portlet:namespace/>survey_1"));
	
		$("#<portlet:namespace/>surveyAddBtn").hide();
	}else if(value=="SVY_03_002"){
		$("#<portlet:namespace/>survey_1").empty();
		$questionTitleTr = $("<tr/>");
		$questionTitleTr.addClass("question_title");
		$("<th rowspan='2'><liferay-ui:message key='edison-virtuallab-surveyResultList-survey' /> 1</th>").appendTo($questionTitleTr);
		$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-question-title' /></th>").appendTo($questionTitleTr);
		$("<td></td>").append("<input type=\"text\" name=\"<portlet:namespace/>questionTitle\" maxlength=\"100\" value=\"\" style=\"width:600px;\"/>").appendTo($questionTitleTr);
		$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-type' /></th>").appendTo($questionTitleTr);
		
		$("<td/>").html("<liferay-ui:message key='edison-virtuallab-surveyResultList-multiple-choice' />" + ": <input type=\"radio\" name=\"<portlet:namespace/>questionDivCd1\" value=\"SVY_02_001\" class=\"radio_div\" checked=\"checked\" />주관식: <input type=\"radio\" name=\"questionDivCd1\" value=\"SVY_02_002\" class=\"radio_div\"/>&nbsp;")
		.appendTo($questionTitleTr);
		
		$questionTitleTr.appendTo($("#<portlet:namespace/>survey_1"));
		
		$questionTr =  $("<tr/>");
		$questionTr.addClass("question");
		$("<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' /> 1</th>").appendTo($questionTr);
		$("<td colspan=\"2\"></td>").append("<input type=\"text\" name=\"<portlet:namespace/>question1\" maxlength=\"100\" value=\"\" style=\"width:600px;\"/>").appendTo($questionTr);
		$("<td></td>").append("<img class=\"plusBtn\" src=\"${contextPath}/images/btn_plus.png\" style=\"cursor: pointer;\"/>").appendTo($questionTr);
		$questionTr.appendTo($("#<portlet:namespace/>survey_1"));
		
		$("#<portlet:namespace/>surveyAddBtn").show();
	}
}

function <portlet:namespace/>surveyAdd(){
	$mainDiv = $(".surveyMain");
	$cloneTable =  $("#<portlet:namespace/>survey_1").clone();
	$cloneTable.attr("id", "<portlet:namespace/>survey_" + (++questionSeq));
	$cloneTable.find("input[type=radio]").attr("name", "<portlet:namespace/>questionDivCd" + questionSeq);	
	$cloneTable.find("tr.question_title").find("th:first").attr("rowspan","2").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-survey' /> " + (questionSeq));
	$cloneTable.find("tr.question:not(:first)").remove();	
	$cloneTable.find("tr.question").find("input[name=<portlet:namespace/>question1]").attr("name","<portlet:namespace/>question" + questionSeq);	
	$cloneTable.find("tr.question_title").find("td:last").append($("<img/>").addClass("minus_surveyBtn").attr("src", "${contextPath}/images/btn_minus.png").css("cursor", "pointer"));
	$cloneTable.find("tr.question_title").attr("data-questionSeq", questionSeq);
	$cloneTable.find("input[type=text]").val("");
	$cloneTable.appendTo($mainDiv);
	
}

function <portlet:namespace/>onclickConfirm(){
	var validationChk = true;
	$("input[type=text]").filter(function() { 
		if($(this).val() == ""){
			
			if(validationChk){
				validationChk = false;
				this.focus();
				alert("<liferay-ui:message key='edison-virtuallab-surveyResultList-no-insert' />");
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

function <portlet:namespace/>historyback(){
	window.location.href = "<liferay-portlet:renderURL/>&<portlet:namespace/>visitSite=survey";	
}

</script>
<!-- 페이지 타이틀 & 네비게이션 -->
<h1 style="padding-bottom:0px;">
	<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-management' />
</h1>
<% 
	if(SessionErrors.contains(renderRequest, SystemException.class.getName())) {
%>
	?????????????????
<% 
	}
%>
<form name="surveyForm" action="<%=insertURL %>" method="post">		
<input type="hidden" name="<portlet:namespace/>surveyDivCd" value="${param.surveyDivCd}"/>

<div id="data_text_wrap" class="surveyMain">

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-registration' />
		<input type="button" class="button06" onclick="<portlet:namespace/>surveyAdd()" id="<portlet:namespace/>surveyAddBtn" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-add-question' />">
	</div>
	<div style="padding: 10px; float:right; border: 2px dashed #6a8ec6; border-radius: 10px;">
		<%
		Locale[] availLocales = LanguageUtil.getAvailableLocales();
		for(int i=0;i<availLocales.length;i++){
		%>
		<label style="display:inline;">
		<input type="radio" id="<portlet:namespace/>select_languageId" name="<portlet:namespace/>select_languageId" value="<%=availLocales[i]%>" <%if(CustomUtil.strNull(request.getAttribute("select_languageId")).equals(availLocales[i].toString())) out.print("checked"); %> style="margin-left:10px;"/>
		<img width="17px" height="12px" src="${contextPath}/images/toplink_<%=availLocales[i]%>.gif" style="float:none; padding:0px;" />
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
		<td width="759px;">
			<input type="text" name="<portlet:namespace/>surveyTitle" size="50" maxlength="100" value="${surveyTitle}" style="width: auto;"/>
		</td>
		<th><liferay-ui:message key='edison-virtuallab-surveyResultList-survey-period' /></th>
		<td>
			<input name="<portlet:namespace/>surveyStartDate" id="<portlet:namespace/>surveyStartDate" readonly="readonly" style="width:105px; text-align:center;"/>
			 ~ <input name="<portlet:namespace/>surveyEndDate" id="<portlet:namespace/>surveyEndDate" readonly="readonly" style="width:105px; text-align:center;"/>
		</td>
	</tr>
</table>
<div id="<portlet:namespace/>survey_1" class="table1_list" style="border-top: 0px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data survey" style="table-layout:fixed; margin-top:20px; border-top: 1px solid gray;">
		<colgroup>
			<col width="12%" />
			<col width="8%" />
			<col width="35%" />
			<col width="20%" />
			<col width="25%" />
		</colgroup>
		<tr class="question_title" data-questionSeq="1">
			<th rowspan="2"><liferay-ui:message key='edison-virtuallab-surveyResultList-survey' /> 1</th>
			<th><liferay-ui:message key='edison-virtuallab-surveyResultList-question-title' /></th>
			<td>
				<input type="text" name="<portlet:namespace/>questionTitle" size="50" maxlength="100" value="${questionTitle}" style="width: auto;"/>
			</td>
			<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-type' /></th>
			<td>
				<div style="display: block;">
					<liferay-ui:message key='edison-virtuallab-surveyResultList-multiple-choice' />: <input type="radio" name="<portlet:namespace/>questionDivCd1" value="SVY_02_001" class="radio_div" checked="checked" />
				</div>
				<div style="display: block;">
					<liferay-ui:message key='edison-virtuallab-surveyResultList-short-answer' />: <input type="radio" name="<portlet:namespace/>questionDivCd1" value="SVY_02_002" class="radio_div"/>
				</div>
				
			</td>
		</tr>
		<tr class="question">
			<th><liferay-ui:message key='edison-virtuallab-surveyResultList-answer-number' />1</th>
			<td colspan="2">
				<input type="text" name="<portlet:namespace/>question1" maxlength="100" value="${question1}" style="width: 600px;"/>
			</td>
			<td>
			<img class="plusBtn" src="${contextPath}/images/btn_plus.png" style="cursor: pointer;"/>			
			</td>
		</tr>			
	</table>
</div>	
</div>
<div style="text-align: right; margin-top: 10px;">
	<input class="button06" type="button" onclick="<portlet:namespace/>historyback()" value="<liferay-ui:message key='edison-button-cancel' />" style="cursor:pointer;"/>
	<input class="button06" type="button" onclick="<portlet:namespace/>onclickConfirm()" value="<liferay-ui:message key='edison-button-register' />" style="cursor:pointer;"/>
</div>
</form>
