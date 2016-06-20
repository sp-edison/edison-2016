<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/html/common/init.jsp" %>
<portlet:defineObjects />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/analyzer/analyzer.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/analyzer/imageviewer/jquery.iviewer.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/analyzer/imageviewer/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/analyzer/imageviewer/jquery.iviewer.js"></script>
<script type="text/javascript">
var iv1 = null;

function imageLoad(imgSource)
{	
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

function imgView(thisObj)
{
	imageLoad(thisObj.value);
}
</script>
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
								<input type="radio" id="${model.fileId}" name="checkboxName" class="fileContents" style="margin-top:-3px;"  value="${model.fileId}"
									onclick="imgView(this)"
								>&nbsp;
									<label for="${model.fileId}"
											onmouseover="this.style.backgroundColor='#c2d7f5';" 
											onmouseout="this.style.backgroundColor='#ffffff';" style="display:inline;">${model.fileName}</label>
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