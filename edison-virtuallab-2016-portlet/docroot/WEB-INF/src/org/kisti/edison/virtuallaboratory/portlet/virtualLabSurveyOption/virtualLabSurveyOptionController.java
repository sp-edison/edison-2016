package org.kisti.edison.virtuallaboratory.portlet.virtualLabSurveyOption;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.service.SurveyLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class virtualLabSurveyOptionController {
	private static Log log = LogFactoryUtil.getLog(virtualLabSurveyOptionController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getScopeGroupId();
	//		Group group = GroupLocalServiceUtil.getGroup(groupId);
			
			Map<String, Object> params = RequestUtil.getParameterMap(httpRequest);
			
	//		User user = PortalUtil.getUser(request);
			
			for (Map.Entry<String,Object> str : params.entrySet()) {
				if(str.getKey().contains("virtualLabId")) {
					model.addAttribute("virtualLabId", str.getValue());
				}
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "virtualLabSurveyOption/surveyManager";
	}
	
	@ResourceMapping(value="getSurveyOption")
	public void getSurveyOption(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
		
		List<Map<String, Object>> surveyOption = SurveyLocalServiceUtil.getSurveyMappingList(virtualLabId, false, locale);
		
		JSONObject obj = new JSONObject();
		
		obj.put("surveyOption", surveyOption);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ResourceMapping(value="getSurveyList")
	public void getSurveyList(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
		
		List<Map<String, Object>> surveyList = SurveyLocalServiceUtil.getSurveyMappingCheckList(virtualLabId, false, locale);
		
		JSONObject obj = new JSONObject();
		
		obj.put("surveyList", surveyList);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ActionMapping(params = "myaction=updateSurveyStatus")
	public void updateSurveyStatus(ActionRequest request, ActionResponse response) {
		try {
			Map params = RequestUtil.getParameterMap(request);
			long virtualLabId = ParamUtil.get(request, "virtualLabId", 0L);
			long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0L);
			
			SurveyLocalServiceUtil.deleteVirtualLabSurvey(virtualLabId);
			if(surveySeqNo > 0) {
				SurveyLocalServiceUtil.addVirtualLabSurvey(virtualLabId, surveySeqNo);
			}
			response.setRenderParameter("virtualLabId", ParamUtil.get(request, "virtualLabId", "0"));

			SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
		}
	}
}
