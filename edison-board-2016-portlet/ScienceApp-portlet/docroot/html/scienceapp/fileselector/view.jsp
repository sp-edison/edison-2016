<%@ include file="/html/common/init.jsp" %>
<%@ include file="/html/common/science_platform_events.jspf" %>
<aui:form>
	<aui:input name="fileSelector" id="fileSelector" label="Select File" value=""></aui:input>
</aui:form>

<aui:script>
var A = AUI();

A.use('aui-base','aui-io-request','liferay-util-window','liferay-portlet-url',function(A) {
	Liferay.on(SciencePlatformEvents.IPC_EVENT_REQUEST_CONTENT, function(event){
		var receivedPayload = event.payload;
		
		var content = {
			fileSelector: A.one('#<portlet:namespace/>fileSelector').val()
		};
		
		var payload = new SciencePlatformEventPayload(
				SciencePlatformEvents.TYPE_TARGET,
				'<portlet:namespace/>', 
				receivedPayload.getEmitter(),
				content);
		
		Liferay.fire(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, {
			payloadName: "stringEditorPort",
			payload:payload
		});
	});
});
</aui:script>