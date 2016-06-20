<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui"  prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects></portlet:defineObjects>
<theme:defineObjects></theme:defineObjects>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<%
	PortletMode portletMode = liferayPortletRequest.getPortletMode();
	WindowState windowState = liferayPortletRequest.getWindowState();
	
	PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
	
	String currentURL = currentURLObj.toString();
	String redirect = ParamUtil.getString(liferayPortletRequest, "redirect");
%>
