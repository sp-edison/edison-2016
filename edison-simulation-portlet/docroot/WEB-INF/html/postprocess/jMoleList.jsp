<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${contextPath}/css/postprocessor/post.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/postprocessor/jmol_v4/Jmol.js"></script>

<%
	String fileId =CustomUtil.strNull(request.getAttribute("fileId"));
	String jobSeqNo =CustomUtil.strNull(request.getAttribute("jobSeqNo"));
	String simulationUuid =CustomUtil.strNull(request.getAttribute("simulationUuid"));
	String groupId =CustomUtil.strNull(request.getAttribute("groupId"));
	
	String icebreakerUrl =CustomUtil.strNull(request.getAttribute("icebreakerUrl"));


	String apiBase = icebreakerUrl + "/api/file/download?id=";
	String resolution = "['750','700']";
	String url = apiBase+fileId;	
%>


<liferay-portlet:renderURL var="postJmoleURL" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="postJmole" />
	<liferay-portlet:param name="jobSeqNo" value="<%=jobSeqNo%>" />
	<liferay-portlet:param name="simulationUuid" value="<%=simulationUuid%>" />
	<liferay-portlet:param name="groupId" value="<%=groupId%>" />
</liferay-portlet:renderURL>

<style>
@charset "utf-8";
/* CSS Document */
#jmolApplet0{
 	margin-left: 10px;
}
#postTable{
	line-height: 17px;
}
</style>
<script type="text/javascript">
function refresh(){
	var fileId = $("input[type=radio]:checked").val();
	if(fileId==null){
		alert('<liferay-ui:message key="edison-simulation-monitoring-post-processor-choice-file" />');
		return;
	}
	
	var url = "<%=postJmoleURL%>&<portlet:namespace/>fileId="+fileId;
	window.location.href = url;
}

</script>
</head>
<body>
<div id="postwrap">
	<div id="postinfo">
		<div id="postinfocon">
			<Table id="postTable">
				<c:choose>
					<c:when test="${!empty resultList}">
						<c:forEach items="${resultList}" var="model">
							<tr>
								<td>
									<input type="radio" id="${model.fileId}" name="postRadio" ${fileId == model.fileId ? 'checked' : ''} 
											value="${model.fileId}">&nbsp;
											<label for="${model.fileId}"
												onmouseover="this.style.backgroundColor='#c2d7f5';" 
												onmouseout="this.style.backgroundColor='#ffffff';">${model.fileName}</label>											
									</input>
								</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</Table>
		</div>
	</div>
	<div id="postbtn_<%=themeDisplay.getLanguageId()%>" onclick="refresh()"></div>
	<div id="postlist">
		 <div id="postlistcon">
		 	<c:if test="${fileId!='null'}">
				<script>
				jmolInitialize("${contextPath}/js/postprocessor/jmol_v4/", "JmolAppletSigned0.jar");
		 		//jmolInitialize("jmol", "JmolAppletSigned0.jar");
		 		jmolCheckBrowser("popup", "jmol_v4/browsercheck", "onClick");
		 		jmolApplet(<%=resolution %>, "load <%= url %>; select all; cartoon on; wireframe off; spacefill off; color chain; load <%= url %>; ");
				</script>
			</c:if>
		 </div>
	</div>
	 <div id="clear"></div>
</div>
</body>
</html>