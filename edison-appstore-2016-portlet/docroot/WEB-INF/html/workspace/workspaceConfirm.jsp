<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:resourceURL var="workspaceRequestURL" id="workspaceRequest" />

<liferay-portlet:renderURL portletMode="view" var="workspaceListURL">
	<liferay-portlet:param name="edionCopyParam" value="true" />
	<liferay-portlet:param name="curPage" value="${returnParams.curPage}"/>
	<liferay-portlet:param name="searchField" value="${returnParams.searchField}"/>
	<liferay-portlet:param name="selectLine" value="${returnParams.selectLine}"/>
	<liferay-portlet:param name="selectStatus" value="${returnParams.selectStatus}"/>
	<liferay-portlet:param name="groupName" value="${groupName}"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="confirmURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="developerConfirm"/>
	<liferay-portlet:param name="groupName" value="${groupName}"/>
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="developerUpdateURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="developerUpdate"/>
	<liferay-portlet:param name="groupName" value="${groupName}"/>
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="deleteWorkSpaceURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="deleteWorkSpace"/>
	<liferay-portlet:param name="groupName" value="${groupName}"/>
</liferay-portlet:actionURL>

<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="developerRoleCheckURL" escapeXml="false" id="developerRoleCheck" copyCurrentRenderParameters="false"/>

<style type="text/css">
.down_title{
	font-weight: 600;
	margin-bottom: 10px;
}
.down_date{
	display:inline;
}

label.checkbox-label{
	display:inline;
}

label.checkbox-label input[type=checkbox]{
	position: relative;
	vertical-align: middle;
	bottom: 2px;
	margin-right: 2px;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$( "#<portlet:namespace/>useStart" ).datepicker({
    	showButtonPanel: true,
    	showOn: 'button',
    	dateFormat:"yy-mm-dd",
    	changeMonth: true,
    	changeYear: true,
    	buttonImage: "${contextPath}/images/calendar.png",
        buttonImageOnly: true,
        onClose: function( selectedDate ) {
            $( "#useEnd" ).datepicker( "option", "minDate", selectedDate );
          }
    });
    $( "#<portlet:namespace/>useEnd" ).datepicker({
    	showButtonPanel: true,
    	showOn: 'button',
    	dateFormat:"yy-mm-dd",
    	changeMonth: true,
    	changeYear: true,
    	buttonImage: "${contextPath}/images/calendar.png",
        buttonImageOnly: true,
        onClose: function( selectedDate ) {
            $( "#useStart" ).datepicker( "option", "maxDate", selectedDate );
            
          }
    }); 
    
    $( "#<portlet:namespace/>processDate" ).datepicker({
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
    
	var requestStatus = "${delevoperMap.requestStatus}";
	if(requestStatus == "1202001" || requestStatus == "1202004"){
    	$( "#<portlet:namespace/>processDate" ).datepicker("setDate", new Date());
	}
    
	$("#workspaceDetail").hide();
});

function workspaceDetailView(){		
	if($("#workspaceDetailButton").val() == "<liferay-ui:message key='edison-appstore-open' />"){
		$("#workspaceDetail").show();
		$("#workspaceDetailButton").val("<liferay-ui:message key='edison-appstore-close' />");
	}else{
		$("#workspaceDetail").hide();
		$("#workspaceDetailButton").val("<liferay-ui:message key='edison-appstore-open' />");
	}
}

$(document).on("keydown", "input[name^=<portlet:namespace/>ip]", function(event){
            if(event.keyCode == 46 
    		|| event.keyCode == 8 
    		|| event.keyCode == 9 
    		|| event.keyCode == 27 
    		|| event.keyCode == 13 
    		|| (event.keyCode == 65 && event.ctrlKey === true) 
    		|| (event.keyCode >= 35 && event.keyCode <= 39)) {
             return;
    }else{
        if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )){
            event.preventDefault(); 
        }else{
        	
        }   
    }
});

$(document).on("click", ".addIp", function(){
	$cloneEl =  $(this).parent().clone(); 	 	 	 	
 	$cloneEl.find("input[type=button]").removeClass("addIp").addClass("deleteIp").attr("value","<liferay-ui:message key='edison-button-board-delete' />");
 	var rowCnt =  $(this).parent().parent().find("th").attr("rowspan");
 	$(this).parent().parent().find("th").attr("rowspan", parseInt(rowCnt)+1); 
 	$cloneEl.find("input[type=text]").val("");
 	$(this).parent().parent().after($("<tr/>").append($cloneEl));
});

$(document).on("click", ".deleteIp", function(){
	var rowCnt =  $("#mainIp").attr("rowspan");	
	$("#mainIp").attr("rowspan", parseInt(rowCnt)-1); 	
 	$(this).parent().parent().remove();
});

function otherEvent(obj){
	
	if($(obj).is(":checked")){
		$("input[name=<portlet:namespace/>languageOtherDescription]").attr("readonly",false);
	}else{
		$("input[name=<portlet:namespace/>languageOtherDescription]").attr("readonly",true).val("");
	}
}

function workspaceConfirm(){
	var validationChk = true;
	var f = document.workspaceform;
	
	$("input[name^=<portlet:namespace/>ip]").each(function(){
		if(validationChk){
			if($(this).val() == ""){
				alert("<liferay-ui:message key='edison-create-account-description-message-first-line' />");
				this.focus();
				validationChk = false;			
			}
		}
		
	});
	
	if(validationChk){
		if(f.<portlet:namespace/>requestStatus.value == "1202007") {
			var paramData = {
					<portlet:namespace/>userId : "${delevoperMap.userId}"
			};
			
			jQuery.ajax({
				type: "POST",
				url: "<%=developerRoleCheckURL%>",
				async : false,
				data  : paramData,
				success: function(solverListData) {
					var dataMap = eval('(' + solverListData + ')');
					var alertContent = '<liferay-ui:message key="edison-appstore-workspace-permission-alert2" />' + '\n';
					if(dataMap.length > 0) {
						for (var i = 0; i < dataMap.length; i++) {
							alertContent += '\n' + dataMap[i].solverName + ' : ' + dataMap[i].solverRole;
						}
						alert(alertContent);
					}else {
						f.action = "<%=confirmURL%>";
						f.submit();
					}
				},error:function(data,e){   
					alert(e);				  
					return false;
				}
			});
		} else {
			f.action = "<%=confirmURL%>";
			f.submit();
		}
	}	
}

function <portlet:namespace/>deleteWorkSpace(){
	var con = confirm('<liferay-ui:message key="edison-appstore-workspace-delete-alert" />');
	var f = document.workspaceform;
	
	if(con){
		var paramData = {
			<portlet:namespace/>userId : "${delevoperMap.userId}"
		};
		
		jQuery.ajax({
			type: "POST",
			url: "<%=developerRoleCheckURL%>",
			async : false,
			data  : paramData,
			success: function(solverListData) {
				var dataMap = eval('(' + solverListData + ')');
				var alertContent = '<liferay-ui:message key="edison-appstore-workspace-permission-alert2" />' + '\n';
				if(dataMap.length > 0) {
					for (var i = 0; i < dataMap.length; i++) {
						alertContent += '\n' + dataMap[i].solverName + ' : ' + dataMap[i].solverRole;
					}
					alert(alertContent);
				}else {
					f.action = "<%=deleteWorkSpaceURL%>";
					f.submit();
				}
			},error:function(data,e){   
				alert(e);				  
				return false;
			}
		});
	}
}

function workspaceUpdate(){	
	var validationChk =  true;
	var f = document.workspaceform;
	
	$("input[name^=<portlet:namespace/>ip]").each(function(){
		if(validationChk){
			if($(this).val() == ""){
				alert("<liferay-ui:message key='edison-create-account-description-message-first-line' />");
				this.focus();
				validationChk = false;			
			}
		}
		
	});
	
	if(validationChk){
		if(f.<portlet:namespace/>requestStatus.value == "1202007") {
			var paramData = {
					<portlet:namespace/>userId : "${delevoperMap.userId}"
			};
			
			jQuery.ajax({
				type: "POST",
				url: "<%=developerRoleCheckURL%>",
				async : false,
				data  : paramData,
				success: function(solverListData) {
					var dataMap = eval('(' + solverListData + ')');
					var alertContent = '<liferay-ui:message key="edison-appstore-workspace-permission-alert2" />' + '\n';
					if(dataMap.length > 0) {
						for (var i = 0; i < dataMap.length; i++) {
							alertContent += '\n' + dataMap[i].solverName + ' : ' + dataMap[i].solverRole;
						}
						alert(alertContent);
					}else {
						f.action = "<%=developerUpdateURL%>";
						f.submit();
					}
				},error:function(data,e){   
					alert(e);				  
					return false;
				}
			});
		} else {
			f.action = "<%=developerUpdateURL%>";
			f.submit();
		}
	}
}

function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}


function historyBack(){
// 	window.location.href = "<liferay-portlet:renderURL/>&<portlet:namespace/>groupName=${groupName}";	
	window.location.href = "<%=workspaceListURL%>";
}

</script>

<!-- 페이지 타이틀 & 네비게이션 -->
<h1>        
	<liferay-ui:message key='edison-appstore-workspace-request' />
</h1>

<form name="workspaceform" method="post" enctype="multipart/form-data">
	<input name="<portlet:namespace/>userId" type="hidden" value="${delevoperMap.userId}"/>
	<input name="<portlet:namespace/>screenName" type="hidden" value="${delevoperMap.screenName}"/>
	<input name="<portlet:namespace/>requestSeq" type="hidden" value="${delevoperMap.requestSeq}"/>

	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='user-information' />
		</div>
	</div>

	<div class="h10"></div>

	<div class="table1_list">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" style="table-layout: fixed;">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
		  <tr>
		      <th><liferay-ui:message key='edison-table-list-header-userid' /></th>
		      <td>${delevoperMap.screenName}
		      </td>
		      <th><liferay-ui:message key='edison-table-list-header-usernm' /></th>
		      <td>${delevoperMap.firstName}
		      </td>
   	       </tr>  
		  <tr>
		      <th><liferay-ui:message key='edison-table-list-header-email' /></th>
		      <td>${delevoperMap.emailAddress}</td>
		      <th><liferay-ui:message key='edison-create-account-field-title-university' /></th>
		      <td>${delevoperMap.universityFieldNm}/${delevoperMap.majorField}</td>
   	       </tr>     	       
	      </table>
	</div>
	
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-appstore-workspace-request-info' />
		</div>
	</div>

	<div class="h10"></div>
	
	<div class="table1_list">		
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" style="table-layout: fixed;">
		  	<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
		  <tr>
		      <th><liferay-ui:message key='edison-appstore-workspace-request-use' /></th>
		      <td>
		      		<select name="<portlet:namespace/>developerSort">
		      			<option value="1201001" ${delevoperMap.developerSort == '1201001' ? 'selected=selected' : ''}><liferay-ui:message key='edison-appstore-workspace-solver-development' /></option>
		      			<option value="1201002" ${delevoperMap.developerSort == '1201002' ? 'selected=selected' : ''}><liferay-ui:message key='edison-appstore-workspace-solver-development-test' /></option>
		      			<option value="1201003" ${delevoperMap.developerSort == '1201003' ? 'selected=selected' : ''}><liferay-ui:message key='edison-appstore-workspace-etc' /></option>
		      		</select>
		      </td>
		      <th><liferay-ui:message key='edison-appstore-developer-preferred-date' /></th>
		      <td colspan="3">
		       	<input name="<portlet:namespace/>useStart" id="<portlet:namespace/>useStart" readonly="readonly" value="${delevoperMap.useStart}" /> ~ <input name="<portlet:namespace/>useEnd" id="<portlet:namespace/>useEnd" readonly="readonly" value="${delevoperMap.useEnd}"/>		      
		      </td>
	        </tr>
		    <tr>
		      <th><liferay-ui:message key='edison-appstore-workspace-use-language' /></th>
		      <td colspan="6">
		      	<div style="float:left;">
			      <label class="checkbox-label"><input name="<portlet:namespace/>languageFortran" type="checkbox" value="Y" ${delevoperMap.languageFortran == 'Y' ? 'checked=checked' : '' }/>&nbsp;fortran</label>
			      <label class="checkbox-label"><input name="<portlet:namespace/>languageCpp" type="checkbox" value="Y" ${delevoperMap.languageCpp == 'Y' ? 'checked=checked' : '' }/>&nbsp;c/c++</label>
			      <label class="checkbox-label"><input name="<portlet:namespace/>languagePython" type="checkbox" value="Y" ${delevoperMap.languagePython == 'Y' ? 'checked=checked' : '' }/>&nbsp;python</label>
			      <label class="checkbox-label"><input name="<portlet:namespace/>languageJava" type="checkbox" value="Y" ${delevoperMap.languageJava == 'Y' ? 'checked=checked' : '' }/>&nbsp;java</label>
			      <label class="checkbox-label"><input name="<portlet:namespace/>languageOther" type="checkbox" onclick="otherEvent(this)" value="Y" ${delevoperMap.languageOther == 'Y' ? 'checked=checked' : '' }/>&nbsp;<liferay-ui:message key='edison-appstore-workspace-etc' /></label>
			      <input type="text" name="<portlet:namespace/>languageOtherDescription" class="text_box_04" ${delevoperMap.languageOther == 'Y' ? '' : 'readonly=readonly' } maxlength="100" value="${delevoperMap.languageOtherDescription}"/>
			    </div>
			</td>
			</tr>		    		    
		    <c:choose>	
		    	<c:when test="${!empty ipList}">		    	
			      <c:forEach var="data" items="${ipList}" varStatus="status" >
			        <c:choose>
			        	<c:when test="${status.index == 0}">
						      <tr>	    
						           <th id="mainIp" rowspan="${fn:length(ipList)})"><liferay-ui:message key='edison-appstore-workspace-access-ip' /></th>
							      	<td colspan="7">
								      	<input name="<portlet:namespace/>ip1" type="text" maxlength="3" value="${data.ip1}"/>.
								      	<input name="<portlet:namespace/>ip2" type="text" maxlength="3" value="${data.ip2}"/>.	     
								        <input name="<portlet:namespace/>ip3" type="text" maxlength="3" value="${data.ip3}"/>.
								        <input name="<portlet:namespace/>ip4" type="text" maxlength="3" value="${data.ip4}"/>
								        <input type="button" class="addIp button01b" onclick="return false;" value="<liferay-ui:message key='edison-appstore-add' />" />
							        </td>
				        	  </tr>
			        	</c:when>
			        	<c:otherwise>
			        		  <tr>
							      	<td colspan="7">
								      	<input name="<portlet:namespace/>ip1" type="text" maxlength="3" value="${data.ip1}"/>.
								      	<input name="<portlet:namespace/>ip2" type="text" maxlength="3" value="${data.ip2}"/>.	     
								        <input name="<portlet:namespace/>ip3" type="text" maxlength="3" value="${data.ip3}"/>.
								        <input name="<portlet:namespace/>ip4" type="text" maxlength="3" value="${data.ip4}"/>
										<input type="button" class="deleteIp button01b" onclick="return false;" value="<liferay-ui:message key='edison-button-board-delete' />" />
							        </td>
				        	  </tr>						        	
			        	</c:otherwise>
			        </c:choose>
			      </td>		
			      </c:forEach>
		      </c:when>
		      <c:otherwise>
		      <tr id="ipTrNode">
		     	  <th id="mainIp"><liferay-ui:message key='edison-appstore-workspace-access-ip' /></th>
			      <td colspan="7">
			      	<input name="<portlet:namespace/>ip1" type="text"/>.
			      	<input name="<portlet:namespace/>ip2" type="text"/>.
			        <input name="<portlet:namespace/>ip3" type="text"/>.
			        <input name="<portlet:namespace/>ip4" type="text"/>
			        <input type="button" class="addIp button01b" onclick="return false;" value="<liferay-ui:message key='edison-appstore-add' />" />
			      </td>
		      </tr>
		      </c:otherwise>
		     </c:choose>     		        
		    <tr>
		      <th><liferay-ui:message key='edison-appstore-remark' /></th>
		      <td width="85%" colspan="5">
		      	<textarea name="<portlet:namespace/>rem" cols="150" rows="5" style="resize: none;width: 95%;margin: 0px;" spellcheck="false">${delevoperMap.rem}</textarea>
		      </td>
	        </tr>        		       	  
	        <%if(true){ %>
	        <tr>
		      <th><liferay-ui:message key='edison-appstore-workspace-user-management-list' /></th>
		      <td width="85%" colspan="5">
		      	<textarea name="<portlet:namespace/>etc" cols="150" rows="5" style="resize: none;width: 95%;margin: 0px;" spellcheck="false">${delevoperMap.etc}</textarea>
		      </td>
	        </tr>
	        
	        <%} %>
	      </table>
	</div>
	
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-appstore-workspace-detail-view' />
			<input type="button" id="workspaceDetailButton" value="<liferay-ui:message key='edison-appstore-open' />" class="button01b" onclick="workspaceDetailView();return false;" />
		</div>
	</div>

	<div class="h10"></div>
	
	<div class="table1_list">		
		  <table id="workspaceDetail" style="display: none; table-layout: fixed;" width="100%" border="0" cellspacing="0" cellpadding="0" class="data" >
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
		    <tr>
		      <th><liferay-ui:message key='edison-appstore-workspace-server-ip' /></th>
		      <td colspan="3"><input type="text" name="<portlet:namespace/>detailIp" style="width:90%;" value="${delevoperMap.detailIp}"/></td>
	        </tr>
		    <tr>
		      <th>OS</th>
		      <td colspan="3"><input type="text" style="width:90%;"  name="<portlet:namespace/>detailOs" value="${delevoperMap.detailOs}" /></td>
	        </tr>
		    <tr>
		      <th>CPU</th>
		      <td colspan="3"><input type="text" style="width:90%;"  name="<portlet:namespace/>detailCpu" value="${delevoperMap.detailCpu}"/></td>
	        </tr>
		    <tr>
		      <th><liferay-ui:message key='edison-appstore-workspace-storage-capacity' /></th>
		      <td colspan="3"><input type="text" style="width:90%;"  name="<portlet:namespace/>detailStorate" value="${delevoperMap.detailStorate}"/></td>
	        </tr>
		    <tr>
		      <th><liferay-ui:message key='edison-appstore-workspace-etc' /></th>
		      <td colspan="3"><input type="text" style="width:90%;"  name="<portlet:namespace/>detailLibrary" value="${delevoperMap.detailLibrary}"/></td>
	        </tr>
	      </table>
	</div>
	
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-virtuallab-confirm-info' />
		</div>
	</div>

	<div class="h10"></div>
	
	<div class="table1_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" style="table-layout: fixed;">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
		 	<tr>
				<th><liferay-ui:message key='edison-science-appstore-toolkit-change-processing-status' /></th>
			    <td>
			      <select id="<portlet:namespace/>requestStatus" name="<portlet:namespace/>requestStatus">
			      	<c:if test="${delevoperMap.requestStatus < 1202004 }">
			      		<c:forEach items="${statusList}" var="status">	<!-- 리스트 -->
			      			<c:if test="${status.cd < 1202004 }">
			      				<option value="${status.cd}" <c:if test="${status.cd == delevoperMap.requestStatus}">selected</c:if> >${status.cdNm}</option>
			      			</c:if>
			      			<c:if test="${status.cd == 1202007 }">
			      				<option value="${status.cd}" <c:if test="${status.cd == delevoperMap.requestStatus}">selected</c:if> >${status.cdNm}</option>
			      			</c:if>
			      		</c:forEach>
			      	</c:if>
			      	<c:if test="${delevoperMap.requestStatus > 1202003 && delevoperMap.requestStatus != '1202007'}">
			      		<c:forEach items="${statusList}" var="status">	<!-- 리스트 -->
			      			<c:if test="${status.cd > 1202003 }">
			      				<option value="${status.cd}"<c:if test="${status.cd == delevoperMap.requestStatus}">selected</c:if>>${status.cdNm}</option>
		      				</c:if>
			      		</c:forEach>
			      	</c:if>
			      	<c:if test="${delevoperMap.requestStatus eq '1202007' }">
			      		<c:forEach items="${statusList}" var="status">	<!-- 리스트 -->
		      				<option value="${status.cd}"<c:if test="${status.cd == delevoperMap.requestStatus}">selected</c:if>>${status.cdNm}</option>
			      		</c:forEach>
			      	</c:if>
			      </select>
					</td>
					<th><liferay-ui:message key='edison-science-appstore-toolkit-change-processing-date' /></th>			    
					<td>
						<input type="text" name="<portlet:namespace/>processDate" id="<portlet:namespace/>processDate" readonly="readonly" value="${delevoperMap.processDate}"/>
					</td>
				</tr>
				<tr>
					<th><liferay-ui:message key='edison-table-list-header-userid' /></th>
					<td>
						<input type="text" name="<portlet:namespace/>developerId" style="width:90%;" value="${delevoperMap.developerId}" />
					</td>
					<th><liferay-ui:message key='password' /></th>
					<td colspan="3">
						<input type="text" name="<portlet:namespace/>developerPassword" style="width:90%;" value="${delevoperMap.developerPassword}" />
					</td>
				</tr>
				<tr>
					<th><liferay-ui:message key='edison-appstore-workspace-request-use' /></th>
					<td colspan="5">
						${delevoperMap.requestSortNm}
					</td>
				</tr>
				<tr>
					<th><liferay-ui:message key='edison-science-appstore-toolkit-change-request-content' /></th>
					<td width="85%" colspan="5">
						<textarea cols="150" rows="5" readOnly>${delevoperMap.requestNote}</textarea>
					</td>
				</tr>
				<tr>
					<th><liferay-ui:message key='edison-process-note' /></th>
					<td colspan="5">
						<input type="text" name="<portlet:namespace/>processNote" style="width:85%;" value="${delevoperMap.processNote}" />
					</td>
				</tr>
				<tr>
					<th><liferay-ui:message key='edison-process-note-info' /></th>
					<td colspan="3" style="line-height: 15px;">
						<c:forEach var="data" items="${requestList}">
						<div style="padding:10px 0px; border-bottom: 1px dashed #e0e0e0">
							<span style="font-weight: 600;"><liferay-ui:message key='edison-science-appstore-toolkit-change-result-of-management' /> : </span><span>${data.requestStatusNm}</span><br>
							<span style="font-weight: 600;"><liferay-ui:message key='edison-process-note' /> : </span><span>${data.processNote}</span><br/>
							<span style="font-weight: 600;">${data.requestStatusNm} <liferay-ui:message key='edison-science-appstore-toolkit-change-date' /> : </span><span>${fn:substring(data.updateDate,0,19)}</span><br>		      
							<span style="font-weight: 600;"><liferay-ui:message key='edison-appstore-workspace-request-use' /> : </span><span>${data.requestSortNm}</span><br/>
							<span style="font-weight: 600;"><liferay-ui:message key='edison-science-appstore-toolkit-change-request-content' /> : </span>
							<pre style="margin:5px; width:85%; font-family: Arial,Nanum Barun Gothic,NanumGothic;">${data.requestNote}</pre>
						</div>
						</c:forEach>
					</td>
				</tr>
		 </table>		 
		</div>
		
		<div class="virtitlebox">
			<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
			<div class="virtitle">
				<liferay-ui:message key='edison-appstore-workspace-security-pledge' />
			</div>
		</div>
	
		<div class="h10"></div>
		
		<div class="table1_list">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data" style="table-layout: fixed;">
			 <colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
		 		<tr>
					<th><liferay-ui:message key='edison-table-list-header-file' /></th>
					<td colspan="3">
						<c:if test="${!empty fileList}">
							<c:forEach items="${fileList}" var="fileMap">
								<div class="down_date"  onclick="<portlet:namespace/>fileDownload('${fileMap.fileEntryId }')" style="cursor: pointer;">
									<img src="${contextPath}/images/fileicon.png" width="19" height="21"/>
									${fileMap.fileTitle }
								</div>
							</c:forEach>
							<span style="margin-left:30px;"><liferay-ui:message key='edison-appstore-workspace-security-pledge' /> <liferay-ui:message key='edison-button-board-modify' /> : </span><input type="file" name="<portlet:namespace/>addfile"/>
						</c:if>
						<c:if test="${empty fileList}">
							<span><liferay-ui:message key='edison-appstore-workspace-security-pledge' /> <liferay-ui:message key='edison-button-register' /> : </span><input type="file" name="<portlet:namespace/>addfile"/>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
		
		<div style="padding:10px; float:right;">
			<c:choose>		
				<c:when test="${delevoperMap.requestStatus == '1202001' || delevoperMap.requestStatus == '1202004'}">
					<label class="checkbox-label">
						<input type="checkbox" name="<portlet:namespace/>mailSendYn" id="<portlet:namespace/>mailSendYn" value="Y"/>
						<i class="icon-envelope">
							<liferay-ui:message key='edison-appstore-workspace-send-email' />
						</i>
					</label>
					<input type="button" class="button0801" onclick="workspaceConfirm();return false;" value="<liferay-ui:message key='edison-button-register' />" style="margin-left:20px;"></input>
				</c:when>
				<c:otherwise>
					<input type="button" class="button0801" onclick="workspaceUpdate();return false;" value="<liferay-ui:message key='edison-button-board-modify' />" style="margin-left:15px;"></input>
				</c:otherwise>
			</c:choose>
			<input type="button" class="button0801" onclick="<portlet:namespace/>deleteWorkSpace()" value="<liferay-ui:message key='edison-button-board-delete' />" style="margin-left:15px;"></input>
			<input type="button" class="button0801" onclick="historyBack()" value="<liferay-ui:message key='edison-button-board-list' />" style="margin-left:15px;"></input>
		</div>
	
</form>
