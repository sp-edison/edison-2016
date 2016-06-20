package org.kisti.edison.science.portlet.requiredLibList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.science.model.RequiredLibConfirm;
import org.kisti.edison.science.service.RequiredLibConfirmLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
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
public class requiredLibListController {
	
	private static Log log = LogFactory.getLog(requiredLibListController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model) {
		return "requiredLibList/requiredLibList";
	}
	
	@ResourceMapping(value="requiredLibList")
	public void developerRequestList(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Map params = RequestUtil.getParameterMap(request);
		Locale locale = themeDisplay.getLocale();
		int curPage = ParamUtil.get(request, "cur_page", 1);
		int linePerPage = ParamUtil.get(request, "select_line", 5);
		
		int pagePerBlock = 10;
		int begin = linePerPage * (curPage - 1);
		
		String portletNameSpace = response.getNamespace();
		
		List<Map<String, Object>> requiredLibList = RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirmList(params, begin, linePerPage);
		int requiredLibCount = RequiredLibConfirmLocalServiceUtil.getCountRequiredConfirm(params);
		
		JSONObject obj = new JSONObject();
		
		String pageList = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", requiredLibCount, curPage, linePerPage, pagePerBlock);
		
		obj.put("selectLine", linePerPage);
		obj.put("curPage", curPage);
		obj.put("pageList", pageList);
		obj.put("requiredLibList", requiredLibList);
		obj.put("requiredLibCount", requiredLibCount);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@RenderMapping(params = "myRender=libChangeRender")
	public String solverChangeRender(final RenderRequest request, RenderResponse response, ModelMap model){
		Map params = RequestUtil.getParameterMap(request);
		String mode =CustomUtil.strNull(params.get("mode"),"VIEW");
		try {
			User user = PortalUtil.getUser(request);
			long groupId = PortalUtil.getScopeGroupId(request);	
			
			if(mode.equals("UPDATE")){
				String requiredState = CustomUtil.strNull(params.get("changeStatus"));
				String confirmContent = CustomUtil.strNull(params.get("confirmContent"));
				Date confirmDate = new Date();
				RequiredLibConfirm updateRequiredLibConfirm = RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirmObject(params);
				updateRequiredLibConfirm.setRequiredState(requiredState);
				updateRequiredLibConfirm.setConfirmContent(confirmContent);;
				updateRequiredLibConfirm.setConfirmDate(confirmDate);
				RequiredLibConfirmLocalServiceUtil.updateRequiredLibConfirm(updateRequiredLibConfirm);
			}else if(mode.equals("DELETE")){
				RequiredLibConfirm deleteRequiredLibConfirm = RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirmObject(params);
				RequiredLibConfirmLocalServiceUtil.deleteRequiredLibConfirm(deleteRequiredLibConfirm);
			}
			if(!mode.equals("DELETE")){
				Map<String, Object> requiredLib = RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirmMap(params);
				model.put("requiredLib", requiredLib);
			}
			model.put("postMode", mode);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			//Session Error Message
			if(mode.equals("UPDATE")){
				SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);  			
			}else if(mode.equals("DELETE")){
				SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
			}else{
				SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
			}
		}
		return "requiredLibList/libChange";
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
