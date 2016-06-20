package org.kisti.edison.project.portlet.management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.content.model.GeneralContent;
import org.kisti.edison.content.service.GeneralContentLocalServiceUtil;
import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.HtmlFormUtils;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class managementContentController {
	
	private static Log log = LogFactoryUtil.getLog(managementContentController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
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
		return "management/content";
	}
	
	/**
	 * 일반컨텐츠 조회
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResourceMapping(value ="myContentForProjectList")
	public void myContentForProjectList(ResourceRequest request, ResourceResponse response){
		try{
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			
			Map param = RequestUtil.getParameterMap(request);

			long groupId = PortalUtil.getScopeGroupId(request);
			User user =  themeDisplay.getUser();
			long userId = user.getUserId();
			
			/* 프로젝트 ROLE THAN 체크 */
			if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR)
				|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)
				|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_OWNER)) {
				userId = 0;
			}
			
			String searchText = CustomUtil.strNull(param.get("searchText"));
			String projectCategoryId = CustomUtil.strNull(param.get("projectCategoryId"),"0");
			
			int currentPage = ParamUtil.get(request, "currentPage", 1);
			int listSize = ParamUtil.get(request, "searchLine", 5);
			int blockSize = 10;
			int start = ((currentPage - 1) * listSize);
			
			List<Map<String, Object>> dataList = GeneralContentLocalServiceUtil.getGeneralContentForProjectList(userId, searchText, projectCategoryId, themeDisplay.getLanguageId(), start, listSize, locale);
			
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
			
			for(Map<String, Object> myContent : dataList){
				long contentManagerPlid = PortalUtil.getPlidFromPortletId(groupId, false, "edisoncontent_WAR_edisoncontent2016portlet");
				myContent.put("contentManagerPlid", contentManagerPlid);
				
				if(categorySelectOptionValue != null && categorySelectOptionText != null){
					myContent.put("categorySelectOption", HtmlFormUtils.makeCombo(categorySelectOptionValue, categorySelectOptionText, CustomUtil.strNull(myContent.get("projectId"),"0")));
				}
			}
			

			int totalCount = GeneralContentLocalServiceUtil.getGeneralContentCountByGroupIdForProjectList(userId, searchText, projectCategoryId, themeDisplay.getLanguageId());
			String portletNameSpace = themeDisplay.getPortletDisplay().getNamespace();
			String paging = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", totalCount ,currentPage, listSize, blockSize);
			
			JSONObject json = new JSONObject(); 
			json.put("dataList", dataList);
			json.put("seq", totalCount - ((currentPage - 1)*listSize)); 
			json.put("paging", paging);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	
	@ResourceMapping(value ="updateMyContentProjectCategory" )
	public void getMyAppListQna(ResourceRequest request, ResourceResponse response) throws IOException{

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject json = new JSONObject(); 
		try {
			Map params = RequestUtil.getParameterMap(request);


			Long contentSeq = Long.parseLong(CustomUtil.strNull(params.get("contentSeq"),"0"));
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
				GeneralContent generalContent = GeneralContentLocalServiceUtil.getGeneralContentForProjectObj(contentSeq);
				
				if(generalContent != null){
					if(selectedCategoryId != 0){
						generalContent.setProjectYn("Y");
					}
					generalContent.setProjectId(selectedCategoryId);
					
					GeneralContentLocalServiceUtil.updateGeneralContent(generalContent);
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
