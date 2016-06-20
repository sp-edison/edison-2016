package org.kisti.edison.project.portlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.project.service.HistoryContentLocalServiceUtil;
import org.kisti.edison.project.service.HistoryScienceAppLocalServiceUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class RegisterStatisticsController {
	
	private static Log log = LogFactoryUtil.getLog(RegisterStatisticsController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		return "statistics/register";
	}
	
	@ResourceMapping(value="getStatistics")
	public void getStatisticsExec(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, ParseException, JSONException, IOException{
		Map params = RequestUtil.getParameterMap(request);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		
		try {
			JSONObject obj = new JSONObject();

			obj.put("scienceAppCenterList", HistoryScienceAppLocalServiceUtil.getScienceAppCenterList("SITE", themeDisplay.getLocale()));
			obj.put("contentCenterList", HistoryContentLocalServiceUtil.getContentCenterList("Y","SITE", themeDisplay.getLocale()));
			
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
}
