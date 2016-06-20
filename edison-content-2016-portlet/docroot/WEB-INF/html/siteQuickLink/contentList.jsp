<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%
	String scienceAppStoreURL = CustomUtil.strNull(request.getAttribute("scienceAppStoreURL"));
	String simulationUrl = CustomUtil.strNull(request.getAttribute("simulationUrl"));
	String virtualLabUrl = CustomUtil.strNull(request.getAttribute("virtualLabUrl"));
%>

<style type="text/css">

/*quicklink 20150527*/
.quicklink{width:100%; height:446px; margin:0 auto; background:
url(/edison-content-2016-portlet/images/siteQuickLink/pattern.gif); border-bottom:solid 1px #e1e1e1;}
.quicklinktit{width:1220px; margin:0 auto; text-align:center; padding:30px 0 40px 0;}
.quicklinkimg{width:843px; margin:0 auto; text-align:center; overflow:hidden;}
.quicklinkimg ul{list-style:none; text-align:center;}
.quicklinkimg ul li{float:left; margin-right:60px;}
.quicklinkimg ul li.last{ margin-right:0;}

.imagebox{width:200px; float:left; margin-right:53px; text-align:center;}
.imagebox1{width:200px; float:left; text-align:center;}
.imagetxt{font-size:12px; color:#666; font-weight:500; padding-top:31px; text-align:left;}
.epsimg{width:1220px; height:887px; margin:0 auto;}
.heightdown{height:70px;}

</style>

<div class="quicklink">
	<div class="quicklinktit"></div>
	
	<div class="quicklinkimg">
		<ul style="list-style: none; text-align: center;margin: 0;">
			<li>
				<a onmouseover="<portlet:namespace/>MM_swapImage('Image28','','${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteQuickLink/icon01off.png',1)" onmouseout="<portlet:namespace/>MM_swapImgRestore();" onclick="<portlet:namespace/>locationLink('app');">
					<img width="240" height="296" id="Image28" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteQuickLink/icon01.png" border="0" usemap="#Image28Map">
					<map name="Image28Map" id="Image28Map">
						<area href="#" shape="circle" coords="120,116,96">
					</map>
				</a>
			</li>
			<li>
				<a onmouseover="<portlet:namespace/>MM_swapImage('Image29','','${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteQuickLink/icon02off.png',1)" onmouseout="<portlet:namespace/>MM_swapImgRestore();" onclick="<portlet:namespace/>locationLink('sim');">
					<img width="240" height="296" id="Image29" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteQuickLink/icon02.png" border="0" usemap="#Image29Map">
					<map name="Image29Map" id="Image29Map">
						<area href="#" shape="circle" coords="120,116,96">
					</map>
				</a>
			</li>
			<li class="last">
				<a onmouseover="<portlet:namespace/>MM_swapImage('Image30','','${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteQuickLink/icon03off.png',1)" onmouseout="<portlet:namespace/>MM_swapImgRestore();" onclick="<portlet:namespace/>locationLink('vir');">
					<img width="240" height="296" id="Image30" src="${contextPath}/images/<%=themeDisplay.getLanguageId()%>/siteQuickLink/icon03.png" border="0" usemap="#Image30Map">
					<map name="Image30Map" id="Image30Map">
						<area href="#" shape="circle" coords="120,116,96">
					</map>
				</a>
			</li>
		</ul>
	</div>
</div>



<script type="text/javascript">
function <portlet:namespace/>locationLink(sort){
	if(sort =="app"){
		window.location.href = "<%=scienceAppStoreURL%>";
	}else{
		<%if(user.isDefaultUser()){%>
			alert(Liferay.Language.get('edison-simulation-please-login'));
		<%}else{%>
			if(sort == "sim"){
				window.location.href = "<%=simulationUrl%>";
			}else if(sort == "vir"){
				window.location.href = "<%=virtualLabUrl%>";
			}
		<%}%>
	}
}
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
