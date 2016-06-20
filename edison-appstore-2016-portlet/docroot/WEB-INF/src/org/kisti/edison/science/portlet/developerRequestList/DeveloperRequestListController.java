package org.kisti.edison.science.portlet.developerRequestList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.science.service.DeveloperInfoLocalServiceUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class DeveloperRequestListController {
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model) {
		return "developerRequestList/developerRequestList";
	}
	
	/* 관리자용 개발자 신청상태 목록 조회 */
	@ResourceMapping(value="developerRequestList")
	public void developerRequestList(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		int curPage = ParamUtil.get(request, "cur_page", 1);
		int linePerPage = ParamUtil.get(request, "select_line", 5);
		
		int pagePerBlock = 10;
		int begin = linePerPage * (curPage - 1);
		
		String portletNameSpace = response.getNamespace();
		
		String workspaceStats[] = {
				"1202001", "1202007"
		};
		
		List<Map<String, Object>> developerRequestList = DeveloperInfoLocalServiceUtil.getDeveloperRequestStatus(0, 0, workspaceStats, locale, begin, linePerPage);
		int developerRequestCount = DeveloperInfoLocalServiceUtil.getCountDeveloperRequestStatus(0, 0, workspaceStats);
		
		JSONObject obj = new JSONObject();
		
		String pageList = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", developerRequestCount, curPage, linePerPage, pagePerBlock);
		
		obj.put("selectLine", linePerPage);
		obj.put("curPage", curPage);
		obj.put("pageList", pageList);
		obj.put("developerRequestList", developerRequestList);
		obj.put("developerRequestCount", developerRequestCount);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	/* 목록에서 클릭했을때 각 사이트의 개발자 요청 관리 페이지 plid 리턴 */
	@ResourceMapping(value="getSitePagePlid")
	public void getSitePagePlid(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		Map params = RequestUtil.getParameterMap(request);
		long groupId = GetterUtil.get(params.get("groupId"), 0);
		User user = PortalUtil.getUser(request);
		long requestPlid = 0;
		
		if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) ||
			EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR) ||
			EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)) {
			requestPlid = PortalUtil.getPlidFromPortletId(groupId, "edisonworkspace_WAR_edisonappstore2016portlet");
		}
		
		JSONObject obj = new JSONObject();
		obj.put("requestPlid", requestPlid);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
}
