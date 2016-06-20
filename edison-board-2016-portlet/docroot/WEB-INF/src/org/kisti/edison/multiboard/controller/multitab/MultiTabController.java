package org.kisti.edison.multiboard.controller.multitab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.permission.LayoutPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;

@Controller
@RequestMapping("VIEW")
public class MultiTabController {
	
	protected static Log  log = LogFactoryUtil.getLog(MultiTabController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		PortletPreferences prefs = request.getPreferences();
		
		String[] numberArray = prefs.getValues("numberArray", new String[]{});
		List<Map<String, String>> tabList = new ArrayList<Map<String, String>>();
		
		if (numberArray.length > 0 && numberArray != null) {
			for (int i = 0; i < numberArray.length; i++) {
				String friendlyURL = prefs.getValue(numberArray[i] + "_friendlyURL", "");
				Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, friendlyURL);
				boolean layoutViewPermission = LayoutPermissionUtil.contains(PermissionCheckerFactoryUtil.create(themeDisplay.getUser(), true), layout, ActionKeys.VIEW);

				if(!layout.isHidden() && layoutViewPermission){
					Map<String, String> tabMap = new HashMap<String, String>();
					
					tabMap.put("tabTitle", layout.getName(themeDisplay.getLocale()));
					tabMap.put("tabPlid", String.valueOf(layout.getPlid()));
					tabMap.put("tabType", StringUtil.toUpperCase(layout.getType()));
					if(StringUtil.toUpperCase(layout.getType()).equals("URL")) {
						tabMap.put("tabURL", layout.getExpandoBridge().getAttribute(LanguageUtil.format(locale, "edison-menu-link-custom-field", "")).toString());
					} else {
						PortletURL classURL = PortletURLFactoryUtil.create(request, "", layout.getPlid(), PortletRequest.RENDER_PHASE);
						tabMap.put("tabURL", classURL.toString());
					}
					tabList.add(tabMap);
				}
			}
		}
		
		model.addAttribute("tabList", tabList);
		return "multitab/view";
	}

}
