package org.kisti.edison.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.util.CustomUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceWrapper;

public class EdisonUserLocalService extends UserLocalServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portal.service.UserLocalServiceWrapper#UserLocalServiceWrapper(UserLocalService userLocalService)
	 */
	public EdisonUserLocalService(UserLocalService userLocalService) {
		super(userLocalService);
	}
	
	
	@Override
	public com.liferay.portal.model.User addUserWithWorkflow(
			long creatorUserId, long companyId, boolean autoPassword,
			java.lang.String password1, java.lang.String password2,
			boolean autoScreenName, java.lang.String screenName,
			java.lang.String emailAddress, long facebookId,
			java.lang.String openId, java.util.Locale locale,
			java.lang.String firstName, java.lang.String middleName,
			java.lang.String lastName, int prefixId, int suffixId, boolean male,
			int birthdayMonth, int birthdayDay, int birthdayYear,
			java.lang.String jobTitle, long[] groupIds, long[] organizationIds,
			long[] roleIds, long[] userGroupIds, boolean sendEmail,
			com.liferay.portal.service.ServiceContext serviceContext) throws PortalException, SystemException{
		
		User user = super.addUserWithWorkflow(creatorUserId, companyId,
				autoPassword, password1, password2, autoScreenName, screenName,
				emailAddress, facebookId, openId, locale, firstName, middleName,
				lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
				birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
				userGroupIds, sendEmail, serviceContext);
		
		/**************************************************************************
		* EDIT GPLUS
		* 1.UPDATE AgreedToTermsOfUse
		* 2.User Expando -> edisonTermsOfUseDate UPDATE DATE
		* 3.SITE GROUP 가입
		* 4.Project 선택시 PROJECT_RESEARCHER 권한 추가
		***************************************************************************/
		UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), true);
		
		
		
		
		user.getExpandoBridge().setAttribute(EdisonExpando.USER_TERMS_OF_USE_DATE, new Date());

		
		
		Group parentGroup = GroupLocalServiceUtil.getGroup(user.getCompanyId(), GroupConstants.GUEST);
		List<Group> childGroups = GroupLocalServiceUtil.getGroups(user.getCompanyId(),parentGroup.getGroupId(),true);
		
		Set<Long> groupIdsSet = new HashSet<Long>();
		
		for(Group childGroup : childGroups){
			String parameterGroupId = CustomUtil.strNull(serviceContext.getAttribute("join_site_id_"+childGroup.getGroupId()+"Checkbox"));
			if(!parameterGroupId.equals("")){
				groupIdsSet.add(childGroup.getGroupId());
			}
		}
		
		long[] joinGroupIds = ArrayUtil.toArray(
				groupIdsSet.toArray(new Long[groupIdsSet.size()]));
		
		GroupLocalServiceUtil.addUserGroups(user.getUserId(), joinGroupIds);
		
		//add SITE_MEMBER
		Role siteMemberRole = RoleLocalServiceUtil.getRole(companyId, RoleConstants.SITE_MEMBER);
		for(long groupId: joinGroupIds){
			UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), groupId, new long[] {siteMemberRole.getRoleId()});
		}
		
		return user;
	}

}