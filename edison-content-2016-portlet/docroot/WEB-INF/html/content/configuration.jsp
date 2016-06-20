<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<%
	Map prefsMap = portletPreferences.getMap();

	Set es = prefsMap.entrySet();
	Iterator entries = null;
	if(es != null){
		entries = es.iterator();
	}
	
	int j=1;
%>
<aui:form action="<%= configurationURL %>" method="post" name="configForm">
	<input name="<portlet:namespace/>tabUseValue" id="<portlet:namespace/>tabUseValue"  type="hidden" />
	
	<div class="table1_list borderno">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list" >
		<colgroup>
			<col width="25%" />
			<col width="25%" />
			<col width="25%" />
			<col width="25%" />
		</colgroup>
       	<thead>
			<tr>
				<th>Number</th>
				<th>Key</th>
				<th>Value</th>
			</tr>       	
	    </thead>
		<tbody id="keySetBody">
		<%
			String key = "";
			String value = "";
			int tabViewCount = 0;
		 	while (entries.hasNext()) {

				Map.Entry<String, String[]> thisEntry = (Map.Entry) entries.next();
				key = CustomUtil.strNull(thisEntry.getKey());
				value = CustomUtil.strNull(thisEntry.getValue()[0]);
				
				if(key.equals("tabViewYn")){
					tabViewCount++;
					String selectedY = value.equals("Y") ? "selected" : "";
					String selectedN = value.equals("N") ? "selected" : "";
					out.print("<tr id=\"_"+PortalUtil.getPortletId(request)+"_tr_"+j+"\">\n");
					out.print("	<td>"+j+"</td>\n");
					out.print("	<td>tabViewYn<input type=\"hidden\" id=\"_"+PortalUtil.getPortletId(request)+"_keyTextBox\" name=\"_"+PortalUtil.getPortletId(request)+"_keyTextBox\" value=\"tabViewYn\" size=\"20\"></td>\n");
					out.print("	<td><select id=\"_"+PortalUtil.getPortletId(request)+"_valueTextBox\" name=\"_"+PortalUtil.getPortletId(request)+"_valueTextBox\" onchange=\"changeTabViewYn(this,'"+value+"');\"><option value=\"Y\" "+selectedY+" >Y</option><option value=\"N\" "+selectedN+" >N</option></select>\n");
					out.print("</tr>\n");
				}
				j=j+1;
			}
		 	if(tabViewCount == 0){
		 		out.print("<tr id=\"_"+PortalUtil.getPortletId(request)+"_tr_1\">\n");
				out.print("	<td>1</td>\n");
				out.print("	<td>tabViewYn<input type=\"hidden\" id=\"_"+PortalUtil.getPortletId(request)+"_keyTextBox\" name=\"_"+PortalUtil.getPortletId(request)+"_keyTextBox\" value=\"tabViewYn\" size=\"20\"></td>\n");
				out.print("	<td><select id=\"_"+PortalUtil.getPortletId(request)+"_valueTextBox\" name=\"_"+PortalUtil.getPortletId(request)+"_valueTextBox\" onchange=\"changeTabViewYn(this,'');\"><option value=\"Y\">Y</option><option value=\"N\" selected=\"selected\" >N</option></select>\n");
				out.print("</tr>\n");
		 	}
		%>
		</tbody>
		</table>
	</div>
<h1 class="h40"></h1>
<div class="sideBySide">
	<div class="dialogSelectGroupLeft">
		<h4><liferay-ui:message key='edison-content-config-select-group'/></h4>
			<ul class="target connected">
				<c:forEach var="tab" items="${tabGroup }">
					<li value="${tab.groupId }">${tab.name }<a href='#' class='dismiss'>x</a></li>	
				</c:forEach>
			</ul>
	</div>
	<div class="dialogAllgroupRight">
		<h4><liferay-ui:message key='edison-content-config-all-group'/></h4>
		<ul class="source connected">
			<c:forEach var="group" items="${groupList }">
				<li value="${group.groupId }">${group.name }</li>	
			</c:forEach>
		</ul>
	</div>
	<div style="clear:both"></div>
	<h1 class="h40"></h1>
</div>
<div>
	<input type="button" value="<liferay-ui:message key='edison-button-save'/>"  onclick="<portlet:namespace/>doSubmit()"/>
</div>
</aui:form>
<script type="text/javascript">
var items = [];
$(function () {
	/* $(".source, .target").sortable({
	connectWith: ".connected"
	}); */
	
	$("ul.target").children().each(function() {
		items.push($(this).prop("value"));
	});
	
	
	var initTabViewYn = $("select[name*=valueTextBox]").val();
	if(initTabViewYn == "Y"){
		$(".sideBySide").show();
	}else{
		$(".sideBySide").hide();
		
	}
	
	
	$(".source li").draggable({
		addClasses: false,
		appendTo: "body",
		helper: "clone"
	});
	
	$(".target").droppable({
		addClasses: false,
		activeClass: "listActive",
		accept: ":not(.ui-sortable-helper)",
		drop: function(event, ui) {
			check = updateValues("add", ui.draggable.val());
			if(check){
				$(this).find(".placeholder").remove();
				var link = $("<a href='#' class='dismiss'>x</a>");
				var list = $("<li></li>").attr("value",ui.draggable.val()).text(ui.draggable.text());
				$(list).append(link);
				$(list).appendTo(this);
			}
		}
	}).on("click", ".dismiss", function(event) {
		check = updateValues("delete", $(this).parent().prop("value"));
		if(check){
			event.preventDefault();
			$(this).parent().remove();
		}
	}).sortable({
		items: "li:not(.placeholder)",
		sort: function() {
			$(this).removeClass("listActive");
		},
		update: function() {
			updateValues("sort");
		}
	});

	
	
});


function updateValues(mode, targetValue) {
	var index = items.indexOf(targetValue);
	var checkExist = true;
	if(mode == "add"){
		if(index == -1){
			items.push(targetValue);
		}else{
			alert(Liferay.Language.get('edison-content-config-register-groupid-alret'));
			checkExist = false;
		}
	}else if(mode == "delete"){
		if(index != -1){
			items.splice(index, 1);
		}
	}else if(mode == "sort"){
		items = [];
		
		$("ul.target").children().each(function() {
			items.push($(this).prop("value"));
		});
	}

	return checkExist;
};

function <portlet:namespace/>doSubmit(){
	if(items != null && items.length > 0){
		$("#<portlet:namespace/>tabUseValue").val(items);
	}
	
	var initTabViewYn = $("select[name*=valueTextBox]").val();
	
	if(initTabViewYn == "Y"){
		if(items.length == 0){
			alert(Liferay.Language.get('edison-content-config-no-register-groupid-alret'));
			return false;
		}
	}
	
	$("form[name=<portlet:namespace/>configForm]").submit();
	
}
function changeTabViewYn(obj, value){
	tabViewYn = $(obj).val();
	
	if(tabViewYn == "Y"){
		$(".sideBySide").show();
	}else if(tabViewYn  == "N"){
		$(".sideBySide").hide();
	}
}

</script>