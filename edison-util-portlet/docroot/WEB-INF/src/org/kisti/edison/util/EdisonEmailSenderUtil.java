package org.kisti.edison.util;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.exception.EdisonException;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonPropskeys;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.util.PwdGenerator;

public class EdisonEmailSenderUtil {
	private static Log _log = LogFactoryUtil.getLog(EdisonEmailSenderUtil.class);
	
	/**
	 * workspace 요청
	 * @param renderRequest
	 * @param requestUserId - workspace 요청자 ID
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailWorkspaceRequestSubmit(RenderRequest renderRequest,Long requestUserId){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		return requestEmailSubmit("workspace",request,requestUserId);
	}
	
	/**
	 * workspace 요청
	 * @param actionRequest
	 * @param requestUserId - workspace 요청자 ID
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailWorkspaceRequestSubmit(ActionRequest actionRequest,Long requestUserId){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		return requestEmailSubmit("workspace",request,requestUserId);
	}
	
	/**
	 * workspace 요청
	 * @param servletRequest
	 * @param requestUserId - workspace 요청자 ID
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailWorkspaceRequestSubmit(HttpServletRequest servletRequest,Long requestUserId){
		return requestEmailSubmit("workspace",servletRequest,requestUserId);
	}
	
	/**
	 * VirtualLab 요청
	 * @param renderRequest
	 * @param requestUserId - VirtualLab 요청자 ID
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailVirtualLabRequestSubmit(RenderRequest renderRequest,Long requestUserId){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		return requestEmailSubmit("virtuallab",request,requestUserId);
	}
	
	/**
	 * VirtualLab 요청
	 * @param actionRequest
	 * @param requestUserId - VirtualLab 요청자 ID
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailVirtualLabRequestSubmit(ActionRequest actionRequest,Long requestUserId){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		return requestEmailSubmit("virtuallab",request,requestUserId);
	}
	
	/**
	 * VirtualLab 요청
	 * @param servletRequest
	 * @param requestUserId - VirtualLab 요청자 ID
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailVirtualLabRequestSubmit(HttpServletRequest servletRequest,Long requestUserId){
		return requestEmailSubmit("virtuallab",servletRequest,requestUserId);
	}
	
	/**
	 * workspace 처리 내역 관련
	 * @param renderRequest
	 * @param adminUserId - 처리한 유저 Admin ID
	 * @param confirmUserId - 처리 결과를 전송할 User ID
	 * @param message - 처리 Message
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailWorkspaceConfirmtSubmit(RenderRequest renderRequest,Long adminUserId,Long confirmUserId,String message){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		return confirmEmailSubmit("workspace",request,adminUserId,confirmUserId,message);
	}
	
	/**
	 * workspace 처리 내역 관련
	 * @param actionRequest
	 * @param adminUserId - 처리한 유저 Admin ID
	 * @param confirmUserId - 처리 결과를 전송할 User ID
	 * @param message - 처리 Message
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailWorkspaceConfirmtSubmit(ActionRequest actionRequest,Long adminUserId,Long confirmUserId,String message){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		return confirmEmailSubmit("workspace",request,adminUserId,confirmUserId,message);
	}
	
	/**
	 * workspace 처리 내역 관련
	 * @param servletRequest
	 * @param adminUserId - 처리한 유저 Admin ID
	 * @param confirmUserId - 처리 결과를 전송할 User ID
	 * @param message - 처리 Message
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailWorkspaceConfirmtSubmit(HttpServletRequest servletRequest,Long adminUserId,Long confirmUserId,String message){
		return confirmEmailSubmit("workspace",servletRequest,adminUserId,confirmUserId,message);
	}
	
	/**
	 * VirtualLab 처리 내역 관련
	 * @param renderRequest
	 * @param adminUserId - 처리한 유저 Admin ID
	 * @param confirmUserId - 처리 결과를 전송할 User ID
	 * @param message - 처리 Message
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailVirtualLabConfirmSubmit(RenderRequest renderRequest,Long adminUserId,Long confirmUserId,String message){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		return confirmEmailSubmit("virtuallab",request,adminUserId,confirmUserId,message);
	}
	
	/**
	 * VirtualLab 처리 내역 관련
	 * @param actionRequest
	 * @param adminUserId - 처리한 유저 Admin ID
	 * @param confirmUserId - 처리 결과를 전송할 User ID
	 * @param message - 처리 Message
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailVirtualLabConfirmSubmit(ActionRequest actionRequest,Long adminUserId,Long confirmUserId,String message){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		return confirmEmailSubmit("virtuallab",request,adminUserId,confirmUserId,message);
	}
	/**
	 * VirtualLab 처리 내역 관련
	 * @param servletRequest
	 * @param adminUserId - 처리한 유저 Admin ID
	 * @param confirmUserId - 처리 결과를 전송할 User ID
	 * @param message - 처리 Message
	 * @return 전송완료:true, 전송실패:false
	 */
	public static boolean emailVirtualLabConfirmSubmit(HttpServletRequest servletRequest,Long adminUserId,Long confirmUserId,String message){
		return confirmEmailSubmit("virtuallab",servletRequest,adminUserId,confirmUserId,message);
	}
	
	/**
	 * Error 결과 Report
	 * @param renderRequest
	 * @param exception
	 */
	public static void errorReportSubmit(RenderRequest renderRequest,Exception exception,String portletNameSpace){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		errorReportMailSubmit(request, exception, portletNameSpace, true);
	}
	
	public static void errorReportSubmit(ActionRequest actionRequest,Exception exception,String portletNameSpace){
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		errorReportMailSubmit(request, exception, portletNameSpace, true);
	}
	
	public static void errorReportSubmit(HttpServletRequest servletRequest,Exception exception,String portletNameSpace){
		errorReportMailSubmit(servletRequest, exception, portletNameSpace, true);
	}
	
	/**
	 * 요청 이메일 전송
	 * @param type
	 * @param request
	 * @param requestUserId
	 * @return
	 */
	public static boolean requestEmailSubmit(String type,HttpServletRequest request,Long requestUserId){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		
			long groupId = PortalUtil.getScopeGroupId(request);
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			String siteName = group.getName();
			
			long companyId = themeDisplay.getCompanyId();
			Role role = RoleLocalServiceUtil.getRole(companyId, RoleConstants.SITE_ADMINISTRATOR);
			List<com.liferay.portal.model.UserGroupRole> userGroupRoleList = UserGroupRoleLocalServiceUtil.getUserGroupRolesByGroupAndRole(groupId, role.getRoleId());
			
			User requestUser = UserLocalServiceUtil.getUser(requestUserId);
			String fromName = requestUser.getFullName();
			String fromAddress = requestUser.getEmailAddress();
			String requestUserOrg = EdisonExpndoUtil.getCommonCdSearchFieldValue(requestUser.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY), 
					EdisonExpando.CDNM, themeDisplay.getLocale());
			
			if(userGroupRoleList.size()==0){
				Exception edisonExcetion = new EdisonException(EdisonException.SITE_ADMINISTRATOR_NOT_EXIST);
				throw edisonExcetion;
			}
			
			String subject = "";
			String body = "";
			if(type.equals("workspace")){
				subject = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_SUBJECT);
				body = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_BODY);
			}else if(type.equals("virtuallab")){
				subject = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_REQUEST_SUBJECT);
				body = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_REQUEST_BODY);
			}
			
			for(UserGroupRole userGroupRole: userGroupRoleList){
				User siteAdminUser = userGroupRole.getUser();
				String toName = siteAdminUser.getFullName();
				String toAddress = siteAdminUser.getEmailAddress();
				
				SubscriptionSender subscriptionSender = new SubscriptionSender();
				subscriptionSender.setBody(body);
				subscriptionSender.setCompanyId(companyId);
				subscriptionSender.setContextAttributes(
					"[$GROUP_SITE_NAME$]", siteName,
					"[$USER_SCREENNAME$]", requestUser.getScreenName(),
					"[$USER_ORG$]", requestUserOrg,
					"[$REMOTE_ADDRESS$]", serviceContext.getRemoteAddr(),
					"[$REMOTE_HOST$]", serviceContext.getRemoteHost()
				);
				subscriptionSender.setFrom(fromAddress, fromName);
				subscriptionSender.setHtmlFormat(true);
				subscriptionSender.setMailId("user", requestUser.getUserId(), System.currentTimeMillis(),PwdGenerator.getPassword());
				subscriptionSender.setServiceContext(serviceContext);
				subscriptionSender.setSubject(subject);
				subscriptionSender.setUserId(requestUser.getUserId());

				subscriptionSender.addRuntimeSubscribers(toAddress, toName);

				subscriptionSender.flushNotificationsAsync();
			}
			return true;
		} catch (Exception e) {
			if(e instanceof EdisonException){
				e.printStackTrace();
				_log.error(LanguageUtil.get(themeDisplay.getLocale(), "edison-error-site-adminostrator-not-exists"));
			}else{
				e.printStackTrace();
				_log.error(e.getMessage());
			}
			return false;
		}
	}
	
	
	/**
	 * 처리 내역 Method
	 * @param type
	 * @param request
	 * @param adminUserId
	 * @param confirmUserId
	 * @param message
	 * @return
	 */
	public static boolean confirmEmailSubmit(String type,HttpServletRequest request,Long adminUserId,Long confirmUserId,String message){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			String siteName = group.getName();
			
			long companyId = themeDisplay.getCompanyId();
			User confirmUser = UserLocalServiceUtil.getUser(confirmUserId);
			User adminUser = UserLocalServiceUtil.getUser(adminUserId);
			
			String fromName = adminUser.getFullName();
			String fromAddress = adminUser.getEmailAddress();
			
			String toName = confirmUser.getFullName();
			String toAddress = confirmUser.getEmailAddress();
			
			String subject = "";
			String body = "";
			if(type.equals("workspace")){
				subject = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_SUBJECT);
				body = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_BODY);
			}else if(type.equals("virtuallab")){
				subject = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_CONFIRM_SUBJECT);
				body = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_CONFIRM_BODY);
			}
			
			SubscriptionSender subscriptionSender = new SubscriptionSender();
			
			subscriptionSender.setBody(body);
			subscriptionSender.setCompanyId(companyId);
			subscriptionSender.setContextAttributes(
				"[$GROUP_SITE_NAME$]", siteName,
				"[$PROCESSNOTE$]", message,
				"[$REMOTE_ADDRESS$]", serviceContext.getRemoteAddr(),
				"[$REMOTE_HOST$]", serviceContext.getRemoteHost(), 
				"[$USER_ID$]",confirmUser.getUserId()
			);
			subscriptionSender.setFrom(fromAddress, fromName);
			subscriptionSender.setHtmlFormat(true);
			subscriptionSender.setMailId("user", adminUser.getUserId());
			subscriptionSender.setServiceContext(serviceContext);
			subscriptionSender.setSubject(subject);
			subscriptionSender.setUserId(adminUser.getUserId());

			subscriptionSender.addRuntimeSubscribers(toAddress, toName);

			subscriptionSender.flushNotificationsAsync();
			return true;
			
		} catch (Exception e){
				e.printStackTrace();
				_log.error(e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * Error Report Submit
	 * @param request
	 * @param exception
	 * @param submit
	 */
	public static void errorReportMailSubmit(HttpServletRequest request, Exception exception, String portletNameSpace, boolean submit){
		if(submit){
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
			try{
				ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
				long companyId = themeDisplay.getCompanyId();
				String name = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);
				String address = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
				
				
				String subject = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_ERROR_REPORT_SUBJECT);
				String body = PrefsPropsUtil.getContent(companyId, EdisonPropskeys.EDISON_ADMIN_ERROR_REPORT_BODY);
				
				Role role = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
				List<com.liferay.portal.model.User> userList = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
				
//				StringWriter exceptionStr = new StringWriter();
//				exception.printStackTrace(new PrintWriter(exceptionStr));
				String exceptionStr="Exception=>"+exception;
				exceptionStr +="   portlet=>"+portletNameSpace;
				for(User adminUser : userList){
					_log.debug("TO---ADMIN-ADDRESS-->"+adminUser.getEmailAddress());
					SubscriptionSender subscriptionSender = new SubscriptionSender();

					subscriptionSender.setBody(body);
					subscriptionSender.setCompanyId(companyId);
					subscriptionSender.setContextAttributes(
						"[$ERROR_MESSAGE$]", exceptionStr,
						"[$REMOTE_ADDRESS$]", serviceContext.getRemoteAddr(),
						"[$REMOTE_HOST$]", serviceContext.getRemoteHost() 
					);
					subscriptionSender.setFrom(address,name);
					subscriptionSender.setHtmlFormat(true);
					subscriptionSender.setMailId("user", adminUser.getUserId());
					subscriptionSender.setServiceContext(serviceContext);
					subscriptionSender.setSubject(subject);
					subscriptionSender.setUserId(adminUser.getUserId());
					subscriptionSender.addRuntimeSubscribers(adminUser.getEmailAddress(),name);

					subscriptionSender.flushNotificationsAsync();
				}
			}catch(Exception e){
				e.printStackTrace();
				_log.error(e.getMessage());
			}
		}
	}
}
