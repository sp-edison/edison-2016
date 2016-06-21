/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.model.VirtualImage;

/**
 * @author root
 * 
 */
@Repository("virtualImageDAO")
@SuppressWarnings("unchecked")
public class VirtualImageDAOImpl extends HibernateDAO implements
		VirtualImageDAO {

	@Override
	public List<VirtualImage> getVirtualImages() {
		Session session = getSession();
		List<VirtualImage> images = session.createQuery(
				"from VirtualImage order by id").list();

		return images;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.VirtualImageDAO#findVirtualImageByUUID(java.lang
	 * .String)
	 */
	@Override
	public VirtualImage findVirtualImageByUUID(String uuid) {
		Assert.hasText(uuid);
		Session session = getSession();
		String query = "from VirtualImage image where image.uuid = :uuid";
		VirtualImage image = (VirtualImage) session.createQuery(query)
				.setString("uuid", uuid).uniqueResult();
		return image;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.VirtualImageDAO#createVirtualImage(kisti.edison
	 * .cloud.model.VirtualImage)
	 */
	@Override
	public VirtualImage createVirtualImage(VirtualImage image) {
		if (image.getUuid().isEmpty()) {
			return null;
		}

		Session session = getSession();
		session.save(image);
		session.flush();

		return image;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.VirtualImageDAO#updateVirtualImage(kisti.edison
	 * .cloud.model.VirtualImage)
	 */
	@Override
	public VirtualImage updateVirtualImage(VirtualImage image) {
		Session session = getSession();

		VirtualImage loadedImage = (VirtualImage) session.load(
				VirtualImage.class, image.getId());
		loadedImage.setUuid(image.getUuid());
		loadedImage.setName(image.getName());
		loadedImage.setType(image.getType());
		loadedImage.setState(image.getState());
		loadedImage.setSource(image.getSource());
		loadedImage.setSize(image.getSize());
		session.flush();

		return loadedImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.VirtualImageDAO#deleteVirtualImage(java.lang.Long)
	 */
	@Override
	public VirtualImage deleteVirtualImage(Long id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		VirtualImage image = (VirtualImage) session.get(VirtualImage.class, id);
		if(image != null) {
			session.delete(image);
			session.flush();
		}
		return image;
	}

	@Override
	public VirtualImage acquireIdleVirtualImage() {
		Session session = getSession();
		String query = "from VirtualImage image where image.localUsed = :localUsed";
		List<VirtualImage> images = session.createQuery(query)
				.setBoolean("localUsed", false).list();

		if (images.size() == 0) {
			return null;
		}

		VirtualImage loadedImage = (VirtualImage) session.load(
				VirtualImage.class, images.get(0).getId());
		loadedImage.setLocalUsed(true);
		session.flush();

		return images.get(0);
	}

	@Override
	public VirtualImage releaseVirtualImage(Long id) {
		Session session = getSession();

		VirtualImage loadedImage = (VirtualImage) session.load(
				VirtualImage.class, id);
		loadedImage.setLocalUsed(false);
		session.flush();

		return loadedImage;
	}

}
