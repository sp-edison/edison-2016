<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<script type="text/javascript">
AUI().ready(function() {
	alert("<liferay-ui:message key='edison-simulation-monitoring-bad-request' />");
	window.location.href = "${backURL}";
});
</script>
