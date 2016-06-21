/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.VirtualImageManager;
import kisti.edison.cloud.model.VirtualImage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author root
 * 
 */
@Component
public class VirtualImageMonitoringWorker {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private Map<Long, VirtualImage> monitoredImages = new HashMap<Long, VirtualImage>();

	private VirtualImageTasksExecutor virtualImageTasksExecutor;

	public VirtualImageTasksExecutor getVirtualImageTasksExecutor() {
		return virtualImageTasksExecutor;
	}

	@Autowired
	public void setVirtualImageTasksExecutor(
			VirtualImageTasksExecutor virtualImageTasksExecutor) {
		this.virtualImageTasksExecutor = virtualImageTasksExecutor;
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

	private VirtualImageManager imageManager;

	public VirtualImageManager getImageManager() {
		return imageManager;
	}

	@Autowired
	public void setImageManager(VirtualImageManager imageManager) {
		this.imageManager = imageManager;
	}

	public void dispatchTasks() {
		// LOG.info(Thread.currentThread().getName() + " start.");

		try {
			// LOG.info("VI QUEUE SIZE : " + virtualImageQueue.size());
			while (virtualImageQueue.size() != 0) {

				Command<VirtualImage> cmd = virtualImageQueue.take();
				if (cmd.getType() == "ADD") {
					if (monitoredImages.put(cmd.getData().getId(),
							cmd.getData()) == null) {
						// LOG.info("VirtualImage ( ID : " +
						// cmd.getData().getId() + " ) monitoring added.");
					} else {
						// LOG.info("VirtualImage ( ID : " +
						// cmd.getData().getId() +
						// " ) replaced in monitored pool.");
					}
				} else if (cmd.getType() == "DELETE") {
					if (monitoredImages.remove(cmd.getData().getId()) != null) {
						// LOG.info("VirtualImage ( ID : " +
						// cmd.getData().getId() + " ) monitoring deleted.");
					} else {
						// LOG.info("VirtualImage ( ID : " +
						// cmd.getData().getId() +
						// " ) not found in monitored pool.");
					}
				}
			}

			LOG.info("MONITORED VI SIZE : " + monitoredImages.size());
			// this.virtualImageTasksExecutor.executeTasks(this.imageManager,
			// monitoredImages, 8);
			this.virtualImageTasksExecutor.executeTasks(this.imageManager, monitoredImages, 1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		// LOG.info(Thread.currentThread().getName() + " end.");
	}
}
