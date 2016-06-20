package org.kisti.edison.science.portlet.developerInfomation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.science.service.DeveloperInfoLocalServiceUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")   
public class DeveloperInfomationController {
	private static Log log = LogFactoryUtil.getLog(DeveloperInfomationController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response,ModelMap model) {
		try {
			User user = PortalUtil.getUser(request);
			
			/* Temp User 인지 체크 */
			if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.TEMP_USER)) {
				model.addAttribute("display", "NONE");
			} else {
				model.addAttribute("display", "VIEW");
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "developerInfomation/developerInfomationList";
	}
	
	/* 개인별 개발자 신청상태 조회 */
	@ResourceMapping(value ="developerRequestStatus" )
	public void developerRequestStatus(ResourceRequest request, ResourceResponse response) throws IOException{
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			long groupId = PortalUtil.getScopeGroupId(request);
			long userId = PortalUtil.getUserId(request);
			
			long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();
			List<Map<String, Object>> developerStatus;
			
			// 포털 체크 parentGroupId가 0이면 포털
			if(parentGroupId == 0) {
				developerStatus = DeveloperInfoLocalServiceUtil.getDeveloperRequestStatus(0, userId, null ,locale, 0, 10);
			} else {
				developerStatus = DeveloperInfoLocalServiceUtil.getDeveloperRequestStatus(groupId, userId, null,locale, 0, 10);
			}
			
			JSONObject obj = new JSONObject();
			
			obj.put("developerStatus", developerStatus);
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
