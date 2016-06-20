package org.kisti.edison.virtuallaboratory.portlet.virtualLabManagementList;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class VirtualLabManagementController {
	private static Log log = LogFactoryUtil.getLog(VirtualLabManagementController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = PortalUtil.getScopeGroupId(request);
			
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			
			long labPlid = PortalUtil.getPlidFromPortletId(groupId, "edisonvirtuallabmainvisual_WAR_edisonvirtuallab2016portlet");
			PortletURL labURL = PortletURLFactoryUtil.create(request, "edisonvirtuallabmainvisual_WAR_edisonvirtuallab2016portlet", labPlid, PortletRequest.RENDER_PHASE);
			
			model.addAttribute("labURL", labURL.toString());
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "virtualLabManagementList/virtualLabManagementList";
	}
	
	@ResourceMapping(value="virtualLabManagementList")
	public void getVirtualLabManagementList(ResourceRequest request, ResourceResponse response) throws Exception {
		long companyId = PortalUtil.getCompanyId(request);
		User user = PortalUtil.getUser(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		String searchField = ParamUtil.get(request, "search_parameter", "");
		int curPage = ParamUtil.get(request, "cur_page", 1);
		int linePerPage = ParamUtil.get(request, "select_line", 5);
		
		int pagePerBlock = 10;
		int begin = linePerPage * (curPage - 1);
		
		String portletNameSpace = response.getNamespace();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", String.valueOf(groupId));
		params.put("searchField", searchField);
		params.put("begin", String.valueOf(begin));
		params.put("end", String.valueOf(linePerPage));
		params.put("statusSort", "1401002");
		
		List<Map<String, Object>> virtualLabManagementList = null;
		int virtualLabCount = 0;
		
		/* 관리자 체크 */
		if (!(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)
			|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)
			|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER))) {
			params.put("userId", user.getUserId());
			params.put("virtualLabOwnerName", EdisonRoleConstants.VIRTUAL_LAB_OWNER);
			params.put("virtualLabManagerName", EdisonRoleConstants.VIRTUAL_LAB_MANAGER);
		}
		
		virtualLabManagementList = VirtualLabLocalServiceUtil.getListVirtualLab(params, locale);
		virtualLabCount = VirtualLabLocalServiceUtil.getCountVirtualLab(params, locale);
		
		JSONObject obj = new JSONObject();
		String pageList = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", virtualLabCount, curPage, linePerPage, pagePerBlock);
		obj.put("selectLine", linePerPage);
		obj.put("curPage", curPage);
		obj.put("pageList", pageList);
		obj.put("virtualLabManagementList", virtualLabManagementList);
		obj.put("virtualLabCount", virtualLabCount);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
}
