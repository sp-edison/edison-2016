<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<liferay-portlet:resourceURL var="getWebGLFilePath" id="webGLFilePath">
	<liferay-portlet:param name="token" value="${token}" />
</liferay-portlet:resourceURL>

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
	String vcToken =CustomUtil.strNull(request.getAttribute("vcToken"));
	String resultFilePath =CustomUtil.strNull(request.getAttribute("resultFilePath"));
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
	overflow: scroll;
}

</style>

<script type="text/javascript">

function webGLView(fileId, fileName)
{
	var url = "/data/webgl_temp/<%=resultFilePath%>/"+fileName;
	window.viewer.location.href = url.replace("//","/");
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
									onclick="webGLView('${model.fileId}', '${model.fileName}')"
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
	<div id="postbtn_<%=themeDisplay.getLanguageId()%>" ></div>
	<div id="postlist">
		 <div id="postlistcon">
		 	<!-- style="padding:0px;width: 780px;height: 700px; background-color:'white' ; overflow: 'scroll' " frameborder=0 scrolling="yes"  -->
			<iframe id="viewer" name="viewer"  class="viewer"  style="padding:0px;width: 780px;height: 700px; background-color:'white'" frameborder=0 > </iframe>
		 </div>
	</div>
 	<div id="clear"></div>
</div>
</body>
</html>