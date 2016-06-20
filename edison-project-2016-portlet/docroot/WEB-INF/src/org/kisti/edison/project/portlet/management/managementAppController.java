package org.kisti.edison.project.portlet.management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.model.ScienceAppCategoryLink;
import org.kisti.edison.science.service.ScienceAppCategoryLinkLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.HtmlFormUtils;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class managementAppController {
	
	private static Log log = LogFactoryUtil.getLog(managementAppController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long simulationPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonbestsimulation_WAR_edisonsimulationportlet");
			long appstorePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonscienceAppstore_WAR_edisonappstore2016portlet");
			User user = PortalUtil.getUser(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			
			model.addAttribute("groupId", groupId);
			
			long globalGroupId = themeDisplay.getCompany().getGroup().getGroupId(); 
			
			AssetVocabulary assetVocabulary =  AssetVocabularyLocalServiceUtil.getGroupVocabulary(globalGroupId, EdisonAssetCategory.PROJECT_DOMAIN);
			long vocabularyId = assetVocabulary.getVocabularyId();
			int categoryCnt = AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(vocabularyId);
			
			OrderByComparator orderByComparator = OrderByComparatorFactoryUtil.create("AssetCategory", "categoryId",true);
			List<AssetCategory> assetCategoryList =AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, categoryCnt, orderByComparator);
			
			int optionIndex = 0;
			String []categorySelectOptionText = new String[assetCategoryList.size()];
			String []categorySelectOptionValue = new String[assetCategoryList.size()];
			
			for(AssetCategory categoryMap : assetCategoryList){
				AssetCategoryProperty property = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryMap.getCategoryId(), "SITE");
				
				categorySelectOptionText[optionIndex] = CustomUtil.strNull(LanguageUtil.get(themeDisplay.getLocale(), property.getValue()));
				categorySelectOptionValue[optionIndex] = CustomUtil.strNull(String.valueOf(property.getCategoryId()));
				
				optionIndex++;
			}
			
			
			model.addAttribute("categorySelectOption",HtmlFormUtils.makeCombo(categorySelectOptionValue, categorySelectOptionText, ""));
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "management/app";
	}
	
	
	@ResourceMapping(value ="myAppForProjectList" )
	public void myAppList(ResourceRequest request, ResourceResponse response) throws IOException{
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Map params = RequestUtil.getParameterMap(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long companyId = themeDisplay.getCompanyId();
			long companyGroupId = themeDisplay.getCompany().getGroupId();
			long userId = PortalUtil.getUserId(request);
			Locale locale = themeDisplay.getLocale();
			
			User user = PortalUtil.getUser(request);
			
			Map newParam = new HashMap();
			if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR)
					|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)
					|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_OWNER)) {
			}else{
				newParam.put("userId", userId);
			}
			
			
			if(!CustomUtil.strNull(params.get("projectCategoryId"),"0").equals("0")){
				newParam.put("projectCategoryId", CustomUtil.strNull(params.get("projectCategoryId"),"0"));	
			}
			
			String searchText = CustomUtil.strNull(params.get("searchText"));
			int currentPage = ParamUtil.get(request, "currentPage", 1);
			int listSize = ParamUtil.get(request, "searchLine", 5);
			int blockSize = 10;
			int start = ((currentPage - 1) * listSize);

			newParam.put("appStatus", 1901004);
			newParam.put("languageId", themeDisplay.getLanguageId());
			newParam.put("searchText", searchText);
			newParam.put("begin", start);
			newParam.put("end", listSize);
			
			List<Map<String, Object>> myAppList = ScienceAppLocalServiceUtil.getMyAppListForProject(newParam, locale);
			int totalCount = ScienceAppLocalServiceUtil.getMyAppListForProjectCount(newParam, locale);
			
			/*select 만들기*/
			long globalGroupId = themeDisplay.getCompany().getGroup().getGroupId(); 
			
			AssetVocabulary assetVocabulary =  AssetVocabularyLocalServiceUtil.getGroupVocabulary(globalGroupId, EdisonAssetCategory.PROJECT_DOMAIN);
			long vocabularyId = assetVocabulary.getVocabularyId();
			int categoryCnt = AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(vocabularyId);
			
			OrderByComparator orderByComparator = OrderByComparatorFactoryUtil.create("AssetCategory", "categoryId",true);
			List<AssetCategory> assetCategoryList =AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, categoryCnt, orderByComparator);
			
			int optionIndex = 0;
			String []categorySelectOptionText = new String[assetCategoryList.size()+1];
			String []categorySelectOptionValue = new String[assetCategoryList.size()+1];
			
			categorySelectOptionText[optionIndex] = LanguageUtil.get(locale, "edison-project-management-no-category");
			categorySelectOptionValue[optionIndex] = "0";
			
			for(AssetCategory categoryMap : assetCategoryList){
				AssetCategoryProperty property = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryMap.getCategoryId(), "SITE");
				
				optionIndex++;
				categorySelectOptionText[optionIndex] = CustomUtil.strNull(LanguageUtil.get(themeDisplay.getLocale(), property.getValue()));
				categorySelectOptionValue[optionIndex] = CustomUtil.strNull(String.valueOf(property.getCategoryId()));
			}
			/*여기까지*/
			
			
			for(Map<String, Object> myApp : myAppList){
				long scienceAppId = Long.parseLong(CustomUtil.strNull(myApp.get("scienceAppId")));
				long myAppScopeGroupId = getMyAppGroupId(companyId,companyGroupId , scienceAppId, locale);
				long appManagerPlid = PortalUtil.getPlidFromPortletId(myAppScopeGroupId, false, "scienceappmanager_WAR_edisonappstore2016portlet");
				
				myApp.put("appManagerPlid", appManagerPlid);
				myApp.put("myAppScopeGroupId", myAppScopeGroupId);
				
				if(categorySelectOptionValue != null && categorySelectOptionText != null){
					myApp.put("categorySelectOption", HtmlFormUtils.makeCombo(categorySelectOptionValue, categorySelectOptionText, CustomUtil.strNull(myApp.get("projectCategoryId"),"0")));
				}
			}
			
			String portletNameSpace = themeDisplay.getPortletDisplay().getNamespace();
			String paging = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", totalCount ,currentPage, listSize, blockSize);
			
			
			JSONObject obj = new JSONObject();
			obj.put("myAppList", myAppList);
			obj.put("seq", totalCount - ((currentPage - 1)*listSize)); 
			obj.put("paging", paging);
			
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public long getMyAppGroupId(long companyId, long companyGroupId, long scienceAppId, Locale locale) throws PortalException, SystemException{
		long groupId = 0;
		
		List<Group> parentGroupList = GroupLocalServiceUtil.getGroups(companyId, 0, true);
		Group parentGroup = null;
		for(Group group:parentGroupList){
			if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){//포탈 groupId 구하기
				parentGroup = group;
				break;
			}
		}
		
		List<Group> groupList = GroupLocalServiceUtil.getGroups(companyId, parentGroup.getGroupId(), true);//하위 그룹 리스트
		
		List<ScienceAppCategoryLink> ScienceAppCategoryLinkList = ScienceAppCategoryLinkLocalServiceUtil.getScienceAppCategorysByscienceAppId(scienceAppId);//현재 앱ID의 카테고리링크 리스트
		
		//카테고리
		AssetVocabulary aVocabulary =  AssetVocabularyLocalServiceUtil.getGroupVocabulary(companyGroupId,EdisonAssetCategory.GLOBAL_DOMAIN);
		boolean findGroup = false;
		for(Group group : groupList){
			AssetEntry aEntry = AssetEntryLocalServiceUtil.fetchEntry(Group.class.getName(), group.getGroupId());
			List<AssetCategory> aCategoryList = AssetCategoryLocalServiceUtil.getAssetEntryAssetCategories(aEntry.getEntryId());//현재 groupId의 카테고리리스트
			for(AssetCategory aCategory : aCategoryList){
				if(aCategory.getVocabularyId()==aVocabulary.getVocabularyId() && aCategory.getParentCategoryId()!=0){
					for(ScienceAppCategoryLink ScienceAppCategoryLink : ScienceAppCategoryLinkList){
						if(ScienceAppCategoryLink.getCategoryId() == aCategory.getCategoryId()){
							groupId = group.getGroupId();
							findGroup = true;
							break;
						}
					}
				}
				if(findGroup){
					break;
				}
			}
			
			if(findGroup){
				break;
			}
		}
		return groupId;
	}
	
	@ResourceMapping(value ="updateMyAppProjectCategory" )
	public void getMyAppListQna(ResourceRequest request, ResourceResponse response) throws IOException{
		JSONObject json = new JSONObject(); 
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			Map params = RequestUtil.getParameterMap(request);

			Long scienceAppId = Long.parseLong(CustomUtil.strNull(params.get("scienceAppId"),"0"));
			Long selectedCategoryId = Long.parseLong(CustomUtil.strNull(params.get("selectedCategoryId"),"0"));
			
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("groupId"),"0"));
			User user = PortalUtil.getUser(request);
			
			boolean isRoleTure = false;
			if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR)
					|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)
					|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_OWNER)
					|| EdisonUserUtil.isProjectThan(user)) {
				isRoleTure = true;
			}
			
			if(isRoleTure){
				ScienceApp app =  ScienceAppLocalServiceUtil.getScienceApp(scienceAppId);
				
				if(app != null){
					app.setProjectCategoryId(selectedCategoryId);
					ScienceAppLocalServiceUtil.updateScienceApp(app);
					json.put("msg", LanguageUtil.get(themeDisplay.getLocale(), "edison-data-update-success"));
				}else{
					json.put("msg", LanguageUtil.get(themeDisplay.getLocale(), "edison-data-update-error"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("msg", LanguageUtil.get(themeDisplay.getLocale(), "edison-data-update-error"));
		}
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json.toString());
	}
}
