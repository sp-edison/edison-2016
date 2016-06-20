package org.kisti.edison.science.portlet.favoriteApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.science.service.ScienceAppFavoriteLocalServiceUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")   
public class FavoriteAppController {
	
	private static Log log = LogFactoryUtil.getLog(FavoriteAppController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response,ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			PortletLocalServiceUtil.getPortletApp("edison-scienceAppstore");
			
			long simulationPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonbestsimulation_WAR_edisonsimulationportlet");
			long appstorePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonscienceAppstore_WAR_edisonappstore2016portlet");
			
			model.addAttribute("simulationPlid", simulationPlid);
			model.addAttribute("appstorePlid", appstorePlid);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "favoriteApp/favoriteAppList";
	}
	
	/* 나의 즐겨찾기 앱 목록 조회 */
	@ResourceMapping(value ="favoriteAppList" )
	public void favoriteAppList(ResourceRequest request, ResourceResponse response) throws IOException{
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Map params = RequestUtil.getParameterMap(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long userId = PortalUtil.getUserId(request);
			long companyId = PortalUtil.getCompanyId(request);
			Locale locale = themeDisplay.getLocale();
			
			List<Map<String, Object>> favoriteAppList = ScienceAppFavoriteLocalServiceUtil.getFavoriteAppList(companyId, groupId, userId, locale, true);

			List favoriteAppManualList =  new ArrayList();
			Map manualMap = null;
			for (int i = 0; i < favoriteAppList.size(); i++) {
				List solverManualList = EdisonFileUtil.getListEdisonFile(groupId, "solver_manual", String.valueOf(favoriteAppList.get(i).get("scienceAppId")), EdisonFileConstants.SCIENCE_APPS);	
				manualMap = new HashMap();
				if(solverManualList != null && solverManualList.size() > 0) {
					manualMap.put("fileEntryId", ((Map)solverManualList.get(0)).get("fileEntryId"));
				} 
				favoriteAppManualList.add(manualMap);
			}
			
			JSONObject obj = new JSONObject();
			
			obj.put("favoriteAppManualList", favoriteAppManualList);
			obj.put("favoriteAppList", favoriteAppList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/* 즐겨찾기 앱 삭제 */
	@ResourceMapping(value ="deleteFavoriteApp" )
	public void deleteFavoriteApp(ResourceRequest request, ResourceResponse response) throws IOException{
		try {
			String result = "200";
			Map params = RequestUtil.getParameterMap(request);
			long userId = PortalUtil.getUserId(request);
			long scienceAppId = GetterUtil.get(params.get("solverId"), 0L);
			long groupId = GetterUtil.get(params.get("groupId"), 0L);
			ScienceAppFavoriteLocalServiceUtil.deleteFavoriteApp(scienceAppId, userId);
			
			JSONObject obj = new JSONObject();
			
			obj.put("result", result);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
		}
	}
}
