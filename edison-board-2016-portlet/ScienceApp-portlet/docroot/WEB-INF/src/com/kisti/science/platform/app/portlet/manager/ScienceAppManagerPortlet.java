package com.kisti.science.platform.app.portlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import science.platform.service.constants.SciencePlatformAction;

import com.kisti.science.platform.app.service.constants.ScienceAppConstants;
import com.kisti.science.platform.app.service.persistence.ScienceAppPersistence;
import com.kisti.science.platform.app.service.persistence.ScienceAppPersistenceImpl;
import com.kisti.science.platform.app.model.ScienceApp;
import com.kisti.science.platform.app.service.ScienceAppCategoryLinkLocalServiceUtil;
import com.kisti.science.platform.app.service.ScienceAppLocalServiceUtil;
import com.kisti.science.platform.app.model.CommonLibrary;
import com.kisti.science.platform.app.service.CommonLibraryServiceUtil;
import com.kisti.science.platform.app.model.CommonModule;
import com.kisti.science.platform.app.service.CommonModuleServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ScienceAppManagerPortlet
 */
public class ScienceAppManagerPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(ScienceAppManagerPortlet.class.getName());

	/** 
	 * @param renderRequest
	 * @param renderResponse
	 * @throws IOException
	 * @throws PortletException
	 * 
	 * Also see @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse).
	 */
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
			String renderPage = ParamUtil.getString(renderRequest, "renderPage");

			String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
			_log.info("renderPage: "+renderPage);
			_log.info("mvcPath: "+mvcPath);

		super.doView(renderRequest, renderResponse);
	}

	/** 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletException
	 * 
	 * Also see @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse).
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String method = ParamUtil.getString(resourceRequest, "method");
		String appName = ParamUtil.getString(resourceRequest, "appName");
		String appVersion = ParamUtil.getString(resourceRequest, "appVersion");
		
		_log.debug("METHOD: "+ method);
		_log.debug("appName: "+appName);
		_log.debug("appVersion: "+appVersion);
		
		PrintWriter writer = resourceResponse.getWriter();
		
		JSONObject resource = JSONFactoryUtil.createJSONObject();
		
		boolean isDuplicated = false;
		
		if(method == null || method.isEmpty()){
			_log.info("Method does not exist: do not know what to to!");
			throw new PortletException("Method does not exist: do not know what to to!");
		}
		
		if(method.equalsIgnoreCase(SciencePlatformAction.CHECK_DUPLICATION_SCIENCEAPP)){
			try {
				isDuplicated = ScienceAppLocalServiceUtil.existApp(appName, appVersion);
				resource.put("isDuplicated", isDuplicated);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(isDuplicated == false){
				ServiceContext sc = null;
				try {
					sc = ServiceContextFactory.getInstance(ScienceApp.class.getName(), resourceRequest);
//					sc = ServiceContextFactory.getInstance(resourceRequest);
					Date date = new Date();
					sc.setCreateDate(date);
					sc.setModifiedDate(date);
					_log.debug("Current URL: "+sc.getCurrentURL());
					_log.debug("Company Id: "+sc.getCompanyId());
					_log.debug("Scope Group Id: "+sc.getScopeGroupId());
				} catch (PortalException e) {
					e.printStackTrace();
					return;
				} catch (SystemException e) {
					e.printStackTrace();
					return;
				}
				
				ScienceApp app = null;
				try {
					app = ScienceAppLocalServiceUtil.createScienceApp(appName, appVersion, sc);
				} catch (SystemException e) {
					e.printStackTrace();
					return;
				}
				
				if(app == null){
					throw new PortletException("Unable to create new ScienceApp: May the ScienceApp exitst in the database already.");
				}
				
				try {
					app.setStage(ScienceAppConstants.EMPTY);
					app.setStatus(WorkflowConstants.STATUS_APPROVED);
					ScienceAppLocalServiceUtil.addScienceApp(app, sc);
				} catch (SystemException e) {
					e.printStackTrace();
					return;
				} catch (PortalException e) {
					e.printStackTrace();
					return;
				}
				
				JSONObject appJSON = JSONFactoryUtil.createJSONObject();
				
				appJSON.put("appName", appName);
				appJSON.put("appVersion", appVersion);
				appJSON.put("appId", app.getScienceAppId());
				resource.put("app", appJSON);
			}
			
			writer.print(resource.toString());
		}
		else if(method.equalsIgnoreCase(SciencePlatformAction.DELETE_SCIENCEAPP)){
			long scienceAppId = ParamUtil.getLong(resourceRequest, "scienceAppId");
			
			_log.info("ScienceAppId To be deleted: "+scienceAppId);
			
			try {
				ScienceAppLocalServiceUtil.deleteScienceApp(scienceAppId);
			} catch (PortalException e) {
				e.printStackTrace();
				return;
			} catch (SystemException e) {
				e.printStackTrace();
				return;
			}
			
		}
		
		writer.flush();
		writer.close();
		
		super.serveResource(resourceRequest, resourceResponse);
	}

	public void createNewScienceApp(ActionRequest request, ActionResponse response ){
		System.out.println("action request");
	}
	
	public void proceedToEditGeneralInfo(ActionRequest request, ActionResponse response) throws IOException{
		String renderPage = ParamUtil.getString(request, "renderPage");
		String appId = ParamUtil.getString(request, "appId");
		String appName = ParamUtil.getString(request, "appName");
		String appVersion = ParamUtil.getString(request, "appVersion");
		request.setAttribute("renderPage", renderPage);
		request.setAttribute("appId", appId);
		request.setAttribute("appName", appName);
		request.setAttribute("appVersion", appVersion);
		
		response.setRenderParameter("jspPage", "/html/scienceapp/manager/edit_general_info.jsp");
		//response.sendRedirect(renderPage);
		/*
		String portletName = (String)request.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request),portletName,themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", "/html/scienceapp/manager/edit_general_info.jsp");
		System.out.println("jspPage in Action: "+redirectURL.toString());
		response.sendRedirect(redirectURL.toString());
		*/
		//System.out.println("mvcPath in Action: "+path);
		//response.sendRedirect(path);
	}

	@Override
	public void doConfig(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doConfig(renderRequest, renderResponse);
	}
	
	public void saveSampleScienceApp(ActionRequest request, ActionResponse response){
		String appNameBase[] = {
				"abcd","bcde","cdef","defg","dfgi","fgij","ghij","hijk","ijkl","jklm"
		};
		String appTitleBase[][] = {
				{"한국 등 트럼프 핵정책 반박", "Donald Trump suggestion that South Korea and Japan"},
				{"한국 대학들 북한학 외면","North Korea is losing ground in South Korean academic"},
				{"우버로 헬리콥터 불러 타기","The company that shook up the world taxi industry"},
				{"제브 부시 크루우즈 지지 선언","Former Florida Gov Jeb Bush is endorsing Sen Ted Cruz"},
				{"트럼프 미국은 가난한 나라","we are a poor country now"},
				{"푸틴의 허풍선같은 러시아","Deep Russian decline will limit its aggression"},
				{"힘들게 된 트럼프 지명","The loss in Ohio makes it extraordinarily difficult"},
				{"캠벨 대장 탈리반 공격해야","A senior American general has proposed resuming offensive strikes"},
				{"용감한 중국 매체 차이신 미이디어","Hu Shuli journalism has pushed the"},
				{"미 여야 상원의원들 이민법 개혁안 윤곽에 합의","Senators Offer a Bipartisan Blueprint for Immigration"}
		};
		
		String[] targets = {
				"ko_KR",
				"en_US"
		};
		
		String[] stages = ScienceAppConstants.getScienceAppStages();	
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Group globalGroup=null;
		try {
			globalGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "20155");
			System.out.println("Global group ID: "+ globalGroup.getGroupId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AssetVocabulary vocabulary=null;
		try {
			vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(globalGroup.getGroupId(), "Active Domain");
			System.out.println("Vocabulary Name: "+vocabulary.getName());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<AssetCategory> categoryList=null;
		int categoryCount = 0;
		try {
			categoryCount = AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(vocabulary.getVocabularyId());
			categoryList = AssetCategoryLocalServiceUtil.getVocabularyCategories(
					vocabulary.getVocabularyId(), 
					0, 
					categoryCount, 
					null);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(AssetCategory category : categoryList){
			System.out.println("category: ("+category.getCategoryId()+", "+category.getName()+")");
		}
		
		System.out.println("Add sample sc ience apps");
		for( int i=0; i<100; i++){
			String appName = appNameBase[i%10]+"_"+(i+1);
			String appVersion = "1.0." + (i%9);
			ServiceContext sc= null;
			try {
				sc = ServiceContextFactory.getInstance(ScienceApp.class.getName(), request);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ScienceApp app = null;
			try {
				app = ScienceAppLocalServiceUtil.createScienceApp(appName, appVersion, sc);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			app.setTitle(appTitleBase[i%7][0], Locale.KOREA);
			app.setTitle(appTitleBase[i%7][1], Locale.US);
			app.setTargetLanguage(targets[i%2]);
			app.setStage(stages[i%stages.length]);
			
			try {
				ScienceAppLocalServiceUtil.addScienceApp(app);
				AssetCategory category = categoryList.get(i%categoryCount);
				ScienceAppCategoryLinkLocalServiceUtil.addScienceAppCategory(category.getCategoryId(), app.getScienceAppId());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteAllSampleScienceApp(ActionRequest request, ActionResponse response){
		System.out.println("Just delete all science apps......");
		try {
			ScienceAppLocalServiceUtil.deleteAllScienceApps();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkScienceAppFinder(ActionRequest request, ActionResponse response){
		long vocabularyId = 23402;
		long categoryId = 23405;
		
		System.out.println("retrieveScienceAppsByVocabularyId(): "+ScienceAppLocalServiceUtil.retrieveScienceAppsByVocabularyId(vocabularyId).size());
		System.out.println("retrieveScienceAppsByCategoryId(): "+ScienceAppLocalServiceUtil.retrieveScienceAppsByCategoryId(categoryId).size());
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/****
	 * Retrieve all libraries installed
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void retrieveAllLibAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException {
//		List<CommonLibrary> clList = CommonLibraryServiceUtil.retrieveAllLibraries();
//		actionRequest.setAttribute("foundLibList", clList);
//		String jspFileName = Constants.SCIENCE_APP_MANAGER_AXIS+"lib_result.jsp";
//		actionResponse.setRenderParameter("jspPage", jspFileName);
    } 

	/****
	 * Retrieve libraries matching library name keyword
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void retrieveLibAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException {
//		String reqLibName = actionRequest.getParameter("reqLibName");
		String reqLibName = ParamUtil.getString(actionRequest, "reqLibName");
System.out.println("action request - received name: " + reqLibName);
//		List<CommonLibrary> clList = CommonLibraryServiceUtil.retrieveLibrary(reqLibName);
//		//actionRequest.setAttribute("foundLibList", clList);
//		//String paramCommonLibListStr = toPlainString(clList);
//		//actionRequest.setAttribute("foundLibList", paramCommonLibListStr);
//		actionRequest.setAttribute("foundLibList", clList);
//		String jspFileName = Constants.SCIENCE_APP_MANAGER_AXIS+"lib_result.jsp";
//		//String url = actionRequest.getContextPath()+jspFileName;
////System.out.println(url);
////		actionResponse.sendRedirect(url);
//		actionResponse.setRenderParameter("jspPage", jspFileName);
//		//actionResponse.setRenderParameter("jspPage", "/html/scienceappengine/lib_result.jsp");
//		//super.processAction(actionRequest, actionResponse);
    } 
	
	/****
	 * Retrieve all modules installed
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void retrieveAllModAction( 
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException {
//		List<CommonModule> cmList = CommonModuleServiceUtil.retrieveAllModules();
//		actionRequest.setAttribute("foundModList", cmList);
//		//String jspFileName = "/html/scienceappengine/mod_result.jsp";
//		String jspFileName = Constants.SCIENCE_APP_MANAGER_AXIS+"mod_result.jsp";
//		actionResponse.setRenderParameter("jspPage", jspFileName);
    } 
	
	/****
	 * Retrieve modules matching library name keyword
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void retrieveModAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException {
		String reqModName = ParamUtil.getString(actionRequest, "reqModName");
System.out.println("action request - received mod name: " + reqModName);
//		List<CommonModule> cmList = CommonModuleServiceUtil.retrieveInstalledModule(reqModName);
//		actionRequest.setAttribute("foundModList", cmList);
//		String jspFileName = Constants.SCIENCE_APP_MANAGER_AXIS+"mod_result.jsp";
//		actionResponse.setRenderParameter("jspPage", jspFileName);
    } 
	
	/****
	 * Retrieve all modules installed
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void retrieveAvailModAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException {
//		List<CommonModule> cmList = CommonModuleServiceUtil.retrieveAvailModules();
//		actionRequest.setAttribute("foundModList", cmList);
//		String jspFileName = Constants.SCIENCE_APP_MANAGER_AXIS+"mod_result.jsp";
//		actionResponse.setRenderParameter("jspPage", jspFileName);
    } 
	
	/****
	 * Load a selected modules 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void loadModAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException {
		String reqModName = ParamUtil.getString(actionRequest, "reqModName");
		System.out.println("action request - received mod name: " + reqModName);
//		String res = CommonModuleServiceUtil.loadModule(reqModName);
//		actionRequest.setAttribute("loadModRes", res);
//		String jspFileName = Constants.SCIENCE_APP_MANAGER_AXIS+"load_mod.jsp";
////		String jspFileName = "/html/scienceappengine/load_mod.jsp";
//		actionResponse.setRenderParameter("jspPage", jspFileName);
    } 
}
