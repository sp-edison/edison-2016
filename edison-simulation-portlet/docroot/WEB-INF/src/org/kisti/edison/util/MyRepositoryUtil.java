package org.kisti.edison.util;

import org.kisti.edison.model.EdisonRoleConstants;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class MyRepositoryUtil {
	
	/*
	 * 최상위 권한 체크
	 */
	public static String getHighestRole(long userId, long groupId) throws SystemException {
		User user = UserLocalServiceUtil.fetchUser(userId);
		if (user != null) {
			if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)) {
				return RoleConstants.ADMINISTRATOR;
			} else if (EdisonUserUtil.isRegularRole(user, RoleConstants.OWNER)) {
				return RoleConstants.OWNER;
			} else if (EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)) {
				return RoleConstants.SITE_ADMINISTRATOR;
			} else if (EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)) {
				return RoleConstants.SITE_OWNER;
			} else if (EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SOLVER_OWNER)) {
				return EdisonRoleConstants.SOLVER_OWNER;
			} else if (EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SOLVER_MANAGER)) {
				return EdisonRoleConstants.SOLVER_MANAGER;
			} else if (EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_LAB_OWNER)) {
				return EdisonRoleConstants.VIRTUAL_LAB_OWNER;
			} else if (EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER)) {
				return EdisonRoleConstants.VIRTUAL_LAB_MANAGER;
			} else if (EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER)) {
				return EdisonRoleConstants.VIRTUAL_CLASS_OWNER;
			} else if (EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER)) {
				return EdisonRoleConstants.VIRTUAL_CLASS_MANAGER;
			} else if (EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_CLASS_MEMBER)) {
				return EdisonRoleConstants.VIRTUAL_CLASS_MEMBER;
			}
		}
		return "";
	}
	
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    char pre = ("kMGTPE").charAt(exp-1);
	    return StringUtil.upperCase(String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre));
	}
}
