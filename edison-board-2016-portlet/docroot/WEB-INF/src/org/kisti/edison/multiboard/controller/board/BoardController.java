package org.kisti.edison.multiboard.controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.multiboard.model.Board;
import org.kisti.edison.multiboard.model.BoardDiv;
import org.kisti.edison.multiboard.service.BoardDivLocalServiceUtil;
import org.kisti.edison.multiboard.service.BoardLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class BoardController {
	
	protected static Log  log = LogFactoryUtil.getLog(BoardController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		Map params = RequestUtil.getParameterMap(request);
		String mainListYn = request.getPreferences().getValue("mainListYn", "N");
		String maxList = GetterUtil.get(params.get("maxList"), "N");
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long companyId = PortalUtil.getCompanyId(request);
			long boardGroupId = ParamUtil.get(request, "boardGroupId", themeDisplay.getSiteGroupId());
			String customId = "";
			long userId = PortalUtil.getUserId(request);
			
			
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
			String solverId = CustomUtil.strNull(params.get("solverId"), "0");
			String classId = CustomUtil.strNull(httpRequest.getParameter("classId"), "0");
			
			User user = PortalUtil.getUser(request);
	
			long classId_ = GetterUtil.get(classId, 0L);
			long solverId_ = GetterUtil.get(solverId, 0L);
			
			boolean isCustomAdmin = false;
			
			if(classId_ > 0) {
				isCustomAdmin = UserGroupRoleCustomLocalServiceUtil.isAdminRoleVirtualLabClass(companyId, boardGroupId, userId, classId_);
			} else if (solverId_ > 0) {
	//			isCustomAdmin = UserGroupRoleCustomLocalServiceUtil.isAdminRoleSolver(companyId, boardGroupId, userId, solverId_);
			}
			
			if(!classId.equals("0")) {
				customId = "class_" + classId;
			} else if(!solverId.equals("0")) {
				customId = "solver_" + solverId;
			}
			
			String divSort = request.getPreferences().getValue("divSort", "NOTICE");
			
			Long divCd = Long.parseLong(request.getPreferences().getValue("divCd", "100"));
			BoardDiv boardDiv = BoardDivLocalServiceUtil.getBoardDiv(divCd);
			String boardDivTitle = boardDiv.getTitleNm(themeDisplay.getLocale());
			String popState = "NO";
			long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();
			String isPortal = "true";
			String siteGroup = "";
			// 포털 체크 parentGroupId가 0이면 포털
			if(parentGroupId != 0) {
				isPortal = "false";
			}
			if(isPortal.equals("false") && divCd == 100){
				siteGroup = String.valueOf(themeDisplay.getScopeGroupId());
			}
			
			List popupList = new ArrayList();
			if(boardDiv.getPopupYn() == true){		
				List boardPopupList = BoardDivLocalServiceUtil.getCustomListBoard(divCd, 0, 100, boardGroupId, customId, "", themeDisplay.getLocale(), 0, true, siteGroup);
				
				Map cookieMap = new java.util.HashMap();
	
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (int i = 0 ; i < cookies.length ; i++) {
						cookieMap.put(cookies[i].getName(), cookies[i]);
					}
				}
	
				String preFix = "";
				List popupFileList = null;
				Map popupMap = null;
				for(int i=0;i<boardPopupList.size();i++){
	
					popupMap = (Map) boardPopupList.get(i);
	
					String popupMapSeq = "POPUP_"+CustomUtil.strNull(popupMap.get("boardSeq"));
					if(CustomUtil.strNull(cookieMap.get(popupMapSeq)).equals("")){
	
						popupMap = (Map)boardPopupList.get(i);
	
						preFix = "";
						if(!solverId.equals("0")){
							if(!preFix.equals("")) preFix += "_"; 
							preFix += solverId;
						}
						if(!classId.equals("0")){
							if(!preFix.equals("")) preFix += "_"; 
							preFix += classId;
						}
						
						popupFileList = EdisonFileUtil.getListEdisonFile(
																	boardGroupId, 
																	preFix, 
																	CustomUtil.strNull(popupMap.get("boardSeq")),
																	divSort
																	);
	
						popupMap.put("fileList", popupFileList);
	
						popupList.add(popupMap);
					}
				}
	
				if(popupList != null && popupList.size() > 0){
					popState = "YES";
				}
			}
			
			model.addAttribute("popState", popState);
			model.addAttribute("isCustomAdmin", isCustomAdmin);
			model.addAttribute("currentPage", CustomUtil.strNull(params.get("currentPage"), "1"));
			model.addAttribute("searchValue", CustomUtil.strNull(params.get("searchValue")));
			model.addAttribute("boardDiv", boardDiv);
			model.addAttribute("boardDivTitle", boardDivTitle);
			model.addAttribute("boardGroupId", String.valueOf(boardGroupId));
			model.addAttribute("divSort", divSort);
			model.addAttribute("solverId", solverId);
			model.addAttribute("classId", classId_);
			model.addAttribute("popupList", popupList);
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		if(mainListYn.equals("Y") && maxList.equals("N")){
			return "listMain";
		}else{
			return "list";
		}
	}

	@ResourceMapping(value="getBoardDivBoards")
	public void getBoardDivBoards(ResourceRequest request, ResourceResponse response) throws SystemException, JSONException, IOException, PortalException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		long boardGroupId = ParamUtil.get(request, "boardGroupId", themeDisplay.getSiteGroupId());
		
		Map params = RequestUtil.getParameterMap(request);

		long solverId = Long.parseLong(CustomUtil.strNull(params.get("solverId"), "0"));
		long classId = Long.parseLong(CustomUtil.strNull(params.get("classId"), "0"));
		
		String customId = "";
		
		String searchValue = CustomUtil.strNull(params.get("searchValue"));
		
		Long divCd = Long.parseLong(((PortletRequest) request).getPreferences().getValue("divCd", "100"));
				
		int currentPage = Integer.parseInt(CustomUtil.strNull(params.get("currentPage"), "1"));
		int listSize = Integer.parseInt(CustomUtil.strNull(params.get("listSize"), "10"));
		int blockSize = Integer.parseInt(((PortletRequest) request).getPreferences().getValue("blockSize", "10"));
		int start = ((currentPage - 1) * listSize);
		if(classId > 0) {
			customId = "class_" + classId;
		} else if(solverId > 0) {
			customId = "solver_" + solverId;
		}
		long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();
		String isPortal = "true";
		String siteGroup = "";
		// 포털 체크 parentGroupId가 0이면 포털
		if(parentGroupId != 0) {
			isPortal = "false";
		}
		if(isPortal.equals("false") && divCd == 100){
			siteGroup = String.valueOf(themeDisplay.getScopeGroupId());
		}
		List boardList = BoardDivLocalServiceUtil.getCustomListBoard(divCd, start, listSize, boardGroupId, customId, searchValue, locale, 0, false, siteGroup);
				
		int totalCount = BoardDivLocalServiceUtil.getCustomCountBoard(divCd, boardGroupId, customId, searchValue, 0, siteGroup);

		String paging = PagingUtil.getPaging(request.getContextPath(), CustomUtil.strNull(params.get("methodName")), totalCount, currentPage, listSize, blockSize);
		
		JSONObject obj = new JSONObject();
		
		obj.put("divCd", divCd);	// divCd(구분코드)를 넘겨주어 어떤 게시판인지 확인
		obj.put("boardList", boardList);
		obj.put("seq", totalCount - ((currentPage - 1)*listSize));
		obj.put("paging", paging);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

	@RenderMapping(params = "myRender=getBoardRender")
	public String getBoardRender(RenderRequest request, RenderResponse response, ModelMap model) throws PortalException, SystemException, MalformedURLException, IOException, SQLException, ParseException{
		Map params = RequestUtil.getParameterMap(request);		
		String mode = CustomUtil.strNull(params.get("RENDER_SORT"),"VIEW");
		User user = PortalUtil.getUser(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		Group group = GroupLocalServiceUtil.getGroup(groupId);
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			
			//VIEW가 아니면서 (게시물 보기) 로그인이 안되어있을 경우 홈 화면으로 보냄
			if(!mode.equals("VIEW") && !themeDisplay.isSignedIn()) {
				model.addAttribute("backURL", themeDisplay.getPortalURL() + "/c/portal/login");
				return "error";
			}
			
			long boardGroupId = ParamUtil.get(request, "boardGroupId", themeDisplay.getSiteGroupId());
			
			long companyId = PortalUtil.getCompanyId(request);
			long userId = PortalUtil.getUserId(request);
			
			Long divCd = Long.parseLong(((PortletRequest) request).getPreferences().getValue("divCd", "100"));
			BoardDiv boardDiv = BoardDivLocalServiceUtil.getBoardDiv(divCd);
			model.addAttribute("boardDiv", boardDiv);
			
			String boardDivTitle = boardDiv.getTitleNm(themeDisplay.getLocale());
			model.addAttribute("boardDivTitle", boardDivTitle);
			
			List<com.liferay.portal.model.Group> parentGroupList = GroupLocalServiceUtil.getGroups(companyId, 0, true);
			Group portalGroup = null;
			for(Group parentGroup:parentGroupList){
				if(StringUtil.toUpperCase(parentGroup.getName()).equals("GUEST")){
					portalGroup = parentGroup;
					break;
				}
			}
			long portalGroupId = portalGroup.getGroupId();
			
			boolean isPortal = false; //포탈 여부
			boolean isChildrenSite = false;
			long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();
			
			if(GroupLocalServiceUtil.getGroups(companyId, PortalUtil.getScopeGroupId(request), true).size()>0){
				isChildrenSite = true;
			}
			
			if(parentGroupId == 0 && isChildrenSite){
				isPortal = true; 
			}
			
			Map boardMap = null;
			
			Locale locale = themeDisplay.getLocale();
			
			if(mode.equals("WRITE") || mode.equals("UPDATE")){
				locale = CustomUtil.stringToLocale(CustomUtil.strNull(params.get("select_languageId")));
				if(isPortal == true && divCd == 100){
					List<Group> groupList = GroupLocalServiceUtil.getGroups(companyId, portalGroup.getGroupId(), true);//하위 그룹 리스트
					model.put("groupList", groupList) ;
				}
			}
			
			if(mode.equals("REPLY")){
				params.put("boardSeq", CustomUtil.strNull(params.get("groupBoardSeq")));
			}
			
			String solverId = CustomUtil.strNull(params.get("solverId"), "0");
			String classId = CustomUtil.strNull(params.get("classId"), "0");
			
			String customId = "";
			
			if(!classId.equals("0")) {
				customId = "class_" + classId;
			} else if(!solverId.equals("0")) {
				customId = "solver_" + solverId;
			}
			
			long getboardGroupId = boardGroupId;
			
			if(!CustomUtil.strNull(params.get("boardSeq")).equals("")){
				boardMap = BoardLocalServiceUtil.getBoard(divCd, customId, GetterUtil.get(params.get("boardSeq"), 0L), locale);
				String getGroupId = CustomUtil.strNull(boardMap.get("groupId"));
				if(!getGroupId.equals("")){
					getboardGroupId = Long.parseLong(getGroupId);
				}
				
				String[] siteGroups = CustomUtil.strNull(boardMap.get("siteGroup")).split(",");
				model.addAttribute("siteGroups", siteGroups);
			}
			
			String divSort = request.getPreferences().getValue("divSort", "NOTICE");	
			
			String preFix = "";
			if(!solverId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += solverId;
			}
			if(!classId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += classId;
			}
			
			List fileList = null;
			if(!CustomUtil.strNull(params.get("boardSeq")).equals("")){
				fileList = EdisonFileUtil.getListEdisonFile(
															getboardGroupId, 
															preFix, 
															GetterUtil.get(params.get("boardSeq"), ""),
															divSort
															);
				
			}
			
			String siteGroup = "";
			if(isPortal == false && divCd == 100){
				siteGroup = String.valueOf(themeDisplay.getScopeGroupId());
			}
			List replyList = new ArrayList();
			boolean isNoticeYn = request.getPreferences().getValue("divCd", "100").equals("100") ? true : false;
			if(boardDiv.getReplyYn() && !GetterUtil.get(params.get("boardSeq"), "").equals("")){
				List boardList = BoardDivLocalServiceUtil.getCustomListBoard(divCd, 0, 100000, boardGroupId, customId, "", locale, GetterUtil.get(params.get("boardSeq"), 0L), false, siteGroup);
				
				List replyFileList = null;
				Map map = null;
				
				if(boardList != null && boardList.size() > 0){
					for(int i=0; i<boardList.size();i++){					
						map = (Map) boardList.get(i);					
						
						preFix = "";
						if(!solverId.equals("0")){
							if(!preFix.equals("")) preFix += "_"; 
							preFix += solverId;
						}
						if(!classId.equals("0")){
							if(!preFix.equals("")) preFix += "_"; 
							preFix += classId;
						}
						
						replyFileList = EdisonFileUtil.getListEdisonFile(
																	boardGroupId, 
																	preFix, 
																	GetterUtil.get(params.get("boardSeq"), "")
																	,divSort
																	);
						
						map.put("fileList", replyFileList);
						replyList.add(map);
					}
				}
			}
			
			long classId_ = GetterUtil.get(classId, 0L);
			long solverId_ = GetterUtil.get(solverId, 0L);
			boolean isCustomAdmin = false;
			
			if(classId_ > 0) {
				isCustomAdmin = UserGroupRoleCustomLocalServiceUtil.isAdminRoleVirtualLabClass(companyId, boardGroupId, userId, classId_);
			} else if (solverId_ > 0) {
	//			isCustomAdmin = UserGroupRoleCustomLocalServiceUtil.isAdminRoleSolver(companyId, boardGroupId, userId, solverId_);
			}
			
			// NOTICE(공지사항) 인데 권한이 없는 유저일때
			if(!mode.equals("VIEW") && divSort.equals("NOTICE")) {
				boolean isAdmin = EdisonUserUtil.isPowerUserThan(user);
				if(!isAdmin && !isCustomAdmin) {
					model.addAttribute("backURL", themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + group.getFriendlyURL() + "/home");
					return "error";
				}
			}
			
			model.addAttribute("isPortal", isPortal);
			model.addAttribute("boardGroupId", String.valueOf(boardGroupId));
			model.addAttribute("replyList",	replyList);
			model.addAttribute("isCustomAdmin", isCustomAdmin);
			model.addAttribute("boardMap",	boardMap);
			model.addAttribute("solverId",	solverId);
			model.addAttribute("classId",	classId);
			model.addAttribute("fileList",	fileList);
			model.addAttribute("boardSeq",	CustomUtil.strNull(params.get("boardSeq")));	
			model.addAttribute("replyBoardSeq",	CustomUtil.strNull(params.get("replyBoardSeq")));		
			model.addAttribute("currentPage",	CustomUtil.strNull(params.get("currentPage"), "1"));
			model.addAttribute("searchValue",	CustomUtil.strNull(params.get("searchValue")));
			model.addAttribute("select_languageId",	GetterUtil.get(params.get("select_languageId"), themeDisplay.getLocale().toString()));		
			model.addAttribute("RENDER_SORT",	mode);
			model.addAttribute("RENDER_MSG",	CustomUtil.strNull(params.get("RENDER_MSG")));
			
			String currunt_folder = "/" +portalGroupId+" - " +CompanyLocalServiceUtil.getCompany(PortalUtil.getCompanyId(request)).getName() + "/"+portalGroupId+"_EDISON_FILE"+"/"+EdisonFileConstants.USER_IMAGE+"/"+userId+ "/";
			model.addAttribute("currentFolder", currunt_folder);
			
			if(mode.equals("WRITE")){
				EdisonFileUtil.checkUserFolder(request, userId, portalGroupId, EdisonFileConstants.USER_IMAGE);
				return "write";
			}else if(mode.equals("UPDATE")){
				EdisonFileUtil.checkUserFolder(request, userId, portalGroupId, EdisonFileConstants.USER_IMAGE);
				return "write";
			}else if(mode.equals("REPLY")){
				return "view";
			}else if(mode.equals("REPLY_DELETE")){
				return "view";			
			}else{
				Map upMap = new HashMap();

				upMap.put("userId", themeDisplay.getUserId());
				upMap.put("locale", locale);
				upMap.put("boardSeq", Long.parseLong(CustomUtil.strNull(params.get("boardSeq"), "0")));
				upMap.put("readCnt", (Integer.parseInt(CustomUtil.strNull(boardMap.get("readCnt"), "0"))+1));
				
				BoardLocalServiceUtil.updateBoard(upMap);
			}
			
			if(mode.equals("WRITE") || mode.equals("REPLY")){
				SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
			}else if(mode.equals("UPDATE")){
				SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
			}else if(mode.equals("DELETE") || mode.equals("REPLY_DELETE")){
				SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			if(mode.equals("WRITE") || mode.equals("REPLY")){
				SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
			}else if(mode.equals("UPDATE")){
				SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
			}else if(mode.equals("DELETE") || mode.equals("REPLY_DELETE")){
				SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
			}
		}
		return "view";
	}

	@ActionMapping(params="myAction=addBoardAction")
	public void addBoardAction(ActionRequest request, ActionResponse response, ModelMap model) {
		try {
			UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);			
			Map params = RequestUtil.getParameterMap(upload);
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long boardGroupId = GetterUtil.get(params.get("boardGroupId"), themeDisplay.getScopeGroupId());
			
			String solverId = CustomUtil.strNull(params.get("solverId"), "0");
			String classId = CustomUtil.strNull(params.get("classId"), "0");
			
			String divSort = request.getPreferences().getValue("divSort", "NOTICE");
			
			Long divCd = Long.parseLong(((PortletRequest) request).getPreferences().getValue("divCd", "100"));
			
			if(!classId.equals("0")) {
				params.put("customId", "class_" + classId);
			} else if(!solverId.equals("0")) {
				params.put("customId", "solver_" + solverId);
			}
			
			String[] siteGroups = request.getParameterValues("siteGroup");
			String siteGroup = "";
			if(siteGroups != null){
				for(String siteGroupId : siteGroups){
					if(!siteGroup.equals("")){
						siteGroup+=",";
					}
					siteGroup+= siteGroupId;
				}
				params.put("siteGroup", siteGroup);
			}
			params.put("groupId", boardGroupId);
			params.put("divCd", divCd);
			params.put("userId", themeDisplay.getUserId());
			params.put("locale", CustomUtil.stringToLocale(CustomUtil.strNull(params.get("select_languageId"))));
			params.put("allNoticeYn", Boolean.parseBoolean(CustomUtil.strNull(params.get("allNoticeYn"), "0")));
			params.put("popupYn", Boolean.parseBoolean(CustomUtil.strNull(params.get("popupYn"), "0")));
			params.put("popupStartDt", CustomUtil.strNull(params.get("popupStartDt")));
			params.put("popupEndDt", CustomUtil.strNull(params.get("popupEndDt")));
			params.put("groupBoardSeq", "0");
			params.put("groupBoardTurn", "0");
			params.put("replyDepth", 0);
			
			
			Board brd = BoardLocalServiceUtil.addBoard(params);
			
			String preFix = "";
			if(!solverId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += solverId;
			}
			if(!classId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += classId;
			}
			
			EdisonFileUtil.insertEdisonFile(request, upload, userId, boardGroupId, preFix, CustomUtil.strNull(String.valueOf(brd.getBoardSeq())), "addfile", divSort);
			
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("myRender", "getBoardRender");
			portletURL.setParameter("RENDER_SORT", "WRITE");
			portletURL.setParameter("RENDER_MSG", "WRITE");
			portletURL.setParameter("searchValue", CustomUtil.strNull(params.get("searchValue")));
			portletURL.setParameter("currentPage", CustomUtil.strNull(params.get("currentPage"), "1"));
			portletURL.setParameter("select_languageId", CustomUtil.strNull(params.get("select_languageId")));
			portletURL.setParameter("boardSeq", CustomUtil.strNull(brd.getBoardSeq(), "0"));
			portletURL.setParameter("boardGroupId", CustomUtil.strNull(boardGroupId));
			
			SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
			
			if(!classId.equals("0")) {
				portletURL.setParameter("maxList", "Y");
				portletURL.setWindowState(WindowState.MAXIMIZED);
				portletURL.setParameter("classId", classId);
				response.sendRedirect(portletURL.toString() + "&classId=" + classId);
			} else if(!solverId.equals("0")) {
				portletURL.setParameter("maxList", "Y");
				portletURL.setParameter("solverId", solverId);
				response.sendRedirect(portletURL.toString() + "&solverId=" + solverId);
			} else {
				response.sendRedirect(portletURL.toString());
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
		}
	}
	
	@ActionMapping(params="myAction=addReplyBoardAction")
	public void addReplyBoardAction(ActionRequest request, ActionResponse response, ModelMap model) {
		try {
			UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);			
	
			Map params = RequestUtil.getParameterMap(upload);
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long boardGroupId = ParamUtil.get(request, "boardGroupId", themeDisplay.getSiteGroupId());
	
			String solverId = CustomUtil.strNull(params.get("solverId"), "0");
			String classId = CustomUtil.strNull(params.get("classId"), "0");
			
			String divSort = request.getPreferences().getValue("divSort", "NOTICE");
			
			Long divCd = Long.parseLong(((PortletRequest) request).getPreferences().getValue("divCd", "100"));
			
			if(!classId.equals("0")) {
				params.put("customId", "class_" + classId);
			} else if(!solverId.equals("0")) {
				params.put("customId", "solver_" + solverId);
			}
			
			params.put("groupId", boardGroupId);
			params.put("divCd", divCd);
			params.put("userId", themeDisplay.getUserId());
			params.put("locale", CustomUtil.stringToLocale(CustomUtil.strNull(params.get("select_languageId"))));
			params.put("allNoticeYn", false);
			params.put("popupYn", false);
			params.put("popupStartDt", "");
			params.put("popupEndDt", "");
	
			params.put("groupBoardSeq", Integer.parseInt(CustomUtil.strNull(params.get("groupBoardSeq"))));
			params.put("groupBoardTurn", 0);
			params.put("replyDepth", 0);
	
			Board brd = BoardLocalServiceUtil.addBoard(params);
	
			String preFix = "";
			if(!solverId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += solverId;
			}
			if(!classId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += classId;
			}
			
			EdisonFileUtil.insertEdisonFile(request, upload, userId, boardGroupId, preFix, CustomUtil.strNull(String.valueOf(brd.getBoardSeq())), "addfile", divSort);
			
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("myRender", "getBoardRender");
			portletURL.setParameter("searchValue", CustomUtil.strNull(params.get("searchValue")));
			portletURL.setParameter("currentPage", CustomUtil.strNull(params.get("currentPage"), "1"));
			portletURL.setParameter("RENDER_SORT", "REPLY");
			portletURL.setParameter("RENDER_MSG", "WRITE");
			portletURL.setParameter("groupBoardSeq", CustomUtil.strNull(params.get("groupBoardSeq")));
			portletURL.setParameter("boardSeq", CustomUtil.strNull(params.get("boardSeq")));
			portletURL.setParameter("boardGroupId", CustomUtil.strNull(boardGroupId));
			
			SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
			
			if(!classId.equals("0")) {
				portletURL.setWindowState(WindowState.MAXIMIZED);
				portletURL.setParameter("classId", classId);
				response.sendRedirect(portletURL.toString() + "&classId=" + classId);
			} else if(!solverId.equals("0")) {
				portletURL.setParameter("solverId", solverId);
				response.sendRedirect(portletURL.toString() + "&solverId=" + solverId);
			} else {
				response.sendRedirect(portletURL.toString());
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
		}
	}

	@ActionMapping(params="myAction=updateBoardAction")
	public void updateBoardAction(ActionRequest request, ActionResponse response, ModelMap model) {
		try {
			UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);			
	
			Map params = RequestUtil.getParameterMap(upload);
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long boardGroupId = ParamUtil.get(request, "boardGroupId", themeDisplay.getSiteGroupId());
	
			String solverId = CustomUtil.strNull(params.get("solverId"), "0");
			String classId = CustomUtil.strNull(params.get("classId"), "0");
			
			String divSort = request.getPreferences().getValue("divSort", "NOTICE");
			
			Long divCd = Long.parseLong(((PortletRequest) request).getPreferences().getValue("divCd", "100"));
			
			if(!classId.equals("0")) {
				params.put("customId", "class_" + classId);
			} else if(!solverId.equals("0")) {
				params.put("customId", "solver_" + solverId);
			}
			
			long boardSeq = Long.parseLong(CustomUtil.strNull(params.get("boardSeq")));
			params.put("userId", userId);
			params.put("boardSeq", boardSeq);
			params.put("locale", CustomUtil.stringToLocale(CustomUtil.strNull(params.get("current_languageId"), CustomUtil.strNull(params.get("select_languageId")))));
			params.put("allNoticeYn", Boolean.parseBoolean(CustomUtil.strNull(params.get("allNoticeYn"), "0")));
			params.put("popupYn", Boolean.parseBoolean(CustomUtil.strNull(params.get("popupYn"), "0")));
			params.put("popupStartDt", CustomUtil.strNull(params.get("popupStartDt")));
			params.put("popupEndDt", CustomUtil.strNull(params.get("popupEndDt")));
			
			String[] siteGroups = request.getParameterValues("siteGroup");
			String siteGroup = "";
			if(siteGroups != null){
				for(String siteGroupId : siteGroups){
					if(!siteGroup.equals("")){
						siteGroup+=",";
					}
					siteGroup+= siteGroupId;
				}
				params.put("siteGroup", siteGroup);
			}
			
			Board brd = BoardLocalServiceUtil.updateBoard(params);
	
			String preFix = "";
			if(!solverId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += solverId;
			}
			if(!classId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += classId;
			}
			
			EdisonFileUtil.insertEdisonFile(request, upload, userId, boardGroupId, preFix, CustomUtil.strNull(String.valueOf(brd.getBoardSeq())), "addfile", divSort);
			
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("myRender", "getBoardRender");
			portletURL.setParameter("searchValue", CustomUtil.strNull(params.get("searchValue")));
			portletURL.setParameter("currentPage", CustomUtil.strNull(params.get("currentPage"), "1"));
			portletURL.setParameter("RENDER_SORT", "UPDATE");
			portletURL.setParameter("RENDER_MSG", "UPDATE");
			portletURL.setParameter("select_languageId", CustomUtil.strNull(params.get("select_languageId")));
			portletURL.setParameter("boardSeq", CustomUtil.strNull(params.get("boardSeq")));
			portletURL.setParameter("boardGroupId", CustomUtil.strNull(boardGroupId));
			
			SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
			
			if(!classId.equals("0")) {
				portletURL.setWindowState(WindowState.MAXIMIZED);
				portletURL.setParameter("classId", classId);
				response.sendRedirect(portletURL.toString() + "&classId=" + classId);
			} else if(!solverId.equals("0")) {
				portletURL.setParameter("solverId", solverId);
				response.sendRedirect(portletURL.toString() + "&solverId=" + solverId);
			} else {
				response.sendRedirect(portletURL.toString());
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
		}
	}	

	@ActionMapping(params="myAction=updateReplyBoardAction")
	public void updateReplyBoardAction(ActionRequest request, ActionResponse response, ModelMap model) {
		try {
			UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);			
	
			Map params = RequestUtil.getParameterMap(upload);
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			long userId = themeDisplay.getUserId();
			long boardGroupId = ParamUtil.get(request, "boardGroupId", themeDisplay.getSiteGroupId());
			
			String solverId = CustomUtil.strNull(params.get("solverId"), "0");
			String classId = CustomUtil.strNull(params.get("classId"), "0");
			
			String divSort = request.getPreferences().getValue("divSort", "NOTICE");
			
			Long divCd = Long.parseLong(((PortletRequest) request).getPreferences().getValue("divCd", "100"));
	
			long replyBoardSeq = Long.parseLong(CustomUtil.strNull(params.get("replyBoardSeq")));
			
			params.put("locale", locale);
			params.put("userId", userId);
			params.put("boardSeq", replyBoardSeq);
	
			Board brd = BoardLocalServiceUtil.updateBoard(params);
	
			String preFix = "";
			if(!solverId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += solverId;
			}
			if(!classId.equals("0")){
				if(!preFix.equals("")) preFix += "_"; 
				preFix += classId;
			}
			
			EdisonFileUtil.insertEdisonFile(request, upload, brd.getWriterId(), boardGroupId, preFix, CustomUtil.strNull(String.valueOf(brd.getBoardSeq())), "addfile", divSort);
			
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("myRender", "getBoardRender");
			portletURL.setParameter("searchValue", CustomUtil.strNull(params.get("searchValue")));
			portletURL.setParameter("currentPage", CustomUtil.strNull(params.get("currentPage"), "1"));
			portletURL.setParameter("RENDER_SORT", "REPLY");
			portletURL.setParameter("RENDER_MSG", "UPDATE");
			portletURL.setParameter("select_languageId", CustomUtil.strNull(params.get("select_languageId")));
			portletURL.setParameter("groupBoardSeq", CustomUtil.strNull(params.get("groupBoardSeq")));
			portletURL.setParameter("boardSeq", CustomUtil.strNull(params.get("boardSeq")));
			portletURL.setParameter("boardGroupId", CustomUtil.strNull(boardGroupId));
			
			SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
			
			if(!classId.equals("0")) {
				portletURL.setWindowState(WindowState.MAXIMIZED);
				portletURL.setParameter("classId", classId);
				response.sendRedirect(portletURL.toString() + "&classId=" + classId);
			} else if(!solverId.equals("0")) {
				portletURL.setParameter("solverId", solverId);
				response.sendRedirect(portletURL.toString() + "&solverId=" + solverId);
			} else {
				response.sendRedirect(portletURL.toString());
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
		}
	}
	
	@ActionMapping(params="myAction=deleteBoardAction")
	public void deleteBoardAction(ActionRequest request, ActionResponse response, ModelMap model) {
		try {
			Map params = RequestUtil.getParameterMap(request);
	
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long boardGroupId = ParamUtil.get(request, "boardGroupId", themeDisplay.getSiteGroupId());
	
			String solverId = CustomUtil.strNull(params.get("solverId"), "0");
			String classId = CustomUtil.strNull(params.get("classId"), "0");
			
			String divSort = request.getPreferences().getValue("divSort", "NOTICE");
			
			Board brd = BoardLocalServiceUtil.deleteBoard(Long.parseLong(CustomUtil.strNull(params.get("boardSeq"),"0")));
	
			String preFix = "";
			preFix += String.valueOf(boardGroupId);
			if(!solverId.equals("0")) preFix += "_"+solverId;
			if(!classId.equals("0")) preFix += "_"+classId;
			
			String folderSeq = preFix + "_" + CustomUtil.strNull(params.get("boardSeq"));
			
			EdisonFileUtil.deleteGroupEdisonFile(boardGroupId, divSort, folderSeq);
			
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("boardGroupId", CustomUtil.strNull(boardGroupId));
			portletURL.setParameter("maxList", "Y");	//일반 목록으로 이동하기 위해
			
			SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
			
			if(!classId.equals("0")) {
				portletURL.setWindowState(WindowState.MAXIMIZED);
				portletURL.setParameter("classId", classId);
				response.sendRedirect(portletURL.toString() + "&classId=" + classId);
			} else if(!solverId.equals("0")) {
				portletURL.setParameter("solverId", solverId);
				response.sendRedirect(portletURL.toString() + "&solverId=" + solverId);
			} else {
				response.sendRedirect(portletURL.toString());
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
		}
	}

	@ActionMapping(params="myAction=deleteReplyBoardAction")
	public void deleteReplyBoardAction(ActionRequest request, ActionResponse response, ModelMap model) {
		try {
			Map params = RequestUtil.getParameterMap(request);
	
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long boardGroupId = ParamUtil.get(request, "boardGroupId", themeDisplay.getSiteGroupId());
			
			String solverId = CustomUtil.strNull(params.get("solverId"), "0");
			String classId = CustomUtil.strNull(params.get("classId"), "0");
			
			String divSort = request.getPreferences().getValue("divSort", "NOTICE");
			
			Board brd = BoardLocalServiceUtil.deleteBoard(Long.parseLong(CustomUtil.strNull(params.get("replyBoardSeq"))));
	
			String preFix = "";
			if(!solverId.equals("0")) preFix += "_"+solverId;
			if(!classId.equals("0")) preFix += "_"+classId;
			if(!divSort.equals("")) preFix += "_"+divSort;
			
			EdisonFileUtil.deleteGroupEdisonFile(boardGroupId, preFix, CustomUtil.strNull(params.get("replyBoardSeq")));
			
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("myRender", "getBoardRender");
			portletURL.setParameter("searchValue", CustomUtil.strNull(params.get("searchValue")));
			portletURL.setParameter("currentPage", CustomUtil.strNull(params.get("currentPage"), "1"));
			portletURL.setParameter("RENDER_SORT", "REPLY");
			portletURL.setParameter("RENDER_MSG", "REPLY");
			portletURL.setParameter("groupBoardSeq", CustomUtil.strNull(params.get("boardSeq")));
			portletURL.setParameter("boardSeq", CustomUtil.strNull(params.get("replyBoardSeq")));
			portletURL.setParameter("boardGroupId", CustomUtil.strNull(boardGroupId));
			
			SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
			
			if(!classId.equals("0")) {
				portletURL.setWindowState(WindowState.MAXIMIZED);
				portletURL.setParameter("classId", classId);
				response.sendRedirect(portletURL.toString() + "&classId=" + classId);
			} else if(!solverId.equals("0")) {
				portletURL.setParameter("solverId", solverId);
				response.sendRedirect(portletURL.toString() + "&solverId=" + solverId);
			} else {
				response.sendRedirect(portletURL.toString());
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
		}
	}
	
	@ResourceMapping(value="edisonFileDownload")
	public void edisonFileDownload(ResourceRequest request, ResourceResponse response) throws SystemException, JSONException, IOException, PortalException, ParseException, PortletModeException{

		Map paramsMap = RequestUtil.getParameterMap(request);
		long fileEntryId = Long.parseLong(CustomUtil.strNull(paramsMap.get("fileEntryId")));
		
		EdisonFileUtil.edisonFileDownload(response, fileEntryId);
	}	

	@ResourceMapping(value="deleteSingleEdisonFile")
	public void deleteSingleEdisonFile(ResourceRequest request, ResourceResponse response) throws SystemException, JSONException, IOException, PortalException, ParseException, PortletModeException{
		
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
		long fileEntryId = Long.parseLong(CustomUtil.strNull(params.get("fileEntryId")));
		long boardGroupId = ParamUtil.get(request, "boardGroupId", themeDisplay.getSiteGroupId());
		
		String resultMsg = "";
		List fileList = new ArrayList();
		
		if(EdisonFileUtil.deleteSingleEdisonFile(fileEntryId)){
			
			String solverId = CustomUtil.strNull(params.get("solverId"), "0");
			String classId = CustomUtil.strNull(params.get("classId"), "0");
			String divSort = request.getPreferences().getValue("divSort", "NOTICE");
			String boardSeq = CustomUtil.strNull(params.get("boardSeq"));
			
			String preFix = "";
			if(!solverId.equals("0")) preFix += "_"+solverId;
			if(!classId.equals("0")) preFix += "_"+classId;
			
			fileList = EdisonFileUtil.getListEdisonFile(
														boardGroupId, 
														preFix, 
														boardSeq,
														divSort);
			
			resultMsg = "SUCCESS";
		}else{
			resultMsg = "DELETE_FAIL";
		}
		
		JSONObject obj = new JSONObject();
		
		obj.put("fileList", fileList);
		obj.put("resultMsg", resultMsg);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
}
