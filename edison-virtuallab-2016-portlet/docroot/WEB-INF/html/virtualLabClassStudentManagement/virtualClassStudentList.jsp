<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>

<liferay-portlet:resourceURL var="virtualClassStudentListURL" id="virtualClassStudentList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="updateClassRegisterURL" id="updateClassRegister" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="addVirtualClassStudentURL" id="addVirtualClassStudent" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="deleteVirtualClassUserURL" id="deleteVirtualClassUser" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="updateVirtualClassUserURL" id="updateVirtualClassUser" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getTempUserInfomationURL" id="getTempUserInfomation" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="studentPasswordInitURL" id="studentPasswordInit" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="registerDeniedURL" id="registerDenied" copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="virtualLabClassUserCreateBatchURL" id="studentCreateBatch" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="virtualLabId" value="${virtualLabClassInfo.virtualLabId}" />
	<liferay-portlet:param name="classId" value="${virtualLabClassInfo.classId}" />
	<liferay-portlet:param name="classTitle" value="${virtualLabClassInfo.classTitle}" />
	<liferay-portlet:param name="virtualClassCd" value="${virtualLabClassInfo.virtualClassCd}" />
	<liferay-portlet:param name="virtualLabUniversityField" value="${virtualLabClassInfo.virtualLabUniversityField}" />
	<liferay-portlet:param name="virtualLabUniversityFieldNm" value="${virtualLabClassInfo.virtualLabUniversityFieldNm}" />
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="userCreateBatchURL" id="userCreateBatch" copyCurrentRenderParameters="false">
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="studentExcelInsertURL" id="studentExcelInsert" copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>

<script src="<%=request.getContextPath()%>/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.blockUI.js"></script>

<style type="text/css">
.buttonbox0802{margin:0 auto; overflow:hidden;  padding-bottom:3px; text-align:center; float:right;}
</style>

<script type="text/javascript">
AUI().ready(function() {
	console.log("${maxQuestionSeqNo}");
	<portlet:namespace/>dataSearchList();
	$("#<portlet:namespace/>virtualLabClass-register-dialog").dialog({
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
	    	$(".dialogInput").val("");
	    },
	    close: function() {
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	$("#<portlet:namespace/>virtualLabClass-register-dialog-close-btn").click(function() {
		$("#<portlet:namespace/>virtualLabClass-register-dialog").dialog("close");
	});
	
	$("#<portlet:namespace/>tempUser-update-dialog").dialog({
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
	
	$("#<portlet:namespace/>tempUser-update-dialog-close-btn").click(function() {
		$("#<portlet:namespace/>tempUser-update-dialog").dialog("close");
	});
	
	$("#<portlet:namespace/>addStudentBtn").click(function() {
		$("#<portlet:namespace/>virtualLabClass-register-dialog").dialog("open");
	});
	
	$("#<portlet:namespace/>createExcel-dialog").dialog({
		resizable: false,
		height:'auto',
		width:'auto',
		modal: true,
		draggable: false,
		autoOpen : false,
	    open: function(event, ui) {
	    	$(this).css('overflow', 'hidden');
	    	$(this).parent().removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget");
	    	$(this).removeClass("ui-widget-content");
	    	$(this).removeClass("ui-dialog-content");
	    },
		create : function(event, ui){
		}
		/*
	    ,
		buttons: {
			fileCheck: {
				text:"<liferay-ui:message key='edison-virtuallab-file-check' />",
				click : function(){
						if($("#<portlet:namespace/>excelFile").val() != ""){
							$(this).dialog("close");
							$.ajaxFileUpload({
								url:"<%=virtualLabClassUserCreateBatchURL%>", 
								secureuri:false,
								fileElementId: "<portlet:namespace/>excelFile",
								dataType: 'text',
								async : false,
								success: function (data, status){
									var dataMap = eval("(" + data + ")");
									var dataSize = dataMap.dataList.length;
									var tbodyObj = $("#<portlet:namespace/>excel-validation-result");
									$(tbodyObj).empty();
									
									if(dataSize != 0){
										
										for(var i=0; i < dataSize; i++){
											
											if(dataMap.dataList[i].errCode == 'Y'){
												
												$trNode = $("<tr></tr>");
												$("<td></td>").append(
																	  $("<input/>").attr("disabled","disabled")
																	  			   .attr("type","checkbox")
																	  			   .val(dataMap.dataList[i].newSeqNo)
																	  ).appendTo($trNode);
												$("<td></td>").text(dataMap.dataList[i].seqNo)
															  .appendTo($trNode);
												$("<td></td>").text(dataMap.dataList[i].userName)
															  .appendTo($trNode);
												$("<td></td>").text(dataMap.dataList[i].userStudentNumber)
															  .appendTo($trNode);
												$("<td></td>").text(dataMap.dataList[i].userScreenName)
															  .appendTo($trNode);
												$("<td></td>").text(dataMap.dataList[i].errMsg)
															  .appendTo($trNode);
												
												$trNode.appendTo($(tbodyObj));
											}else{
												$trNode = $("<tr></tr>");
												$("<td></td>").append(
																	  $("<input/>").attr("name","<portlet:namespace/>seqNo")
																	  			   .attr("checked", "checked")
																	  			   .attr("type","checkbox")
																	  			   .val(dataMap.dataList[i].newSeqNo)
																	  ).appendTo($trNode);
												$("<td></td>").text(dataMap.dataList[i].seqNo)
														 	 .appendTo($trNode); 					
												$("<td></td>").text(dataMap.dataList[i].userName)
															  .appendTo($trNode); 					
												$("<td></td>").text(dataMap.dataList[i].userStudentNumber)
														 	 .appendTo($trNode);
												$("<td></td>").text(dataMap.dataList[i].userScreenName)
															  .appendTo($trNode);
												$("<td></td>").text("<liferay-ui:message key='edison-virtuallab-valid' />")
															  .appendTo($trNode);
												$trNode.appendTo($(tbodyObj));
											}
										}
									}
								}, error : function (data, status, e){
									alert("createExcel" + e);
								}, complete : function(){
									$("#<portlet:namespace/>excelvalidation-dialog").dialog("open");
								}
							});
						} else {
							alert("<liferay-ui:message key='edison-virtuallab-select-file' />");
						}
					}
				}
			},
			cancel :{
				text:"<liferay-ui:message key='edison-button-cancel' />",
				click : function(){
					$( this ).dialog( "close" );
				}
			}
			,
			userAdd : {
				text:"<liferay-ui:message key='edison-virtuallab-user-registration' />",
				click : function(){
					if($("#<portlet:namespace/>excelFile").val() != ""){
						$(this).dialog("close");
						$.ajaxFileUpload({
							url:"<%=userCreateBatchURL%>", 
							secureuri:false,
							fileElementId: "<portlet:namespace/>excelFile",
							dataType: 'text',
							async : false,
							success: function (data, status){
								if(data == "200") {
									alert("<liferay-ui:message key='edison-virtuallab-user-registration-finishied' />");
								} else {
									alert("<liferay-ui:message key='edison-virtuallab-user-registration-failed' />");
								}
								
							}, error : function (data, status, e){
								alert("createExcel" + e);
							}, complete : function(){
							}
						});
					} else {
						alert("<liferay-ui:message key='edison-virtuallab-select-file' />");
					}
				}
			}
		},
		*/
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	$("#<portlet:namespace/>createExcel-close-btn").click(function() {
		$("#<portlet:namespace/>createExcel-dialog").dialog("close");
	});
	
	$("#<portlet:namespace/>excelvalidation-dialog").dialog({
		resizable: false,
		height:'auto',
		width:'auto',
		modal: true,
		draggable: false,
		autoOpen : false,
	    open: function(event, ui) {
	    	$(this).css('overflow', 'hidden');
	    	$(this).parent().removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget");
	    	$(this).removeClass("ui-widget-content");
	    	$(this).removeClass("ui-dialog-content");
	    },
		create : function(event, ui){
		}
		/*
		,
		buttons: {
			'aa' : {
				text:"<liferay-ui:message key='edison-button-register' />",
				click : function(){
					$( this ).dialog( "close" );
					var excelForm = $("form[name=excelForm]").serialize();
					jQuery.ajax({
						type: "POST",
						url: "<%=studentExcelInsertURL%>",
						async : false,
						data  : excelForm,
						success: function(result) {
							<portlet:namespace/>dataSearchList();
						},error:function(data,e){
							alert("dialog" + e);
							return false;
						},complete:function(){
							dataSearchList("1");
						}
					});
					
				}
			},
			'bb' :{
				text:"<liferay-ui:message key='edison-button-cancel' />",
				click : function(){
					$( this ).dialog( "close" );
				}
			}
		}
		*/
	}).dialog("widget").find(".ui-dialog-titlebar").remove();;
	
	$("#<portlet:namespace/>excelvalidation-close-btn").click(function() {
		$("#<portlet:namespace/>excelvalidation-dialog").dialog("close");
	});
	
	$("#<portlet:namespace/>register-denied-dialog").dialog({
		autoOpen: false,
		width: 455,
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
	
	$("#<portlet:namespace/>register-denied-dialog-close-btn").click(function() {
		$("#<portlet:namespace/>register-denied-dialog").dialog("close");
	});
});

function studentExcelInsert(){
	$("#<portlet:namespace/>createExcel-dialog").dialog("open");
}

function formCheck(form) {
	if(form.submitted){
		return false;
	}
	form.submitted = true;
	return true;
}

function fileCheck() {
	if($("#<portlet:namespace/>excelFile").val() != ""){
		$("#<portlet:namespace/>createExcel-dialog").dialog("close");
		$.ajaxFileUpload({
			url:"<%=virtualLabClassUserCreateBatchURL%>", 
			secureuri:false,
			fileElementId: "<portlet:namespace/>excelFile",
			dataType: 'text',
			async : false,
			success: function (data, status){
				var dataMap = eval("(" + data + ")");
				var dataSize = dataMap.dataList.length;
				var tbodyObj = $("#<portlet:namespace/>excel-validation-result");
				var alertContentCheck1 = false;
				var alertContentCheck2 = false;
				
				$(tbodyObj).empty();
				
				if(dataSize != 0){
					
					for(var i=0; i < dataSize; i++){
						
						if(dataMap.dataList[i].errCode == 'Y'){
							
							$trNode = $("<tr></tr>");
							$("<td></td>").append(
												  $("<input/>").attr("disabled","disabled")
												  			   .attr("type","checkbox")
												  			   .val(dataMap.dataList[i].newSeqNo)
												  ).appendTo($trNode);
							$("<td></td>").text(dataMap.dataList[i].seqNo)
										  .appendTo($trNode);
							$("<td></td>").text(dataMap.dataList[i].userName)
										  .appendTo($trNode);
							if(dataMap.dataList[i].userStudentNumber.length > 7 || dataMap.dataList[i].errMsg == 'Duplicate Value') {
								alertContentCheck1 = true;
								$("<td></td>").text(dataMap.dataList[i].userStudentNumber)
											  .css("color", "red")
											  .appendTo($trNode);
							} else {
								$("<td></td>").text(dataMap.dataList[i].userStudentNumber)
											  .appendTo($trNode);
							}
							if(dataMap.dataList[i].userScreenName.length > 12 || dataMap.dataList[i].errMsg == 'Duplicate ID' || dataMap.dataList[i].errMsg == 'Duplicate Value') {
								$("<td></td>").text(dataMap.dataList[i].userScreenName)
											  .css("color", "red")
											  .appendTo($trNode);
							} else {
								$("<td></td>").text(dataMap.dataList[i].userScreenName)
											  .appendTo($trNode);
							}
							$("<td></td>").text(dataMap.dataList[i].errMsg)
										  .appendTo($trNode);
							
							if(dataMap.dataList[i].errMsg == 'Duplicate ID') {
								alertContentCheck2 = true;
							}
							if(dataMap.dataList[i].errMsg == 'Duplicate Value') {
								alertContentCheck3 = true;
							}
							
							$trNode.appendTo($(tbodyObj));
						}else{
							$trNode = $("<tr></tr>");
							$("<td></td>").append(
												  $("<input/>").attr("name","<portlet:namespace/>seqNo")
												  			   .attr("checked", "checked")
												  			   .attr("type","checkbox")
												  			   .val(dataMap.dataList[i].newSeqNo)
												  ).appendTo($trNode);
							$("<td></td>").text(dataMap.dataList[i].seqNo)
									 	 .appendTo($trNode); 					
							$("<td></td>").text(dataMap.dataList[i].userName)
										  .appendTo($trNode); 					
							$("<td></td>").text(dataMap.dataList[i].userStudentNumber)
									 	 .appendTo($trNode);
							$("<td></td>").text(dataMap.dataList[i].userScreenName)
										  .appendTo($trNode);
							$("<td></td>").text("<liferay-ui:message key='edison-virtuallab-valid' />")
										  .appendTo($trNode);
							$trNode.appendTo($(tbodyObj));
						}
					}
					
					if(alertContentCheck1) {
						$("#alertContent1").css("display", "block");
					} else {
						$("#alertContent1").css("display", "none");
					}
					
					if(alertContentCheck2) {
						$("#alertContent2").css("display", "block");
					} else {
						$("#alertContent2").css("display", "none");
					}
					
					if(alertContentCheck3) {
						$("#alertContent3").css("display", "block");
					} else {
						$("#alertContent3").css("display", "none");
					}
					
					
				}
			}, error : function (data, status, e){
				alert("createExcel" + e);
			}, complete : function(){
				$("#<portlet:namespace/>excelvalidation-dialog").dialog("open");
			}
		});
	} else {
		alert("<liferay-ui:message key='edison-virtuallab-select-file' />");
	}
}

function excelListAdd() {
	if($('input:checkbox[name=<portlet:namespace/>seqNo]').is(':checked')) {
		$("#<portlet:namespace/>excelvalidation-dialog").dialog( "close" );
		var excelForm = $("form[name=excelForm]").serialize();
		jQuery.ajax({
			type: "POST",
			url: "<%=studentExcelInsertURL%>",
			async : false,
			data  : excelForm,
			success: function(result) {
				<portlet:namespace/>dataSearchList();
			},error:function(data,e){
				alert("dialog" + e);
				return false;
			},complete:function(){
				dataSearchList("1");
			}
		});
	} else {
		
	}
}

function <portlet:namespace/>dataSearchList() {
	bStart();
	var dataForm = {
		"<portlet:namespace/>virtualLabId" : "${virtualLabClassInfo.virtualLabId}",
		"<portlet:namespace/>classId" : "${classId}",
		"<portlet:namespace/>questionSeqNo" : "${maxQuestionSeqNo}",
		"<portlet:namespace/>search_parameter" : $("#<portlet:namespace/>search_parameter").val()
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=virtualClassStudentListURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var virtualClassStudentList = msg.virtualClassStudentList;
			
			$("#<portlet:namespace/>virtualClassStudentListBody tr:not(:has(#1))").remove();
			
			if(virtualClassStudentList === undefined || virtualClassStudentList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "8")
						  .css("text-align","center")
						  .css("height", "40px")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>virtualClassStudentListBody").append($rowResult);
			} else {
				
				for(var i = 0; i < virtualClassStudentList.length; i++) {
					$rowResult = $("<tr/>");
					
 					if(i%2 == 1){
 						$rowResult.addClass("tablebgtr");
 					}
					
					$("<td/>").text(virtualClassStudentList.length - i)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualClassStudentList[i].userStudentNumber)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").text(virtualClassStudentList[i].userFirstName)
							  .css("text-align","center")
							  .appendTo($rowResult);
					if(virtualClassStudentList[i].requestSort == "TEMP") {
						$("<td/>").append($("<a/>").text(virtualClassStudentList[i].userScreenName)
												   .css("text-align","center")
												   .attr("href","#")
												   .attr("onClick","<portlet:namespace/>updateTempUserDialogOpen('" + virtualClassStudentList[i].virtualLabUserId + "'); return false;")
								  ).css("text-align","center")
								   .appendTo($rowResult);
					} else {
						$("<td/>").text(virtualClassStudentList[i].userScreenName)
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					if(virtualClassStudentList[i].surveyCheck > 0) {
						$("<td/>").text("<liferay-ui:message key='yes' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else {
						$("<td/>").text("<liferay-ui:message key='no' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					$("<td/>").text(virtualClassStudentList[i].executeCount)
							  .css("text-align","center")
							  .appendTo($rowResult);
					$("<td/>").html("<input type='button' value='<liferay-ui:message key='edison-simulation-monitoring-title' />' class='button01b' onclick=\"<portlet:namespace/>searchMonitoring('" + virtualClassStudentList[i].userId + "')\"/>")
							  .css("text-align","center")
							  .appendTo($rowResult);
					if(virtualClassStudentList[i].requestSort == "REQUEST") {
						$("<td/>").html("<p><liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-course-registration' /></p><input type='button' value='<liferay-ui:message key='edison-virtuallab-approve' />' class='button01b' onclick='<portlet:namespace/>classRegister(\"" + virtualClassStudentList[i].virtualLabUserId + "\",\"" + "CONFIRM" + "\", \"" + virtualClassStudentList[i].userId + "\")'/><input type='button' value='<liferay-ui:message key='edison-virtuallab-denial' />' class='button01b' onclick='<portlet:namespace/>deniedDialogOpen(\"" + virtualClassStudentList[i].virtualLabUserId + "\")'/>")
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else if(virtualClassStudentList[i].requestSort == "CONFIRM") {
						$("<td/>").html("<p><liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-take-class' /></p><input type='button' value='<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-cancel-registration' />' class='button01b' onclick='<portlet:namespace/>classRegister(\"" + virtualClassStudentList[i].virtualLabUserId + "\",\"" + "REQUEST" + "\", \"" + virtualClassStudentList[i].userId + "\")'/>")
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else if(virtualClassStudentList[i].requestSort == "DENIED") {
						$("<td/>").html("<p><liferay-ui:message key='edison-virtuallab-denial' /></p><input type='button' value='<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-reason-denial' />' class='button01b' onclick='alert(\"" + virtualClassStudentList[i].processNote +"\");' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else if(virtualClassStudentList[i].requestSort == "TEMP") {
						$("<td/>").html("<input type='button' value='<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-student-delete' />' class='button01b' onclick='studentDelete(\"" + virtualClassStudentList[i].userScreenName + "\", \"" + virtualClassStudentList[i].virtualLabUserId + "\")'/>")
								  .css("text-align","center")
								  .appendTo($rowResult);
					} else {
						$("<td/>").text("<liferay-ui:message key='unknown' />")
								  .css("text-align","center")
								  .appendTo($rowResult);
					}
					$("#<portlet:namespace/>virtualClassStudentListBody").append($rowResult);
				}
			}
		},error:function(msg,e){ 
			alert("dataSearchList" + e);
			return false;
		},complete: function(){
			bEnd();
		}
	});
}

<%
Layout scienceApplayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(themeDisplay.getScopeGroupId(), false, "/monitoring");
long requestPlid = scienceApplayout.getPlid(); 
long groupId = themeDisplay.getScopeGroupId();
%>

/*
 * 모니터링 결과 확인 (유저별 확인)
 */
function <portlet:namespace/>searchMonitoring(userId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("<%=requestPlid%>"); <!-- 모니터링 페이지 Plid -->
		portletURL.setPortletMode("view");
		portletURL.setWindowState("pop_up");
		portletURL.setPortletId("edisonmonitoring_WAR_edisonsimulationportlet"); <!-- 모니터링 ID -->
		portletURL.setParameter("classSearchUser", userId); <!-- 유저 아이디 -->
		
		Liferay.Util.openWindow(
			{
				dialog: {
					width:1280,
					height:850,
					cache: false,
					modal: true,
					draggable: false,
					resizable: false,
					destroyOnClose: true
/* 					,after: {
						render: function(event) {
							$("button.btn.close").on("click", function(e){
								<portlet:namespace/>dataSearchList(1);
							});
						}
					} */
				},
				id: 'edisonmonitoring_WAR_edisonsimulationportlet',
				uri: portletURL.toString()
			}
		);
		
	});
}

function <portlet:namespace/>updateTempUserDialogOpen(virtualLabUserId) {
	jQuery.ajax({
		type: "POST",
		url: "<%=getTempUserInfomationURL%>",
		async : false,
		data : {"<portlet:namespace/>virtualLabUserId" : virtualLabUserId},
		success: function(msg) {
			var tempUserInfomation = msg.tempUserInfomation;
			$("#<portlet:namespace/>updateVirtualLabUserId").val(tempUserInfomation.virtualLabUserId);
			$("#<portlet:namespace/>updateUserScreenName").text(tempUserInfomation.userScreenName);
			$("#<portlet:namespace/>updateUserName").val(tempUserInfomation.userFirstName);
			$("#<portlet:namespace/>updateUserStudentNumber").text(tempUserInfomation.userStudentNumber);
			$("#<portlet:namespace/>tempUser-update-dialog").dialog("open");
			return false;
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
		
}

function <portlet:namespace/>classRegister(virtualLabUserId, requestSort, userId) {
	var dataForm = {
		"<portlet:namespace/>userId" : userId,
		"<portlet:namespace/>virtualLabUserId" : virtualLabUserId,
		"<portlet:namespace/>requestSort" : requestSort
	};
	jQuery.ajax({
		type: "POST",
		url: "<%=updateClassRegisterURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			<portlet:namespace/>dataSearchList();
		},error:function(msg,e){ 
			alert("classRegister" + e);
			return false;
		}
	});
}

function <portlet:namespace/>deniedDialogOpen(virtualLabUserId) {
	$("#<portlet:namespace/>virtualLabUserId").val(virtualLabUserId);
	$("#<portlet:namespace/>processNote").val("");
	$("#<portlet:namespace/>register-denied-dialog").dialog("open");
}

function <portlet:namespace/>checkValidation() {
	var checkForm = document.registerDeniedForm;
	if(!checkValue(checkForm.<portlet:namespace/>processNote, "<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-reason-denial' />", 1, 40)) {
		checkForm.<portlet:namespace/>processNote.focus();
		return false;
	}
	
	var updateForm = $("form[name=registerDeniedForm]").serialize();
	
	jQuery.ajax({
		type: "POST",
		url: "<%=registerDeniedURL%>",
		async : false,
		data : updateForm,
		success: function(msg) {
			var result = msg.result
			if (result == 200) {
				$("#<portlet:namespace/>register-denied-dialog").dialog("close");
				alert("<liferay-ui:message key='edison-virtuallab-denial-description' />");
				<portlet:namespace/>dataSearchList();
			} else {
				alert("<liferay-ui:message key='edison-data-insert-error' />");
			}
		},error:function(msg,e){ 
			alert("checkValidation" + e);
			return false;
		}
	});
}

function studentNumberOnkeyup(value){
	var f = document.addVirtualClassStudentForm;
	f.<portlet:namespace/>userScreenName.value = "${virtualLabClassInfo.virtualClassCd}" + value;
	f.<portlet:namespace/>userPassword.value = "${virtualLabClassInfo.virtualClassCd}" + value;
}

function studentCreate(){
	var f = document.addVirtualClassStudentForm;
	
	if(!checkValue(f.<portlet:namespace/>userStudentNumber,"<liferay-ui:message key='edison-virtuallab-code' />",4,27)) return false;
	if(!checkValue(f.<portlet:namespace/>userName,"<liferay-ui:message key='name' />",1,20)) return false;	
	
	var paramData = $("form[name=addVirtualClassStudentForm]").serialize();
	jQuery.ajax({
		type: "POST",
		url: "<%=addVirtualClassStudentURL%>",
		async : false,
		data  : paramData,
		success: function(result) {
			var resultCode = result.resultCode;
			if(resultCode == "200"){
				alert("<liferay-ui:message key='edison-data-insert-success' />");
				$("#<portlet:namespace/>virtualLabClass-register-dialog").dialog("close");
				<portlet:namespace/>dataSearchList();
			}else{
				alert("<liferay-ui:message key='edison-data-insert-error' />");
				return false;
			}
			
		},error:function(data,e){ 
			alert("studentCreate"+e);
			return false;
		}
	});
}

function studentDelete(userScreenName, virtualLabUserId){
	if(confirm("<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-student-delete-alert' />")){
		
		if(userScreenName == ""){
			alert("<liferay-ui:message key='edison-simulation-monitoring-bad-request' />");
		}else{
			var dataForm = {
				"<portlet:namespace/>virtualLabUserId" : virtualLabUserId,
				"<portlet:namespace/>userScreenName" : userScreenName,
				"<portlet:namespace/>classId" : $("#<portlet:namespace/>classId").val()
			};
			jQuery.ajax({
				type: "POST",
				url: "<%=deleteVirtualClassUserURL%>",
				async : false,
				data  : dataForm,
				success: function(msg) {
					var result = msg.result;
					if(result = "200"){
						alert("<liferay-ui:message key='edison-data-delete-success' />");
					}else{
						alert("<liferay-ui:message key='edison-data-delete-error' />");
					}
					<portlet:namespace/>dataSearchList();
				},error:function(data,e){ 
					alert(e);				
					alert("<liferay-ui:message key='edison-data-delete-error' />");
					return false;
				}
			});
		}
	}
}

function studentUpdate(){
	jQuery.ajax({
		type: "POST",
		url: "<%=updateVirtualClassUserURL%>",
		async : false,
		data  : {"<portlet:namespace/>virtualLabUserId" : $("#<portlet:namespace/>updateVirtualLabUserId").val(),
				 "<portlet:namespace/>userFirstName" : $("#<portlet:namespace/>updateUserName").val() },
		success: function(msg) {
			var result = msg.result;
			if(result == "200"){
				alert("<liferay-ui:message key='edison-data-update-success' />");
			} else if(result == "400") {
				alert("<liferay-ui:message key='edison-there-are-no-data' />");
			} else {
				alert("<liferay-ui:message key='edison-data-update-error' />");
			}
			$("#<portlet:namespace/>tempUser-update-dialog").dialog("close");
			<portlet:namespace/>dataSearchList();
		},error:function(data,e){ 
			alert(e);				
			return false;
		}
	});
}

function initPassword(){
	jQuery.ajax({
		type: "POST",
		url: "<%=studentPasswordInitURL%>",
		async : false,
		data  : {"<portlet:namespace/>virtualLabUserId" : $("#<portlet:namespace/>updateVirtualLabUserId").val()},
		success: function(msg) {
			var result = msg.result;
			if(result == "200"){
				alert("<liferay-ui:message key='edison-data-update-success' />");
			}else if(result == "400"){
				alert("<liferay-ui:message key='edison-there-are-no-data' />");
			}else{
				alert("<liferay-ui:message key='edison-data-update-error' />");
			}
			$("#<portlet:namespace/>tempUser-update-dialog").dialog("close");
		},error:function(data,e){ 
			alert(e);				
			return false;
		}
	});
}

function <portlet:namespace/>onKeyDown() {
	if(event.keyCode == 13 && $("#<portlet:namespace/>search_parameter").val() != ""){
		<portlet:namespace/>dataSearchList();
	}
}

function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}
</script>
<div class="h10"></div>
<div class="virtitlebox"><img src="${contextPath }/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle"><liferay-ui:message key='edison-virtuallab-student-infomation' /></div> 
	<div class="search01">
		<div class="buttonbox0802">
			<input id="<portlet:namespace/>addStudentBtn" name="<portlet:namespace/>addStudentBtn" type="button" class="button0801" value="<liferay-ui:message key='edison-virtuallab-student-add' />"/>
			<input id="addStudentAllBtn" name="addStudentAllBtn" type="button" class="button0801" value="<liferay-ui:message key='edison-virtuallab-excel-add' />" onClick="studentExcelInsert();return false;"/>
		</div>
		<div class="searchbox01">
			<input style="margin: 1px 0;" id="<portlet:namespace/>search_parameter" name="<portlet:namespace/>search_parameter" type="text" maxlength="15" placeholder="<liferay-ui:message key='edison-virtuallab-search-option' />" onkeypress="<portlet:namespace/>onKeyDown();" />
			<input id="search_button" name="search_button" type="button" class="btnsearch" onClick="<portlet:namespace/>dataSearchList()"/>
		</div>
	</div>
</div>
<div class="h10"></div>
<form id="searchForm" name="searchForm" method="post" onsubmit="return false;">
	<input id="<portlet:namespace/>virtualLabId" name="<portlet:namespace/>virtualLabId" type="hidden" value="${virtualLabId}" />
</form>
<div class="table7_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="10%" />
			<col width="15%" />
			<col width="10%" />
			<col width="10%" />
			<col width="15%" />
			<col width="20%" />
			<col width="10%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-code' /></th>
				<th align="center" scope="col"><liferay-ui:message key='name' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-table-list-header-userid' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-survey-participation' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-sw-data-result' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-simulation-monitoring-title' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-student-management' /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>virtualClassStudentListBody">
		</tbody>
	</table>
</div>

<div id="<portlet:namespace/>spaceDiv" align="center"></div>
<div id="<portlet:namespace/>pageListDiv" style="text-align: center;"></div>

<div id="<portlet:namespace/>virtualLabClass-register-dialog" class="bigpopupbox" title="<liferay-ui:message key='edison-virtuallab-student-registration' />" style="background:#fff; display:none;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-student-add' />
			</div>
		</div>
		<div class="newWclose">
			<img id="<portlet:namespace/>virtualLabClass-register-dialog-close-btn" name="<portlet:namespace/>virtualLabClass-register-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>

	<form id="addVirtualClassStudentForm" name="addVirtualClassStudentForm" method="post">
		<input id="<portlet:namespace/>virtualLabId" name="<portlet:namespace/>virtualLabId" type="hidden" value="${virtualLabClassInfo.virtualLabId }"/>
		<input id="<portlet:namespace/>classId" name="<portlet:namespace/>classId" type="hidden" value="${virtualLabClassInfo.classId }"/>
		<input id="<portlet:namespace/>universityField" name="<portlet:namespace/>universityField" type="hidden" value="${virtualLabClassInfo.virtualLabUniversityField}"/>
	
		<div class="newWcont01">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<colgroup>
					<col width="20%" />
					<col width="30%" />
					<col width="20%" />
					<col width="30%" />
				</colgroup>
				<tbody>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='edison-table-list-header-virtuallab' /></td>
						<td class="puptxt">${virtualLabClassInfo.virtualLabTitle }</td>
						<td class="puptitle"><liferay-ui:message key='edison-table-list-header-virtuallab-code' /></td>
						<td class="puptxt">LAB${virtualLabClassInfo.virtualLabId }</td>
					</tr>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='edison-virtuallab-tablerow-virtualclass' /></td>
						<td class="puptxt">${virtualLabClassInfo.classTitle }</td>
						<td class="puptitle"><liferay-ui:message key='edison-table-list-header-virtualclass-code' /></td>
						<td class="puptxt">${virtualLabClassInfo.virtualClassCd}</td>
					</tr>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='edison-virtuallab-code' /></td>
						<td class="puptxt">
							<input id="<portlet:namespace/>userStudentNumber" name="<portlet:namespace/>userStudentNumber" class="dialogInput" type="text" maxlength="27" style="width:140px; margin-bottom:0px;" onkeyup="studentNumberOnkeyup(this.value)"/>
						</td>
						<td class="puptitle"><liferay-ui:message key='name' /></td>
						<td class="puptxt">
							<input id="<portlet:namespace/>userName" name="<portlet:namespace/>userName" class="dialogInput" type="text" maxlength="10" style="width:140px; margin-bottom:0px;"/>
						</td>
					</tr>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='edison-table-list-header-userid' /></td>
						<td class="puptxt">
							<input id="<portlet:namespace/>userScreenName" name="<portlet:namespace/>userScreenName" class="dialogInput" type="text" readonly="readonly" style="width:140px; margin:1px 0;"/>
						</td>
						<td class="puptitle"><liferay-ui:message key='edison-create-account-field-title-password' /></td>
						<td class="puptxt">
							<input id="<portlet:namespace/>userPassword" name="<portlet:namespace/>userPassword" class="dialogInput" type="password" readonly="readonly" style="width:140px; margin-bottom:0px;"/>
						</td>
					</tr>
					<tr class="puptrline">
						<td class="puptxt" style="text-align:center; color: #ff0000; padding:25px;" colspan="4"><liferay-ui:message key='edison-virtuallab-password-alert' /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="text-align: right; margin:0px 25px 30px 0px;">
			<input id="virtualLab_creation_button" name="virtualLab_creation_button" type="button" value="<liferay-ui:message key='edison-virtuallab-student-registration' />" class="button06" onclick="studentCreate()"/>
		</div>
	</form>
</div>

<div id="<portlet:namespace/>tempUser-update-dialog" class="bigpopupbox" title="<liferay-ui:message key='edison-virtuallab-student-management' />" style="background:#fff; display:none;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-student-management' />
			</div>
		</div>
		<div class="newWclose">
			<img id="<portlet:namespace/>tempUser-update-dialog-close-btn" name="<portlet:namespace/>tempUser-update-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	
	<form id="udpateVirtualClassStudentForm" name="udpateVirtualClassStudentForm" method="post">
		<input id="<portlet:namespace/>updateVirtualLabUserId" name="<portlet:namespace/>updateVirtualLabUserId" type="hidden" value="0"/>
	
		<div class="newWcont01">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<colgroup>
					<col width="20%" />
					<col width="30%" />
					<col width="20%" />
					<col width="30%" />
				</colgroup>
				<tbody>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='edison-virtuallab-tablerow-virtuallab' /></td>
						<td class="puptxt">${virtualLabClassInfo.virtualLabTitle }</td>
						<td class="puptitle"><liferay-ui:message key='edison-table-list-header-virtuallab-code' /></td>
						<td class="puptxt">LAB${virtualLabClassInfo.virtualLabId }</td>
					</tr>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='edison-virtuallab-tablerow-virtualclass' /></td>
						<td class="puptxt">${virtualLabClassInfo.classTitle }</td>
						<td class="puptitle"><liferay-ui:message key='edison-table-list-header-virtualclass-code' /></td>
						<td class="puptxt">${virtualLabClassInfo.virtualClassCd}</td>
					</tr>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='edison-virtuallab-code' /></td>
						<td class="puptxt" id="<portlet:namespace/>updateUserStudentNumber">
						</td>
						<td class="puptitle"><liferay-ui:message key='name' /></td>
						<td class="puptxt">
							<input id="<portlet:namespace/>updateUserName" name="<portlet:namespace/>updateUserName" type="text" maxlength="10" style="width:140px; margin-bottom:0px;"/>
						</td>
					</tr>
					<tr class="puptrline">
						<td class="puptitle"><liferay-ui:message key='edison-table-list-header-userid' /></td>
						<td class="puptxt" id="<portlet:namespace/>updateUserScreenName">
						</td>
						<td class="puptitle"><liferay-ui:message key='password' /></td>
						<td class="puptxt">
							<input id="init_password_button" name="init_password_button" type="button" value="<liferay-ui:message key='edison-virtuallab-password-reset' />" class="button06" onclick="initPassword()"/>
						</td>
					</tr>
					<tr class="puptrline">
						<td class="puptxt" style="text-align:center; color: #ff0000; padding:25px;" colspan="4"><liferay-ui:message key='edison-virtuallab-password-alert' /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="text-align: right; margin:0px 25px 30px 0px;">
			<input id="virtualLab_creation_button" name="virtualLab_creation_button" type="button" value="<liferay-ui:message key='action.UPDATE' />" class="graybtn" onclick="studentUpdate()"/>
		</div>
	</form>
</div>

<div id="<portlet:namespace/>createExcel-dialog" title="<liferay-ui:message key='edison-virtuallab-excel-add' />" style="background:#fff; display: none;">
	<div class="newWheader" style="min-width: 450px;">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-excel-add' />
			</div>
		</div>
		<div class="newWclose">
			<img id="<portlet:namespace/>createExcel-close-btn" name="<portlet:namespace/>createExcel-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<div class="newWcont01">
		<div style="padding-bottom:10px;"><liferay-ui:message key='edison-virtuallab-reference-excelfile' /></div>
		<input type="file" class="excelFile" id="<portlet:namespace/>excelFile" name="<portlet:namespace/>excelFile"/><br><br>
		
		<c:if test="${!empty fileMap}">
			<span onclick="<portlet:namespace/>fileDownload('${fileMap.fileEntryId }')" style="cursor: pointer; font-size:14px;">
				<img src="${contextPath}/images/fileicon.png" width="19" height="21"/>
				[<liferay-ui:message key='edison-virtuallab-sample-file' />]
				Down
			</span>
		</c:if>
	</div>
	<div style="text-align: right; margin:0px 25px 30px 0px;">
		<input id="<portlet:namespace/>file_check" name="<portlet:namespace/>file_check" type="button"  class="button06" value="<liferay-ui:message key='edison-simulation-execute-pre-processor-form-create-attachments-upload' />" onClick="fileCheck();" />
	</div>
</div>

<div id="<portlet:namespace/>excelvalidation-dialog" title="<liferay-ui:message key='edison-virtuallab-valid-check-result' />" style="background:#fff; display: none;">
	<div class="newWheader" style="min-width: 450px;">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-student-list' />
			</div>
		</div>
		<div class="newWclose">
			<img id="<portlet:namespace/>excelvalidation-close-btn" name="<portlet:namespace/>excelvalidation-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	<form name="excelForm" method="post" style="margin:0px;">
		<input id="<portlet:namespace/>virtualLabId" name="<portlet:namespace/>virtualLabId" type="hidden" value="${virtualLabClassInfo.virtualLabId }"/>
		<input id="<portlet:namespace/>classId" name="<portlet:namespace/>classId" type="hidden" value="${virtualLabClassInfo.classId }"/>
		<input id="<portlet:namespace/>universityField" name="<portlet:namespace/>universityField" type="hidden" value="${virtualLabClassInfo.virtualLabUniversityField}"/>
		<input id="<portlet:namespace/>virtualClassCd" name="<portlet:namespace/>virtualClassCd" type="hidden" value="${virtualLabClassInfo.virtualClassCd}"/>
		<div class="newWcont01" style="overflow:auto; max-height:400px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table1_list" >
				<thead>
				<tr>
					<th></th>
					<th><liferay-ui:message key='edison-table-list-header-index' /></th>
					<th><liferay-ui:message key='name' /></th>
					<th><liferay-ui:message key='edison-virtuallab-code' /></th>
					<th><liferay-ui:message key='edison-table-list-header-userid' /></th>
					<th><liferay-ui:message key='edison-virtuallab-result' /></th>
				</tr>
				</thead>
				<tbody id="<portlet:namespace/>excel-validation-result"></tbody>
			</table>
		</div>
		<div id="alertContent1" style="text-align: center; color:red; text-size:14px; margin-bottom:10px; display:none;">
			※ <liferay-ui:message key='edison-create-account-description-message-second-line' />
		</div>
		<div id="alertContent2" style="text-align: center; color:red; text-size:14px; margin-bottom:10px; display:none;">
			※ <liferay-ui:message key='edison-create-account-id-used' />
		</div>
		<div id="alertContent3" style="text-align: center; color:red; text-size:14px; margin-bottom:10px; display:none;">
			※ <liferay-ui:message key='edison-virtuallab-tempuser-duplicate' />
		</div>
	</form>
	<div style="text-align: right; margin:0px 25px 30px 0px;">
		<input id="<portlet:namespace/>register" name="<portlet:namespace/>register" type="button"  class="button06" value="<liferay-ui:message key='edison-button-register' />" onClick="excelListAdd();" />
	</div>
</div> 

<div id="<portlet:namespace/>register-denied-dialog" class="newWindow" style="background:#fff; display:none;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-registration-denial' />
			</div>
		</div>
		<div class="newWclose">
			<img id="<portlet:namespace/>register-denied-dialog-close-btn" name="<portlet:namespace/>register-denied-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	
	<form id="registerDeniedForm" name="registerDeniedForm" method="post">
		<input id="<portlet:namespace/>virtualLabUserId" name="<portlet:namespace/>virtualLabUserId" type="hidden" value="0"/>
		<input id="<portlet:namespace/>requestSort" name="<portlet:namespace/>requestSort" type="hidden" value="DENIED"/>
		<div class="newWcont01">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<colgroup>
					<col width="100%" />
				</colgroup>
				<tbody>
					<tr>
						<td class="puptitle"><liferay-ui:message key='edison-virtuallab-virtualLabClassRegistrationList-reason-denial' /></td>
					</tr>
					<tr class="puptrline">
						<td class="puptxt">
							<input id="<portlet:namespace/>processNote" name="<portlet:namespace/>processNote" type="text" maxlength="40" style="width:95%;"/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="text-align: right; margin:0px 25px 30px 0px;">
			<input id="<portlet:namespace/>registerDenied_button" name="<portlet:namespace/>registerDenied_button" type="button"  class="button06" value="<liferay-ui:message key='edison-virtuallab-denial' />" onClick="<portlet:namespace/>checkValidation();" />
		</div>
	</form>
</div>

<img id="loadingBox" src="${contextPath}/images/processing.gif" width="400" style="display: none;"/>
