/**
 * 
 */
package kisti.edison.cloud.test;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

/**
 * @author root
 * 
 */
public class TaskExecutorExample {
	private final Logger logger = Logger.getLogger(this.getClass());

	private class MessagePrinterTask implements Runnable {
		private String message;

		public MessagePrinterTask(String message) {
			this.message = message;
		}

		public void run() {
			logger.info(Thread.currentThread().getId() + " " + message);
		}
	}

	private TaskExecutor taskExecutor;

	public TaskExecutorExample(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void printMessages() {
		for (int i = 0; i < 25; i++) {
			taskExecutor.execute(new MessagePrinterTask("Message" + i));
		}
	}
}
