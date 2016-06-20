<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<liferay-portlet:resourceURL var="getBoardDivBoardsURL" id="getBoardDivBoards" escapeXml="false" copyCurrentRenderParameters="false"/>

<%--### Main Board List Start ######################################################################################################################  --%>

<%
	long originalBoardPlid = Long.parseLong(CustomUtil.strNull((portletPreferences.getValue("originalBoardPlid", "0"))));
	String originalBoardPortletName = CustomUtil.strNull((portletPreferences.getValue("originalBoardPortletName", "")));
	String divCd = CustomUtil.strNull((portletPreferences.getValue("divCd", "100")));
	
	if(originalBoardPlid == 0) originalBoardPlid = plid;
%>
<%
	String classId = CustomUtil.strNull(request.getAttribute("classId"), "0");
	String solverId = CustomUtil.strNull(request.getAttribute("solverId"), "0");
%>
	
	<liferay-portlet:renderURL plid="<%=originalBoardPlid %>" portletMode="view" var="originalBoardListUrl">
		<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
	</liferay-portlet:renderURL>
	
	<liferay-portlet:renderURL plid="<%=originalBoardPlid %>" portletName="<%=originalBoardPortletName %>" portletMode="view" var="originalBoardViewUrl" copyCurrentRenderParameters="false">
		<liferay-portlet:param name="myRender" value="getBoardRender" />
		<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
	</liferay-portlet:renderURL>
	
	<liferay-portlet:renderURL portletMode="view" var="originalBoardListMaxUrl" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
		<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
		<liferay-portlet:param name="maxList" value="Y" />
	</liferay-portlet:renderURL>
	
	<liferay-portlet:renderURL windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>" portletMode="view" var="originalBoardViewMaxUrl" copyCurrentRenderParameters="false">
		<liferay-portlet:param name="boardGroupId" value="${boardGroupId}" />
		<liferay-portlet:param name="myRender" value="getBoardRender" />
	</liferay-portlet:renderURL>
	
	<div class="noticesbox" style="background:#f2f2f2;">
		<div class="noticetit"> ${boardDivTitle} 
		<%
			if(!classId.equals("0")){
		%>
				<a href="<%=originalBoardListMaxUrl%>&classId=${classId}"><img src="${contextPath}/images/readmoreimg.gif" width="25" height="25" /></a>
		<%
			} else if(!solverId.equals("0")){
		%>
				<a href="<%=originalBoardListMaxUrl%>&solverId=${solverId}"><img src="${contextPath}/images/readmoreimg.gif" width="25" height="25" /></a>
		<%
			} else {
		%>
				<a href="<%=originalBoardListUrl%>"><img src="${contextPath}/images/readmoreimg.gif" width="25" height="25" /></a>
		<%
			}
		%>
		</div>
		<div id="boardListBody<portlet:namespace/>" class="notice-table">
		</div>
	</div>
	
	<script type="text/javascript">
	
	var currentPage = "${currentPage}";
	
	function getBoardList<portlet:namespace/>(p_currentPage){
		
		currentPage = p_currentPage;	
		
		var boardInputForm = {
						"<portlet:namespace/>classId" : "${classId}",
						"<portlet:namespace/>solverId" : "${solverId}",
						"<portlet:namespace/>methodName" : "getBoardList<portlet:namespace/>",
						"<portlet:namespace/>currentPage" : p_currentPage,
						"<portlet:namespace/>listSize" : "4"
						};
		jQuery.ajax({
			type: "POST",
			url: "<%=getBoardDivBoardsURL%>",
			data: boardInputForm,
	  		async : false,
			success: function(data) {
				var boardList = data.boardList;
				var divCd = data.divCd;
				$("#boardListBody<portlet:namespace/>").empty();			
				
				if(boardList.length == 0){
					$vRow = $("<div/>").addClass("notice-mtr")
										.append(
											   $("<div/>").css("text-align", "center")
											   			  .css("font-size", "15px")
											   			  .html("<p><liferay-ui:message key='edison-there-are-no-data' /></p>")
										)
	
					$("#boardListBody<portlet:namespace/>").append($vRow);
				}else{

					for(var i = 0 ; i < boardList.length; i++ ){
						$vRow = $("<div/>").addClass("notice-mtr")
										   .attr("onclick", "javascript:viewClick<portlet:namespace/>('"+boardList[i].boardSeq+"')")
										   .append(
												   $("<div/>").addClass("notice-mtitle")
															  .html("<p><a href='javascript:;'>"+boardList[i].title+"</a></p>")
											)
										   .append(
												   $("<div/>").addClass("notice-mdate")
															  .html(boardList[i].writerDate)
											);
						
						$("#boardListBody<portlet:namespace/>").append($vRow);
					}
				}
				
			},error:function(data,e){ 
				alert("listMain:::BoardList===>"+e);
			},complete:function(){
				//boardSearchList("1",divCd);
			}
		});
	}
	
	function viewClick<portlet:namespace/>(p_boardSeq){
		
		var vClassId = "${classId }"==""?"":Number("${classId }");
		var vSolverId = "${solverId }"==""?"":Number("${solverId }");

		if(vClassId > 0) {
			document.mainBoardForm<portlet:namespace/>.action = "<%=originalBoardViewMaxUrl%>&<portlet:namespace/>classId=${classId}&classId=${classId}&<portlet:namespace/>boardSeq=" + p_boardSeq;
		} else if(vSolverId > 0) {
			document.mainBoardForm<portlet:namespace/>.action = "<%=originalBoardViewMaxUrl%>&<portlet:namespace/>solverId=${solverId}&solverId=${solverId}&<portlet:namespace/>boardSeq=" + p_boardSeq;
		} else {
			document.mainBoardForm<portlet:namespace/>.action = "<%=originalBoardViewUrl%>&_<%=originalBoardPortletName%>_boardSeq="+p_boardSeq;
		}
		
		document.mainBoardForm<portlet:namespace/>.submit();
		
	}
		
	getBoardList<portlet:namespace/>(currentPage);
	
	</script>
	
	<form name="mainBoardForm<portlet:namespace/>" method="post">
	</form>
 
	<style type="text/css">
	
	.popuptitle{
		padding-top:60px; 
		padding-left:20px; 
		font-weight:600; 
		font-size:16px; 
		color:#D35400;
	}
	
	.popupcontxt{
		height:350px;
		padding:15px 25px 15px 25px; 
		font-size:13px; 
		line-height:1.5em;
	}
	.closetxt{
		font-size:11px; 
		color:#fff; 
		margin-top:28px; 
		padding-left:15px;
	}
	
	.closetxt img{
		vertical-align:middle;
	}
	
	.ui-icon {
		visibility: hidden;
	}
	 
	.popupWrap {
	    clear: left;
	    margin-right: 10px;
	    padding: 5px;
	    float: left;
	    border-width: 1px;
	    border-color: #f9f9f9;
	    border-radius: 5px;
	    box-shadow: 0px 0px 33px 8px lightgray;
	    background-color: #f9f9f9;
	} 
	.popupTitle {
		width: 80%;
		height:50px;
		float: left;
		padding: 10px 10px 0px 46px;
		font-size: 20px;
		font-weight: 600;
		line-height: normal;
		background: url(/edison-board-2016-portlet/images/bcicon.png) no-repeat 10px 10px;
	}
	.popupClose {
		width: 30px;
		float: right;
	 	padding: 10px 10px 0px 0px;
		font-size: 24px;
		font-weight: 600;
	}
	.popupTrLine {
		width:95%;
		padding-bottom:10px;
		margin-top:10px;
		border-bottom: solid 1px #ccc;
	}
	
	.popupContent {
		width:554px;
		height:285px;
		margin :0 auto;
		padding: 5px 9px 10px 9px;
		background-color: #FFFFFF;
	}
	
	.smallpupboxBoard{
				width:100%; border-radius:5px; -webkit-border-radius:5px; border:solid 3px #ddd;
				font-family: Tahoma,Arial, Nanum Barun Gothic, NanumGothic;
				}
	.smallpuptitle{border-radius:3px 3px 0px 0px; -webkit-border-radius:3px 3px 0px 0px; padding:5px; color:#fff; 
					font-size:15px; font-weight:600; background:url(/edison-board-2016-portlet/images/popbl.png) no-repeat 15px 12px; 
					padding-left:55px; padding-right:17px; 
					background-color:#3fabc7; position:relative;
					height: 40px;
					vertical-align: middle;
					}
	.smpupclosebtn{position:absolute; right:18px; top:23px;}
	.smpuptable{width:80%; padding:20px; margin:0 auto;}
	.notice-mtitle p {margin:0px; padding:0px;}
	.notice-mtitle p a,.notice-mtitle p a:visited, .notice-mtitle p a:link{color:#666;}
	.notice-mtitle p a:hover{color:#000;}
	</style>
	<c:if test="${popState ne 'NO'}">
		<c:forEach items="${popupList}" var="model"> 
			<div id="POPUP_${model.boardSeq}" class="smallpupboxBoard" style="width:600px; height:405px; font-family: Arial,Nanum Barun Gothic,NanumGothic;">			
				<div style="vertical-align: middle;">
					<div class="smallpuptitle"> 
						${model.title} 
					</div>	  
					<div class="smpupclosebtn">
						<img src="${contextPath}/images/closeicon.png" width="21" height="21" onclick="closePopup('POPUP_${model.boardSeq}');return false;" style="cursor: pointer;"/>
					</div>
				</div><br>
				
				<div class="popupContent" style="overflow: auto;">
					<c:out value="${model.content}" escapeXml="false"/>
				</div>

				<div>
					<c:forEach items="${model.fileList}" var="fileModel">
						<div style="cursor:pointer" onclick="<portlet:namespace/>fileDownload('${fileModel.fileEntryId }')" class="onMouseHover">
							${fileModel.fileTitle }
							<img src="<%=themeDisplay.getPathThemeImages() %>/custom/portlet/fileicon2.png" width="16" height="16" />
						</div>
					</c:forEach>
				</div>
				
				<div style="padding-top: 7px;">
					<div style="float:left">
						<a href="#" onclick="closePopup('POPUP_${model.boardSeq}');return false;" class="onMouseHover"><liferay-ui:message key='edison-button-board-close' /> X</a>
					</div>
					<div style="float:right;padding-right:10px;">
						<a href="#" onclick="closePopupAt('POPUP_${model.boardSeq}');return false;" class="onMouseHover"><liferay-ui:message key='edison-board-popup-close-alert' /> X</a> 
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>	
	  
	<script type="text/javascript">
		function popupCreate(state){
			if(state="YES"){
				$(".smallpupboxBoard").each(function(index){
					$(this).dialog({
						resizable: false,
						modal: false,
						draggable: true,
						width:606,
						height:'auto',
						position: [100*(index+1), 100*(index+1)],
					    show: {effect:'fade', speed: 800}, 
				        hide: {effect:'fade', speed: 800}
					}).dialog("widget").find(".ui-dialog-titlebar").remove();
					
				});
			}
		}
		
		function closePopup(id){
			$("#"+id).dialog("close");;
		}
		
		function closePopupAt(id){
			setCookie( id, "done");
			$("#"+id).dialog("close");;
		}
		
		function setCookie( name, value) {   
			var todayDate = new Date();   
			todayDate.setDate(todayDate.getDate() + 1 );
			document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"   
		}
		
		popupCreate("${popState}");
		
	</script>		
<%--### Main Board List Start ######################################################################################################################  --%>