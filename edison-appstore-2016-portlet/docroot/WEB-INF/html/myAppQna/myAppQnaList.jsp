<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>

<liferay-portlet:resourceURL var="myAppListURL" id="myAppList" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="myAppListQnaURL" id="myAppListQna" copyCurrentRenderParameters="false" />
<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>

<style type="text/css">
.appqnali{
	padding: 0 20px 0 20px;
	background-color: #eeeeee;
	height: 56px;
}
.appqnatitle{
	font-size: 17px;
	display: inline-block;
	width: 75%;
}
.appqnasub{
	display: inline-block;
	text-align:right;
	width: 25%;
}
.appqnasub2{
	display: inline-block;
	width: 13%;
}

</style>

<script type="text/javascript" src="${contextPath}/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
AUI().ready(function() {
	<portlet:namespace/>dataSearchList();
	
	var display = "${display}";
	if(display == "VIEW") {
		$("#<portlet:namespace/>display").css("display", "block");
	} else {
		$(".portlet-borderless-container").css("min-height", "0");
	}
});

/* var oEditors = new Array();
 */
function <portlet:namespace/>dataSearchList() {
	var dataForm = {
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=myAppListURL%>",
		async : false,
		data : dataForm,
		success: function(msg) {
			var myAppList = msg.myAppList;
			var myAppManualList = msg.myAppManualList;
			var rowResult;
			
			$("#<portlet:namespace/>myAppQnaListBody tr:not(:has(#1))").remove();
			
			if(typeof myAppList == "undefined" || myAppList.length == 0) {
				$rowResult = $("<tr/>");
				$("<td/>").attr("colspan", "7")
						  .css("text-align","center")
						  .text("<liferay-ui:message key='edison-there-are-no-data' />")
						  .appendTo($rowResult);
				$("#<portlet:namespace/>myAppQnaListBody").append($rowResult);
			} else {
				for(var i = 0; i < myAppList.length; i++) {
					$rowResult = $("<tr/>").css("border-bottom", "1px solid #e0e0e0").addClass("appItem" + i).attr("id", "appItem" + i);
					$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveToolkit('" + myAppList[i].appManagerPlid + "','" + myAppList[i].scienceAppId + "');")
									  .text(myAppList[i].title)
									  .css("cursor", "pointer")
							 ).appendTo($rowResult)
							  .css("white-space","nowrap")
							  .css("overflow","hidden")
							  .css("text-overflow","ellipsis")
					$("<td/>").text("Ver " + myAppList[i].version)
							  .appendTo($rowResult);
					$("<td/>").text(myAppList[i].affiliation)
							  .appendTo($rowResult);
					$("<td/>").text(myAppList[i].userFirstName)
							  .appendTo($rowResult);
					
					if(myAppList[i].answerCount == 0) {
						$("<td/>").appendTo($rowResult);
						if(myAppList[i].manualId != undefined) {
							$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>fileDownload('" + myAppList[i].manualId + "');")
														   .text("<liferay-ui:message key='edison-table-list-header-manual' />")
														   .css("cursor", "pointer")
									 ).appendTo($rowResult);
						} else {
							$("<td/>").html("<liferay-ui:message key='edison-table-list-header-manual' />").appendTo($rowResult);
						}
						$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveSimulation('" + myAppList[i].myAppScopeGroupId + "','" + myAppList[i].scienceAppId + "');")
													   .text("<liferay-ui:message key='edison-table-list-header-run' />")
													   .css("cursor", "pointer")
								 ).appendTo($rowResult);
					
					} else {
						$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>getQnaList('" + myAppList[i].scienceAppId + "','" + i + "')")
													   .text("<liferay-ui:message key='edison-appstore-myapp-question' />"+"\n(" + myAppList[i].answerCount +")")
													   .css("cursor", "pointer")
								 ).css("word-wrap","break-word").appendTo($rowResult);
						if(myAppList[i].manualId != undefined) {
							$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>fileDownload('" + myAppList[i].manualId + "');")
														   .text("<liferay-ui:message key='edison-table-list-header-manual' />")
														   .css("cursor", "pointer")
									 ).appendTo($rowResult);
						} else {
							$("<td/>").html("<liferay-ui:message key='edison-table-list-header-manual' />").appendTo($rowResult);
						}
						$("<td/>").append($("<a/>").attr("onClick", "event.cancelBubble=true; <portlet:namespace/>moveSimulation('" + myAppList[i].myAppScopeGroupId + "','" + myAppList[i].scienceAppId + "');")
													   .text("<liferay-ui:message key='edison-table-list-header-run' />")
													   .css("cursor", "pointer")
								 ).appendTo($rowResult);
					}
 					$("#<portlet:namespace/>myAppQnaListBody").append($rowResult);
				}
			}
		},error:function(msg,e){ 
			alert(e);
			return false;
		}
	});
}

var fileIndex = 0;
function moreFileTag(boardSeq)
{
	fileIndex++;
	var frmTag = "<div id=\"fileDiv" + boardSeq + fileIndex + "\" class=\"filetag\">";
	frmTag += "<input type=\"file\" name=\"addfile" + boardSeq + "\" style =\"width:500px;border:1px solid #CCCCCC;margin-bottom:2px;\">&nbsp;";
	frmTag += "<input type=\"button\" value=\"delete\" style=\"cursor:pointer;\" class=\"button03\" onClick=\"deleteFileTag(\'fileDiv" + boardSeq + fileIndex + "\', '" + boardSeq +"')\"/>";
	frmTag += "</div>";

	$("#fileTDArea" + boardSeq).append(frmTag);
}

function deleteFileTag(objId, boardSeq){
	$("#"+objId).remove();
	if($(':input[name*=addfile' + boardSeq + ']').length == 0){
		moreFileTag(boardSeq);
	} 
}

function <portlet:namespace/>getQnaList(solverId, itemNo) {
	var trlength = $(".remove" + itemNo).length;
	
	$(".myAppQnaUp").slideUp( "slow", function() {
	});
	
	if(trlength > 0) {
		var status = $(".myAppQna" + itemNo).css("display");
		if(status != "block") {
			$(".myAppQna" + itemNo).slideDown( "slow", function() {
			});
		} else {
			$(".myAppQna" + itemNo).slideUp( "slow", function() {
			});
		}
	}else {
		var trRow = $("#appItem" + itemNo);
		var cls = trRow.attr("class");
		
		var dataForm = {
			"<portlet:namespace/>solverId": solverId
		};
		
		jQuery.ajax({
			type: "POST",
			url: "<%=myAppListQnaURL%>",
			async : false,
			data : dataForm,
			success: function(msg) {
				var myAppQnaList = msg.myAppQnaList;
				
				if(myAppQnaList.length == 0) {
					alert("<liferay-ui:message key='edison-there-are-no-data' />");
				} else {
					for(var i = 0; i < myAppQnaList.length; i++) {
						$rowResult = $("<tr/>").addClass("appadminlist").addClass("remove" + itemNo);
						$("<td/>").css("background", "#fdfdfd")
								  .attr("colspan", "7")
								  .append($("<div/>").addClass("myAppQnaUp").addClass("myAppQna" + itemNo).css("display", "none").css("border-bottom", "1px solid #e0e0e0").append(
										  $("<ul/>").append($("<li/>").append($("</p>").text(myAppQnaList[i].title).addClass("appqnatitle"))
																	  .append($("</p>").text(myAppQnaList[i].writerUserFirstName + " | " + myAppQnaList[i].writerDate).addClass("appqnasub"))
																	  .addClass("appqnali")
																	  .css("line-height", "52px")
																	 )
										  			.append($("<li/>").html(myAppQnaList[i].content).css("background", "#ffffff").css("padding", "20px").css("border-bottom", "1px solid #e0e0e0"))
										  			.append($("<li/>").append($("<a/>").text("<liferay-ui:message key='edison-appstore-solver-move' />").attr("onclick", "<portlet:namespace/>moveAppQna('" + solverId +"','" + myAppQnaList[i].boardSeq + "','" + myAppQnaList[i].groupId + "')").addClass("boardbtn").css("cursor", "pointer").css("width","initial").css("padding", "5px 20px 5px 10px")).css("padding", "10px").css("height", "30px").css("background", "#ffffff"))
										  			.css("margin","15px")
										  			.css("border", "2px solid #DDDDDD")
										  			.css("border-radius","5px")
										  			.css("padding","0")
										  )
								 ).css("padding","0").css("border-bottom", "none").appendTo($rowResult);
						$rowResult.insertAfter($("#<portlet:namespace/>myAppQnaListBody ."+cls+":last"));
					}
				}
				
				$(".myAppQna" + itemNo).slideDown( "slow", function() {
				});
				
			},error:function(msg,e){ 
				alert(e);
				return false;
			}
		});
	}
}

function <portlet:namespace/>fileDownload(p_fileEntryId){
	location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
}

</script>

<aui:script>
function <portlet:namespace/>moveSolverManual(scienceAppId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${appstorePlid}");  
		portletURL.setPortletId("edisonscienceAppstore_WAR_edisonappstore2016portlet"); 
		portletURL.setParameter("groupId", <%= themeDisplay.getScopeGroupId()%>); 
		portletURL.setParameter("solverId", scienceAppId); 
		portletURL.setParameter("myaction", "detailView"); 
		window.location.href = portletURL.toString();
	});
}

function <portlet:namespace/>moveSolverDetail(scienceAppId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${appstorePlid}"); 
		portletURL.setPortletId("edisonscienceAppstore_WAR_edisonappstore2016portlet"); 
		portletURL.setParameter("groupId", <%= themeDisplay.getScopeGroupId()%>); 
		portletURL.setParameter("solverId", scienceAppId); 
		portletURL.setParameter("myaction", "detailView"); 
		window.location.href = portletURL.toString();
	});
}

function <portlet:namespace/>moveSimulation(groupId, solverId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${simulationPlid}"); 
		portletURL.setPortletId("edisonbestsimulation_WAR_edisonsimulationportlet");
		portletURL.setParameter("directGroupId", groupId); 
		portletURL.setParameter("directScienceAppId", solverId); 
		window.location.href = portletURL.toString();
	});
}

function <portlet:namespace/>moveAppQna(scienceAppId, boardSeq, groupId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid("${appstorePlid}");
		portletURL.setPortletId("edisonscienceAppstore_WAR_edisonappstore2016portlet");
		portletURL.setParameter("groupId", groupId);
		portletURL.setParameter("solverId", scienceAppId);
		portletURL.setParameter("myaction", "detailView");
		portletURL.setParameter("boardSeq", boardSeq);
		window.location.href = portletURL.toString();
	});
}

function <portlet:namespace/>moveToolkit(appManagerPlid, scienceAppId) {
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPlid(appManagerPlid);
		portletURL.setPortletId("scienceappmanager_WAR_edisonappstore2016portlet");
		portletURL.setParameter("groupId", <%= themeDisplay.getScopeGroupId()%>); 
		portletURL.setParameter("scienceAppId", scienceAppId);
		portletURL.setParameter("myRender", "solverRender");
		window.location.href = portletURL.toString();
	});
}
</aui:script>

<div id="<portlet:namespace/>display" style="display:none;" >
	<div class="virtitlebox">
		<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
		<div class="virtitle">
			<liferay-ui:message key='edison-appstore-myapp-list' />
		</div>
	</div>
	
	<div class="h10"></div>

	<input type="hidden" id="<portlet:namespace/>groupBoardSeq" name="<portlet:namespace/>groupBoardSeq" value="0">
	<input type="hidden" id="<portlet:namespace/>solverId" name="<portlet:namespace/>solverId" value="0">
	
	<div class="table7_list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout: fixed;">
			<colgroup>
				<col width="*" />
				<col width="100" />
				<col width="200" />
				<col width="150" />
				<col width="80" />
				<col width="80" />
				<col width="80" />
			</colgroup>
			<tbody id="<portlet:namespace/>myAppQnaListBody">
			</tbody>
		</table>
	</div>
</div>