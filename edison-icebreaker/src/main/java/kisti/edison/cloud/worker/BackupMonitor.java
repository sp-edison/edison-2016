/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.service.BackupService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author junglok
 *
 */
@Component
public class BackupMonitor {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private Map<Long, User> mUsers = new HashMap<Long, User>();
	
	private BackupTasks backupTasks;

	public BackupTasks getBackupTasks() {
		return backupTasks;
	}
	
	@Autowired
	public void setBackupTasks(BackupTasks backupTasks) {
		this.backupTasks = backupTasks;
	}
	
	@Resource(name = "backupQueue")
	private BlockingQueue<Command<User>> backupQueue;

	public BlockingQueue<Command<User>> getBackupQueue() {
		return backupQueue;
	}

	public void setBackupQueue(BlockingQueue<Command<User>> backupQueue) {
		this.backupQueue = backupQueue;
	}
	
	private BackupService backupService;
	public BackupService getBackupService() {
		return backupService;
	}
	@Autowired
	public void setBackupService(BackupService backupService) {
		this.backupService = backupService;
	}
	
	public void dispatchTasks() {
		try {
			while (backupQueue.size() != 0) {
				Command<User> cmd = backupQueue.take();
				if (cmd.getType() == "ADD") {
					mUsers.put(cmd.getData().getId(), cmd.getData());
				} 
				else if (cmd.getType() == "DELETE") {
					mUsers.remove(cmd.getData().getId());
				}
			}
			
			LOG.info("BACKUP USERS (DATA) : " + mUsers.size());

			if (mUsers.size() != 0) {
				this.backupTasks.executeTasks(backupService, mUsers, 1);
			}
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}


}
