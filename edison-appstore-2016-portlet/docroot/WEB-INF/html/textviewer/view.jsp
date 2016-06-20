<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<portlet:defineObjects />
<liferay-portlet:resourceURL var="getTextViewerURL" id="getTextViewerData" copyCurrentRenderParameters="false" escapeXml="false"/>
<script type="text/javascript">
$(function () {
	  <portlet:namespace/>initJstree();
});

function <portlet:namespace/>textLoad(textFileId)
{	
	var icebreakerUrl = '<%=request.getAttribute("icebreakerUrl")%>';
	var downloadUrl = icebreakerUrl+"/api/file/download?id="+textFileId;
	
	var fileId = textFileId;
	var textViewData = {
		"<portlet:namespace/>downloadUrl": downloadUrl
	};
	
	$.ajax({
		type: "POST",
		url: "<%=getTextViewerURL%>",
		async : false,
		data  : textViewData,
		dataType : "json",
		success: function(data) {
			if(data.length==1){
				$('#<portlet:namespace/>viewer').attr("viewIndex",0);
				$('#<portlet:namespace/>viewer').attr("totalIndex",0);
				$('#<portlet:namespace/>viewer').html(String(data));
			}else{
				$('#<portlet:namespace/>viewer').attr("viewIndex",0);
				$('#<portlet:namespace/>viewer').attr("totalIndex",data.length);
				$('#<portlet:namespace/>viewer').html(String(data[0]));
				
				$('#<portlet:namespace/>viewer').scroll(function() {
					if ($(this).scrollTop() + $(this).height() >= $(this)[0].scrollHeight - 30) {
						var viewIndex = $(this).attr("viewIndex");
						var totalIndex = $(this).attr("totalIndex");
						
						if(viewIndex<totalIndex){
							var viewIndex = viewIndex*1+1;
							$('#<portlet:namespace/>viewer').attr("viewIndex",viewIndex);
							$('#<portlet:namespace/>viewer').append(String(data[viewIndex]));
						}
					}
				});
			}
		},error:function(data,e){
			console.log(data);
			console.log("textView ERROR-->"+e);
		}
	});
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
			<portlet:namespace/>textLoad(data.node.id);
	});
}
</script>
<div class="analyzerWrapper">
	<div class="analyzerFileList">
		<div id="<portlet:namespace/>analyzerFileList"  class="mflefttree">
		</div>
	</div>
	<div class="analyzerContent">
		<textarea id="<portlet:namespace/>viewer"  style="padding:10px; margin-bottom:0px;width:748px;height: 678px;position:relative;resize: none; cursor: text;" readonly="readonly" ></textarea>
	</div>
</div>
