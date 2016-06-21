/**
 * 
 */
package kisti.edison.cloud.service;

import kisti.edison.cloud.model.User;

/**
 * @author junglok
 *
 */
public interface BackupService {
	
	public User backupUserData(User user, boolean bh);
	
}
