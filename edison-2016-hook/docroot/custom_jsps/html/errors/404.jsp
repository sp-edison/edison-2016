<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/common/init.jsp" %>
<%@ page isErrorPage="true" %>
<%
String forwardURL = PortalUtil.getHomeURL(request);

String cURL = PortalUtil.getCurrentURL(request);
boolean urlError = false;

int[] urlCheck = PortalUtil.getGroupFriendlyURLIndex(cURL);
if(urlCheck!=null){
	String groupFriendlyURL = cURL.substring(urlCheck[0]);
	String layoutFriendlyURL = cURL.substring(urlCheck[1]);
	
	boolean isGroupURL = PortalUtil.isGroupFriendlyURL(cURL,groupFriendlyURL,layoutFriendlyURL);
	if(isGroupURL){
		
	}else{
		urlError = true;
	}
}else{
	urlError = true;
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
<style type="text/css">
.alert-error {
	background-color: #fee5e2;
	border-color: #fcaca5;
	color: #b50303;
}

.alert{
	padding: 8px 35px 8px 14px;
	margin-bottom: 20px;
	text-shadow: 0 1px 0 rgba(255,255,255,0.5);
	background-color: #fffbdc;
	border: 1px solid #f1d875;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border-radius: 2px;
}

</style>
</head>
<body onload="javascript:window_onload();">
	<div class="alert alert-error">
	<c:choose>
		<c:when test="<%=urlError%>">
			The URL is not correct<br/>
		</c:when>
		<c:otherwise>
			You do not have permission for this URL<br/>
		</c:otherwise>
	</c:choose>
	<label id="timer">5</label>&nbsp;&nbsp;&nbsp;Seconds to go EDISON.
	</div>
</body>
<script type="text/javascript">
var refreshIntervalId;

function window_onload(){
	refreshIntervalId = setInterval('text_replace()',1000);
	setTimeout('go_url()',5000);
}

var time = 5;
function text_replace(){
	time = time-1;
	document.getElementById("timer").innerHTML = time;
	
}

function go_url(){
	clearInterval(refreshIntervalId);
	location.replace('<%=forwardURL%>');
}

</script>
</html>