package org.kisti.edison.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonRoleConstants;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.model.Website;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.announcements.model.AnnouncementsDelivery;
import com.liferay.portlet.announcements.service.AnnouncementsDeliveryLocalServiceUtil;
import com.liferay.portlet.usersadmin.util.UsersAdminUtil;

public final class EdisonTempUserUtil {
	public static User addUser(ResourceRequest actionRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		boolean autoPassword = false;
		String password1 = actionRequest.getParameter("userPassword");
		String password2 = actionRequest.getParameter("userPassword");

		String reminderQueryQuestion = ParamUtil.getString(actionRequest, "reminderQueryQuestion");

		if (reminderQueryQuestion.equals(UsersAdminUtil.CUSTOM_QUESTION)) {
			reminderQueryQuestion = ParamUtil.getString(actionRequest, "reminderQueryCustomQuestion");
		}
		
		String reminderQueryAnswer = ParamUtil.getString(actionRequest, "reminderQueryAnswer");
		boolean autoScreenName = ParamUtil.getBoolean(actionRequest, "autoScreenName");
		String screenName = ParamUtil.getString(actionRequest, "userScreenName");
		String emailAddress = screenName+"@mail.com";
		long facebookId = 0;
		String openId = ParamUtil.getString(actionRequest, "openId");
		String languageId = ParamUtil.getString(actionRequest, "languageId");
		String timeZoneId = ParamUtil.getString(actionRequest, "timeZoneId");
		String greeting = ParamUtil.getString(actionRequest, "greeting");
		String firstName = ParamUtil.getString(actionRequest, "userName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		int prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
		int suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 2013;
		String comments = ParamUtil.getString(actionRequest, "comments");
		String smsSn = ParamUtil.getString(actionRequest, "smsSn");
		String aimSn = ParamUtil.getString(actionRequest, "aimSn");
		String facebookSn = ParamUtil.getString(actionRequest, "facebookSn");
		String icqSn = ParamUtil.getString(actionRequest, "icqSn");
		String jabberSn = ParamUtil.getString(actionRequest, "jabberSn");
		String msnSn = ParamUtil.getString(actionRequest, "msnSn");
		String mySpaceSn = ParamUtil.getString(actionRequest, "mySpaceSn");
		String skypeSn = ParamUtil.getString(actionRequest, "skypeSn");
		String twitterSn = ParamUtil.getString(actionRequest, "twitterSn");
		String ymSn = ParamUtil.getString(actionRequest, "ymSn");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = { RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), EdisonRoleConstants.STUDENT).getRoleId()
				, RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), EdisonRoleConstants.USER).getRoleId()};
		long[] userGroupIds = null;
		
		User adminUser  = (User) PortalUtil.getHttpServletRequest(actionRequest).getAttribute(WebKeys.USER);
		
		List<Address> addresses = adminUser.getAddresses();
		List<EmailAddress> emailAddresses = adminUser.getEmailAddresses();
		List<Phone> phones = adminUser.getPhones();
		List<Website> websites = adminUser.getWebsites();
		
		List<AnnouncementsDelivery> announcementsDeliveries = AnnouncementsDeliveryLocalServiceUtil.getUserDeliveries(adminUser.getUserId());
		boolean sendEmail = false;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

		User user = UserServiceUtil.addUser(
			themeDisplay.getCompanyId(), autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			LocaleUtil.getDefault(), firstName, middleName, lastName, prefixId,
			suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
			groupIds, organizationIds, roleIds, userGroupIds, addresses,
			emailAddresses, phones, websites, announcementsDeliveries,
			sendEmail, serviceContext);
		
		//KD 추가 - USER ADD 후에 Status 상태를 activate 상태로 변경 0 - activate 5 - deactivate (default)
		UserServiceUtil.updateStatus(user.getUserId(), 0, serviceContext);
		
		if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_LAB_ID)) user.getExpandoBridge().setAttribute(EdisonExpando.USER_LAB_ID,ParamUtil.getString(actionRequest, "virtualLabId"));
		if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_CLASS_ID)) user.getExpandoBridge().setAttribute(EdisonExpando.USER_CLASS_ID,ParamUtil.getString(actionRequest, "classId"));
		if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_UNIVERSITY)) user.getExpandoBridge().setAttribute(EdisonExpando.USER_UNIVERSITY,ParamUtil.getString(actionRequest, EdisonExpando.USER_UNIVERSITY));
		if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VISIT_SITE)) user.getExpandoBridge().setAttribute(EdisonExpando.USER_VISIT_SITE,ParamUtil.getString(actionRequest, EdisonExpando.USER_VISIT_SITE));
		
		UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), true);
		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);
		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);
		
		return user;
	}
    
    public static User addUser(ResourceRequest actionRequest, Map userTemp) throws Exception {
    	ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);    	    	
    	
    	boolean autoPassword = false;
    	String password1 = (String) userTemp.get("userScreenName");
    	String password2 = (String) userTemp.get("userScreenName");
    	String screenName = (String) userTemp.get("userScreenName");
    	
    	String reminderQueryQuestion = ParamUtil.getString(
    			actionRequest, "reminderQueryQuestion");
    	
    	if (reminderQueryQuestion.equals(UsersAdminUtil.CUSTOM_QUESTION)) {
    		reminderQueryQuestion = ParamUtil.getString(
    				actionRequest, "reminderQueryCustomQuestion");
    	}
    	
    	String reminderQueryAnswer = ParamUtil.getString(
    			actionRequest, "reminderQueryAnswer");
    	boolean autoScreenName = ParamUtil.getBoolean(
    			actionRequest, "autoScreenName");
    	String emailAddress = screenName+"@mail.com";
    	long facebookId = 0;
    	String openId = ParamUtil.getString(actionRequest, "openId");   
    	String firstName = (String) userTemp.get("userName");
    	String middleName = ParamUtil.getString(actionRequest, "middleName");
    	String lastName = ParamUtil.getString(actionRequest, "lastName");
    	int prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
    	int suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
    	boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
    	int birthdayMonth = 1;
    	int birthdayDay = 1;
    	int birthdayYear = 2013;    	
    	String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
    	long[] groupIds = null;
    	long[] organizationIds = null;
    	long[] roleIds = { RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), EdisonRoleConstants.STUDENT).getRoleId()
    			, RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), EdisonRoleConstants.USER).getRoleId()};
    	long[] userGroupIds = null;		
    	
    	//User adminUser = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), "edison");
    	User adminUser  = (User) PortalUtil.getHttpServletRequest(actionRequest).getAttribute(WebKeys.USER);
    	List<Address> addresses = adminUser.getAddresses();
    	List<EmailAddress> emailAddresses = adminUser.getEmailAddresses();
    	List<Phone> phones = adminUser.getPhones();
    	List<Website> websites = adminUser.getWebsites();
    	
    	List<AnnouncementsDelivery> announcementsDeliveries = AnnouncementsDeliveryLocalServiceUtil.getUserDeliveries(adminUser.getUserId());
    	boolean sendEmail = false;
    	ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
    	
    	User user = UserServiceUtil.addUser(
   			themeDisplay.getCompanyId(), autoPassword, password1, password2,
   			autoScreenName, screenName, emailAddress, facebookId, openId,
   			LocaleUtil.getDefault(), firstName, middleName, lastName, prefixId,
   			suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
   			groupIds, organizationIds, roleIds, userGroupIds, addresses,
   			emailAddresses, phones, websites, announcementsDeliveries,
   			sendEmail, serviceContext);

		if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_LAB_ID)) user.getExpandoBridge().setAttribute(EdisonExpando.USER_LAB_ID,CustomUtil.strNull(userTemp.get("virtualLabId")));
		if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_CLASS_ID)) user.getExpandoBridge().setAttribute(EdisonExpando.USER_CLASS_ID,CustomUtil.strNull(userTemp.get("classId")));
		if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_UNIVERSITY)) user.getExpandoBridge().setAttribute(EdisonExpando.USER_UNIVERSITY,CustomUtil.strNull(userTemp.get("universityField")));
		if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VISIT_SITE)) user.getExpandoBridge().setAttribute(EdisonExpando.USER_VISIT_SITE,CustomUtil.strNull(userTemp.get("groupId")));
		
    	UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), true);
    	UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);
    	UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);
    	
    	return user;
    }
	
    public static boolean deleteUser(User user) throws Exception {
		
    	//UserLocalServiceUtil.deleteUser(user);
    	UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_INACTIVE);
    	Map map = new HashMap();
    	
    	
//    	map.put("userScreenName", user.getScreenName());
//    	if(VCRegister.VCDeactivate(map) != 200){
//    		return false;
//    	}
		
		return true;
	}
    
    public static boolean deleteUserException(User user) throws Exception {
    	
    	UserLocalServiceUtil.deleteUser(user);
    	
    	Map map = new HashMap();
    	map.put("userId", user.getScreenName());
//    	if(VCRegister.VCDelete(map) != 200){
//    		return false;
//    	}
    	
    	return true;
    }
    
    public static List getListByUserExcel(Workbook wb) throws Exception {
    	String cellData = "";
    	List resultList = new ArrayList();
    	Map rowMap;
		int i = 0; //첫번째 sheet 고정
		
		int ri = 0;//엑셀에 타이틀 row가 있는경우 skip 후 처리	
		
		for( Row row : wb.getSheetAt(i) ) {//row loop
			//엑셀에 타이틀 row가 있는경우 skip 후 처리			
			if(ri < 1){
				ri++;
				continue;
			}
			rowMap = new HashMap();
			int cellNum = 0;
			for( Cell cell : row ) {//column loop	
				
				//숫자인지 체크
				if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){	
					
					//DATE타입은 우선 NUMERIC으로 인식 하며 NUMERIC이 DATE TYPE인지 확인하여 분기처리.
					if(HSSFDateUtil.isCellDateFormatted(cell)){
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						cellData = formatter.format(cell.getDateCellValue());
					}else{
						cellData = String.valueOf((long)cell.getNumericCellValue());	
					}					
				}else if(cell.getCellType()== Cell.CELL_TYPE_FORMULA){ // 수식이면 반올림 처리 2011.07.07
					cellData = String.valueOf(Math.round(cell.getNumericCellValue()));					
				}else{
					cellData = cell.getStringCellValue();					
				}
				//row에 data insert		
				switch (cellNum) {
					case 0  : rowMap.put("seqNo", cellData); break;
                	case 1  : rowMap.put("userStudentNumber", cellData); break;
                	case 2  : rowMap.put("userName", cellData); break;                   
                	default : 
				}
				cellNum++;
			}//column loop
			resultList.add(rowMap);
		}//row loop
    	return resultList;
    }
}
