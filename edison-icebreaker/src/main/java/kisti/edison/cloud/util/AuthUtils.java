/**
 * Copyright (c) 2012 KISTI. All rights reserved.
 * EDISON.
 * 
 * Package : kisti.edison.cloud.util
 * File         : AuthUtils.java
 * Date       : Jan 12, 2012 
 */
package kisti.edison.cloud.util;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.User;

import java.io.File;
//import java.io.FileOutputStream;

//import com.ice.tar.TarArchive;
//import com.ice.tar.TarBuffer;
//import com.ice.tar.TarEntry;



/**
 * @author root
 * 
 */
public class AuthUtils {
	private static final Logger LOG = Logger.getLogger(AuthUtils.class
			.getName());

	public static Map<String, String> getKeyPairs(String userId,
			String credential) {
		Map<String, String> ret = new HashMap<String, String>();

		KeyPairGenerator keyGen;
		try {
			keyGen = KeyPairGenerator.getInstance("DSA");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			keyGen.initialize(1024, random);
			KeyPair pair = keyGen.generateKeyPair();
			PrivateKey priv = pair.getPrivate();
			PublicKey pub = pair.getPublic();

			LOG.info("publicKey : " + pub.toString());
			LOG.info("privateKey : " + priv.toString());

			ret.put(new Sha256Hash(pub.toString()).toHex(),
					new Sha256Hash(priv.toString()).toHex());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return ret;
	}

	public static Map<String, String> parseAuthorizationHeader(String authStr) {
		Map<String, String> result = new HashMap<String, String>();

		if (authStr == null || authStr.isEmpty())
			return result;

		if (authStr.startsWith(Cloud.HTTP_HEADER_BASIC)) {
			String usernpass = new String(Base64.decode(authStr.substring(6)));
			String userId = usernpass.substring(0, usernpass.indexOf(":"));
			String password = usernpass.substring(usernpass.indexOf(":") + 1);

			result.put(Cloud.USERID, userId);
			result.put(Cloud.PASSWORD, password);
		}

		return result;
	}

	public static UsernamePasswordToken getToken(String authStr) {
		Map<String, String> userInfo = parseAuthorizationHeader(authStr);
		if (userInfo.isEmpty()) {
			return null;
		}
		return new UsernamePasswordToken(userInfo.get(Cloud.USERID),
				userInfo.get(Cloud.PASSWORD), false);
	}

	public static boolean createUserDir(Long id, String userid) {
		boolean result = true;
		String p1_cmd = "groupadd --gid " + (1100 + id) + " " + userid;
		String p2_cmd = "useradd --uid " + (1100 + id) + " -g " + (1100 + id)
				+ " -d " + Cloud.getInstance().getProp("data.basedir") + "/"
				+ userid + " -m " + userid;
		try {
			LOG.info(p1_cmd);
			Process p = Runtime.getRuntime().exec(p1_cmd);
			p.waitFor();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
			LOG.info("Exit Value : " + p.exitValue());

			LOG.info(p2_cmd);
			p = Runtime.getRuntime().exec(p2_cmd);
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
		return result;
	}

	public static boolean deleteUserDir(String userid) {
		boolean result = true;
		String p2_cmd = "rm -rf "
				+ Cloud.getInstance().getProp("data.basedir") + "/" + userid;
		String p1_cmd = "userdel " + userid;
		try {
			LOG.info(p1_cmd);
			Process p = Runtime.getRuntime().exec(p1_cmd);
			p.waitFor();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
			LOG.info("Exit Value : " + p.exitValue());

			LOG.info(p2_cmd);
			p = Runtime.getRuntime().exec(p2_cmd);
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
		return result;
	}

	public static void createDir(List<Cluster> clusters, String userId) {
		for(Cluster c : clusters) {
			String cmd = "mkdir -p "
					+ c.getBaseDir() + Cloud.getInstance().getProp("data.basedir") + "/" + userId
					+ "/repository/";
			try {
				LOG.info(cmd);
				Process p1 = Runtime.getRuntime().exec(cmd);
				p1.waitFor();
				p1.getInputStream().close();
				p1.getOutputStream().close();
				p1.getErrorStream().close();
				LOG.info("Exit Value : " + p1.exitValue());
				cmd = "mkdir -p " + c.getBaseDir() + Cloud.getInstance().getProp("data.basedir")
						+ "/" + userId + "/jobs/";
				LOG.info(cmd);
				Process p2 = Runtime.getRuntime().exec(cmd);
				p2.waitFor();
				p2.getInputStream().close();
				p2.getOutputStream().close();
				p2.getErrorStream().close();
				LOG.info("Exit Value : " + p2.exitValue());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String createDirs(List<Cluster> clusters, User user) {
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
				userBase = "/" + user.getCyberLabId() + "/" + user.getClassId() + "/" + user.getUserId() + "/";
			}
			String repodir = storageBase + userBase + "/" + Cloud.getInstance().getProp("user.repositorypath") + "/";
			if (!(new File(repodir)).exists()) {
				LOG.info("creating repodir : " + repodir);
				(new File(repodir)).mkdirs();
			}
			String jobdir = storageBase + userBase + "/" + Cloud.getInstance().getProp("user.jobpath") + "/";
			if (!(new File(jobdir)).exists()) {
				LOG.info("creating jobdir : " + jobdir);
				(new File(jobdir)).mkdirs();
			}
			/*
			if(Cloud.getInstance().getProp("build.target").equals("KISTI-NAP")) {
				String userDir = storageBase + userBase;
				File userdir = new File(userDir);
				if(userdir.exists()) {
					userdir.setReadable(true, false);
					userdir.setWritable(true, false);
					userdir.setExecutable(true, false);
				}
				
				File jobDir = new File(jobdir);
				if(jobDir.exists()) {
					jobDir.setReadable(true, false);
					jobDir.setWritable(true, false);
					jobDir.setExecutable(true, false);
				}
				
				File repoDir = new File(repodir);
				if(repoDir.exists()) {
					repoDir.setReadable(true, false);
					repoDir.setWritable(true, false);
					repoDir.setExecutable(true, false);
				}
			}*/
		}
		
		return userBase;
	}

	public static void deleteDir(String userId) {
		String cmd = "rm -rf " + Cloud.getInstance().getProp("data.basedir")
				+ "/" + userId;
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
	
	public static boolean moveDir(String source, String destination) {
		String cmd = "mv -f " + source + " " + destination + "/.";
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
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		/*
		File sourceDir = new File(source);
		File targetDir = new File(destination);
		try {
			FileUtils.moveDirectory(sourceDir, targetDir);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		*/
		return true;
	}
	
//	public static boolean createTarArchive( File archiveFile, File[] tobeTarFiles ){
//		boolean bRet = false;
//		try {
//			FileOutputStream outStream = new FileOutputStream(archiveFile);
//
//			int blockSize = TarBuffer.DEFAULT_BLKSIZE;
//			TarArchive archive = new TarArchive( outStream, blockSize );
//
//			if( archive != null) {
//				//		    archive.setDebug( false );
//				//		    archive.setVerbose( true );
//				//		    archive.setKeepOldFiles( false );
//				//		    archive.setAsciiTranslation( false );
//				//		    archive.setUserInfo( 0,"", 0, "" );
//
//				TarEntry entry = null;
//				String fileName = null;
//				for( int i = 0 ; i < tobeTarFiles.length ; i ++ ){
//					if (tobeTarFiles[i] == null || !tobeTarFiles[i].exists() || tobeTarFiles[i].isDirectory() )
//						continue;
//
//					entry = new TarEntry( tobeTarFiles[i] );
//
//					if( entry.getName().lastIndexOf("/") > -1 ){
//						fileName = entry.getName().substring( entry.getName().lastIndexOf("/") +1 );  //이건 파일이 폴더째 저장되는 경우 폴더를 없애고 한 곳에 파일을 넣기 위해서 이다.. 삭제 가능..
//
//						entry.setName( fileName );
//					}
//					System.out.println( "Add File: " + entry.getName() );
//
//					archive.writeEntry( entry, true );
//				}
//
//				archive.closeArchive();
//			}
//
//			outStream.close();
//			System.out.println("Adding completed OK");
//			bRet = true;
//		}catch (Exception e){
//			e.printStackTrace();
//			System.out.println( "Error: " + e.getMessage() );
//			return false;
//		}
//		return bRet;
//	}
	
	
}
