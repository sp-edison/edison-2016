package org.kisti.edison.bestsimulation.portlet.simulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
import javax.servlet.ServletContext;

import org.kisti.edison.util.CustomUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletConfigFactoryUtil;

public class ConfigurationController implements ConfigurationAction{

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		preferenceOption(actionRequest,actionResponse);
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
		List<Group> parentGroupList = GroupLocalServiceUtil.getGroups(companyId, 0, true);
		Group parentGroup = null;
		for(Group group:parentGroupList){
			if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){
				parentGroup = group;
				break;
			}
		}
		
		List<Group> groupList = CustomUtil.getGroupIdASC(GroupLocalServiceUtil.getGroups(companyId, parentGroup.getGroupId(), true));
		renderRequest.setAttribute("groupList", groupList);
		
		String tabUseStr = renderRequest.getPreferences().getValue("tabUseList", "");
		List<Group> tabGroup = new ArrayList<Group>();
		if(!tabUseStr.equals("")){
			String[] tabUseArray = tabUseStr.split(",");
			
			for(int i=0; i<tabUseArray.length; i++){
				Long selectGroupId = Long.parseLong(CustomUtil.strNull(tabUseArray[i]));
				
				Group group = GroupLocalServiceUtil.getGroup(selectGroupId);
				tabGroup.add(group);
			}
		}
		renderRequest.setAttribute("tabGroup", tabGroup);
		
		PortletConfig selPortletConfig = getSelPortletConfig(renderRequest);

		String configTemplate = selPortletConfig.getInitParameter("config-template");
		if (Validator.isNotNull(configTemplate)) {
			return configTemplate;
		}
		
		
		String configJSP = selPortletConfig.getInitParameter("config-jsp");
		
		if (Validator.isNotNull(configJSP)) {
			return configJSP;
		}
		return "configuration.jsp";
	}
	
	public void preferenceOption(ActionRequest actionRequest, ActionResponse actionResponse) throws ReadOnlyException, ValidatorException, IOException {
		PortletPreferences prefs = actionRequest.getPreferences();
		
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
		
		
		String[] keyTextBox		= actionRequest.getParameterValues("keyTextBox");
		String[] valueTextBox	= actionRequest.getParameterValues("valueTextBox");
		String[] tabUseValue	= actionRequest.getParameterValues("tabUseValue");
		
		if(keyTextBox != null){
			for(int i=0;i<keyTextBox.length;i++){
				if(CustomUtil.strNull(keyTextBox[i]).equals("")) continue;
												
				prefs.setValue(keyTextBox[i], String.valueOf(valueTextBox[i]));
			}
		}		
		if(tabUseValue != null){
			prefs.setValues("tabUseList", tabUseValue);
		}		
		prefs.store();
	}
	
	protected PortletConfig getSelPortletConfig(PortletRequest portletRequest)throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portletResource = ParamUtil.getString(portletRequest, "portletResource");
		Portlet selPortlet = PortletLocalServiceUtil.getPortletById(themeDisplay.getCompanyId(), portletResource);
		ServletContext servletContext = (ServletContext)portletRequest.getAttribute(WebKeys.CTX);
		PortletConfig selPortletConfig = PortletConfigFactoryUtil.create(selPortlet, servletContext);

		return selPortletConfig;
	}
}
