<%@page import="freemarker.template.Configuration"%>
<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@page import="com.kisti.science.platform.app.model.ScienceApp"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="science.platform.service.constants.SciencePlatformConstants"%>
<%@page import="com.kisti.science.platform.app.service.constants.ScienceAppConstants"%>
<%@page import="com.kisti.science.platform.app.service.ScienceAppLocalServiceUtil"%>
<%@page import="science.platform.service.constants.SciencePlatformAction"%>
<%@page import="com.liferay.portal.service.persistence.PortletUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.events.Action"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="science.platform.model.SpUser"%>
<%@page import="science.platform.service.SpUserLocalServiceUtil"%>

<%@ include file="/html/common/init.jsp" %>

<portlet:renderURL var="createNewScienceAppURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcPath" value="/html/scienceapp/manager/create_scienceapp.jsp"></portlet:param>
	<portlet:param name="redirect" value="<%=currentURL%>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="editGeneralInfoURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/scienceapp/manager/edit_general_info.jsp"></portlet:param>
	<portlet:param name="redirect" value="<%=currentURL%>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="editExecutionInfoURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/scienceapp/manager/edit_execution_info.jsp"></portlet:param>
	<portlet:param name="redirect" value="<%=currentURL%>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="editPortInfoURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/scienceapp/manager/edit_ports_info.jsp"></portlet:param>
	<portlet:param name="redirect" value="<%=currentURL%>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="editPortTypeURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/scienceapp/manager/edit_porttype.jsp"></portlet:param>
	<portlet:param name="redirect" value="<%=currentURL%>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="testURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/scienceapp/manager/test.jsp"></portlet:param>
	<portlet:param name="redirect" value="<%=currentURL%>"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="saveSampleScienceApp" var="saveSampleScienceAppURL">
	<portlet:param name="redirect" value="<%=currentURL%>"></portlet:param>
</portlet:actionURL>
<portlet:actionURL name="deleteAllSampleScienceApp" var="deleteAllSampleScienceAppURL">
	<portlet:param name="redirect" value="<%=currentURL%>"></portlet:param>
</portlet:actionURL>
<portlet:actionURL name="checkScienceAppFinder" var="checkScienceAppFinderURL">
	<portlet:param name="redirect" value="<%=currentURL%>"></portlet:param>
</portlet:actionURL>

<portlet:resourceURL var="deleteScienceAppURL" >
</portlet:resourceURL>

<%
	boolean hasPermission = permissionChecker.hasPermission(scopeGroupId, "com.kisti.science.platform.app.model", scopeGroupId, "ADD_SCIENCEAPP");
	Configuration cfg = new Configuration();
%>

<c:if test='<%=hasPermission%>' >
	<!-- input type="button"  value="<liferay-ui:message key='create-new-scienceapp'/>" id="<portlet:namespace/>createScienceApp" /-->
	<button id="<portlet:namespace/>createScienceApp" >
		<liferay-ui:icon image="add_instance" ></liferay-ui:icon>
		<liferay-ui:message key='create-new-scienceapp' />
	</button>
	<br/>
	<button id="<portlet:namespace/>saveSampleScienceApp" >
		<liferay-ui:icon image="add_instance" ></liferay-ui:icon>
		<liferay-ui:message key='Save Sample ScinecApps' />
	</button>
	<button id="<portlet:namespace/>deleteAllSampleScienceApp" >
		<liferay-ui:icon image="add_instance" ></liferay-ui:icon>
		<liferay-ui:message key='DeleteAll Sample ScinecApps' />
	</button>
	<button id="<portlet:namespace/>checkScienceAppFinder" >
		<liferay-ui:icon image="add_instance" ></liferay-ui:icon>
		<liferay-ui:message key='Check ScienceAppFinder' />
	</button>

	<h3>My ScienceApps</h3>
	<h4>Search Result Count : <%= ScienceAppLocalServiceUtil.countScienceAppsOnNameTitleScreenNameAffiliationName("%cou%") %></h4>
	<liferay-ui:search-container emptyResultsMessage="you-have-not-registered-any-scienceapp-yet"> 
		<liferay-ui:search-container-results
			retulr = '';
			total='<%= ScienceAppLocalServiceUtil.countScienceAppsByAuthorId(themeDisplay.getUserId()) %>'
		/>
	
		<liferay-ui:search-container-row
			className='com.kisti.science.platform.app.model.ScienceApp'
			modelVar='aScienceApp'
		>
			<liferay-ui:search-container-column-text property="name"  align="center"/>
			<liferay-ui:search-container-column-text property="version" align="center" />
			<liferay-ui:search-container-column-text property="scienceAppId" align="center" />
	
			<liferay-ui:search-container-column-text name="Stage"  align="center">
				<c:choose>
					<c:when test="<%= aScienceApp.getStage().equalsIgnoreCase(ScienceAppConstants.EMPTY) %>">
						<img src="<%=request.getContextPath() %>/images/icons/dot_red_anim.gif"></img>
					</c:when>
					<c:when test="<%=aScienceApp.getStage().equalsIgnoreCase(ScienceAppConstants.EXECUTION_INFO_READY) %>">
						<img src="<%=request.getContextPath() %>/images/icons/dot_purple_anim.gif"></img>
					</c:when>
					<c:when test="<%=aScienceApp.getStage().equalsIgnoreCase(ScienceAppConstants.TEST_OK) %>">
						<img src="<%=request.getContextPath() %>/images/icons/dot_blue_anim.gif"></img>
					</c:when>
					<c:when test="<%=aScienceApp.getStage().equalsIgnoreCase(ScienceAppConstants.IN_SERVICE) %>">
						<img src="<%=request.getContextPath() %>/images/icons/crown_blue_anim.gif"></img>
					</c:when>
				</c:choose>
			</liferay-ui:search-container-column-text>
	
			<liferay-ui:search-container-column-text name="title" value="<%= aScienceApp.getTitle(locale) %>"/>
			<liferay-ui:search-container-column-text property="createDate"  align="center"/>
	
			<%
				SpUser spUser = SpUserLocalServiceUtil.getSpUser(aScienceApp.getUserId());
			%>
			<liferay-ui:search-container-column-text name="User" value="<%= spUser.getSpUserFullName(locale) %>"  align="center"/>
	
			<liferay-ui:search-container-column-text property="iconId" />
			<liferay-ui:search-container-column-text property="appType"  align="center"/>
			<liferay-ui:search-container-column-text property="runType"  align="center"/>
			<liferay-ui:search-container-column-text name="Action" align="center">
				<liferay-ui:icon-menu>
					<%
						//String editEventURL = this.getJavascriptPopupURL(editGeneralInfoURL.toString(), aScienceApp, portletDisplay.getNamespace(), "Edit General Info", "800", "700");
						String editEventURL = addPrimaryScienceAppAttributes(editGeneralInfoURL.toString(), aScienceApp);
					%>
					 <liferay-ui:icon message="scienceapp-edit-general-info" url="<%= editEventURL %>" />
					
					<%
						editEventURL = addPrimaryScienceAppAttributes(editExecutionInfoURL.toString(), aScienceApp);
					%>
					  <liferay-ui:icon message="scienceapp-edit-execution-info" url="<%= editEventURL %>" />
					
					<%
						editEventURL = addPrimaryScienceAppAttributes(editPortInfoURL.toString(), aScienceApp);
					%>
					  <liferay-ui:icon message="scienceapp-edit-in-out-port" url="<%= editEventURL %>" />
					  
					<%
						editEventURL = addPrimaryScienceAppAttributes(testURL.toString(), aScienceApp);
					%>
					  <liferay-ui:icon message="scienceapp-test" url="<%= editEventURL %>" />
					  
					  <liferay-ui:icon message="scienceapp-request-service" url="#" />
					  <liferay-ui:icon message="scienceapp-execute" url="#" />
					  <liferay-ui:icon message="scienceapp-activate-deactivate" url="#" />
					  <liferay-ui:icon message="scienceapp-copy" url="#" />
					  <%
					  		String deleteURL = "javascript:window."+ portletDisplay.getNamespace()+"deleteScienceApp("+ aScienceApp.getScienceAppId()+");";					  
					  	%>
					  <liferay-ui:icon message="scienceapp-delete" id="deleteScienceApp" url="<%=deleteURL %>"/>
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
	<%!
	private final String getJavascriptPopupURL(String renderURL, ScienceApp scienceApp, String namespace, String title, String width, String height){
		renderURL = addPrimaryScienceAppAttributes(renderURL, scienceApp);
		
		String url = "javascript:window."+ 
							namespace+
							"openEditPopup(\'"+ 
							renderURL+
							"\',\'"+
							title+
							"\',\'"+
							width+
							"\',\'"+
							height+
							"\');";	
		
		return url;
	};
	
	private final String addPrimaryScienceAppAttributes(String renderURL, ScienceApp scienceApp){
		renderURL = HttpUtil.addParameter(renderURL, "scienceAppId", scienceApp.getScienceAppId());
		renderURL = HttpUtil.addParameter(renderURL, "scienceAppName", scienceApp.getName());
		renderURL = HttpUtil.addParameter(renderURL, "scienceAppVersion", scienceApp.getVersion());

		return renderURL;
	}
	%>
	
	<script type="text/javascript">
		var A = AUI();
		A.use('aui-base','aui-io-request','liferay-util-window','liferay-portlet-url',function(A) {
		
			var createScienceAppButton = A.one('#<portlet:namespace/>createScienceApp');
			if( createScienceAppButton != null && createScienceAppButton != "undefined"){
				createScienceAppButton.on('click',function(event){
					window.<portlet:namespace/>openEditPopup('<%=createNewScienceAppURL%>', 'Create New ScienceApp', 350, 380);
				});
			}
			
			var saveSampleScienceAppButton = A.one('#<portlet:namespace/>saveSampleScienceApp');
			if( saveSampleScienceAppButton != null && saveSampleScienceAppButton != "undefined"){
				saveSampleScienceAppButton.on('click',function(event){
					window.<portlet:namespace/>saveSampleScienceApp();
				});
			}
			
			var deleteAllSampleScienceAppButton = A.one('#<portlet:namespace/>deleteAllSampleScienceApp');
			if( deleteAllSampleScienceAppButton != null && deleteAllSampleScienceAppButton != "undefined"){
				deleteAllSampleScienceAppButton.on('click',function(event){
					window.<portlet:namespace/>deleteAllSampleScienceApp();
				});
			}
			
			var checkScienceAppFinderButton = A.one('#<portlet:namespace/>checkScienceAppFinder');
			if( checkScienceAppFinderButton != null && checkScienceAppFinderButton != "undefined"){
				checkScienceAppFinderButton.on('click',function(event){
					window.<portlet:namespace/>checkScienceAppFinder();
				});
			}
		});
		
	
	</script>
	
	<aui:script>
		Liferay.provide(
				window,
				"<portlet:namespace/>openEditPopup",
				function(redirectURL, title, width, height){
					//console.log("Redirect URL: "+redirectURL);
					Liferay.Util.openWindow({
						dialog: {
							constrain2view: true,
							centered: true,
							modal: true,
							resizable: true,
							width:width,
							height:height
						},
						id:'<portlet:namespace/>scienceAppEditPopup',
						title:title,
						uri:redirectURL
					});
				},
		        ['aui-base','aui-io-request-deprecated','liferay-util-window']
		);

		Liferay.provide(
			window,
			"<portlet:namespace/>closeEditPopup",
			function(data, dialogId, redirect){
				Liferay.Util.Window.getById(dialogId).destroy();
				
				//location.href = redirect;
				var portletId = '#p_p_id<portlet:namespace/>';
				console.log(portletId);
									
				Liferay.Portlet.refresh(portletId);
				
				Liferay.fire(
					'<%= SciencePlatformConstants.SCIENCEPLATFORM_IPC_EVENT_SCIENCEAPP_ADDED %>', {
			            scienceAppId: '1234',
			            scienceAppName : 'mumbai'
			        }
			    );
			},
	        ['liferay-util-window', 'aui-io-request-deprecated']
		);
		
		Liferay.provide(
				window,
				"<portlet:namespace/>deleteScienceApp",
				function(scienceAppId){
					console.log("To delete: "+scienceAppId);
					alert("To delete: "+scienceAppId);
					
					A.io.request(
						'<%=deleteScienceAppURL.toString()%>',
						{
							method:'post',
							dataType: 'json',
							data:{
								<portlet:namespace/>method:"<%= SciencePlatformAction.DELETE_SCIENCEAPP %>",
								<portlet:namespace/>scienceAppId:scienceAppId
							},
							on:{
								success: function(){
									var regionStrList = this.get("responseData");
									var portletId = '#p_p_id<portlet:namespace/>';
									console.log(portletId);
														
									Liferay.Portlet.refresh(portletId);
									
									Liferay.fire(
										'<%= SciencePlatformConstants.SCIENCEPLATFORM_IPC_EVENT_SCIENCEAPP_ADDED %>', {
								            scienceAppId: '1234',
								            scienceAppName : 'mumbai'
								        }
								    );
								}
							}
						}
					);
				},
		        ['liferay-util-window', 'aui-io-request-deprecated']
			);
		
		Liferay.provide(
				window,
				"<portlet:namespace/>saveSampleScienceApp",
				function(scienceAppId){
					A.io.request(
						'<%=saveSampleScienceAppURL.toString()%>',
						{
							method:'post',
							dataType: 'json',
							on:{
								success: function(){
								}
							}
						}
					);
				},
		        ['aui-base', 'liferay-util-window', 'aui-io-request-deprecated']
			);
		
		Liferay.provide(
				window,
				"<portlet:namespace/>deleteAllSampleScienceApp",
				function(scienceAppId){
					A.io.request(
						'<%=deleteAllSampleScienceAppURL.toString()%>',
						{
							method:'post',
							dataType: 'json',
							on:{
								success: function(){
								}
							}
						}
					);
				},
		        ['aui-base', 'liferay-util-window', 'aui-io-request-deprecated']
			);
		
		Liferay.provide(
				window,
				"<portlet:namespace/>checkScienceAppFinder",
				function(scienceAppId){
					A.io.request(
						'<%=checkScienceAppFinderURL.toString()%>',
						{
							method:'post',
							dataType: 'json',
							on:{
								success: function(){
								}
							}
						}
					);
				},
		        ['aui-base', 'liferay-util-window', 'aui-io-request-deprecated']
			);
	</aui:script>
</c:if>
