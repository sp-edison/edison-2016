<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:resourceURL var="getSurveyOptionURL" id="getSurveyOption" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="getSurveyListURL" id="getSurveyList" copyCurrentRenderParameters="false" />

<liferay-portlet:actionURL var="updateSurveyStatusURL" portletMode="view" copyCurrentRenderParameters="false" >
	<liferay-portlet:param name="myaction" value="updateSurveyStatus" />
</liferay-portlet:actionURL>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-virtuallab-survey' />
	</div>
	<div class="buttonbox0801">
		<input id="<portlet:namespace/>surveyOptionDialog" name="<portlet:namespace/>surveyOptionDialog" type="button" class="button0801" value="<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-management' />" onclick="<portlet:namespace/>surveyOption();"/>
	</div>
</div>

<div class="h5"></div>

<form id="searchForm" name="searchForm" method="post">
	<input id="<portlet:namespace/>virtualLabId" name="<portlet:namespace/>virtualLabId" type="hidden" value="${virtualLabId}" />
</form>
<div class="table1_list" style="display: inline-block; margin-bottom: 10px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="70%" />
			<col width="30%" />
		</colgroup>
		<tbody id="<portlet:namespace/>surveyManagerListBody">
		</tbody>
	</table>
</div>

<div id="<portlet:namespace/>survey-option-dialog" style="display:none; background-color: #fff;" class="newWindow">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-surveyResultList-survey-management' />
			</div>
		</div>
		<div class="newWclose">
			<img id="<portlet:namespace/>survey-option-dialog-close-btn" name="<portlet:namespace/>survey-option-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	
	<form id="surveyUpdateForm" name="surveyUpdateForm" method="post" action="<%= updateSurveyStatusURL %>" >
		<input id="<portlet:namespace/>virtualLabId" name="<portlet:namespace/>virtualLabId" type="hidden" value="${virtualLabId}">
		<div class="newWcont01" style="min-width:500px;">
			<table class="table1_list" width="100%" border="0" cellspacing="0" cellpadding="0">
				<colgroup>
					<col width="*" />
					<col width="120" />
					<col width="100" />
				</colgroup>
				<thead>
					<tr style="border-bottom:1px solid #bcd1d6;">
						<th class="puptitle" align="center" scope="col" style="text-align: center;"><liferay-ui:message key='edison-virtuallab-surveyResultList-survey-title2' /></th>
						<th class="puptitle" align="center" scope="col" style="text-align: center;"><liferay-ui:message key='edison-virtuallab-surveyResultList-survey-period' /></th>
						<th class="puptitle" align="center" scope="col" style="text-align: center;"><liferay-ui:message key='action.CONFIGURATION' /></th>
					</tr>
				</thead>
				<tbody id="<portlet:namespace/>surveyOptionListBody">
				</tbody>
			</table>
		</div>
		
		<div style="text-align: right; margin:0px 30px 25px 0px;">
			<input class="button06" id="<portlet:namespace/>survey_request_button" name="<portlet:namespace/>survey_request_button" type="submit" value="<liferay-ui:message key='edison-virtuallab-save' />" />
		</div>
	</form>
</div>
<style type="text/css">
.buttonbox0801{
	margin:0 auto;
	overflow:hidden;
	padding-top:18px;
	padding-bottom:5px;
	text-align:center;
	float:right;
}
.h5{
    height: 5px;
    clear: both;
}
</style>

<script type="text/javascript">
<portlet:namespace/>dataSearchList();

$("#<portlet:namespace/>survey-option-dialog").dialog({
	autoOpen: false,
    width: 'auto',
    height: 'auto',
    modal: true,
    resizable: false,
    show: {effect:'fade', speed: 800},
    hide: {effect:'fade', speed: 800},
    open: function(event, ui) {
    	$(this).css('overflow', 'hidden');
    	$(this).parent().removeClass("ui-widget-content");
    	$(this).parent().removeClass("ui-widget");
    	$(this).removeClass("ui-widget-content");
    	$(this).removeClass("ui-dialog-content");
    },
    close: function() {
	
    }
}).dialog("widget").find(".ui-dialog-titlebar").remove();

$("#<portlet:namespace/>survey-option-dialog-close-btn").click(function() {
	$("#<portlet:namespace/>survey-option-dialog").dialog("close");
});

function <portlet:namespace/>dataSearchList() {
	
	var dataForm = {
			"<portlet:namespace/>virtualLabId" : "${virtualLabId}"
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getSurveyOptionURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var surveyOption = msg.surveyOption;
			
			var rowResult;
			$("#<portlet:namespace/>surveyManagerListBody tr:not(:has(#1))").remove();
			
			if(surveyOption.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "2")
						  .css("text-align","center")
						  .css("height", "40px")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>surveyManagerListBody").append($rowResult);
			} else {
				for(var i = 0; i < surveyOption.length; i++) {
					$rowResult = $("<tr/>");
					
					$("<td/>").text(surveyOption[i].surveyTitle)
							  .css("text-align","left")
							  .css("padding-left","50px")
							  .appendTo($rowResult);
					if(surveyOption[i].surveyStartDate == "" || surveyOption[i].surveyEndDate == "") {
						$("<td/>").text("<liferay-ui:message key='edison-virtuallab-survey-no-deadline' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					}else {
						$("<td/>").text(surveyOption[i].surveyStartDate + " ~ " + surveyOption[i].surveyEndDate)
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					$("#<portlet:namespace/>surveyManagerListBody").append($rowResult);
				}
				
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>surveyOption() {
	var dataForm = {
		"<portlet:namespace/>virtualLabId" : "${virtualLabId}"
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getSurveyListURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var surveyList = msg.surveyList;
			var checked = false;
			var rowResult;
			var colorNum = 1;
			$("#<portlet:namespace/>surveyOptionListBody tr:not(:has(#1))").remove();
			
			if(surveyList === undefined || surveyList.length == 0) {
				$rowResult = $("<tr/>").css("height","30px");
				$("<td/>").attr("colspan", "3")
						  .css("text-align","center")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>surveyOptionListBody").append($rowResult);
			} else {
				
				for(var i = 0; i < surveyList.length; i++) {
					$rowResult = $("<tr/>").css("height","30px");
					
 					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
					
					$("<td/>").text(surveyList[i].surveyTitle)
							  .css("text-align","left")
							  .appendTo($rowResult);
					if(surveyList[i].surveyStartDate == "" || surveyList[i].surveyEndDate == "") {
						$("<td/>").text("<liferay-ui:message key='edison-virtuallab-survey-no-deadline' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					}else {
						$("<td/>").text(surveyList[i].surveyStartDate + " ~ " + surveyList[i].surveyEndDate)
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					
					if("${virtualLabId}" == surveyList[i].virtualLabId) {
						checked = true;
						$("<td/>").append(
										  $("<input/>").attr("type","radio")
										  			   .attr("name","<portlet:namespace/>surveySeqNo")
										  			   .attr("value",surveyList[i].surveySeqNo)
										  			   .attr("checked", "checked")
								  )
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else {
						$("<td/>").append(
										  $("<input/>").attr("type","radio")
										  			   .attr("name","<portlet:namespace/>surveySeqNo")
										  			   .attr("value",surveyList[i].surveySeqNo)
								  )
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					$("#<portlet:namespace/>surveyOptionListBody").append($rowResult);
				}
				$rowResult = $("<tr/>").css("height","30px");
				
				if (checked) {
					$("<td/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-not-use' />")
							  .attr("colspan", "2")
							  .css("text-align","left")
							  .appendTo($rowResult);
					$("<td/>").append(
									  $("<input/>").attr("type","radio")
									  			   .attr("name","<portlet:namespace/>surveySeqNo")
									  			   .attr("value","0")
									  )
									  .css("text-align","center")
									  .appendTo($rowResult);
				} else {
					$("<td/>").text("<liferay-ui:message key='edison-virtuallab-surveyResultList-not-use' />")
							  .css("text-align","left")
							  .appendTo($rowResult);
					$("<td/>").text("")
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").append(
									  $("<input/>").attr("type","radio")
									  			   .attr("name","<portlet:namespace/>surveySeqNo")
									  			   .attr("value","0")
									  			   .attr("checked", "checked")
							  )
							  .css("text-align","center")
							  .appendTo($rowResult);
				}
				
				$("#<portlet:namespace/>surveyOptionListBody").append($rowResult);
			}
			
			$("#<portlet:namespace/>survey-option-dialog").dialog("open");
			$("#<portlet:namespace/>survey_request_button").focus();
			
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

</script>