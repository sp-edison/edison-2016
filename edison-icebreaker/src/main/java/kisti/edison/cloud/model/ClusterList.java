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
@XmlRootElement(name = "clusters")
public class ClusterList {
	private int count;
	private List<Cluster> clusters;

	public ClusterList() {
	}

	public ClusterList(List<Cluster> clusters) {
		this.setClusters(clusters);
		this.setCount(clusters.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "cluster")
	public List<Cluster> getClusters() {
		return clusters;
	}

	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}
}
