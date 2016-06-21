/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kisti.edison.cloud.model.User;
import kisti.edison.cloud.service.BackupService;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

/**
 * @author junglok
 *
 */
public class BackupTasks {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private TaskExecutor taskExecutor;

	public BackupTasks(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	
	private class BackupTask implements Runnable {
		private BackupService backupService;
		private List<User> users = new LinkedList<User>();

		public BackupTask(BackupService backupService, List<User> users) {
			this.backupService = backupService;
			for (int i = 0; i < users.size(); i++) {
				this.users.add(users.get(i));
			}
		}
		public void run() {
			for (int i = 0; i < users.size(); i++) {
				// TODO: user's data backup to backup storage
				this.backupService.backupUserData(users.get(i), true);
			}
		}
	}
	
	public void executeTasks(BackupService backupService, Map<Long, User> mUsers, int nThreads) {
		List<List<User>> userList = new LinkedList<List<User>>();

		for (int i = 0; i < nThreads; i++) {
			userList.add(new LinkedList<User>());
		}
		Iterator<Long> iter = mUsers.keySet().iterator();

		int index = 0;
		while (iter.hasNext()) {
			Long key = iter.next();
			userList.get(index).add(mUsers.get(key));
			index++;
			if (index == nThreads)
				index = 0;
		}

		int createdThreads = 0;
		for (int i = 0; i < nThreads; i++) {
			if (userList.get(i).size() != 0) {
				createdThreads++;
				taskExecutor.execute(new BackupTask(backupService, userList.get(i)));
			}
		}
	}
}
