<%@page import="science.platform.service.constants.SciencePlatformAction"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.kisti.science.platform.app.model.ScienceApp"%>
<%@ include file="/html/common/init.jsp" %>

<portlet:actionURL name="createNewScienceApp" var="createNewScienceAppURL">
</portlet:actionURL>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="method" value="<%=SciencePlatformAction.CHECK_DUPLICATION_SCIENCEAPP %>"></portlet:param>
</portlet:resourceURL>

<portlet:actionURL var="editGeneralInfoURL"  name="proceedToEditGeneralInfo" >
</portlet:actionURL>

<portlet:renderURL var="editGeneralInfoRenderURL" >
	<portlet:param name="mvcPath" value="/html/scienceapp/manager/edit_general_info.jsp" />
</portlet:renderURL>


<aui:form action="<%=createNewScienceAppURL%>" name="fm" method="post">
	
	<aui:panel collapsible="true" id="primary"  label="enter-unique-scienceapp-name-and-version">
		<aui:fieldset>
			<aui:input  type="text" label="scienceapp-name" name="appName"  id="appName" >
				<aui:validator name="required"></aui:validator>
			</aui:input>
			<aui:input type="text" label="scienceapp-version" name="appVersion" id="appVersion" >
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:fieldset>
		<aui:button-row>
			<input type="button"  value='<liferay-ui:message key="scienceapp-check-uniqueness" />' id="<portlet:namespace/>checkUniqueness" />
			<input type="button"  value='<liferay-ui:message key="cancel" />'  id="<portlet:namespace/>cancel" />
		</aui:button-row>
	</aui:panel>
</aui:form>

<aui:script>
	var A = AUI();
	
	A.use('aui-base','aui-io-request','liferay-util-window','liferay-portlet-url',function(A) {
		A.one('#<portlet:namespace/>checkUniqueness').on('click',function(){
			var appName = A.one("#<portlet:namespace/>appName").attr("value");
			var appVersion = A.one("#<portlet:namespace/>appVersion").attr("value");
			//alert(appName+":"+appVersion);
			
			A.io.request(
				'<%=resourceURL.toString()%>',
				{
					method:'post',
					dataType: 'json',
					data:{
						<portlet:namespace/>appName:appName,
						<portlet:namespace/>appVersion:appVersion
					},
					on:{
						success: function(){
							var data = this.get("responseData");
							if( data.isDuplicated == false){
							 	Liferay.Util.getOpener().<portlet:namespace/>closeEditPopup( 
							 			data.app, 
							 			'<portlet:namespace/>scienceAppEditPopup',
							 			null);
							}
							else{
								alert("App Name and Version combination is duplicated. Please enter other name or version");
							}
						}
					}
				}
			);
		});
		
		A.one('#<portlet:namespace/>cancel').on('click',function(){
			Liferay.Util.getOpener().<portlet:namespace/>closeScienceAppUniquenessDialog( null, '<portlet:namespace/>scienceAppEditPopup', null );
		});
	});
	
</aui:script>
