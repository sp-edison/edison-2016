package org.kisti.edison.virtuallaboratory.portlet.virtualLabRequestManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.EdisonEmailSenderUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.HtmlFormUtils;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class VirtualLabRequestManagementController {
	private static Log log = LogFactoryUtil.getLog(VirtualLabRequestManagementController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			
			Map<String, Object> params = RequestUtil.getParameterMap(request);
			String groupName = GetterUtil.get(params.get("groupName"), "");
			List<Map<String, String>> statusList = EdisonExpndoUtil.getCodeListByUpCode("1401", themeDisplay.getLocale());
			String selectOptionStr = HtmlFormUtils.makeCombo(statusList, GetterUtil.get(params.get("selectOption"), ""));	// 공통 코드
			
			if(groupName != null & !groupName.equals("")) {
				model.addAttribute("groupName", groupName);
			}
			
			model.addAttribute("selectOptionStr", selectOptionStr);
	
			long labPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonvirtuallabmainvisual_WAR_edisonvirtuallab2016portlet");
			PortletURL labURL = PortletURLFactoryUtil.create(request, "edisonvirtuallabmainvisual_WAR_edisonvirtuallab2016portlet", labPlid, PortletRequest.RENDER_PHASE);
			
			model.addAttribute("labURL", labURL.toString());
			
			long classPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonvirtuallabclassmainvisual_WAR_edisonvirtuallab2016portlet");
			PortletURL classURL = PortletURLFactoryUtil.create(request, "edisonvirtuallabclassmainvisual_WAR_edisonvirtuallab2016portlet", classPlid, PortletRequest.RENDER_PHASE);
			
			model.addAttribute("classURL", classURL.toString());
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "virtualLabRequestManagement/virtualLabRequestList";
	}
	
	@ResourceMapping(value="virtualLabRequestList")
	public void virtualLabList(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		long groupId = PortalUtil.getScopeGroupId(request);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		String searchField = ParamUtil.get(request, "search_parameter", "");
		String status = ParamUtil.get(request, "select_virtualLab_status", "0");
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
		params.put("statusSort", status);
		
		List<Map<String, Object>> virtualLabRequestList = VirtualLabLocalServiceUtil.getListVirtualLab(params, locale);
		int virtualLabCount = VirtualLabLocalServiceUtil.getCountVirtualLab(params, locale);
		
		JSONObject obj = new JSONObject();
		
		String pageList = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", virtualLabCount, curPage, linePerPage, pagePerBlock);
		
		obj.put("selectLine", linePerPage);
		obj.put("curPage", curPage);
		obj.put("pageList", pageList);
		obj.put("virtualLabRequestList", virtualLabRequestList);
		obj.put("virtualLabCount", virtualLabCount);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ResourceMapping(value="virtualLabInfomation")
	public void getVirtualLabInfomation(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();

		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
		
		Map<String, Object> virtualLabInfo = VirtualLabLocalServiceUtil.getVirtualLabInfomation(virtualLabId, locale);
		
		JSONObject obj = new JSONObject();
		
		obj.put("languageId", themeDisplay.getLanguageId());
		obj.put("virtualLabInfo", virtualLabInfo);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ActionMapping(params = "myaction=updateVirtualLabStatus")
	public void updateVirtualLabStatus(ActionRequest request, ActionResponse response) {
		try {
			long userId = PortalUtil.getUserId(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long companyId = PortalUtil.getCompanyId(request);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			
			String processStatus = ParamUtil.get(request, "processStatus", "1401001");
			String requestUserId = ParamUtil.get(request, "requestUserId", "0");
			String virtualLabId = ParamUtil.get(request, "processVirtualLabId", "0");
			String groupName = ParamUtil.get(request, "groupName", "");
			String mailSendYn = ParamUtil.get(request, "mailSendYn", "N");
			
			Map<String, String> param = new HashMap<String, String>();
			param.put("groupId", String.valueOf(groupId));
			param.put("userId", String.valueOf(userId));
			param.put("virtualLabId",virtualLabId);
			param.put("virtualLabConfirmDescription",ParamUtil.get(request, "processDescription", ""));
			param.put("virtualLabStatus",processStatus);
			
			User requestUser = UserUtil.fetchByPrimaryKey(Long.parseLong(requestUserId));
			
			if(processStatus.equals("1401002") && requestUser != null) {	// 생성요청 승인
				if(!EdisonUserUtil.isRegularRole(requestUser, RoleConstants.ADMINISTRATOR)
				&& !EdisonUserUtil.isSiteRole(requestUser, groupId, RoleConstants.SITE_ADMINISTRATOR)
				&& !EdisonUserUtil.isSiteRole(requestUser, groupId, RoleConstants.SITE_OWNER)) {
					
					EdisonUserUtil.addSiteRole(requestUser, groupId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);		// VIRTUAL_LAB_OWNER 권한 추가
					EdisonUserUtil.addGroup(requestUser, EdisonRoleConstants.TUTOR_GROUP);						// TUTOR Group 추가
					
					Role role = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);		// Role Id 확인
					UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(Long.parseLong(requestUserId), groupId, role.getRoleId(), Long.parseLong(virtualLabId));
				}
			} else if (processStatus.equals("1401001") || processStatus.equals("1401003")) {	// 요청 또는 반려일때
				
			}
			
			//가상실험실 승인 내역을 튜터에게 전송
			//처리한 유저 Admin ID
			//처리 결과를 전송할 User ID
			//전송완료:true, 전송실패:false
			if(mailSendYn.equals("Y")){
				String message = EdisonExpndoUtil.getCommonCdSearchFieldValue(processStatus, EdisonExpando.CDNM, themeDisplay.getLocale());
				EdisonEmailSenderUtil.emailWorkspaceConfirmtSubmit(request, userId, Long.parseLong(requestUserId), message); //email 승인하면 개발자에게 메일보내기
			}
			
			VirtualLabLocalServiceUtil.updateVirtualLabStatus(param);
			
			if(!groupName.equals("")) {
				PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				
				portletURL.setParameter("groupName", groupName);
				portletURL.setPortletMode(LiferayPortletMode.VIEW);
				portletURL.setWindowState(LiferayWindowState.POP_UP);
				response.sendRedirect(portletURL.toString());
			}
			SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
		}
	}
}
