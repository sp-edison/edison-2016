package org.kisti.edison.multiboard.controller.multitab;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.RequestUtil;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class ConfigurationController extends DefaultConfigurationAction {
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)	throws Exception {
		RequestUtil.getParameterMap(actionRequest);
		
		PortletPreferences prefs = actionRequest.getPreferences();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);				
		
		Set es = prefs.getMap().entrySet();
		Iterator entries = null;
		if(es != null){
			entries = es.iterator();
		}
		while (entries.hasNext()) {
			Map.Entry<String, String[]> thisEntry = (Map.Entry) entries.next();
			String key = CustomUtil.strNull(thisEntry.getKey());
			prefs.reset(key);
		}
		
		String[] keyPlid = actionRequest.getParameterValues("numberArray");
		if(keyPlid != null){
			prefs.setValues("numberArray", keyPlid);
			
			for(int i=0;i<keyPlid.length;i++){
				if(CustomUtil.strNull(keyPlid[i]).equals("")) continue;
				prefs.setValue(keyPlid[i] + "_friendlyURL", ParamUtil.get(actionRequest, keyPlid[i] + "_friendlyURL", ""));
			}
		}
		
		prefs.store();
	}

}
