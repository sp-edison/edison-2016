<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="javax.portlet.PortletURL" %>

<liferay-portlet:resourceURL var="getRepositoryInfoURL" id="getRepositoryInfo" copyCurrentRenderParameters="false" />

<style type="text/css">
.hoverView:hover .cpuDiv{
	display:inline;
	background:white;
	font-size:20px;
	z-index: 3;
	left:-30px;
	top:-30px;
	line-height: normal;
	width:100px;
	text-align: center;
}
.hoverView:hover .fileDiv{
	display:inline;
	background:white;
	font-size:20px;
	z-index: 3;
	left:-75px;
	top:-30px;
	line-height: normal;
	width:210px;
	text-align: center;
}

.hoverView .cpuDiv {
	position:relative; top:-20px; left:-2px; font-size: 11px; color:#46aaec; width:55px; display:none; font-weight: 600; line-height:10px;
}

.hoverView .fileDiv {
	position:relative; top:-20px; left:-2px; font-size: 11px; color:#f26201; width:115px; display:none; font-weight: 600; line-height:10px;
}
</style>

<script type="text/javascript">
AUI().ready(function() {
});

function <portlet:namespace/>getRepositoryInfo(groupId) {
	var searchData = {
		"<portlet:namespace/>groupId" : groupId
	}
	jQuery.ajax({
		type: "POST",
		url: "<%=getRepositoryInfoURL%>",
		async : true,
		data : searchData
		,complete:function(){
			$("#<portlet:namespace/>loadingImage" + groupId).fadeOut( "slow" );
		}
		,success: function(msg) {
			var repositoryInfoMap = msg.repositoryInfoMap;
			if(repositoryInfoMap.cpuRepositoryPercent > 0) {
				$("#<portlet:namespace/>cpuRepositoryGraph" + groupId).animate({
					height: repositoryInfoMap.cpuRepositoryPercent + "%"
				}, {
					duration : 600,
					step: function( now, fx) {
						$("#<portlet:namespace/>cpuPercent" + groupId).text(Math.floor(now) + "%");
					},
					complete: function() {
						$("#<portlet:namespace/>cpuRepositoryDescription" + groupId).fadeIn("slow").html(repositoryInfoMap.userCpuRepository + "&nbsp;/&nbsp;<span style='color:black; display:inline-block; font-style:italic;'>" + repositoryInfoMap.cpuRepository + "</span>");
						$("#<portlet:namespace/>cpuRepositoryGraph" + groupId).attr("title", repositoryInfoMap.userCpuRepository + " / " + repositoryInfoMap.cpuRepository);
					}
				});
			} else {
				$("#<portlet:namespace/>cpuPercent" + groupId).text("0%");
				$("#<portlet:namespace/>cpuRepositoryDescription" + groupId).fadeIn("slow").html(repositoryInfoMap.userCpuRepository + "&nbsp;/&nbsp;<span style='color:black; display:inline-block; font-style:italic;'>" + repositoryInfoMap.cpuRepository + "</span>");
				$("#<portlet:namespace/>cpuRepositoryGraph" + groupId).attr("title", repositoryInfoMap.userCpuRepository + " / " + repositoryInfoMap.cpuRepository);
			}
			
			if(repositoryInfoMap.repositoryPercent > 0) {
				$("#<portlet:namespace/>diskRepositoryGraph" + groupId).animate({
					height: repositoryInfoMap.repositoryPercent + "%"
				}, {
					duration : 600,
					step: function( now, fx) {
						$("#<portlet:namespace/>diskPercent" + groupId).text(Math.floor(now) + "%");
					},
					complete: function() {
						$("#<portlet:namespace/>diskRepositoryDescription" + groupId).fadeIn("slow").html(repositoryInfoMap.userRepository + "&nbsp;/&nbsp;<span style='color:black; display:inline-block; font-style:italic;'>" + repositoryInfoMap.repository + "</span>");
						$("#<portlet:namespace/>diskRepositoryGraph" + groupId).attr("title", repositoryInfoMap.userRepository + " / "+ repositoryInfoMap.repository);
					}
				});
			} else {
				$("#<portlet:namespace/>diskPercent" + groupId).text("0%");
				$("#<portlet:namespace/>diskRepositoryDescription" + groupId).fadeIn("slow").html(repositoryInfoMap.userRepository + "&nbsp;/&nbsp;<span style='color:black; display:inline-block; font-style:italic;'>" + repositoryInfoMap.repository + "</span>");
				$("#<portlet:namespace/>diskRepositoryGraph" + groupId).attr("title", repositoryInfoMap.userRepository + " / "+ repositoryInfoMap.repository);
			}
		},error:function(jqXHR, textStatus, errorThrown) {
			if(jqXHR.status!=0){
	 			alert("getRepositoryInfo-->"+jqXHR.status+",  " + jqXHR.statusText+",  "+textStatus+",  "+errorThrown);
			}
			return false;
		}
	});
}

</script>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-simulation-myrepository-title' />
	</div>
</div>

<div class="h10"></div>

<table border="0" style="table-layout: fixed; margin: 0 auto;">
	<colgroup>
		<col width="80px" />
		<col width="15px" />
		<col width="15px" />
		<col width="*" />
		<col width="*" />
	</colgroup>
	<tbody>
		<tr style="height:25px;">
			<td rowspan="2" style="text-align: center; font-weight: 600;">
				100%
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td style="border-top: 2px solid black; border-right: 1px solid black;"></td>
			<td style="border-top: 2px solid black;"></td>
			<td rowspan="10" style="height:250px;">
				<c:forEach items="${repositoryList}" var="modelList">
					<div id="<portlet:namespace/>repositoryDiv${modelList.groupId}" style="display:inline-block; width:90px; height:250px; position:relative; padding: 0px 40px 0px 40px;">
						<img id="<portlet:namespace/>loadingImage${modelList.groupId}" src="${contextPath}/images/loading.gif" style="position: absolute; float:left; left:20%; top:45%;" height="50" width="50"/>
						<div id="<portlet:namespace/>cpuRepositoryGraph${modelList.groupId}" class="hoverView" style="position:absolute; left:15px; bottom:0px; display:inline-block; background: #46aaec; height: 1%; width:30px; border-radius: 3px; box-shadow: 5px 5px 10px #888888;" title="--/--">
							<div id="<portlet:namespace/>cpuRepositoryDescription${modelList.groupId}" class="cpuDiv">
								<!-- ${modelList.userCpuRepository}&nbsp;/&nbsp;<span style="font-weight:600;">${modelList.cpuRepository}</span> -->
							</div>
						</div>
						<div id="<portlet:namespace/>diskRepositoryGraph${modelList.groupId}" class="hoverView" style="position:absolute; left:70px; bottom:0px; display:inline-block; background: #f26201; height: 1%; width:30px; border-radius: 3px; box-shadow: 5px 5px 10px #888888;"  title="--/--">
							<div id="<portlet:namespace/>diskRepositoryDescription${modelList.groupId}" class="fileDiv">
								<!-- ${modelList.userRepository}&nbsp;/&nbsp;<span style="font-weight:600;">${modelList.repository}</span> -->
							</div>
						</div>
					</div>
				</c:forEach>
			</td>
			<td rowspan="3">
				<div style="padding:10px; border:1px solid black; margin-left:30px; box-shadow: 5px 5px 10px #888888; border-radius: 5px;">
					<ul style="margin:0px; font-weight:600;">
						<li><span style="color:#46aaec;">■</span> : <liferay-ui:message key='edison-simulation-myrepository-cpu-usage' /></li>
						<li><span style="color:#f26201;">■</span> : <liferay-ui:message key='edison-simulation-myrepository-disk-usage' /></li>
					</ul>
				</div>
			</td>
		</tr>
		<tr style="height:25px;" >
			<td rowspan="2" style="text-align: center; font-weight: 600;">
				80%
			</td>
			<td style="border-right: 1px solid black;"></td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td style="border-top: 2px solid black; border-right: 1px solid black;"></td>
			<td style="border-top: 2px solid black;"></td>
		</tr>
		<tr style="height:25px;">
			<td rowspan="2" style="text-align: center; font-weight: 600;">
				60%
			</td>
			<td style="border-right: 1px solid black;"></td>
			<td></td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td style="border-top: 2px solid black; border-right: 1px solid black;"></td>
			<td style="border-top: 2px solid black;"></td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td rowspan="2" style="text-align: center; font-weight: 600;">
				40%
			</td>
			<td style="border-right: 1px solid black;"></td>
			<td></td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td style="border-top: 2px solid black; border-right: 1px solid black;"></td>
			<td style="border-top: 2px solid black;"></td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td rowspan="2" style="text-align: center; font-weight: 600;">
				20%
			</td>
			<td style="border-right: 1px solid black;"></td>
			<td></td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td style="border-top: 2px solid black; border-right: 1px solid black;"></td>
			<td style="border-top: 2px solid black;"></td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td rowspan="2" style="text-align: center; font-weight: 600;">
				0%
			</td>
			<td style="border-right: 1px solid black;"></td>
			<td></td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td style="border-top: 1px solid black; border-right: 1px solid black;"></td>
			<td style="border-top: 1px solid black;"></td>
			<td style="border-top: 1px solid black; font-weight: 600;" rowspan="2">
				<c:forEach items="${repositoryList}" var="modelList">
					<ul style="display:inline-block; width:120px; text-align: center; margin:0px 50px 0px 0px;">
						<li>
							(
							<span id="<portlet:namespace/>cpuPercent${modelList.groupId}" style="color:#46aaec;">--%</span>
							/
							<span id="<portlet:namespace/>diskPercent${modelList.groupId}" style="color:#f26201;">--%</span>
							)
						</li>
						<li>
						<script>
							<portlet:namespace/>getRepositoryInfo("${modelList.groupId}");
						</script>
							${modelList.groupName}
						</li>
					</ul>
				</c:forEach>
			</td>
			<td></td>
		</tr>
		<tr style="height:25px;">
			<td></td>
			<td style="border-right: 1px solid black;"></td>
			<td></td>
			<td></td>
		</tr>
	</tbody>
</table>
