/**
 * Copyright (c) 2012 KISTI. All rights reserved.
 * EDISON.
 * 
 * Package : kisti.edison.cloud.dao
 * File    : BootstrapData.java
 * Date    : Jan 6, 2012 2012
 *  
 */
package kisti.edison.cloud.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.env.ResourceConf;
import kisti.edison.cloud.manager.ClusterManager;
import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.HostManager;
import kisti.edison.cloud.manager.VirtualImageManager;
import kisti.edison.cloud.manager.VirtualMachineManager;
import kisti.edison.cloud.manager.VirtualNetworkManager;
import kisti.edison.cloud.manager.JobManager;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.LocalAccount;
import kisti.edison.cloud.model.Role;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.model.User.UserState;
import kisti.edison.cloud.model.VirtualImage;
import kisti.edison.cloud.model.VirtualMachine;
import kisti.edison.cloud.model.VirtualNetwork;
import kisti.edison.cloud.plugin.spec.ClusterAdapter;
import kisti.edison.cloud.plugin.spec.JobAdapter;
import kisti.edison.cloud.util.AuthUtils;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

/**
 * @author jlyu
 * 
 */
@Component
public class BootstrapDataPopulator implements ApplicationContextAware, InitializingBean {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private ApplicationContext ctx;
	
	private DataSource dataSource;
	private SessionFactory sessionFactory;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private LocalAccountDAO localAccountDAO;
	public LocalAccountDAO getLocalAccountDAO() {
		return localAccountDAO;
	}
	@Autowired
	public void setLocalAccountDAO(LocalAccountDAO localAccountDAO) {
		this.localAccountDAO = localAccountDAO;
	}

	private UserDAO userDAO;
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	private RoleDAO roleDAO;
	
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
	@Autowired
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	private HostDAO hostDAO;
	@Autowired
	public void setHostDAO(HostDAO hostDAO) {
		this.hostDAO = hostDAO;
	}

	private VirtualNetworkDAO virtualNetworkDAO;
	public VirtualNetworkDAO getVirtualNetworkDAO() {
		return virtualNetworkDAO;
	}
	@Autowired
	public void setVirtualNetworkDAO(VirtualNetworkDAO virtualNetworkDAO) {
		this.virtualNetworkDAO = virtualNetworkDAO;
	}
	
	private VirtualImageDAO virtualImageDAO;
	public VirtualImageDAO getVirtualImageDAO() {
		return virtualImageDAO;
	}
	@Autowired
	public void setVirtualImageDAO(VirtualImageDAO virtualImageDAO) {
		this.virtualImageDAO = virtualImageDAO;
	}

	private VirtualMachineDAO virtualMachineDAO;
	public VirtualMachineDAO getVirtualMachineDAO() {
		return virtualMachineDAO;
	}
	@Autowired
	public void setVirtualMachineDAO(VirtualMachineDAO virtualMachineDAO) {
		this.virtualMachineDAO = virtualMachineDAO;
	}

	
	private JobDAO jobDAO;
	public JobDAO getJobDAO() {
		return jobDAO;
	}
	@Autowired
	public void setJobDAO(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}
	
	private ClusterDAO clusterDAO;
	
	public ClusterDAO getClusterDAO() {
		return clusterDAO;
	}
	@Autowired
	public void setClusterDAO(ClusterDAO clusterDAO) {
		this.clusterDAO = clusterDAO;
	}
	
	
	private HostManager hostManager;
	public HostManager getHostManager() {
		return hostManager;
	}
	@Autowired
	public void setHostManager(HostManager hostManager) {
		this.hostManager = hostManager;
	}

	private VirtualNetworkManager virtualNetworkManager;
	public VirtualNetworkManager getVirtualNetworkManager() {
		return virtualNetworkManager;
	}
	@Autowired
	public void setVirtualNetworkManager(
			VirtualNetworkManager virtualNetworkManager) {
		this.virtualNetworkManager = virtualNetworkManager;
	}

	private VirtualImageManager virtualImageManager;
	public VirtualImageManager getVirtualImageManager() {
		return virtualImageManager;
	}
	@Autowired
	public void setVirtualImageManager(VirtualImageManager virtualImageManager) {
		this.virtualImageManager = virtualImageManager;
	}

	private VirtualMachineManager virtualMachineManager;
	public VirtualMachineManager getVirtualMachineManager() {
		return virtualMachineManager;
	}
	@Autowired
	public void setVirtualMachineManager(
			VirtualMachineManager virtualMachineManager) {
		this.virtualMachineManager = virtualMachineManager;
	}
	
	private JobManager jobManager;
	public JobManager getJobManager() {
		return jobManager;
	}
	@Autowired
	public void setJobManager(JobManager jobManager) {
		this.jobManager = jobManager;
	}
	
	private ClusterManager clusterManager;
	public ClusterManager getClusterManager() {
		return clusterManager;
	}
	@Autowired
	public void setClusterManager(ClusterManager clusterManager) {
		this.clusterManager = clusterManager;
	}
	/**
	 * 
	 * @throws Exception
	 */
	private void createDirectories() throws Exception {
		Session session = null;
		Transaction transaction = null;
		
		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
		transaction = session.beginTransaction();
		List<Cluster> clusters = clusterDAO.getClusters(session);
		for(Cluster c : clusters) {
			List<String> dirList = new ArrayList<String>();
			dirList.add(c.getBaseDir() + Cloud.getInstance().getProp("data.basedir"));
			dirList.add(c.getBaseDir() + Cloud.getInstance().getProp("commonstorage.basedir"));
			dirList.add(c.getBaseDir() + Cloud.getInstance().getProp("solver.basedir"));
			for (String dir : dirList) {
				if (!(new File(dir)).exists()) {
					(new File(dir)).mkdirs();
				}
			}
		}
		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		
		/* Backup directory creation */
		if(!(new File(Cloud.getInstance().getProp("backup.basedir")).exists())) {
			(new File(Cloud.getInstance().getProp("backup.basedir"))).mkdirs();
		}
		
	}
	
	private void createDefaultUsers(List<Cluster> clusters, boolean roleCreation) throws Exception {
		Session session = null;
		Transaction transaction = null;
		
		if(roleCreation) {
			session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
			transaction = session.beginTransaction();
			
			Set<String> admin_perms = new HashSet<String>();
			admin_perms.add(Cloud.getInstance().getProp("user.role.admin.permission"));
	
			Set<String> user_perms = new HashSet<String>();
			user_perms.add(Cloud.getInstance().getProp("user.role.normal.permission"));
	
			Role role0 = new Role(Cloud.getInstance().getProp("user.role.admin"), "The administrator role only given to site admins", admin_perms);
			Role role1 = new Role(Cloud.getInstance().getProp("user.role.normal"), "The default role given to all users", user_perms);
			session.save(role0);
			session.save(role1);
			
			transaction.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		}

		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
		transaction = session.beginTransaction();
		
		
		User admin = new User(Cloud.getInstance().getProp("user.admin.id"),
				new Sha256Hash(Cloud.getInstance().getProp(
						"user.admin.password")).toHex(), Cloud
						.getInstance().getProp("user.admin.email"), "", "",
				"");
		admin.setSessionToken("");
		admin.setStorageSource(Cloud.getInstance().getProp("data.basedir") + "/" + admin.getUserId());
		admin.setUserName("유정록");
		admin.setAffiliation("KISTI");
		admin.setMajor("KISTI");
		admin.setClassName("KISTI");
		admin.setUid("4050078");
		admin.setGid("4050078");
		admin.setRegisteredDate(new Date());
		Set<Role> roles = new HashSet<Role>();
		roles.add(roleDAO.findRole(session, Cloud.getInstance().getProp("user.role.admin")));
		admin.setRoles(roles);
		admin.setState(UserState.ACTIVATED);
		session.save(admin);
		AuthUtils.createDir(clusters, admin.getUserId());

		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
	}
	
	private Cluster.JobManagerType getJobManagerType(String jobManager) {
		if(jobManager.equals("TORQUE")) {
			return Cluster.JobManagerType.TORQUE;
		}
		else if(jobManager.equals("LoadL")) {
			return Cluster.JobManagerType.LoadL;
		}
		else if(jobManager.equals("SGE")) {
			return Cluster.JobManagerType.SGE;
		}
		else if(jobManager.equals("OpenPBS")) {
			return Cluster.JobManagerType.OpenPBS;
		}
		else if(jobManager.equals("Condor")) {
			return Cluster.JobManagerType.Condor;
		}
		else {
			return Cluster.JobManagerType.UNKNOWN;
		}
	}
	
	private void updateClusters(String name, String ip, String port, String jobManager, String jobManagerVersion, String queues, String totalCores, String baseDir,
								String zone, boolean isEnabled) {
		Session session = null;
		Transaction transaction = null;
		
		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
		transaction = session.beginTransaction();
		
		Cluster c = clusterDAO.findCluster(session, name);
		
		if (c == null) {
			Cluster aCluster = new Cluster();
			aCluster.setName(name);
			aCluster.setIp(ip);
			aCluster.setPort(port);
			aCluster.setJobManagerType(getJobManagerType(jobManager));
			aCluster.setJobManagerVersion(jobManagerVersion);
			aCluster.setQueues(queues);
			aCluster.setBaseDir(baseDir);
			aCluster.setZone(zone);
			aCluster.setEnabled(isEnabled);
			Cluster.Runtime runtime = new Cluster.Runtime();
			runtime.setTotalCores(Long.parseLong(totalCores));
			runtime.setBusyCores(-1L);
			runtime.setDownCores(-1L);
			runtime.setFreeCores(-1L);
			aCluster.setRuntime(runtime);
			aCluster.setLastModified(new Date());

			Cluster monitoredCluster = clusterDAO.createCluster(session, aCluster);
			/* TODO: ADD TO WORKER */
			clusterManager.notifyToWorker(new Command<Cluster>("ADD", monitoredCluster));
			
			LOG.info("Cluster [ " + monitoredCluster.getName() + " ] added.");
		}
		else {
			c.setName(name);
			c.setIp(ip);
			c.setPort(port);
			c.setJobManagerType(getJobManagerType(jobManager));
			c.setJobManagerVersion(jobManagerVersion);
			c.setQueues(queues);
			c.setBaseDir(baseDir);
			c.setZone(zone);
			c.setEnabled(isEnabled);
			Cluster.Runtime runtime = c.getRuntime();
			runtime.setTotalCores(Long.parseLong(totalCores));
			runtime.setBusyCores(0L);
			runtime.setDownCores(0L);
			runtime.setFreeCores(0L);
			c.setLastModified(new Date());
			
			Cluster monitoredCluster = clusterDAO.updateCluster(session, c);
			/* TODO: ADD TO WORKER */
			clusterManager.notifyToWorker(new Command<Cluster>("ADD", monitoredCluster));
			LOG.info("Cluster [ " + monitoredCluster.getName() + " ] udpated.");
		}
		
		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
	}
	
	private void purgeClusters() {
		Session session = null;
		Transaction transaction = null;
		
		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
		transaction = session.beginTransaction();
		List<Cluster> clusters = clusterDAO.getClusters(session);
		for(Cluster c : clusters) {
			LOG.info(c.toString());
			if(!Cloud.getInstance().getProp("resources").contains(c.getName())) {
				clusterDAO.deleteCluster(session, c.getName());
				/* TODO: DELETE FROM WORKER */
				clusterManager.notifyToWorker(new Command<Cluster>("DELETE", c));
			}
		}
		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
	}
	
	private void updateLocalAccounts(List<LocalAccount> accounts) {
		Session session = null;
		Transaction transaction = null;
		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
		transaction = session.beginTransaction();
		for(LocalAccount account : accounts) {
			if(localAccountDAO.find(session, account.getResourceName(), account.getLocalId()) == null) {
				LOG.info("Creating a local account : " + account);
				localAccountDAO.create(session, account);
			}
			else {
				LOG.info(account + " exist ... bypass");
			}
		}
		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Session session = null;
		Transaction transaction = null;
		
		/* Configuration loading ... */
		Resource resource = new ClassPathResource("config.common.ini");
		if (!resource.exists()) {
			throw new Exception("Configuration file does not exist !");
		}

		LOG.info("--------------");
		LOG.info("Resource Exists : " + resource.exists());
		LOG.info("Filename : " + resource.getFilename());
		InputStreamReader isr = new InputStreamReader(resource.getInputStream());
		BufferedReader br = new BufferedReader(isr);

		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.length() == 0)
				continue;
			if (line.startsWith("#"))
				continue;
			if (line.split("=").length != 2)
				continue;
			String[] pairs = line.split("=");
			if(pairs.length == 2) {
				Cloud.getInstance().setProp(pairs[0], pairs[1]);
			}
		}
		
		/* Specific settings */
		Resource setting =  new ClassPathResource("config.ini");

		if (!setting.exists()) {
			throw new Exception("Specific Configuration file does not exist !");
		}
		
		LOG.info("--------------------------------------------");
		List<LocalAccount> accounts = new ArrayList<LocalAccount>();
		
		LOG.info("Specific Setting Exists : " + setting.exists());
		LOG.info("Specific Conf. Filename : " + setting.getFilename());
		isr = new InputStreamReader(setting.getInputStream());
		br = new BufferedReader(isr);
		line = null;
		while ((line = br.readLine()) != null) {
			if (line.length() == 0)
				continue;
			if (line.startsWith("#"))
				continue;
			if (line.split("=").length != 2)
				continue;
			String[] pairs = line.split("=");
			if(pairs.length == 2) {
				if(pairs[0].equals("resources")) {
					String cluster = pairs[1];
					String[] clusterinfo = cluster.split(":");
					if(clusterinfo.length != 10) {
						throw new Exception("config file is not valid");
					}
					String clusterName = clusterinfo[0];
					String clusterIP = clusterinfo[1];
					String clusterPort = clusterinfo[2];
					String jobManagerName = clusterinfo[3];
					String jobManagerVersion = clusterinfo[4];
					String queues = clusterinfo[5];
					String totalCores = clusterinfo[6];
					String baseDir = clusterinfo[7];
					String zone = clusterinfo[8];
					String isEnabled = clusterinfo[9];
					if(isEnabled.equals("true")) {
						updateClusters(clusterName, clusterIP, clusterPort, jobManagerName, jobManagerVersion, queues, totalCores, baseDir, zone, true);
					}
					else {
						updateClusters(clusterName, clusterIP, clusterPort, jobManagerName, jobManagerVersion, queues, totalCores, baseDir, zone, false);
					}
					
					String resourceGroup;
					if(Cloud.getInstance().getProp(pairs[0]) == null) {
						Cloud.getInstance().setProp(pairs[0], cluster);
					}
					else {
						resourceGroup = Cloud.getInstance().getProp(pairs[0]);
						Cloud.getInstance().setProp(pairs[0], resourceGroup + ";" + cluster);
					}
				}
				else if(pairs[0].equals("accounts")) {
					String account = pairs[1];
					String[] accountInfo = account.split(":");
					if(accountInfo.length != 2) {
						throw new Exception("config file is not valid");
					}
					String resourceName = accountInfo[0];
					String localId = accountInfo[1];
					accounts.add(new LocalAccount(resourceName, localId, (Long)0L));
				}
				else {
					Cloud.getInstance().setProp(pairs[0], pairs[1]);
					LOG.info("[ENV]" + pairs[0] + "=" + pairs[1]);
				}
			}
		}
		
		purgeClusters();
		
		/* Loading cluster resources SW configuration */
		Resource clusterRes = new ClassPathResource("resources.conf");
		if (!clusterRes.exists()) {
			throw new Exception("Resource configuration file does not exist !");
		}

		LOG.info("--------------");
		LOG.info("Cluster Resources Exists : " + clusterRes.exists());
		LOG.info("Filename : " + clusterRes.getFilename());
		isr = new InputStreamReader(clusterRes.getInputStream());
		br = new BufferedReader(isr);

		line = null;
		String resourceName = null;
		Map<String,String> conf = null;
		while ((line = br.readLine()) != null) {
			if (line.length() == 0)
				continue;
			if (line.startsWith("#"))
				continue;
			if (line.startsWith("%%START")) {
				resourceName = line.substring(8);
				conf = new HashMap<String, String>();
			}
			
			if (line.startsWith("%%END")) {
				if(resourceName != null && conf != null) {
					ResourceConf.getConf().setProp(resourceName, conf);
				}
			}
			
			if (line.split("=").length != 2)
				continue;
			
			String[] pairs = line.split("=");
			if(pairs.length == 2) {
				conf.put(pairs[0], pairs[1]);
			}
		}
		
		LOG.info(ResourceConf.getConf().toString());
		
		LOG.info(Cloud.getInstance().toString());
		br.close();
		isr.close();
		LOG.info("--------------");

		LOG.info("Creating directories ...");
		createDirectories();
		
		
		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
		transaction = session.beginTransaction();
		List<Cluster> clusters = clusterDAO.getClusters(session);
		for(Cluster c : clusters) {
			LOG.info(c.toString());
		}
		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);

		
		/* CLUSTER ADAPTER CONFIGURATION */
		BeanFactory factory = ctx;
		
		Map<String, ClusterAdapter> clusterAdapters = new HashMap<String, ClusterAdapter>();
		ClusterAdapter ca = null;
		
		for(Cluster c : clusters) {
			ca = (ClusterAdapter)factory.getBean(c.getName(), ClusterAdapter.class);
			if(ca == null) {
				throw new Exception("Cluster adapter not found for " + c.getName());
			}
			else {
				LOG.info("Cluster adapter found for " + c.getName());
				clusterAdapters.put(ca.getName(), ca);	
			}
		}
		clusterManager.setClusterAdapters(clusterAdapters);
		
		Map<String, JobAdapter> jobAdapters = new HashMap<String, JobAdapter>();
		JobAdapter ja = null;
		
		for(Cluster c : clusters) {
			ja = (JobAdapter)factory.getBean(c.getJobManagerType().toString(), JobAdapter.class);
			if(ja == null) {
				throw new Exception("Job adapter not found for " + c.getJobManagerType().toString());
			}
			else {
				LOG.info("Job adapter found for " + c.getJobManagerType().toString());
				jobAdapters.put(ja.getName(), ja);
			}
		}
		jobManager.setJobAdapters(jobAdapters);
		
		
		/**********************************************************************
		 * RENEW PROCESS FOR ALL RESOURCES
		 **********************************************************************/
		if(Cloud.getInstance().getProp("resources.renew").equals("true")) {
			session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
			transaction = session.beginTransaction();
		
			List<VirtualMachine> vms = virtualMachineDAO.getVirtualMachines(session, null, null);
			for(VirtualMachine vm : vms) {
				virtualMachineManager.purgeVirtualMachine(vm);
				LOG.info("VM (" + vm.getName() + ") purging ... done.");
			}

			List<Host> hosts = hostDAO.getAllHosts(null, null);
			for(Host host : hosts) {
				hostManager.purgeHost(host);
				LOG.info("Host (" + host.getName() + ") purging ... done.");
			}
			
			List<VirtualNetwork> nics = virtualNetworkDAO.getVirtualNetworks();
			for(VirtualNetwork nic : nics) {
				virtualNetworkManager.purgeVirtualNetwork(nic);
				LOG.info("VirtualNetwork (" + nic.getId() + ") purging ... done.");
			}
			
			List<VirtualImage> images = virtualImageDAO.getVirtualImages();
			for(VirtualImage image : images) {
				virtualImageManager.purgeVirtualImage(image);
				LOG.info("VirtualImage (" + image.getId() + ") purging ... done.");
			}
			
			transaction.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		}
		
		
		
		/* USERS */
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
		int count = jdbcTemplate.queryForInt(
				"select count(*) from USERS where userid = ?", "admin");
		if (count == 0) {
			LOG.info("USER DATA populating ... ");
			createDefaultUsers(clusters, true);

		} else {
			LOG.info("USER TABLE Loading ...");
			if(Cloud.getInstance().getProp("user.flush").equals("true")) {
				LOG.info("USER TABLE all records flushing ...");
				session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
				transaction = session.beginTransaction();
				List<User> users = userDAO.getAllUsers(session, null, null);
				for(User u : users) {
					userDAO.deleteUser(session, u.getId());
					LOG.info("USER (" + u.getUserId() + ") Deleted");
				}
				transaction.commit();
				SessionFactoryUtils.releaseSession(session, this.sessionFactory);
				
				LOG.info("ROLE TABLE all records flushing ...");
				session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
				transaction = session.beginTransaction();
				List<Role> roles = roleDAO.getRoles(session);
				for(Role r : roles) {
					roleDAO.deleteRole(session, r.getId());
					LOG.info("ROLE (" + r.getId() + ") Deleted");
				}
				transaction.commit();
				SessionFactoryUtils.releaseSession(session, this.sessionFactory);
				
				createDefaultUsers(clusters, true);
			}
			
			
			/* Backward compatibility support : if a user has "NULL" activated value, initialize it with "true" */
			session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
			transaction = session.beginTransaction();
			List<User> users = userDAO.getAllUsers(session, null, null);
			for(User u : users) {
				if(u.getState() == null) {
					userDAO.updateState(session, u.getId(), UserState.ACTIVATED);
					LOG.info("USER (" + u.getUserId() + ") Activated");
				}
							}
			transaction.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		}

		/* HOSTS */
		LOG.info("HOST TABLE Loading ... ");
		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory,
				true);
		transaction = session.beginTransaction();
		List<Host> hosts = hostDAO.getAllHosts(null, null);
		for (int i = 0; i < hosts.size(); i++) {
			hostManager.notifyToWorker(new Command<Host>("ADD", hosts.get(i)));
		}
		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);

		/* VIRTUAL NETWORKS */
		LOG.info("VIRTUALNETWORK TABLE Loading ... ");
		VirtualNetwork vn = new VirtualNetwork("0");
		// for KISTI
		
		vn.setId(-1L);
		virtualNetworkManager.notifyToWorker(new Command<VirtualNetwork>("ADD",
				vn));

		/* VIRTUAL IMAGES */
		LOG.info("VIRTUALIMAGE TABLE Loading ... ");
		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory,
				true);
		transaction = session.beginTransaction();
		List<VirtualImage> images = virtualImageDAO.getVirtualImages();

		for (VirtualImage image : images) {
			virtualImageManager.notifyToWorker(new Command<VirtualImage>("ADD",
					image));
		}

		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);

		/* VIRTUAL MACHINES */
		LOG.info("VIRTUALMACHINE TABLE Loading ... ");
		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory,
				true);
		transaction = session.beginTransaction();

		List<VirtualMachine> vms = virtualMachineDAO
				.getVirtualMachines(session, null, null);
		for (VirtualMachine vm : vms) {
			LOG.info("VMID : " + vm.getId());
			LOG.info("DISKS : " + vm.getDisks().size());
			LOG.info("NICS  : " + vm.getNics().size());
			virtualMachineManager.notifyToWorker(new Command<VirtualMachine>(
					"ADD", vm));
		}
		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		
		/* JOBS */
		LOG.info("JOB TABLE Loading ... ");

		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
		transaction = session.beginTransaction();
		/*
		int jobCnt = jobDAO.getJobCount(session, null);
		for(int index = 0 ; index < jobCnt ; index+=1) {
			LOG.info(". : " + index);
			int startIndex = index;
			List<Job> jobs = jobDAO.getJobs(session, startIndex, 1);
			for(Job job : jobs) {
				if(job.getLocalAccount() == null || job.getLocalAccount().isEmpty()) {
					job.setLocalAccount("root");
					jobDAO.updateJob(session, job);
				}
				if(job.getState().equals(Job.JobState.QUEUED)) {
					jobManager.notifyToWorker(new Command<Job>("ADD",job));
					LOG.info(job.getUuid() + " QUEUED monitoring added");
				}
				else if(job.getState().equals(Job.JobState.RUNNING)) {
					jobManager.notifyToWorker(new Command<Job>("ADD",job));
					LOG.info(job.getUuid() + " RUNNING monitoring added");
				}
			}
		}
		*/
		List<Job> jobs = jobDAO.getFailedJobs(session);
		LOG.info("FAILED JOBS : " + jobs.size());
		
		List<Job> activeJobs = jobDAO.getActiveJobs(session);
		if(activeJobs.size() != 0) {
			LOG.info("ACTIVE JOBS : " + activeJobs.size());
			for(Job job : activeJobs) {
				if(job.getState().equals(Job.JobState.QUEUED)) {
					jobManager.notifyToWorker(new Command<Job>("ADD",job));
					LOG.info(job.getUuid() + " QUEUED monitoring added");
				}
				else if(job.getState().equals(Job.JobState.RUNNING)) {
					jobManager.notifyToWorker(new Command<Job>("ADD",job));
					LOG.info(job.getUuid() + " RUNNING monitoring added");
				}
			}
		}
		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		
		
		
		updateLocalAccounts(accounts);
		
		
		
		
		/*
		session = (Session) SessionFactoryUtils.getSession(this.sessionFactory, true);
		transaction = session.beginTransaction();
		int jobInitializedFailed = 0;
		int jobInitialized = 0;
		int jobSuccess = 0;
		int jobFailed = 0;
		int jobSubmitFailed = 0;
		int jobCanceled = 0;
		int jobQueued = 0;
		int jobRunning = 0;
		int jobOthers = 0;
		int jobCnt = jobDAO.getJobCount(session, null);
		
		for(int index = 0 ; index < jobCnt ; index+=1) {
			int startIndex = index;
			List<Job> jobs = jobDAO.getJobs(session, startIndex, 1);
			for(Job job : jobs) {
				//LOG.info(job.getJobId() + ":" + job.getExecutable());
				if(job.getState().equals(Job.JobState.INITIALIZED)) {
					jobInitialized++;
				}
				else if (job.getState().equals(Job.JobState.CANCELED)) {
					jobCanceled++;
				}
				else if(job.getState().equals(Job.JobState.INITIALIZE_FAILED)) {
					jobInitializedFailed++;
				}
				else if(job.getState().equals(Job.JobState.SUCCESS)) {
					jobSuccess++;
				}
				else if(job.getState().equals(Job.JobState.FAILED)) {
					jobFailed++;
				}
				else if(job.getState().equals(Job.JobState.SUBMISSION_FAILED)) {
					jobSubmitFailed++;
				}
				else if(job.getState().equals(Job.JobState.QUEUED)) {
					jobQueued++;
					jobManager.notifyToWorker(new Command<Job>("ADD",job));
				}
				else if(job.getState().equals(Job.JobState.RUNNING)) {
					jobRunning++;
					jobManager.notifyToWorker(new Command<Job>("ADD",job));
				}
				else {
					jobOthers++;
				}
			
//				if( job.getCyberLabId() == null || job.getCyberLabId().isEmpty() ||
//						job.getClassId() == null || job.getClassId().isEmpty() ) {
//					User u = userDAO.getUser(session, job.getUserId());
//					if(u != null) {
//						job.setCyberLabId(u.getAffiliation());
//						job.setClassId(u.getClassName());
//					} else {
//						LOG.info(job.getUserId() + " user object null");
//						
//						job.setCyberLabId("조교");
//						job.setClassId("조교");
//					}
//				}
//				job.setSolverId("");
//				job.setSolverName(job.getExecutable().substring(job.getExecutable().lastIndexOf('/')+1));
//				jobDAO.updateJob(session, job);
			}
		}
		transaction.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		
		LOG.info("# OF ALL JOBS : " + jobCnt);
		LOG.info("INITIALIZED JOBS : " + jobInitialized);
		LOG.info("INITIALIZE_FAILED JOBS : " + jobInitializedFailed);
		LOG.info("SUCCESS JOBS : " + jobSuccess);
		LOG.info("FAILED JOBS : " + jobFailed);
		LOG.info("SUBMISSION_FAILED JOBS : " + jobSubmitFailed);
		LOG.info("CANCELED JOBS : " + jobCanceled);
		LOG.info("QUEUED JOBS : " + jobQueued);
		LOG.info("RUNNING JOBS : " + jobRunning);
		LOG.info("UNKNOWN JOBS : " + jobOthers);
		
		*/
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		LOG.info("setApplicationContext() called");
		this.ctx = applicationContext;
		
	}

}

