<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/html/common/init.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/analyzer/analyzer.css" />

<script type="text/javascript">

function textView(thisObj)
{	
}
</script>
</head>
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
								<input type="radio" id="${model.fileId}" name="checkboxName" class="fileContents"  style="margin-top:-3px;" value="${model.fileId}"
									onclick="textView(this)"
								>&nbsp;
									<label for="${model.fileId}"
											onmouseover="this.style.backgroundColor='#c2d7f5';" 
											onmouseout="this.style.backgroundColor='#ffffff';" style="cursor: pointer;display:inline;">${model.fileName}</label>
									<!-- <input type="button" value="down" class="button03" onclick="textDownload('${model.fileId}');" > -->
									
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
		 <textarea id="postlistcon" style="padding:10px; width:760px;height:677px;resize: none; cursor: text;" readonly="readonly" ></textarea>
	</div>
 	<div id="clear"></div>
</div>