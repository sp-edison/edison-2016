<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="getScienceAppListURL" id="getScienceAppList" copyCurrentRenderParameters="false" />

<liferay-portlet:resourceURL var="classScienceAppInsertURL" id="classScienceAppInsert" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="classId" value="${classId}" />
</liferay-portlet:resourceURL>

<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList();
	
	$('#scienceAppTable tr').click(function(event) {
		if (event.target.type !== 'checkbox') {
			$(':checkbox', this).trigger('click');
		}
	});
});

function <portlet:namespace/>dataSearchList(reset) {
	if(reset == 0) {
		$("#<portlet:namespace/>searchField").val("");
	}
	var dataForm = {
		"<portlet:namespace/>classId" : "${classId}",
		"<portlet:namespace/>searchField" : $("#<portlet:namespace/>searchField").val()
	};
	jQuery.ajax({
		type: "POST",
		url: "<%=getScienceAppListURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var virtualLabScienceAppList = msg.virtualLabScienceAppList;
			
			var rowResult;
			$("#<portlet:namespace/>scienceAppListBody tr:not(:has(#1))").remove();
			
			if(virtualLabScienceAppList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "4")
							.css("text-align","center")
							.addClass("appadmintxt")
							.css("height", "40px")
							.text("<liferay-ui:message key='edison-there-are-no-data' />")
							.appendTo($rowResult);
				$("#<portlet:namespace/>scienceAppListBody").append($rowResult);
			} else {
				for(var i=0;i<virtualLabScienceAppList.length;i++){
					
					$trNode = $("<tr/>").css("cursor","pointer");
					$checkBox = $("<input>").attr("type","checkbox")
											.attr("name","<portlet:namespace/>scienceAppCheck")
											.attr("value",virtualLabScienceAppList[i].scienceAppId);
					
					if(i%2 == 1){
 						$trNode.addClass("tablebgtr");
 					}
					
					if(virtualLabScienceAppList[i].scienceAppCheck > 0){
						$checkBox.attr("checked", true);
					} else {
						$checkBox.attr("checked", false);
					}
					
					$("<td/>").append($checkBox).appendTo($trNode);
					$("<td/>").css("text-align","left")
								.css("word-wrap","break-word")
								.text(virtualLabScienceAppList[i].scienceAppTitle)
								.appendTo($trNode);
					
					$("<td/>").css("text-align","center")
								.text("Ver "+virtualLabScienceAppList[i].scienceAppVersion)
								.appendTo($trNode);
					
					$("<td/>").css("text-align","center")
								.text(virtualLabScienceAppList[i].userFirstName)
								.appendTo($trNode);
					$("#<portlet:namespace/>scienceAppListBody").append($trNode);
				}
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

function <portlet:namespace/>insertClassScienceApp(){
	var paramData = $("form[name=scienceAppForm]").serialize();
	jQuery.ajax({
		type: "POST",
		url: "<%=classScienceAppInsertURL%>",
		async : false,
		data : paramData,
		success: function(data) {
			if(data=="SUCCESS"){
				alert("<liferay-ui:message key='edison-virtuallab-save-data' />");
			}
			parent.<portlet:namespace/>dataSearchList();
		},
		error:function(e){
			alert("insertClassScienceApp="+e)
		}
	});
}

function <portlet:namespace/>onKeyDown(e){
	if(e.keyCode == 13){
		<portlet:namespace/>dataSearchList();
		return false;
	}
}

</script>
<div class="tabletopbox">
	<form id="searchForm" name="searchForm" method="post" onsubmit="return false;" style="margin:0px;">
		<div class="search">
			<div class="searchbox">
				<input id="<portlet:namespace/>searchField" name="<portlet:namespace/>searchField" type="text" maxlength="15" placeholder="<liferay-ui:message key='edison-virtuallab-app-name' />" onkeypress="<portlet:namespace/>onKeyDown(event);"/>
				<input id="search_button" name="search_button" type="button" class="btnsearch" onClick="<portlet:namespace/>dataSearchList()"/>
			</div>
			<input id="total_search_button" name="total_search_button" type="button" class="button01" value="<liferay-ui:message key='edison-button-all-search' />" onClick="<portlet:namespace/>dataSearchList(0)" />
			<input id="total_search_button" name="total_search_button" type="button" class="button01" style="float:right;" value="<liferay-ui:message key='edison-virtuallab-save' />" onClick="<portlet:namespace/>insertClassScienceApp()" />
		</div>
		
	</form>
</div>
<div class="table0_list borderno">
	<form id="scienceAppForm" name="scienceAppForm" method="post" onsubmit="return false;" style="margin:0px;">
	<table id="scienceAppTable" width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
		<colgroup>
			<col width="5%" />
			<col width="60%" />
			<col width="10%" />
			<col width="25%" />
		</colgroup>
		<thead>
			<tr>
				<th align="center" scope="col"></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-app-name' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-version' /></th>
				<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-developer-name' /></th>
			</tr>
		</thead>
		<tbody id="<portlet:namespace/>scienceAppListBody">
		</tbody>
	</table>
	</form>
</div>
