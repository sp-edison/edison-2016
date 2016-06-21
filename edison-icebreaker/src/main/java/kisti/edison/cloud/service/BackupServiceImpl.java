/**
 * 
 */
package kisti.edison.cloud.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kisti.edison.cloud.dao.ClusterDAO;
import kisti.edison.cloud.dao.RoleDAO;
import kisti.edison.cloud.dao.UserDAO;
import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.model.User.UserState;
import kisti.edison.cloud.util.AuthUtils;

/**
 * @author junglok
 *
 */
@Transactional
@Service("backupService")
public class BackupServiceImpl implements BackupService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private ClusterDAO clusterDAO;

	public ClusterDAO getClusterDAO() {
		return clusterDAO;
	}
	
	@Autowired
	public void setClusterDAO(ClusterDAO clusterDAO) {
		this.clusterDAO = clusterDAO;
	}

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	@Resource(name = "backupQueue")
	private BlockingQueue<Command<User>> backupQueue;
	
	
	private String getBackupDirectory(String userId) {
		/*		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfm = new SimpleDateFormat("MM");
		SimpleDateFormat sdfd = new SimpleDateFormat("dd");
		String dir = Cloud.getInstance().getProp("backup.basedir") + "/" + 
					sdfy.format(now.getTime()) + "/" + sdfm.format(now.getTime()) + 
					"/" + sdfd.format(now.getTime()) + "/" + userId  + "/";
		 */
		
		String dir = Cloud.getInstance().getProp("backup.basedir") + "/" + userId  + "/";
		if (!(new File(dir)).exists()) {
			LOG.info("creating " + dir);
			(new File(dir)).mkdirs();
		}
		return dir;
	}
	/* (non-Javadoc)
	 * @see kisti.edison.cloud.service.BackupService#backupUserData(kisti.edison.cloud.model.User)
	 */
	@Override
	public User backupUserData(User user, boolean bh) {
		// TODO Auto-generated method stub
		if(!bh) {
			User pu = userDAO.updateState(null, user.getId(), UserState.DEACTIVATING);
			this.notifyToWorker(new Command<User>("ADD", pu));
			return pu;
		}
		else {
			String backupBase = getBackupDirectory(user.getUserId());
			List<Cluster> clusters = clusterDAO.getClusters(null);
			for(Cluster c : clusters) {
//				String source = c.getBaseDir() + Cloud.getInstance().getProp("data.basedir") + "/" + user.getUserId();
				String source = c.getBaseDir() + user.getStorageSource();
				String dest = backupBase + c.getName();
				LOG.info("source directory: " + source);
				LOG.info("destination directory: " + dest);
				if ((new File(source)).exists()) {
					if (!(new File(dest)).exists()) {
						LOG.info("creating destination directory:" + dest);
						(new File(dest)).mkdirs();
					}
					boolean r1 = AuthUtils.moveDir(source+"/jobs", backupBase + c.getName());
					boolean r2 = AuthUtils.moveDir(source+"/repository", backupBase + c.getName());
					
					if(r1 == true && r2 == true) {
						String cmd = "rm -rf " + source;
						try {
							LOG.info(cmd);
							Process p = Runtime.getRuntime().exec(cmd);
							p.waitFor();
							p.getInputStream().close();
							p.getOutputStream().close();
							p.getErrorStream().close();
							LOG.info("Exit Value : " + p.exitValue());
						} catch (IOException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			User pu = null;
			pu = userDAO.updateStoragePath(null, user.getId(), backupBase);
			pu = userDAO.updateState(null, user.getId(), UserState.DEACTIVATED);
			this.notifyToWorker(new Command<User>("DELETE", pu));
			return pu;
		}
	}

	public void notifyToWorker(Command<User> cmd) {
		try {
			backupQueue.put(cmd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
