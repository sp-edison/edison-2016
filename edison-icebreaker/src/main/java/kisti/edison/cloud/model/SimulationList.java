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
@XmlRootElement(name = "simulation_list")
public class SimulationList {
	private int count;
	private List<Simulation> simulations;

	public SimulationList() {

	}

	public SimulationList(List<Simulation> simulations) {
		this.setSimulations(simulations);
		this.setCount(simulations.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "simulation_info")
	public List<Simulation> getSimulations() {
		return simulations;
	}

	public void setSimulations(List<Simulation> simulations) {
		this.simulations = simulations;
	}

}
