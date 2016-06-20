<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<style>
body > li {
  width: 177px;
  margin: 5px;
  padding: 5px;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
  text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
  list-style-type: none;
  list-style-position: inside;
  border-width: 1px;
  border-style: solid;
  border-color: #ccc !important;
  background-color: #fafafa !important;
  color: #bbb !important;
}
.listActive {
  border: 1px solid #ccc;
  background-color: #fcfcfc;
  padding: 0.5em 0 3em 0 !important;
}
.placeholder {
  list-style-type: none;
  text-align: center;
  font-style: italic;
  border: 1px dashed #ddd !important;
  background-color: #fff !important;
  color: #aaa !important;
}
.dismiss {
  float: right;
  position: relative;
  top: -8px;
  line-height: 20px;
  font-size: 12px;
  font-weight: bold;
  text-decoration: none !important;
  color: #468847;
}
ul.source, ul.target {
  min-height: 50px;
  margin: 0px 25px 10px 0px;
  padding: 2px;
  border-width: 1px;
  border-style: solid;
  -webkit-border-radius: 3px;
  -moz-border-radius: 3px;
  border-radius: 3px;
  list-style-type: none;
  list-style-position: inside;
}
ul.source {
  border-color: #f8e0b1;
}
ul.target {
  border-color: #add38d;
}
.source li, .target li {
  margin: 5px;
  padding: 5px;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
  text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
  cursor: move;
}
.source li {
  background-color: #fcf8e3;
  border: 1px solid #fbeed5;
  color: #c09853;
}
.target li {
  background-color: #ebf5e6;
  border: 1px solid #d6e9c6;
  color: #468847;
}
.sortable-dragging {
  border-color: #ccc !important;
  background-color: #fafafa !important;
  color: #bbb !important;
}
.sortable-placeholder {
  height: 40px;
}
.source .sortable-placeholder {
  border: 2px dashed #f8e0b1 !important;
  background-color: #fefcf5 !important;
}
.target .sortable-placeholder {
  border: 2px dashed #add38d !important;
  background-color: #f6fbf4 !important;
}
.sideBySide{
	width:35%;
	margin:auto;
}
.left, .right{
	width:50%;
	float:left;
}

.left h4, .right h4{
	text-align: center;
}

.aui input[type="text"]{
	width: 50%;
}
</style>

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
<aui:form action="<%= configurationURL %>" method="post" name="tabSetting">
	<input name="<portlet:namespace/>myaction" type="hidden" value="tab"/>
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
	<div class="left">
		<h4><liferay-ui:message key='edison-content-config-select-group'/></h4>
			<ul class="target connected">
				<c:forEach var="tab" items="${tabGroup }">
					<li value="${tab.groupId }">${tab.name }<a href='#' class='dismiss'>x</a></li>	
				</c:forEach>
			</ul>
	</div>
	<div class="right">
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

<h3>SolverType</h3>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<input name="<portlet:namespace/>myaction" type="hidden" value="category"/>
	
	<div class="table1_list borderno">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list" >
		<colgroup>
			<col width="10%" />
			<col width="10%" />
			<col width="65%" />
		</colgroup>
		<thead>
			<tr>
				<th>ParentCategoryName</th>
				<th>CategoryName</th>
				<th>ImageFileName</th>
			</tr>
	    </thead>
		<tbody id="keySetBody">
			<c:set var="stateIndex" value="${1}"></c:set>
			<c:forEach items="${allSolverTypeList}" var="solverTypeList" varStatus="typeListStatus">
				
				<c:forEach items="${solverTypeList}" var="solverType" varStatus="typeStatus">
					<tr id="<portlet:namespace/>tr_${stateIndex}">
					<c:if test="${typeStatus.index eq 0}">
						<td rowspan="${fn:length(solverTypeList)}">${parentCategoryList[typeListStatus.index].title}</td>
					</c:if>
						<td>
							<input type="hidden" id="<portlet:namespace/>numberArray" name="<portlet:namespace/>numberArray" value="${stateIndex}" />
							<input type="hidden" id="<portlet:namespace/>categoryId_${stateIndex}" name="<portlet:namespace/>categoryId_${stateIndex}" value="${solverType.categoryId}" />
							<input type="hidden" id="<portlet:namespace/>companyId_${stateIndex}" name="<portlet:namespace/>companyId_${stateIndex}" value="${solverType.companyId}" />
							<input type="hidden" id="<portlet:namespace/>userId_${stateIndex}" name="<portlet:namespace/>userId_${stateIndex}" value="${solverType.userId}" />
							<input type="hidden" id="<portlet:namespace/>userName_${stateIndex}" name="<portlet:namespace/>userName_${stateIndex}" value="${solverType.userName}" />
							<input type="hidden" id="<portlet:namespace/>categoryTitle_${stateIndex}" name="<portlet:namespace/>categoryTitle_${stateIndex}" value="${solverType.title}" />
							${solverType.title}
						</td>
						<td>
							<input type="hidden" id="<portlet:namespace/>categoryPropertyId_${stateIndex}" name="<portlet:namespace/>categoryPropertyId_${stateIndex}" value="${solverType.image.categoryPropertyId}" />
							<input type="text" id="<portlet:namespace/>categoryImage_${stateIndex}" name="<portlet:namespace/>categoryImage_${stateIndex}" value="${solverType.image.value}" />
						</td>
					</tr>
					<c:set var="stateIndex" value="${stateIndex + 1}"></c:set>
				</c:forEach>
				
			</c:forEach>
		</tbody>
	</table>
	</div>
<div>
	<input type="submit" value="SAVE" style="float: right;" />
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
			alert("<liferay-ui:message key='edison-content-config-register-groupid-alret'/>");
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
			alert("<liferay-ui:message key='edison-content-config-no-register-groupid-alret'/>");
			return false;
		}
	}
	
	$("form[name=<portlet:namespace/>tabSetting]").submit();
	
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

