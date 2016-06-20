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
var iv1 = null;

function imageLoad(imgSource){	
	if(iv1 ==null)
	{
	    iv1 = $("#viewer").iviewer({
	        src: imgSource
	   });
	}
	else
	{
		$('#viewer').iviewer('loadImage', imgSource );
	}
}

function selectAll(){
	var c = $('#checkAll').attr('checked');	
	if(typeof c == 'undefined'){
		$('input[name=checkboxName]').attr('checked',false);
	}else{	
		$('input[name=checkboxName]').attr('checked',c);
	}
}

function imgView(thisObj){
	var apiBase = '<%=icebreakerUrl+"/api/file/download?id="%>';
	imageLoad(apiBase+thisObj.value);
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
									onclick="imgView(this)"
								>&nbsp;
									<label for="${model.fileId}"
											onmouseover="this.style.backgroundColor='#c2d7f5';" 
											onmouseout="this.style.backgroundColor='#ffffff';">${model.fileName}</label>
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
	<div id="postbtn_<%=themeDisplay.getLanguageId()%>"></div>
	<div id="postlist">
		 <div id="postlistcon">
			<div id="viewer" class="viewer" style="width: 780px;height: 700px;"></div>
		 </div>
	</div>
	 <div id="clear"></div>
</div>
</body>
</html>