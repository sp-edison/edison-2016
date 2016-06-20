<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<div >
	<liferay-portlet:runtime portletName="edisonmonitoring_WAR_edisonsimulation2016portlet_INSTANCE_classMonitoring" queryString="&jobVirtualLabId=${virtualLabClassInfo.virtualLabId}&jobClassId=${virtualLabClassInfo.classId}&classSearchUser=${userId}"/>
</div>