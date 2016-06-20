<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:resourceURL var="getBoardDivBoardsURL" id="getBoardDivBoards" escapeXml="false" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="addBoardURL" id="addBoard" escapeXml="false" copyCurrentRenderParameters="false" >
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:resourceURL>

<liferay-portlet:renderURL copyCurrentRenderParameters="false" var="getBoardMaxRenderUrl" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="myRender" value="getBoardRender"/>
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL copyCurrentRenderParameters="false" var="getBoardRenderUrl" >
	<liferay-portlet:param name="myRender" value="getBoardRender"/>
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="deleteBoardActionUrl" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myAction" value="deleteBoardAction"/>
	<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
</liferay-portlet:actionURL>

<style type="text/css">
	.onMouseHover:hover {
		background-color: #ddd;
	}
	
	.faqContent {
		background: #f7f7fb;
		display:none;
	}
	
	.onFaqContent {
		display:table-row;
	}
</style>
<%--### Default Board List Start ######################################################################################################################  --%>	
<% 	
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	String classId = CustomUtil.strNull(httpRequest.getParameter("classId"), "0");
	String solverId = CustomUtil.strNull(httpRequest.getParameter("solverId"), "0");
	
	String mainListYn = renderRequest.getPreferences().getValue("mainListYn", "N");
	long originalBoardPlid = 0;
	String originalBoardPortletName = "";
	String boardPlid = CustomUtil.strNull((portletPreferences.getValue("originalBoardPlid", "0")));
	
	if(boardPlid.equals("")){
		originalBoardPlid = 0;
	}else{
		originalBoardPlid = Long.parseLong(boardPlid);
	}
	originalBoardPortletName = CustomUtil.strNull((portletPreferences.getValue("originalBoardPortletName", "")));
	
	if(originalBoardPlid == 0) originalBoardPlid = plid;
%>
	
	<h1>${boardDivTitle}</h1>
	
	<form name="<portlet:namespace/>viewForm" action="<%=getBoardRenderUrl%>" method="post" style="margin:0px;">
		<input type="hidden" id="<portlet:namespace/>groupBoardSeq" name="<portlet:namespace/>groupBoardSeq" value="">
		<input type="hidden" id="<portlet:namespace/>solverId" name="<portlet:namespace/>solverId" value="${solverId}">
		<input type="hidden" id="<portlet:namespace/>classId" name="<portlet:namespace/>classId" value="${classId }">	
	</form>
	
	<div class="tabletopbox01">
		<div class="search">
			<div class="searchbox">
				<c:if test="${boardDiv.divNm=='FAQ'}">
					<input type="text" id="<portlet:namespace/>searchValue"  name="<portlet:namespace/>searchValue" value="${searchValue}" onkeypress="if(event.keyCode==13)getBoardList<portlet:namespace/>(1); " placeholder="<liferay-ui:message key='edison-board-placeholder-faq' />">
				</c:if>
				<c:if test="${boardDiv.divNm!='FAQ'}">
					<input type="text" id="<portlet:namespace/>searchValue"  name="<portlet:namespace/>searchValue" value="${searchValue}" onkeypress="if(event.keyCode==13)getBoardList<portlet:namespace/>(1); " placeholder="<liferay-ui:message key='edison-board-placeholder' />">
				</c:if>
				<input type="button" onClick="getBoardList<portlet:namespace/>(1)" class="btnsearch">
			</div>
			<input type="button" value="<liferay-ui:message key='edison-button-all-search' />" onClick="searchAllClick<portlet:namespace/>()" class="button03">
		</div>
		<div class="tabletopright">
			<select id="<portlet:namespace/>listSize" name="<portlet:namespace/>listSize" onchange="getBoardList<portlet:namespace/>(1)" class="selectview">
				<option value="10">10<liferay-ui:message key='edison-search-views' /></option>
				<option value="20">20<liferay-ui:message key='edison-search-views' /></option>
				<option value="50">50<liferay-ui:message key='edison-search-views' /></option>
				<option value="100">100<liferay-ui:message key='edison-search-views' /></option>
			</select>
		</div>
	</div>
	
	<!-- FAQ 게시판 체크 -->
	
	<c:choose>
		<c:when test="${boardDiv.divNm=='FAQ'}">
			<div class="table1_list borderno">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list" >
					<colgroup id="boardColgroup">
						<col width="70" />
						<col width="50" />
						<col width="*" />
						<col width="150" />
					</colgroup>
					<thead>
					<tr>
						<th><liferay-ui:message key='edison-table-list-header-index' /></th>
						<th></th>
						<th><liferay-ui:message key='edison-table-list-header-title' /></th>
						<th><liferay-ui:message key='edison-table-list-header-date' /></th>
					</tr>
					</thead>
					<tbody id="boardListBody<portlet:namespace/>">
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<div class="table1_list borderno">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list" >
					<colgroup id="boardColgroup">
						<col width="8%" />
						<col/>
						<col width="12%" />
						<col width="10%" />
						<col width="8%" />
					</colgroup>
					<thead>
					<tr>
						<th><liferay-ui:message key='edison-table-list-header-index' /></th>
						<th><liferay-ui:message key='edison-table-list-header-title' /></th>
						<th><liferay-ui:message key='edison-table-list-header-name' /></th>
						<th><liferay-ui:message key='edison-table-list-header-date' /></th>
						<th><liferay-ui:message key='edison-table-list-header-views' /></th>
					</tr>
					</thead>
					<tbody id="boardListBody<portlet:namespace/>">
					</tbody>
				</table>
			</div>
		</c:otherwise>
	</c:choose>
	
	<div id="paging<portlet:namespace/>" class="paging"></div>
		
<%
	if(isLogin){
%>
		<c:set var="writeButtonCheck" value="false"/>
		<c:choose>
			<c:when test="${boardDiv.divNm=='NOTICE' || boardDiv.divNm=='FAQ'}">
				<c:if test="${isSiteAdministratorThan==true || isCustomAdmin}">
					<c:set var="writeButtonCheck" value="true"/>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:set var="writeButtonCheck" value="true"/>
			</c:otherwise>
		</c:choose>
		<div class="buttonbox" style="position: absolute; bottom: 24px; width:auto; right:1%;">
		<c:if test="${writeButtonCheck==true }">
			<input class="button02" type="button" onClick="writeBoard<portlet:namespace/>()" value="<liferay-ui:message key='edison-button-board-write' />" />
		</c:if>
<%
	}
%>
<%
	if(classId != null && !classId.equals("0")) { 
%>
	<input class="button02" type="button" style="margin-left:5px;" onClick="historyBack<portlet:namespace/>()" value="<liferay-ui:message key='edison-virtuallab-virtualLabClassManagement-class-move' />"/>
<%
	}
%>
		</div>
	 
	<script type="text/javascript">
	
	var currentPage = "${currentPage}";
	
	function getBoardList<portlet:namespace/>(p_currentPage){
		
		currentPage = p_currentPage;
		
		var boardInputForm = {
						"<portlet:namespace/>methodName" : "getBoardList<portlet:namespace/>",
						"<portlet:namespace/>currentPage" : p_currentPage,
						"<portlet:namespace/>searchValue" : $('#<portlet:namespace/>searchValue').val(),
						"<portlet:namespace/>listSize" : $('#<portlet:namespace/>listSize').val(),
						"<portlet:namespace/>classId" : "${classId}",
						"<portlet:namespace/>solverId" : "${solverId}"
						};
		jQuery.ajax({
			type: "POST",
			url: "<%=getBoardDivBoardsURL%>",
			data: boardInputForm,
	  		async : false,
			success: function(data) {
				var boardList = data.boardList;		
				
				$("#boardListBody<portlet:namespace/> tr:not(:has(#1))").remove();			
				$vRow = $("<tr/>");
				
				if("${boardDiv.divNm}"=='FAQ') {
					if(boardList.length == 0){
						$("<td/>").attr("colspan", "4")
						  .css("height", "40px")
						  .html("<p style='text-align:center;'>${boardDiv.divNm} <liferay-ui:message key='edison-there-are-no-data' /></p>")
						  .appendTo($vRow);				
		
						$("#boardListBody<portlet:namespace/>").append($vRow);
					}else{
						for(var i = 0 ; i < boardList.length; i++ ){
							
							$vRow = $("<tr/>").addClass("faqHeader")
											  .css("cursor", "pointer")
											  .attr("onclick","viewDownRow('" + (data.seq - i) + "')");
							
							$("<td/>").text(data.seq-i)
									  .addClass("TC")
									  .appendTo($vRow);
							$("<td/>").addClass("TC")
									  .append($("<img/>").attr("src", "${contextPath}/images/Q.png"))
									  .appendTo($vRow);
							$("<td/>").html(boardList[i].title + (boardList[i].replyCount > 0? "<b>("+boardList[i].replyCount+")</b>":"") )
									  .addClass("TL")
									  .appendTo($vRow);
							$("<td/>").html(boardList[i].writerDate )
									  .addClass("TC")
									  .appendTo($vRow);
							$("#boardListBody<portlet:namespace/>").append($vRow);
							
							$vRow = $("<tr/>").addClass("faqContent")
											  .attr("id", "faqContent_" + (data.seq-i));
							
							$("<td/>").appendTo($vRow);
							

							$("<td/>").appendTo($vRow);
							
							var adminCheck = "${writeButtonCheck}";

							if(adminCheck) {
								$("<td/>").attr("colspan", "2")
										  .append($("<div/>").css("height", "100%").append($("<img/>").attr("src", "${contextPath}/images/A.png").css("float","left").css("margin", "4px 10px 0px 0px")))
										  .append(boardList[i].content)
										  .addClass("TL")
										  .append($("<div/>").css("text-align", "right")
															 .append($("<input/>").attr("type", "button")
																				  .attr("value", "<liferay-ui:message key='edison-button-board-modify' />")
																				  .attr("onclick", "<portlet:namespace/>modify('" + boardList[i].boardSeq + "')")
																				  .addClass("button01b")
																				  .css("padding", "3px 7px")
																				  .css("margin-right", "10px")
																	 )
															 .append($("<input/>").attr("type", "button")
																				  .attr("value", "<liferay-ui:message key='edison-button-board-delete' />")
																				  .attr("onclick", "<portlet:namespace/>deleteBoard('" + boardList[i].boardSeq + "')")
																				  .addClass("button01b")
																				  .css("padding", "3px 7px")
																	 )
												  )
										  .appendTo($vRow);
							} else {
								$("<td/>").attr("colspan", "2")
										  .append($("<img/>").attr("src", "${contextPath}/images/A.png").css("float","left").css("margin", "4px 10px 0px 0px"))
										  .append(boardList[i].content)
										  .addClass("TL")
										  .appendTo($vRow);
							}
							
							$("#boardListBody<portlet:namespace/>").append($vRow);
							
						}

					}
				} else {
					if(boardList.length == 0){
						$("<td/>").attr("colspan", "5")
						  .css("height", "40px")
						  .html("<p style='text-align:center;'>${boardDiv.divNm} <liferay-ui:message key='edison-there-are-no-data' /></p>")
						  .appendTo($vRow);				
		
						$("#boardListBody<portlet:namespace/>").append($vRow);
					}else{
						
						for(var i = 0 ; i < boardList.length; i++ ){
							
							$vRow = $("<tr/>").addClass("onMouseHover")
											  .attr("onclick", "javascript:viewClick<portlet:namespace/>('"+boardList[i].boardSeq+"', '"+p_currentPage+"')");
							
		 					if(i%2 == 1){
		 						$vRow.addClass("tablebgtr");
		 					}
							
							$("<td/>").text(data.seq-i)
									  .addClass("TC")
									  .appendTo($vRow);
		
							$("<td/>").html(boardList[i].title + (boardList[i].replyCount > 0? "<b>("+boardList[i].replyCount+")</b>":"") )
									  .addClass("TL")
									  .appendTo($vRow);
							$("<td/>").html(boardList[i].writerName )
									  .addClass("TC")
									  .appendTo($vRow);
							$("<td/>").html(boardList[i].writerDate )
									  .addClass("TC")
									  .appendTo($vRow);					
							$("<td/>").html(boardList[i].readCnt )
									  .addClass("TC")
									  .appendTo($vRow);
							$("#boardListBody<portlet:namespace/>").append($vRow);
						}
					}
				}
				
				$("#paging<portlet:namespace/>").html(data.paging);
				
			},error:function(data,e){ 
				alert("list:::BoardList===>"+e);
			},complete:function(){
				//boardSearchList("1",divCd);
			}
		});
	}
	
	function viewClick<portlet:namespace/>(p_boardSeq, p_currentPage){
		var vClassId = "${classId }"==""?"":Number("${classId }");
		var vSolverId = "${solverId }"==""?"":Number("${solverId }");
		var getBoardRenderURL = "";
		var searchValue = $("#<portlet:namespace/>searchValue").val();
		var vMainListYn = "<%=mainListYn%>";
		
		if(vMainListYn == 'Y') {
			getBoardRenderURL = "<%=getBoardMaxRenderUrl%>";
		} else {
			getBoardRenderURL = "<%=getBoardRenderUrl%>";
		}
		
		if(vClassId > 0) {
			location.href= getBoardRenderURL + "&<portlet:namespace/>boardSeq="+p_boardSeq+"&<portlet:namespace/>currentPage="+p_currentPage+"&<portlet:namespace/>searchValue="+searchValue+"&<portlet:namespace/>classId=${classId}&classId=${classId}";
		} else if(vSolverId > 0){
			location.href= getBoardRenderURL + "&<portlet:namespace/>boardSeq="+p_boardSeq+"&<portlet:namespace/>currentPage="+p_currentPage+"&<portlet:namespace/>searchValue="+searchValue+"&<portlet:namespace/>solverId=${solverId}&solverId=${solverId}";
		} else {
			location.href= getBoardRenderURL + "&<portlet:namespace/>boardSeq="+p_boardSeq+"&<portlet:namespace/>currentPage="+p_currentPage+"&<portlet:namespace/>searchValue="+searchValue;
		}
		
	}
	
	function viewDownRow(rowNum) {
		/* $(".onFaqContent").removeClass("onFaqContent"); */
		$("#faqContent_" + rowNum).toggleClass("onFaqContent")
	}
	
	function searchAllClick<portlet:namespace/>(){
		$('#<portlet:namespace/>searchValue').val("");
		getBoardList<portlet:namespace/>(currentPage);
	}
	
	function writeBoard<portlet:namespace/>(){
		var currentPage = $(".select b").html();
		if(currentPage == undefined) {
			currentPage = "1";
		}
		
		var searchValue = $("#<portlet:namespace/>searchValue").val();
		var vClassId = "${classId }"==""?"":Number("${classId }");
		var vSolverId = "${solverId }"==""?"":Number("${solverId }");
		var vMainListYn = "<%=mainListYn%>";
		
		if(vMainListYn == 'Y') {
			getBoardRenderURL = "<%=getBoardMaxRenderUrl%>";
		} else {
			getBoardRenderURL = "<%=getBoardRenderUrl%>";
		}
		
		if(vClassId > 0) {
			location.href= getBoardRenderURL + "&<portlet:namespace/>RENDER_SORT=WRITE&<portlet:namespace/>classId=${classId}&classId=${classId}";
		} else if(vSolverId > 0){
			location.href= getBoardRenderURL + "&<portlet:namespace/>RENDER_SORT=WRITE&<portlet:namespace/>solverId=${solverId}&solverId=${solverId}";
		} else {
			location.href= getBoardRenderURL + "&<portlet:namespace/>RENDER_SORT=WRITE";
		}
	}
	
	function <portlet:namespace/>modify(boardSeq){
		$("#<portlet:namespace/>groupBoardSeq").val(boardSeq);
		var currentPage = $(".select b").html();
		if(currentPage == undefined) {
			currentPage = "1";
		}
		
		var searchValue = $("#<portlet:namespace/>searchValue").val();
		<portlet:namespace/>viewForm.action = "<%=getBoardRenderUrl%>&<portlet:namespace/>boardSeq=" + boardSeq + "&<portlet:namespace/>RENDER_SORT=" + "UPDATE" + "&<portlet:namespace/>searchValue=" + searchValue + "&<portlet:namespace/>currentPage=" + currentPage;
		<portlet:namespace/>viewForm.submit();
	}

	function <portlet:namespace/>deleteBoard(boardSeq){
		if(confirm("Delete ?")){
			$("#<portlet:namespace/>groupBoardSeq").val(boardSeq);
			<portlet:namespace/>viewForm.action = "<%=deleteBoardActionUrl%>&<portlet:namespace/>boardSeq=" + boardSeq;
			<portlet:namespace/>viewForm.submit();
		}
	}
	
	//####################################################################################
	// Document Ready Define #############################################################
	//####################################################################################		

	getBoardList<portlet:namespace/>(currentPage);
</script>
	
<aui:script>
function historyBack<portlet:namespace/>(){
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid(<%=originalBoardPlid%>);	<!-- 가상클래스 페이지 Plid -->
		portletURL.setPortletMode("view");
		if("${classId}" > 0) {
			location.href = portletURL.toString() + "&classId=${classId}";
		} else if("${solverId}" > 0){
			location.href = portletURL.toString() + "&solverId=${solverId}";
		} else {
			location.href = portletURL.toString();
		}
	});
}
</aui:script>

<%--### Default Board List End ######################################################################################################################  --%>

