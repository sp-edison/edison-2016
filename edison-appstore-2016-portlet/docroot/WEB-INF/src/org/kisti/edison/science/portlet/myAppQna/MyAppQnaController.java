package org.kisti.edison.science.portlet.myAppQna;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletModeException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.science.model.ScienceAppCategoryLink;
import org.kisti.edison.science.service.ScienceAppCategoryLinkLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.persistence.GroupUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")   
public class MyAppQnaController {
	private static Log log = LogFactoryUtil.getLog(MyAppQnaController.class);

	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response,ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long simulationPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonbestsimulation_WAR_edisonsimulationportlet");
			long appstorePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonscienceAppstore_WAR_edisonappstore2016portlet");
			User user = PortalUtil.getUser(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			
			/* 개발자 인지 체크 */
			if(EdisonUserUtil.isGroup(user, EdisonRoleConstants.DEVELOPER_GROUP)
				|| EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR)
				|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)
				|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_OWNER)) {
				model.addAttribute("display", "VIEW");
			} else {
				model.addAttribute("display", "NONE");
			}
			
			model.addAttribute("simulationPlid", simulationPlid);
			model.addAttribute("appstorePlid", appstorePlid);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "myAppQna/myAppQnaList";
	}
	
	@ResourceMapping(value ="myAppList" )
	public void myAppList(ResourceRequest request, ResourceResponse response) throws IOException{
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Map params = RequestUtil.getParameterMap(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long companyId = themeDisplay.getCompanyId();
			long companyGroupId = themeDisplay.getCompany().getGroupId();
			long userId = PortalUtil.getUserId(request);
			Locale locale = themeDisplay.getLocale();
			
			long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();
			String isPortal = "true";
			// 포털 체크 parentGroupId가 0이면 포털
			if(parentGroupId != 0) {
				params.put("groupId", groupId);
				params.put("companyGroupId", companyGroupId);
				isPortal = "false";
			}
			params.put("isPortal", isPortal);
			params.put("userId", userId);
			
			List<Map<String, Object>> myAppList = ScienceAppLocalServiceUtil.getMyAppListWithQna(params, locale);
			for(Map<String, Object> myApp : myAppList){
				long scienceAppId = Long.parseLong(CustomUtil.strNull(myApp.get("scienceAppId")));
				long myAppScopeGroupId = getMyAppGroupId(companyId,companyGroupId , scienceAppId, locale);
				long appManagerPlid = PortalUtil.getPlidFromPortletId(myAppScopeGroupId, false, "scienceappmanager_WAR_edisonappstore2016portlet");
				myApp.put("appManagerPlid", appManagerPlid);
				myApp.put("myAppScopeGroupId", myAppScopeGroupId);
			}
			
			JSONObject obj = new JSONObject();
			obj.put("myAppList", myAppList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
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
	
	@ResourceMapping(value ="myAppListQna" )
	public void getMyAppListQna(ResourceRequest request, ResourceResponse response) throws IOException{
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Map params = RequestUtil.getParameterMap(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long userId = PortalUtil.getUserId(request);
			Locale locale = themeDisplay.getLocale();
			
			params.put("userId", userId);
			params.put("groupId", groupId);
			
			List myAppManualList =  new ArrayList();
			Map manualMap = null;
			List<Map<String, Object>> myAppQnaList = ScienceAppLocalServiceUtil.getListMyAppQna(params, locale);
			
			JSONObject obj = new JSONObject();
			obj.put("myAppQnaList", myAppQnaList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@ResourceMapping(value="edisonFileDownload")
	public void edisonFileDownload(ResourceRequest request, ResourceResponse response) throws SystemException, JSONException, IOException, PortalException, ParseException, PortletModeException{

		Map paramsMap = RequestUtil.getParameterMap(request);
		long fileEntryId = Long.parseLong(CustomUtil.strNull(paramsMap.get("fileEntryId")));
		
		EdisonFileUtil.edisonFileDownload(response, fileEntryId);
	}
}
