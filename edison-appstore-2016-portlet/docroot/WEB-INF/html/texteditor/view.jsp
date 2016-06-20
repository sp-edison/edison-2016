<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="/common/science_platform_events.jspf" %>
<%
	String returnId = request.getAttribute("returnId")!= null?(String)request.getAttribute("returnId"):"";
	String returnFileName = request.getAttribute("returnFileName")!= null?(String)request.getAttribute("returnFileName"):"";
	String cluster = request.getAttribute("cluster")!= null?(String)request.getAttribute("cluster"):"";
	String workflowType = request.getAttribute("workflowType")!= null?(String)request.getAttribute("workflowType"):"";
	String icebreakerUrl =CustomUtil.strNull(request.getAttribute("icebreakerUrl"));
	
	String portName = request.getParameter("portName")==null?"FileSelectorPort":request.getParameter("portName").toString();
	String taskId = request.getParameter("taskId")!= null?(String)request.getParameter("taskId").toString():"";
	String useSampleFile = request.getParameter("useSampleFile")!= null?(String)request.getParameter("useSampleFile").toString():"";
	//해당 파일을 POPUP으로 띄울경우
	boolean popupState = false;
	if(LiferayWindowState.isPopUp(request)){
		popupState = true;
	}
	String mode = request.getAttribute("mode")!= null?(String)request.getAttribute("mode"):"";
	String uploadDestFolerId = request.getAttribute("uploadDestFolerId")!= null?(String)request.getAttribute("uploadDestFolerId"):"";
	String uploadDestFileId = request.getAttribute("uploadDestFileId")!= null?(String)request.getAttribute("uploadDestFileId"):"";
	String uploadDestFileName = request.getAttribute("uploadDestFileName")!= null?(String)request.getAttribute("uploadDestFileName"):"";
	
	String dialogId = request.getParameter("dialogId")!= null?(String)request.getParameter("dialogId"):"";
	if( dialogId == null || dialogId.equals(""))
	{
		dialogId = request.getAttribute("dialogId")!= null?(String)request.getAttribute("dialogId"):"";
	}
	
	String destFolerParents = request.getAttribute("destFolerParents")!= null?(String)request.getAttribute("destFolerParents"):"";
%>
<liferay-portlet:resourceURL var="getRepositoryFolderURL" id="getRepositoryFolder" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="getChildFolderURL" id="getChildFolder" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="getChildFileURL" id="getChildFile" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:renderURL var="fileUploadPopUpURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="fileUploadPopUp" />
</liferay-portlet:renderURL>
<liferay-portlet:resourceURL var="createFolderURL" id="createFolder" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="renameFolderURL" id="renameFolder" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="deleteFolderURL" id="deleteFolder" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="moveFolderURL"   id="moveFolder"	 copyCurrentRenderParameters="false" escapeXml="false"/>

<liferay-portlet:resourceURL var="deleteFileURL" id="deleteFile" copyCurrentRenderParameters="false" escapeXml="false"/>

<liferay-portlet:resourceURL var="savePortletSessionValueURL" id="savePortletSessionValue" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="getPortletSessionValueURL" id="getPortletSessionValue" copyCurrentRenderParameters="false" escapeXml="false"/>

<style>
.ui-resizable-w, .ui-resizable-handle{ 
	margin-left: 0px;
	background: #dbdbdb;
	width:13px;
}
.selected-tablebgtr{
	background-color: #b0b0b1;
}
</style>

<div class="h10"></div>
	
<!--박스-->
<aui:form name="form">
<aui:input type="hidden" name="groupId" id="groupId" value="${groupId }"></aui:input>
<aui:input type="hidden" name="vcToken" id="vcToken" value="${icebreakerVcToken.vcToken }"></aui:input>
<div class="myfilebox">
	<div class="leftcontent">
		<div id="myfileTree" class="mflefttree">
		</div>
	</div>
	
	<!--right contents-->
	<div class="rightcontent" id="<portlet:namespace/>rightcontent" 	style="overflow: auto;display:none;">
		<!--table-->
		<div class="tablemf_list borderno">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<colgroup>
		        	<col width="*">
					<col width="25%">
					<col width="15%">
				</colgroup>
		            <thead>
						<tr>
							<th scope="col"><liferay-ui:message key="edison-table-list-header-file-nm"/> </th>
							<th scope="col"><liferay-ui:message key="edison-science-appstore-toolkit-change-date"/></th>
							<th scope="col"><liferay-ui:message key="edison-table-list-header-file-size"/></th>
						</tr>
					</thead>
					<tbody id ="fileTableBody">
					</tbody>
			</table>
		</div>
	</div> <!-- //right contents-->                                    
</div>
</aui:form>

<div style="width:45%; float:right; text-align:right;">
	<input class="button08_1" onclick="openPopUpFileUpload();" value=<liferay-ui:message key='edison-button-upload'/> type="button"/>
	<input class="button01b" style="min-width:90px;display:none;" id="<portlet:namespace/>sampleFileBtn" value="샘플 파일 선택" type="button"/>
	<input class="button01b" style="min-width:90px;" id="<portlet:namespace/>confirmBtn" value="파일 선택" type="button"/>
	 <input class="button01b" style="min-width:90px;" id="<portlet:namespace/>cancelBtn"  value="취소" type="button"/>
</div>
<div style="clear:both"></div>
<div id="fileDownloadIframe"> </div>

<div id="icebreaker-file-upload-dialog" title="파일업로드" class="bigpopupbox" style="display:none;">
</div>
<img id="loadingBox" src="${contextPath}/images/processing.gif" width="400" style="display: none;"/>


<script type="text/javascript">

var isSelectedSampleFile = false;

$(function(){
	var folderArr = <portlet:namespace/>getRepositoryFolder();
	<portlet:namespace/>fileDivWidthEvent2();
	
	var mode = "<%=mode%>";
	if(mode == "fileUpload"){
		var array = [];
		var uploadParents = "<%=destFolerParents%>";
		if(uploadParents != ""){
			
			if(	uploadParents.split(",").length > 0 ){
				for(var i=0 ; i< uploadParents.split(",").length ; i++){
					array.push(uploadParents.split(",")[i]);
				}
			}
		}
		<portlet:namespace/>initJstree(folderArr, "<%=uploadDestFolerId%>" , array);
		<portlet:namespace/>getChildFile("<%=uploadDestFolerId%>");
	}else{
		//초기 jstree init
		if(folderArr != null){
			<portlet:namespace/>initJstree(folderArr,"", null);
			<portlet:namespace/>getChildFile("HOME");
		}	
	}
	$("#myfileTree").jstree("deselect_all");
	
	<portlet:namespace/>initFileCheckEvent();
});
//최상위 폴더 목록 가져오기
function <portlet:namespace/>getRepositoryFolder(){
	var arr = [];
	jQuery.ajax({
		type: "POST",
		url: "<%=getRepositoryFolderURL%>",
		data: $("form[name=<portlet:namespace/>form]").serialize(),
		async : false,
		success: function(data) {
			var dataSize = data.dataList.length;
			var dataMap = data.dataList;
			if(dataSize>0){
				for(var i=0 ; i<dataSize; i++ ){
					var obj = {
						"id": dataMap[i].fileId,
						"text": dataMap[i].fileName,
						"type":"close",
						"li_attr": {
							"childLength":dataMap[i].childCnt
						}
					};
					arr.push(obj);
				}
			}
		},error:function(data,e){ 
			alert(Liferay.Language.get('edison-data-search-error'));
		},complete: function(){
		}
	});
	return arr;
}

//선택한 폴더의 하위폴더 목록 가져오기
function <portlet:namespace/>getChildFolder(folderId){
	var selectFolder = folderId.valueOf();
	var arr = [];
	
	var groupId = $("#<portlet:namespace/>groupId").val();
	var vcToken = $("#<portlet:namespace/>vcToken").val();
	jQuery.ajax({
		type: "POST",
		url: "<%=getChildFolderURL%>",
		data: {
			"<portlet:namespace/>groupId" : groupId,
			"<portlet:namespace/>vcToken" : vcToken,
			"<portlet:namespace/>selectFolderId" : selectFolder
		},
		async : false,
		success: function(data) {
			var dataSize = data.dataList.length;
			var dataMap = data.dataList;
			if(dataSize>0){
				for(var i=0 ; i<dataSize; i++ ){
					var obj = {
						"id": dataMap[i].fileId,
						"parent": selectFolder,
						"text": dataMap[i].fileName,
						"type":"close",
						"li_attr": {
							"childLength":dataMap[i].childCnt
						}
					};
					
					arr.push(obj);
				}
			}
		},error:function(data,e){ 
			alert(Liferay.Language.get('edison-data-search-error'));
		}
	});
	return arr;
}

//선택한 폴더의 하위파일 목록 가져오기
function <portlet:namespace/>getChildFile(folderId){
	var selectFolder = folderId+"";
	var arr = [];
	var groupId = $("#<portlet:namespace/>groupId").val();
	var vcToken = $("#<portlet:namespace/>vcToken").val();
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getChildFileURL%>",
		data: {
			"<portlet:namespace/>groupId" : groupId,
			"<portlet:namespace/>vcToken" : vcToken,
			"<portlet:namespace/>selectFolderId" : selectFolder
		},
		async : false,
		success: function(data) {
			var dataSize = data.dataList.length;
			var dataMap = data.dataList;
			
			$fileTableBody = $("#fileTableBody");
			$("#fileTableBody tr").remove();
			if(dataSize>0){
				for(var i=0 ; i<dataSize; i++ ){
					var obj = {
						"id": dataMap[i].fileId,
						"text": dataMap[i].fileName,
						"type":"file",
						"li_attr": {
							"childLength":dataMap[i].childCnt
						}
					};
					arr.push(obj);
				}
			}else{
			} 
		},error:function(data,e){ 
			alert(Liferay.Language.get('edison-data-search-error'));
		}
	});
	return arr;
}

function <portlet:namespace/>initFileCheckEvent()
{
	$("input[name=<portlet:namespace/>fileChk]").click(function(){
    	//var allChkLength = $("input[name=<portlet:namespace/>fileChk]").length;
    	//var uncheckedLength = $("input[name=<portlet:namespace/>fileChk]:checkbox:not(:checked)").length;
    	var checkedLength = $("input[name=<portlet:namespace/>fileChk]:checkbox:checked").length;
		console.log("CLICK : " + checkedLength);
    	var i = 0;
   		if(1 < checkedLength ){
   			alert( "한 개의 파일을 선택해 주세요.");
   			$(this).prop("checked", false);
   		}
   		else
		{
	    	$("input[name=<portlet:namespace/>fileChk]").each(function() {
	   			$(this).parents("tr").removeClass("tablebgtr");
	    		if( $(this).prop("checked") )
	   			{
	    			//isSelectedSampleFile = false;
	    			$(this).parents("tr").addClass("selected-tablebgtr");
	    		}
	    		else
	   			{
	    			$(this).parents("tr").removeClass("selected-tablebgtr");
	    			if(i%2 == 1){ $(this).parents("tr").addClass("tablebgtr"); }
	   			}
 		    		i++;
			});
		}
    });
}

//jstree initial
function <portlet:namespace/>initJstree(dataArr,selectId, nodeParents){
	var rootData = [{
		"id":"HOME",
		"text":"HOME",
		"type":"open",
		"children": dataArr,
		"li_attr":{
			"childLength" : dataArr.length			
		}

	}];
	
	$("#myfileTree").jstree({
	   "core" : {
		  "data": rootData,
	     "check_callback" : true,
	   },
	   "state" : "open",
	    "types" : {
	        "open" : {
	        	"icon" : "${contextPath}/images/fileselector/myfile-icon01.png"
	        },
	        "close" : {
	          	"icon" : "${contextPath}/images/fileselector/myfile-icon02.png"
	        },
	        "file" : {
	          	"icon" : "${contextPath}/images/fileselector/fileicon.png"
	        }
	    },
       "progressive_render" : true,
	   "plugins" : [ "contextmenu", "state", "dnd", "types","progressive_render" ,"hotkeys"]
	}).bind("loaded.jstree", function(event, data) { 
		 //$(this).jstree("open_all");//현재 최상위폴더만 있으므로 open_all하면 열린 폴더 없음
		 //create, rename, delete 경우 jstree init 후 다시 그 노드 child 생성 및 open 
		 if(nodeParents != null){
			for(var i = nodeParents.length-2 ; i>=0 ; i--){
				if(nodeParents[i] != "HOME" && nodeParents[i] != "#"){
					
					 var childFolderArr = <portlet:namespace/>getChildFolder(nodeParents[i]);
					 
					 var node = $('#myfileTree').jstree(true).get_node(nodeParents[i]);
				     if(childFolderArr.length>0){
				   		$('#myfileTree').jstree().delete_node(node.children);
				    	for(var j=0; j<childFolderArr.length; j++){
				    		var obj = childFolderArr[j];
				    		$('#myfileTree').jstree().create_node( node.id ,  obj , "last", false);
				    	} 
				    }
				}
			}
		}
		 
		$("#myfileTree").jstree("select_node", selectId);
		$("#myfileTree").jstree("open_all");
		
		//아이콘변경
		<portlet:namespace/>iconChange();
	}).bind("select_node.jstree",function(evt, data){//노드 선택 이벤트
		var length = data.node.children.length;
		
		if(data.node.id != "HOME"){
			//HOME가 아닐때
	    	var childFolderArr = <portlet:namespace/>getChildFolder(data.node.id);
	    	
	    	//노드 child와 api의 하위폴더 개수와 다르면 child node create
			if( length != childFolderArr.length ){
		    	if(childFolderArr.length>0){
		   			$('#myfileTree').jstree().delete_node(data.node.children);
		    		for(var j=0; j<childFolderArr.length; j++){
		    			var obj = childFolderArr[j];
		    			$('#myfileTree').jstree().create_node( data.node.id ,  obj , "last", false);
						
		    		} 
		    	} 
			}
   			$("#myfileTree").jstree("toggle_node", data.node.id);
		}
		//아이콘변경
    	<portlet:namespace/>iconChange();
    	//파일목록 가져오기
	   	var fileArr = <portlet:namespace/>getChildFile(data.node.id);
	   	if(fileArr.length>0)
	   	{
	   		for(var j=0; j<fileArr.length; j++){
    			var obj = fileArr[j];
    			$('#myfileTree').jstree().create_node( data.node.id ,  obj , "last", false);
    		} 
	   	}
    	
	}).bind("click.jstree", function (e, datap) { //아이콘 클릭 이벤트
		//클릭해서 노드가 없는거는 붙이기
		//클릭li 하위노드수하고 api온 자바하고 다르면 select li시키기
		var li = $(e.toElement).parent("li");
		var liId = $(e.toElement).parent("li").attr("id");
		var node = $('#myfileTree').jstree(true).get_node(liId);
		
		if(node.children != null){
			var liChildLength = node.children.length;
			
			var childlength = $(e.toElement).parent("li").attr("childlength");
			if( liChildLength != childlength && childlength > 0 ){
				$("#myfileTree").jstree("deselect_all");
				$("#myfileTree").jstree("select_node", li);
			}
			/* else if(liId == "HOME"){//HOME이고 열려있을때 노드 select
				$("#myfileTree").jstree("deselect_all");
				$("#myfileTree").jstree("select_node", li);
			} */
		}
	}).bind("open_node.jstree", function(event, data) { //노드를 open
		<portlet:namespace/>iconChange();
	}).bind("close_node.jstree", function(event, data) {//노드를 closed
	}).bind("move_node.jstree", function(e, data) { // 폴더 move 이벤트
			var sourceId = data.node.id;
			var targetId = data.parent;
			
			var tree = $('#myfileTree').jstree(true);
			var node = tree.get_node(targetId);				 
			var nodeParents = node.parents;
			
		   if(sourceId != "" || targetId != ""){
			   var groupId = $("#<portlet:namespace/>groupId").val();
			   var vcToken = $("#<portlet:namespace/>vcToken").val();
			   bStart();
			   jQuery.ajax({
			 		type: "POST",
			 		url: "<%=moveFolderURL%>",
			 		data: {
			 			"<portlet:namespace/>groupId" : groupId,
			 			"<portlet:namespace/>vcToken" : vcToken,
			 			"<portlet:namespace/>sourceId" : sourceId,
			 			"<portlet:namespace/>targetId" : targetId,
			 			"<portlet:namespace/>targetId" : targetId,
			 		},
			 		async : true,
			 		success: function(data) {
						$("#myfileTree").jstree("destroy");
						var folderArr = <portlet:namespace/>getRepositoryFolder();
						<portlet:namespace/>initJstree(folderArr, targetId, nodeParents);
						
			 	    	if(data.status == 200 || data.status == 201){
			 	    		alert(Liferay.Language.get('edison-simulation-myfile-move-alert'));
			 	    	}else{
			 	    		alert(Liferay.Language.get('edison-data-update-error'));	
			 	    	}
						
			 		},error:function(){
			 			bEnd();
		 	    		alert(Liferay.Language.get('edison-data-update-error')); 
			 		},complete: function(){
						bEnd();
					}
			   	});	 
		   }
	});;
}

function <portlet:namespace/>iconChange(){ //아이콘변경 : child가 있는지 없는지 임시로 아이콘 변경
	$(".jstree-node").each(function(index){
  		 var childLength = $(this).attr("childlength");
		 if(childLength > 0){
			 var flag = $(this).hasClass("jstree-leaf");
			 if(flag) {
				 $(this).removeClass("jstree-leaf").addClass("jstree-closed");
			 }
		 }
  	});
}

function <portlet:namespace/>fileDivWidthEvent2(){
	var maxWidth = 0;
	
	/*var ua = window.navigator.userAgent;
	//익스플로러인경우는 width - 25 
	if(ua.indexOf('MSIE') > 0 || ua.indexOf('Trident') > 0){
		//rightWidth = rightWidth - 25;
	}*/
	var fileboxWidth = $(".myfilebox").width();
	
	if(<%=popupState%>){
		$("body").css("margin","5px");
		fileboxWidth = fileboxWidth + 38;
	}

	var leftWidth = $(".leftcontent").width();
	var rightWidth = fileboxWidth - leftWidth-51;

	$(".myfilebox").css("width", fileboxWidth +"px");
	$(".leftcontent").css("min-width", leftWidth +"px");
	$(".leftcontent").css("width", leftWidth+"px");
	$(".rightcontent").css("width", rightWidth+"px");
		
	maxWidth = rightWidth;
	
	//왼쪽div resize event
	  $(".rightcontent").resizable({
		maxWidth: maxWidth ,
		minWidth: maxWidth - 200 ,
		handles: 'w',
     	ghost: true,
    	handles: 'w',
     	css:{overflow:"hidden"},
	    stop: function(e, ui) {
	        var parent = ui.element.parent();    
	        
	        var current = ui.element;
	       
	       	var pWidth = $(".myfilebox").width();//parent.width();       
	        var pHeight = parent.height();
	        var cWidth = ui.element.width();
	        var cHeight = ui.element.height();

	        var resizeRightWidth = cWidth;
	        var resizeLeftWidth = pWidth-cWidth-100;
	        
	        if(leftWidth >= resizeLeftWidth){//245보다 작거나 같다.
	        	$(".leftcontent").css("width", leftWidth+"px");
	        	resizeRightWidth = pWidth-leftWidth-50;
	        }else if(leftWidth < resizeLeftWidth){//245보다 크다.
	        	resizeRightWidth = pWidth-resizeLeftWidth-50;
	        	$(".leftcontent").css("width", resizeLeftWidth+"px");
	        }

	        current.css({
	            width: resizeRightWidth+"px",
	            height : "583px",
	            left: "0"
	        });
	        
	        
			//helper 높이 변경
	    	var fileTableHeight = $(".tablemf_list").height() + 50;
			if(fileTableHeight > 584){
	    		$("div.ui-resizable-handle.ui-resizable-w").css("height", fileTableHeight + "px");
			}
	    }
	});
}

//check된 file 다운로드
function <portlet:namespace/>checkfileDownload(){
	$iframeDiv = $("#fileDownloadIframe");
	$iframeDiv.empty();
	var checkedLength = $("input[name=<portlet:namespace/>fileChk]:checked").length;
	if(checkedLength == 0 ){
		alert(Liferay.Language.get('edison-simulation-myfile-download-not-select-alert'));
	}
	else{
		$("input[name=<portlet:namespace/>fileChk]:checked").each(function() {
			$fileId = $(this).val();
			$iframe = $("<iframe/>").attr("src","<%=icebreakerUrl%>/majin/api/file/download?id="+$fileId);
			$iframeDiv.append($iframe)
		}); 
	}
}
	
//dialogue initial
AUI().ready(function(){
	$("#icebreaker-file-upload-dialog").dialog({
		autoOpen: false,
		width: 800,
	    height: 600,
	    modal: true,
	    resizable: false,
	    show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},

        open: function(event, ui) {
	    	$(this).parent().css('overflow', 'visible');
	    	$(this).css('overflow', 'visible');
	    	$(this).removeClass("ui-widget-content");
	    	$(this).parent().removeClass("ui-widget-content");
	    	

	    	$('.ui-widget-overlay').bind('click',function(){
	    		$("#icebreaker-file-upload-dialog").dialog("close");
	    	})
	    },
	    close: function() {
	    	$("#icebreaker-file-upload-dialog").empty();
	    }
	}).dialog("widget").find(".ui-dialog-titlebar").remove();
});

//upload popup
function openPopUpFileUpload(){
	var groupId = $("#<portlet:namespace/>groupId").val();
	var vcToken = $("#<portlet:namespace/>vcToken").val();
	

	var tree = $('#myfileTree').jstree(true);
	var selectNode = $("#myfileTree").jstree("get_selected");

	if(selectNode == "HOME" || selectNode == ""){//선택한 노드가 없거나 루트선택
		 selectNode = "HOME";
	}
	var node = tree.get_node(selectNode);				 
	var nodeParents = node.parents;
	 
	selectNode = selectNode.valueOf();
	var URL = "<%=fileUploadPopUpURL%>&<portlet:namespace/>isPopUp="+<%=popupState%>+"&<portlet:namespace/>groupId="+groupId;
	URL = URL + "&<portlet:namespace/>returnId=<%=returnId%>&<portlet:namespace/>returnFileName=<%=returnFileName%>&<portlet:namespace/>cluster=<%=cluster%>";
	URL = URL + "&<portlet:namespace/>workflowType=<%=workflowType%>"+ "&<portlet:namespace/>dialogId=<%=dialogId%>";
	URL = URL + "&<portlet:namespace/>vcToken="+vcToken+"&<portlet:namespace/>destFolerId="+selectNode+"&<portlet:namespace/>destFolerParents="+nodeParents;
	
	$("#icebreaker-file-upload-dialog").load(URL, function (e) {
		$("#icebreaker-file-upload-dialog").dialog("open")
	});
}

//file id, name return 
function <portlet:namespace/>fileChoice(fileId, fileNm, filePath){
	var returnFileAPIId = fileId;

	if("<%=workflowType%>"=="parameter"){
		returnFileAPIId = filePath;
	}
	
	var $openerObj = $(window.opener.document);
	$openerObj.find("#"+"<%=returnId%>").val(returnFileAPIId);
	$openerObj.find("#"+"<%=returnFileName%>").val(fileNm);
	$openerObj.find("#"+"<%=returnId%>").change();
	$openerObj.find("#"+"<%=returnFileName%>").change();
	
	window.self.close();
}
</script>

<!--  IPC 용 추가 -->
<script>

	var portName = '<%= portName%>';
	var workflowType = '<%= workflowType%>';
	var taskId = '<%= taskId%>';
	var useSampleFile = '<%= useSampleFile%>';

	//useSampleFile = 'y';
	
	//SamleFile을 사용할경우 fileId 값을 SAMPLE로 openner에게 전달
	if( useSampleFile.toUpperCase() == "Y")
		$("#<portlet:namespace/>sampleFileBtn").show();
	
	// workflowType value : workflow or single
	// editor가 창으로 열릴지 여부를 받는다(workflow일 경우 창, single일 경우 일반 포틀릿)
	if( workflowType == "workflow")
	{
		$("#<portlet:namespace/>confirmBtn").show();
		$("#<portlet:namespace/>cancelBtn").show();
	}
	else
	{
		$("#<portlet:namespace/>confirmBtn").hide();
		$("#<portlet:namespace/>cancelBtn").hide();
		
		Liferay.on(SciencePlatformEvents.IPC_EVENT_REQUEST_CONTENT, function(event){
			
			var fileId = "";
			var filaName = "";
			if(isSelectedSampleFile)
			{
				fileId = "SAMPLE";	
				filaName = "SAMPLE";
			}
			else
			{
				if($("input[name=<portlet:namespace/>fileChk]:checked").length == 0 ){
					alert(Liferay.Language.get('사용할 파일을 선택하세요.'));
				}
				else
				{
					$("input[name=<portlet:namespace/>fileChk]:checked").each(function() {
						fileId = $(this).val();
						filaName = $(this).parent().find("span").text();
					});
				}
			}

			var content = {
					taskId : taskId=='null'?"":taskId,
					portName : portName,
					value : {"fileId" : fileId, "fileName" : filaName}
			};
		 
			var payload = new SciencePlatformEvent(
					event.getPortName(),
					SciencePlatformEvents.TYPE_TARGET,
					'<portlet:namespace/>', 
					event.getEventEmitter(),
					content);

			Liferay.fire(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, payload);
		});
	}
	
	$("#<portlet:namespace/>sampleFileBtn").click(function() {
		if(<%=popupState%>)
		{
			var value = {fileId:"SAMPLE", fileName:"SAMPLE"};
			<portlet:namespace/>savePortletSessionValue( taskId, portName,  value);
		}
		else
		{
			alert("샘플 파일을 선택하셨습니다.");
			isSelectedSampleFile = true;
			var i = 0;
			$("input[name=<portlet:namespace/>fileChk]").each(function() {
	   			$(this).parents("tr").removeClass("tablebgtr");
    			$(this).parents("tr").removeClass("selected-tablebgtr");
    			if(i%2 == 1){ $(this).parents("tr").addClass("tablebgtr"); }
		    	i++;
			});
		}
	});		
	
	$("#<portlet:namespace/>confirmBtn").click(function() {
		var value = "";
		if($("input[name=<portlet:namespace/>fileChk]:checked").length == 0 ){
			alert(Liferay.Language.get('사용할 파일을 선택하세요.'));
		}
		else
		{
			$("input[name=<portlet:namespace/>fileChk]:checked").each(function() {
				var fileId = $(this).val();
				var filaName = $(this).parent().find("span").text();
				value = {fileId:fileId, fileName:filaName};
			});
			
			<portlet:namespace/>savePortletSessionValue( taskId, portName, value );
		}
	});
	
	$("#<portlet:namespace/>cancelBtn").click(function() {
		Liferay.Util.getOpener().closePopup( '<%=dialogId%>' );
	});
	
	function <portlet:namespace/>savePortletSessionValue( taskId, portName, value )
	{
		$.ajax({
			url: "<%=savePortletSessionValueURL%>",
			type:"post",
			dataType: "text",
			data:{
				"<portlet:namespace/>taskId" : taskId,
				"<portlet:namespace/>portName" : portName,
				"<portlet:namespace/>value": JSON.stringify(value)
			},
			success:function(data)
			{
				Liferay.Util.getOpener().fetchResult( taskId,portName, value );
				Liferay.Util.getOpener().closePopup( '<%=dialogId%>' );
			}
		});
	}
	
	function <portlet:namespace/>getPortletSessionValue( portName )
	{
		$.ajax({
			url: "<%=getPortletSessionValueURL%>",
			type:"post",
			dataType: "text",
			data:{
				"<portlet:namespace/>portName" : portName
			},
			success:function(data)
			{
				console.log("FILESELECT GET SESSION : " + data);
			}
		});
	}
</script>