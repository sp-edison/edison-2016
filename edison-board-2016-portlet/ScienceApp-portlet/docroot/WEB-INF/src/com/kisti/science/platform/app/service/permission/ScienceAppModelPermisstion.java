package com.kisti.science.platform.app.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

// TODO: Auto-generated Javadoc
/**
 * The Class ScienceAppModelPermisstion.
 */
public class ScienceAppModelPermisstion {
	
	/** The Constant RESOURCE_NAME. */
	public static final String RESOURCE_NAME = "com.kisti.science.platform.model";

    /**
     * Check.
     *
     * @param permissionChecker the permission checker
     * @param groupId the group id
     * @param actionId the action id
     * @throws PortalException the portal exception
     */
    public static void check(
    		PermissionChecker permissionChecker, 
    		long groupId,
    		String actionId) throws PortalException {

    	if (!contains(permissionChecker, groupId, actionId)) {
    		throw new PrincipalException();
    	}
    }

    /**
     * Contains.
     *
     * @param permissionChecker the permission checker
     * @param groupId the group id
     * @param actionId the action id
     * @return true, if successful
     */
    public static boolean contains(
    		PermissionChecker permissionChecker,
            long groupId, 
            String actionId) {

        return permissionChecker.hasPermission(
        		groupId, 
        		RESOURCE_NAME, 
        		groupId,
                actionId);
    }
}
