<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<link href="${contextPath}/css/owl-carousel/owl.carousel.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/css/owl-carousel/owl.theme.css" rel="stylesheet" type="text/css" />

<%
%>

<style type="text/css">
	#banner-wrap { width: 1220px; height: 72px; margin: 0 auto;}
	#banner-wrap ul{ height: 72px; }
	#banner-wrap li{ list-style: none; }
	#banner-wrap .rolling-button { float: left; padding-left: 5px;}
	#rolling-banner { width: 1080px; float: left;}
	
	@media all and (max-width:1220px){
		#banner-wrap { width: 100%;}
		#rolling-banner { width: 80%;}
	}
	
	#rolling-banner .owl-item{text-align: center;}
	
</style>
<div id="banner-wrap">
	<div class="rolling-button">
		<a id="rollingPrev" href="#rollingPrev" title="preview" ><img src="${contextPath}/images/owl-carousel/prev.png" alt="preview" /></a>
	</div>
	
	<ul id="rolling-banner" class="owl-carousel owl-theme">
		<c:if test="${!empty orgImgContnetList}">
			<c:forEach items="${orgImgContnetList}" var="model" varStatus="data">
				<li class="item">
					<a href="${model.orgLink}" target="_blank" title="${model.orgNm}">
						<img src="<%=themeDisplay.getPortalURL()%>${model.fileUrl}" alt="${model.orgNm}" height="62"/>
					</a>
				</li>
			</c:forEach>
		</c:if>
	</ul>
	<div class="rolling-button">
		<a id="rollingStop" href="#rollingStop" title="scroll stop"><img src="${contextPath}/images/owl-carousel/stop.png" alt="stop"/></a>
		<a id="rollingPlay" href="#rollingPlay" title="scroll start"><img src="${contextPath}/images/owl-carousel/play.png" alt="start" /></a>
	</div>
	<div class="rolling-button">
		<a id="rollingNext" href="#rollingNext" title="nextview"><img src="${contextPath}/images/owl-carousel/next.png" alt="nextview" /></a>
	</div>
</div>


<script src="${contextPath}/js/owl-carousel/owl.carousel.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var rolling = $("#rolling-banner");
	rolling.owlCarousel({
		items : "${items}",
		autoPlay : "${autoPlay}",
		rewindSpeed : "${rewindSpeed}",
		pagination : false
	});
	
	$("#rollingNext").click(function(e){
		e.preventDefault();
		rolling.trigger('owl.next');
		rolling.trigger('owl.play',5000);
	});
	
	$("#rollingPrev").click(function(e){
		e.preventDefault();
		rolling.trigger('owl.prev');
		rolling.trigger('owl.play',5000);
	});
	
	$("#rollingPlay").click(function(e){
		e.preventDefault();
		rolling.trigger('owl.play',5000);
	});
	
	$("#rollingStop").click(function(e){
		e.preventDefault();
		rolling.trigger('owl.stop');
	});
  });
  
  
AUI().ready(function() {
});
</script>
