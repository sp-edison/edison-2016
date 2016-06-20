package org.kisti.edison.science.portlet.InputDeck;

import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.kisti.edison.science.service.PortTypeInputdeckFormLocalServiceUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

@Controller
@RequestMapping("VIEW")
public class InputDeckController {
	private static Log log = LogFactoryUtil.getLog(InputDeckController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response,ModelMap model) throws PortalException, SystemException {
		Map params = RequestUtil.getParameterMap(request);
		/*
		String portletMode = GetterUtil.getString(params.get("portletMode"),Constants.VIEW);
		
		String renderJsp = "inputdeck/"+portletMode;
		long portTypeId = ParamUtil.get(request, "taskId", 0L);
		String portData = ParamUtil.get(request, "portData", "");
		
		if (!portData.equals("")) {
			model.addAttribute("JsonData", portData);
		} else if (portTypeId > 0) {
			String JsonData = PortTypeInputdeckFormLocalServiceUtil.getInputdeckFormJsonString(portTypeId);
			model.addAttribute("JsonData", JsonData);
		}
		
		String portName = ParamUtil.get(request, "portName", "");
		
		model.addAttribute("scienceAppId", portTypeId);
		model.addAttribute("portName", portName);
		*/
		String portletMode = GetterUtil.getString(params.get("portletMode"),Constants.EDIT);
		String renderJsp = "inputdeck/"+portletMode;
		
		model.addAttribute("targetLanuage", "full");
		model.addAttribute("defaultLanguage", "ko_KR");
		model.addAttribute("availableLanguages", "{ko_KR,en_US}");
		return renderJsp;
	}
}
