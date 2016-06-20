<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.kisti.edison.model.EdisonExpando"%>
<%@page import="org.kisti.edison.util.EdisonExpndoUtil"%>

<%@page import="java.util.Map.Entry"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<base target="_self">
<title>공통 코드 조회</title>
<script src="/edison-2016-hook/js/jquery-1.10.2.min.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${comSearchType eq 'orgSearch'}">
			<div class="table1_list">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<colgroup>
						<col width="10%"/>
						<col width="10%"/>
						<col width="*"/>
						<col width="15%"/>
					</colgroup>
					<thead>
						<th scope="col"><liferay-ui:message key="edison-table-list-header-select"/></th>
						<th scope="col"><liferay-ui:message key="edison-table-list-header-index"/></th>
						<th scope="col"><liferay-ui:message key="edison-create-account-field-title-university"/></th>
						<th scope="col"><liferay-ui:message key="edison-table-list-header-region"/></th>
					</thead>
					<tbody>
					<%
					List<Map<String,String>> codeList = (List<Map<String,String>>)request.getAttribute("codeList");
						if(codeList.size()>0){
							int rowCnt = 1;
							for(Map<String,String> codeMap : codeList){
								out.println("<tr>");
								String cd = codeMap.get(EdisonExpando.CD).toString();
								String cdNm = codeMap.get(EdisonExpando.CDNM).toString();
								String region = codeMap.get(EdisonExpando.REGION).toString();
								String regionNm = "";
								
								if(!region.equals("")){
									regionNm = EdisonExpndoUtil.getCommonCdSearchFieldValue(region, EdisonExpando.CDNM, themeDisplay.getLocale());
								} 
								String hiddenCdNm = HtmlUtil.escapeJS(cdNm);
					%>
						<td class="tc" style="cursor: auto;">
							<input type="radio" name="up_common_cd" onclick="selectOrg('<%=cd%>','<%=hiddenCdNm%>');"/>
						</td>
						<td class="tc" style="cursor: auto;">
							<%=rowCnt%>
						</td>
						<td  style="cursor: pointer;" onclick="selectOrg('<%=cd%>','<%=hiddenCdNm%>');">
							<%=cdNm%>
						</td>
						<td style="cursor: auto;">
							<%=regionNm%>
						</td>
					<%
								rowCnt++;
								out.println("</tr>");
							}
						}else{
					%>
						<tr>
							<td colspan="4"><liferay-ui:message key="edison-search-no-result"/></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<div class="table1_list">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<colgroup>
						<col width="20"/>
						<col width="*"/>
					</colgroup>
					<thead>
						<th scope="col">순번</th>
						<th scope="col">코드명</th>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${!empty codeList}">
								<c:forEach var="dataList" items="${codeList}" varStatus="status">
									<c:forEach var="item_map" items="${dataList}">
										<tr>
											<td>${status.count}</td>
											<c:choose>
												<c:when test="${themeDisplay.getLanguageId() eq 'en_US'}">
													<td>${item_map.value.cdNm_en_US}</td>
												</c:when>
												<c:otherwise>
													<td>${item_map.value.cdNm_ko_KR}</td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="2"><liferay-ui:message key="edison-search-no-result"/></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</c:otherwise>
	</c:choose>
</body>
<footer>
	<script type="text/javascript">
		
		var popupType = "${param.popupType}";
		var universityField = "${param.universityField}";
		var universityFieldNm = "${param.universityFieldNm}";
		
		if(popupType == "details"){
			$(".table1_list").css("line-height","2.0em")
							.css("font-family","\"나눔고딕\",NanumGothic,\"돋움\",'Nanum Gothic'")
							.css("width","100%")
							.css("width","100%")
							.css("border-top","2px solid #6a8ec6")
							.css("border-collapse","collapse")
							.css("font-size","13px");
			
			$(".table1_list").find("th").css("border-bottom","1px solid #b4b4b4")
								  .css("padding","10px")
								  .css("color","#383838")
								  .css("font-weight","600")
								  .css("background-color","#f7f7f7")
								  .css("text-align","center")
								  .css("font-size","15px");
			
			$(".table1_list").find("td").css("border-right","0px solid #e2e2e2")
										.css("color","#777777")
										.css("border-bottom","1px solid #ccc")
										.css("font-padding","10px")
										.css("padding","10px");
			
			$(".table1_list").find("td[class=tc]").css("text-align","center");
			
			$(".table1_list").find("tr").hover(function(){
				$(this).css("background-color", "#d0d0d0");
			}, function(){
				$(this).css("background-color", "rgb(255, 255, 255)");
			});
		}
		
		function selectOrg(com_cd, cd_nm){
			var $openerObj = $(window.opener.document);
			
			if(popupType == "cyberlab"){
				$openerObj.find("#universityField").val(cd_nm);
				$openerObj.find("input[name=cyberLabUniversityField]").val(com_cd);			
			}else if(popupType == "createAccount"){
				$openerObj.find('[id*="_com_cd_nm"]').val(cd_nm);
				$openerObj.find('[id*="_com_cd_nm"]').focus();
				$openerObj.find("input[name*=ExpandoAttribute--universityField-]").val(com_cd);
			}else if(popupType == "details"){
				$openerObj.find("#com_cd_nm").val(cd_nm);
				$openerObj.find("input[name*=ExpandoAttribute--universityField-]").val(com_cd);
			}else{
				$openerObj.find("input[name*="+universityFieldNm+"]").val(cd_nm);
				$openerObj.find("input[name*="+universityField+"]").val(com_cd);
			}
			
			window.self.close();
		}
	</script>
</footer>
</html>