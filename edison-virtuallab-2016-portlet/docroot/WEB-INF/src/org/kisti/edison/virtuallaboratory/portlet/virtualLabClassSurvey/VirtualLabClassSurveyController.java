package org.kisti.edison.virtuallaboratory.portlet.virtualLabClassSurvey;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.service.SurveyAnswerLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.SurveyLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.SurveyQuestionLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("VIEW")
public class VirtualLabClassSurveyController {
	private static Log log = LogFactoryUtil.getLog(VirtualLabClassSurveyController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
	
			httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
			String classId = httpRequest.getParameter("classId");
			long companyId = PortalUtil.getCompanyId(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			
			User user = PortalUtil.getUser(request);
			Map<String, Object> params = RequestUtil.getParameterMap(httpRequest);
			String role;
			List<Map<String, Object>> surveyAttend = null;
			
			if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.TEMP_USER)) {
				classId = (String) user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
			} else {
				for (Map.Entry<String,Object> str : params.entrySet()) {
					if(str.getKey().contains("classId")) {
						classId =  (String) str.getValue();
					}
				}
			}
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			
			Map<String, String> classInfo = null;
			
			long classId_ = GetterUtil.get(classId, 0L);
			
			if(classId_ > 0) {
				classInfo = VirtualLabClassLocalServiceUtil.getVirtualClassMainVisual(classId_, locale);
			}
			
			if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) ||	// 포털 Admin Check
					EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR) ||	// 사이트 Admin Check
					EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER) ||
					UserGroupRoleCustomLocalServiceUtil.checkRoleVirtualLabClass(companyId, groupId, user.getUserId(), GetterUtil.get(classInfo.get("virtualLabId"), 0L), classId_) != null){
				role = "ADMIN";
				surveyAttend = SurveyLocalServiceUtil.getSurveyMappingList(GetterUtil.get(classInfo.get("virtualLabId"), 0L), true, locale);
			} else {
				role = "STUDENT";
				surveyAttend = SurveyLocalServiceUtil.getSurveyMappingVoteList(GetterUtil.get(classInfo.get("virtualLabId"), 0L), classId_, user.getUserId(), true, locale);
			}
			
			model.addAttribute("role", role);
			model.addAttribute("surveyAttend", surveyAttend);
			model.addAttribute("surveyCount", surveyAttend.size());
			model.addAttribute("classInfo", classInfo);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "virtualLabClassSurvey/surveyClassAttend";
	}
	
	@ResourceMapping(value="getSurveyAttend")
	public void getSurveyAttend(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
		long classId = ParamUtil.get(request, "classId", 0);
		User user = PortalUtil.getUser(request);
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		String role;
		
		List<Map<String, Object>> surveyAttend = null;
		
		if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) ||	// 포털 Admin Check
				EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR) ||	// 사이트 Admin Check
				EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER) ||
				UserGroupRoleCustomLocalServiceUtil.checkRoleVirtualLabClass(companyId, groupId, user.getUserId(), virtualLabId, classId) != null){
			role = "ADMIN";
			surveyAttend = SurveyLocalServiceUtil.getSurveyMappingList(virtualLabId, true, locale);
		} else {
			role = "STUDENT";
			surveyAttend = SurveyLocalServiceUtil.getSurveyMappingVoteList(virtualLabId, classId, user.getUserId(), true, locale);
		}
		
		JSONObject obj = new JSONObject();
		
		obj.put("role", role);
		obj.put("surveyAttend", surveyAttend);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@RenderMapping(params = "myaction=surveyVote")
	public String surveyVote(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			
			long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0);
			Map surveyMap = (Map) SurveyLocalServiceUtil.getSurveyInfomation(surveySeqNo, locale);	
			List surveyQuestionList = (List) SurveyQuestionLocalServiceUtil.getSurveyQuestionInfomation(surveySeqNo, locale);
			User user = PortalUtil.getUser(request);
			long companyId = PortalUtil.getCompanyId(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			
			long classId = ParamUtil.get(request, "classId", 0);
			long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
			
			model.addAttribute("classId",classId);
			model.addAttribute("surveyMap",surveyMap);
			model.addAttribute("surveyQuestionList",surveyQuestionList);
			
			if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) ||	// 포털 Admin Check
					EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR) ||	// 사이트 Admin Check
					EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)){
				return "virtualLabClassSurvey/surveyDescription";
			} else if (UserGroupRoleCustomLocalServiceUtil.checkRoleVirtualLabClass(companyId, groupId, user.getUserId(), virtualLabId, classId) != null) {
				return "virtualLabClassSurvey/surveyDescription";
			}
		return "virtualLabClassSurvey/surveyVote";
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
			return "";
		}
	}
	
	@ResourceMapping(value="surveyQuestionList")
	public void surveyQuestionList(ResourceRequest request, ResourceResponse response)  throws PortalException, SystemException, IOException, SQLException{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();

		long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0);
		
		String resultCode = "200";
		
		Map params = RequestUtil.getParameterMap(request);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		User user = PortalUtil.getUser(request);
		PrintWriter writer = response.getWriter();
		JSONArray json = new JSONArray();		
		List jobList = (List) SurveyQuestionLocalServiceUtil.getSurveyQuestionInfomation(surveySeqNo, locale);
		json = JSONArray.fromObject(JSONSerializer.toJSON(jobList));
		StringBuffer responseBuffer = new StringBuffer();
		responseBuffer.append("{");
		responseBuffer.append("		\"dataList\":	");
		responseBuffer.append(					CustomUtil.strNull(json.toString()));	
		responseBuffer.append("}");
		
		writer.write(responseBuffer.toString());		
		writer.close();
	}
	
	@ResourceMapping(value="surveyVoteInsert")
	public void surveyVoteInsert(ResourceRequest request, ResourceResponse response)  throws PortalException, SystemException, IOException, SQLException{
		
		Map<String, Object> params = RequestUtil.getParameterMap(request);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();		
		String resultCode = "200";
		User user = PortalUtil.getUser(request);
		
		long virtualLabId = ParamUtil.get(request, "virtualLabId", 0);
		long classId = ParamUtil.get(request, "classId", 0);
		long userId = PortalUtil.getUserId(request);
		
		long surveySeqNo = ParamUtil.get(request, "surveySeqNo", 0);
		int questionCnt = 0;
		for(String key : params.keySet()) {
			if(key.contains("questionSeqNo")) {
				questionCnt++;
			}
		}
		
		int surveyCheck = SurveyLocalServiceUtil.getCountSurveyCheck(surveySeqNo, userId, classId);	// 설문참여 중복 체크
		
		if(surveySeqNo > 0 && surveyCheck == 0){
			Map<String, String> answerInsertMap = new HashMap<String, String>();
			for(int i=0; i < questionCnt; i++){
				answerInsertMap.put("virtualLabId", String.valueOf(virtualLabId));
				answerInsertMap.put("classId", String.valueOf(classId));
				answerInsertMap.put("userId", String.valueOf(user.getUserId()));
				answerInsertMap.put("questionSeqNo", CustomUtil.strNull(params.get("questionSeqNo"+(i+1))));
				if(CustomUtil.strNull(params.get("questionDivCd"+(i+1))).equals("SVY_02_001")){						
					answerInsertMap.put("objecttivityAnswer", CustomUtil.strNull(params.get("objecttivityAnswer"+(i+1))));
				}else if(CustomUtil.strNull(params.get("questionDivCd"+(i+1))).equals("SVY_02_002")){
					answerInsertMap.put("subjectivityAnswer", CustomUtil.strNull(params.get("subjectivityAnswer"+(i+1))));
				}
				SurveyAnswerLocalServiceUtil.insertSurveyAnswer(answerInsertMap);
				answerInsertMap.clear();
			}
		} else {
			resultCode = "400";
		}
		
		writer.write(resultCode);		
		writer.close();
	}
	
}
