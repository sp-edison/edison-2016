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
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.bean.PortletBeanLocatorUtil"%>

<%@page import="com.liferay.portlet.expando.model.ExpandoValue"%>
<%@page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>

<%@ include file="/html/portlet/users_admin/init.jsp" %>

<script src="/edison-2016-hook/js/jquery-1.10.2.min.js"></script>
<%
User selUser = (User)request.getAttribute("user.selUser");
Contact selContact = (Contact)request.getAttribute("user.selContact");

Calendar birthday = CalendarFactoryUtil.getCalendar();

birthday.set(Calendar.MONTH, Calendar.JANUARY);
birthday.set(Calendar.DATE, 1);
birthday.set(Calendar.YEAR, 1970);

if (selContact != null) {
	birthday.setTime(selContact.getBirthday());
}


String universityNm = "";
String duplicationCheckURL = themeDisplay.getURLPortal()+themeDisplay.getPathMain();

String duplicateScreenNameMsg = "";
String duplicateEmaidMsg = "";

if(selUser != null){
	Serializable serialozableUniversityCode = selUser.getExpandoBridge().getAttribute("universityField");
	int universityCode = 0;
	if(serialozableUniversityCode!=null){
		universityCode = Integer.parseInt(serialozableUniversityCode .toString());
	}
	
	OrderByComparator tableClassIdSearch = (OrderByComparator)PortletBeanLocatorUtil.locate("edison-2016-hook","hookExpandoUtil");
	long tableClassNameId = Long.valueOf(tableClassIdSearch.compare(0,0));
	ExpandoValue value = ExpandoValueLocalServiceUtil.getValue(themeDisplay.getCompanyId(), tableClassNameId, "EDISON_SysCommonCd", "cdNm", universityCode);
	universityNm = value.getString(themeDisplay.getLocale());
	
// 	universityNm = !universityCode.equals("")?EdisonExpndoUtil.getCommonCdSearchFieldValue(StringUtil.trim(universityCode),cdNmSearch):"";
}else{
	duplicateScreenNameMsg = LanguageUtil.get(themeDisplay.getLocale(),"edison-create-account-id-used");
	duplicateEmaidMsg = LanguageUtil.get(themeDisplay.getLocale(),"edison-create-account-email-used");
}
%>
<liferay-portlet:renderURL 
	portletName="edisonorgcodesearch_WAR_edisondefault2016portlet" 
	portletMode="view" 
	windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="syscommoncdURL">
	<liferay-portlet:param name="up_code" value="1501"/>
	<liferay-portlet:param name="com_search_type" value="orgSearch"/>
	<liferay-portlet:param name="popupType" value="details"/>
	<liferay-portlet:param name="popup_title" value="edison-org-code-search"/>
</liferay-portlet:renderURL>
<liferay-ui:error-marker key="errorSection" value="details" />

<aui:model-context bean="<%= selUser %>" model="<%= User.class %>" />

<h3><liferay-ui:message key="details" /></h3>

<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:success key="verificationEmailSent" message="your-email-verification-code-has-been-sent-and-the-new-email-address-will-be-applied-to-your-account-once-it-has-been-verified" />

		<liferay-ui:error exception="<%= DuplicateUserScreenNameException.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken" />

		<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>" focusField="screenName">

			<%
			GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
			%>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
				<liferay-ui:message key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
			</c:if>
		</liferay-ui:error>

		<liferay-ui:error exception="<%= ReservedUserScreenNameException.class %>" focusField="screenName" message="the-screen-name-you-requested-is-reserved" />

		<liferay-ui:error exception="<%= UserFieldException.class %>">

			<%
			UserFieldException ufe = (UserFieldException)errorException;

			StringBundler sb = new StringBundler();

			List<String> fields = ufe.getFields();

			for (int i = 0; i < fields.size(); i++) {
				String field = fields.get(i);

				sb.append(LanguageUtil.get(pageContext, TextFormatter.format(field, TextFormatter.K)));

				if ((i + 1) < fields.size()) {
					sb.append(StringPool.COMMA_AND_SPACE);
				}
			}
			%>

			<liferay-ui:message arguments="<%= sb.toString() %>" key="your-portal-administrator-has-disabled-the-ability-to-modify-the-following-fields" />
		</liferay-ui:error>

		<liferay-ui:error exception="<%= UserScreenNameException.class %>" focusField="screenName" message="please-enter-a-valid-screen-name" />

		<c:if test="<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE) || (selUser != null) %>">
			<c:choose>
				<c:when test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE) || !UsersAdminUtil.hasUpdateFieldPermission(permissionChecker, user, selUser, "screenName") %>'>
					<aui:input disabled="<%= true %>" name="screenName" />
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="<%= (selUser != null) %>">
							<aui:input disabled="<%= true %>" name="screenName" />
						</c:when>
						<c:otherwise>
							<aui:input model="<%= User.class %>" name="screenName">
								<aui:validator name="required" />
								<aui:validator  name="custom"  errorMessage="<%=duplicateScreenNameMsg%>"> 
									function (val, fieldNode, ruleValue) {
										return idCheck(val);
									}
								</aui:validator>
							</aui:input>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:if>

		<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" focusField="emailAddress" message="the-email-address-you-requested-is-already-taken" />
		<liferay-ui:error exception="<%= ReservedUserEmailAddressException.class %>" focusField="emailAddress" message="the-email-address-you-requested-is-reserved" />
		<liferay-ui:error exception="<%= UserEmailAddressException.class %>" focusField="emailAddress" message="please-enter-a-valid-email-address" />

		<c:choose>
			<c:when test='<%= !UsersAdminUtil.hasUpdateFieldPermission(permissionChecker, user, selUser, "emailAddress") %>'>
				<aui:input disabled="<%= true %>" name="emailAddress" />
			</c:when>
			<c:otherwise>

				<%
				User displayEmailAddressUser = null;

				if (selUser != null) {
					displayEmailAddressUser = (User)selUser.clone();

					displayEmailAddressUser.setEmailAddress(displayEmailAddressUser.getDisplayEmailAddress());
				}
				%>

				<aui:input bean="<%= displayEmailAddressUser %>" model="<%= User.class %>" name="emailAddress">
					<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
						<aui:validator name="required" />
					</c:if>
				</aui:input>
			</c:otherwise>
		</c:choose>

		<%@ include file="/html/portlet/users_admin/user/details_user_name.jspf" %>
		
		<liferay-ui:custom-attribute className="<%= User.class.getName() %>" classPK="<%=(selUser != null) ? selUser.getUserId() : 0%>" editable="<%= true %>" label="<%= false %>" name="universityField"/>
		<b><liferay-ui:message key="edison-create-account-field-title-university" /></b><br>
		<input type="text" id="com_cd_nm" id="com_cd_nm" name="com_cd_nm" size="50" type="text" value="<%=universityNm %>" readonly="readonly"/>		
		<input type="button" onclick="syscommoncdPopup()" value='<liferay-ui:message key="edison-button-search"/>' style="height: 30px;margin-bottom: 6px;"/>	
		
		
		<br/><b><liferay-ui:message key="edison-create-account-field-title-major" /></b><br/>
		<liferay-ui:custom-attribute className="<%= User.class.getName() %>" classPK="<%= (selUser != null) ? selUser.getUserId() : 0 %>" editable="<%= true %>" label="<%= false %>" name="majorField"/>
	</aui:fieldset>

	<aui:fieldset cssClass="span5">
		<div>
			<c:if test="<%= selUser != null %>">
				<c:choose>
					<c:when test='<%= UsersAdminUtil.hasUpdateFieldPermission(permissionChecker, user, selUser, "portrait") %>'>
						<portlet:renderURL var="editUserPortraitURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="struts_action" value="/users_admin/edit_user_portrait" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="p_u_i_d" value="<%= String.valueOf(selUser.getUserId()) %>" />
							<portlet:param name="portrait_id" value="<%= String.valueOf(selUser.getPortraitId()) %>" />
						</portlet:renderURL>

						<liferay-ui:logo-selector
							currentLogoURL="<%= selUser.getPortraitURL(themeDisplay) %>"
							defaultLogoURL="<%= UserConstants.getPortraitURL(themeDisplay.getPathImage(), selUser.isMale(), 0) %>"
							editLogoURL="<%= editUserPortraitURL %>"
							imageId="<%= selUser.getPortraitId() %>"
							logoDisplaySelector=".user-logo"
						/>
					</c:when>
					<c:otherwise>
						<img alt="<liferay-ui:message key="portrait" />" src="<%= selUser.getPortraitURL(themeDisplay) %>" />
					</c:otherwise>
				</c:choose>
			</c:if>
		</div>

		<c:if test="<%= selUser != null %>">
			<liferay-ui:error exception="<%= DuplicateUserIdException.class %>" message="the-user-id-you-requested-is-already-taken" />
			<liferay-ui:error exception="<%= ReservedUserIdException.class %>" message="the-user-id-you-requested-is-reserved" />
			<liferay-ui:error exception="<%= UserIdException.class %>" message="please-enter-a-valid-user-id" />

			<aui:input name="userId" type="resource" value="<%= String.valueOf(selUser.getUserId()) %>" />
		</c:if>

		<c:choose>
			<c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY) %>">
				<liferay-ui:error exception="<%= ContactBirthdayException.class %>" message="please-enter-a-valid-date" />

				<aui:input bean="<%= selContact %>" cssClass="modify-link" disabled='<%= !UsersAdminUtil.hasUpdateFieldPermission(permissionChecker, user, selUser, "birthday") %>' model="<%= Contact.class %>" name="birthday" value="<%= birthday %>" />
			</c:when>
			<c:otherwise>
				<aui:input name="birthdayMonth" type="hidden" value="<%= Calendar.JANUARY %>" />
				<aui:input name="birthdayDay" type="hidden" value="1" />
				<aui:input name="birthdayYear" type="hidden" value="1970" />
			</c:otherwise>
		</c:choose>

		<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_MALE) %>">
			<aui:select bean="<%= selContact %>" disabled='<%= !UsersAdminUtil.hasUpdateFieldPermission(permissionChecker, user, selUser, "gender") %>' label="gender" model="<%= Contact.class %>" name="male">
				<aui:option label="male" value="true" />
				<aui:option label="female" value="false" />
			</aui:select>
		</c:if>

<%-- 		<aui:input disabled='<%= !UsersAdminUtil.hasUpdateFieldPermission(permissionChecker, user, selUser, "jobTitle") %>' name="jobTitle" /> --%>
	</aui:fieldset>
</div>
<script type="text/javascript">
	$("input[name*=universityField]").css("display","none");
	
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
</script>