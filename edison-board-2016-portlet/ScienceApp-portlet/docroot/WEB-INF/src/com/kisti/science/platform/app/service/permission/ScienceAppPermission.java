package com.kisti.science.platform.app.service.permission;

import com.kisti.science.platform.app.model.ScienceApp;
import com.kisti.science.platform.app.service.ScienceAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

// TODO: Auto-generated Javadoc
/**
 * The Class ScienceAppPermission.
 */
public class ScienceAppPermission {
	 
 	/**
 	 * Check.
 	 *
 	 * @param permissionChecker the permission checker
 	 * @param scienceAppId the science app id
 	 * @param actionId the action id
 	 * @throws PortalException the portal exception
 	 * @throws SystemException the system exception
 	 */
 	public static void check(
			 PermissionChecker permissionChecker,
			 long scienceAppId, 
			 String actionId) throws PortalException, SystemException {

		 if (!contains(permissionChecker, scienceAppId, actionId)) {
			 throw new PrincipalException();
		 }
	 }

	 /**
 	 * Contains.
 	 *
 	 * @param permissionChecker the permission checker
 	 * @param scienceAppId the science app id
 	 * @param actionId the action id
 	 * @return true, if successful
 	 * @throws PortalException the portal exception
 	 * @throws SystemException the system exception
 	 */
 	public static boolean contains(
			 PermissionChecker permissionChecker,
			 long scienceAppId, 
			 String actionId) throws PortalException, SystemException {

		 ScienceApp scienceApp = ScienceAppLocalServiceUtil.getScienceApp(scienceAppId);

		 return permissionChecker.hasPermission(
				 scienceApp.getGroupId(),
				 ScienceApp.class.getName(), 
				 scienceApp.getScienceAppId(),
				 actionId);
	 }
	 
	 /**
 	 * Contains.
 	 *
 	 * @param permissionChecker the permission checker
 	 * @param scienceApp the science app
 	 * @param actionId the action id
 	 * @return true, if successful
 	 * @throws PortalException the portal exception
 	 * @throws SystemException the system exception
 	 */
 	public static boolean contains(
			 PermissionChecker permissionChecker,
			 ScienceApp scienceApp, 
			 String actionId) throws PortalException, SystemException {

		 return permissionChecker.hasPermission(
				 scienceApp.getGroupId(),
				 ScienceApp.class.getName(), 
				 scienceApp.getScienceAppId(),
				 actionId);
	 }
}
