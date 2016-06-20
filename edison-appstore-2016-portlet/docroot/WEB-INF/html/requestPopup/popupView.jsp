<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<style type="text/css">
	.request-zindex{
		z-index: 10 !important;
	}
</style>

<div id='<portlet:namespace/>requestPopup' style="display: none; width:100%;height:200px; background-color: rgb(227, 253, 181); border-top: 1px solid rgb(115, 119, 48);  border-bottom: 1px solid rgb(115, 119, 48);text-align: center;">
<b>
	<span>
		<img src="${contextPath }/images/danger-34250_1280.png" width="27"/> Request information : 
	</span>
	<span onclick="moveWorkspace();">	
		<u><a href="#">Workspace request : ${requestInfo.developerRequestCount }</a></u>
	</span>
	<span onclick="moveVirtualLab();">
		,&nbsp;&nbsp;<u><a href="#">VirtualLab request : ${requestInfo.virtualLabRequestCount }</a></u>
	</span>
	<c:if test="${isSite}">
		<span onclick="moveLibraryRequest();">
			,&nbsp;&nbsp;<u><a href="#">Library request: ${requestInfo.libRequestCount}</a></u>
		</span>		
	</c:if>
	<span onclick="moveWorkspace();">	
		,&nbsp;&nbsp;<u><a href="#">Workspace delete : ${requestInfo.developerDeleteCount }</a></u>
	</span>
	<span>&nbsp;&nbsp; </span>
	<span>
		<img id="<portlet:namespace/>requestPopup-closeBtn" src="${contextPath }/images/close-button.png" width="24" style="cursor:pointer;"/>
	</span>
</b>	
</div>

<script type="text/javascript">
AUI().ready(function() {
	$( window ).scroll(function() {
		  var height = $(document).scrollTop();
		  var topPosition = $("#banner").outerHeight()+$("#banner").position().top;
		  
		  if(height>topPosition){
			  $("#<portlet:namespace/>requestPopup").parent().css("top",height);
		  }else{
			  $("#<portlet:namespace/>requestPopup").parent().css("top",topPosition);
		  }
	});
	
	
	$(".portlet-borderless-container").css("min-height", "0px");
	
	/* 다이얼로그 */
	$("#<portlet:namespace/>requestPopup").dialog({
		autoOpen: false,
	    width: "100%",
	    height: "auto",
	    //position:[0, 117],
	    position: { my: "top", at: "bottom",of:"#banner"},
	    padding:0,
	    modal: false,
	    resizable: false,
	    dialogClass:'request-zindex',
	    show: {effect:'fade', speed: 800},
        hide: {effect:'fade', speed: 800},
	    open: function(event, ui) {
	    	$(this).css('overflow', 'hidden');
	    	$(this).css("padding", "10px 15px 10px 15px");
	    	$(this).css("min-height", "0px");
	    	$(this).removeClass("ui-widget-content");
	    	$(this).removeClass("ui-dialog-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget");
	    },
	    close: function() {
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
	
	$("#<portlet:namespace/>requestPopup-closeBtn").click(function() {
		$("#<portlet:namespace/>requestPopup").dialog("close");
	});
	var totalCount = ${requestInfo.totalCount};
	if(totalCount > 0) {
		<%	
		if(isAdministrator || isSiteAdministrator){
		%>
		$("#<portlet:namespace/>requestPopup").dialog("open");
		<%	
		}
		%>
	}

	$("#<portlet:namespace/>requestPopup").parent().css("padding", "0px 0px 0px 0px");
	
});

function moveVirtualLab() {
	location.href = "${virtualLabURL}";
}

function moveWorkspace() {
	location.href = "${workspaceURL}";
}

function moveLibraryRequest() {
	location.href = "${libRequestURL}";
}




</script>