<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<script type="text/javascript" src="${contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery-ui.min.js"></script>

<link href="${contextPath}/css/postprocessor/post.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/postprocessor/jquery.iviewer.css" />

<script type="text/javascript" src="${contextPath}/js/image-viewer/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/image-viewer/jquery.iviewer.js"></script>

<liferay-portlet:resourceURL var="postTextViewerURL" id="postTextViewer" copyCurrentRenderParameters="false" escapeXml="false"/>

<%
	String icebreakerUrl =CustomUtil.strNull(request.getAttribute("icebreakerUrl"));
%>
<style type="text/css">
@charset "utf-8";
/* CSS Document */

#postTable{
	line-height: 17px;
}
#page_title{
	margin: -10px 15px 0px 15px;
}

body {
	font-size:12px;
}

</style>

<script type="text/javascript">

function textDownload(fileId){
	var apiBase = '<%=icebreakerUrl+"/api/file/read?id="%>';
	window.location.href = apiBase+fileId;
}

function textView(thisObj)
{	
	var fileId = thisObj.value;
	var textViewData = {
			"<portlet:namespace/>icebreakerURL": "<%=icebreakerUrl%>",
			"<portlet:namespace/>fileId": fileId
			};
	
	$.ajax({
		type: "POST",
		url: "<%=postTextViewerURL%>",
		async : false,
		data  : textViewData,
		dataType : "json",
		success: function(data) {
			if(data.length==1){
				$('#postlistcon').attr("viewIndex",0);
				$('#postlistcon').attr("totalIndex",0);
				$('#postlistcon').html(data);
			}else{
				$('#postlistcon').attr("viewIndex",0);
				$('#postlistcon').attr("totalIndex",data.length);
				$('#postlistcon').html(data[0]);
				
				
				$('#postlistcon').scroll(function() {
					if ($(this).scrollTop() + $(this).height() >= $(this)[0].scrollHeight - 30) {
						var viewIndex = $(this).attr("viewIndex");
						var totalIndex = $(this).attr("totalIndex");
						
						if(viewIndex<totalIndex){
							var viewIndex = viewIndex*1+1;
							$('#postlistcon').attr("viewIndex",viewIndex);
							$('#postlistcon').append(data[viewIndex]);
						}
					}
				});
				
			}
		},error:function(data,e){
			alert("textView ERROR-->"+e);
		}
	});
}
</script>
</head>
<body> 

<div id="postwrap">
	<div id="postinfo">
		<div id="postinfocon">		
			<Table id="postTable">
				<c:if test="${!empty resultList}">
					<c:forEach items="${resultList}" var="model">
						<tr>
							<td>						
								<c:set var="checkedVal" value=""/>								
								<c:choose>
									<c:when test="${fn:indexOf(checkedFileIds, model.fileId)> -1}">
										<c:set var="checkedVal" value="selected"/>
									</c:when>
									<c:otherwise>
										<c:set var="checkedVal" value=""/>
									</c:otherwise>
								</c:choose>
								<input type="radio" id="${model.fileId}" name="checkboxName" class="fileContents" value="${model.fileId}"
									onclick="textView(this)"
								>&nbsp;
									<label for="${model.fileId}"
											onmouseover="this.style.backgroundColor='#c2d7f5';" 
											onmouseout="this.style.backgroundColor='#ffffff';">${model.fileName}</label>
									<input type="button" value="down" class="button03" onclick="textDownload('${model.fileId}');" style="cursor: pointer;">
									
								</input>
							</td>
						</tr>
					</c:forEach>
				</c:if>		
				<c:if test="${empty resultList}">
					<liferay-ui:message key='edison-there-are-no-data'/>
				</c:if>
			</Table>
		</div>
	</div>
	<div id="postbtn_<%=themeDisplay.getLanguageId()%>" ></div>
	<div id="postlist">
		 <textarea id="postlistcon" style="padding:10px; width:760px;height:677px;resize: none; " readonly="readonly" ></textarea>
	</div>
 	<div id="clear"></div>
</div>
</body>
</html>