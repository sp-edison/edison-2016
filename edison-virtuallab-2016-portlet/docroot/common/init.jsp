<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ taglib uri="http://www.edison.re.kr/tld/edison-ui" prefix="edison-ui" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="org.kisti.edison.model.EdisonMessageConstants" %>
<%@ page import="org.kisti.edison.util.EdisonUserUtil" %>
<%@ page import="org.kisti.edison.util.CustomUtil" %>
<%@ page import="org.kisti.edison.model.EdisonRoleConstants" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="page" />
<%
	boolean isLogin = themeDisplay.isSignedIn();
	
	boolean isAdministrator = false;
	boolean isSiteAdministrator = false;
	boolean isDeveloper = false;
	boolean isTutor = false;
	boolean isStudent = false;
	boolean isDeveloperThan = false;
	boolean isTutorThan = false;
	
	if(isLogin){
		isAdministrator = EdisonUserUtil.isRegularRole(themeDisplay.getUser(), EdisonRoleConstants.ADMINISTRATOR);
		isSiteAdministrator = EdisonUserUtil.isSiteRole(themeDisplay.getUser(), themeDisplay.getScopeGroupId(), EdisonRoleConstants.SITE_ADMINISTRATOR);
		isDeveloper = EdisonUserUtil.isRegularRole(themeDisplay.getUser(),EdisonRoleConstants.DEVELOPER);
		isTutor = EdisonUserUtil.isRegularRole(themeDisplay.getUser(),EdisonRoleConstants.TUTOR);
		isStudent = EdisonUserUtil.isRegularRole(themeDisplay.getUser(),EdisonRoleConstants.STUDENT);
		isDeveloperThan = EdisonUserUtil.isDeveloperThan(themeDisplay.getUser());
		isTutorThan = EdisonUserUtil.isTutorThan(themeDisplay.getUser());
	}
%>


<c:set var="isAdministrator" value="<%=isAdministrator %>" scope="page" />
<c:set var="isSiteAdministrator" value="<%=isSiteAdministrator %>" scope="page" />
<c:set var="isDeveloper" value="<%=isDeveloper %>" scope="page" />
<c:set var="isTutor" value="<%=isTutor %>" scope="page" />
<c:set var="isStudent" value="<%=isStudent %>" scope="page" />
<c:set var="isDeveloperThan" value="<%=isDeveloperThan %>" scope="page" />
<c:set var="isTutorThan" value="<%=isTutorThan %>" scope="page" />

<liferay-ui:success key="<%=EdisonMessageConstants.INSERT_SUCCESS%>" message="edison-data-insert-success"/>
<liferay-ui:success key="<%=EdisonMessageConstants.UPDATE_SUCCESS%>" message="edison-data-update-success"/>
<liferay-ui:success key="<%=EdisonMessageConstants.DELETE_SUCCESS%>" message="edison-data-delete-success"/>

<liferay-ui:error key="<%=EdisonMessageConstants.INSERT_ERROR%>" message="edison-data-insert-error" />
<liferay-ui:error key="<%=EdisonMessageConstants.UPDATE_ERROR%>" message="edison-data-update-error" />
<liferay-ui:error key="<%=EdisonMessageConstants.DELETE_ERROR%>" message="edison-data-delete-error" />
<liferay-ui:error key="<%=EdisonMessageConstants.SEARCH_ERROR%>" message="edison-data-search-error" />
<liferay-ui:error key="<%=EdisonMessageConstants.EVENT_ERROR%>" message="edison-data-event-error" />

