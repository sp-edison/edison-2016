/**
 * 
 */
package kisti.edison.cloud.plugin.xen;

import org.opennebula.client.Client;
import org.opennebula.client.OneResponse;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.model.VirtualMachine;
import kisti.edison.cloud.plugin.spec.VirtualMachineAdapter;

/**
 * @author root
 * 
 */
@Component("xenVirtualMachineAdapter")
public class XenVirtualMachineAdapter extends XenAdapter implements
		VirtualMachineAdapter {
	private final static String DEFAULT_VCPUS = "1";

	@Override
	public VirtualMachine allocateVirtualMachine(Host host, VirtualMachine vm) {
		/*
		 * TODO: modify /etc/hosts in both the front-end and vms machines
		 */
		LOG.info("XenVirtualMachineAdapter::allocateVirtualMachine( "
				+ host.getId() + " , " + vm.getId() + " ) called.");

		// String name = "vm" + vm.getId();
		String name = vm.getNics().iterator().next().getVmName();
		double cpu = (((double) vm.getReqCpu()) / (double) 100L);
		Long port = 5900L + vm.getId();

		String vmTemplate = "";
		
		if(Cloud.getInstance().getProp("build.target").equals("KISTI-NANO") 
				|| Cloud.getInstance().getProp("build.target").equals("KISTI-NAP")) {
			vmTemplate = "NAME = "
				+ name
				+ "\n"
				+ "MEMORY = "
				+ vm.getReqMem()
				+ "\n"
				+ "CPU = "
				+ cpu
				+ "\n"
				+ "VCPU = "
				+ vm.getReqVcpus()
				+ "\n"
				+ "OS =    [ BOOTLOADER = \"/usr/bin/pygrub\" ]\n"
				+ "DISK =  [ IMAGE_ID = "
				+ vm.getDisks().iterator().next().getUuid()
				+ ",\n"
				+ "TARGET = \"xvda\",\n"
				+ "DRIVER = \"file:\" ]\n"
				+ "NIC =   [ BRIDGE = virbr0 ]\n"
				+ "NIC =   [ NETWORK_ID = "
				+ vm.getNics().iterator().next().getUuid()
				+ ", IP = "
				+ vm.getNics().iterator().next().getIp()
				+ " ]\n"
				//+ "GRAPHICS = [ TYPE = \"vnc\",\n"
				//+ "LISTEN = \"0.0.0.0\",\n"
				//+ "PORT = "
				//+ port
				//+ ",\n"
				//+ "KEYMAP = \"en-us\" ]\n"
				+ "REQUIREMENTS = \"NAME=\\\""
				+ host.getName()
				+ "\\\"\"\n"
				+ "CONTEXT = [ HOSTNAME = \"$NAME.kisti.re.kr\",\n"
				+ "ROOT_PUBKEY = \"id_rsa.pub\",\n"
				+ "HOSTNAMEABBR = \"$NAME\",\n"
				+ "USERNAME = \"edison\",\n"
				+ "IP_PRIVATE = \"$NIC[IP, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "DNS = \"$NETWORK[DNS, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "GATEWAY = \"$NETWORK[GATEWAY, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "NFS_SERVER = \"10.183.0.10\",\n"
				+ "PBS_SERVER = \"gentoo.kisti.re.kr\",\n"
				+"FILES = \"/ONEADMIN/services/CONTEXT/id_rsa.pub /ONEADMIN/services/CONTEXT/init.sh /ONEADMIN/services/CONTEXT/dns.sh /ONEADMIN/services/CONTEXT/hosts.sh /ONEADMIN/services/CONTEXT/iface.sh /ONEADMIN/services/CONTEXT/pbs_mom_conf.sh /ONEADMIN/services/CONTEXT/pbs_mom\",\n"
				+ "TARGET = \"xvdb\" ]\n";
		}
		
		if(Cloud.getInstance().getProp("build.target").equals("KISTI-NANO-EN")) {
			vmTemplate = "NAME = "
				+ name
				+ "\n"
				+ "MEMORY = "
				+ vm.getReqMem()
				+ "\n"
				+ "CPU = "
				+ cpu
				+ "\n"
				+ "VCPU = "
				+ vm.getReqVcpus()
				+ "\n"
				+ "OS =    [ BOOTLOADER = \"/usr/bin/pygrub\" ]\n"
				+ "DISK =  [ IMAGE_ID = "
				+ vm.getDisks().iterator().next().getUuid()
				+ ",\n"
				+ "TARGET = \"xvda\",\n"
				+ "DRIVER = \"file:\" ]\n"
				+ "NIC =   [ BRIDGE = virbr0 ]\n"
				+ "NIC =   [ NETWORK_ID = "
				+ vm.getNics().iterator().next().getUuid()
				+ ", IP = "
				+ vm.getNics().iterator().next().getIp()
				+ " ]\n"
				//+ "GRAPHICS = [ TYPE = \"vnc\",\n"
				//+ "LISTEN = \"0.0.0.0\",\n"
				//+ "PORT = "
				//+ port
				//+ ",\n"
				//+ "KEYMAP = \"en-us\" ]\n"
				+ "REQUIREMENTS = \"NAME=\\\""
				+ host.getName()
				+ "\\\"\"\n"
				+ "CONTEXT = [ HOSTNAME = \"$NAME.kisti.re.kr\",\n"
				+ "ROOT_PUBKEY = \"id_rsa.pub\",\n"
				+ "HOSTNAMEABBR = \"$NAME\",\n"
				+ "USERNAME = \"edison\",\n"
				+ "IP_PRIVATE = \"$NIC[IP, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "DNS = \"$NETWORK[DNS, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "GATEWAY = \"$NETWORK[GATEWAY, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "NFS_SERVER = \"10.183.0.10\",\n"
				+ "PBS_SERVER = \"macaroni.kisti.re.kr\",\n"
				+"FILES = \"/ONEADMIN/services/CONTEXT/id_rsa.pub /ONEADMIN/services/CONTEXT/init.sh /ONEADMIN/services/CONTEXT/dns.sh /ONEADMIN/services/CONTEXT/hosts.sh /ONEADMIN/services/CONTEXT/iface.sh /ONEADMIN/services/CONTEXT/pbs_mom_conf.sh /ONEADMIN/services/CONTEXT/pbs_mom\",\n"
				+ "TARGET = \"xvdb\" ]\n";
		}
		
		if(Cloud.getInstance().getProp("build.target").equals("GPLUS") || Cloud.getInstance().getProp("build.target").equals("TEST")) {
			vmTemplate = "NAME = "
				+ name
				+ "\n"
				+ "MEMORY = "
				+ vm.getReqMem()
				+ "\n"
				+ "CPU = "
				+ cpu
				+ "\n"
				+ "VCPU = "
				+ vm.getReqVcpus()
				+ "\n"
				+ "OS =    [ BOOTLOADER = \"/usr/bin/pygrub\" ]\n"
				+ "DISK =  [ IMAGE_ID = "
				+ vm.getDisks().iterator().next().getUuid()
				+ ",\n"
				+ "TARGET = \"xvda\",\n"
				+ "DRIVER = \"file:\" ]\n"
				+ "NIC =   [ BRIDGE = virbr0 ]\n"
				+ "NIC =   [ NETWORK_ID = "
				+ vm.getNics().iterator().next().getUuid()
				+ ", IP = "
				+ vm.getNics().iterator().next().getIp()
				+ " ]\n"
				+ "GRAPHICS = [ TYPE = \"vnc\",\n"
				+ "LISTEN = \"0.0.0.0\",\n"
				+ "PORT = "
				+ port
				+ ",\n"
				+ "KEYMAP = \"en-us\" ]\n"
				+ "REQUIREMENTS = \"NAME=\\\""
				+ host.getName()
				+ "\\\"\"\n"
				+ "CONTEXT = [ HOSTNAME = \"$NAME.gplus.co.kr\",\n" 
				+ "HOSTNAMEABBR = \"$NAME\",\n"
				+ "USERNAME = \"edison\",\n"
				+ "IP_PRIVATE = \"$NIC[IP, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "DNS = \"$NETWORK[DNS, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "GATEWAY = \"$NETWORK[GATEWAY, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "NFS_SERVER = \"10.10.0.245\",\n"
				+ "PBS_SERVER = \"fe.gplus.co.kr\",\n" 
				+"FILES = \"/vms/services/CONTEXT/init.sh /vms/services/CONTEXT/dns.sh /vms/services/CONTEXT/hosts.sh /vms/services/CONTEXT/iface.sh /vms/services/CONTEXT/pbs_mom_conf.sh /vms/services/CONTEXT/pbs_mom\",\n"
				+ "TARGET = \"xvdb\" ]\n";
		}

		if(Cloud.getInstance().getProp("build.target").equals("KISTI-CHEM")) {
			vmTemplate = "NAME = "
				+ name
				+ "\n"
				+ "MEMORY = "
				+ vm.getReqMem()
				+ "\n"
				+ "CPU = "
				+ cpu
				+ "\n"
				+ "VCPU = "
				+ vm.getReqVcpus()
				+ "\n"
				+ "OS =    [ BOOTLOADER = \"/usr/bin/pygrub\" ]\n"
				+ "DISK =  [ IMAGE_ID = "
				+ vm.getDisks().iterator().next().getUuid()
				+ ",\n"
				+ "TARGET = \"xvda\",\n"
				+ "DRIVER = \"file:\" ]\n"
			//	+ "DISK =  [ TYPE = swap, \n"
			//	+ "DRIVER = \"file:\", \n"
			//	+ "SIZE = 1024, \n"
			//	+ "READONLY = \"no\" ]\n" 
				+ "NIC =   [ BRIDGE = virbr0 ]\n"
				+ "NIC =   [ NETWORK_ID = "
				+ vm.getNics().iterator().next().getUuid()
				+ ", IP = "
				+ vm.getNics().iterator().next().getIp()
				+ " ]\n"
				+ "REQUIREMENTS = \"NAME=\\\""
				+ host.getName()
				+ "\\\"\"\n"
				+ "CONTEXT = [ HOSTNAME = \"$NAME.kisti.re.kr\",\n"
				+ "ROOT_PUBKEY = \"id_rsa.pub\",\n"
				+ "HOSTNAMEABBR = \"$NAME\",\n"
				+ "USERNAME = \"edison\",\n"
				+ "IP_PRIVATE = \"$NIC[IP, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "DNS = \"$NETWORK[DNS, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "GATEWAY = \"$NETWORK[GATEWAY, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "NFS_SERVER = \"10.183.0.10\",\n"
				+ "PBS_SERVER = \"adelie.kisti.re.kr\",\n"
				+"FILES = \"/ONEADMIN/services/CONTEXT/id_rsa.pub /ONEADMIN/services/CONTEXT/init.sh /ONEADMIN/services/CONTEXT/dns.sh /ONEADMIN/services/CONTEXT/hosts.sh /ONEADMIN/services/CONTEXT/iface.sh /ONEADMIN/services/CONTEXT/pbs_mom_conf.sh /ONEADMIN/services/CONTEXT/pbs_mom\",\n"
				+ "TARGET = \"xvdb\" ]\n";
		}
		
		if(Cloud.getInstance().getProp("build.target").equals("KISTI-CHEM-EN")) {
			vmTemplate = "NAME = "
				+ name
				+ "\n"
				+ "MEMORY = "
				+ vm.getReqMem()
				+ "\n"
				+ "CPU = "
				+ cpu
				+ "\n"
				+ "VCPU = "
				+ vm.getReqVcpus()
				+ "\n"
				+ "OS =    [ BOOTLOADER = \"/usr/bin/pygrub\" ]\n"
				+ "DISK =  [ IMAGE_ID = "
				+ vm.getDisks().iterator().next().getUuid()
				+ ",\n"
				+ "TARGET = \"xvda\",\n"
				+ "DRIVER = \"file:\" ]\n"
			//	+ "DISK =  [ TYPE = swap, \n"
			//	+ "DRIVER = \"file:\", \n"
			//	+ "SIZE = 1024, \n"
			//	+ "READONLY = \"no\" ]\n" 
				+ "NIC =   [ BRIDGE = virbr0 ]\n"
				+ "NIC =   [ NETWORK_ID = "
				+ vm.getNics().iterator().next().getUuid()
				+ ", IP = "
				+ vm.getNics().iterator().next().getIp()
				+ " ]\n"
				+ "REQUIREMENTS = \"NAME=\\\""
				+ host.getName()
				+ "\\\"\"\n"
				+ "CONTEXT = [ HOSTNAME = \"$NAME.kisti.re.kr\",\n"
				+ "ROOT_PUBKEY = \"id_rsa.pub\",\n"
				+ "HOSTNAMEABBR = \"$NAME\",\n"
				+ "USERNAME = \"edison\",\n"
				+ "IP_PRIVATE = \"$NIC[IP, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "DNS = \"$NETWORK[DNS, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "GATEWAY = \"$NETWORK[GATEWAY, NETWORK_ID="
				+ vm.getNics().iterator().next().getUuid()
				+ "]\",\n"
				+ "NFS_SERVER = \"10.183.0.10\",\n"
				+ "PBS_SERVER = \"humboldt.kisti.re.kr\",\n"
				+"FILES = \"/ONEADMIN/services/CONTEXT/id_rsa.pub /ONEADMIN/services/CONTEXT/init.sh /ONEADMIN/services/CONTEXT/dns.sh /ONEADMIN/services/CONTEXT/hosts.sh /ONEADMIN/services/CONTEXT/iface.sh /ONEADMIN/services/CONTEXT/pbs_mom_conf.sh /ONEADMIN/services/CONTEXT/pbs_mom\",\n"
				+ "TARGET = \"xvdb\" ]\n";
		}
		
		LOG.info(vmTemplate);
		try {
			Client oneClient = getClient();
			OneResponse rc = org.opennebula.client.vm.VirtualMachine.allocate(
					oneClient, vmTemplate);
			if (rc.isError()) {
				LOG.info("XenVirtualMachineAdapter::allocateVirtualMachine() failed");
				throw new Exception(rc.getErrorMessage());
			}

			LOG.info("newVMID : " + rc.getMessage());
			vm.setName(name);
			vm.setUuid(rc.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return vm;
	}

	@Override
	public VirtualMachine shutdownVirtualMachine(VirtualMachine vm) {
		LOG.info("shutdownVirtualMachine() called.");
		org.opennebula.client.vm.VirtualMachine shutdownVM = null;

		if (vm.getUuid() == null || vm.getUuid().isEmpty()) {
			return null;
		}

		try {
			Client oneClient = getClient();
			shutdownVM = new org.opennebula.client.vm.VirtualMachine(
					Integer.parseInt(vm.getUuid()), oneClient);
			OneResponse rc = shutdownVM.shutdown();
			if (rc.isError()) {
				LOG.info("shutdownVirtualMachine() failed");
				throw new Exception(rc.getErrorMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return vm;
	}

	@Override
	public VirtualMachine retrieveVirtualMachineInfo(VirtualMachine vm) {
		// LOG.info("retrieveVirtualMachineInfo() called.");
		org.opennebula.client.vm.VirtualMachine retrievedVM = null;

		if (vm.getUuid() == null || vm.getUuid().isEmpty()) {
			return null;
		}

		try {
			Client oneClient = getClient();
			retrievedVM = new org.opennebula.client.vm.VirtualMachine(
					Integer.parseInt(vm.getUuid()), oneClient);
			OneResponse rc = retrievedVM.info();

			if (rc.isError()) {
				LOG.info("retrieveVirtualMachineInfo() failed");
				throw new Exception(rc.getErrorMessage());
			}

			if (retrievedVM.stateStr().equals("ACTIVE")) {
				vm.setLcmState(retrievedVM.lcmStateStr());
			} else {
				vm.setLcmState(retrievedVM.stateStr());
			}
			vm.setCpu(Long.parseLong(retrievedVM.xpath("CPU")));
			vm.setMemory(Long.parseLong(retrievedVM.xpath("MEMORY")));
			vm.setNettx(Long.parseLong(retrievedVM.xpath("NET_TX")));
			vm.setNetrx(Long.parseLong(retrievedVM.xpath("NET_RX")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return vm;
	}

	@Override
	public VirtualMachine suspendVirtualMachine(VirtualMachine vm) {
		// TODO Auto-generated method stub
		LOG.info("suspendVirtualMachine() called.");
		org.opennebula.client.vm.VirtualMachine suspendVM = null;

		if (vm.getUuid() == null || vm.getUuid().isEmpty()) {
			return null;
		}

		if (!vm.getState().equals(VirtualMachine.VirtualMachineState.RUNNING)
				|| !vm.getLcmState().equals("RUNNING")) {
			return null;
		}

		try {
			Client oneClient = getClient();
			suspendVM = new org.opennebula.client.vm.VirtualMachine(
					Integer.parseInt(vm.getUuid()), oneClient);
			OneResponse rc = suspendVM.suspend();
			if (rc.isError()) {
				LOG.info("suspendVirtualMachine() failed");
				throw new Exception(rc.getErrorMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return vm;
	}

	@Override
	public VirtualMachine resumeVirtualMachine(VirtualMachine vm) {
		// TODO Auto-generated method stub
		LOG.info("resumeVirtualMachine() called.");
		org.opennebula.client.vm.VirtualMachine resumeVM = null;

		if (vm.getUuid() == null || vm.getUuid().isEmpty()) {
			return null;
		}

		if (!vm.getState().equals(VirtualMachine.VirtualMachineState.SUSPENDED)
				|| !vm.getLcmState().equals("SUSPENDED")) {
			return null;
		}

		try {
			Client oneClient = getClient();
			resumeVM = new org.opennebula.client.vm.VirtualMachine(
					Integer.parseInt(vm.getUuid()), oneClient);
			OneResponse rc = resumeVM.resume();
			if (rc.isError()) {
				LOG.info("resumeVirtualMachine() failed");
				throw new Exception(rc.getErrorMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return vm;
	}

	@Override
	public VirtualMachine migrateVirtualMacine(Host destHost, VirtualMachine vm) {
		// TODO Auto-generated method stub
		return null;
	}

}
