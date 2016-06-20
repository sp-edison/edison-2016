<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<liferay-portlet:resourceURL var="checkePortNameURL" copyCurrentRenderParameters="false" id="checkePortName" escapeXml="false">
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
	<portlet:param name="portType" value="${portType}"/>
	<portlet:param name="portMode" value="${portMode}"/>
</liferay-portlet:resourceURL>

<style type="text/css">
</style>
<div class="newWindow" style="background-color: #fff; overflow-x: hidden;overflow-y: hidden;">
	<div class="newWheader">
		<div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
			<div class="newWtitle">
				<c:choose>
					<c:when test="${portType eq 'INPUT' }">
<%-- 						<liferay-ui:message key="edison-science-appstore-toolkit-input"/>  --%>
					</c:when>
					<c:otherwise>
<%-- 						<liferay-ui:message key="edison-science-appstore-toolkit-out"/> --%>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${portMode eq 'add' }">
						<liferay-ui:message key="edison-table-list-header-port-Type-name"/> 
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="edison-table-list-header-port-name"/>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="newWclose">
			<img id="port-name-close-btn" name="port-name-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21" style="cursor:pointer; float: right;"/>
		</div>
	</div>
	
	
	<div class="newWcont01">
		<input type="text" id="portName" size="40" maxlength="30" onKeydown="if(event.keyCode ==13){<portlet:namespace/>checkName();return false;}"/>
	</div>
	<div class="popupbtnGroup" style="height:40px;">
		<input name="add" type="button" value="<liferay-ui:message key="add"/>" class="graybtn" onclick="<portlet:namespace/>checkName();"/>
	</div>
</div>
<script type="text/javascript">
AUI().ready(function() {
	$("#port-name-close-btn").click(function() {
		$("#port-name-dialog").dialog("close");
	});
});

function <portlet:namespace/>checkName(){
	if($("#portName").val()==""){
		alert(Liferay.Language.get('edison-create-account-description-message-first-line'));
		$("#portName").focus();
		return false;
	}else{
		var checkName = $("#portName").val();
		
		if('${portMode}' == 'add'){
			if(/[^a-zA-Z0-9_]/.test(checkName)){
				alert(Liferay.Language.get('please-enter-only-alpha'));
				return false;
			}
		}else{
			if(!/^[-|_]?[a-zA-Z0-9_]+$/.test(checkName)){
				alert(Liferay.Language.get('expression-is-not-valid-ex-3',['param','param1','-param']));
				return false;
			}
		}
	}
	
	var searchForm = {"<portlet:namespace/>portName": $("#portName").val()};
	jQuery.ajax({
		type: "POST",
		url: "<%=checkePortNameURL%>",
		async : false,
		data  : searchForm,
		dataType: 'json',
		success: function(data) {
			if(data.result){
				$('.ui-widget-overlay').click();
				
				var val = $("#portName").val();
				
				if('${portMode}'=='add'){
					<portlet:namespace/>portTypeEditorOpen('${portType}', val);
				}else{
					<portlet:namespace/>portAddOpen('${scienceAppId}','${portType}',val);
				}
			}else{
				alert(Liferay.Language.get('edison-science-appstore-toolkit-duplicate-message'));
				$("#portName").focus();
			}
		},error:function(data,e){ 
			alert("AJAX ERROR checkName"+e);
		}
	});
}

</script>