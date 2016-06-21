/**
 * 
 */
package kisti.edison.cloud.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.activation.MimetypesFileTypeMap;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.FileItem;
import kisti.edison.cloud.model.User;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author root
 * 
 */
@Transactional
@Service("repositoryService")
public class RepositoryServiceImpl implements RepositoryService {
	private static String separator = "______";
	private final Logger LOG = Logger.getLogger(this.getClass());

	private String getTemporalDirectory(Cluster cluster, String userId) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dir = cluster.getBaseDir() + Cloud.getInstance().getProp("data.basedir") + "/"
				+ userId + "/"
				+ Cloud.getInstance().getProp("user.repositorypath") + "/"
				+ sdf.format(now.getTime()) + "/";

		if (!(new File(dir)).exists()) {
			LOG.info("creating " + dir);
			(new File(dir)).mkdirs();
		}
		return dir;
	}
	
	private String makeRandomDir(Cluster cluster, User user) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dir = cluster.getBaseDir() + "/" + user.getStorageSource() + "/" + Cloud.getInstance().getProp("user.repositorypath") + "/"
				+ sdf.format(now.getTime()) + "/";

		if (!(new File(dir)).exists()) {
			LOG.info("creating " + dir);
			(new File(dir)).mkdirs();
		}
		return dir;
	}

	private String getFilePath(String dir, String fileName) {
		return dir + UUID.randomUUID().toString().replaceAll("-", "") + RepositoryServiceImpl.separator + fileName;
	}

	private String getFileName(String filePath) {
		String[] tokens = filePath.split(RepositoryServiceImpl.separator);
		if (tokens != null && tokens.length == 2) {
			return tokens[1];
		} else {
			return filePath.substring(filePath.lastIndexOf('/') + 1);
		}
	}

	@Override
	public void create(Cluster cluster, String userId, byte[] content, FileItem fileItem)
			throws IOException {
		LOG.info("RepositoryServiceImpl::create() : " + cluster.getName() + " : " + userId);
		String filePath = getFilePath(getTemporalDirectory(cluster, userId),
				fileItem.getName());
		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(content);
		fos.close();
		fileItem.setId(Base64.encode(filePath.getBytes()));
		fileItem.setPath(filePath);
		LOG.info(new String(Base64.decode(fileItem.getId())));
	}

	@Override
	public void create(Cluster cluster, User user, byte[] content, FileItem fileItem) throws IOException {
		// TODO Auto-generated method stub
		LOG.info("File Creating... : " + cluster.getName() + " : " + user.getUserId());
		String filePath = getFilePath(makeRandomDir(cluster, user), fileItem.getName());
		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(content);
		fos.close();
		fileItem.setId(Base64.encode(filePath.getBytes()));
		fileItem.setPath(filePath);
		LOG.info(new String(Base64.decode(fileItem.getId())));
	}
	
	@Override
	public FileItem find(String fileId) {
		// TODO Auto-generated method stub
		FileItem item = null;

		if (fileId != null && !fileId.isEmpty()) {
			String filePath = new String(Base64.decode(fileId));
			LOG.info("filePath : " + filePath);
			File f = new File(filePath);

			if (!f.exists()) {
				return null;
			}
			item = new FileItem();
			item.setId(fileId);
			item.setType(new MimetypesFileTypeMap().getContentType(f));
			item.setSize(f.length());
			item.setName(getFileName(filePath));
			item.setDescription("");
			item.setPath(filePath);

		} else {
			LOG.info("fileId empty");
			return null;
		}

		return item;
	}

	@Override
	public byte[] read(FileItem fileItem) throws IOException {
		File file = new File(new String(Base64.decode(fileItem.getId())));
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		is.close();
		return bytes;
	}

	@Override
	public void update(String fileId, byte[] contents, FileItem file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String path) {
		// TODO Auto-generated method stub
		File target = new File(path);
		if(target.isDirectory()){
			try {
				FileUtils.deleteDirectory(target);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			target.delete();
		}
	}


	@Override
	public List<FileItem> getFiles(String directory) throws IOException {
		// TODO Auto-generated method stub
		List<FileItem> items = new LinkedList<FileItem>();

		File dir = new File(directory);
		if (!dir.exists() || !dir.isDirectory()) {
			LOG.info(directory + "not exists");
			return null;
		}

		for (File f : dir.listFiles()) {
			if (f.isFile()) {
				FileItem item = new FileItem();
				LOG.info(f.getAbsolutePath());
				item.setId(Base64.encode(f.getAbsolutePath().getBytes()));
				item.setName(f.getName());
				item.setType(new MimetypesFileTypeMap().getContentType(f));
				item.setSize(f.length());
				item.setDescription("");
				item.setPath(f.getAbsolutePath());
				items.add(item);
			}
		}

		return items;
	}

	@Override
	public FileItem getFile(String filePath) throws IOException {
		// TODO Auto-generated method stub
		FileItem item = new FileItem();
		File f = new File(filePath);
		if (!f.exists()) {
			LOG.info(filePath + "not exists");
			return null;
		}
		
		if(f.isDirectory()) {
			LOG.info(filePath + "is not a file");
			return null;
		}
		
		item.setId(Base64.encode(f.getAbsolutePath().getBytes()));
		item.setName(f.getName());
		item.setType(new MimetypesFileTypeMap().getContentType(f));
		item.setSize(f.length());
		item.setDescription("");
		item.setPath(f.getAbsolutePath());
		
		return item;
	}
}
