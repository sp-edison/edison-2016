<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%
%>

<style type="text/css">

.<portlet:namespace/>edisonsitewrap{width:100%; height:887px; margin:0 auto; background:url(/edison-content-2016-portlet/images/siteMainLink/pattern.gif); border-bottom:solid 1px #e1e1e1;}
.<portlet:namespace/>epsimg{width:1220px; height:887px; margin:0 auto;}

.<portlet:namespace/>epsimgdiv{display: table-cell;}
</style>
<div class="<portlet:namespace/>edisonsitewrap">
	<div class="<portlet:namespace/>epsimg" style="display: table;">
		<div class="<portlet:namespace/>epsimgdiv">
			<img width="228" height="835" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv01.gif"  border="0" id="<portlet:namespace/>Image22" usemap="#<portlet:namespace/>Image22Map">
			<map name="<portlet:namespace/>Image22Map" id="<portlet:namespace/>Image22Map" onmouseout="<portlet:namespace/>MM_swapImgRestore()" onmouseover="<portlet:namespace/>MM_swapImage('<portlet:namespace/>Image22','','${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv01on.gif',1)">
				<area shape="circle" coords="116,454,94" href="${CFD}" style="outline: none;"/>
			</map>
		</div>
		<div class="<portlet:namespace/>epsimgdiv">
			<img width="227" height="835" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv02.gif"  border="0" id="<portlet:namespace/>Image23" usemap="#<portlet:namespace/>Image23Map">
			<map name="<portlet:namespace/>Image23Map" id="<portlet:namespace/>Image23Map" onmouseout="<portlet:namespace/>MM_swapImgRestore()" onmouseover="<portlet:namespace/>MM_swapImage('<portlet:namespace/>Image23','','${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv02on.gif',1)">
				<area shape="circle" coords="105,623,96" href="${CHEM}" style="outline: none;"/>
			</map>
		</div>
		<div class="<portlet:namespace/>epsimgdiv">
			<img width="293" height="835" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv03.gif"  border="0" id="<portlet:namespace/>Image24" usemap="#<portlet:namespace/>Image24Map" style="height: 835px;">
			<map name="<portlet:namespace/>Image24Map" id="<portlet:namespace/>Image24Map" id="<portlet:namespace/>Image24Map" onmouseout="<portlet:namespace/>MM_swapImgRestore()" onmouseover="<portlet:namespace/>MM_swapImage('<portlet:namespace/>Image24','','${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv03on.gif',1)">
				<area shape="circle" coords="152,651,96" href="${NANO}" style="outline: none;"/>
			</map>
		</div>
		<div class="<portlet:namespace/>epsimgdiv">
			<img width="232" height="835" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv04.gif"  border="0"  id="<portlet:namespace/>Image25" usemap="#<portlet:namespace/>Image25Map">
			<map name="<portlet:namespace/>Image25Map" id="<portlet:namespace/>Image25Map" id="<portlet:namespace/>Image25Map" onmouseout="<portlet:namespace/>MM_swapImgRestore()" onmouseover="<portlet:namespace/>MM_swapImage('<portlet:namespace/>Image25','','${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv04on.gif',1)">
				<area shape="circle" coords="129,622,96" href="${CSD}" style="outline: none;"/>
			</map>
		</div>
		<div class="<portlet:namespace/>epsimgdiv">
			<img width="240" height="835" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv05.gif"  border="0" id="<portlet:namespace/>Image26" usemap="#<portlet:namespace/>Image26Map">
			<map name="<portlet:namespace/>Image26Map" id="<portlet:namespace/>Image26Map"  id="<portlet:namespace/>Image26Map" onmouseout="<portlet:namespace/>MM_swapImgRestore()" onmouseover="<portlet:namespace/>MM_swapImage('<portlet:namespace/>Image26','','${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteMainLink/m_serv05on.gif',1)">
				<area shape="circle" coords="102,454,95" href="${DESIGN}" style="outline: none;"/>
			</map>
		</div>
	</div>
</div>


<script type="text/javascript">

function <portlet:namespace/>MM_swapImgRestore() { //v3.0
	var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function <portlet:namespace/>MM_swapImage() { //v3.0
	var i,j=0,x,a=<portlet:namespace/>MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
	if ((x=<portlet:namespace/>MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function <portlet:namespace/>MM_preloadImages() { //v3.0
var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function <portlet:namespace/>MM_findObj(n, d) { //v4.01
var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
	d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=<portlet:namespace/>MM_findObj(n,d.layers[i].document);
if(!x && d.getElementById) x=d.getElementById(n); return x;
}
</script>
