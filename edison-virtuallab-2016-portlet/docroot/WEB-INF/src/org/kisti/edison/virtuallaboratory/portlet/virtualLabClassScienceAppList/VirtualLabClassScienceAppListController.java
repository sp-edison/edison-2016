package org.kisti.edison.virtuallaboratory.portlet.virtualLabClassScienceAppList;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassScienceAppLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class VirtualLabClassScienceAppListController {
	private static Log log = LogFactoryUtil.getLog(VirtualLabClassScienceAppListController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
			String classId = GetterUtil.get(httpRequest.getParameter("classId"), "0");
			User user = PortalUtil.getUser(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long companyId = PortalUtil.getCompanyId(request);
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			
			Role virtualLabOwner = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
			Role virtualLabClassOwner = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
			Role virtualLabClassManager = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);
			
			Map<String, String> classInfo = VirtualLabClassLocalServiceUtil.getVirtualClassMainVisual(Long.parseLong(classId), locale);
			
			if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)	// PORTAL ADMINISTRATOR 체크
					|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)	// SITE ADMINSTRATOR	체크
					|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)	// SITE OWNER 체크
					|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwner.getRoleId(), Long.parseLong(classInfo.get("virtualLabId")))
					|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabClassOwner.getRoleId(), Long.parseLong(classId))
					|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabClassManager.getRoleId(), Long.parseLong(classId))) // VIRTUAL LAB OWNER CHECK
			{
				model.addAttribute("role", "admin");
			} else {
				model.addAttribute("role", "member");
			}
			
			long simulationPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonbestsimulation_WAR_edisonsimulationportlet");
			long appstorePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonscienceAppstore_WAR_edisonappstore2016portlet");
			
			model.addAttribute("simulationPlid", simulationPlid);
			model.addAttribute("appstorePlid", appstorePlid);
	
			model.addAttribute("classId", classId);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "virtualLabClassScienceAppList/virtualLabClassScienceAppList";
	}
	
	@ResourceMapping(value="virtualLabScienceAppList")
	public void getVirtualLabScienceAppList(ResourceRequest request, ResourceResponse response) throws Exception {
		Map params = RequestUtil.getParameterMap(request);
		long classId = GetterUtil.get(params.get("classId"), 0);
		long groupId = PortalUtil.getScopeGroupId(request);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		List<Map<String, Object>> virtualLabScienceAppList = VirtualLabClassScienceAppLocalServiceUtil.getVirtualLabClassScienceAppList(themeDisplay.getCompanyId(), groupId, classId, locale);
		
		List virtualScienceAppManualList =  new ArrayList();
		Map manualMap = null;
		for (int i = 0; i < virtualLabScienceAppList.size(); i++) {
			List scienceAppManualList = EdisonFileUtil.getListEdisonFile(themeDisplay.getScopeGroupId(), "scienceApp_manual", String.valueOf(virtualLabScienceAppList.get(i).get("scienceAppId")), EdisonFileConstants.SCIENCE_APPS);	
			manualMap = new HashMap();
			if(scienceAppManualList != null && scienceAppManualList.size() > 0) {
				manualMap.put("fileEntryId", ((Map)scienceAppManualList.get(0)).get("fileEntryId"));
			} 
			virtualScienceAppManualList.add(manualMap);
		}
		
		JSONObject obj = new JSONObject();
		obj.put("virtualLabScienceAppList", virtualLabScienceAppList);
		obj.put("virtualScienceAppManualList", virtualScienceAppManualList);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@RenderMapping(params = "myaction=popupScienceAppList")
	public String popupScienceAppList(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			String classId = ParamUtil.get(request, "classId", "0");
			model.addAttribute("classId", classId);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "virtualLabClassScienceAppList/scienceAppPopupList";
	}
	
	@ResourceMapping(value="getScienceAppList")
	public void getScienceAppList(ResourceRequest request, ResourceResponse response) throws Exception {
		Map params = RequestUtil.getParameterMap(request);
		long classId = GetterUtil.get(params.get("classId"), 0);
		long groupId = PortalUtil.getScopeGroupId(request);
		String searchField = GetterUtil.get(params.get("searchField"), "");
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyGroupId = themeDisplay.getCompany().getGroupId();
		Locale locale = themeDisplay.getLocale();
		
		List<Map<String, Object>> virtualLabScienceAppList = VirtualLabClassScienceAppLocalServiceUtil.getScienceAppList(themeDisplay.getCompanyId(), groupId, classId, searchField, locale);
		
		JSONObject obj = new JSONObject();
		obj.put("virtualLabScienceAppList", virtualLabScienceAppList);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	/**
	 * 클래스 솔버 insert
	 **/
	@ResourceMapping(value ="classScienceAppInsert" )
	public void classSolveInsert(ResourceRequest request, ResourceResponse response) throws IOException, SystemException, PortalException, SQLException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		Map params = RequestUtil.getParameterMap(request);
		long classId = GetterUtil.get(params.get("classId"), 0L);
		long groupId = PortalUtil.getScopeGroupId(request);
		Object scienceAppCheck = params.get("scienceAppCheck");
		
		VirtualLabClassScienceAppLocalServiceUtil.insertVirtualLabClassScienceAppList(themeDisplay.getCompanyId(), classId, groupId, scienceAppCheck, themeDisplay.getLocale());
		
		writer.write("SUCCESS");
		
		writer.close();
	}
}
