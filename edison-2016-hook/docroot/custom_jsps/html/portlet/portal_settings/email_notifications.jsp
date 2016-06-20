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

<%@ include file="/html/portlet/portal_settings/init.jsp" %>

<h3><liferay-ui:message key="email-notifications" /></h3>
<%!
// EDISON EMAIL SETTING preperence Keys
public static final String EDISON_ADMIN_EMAIL_LAB_REQUEST_SUBJECT 	= "admin.email.lab.request.subject";
public static final String EDISON_ADMIN_EMAIL_LAB_REQUEST_BODY 	= "admin.email.lab.request.body";
public static final String EDISON_ADMIN_EMAIL_LAB_CONFIRM_SUBJECT 	= "admin.email.lab.confirm.subject";
public static final String EDISON_ADMIN_EMAIL_LAB_CONFIRM_BODY 	= "admin.email.lab.confirm.body";


public static final String EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_SUBJECT 	= "admin.email.workspace.confirm.subject";
public static final String EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_BODY 		= "admin.email.workspace.confirm.body";
public static final String EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_SUBJECT 	= "admin.email.workspace.request.subject";
public static final String EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_BODY 		= "admin.email.workspace.request.body";

public static final String EDISON_ADMIN_ERROR_REPORT_SUBJECT 	= "admin.email.error.report.subject";
public static final String EDISON_ADMIN_ERROR_REPORT_BODY 		= "admin.email.error.report.body";

public static final String EDISON_FORGOT_ID_SUBJECT 	= "admin.email.forgot.id.subject";
public static final String EDISON_FORGOT_ID_BODY 	= "admin.email.forgot.id.body";
%>

<%
String adminEmailFromName = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
String adminEmailFromAddress = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

boolean adminEmailUserAddedEnable = PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED);
String adminEmailUserAddedSubject = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_SUBJECT);
String adminEmailUserAddedBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_BODY);
String adminEmailUserAddedNoPasswordBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_NO_PASSWORD_BODY);

String adminEmailPasswordSentSubject = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_SUBJECT);
String adminEmailPasswordSentBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_BODY);

String adminEmailPasswordResetSubject = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_SUBJECT);
String adminEmailPasswordResetBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_BODY);

String adminEmailVerificationSubject = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_VERIFICATION_SUBJECT);
String adminEmailVerificationBody = PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_VERIFICATION_BODY);


// TODO : Gplus 추가 내용 컨버전
String adminEmailLabConfirmBody = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_EMAIL_LAB_CONFIRM_BODY);
String adminEmailLabConfirmSubject = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_EMAIL_LAB_CONFIRM_SUBJECT);

String adminEmailLabRequestSubject = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_EMAIL_LAB_REQUEST_SUBJECT);
String adminEmailLabRequestBody = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_EMAIL_LAB_REQUEST_BODY);

String adminEmailWorkspaceConfirmSubject = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_SUBJECT);
String adminEmailWorkspaceConfirmBody = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_BODY);

String adminEmailWorkspaceRequestSubject = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_SUBJECT);
String adminEmailWorkspaceRequestBody = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_BODY);

String adminErrorReportSubject = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_ERROR_REPORT_SUBJECT);
String adminErrorReportBody = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_ADMIN_ERROR_REPORT_BODY);

String adminForgotIdSubject = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_FORGOT_ID_SUBJECT);
String adminForgotIdBody = PrefsPropsUtil.getContent(company.getCompanyId(), EDISON_FORGOT_ID_BODY);
%>

<liferay-ui:error-marker key="errorSection" value="email_notifications" />

<liferay-ui:tabs
	names="sender,
	account-created-notification,
	email-verification-notification,
	password-changed-notification,
	password-reset-notification,
	forgot-id-notification,
	lab-request-notification,
	workspace-request-notification,
	lab-confirm-notification,
	workspace-confirm-notification,
	error-report-notification"
	refresh="<%= false %>"
>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailFromName" message="please-enter-a-valid-name" />

			<aui:input cssClass="lfr-input-text-container" label="name" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_FROM_NAME + "--" %>' type="text" value="<%= adminEmailFromName %>" />

			<liferay-ui:error key="emailFromAddress" message="please-enter-a-valid-email-address" />

			<aui:input cssClass="lfr-input-text-container" label="address" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_FROM_ADDRESS + "--" %>' type="text" value="<%= adminEmailFromAddress %>" />
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<aui:input label="enabled" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED + "--" %>' type="checkbox" value="<%= adminEmailUserAddedEnable %>" />

			<liferay-ui:error key="emailUserAddedSubject" message="please-enter-a-valid-subject" />

			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_USER_ADDED_SUBJECT + "--" %>' type="text" value="<%= adminEmailUserAddedSubject %>" />

			<liferay-ui:error key="emailUserAddedBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper helpMessage="account-created-notification-body-with-password-help" label="body-with-password">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailUserAddedBodyEditor" %>' name="emailUserAddedBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_USER_ADDED_BODY + "--" %>' type="hidden" value="<%= adminEmailUserAddedBody %>" />
			</aui:field-wrapper>

			<liferay-ui:error key="emailUserAddedNoPasswordBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper helpMessage="account-created-notification-body-without-password-help" label="body-without-password">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailUserAddedNoPasswordBodyEditor" %>' name="emailUserAddedNoPasswordBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_USER_ADDED_NO_PASSWORD_BODY + "--" %>' type="hidden" value="<%= adminEmailUserAddedNoPasswordBody %>" />
			</aui:field-wrapper>

			<div class="terms email-user-add definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailVerificationSubject" message="please-enter-a-valid-subject" />

			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_VERIFICATION_SUBJECT + "--" %>' type="text" value="<%= adminEmailVerificationSubject %>" />

			<liferay-ui:error key="emailVerificationBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper label="body">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailVerificationBodyEditor" %>' name="emailVerificationBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_VERIFICATION_BODY + "--" %>' type="hidden" value="<%= adminEmailPasswordResetBody %>" />
			</aui:field-wrapper>

			<div class="terms email-verification definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailPasswordSentSubject" message="please-enter-a-valid-subject" />

			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_SUBJECT + "--" %>' type="text" value="<%= adminEmailPasswordSentSubject %>" />

			<liferay-ui:error key="emailPasswordSentBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper label="body">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailPasswordSentBodyEditor" %>' name="emailPasswordSentBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_BODY + "--" %>' type="hidden" value="<%= adminEmailPasswordSentBody %>" />
			</aui:field-wrapper>

			<div class="terms email-password-sent definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailPasswordResetSubject" message="please-enter-a-valid-subject" />

			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_SUBJECT + "--" %>' type="text" value="<%= adminEmailPasswordResetSubject %>" />

			<liferay-ui:error key="emailPasswordResetBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper label="body">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailPasswordResetBodyEditor" %>' name="emailPasswordResetBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_BODY + "--" %>' type="hidden" value="<%= adminEmailPasswordResetBody %>" />
			</aui:field-wrapper>

			<div class="terms email-password-sent definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailForgotIdSubject" message="please-enter-a-valid-subject" />

			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + EDISON_FORGOT_ID_SUBJECT + "--" %>' type="text" value="<%= adminForgotIdSubject%>" />

			<liferay-ui:error key="emailForgotIdBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper label="body">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initForgotIdBody" %>' name="emailForgotIdBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + EDISON_FORGOT_ID_BODY  + "--" %>' type="hidden" value="<%= adminForgotIdBody%>" />
			</aui:field-wrapper>

			<div class="terms email-developer-request definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailLabRequestSubject" message="please-enter-a-valid-subject" />

			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + EDISON_ADMIN_EMAIL_LAB_REQUEST_SUBJECT + "--" %>' type="text" value="<%= adminEmailLabRequestSubject %>" />

			<liferay-ui:error key="emailLabRequestBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper label="body">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailLabRequestBody" %>' name="emailLabRequestBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + EDISON_ADMIN_EMAIL_LAB_REQUEST_BODY  + "--" %>' type="hidden" value="<%= adminEmailLabRequestBody %>" />
			</aui:field-wrapper>

			<div class="terms email-developer-request definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailWorkspaceRequestSubject" message="please-enter-a-valid-subject" />

			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_SUBJECT + "--" %>' type="text" value="<%= adminEmailWorkspaceRequestSubject %>" />

			<liferay-ui:error key="emailWorkspaceRequestBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper label="body">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailWorkspaceRequestBody" %>' name="emailWorkspaceRequestBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_BODY + "--" %>' type="hidden" value="<%= adminEmailWorkspaceRequestBody %>" />
			</aui:field-wrapper>

			<div class="terms email-developer-request definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailLabConfirmSubject" message="please-enter-a-valid-subject" />


			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + EDISON_ADMIN_EMAIL_LAB_CONFIRM_SUBJECT + "--" %>' type="text" value="<%= adminEmailLabConfirmSubject %>" />
			<liferay-ui:error key="emailLabConfirmBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper label="body">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailLabConfirmBody" %>' name="emailLabConfirmBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + EDISON_ADMIN_EMAIL_LAB_CONFIRM_BODY + "--" %>' type="hidden" value="<%= adminEmailLabConfirmBody %>" />
			</aui:field-wrapper>

			<div class="terms email-developer-request definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailWorkspaceConfirmSubject" message="please-enter-a-valid-subject" />

			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_SUBJECT + "--" %>' type="text" value="<%= adminEmailWorkspaceConfirmSubject%>" />

			<liferay-ui:error key="emailWorkspaceConfirmBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper label="body">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailWorkspaceConfirmBody" %>' name="emailWorkspaceConfirmBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_BODY + "--" %>' type="hidden" value="<%= adminEmailWorkspaceConfirmBody %>" />
			</aui:field-wrapper>

			<div class="terms email-developer-request definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:fieldset>
			<liferay-ui:error key="emailErrorReportSubject" message="please-enter-a-valid-subject" />

			<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "settings--" + EDISON_ADMIN_ERROR_REPORT_SUBJECT + "--" %>' type="text" value="<%= adminErrorReportSubject %>" />

			<liferay-ui:error key="emailErrorReportBody" message="please-enter-a-valid-body" />

			<aui:field-wrapper label="body">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" initMethod='<%= "initEmailErrorReportBody" %>' name="emailErrorReportBody" toolbarSet="email" width="470" />

				<aui:input name='<%= "settings--" + EDISON_ADMIN_ERROR_REPORT_BODY + "--" %>' type="hidden" value="<%= adminErrorReportBody %>" />
			</aui:field-wrapper>

			<div class="terms email-developer-request definition-of-terms">
				<%@ include file="/html/portlet/portal_settings/definition_of_terms.jspf" %>
			</div>
		</aui:fieldset>
	</liferay-ui:section>
</liferay-ui:tabs>

<aui:script>
	function <portlet:namespace />initEmailUserAddedBodyEditor() {
		return "<%= UnicodeFormatter.toString(adminEmailUserAddedBody) %>";
	}

	function <portlet:namespace />initEmailUserAddedNoPasswordBodyEditor() {
		return "<%= UnicodeFormatter.toString(adminEmailUserAddedNoPasswordBody) %>";
	}

	function <portlet:namespace />initEmailPasswordSentBodyEditor() {
		return "<%= UnicodeFormatter.toString(adminEmailPasswordSentBody) %>";
	}

	function <portlet:namespace />initEmailPasswordResetBodyEditor() {
		return "<%= UnicodeFormatter.toString(adminEmailPasswordResetBody) %>";
	}

	function <portlet:namespace />initEmailVerificationBodyEditor() {
		return "<%= UnicodeFormatter.toString(adminEmailVerificationBody) %>";
	}
	
	
	
	function <portlet:namespace />initForgotIdBody() {
		return "<%= UnicodeFormatter.toString(adminForgotIdBody ) %>";
	}
	
	function <portlet:namespace />initEmailLabConfirmBody() {
		return "<%= UnicodeFormatter.toString(adminEmailLabConfirmBody) %>";
	}
	
	function <portlet:namespace />initEmailLabRequestBody() {
		return "<%= UnicodeFormatter.toString(adminEmailLabRequestBody) %>";
	}
	
	function <portlet:namespace />initEmailWorkspaceConfirmBody() {
		return "<%= UnicodeFormatter.toString(adminEmailWorkspaceConfirmBody) %>";
	}
	
	function <portlet:namespace />initEmailWorkspaceRequestBody() {
		return "<%= UnicodeFormatter.toString(adminEmailWorkspaceRequestBody) %>";
	}
	
	function <portlet:namespace />initEmailErrorReportBody() {
		return "<%= UnicodeFormatter.toString(adminErrorReportBody) %>";
	}
	
	
	

	function <portlet:namespace />saveEmails() {
		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_USER_ADDED_BODY %>--'].value = window['<portlet:namespace />emailUserAddedBody'].getHTML();
		}
		catch (e) {
		}

		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_USER_ADDED_NO_PASSWORD_BODY %>--'].value = window['<portlet:namespace />emailUserAddedNoPasswordBody'].getHTML();
		}
		catch (e) {
		}

		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_BODY %>--'].value = window['<portlet:namespace />emailPasswordSentBody'].getHTML();
		}
		catch (e) {
		}

		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_BODY %>--'].value = window['<portlet:namespace />emailPasswordResetBody'].getHTML();
		}
		catch (e) {
		}

		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.ADMIN_EMAIL_VERIFICATION_BODY %>--'].value = window['<portlet:namespace />emailVerificationBody'].getHTML();
		}
		catch (e) {
		}
		
		
		
		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= EDISON_FORGOT_ID_BODY %>--'].value = window['<portlet:namespace />emailForgotIdBody'].getHTML();
		}
		catch (e) {
		}
		
		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= EDISON_ADMIN_EMAIL_LAB_REQUEST_BODY %>--'].value = window['<portlet:namespace />emailLabRequestBody'].getHTML();
		}
		catch (e) {
		}
		
		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_BODY %>--'].value = window['<portlet:namespace />emailWorkspaceRequestBody'].getHTML();
		}
		catch (e) {
		}
		
		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= EDISON_ADMIN_EMAIL_LAB_CONFIRM_BODY %>--'].value = window['<portlet:namespace />emailLabConfirmBody'].getHTML();
		}
		catch (e) {
		}
		
		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_BODY %>--'].value = window['<portlet:namespace />emailWorkspaceConfirmBody'].getHTML();
		}
		catch (e) {
		}
		
		try {
			document.<portlet:namespace />fm['<portlet:namespace />settings--<%= EDISON_ADMIN_ERROR_REPORT_BODY %>--'].value = window['<portlet:namespace />emailErrorReportBody'].getHTML();
		}
		catch (e) {
		}
	}
</aui:script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.portal_settings.email_notifications.jsp";
%>