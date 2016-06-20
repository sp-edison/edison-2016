
package org.kisti.edison.science.portlet.appmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.science.NoSuchScienceAppException;
import org.kisti.edison.science.Exception.ScienceAppException;
import org.kisti.edison.science.model.CommonLib;
import org.kisti.edison.science.model.PortType;
import org.kisti.edison.science.model.RequiredLibConfirm;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.model.ScienceAppInputPorts;
import org.kisti.edison.science.model.ScienceAppManager;
import org.kisti.edison.science.model.ScienceAppOutputPorts;
import org.kisti.edison.science.service.CommonLibLocalServiceUtil;
import org.kisti.edison.science.service.DeveloperInfoLocalServiceUtil;
import org.kisti.edison.science.service.PortTypeAnalyzerLinkLocalServiceUtil;
import org.kisti.edison.science.service.PortTypeEditorLinkLocalServiceUtil;
import org.kisti.edison.science.service.PortTypeInputdeckFormLocalServiceUtil;
import org.kisti.edison.science.service.PortTypeLocalServiceUtil;
import org.kisti.edison.science.service.RequiredLibConfirmLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppInputPortsLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppManagerLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppOutputPortsLocalServiceUtil;
import org.kisti.edison.science.service.constants.RequiredLibConstants;
import org.kisti.edison.science.service.constants.ScienceAppConstants;
import org.kisti.edison.science.service.persistence.RequiredLibConfirmPK;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonPropsUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.HtmlFormUtils;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.util.TokenProviderUtil;
import org.kisti.edison.util.VCRegisterUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;

@Controller
@RequestMapping("VIEW")
public class AppManagerController{
	
	private static Log log = LogFactory.getLog(AppManagerController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) throws SystemException, IOException, PortalException, SQLException{
		Map params = RequestUtil.getParameterMap(request);
		
		User user = PortalUtil.getUser(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = PortalUtil.getScopeGroupId(request);
		/* Tabs - Setting */
		String tabNames = LanguageUtil.get(themeDisplay.getLocale(), "edison-science-appstore-toolkit-list-owned-app")+",";
		tabNames += LanguageUtil.get(themeDisplay.getLocale(), "edison-science-appstore-toolkit-list-management-app");
		model.addAttribute("tabNames", tabNames);
		String listTabValue = CustomUtil.strNull(params.get("tabValue"), "owner_sw");
		model.addAttribute("listTabValue", listTabValue);
		
		
		/* DATA - Search */
		int curPage = Integer.parseInt(CustomUtil.strNull(params.get("p_curPage"), "1"));
		int linePerPage = Integer.parseInt(CustomUtil.strNull(params.get("linePerPage"), "10"));
		int pagePerBlock = 5;
		
		int totalCnt = 0;
		
		int begin = (curPage - 1) * linePerPage;
		int end = linePerPage;
		
		List<Map<String,Object>> swList = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("status", CustomUtil.strNull(params.get("searchStatus")));
		searchParam.put("searchOption", CustomUtil.strNull(params.get("searchOption")));
		searchParam.put("searchValue", CustomUtil.strNull(params.get("searchValue")));
		
		if(listTabValue.equals("owner_sw")){
			if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) 
					|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)){
				
			}else{
				searchParam.put("userId", themeDisplay.getUserId());
			}
			
			totalCnt = ScienceAppLocalServiceUtil.countScienceApp(themeDisplay.getCompanyGroupId(), groupId , 0, themeDisplay.getLocale(), searchParam);
			swList = ScienceAppLocalServiceUtil.retrieveListScienceApp(themeDisplay.getCompanyGroupId(), groupId, 0, themeDisplay.getLocale(), searchParam, begin, end, false);
			
			if(curPage==1){
				List<Map<String, Object>> swEditorList = ScienceAppLocalServiceUtil.retrieveListScienceEditorApp(themeDisplay.getCompanyId(), themeDisplay.getLocale(), searchParam);
				model.addAttribute("swEditorList", swEditorList);
			}
			
		}else{
			//ManagerApp 조회
			searchParam.put("myManagerAppUserId", themeDisplay.getUserId());
			searchParam.put("myManagerAppSearch", "true");
			totalCnt = ScienceAppLocalServiceUtil.countScienceApp(themeDisplay.getCompanyGroupId(), groupId , 0, themeDisplay.getLocale(), searchParam);
			swList = ScienceAppLocalServiceUtil.retrieveListScienceApp(themeDisplay.getCompanyGroupId(), groupId, 0, themeDisplay.getLocale(), searchParam, begin, end, false);
			
			if(curPage==1){
				List<Map<String, Object>> swEditorList = ScienceAppLocalServiceUtil.retrieveListScienceEditorApp(themeDisplay.getCompanyId(), themeDisplay.getLocale(), searchParam);
				model.addAttribute("swEditorList", swEditorList);
			}
		}
		
		
		
		String pagingStr = PagingUtil.getPaging(request.getContextPath(), response.getNamespace()+"dataSearchList", totalCnt, curPage, linePerPage, pagePerBlock);
		
		
		model.addAttribute("searchStatus", CustomUtil.strNull(params.get("searchStatus")));
		model.addAttribute("searchValue", CustomUtil.strNull(params.get("searchValue")));
		model.addAttribute("swList", swList);
		model.addAttribute("pagingStr", pagingStr);
		model.addAttribute("pageNum", totalCnt- (curPage-1) * linePerPage);
		
		return "appmanager/list";
	}
	
	@RenderMapping(params="myRender=solverRender")
	public String solverRender(RenderRequest request, RenderResponse response, ModelMap model){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Map params = RequestUtil.getParameterMap(request);
			
			long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"), 0);
			ScienceApp scienceApp = null;
			boolean swTest = false;
			boolean ownerThan = false;
			boolean isAdmin = false;
			
			
			if(scienceAppId!=0){
				
				scienceApp = ScienceAppLocalServiceUtil.getScienceApp(scienceAppId);
				swTest = scienceApp.getSwTest();
				
				//관리자 권한 확인
				if (EdisonUserUtil.isRegularRole(themeDisplay.getUser(), RoleConstants.ADMINISTRATOR)
						|| EdisonUserUtil.isSiteRole(themeDisplay.getUser(), themeDisplay.getScopeGroupId(), RoleConstants.SITE_ADMINISTRATOR)
						|| EdisonUserUtil.isSiteRole(themeDisplay.getUser(), themeDisplay.getScopeGroupId(), RoleConstants.SITE_OWNER)
						|| scienceApp.getAuthorId() == themeDisplay.getUser().getUserId()) {
					ownerThan = true;
				}else{
					//APP 권한 확인
					checkAppPermission(scienceApp,themeDisplay.getUserId());
				}
				
				if (EdisonUserUtil.isRegularRole(themeDisplay.getUser(), RoleConstants.ADMINISTRATOR)
						|| EdisonUserUtil.isSiteRole(themeDisplay.getUser(), themeDisplay.getScopeGroupId(), RoleConstants.SITE_ADMINISTRATOR)
						|| EdisonUserUtil.isSiteRole(themeDisplay.getUser(), themeDisplay.getScopeGroupId(), RoleConstants.SITE_OWNER)) {
					isAdmin = true;
				}
				
			}else{
				swTest = GetterUtil.getBoolean(params.get("swTest"), false);
			}
			
			String clickTab = CustomUtil.strNull(params.get("clickTab"),"m01");
			Locale locale = themeDisplay.getLocale();
			Map<String,Object> tabAndButtonMap = tabCreateAndStatusButtonView(scienceAppId, swTest, clickTab, locale);
			
			String tabStr = GetterUtil.getString(tabAndButtonMap.get("tabString"),"");
			boolean appStatusButtonView = GetterUtil.getBoolean(tabAndButtonMap.get("appStatusButtonView"),false);
			
			
			String mode = Constants.ADD;
			Map<String,Object> data = null;
			
			if(clickTab.equals("m01")){
				if(scienceAppId!=0){
					data = ScienceAppLocalServiceUtil.getScienceAppReturnObject(scienceAppId,locale);
					mode = Constants.UPDATE;
				}else{
					model.addAttribute("userScreenName", themeDisplay.getUser().getScreenName());
				}
			
			//Category 정보 조회
			long companyGroupId = themeDisplay.getCompany().getGroupId();	
			AssetVocabulary aVocabulary =  AssetVocabularyLocalServiceUtil.getGroupVocabulary(companyGroupId,EdisonAssetCategory.GLOBAL_DOMAIN);
			
			int rootCategoryCnt = AssetCategoryLocalServiceUtil.getVocabularyRootCategoriesCount(aVocabulary.getVocabularyId());
			Map<Long,List<Map<String,Object>>> childrenCategoryGroupMap =  new HashMap<Long,List<Map<String,Object>>>();
			List<Map<String,Object>> parentCategoryList = new ArrayList<Map<String,Object>>();
			
			if(rootCategoryCnt!=0){
				List<AssetCategory> rootCategoryList = AssetCategoryLocalServiceUtil.getVocabularyRootCategories(aVocabulary.getVocabularyId(), -1, -1,null);
				for(AssetCategory rootCatogory : rootCategoryList){
					Map<String,Object> parentCategoryMap = new HashMap<String,Object>();
					parentCategoryMap.put("value", rootCatogory.getCategoryId());
					parentCategoryMap.put("name", rootCatogory.getTitle(themeDisplay.getLocale()));
					parentCategoryList.add(parentCategoryMap);
					
					List<AssetCategory> childCategoryList =  AssetCategoryLocalServiceUtil.getChildCategories(rootCatogory.getCategoryId());
					List<Map<String,Object>> childrenCategoryList = new ArrayList<Map<String,Object>>();
					for(AssetCategory childCatogory : childCategoryList){
						Map<String,Object> childrenCategoryMap = new HashMap<String,Object>();
						childrenCategoryMap.put("value", childCatogory.getCategoryId());
						childrenCategoryMap.put("name", childCatogory.getTitle(themeDisplay.getLocale()));
						childrenCategoryList.add(childrenCategoryMap);
					}
					childrenCategoryGroupMap.put(rootCatogory.getCategoryId(),childrenCategoryList);
				}
			}
			
			model.addAttribute("childrenCategoryGroupMap",childrenCategoryGroupMap);
			model.addAttribute("parentCategoryList",parentCategoryList);
			
			//CKEditor
			long portalGroupId = themeDisplay.getScopeGroup().getParentGroupId();
			EdisonFileUtil.checkUserFolder(request, themeDisplay.getUserId(),portalGroupId, EdisonFileConstants.USER_IMAGE);
			String currunt_folder = "/" +portalGroupId+" - " +CompanyLocalServiceUtil.getCompany(PortalUtil.getCompanyId(request)).getName() + "/"+portalGroupId+"_EDISON_FILE"+"/"
									+EdisonFileConstants.USER_IMAGE+"/"+themeDisplay.getUserId()+ "/";
			model.addAttribute("currentFolder", currunt_folder);
			
			}else if(clickTab.equals("m02")){
				data = scienceApp.getModelAttributes();
				
				if(!scienceApp.getExeFileName().equals("")){
					
					if(!CustomUtil.strNull(scienceApp.getSrcFileName()).equals("")){
						long sourceFileId = GetterUtil.getLong(scienceApp.getSrcFileName());
						data.put("sourceFileId", sourceFileId);
						DLFileEntry sourceFileDl =  DLFileEntryLocalServiceUtil.getDLFileEntry(sourceFileId);
						data.put("sourceFileRepositoryId", sourceFileDl.getRepositoryId());
						data.put("sourceFileUuid", sourceFileDl.getUuid());
						data.put("sourceFileTitle", sourceFileDl.getTitle());
					}
					mode = Constants.UPDATE;
					
					boolean isOsWindow = false;
					if(System.getProperty("os.name").toUpperCase().contains("WINDOWS")){
						isOsWindow = true;
					}
					
					model.addAttribute("isOsWindow", isOsWindow);
				}
				
				//SELECT BOX 생성
				String openLevelOptions = HtmlFormUtils.makeCombo(ScienceAppConstants.getScienceAppOpenLevels(), scienceApp.getOpenLevel());
				
				String appTypeOptions = "";
				if(scienceApp.getSwTest()){
					appTypeOptions = HtmlFormUtils.makeCombo(ScienceAppConstants.getScienceAppSwTypes(), scienceApp.getAppType());
				}else{
					appTypeOptions = HtmlFormUtils.makeCombo(ScienceAppConstants.getScienceAppEditorTypes(), scienceApp.getAppType());
				}
				
				String editorTypeOptions = HtmlFormUtils.makeCombo(ScienceAppConstants.getEditorTypes(), scienceApp.getEditorType());
				String runTypeOptions = HtmlFormUtils.makeCombo(ScienceAppConstants.getScienceAppRunTypes(), scienceApp.getRunType());
				String parallelOptions = HtmlFormUtils.makeCombo(ScienceAppConstants.getScienceAppParallerModule(), scienceApp.getParallelModule());

				
				model.addAttribute("editorTypeOptions",editorTypeOptions);
				model.addAttribute("openLevelOptions",openLevelOptions);
				model.addAttribute("appTypeOptions",appTypeOptions);
				model.addAttribute("runTypeOptions",runTypeOptions);
				model.addAttribute("parallelOptions",parallelOptions);
				
				//실행 파일 업로드 확인
				boolean exeFileUpload = false;
				
				String appBasePath = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), EdisonPropsUtil.SCIENCEAPP_BASE_PATH)
									+scienceApp.getName()+File.separator
									+scienceApp.getVersion();
				
				String targetPath = appBasePath+File.separator+"bin";
				
				exeFileUpload = ScienceAppLocalServiceUtil.existScienceAppPath(targetPath);
				model.addAttribute("exeFileUpload",exeFileUpload);
				
				
			}else if(clickTab.equals("m03")){
				long inputCnt = ScienceAppInputPortsLocalServiceUtil.getScienceAppInputPortsesCount(scienceAppId);
				long outputCnt = ScienceAppOutputPortsLocalServiceUtil.getScienceAppOutputPortsesCount(scienceAppId);
				
				//port 조회
				String inputPorts = "";
				if(inputCnt!=0){
					inputPorts = ScienceAppInputPortsLocalServiceUtil.getInputPortsJsonString(scienceAppId);
				}
				
				String outputPorts = "";
				if(outputCnt!=0){
					outputPorts = ScienceAppOutputPortsLocalServiceUtil.getOutputPortsJsonString(scienceAppId);
				}		
				
				data = scienceApp.getModelAttributes();
				data.put("inputPorts", inputPorts);
				data.put("outputPorts", outputPorts);
				
				mode = Constants.UPDATE;
			}else if(clickTab.equals("m04")){
				data = scienceApp.getModelAttributes();
				mode = Constants.UPDATE;
			}
			
			if(scienceAppId!=0){
				model.addAttribute("scienceAppId", scienceAppId);
			}
			
			model.addAttribute("data", data);
			model.addAttribute("mode", mode);
			model.addAttribute("clickTab", clickTab);
			model.addAttribute("tabStr", tabStr);
			model.addAttribute("appStatusButtonView", appStatusButtonView);
			model.addAttribute("swTest", swTest);
			model.addAttribute("ownerThan", ownerThan);
			model.addAttribute("isAdmin", isAdmin);
			
			//리스트 검색 파라미터
			model.addAttribute("searchValue",CustomUtil.strNull(params.get("searchValue")));
			model.addAttribute("searchOption",CustomUtil.strNull(params.get("searchOption")));
			model.addAttribute("searchStatus",CustomUtil.strNull(params.get("searchStatus")));
			model.addAttribute("p_curPage",CustomUtil.strNull(params.get("p_curPage")));
			
			if(!SessionErrors.isEmpty(request)){
				PortalUtil.clearRequestParameters(request);
			}
			
		} catch (Exception e) {
			if(e instanceof ScienceAppException){
				SessionErrors.add(request, e.getClass(), e);
				return "appmanager/list";
			}else{
				log.error(e);
				e.printStackTrace();
				SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
			}
		}
		return "appmanager/view";
	}
	
	@ActionMapping(value="appAction")
	public void appAction(ActionRequest request, ActionResponse response, Model model){
		Map params = RequestUtil.getParameterMap(request);
		
		String actionType = CustomUtil.strNull(params.get("actionType"));
		String mode = CustomUtil.strNull(params.get("actionMode"));
		long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"),0l);
		
		try{
			if(mode.equals(Constants.DELETE)){
				ScienceAppLocalServiceUtil.deleteScienceAppRelation(scienceAppId);
			}else{
				if(actionType.equals("appInfomation")){
					if(mode.equals(Constants.ADD)){
						params.put("duplicationCheck", "check");
					}else if(mode.equals(Constants.UPDATE)){
						String version = CustomUtil.strNull(params.get("version"));
						String previousVersion = CustomUtil.strNull(params.get("previousVersion"));
						if(!version.equals(previousVersion)){
							params.put("duplicationCheck", "check");
						}
					}
					
					ServiceContext sc = ServiceContextFactory.getInstance(ScienceApp.class.getName(), request);
					scienceAppId = appInfomation(sc, params);
					response.setRenderParameter("scienceAppId", String.valueOf(scienceAppId));
					
				}else if(actionType.equals("exeInfomation")){
					ServiceContext sc = ServiceContextFactory.getInstance(ScienceApp.class.getName(), request);
					exeInfomation(sc, params, scienceAppId);
				}else if(actionType.equals("portInfomation")){
					
					String inputPorts = CustomUtil.strNull(params.get("inputPorts"));
					String outputPorts = CustomUtil.strNull(params.get("outputPorts"));
					
					if(!inputPorts.equals("")){
						long inputCnt = ScienceAppInputPortsLocalServiceUtil.getScienceAppInputPortsesCount(scienceAppId);
						
						if(inputCnt!=0){
							ScienceAppInputPorts ports=  ScienceAppInputPortsLocalServiceUtil.getScienceAppInputPorts(scienceAppId);
							ports.setInputPorts(inputPorts);
							ScienceAppInputPortsLocalServiceUtil.updateScienceAppInputPorts(ports);
						}else{
							ScienceAppInputPortsLocalServiceUtil.create(scienceAppId, inputPorts);
						}
					}
					
					if(!outputPorts.equals("")){
						long outputCnt = ScienceAppOutputPortsLocalServiceUtil.getScienceAppOutputPortsesCount(scienceAppId);
						
						if(outputCnt!=0){
							ScienceAppOutputPorts ports=  ScienceAppOutputPortsLocalServiceUtil.getScienceAppOutputPorts(scienceAppId);
							ports.setOutputPorts(outputPorts);
							ScienceAppOutputPortsLocalServiceUtil.updateScienceAppOutputPorts(ports);
						}else{
							ScienceAppOutputPortsLocalServiceUtil.create(scienceAppId, outputPorts);
						}
					}
				}else if(actionType.equals("swTest")){
					
				}
			}
			
			
			
			if(!mode.equals(Constants.DELETE)){
				if(mode.equals(Constants.ADD)){
					SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
				}else if(mode.equals(Constants.UPDATE)){
					SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
				}
				RequestUtil.copyRequestParameters(request, response, new String[] {"searchValue", "searchOption","searchStatus", "p_curPage", "clickTab", "scienceAppId", "swTest"});
			}else{
				response.setPortletMode(PortletMode.VIEW);
				SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			response.setRenderParameter("myRender", "solverRender");
			PortalUtil.copyRequestParameters(request, response);
			
			if (e instanceof ScienceAppException){
				SessionErrors.add(request, e.getClass(), e);
			}else{
				//Session Error Message
				if(mode.equals(Constants.ADD)){
					SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
				}else if(mode.equals(Constants.UPDATE)){
					SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
				}else if(mode.equals(Constants.DELETE)){
					SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
				}
			}
			
		}finally {
			if(!mode.equals(Constants.DELETE)){
				response.setRenderParameter("myRender", "solverRender");
			}
		}
	}
	
	protected long appInfomation(ServiceContext sc,Map params) throws SystemException, ScienceAppException, NoSuchScienceAppException{
		String mode = CustomUtil.strNull(params.get("actionMode"));
		String duplicationCheck = CustomUtil.strNull(params.get("duplicationCheck"));
		long returnLong = 0;
		
		if(!duplicationCheck.equals("")){
			String appName = CustomUtil.strNull(params.get("name"));
			String appVersion = CustomUtil.strNull(params.get("version"));
			
			boolean isDuplicated = ScienceAppLocalServiceUtil.existApp(appName, appVersion);
			
			if(isDuplicated){
				throw new ScienceAppException(ScienceAppException.EXISTS_NAME_VERSION_DATABASE);
			}
		}
		
		if(mode.equals(Constants.ADD)){
			ScienceApp scienceApp = ScienceAppLocalServiceUtil.createScienceApp(sc, params);
			returnLong = scienceApp.getScienceAppId();
		}else if(mode.equals(Constants.UPDATE)){
			long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"));
			ScienceAppLocalServiceUtil.updateScienceApp(sc, params, scienceAppId);
			returnLong = scienceAppId; 
		}else if(mode.equals(Constants.DELETE)){
			
		}
		return returnLong;
	}
	
	protected void exeInfomation(ServiceContext sc, Map params, long scienceAppId) throws PortalException, SystemException{
		ScienceAppLocalServiceUtil.updateExeInfomaionScienceApp(sc,params,scienceAppId);
	}
	
	protected Map<String,Object> tabCreateAndStatusButtonView(long scienceAppId, boolean swTest,String clickTab, Locale locale) throws PortalException, SystemException{
		
		Map<String,Object> returnMap = new HashMap<String,Object>();
		
		String[] tabs = null;
		int activateTab = 1;
		//작성 값에 따른 상태 변화 버튼 확인
		boolean appStatusButtonView = false;
		
		if(scienceAppId == 0){
			if(swTest){
				tabs = new String[]{"m01fail", "m02fail", "m03fail", "m04fail"};
			}else{
				tabs = new String[]{"m01fail", "m02fail"};
			}
		}else{
			String tabsStr = "";
			if(clickTab.equals("m01")){
				tabsStr +="m01over";
			}else{
				tabsStr +="m01out";
			}
			
			activateTab++;
			
			ScienceApp scienceApp = ScienceAppLocalServiceUtil.getScienceApp(scienceAppId);
			
			if(scienceApp.getExeFileName().equals("")){
				tabsStr +=",m02fail";
			}else{
				if(clickTab.equals("m02")){
					tabsStr +=",m02over";
				}else{
					tabsStr +=",m02out";
				}
				activateTab++;
				
				//분석기, EDITOR 일 경우 입/출력 포트 정보, SW TEST 탭이 없기 때문에 
				//appStatusButtonView = true
				if(!swTest){
					appStatusButtonView = true;
				}
				
			}
			
			
			//분석기, EDITOR 일 경우 입/출력 포트 정보, SW TEST 탭이 없음.
			if(swTest){
				long scienceAppInputPortsCnt = ScienceAppInputPortsLocalServiceUtil.getScienceAppInputPortsesCount(scienceAppId);
				
				if(scienceAppInputPortsCnt==0){
					tabsStr +=",m03fail";
				}else{
					if(clickTab.equals("m03")){
						tabsStr +=",m03over";
					}else{
						tabsStr +=",m03out";
					}
					activateTab++;
				}
				
				//AppTestHistory - TABLE 확인
				//최신의 데이터가 성공 CNT가 있을 경우 SUCCESS
				Map<String, Object> searchParam = new HashMap<String, Object>();
				searchParam.put("scienceAppId", scienceAppId);
				searchParam.put("begin", 0);
				searchParam.put("end", 1);
				List<Map<String, Object>> resultList = ScienceAppLocalServiceUtil.retrieveListAppTest(searchParam);
				int testCnt = 0;
				if(!resultList.isEmpty()){
					Map<String,Object> resultMap = resultList.get(0);
					testCnt = GetterUtil.getInteger(resultMap.get("successCnt"),0);
				}
				
//				int testCnt = ScienceAppLocalServiceUtil.countAppTest(scienceAppId);
				
				if(testCnt==0){
					tabsStr +=",m04fail";
				}else{
					if(clickTab.equals("m04")){
						tabsStr +=",m04over";
					}else{
						tabsStr +=",m04out";
					}
					//SW를 TEST한 내역이 있을경우 상태 변경 버튼 SHOW
					appStatusButtonView = true;
				}
			}
			
			tabs = StringUtil.split(tabsStr);
		}
		
		
		
		StringBuffer tabString = new StringBuffer();
		
		tabString.append("<ul>");
		
		for(int i=0; i<tabs.length;i++){
			String tab = tabs[i];
			String liClass = tab;
			
			if(clickTab.equals("")){
				if(i==0){
					liClass+=" select";
				}
			}else{
				if(tab.contains(clickTab)){
					liClass+=" select";
				}
			}
			
			
			String tabName = "";
			String tabValue = "";
			if(tab.contains("m01")){
				tabName=LanguageUtil.get(locale,"edison-science-appstore-view-tab-app-infomation");
				tabValue = "m01";
			};
			
			if(tab.contains("m02")){
				tabName=LanguageUtil.get(locale,"edison-science-appstore-view-tab-execute-infomation");
				tabValue = "m02";
			};
			
			if(tab.contains("m03")){
				tabName=LanguageUtil.get(locale,"edison-science-appstore-view-tab-port-infomation");
				tabValue = "m03";
			}; 
			
			if(tab.contains("m04")){
				tabName=LanguageUtil.get(locale,"edison-science-appstore-view-tab-app-test");
				tabValue = "m04";
			};
			
			if(liClass.contains("select")){
				tabString.append("<li class=\""+liClass+"\"><p>"+tabName+"</p></li>");
			}else{
				if(i<activateTab){
					tabString.append("<li class=\""+liClass+"\"><a href=\"javascript:tabAction('"+tabValue+"')\"><p>"+tabName+"</p></a></li>");
				}else{
					tabString.append("<li class=\""+liClass+"\"><p>"+tabName+"</p></li>");
				}
				
			}
		}
		tabString.append("</ul>");
		
		returnMap.put("tabString", tabString.toString());
		returnMap.put("appStatusButtonView", appStatusButtonView);
		return returnMap;
	}
	
	/**
	 * 포트 이름 입력
	 * @param request
	 * @param model
	 * @param scienceAppId 	- App ID
	 * @param portType		- Input, Output 여부
	 * @param portMode		- port 타입 추가(add), port 조회 여부(search)
	 * @return
	 */
	@RenderMapping(params = "myaction=portNameAdd")
	public String portNameAdd(RenderRequest request, ModelMap model){
		try{
			Map params = RequestUtil.getParameterMap(request);
			
			long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"),0l);
			String portType = CustomUtil.strNull(params.get("portType"));
			String portMode = CustomUtil.strNull(params.get("portMode"));
			
			
			model.addAttribute("scienceAppId",scienceAppId);
			model.addAttribute("portType",portType);
			model.addAttribute("portMode",portMode);
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		return "appmanager/port_name_add";
	}
	
	
	@RenderMapping(params = "myaction=portSearch")
	public String portSearch(RenderRequest request, ModelMap model){
		try{
			Map params = RequestUtil.getParameterMap(request);
			
			long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"),0l);
			String portType = CustomUtil.strNull(params.get("portType"));
			String portName = CustomUtil.strNull(params.get("portName"));
			
			
			model.addAttribute("scienceAppId",scienceAppId);
			model.addAttribute("portType",portType);
			model.addAttribute("portName",portName);
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		return "appmanager/port_search";
	}
	
	public static void handleRuntimeException(Exception ex, HttpServletResponse response,String message) throws IOException {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.getWriter().write(message);
		response.flushBuffer();
	}
	
	@ResourceMapping(value="addScienceAppFile")
	public void addScienceAppFile(ResourceRequest request, ResourceResponse response) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try{
			ServiceContext sc = ServiceContextFactory.getInstance(PortType.class.getName(), request);
			UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(sc.getLiferayPortletRequest());
			String fileName = GetterUtil.getString(upload.getFileName("scienceAppFile"),"");
			
			if(System.getProperty("os.name").toUpperCase().contains("WINDOWS")){
				throw new ScienceAppException(ScienceAppException.SCIENCE_APP_FILE_NOT_SUPPORT_OS);
			}else{
				long companyId = themeDisplay.getCompanyId();
				String appName = GetterUtil.getString(params.get("appName"),"");
				String appVersion = GetterUtil.getString(params.get("appVersion"),"");
				
				if(appName.equals("")||appVersion.equals("")){
					throw new Exception("AppName OR AppVersion IS NULL");
				}
				
				ScienceAppLocalServiceUtil.addScienceAppFile(companyId, appName, appVersion, fileName, upload.getFileAsStream("scienceAppFile", false));
				
				net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
				obj.put("fileName", fileName);
				response.setContentType("application/json; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(obj.toString());
			}
		}catch(Exception e){
			if(e instanceof ScienceAppException){
				handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-not-support-os"));
			}else{
				e.printStackTrace();
				handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-insert-error"));
			}
		}
	}
	

	@ResourceMapping(value="addPortType")
	public void addPortType(ResourceRequest request, ResourceResponse response) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			ServiceContext sc = ServiceContextFactory.getInstance(PortType.class.getName(), request);
			UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(sc.getLiferayPortletRequest());
			String fileName = GetterUtil.getString(upload.getFileName("sample_file"),"");
			
			if(fileName.equals("")){
				PortTypeLocalServiceUtil.createPortType(sc, params);
			}else{
				String portTypeName = GetterUtil.getString(params.get("portTypeName"),"");
				List<FileEntry> appIcons = EdisonFileUtil.insertEdisonFile(
						sc.getLiferayPortletRequest(), upload,
						sc.getUserId(), sc.getScopeGroupId(), 
						"", portTypeName, "sample_file", EdisonFileConstants.PORT_TYPE
						);
				
				FileEntry appEntry = appIcons.get(0);
				
				net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
				obj.put("fileEntryId", String.valueOf(appEntry.getFileEntryId()));
				obj.put("title", appEntry.getTitle());
				response.setContentType("application/json; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(obj.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-insert-error"));
		}
	}
	
	@ResourceMapping(value="searchCommonLib")
	public void searchCommonLib(ResourceRequest request, ResourceResponse response) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String searchValue = GetterUtil.get(params.get("searchValue"), "");
		int curPage = ParamUtil.get(request, "p_curPage", 1);
		
		try {
			int linePerPage = 10;
			
			int pagePerBlock = 5;
			int begin = (curPage - 1) * linePerPage;
			int end = linePerPage;
			
			long companyId = themeDisplay.getCompanyId();
			
			int totalCnt = CommonLibLocalServiceUtil.countCommonLib(companyId,searchValue);
			
			List<CommonLib> resultList = CommonLibLocalServiceUtil.retrieveListCommonLib(searchValue, begin, end);
			
			String portletNameSpace = response.getNamespace();
			String pageStr = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"searchCommonLib", totalCnt, curPage, linePerPage, pagePerBlock);

			
			JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			
			String optionJson = jsonSerializer.serialize(resultList);
			JSONArray optionArr = JSONFactoryUtil.createJSONArray(optionJson);
			jsonObj.put("dataList", optionArr);
			jsonObj.put("page", pageStr);
			jsonObj.put("seq", totalCnt - ((curPage - 1)*linePerPage));
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(jsonObj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
	}
	
	@ResourceMapping(value="updateAppStatus")
	public void updateAppStatus(ResourceRequest request, ResourceResponse response) throws IOException{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try{
			Map params = RequestUtil.getParameterMap(request);
			
			long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"),0);
			int status = GetterUtil.getInteger(params.get("status"),0);
			
			if(scienceAppId==0){throw new Exception("@ResourceMapping(value=updateAppStatus) scienceAppId IS NULL");}
			if(status==0){throw new Exception("@ResourceMapping(value=updateAppStatus) status IS NULL");}
			
			ScienceApp scienceApp = ScienceAppLocalServiceUtil.getScienceApp(scienceAppId);
			scienceApp.setStatus(status);
			scienceApp.setStatusDate(new Date());
			scienceApp.setRecentModifierId(themeDisplay.getUserId());
			ScienceAppLocalServiceUtil.updateScienceApp(scienceApp);
			
			PrintWriter writer = response.getWriter();
			writer.write("SUCCESS");
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-update-error"));
		}
	}
	
	
	
	/**
	 * inputdeckfrom 조회
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@ResourceMapping(value="searchInputdeckForm")
	public void searchInputdeckForm(ResourceRequest request, ResourceResponse response) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long portTypeId = GetterUtil.getLong(params.get("portTypeId"));
		try {
			String inputDeckForm = PortTypeInputdeckFormLocalServiceUtil.getInputdeckFormJsonString(portTypeId);
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(inputDeckForm);
		} catch (Exception e) {
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
	}
	
	@ResourceMapping(value="saveRequestLib")
	public void saveRequestLib(ResourceRequest request, ResourceResponse response) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"));
		String name = GetterUtil.get(params.get("name"), "");
		String version = GetterUtil.get(params.get("version"), "");
		String content = GetterUtil.get(params.get("content"), "");

		try {
			long requiredLibId = CounterLocalServiceUtil.increment(RequiredLibConfirm.class.getName());
			RequiredLibConfirmPK requiredLibConfirmPK = new RequiredLibConfirmPK(requiredLibId, scienceAppId);
			RequiredLibConfirm requiredLibConfirm = RequiredLibConfirmLocalServiceUtil.createRequiredLibConfirm(requiredLibConfirmPK);
			requiredLibConfirm.setUserId(themeDisplay.getUserId());
			requiredLibConfirm.setRequiredDate(new Date());
			requiredLibConfirm.setLibraryName(name);
			requiredLibConfirm.setLibraryVersion(version);
			requiredLibConfirm.setRequiredContent(content);
			requiredLibConfirm.setRequiredState(RequiredLibConstants.LIB_STATE_REQUIRE);
			RequiredLibConfirmLocalServiceUtil.addRequiredLibConfirm(requiredLibConfirm);
			
			PrintWriter writer = response.getWriter();
			writer.write("SUCCESS");
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-insert-error"));
		}
	}
	
	
	@ResourceMapping(value="searchAppTest")
	public void searchAppTest(ResourceRequest request, ResourceResponse response) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"));
		int curPage = ParamUtil.get(request, "p_curPage", 1);
		try {
			int linePerPage = 5;
			
			int pagePerBlock = 10;
			int begin = (curPage - 1) * linePerPage;
			int end = linePerPage;
			
			int totalCnt = ScienceAppLocalServiceUtil.countAppTest(scienceAppId);
			
			Map<String, Object> searchParam = new HashMap<String, Object>();
			searchParam.put("scienceAppId", scienceAppId);
			searchParam.put("begin", begin);
			searchParam.put("end", end);
			List<Map<String, Object>> resultList = ScienceAppLocalServiceUtil.retrieveListAppTest(searchParam);
			
			String pageStr = PagingUtil.getPaging(request.getContextPath(), "searchAppTest", totalCnt, curPage, linePerPage, pagePerBlock);

			
			net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
			net.sf.json.JSONArray jsonArray = new net.sf.json.JSONArray();
			jsonObj.put("dataList", jsonArray.fromObject(resultList));
			jsonObj.put("page", pageStr);
			jsonObj.put("seq", totalCnt - ((curPage - 1)*linePerPage));
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(jsonObj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
	}
	
	@ResourceMapping(value="searchRequestLib")
	public void searchRequestLib(ResourceRequest request, ResourceResponse response) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"));
		try {
			int curPage = ParamUtil.get(request, "p_curPage", 1);
			int linePerPage = 5;
			
			int pagePerBlock = 10;
			int start = linePerPage * (curPage - 1);
			
			String portletNameSpace = response.getNamespace();

			int totalCnt = RequiredLibConfirmLocalServiceUtil.countByScienceAppId(scienceAppId);
			List<RequiredLibConfirm> resultList = RequiredLibConfirmLocalServiceUtil.findByScienceAppId(scienceAppId, start, curPage*linePerPage, null);
			
			String pageStr = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"searchRequestLib", totalCnt, curPage, linePerPage, pagePerBlock);
			
			response.setContentType("application/json; charset=UTF-8");
			JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			
			String optionJson = jsonSerializer.serialize(resultList);
			JSONArray optionArr = JSONFactoryUtil.createJSONArray(optionJson);
			
			jsonObj.put("dataList", optionArr);
			jsonObj.put("page", pageStr);
			jsonObj.put("seq", totalCnt - ((curPage - 1)*linePerPage));
			
			PrintWriter out = response.getWriter();
			out.write(jsonObj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
	}
	
	@RenderMapping(params = "myRender=libChangeRender")
	public String libChangeRender(RenderRequest request, ModelMap model){
		try{
			Map params = RequestUtil.getParameterMap(request);
			long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"));
			long requiredLibId = GetterUtil.getLong(params.get("requiredLibId"),0);
			
			String mode = "";
			if(requiredLibId==0){
				mode = Constants.ADD;
			}else{
				RequiredLibConfirmPK requiredLibConfirmPK = new RequiredLibConfirmPK(requiredLibId, scienceAppId);
				RequiredLibConfirm requiredLibConfirm = RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirm(requiredLibConfirmPK);
				model.addAttribute("data", requiredLibConfirm.getModelAttributes());
				mode = Constants.SEARCH;
			}
			
			model.addAttribute("mode", mode);
			model.addAttribute("requiredLibId", requiredLibId);
			model.addAttribute("scienceAppId", scienceAppId);
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		return "appmanager/request_lib";
	}
	
	@RenderMapping(params = "myRender=commonLibRender")
	public String commonLibRender(RenderRequest request, ModelMap model){
		return "appmanager/common_lib";
	}
	
	
	
	@ResourceMapping(value="portTypeSearch")
	public void portTypeSearch(ResourceRequest request, ResourceResponse response){
		try {
		
			Map params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			
			int curPage = Integer.parseInt(CustomUtil.strNull(params.get("p_curPage"), "1"));
			int linePerPage = 10;
			int pagePerBlock = 5;
			int begin = (curPage - 1) * linePerPage;
			int end = linePerPage;
			
			String searchName = CustomUtil.strNull(params.get("searchName"));
			
			Map<String, Object> searchParam = new HashMap<String, Object>();
			searchParam.put("searchName", searchName);
			
			
			int totalCnt = PortTypeLocalServiceUtil.countPortType(themeDisplay.getCompanyGroupId(), 
																  themeDisplay.getLocale(), 
																  searchParam);
			
			List<Map<String, Object>> listPortType = PortTypeLocalServiceUtil.retrieveListPortType(themeDisplay.getCompanyGroupId(), 
																		   themeDisplay.getLocale(), 
																		   searchParam, 
																		   begin, end);
			
			String pagingStr = PagingUtil.getPaging(request.getContextPath(), response.getNamespace()+"searchPortTypeList", totalCnt, curPage, linePerPage, pagePerBlock);
			
			response.setContentType("application/json; charset=UTF-8");
			JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
			String optionJson = jsonSerializer.serialize(listPortType);
			JSONArray optionArr = JSONFactoryUtil.createJSONArray(optionJson);
			
			JSONObject returnObject = JSONFactoryUtil.createJSONObject();
			returnObject.put("dataList", optionArr);
			returnObject.put("pagingStr", pagingStr);
			
			PrintWriter out = response.getWriter();
			out.write(returnObject.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResourceMapping(value="portTypeEditorLinkSearch")
	public void portTypeEditorLinkSearch(ResourceRequest request, ResourceResponse response) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			long portTypeId = GetterUtil.getLong(params.get("portTypeId"),0);
			long companyId = themeDisplay.getCompanyId();
			
			List<Map<String,Object>> dataList = PortTypeEditorLinkLocalServiceUtil.findByPortTypeEditorWithAppName(companyId, portTypeId);
			
			response.setContentType("application/json; charset=UTF-8");
			net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
			obj.put("dataList", dataList);
			
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
	}
	
	@ResourceMapping(value="portTypeAnalyzerLinkSearch")
	public void portTypeAnalyzerLinkSearch(ResourceRequest request, ResourceResponse response) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			long companyId = themeDisplay.getCompanyId();
			long portTypeId = GetterUtil.getLong(params.get("portTypeId"),0);
			
			List<Map<String,Object>> dataList = PortTypeAnalyzerLinkLocalServiceUtil.findByPortTypeAnalyzerWithAppName(companyId, portTypeId);
			
			response.setContentType("application/json; charset=UTF-8");
			net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
			obj.put("dataList", dataList);
			
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
	}
	
	
	

	
	@ResourceMapping(value="checkePortName")
	public void checkePortName(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, JSONException{
		Map params = RequestUtil.getParameterMap(request);
		
		long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"),0l);
		String portType = CustomUtil.strNull(params.get("portType"));
		String portMode = CustomUtil.strNull(params.get("portMode"));
		
		String portName = CustomUtil.strNull(params.get("portName"));
		
		boolean result = false;
		//포트타입 추가
		if(portMode.equals(Constants.ADD)){
			boolean portExist = PortTypeLocalServiceUtil.existPortType(portName);
			if(!portExist){
				result=true;
			}
		}else{
			if(StringUtil.equalsIgnoreCase(portType, "INPUT")){
				long cnt = ScienceAppInputPortsLocalServiceUtil.getScienceAppInputPortsesCount(scienceAppId);
				if(cnt==0){
					result = true;
				}else{
					String inputJson = ScienceAppInputPortsLocalServiceUtil.getInputPortsJsonString(scienceAppId);
					JSONObject input = JSONFactoryUtil.createJSONObject(inputJson);
					if(input.getString(portName).equals("")){
						result = true;
					}
					
				}
			}else{
				long cnt = ScienceAppOutputPortsLocalServiceUtil.getScienceAppOutputPortsesCount(scienceAppId);
				if(cnt==0){
					result = true;
				}else{
					String outputJson = ScienceAppOutputPortsLocalServiceUtil.getOutputPortsJsonString(scienceAppId);
					JSONObject output = JSONFactoryUtil.createJSONObject(outputJson);
					if(output.getString(portName).equals("")){
						result = true;
					}
				}
			}
		}
		
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("result", result);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@RenderMapping(params = "myaction=portTypeEditor")
	public String portTypeEditor(RenderRequest request, ModelMap model){
		try{
			Map params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String portTypeName = CustomUtil.strNull(params.get("portTypeName"));
			String portType = CustomUtil.strNull(params.get("portType"));
			
			
			//EDITOR 조회
			Map<String,Object> searchParam = new HashMap<String,Object>();
			searchParam.put("appType", ScienceAppConstants.APP_TYPE_EDITOR);
			searchParam.put("status", 1901004);
			
//			//Editor 중 String 타입이 아닌것만 조회 - 확인 필요
//			searchParam.put("notEditorTypeString", "NO");
			
			List<Map<String, Object>> editorDataList = ScienceAppLocalServiceUtil.retrieveListScienceEditorApp(
																	themeDisplay.getCompanyId(), 
																	themeDisplay.getLocale(), 
																    searchParam);
			
			//Analyzer 조회
			Map<String,Object> analyzerSearchParam = new HashMap<String,Object>();
			analyzerSearchParam.put("appType", ScienceAppConstants.APP_TYPE_ANALYZER);
			analyzerSearchParam.put("status", 1901004);
			
			List<Map<String, Object>> analyzerDataList = ScienceAppLocalServiceUtil.retrieveListScienceEditorApp(
																		themeDisplay.getCompanyId(), 
																		themeDisplay.getLocale(), 
																		analyzerSearchParam);
			
			model.addAttribute("editorDataList",editorDataList);
			model.addAttribute("analyzerDataList",analyzerDataList);
			model.addAttribute("portTypeName",portTypeName);
			model.addAttribute("portType",portType);
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		return "appmanager/port_type_editor";
	}
	
	@RenderMapping(params = "myaction=portTypeAddView")
	public String portTypeAdd(RenderRequest request, ModelMap model){
		try{
			Map params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String targetLanuage = GetterUtil.getString(params.get("targetLanuage"));
			
			model.addAttribute("editor",GetterUtil.getString(params.get("editor"),""));
			model.addAttribute("defaultEditor",params.get("defaultEditor"));
			model.addAttribute("portTypeName",params.get("portTypeName"));
			model.addAttribute("targetLanuage",targetLanuage);
			model.addAttribute("inputDeckExist",params.get("inputDeckExist"));
			model.addAttribute("analyzer",GetterUtil.getString(params.get("analyzer"),""));
			model.addAttribute("defaultAnalyzer",GetterUtil.getString(params.get("defaultAnalyzer"),""));
			model.addAttribute("fileExist",params.get("fileExist"));
			
			if(targetLanuage.equals("full")){
				model.addAttribute("defaultLanguage",themeDisplay.getSiteDefaultLocale().toString());
				String fullLanuage = "";
				for(Locale locale : LanguageUtil.getAvailableLocales()){
					String languageId = LocaleUtil.toLanguageId(locale);
					
					if(fullLanuage.equals("")){
						fullLanuage += languageId;
					}else{
						fullLanuage += ","+languageId;
					}
				}
				
				model.addAttribute("availableLanguages","{"+fullLanuage+"}");
			}else{
				model.addAttribute("defaultLanguage",targetLanuage);
				model.addAttribute("availableLanguages","{"+targetLanuage+"}");
			}
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		return "appmanager/port_type_add";
	}
	
	
	@ResourceMapping(value="edisonFileDownload")
	public void edisonFileDownload(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, IOException{
		Map paramsMap = RequestUtil.getParameterMap(request);
		long fileEntryId = Long.parseLong(CustomUtil.strNull(paramsMap.get("fileEntryId")));
		EdisonFileUtil.edisonFileDownload(response, fileEntryId);
	}
	
	
	/**
	 * app Manager 조회
	 * @param request
	 * @param response
	 */
	@ResourceMapping(value="appManagerList")
	public void getAppManagerList(ResourceRequest request, ResourceResponse response) throws Exception{
		Map params = RequestUtil.getParameterMap(request);
		long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"),0);
		
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		Role role = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.SOLVER_MANAGER);		// Role Id 확인
		
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		if (scienceAppId != 0) {
			List<ScienceAppManager> scienceAppManagers= ScienceAppManagerLocalServiceUtil.getManagersByScienceAppId(scienceAppId);
			
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			df.setTimeZone(TimeZoneUtil.getDefault());
			
			List<Map<String,String>> ajaxList = new ArrayList<Map<String,String>>();
			for(ScienceAppManager scienceAppManager:scienceAppManagers){
				Map<String,String> rowMap = new HashMap<String,String>();
				User user = UserLocalServiceUtil.getUser(scienceAppManager.getUserId());
				
				rowMap.put("userScreenName", user.getScreenName());
				rowMap.put("userFullName", user.getFirstName());
				rowMap.put("userEmailAddress", user.getEmailAddress());
				rowMap.put("createDate", df.format(scienceAppManager.getCreateDate()));
				rowMap.put("scienceAppManagerId", String.valueOf(scienceAppManager.getScienceAppManagerId()));
				
				ajaxList.add(rowMap);
			}
			
			JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
			String optionJson = jsonSerializer.serialize(ajaxList);
			JSONArray optionArr = JSONFactoryUtil.createJSONArray(optionJson);
			
			obj.put("appManagerList", optionArr);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@ResourceMapping(value="deleteAppAuth")
	public void deleteAppAuth(ResourceRequest request, ResourceResponse response) throws Exception {
		Map params = RequestUtil.getParameterMap(request);
		
		long scienceAppManagerId = GetterUtil.getLong(params.get("scienceAppManagerId"),0);
		
		/*권한 삭제*/
		ScienceAppManager scienceAppManager = ScienceAppManagerLocalServiceUtil.getScienceAppManager(scienceAppManagerId);
		ScienceAppManagerLocalServiceUtil.deleteScienceAppManager(scienceAppManager);
		
		int managerCnt = ScienceAppManagerLocalServiceUtil.countByUserId(scienceAppManager.getUserId());
		if(managerCnt == 0){
			User user = UserLocalServiceUtil.getUser(scienceAppManager.getUserId());
			
			for(Group group : user.getMySiteGroups()){
				EdisonUserUtil.deleteSiteRole(user, group.getGroupId(), EdisonRoleConstants.SOLVER_MANAGER);
			}
//				EdisonUserUtil.deleteGroup(user, EdisonRoleConstants.DEVELOPER_GROUP);
		}
		
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	
	
	@ResourceMapping(value="appUserInfo")
	public void appUserInfo(ResourceRequest request, ResourceResponse response) throws Exception {
		Map params = RequestUtil.getParameterMap(request);
				
		String type = CustomUtil.strNull(params.get("type"));
		
		long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"),0);
		String userScreenName = "";
		String pre_userScreenName = "";
		
		if(type.equals("owner")){
			userScreenName = CustomUtil.strNull(params.get("userScreenName_owner"),"0");
			pre_userScreenName = CustomUtil.strNull(params.get("now_userScreenName"),"0");
		}else if(type.equals("manager")){
			userScreenName = CustomUtil.strNull(params.get("userScreenName_manager"),"0");
		}
		
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		User user = UserLocalServiceUtil.fetchUserByScreenName(companyId, userScreenName);
		
		//com.liferay.util.json.JSONFactoryUtil -  Deprecated. 6.2-ce-ga5
		net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
		Map<String, String> appUserInfo = null;
		
		
		if (user == null) {
			obj.put("result", "none");
		} else {
			
			Role ownerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.SOLVER_OWNER);		// Owner Role Id 확인
			Role managerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.SOLVER_MANAGER);		// Manager Role Id 확인
			
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(checker);
			
			if(type.equals("manager")){
				long appUserId = ScienceAppLocalServiceUtil.getScienceApp(scienceAppId).getAuthorId();
				long managerExistCnt = ScienceAppManagerLocalServiceUtil.countByAppIdAndUserId(scienceAppId, user.getUserId());
				
				if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)
						|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)
						|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)) {
					obj.put("result", "admin");
				}else if(user.getUserId()==appUserId) {	// Owner 체크
					obj.put("result", "owner");
				} else if(managerExistCnt>0) {	// Manager 체크
					obj.put("result", "manager");
				}else {
					appUserInfo = new HashMap<String, String>();
					appUserInfo.put("userScreenName", user.getScreenName());
					appUserInfo.put("userFullName", user.getFullName());
					appUserInfo.put("userEmailAddress", user.getEmailAddress());
					appUserInfo.put("userId", String.valueOf(user.getUserId()));
					
					obj.put("appUserInfo", appUserInfo);
					obj.put("result", "user");
				}
			}else if(type.equals("owner")){
				appUserInfo = new HashMap<String, String>();
				appUserInfo.put("userScreenName", user.getScreenName());
				appUserInfo.put("userFullName", user.getFullName());
				appUserInfo.put("userEmailAddress", user.getEmailAddress());
				appUserInfo.put("userId", String.valueOf(user.getUserId()));
				
				obj.put("appUserInfo", appUserInfo);
				obj.put("result", "user");
			}
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	
	@ResourceMapping(value="appManagerAdd")
	public void appManagerAdd(ResourceRequest request, ResourceResponse response) throws Exception{
		Map params = RequestUtil.getParameterMap(request);
		
		long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"),0);
		long userId = GetterUtil.getLong(params.get("managerUserId"),0);
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		
		User requestUser = UserLocalServiceUtil.fetchUser(userId);
		Role role = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.SOLVER_MANAGER);		// Role Id 확인
		
		//권한 추가
		EdisonUserUtil.addSiteRole(requestUser, groupId, EdisonRoleConstants.SOLVER_MANAGER);	// SOLVER MANAGER 권한 추가
		
		//DEVELOPER_GROUP에 추가
		EdisonUserUtil.addGroup(requestUser, EdisonRoleConstants.DEVELOPER_GROUP);
		
		//DB 추가
		long scienceAppManagerId = CounterLocalServiceUtil.increment(ScienceAppManager.class.getName());
		ScienceAppManager scienceAppManager =  ScienceAppManagerLocalServiceUtil.createScienceAppManager(scienceAppManagerId);
		scienceAppManager.setUserId(userId);
		scienceAppManager.setCreateDate(new Date());
		scienceAppManager.setScienceAppId(scienceAppId);
		scienceAppManager.setManagerId(role.getRoleId());
		ScienceAppManagerLocalServiceUtil.updateScienceAppManager(scienceAppManager);
		
		
		
		net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
		obj.put("scienceAppId", scienceAppId);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	
	@ResourceMapping(value="appOwnerUpdate")
	public void updateSolverOwner(ResourceRequest request, ResourceResponse response) throws PortalException{
		 //solver, auth 테이블 update
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try{
			long groupId = PortalUtil.getScopeGroupId(request);
			long preUserId = GetterUtil.getLong(params.get("pre_userScreenName"),0);
			long userId = GetterUtil.getLong(params.get("ownerUserId"),0);
			long scienceAppId =  GetterUtil.getLong(params.get("scienceAppId"),0);
			
			
			User requestUser = UserLocalServiceUtil.fetchUser(userId);
			
			/*권한 등록*/
			//GROUP_추가
			EdisonUserUtil.addGroup(requestUser, EdisonRoleConstants.DEVELOPER_GROUP);
			
			//SiteRole 추가
			EdisonUserUtil.addSiteRole(requestUser, groupId, EdisonRoleConstants.SOLVER_OWNER);	// SOLVER OWNER 권한 추가
			
			/*권한 삭제*/
			//매니저 권한이 있었을 경우 제거 해줌
			if(ScienceAppManagerLocalServiceUtil.countByAppIdAndUserId(scienceAppId, userId)>0){
				List<ScienceAppManager> appManagerList = ScienceAppManagerLocalServiceUtil.findByAppIdAndUserId(scienceAppId, userId);
				for(ScienceAppManager scienceAppManager : appManagerList){
					ScienceAppManagerLocalServiceUtil.deleteScienceAppManager(scienceAppManager.getScienceAppManagerId());
				}
			}
			
			//Administrator, Site Administrator 가 아닐경우
			//WORKSPACE 승인 내역이 없을경우
			//솔버권한 확인 후 GROUP, SiteRole 삭제
			User preUser = UserLocalServiceUtil.fetchUser(preUserId);
			
			int developerInfoCnt = DeveloperInfoLocalServiceUtil.getScienceAppDeveloperInfoCount(preUserId, groupId);
					
			if(!EdisonUserUtil.isRegularRole(preUser, EdisonRoleConstants.ADMINISTRATOR)
			 &&!EdisonUserUtil.isSiteRole(preUser, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)
			 &&developerInfoCnt==0){
				//현재 관리 하고 있는 app 목록이 없을 경우 SOLVER_MANAGER 권한 삭제
				int managerCnt = ScienceAppManagerLocalServiceUtil.countByUserId(preUserId);
				if(managerCnt == 0){
					if(preUser.getMySiteGroups().size()!=0){
						for(Group group : preUser.getMySiteGroups()){
							EdisonUserUtil.deleteSiteRole(preUser, group.getGroupId(), EdisonRoleConstants.SOLVER_MANAGER);
						}
//								EdisonUserUtil.deleteGroup(user, EdisonRoleConstants.DEVELOPER_GROUP);
					}
				}
			}
			
			/*Solver Table userId 변경*/
			ScienceApp scienceApp = ScienceAppLocalServiceUtil.getScienceApp(scienceAppId);
			scienceApp.setAuthorId(userId);
			scienceApp.setRecentModifierId(themeDisplay.getUserId());
			scienceApp.setModifiedDate(new Date());
			ScienceAppLocalServiceUtil.updateScienceApp(scienceApp);
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write(requestUser.getScreenName());
		}catch(Exception e){
			e.printStackTrace();
			throw new PortalException(e);
		}
	}
	
	@ResourceMapping(value="deleteFile")
	public void deleteFile(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException{
		Map params = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String fileType = GetterUtil.getString(params.get("fileType"),"");
		String language = GetterUtil.getString(params.get("language"),"");
		long fileEntryId = GetterUtil.getLong(params.get("fileEntryId"),0);
		long scienceAppId = GetterUtil.getLong(params.get("scienceAppId"),0);
		
		if(fileEntryId!=0&&!fileType.equals("")){
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(fileEntryId);
			if(!fileType.equals("portType")){
				ScienceApp scienceApp = ScienceAppLocalServiceUtil.getScienceApp(scienceAppId);
				
				if(fileType.equals("soruceFile")){
					scienceApp.setSrcFileName("");
				}else if(fileType.equals("appIcon")){
					scienceApp.setIconId(0);
				}else if(fileType.equals("appManual")){
					scienceApp.setManualId("0", LocaleUtil.fromLanguageId(language));
				}
				scienceApp.setModifiedDate(new Date());
				scienceApp.setRecentModifierId(themeDisplay.getUserId());
				ScienceAppLocalServiceUtil.updateScienceApp(scienceApp);
			}
		}
	}
	
	
	//에러보기
	@ResourceMapping(value = "errorAPICall")
	public void errorView(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, IOException, ParseException{
		Map param = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = themeDisplay.getScopeGroupId();
		String jobUuid = CustomUtil.strNull(param.get("jobUuid"));
		User user = themeDisplay.getUser();
		String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
		IcebreakerVcToken vcToken = getOrCreateToken(groupId, user);
		
		String result = errorView(icebreakerUrl, vcToken.getVcToken(), jobUuid);
		result = result.replaceAll("[\"\']", " ");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(result);
	}
	
	protected void checkAppPermission(ScienceApp scienceApp, long userId) throws SystemException, ScienceAppException {
		
		int managerCnt = ScienceAppManagerLocalServiceUtil.countByAppIdAndUserId(scienceApp.getScienceAppId(), userId);
		
		if(managerCnt==0){
			throw new ScienceAppException(ScienceAppException.SCIENCE_APP_NO_AUTH);
		}
		
	}
	
	
	private IcebreakerVcToken getOrCreateToken(long thisGroupId, User user) throws MalformedURLException, PortalException, SystemException, IOException, ParseException{
		
		IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();

		Group thisGroup = GroupLocalServiceUtil.getGroup(thisGroupId);		
		String userScreenName = "";
		String userPassword = "";
		String universityField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY);
		String virtualLabId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_LAB_ID);
		String classId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
		String majorField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR);
		
		if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) || EdisonUserUtil.isSiteRole(user, thisGroupId, RoleConstants.SITE_ADMINISTRATOR)){
			userScreenName = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_ID);
			userPassword = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_PWD);
		}else{
			userScreenName = String.valueOf(user.getScreenName());
			userPassword = user.getPassword();
		}
		
		if(VCRegisterUtil.isVcInfo(thisGroupId, userScreenName) == 200){
			
			if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))){
			
				icebreakerVcToken.setVcToken(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))));				
				icebreakerVcToken.setVcTokenExpired(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId)), "0"));
	
				if(Integer.parseInt(icebreakerVcToken.getVcTokenExpired()) <= Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
					//시간이 지난 토큰인 경우 새로운 토큰 발행 및 커스텀 필드 저장				
					icebreakerVcToken = TokenProviderUtil.getVcToken(thisGroupId, userScreenName, userPassword);
		
					//Icebreaker에 회원정보는 있으나 로그인 되지 않는 경우 비밀번호 변경으로 인한것으로 판단하여 비밀번호 update후에 다시 로그인하여 토큰을 요청 합니다. 
					if(icebreakerVcToken.getResultCode() != 200){
						int updateResult = VCRegisterUtil.VCUpdate(thisGroupId, userScreenName, userPassword, user.getEmailAddress());
						if(updateResult==200){
							icebreakerVcToken = TokenProviderUtil.getVcToken(thisGroupId, userScreenName, userPassword);
						}
					}
					
					if(icebreakerVcToken.getResultCode() == 200){
						icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());					
						icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
						
						user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), icebreakerVcToken.getVcToken());
						user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), icebreakerVcToken.getVcTokenExpired());
					}else{
						log.debug("SimulationLocalServiceImpl : Icebreaker getOrCreateToken Error !!");
					}
				}
			}else{
				//icebreaker 계정은 있으나 포털에 expando가 없는 경우 expando 추가 생성
				icebreakerVcToken = creaateExpandoUserVctoken(user, thisGroupId, userScreenName, userPassword);
			}
		}else{
			int resultRegist = VCRegisterUtil.VCRegist(thisGroupId, userScreenName, userPassword, user.getEmailAddress(), user.getFirstName(), universityField, virtualLabId, classId, majorField);
			if (resultRegist == 201) {
				//icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
				icebreakerVcToken = creaateExpandoUserVctoken(user, thisGroupId, userScreenName, userPassword);
			}
		}
	
		return icebreakerVcToken;
	}
	
	
	private static IcebreakerVcToken creaateExpandoUserVctoken(User user, long thisGroupId, String userScreenName, String userPassword) throws SystemException, MalformedURLException, PortalException, IOException, ParseException {

		IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();
		
		//icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
		icebreakerVcToken = TokenProviderUtil.getVcToken(thisGroupId, userScreenName, userPassword);										
		icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());					
		icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
		
		if(!user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))){		

			user.getExpandoBridge().addAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), false);
			user.getExpandoBridge().addAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), false);
			
			ExpandoColumn toKenColumn = ExpandoColumnLocalServiceUtil.getColumn(
																			user.getExpandoBridge().getCompanyId(), 
																			user.getExpandoBridge().getClassName(), 
																			ExpandoTableConstants.DEFAULT_TABLE_NAME, 
																			EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId)
																			);
			setExpandoPermissions(user.getExpandoBridge().getCompanyId(), toKenColumn); 
		
			ExpandoColumn expiredColumn = ExpandoColumnLocalServiceUtil.getColumn(
																			user.getExpandoBridge().getCompanyId(), 
																			user.getExpandoBridge().getClassName(), 
																			ExpandoTableConstants.DEFAULT_TABLE_NAME, 
																			EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId)
																			);
			setExpandoPermissions(user.getExpandoBridge().getCompanyId(), expiredColumn);
		}
		
		user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), icebreakerVcToken.getVcToken());
		user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), icebreakerVcToken.getVcTokenExpired());
		return icebreakerVcToken;
	}
	
private static void setExpandoPermissions(long companyId, ExpandoColumn column) throws SystemException {
        
		try {
	 
			Role userRole = RoleLocalServiceUtil.getRole(companyId, RoleConstants.USER);
			Role adminRole = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
	 
	          
			if (userRole != null && adminRole != null) {
				// define actions 
				String[] actionIds = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
				
				Map<Long, String[]> map = new HashMap();
				map.put(userRole.getRoleId(), actionIds);
				map.put(adminRole.getRoleId(), actionIds);
	                
				// set the permission
				ResourcePermissionLocalServiceUtil.setResourcePermissions(
	                															companyId, 
	                															ExpandoColumn.class.getName(), 
	                															ResourceConstants.SCOPE_INDIVIDUAL, 
	                															String.valueOf(column.getColumnId()), 
	                															map
	                															);
	                	                
	            }
	      } catch (PortalException pe) {
	      }
	}
	
	
	private String errorView(String icebreakerUrl, String vcToken, String job_uuid) throws IOException{
		String resultText = "";
		if(!CustomUtil.strNull(vcToken).equals("")){
			URL url = new URL(icebreakerUrl+"/api/job/"+CustomUtil.strNull(job_uuid)+"/log/error");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/plain");
			conn.setRequestProperty("Content-Type", "application/xml");
			
			//GET Token
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String  output = "";		
				StringBuffer responseBuffer = new StringBuffer();
				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){
						responseBuffer.append(CustomUtil.strNull(output)+"<br/>");	
					}
				}	
				resultText = responseBuffer.toString();
			}else if (conn.getResponseCode() == 400) {
				log.error("Failed IcebreakerService [ errorView ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 401) {
				log.error("Failed IcebreakerService [ errorView ] : UNAUTHORIZED : access denied - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 404) {
				log.error("Failed IcebreakerService [ errorView ] : NOT FOUND : no existing job - HTTP error code : " + conn.getResponseCode());
			}else{			
				log.error("Failed IcebreakerService [ errorView ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();		
		}else{
			log.error("Failed IcebreakerService [ errorView ] : Token is NOT NULL - Request error code : 999");
		}
		
		return resultText;
	}
}
