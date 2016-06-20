<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%
%>

<style type="text/css">
.srstitwrap{width:100%; clear:both;}
.srstit{width:1220px; margin:0 auto; text-align:center; padding:45px 0 32px 0;}
.srsbox{width:1220px; margin:0 auto;}
.srs{width:35%; height:330px; float:left; border-bottom:solid 1px #1dcbe3; border-right:solid 1px #1dcbe3; margin-bottom:77px;}


.statistictable{margin:0px 50px 0 0;}
.statistictable th{background:#e26123; color:#fefafa; font-size:17px; font-weight:600; padding:8px 10px 15px 10px; border-right:1px solid #d9d9d9;  border-bottom:solid 1px #d9d9d9; text-align: center;}
.statistictable td{border-right:1px solid #d9d9d9; border-bottom:solid 1px #d9d9d9;}
.statistictable td.tit{background:#e3772c; color:#fefafa; text-align:center; font-size:17px; font-weight:600; line-height:2.3em;}

.statistictable.c{background:#eee;}
.statistictable th.c{background:#406DB3; border-right:1px solid #DBDBDB;  border-bottom:solid 1px #DBDBDB;}
.statistictable td.c{background:#4973A0}
.statistictable td.tit.c{color:#ededed;}
.statistictable td.num{font-size:15px; font-weight:600; color:#3d5773; text-align:center; background:#ccc;}

.hconbox{width:64%; height:330px; float:left; border-bottom:solid 1px #1dcbe3; margin-bottom:77px; position:relative;}
.hcon{margin:0px 0 0 50px;}
.hcontxt{font-size:13px; font-weight:600; color:#0d2b47;}
.hconlist{margin-top:20px;}
.hconlist ul{margin: 0px;}
.hconlist ul li{float:left; margin-right:35px; width:205px;white-space:nowrap; text-overflow:ellipsis; -o-text-overflow:ellipsis; overflow:hidden; -moz-binding: url('ellipsis.xml#ellipsis');}
.hconlist ul li.last{float:left; width:205px;}
</style>

<div class="srstitwrap">
	<div class="srstit">
		<img width="743" height="77" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainContent/maintitle02.gif">
	</div>
		
	<div class="srsbox">
		<div class="srs">
			<div class="statistictable">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="87" style="border-right-color: currentColor; border-right-width: medium; border-right-style: none;" colspan="4">
							<img width="293" height="47" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainContent/maintitle02-1.gif">
						</td>
					</tr>
					<tr>
						<th>Cluster</th>
						<td width="24%" class="tit">Total</td>
						<td width="24%" class="tit">Used</td>
						<td width="24%" class="tit">Avail</td>
					</tr>
					<c:choose>
						<c:when test="${!empty clusterList}">
							<c:forEach items="${clusterList}" var="model">
								<tr>
									<td class="tit">${model.clusterName}</td>
									<td class="num">${model.total}</td>
									<td class="num">${model.used}</td>
									<td class="num">${model.avail}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4" class="tc">
									<liferay-ui:message key='edison-there-are-no-data'/>
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
		
		<div class="hconbox">
			<div class="hcon">
				<div style="margin-top: 21px;">
					<img height="47" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainContent/maintitle02-2.gif">
				</div>
				
				<div class="hconlist">
					<ul>
						<c:choose>
							<c:when test="${!empty advancedList}">
								<c:forEach items="${advancedList}" var="model" end="2" varStatus="status">
									<li <c:if test="${status.last }">class="last"</c:if>>
										<img src="<%=themeDisplay.getPortalURL()%>${model.fileUrl}" width="205" height="174" style="cursor: pointer;" onclick="<portlet:namespace/>advancedContentView('${model.contentFilePath}/${model.contentFileNm}','${model.title}');"/><br/><br/>
										<span class="hcontxt">
											<img width="5" height="5" src="${contextPath}/images/siteMainContent/bl.gif"/>
											${model.title}
										</span>
										
									</li>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<liferay-ui:message key='edison-there-are-no-data'/>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				
			</div>
		</div>
		
	</div>
</div>
<script type="text/javascript">

//고급 콘텐츠 상세보기
function <portlet:namespace/>advancedContentView(fileFullPath,title){
	var last = fileFullPath.lastIndexOf("."); //확장자 추출
	var ext = fileFullPath.substring(last+1);  //확장자 추출
	ext = ext.toLowerCase(); //소문자로
	
	var objFlash = "";
	var contentWidth = window.innerWidth;
	var contentHeight = window.innerHeight;
	
	var objectWidth = window.innerWidth - 50;
	var objectHeight = window.innerHeight - 10;
	if(ext == "swf"){
		objFlash += "	<object type='application/x-shockwave-flash' "; 
		objFlash += "			data='/content"+fileFullPath+"'"; 
		objFlash += "			width='"+objectWidth+"px'  ";
		objFlash += "			height='"+objectHeight+"px'> ";
		objFlash += "	 	<param name='movie' value='${contextPath}/content"+fileFullPath+"' /> ";
		objFlash += "	 	<param name='wmode' value='transparent' /> ";
		objFlash += "	 	<param name='allowScriptAccess' value='always' /> ";
		objFlash += "	</object>	 ";
		
		$("<div/>").html(objFlash)
		.dialog({
			modal: true,
			autoOpen:true,
			resizable: false,
			width:contentWidth,
			height:contentHeight,
			draggable: true,
			title: title,
			open: function(event, ui){
				document.documentElement.style.overflow = 'hidden';  // firefox, chrome
				document.body.scroll = "no"; // ie only
			}, 
			close: function() {
				document.documentElement.style.overflow = 'auto';  // firefox, chrome
				document.body.scroll = "yes"; // ie only
			}
		});
	}else if(ext == "html"){
		objFlash += "	<object type='text/html' "; 
		objFlash += "			data='/content"+fileFullPath+"'"; 
		objFlash += "			width='"+objectWidth+"px'  ";
		objFlash += "			height='"+objectHeight+"px'> ";
		objFlash += "	</object>	 ";
		
		$("<div/>").html(objFlash)
		.dialog({
			modal: true,
			autoOpen:true,
			resizable: false,
			width:contentWidth,
			height:contentHeight,
			draggable: true,
			title: title,
			open: function(event, ui){
				document.documentElement.style.overflow = 'hidden';  // firefox, chrome
				document.body.scroll = "no"; // ie only
			}, 
			close: function() {
				document.documentElement.style.overflow = 'auto';  // firefox, chrome
				document.body.scroll = "yes"; // ie only
			}
		});
	}
}
</script>
