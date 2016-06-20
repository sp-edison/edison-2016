<%@ include file="/html/common/init.jsp" %>
<portlet:defineObjects />
<div class="mainContent">
	<div class="listContent">
		<h3>InputDeckForm List</h3>
		<ul id="<portlet:namespace/>inputdeckFormList" >
		</ul>
	</div>
	<div class="viewerContent">
		<h3>InputDeck Viewer</h3>
		<div id="<portlet:namespace/>inputdeckViewer"  class="jsonFormDiv"></div>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/editor/inputdeck/inputdeck_form.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/editor/inputdeck/inputdeck_viewer.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/editor/editor.css" />
<script>
	//inputdeck form 리스트 정보
	var inputdeckFormDataList = <%= request.getAttribute("inputdeckFormDataList")%>;
	var cnt = 1;
	
	for(var i=0; i<inputdeckFormDataList.length; i++)
	{
		$("#<portlet:namespace/>inputdeckFormList").append("<li><input type='radio' name='formRadio' onClick='showPreView(\"<portlet:namespace/>inputdeckViewer\", "+inputdeckFormDataList[i].inputdeckForm+");' />InputDeckForm"+ cnt+"("+inputdeckFormDataList[i].inputdeckFormId+")</li>");
		cnt++;
	}
</script>