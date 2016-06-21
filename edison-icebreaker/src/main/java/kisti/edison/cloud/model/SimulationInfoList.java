/**
 * 
 */
package kisti.edison.cloud.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author root
 * 
 */
@XmlRootElement(name = "simulations")
public class SimulationInfoList {
	private int count;
	private List<SimulationInfo> simulations;

	public SimulationInfoList() {

	}

	public SimulationInfoList(List<SimulationInfo> simulations) {
		this.setSimulations(simulations);
		this.setCount(simulations.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "simulation")
	public List<SimulationInfo> getSimulations() {
		return simulations;
	}

	public void setSimulations(List<SimulationInfo> simulations) {
		this.simulations = simulations;
	}
}
