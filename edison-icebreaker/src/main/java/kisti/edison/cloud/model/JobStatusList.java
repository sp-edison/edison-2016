/**
 * 
 */
package kisti.edison.cloud.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jlyu
 * 
 */
@XmlRootElement(name = "jobList")
public class JobStatusList {
	private int count;
	private List<JobStatus> jobStatues;

	public JobStatusList() {
	}

	public JobStatusList(List<JobStatus> statues) {
		this.setJobStatues(statues);
		this.setCount(statues.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "jobStatus")
	public List<JobStatus> getJobStatues() {
		return jobStatues;
	}

	public void setJobStatues(List<JobStatus> jobStatues) {
		this.jobStatues = jobStatues;
	}

}
