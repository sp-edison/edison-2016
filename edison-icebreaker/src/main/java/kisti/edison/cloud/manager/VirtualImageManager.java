/**
 * 
 */
package kisti.edison.cloud.manager;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.dao.VirtualImageDAO;
import kisti.edison.cloud.model.VirtualImage;
import kisti.edison.cloud.plugin.spec.VirtualImageAdapter;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author root
 * 
 */
@Component
public class VirtualImageManager {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private VirtualImageDAO virtualImageDAO;

	public VirtualImageDAO getVirtualImageDAO() {
		return virtualImageDAO;
	}

	@Autowired
	public void setVirtualImageDAO(VirtualImageDAO virtualImageDAO) {
		this.virtualImageDAO = virtualImageDAO;
	}

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Resource(name = "virtualImageQueue")
	private BlockingQueue<Command<VirtualImage>> virtualImageQueue;

	public BlockingQueue<Command<VirtualImage>> getVirtualImageQueue() {
		return virtualImageQueue;
	}

	public void setVirtualImageQueue(
			BlockingQueue<Command<VirtualImage>> virtualImageQueue) {
		this.virtualImageQueue = virtualImageQueue;
	}

	private VirtualImageAdapter virtualImageAdapter;

	public VirtualImageAdapter getVirtualImageAdapter() {
		return virtualImageAdapter;
	}

	@Autowired
	public void setVirtualImageAdapter(VirtualImageAdapter virtualImageAdapter) {
		this.virtualImageAdapter = virtualImageAdapter;
	}

	public VirtualImageManager() {
	}

	public VirtualImage acquireIdleVirtualImage() {
		return virtualImageDAO.acquireIdleVirtualImage();
	}

	public VirtualImage releaseVirtualImage(Long id) {
		return virtualImageDAO.releaseVirtualImage(id);
	}

	
	@Transactional
	public void purgeVirtualImage(VirtualImage image) {
		if( image != null ) {
			Session session = SessionFactoryUtils.getSession(this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			virtualImageDAO.deleteVirtualImage(image.getId());
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		}
	}
	
	
	@Transactional
	public void updateVirtualImage(VirtualImage image) {
		if (image == null) {
			List<VirtualImage> images = virtualImageAdapter.retrieveVirtualImages();

			if (images != null) {
				LOG.info(images.size() + " VIRTUAL IMAGES DETECTED.");
				Session session = SessionFactoryUtils.getSession(
						this.sessionFactory, true);
				Transaction tx = session.beginTransaction();
				for (VirtualImage img : images) {
					VirtualImage newImage = null;
					VirtualImage foundImage = virtualImageDAO
							.findVirtualImageByUUID(img.getUuid());
					if (foundImage == null) {
						newImage = virtualImageDAO.createVirtualImage(img);
					} else {
						img.setId(foundImage.getId());
						newImage = virtualImageDAO.updateVirtualImage(img);
					}

					if (newImage != null) {
						this.notifyToWorker(new Command<VirtualImage>("ADD",
								newImage));
					}
				}
				tx.commit();
				SessionFactoryUtils
						.releaseSession(session, this.sessionFactory);
			} else {
				LOG.info("VIRTUAL IMAGES UPDATE FAILED.");
			}

			return;
		} else {
			VirtualImage retrievedImage = virtualImageAdapter
					.retrieveVirtualImage(image.getUuid());
			if (retrievedImage != null) {
				retrievedImage.setId(image.getId());

				Session session = SessionFactoryUtils.getSession(
						this.sessionFactory, true);
				Transaction tx = session.beginTransaction();
				VirtualImage updatedImage = virtualImageDAO
						.updateVirtualImage(retrievedImage);
				tx.commit();
				SessionFactoryUtils
						.releaseSession(session, this.sessionFactory);

				if (updatedImage != null) {
					this.notifyToWorker(new Command<VirtualImage>("ADD",
							updatedImage));
				}
				// LOG.info("VIRTUAL IMAGE ( " + retrievedImage.getId() +
				// " ) : " + retrievedImage.getState());
			} else {
				LOG.info("VIRTUAL IMAGE ( " + image.getId()
						+ " ) UPDATE FAILED");
			}
		}
	}

	public void notifyToWorker(Command<VirtualImage> cmd) {
		try {
			virtualImageQueue.put(cmd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
