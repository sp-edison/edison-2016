package org.kisti.edison.content.portlet.siteQuickLink;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.WindowStateException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

@Controller
@RequestMapping("VIEW")
public class SiteQuickLinkController {
	
	private static Log log = LogFactoryUtil.getLog(SiteQuickLinkController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		
		try {
			
			//create ScienceAppStore Url
			String scienceAppStoreName = "edisonscienceAppstore_WAR_edisonappstoreportlet";
			long scienceAppStorePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), scienceAppStoreName);
			PortletURL scienceAppStoreUrl = PortletURLFactoryUtil.create(request,scienceAppStoreName, scienceAppStorePlid, PortletRequest.RENDER_PHASE);
			scienceAppStoreUrl.setWindowState(LiferayWindowState.MAXIMIZED);
			model.put("scienceAppStoreURL", scienceAppStoreUrl);
			
			
			//create Simulation Url
			String simulationName = "edisonbestsimulation_WAR_edisonsimulationportlet";
			long simulationPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), simulationName);
			PortletURL simulationUrl = PortletURLFactoryUtil.create(request,simulationName, simulationPlid, PortletRequest.RENDER_PHASE);
			simulationUrl.setWindowState(LiferayWindowState.MAXIMIZED);
			model.put("simulationUrl", simulationUrl);
			
			
			//create virtualLabUrl
			String virtuallabName = "edisonvirtuallablist_WAR_edisonvirtuallabportlet";
			long virtualLabPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), virtuallabName);
			PortletURL virtualLabUrl = PortletURLFactoryUtil.create(request,virtuallabName, virtualLabPlid, PortletRequest.RENDER_PHASE);
			virtualLabUrl.setWindowState(LiferayWindowState.MAXIMIZED);
			model.put("virtualLabUrl", virtualLabUrl);
			
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (WindowStateException e) {
			e.printStackTrace();
		}
		
		
	return "/contentList";
	}
}
