<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%
	String returnId = request.getAttribute("returnId")!= null?(String)request.getAttribute("returnId"):"";
	String returnFileName = request.getAttribute("returnFileName")!= null?(String)request.getAttribute("returnFileName"):"";
	String cluster = request.getAttribute("cluster")!= null?(String)request.getAttribute("cluster"):"";
	String workflowType = request.getAttribute("workflowType")!= null?(String)request.getAttribute("workflowType"):"";
	String icebreakerUrl =CustomUtil.strNull(request.getAttribute("icebreakerUrl"));
	
	//해당 파일을 POPUP으로 띄울경우
	boolean popupState = false;
	if(LiferayWindowState.isPopUp(request)){
		popupState = true;
	}
	
	String pathCopyStr = LanguageUtil.format(locale, "edison-myfile-file-path-copy", "");
	String fileCopyQStr = LanguageUtil.format(locale, "edison-myfile-file-copy-question", "");

	String mode = request.getAttribute("mode")!= null?(String)request.getAttribute("mode"):"";
	String uploadDestFolerId = request.getAttribute("uploadDestFolerId")!= null?(String)request.getAttribute("uploadDestFolerId"):"";
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

<script type="text/javascript" src="${contextPath}/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="${contextPath}/js/jstree.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/main.js"></script>
<style>
.ui-resizable-w, .ui-resizable-handle{ 
	margin-left: 0px;
	background: #dbdbdb;
	width:13px;
}
</style>
<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-myfile-title' />
	</div>
</div>


<!-- 삭제 -->
<%-- <input name="<portlet:namespace/>option_8601_logical_file_value" id="<portlet:namespace/>option_8601_logical_file_value" type="text" class="preValueGroup"  readonly="readonly" style="width: 480px; margin-bottom: 0px;">
<input name="<portlet:namespace/>option_8601" id="<portlet:namespace/>option_8601" type="text"  class="preValueGroup"  readonly="readonly" style="width: 480px; margin-bottom: 0px;">
<input class="button01b" type="button" value="My File" onclick="myFilePopup('<portlet:namespace/>option_8601', '<portlet:namespace/>option_8601_logical_file_value','inputport')"> 
<input class="button01b" type="button" value="My File" onclick="myFilePopup('<portlet:namespace/>option_8601', '<portlet:namespace/>option_8601_logical_file_value','parameter')"> --%> 

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
	<div class="rightcontent" style="overflow: auto;">
		<!--table-->
		<div class="tablemf_list borderno">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<colgroup>
		        	<col width="*">
					<c:choose>
						<c:when test="<%=popupState%>"> <!-- popup일떄 -->
							<col width="20%">
							<col width="12%">
							<col width="10%" />
							<col width="10%" />
						</c:when>
						<c:otherwise>
							<col width="25%">
							<col width="15%">
						</c:otherwise>
					</c:choose> 
				</colgroup>
		            <thead>
						<tr>
							<th scope="col"><input value="all" id="<portlet:namespace/>filechkAll" type="checkbox" class="allCheckBox"><liferay-ui:message key="edison-table-list-header-file-nm"/> </th>
							<th scope="col"><liferay-ui:message key="edison-science-appstore-toolkit-change-date"/></th>
							<th scope="col"><liferay-ui:message key="edison-table-list-header-file-size"/></th>
							<c:if test="<%=popupState%>">
								<th align="center" scope="col"><liferay-ui:message key="edison-table-list-header-file-choice"/></th>
								<th align="center" scope="col"><liferay-ui:message key="edison-table-list-header-path-copy"/></th>
							</c:if>
						</tr>
					</thead>
					<tbody id ="fileTableBody">
					</tbody>
			</table>
		</div>
	</div> <!-- //right contents-->                                    
</div>
</aui:form>

<!--버튼-->
<div style="width:50%; float:left;">
	<input class="addIp button08_2" id="createFolder"  onclick="<portlet:namespace/>createFolder();" value="<liferay-ui:message key='edison-simulation-myfile-create-folder'/>" type="button">
</div>

<div style="width:45%; float:right; text-align:right;">
	<input class="addIp button08_1" onclick="openPopUpFileUpload();" value=<liferay-ui:message key='edison-button-upload'/> type="button"/> 
	<input class="addIp button01b" style="min-width:90px;" onclick="<portlet:namespace/>checkfileDownload();" value="<liferay-ui:message key='edison-table-list-header-download'/>" type="button"/>
	<input class="addIp button01b" style="min-width:90px;" onclick="<portlet:namespace/>checkfileDelete();" value="<liferay-ui:message key='edison-button-file-delete'/>" type="button"/>
</div>
<div style="clear:both"></div>
<div id="fileDownloadIframe"> </div>

<div id="icebreaker-file-upload-dialog" title="파일업로드" class="bigpopupbox" style="display:none;">
</div>
<img id="loadingBox" src="${contextPath}/images/processing.gif" width="400" style="display: none;"/>


<script type="text/javascript">
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
	
	/*파일 체크박스 전체선택해제*/
    $("#<portlet:namespace/>filechkAll").click(function(){
        if($("#<portlet:namespace/>filechkAll").prop("checked")){
            $("input[name=<portlet:namespace/>fileChk]").prop("checked",true);
        }else{
            $("input[name=<portlet:namespace/>fileChk]").prop("checked",false);
        }
    });
    $("input[name=<portlet:namespace/>fileChk]").click(function(){
    	var allChkLength = $("input[name=<portlet:namespace/>fileChk]").length;
    	var uncheckedLength = $("input[name=<portlet:namespace/>fileChk]:checkbox:not(:checked)").length;
    	var checkedLength = $("input[name=<portlet:namespace/>fileChk]:checkbox:checked").length;
    	
		/*파일1개라도체크안되있으면 전체선택체크박스 해제*/
    	if(uncheckedLength > 0){
    		$("#<portlet:namespace/>filechkAll").prop("checked",false)
    	}
    	
		/*파일을 낱개로 모두선택시 전체선택체크박스 체크*/
    	if(allChkLength == checkedLength){
    		$("#<portlet:namespace/>filechkAll").prop("checked",true)
    	}
    });
    
	//f2를 눌렀을 떄 rename function으로 연결
    $(document).keydown(function (e) {
        if (e.keyCode == 113){
        	<portlet:namespace/>renameFolder();
        }
        if(e.keyCode == 46) {
        	<portlet:namespace/>deleteFolder();
        }
    });
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
					$tr = $("<tr></tr>").appendTo($fileTableBody);
					if(i%2 == 1){ $tr.addClass("tablebgtr"); }
					
					$label = $("<label/>");
					$checkBox = $("<input/>").attr("type","checkbox").attr("name","<portlet:namespace/>fileChk").attr("value",dataMap[i].fileId);
					$img = $("<img/>").attr("src","${contextPath}/images/myfile/myfile-icon05.png").attr("width","14").attr("height","16");
					
					$fileName = $("<span/>").attr("id","fileDownLoad").text(dataMap[i].fileName);
					
					$label = $label.append($checkBox).append("&nbsp;&nbsp;").append($img).append("&nbsp;").append($fileName).css("word-break","break-all");
					$("<td></td>").addClass("name").append($label).appendTo($tr);
					$("<td></td>").addClass("TC").append(dataMap[i].lastModified).appendTo($tr);
					$("<td></td>").addClass("TC").append(dataMap[i].fileSize).appendTo($tr);
					
					if(<%=popupState%>){
						$fileSelectBt = $("<input/>").attr("type","button").attr("name","fieChoice").attr("id","fieChoice").attr("value",Liferay.Language.get('edison-myfile-choice')).addClass("button03").attr("onclick","<portlet:namespace/>fileChoice('"+dataMap[i].fileId+"', '"+dataMap[i].fileName+"', '"+dataMap[i].path+"');");
						$copyPathBt = $("<input/>").attr("type","button").attr("name","fullsize").attr("id","fullsize").attr("value","Copy").addClass("button03").attr("onclick","<portlet:namespace/>clipUrl('"+dataMap[i].fileId+"', '"+dataMap[i].fileName+"', '"+dataMap[i].path+"');");
						
						$("<td></td>").addClass("TC").append($fileSelectBt).appendTo($tr);	
						$("<td></td>").addClass("TC").append($copyPathBt).appendTo($tr);	
					}

				}
			}else{
				$tr = $("<tr></tr>").appendTo($fileTableBody);
				
				var colspan = 4;
				if(<%=popupState%>){
					colspan = 6;	
				}
				$("<td></td>").addClass("TC")
							  .text(Liferay.Language.get('edison-there-are-no-data'))
							  .attr("colspan",colspan)
							  .appendTo($tr);
			} 
		},error:function(data,e){ 
			alert(Liferay.Language.get('edison-data-search-error'));
		},complete:function(){
			//helper 높이 변경
	    	var fileTableHeight = $(".tablemf_list").height() + 50;
			if(fileTableHeight > 582){
	    		$("div.ui-resizable-handle.ui-resizable-w").css("height", fileTableHeight + "px");
			}else{
				$("div.ui-resizable-handle.ui-resizable-w").css("height", "605px");
			}
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
		  "check_callback" : function(operation, node, node_parent, node_position) {
			  if (operation === "move_node") {
            	  //return $.inArray(this.get_type(node), this.get_rules(node_parent).type) != -1;
                  //return node_parent.parent === "#"; //only allow dropping inside nodes of type '#'
				  return node_parent.id != "#";
              }
			  return true;  //allow all other operations	 	
		    }
	   },
	   "state" : "open",
	    "types" : {
	        "open" : {
	        	"icon" : "${contextPath}/images/myfile/myfile-icon01.png"
	        },
	        "close" : {
	          	"icon" : "${contextPath}/images/myfile/myfile-icon02.png"
	        }
	    },
	    "contextmenu":{
	    	"items": contextMenu
        },
       "progressive_render" : true,
	   "plugins" : [ "contextmenu", "state", "dnd", "types","progressive_render" ]
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
	   	<portlet:namespace/>getChildFile(data.node.id);
    	
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

//jstree context menu customizing
function contextMenu(node){

	var tree = $('#myfileTree').jstree(true);
	var selectNode = $("#myfileTree").jstree("get_selected");
	 if(selectNode != "HOME") {//선택한 노드가 없거나 루트선택
		var items =  {
				"Create": {
					"label": Liferay.Language.get('edison-simulation-myfile-create-folder'),
					"action": function (data) {
						<portlet:namespace/>createFolder();
					} 
				},
				"Rename": {
					"label": Liferay.Language.get('edison-simulation-myfile-rename-folder'),
					"action": function (data) {
						<portlet:namespace/>renameFolder();
						}
					},
				"Delete": {
					"label": Liferay.Language.get('edison-simulation-myfile-delete-folder'),
					"action": function (data) {
						<portlet:namespace/>deleteFolder();
						}
					}
				};
		 
		return items;
	}else  if(selectNode == "HOME") {
		var items =  {
				"Create": {
					"label": Liferay.Language.get('edison-simulation-myfile-create-folder'),
					"action": function (data) {
						<portlet:namespace/>createFolder();
					} 
				}
		};
		 
		return items;
	}
}

//create Folder 버튼 클릭시 폴더 생성
function <portlet:namespace/>createFolder(){
	var tree = $('#myfileTree').jstree(true);
	var selectNode = $("#myfileTree").jstree("get_selected");
	
	var obj = {
		"id":"new",
		"text":"new",
		"type":"close"
	};
	
	 if(selectNode == "HOME" || selectNode == ""){//선택한 노드가 없거나 루트선택
		 selectNode = "HOME";
	}
	 var nodeParents = null;
	 var parentpath = "";
	 if(selectNode != ""){//선택한 노드가 있음
		var newNode = $('#myfileTree').jstree().create_node( selectNode ,  obj , "last", false);
		$("#myfileTree").jstree("open_node", selectNode);
		var node = tree.get_node(newNode);
		if(node){
		     tree.edit(node);
		} 
		nodeParents = node.parents;
		if(nodeParents.length > 0){
			for(var i = nodeParents.length-2 ; i>=0 ; i--){
				if(nodeParents[i] != "HOME" && nodeParents[i] != "#"){
					var nodeText = tree.get_node(nodeParents[i]).text;
					if(parentpath != ""){
						parentpath += "/";	
					}
					parentpath += nodeText;
				}
			}
		}
	}

	$("#myfileTree").bind("create_node.jstree rename_node.jstree", function (){ //create, rename이 끝나면 event 시작
		//bStart(); 
		var newFolderNm = node.text;
		if(newFolderNm == ""){
			return false;
		}
		 
		newFolderNm = newFolderNm.replace(/(\s*)/g,"");
		var parentId = selectNode.valueOf();
		
		var groupId = $("#<portlet:namespace/>groupId").val();
		var vcToken = $("#<portlet:namespace/>vcToken").val();
	     
		bStart(); 
		 jQuery.ajax({
			type: "POST",
			url: "<%=createFolderURL%>",
			data: {
				"<portlet:namespace/>groupId" : groupId,
				"<portlet:namespace/>vcToken" : vcToken,
				"<portlet:namespace/>parentId" : parentId,
				"<portlet:namespace/>parentpath" : parentpath,
				"<portlet:namespace/>newFolderNm" : newFolderNm
			},
			async : true,
			success: function(data) {
				$("#myfileTree").jstree("destroy");
				var folderArr = <portlet:namespace/>getRepositoryFolder();
				<portlet:namespace/>initJstree(folderArr, parentId, nodeParents);
				
				if(data.status == 200 || data.status == 201){
					alert(Liferay.Language.get('edison-simulation-myfile-create-alert'));
				}else{
					alert(Liferay.Language.get('edison-data-insert-error'));
				}
			},error: function(){
				bEnd();
				alert(Liferay.Language.get('edison-data-insert-error'));
			},complete: function(){
				bEnd();
			}
		});
 	});	 
	 
}	

	
function chKoText(inputVal){
	check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if(check.test(inputVal)){
		return false;
	}else{
		return true;
	}
}

//folder rename event
function <portlet:namespace/>renameFolder(){
	var tree = $('#myfileTree').jstree(true);
	var selectNode = $("#myfileTree").jstree("get_selected");
	
	 var nodeParents = null;
	 var parentpath = "";
	 var node = null;
	if(selectNode != "HOME" && selectNode != ""){//선택한 노드가 있음
		node = tree.get_node(selectNode);
		if(node){
		     tree.edit(node);
		}
		nodeParents = node.parents;
	} 
	$("#myfileTree").bind("rename_node.jstree", function (){ //rename 이 끝나면 event 시작

   	 	var newFolderNm = node.text;
		newFolderNm = newFolderNm.replace(/(\s*)/g,"");
   		var selectFolderId = selectNode+"";

   		var groupId = $("#<portlet:namespace/>groupId").val();
   		var vcToken = $("#<portlet:namespace/>vcToken").val();
   		
			bStart();
			jQuery.ajax({
	 	 		type: "POST",
	 	 		url: "<%=renameFolderURL%>",
	 	 		data: {
	 	 			"<portlet:namespace/>groupId" : groupId,
	 	 			"<portlet:namespace/>vcToken" : vcToken,
	 	 			"<portlet:namespace/>selectFolderId" : selectFolderId,
	 	 			"<portlet:namespace/>newFolderNm" : newFolderNm
	 	 		},
	 	 		async : true,
	 	 		success: function(data) {
	 	 			$("#myfileTree").jstree("destroy");
 	 	    		var folderArr = <portlet:namespace/>getRepositoryFolder();
 	 	    		<portlet:namespace/>initJstree(folderArr , selectFolderId, nodeParents);
 	 	    		
	 	 	    	if(data.status == 200 || data.status == 201){
	 	 	    		alert(Liferay.Language.get('edison-simulation-myfile-rename-alert'));
	 	 	    	}else{
	 	 	    		alert(Liferay.Language.get('edison-data-update-error'));	
	 	 	    	}
 		 			 
	 	 		},error: function(){
	 	 			bEnd();
	 	 			alert(Liferay.Language.get('edison-data-update-error'));
	 	 		},complete:function(){
	 	 			bEnd();
	 	 		}
	 	 	});	 
 	   	
	});
}
	
//폴더 삭제
function <portlet:namespace/>deleteFolder(){
	
	var tree = $('#myfileTree').jstree(true);
	var selectNode = $("#myfileTree").jstree("get_selected");
	
	 var nodeParents = null;
	 var parentpath = "";
	 var node = null;
	if(selectNode != "HOME" && selectNode != ""){//선택한 노드가 있음
		node = tree.get_node(selectNode);
		nodeParents = node.parents;
	} 
	if(node == null) return false;
	
	if(confirm(Liferay.Language.get('edison-simulation-myfile-delete-confirm-alert'))){	
		//안에 파일이나 하위폴더가 있으면 삭제 no????
		
		var tree = $('#myfileTree').jstree(true);
		var selectNode = $("#myfileTree").jstree("get_selected");
		if(selectNode != "HOME" && selectNode != ""){//선택한 노드가 있음
			
		
			var node = tree.get_node(selectNode);
			if(node != null){
				var selectFolderId = node.id + "";
				var groupId = $("#<portlet:namespace/>groupId").val();
				var vcToken = $("#<portlet:namespace/>vcToken").val();
				
				bStart();
				jQuery.ajax({
		 	 		type: "POST",
		 	 		url: "<%=deleteFolderURL%>",
		 	 		data: {
		 	 			"<portlet:namespace/>groupId" : groupId,
		 	 			"<portlet:namespace/>vcToken" : vcToken,
		 	 			"<portlet:namespace/>selectFolderId" : selectFolderId
		 	 		},
		 	 		async : true,
		 	 		success: function(data) {
		 	 	    	if(data.status == 200 || data.status == 201){
							 var del = tree.delete_node(node);
							 var nodeParents = node.parents;
							 
							 if(del){
			 		 			$("#myfileTree").jstree("destroy");
			 	 	    		var folderArr = <portlet:namespace/>getRepositoryFolder();
			 	 	    		<portlet:namespace/>initJstree(folderArr, node.parent, nodeParents);
								 alert(Liferay.Language.get('edison-simulation-myfile-delete-alert')); 
							 }
		 	 	    	}else{
		 	 	    		alert(Liferay.Language.get('edison-data-delete-error'));
		 	 	    	}
		 	 		},error:function(){
		 	 			bEnd();
		 	 			alert(Liferay.Language.get('edison-data-delete-error'));
		 	 		},complete: function(){
		 	 			bEnd();
					}
		 	 	});	 
			}
			
		} 
	}
}



function <portlet:namespace/>fileDivWidthEvent2(){
	var maxWidth = 0;
	
	
	/*var ua = window.navigator.userAgent;
	//익스플로러인경우는 width - 25 
	if(ua.indexOf('MSIE') > 0 || ua.indexOf('Trident') > 0){
		//rightWidth = rightWidth - 25;
	}*/
	
	if(<%=popupState%>){
		$("body").css("margin","5px");
	}
	
	var fileboxWidth = $(".myfilebox").width();
	var leftWidth = $(".leftcontent").width();
	var rightWidth = fileboxWidth - leftWidth - 51;
	
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
	
	if($("input[name=<portlet:namespace/>fileChk]:checked").length == 0 ){
		alert(Liferay.Language.get('edison-simulation-myfile-download-not-select-alert'));
	}else{
		$("input[name=<portlet:namespace/>fileChk]:checked").each(function() {
			$fileId = $(this).val();
			$iframe = $("<iframe/>").attr("src","<%=icebreakerUrl%>/api/file/download?id="+$fileId);
			$iframeDiv.append($iframe)
		}); 
	}
	
	$("#<portlet:namespace/>filechkAll").prop("checked",false);
}

//check된 file 삭제
function <portlet:namespace/>checkfileDelete(){
	
	var deleteFile = [];
	if($("input[name=<portlet:namespace/>fileChk]:checked").length == 0 ){
		alert(Liferay.Language.get('edison-simulation-myfile-delete-not-select-alert'));
		return false;
	}else{
		
		if(confirm(Liferay.Language.get('edison-simulation-myfile-delete-file-confirm-alert'))){
			$("input[name=<portlet:namespace/>fileChk]:checked").each(function() {
				deleteFile.push($(this).val());
			});
			
				
	   		var groupId = $("#<portlet:namespace/>groupId").val();
	   		var vcToken = $("#<portlet:namespace/>vcToken").val();
	   		
			if(deleteFile.length > 0){
				var selectNode = $("#myfileTree").jstree("get_selected");
				if(selectNode == ""){//선택한 노드가 없음
					selectNode = "HOME";
				}

				bStart();
				jQuery.ajax({
		 	 		type: "POST",
		 	 		url: "<%=deleteFileURL%>",
		 	 		data: {
		 	 			"<portlet:namespace/>groupId" : groupId,
		 	 			"<portlet:namespace/>vcToken" : vcToken,
		 	 			"<portlet:namespace/>deletefileId" : deleteFile.valueOf()
		 	 		},
		 	 		async : true,
		 	 		success: function(data) {
		 	 			
		 	 			if(data.status == 200){
			 	 			<portlet:namespace/>getChildFile(selectNode);
		 	 	    		$("#<portlet:namespace/>filechkAll").prop("checked",false);
			 	 			alert(Liferay.Language.get('edison-simulation-myfile-delete-filet-alert'));
		 	 			}else{
			 	 			alert(Liferay.Language.get('edison-data-delete-error'));
		 	 			}
		 	 		},error: function(){
		 	 			bEnd();
		 	 			alert(Liferay.Language.get('edison-data-delete-error'));
		 	 		},complete: function(){
		 	 			bEnd();
					}
		 	 	});	 
			}
		}
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
	URL = URL + "&<portlet:namespace/>workflowType=<%=workflowType%>";
	URL = URL + "&<portlet:namespace/>vcToken="+vcToken+"&<portlet:namespace/>destFolerId="+selectNode+"&<portlet:namespace/>destFolerParents="+nodeParents;
	
	$("#icebreaker-file-upload-dialog").load(URL, function (e) {
		$("#icebreaker-file-upload-dialog").dialog("open")
	});
}

//file path return 
function <portlet:namespace/>clipUrl(fileId, fileNm, path){
	prompt("<%=pathCopyStr%>", path);
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





/***삭제****/
/*  function myFilePopup(responseFormId, responseFileName,simulationWorkflowType){
	//$("#"+responseFormId).val("").change();
	//$("#"+responseFileName).val("").change();
		
 	var <portlet:namespace/>url = "${preprocessorPopupRenderURL}&${preprocessorPortletNamespace}returnId="+responseFormId+"&${preprocessorPortletNamespace}returnFileName="+responseFileName+"&${preprocessorPortletNamespace}cluster=EDISON-TEST&${preprocessorPortletNamespace}workflowType="+simulationWorkflowType;
	
	var <portlet:namespace/>width = 1200;
	var <portlet:namespace/>height = 800;
	var <portlet:namespace/>top = (screen.availHeight / 2) - (<portlet:namespace/>height / 2);
	var <portlet:namespace/>left = (screen.availWidth / 2) - (<portlet:namespace/>width / 2); 
	var <portlet:namespace/>popupWindowName = "myFilePopup";
	var <portlet:namespace/>popupOption = "directories=no, width="+<portlet:namespace/>width+", height="+<portlet:namespace/>height+", top="+<portlet:namespace/>top+", left="+<portlet:namespace/>left+", location=0, menubar=0, resizeable=no, scrollbars=1, status=0, toolbar=0";

	var popup = window.open(<portlet:namespace/>url, <portlet:namespace/>popupWindowName, <portlet:namespace/>popupOption);
	
	popup.focus(); 
}  */
</script>