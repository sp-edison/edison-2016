package org.kisti.edison.wfapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.science.service.PortTypeAnalyzerLinkLocalServiceUtil;
import org.kisti.edison.science.service.PortTypeEditorLinkLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppInputPortsLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppOutputPortsLocalServiceUtil;
import org.kisti.edison.wfapi.custom.WorkflowBeanUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.rits.cloning.Cloner;

@Controller
@RequestMapping("/services/app")
public class ScienceAppController{
  private Log log = LogFactoryUtil.getLog(getClass());
  private Cloner cloner = new Cloner();
  
  @RequestMapping(value = "/groups/{groupId}", method = RequestMethod.GET)
  public @ResponseBody List<Map<String, Object>> groupCategories(
      @PathVariable("groupId") long groupId,
      HttpServletRequest request)
          throws Exception{
    try{
      long companyGroupId = PortalUtil.getCompany(request).getGroupId();
      List<Map<String, Object>> scienceApps = ScienceAppLocalServiceUtil.retrieveListScienceAppWithOutExpando(
          companyGroupId, groupId, PortalUtil.getLocale(request),
          (Map<String, Object>) new HashMap<String, Object>(), 0, 0);

      return scienceApps;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/groups", method = RequestMethod.GET)
  public @ResponseBody List<Map<String, Object>> groups(
      HttpServletRequest request)
      throws Exception{
    try{
      List<Group> groups = GroupLocalServiceUtil.getGroups(PortalUtil.getCompanyId(request),
          ServiceContextFactory.getInstance(request).getScopeGroupId(), true);
      return WorkflowBeanUtil.groupToJstreeModel(groups, PortalUtil.getLocale(request));
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }

  @RequestMapping(value = "/categories", method = RequestMethod.GET)
  public @ResponseBody List<Map<String, Object>> categories(HttpServletRequest request)
      throws Exception{
    try{
      long companyGroupId = PortalUtil.getCompany(request).getGroupId();
      List<AssetCategory> lv1Categories = new ArrayList<>();
      AssetVocabulary aVocabulary = AssetVocabularyLocalServiceUtil
          .getGroupVocabulary(companyGroupId, EdisonAssetCategory.GLOBAL_DOMAIN);
      
      for(AssetCategory assetCategory : aVocabulary.getCategories()){
        if(assetCategory.getParentCategoryId() == 0){
          lv1Categories.add(assetCategory);
        }
      }
      return WorkflowBeanUtil
          .assetCategoryToJstreeModel(lv1Categories, PortalUtil.getLocale(request));
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public @ResponseBody List<Map<String, Object>> temp(HttpServletRequest request)
      throws Exception{
    try{
      List<Map<String, Object>> results = new ArrayList<>();
      List<Map<String, Object>> apps = new ArrayList<>();
      long companyGroupId = PortalUtil.getCompany(request).getGroupId();
      Locale locale = PortalUtil.getLocale(request);
      List<AssetCategory> lv1Categories = new ArrayList<>();
      AssetVocabulary aVocabulary = AssetVocabularyLocalServiceUtil
          .getGroupVocabulary(companyGroupId, EdisonAssetCategory.GLOBAL_DOMAIN);
      for(AssetCategory assetCategory : aVocabulary.getCategories()){
        if(assetCategory.getParentCategoryId() == 0){
          lv1Categories.add(assetCategory);
        }
      }
      List<Map<String, Object>> rootCategories = WorkflowBeanUtil
          .assetCategoryToJstreeModel(lv1Categories, locale);
      results.addAll(rootCategories);
      for(Map<String, Object> lv1 : rootCategories){
        long lv1CategoryId = GetterUtil.getLong(lv1.get("categoryId"));
        List<Map<String, Object>> subCategories = 
            ScienceAppLocalServiceUtil.getLanguageSpecificAssetCategories(
                AssetCategoryLocalServiceUtil.getChildCategories(lv1CategoryId),
                lv1CategoryId, locale);
        for(Map<String, Object> lv2 : subCategories){
          long lv2CategoryId = GetterUtil.getLong(lv2.get("categoryId"));
          lv2.put("id", lv2CategoryId);
          lv2.put("data", cloner.deepClone(lv2));
          lv2.put("parent", lv1CategoryId);
          List<Map<String, Object>> app = WorkflowBeanUtil.scienceAppToJstreeModel(
              ScienceAppLocalServiceUtil.getScienceAppListByCategoryId(lv2CategoryId, locale),
              locale, lv2CategoryId);
          apps.addAll(app);
        }
        results.addAll(subCategories);
      }
      results.addAll(apps);
      
      return results;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }

  @RequestMapping(value = "/categories/{parentCategoryId}", method = RequestMethod.GET)
  public @ResponseBody List<Map<String, Object>> subCategories(
      @PathVariable("parentCategoryId") long parentCategoryId,
      HttpServletRequest request)
      throws Exception{
    try{
      List<AssetCategory> subCategories = 
          AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);
      return ScienceAppLocalServiceUtil
          .getLanguageSpecificAssetCategories(subCategories, parentCategoryId, 
              PortalUtil.getLocale(request));
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/categories/{categoryId}/apps", method = RequestMethod.GET)
  public @ResponseBody List<Map<String, Object>> findAppsBycategory(
      @PathVariable("categoryId") long categoryId,
      HttpServletRequest request) 
      throws Exception{
    try{
      Locale locale = PortalUtil.getLocale(request);
      return WorkflowBeanUtil.scienceAppToJstreeModel(
          ScienceAppLocalServiceUtil.getScienceAppListByCategoryId(categoryId, locale), locale, categoryId);
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public @ResponseBody List<Map<String, Object>> list(HttpServletRequest request)
      throws Exception{
    try{
      return WorkflowBeanUtil
          .transformToModelAttributes(ScienceAppLocalServiceUtil.getScienceApps(-1, -1));
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/list", params={"start", "end"}, method = RequestMethod.GET)
  public @ResponseBody List<Map<String, Object>> rangedList(
      @RequestParam("start") int start,
      @RequestParam("end") int end,
      HttpServletRequest request)
      throws Exception{
    try{
      return WorkflowBeanUtil
          .transformToModelAttributes(ScienceAppLocalServiceUtil.getScienceApps(start, end));
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value="/{scienceAppId}")
  public @ResponseBody Map<String, Object> app(
      @PathVariable("scienceAppId") long scienceAppId,
      HttpServletRequest request)
      throws SystemException, PortalException{
    try{
      return WorkflowBeanUtil
          .transformToModelAttributes(ScienceAppLocalServiceUtil.getScienceApp(scienceAppId));
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value="/{scienceAppId}/inputports")
  public @ResponseBody String getScienceAppInputPorts(
      @PathVariable("scienceAppId") long scienceAppId,
      HttpServletRequest request)
      throws SystemException, PortalException{
    try{
      long inputportCnt = ScienceAppInputPortsLocalServiceUtil.getScienceAppInputPortsesCount(scienceAppId);
      if(inputportCnt > 0){
        return ScienceAppInputPortsLocalServiceUtil.getInputPortsJsonString(scienceAppId);
      }else{
        return "{}";
      }
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value="/{scienceAppId}/outputports")
  public @ResponseBody String getScienceAppOutputPorts(
      @PathVariable("scienceAppId") long scienceAppId,
      HttpServletRequest request)
          throws SystemException, PortalException{
    try{
      long outputportCnt = ScienceAppOutputPortsLocalServiceUtil.getScienceAppOutputPortsesCount(scienceAppId);
      if(outputportCnt > 0){
        return ScienceAppOutputPortsLocalServiceUtil.getOutputPortsJsonString(scienceAppId);
      }else{
        return "{}";
      }
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = {
      "/{scienceAppId}/inputports/{portTypeId}"})
  public @ResponseBody List<Map<String, Object>> getScienceAppPortEditors(
      @PathVariable("scienceAppId") long scienceAppId,
      @PathVariable("portTypeId") long portTypeId,
      HttpServletRequest request)
          throws SystemException, PortalException{
    try{
      return PortTypeEditorLinkLocalServiceUtil.findByPortTypeId(portTypeId, PortalUtil.getLocale(request));
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = {
      "/{scienceAppId}/outputports/{portTypeId}"})
  public @ResponseBody List<Map<String, Object>> getScienceAppAnalyzers(
      @PathVariable("scienceAppId") long scienceAppId,
      @PathVariable("portTypeId") long portTypeId,
      HttpServletRequest request)
          throws SystemException, PortalException{
    try{
      return PortTypeAnalyzerLinkLocalServiceUtil.findByPortTypeId(portTypeId, PortalUtil.getLocale(request));
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
}
