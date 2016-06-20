<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="javax.portlet.PortletURL" %>

<style type="text/css">
.usedtitle{font-size:16px; font-weight:600;}
.usedbox1{border:solid 1px #ddd; border-radius:3px 3px 3px 3px; -webkit-border-radius:3px 3px 3px 3px; padding:7px; margin:5px;}
.usedbox2{border-radius:7px 7px 7px 7px; -webkit-border-radius:7px 7px 7px 7px; height:15px; background-color:#46aaec;}
.usedbox3{border-radius:7px 7px 7px 7px; -webkit-border-radius:7px 7px 7px 7px; height:15px; background-color:#f26201;}
</style>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-simulation-myrepository-title' />
	</div>
</div>

<div class="h10"></div>

<table width="100%">
  <tr style="height:60px;">
    <td width="10%" class="usedtitle"><img src="${contextPath}/images/myrepository/arrowright01.png" width="5" height="10" /> <liferay-ui:message key='edison-simulation-myrepository-disk-usage' /> </td>
    <td width="78%">
    <div class="usedbox1">
    <div id="<portlet:namespace/>storageProgressbar"></div>
    </div>
    </td>
    <td width="12%" style="text-align: center;"><span id="<portlet:namespace/>storageUserRepository"></span><br>(<liferay-ui:message key='edison-simulation-myrepository-use' />/<liferay-ui:message key='edison-simulation-myrepository-usage' />)</td>
  </tr>
  <tr style="height:60px;">
    <td width="10%" class="usedtitle"><img src="${contextPath}/images/myrepository/arrowright01.png" width="5" height="10" /> <liferay-ui:message key='edison-simulation-myrepository-cpu-usage' /> </td>
    <td width="78%">
    <div class="usedbox1">
    <div id="<portlet:namespace/>cpuProgressbar"></div>
    </div>
    </td>
    <td width="12%" style="text-align: center;"><span id="<portlet:namespace/>cpuUserRepository"></span><br>(<liferay-ui:message key='edison-simulation-myrepository-use' />/<liferay-ui:message key='edison-simulation-myrepository-usage' />)</td>
  </tr>
</table>
<script type="text/javascript">
AUI().ready(function() {
	$("#<portlet:namespace/>storageUserRepository").text("${userRepository}" + " / " + "${repository}");
	var progressPercentage = "${repositoryPercent}";
	if(progressPercentage > 70) {
		$("#<portlet:namespace/>storageProgressbar").addClass("usedbox3");
	} else {
		$("#<portlet:namespace/>storageProgressbar").addClass("usedbox2");
	}
	$("#<portlet:namespace/>storageProgressbar").css("width", progressPercentage+"%");
	$("#<portlet:namespace/>userRepository").text("${userRepository}" + " / " + "${repository}");
	
	var cpuProgressPercentage = "${cpuRepositoryPercent}";
	if(cpuProgressPercentage > 70) {
		$("#<portlet:namespace/>cpuProgressbar").addClass("usedbox3");
	} else {
		$("#<portlet:namespace/>cpuProgressbar").addClass("usedbox2");
	}
	$("#<portlet:namespace/>cpuProgressbar").css("width", cpuProgressPercentage + "%");
	$("#<portlet:namespace/>cpuUserRepository").text("${userCpuRepository}" + " / " + "${cpuRepository}");
});
</script>
