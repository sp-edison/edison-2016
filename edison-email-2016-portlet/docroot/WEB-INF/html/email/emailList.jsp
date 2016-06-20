<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:resourceURL var="getSentEmailListURL" id="getSentMailList" escapeXml="false" copyCurrentRenderParameters="false">
</liferay-portlet:resourceURL>

<liferay-portlet:renderURL copyCurrentRenderParameters="false" var="getEmailRenderUrl" >
	<liferay-portlet:param name="myRender" value="getEmailRender"/>
<%-- 	<liferay-portlet:param name="sendMailId" value="${sendMailId}" /> --%>
</liferay-portlet:renderURL>

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
	
	<h1>Email</h1>
	
	<div class="tabletopbox01">
		<div class="search">
			<div class="searchbox">
				<input type="text" id="<portlet:namespace/>searchValue"  name="<portlet:namespace/>searchValue" value="${searchValue}" 
					onkeypress="if(event.keyCode==13)<portlet:namespace/>getSendEmailList(1); " placeholder='<liferay-ui:message key="edison-email-searchMail-placeholder"/>'>
				<input type="button" onClick="<portlet:namespace/>getSendEmailList(1)" class="btnsearch">
			</div>
			<input type="button" value="<liferay-ui:message key='edison-button-all-search' />" onClick="<portlet:namespace/>searchAllClick()" class="button03">
		</div>
		<div class="tabletopright">
			<select id="<portlet:namespace/>listSize" name="<portlet:namespace/>listSize" onchange="<portlet:namespace/>getSendEmailList(1)" class="selectview">
				<option value="10" <c:if test="${listSize == '10' }"> selected="selected"</c:if> >10<liferay-ui:message key='edison-search-views' /></option>
				<option value="20" <c:if test="${listSize == '20' }"> selected="selected"</c:if> >20<liferay-ui:message key='edison-search-views' /></option>
				<option value="50" <c:if test="${listSize == '50' }"> selected="selected"</c:if> >50<liferay-ui:message key='edison-search-views' /></option>
				<option value="100" <c:if test="${listSize == '100' }"> selected="selected"</c:if> >100<liferay-ui:message key='edison-search-views' /></option>
			</select>
		</div>
	</div>
	
	<div class="table1_list borderno">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list" >
			<colgroup id="boardColgroup">
				<col width="8%" />
				<col/>
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
			</colgroup>
			<thead>
			<tr>
				<th><liferay-ui:message key='edison-table-list-header-index' /></th>
				<th><liferay-ui:message key='edison-table-list-header-title' /></th>
				<th><liferay-ui:message key="edison-email-sendCount"/></th>
				<th><liferay-ui:message key="edison-email-successCount"/></th>
				<th><liferay-ui:message key="edison-email-failCount"/></th>
				<th><liferay-ui:message key="edison-email-name"/></th>
				<th><liferay-ui:message key="edison-email-sendDate"/></th>
			</tr>
			</thead>
			<tbody id="<portlet:namespace/>sendEmailListBody">
			</tbody>
		</table>
	</div>
	
	<div id="<portlet:namespace/>paging" class="paging"></div>
		
<%
	if(isLogin){
%>
		<c:set var="writeButtonCheck" value="false"/>
		<c:if test="${isSiteAdministratorThan==true || isCustomAdmin}">
			<c:set var="writeButtonCheck" value="true"/>
		</c:if>
		<div class="buttonbox" style="position: absolute; bottom: 24px; width:auto; right:1%;">
		<c:if test="${writeButtonCheck==true }">
			<input class="button02" type="button" onClick="<portlet:namespace/>writeEmail()" value="<liferay-ui:message key="edison-email-write"/>" />
		</c:if>
<%
	}
%>
		</div>
	 
	<script type="text/javascript">
	
	var currentPage = "${currentPage}";
	
	function <portlet:namespace/>getSendEmailList(p_currentPage){
		
		currentPage = p_currentPage;
		
		var boardInputForm = {
						"<portlet:namespace/>methodName" : "<portlet:namespace/>getSendEmailList",
						"<portlet:namespace/>currentPage" : p_currentPage,
						"<portlet:namespace/>searchValue" : $('#<portlet:namespace/>searchValue').val(),
						"<portlet:namespace/>listSize" : $('#<portlet:namespace/>listSize').val()
						};
		jQuery.ajax({
			type: "POST",
			url: "<%=getSentEmailListURL%>",
			data: boardInputForm,
	  		async : false,
			success: function(data) {
				var sendEmailList = data.sendMailList;		
				
				$("#<portlet:namespace/>sendEmailListBody tr:not(:has(#1))").remove();			
				$vRow = $("<tr/>");
				
				if(sendEmailList.length == 0){
					$("<td/>").attr("colspan", "7")
					  .css("height", "40px")
					  .html("<p style='text-align:center;'><liferay-ui:message key='edison-there-are-no-data' /></p>")
					  .appendTo($vRow);				
	
					$("#<portlet:namespace/>sendEmailListBody").append($vRow);
				}else{
					
					for(var i = 0 ; i < sendEmailList.length; i++ ){
						
						$vRow = $("<tr/>").addClass("onMouseHover")
										  .attr("onclick", "javascript:<portlet:namespace/>viewSentEmail('"+sendEmailList[i].sendMailId+"')");
						
	 					if(i%2 == 1){
	 						$vRow.addClass("tablebgtr");
	 					}
						
						$("<td/>").text(data.seq-i)
								  .addClass("TC")
								  .appendTo($vRow);
	
						$("<td/>").html(sendEmailList[i].title)
								  .addClass("TL")
								  .appendTo($vRow);
						$("<td/>").html(sendEmailList[i].sendCount )
								  .addClass("TC")
								  .appendTo($vRow);
						$("<td/>").html(sendEmailList[i].successCount )
								  .addClass("TC")
								  .appendTo($vRow);					
						$("<td/>").html(sendEmailList[i].failCount )
								  .addClass("TC")
								  .appendTo($vRow);
						$("<td/>").html(sendEmailList[i].screenName )
								  .addClass("TC")
								  .appendTo($vRow);
						$("<td/>").html(sendEmailList[i].sendDate )
								  .addClass("TC")
								  .appendTo($vRow);
						$("#<portlet:namespace/>sendEmailListBody").append($vRow);
					}
				}
				
				$("#<portlet:namespace/>paging").html(data.paging);
				
			},error:function(data,e){ 
				alert("list:::sendEmailList===>"+e);
			},complete:function(){
				//boardSearchList("1",divCd);
			}
		});
	}
	
	function <portlet:namespace/>searchAllClick(){
		$('#<portlet:namespace/>searchValue').val("");
		<portlet:namespace/>getSendEmailList(currentPage);
	}
	
	function <portlet:namespace/>writeEmail(){
		var currentPage = $(".select b").html();
		if(currentPage == undefined) {
			currentPage = "1";
		}
		
		var searchValue = $("#<portlet:namespace/>searchValue").val();
		var listSize = $("#<portlet:namespace/>listSize").val();
		
		getBoardRenderURL = "<%=getEmailRenderUrl%>";
		var writeUrl = "";
		writeUrl += getBoardRenderURL; 
		writeUrl += "&<portlet:namespace/>searchValue="+searchValue; 
		writeUrl += "&<portlet:namespace/>currentPage="+currentPage; 
		writeUrl += "&<portlet:namespace/>listSize="+listSize;
		writeUrl += "&<portlet:namespace/>mode=write";
		location.href= writeUrl;
	}
	
	function <portlet:namespace/>viewSentEmail(sendMailId){
		var currentPage = $(".select b").html();
		if(currentPage == undefined) {
			currentPage = "1";
		}
		
		var searchValue = $("#<portlet:namespace/>searchValue").val();
		var listSize = $("#<portlet:namespace/>listSize").val();
		
		getBoardRenderURL = "<%=getEmailRenderUrl%>";
		var writeUrl = "";
		writeUrl += getBoardRenderURL; 
		writeUrl += "&<portlet:namespace/>searchValue="+searchValue; 
		writeUrl += "&<portlet:namespace/>currentPage="+currentPage; 
		writeUrl += "&<portlet:namespace/>listSize="+listSize;
		writeUrl += "&<portlet:namespace/>mode=view";
		writeUrl += "&<portlet:namespace/>sendMailId="+sendMailId;
		location.href= writeUrl;
	}
	
	//####################################################################################
	// Document Ready Define #############################################################
	//####################################################################################		
	
	<portlet:namespace/>getSendEmailList(currentPage);
</script>
	

