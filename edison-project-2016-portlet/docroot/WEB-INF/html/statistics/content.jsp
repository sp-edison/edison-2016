<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:resourceURL var="getContentDatailURL"		id="getContentDatail"	escapeXml="false" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="excelDownURL"		id="excelDown"	escapeXml="false" copyCurrentRenderParameters="false"/>
<!-- <div class="h40"></div> -->

<h1 class="h1" style="display: inline;">EDISON <liferay-ui:message key="edison-project-statistics-title"/></h1>		
<div class="EDbuttonbox"><input class="addIp button04per" onclick="<portlet:namespace/>excelDown();" value="Excel Download" type="button"> </div>

<liferay-portlet:runtime portletName="edisonmultitab_WAR_edisonboard2016portlet_INSTANCE_multitab" />

<div class="buttonWrapper">
	<div class="tabletopCategoryrightper">
		<select id="<portlet:namespace/>selectProjectCategory" name="<portlet:namespace/>selectProjectCategory" onchange="<portlet:namespace/>dataSearch()" class="selectCategoryView">
			${categorySelectOption}
		</select>
	</div>
</div>		
<div class="table0p_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<colgroup>
			<col width="15%">
			<col width="*">
			<col width="15%">
			<col width="15%">
			<col width="15%">
		</colgroup>
		<thead>
		<tr>
			<th scope="col"><liferay-ui:message key='edison-table-list-header-group'/></th>
			<th scope="col"><liferay-ui:message key='edison-content'/></th>
			<th scope="col"><liferay-ui:message key='edison-create-account-field-title-university'/></th>
			<th scope="col"><liferay-ui:message key='edison-table-list-header-name'/></th>
			<th scope="col" class="last"><liferay-ui:message key='edison-table-list-header-date'/></th>
		</tr>
		</thead>
		<tbody id="<portlet:namespace/>contentDetailBody">
		</tbody>
	</table>
</div>
<script type="text/javascript">
	
$(function(){
	<portlet:namespace/>dataSearch();
});

function <portlet:namespace/>dataSearch(){
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getContentDatailURL%>",
		data : {
			<portlet:namespace/>selectProjectCategory : $("#<portlet:namespace/>selectProjectCategory").val()
		},
		async : false,
		success: function(data) {
			var dataSize = data.dataList.length;
			var dataMap = data.dataList;
			
			$("#<portlet:namespace/>contentDetailBody tr").remove();
			$contentDetailBody = $("#<portlet:namespace/>contentDetailBody");
			var nowCategoryId = 0;
			var rowspanCnt = 0;
			if(dataSize>0){
				for(var i=0 ; i<dataSize; i++ ){
					$tr = $("<tr></tr>").appendTo($contentDetailBody);
					
					//if(i%2 == 1){ $tr.addClass("tablebgtr"); }
					
					var categoryId = dataMap[i].projectCategoryId;
					if(nowCategoryId != categoryId){
						/* $("<td></td>").attr("rowSpan", dataMap[i].categoryCnt).addClass("TC").append(dataMap[i].projectCategoryNm).appendTo($tr);
						nowCategoryId  = categoryId; */
						
						if(rowspanCnt != 0){
							$("#<portlet:namespace/>"+nowCategoryId).attr("rowspan", rowspanCnt);
						}
						
						nowCategoryId  = categoryId;
						$("<td></td>").attr("id","<portlet:namespace/>"+nowCategoryId).addClass("TC").append(Liferay.Language.get(dataMap[i].propertyValue)).appendTo($tr);
						rowspanCnt = 0;
					}
					
					$("<td></td>").append(dataMap[i].title).css("word-break","break-all").appendTo($tr);
					$("<td></td>").addClass("TC").append(dataMap[i].affiliation).appendTo($tr);
					$("<td></td>").addClass("TC").append(dataMap[i].firstName).appendTo($tr);
					$("<td></td>").addClass("TC").append(dataMap[i].insertDate).appendTo($tr);
					
					rowspanCnt++;
				}
				$("#<portlet:namespace/>"+nowCategoryId).attr("rowspan", rowspanCnt);
			}else{
				$tr = $("<tr></tr>").appendTo($contentDetailBody);
				
				var colspan = 5;
				$("<td></td>").addClass("TC")
							  .text(Liferay.Language.get('edison-there-are-no-data'))
							  .attr("colspan",colspan)
							  .appendTo($tr);
			} 
			
		},error:function(msg){
			alert("System Exception dataSearch: " + msg);
		}

	});
}

function <portlet:namespace/>excelDown(){
	var url = "<%=excelDownURL%>"+"&<portlet:namespace/>selectProjectCategory="+$("#<portlet:namespace/>selectProjectCategory").val();
	window.location.href = spaceDelete(url);
}
	
</script>  
  
