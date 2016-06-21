/**
 * 
 */
package kisti.edison.cloud.env;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author jlyu
 *
 */
public class ResourceConf {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private static ResourceConf conf = null;
	
	private Map<String, Map<String, String>> env;
	
	private ResourceConf() {
		this.env = new HashMap<String, Map<String,String>>();
	}
	
	public static ResourceConf getConf() {
		if(conf == null) {
			conf = new ResourceConf();
		}
		return conf;
	}
	
	public void setProp(String key, Map<String,String> values) {
		this.env.put(key, values);
	}
	
	public Map<String,String> getProp(String key) {
		return this.env.get(key);
	}
	
	@Override
	public String toString() {
		String ret = "\n";
		Iterator<String> iter = this.env.keySet().iterator();
		while (iter.hasNext()) {
			String k = iter.next();
			ret += ("[CONF] " + k + ":" + this.env.get(k).toString() + "\n");
		}

		return ret;
	}
}
