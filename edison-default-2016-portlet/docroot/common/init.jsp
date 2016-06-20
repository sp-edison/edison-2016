<%@page import="org.kisti.edison.model.EdisonRoleConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.model.RoleConstants" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.util.PortletKeys"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.WindowState" %>
<%@page import="org.kisti.edison.model.EdisonMessageConstants"%>
<%@page import="org.kisti.edison.util.EdisonUserUtil"%>


<%@ page import="org.kisti.edison.util.CustomUtil" %>
<%@ page import="org.kisti.edison.exception.EdisonException" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	boolean isLogin = themeDisplay.isSignedIn();
	
	boolean isAdministrator = false;
	boolean isSiteAdministrator = false;
	boolean isSiteAdministratorThan = false;
	
	if(isLogin){
		isAdministrator = EdisonUserUtil.isRegularRole(themeDisplay.getUser(), EdisonRoleConstants.ADMINISTRATOR);
		isSiteAdministrator = EdisonUserUtil.isSiteRole(themeDisplay.getUser(), themeDisplay.getScopeGroupId(), EdisonRoleConstants.SITE_ADMINISTRATOR);
		isSiteAdministratorThan = EdisonUserUtil.isPowerUserThan(themeDisplay.getUser());
	}
%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="page" />

<c:set var="isAdministrator" value="<%=isAdministrator %>" scope="page" />
<c:set var="isSiteAdministrator" value="<%=isSiteAdministrator %>" scope="page" />
<c:set var="isSiteAdministratorThan" value="<%=isSiteAdministratorThan %>" scope="page" />
