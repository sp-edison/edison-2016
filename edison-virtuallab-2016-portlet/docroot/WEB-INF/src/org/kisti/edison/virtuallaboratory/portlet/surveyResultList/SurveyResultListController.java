package org.kisti.edison.virtuallaboratory.portlet.surveyResultList;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.ExcelUtil;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.service.SurveyAnswerLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.SurveyLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.SurveyQuestionLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("VIEW")
public class SurveyResultListController {
	private static Log log = LogFactoryUtil.getLog(SurveyResultListController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			User user = PortalUtil.getUser(request);
			Map params = RequestUtil.getParameterMap(request);
			
			long companyId = themeDisplay.getCompanyId();
			
			
			String surveySeqno = ParamUtil.get(request, "surveySeqNo", "");
			model.addAttribute("surveySeqNo", surveySeqno);
			
			//하위 사이트 존재 여부
			boolean isChildrenSite = false;
			if(GroupLocalServiceUtil.getGroups(companyId, PortalUtil.getScopeGroupId(request), true).size()>0){
				isChildrenSite = true;
			}
			
			if(isChildrenSite){
				// GUEST(Edison) Group 가져오기 
				List<Group> parentGroupList = GroupLocalServiceUtil.getGroups(companyId, 0, true);
				Group parentGroup = null;
				for(Group group : parentGroupList){
					if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){
						parentGroup = group;
						break;
					}
				}
				
				List<Group> groupList = CustomUtil.getGroupIdASC(GroupLocalServiceUtil.getGroups(companyId, parentGroup.getGroupId(), true));
				// 설문관리 탭 추가 
				String groupName = "survey,";
				String groupId = "survey,";
				int groupCnt = 0;
				
				// 최근 방문 사이트 가져오기
				String visitSite = ParamUtil.get(request, "visitSite", "");
				if(visitSite.equals("")) {
					String visitSiteName = (String) themeDisplay.getUser().getExpandoBridge().getAttribute(EdisonExpando.USER_VISIT_SITE);
					if((visitSiteName == null || visitSiteName.equals(""))) {
						visitSiteName = "survey";
					} else {
						visitSite = String.valueOf(GroupLocalServiceUtil.getGroup(companyId, visitSiteName).getGroupId());
					}
				}
				
				
				//탭 클릭 파라미터 가져오기
				String tabs1 = ParamUtil.getString(request, "tabs1", visitSite);
				
				if (tabs1 !=null && !tabs1.equals("") && !tabs1.equals("survey")) {
					themeDisplay.getUser().getExpandoBridge().setAttribute(EdisonExpando.USER_VISIT_SITE, GroupLocalServiceUtil.getGroup(Long.parseLong(tabs1)).getName());
				}
				
				Map<String,Long> GroupMap = new HashMap<String,Long>();
				
				if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)) {
					for(Group group:groupList){
						GroupMap.put(group.getName(), group.getGroupId());
						if(groupCnt==0){
							groupName += group.getName();
							groupId += group.getGroupId();
							groupCnt++;
						}else{
							groupName += ","+group.getName();
							groupId += ","+group.getGroupId();
						}
					}
				} else {
					for(Group group:groupList){
						if (EdisonUserUtil.isSiteRole(user, group.getGroupId(), RoleConstants.SITE_ADMINISTRATOR)) {	// 사이트 어드민은 해당하는 사이트만 넣기
							if(groupCnt==0){
								groupName += group.getName();
								groupId += group.getGroupId();
								groupCnt++;
								if(!visitSite.equals("survey")) {
									visitSite = String.valueOf(group.getGroupId());
								}
							} else {
								groupName += ","+group.getName();
								groupId += ","+group.getGroupId();
							}
						}
					}
				}
				
				List<Map<String, Object>> surveySelectList = SurveyLocalServiceUtil.getListSurveyAll(locale);
				
				if(surveySelectList != null && surveySelectList.size() > 0) {
					model.addAttribute("surveySelectList", surveySelectList);
				}
				model.addAttribute("visitSite", visitSite);
				model.addAttribute("tabNames", groupName);
				model.addAttribute("tabsValues", groupId);
				
				JSONObject json = new JSONObject();
				json.putAll(GroupMap);
				
				model.addAttribute("groupMap", json.toString());
			}else{
				
				Group recentGroup = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request));
				long parentGroupId =  recentGroup.getParentGroupId();
				
				if(parentGroupId==0){
					
					// 설문관리 탭 추가 
					String groupName = "survey,";
					String groupId = "survey,";
					
					Map<String,Long> GroupMap = new HashMap<String,Long>();
					
					groupName += recentGroup.getExpandoBridge().getAttribute("siteName");
					groupId += recentGroup.getGroupId();
					GroupMap.put(recentGroup.getName(), recentGroup.getGroupId()); 
					
					model.addAttribute("tabNames", groupName);
					model.addAttribute("tabsValues", groupId);
					
					JSONObject json = new JSONObject();
					json.putAll(GroupMap);
					model.addAttribute("groupMap", json.toString());
					
					//탭 클릭 파라미터 가져오기
					String tabs1 = ParamUtil.getString(request, "tabs1", "survey");
					
					model.addAttribute("visitSite", tabs1);
					
					List<Map<String, Object>> surveySelectList = SurveyLocalServiceUtil.getListSurveyAll(locale);
					
					if(surveySelectList != null && surveySelectList.size() > 0) {
						model.addAttribute("surveySelectList", surveySelectList);
					}
					
					
				}else{
					//분야별 사이트 일경우 - 추가 코딩 필요
				}
			}
			
			

		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "surveyResultList/surveyResultMain";
	}
	
	/*
	 * 설문조사 목록을 가져오는 메서드
	 */
	@ResourceMapping(value="getListSurvey")
	public void getListSurvey(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		int curPage = ParamUtil.get(request, "curPage", 1);
		int linePerPage = 10;
		
		int pagePerBlock = 10;
		int begin = linePerPage * (curPage - 1);
		String portletNameSpace = response.getNamespace();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("begin", String.valueOf(begin));
		params.put("end", String.valueOf(linePerPage * curPage));
		
		int surveyCount = SurveyLocalServiceUtil.getCountSurvey();
		List<Map<String, Object>> surveyList = SurveyLocalServiceUtil.getListSurvey(params, locale);
		String pageList = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", surveyCount, curPage, linePerPage, pagePerBlock);
		
		JSONObject obj = new JSONObject();
		
		obj.put("selectLine", linePerPage);
		obj.put("curPage", curPage);
		obj.put("pageList", pageList);
		obj.put("surveyList", surveyList);
		obj.put("totalCnt", surveyCount);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	/*
	 * 설문조사 입력 화면 이동
	 */
	@RenderMapping(params = "myaction=surveyInsertView")
	public String surveyInsertView(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map params = RequestUtil.getParameterMap(request);
			model.addAttribute("select_languageId",	GetterUtil.get(params.get("select_languageId"), themeDisplay.getLocale().toString()));
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "surveyResultList/surveyInsert";
	}
	
	/*
	 * 설문조사 정보 입력
	 */
	@ActionMapping(params = "myaction=insert")
	public void insert(ActionRequest request, ActionResponse response) {
		try {
			Map<String, Object> params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = CustomUtil.stringToLocale(ParamUtil.get(request, "select_languageId", themeDisplay.getLanguageId()));
			
			Map insertSurveyMap = new HashMap();
			insertSurveyMap.put("surveySeqNo", "0");
			insertSurveyMap.put("surveyTitle", CustomUtil.strNull(params.get("surveyTitle")));
			insertSurveyMap.put("surveyStatus", "SVY_01_001");
			insertSurveyMap.put("surveyStartDate", CustomUtil.strNull(params.get("surveyStartDate")));
			insertSurveyMap.put("surveyEndDate", CustomUtil.strNull(params.get("surveyEndDate")));
			insertSurveyMap.put("surveyDivCd", CustomUtil.strNull(params.get("surveyDivCd")));
			long newSeqno = SurveyLocalServiceUtil.insertSurvey(insertSurveyMap, locale).getSurveySeqNo();
			
			if(params.get("questionTitle") instanceof String){
				
				Map insertQuestionMap = new HashMap();
				insertQuestionMap.put("surveySeqNo", newSeqno);
				insertQuestionMap.put("questionTitle", CustomUtil.strNull(params.get("questionTitle")));
				insertQuestionMap.put("questionDivCd", CustomUtil.strNull(params.get("questionDivCd1")));
				if(CustomUtil.strNull(params.get("questionDivCd1")).equals("SVY_02_001")){
					if(params.get("question1") instanceof String){
						insertQuestionMap.put("question1", CustomUtil.strNull(params.get("question1")));
						
					}else if(params.get("question1") instanceof String[]){
						String[] que_arr = (String[]) params.get("question1");
						for(int i=0; i < que_arr.length; i++){
							insertQuestionMap.put("question"+(i+1), que_arr[i]);
						}
					}
				}
				
				SurveyQuestionLocalServiceUtil.insertSurveyQuestion(insertQuestionMap, locale);
				
			}else if(params.get("questionTitle") instanceof String[]){
				String[] qTitle_arr =  (String[]) params.get("questionTitle");
				
				/* 중간 질문을 삭제 했을때 번호가 뒤죽박죽되기 때문에 한번 정렬이 필요함 */
				ArrayList<Integer> arrayList = new ArrayList<Integer>();
				for(Map.Entry<String, Object> param : params.entrySet()) {
					if(param.getKey().startsWith("questionDivCd")) {
						arrayList.add(Integer.parseInt(param.getKey().replace("questionDivCd", "")));
					}
				}
				Collections.sort(arrayList);
				
				for(int i=0; i < qTitle_arr.length; i++){
					String questionTitle = qTitle_arr[i];
					int cnt = arrayList.get(i);
					Map insertQuestionMap = new HashMap();
					insertQuestionMap.put("surveySeqNo", newSeqno);
					insertQuestionMap.put("questionTitle", questionTitle);
					insertQuestionMap.put("questionDivCd", CustomUtil.strNull(params.get("questionDivCd"+cnt)));
					if(CustomUtil.strNull(params.get("questionDivCd"+cnt)).equals("SVY_02_001")){
						
						if(params.get("question"+cnt) instanceof String){
							insertQuestionMap.put("question1", CustomUtil.strNull(params.get("question"+cnt)));
							
						}else if(params.get("question"+cnt) instanceof String[]){
							String[] que_arr = (String[]) params.get("question"+cnt);
							for(int j=0; j < que_arr.length; j++){
								insertQuestionMap.put("question"+(j+1), que_arr[j]);
							}
						}
					}
					
					SurveyQuestionLocalServiceUtil.insertSurveyQuestion(insertQuestionMap, locale);
				}
			}
			
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("myaction", "surveyView");
			portletURL.setParameter("surveySeqNo", CustomUtil.strNull(newSeqno));
			portletURL.setParameter("select_languageId", GetterUtil.get(params.get("select_languageId"), themeDisplay.getLocale().toString()));
			portletURL.setParameter("RENDER_MSG", "WRITE");
			
			SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);

			response.sendRedirect(portletURL.toString());
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
		}
	}
	
	/*
	 * 설문조사 수정
	 */
	@Transactional
	@ActionMapping(params = "myaction=update")
	public void update(ActionRequest request, ActionResponse response) {
		try {
			Map<String, Object> params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = CustomUtil.stringToLocale(ParamUtil.get(request, "current_languageId", ParamUtil.get(request, "select_languageId", themeDisplay.getLanguageId())));
			
			String surveySeqNo = CustomUtil.strNull(params.get("surveySeqNo"));
			Map insertSurveyMap = new HashMap();
			insertSurveyMap.put("surveySeqNo", CustomUtil.strNull(params.get("surveySeqNo")));
			insertSurveyMap.put("surveyTitle", CustomUtil.strNull(params.get("surveyTitle")));
			insertSurveyMap.put("surveyStartDate", CustomUtil.strNull(params.get("surveyStartDate")));
			insertSurveyMap.put("surveyEndDate", CustomUtil.strNull(params.get("surveyEndDate")));
			
			List<Long> questionSeqList = SurveyQuestionLocalServiceUtil.getQuestionSeqList(Long.parseLong(surveySeqNo));
			SurveyLocalServiceUtil.insertSurvey(insertSurveyMap, locale);
			
			/* 중간 질문을 삭제 했을때 번호가 뒤죽박죽되기 때문에 한번 정렬이 필요함 */
			ArrayList<Long> arrayList = new ArrayList<Long>();
			for(Map.Entry<String, Object> param : params.entrySet()) {
				if(param.getKey().startsWith("questionTitle")) {
					arrayList.add(GetterUtil.get(param.getKey().replace("questionTitle", ""),0L));
				}
			}
			
			Collections.sort(arrayList);
	//		System.out.println("save: " + arrayList);
	//		System.out.println("get: " + questionSeqList);
			for(int i = 0; i < arrayList.size(); i++) {
				Map insertQuestionMap = new HashMap();
				long cnt = arrayList.get(i);
				insertQuestionMap.put("surveySeqNo", Long.parseLong(surveySeqNo));
				if(cnt < 0) {
					insertQuestionMap.put("questionSeqNo", Math.abs(cnt));
					if(questionSeqList != null) {
						questionSeqList.remove(Math.abs(cnt));
					}
				} else {
					insertQuestionMap.put("questionSeqNo", 0);
				}
				insertQuestionMap.put("questionTitle", CustomUtil.strNull(params.get("questionTitle"+cnt)));
				insertQuestionMap.put("questionDivCd", CustomUtil.strNull(params.get("questionDivCd"+cnt)));
				if(CustomUtil.strNull(params.get("questionDivCd"+cnt)).equals("SVY_02_001")){
					
					if(params.get("question"+cnt) instanceof String){					
						insertQuestionMap.put("question1", CustomUtil.strNull(params.get("question"+cnt)));
						
					}else if(params.get("question"+cnt) instanceof String[]){
						String[] que_arr = (String[]) params.get("question"+cnt);
						for(int j=0; j < que_arr.length; j++){
							insertQuestionMap.put("question"+(j+1), que_arr[j]);
						}
					}
				}
				SurveyQuestionLocalServiceUtil.insertSurveyQuestion(insertQuestionMap, locale);
			}
			
	//		System.out.println("remove: " + questionSeqList);
			if(questionSeqList != null && questionSeqList.size() > 0) {
				for (Long removeSeqNo : questionSeqList) {
					SurveyQuestionLocalServiceUtil.deleteSurveyQuestion(removeSeqNo);
				}
			}
			
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("myaction", "surveyView");
			portletURL.setParameter("surveySeqNo", surveySeqNo);
			portletURL.setParameter("select_languageId", GetterUtil.get(params.get("select_languageId"), themeDisplay.getLocale().toString()));
			portletURL.setParameter("RENDER_MSG", "UPDATE");
			
			SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
	
			response.sendRedirect(portletURL.toString());
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
		}
	}
	
	/*
	 * 설문조사 내용 확인
	 */
	@RenderMapping(params = "myaction=surveyView")
	public String surveyView(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			Map params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = CustomUtil.stringToLocale(ParamUtil.get(request, "select_languageId", themeDisplay.getLanguageId()));
			
			long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0L);
			
			Map surveyMap = (Map) SurveyLocalServiceUtil.getSurveyInfomation(surveySeqNo, locale);
			
			List surveyQuestionList = (List) SurveyQuestionLocalServiceUtil.getSurveyQuestionInfomation(surveySeqNo, locale);
			
			int answerCnt = SurveyAnswerLocalServiceUtil.getCountAnswerResult(surveySeqNo, 0, 0);
	
			model.addAttribute("RENDER_MSG", GetterUtil.get(params.get("RENDER_MSG"), ""));
			model.addAttribute("select_languageId",	GetterUtil.get(params.get("select_languageId"), themeDisplay.getLocale().toString()));
			model.addAttribute("surveyMap",surveyMap);
			model.addAttribute("answerCnt",answerCnt);
			model.addAttribute("surveyQuestionList",surveyQuestionList);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "surveyResultList/surveyView";
	}
	
	/*
	 * 설문조사 삭제
	 */
	@ActionMapping(params = "myaction=delete")
	public void delete(ActionRequest request, ActionResponse response) {
		try {
			long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0);
			
			SurveyLocalServiceUtil.deleteSurvey(surveySeqNo);
			SurveyQuestionLocalServiceUtil.deleteSurveyQuestionList(surveySeqNo);
			
			response.setRenderParameter("visitSite", "survey");
			response.setPortletMode(PortletMode.VIEW);
			
			SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
		}
	}
	
	/*
	 * 설문조사 결과 목록(클래스별 확인)
	 */
	@ResourceMapping(value="getListSurveyResult")
	public void getListSurveyResult(ResourceRequest request, ResourceResponse response) throws IOException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		int curPage = ParamUtil.get(request, "curPage", 1);
		long groupId = ParamUtil.get(request, "groupId", 0);
		long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0);
		String searchField = ParamUtil.get(request, "searchField", "");
		int linePerPage = ParamUtil.get(request, "linePerPage", 10);
		
		int pagePerBlock = 10;
		int begin = linePerPage * (curPage - 1);
		String portletNameSpace = response.getNamespace();
		
		int surveyCount = SurveyLocalServiceUtil.getCountSurveyResultList(groupId, surveySeqNo, searchField, locale);
		List<Map<String, Object>> surveyResultList = SurveyLocalServiceUtil.getSurveyResultList(groupId, surveySeqNo, searchField, begin, linePerPage, locale);
		
		String pageList = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", surveyCount, curPage, linePerPage, pagePerBlock);
		JSONObject obj = new JSONObject();
		
		obj.put("selectLine", linePerPage);
		obj.put("curPage", curPage);
		obj.put("pageList", pageList);
		obj.put("surveyResultList", surveyResultList);
		obj.put("totalCnt", surveyCount);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	/*
	 * 설문조사 결과 확인
	 */
	@RenderMapping(params = "myaction=surveyResultView")
	public String surveyResultView(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			Map params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			
			long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0L);
			long classId = ParamUtil.get(request, "classId", 0L);
			String visitSite = ParamUtil.get(request, "tabs1", "survey");
			
			Map<String, String> classInfo = null;
			
			if(classId > 0) {
				classInfo = VirtualLabClassLocalServiceUtil.getVirtualClassMainVisual(classId, locale);
			}
			
			Map surveyMap = (Map) SurveyLocalServiceUtil.getSurveyInfomation(surveySeqNo, locale);
			List surveyQuestionList = (List) SurveyQuestionLocalServiceUtil.getSurveyQuestionInfomation(surveySeqNo, locale);
			
			
			model.addAttribute("visitSite",visitSite);
			model.addAttribute("classInfo",classInfo);
			model.addAttribute("classId",classId);
			model.addAttribute("surveyMap",surveyMap);
			model.addAttribute("surveyQuestionList",surveyQuestionList);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "surveyResultList/surveyResult";
	}
	
	/*
	 * 설문조사 surveySeqNo에 해당하는 질문 리스트 조회
	 */
	@ResourceMapping(value="surveyQuestionList")
	public void surveyQuestionList(ResourceRequest request, ResourceResponse response)  throws PortalException, SystemException, IOException, SQLException{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		String resultCode = "200";
		
		Map params = RequestUtil.getParameterMap(request);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		User user = PortalUtil.getUser(request);
		PrintWriter writer = response.getWriter();
		JSONArray json = new JSONArray();
		
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
		long classId = ParamUtil.get(request, "classId", 0);

		long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0L);
		
		long groupId = ParamUtil.get(request, "tabs", 0);
		
		List jobList = (List) SurveyQuestionLocalServiceUtil.getSurveyQuestionResult(surveySeqNo, virtualLabId, classId, groupId, locale);
		json = JSONArray.fromObject(JSONSerializer.toJSON(jobList));
		
		StringBuffer responseBuffer = new StringBuffer();
		responseBuffer.append("{");
		responseBuffer.append("		\"dataList\":	");
		responseBuffer.append(					CustomUtil.strNull(json.toString()));	
		responseBuffer.append("}");
		
		writer.write(responseBuffer.toString());		
		writer.close();
	}
	
	/*
	 * 설문조사 surveySeqNo에 해당하는 답변 목록 조회
	 */
	@ResourceMapping(value="surveyAnswerList")
	public void surveyAnswerList(ResourceRequest request, ResourceResponse response)  throws PortalException, SystemException, IOException, SQLException{
		
		
		String resultCode = "200";
		
		Map params = RequestUtil.getParameterMap(request);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		User user = PortalUtil.getUser(request);
		PrintWriter writer = response.getWriter();
		JSONArray json = new JSONArray();
		
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
		long classId = ParamUtil.get(request, "classId", 0);
		long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0L);
		String questionDivCd = "SVY_02_002";
		long questionSeqNo = ParamUtil.get(request, "questionSeqNo", 0L);
		long groupId = ParamUtil.get(request, "tabs", 0);
		
		
		List jobList = (List) SurveyQuestionLocalServiceUtil.getSurveyQuestionSubject(surveySeqNo, virtualLabId, classId, questionDivCd, questionSeqNo, groupId);
		json = JSONArray.fromObject(JSONSerializer.toJSON(jobList));
		
		StringBuffer responseBuffer = new StringBuffer();
		responseBuffer.append("{");
		responseBuffer.append("		\"dataList\":	");
		responseBuffer.append(					CustomUtil.strNull(json.toString()));	
		responseBuffer.append("}");
		
		writer.write(responseBuffer.toString());		
		writer.close();
	}
	
	/*
	 * 설문조사 결과 엑셀 다운로드
	 */
	@ResourceMapping(value="surveyExcelDownLoad")
	public void surveyExcelDownLoad(ResourceRequest request, ResourceResponse response)  throws PortalException, SystemException, IOException, SQLException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0L);
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0L);
		long classId = ParamUtil.get(request, "classId", 0L);
		long groupId = ParamUtil.get(request, "tabs", 0);
		
		List resultList = (List) SurveyAnswerLocalServiceUtil.getExcelResult(surveySeqNo, virtualLabId, classId, groupId,themeDisplay.getLanguageId());
		String msg = ExcelUtil.surveyRowExcelDownload(response, CustomUtil.strNull(params.get("surveyTitle")), resultList);
	}
}
