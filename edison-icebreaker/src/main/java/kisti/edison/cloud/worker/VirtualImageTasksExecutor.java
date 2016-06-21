/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kisti.edison.cloud.manager.VirtualImageManager;
import kisti.edison.cloud.model.VirtualImage;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

/**
 * @author root
 * 
 */
public class VirtualImageTasksExecutor {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private class VirtualImageTask implements Runnable {
		private VirtualImageManager virtualImageManager;
		private List<VirtualImage> images = new LinkedList<VirtualImage>();

		public VirtualImageTask(VirtualImageManager virtualImageManager,
				List<VirtualImage> images) {
			this.virtualImageManager = virtualImageManager;
			for (int i = 0; i < images.size(); i++) {
				this.images.add(images.get(i));
			}
		}

		public void run() {
			// String threadName = Thread.currentThread().getName();
			// LOG.info(threadName + " task start. ( " +
			// Thread.currentThread().getId() + " )");
			for (int i = 0; i < images.size(); i++) {
				/* DO SOMETHING */
				this.virtualImageManager.updateVirtualImage(images.get(i));
			}
			// LOG.info(threadName + " task end. ( " +
			// Thread.currentThread().getId() + " )");
			LOG.info("VIRTUAL IMAGES ( " + images.size() + " ) UPDATE SUCCESS.");
		}
	}

	private TaskExecutor taskExecutor;

	public VirtualImageTasksExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void executeTasks(VirtualImageManager imageManager,
			Map<Long, VirtualImage> monitoredImages, int nThreads) {
		/* first bootstrapping for images */
		if (monitoredImages.size() == 0) {
			imageManager.updateVirtualImage(null);
		} else {
			List<List<VirtualImage>> imageList = new LinkedList<List<VirtualImage>>();

			for (int i = 0; i < nThreads; i++) {
				imageList.add(new LinkedList<VirtualImage>());
			}
			Iterator<Long> iter = monitoredImages.keySet().iterator();

			int index = 0;
			while (iter.hasNext()) {
				Long key = iter.next();
				imageList.get(index).add(monitoredImages.get(key));
				index++;
				if (index == nThreads)
					index = 0;
			}

			int createdThreads = 0;
			for (int i = 0; i < nThreads; i++) {
				if (imageList.get(i).size() != 0) {
					createdThreads++;
					taskExecutor.execute(new VirtualImageTask(imageManager,
							imageList.get(i)));
				}
			}
			// LOG.info(createdThreads +
			// " threads (virtual image monitoring) executing ...");
		}
	}
}
