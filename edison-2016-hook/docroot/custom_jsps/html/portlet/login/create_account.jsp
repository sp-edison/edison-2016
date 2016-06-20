<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@page import="java.util.Comparator"%>

<%@ include file="/html/portlet/login/init.jsp" %>
<script src="/edison-2016-hook/js/jquery-1.10.2.min.js"></script>

<%
String EdisonExpando_USER_UNIVERSITY = renderRequest.getAttribute("EdisonExpando_USER_UNIVERSITY")!=null?(String)renderRequest.getAttribute("EdisonExpando_USER_UNIVERSITY"):"";
String EdisonExpando_USER_MAJOR = renderRequest.getAttribute("EdisonExpando_USER_MAJOR")!=null?(String)renderRequest.getAttribute("EdisonExpando_USER_MAJOR"):"";
String EdisonExpando_USER_PROJECT_CATEGORY_ID = renderRequest.getAttribute("EdisonExpando_USER_PROJECT_CATEGORY_ID")!=null?(String)renderRequest.getAttribute("EdisonExpando_USER_PROJECT_CATEGORY_ID"):"";

List<AssetCategory> assetCategoryList = new ArrayList<AssetCategory>();
if(renderRequest.getAttribute("assetCategoryList")!=""){
	assetCategoryList = (List<AssetCategory>) renderRequest.getAttribute("assetCategoryList");
}
String duplicationCheckURL = themeDisplay.getURLPortal()+themeDisplay.getPathMain();
		 
String redirect = ParamUtil.getString(request, "redirect");

String openId = ParamUtil.getString(request, "openId");
boolean male = ParamUtil.getBoolean(request, "male", true);

Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
birthdayCalendar.set(Calendar.DATE, 1);
birthdayCalendar.set(Calendar.YEAR, 1970);

String duplicateScreenNameMsg = LanguageUtil.get(themeDisplay.getLocale(),"edison-create-account-id-used");
String passwordErrMsg = LanguageUtil.get(themeDisplay.getLocale(),"edison-create-account-password-unfit");
String duplicateEmaidMsg = LanguageUtil.get(themeDisplay.getLocale(),"edison-create-account-email-used");
String idErrMsg = LanguageUtil.get(themeDisplay.getLocale(),"edison-create-account-id-unfit");

PasswordPolicy edionPasswordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(company.getCompanyId());

Comparator<Group> sort = new Comparator<Group>() {
	public int compare(Group o1Group, Group o2Group) {
		long o1 = o1Group.getGroupId();
		long  o2 = o2Group.getGroupId();
		return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1);
	}
};

List<Group> siteGroups = ListUtil.sort(GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(),themeDisplay.getSiteGroupId(),true),sort);
%>

<liferay-portlet:renderURL 
	portletName="edisonorgcodesearch_WAR_edisondefault2016portlet" 
	portletMode="view" 
	windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="syscommoncdURL">
	<liferay-portlet:param name="up_code" value="1501"/>
	<liferay-portlet:param name="com_search_type" value="orgSearch"/>
	<liferay-portlet:param name="popupType" value="createAccount"/>
	<liferay-portlet:param name="popup_title" value="edison-org-code-search"/>
</liferay-portlet:renderURL>

<style type="text/css">
	.logintitlebox {
		margin: 0 auto;
		width: 100%;
	}
	
	.logintitle {
		font-size: 27px;
		color: #000;
		padding: 0px 20px 12px 0px;
		font-family: Arial, Nanum Barun Gothic, NanumGothic;
		float: left;
	}
	
	.loginintro {
		vertical-align: bottom;
		font-size: 13px;
		color: #777777;
		padding: 15px 0px 12px 0px;
		float: left;
	}
	
	.joinbox {
		width: 94%;
		border: solid 6px #e5e5e5;
		text-align: center;
		padding: 22px 30px;
		text-align: left;
	}
	
	.jointitle{
		background: url(/edison-2016-hook/images/termsofuse/member_icon.gif) 0px 8px no-repeat;
		font-size: 19px;
		color: #6e6e6e;
		font-weight: 600;
		padding-left: 25px;
		text-align: left;
		line-height: 30px;
		font-family: Arial, Nanum Barun Gothic,NanumGothic;
	}
	
	.joinintro {
		vertical-align: bottom;
		font-size: 14px;
		color: #6e6e6e;
		padding: 15px 0px 25px 0px;
		line-height: 10px;
	}
	
	.edison .table3_list td.title2 {
		vertical-align: middle;
	}
	
	.aui .portlet-borderless-bar{
		display: none;
	}
	
	.aui .control-group{
		margin-bottom: 0px;
	}
	
	.aui input[type="text"],
	.aui input[type="password"]{
		margin-bottom: 0px;
	}
	
	.aui .long_field{
		width: 275px;
	}
</style>

<portlet:actionURL secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="createAccountURL">
	<portlet:param name="struts_action" value="/login/create_account" />
</portlet:actionURL>

<aui:form action="<%= createAccountURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="openId" type="hidden" value="<%= openId %>" />

	<liferay-ui:error exception="<%= AddressCityException.class %>" message="please-enter-a-valid-city" />
	<liferay-ui:error exception="<%= AddressStreetException.class %>" message="please-enter-a-valid-street" />
	<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-postal-code" />
	<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
	<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-create-user-account-because-the-maximum-number-of-users-has-been-reached" />
	<liferay-ui:error exception="<%= ContactFirstNameException.class %>" message="please-enter-a-valid-first-name" />
	<liferay-ui:error exception="<%= ContactFullNameException.class %>" message="please-enter-a-valid-first-middle-and-last-name" />
	<liferay-ui:error exception="<%= ContactLastNameException.class %>" message="please-enter-a-valid-last-name" />
	<liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-open-id-already-exists" />
	<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" message="the-email-address-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= DuplicateUserIdException.class %>" message="the-user-id-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= DuplicateUserScreenNameException.class %>" message="the-screen-name-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= EmailAddressException.class %>" message="please-enter-a-valid-email-address" />

	<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>">

		<%
		GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
		%>

		<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
			<liferay-ui:message key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= NoSuchCountryException.class %>" message="please-select-a-country" />
	<liferay-ui:error exception="<%= NoSuchListTypeException.class %>" message="please-select-a-type" />
	<liferay-ui:error exception="<%= NoSuchRegionException.class %>" message="please-select-a-region" />
	<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />
	<liferay-ui:error exception="<%= RequiredFieldException.class %>" message="please-fill-out-all-required-fields" />
	<liferay-ui:error exception="<%= ReservedUserEmailAddressException.class %>" message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= ReservedUserIdException.class %>" message="the-user-id-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= ReservedUserScreenNameException.class %>" message="the-screen-name-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= TermsOfUseException.class %>" message="you-must-agree-to-the-terms-of-use" />
	<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%= UserIdException.class %>" message="please-enter-a-valid-user-id" />

	<liferay-ui:error exception="<%= UserPasswordException.class %>">

		<%
		UserPasswordException upe = (UserPasswordException)errorException;
		%>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_CONTAINS_TRIVIAL_WORDS %>">
			<liferay-ui:message key="that-password-uses-common-words-please-enter-in-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_INVALID %>">
			<liferay-ui:message key="that-password-is-invalid-please-enter-in-a-different-password" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_LENGTH %>">

			<%
			PasswordPolicy passwordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(company.getCompanyId());
			%>

			<%= LanguageUtil.format(pageContext, "that-password-is-too-short-or-too-long-please-make-sure-your-password-is-between-x-and-512-characters", String.valueOf(passwordPolicy.getMinLength()), false) %>
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_TOO_TRIVIAL %>">
			<liferay-ui:message key="that-password-is-too-trivial" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH %>">
			<liferay-ui:message key="the-passwords-you-entered-do-not-match-each-other-please-re-enter-your-password" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="please-enter-a-valid-screen-name" />
	<liferay-ui:error exception="<%= WebsiteURLException.class %>" message="please-enter-a-valid-url" />

	<c:if test='<%= SessionMessages.contains(request, "openIdUserInformationMissing") %>'>
		<div class="alert alert-info">
			<liferay-ui:message key="you-have-successfully-authenticated-please-provide-the-following-required-information-to-access-the-portal" />
		</div>
	</c:if>

	<aui:model-context model="<%= Contact.class %>" />
	
	<div class="logintitlebox">
			<div class="logintitle"><liferay-ui:message key="edison-create-account-message" /></div>
			<div class="loginintro"><liferay-ui:message key="edison-create-account-course-message" /></div>
	</div>
	<div class="h20"></div>
	<div class="joinbox">
		<div class="jointitle"><liferay-ui:message key="edison-create-account-member-information-input-message" /></div>
		<div class="joinintro">
			<p><font color="red">*</font> <liferay-ui:message key="edison-create-account-description-message-first-line" /></p>
			<p><liferay-ui:message key="edison-create-account-description-message-second-line" /></p>
			<p><liferay-ui:message key="edison-create-account-description-message-third-line" /></p>
<!-- 			<p><liferay-ui:message key="edison-create-account-description-message-Fourth-line" /></p> -->
		</div>
		<div class="table3_list">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="20%" class="title2"><liferay-ui:message key="edison-create-account-field-title-name" />(<font color="red">*</font>)</td>
					<td width="37%">
						<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" model="<%= User.class %>" name="firstName" label="" cssClass="long_field">
							<aui:validator name="required"/>
							<aui:validator name="maxLength">32</aui:validator>
						</aui:input>
					</td>
					<td width="20%" class="title2">ID(<font color="red">*</font>)</td>
					<td width="37%">
						<c:if test="<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE) %>">
							<aui:input label="" model="<%= User.class %>" name="screenName" cssClass="long_field">
								<aui:validator name="required"/>
								<aui:validator name="maxLength">32</aui:validator>
								<aui:validator name="minLength">3</aui:validator>
								<aui:validator  name="custom"  errorMessage="<%=duplicateScreenNameMsg%>"> 
									function (val, fieldNode, ruleValue) {
										return idCheck(val);
									}
								</aui:validator>
								<aui:validator  name="custom"  errorMessage="<%=idErrMsg%>">
									function (val) {
										return idExpressionCheck(val);
									}
								</aui:validator>
							</aui:input>
						</c:if>
					</td>
				</tr>
				
				
				
				<c:if test="<%= PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD %>">
					<tr>
						<td width="20%" class="title2"><liferay-ui:message key="edison-create-account-field-title-password" />(<font color="red">*</font>)</td>
							<td width="37%">
								<aui:input label="" name="password1" size="30" type="password" value="">
									<aui:validator name="required"/>
									<aui:validator  name="custom"  errorMessage="<%=passwordErrMsg%>">
										function (val, fieldNode, ruleValue) {
											return passWordCheck(val);
										}
										
									</aui:validator>
								</aui:input>
							</td>
							<td width="20%" class="title2"><liferay-ui:message key="edison-create-account-field-title-password-confirm" />(<font color="red">*</font>)</td>
							<td width="37%">
								<aui:input label="" name="password2" size="30" type="password" value="">
									<aui:validator name="required"/>
									<aui:validator name="equalTo">
										'#<portlet:namespace />password1'
									</aui:validator>
								</aui:input>
							</td>
					</tr>
				</c:if>
				
				
				
				
				<tr>
					<td width="20%" class="title2"><liferay-ui:message key="edison-create-account-field-title-email" />(<font color="red">*</font>)</td>
					<td colspan="3">
						<aui:input model="<%= User.class %>" name="emailAddress" label="" cssClass="long_field">
							<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
								<aui:validator name="required"/>
							</c:if>
							<aui:validator  name="custom"  errorMessage="<%=duplicateEmaidMsg%>"> 
								function (val, fieldNode, ruleValue) {
									return emailCheck(val);
								}
							</aui:validator>
						</aui:input>
					</td>
				</tr>
				
				
				
				<tr>
					<td width="20%" class="title2"><liferay-ui:message key="edison-create-account-field-title-university" />(<font color="red">*</font>)</td>
					<td width="37%">
						<aui:input label="" id="com_cd_nm" name="com_cd_nm" size="50" type="text" value="" readonly="readonly">
							<aui:validator name="required"/>
						</aui:input>
						<liferay-ui:custom-attribute className="<%= User.class.getName() %>" classPK="<%= 0 %>" editable="<%= true %>" label="<%= false %>" name="<%=EdisonExpando_USER_UNIVERSITY%>"/>
						<div class="h10"></div>
						<input type="button" class="button09" onclick="syscommoncdPopup()" value='<liferay-ui:message key="edison-button-search"/>' />
					</td>
					<td width="20%" class="title2"><liferay-ui:message key="edison-create-account-field-title-major" /></td>
					<td width="37%" style="vertical-align: middle;">
						<liferay-ui:custom-attribute className="<%= User.class.getName() %>" classPK="<%= 0 %>" editable="<%= true %>" label="<%= false %>" name="<%=EdisonExpando_USER_MAJOR%>"/>
					</td>
				</tr>
				
				
				<tr>
					<td width="20%" class="title2"><liferay-ui:message key="edison-create-account-field-title-site" /></td>
					<td colspan="3">
						<%
							for(Group group:siteGroups){
								String groupName = LanguageUtil.get(themeDisplay.getLocale(), StringUtil.toUpperCase(group.getName()));
						%>
							<aui:input name='<%= "join_site_id_"+group.getGroupId() %>' type="checkbox" value="<%= group.getName() %>" label="<%=groupName%>"/>
						<%
							}
						%>
					</td>
				</tr>
				
				
				
				<c:if test="<%= PropsValues.CAPTCHA_CHECK_PORTAL_CREATE_ACCOUNT %>">
					<tr>
						<td width="20%" class="title2"><liferay-ui:message key="edison-create-account-field-title-captcha" />(<font color="red">*</font>)</td>
						<td colspan="3">
							<portlet:resourceURL var="captchaURL">
								<portlet:param name="struts_action" value="/login/captcha" />
							</portlet:resourceURL>
							
							<aui:column>
								<liferay-ui:captcha url="<%= captchaURL %>" />
							</aui:column>
						</td>
					</tr>
				</c:if>
				
				
			</table>
		</div>
		<div class="buttonbox08">
			<input type="submit" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-save" />" class="button08">
			<input type="button" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-cancel" />" class="button08" onclick="cancle();">
		</div>
	</div>
	
	
	
	
	<c:choose>
		<c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY) %>">
			<tr>
				<td width="20%" class="title2">birthday</td>
				<td colspan="3">
					<aui:input name="birthday" value="<%= birthdayCalendar %>" />
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<aui:input name="birthdayMonth" type="hidden" value="<%= Calendar.JANUARY %>" />
			<aui:input name="birthdayDay" type="hidden" value="1" />
			<aui:input name="birthdayYear" type="hidden" value="1970" />
		</c:otherwise>
	</c:choose>


	<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_MALE) %>">
		<tr>
			<td colspan="4">
				<aui:select label="gender" name="male">
					<aui:option label="male" value="1" />
					<aui:option label="female" selected="<%= !male %>" value="0" />
				</aui:select>
			</td>
		</tr>
	</c:if>
	
	
</aui:form>

<script type="text/javascript">
	$("input[name*=firstName]").css("max-width","none");
	$("input[name*=screenName]").css("max-width","none");
	$("input[name*=emailAddress]").css("max-width","none");
	$("input[name*=universityField]").css("display","none");
	$("input[name*=projectCategoryId]").css("display","none");
	$("input[name*=com_cd_nm]").css("width","250px");
	
	function cancle(){
		location.href = "<%= PortalUtil.getHomeURL(request)%>";
	}	
	
	
	function syscommoncdPopup(){
		var URL = "<%=syscommoncdURL%>";
		w = 850;
		h = 550;		
		x = (screen.availWidth - w) / 2;
		y = (screen.availHeight - h) / 2;
		var options = "width="+w+", height="+h+", left="+x+",top="+y+",toolbar=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no";
		var openPop;
		if(openPop != null){
			openPop.focus();
		}else{
			openPop = window.open(URL, "syscommoncdPopup",options);
			openPop.focus();
		}
	}
	
	function idCheck(val){
		 var retbool = true;
		 var url =  "<%=duplicationCheckURL%>";
		  jQuery.ajax({
	    		type: "POST",
	    		url:  url+"/portal/create_account_validataion",
	    		async : false,
	    		data: { 
	    			"data" : val,
	    			"checkDiv" : "ID"
	    		},
	    		success: function(data) {
	   			 if(data == 'true'){
	   				
	   			 }else{
	   				retbool = false;
	   			 }
	    		},
	    		error:function(data,e){
	    			alert("ID duplication Check Error!!!");
	    			retbool = false;
	    		}
	    	});	 
		
		  
		 return retbool;
		 
	}
	
	function emailCheck(val){
		 var retbool = true;
		 var url =  "<%=duplicationCheckURL%>";
		  jQuery.ajax({
	    		type: "POST",
	    		url:  url+"/portal/create_account_validataion",
	    		async : false,
	    		data: {
	    			"data" : val,
	    			"checkDiv" : "EMAIL"
	    		},
	    		success: function(data) {
	   			 if(data == 'true'){
	   				
	   			 }else{
	   				retbool = false;
	   			 }

	    		},
	    		error:function(data,e){
	    			alert("emailAddress duplication Check Error!!!");
	    			retbool = false;
	    		}
	    	});	 

		 return retbool;
	}
	
	function idExpressionCheck(val){
		var retbool = false;
		var idCheck = /^[A-Za-z0-9+]*$/;
		if(idCheck.test(val)){
			retbool = true;
		}
		return retbool;
	}

	function passWordCheck(val){
		var retbool = true;
		var minLength = <%=edionPasswordPolicy.getMinLength()%>;
		var reg = new RegExp("<%=edionPasswordPolicy.getRegex()%>");
		if(val.length<minLength){
			retbool = false;
		}else{
			if(!reg.test(val)){
				retbool = false;
			}
		}
		return retbool;
		
	}
	
	function <portlet:namespace/>changeCategory(value){
		$("input[name*=ExpandoAttribute--projectCategoryId-]").val(value);
	}
</script>
