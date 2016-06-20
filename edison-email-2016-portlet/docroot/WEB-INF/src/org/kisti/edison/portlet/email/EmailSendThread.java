package org.kisti.edison.portlet.email;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.kisti.edison.model.SendMailContent;
import org.kisti.edison.service.SendMailContentLocalServiceUtil;
import org.kisti.edison.service.constants.EmailConstants;
import org.kisti.edison.util.CustomUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.SubscriptionSender;

public class EmailSendThread extends Thread{
	private static Log log = LogFactoryUtil.getLog(EmailSendThread.class);
	private ServiceContext serviceContext;
	private long companyId ;
	private long userId ;
	private long adminUserId ;
	private String[] siteGroups ;
	private String[] userGroups ;
	private Map params ;
	
	public EmailSendThread(Map params, ServiceContext serviceContext, long companyId, long userId, long adminUserId, String[] siteGroups, String[] userGroups) {
		this.params = params;
		this.serviceContext = serviceContext;
		this.companyId = companyId;
		this.userId = userId;
		this.adminUserId = adminUserId;
		this.siteGroups = siteGroups;
		this.userGroups = userGroups;
	}
	
	public void run(){
		
		try {
	
			User adminUser = UserLocalServiceUtil.getUser(adminUserId);
			String fromName = adminUser.getFullName();
			String fromAddress = adminUser.getEmailAddress();
			String emailSubject = CustomUtil.strNull(params.get("emailSubject"));
			String emailContent = CustomUtil.strNull(params.get("emailContent"));
			boolean insertMailContent = false;
			long sendMailId = 0;
			int sendCount = 0;
			int successCount = 0;
			int failCount = 0;
			String siteGroup = "";
			String userGroup = "";
			Vector<String> sendtEmailAdresses = new Vector<String>();
			
			if(siteGroups != null){
				for(String siteGroupId : siteGroups){
					if(!siteGroup.equals("")){
						siteGroup+=",";
					}
					siteGroup+= siteGroupId;
					
					long groupId = Long.parseLong(siteGroupId);
					List<User> siteGroupUserList = UserLocalServiceUtil.getGroupUsers(groupId);
					
					for(User siteGroupUser : siteGroupUserList){
						String emailAddress = siteGroupUser.getEmailAddress();
						if(!sendtEmailAdresses.contains(emailAddress)){
							try{
								if(insertMailContent == false){
									sendMailId = insertSendMailContent(emailSubject, emailContent, sendCount, successCount, failCount, siteGroup, userGroup);
									insertMailContent = true;
								}
								sendCount++;
								sendMail(emailSubject, emailContent, fromName, fromAddress, siteGroupUser, adminUser);
								sendtEmailAdresses.add(emailAddress);
								successCount++;
							}catch (Exception e) {
								failCount++;
							}
						}
						
					}
					
				}
			}
			
			if(userGroups != null){
				for(String userGroupId : userGroups){
					if(!userGroup.equals("")){
						userGroup+=",";
					}
					userGroup+= userGroupId;
					
					long groupId = Long.parseLong(userGroupId);
					List<User> userGroupUserList = UserLocalServiceUtil.getUserGroupUsers(groupId);

					for(User userGroupUser : userGroupUserList){
						String emailAddress = userGroupUser.getEmailAddress();
						if(!sendtEmailAdresses.contains(emailAddress)){
							try{
								if(insertMailContent == false){
									sendMailId = insertSendMailContent(emailSubject, emailContent, sendCount, successCount, failCount, siteGroup, userGroup);
									insertMailContent = true;
								}
								sendCount++;
								sendMail(emailSubject, emailContent, fromName, fromAddress, userGroupUser, adminUser);
								sendtEmailAdresses.add(emailAddress);
								successCount++;
							}catch (Exception e) {
								failCount++;
							}
						}
					}
				}
			}
			
			updateSendMailContent(sendMailId, sendCount, successCount, failCount, siteGroup, userGroup);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}
	
	public void sendMail(String emailSubject , String emailContent, String fromName, String fromAddress, User sendMailUser, User adminUser) throws SystemException{
		
		String toName = sendMailUser.getFullName();
		String toAddress = sendMailUser.getEmailAddress();
		
		SubscriptionSender subscriptionSender = new SubscriptionSender();
		subscriptionSender.setBody(emailContent);
		subscriptionSender.setCompanyId(companyId);
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setMailId("user", adminUser.getUserId());
		subscriptionSender.setServiceContext(serviceContext);
		subscriptionSender.setSubject(emailSubject);
		subscriptionSender.setUserId(adminUser.getUserId());
		subscriptionSender.addRuntimeSubscribers(toAddress, toName);
		subscriptionSender.flushNotificationsAsync();
		
		//테스트용 소스
//		System.out.println("toName : "+ toName );
//		System.out.println("toAddress : "+ toAddress );
		
	}
	
	public long insertSendMailContent(String emailSubject , String emailContent, int sendCount, int successCount, int failCount, String siteGroup, String userGroup) throws SystemException{
		
		long sendMailId= CounterLocalServiceUtil.increment(SendMailContent.class.getName());
		
		SendMailContent sendMailContent = SendMailContentLocalServiceUtil.createSendMailContent(sendMailId);
		sendMailContent.setTitle(emailSubject);
		sendMailContent.setContent(emailContent);
		sendMailContent.setState(EmailConstants.MAIL_STATE_SEND);
		sendMailContent.setSendCount(sendCount);
		sendMailContent.setSuccessCount(successCount);
		sendMailContent.setFailCount(failCount);
		sendMailContent.setUserId(userId);
		sendMailContent.setSendDate(new Date());
		if(!siteGroup.equals("")) sendMailContent.setSiteGroup(siteGroup);
		if(!userGroup.equals("")) sendMailContent.setUserGroup(userGroup);
		SendMailContentLocalServiceUtil.addSendMailContent(sendMailContent);
		
		return sendMailId;
	}
	
	public void updateSendMailContent(long sendMailId, int sendCount, int successCount, int failCount, String siteGroup, String userGroup) throws SystemException, PortalException{
		
		SendMailContent sendMailContent = SendMailContentLocalServiceUtil.getSendMailContent(sendMailId);
		sendMailContent.setState(EmailConstants.MAIL_STATE_COMPLETE);
		sendMailContent.setSendCount(sendCount);
		sendMailContent.setSuccessCount(successCount);
		sendMailContent.setSendCount(sendCount);
		sendMailContent.setFailCount(failCount);
		if(!siteGroup.equals("")) sendMailContent.setSiteGroup(siteGroup);
		if(!userGroup.equals("")) sendMailContent.setUserGroup(userGroup);
		SendMailContentLocalServiceUtil.updateSendMailContent(sendMailContent);
		
	}
		
}
