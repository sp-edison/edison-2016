/**
 * 
 */
package kisti.edison.cloud.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author root
 * 
 */
public class HashMapAdapter extends
		XmlAdapter<KeyValuePair[], Map<String, String>> {

	public HashMapAdapter() {
		super();
	}

	@Override
	public KeyValuePair[] marshal(Map<String, String> v) throws Exception {
		List<KeyValuePair> list = new ArrayList<KeyValuePair>();

		for (Iterator<String> it = v.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			String value = v.get(key);
			list.add(new KeyValuePair(key, value));
		}

		return list.toArray(new KeyValuePair[0]);
	}

	@Override
	public Map<String, String> unmarshal(KeyValuePair[] v) throws Exception {
		Map<String, String> contentMap = new HashMap<String, String>();

		for (KeyValuePair pair : v) {
			contentMap.put(pair.getKey(), pair.getValue());
		}

		return contentMap;
	}

}
