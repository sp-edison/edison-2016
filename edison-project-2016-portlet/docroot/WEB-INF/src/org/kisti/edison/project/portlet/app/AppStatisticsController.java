package org.kisti.edison.project.portlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.project.service.HistoryScienceAppLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.ExcelUtil;
import org.kisti.edison.util.HtmlFormUtils;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class AppStatisticsController {
	
	private static Log log = LogFactoryUtil.getLog(AppStatisticsController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		try {
			
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			/*select 만들기*/
			long globalGroupId = themeDisplay.getCompany().getGroup().getGroupId(); 
			
			AssetVocabulary assetVocabulary =  AssetVocabularyLocalServiceUtil.getGroupVocabulary(globalGroupId, EdisonAssetCategory.PROJECT_DOMAIN);
			long vocabularyId = assetVocabulary.getVocabularyId();
			int categoryCnt = AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(vocabularyId);
			
			OrderByComparator orderByComparator = OrderByComparatorFactoryUtil.create("AssetCategory", "categoryId",true);
			List<AssetCategory> assetCategoryList =AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, categoryCnt, orderByComparator);
			
			int optionIndex = 0;
			String []categorySelectOptionText = new String[assetCategoryList.size() + 1 ];
			String []categorySelectOptionValue = new String[assetCategoryList.size() + 1];

			categorySelectOptionText[optionIndex] = LanguageUtil.get(themeDisplay.getLocale(), "edison-project-all-category");
			categorySelectOptionValue[optionIndex] = "0";
			
			for(AssetCategory categoryMap : assetCategoryList){
				AssetCategoryProperty property = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryMap.getCategoryId(), "SITE");
				
				optionIndex++;
				categorySelectOptionText[optionIndex] = CustomUtil.strNull(LanguageUtil.get(themeDisplay.getLocale(), property.getValue()));
				categorySelectOptionValue[optionIndex] = CustomUtil.strNull(String.valueOf(property.getCategoryId()));
			}
			model.addAttribute("categorySelectOption", HtmlFormUtils.makeCombo(categorySelectOptionValue, categorySelectOptionText, ParamUtil.get(request, "categoryId", "")));
			/*여기까지*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "statistics/app";
	}
	
	@ResourceMapping(value="getAppDatail")
	public void getStatisticsExec(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, ParseException, JSONException, IOException{
		Map params = RequestUtil.getParameterMap(request);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			Long selectProjectCategory = Long.parseLong(CustomUtil.strNull(params.get("selectProjectCategory"), "0"));
			
			JSONObject obj = new JSONObject();
			
			//User 확장 필드 조회
			
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(themeDisplay.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.USER_UNIVERSITY);

			obj.put("dataList", HistoryScienceAppLocalServiceUtil.getAppDetailList(1301003, column.getColumnId(),selectProjectCategory,  themeDisplay.getLanguageId(), themeDisplay.getLocale()));
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResourceMapping(value="excelDown")
	public void excelDown(ResourceRequest request, ResourceResponse response){
		Map params = RequestUtil.getParameterMap(request);
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
		try {		
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	
			Long selectProjectCategory = Long.parseLong(CustomUtil.strNull(params.get("selectProjectCategory"), "0"));
			
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(themeDisplay.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.USER_UNIVERSITY);
			
			List appDetailList  = HistoryScienceAppLocalServiceUtil.getAppDetailList(1301003, column.getColumnId(), selectProjectCategory, themeDisplay.getLanguageId(), themeDisplay.getLocale());
			
			Locale locale = themeDisplay.getLocale();
			String[] logical_names = {
					LanguageUtil.get(locale, "edison-table-list-header-group"),
					LanguageUtil.get(locale, "edison-table-list-header-sw-name"),
					LanguageUtil.get(locale, "edison-create-account-field-title-university"),
					LanguageUtil.get(locale, "edison-virtuallab-owner"),
					LanguageUtil.get(locale, "edison-table-list-header-version"),
					LanguageUtil.get(locale, "edison-statistics-user-count"),
					LanguageUtil.get(locale, "edison-simulation-monitoring-table-header-averate-running-time"),
					LanguageUtil.get(locale, "edison-science-appstore-view-Execution-count"),
					LanguageUtil.get(locale, "edison-table-list-header-date"),
			};
			int[] widths = {
					25,			100,			25,					20,				20,
					25,			25,				25,					20
			};
			String[] physical_names = {
					"projectCategoryNm",	"appTitle",			"affiliation",		"firstName",		"appVersion",
					"userCount",			"averageRuntime",	"executeCount",		"createDate"
			};

			String downFileName = "AppDetailStatistics_"+CustomUtil.dateToStringFormat(new Date(), "yyyy.MM.dd");		
			ExcelUtil.excelDownload(httpResponse, logical_names, physical_names, widths, downFileName, appDetailList);
			
		} catch (PortalException e) {
			log.error("PortalException");
		} catch (SystemException e) {
			log.error("SystemException");
		} catch (ParseException e) {
			log.error("ParseException");
		} catch (IOException e) {
			log.error("IOException");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
