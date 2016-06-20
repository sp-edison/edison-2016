<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ page import="com.liferay.portal.util.PortletKeys"%>

<liferay-portlet:resourceURL var="virtualLabListURL" id="virtualLabList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="virtualLabClassRegisterCheckURL" id="virtualLabClassRegisterCheck" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="virtualLabCreateResourceURL" id="createVirtualLabResource" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="virtualLabCancelResourceURL" id="cancelVirtualLabResource" copyCurrentRenderParameters="false" />

<liferay-portlet:actionURL var="virtualLabCreateURL" portletMode="view" copyCurrentRenderParameters="false" >
	<liferay-portlet:param name="myaction" value="createVirtualLab" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="registerRequestURL" portletMode="view" copyCurrentRenderParameters="false" >
	<liferay-portlet:param name="myaction" value="registerRequest" />
</liferay-portlet:actionURL>

<liferay-portlet:renderURL 
	portletName="edisonorgcodesearch_WAR_edisondefault2016portlet" 
	portletMode="view"
	windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="syscommoncdURL">
	<liferay-portlet:param name="up_code" value="1501"/>
	<liferay-portlet:param name="com_search_type" value="orgSearch"/>
	<liferay-portlet:param name="popup_title" value="edison-org-code-search"/>
	<liferay-portlet:param name="universityFieldNm" value="virtualLabUniversityField"/>
	<liferay-portlet:param name="universityField" value="universityField"/>
</liferay-portlet:renderURL>

<style type="text/css">
	.onHover:hover {
		background:#e0e0e0;
	}
	.backHover1:hover {
		background:#e0e0e0;
		text-decoration: underline;
		font-weight: 600;
	}
	.backHover2:hover {
		background:#e0e0e0;
		text-decoration: underline;
		font-weight: 600;
	}
	.backHover1 {
		background-color:#f8fafe;
	}
</style>

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList(1);
	$("#virtualLab-request-dialog").dialog({
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
	
	$("#virtualLab-request-dialog-close-btn").click(function() {
		$("#virtualLab-request-dialog").dialog("close");
	});
	
	$("#register-request-dialog").dialog({
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
	
	$("#register-request-dialog-close-btn").click(function() {
		$("#register-request-dialog").dialog("close");
	});
	
	$("#request-denied-dialog").dialog({
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
	$("#request-denied-dialog-close-btn").click(function() {
		$("#request-denied-dialog").dialog("close");
	});
	
	$(".virtualLab-request-button").click(function() {
		$("#<portlet:namespace/>select_languageId").val("${languageId}");
		$("#<portlet:namespace/>virtualLabId").val("0");
		$("#<portlet:namespace/>virtualLabTitle").val("");
		$("#<portlet:namespace/>virtualLabPersonName").val("");
		$("#<portlet:namespace/>virtualLabUniversityField").val("");
		$("#<portlet:namespace/>virtualLabDescription").val("");
		$("#<portlet:namespace/>universityField").val("");
		$("#virtualLab-request-dialog").dialog( "open" );
	});
	
});

function <portlet:namespace/>syscommoncdPopup(){
	var URL = "<%=syscommoncdURL%>";
	w = 850;
	h = 550;		
	x = (screen.availWidth - w) / 2;
	y = (screen.availHeight - h) / 2;
	var options = "width="+w+", height="+h+", left="+x+",top="+y+",toolbar=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no";
	var openPop;
	if(openPop != null){
		openPop.focus();
	}else{
		openPop = window.open(URL, "syscommoncdPopup",options);
		openPop.focus();
	}
}

function <portlet:namespace/>dataSearchList(pageNumber) {
	if(pageNumber == 0) {
		$("#<portlet:namespace/>cur_page").val(1);
		$("#<portlet:namespace/>search_parameter").val("");
	} else {
		$("#<portlet:namespace/>cur_page").val(pageNumber);
	}
	
	var searchForm = $("form[name=searchForm]").serialize();
	
	jQuery.ajax({
		type: "POST",
		url: "<%=virtualLabListURL%>",
		async : false,
		data : searchForm,
		success: function(msg) {
			var virtualLabList = msg.virtualLabList;
			var virtualLabAuthList = msg.virtualLabAuthList;
			var virtualLabClassRegisterList = msg.virtualLabClassRegisterList;
			var curPage = msg.curPage;
			var selectLine = msg.selectLine;
			var virtualLabCount = msg.virtualLabCount - ((curPage -1) * selectLine);
			var pageList = msg.pageList;
			var colorNum = 1;
			
			var rowResult;
			$("#virtualLabListBody tr:not(:has(#1))").remove();
			
			if(virtualLabClassRegisterList.length != 0) {
				for(var i = 0; i < virtualLabClassRegisterList.length; i++) {
					$rowResult = $("<tr/>");
					
 					if(colorNum%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
					colorNum++;
 					
					if(virtualLabClassRegisterList[i].requestSort == "CONFIRM" || virtualLabClassRegisterList[i].requestSort == "TEMP") {
						$("<td/>").text("<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-take-class' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
						$rowResult.attr("onClick","<portlet:namespace/>registerCheck('" + virtualLabClassRegisterList[i].virtualLabId + "','" + virtualLabClassRegisterList[i].classId + "')")
								  .addClass("onHover")
								  .css("cursor","pointer");
					} else if (virtualLabClassRegisterList[i].requestSort == "REQUEST") {
						$("<td/>").css("text-align","center")
								  .append($("<p/>").text("<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-during-registration' />"))
								  .append($("<input/>").attr("value", "<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-cancel-registration' />")
													   .addClass("button04")
													   .attr("type", "button")
													   .css("text-align","center")
													   .attr("onClick","<portlet:namespace/>registerCheck('" + virtualLabClassRegisterList[i].virtualLabId + "','" + virtualLabClassRegisterList[i].classId + "')")
								  )
								  .appendTo($rowResult);
					} else if (virtualLabClassRegisterList[i].requestSort == "DENIED") {
						$("<td/>").css("text-align","center")
								  .append($("<p/>").text("<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-registration-denial' />")
												   .css("color", "red")
								  )
								  .append($("<input/>").attr("value", "<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-reason-denial' />")
													   .addClass("button04")
													   .attr("type", "button")
													   .attr("onClick","<portlet:namespace/>openDeniedDialog('" + "<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-reason-denial' />" + "','" + virtualLabClassRegisterList[i].processNote + "','0')")
								  )
								  .appendTo($rowResult);
					} else {
						$("<td/>").text("<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-unknown-class' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					$("<td/>").text(virtualLabClassRegisterList[i].virtualLabTitle)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassRegisterList[i].virtualLabUniversityField)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassRegisterList[i].virtualLabPersonName)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassRegisterList[i].classTitle)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualLabClassRegisterList[i].classCreateDt)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("#virtualLabListBody").append($rowResult);
				}
			}
			
			if(virtualLabAuthList.length != 0) {
				var tempVirtualLabId = 0;
				for(var i = 0; i < virtualLabAuthList.length; i++) {
					$rowResult = $("<tr/>");
					
 					if(colorNum%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
					colorNum++;
					
					if (tempVirtualLabId == virtualLabAuthList[i].virtualLabId){
						$("<td/>").text(virtualLabAuthList[i].classTitle)
								  .css("text-align","center")
								  .appendTo($rowResult);
						$("<td/>").text(virtualLabAuthList[i].classCreateDt)
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else {
						if (virtualLabAuthList[i].virtualLabStatus == "1401001") {
							$("<td/>").text("<liferay-ui:message key='edison-virtuallab-lab-creation-request' />")
									  .css("text-align","center")
									  .attr("rowSpan", virtualLabAuthList[i].classCount)
									  .append($("<input/>").attr("type", "button")
											  			   .addClass("button04")
														   .attr("value", "<liferay-ui:message key='edison-virtuallab-lab-creation-request-cancel' />")
														   .attr("onclick", "<portlet:namespace/>cancelVirtualLabRequest('" + virtualLabAuthList[i].virtualLabId + "')")
									  )
									  .appendTo($rowResult);
						} else if (virtualLabAuthList[i].virtualLabStatus == "1401003") {
							$("<td/>").css("text-align","center")
									  .attr("rowSpan", virtualLabAuthList[i].classCount)
									  .append($("<p/>").text("<liferay-ui:message key='edison-virtuallab-lab-creation-request-denial' />")
											  		   .css("color", "red")
									  )
									  .append($("<input/>").attr("type", "button")
											  			   .addClass("button04")
														   .attr("value", "<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-reason-denial' />")
														   .attr("onclick", "<portlet:namespace/>openDeniedDialog('" + "<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-reason-denial' />" + "','" + virtualLabAuthList[i].virtualLabConfirmDescription + "','" + virtualLabAuthList[i].virtualLabId + "')")
									  )
									  .appendTo($rowResult);
						} else if (virtualLabAuthList[i].virtualLabStatus == "1401002") {
							$("<td/>").text("<liferay-ui:message key='edison-virtuallab-my-lab' />")
									  .attr("onClick","<portlet:namespace/>moveVirtualLab('" + virtualLabAuthList[i].virtualLabId + "')")
									  .css("text-align","center")
									  .css("color", "red")
									  .css("cursor","pointer")
									  .attr("rowSpan", virtualLabAuthList[i].classCount)
									  .appendTo($rowResult);
						}
						$("<td/>").text(virtualLabAuthList[i].virtualLabTitle)
								  .css("text-align","center")
								  .attr("rowSpan", virtualLabAuthList[i].classCount)
								  .appendTo($rowResult);
						$("<td/>").text(virtualLabAuthList[i].virtualLabUniversityField)
								  .css("text-align","center")
								  .attr("rowSpan", virtualLabAuthList[i].classCount)
								  .appendTo($rowResult);
						$("<td/>").text(virtualLabAuthList[i].virtualLabPersonName)
								  .css("text-align","center")
								  .attr("rowSpan", virtualLabAuthList[i].classCount)
								  .appendTo($rowResult);
						if (virtualLabAuthList[i].classCount == 0) {
							$("<td/>").text("<liferay-ui:message key='edison-virtuallab-no-status' />")
							  .css("text-align","center")
							  .attr("colSpan", "2")
							  .appendTo($rowResult);
						} else {
							$("<td/>").text(virtualLabAuthList[i].classTitle)
									  .css("text-align","center")
									  .appendTo($rowResult);
							$("<td/>").text(virtualLabAuthList[i].classCreateDt)
									  .css("text-align","center")
									  .appendTo($rowResult);
						}
						tempVirtualLabId = virtualLabAuthList[i].virtualLabId;
					}
					$("#virtualLabListBody").append($rowResult);
				}

			}
			
			if(virtualLabList.length == 0) {
				$rowResult = $("<tr/>");
				
				if(colorNum%2 == 1){
					$rowResult.addClass("tablebgtr");
				}
				colorNum++;
					
				$("<td/>").attr("colspan", "6")
						  .css("text-align","center")
						  .css("height", "40px")
						  .text("<liferay-ui:message key='edison-virtuallab-no-status' />")
						  .appendTo($rowResult);
				$("#virtualLabListBody").append($rowResult);
			} else {
				var tempVirtualLabId = 0;
				for(var i = 0; i < virtualLabList.length; i++) {
					$rowResult = $("<tr/>");
					colorNum++;
					
					if (tempVirtualLabId == virtualLabList[i].virtualLabId){
						if(colorNum%2 == 1){
							$("<td/>").text(virtualLabList[i].classTitle)
									  .css("text-align","center")
									  .css("cursor","pointer")
									  .css("color", "#29547e")
									  .addClass("backHover1")
									  .attr("onClick","<portlet:namespace/>registerCheck('" + virtualLabList[i].virtualLabId + "','" +  virtualLabList[i].classId + "')")
									  .appendTo($rowResult);
						} else {
							$("<td/>").text(virtualLabList[i].classTitle)
									  .css("text-align","center")
									  .css("cursor","pointer")
									  .css("color", "#29547e")
									  .addClass("backHover2")
									  .attr("onClick","<portlet:namespace/>registerCheck('" + virtualLabList[i].virtualLabId + "','" +  virtualLabList[i].classId + "')")
									  .appendTo($rowResult);
						}
						$("<td/>").text(virtualLabList[i].classCreateDt)
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else {
						$("<td/>").text(virtualLabCount--)
								  .css("text-align","center")
								  .attr("rowSpan", virtualLabList[i].classCount)
								  .appendTo($rowResult);
						if("${isAdministrator}"=="true" || "${isSiteAdministrator}"=="true") {
							$("<td/>").text(virtualLabList[i].virtualLabTitle)
									  .css("text-align","center")
									  .css("cursor","pointer")
									  .css("color", "#29547e")
									  .addClass("backHover2")
									  .attr("onClick","<portlet:namespace/>moveVirtualLab('" + virtualLabList[i].virtualLabId + "')")
									  .attr("rowSpan", virtualLabList[i].classCount)
									  .appendTo($rowResult);
						} else {
							$("<td/>").text(virtualLabList[i].virtualLabTitle)
									  .css("text-align","center")
									  .attr("rowSpan", virtualLabList[i].classCount)
									  .appendTo($rowResult);
						}
						$("<td/>").text(virtualLabList[i].virtualLabUniversityFieldNm)
								  .css("text-align","center")
								  .attr("rowSpan", virtualLabList[i].classCount)
								  .appendTo($rowResult);
						$("<td/>").text(virtualLabList[i].virtualLabPersonName)
								  .css("text-align","center")
								  .attr("rowSpan", virtualLabList[i].classCount)
								  .appendTo($rowResult);
						if(colorNum%2 == 1){
							$("<td/>").text(virtualLabList[i].classTitle)
									  .css("text-align","center")
									  .css("cursor","pointer")
									  .css("color", "#29547e")
									  .addClass("backHover1")
									  .attr("onClick","<portlet:namespace/>registerCheck('" + virtualLabList[i].virtualLabId + "','" + virtualLabList[i].classId + "')")
									  .appendTo($rowResult);
						} else {
							$("<td/>").text(virtualLabList[i].classTitle)
									  .css("text-align","center")
									  .css("cursor","pointer")
									  .css("color", "#29547e")
									  .addClass("backHover2")
									  .attr("onClick","<portlet:namespace/>registerCheck('" + virtualLabList[i].virtualLabId + "','" + virtualLabList[i].classId + "')")
									  .appendTo($rowResult);
						}
						$("<td/>").text(virtualLabList[i].classCreateDt)
								  .css("text-align","center")
								  .appendTo($rowResult);
						tempVirtualLabId = virtualLabList[i].virtualLabId;
					}
					$("#virtualLabListBody").append($rowResult);
				}
			}
			$("#pageListDiv").html(pageList);
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>registerCheck(virtualLabId, classId) {
	var checkForm = {
		"<portlet:namespace/>virtualLabId" : virtualLabId,
		"<portlet:namespace/>classId" : classId
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=virtualLabClassRegisterCheckURL%>",
		async : false,
		data : checkForm,
		success: function(msg) {
			var virtualLabClassUserInfo = msg.virtualLabClassUserInfo;
			
			if(msg.result == "ADMINISTRATOR") {
				window.location.href = "${classURL}" + "&classId=" + classId;
			}else {
				$("#<portlet:namespace/>registerClassRequestNo").val(virtualLabClassUserInfo.classId);
				$("#classPersonnel").text(virtualLabClassUserInfo.classPersonnel);
				$("#totalUserCount").text(virtualLabClassUserInfo.totalUserCount);
				$("#registerClassTitle").text(virtualLabClassUserInfo.classTitle);
				$("#registerClassProfessor").text(virtualLabClassUserInfo.virtualLabPersonName);
				$("#registerClassCompany").text(virtualLabClassUserInfo.virtualLabUniversityField);
				$("#registerClassCount").text("(" + virtualLabClassUserInfo.totalUserCount + "/" + virtualLabClassUserInfo.classPersonnel + ")");
				
				if(virtualLabClassUserInfo.requestSort == "REQUEST") {
					requestDialog(virtualLabClassUserInfo.virtualUserId);
				} else if(virtualLabClassUserInfo.requestSort == "DENIED") {
					alert(virtualLabClassUserInfo.processNote);
				} else if(virtualLabClassUserInfo.requestSort == "CONFIRM" || virtualLabClassUserInfo.requestSort == "TEMP") {
					window.location.href = "${classURL}" + "&classId=" + virtualLabClassUserInfo.classId;
				} else if(virtualLabClassUserInfo.totalUserCount >= virtualLabClassUserInfo.classPersonnel){
					alert("<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-over-personnel' />");
				} else {
					requestDialog(virtualLabClassUserInfo.virtualUserId);
				}
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>moveVirtualLab(virtualLabId) {
	window.location.href = "${labURL}" + "&virtualLabId=" + virtualLabId;
}

function requestDialog(virtualUserId) {
	if (virtualUserId == undefined) {
		$('#register_request_button').val("<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-course-registration' />");
		$("#<portlet:namespace/>registerVirtualUserId").val(0);
	} else {
		$('#register_request_button').val("<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-cancel-registration' />");
		$("#<portlet:namespace/>registerVirtualUserId").val(virtualUserId);
	}
	$("#register-request-dialog").dialog( "open" );
}

function <portlet:namespace/>checkValidation(form) {
	if (form.submitted) return false;
	if(!checkValue(form.<portlet:namespace/>virtualLabPersonName, "<liferay-ui:message key='edison-table-list-header-tutor' />", 1, 30)) {
		return false;
	} else if (!checkValue(form.<portlet:namespace/>virtualLabTitle, "<liferay-ui:message key='edison-virtuallab-tablerow-virtuallab' />", 1, 75)) {
		return false;
	} else if (!checkValue(form.<portlet:namespace/>universityField, "<liferay-ui:message key='edison-create-account-field-title-university' />", 1, 10)) {
		return false;
	} else if (!checkValue(form.<portlet:namespace/>virtualLabDescription, "<liferay-ui:message key='edison-table-list-header-resume' />", 1, 100)) {
		return false;
	} else {
		form.submitted = true;
		return true;
	}
	return false;
}

function changeLanguage() {
	if(!<portlet:namespace/>checkValidation(document.createVirtualLabForm)) {
		$("#<portlet:namespace/>select_languageId").val("${languageId}");
	} else {
		var checkForm = {
			"<portlet:namespace/>virtualLabId" : $("#<portlet:namespace/>virtualLabId").val(),
			"<portlet:namespace/>virtualLabTitle" : $("#<portlet:namespace/>virtualLabTitle").val(),
			"<portlet:namespace/>virtualLabPersonName" : $("#<portlet:namespace/>virtualLabPersonName").val(),
			"<portlet:namespace/>universityField" : $("#<portlet:namespace/>universityField").val(),
			"<portlet:namespace/>virtualLabDescription" : $("#<portlet:namespace/>virtualLabDescription").val(),
			"<portlet:namespace/>select_languageId" : $("#<portlet:namespace/>select_languageId").val()
		};
		
		jQuery.ajax({
			type: "POST",
			url: "<%=virtualLabCreateResourceURL%>",
			async : false,
			data : checkForm,
			success: function(msg) {
				var virtualLabInfo = msg.virtualLabInfo;
				alert("<liferay-ui:message key='edison-virtuallab-save-data' />");
				$("#<portlet:namespace/>virtualLabId").val(virtualLabInfo.virtualLabId);
				$("#<portlet:namespace/>virtualLabTitle").val(virtualLabInfo.virtualLabTitle);
				$("#<portlet:namespace/>virtualLabPersonName").val(virtualLabInfo.virtualLabPersonName);
				$("#<portlet:namespace/>universityField").val(virtualLabInfo.universityField);
				$("#<portlet:namespace/>virtualLabUniversityField").val(virtualLabInfo.virtualLabUniversityField);
				$("#<portlet:namespace/>virtualLabDescription").val(virtualLabInfo.virtualLabDescription);
				
			},error:function(msg,e){ 
				alert(e);
				return false;
			}
		});
	}
}

function <portlet:namespace/>cancelVirtualLabRequest(virtualLabId) {
	if(confirm("<liferay-ui:message key='edison-virtuallab-cancel-request-alert' />")){	
		var checkForm = {
			"<portlet:namespace/>virtualLabId" : virtualLabId
		}
		
		jQuery.ajax({
			type: "POST",
			url: "<%=virtualLabCancelResourceURL%>",
			async : false,
			data : checkForm,
			success: function(msg) {
				<portlet:namespace/>dataSearchList();
			},error:function(msg,e){ 
				alert(e);
				return false;
			}
		});
	}
}

function deleteVirtualLabRequest() {
	var tempVirtualLabId = $("#<portlet:namespace/>tempVirtualLabId").val();
	<portlet:namespace/>cancelVirtualLabRequest(tempVirtualLabId);
	$("#request-denied-dialog").dialog("close");
}

function <portlet:namespace/>openDeniedDialog(title, content, virtualLabId) {
	if(virtualLabId > 0) {
		$("#register_delete_button").css("visibility", "visible");
	}else {
		$("#register_delete_button").css("visibility", "hidden");
	}
	$("#<portlet:namespace/>tempVirtualLabId").val(virtualLabId);
	$("#request-denied-title").text(title);
	$("#request-denied-content").text(content);
	$("#request-denied-dialog").dialog("open");
}

function <portlet:namespace/>onKeyDown() {
	if(event.keyCode == 13 && $("#<portlet:namespace/>search_parameter").val() != ""){
		<portlet:namespace/>dataSearchList();
	}
}

</script>
<h1>
	<liferay-ui:message key='edison-virtuallab-list' />
</h1><!--e h1-->
<div class="tabletopbox">
	<form id="searchForm" name="searchForm" method="post" onsubmit="return false;">
		<input id="<portlet:namespace/>cur_page" name="<portlet:namespace/>cur_page" type="hidden" value="1"/>
		<div class="search">
			<div class="searchbox">
				<input id="<portlet:namespace/>search_parameter" name="<portlet:namespace/>search_parameter" type="text" maxlength="15" placeholder="<liferay-ui:message key='edison-virtuallab-placeholder' />" onKeyDown="<portlet:namespace/>onKeyDown()"/>
				<input id="search_button" name="search_button" type="button" class="btnsearch" onClick="<portlet:namespace/>dataSearchList()"/>
			</div>
			<input id="total_search_button" name="total_search_button" type="button" value="<liferay-ui:message key='edison-button-all-search' />" class="button01" onClick="<portlet:namespace/>dataSearchList(0)" />
		</div>
		<div class="tabletopright">
			<select id="<portlet:namespace/>select_line" name="<portlet:namespace/>select_line" onChange="<portlet:namespace/>dataSearchList(0)" class="selectview">
				<option value="5">5<liferay-ui:message key='edison-search-views' /></option>
				<option value="10">10<liferay-ui:message key='edison-search-views' /></option>
				<option value="20">20<liferay-ui:message key='edison-search-views' /></option>
				<option value="40">40<liferay-ui:message key='edison-search-views' /></option>
			</select>
		</div>
	</form>
</div>
<div class="table1_list borderno">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="12%" />
			<col width="20%" />
			<col width="10%" />
			<col width="10%" />
			<col width="38%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-virtuallab' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-affiliate' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-professor' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-virtualclass' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-class-create-date' /></th>
			</tr>
		</thead>
		<tbody id="virtualLabListBody">
		</tbody>
	</table>
</div>
<div id="spaceDiv" align="center"></div>
<div id="pageListDiv" class="paging"></div>

<div class="buttonbox" style="position: absolute; bottom: 24px; width:auto; right:1%;">
	<c:choose>
		<c:when test="${role eq 'LABOWNER' }">
			<input id="virtualLab-request-button" name="virtualLab-request-button" type="button" class="button0801 virtualLab-request-button" value="<liferay-ui:message key='edison-virtuallab-creation' />" />
		</c:when>
		<c:otherwise>
			<input id="virtualLab-request-button" name="virtualLab-request-button" type="button" class="button0801 virtualLab-request-button" value="<liferay-ui:message key='edison-virtuallab-creation-request' />" />
		</c:otherwise>
	</c:choose>
</div>

<div id="virtualLab-request-dialog" title="<liferay-ui:message key='edison-virtuallab-request-infomation' />" class="newWindow" style="background-color: #fff; display:none;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-request-infomation' />
			</div>
		</div>
		<div class="newWclose">
			<img id="virtualLab-request-dialog-close-btn" name="virtualLab-request-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<form id="createVirtualLabForm" name="createVirtualLabForm" method="post" action="<%= virtualLabCreateURL %>" onsubmit="return <portlet:namespace/>checkValidation(this);" style="margin:0px;">
		<input id="<portlet:namespace/>virtualLabId" name="<portlet:namespace/>virtualLabId" type="hidden" value="0">
		<input id="<portlet:namespace/>universityField" name="<portlet:namespace/>universityField" type="hidden" value="1501005">
		<div class="newWcont01">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="width:715px; table-layout: fixed;">
			<colgroup>
				<col width="20%" />
				<col width="30%" />
				<col width="20%" />
				<col width="30%" />
			</colgroup>
			<tbody>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key='edison-virtuallab-request-user-id' /></td>
					<td class="puptxt">${userInfomation.screenName}</td>
					<td class="puptitle"><liferay-ui:message key='edison-virtuallab-request-user-name' /></td>
					<td class="puptxt">${userInfomation.fullName}</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key='edison-table-list-header-tutor' /></td>
					<td class="puptxt" colspan="3">
						<liferay-ui:input-localized id="virtualLabPersonName" name="virtualLabPersonName" xml="" style="display: inline-block; margin:4px; width:150px;" type="input"/>
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key='edison-virtuallab-tablerow-virtuallab' /></td>
					<td class="puptxt">
						<liferay-ui:input-localized id="virtualLabTitle" name="virtualLabTitle" xml="" style="display: inline-block; margin:4px; width:150px;" type="input"/>
					</td>
					<td class="puptitle" style="word-wrap: break-word;"><liferay-ui:message key='edison-create-account-field-title-university' /></td>
					<td class="puptxt">
						<input id="<portlet:namespace/>virtualLabUniversityField" name="<portlet:namespace/>virtualLabUniversityField" type="text" maxlength="10" readonly="readonly" style="width:120px; margin-bottom:0px; "/>
						<input id="virtualLab_search_university_button" name="virtualLab_search_university_button" onclick="<portlet:namespace/>syscommoncdPopup();" type="button" value="<liferay-ui:message key='edison-button-search' />" class="button06" />
					</td>
				</tr>
				<tr class="puptrline">
					<td class="puptitle"><liferay-ui:message key='edison-table-list-header-resume' /></td>
					<td class="puptxt" colspan="3">
						<liferay-ui:input-localized id="virtualLabDescription" name="virtualLabDescription" xml=""  rows="5" spellcheck="false" style="width: 85%; resize:none; margin:5px;" type="textarea"/>
					</td>
				</tr>
			</tbody>
		</table>
		</div>
		<div style="text-align: right; margin:0px 25px 30px 0px;">
			<c:choose>
				<c:when test="${role eq 'LABOWNER' }">
					<input id="virtualLab_creation_button" name="virtualLab_creation_button" type="submit" value="<liferay-ui:message key='edison-virtuallab-creation' />" class="button06" />
				</c:when>
				<c:otherwise>
					<input id="virtualLab_creation_button" name="virtualLab_creation_button" type="submit" value="<liferay-ui:message key='edison-virtuallab-creation-request' />" class="button06" />
				</c:otherwise>
			</c:choose>
		</div>
	</form>
</div>

<div id="register-request-dialog" title="<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-course-registration' />" class="newWindow" style="background-color: #fff; display:none;" >
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-class-registration-status' />
			</div>
		</div>
		<div class="newWclose">
			<img id="register-request-dialog-close-btn" name="register-request-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<form id="registerRequestForm" name="registerRequestForm" method="post" action="<%= registerRequestURL %>" onsubmit="">
		<input id="classPersonnel" name="classPersonnel" type="hidden" value="0">
		<input id="totalUserCount" name="totalUserCount" type="hidden" value="0">
		<input id="<portlet:namespace/>registerVirtualUserId" name="<portlet:namespace/>registerVirtualUserId" type="hidden">
		<input id="<portlet:namespace/>registerClassRequestNo" name="<portlet:namespace/>registerClassRequestNo" type="hidden">
		<div class="newWcont01">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="width:500px;">
				<colgroup>
					<col width="50%" />
					<col width="50%" />
				</colgroup>
				<tbody>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='edison-virtuallab-tablerow-virtualclass' /> : </td>
						<td class="puptitle" id="registerClassTitle"></td>
					</tr>
					<tr>
						<td class="puptxt2"><liferay-ui:message key='edison-virtuallab-tablerow-professor' /> : </td>
						<td class="puptxt2" id="registerClassProfessor"></td>
					</tr>
					<tr>
						<td class="puptxt2"><liferay-ui:message key='edison-virtuallab-tablerow-affiliation' /> : </td>
						<td class="puptxt2" id="registerClassCompany"></td>
					</tr>
					<tr>
						<td class="puptxt2"><liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-student-number' />(<liferay-ui:message key='edison-virtuallab-course-current' />/<liferay-ui:message key='edison-virtuallab-course-maximum' />) : </td>
						<td class="puptxt2" id="registerClassCount"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="text-align: right; margin:0px 30px 25px 0px;">
			<input id="register_request_button" name="register_request_button" class="button06" type="submit" value="<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-course-registration' />" />
		</div>
	</form>
</div>

<div id="request-denied-dialog" title="<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-course-registration' />" class="newWindow" style="background-color: #fff; display:none;" >
	<input id="<portlet:namespace/>tempVirtualLabId" name="<portlet:namespace/>tempVirtualLabId" type="hidden">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-reason-denial' />
			</div>
		</div>
		<div class="newWclose">
			<img id="request-denied-dialog-close-btn" name="request-denied-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	
	<div class="newWcont01">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="width:350px; min-height:50px;">
			<tbody>
				<tr>
					<td id="request-denied-content" class="puptxt2"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div style="text-align: right; margin:0px 25px 30px 0px;">
		<input id="register_delete_button" name="register_delete_button" class="button06" type="button" onclick="deleteVirtualLabRequest()" value="<liferay-ui:message key='edison-virtuallab-cancel-request' />" />
	</div>
</div>
