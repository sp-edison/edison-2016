<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<portlet:defineObjects />
<script type="text/javascript">
var iv1 = null;

$(function () {
	  <portlet:namespace/>initJstree();
});

function <portlet:namespace/>imageLoad(imgFileId)
{	
	var icebreakerUrl = '<%=request.getAttribute("icebreakerUrl")%>';
	var downloadUrl = icebreakerUrl+"/api/file/download?id="+imgFileId;
	if(iv1 ==null)
	{
	    iv1 = $("#<portlet:namespace/>viewer").iviewer({
	        src: downloadUrl
	   });
	}
	else
		$('#<portlet:namespace/>viewer').iviewer('loadImage', downloadUrl );
}

function <portlet:namespace/>initJstree()
{
	var dataList = <%=request.getAttribute("resultDataList")%>;
	var dataArr = [];
	for(var i=0 ; i< dataList.length ; i++ ){
		var obj = {
			"id": dataList[i].id,
			"text": dataList[i].name,
			"type":"file",
			"li_attr": {
				"childLength": 0
			}
		};
		dataArr.push(obj);
	}
	
	var rootData = [{
		"id":"ROOT",
		"text":"Result",
		"type":"open",
		"children": dataArr,
		"li_attr":{
			"childLength" : dataArr.length			
		}
	}];
	$("#<portlet:namespace/>analyzerFileList").jstree({
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
		$("#<portlet:namespace/>analyzerFileList").jstree("open_all");
		$("#<portlet:namespace/>analyzerFileList").jstree("deselect_all");
	}).bind("select_node.jstree",function(e, data){//노드 선택 이벤트
		if(data.node.id != "ROOT")
			<portlet:namespace/>imageLoad(data.node.id);
	});
}
</script>
<div class="analyzerWrapper">
	<div class="analyzerFileList">
		<div id="<portlet:namespace/>analyzerFileList"  class="mflefttree">
		</div>
	</div>
	<div class="analyzerContent">
		<div id="<portlet:namespace/>viewer" class="analyzerViewer"></div>
	</div>
</div>
