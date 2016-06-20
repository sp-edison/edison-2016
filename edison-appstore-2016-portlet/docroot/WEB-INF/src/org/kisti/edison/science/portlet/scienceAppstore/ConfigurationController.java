package org.kisti.edison.science.portlet.scienceAppstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
import javax.servlet.ServletContext;

import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.RequestUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletConfigFactoryUtil;
import com.liferay.portlet.asset.NoSuchCategoryPropertyException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

public class ConfigurationController implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)	throws Exception {
		Map param = RequestUtil.getParameterMap(actionRequest);
		String myaction = CustomUtil.strNull(param.get("myaction"));
		if(myaction.equals("tab")){
			preferenceOption(actionRequest,actionResponse);
		}else if(myaction.equals("category")){
			String[] numberArray = actionRequest.getParameterValues("numberArray");
			
			/*SolverTypeLocalServiceUtil.removeAll();*/
			AssetCategoryProperty assetCategoryProperty;
			for (String number : numberArray) {
				int categoryPropertyId = ParamUtil.get(actionRequest, "categoryPropertyId_"+ number , 0);
				if(categoryPropertyId > 0){
					assetCategoryProperty = AssetCategoryPropertyLocalServiceUtil.getAssetCategoryProperty(categoryPropertyId);
					
					String orgValue = assetCategoryProperty.getValue();
					String changeValue = ParamUtil.get(actionRequest, "categoryImage_"+ number , "");
					
					if(!orgValue.equals(changeValue)){
						assetCategoryProperty.setValue(changeValue);
						AssetCategoryPropertyLocalServiceUtil.updateAssetCategoryProperty(assetCategoryProperty);
					}
				}else{
					long newCategoryPropertyId = CounterLocalServiceUtil.increment(AssetCategoryProperty.class.getName());
					int categoryId = ParamUtil.get(actionRequest, "categoryId_"+ number , 0);
					int companyId = ParamUtil.get(actionRequest, "companyId_"+ number , 0);
					int userId = ParamUtil.get(actionRequest, "userId_"+ number , 0);
					String userName = ParamUtil.get(actionRequest, "userName_"+ number , "");
					String value = ParamUtil.get(actionRequest, "categoryImage_"+ number , "");
					Date curruntDate = new Date();
					
					if( value != null && !value.equals("")){
						assetCategoryProperty = AssetCategoryPropertyLocalServiceUtil.createAssetCategoryProperty(newCategoryPropertyId); 
						assetCategoryProperty.setCategoryId(categoryId);
						assetCategoryProperty.setCompanyId(companyId);
						assetCategoryProperty.setUserId(userId);
						assetCategoryProperty.setUserName(userName);
						assetCategoryProperty.setCreateDate(curruntDate);
						assetCategoryProperty.setModifiedDate(curruntDate);
						assetCategoryProperty.setUserName(userName);
						assetCategoryProperty.setKey("IMAGE");
						assetCategoryProperty.setValue(value);
						
						AssetCategoryPropertyLocalServiceUtil.updateAssetCategoryProperty(assetCategoryProperty);
					}
				}
			}
		}
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getCompany().getGroupId();
		AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, EdisonAssetCategory.GLOBAL_DOMAIN);
		long parentId = 0;
		
		List<AssetCategory> parentCategoryList = AssetCategoryLocalServiceUtil.getVocabularyCategories(parentId, assetVocabulary.getVocabularyId(), -1, -1, OrderByComparatorFactoryUtil.create("AssetCategory", "categoryId", true));
		List<Map> parentCategoryMapList =  new ArrayList<Map>();
		List<List<Map>> categoryList =  new ArrayList<List<Map>>();
		
		for(AssetCategory parentCategory : parentCategoryList){
			List<AssetCategory> childCategoryList = AssetCategoryLocalServiceUtil.getChildCategories(parentCategory.getCategoryId());
			List<Map> categoryMapList =  new ArrayList<Map>();
			
			Map parentCategoryMap = new HashMap();
			parentCategoryMap.put("title", parentCategory.getTitle(themeDisplay.getLanguageId()));
			
			parentCategoryMapList.add(parentCategoryMap);
			
			for(AssetCategory childCategory : childCategoryList){
				Map categoryMap = new HashMap();
				categoryMap.put("categoryId", childCategory.getCategoryId());
				categoryMap.put("title", childCategory.getTitle(themeDisplay.getLanguageId()));
				categoryMap.put("companyId", childCategory.getCompanyId());
				categoryMap.put("parentCategoryId", childCategory.getParentCategoryId());
				categoryMap.put("userId", childCategory.getUserId());
				categoryMap.put("userName", childCategory.getUserName());
				
				try{
					AssetCategoryProperty categoryProperty = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(childCategory.getCategoryId(), "IMAGE");
					categoryMap.put("image", categoryProperty);
				}catch(NoSuchCategoryPropertyException e){
					
				}
				
				categoryMapList.add(categoryMap);
			}
			categoryList.add(categoryMapList);
		}
		
		renderRequest.setAttribute("allSolverTypeList", categoryList);
		renderRequest.setAttribute("parentCategoryList", parentCategoryMapList);
		
		List<com.liferay.portal.model.Group> parentGroupList = GroupLocalServiceUtil.getGroups(companyId, 0, true);
		Group parentGroup = null;
		for(Group group:parentGroupList){
			if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){
				parentGroup = group;
				break;
			}
		}
		List<Group> groupList = CustomUtil.getGroupIdASC(GroupLocalServiceUtil.getGroups(companyId, parentGroup.getGroupId(), true));
		renderRequest.setAttribute("groupList", groupList);
		
		String tabUseStr = renderRequest.getPreferences().getValue("tabUseList", "");
		List<Group> tabGroup = new ArrayList<Group>();
		if(!tabUseStr.equals("")){
			String[] tabUseArray = tabUseStr.split(",");
			
			for(int i=0; i<tabUseArray.length; i++){
				Long selectGroupId = Long.parseLong(CustomUtil.strNull(tabUseArray[i]));
				
				Group group = GroupLocalServiceUtil.getGroup(selectGroupId);
				tabGroup.add(group);
			}
		}
		renderRequest.setAttribute("tabGroup", tabGroup);
		
		PortletConfig selPortletConfig = getSelPortletConfig(renderRequest);

		String configTemplate = selPortletConfig.getInitParameter(
			"config-template");
		
		if (Validator.isNotNull(configTemplate)) {
			return configTemplate;
		}

		String configJSP = selPortletConfig.getInitParameter("config-jsp");
		
		if (Validator.isNotNull(configJSP)) {
			return configJSP;
		}
		return "scienceAppstore/configuration.jsp";
	}
	
	public void preferenceOption(ActionRequest actionRequest, ActionResponse actionResponse) throws ReadOnlyException, ValidatorException, IOException {
		PortletPreferences prefs = actionRequest.getPreferences();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);				
				
		Set es = prefs.getMap().entrySet();
		Iterator entries = null;
		if(es != null){
			entries = es.iterator();
		}
		while (entries.hasNext()) {
			Map.Entry<String, String[]> thisEntry = (Map.Entry) entries.next();
			String key = CustomUtil.strNull(thisEntry.getKey());
			prefs.reset(key);
		}
		
		
		String[] keyTextBox		= actionRequest.getParameterValues("keyTextBox");
		String[] valueTextBox	= actionRequest.getParameterValues("valueTextBox");
		String[] tabUseValue	= actionRequest.getParameterValues("tabUseValue");
		String[] prefPortletId = null;
		
		if(keyTextBox != null){
			for(int i=0;i<keyTextBox.length;i++){
				if(CustomUtil.strNull(keyTextBox[i]).equals("")) continue;
												
				prefs.setValue(keyTextBox[i], String.valueOf(valueTextBox[i]));
			}
		}		
		if(tabUseValue != null){
			prefs.setValues("tabUseList", tabUseValue);
		}		
		prefs.store();
	}
	
	protected PortletConfig getSelPortletConfig(PortletRequest portletRequest)
			throws SystemException {

			ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			String portletResource = ParamUtil.getString(
				portletRequest, "portletResource");

			Portlet selPortlet = PortletLocalServiceUtil.getPortletById(
				themeDisplay.getCompanyId(), portletResource);

			ServletContext servletContext =
				(ServletContext)portletRequest.getAttribute(WebKeys.CTX);

			PortletConfig selPortletConfig = PortletConfigFactoryUtil.create(
				selPortlet, servletContext);

			return selPortletConfig;
		}
}
