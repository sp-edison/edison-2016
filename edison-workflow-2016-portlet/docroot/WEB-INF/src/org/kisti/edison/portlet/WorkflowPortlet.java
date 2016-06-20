package org.kisti.edison.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.service.WorkflowLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.util.TokenProviderUtil;
import org.kisti.edison.util.VCRegisterUtil_fileTest;
import org.kisti.edison.wfapi.custom.MyFileIcebreakerUtil;
import org.kisti.edison.wfapi.custom.WorkflowPagingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

@Controller
@RequestMapping("VIEW")
public class WorkflowPortlet{
	
	private static Log log = LogFactory.getLog(WorkflowPortlet.class);
	
  @RequestMapping
  public String view(RenderRequest request, RenderResponse response, ModelMap model)
      throws SystemException, IOException, PortalException, SQLException, ParseException{
    log.debug("view rendering");
    try{
      ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
      //PortletLocalServiceUtil.getPortletApp("edison-scienceAppstore");
      long appstorePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false,
          "edisonscienceAppstore_WAR_edisonappstore2016portlet");
      //서비스 언어 
      Locale[] availableLanguage = LanguageUtil.getAvailableLocales();
      model.addAttribute("ableLang", availableLanguage);
      model.addAttribute("defaultLang", themeDisplay.getLanguageId());
      model.addAttribute("appstorePlid", appstorePlid);
    }catch (Exception e){
      log.error(e);
      e.printStackTrace();
      // Session Error Message
      SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
    }
    return "workflow/view";
  }
  
  @ResourceMapping(value="updateWorkflowConf")
  public void updateWorkflowConf(ResourceRequest request, ResourceResponse response) throws IOException, PortalException, SystemException{
    Map params = RequestUtil.getParameterMap(request);
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    WorkflowLocalServiceUtil.updateWorkflow(params);
    PrintWriter writer = response.getWriter();
    writer.print("<script>parent.refreshListButtonClick();</script>");
    writer.flush();
    writer.close();
  }

  @ResourceMapping(value="getEditorPortlet")
  public void getEditorPortletUrl(ResourceRequest request, ResourceResponse response) throws IOException{
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    String portletId = GetterUtil.getString(request.getParameter("portletId"));
    String portletURL = PortletURLFactoryUtil
        .create(request, portletId, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE)
        .toString();
    
    JSONObject obj = JSONFactoryUtil.createJSONObject();
    obj.put("portletURL", portletURL);
    response.setContentType("application/json; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write(obj.toString());
  }
  
  @ResourceMapping(value="getAuthToken")
  public void getAuthToken(ResourceRequest request, ResourceResponse response) throws IOException{
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    String portletId = GetterUtil.getString(request.getParameter("portletId"));
    String authToken = AuthTokenUtil.getToken(PortalUtil.getHttpServletRequest(request), themeDisplay.getPlid(), portletId);
    
    JSONObject obj = JSONFactoryUtil.createJSONObject();
    obj.put("authToken", authToken);
    obj.put("plid", themeDisplay.getPlid());
    response.setContentType("application/json; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write(obj.toString());
  }
	
  
  @ResourceMapping(value="getSiteGroupId")
  public void getSiteGroupId(ResourceRequest request, ResourceResponse response) throws IOException, PortalException, SystemException{
    long groupId = PortalUtil.getScopeGroupId(request);
    JSONObject obj = JSONFactoryUtil.createJSONObject();
    obj.put("groupId", groupId);
    response.setContentType("application/json; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write(obj.toString());
  }
  
  @SuppressWarnings("unchecked")
  @ResourceMapping(value="getIcebreakerAccessToken")
  public void getIcebreakerAccessToken(ResourceRequest request, ResourceResponse response) throws IOException, NumberFormatException, PortalException, SystemException, ParseException{
    Map<String, Object> param = RequestUtil.getParameterMap(request);
    long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    User user = themeDisplay.getUser();
    Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
    
    if(thisGroup.getParentGroupId() == 0){ //포탈
      String visitSite = themeDisplay.getUser().getExpandoBridge().getAttribute(EdisonExpando.USER_VISIT_SITE).toString();
      List<Group> groupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), thisGroup.getGroupId(), true);//하위 그룹 리스트
      
      for(Group group : groupList){
        if(visitSite.equals(group.getName())){
          groupId = group.getGroupId();
          thisGroup = GroupLocalServiceUtil.getGroup(groupId);
          break;
        }
      }
    }
    IcebreakerVcToken icebreakerVcToken = getOrCreateToken(user, groupId);
    
    String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
    JSONObject obj = JSONFactoryUtil.createJSONObject();
    obj.put("icebreakerUrl", icebreakerUrl);
    obj.put("icebreakerVcToken", icebreakerVcToken.getVcToken());
    obj.put("groupId", groupId);
    response.setContentType("application/json; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write(obj.toString());
  }
  
  private IcebreakerVcToken getOrCreateToken(User user, long groupId) throws PortalException, SystemException, NumberFormatException, MalformedURLException, IOException, ParseException{
    
    IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();
    
    Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);    
    String userScreenName = "";
    String userPassword = "";
    
    String universityField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY);
    String virtualLabId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_LAB_ID);
    String classId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
    String majorField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR);
    
    if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR) || EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
      userScreenName = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_ID);
      userPassword = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_PWD);
    }else{
      userScreenName = String.valueOf(user.getScreenName());
      userPassword = user.getPassword();
    }
    
    if(VCRegisterUtil_fileTest.isVcInfo(groupId, userScreenName) == 200){  
      if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId))){
        
        icebreakerVcToken.setVcToken(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId))));        
        icebreakerVcToken.setVcTokenExpired(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(groupId)), "0"));
  
        if(Integer.parseInt(icebreakerVcToken.getVcTokenExpired()) <= Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
          //시간이 지난 토큰인 경우 새로운 토큰 발행 및 커스텀 필드 저장       
          icebreakerVcToken = TokenProviderUtil.getVcToken(groupId, userScreenName, userPassword);
    
          //Icebreaker에 회원정보는 있으나 로그인 되지 않는 경우 비밀번호 변경으로 인한것으로 판단하여 비밀번호 update후에 다시 로그인하여 토큰을 요청 합니다. 
          if(icebreakerVcToken.getResultCode() != 200){
            int updateResult = VCRegisterUtil_fileTest.VCUpdate(groupId, userScreenName, userPassword, user.getEmailAddress());
            if(updateResult==200){
              icebreakerVcToken = TokenProviderUtil.getVcToken(groupId, userScreenName, userPassword);
            }
          }
          
          if(icebreakerVcToken.getResultCode() == 200){
            icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());         
            icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
            
            user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId), icebreakerVcToken.getVcToken());
            user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(groupId), icebreakerVcToken.getVcTokenExpired());
          }else{
            log.debug("Icebreaker getOrCreateToken Error !!");
          }
        }else{
          //icebreaker 계정은 있으나 포털에 expando가 없는 경우 expando 추가 생성
          icebreakerVcToken = MyFileIcebreakerUtil.createExpandoUserVctoken(user, groupId, userScreenName, userPassword);
        }
      }
    }else{ // Icebreaker 계정이 없는경우
      //icebreaker 계정도 없는 경우 생성
      int resultRegist = VCRegisterUtil_fileTest.VCRegist(groupId, userScreenName, userPassword, user.getEmailAddress(), user.getFirstName(), universityField, virtualLabId, classId, majorField);
      if (resultRegist == 201) {
        //icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
        icebreakerVcToken = MyFileIcebreakerUtil.createExpandoUserVctoken(user, groupId, userScreenName, userPassword);
      }
    }
    return icebreakerVcToken;
  }
  
  @ResourceMapping(value="getWorkflowInstances")
  public View workflowInstanceListByUser(
      @RequestParam Map<String, Object> searchParam, 
      ResourceRequest request)
          throws Exception{
    try{
      long groupId = PortalUtil.getScopeGroupId(request);
      Locale locale = PortalUtil.getLocale(request);
      User user = PortalUtil.getUser(request);
      Map<String, Object> listAndPagingMap = new HashMap<>();
      long companyId = PortalUtil.getCompany(request).getCompanyId();
      searchParam.put("companyId", companyId);
      searchParam.put("groupId", groupId);
      String pagingClassName = GetterUtil.getString(searchParam.get("pagingClassName")); 
      int curPage = Integer.parseInt(CustomUtil.strNull(searchParam.get("p_curPage"), "1"));
      int linePerPage = Integer.parseInt(CustomUtil.strNull(searchParam.get("linePerPage"), "10"));
      int pagePerBlock = 5;
      int totalCnt = GetterUtil.getInteger(WorkflowLocalServiceUtil.getCountWorkflowInstanceByUserId(user, searchParam));
      int totalPage = WorkflowPagingUtil.getTotalPage(totalCnt, curPage, linePerPage);
      
      int begin = (curPage - 1) * linePerPage;
      int end = linePerPage;
      searchParam.put("begin", begin);
      searchParam.put("end", end);
      
      String pagingHtml = WorkflowPagingUtil.getPaging("", pagingClassName, totalCnt, curPage, linePerPage, pagePerBlock);
      
      listAndPagingMap.put("workflowInstances", WorkflowLocalServiceUtil.getWorkflowInstanceByUserId(user, searchParam, locale));
      listAndPagingMap.put("pagingHtml", pagingHtml);
      listAndPagingMap.put("curPage", curPage);
      listAndPagingMap.put("totalPage", totalPage);
      
      MappingJacksonJsonView view = new MappingJacksonJsonView();
      view.addStaticAttribute("workflowMap", listAndPagingMap);
      return view;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RenderMapping(params = "myaction=resultDownLoad")
  public String resultDownLoad(RenderRequest request, RenderResponse response, ModelMap model){
    try{
      @SuppressWarnings("rawtypes")
      Map param = RequestUtil.getParameterMap(request);
      ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

      long groupId = ParamUtil.getLong(request, "groupId", 0);
      String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge()
          .getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
      User user = themeDisplay.getUser();
      
      IcebreakerVcToken icebreakerVcToken = getOrCreateToken(user, groupId);
      String jobUuid = CustomUtil.strNull(param.get("jobUuid"));

      String result = SimulationLocalServiceUtil.retrievePostProcessor(icebreakerUrl,
          icebreakerVcToken.getVcToken(), jobUuid);
      if(!CustomUtil.strNull(result).equals("")){
        net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject
            .fromObject(net.sf.json.JSONSerializer.toJSON(result));
        net.sf.json.JSONArray jsonArray = jsonObj.getJSONArray("files");
        Map<String, Object> resultMap = null;
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

        for(int i = 0; i < jsonArray.size(); i++){
          resultMap = new HashMap<String, Object>();
          net.sf.json.JSONObject comandObj = (net.sf.json.JSONObject) jsonArray.get(i);

          resultMap.put("fileName", comandObj.getString("name"));
          resultMap.put("fileId", comandObj.getString("id"));

          resultMap.put("filePureSize", comandObj.getDouble("size"));
          resultMap.put("fileSize",
              CustomUtil.fileVolumeCalc(String.valueOf(comandObj.getDouble("size"))));
          resultMap.put("jobUuid", jobUuid);

          resultList.add(resultMap);
        }
        Comparator<Map<String, Object>> kdComp = new Comparator<Map<String, Object>>(){
          @Override
          public int compare(Map<String, Object> o1, Map<String, Object> o2){
            String s1 = o1.get("fileName").toString();
            String s2 = o2.get("fileName").toString();

            int n1 = s1.length(), n2 = s2.length();
            for(int i1 = 0, i2 = 0; i1 < n1 && i2 < n2; i1++, i2++){
              char c1 = s1.charAt(i1);
              char c2 = s2.charAt(i2);
              if(c1 != c2){
                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);
                if(c1 != c2){
                  c1 = Character.toLowerCase(c1);
                  c2 = Character.toLowerCase(c2);
                  if(c1 != c2){
                    return c1 - c2;
                  }
                }
              }
            }
            return n1 - n2;
          }
        };

        Collections.sort(resultList, kdComp);
        model.addAttribute("resultList", resultList);
      }else{
        model.addAttribute("file_state", "false");
      }
      model.addAttribute("selectedGroupId", groupId);
      model.addAttribute("icebreakerUrl", icebreakerUrl);

      // 임시 : Result.zip File ID
      String resultFileStr = SimulationLocalServiceUtil.retrieveRemoteDir(icebreakerUrl,
          icebreakerVcToken.getVcToken(), jobUuid, "/");
      if(!CustomUtil.strNull(resultFileStr).equals("")){
        net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject
            .fromObject(net.sf.json.JSONSerializer.toJSON(resultFileStr));
        net.sf.json.JSONArray jsonArray = jsonObj.getJSONArray("files");

        root1: for(int i = 0; i < jsonArray.size(); i++){
          net.sf.json.JSONObject comandObj = (net.sf.json.JSONObject) jsonArray.get(i);
          if(comandObj.getString("name").equals("result.zip")){
            model.addAttribute("zipFileId", comandObj.getString("id"));
            break root1;
          }
        }
      }
    }catch (Exception e){
      log.error(e);
      e.printStackTrace();
      // Session Error Message
      SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
    }
    return "monitoring/resultDownView";
  }
}
