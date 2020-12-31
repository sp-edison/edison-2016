package kisti.edison.cloud.service;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import kisti.edison.cloud.dao.RoleDAO;
import kisti.edison.cloud.dao.UserDAO;
import kisti.edison.cloud.dao.ClusterDAO;
import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Role;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.plugin.auth.LdapAdapter;
import kisti.edison.cloud.util.AuthUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;
import java.util.Set;

/**
 * Default implementation of the {@link UserService} interface. This service
 * implements operations related to User data.
 */

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private ClusterDAO clusterDAO;
	private LdapAdapter ldapAdapter;
	
	@Autowired
	public void setLdapAdapter(LdapAdapter ldapAdapter){
		this.ldapAdapter = ldapAdapter;
	}
	
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

	/*
	 * public User getCurrentUser() { final Long id = (Long)
	 * SecurityUtils.getSubject().getPrincipal(); logger.info("currentID :" +
	 * id); if( id != null ) { return getUser(id); } else { return null; } }
	 */
	
	// http://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
	void writeLineToFile(String filename, String line)
	{
		PrintWriter out = null;
		File fileTest = new File(filename);
				
		if ( fileTest.canWrite() == false ) {
			LOG.info("File already exists(cannot write) : " + filename);
		} else {
			// try when file does not exist
			try {
			    out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
			    out.println();
			    out.println(line);
			}
			catch (IOException e) {
				LOG.error(e.toString());
			}
			finally{
			    if(out != null) out.close();
			}
		}
	}

	public User createUser(User user) {
		if (user.getUserId().isEmpty() || user.getPassword().isEmpty())
			return null;

		List<Cluster> clusters = clusterDAO.getClusters(null);
		
		String reqPW = user.getPassword();
		
		user.setRegisteredDate(new Date());
		user.setState(User.UserState.ACTIVATED);
		

		
		// LOG.info("id : " + createdUser.getId());
		// LOG.info("userid : " + createdUser.getUserId());

		// AuthUtils.createUserDir(createdUser.getId(),
		// createdUser.getUserId());
		
		//AuthUtils.createDir(clusters, createdUser.getUserId());
		// if dir exists, first delete it
		String storageBase = "";
		String userBase = "";
		for(Cluster c : clusters) {
			storageBase = c.getBaseDir() + Cloud.getInstance().getProp("data.basedir");
			if(user.getCyberLabId().isEmpty() || user.getClassId().isEmpty()) {
				// normal user
				userBase = "/" + user.getUserId() + "/";
			}	
			else {
				// grouped user
				//userBase = "/" + user.getCyberLabId() + "/" + user.getClassId() + "/" + user.getUserId() + "/";
				userBase = "/" + user.getUserId() + "/";
			}
			String repodir = storageBase + userBase;
			File dir = new File(repodir);
			if ( dir.exists() ) {
				AuthUtils.deleteDir(c.getBaseDir(), user.getUserId(), repodir);
			}
		}
		String storageSource = AuthUtils.createDirs(clusters, user);

		// createdUser.setUID( Long.toString( (Long)(1100+createdUser.getId()) )
		// );
		// createdUser.setGID( Long.toString( (Long)(1100+createdUser.getId()) )
		// );

		User createdUser = getUser(user.getUserId());
		//User createdUser = userDAO.createUser(null, user);
		if ( createdUser != null ) {
			return null;
		} else {
			createdUser = userDAO.createUser(null, user);	
		}
		
		createdUser.setStorageSource(Cloud.getInstance().getProp("data.basedir") + "/" + storageSource);
		createdUser.setPassword(reqPW);
		
		LOG.info("before generateRSAKey");
		String pubKey = generateRSAKey(user, clusters, createdUser.getStorageSource()+"/.ssh/", "id_rsa.pub", "id_rsa");
		LOG.info("after generateRSAKey");
		
		int uid = AuthUtils.getCounter().getAndIncrement();
		LOG.debug("uid: " + uid);
//		AuthUtils.getCounter().incrementAndGet();
		/* 임시
		 * EDISON:*:10001:
		 *  */
		String gid = Cloud.getInstance().getProp("user.group.gid");
		
		LOG.info("before ldapAdapter.addUser");
		ldapAdapter.addUser(user.getUserId(), uid, gid, user.getPassword(), clusters.get(0).getBaseDir() + user.getStorageSource(), pubKey);
		LOG.info("after ldapAdapter.addUser");
		
		LOG.debug("clusters.get(0).getBaseDir(): " + clusters.get(0).getBaseDir());
		LOG.debug("user.getStorageSource(): " + user.getStorageSource());
		
//		FileSystem fs  = FileSystems.getDefault();
//		UserPrincipalLookupService upls  = fs.getUserPrincipalLookupService();
//
//		UserPrincipal up;
//		try {
//			up = upls.lookupPrincipalByName(user.getUserId());
////			Path filePathObject = Paths.get(clusters.get(0).getBaseDir() + user.getStorageSource() + "/.ssh/id_rsa");
////			FileOwnerAttributeView foav = Files.getFileAttributeView(filePathObject,
////			          FileOwnerAttributeView.class);
////			foav.setOwner(up);
//			String homedir = clusters.get(0).getBaseDir() + user.getStorageSource(); 
//			File publicKeyFile = FileUtils.getFile(homedir + "/.ssh/id_rsa.pub");
//			File privateKeyFile = FileUtils.getFile(homedir + "/.ssh/id_rsa");
//			File authorized_keys = FileUtils.getFile(homedir + "/.ssh/authorized_keys");
//			Files.setOwner(publicKeyFile.toPath(),up);
//			Files.setOwner(privateKeyFile.toPath(),up);
//			Files.setOwner(authorized_keys.toPath(),up);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*
		 *  임시
			INFO | 2016-03-24 16:15:13,776 | AuthUtils.java:208 | creating repodir : /EDISON/./TEST/DATA/test4//repository/
			INFO | 2016-03-24 16:15:13,776 | AuthUtils.java:213 | creating jobdir : /EDISON/./TEST/DATA/test4//jobs/
			INFO | 2016-03-24 16:15:13,777 | AuthUtils.java:218 | creating jobdir : /EDISON/./TEST/DATA/test4//.ssh/
			
			INFO | 2016-03-24 16:16:39,640 | RepositoryServiceImpl.java:99 | File Creating... : EDISON-TEST : test4
			INFO | 2016-03-24 16:16:39,640 | RepositoryServiceImpl.java:63 | creating /EDISON//./TEST/DATA//test4//repository/20160324/
			INFO | 2016-03-24 16:16:39,641 | RepositoryServiceImpl.java:106 | /EDISON//./TEST/DATA//test4//repository/20160324/4ad727dcd4594f8692ef0c30
			
			INFO | 2016-03-24 16:16:39,694 | JobServiceImpl.java:110 | creating /EDISON/./TEST/DATA//test4//jobs/8251c691-8a98-46e2-b993-d6bfe6ca4059/7
		 */
		storageBase = "";
		userBase = "";
		for(Cluster c : clusters) {
			LOG.info("for " + c.getName() + " copy edisonadm public key, etc...");
			storageBase = c.getBaseDir() + Cloud.getInstance().getProp("data.basedir");
			if(user.getCyberLabId().isEmpty() || user.getClassId().isEmpty()) {
				// normal user
				userBase = "/" + user.getUserId() + "/";
			}	
			else {
				// grouped user
				//userBase = "/" + user.getCyberLabId() + "/" + user.getClassId() + "/" + user.getUserId() + "/";
				userBase = "/" + user.getUserId() + "/";
			}

//			String jobdir = storageBase + userBase + "/" + Cloud.getInstance().getProp("user.jobpath") + "/";
//			File file = new File(jobdir);
//			
//			String homedir = storageBase + userBase + "/";
//			File file2 = new File(homedir);
//			
//			String repodir = storageBase + userBase + "/" + Cloud.getInstance().getProp("user.repositorypath") + "/";
//			File file3 = new File(repodir);
//			
//			String keydir = storageBase + userBase + "/.ssh/";
//			File file4 = new File(keydir);
//			
//			try {
//				UserPrincipalLookupService lookupservice=FileSystems.getDefault().getUserPrincipalLookupService();
//				UserPrincipal userPrincipal = lookupservice.lookupPrincipalByName(user.getUserId());
//				Files.setOwner(file.toPath(),userPrincipal);
//				Files.setOwner(file2.toPath(),userPrincipal);
//				Files.setOwner(file3.toPath(),userPrincipal);
//				Files.setOwner(file4.toPath(),userPrincipal);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
			String homedir = storageBase + userBase;
			String adminId = Cloud.getInstance().getProp("user.admin.id");
//			String grp = Cloud.getInstance().getProp("user.group.name");
			
			String destFilename = homedir+".ssh/authorized_keys";
//			File authorized_keys = new File(destFilename);
			// cat admin's public key to authorized_keys
			// cat .ssh/id_rsa.pub >> test31/.ssh/authorized_keys
			// storageBase : /EDISON/./TEST/DATA
			// userBase ; /test31/
			// for job monitoring; qstat -f jobid
			File src = new File(storageBase+"/" + adminId + "/.ssh/id_rsa.pub");
			List<String> lines = null;
			try {
				// https://commons.apache.org/proper/commons-io/description.html
				lines = FileUtils.readLines(src);
			} catch (IOException e1) {
//				e1.printStackTrace();
				LOG.error("can't read " + storageBase+"/" + adminId + "/.ssh/id_rsa.pub");
			}
			
			StringBuffer sb = new StringBuffer();
			for (String s : lines)
			{
				sb.append(s);
			}

			writeLineToFile(destFilename, sb.toString());
			
			// if ownership is changed, skip chown cmd
			Path path = Paths.get(homedir);
	        FileOwnerAttributeView ownerAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
	        UserPrincipal owner = null;
			try {
				owner = ownerAttributeView.getOwner();
			} catch (IOException e1) {
				LOG.error("ownerAttributeView.getOwner() fail");
				e1.printStackTrace();
			}
			
			if ( user.getUserId().equals(owner.getName()) == false ) {
				List<String> cmd = new ArrayList<String>();
	//			String cmd = "/usr/bin/sudo /bin/chown -R " + user.getUserId() + ":" + grp +  "  " + homedir;
				cmd.add("/usr/bin/sudo");
				cmd.add("/bin/chown");
				cmd.add("-R");
				cmd.add(user.getUserId()+":");
				cmd.add(homedir);
				
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
				DefaultExecutor executor = new DefaultExecutor();
				executor.setStreamHandler(streamHandler);
				CommandLine cmdLine = CommandLine.parse(cmd.get(0));
				for (int i=1, n=cmd.size() ; i<n ; i++ ) {
			        cmdLine.addArgument(cmd.get(i));
			    }
				int exitValue = -1;
				try {
					exitValue = executor.execute(cmdLine);
				} catch (ExecuteException e) {
					LOG.error("chown command fail");
					LOG.error("chown fail: " + cmd.toString());
				} catch (IOException e) {
					LOG.error("chown command fail, IOException");
				}
				
				// chmod 775 ./jobs/
				cmd.clear();
				cmd.add("/usr/bin/sudo");
				cmd.add("/bin/chmod");
				cmd.add("775");
				cmd.add(homedir+"jobs/");
				
				outputStream = new ByteArrayOutputStream();
				streamHandler = new PumpStreamHandler(outputStream);
				executor = new DefaultExecutor();
				executor.setStreamHandler(streamHandler);
				cmdLine = CommandLine.parse(cmd.get(0));
				for (int i=1, n=cmd.size() ; i<n ; i++ ) {
			        cmdLine.addArgument(cmd.get(i));
			    }
				exitValue = -1;
				try {
					exitValue = executor.execute(cmdLine);
				} catch (ExecuteException e) {
					LOG.error("chmod command fail");
					LOG.error("chmod cmd: " + cmd.toString());
				} catch (IOException e) {
					LOG.error("chmod command fail, IOException");
				}
	
				// chmod 775 ./repository/
				cmd.clear();
				cmd.add("/usr/bin/sudo");
				cmd.add("/bin/chmod");
				cmd.add("775");
				cmd.add(homedir+"repository/");
	
				outputStream = new ByteArrayOutputStream();
				streamHandler = new PumpStreamHandler(outputStream);
				executor = new DefaultExecutor();
				executor.setStreamHandler(streamHandler);
				cmdLine = CommandLine.parse(cmd.get(0));
				for (int i=1, n=cmd.size() ; i<n ; i++ ) {
			        cmdLine.addArgument(cmd.get(i));
			    }
				exitValue = -1;
				try {
					exitValue = executor.execute(cmdLine);
				} catch (ExecuteException e) {
					LOG.error("chmod command fail");
					LOG.error("chmod cmd: " + cmd.toString());
				} catch (IOException e) {
					LOG.error("chmod command fail, IOException");
				}
			} /* if ownership is changed, skip chown cmd */
			
		} /* for each clusters */
        
		createdUser.setUid(new Integer(uid).toString());
		createdUser.setGid(new Integer(gid).toString());
		

		return updateUser(createdUser);

	}

	public List<User> getAllUsers(String orderBy, String order) {
		return userDAO.getAllUsers(null, orderBy, order);
	}

	public User getUser(String userid) {
		return userDAO.findUser(null, userid);
	}

	public void deleteUser(String userid) {
		User user = getUser(userid);
		// AuthUtils.deleteUserDir(userid);
		
		/* maintain the user's data directory even if the user is deleted */
		List<Cluster> clusters = clusterDAO.getClusters(null);
		for(Cluster c : clusters) {
			String basedir = c.getBaseDir();
//			String repodir = basedir + Cloud.getInstance().getProp("data.basedir") + "/" + userid;
			String repodir = basedir + user.getStorageSource();
			File dir = new File(repodir);
			if ( dir.exists() ) {
				AuthUtils.deleteDir(basedir, userid, repodir);
			}
		}
		
		ldapAdapter.delUser(userid);
		userDAO.deleteUser(null, user.getId());
	}

	public User updateUser(User user) {
		return userDAO.updateUser(null, user);
	}

	public boolean isExist(String userid) {
		if (getUser(userid) == null) {
			/* check ldap account */
			List<String> cmd = new ArrayList<String>();
			cmd.add("/usr/bin/getent");
			cmd.add("passwd");
			cmd.add(userid);
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
			DefaultExecutor executor = new DefaultExecutor();
			executor.setStreamHandler(streamHandler);
			CommandLine cmdLine = CommandLine.parse(cmd.get(0));
			for (int i=1, n=cmd.size() ; i<n ; i++ ) {
		        cmdLine.addArgument(cmd.get(i));
		    }
			int exitValue = -1;
			try {
				exitValue = executor.execute(cmdLine);
			} catch (ExecuteException e) {
				LOG.info("No such user : " + userid);
				LOG.info(e.toString());
				LOG.info("getent cmd: " + cmd.toString());
			} catch (IOException e) {
				LOG.error("getent command fail, IOException");
			}
			
			if ( exitValue == 0 ) return true;
			else
				return false;
		} else {
			return true;
		}
	}

	public Role findRole(String name) {
		return roleDAO.findRole(null, name);
	}

	@Override
	public void updateUserSessionToken(Long id, String token) {
		// TODO Auto-generated method stub
		userDAO.updateUserSessionToken(null, id, token);
	}

	@Override
	public void deleteUserSessionToken(Long id) {
		// TODO Auto-generated method stub
		userDAO.deleteUserSessionToken(null, id);
	}

	@Override
	public int getUsersCount() {
		// TODO Auto-generated method stub
		return userDAO.getUserCount(null);
	}

	@Override
	public List<User> queryUsers(String orderBy, String order, int startIndex, int maxResults) {
		// TODO Auto-generated method stub
		return userDAO.queryUsers(null, orderBy, order, startIndex, maxResults);
	}
	private String generateRSAKey(User user, List<Cluster> clusters, String homedir, String pubKeyFile, String privKeyFile){
		KeyPairGenerator generator;
		KeyPair keyPair;
		String encodedPubKey = null;
		try {
			generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			keyPair = generator.genKeyPair();
			RSAPublicKey pub =  (RSAPublicKey) keyPair.getPublic();
			RSAPrivateKey priv = (RSAPrivateKey) keyPair.getPrivate();
			
			Iterator<Cluster> itr = clusters.iterator();
			
			String pubkeyFilename=null;
			String privatekeyFilename=null;
			String authorized_keysFilename=null;
			while(itr.hasNext()){
				Cluster cluster = (Cluster) itr.next();
				pubkeyFilename=cluster.getBaseDir() + homedir + pubKeyFile;
				authorized_keysFilename=cluster.getBaseDir() + homedir + "authorized_keys";
				BufferedWriter out = new BufferedWriter(new FileWriter(pubkeyFilename));
				encodedPubKey = encodePublicKey(pub,user.getUserId());
//				LOG.info("Generated Pubkey:" + encodedPubKey);
				out.write(encodedPubKey);
				out.close();
				
				Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
				perms.add(PosixFilePermission.OWNER_READ);
				perms.add(PosixFilePermission.OWNER_WRITE);
				
				privatekeyFilename=cluster.getBaseDir() + homedir + privKeyFile;
				out = new BufferedWriter(new FileWriter(privatekeyFilename));
				out.write("-----BEGIN RSA PRIVATE KEY-----");
				out.newLine();
				byte[] byteArray = Base64.encodeBase64(priv.getEncoded());
				String encodedString = new String(byteArray);
//				out.write(encodedString);
				int i = 0;
				String substr = null;
				for (; i < encodedString.length() - 64; i += 64) {
					substr = encodedString.substring(i, i+64);
					out.write(substr);
					out.newLine();
				}
				substr = encodedString.substring(i, encodedString.length());
				out.write(substr);
				out.newLine();
				out.write("-----END RSA PRIVATE KEY-----");
				out.close();
				
				/*
				String cmd = "chown " + user.getUserId() + " " +cluster.getBaseDir() + homedir + "/*";  
				ProcessBuilder builder = new ProcessBuilder(cmd);
				builder.redirectErrorStream(true);
				Process p = null;
				int retCode = 0;
				byte[] data = null;
				
				try {
					p = builder.start();
					retCode = p.waitFor();
					
					if (retCode == (-1)) {
						LOG.error("chown fail");
						return null;
					}
					
					BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
					data = new byte[ef.available()];
					ef.read(data, 0, ef.available());
					ef.close();
					p.getInputStream().close();
					p.getOutputStream().close();
					p.getErrorStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
				
			
				Path filePathObject = Paths.get(privatekeyFilename);
				Files.setPosixFilePermissions(filePathObject, perms);
				
				perms.add(PosixFilePermission.GROUP_READ);
				perms.add(PosixFilePermission.OTHERS_READ);
				filePathObject = Paths.get(pubkeyFilename);
				Files.setPosixFilePermissions(filePathObject, perms);
				
				// Copy a file
				// https://examples.javacodegeeks.com/core-java/apache/commons/io-commons/fileutils/org-apache-commons-io-fileutils-example/
				File src = FileUtils.getFile(pubkeyFilename);
				File dest = FileUtils.getFile(authorized_keysFilename);
				LOG.debug("src: " + pubkeyFilename);
				LOG.debug("dest: " + authorized_keysFilename);
		        FileUtils.copyFile(src, dest);
		        
				filePathObject = Paths.get(authorized_keysFilename);
				Files.setPosixFilePermissions(filePathObject, perms);
			}
	     }
	     catch (Exception e){
	    	 LOG.error(e);	
	     }
	     return encodedPubKey;
	}

		public static String encodePublicKey(PublicKey publicKey, String user)
	            throws IOException {
	        String publicKeyEncoded;
	        if(publicKey.getAlgorithm().equals("RSA")){
	            RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;
	            ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
	            DataOutputStream dos = new DataOutputStream(byteOs);
	            dos.writeInt("ssh-rsa".getBytes().length);
	            dos.write("ssh-rsa".getBytes());
	            dos.writeInt(rsaPublicKey.getPublicExponent().toByteArray().length);
	            dos.write(rsaPublicKey.getPublicExponent().toByteArray());
	            dos.writeInt(rsaPublicKey.getModulus().toByteArray().length);
	            dos.write(rsaPublicKey.getModulus().toByteArray());
	            publicKeyEncoded = new String(
	                    Base64.encodeBase64(byteOs.toByteArray()));
	            return "ssh-rsa " + publicKeyEncoded + " " + user;
	        }
	        else{
	            throw new IllegalArgumentException(
	                    "Unknown public key encoding: " + publicKey.getAlgorithm());
	        }
	    }
}
