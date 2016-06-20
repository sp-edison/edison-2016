package org.kisti.edison.content.portlet.content;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.content.model.AdvancedContent;
import org.kisti.edison.content.model.GeneralContent;
import org.kisti.edison.content.portlet.util.AdvancedFileUtil;
import org.kisti.edison.content.service.AdvancedContentLocalServiceUtil;
import org.kisti.edison.content.service.GeneralContentLocalServiceUtil;
import org.kisti.edison.content.service.persistence.AdvancedContentPK;
import org.kisti.edison.content.service.persistence.GeneralContentFinderUtil;
import org.kisti.edison.content.service.persistence.GeneralContentPK;
import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.exception.EdisonException;
import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.HtmlFormUtils;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class ContentListController {
	
	private static Log log = LogFactoryUtil.getLog(ContentListController.class);
	private String advancedFilePreFix = EdisonFileConstants.CONTENTS_ADVANCED;
	private String generalFilePreFix = EdisonFileConstants.CONTENTS_DEFAULT;
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
		try{

			String visitGroupId = "";
			String visitSite ="";
			long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();

			String tabViewYn = request.getPreferences().getValue("tabViewYn", "N");
			String tabUseStr = request.getPreferences().getValue("tabUseList", "");
			
			if(tabViewYn.equals("Y")){		
				
						
				//User Expando 값 가지고 오기
				if(themeDisplay.isSignedIn()){
					visitSite =  themeDisplay.getUser().getExpandoBridge().getAttribute(EdisonExpando.USER_VISIT_SITE).toString();
				}
				
				String groupName = "";
				int groupCnt = 0;
				String groupId = "";

				Map<String,Long> GroupMap = new HashMap<String,Long>();
				if(!tabUseStr.equals("")){
					String []tabUseArray = tabUseStr.split(",");
					for(int i=0;i<tabUseArray.length;i++){
						
						Long tabUserGroupId = Long.parseLong(CustomUtil.strNull(tabUseArray[i]));
						Group group = GroupLocalServiceUtil.getGroup(tabUserGroupId);
						GroupMap.put(group.getName(), group.getGroupId());
						
						if(groupCnt==0){
							groupName += group.getName();
							groupId += group.getGroupId();
							groupCnt++;
						}else{
							groupName += ","+group.getName();
							groupId += ","+group.getGroupId();
						}
						
						if(!visitSite.equals("")&&visitSite.equals(group.getName())){
							visitGroupId = String.valueOf(group.getGroupId());
							model.addAttribute("visitSite", Long.toString(group.getGroupId()));
						}
						
					}
				}
				model.addAttribute("tabNames", groupName);
				model.addAttribute("tabsValues", groupId);
				
				JSONObject json = new JSONObject();
				json.putAll(GroupMap);
				model.addAttribute("groupMap", json.toString());
				model.addAttribute("parentGroupId", parentGroupId);
				
			}else{
				//탭이 N인 경우
				model.addAttribute("visitSite", PortalUtil.getScopeGroupId(request));
				model.addAttribute("parentGroupId", parentGroupId);
			}
			
			
			//일반컨텐츠 수정 권한 확인
			if(themeDisplay.isSignedIn()){
				if(EdisonUserUtil.isPowerUserThan(themeDisplay.getUser())){
					model.addAttribute("addGeneralContentAuth", true);
				}else{
					if(EdisonUserUtil.isGroup(themeDisplay.getUser(), EdisonRoleConstants.TUTOR_GROUP)){
						model.addAttribute("addGeneralContentAuth", true);
					}else if(EdisonUserUtil.isGroup(themeDisplay.getUser(), EdisonRoleConstants.DEVELOPER_GROUP)){
						model.addAttribute("addGeneralContentAuth", true);
					}else if(EdisonUserUtil.isProjectThan(themeDisplay.getUser())){
						model.addAttribute("addGeneralContentAuth", true);
					}else{
						model.addAttribute("addGeneralContentAuth", false);
					}
				} 
			}else{
				model.addAttribute("addGeneralContentAuth", false);
			}
			
			model.addAttribute("tabViewYn",tabViewYn);
			model.addAttribute("tabUseStr",tabUseStr);
			
			//프로젝트 성과관리에서 링크로 연결될때 사용
			Map param = RequestUtil.getParameterMap(request);
			if(param != null && param.size() > 0){
				model.addAttribute("projectDetailView",param);
				model.addAttribute("visitSite", Long.parseLong(CustomUtil.strNull(param.get("groupId"), visitGroupId)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "content/contentList";
		
	}
	
	
	//탭 이벤트 저장
	@ResourceMapping(value ="cickTab")
	public void fileList(ResourceRequest request, ResourceResponse response){
		try{
			Map param = RequestUtil.getParameterMap(request);
			long groupId = ParamUtil.getLong(request, "groupId",0);
			if(groupId!=0){
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				Group group = GroupLocalServiceUtil.getGroup(groupId);
				themeDisplay.getUser().getExpandoBridge().setAttribute(EdisonExpando.USER_VISIT_SITE,group.getName());
			}
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 고급 콘텐츠 조회
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value ="retrieveListAdvanced")
	public void retrieveListAdvanced(ResourceRequest request, ResourceResponse response){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			Map param = RequestUtil.getParameterMap(request);
			
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId")));
			User user = null;
			
			boolean isSiteAdmin = false;
			if(themeDisplay.isSignedIn()){
				user = themeDisplay.getUser();
			}
			
			List<Map<String, Object>> returnList = AdvancedContentLocalServiceUtil.getAdvancedContentListByGroupId(groupId,user,themeDisplay.getLocale(),themeDisplay);
			
			JSONObject json = new JSONObject();
			json.put("dataList", returnList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 고급컨텐츠 CRUD 기능
	 * @param request
	 * @param response
	 * @param model
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws IOException 
	 * @throws SQLException 
	 */
	@ActionMapping(params="myaction=advancedModify")
	public void advancedModify(ActionRequest request, ActionResponse response, ModelMap model){
		UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);
		Map param = RequestUtil.getParameterMap(upload);
		String mode = CustomUtil.strNull(param.get("mode"));
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
		String portletNameSpace = CustomUtil.strNull(param.get("p_p_id"));
		Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId")));

		String contentFileZip = ".zip";
		try{
			if(mode.equals(Constants.ADD)){
				long contentSeq = CounterLocalServiceUtil.increment(AdvancedContent.class.getName());
				
				AdvancedContentPK advancedContentPK = new AdvancedContentPK(contentSeq, groupId);
				AdvancedContent advancedContent = AdvancedContentLocalServiceUtil.createAdvancedContent(advancedContentPK);
				
				advancedContent.setServiceLanguage(CustomUtil.strNull(param.get("select_languageId")));
				advancedContent.setTitle(CustomUtil.strNull(param.get("title")));
				advancedContent.setResume(CustomUtil.strNull(param.get("resume")));
				
				Group group = GroupLocalServiceUtil.getGroup(groupId);
				String contentFilePath = "/"+group.getName()+"/"+advancedContentPK.getContentSeq();
				advancedContent.setContentFilePath(contentFilePath);
				
				//콘텐츠 파일 등록
				String contentFileNm = AdvancedFileUtil.createFile(request, upload, contentFilePath, "contentFile");
				if((contentFileNm.toLowerCase()).contains(contentFileZip)){
					AdvancedFileUtil.unzipFile(request, upload, contentFilePath, "contentFile");
				}
				
				advancedContent.setContentFileNm(contentFileNm);
				advancedContent.setContentStartFileNm(CustomUtil.strNull(param.get("contentStartFileNm"),""));
				advancedContent.setInsertId(themeDisplay.getUser().getUserId());
				advancedContent.setInsertDate(new Date());
				
				EdisonFileUtil.insertEdisonFile(request, upload, themeDisplay.getUserId(), groupId, "", CustomUtil.strNull(String.valueOf(advancedContent.getContentSeq())), "addfile", advancedFilePreFix);
				
				AdvancedContentLocalServiceUtil.addAdvancedContent(advancedContent);
				SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
			}else{
				Long contentSeq = Long.parseLong(CustomUtil.strNull(param.get("contentSeq")));
				AdvancedContentPK advancedContentPK = new AdvancedContentPK(contentSeq, groupId);
				Group group = GroupLocalServiceUtil.getGroup(groupId);
				String contentFilePath = "/"+group.getName()+"/"+advancedContentPK.getContentSeq();
				
				if(mode.equals(Constants.UPDATE)){
					AdvancedContent advancedContent = AdvancedContentLocalServiceUtil.getAdvancedContent(advancedContentPK);
					advancedContent.setServiceLanguage(CustomUtil.strNull(param.get("select_languageId")));
					advancedContent.setTitle(CustomUtil.strNull(param.get("title")));
					advancedContent.setResume(CustomUtil.strNull(param.get("resume")));
					advancedContent.setContentStartFileNm(CustomUtil.strNull(param.get("contentStartFileNm"),""));
					advancedContent.setUpdateId(themeDisplay.getUser().getUserId());
					advancedContent.setUpdateDate(new Date());
					
					//File 삭제 - 콘텐츠 파일
					if(!CustomUtil.strNull(param.get("deleteAdvancedFile")).equals("")){
						String contentFile = advancedContent.getContentFileNm();
						AdvancedFileUtil.deleteFile(request, contentFilePath, contentFile);
						
						if(!contentFile.equals("")){
							if((contentFile.toLowerCase()).contains(contentFileZip) && (contentFile.toLowerCase()).split(contentFileZip).length > 0){
								AdvancedFileUtil.deleteAllFile(request, contentFilePath);
							}
						}
						
						String contentFileNm = AdvancedFileUtil.createFile(request, upload, contentFilePath, "contentFile");
						if((contentFileNm.toLowerCase()).contains(contentFileZip)){
							AdvancedFileUtil.unzipFile(request, upload, contentFilePath, "contentFile");
						}
						advancedContent.setContentFileNm(contentFileNm);
					}
					
					
					//File 삭제 - image 파일
					if(!CustomUtil.strNull(param.get("deleteFile")).equals("")){
						int deleteFile = Integer.parseInt(CustomUtil.strNull(param.get("deleteFile")));
						//파일삭제
						if(EdisonFileUtil.deleteSingleEdisonFile(deleteFile)){
							EdisonFileUtil.insertEdisonFile(request, upload, themeDisplay.getUserId(), groupId, "", CustomUtil.strNull(String.valueOf(advancedContent.getContentSeq())), "addfile", advancedFilePreFix);
						}
					}
					
					AdvancedContentLocalServiceUtil.updateAdvancedContent(advancedContent);
					SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
				}else if(mode.equals(Constants.DELETE)){
					AdvancedFileUtil.deleteAllFile(request, contentFilePath);
					
					AdvancedContentLocalServiceUtil.deleteAdvancedContent(advancedContentPK);
					
					EdisonFileUtil.deleteGroupEdisonFile(groupId, advancedFilePreFix, groupId+"_"+contentSeq);
					SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
				}
			}
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			if(mode.equals(Constants.ADD)){
				SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
			}else if(mode.equals(Constants.UPDATE)){
				SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
			}else if(mode.equals(Constants.DELETE)){
				SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
			}
			
		}
	}
	
	/**
	 * 고급컨텐츠 POPUP 페이지 OPEN
	 * @param request
	 * @param model
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@RenderMapping(params = "myaction=advancedModifyView")
	public String advancedModifyView(RenderRequest request, ModelMap model){
		try{
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId")));
			String mode = CustomUtil.strNull(param.get("mode"));
			
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			
			model.addAttribute("mode", mode);
			model.addAttribute("groupNm", group.getName());
			model.addAttribute("groupId", String.valueOf(group.getGroupId()));
			
			//서비스 언어 
			Locale[] availableLanguage = LanguageUtil.getAvailableLocales();
			model.addAttribute("ableLang", availableLanguage);
			
			String selectLang = themeDisplay.getLocale().toString();
			if(!mode.equals(Constants.ADD)){
				Long contentSeq = Long.parseLong(CustomUtil.strNull(param.get("contentSeq")));
				AdvancedContentPK advancedContentPK = new AdvancedContentPK(contentSeq, groupId);
				AdvancedContent advancedContent = AdvancedContentLocalServiceUtil.getAdvancedContent(advancedContentPK);
				
				List imgFileList = EdisonFileUtil.getListEdisonFile(groupId, "", CustomUtil.strNull(advancedContent.getContentSeq()) , advancedFilePreFix);
				List fileList = AdvancedFileUtil.getListFile(request, advancedContent.getContentFilePath(), advancedContent.getContentFileNm());
				
				selectLang = advancedContent.getServiceLanguage();
				model.addAttribute("advancedContent", advancedContent);
				model.addAttribute("imgFileList", imgFileList);
				model.addAttribute("fileList", fileList);
				model.addAttribute("contentSeq", String.valueOf(contentSeq));
			}
			model.addAttribute("select_languageId", CustomUtil.strNull(selectLang));
			return "content/advancedModify";
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
			return "";
		}
	}
	
	
	/**
	 * 일반컨텐츠 조회
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResourceMapping(value ="retrieveListGeneral")
	public void retrieveListGeneral(ResourceRequest request, ResourceResponse response){
		try{
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId")));
			Long contentDiv = ParamUtil.getLong(request, "contentDiv",0);
			String searchText = CustomUtil.strNull(param.get("searchText"));
			
			int currentPage = ParamUtil.get(request, "currentPage", 1);
			int listSize = ParamUtil.get(request, "searchLine", 5);
			int blockSize = 10;
			int start = ((currentPage - 1) * listSize);
			
			
			User user = null;
			if(themeDisplay.isSignedIn()){
				user = themeDisplay.getUser();
			}
			List<Map<String, Object>> dataList = GeneralContentLocalServiceUtil.getGeneralContentList(groupId, 
					themeDisplay.getCompanyId(), contentDiv, searchText, start, listSize*currentPage, user, themeDisplay.getLocale());
			
			int totalCount = GeneralContentLocalServiceUtil.getGeneralContentCountByGroupId(groupId, contentDiv, searchText,themeDisplay.getLocale());
			String portletNameSpace = themeDisplay.getPortletDisplay().getNamespace();
			String paging = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"generalContentPageSearch", totalCount,currentPage, listSize, blockSize);
		
			
			
			JSONObject json = new JSONObject();
			json.put("dataList", dataList);
			json.put("seq", totalCount - ((currentPage - 1)*listSize)); 
			json.put("paging", paging);
			json.put("contentDiv", contentDiv);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 일반 컨텐츠 CRUD
	 * @param request
	 * @param response
	 * @param model
	 * @throws SystemException
	 * @throws PortalException
	 * @throws SQLException
	 * @throws IOException
	 */
	@ActionMapping(params="myaction=generalModify")
	public void generalModify(ActionRequest request, ActionResponse response, ModelMap model){
		UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);
		Map param = RequestUtil.getParameterMap(upload);
		String mode = CustomUtil.strNull(param.get("mode"));
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
		String portletNameSpace = CustomUtil.strNull(param.get("p_p_id"));
		try{
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId")));
			Long contentDiv = Long.parseLong(CustomUtil.strNull(param.get("contentDiv")));

			long companyId = PortalUtil.getCompanyId(request);
			
			Role contentOwnerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_OWNER);		// Role Id 확인
			Role contentManagerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_MANAGER);		// Role Id 확인
			
			User user = themeDisplay.getUser();
			
			if(mode.equals(Constants.ADD)){
				long contentSeq = CounterLocalServiceUtil.increment(GeneralContent.class.getName());
				
				GeneralContentPK generalContentPK = new GeneralContentPK(contentSeq, groupId);
				generalContentPK.setContentSeq(contentSeq);
				GeneralContent generalContent = GeneralContentLocalServiceUtil.createGeneralContent(generalContentPK);
				
				generalContent.setContentDiv(contentDiv);
				String serviceLang = "";
				String[] serviceLangArray = CustomUtil.paramToArray(param.get("select_languageId"));
				if(serviceLangArray != null && serviceLangArray.length > 0){
					for(int i=0 ; i< serviceLangArray.length; i++){
						serviceLang += CustomUtil.strNull(serviceLangArray[i]) + ",";
					}
				}
				
				generalContent.setTitleMap(CustomUtil.getLocalizationNotSetLocaleMap(param, "title"));
				generalContent.setServiceLanguage(CustomUtil.strNull(serviceLang,"all,en_US,ko_KR,"));
				
				generalContent.setProjectYn("N");
				generalContent.setProjectId(0);
				generalContent.setInsertId(themeDisplay.getUser().getUserId());
				generalContent.setInsertDate(new Date());
				
				//파일등록
				if(upload.getFileNames("addfile")!=null){
					EdisonFileUtil.insertEdisonFile(request, upload, themeDisplay.getUserId(), groupId, "", CustomUtil.strNull(String.valueOf(generalContent.getContentSeq())), "addfile" , generalFilePreFix);
				}
				
				GeneralContentLocalServiceUtil.addGeneralContent(generalContent);
				
				//권한등록
				//CUSTOM 권한 테이블 등록
				UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(themeDisplay.getUser().getUserId(), groupId, contentOwnerRole.getRoleId(), contentSeq);	// OWNER CUSTOM ROLE 추가
				
				//SiteRole 추가
				User requestUser = UserLocalServiceUtil.fetchUser(themeDisplay.getUser().getUserId());
				EdisonUserUtil.addSiteRole(requestUser, groupId, EdisonRoleConstants.CONTENT_OWNER);	// SOLVER OWNER 권한 추가
				
				SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
			}else{
				Long contentSeq = Long.parseLong(CustomUtil.strNull(param.get("contentSeq")));
				GeneralContentPK generalContentPK = new GeneralContentPK(contentSeq, groupId);
				generalContentPK.setContentSeq(contentSeq);
				
				if(mode.equals(Constants.UPDATE)){
					GeneralContent generalContent = GeneralContentLocalServiceUtil.getGeneralContent(generalContentPK);
					generalContent.setContentDiv(contentDiv);
					generalContent.setTitleMap(CustomUtil.getLocalizationMap(param, "title"));
					
					String serviceLang = "";
					String[] serviceLangArray = CustomUtil.paramToArray(param.get("select_languageId"));
					if(serviceLangArray != null && serviceLangArray.length > 0){
						for(int i=0 ; i< serviceLangArray.length; i++){
							serviceLang += CustomUtil.strNull(serviceLangArray[i]) + ",";
						}
					}
					generalContent.setServiceLanguage(CustomUtil.strNull(serviceLang,"all,en_US,ko_KR,"));
					generalContent.setProjectYn("N");
					generalContent.setProjectId(0);
					generalContent.setUpdateId(themeDisplay.getUser().getUserId());
					generalContent.setUpdateDate(new Date());
					
					GeneralContentLocalServiceUtil.updateGeneralContent(generalContent);
					
					//파일등록
					if(upload.getFileNames("addfile")!=null){
						EdisonFileUtil.insertEdisonFile(request, upload, themeDisplay.getUserId(), groupId, "", CustomUtil.strNull(String.valueOf(generalContent.getContentSeq())), "addfile" ,generalFilePreFix);
					}
					SessionMessages.add(request, EdisonMessageConstants.UPDATE_SUCCESS);
				}else if(mode.equals(Constants.DELETE)){
					//콘텐츠에대한 권한삭제
					//CUSTOM 권한 테이블 삭제
					GeneralContent generalContent = GeneralContentLocalServiceUtil.getGeneralContent(generalContentPK);
					
					//owner
					User owner = UserLocalServiceUtil.fetchUser(generalContent.getInsertId());
					
					UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom( generalContent.getInsertId(), groupId, contentOwnerRole.getRoleId(), contentSeq);
					if(!EdisonUserUtil.isRegularRole(owner, EdisonRoleConstants.ADMINISTRATOR)&&!EdisonUserUtil.isSiteRole(owner, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
						List<Long> contentOwnerCustomRoleList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(owner.getUserId(), groupId, contentOwnerRole.getRoleId());
						
						//솔버 OWNER 권한이 없을 경우 사이트 CONTENT_OWNER 권한 삭제
						if(contentOwnerCustomRoleList==null){
							EdisonUserUtil.deleteSiteRole(owner, groupId, EdisonRoleConstants.CONTENT_OWNER);
						}
					}
					
					//Administrator, Site Administrator 가 아닐경우
					//솔버권한 확인 후 GROUP, SiteRole 삭제
					
					long managerId = Long.parseLong(CustomUtil.strNull(param.get("nowMgrId"),"0"));
					if(managerId != 0){
						User manager = UserLocalServiceUtil.fetchUser(managerId);
						UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom( managerId, groupId, contentManagerRole.getRoleId(), contentSeq);
						//manager
						if(!EdisonUserUtil.isRegularRole(manager, EdisonRoleConstants.ADMINISTRATOR)&&!EdisonUserUtil.isSiteRole(manager, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
							List<Long> contentManagerCustomRoleList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(manager.getUserId(), groupId, contentManagerRole.getRoleId());
							
							//솔버 MANAGER 권한이 없을 경우 사이트 CONTENT_MANAGER 권한 삭제
							if(contentManagerCustomRoleList==null){
								EdisonUserUtil.deleteSiteRole(manager, groupId, EdisonRoleConstants.CONTENT_MANAGER);
							}
						}
					}

					GeneralContentLocalServiceUtil.deleteGeneralContent(generalContentPK);
					 
					EdisonFileUtil.deleteGroupEdisonFile(groupId, generalFilePreFix, groupId+"_"+contentSeq);
					SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
					
				}
			}
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
			
			
			//Session Error Message
			if(mode.equals(Constants.ADD)){
				SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
			}else if(mode.equals(Constants.UPDATE)){
				SessionErrors.add(request, EdisonMessageConstants.UPDATE_ERROR);
			}else if(mode.equals(Constants.DELETE)){
				SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
			}
		}
	}
	
	/**
	 * 일반 콘텐츠 POPUP OPEN
	 * @param request
	 * @param model
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@RenderMapping(params = "myaction=generalModifyView")
	public String defaultModifyView(RenderRequest request, ModelMap model){
		try{
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			
			long companyId = PortalUtil.getCompanyId(request);
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId")));
			String mode = CustomUtil.strNull(param.get("mode"));
			
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			
			model.addAttribute("mode", mode);
			model.addAttribute("groupNm", group.getName());
			model.addAttribute("groupId", String.valueOf(group.getGroupId()));
			
			User user = PortalUtil.getUser(request);
			model.addAttribute("userScreenName", user.getScreenName());

			//서비스 언어 
			Locale[] availableLanguage = LanguageUtil.getAvailableLocales();
			model.addAttribute("ableLang", availableLanguage);
			
			//공통코드
			List<Map<String, String>> codeList = EdisonExpndoUtil.getCodeListByUpCode("2001", themeDisplay.getLocale());

			
			if(!mode.equals(Constants.ADD)){
				Long contentSeq = Long.parseLong(CustomUtil.strNull(param.get("contentSeq")));
				Long contentDiv = Long.parseLong(CustomUtil.strNull(param.get("contentDiv")));
				
				GeneralContentPK generalContentPK = new GeneralContentPK(contentSeq, groupId);
				generalContentPK.setContentSeq(contentSeq);
				//Map<String, Object> generalContentTest = GeneralContentLocalServiceUtil.getGeneralContent(groupId, contentSeq, user, themeDisplay.getLocale());
				GeneralContent generalContent = GeneralContentLocalServiceUtil.getGeneralContent(generalContentPK);
				if(generalContent != null){
					User contentUser = UserLocalServiceUtil.getUserById(generalContent.getInsertId());
					model.addAttribute("insertNm", contentUser.getScreenName());
				}
				
				List fileList = EdisonFileUtil.getListEdisonFile( groupId, "", contentSeq+"", generalFilePreFix);

				
				model.addAttribute("generalContent", generalContent);
				model.addAttribute("fileList", fileList);
				model.addAttribute("contentSeq", String.valueOf(contentSeq));
				model.addAttribute("contentDiv", String.valueOf(contentDiv));
				String codeOption = HtmlFormUtils.makeCombo(codeList, String.valueOf(contentDiv));
				model.addAttribute("codeOption", String.valueOf(codeOption));

				Role managerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_MANAGER);
				
				//manager List
				List<Map<String, String>> contenManagerList = UserGroupRoleCustomLocalServiceUtil.getUserList(groupId, managerRole.getRoleId(), contentSeq);
				model.addAttribute("contenManagerList", contenManagerList);
				
				//접속한사람이 owner인지 검사
				Role contentOwnerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_OWNER);
				Boolean isOwner = true;
				if(!EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR)&&!EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
					isOwner = false;
					isOwner = UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, contentOwnerRole.getRoleId(), contentSeq);
				}
					
				model.addAttribute("isOwner", isOwner);
				
			}else{
				long contentSeq = Long.parseLong(CustomUtil.strNull(param.get("contentSeq"),"0"));
				String codeOption = HtmlFormUtils.makeCombo(codeList, null);
				model.addAttribute("codeOption", String.valueOf(codeOption));
			}
			
			return "content/generalModify";
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
			SessionErrors.add(request, EdisonMessageConstants.EVENT_ERROR);
			return "";
		}
	}
	
	/**
	 * 일반 콘텐츠 파일 다운로드 POPUP OPEN
	 * @param request
	 * @param model
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@RenderMapping(params = "myaction=generalFileDownload")
	public String defaultModifyFileListView(RenderRequest request, ModelMap model){
		try {
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"),"0"));
			String contentSeq = CustomUtil.strNull(param.get("contentSeq"),"0");
			String contentDiv = CustomUtil.strNull(param.get("contentDiv"),"0");
			
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			
			model.addAttribute("groupNm", group.getName());
			model.addAttribute("groupId", String.valueOf(group.getGroupId()));
			
			List resultFileList = EdisonFileUtil.getListEdisonFile(groupId, "", contentSeq, generalFilePreFix);
			
			model.addAttribute("resultFileList", resultFileList);
			return "content/generalFileList";
		} catch (Exception e) {
			return "";
		}
	}
	
	
	@ResourceMapping(value="retrieveGeneralFileList")
	public void retrieveGeneralFileList(ResourceRequest request, ResourceResponse response){
		
		try {
		
			Map param = RequestUtil.getParameterMap(request);
			
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"),"0"));
			String contentSeq = CustomUtil.strNull(param.get("contentSeq"),"0");
			String contentDiv = CustomUtil.strNull(param.get("contentDiv"),"0");
			
			List resultFileList = EdisonFileUtil.getListEdisonFile(groupId, "", contentSeq, generalFilePreFix);
		
			JSONObject obj = new JSONObject();
			
			obj.put("fileList", resultFileList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/**
	 * 일반 컨텐츠 등록 파일 삭제
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortalException
	 * @throws SystemException
	 */
	@ResourceMapping(value="deleteSingleEdisonFile")
	public void deleteSingleEdisonFile(ResourceRequest request, ResourceResponse response){
		try{
			Map params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			
			long fileEntryId = Long.parseLong(CustomUtil.strNull(params.get("fileEntryId")));
			long contentDiv = Long.parseLong(CustomUtil.strNull(params.get("contentDiv")));
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("groupId")));
			String contentSeq = CustomUtil.strNull(params.get("contentSeq"));
			
			String resultMsg = "";
			List fileList = new ArrayList();
			
			if(EdisonFileUtil.deleteSingleEdisonFile(fileEntryId)){
				resultMsg = "SUCCESS";
			}else{
				resultMsg = "DELETE_FAIL";
			}

			fileList = EdisonFileUtil.getListEdisonFile( groupId, "", String.valueOf(contentSeq), generalFilePreFix);
			
			JSONObject obj = new JSONObject();
			
			obj.put("fileList", fileList);
			obj.put("resultMsg", resultMsg);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 고급컨텐츠 조회수 UPDATE
	 * @param request
	 * @param response
	 */
	@ResourceMapping(value="advancedContentViewCount")
	public void advancedContentViewCount(ResourceRequest request, ResourceResponse response){
		try{
			Map param = RequestUtil.getParameterMap(request);
			
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId")));
			Long contentSeq = Long.parseLong(CustomUtil.strNull(param.get("contentSeq")));
			
			AdvancedContentPK advancedContentPK = new AdvancedContentPK(contentSeq, groupId);
			AdvancedContent advancedContent = AdvancedContentLocalServiceUtil.getAdvancedContent(advancedContentPK);
			
			Long viewCnt = advancedContent.getViewCnt()+1;
			advancedContent.setViewCnt(viewCnt);
			
			AdvancedContentLocalServiceUtil.updateAdvancedContent(advancedContent);
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 일반 콘텐츠 다운로드 수 UPDATE
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value="edisonFileCountDownload")
	public void edisonFileCountDownload(ResourceRequest request, ResourceResponse response){
		try{
			Map param = RequestUtil.getParameterMap(request);
			
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId")));
			Long contentDiv = Long.parseLong(CustomUtil.strNull(param.get("contentDiv")));
			Long contentSeq = Long.parseLong(CustomUtil.strNull(param.get("contentSeq")));
			
			GeneralContentPK generalContentPK = new GeneralContentPK(contentSeq, groupId);
			generalContentPK.setContentSeq(contentSeq);
			GeneralContent generalContent = GeneralContentLocalServiceUtil.getGeneralContent(generalContentPK);
			
			Long downloadCnt = generalContent.getDownloadCnt()+1;
			generalContent.setDownloadCnt(downloadCnt);
			
			GeneralContentLocalServiceUtil.updateGeneralContent(generalContent);
			
			JSONObject obj = new JSONObject();
			obj.put("downloadCnt", downloadCnt);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 일반 컨텐츠 다운로드
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@ResourceMapping(value="edisonFileDownload")
	public void edisonFileDownload(ResourceRequest request, ResourceResponse response){
		try{
			Map paramsMap = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long fileEntryId = Long.parseLong(CustomUtil.strNull(paramsMap.get("fileEntryId")));
			EdisonFileUtil.edisonFileDownload(response, fileEntryId);
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 입력 권한 체크
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResourceMapping(value="contentAuthCheck")
	public void contentAuthCheck(ResourceRequest request, ResourceResponse response){
		try{
			Map paramsMap = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Long groupId = Long.parseLong(CustomUtil.strNull(paramsMap.get("groupId")));
			String mode = CustomUtil.strNull(paramsMap.get("mode"));
			
			User user = themeDisplay.getUser();
			String contentCheckAuth = "FALSE";
			

			if(mode.equals("advanced")){
				if(EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
					contentCheckAuth = "TRUE";
				}
			}else{
				if(EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
					contentCheckAuth = "TRUE";
				}else{
					if(EdisonUserUtil.isSiteTutorThan(user,groupId)){
						contentCheckAuth = "TRUE";
					}else if(EdisonUserUtil.isSiteDeveloperThan(user,groupId)){
						contentCheckAuth = "TRUE";
					}else if(EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.CONTENT_OWNER)
							||EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.CONTENT_MANAGER)){
						contentCheckAuth = "TRUE";
					}else if(EdisonUserUtil.isProjectThan(user)){
						contentCheckAuth = "TRUE";
					}
				}
			}
			
			JSONObject obj = new JSONObject();
			obj.put("contentCheckAuth", contentCheckAuth);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}

	/**
	 * 사용자 정보 검색
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResourceMapping(value="contentUserInfo")
	public void getContentUserInfo(ResourceRequest request, ResourceResponse response){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Map params = RequestUtil.getParameterMap(request);
			
			String type = CustomUtil.strNull(params.get("type"));
			
			String newName = "";
			String pastName = "";
			if(type.equals("owner")){
				newName = CustomUtil.strNull(params.get("newOwnerName"),"0");
				pastName = CustomUtil.strNull(params.get("nowOwnerName"),"0");
			}else if(type.equals("manager")){
				newName = CustomUtil.strNull(params.get("newMgrName"),"0");
				pastName = CustomUtil.strNull(params.get("nowMgrName"),"0");
			}
			
			Long groupId = Long.parseLong(CustomUtil.strNull(params.get("groupId")));
			long companyId = PortalUtil.getCompanyId(request);
			String contentSeq = CustomUtil.strNull(params.get("contentSeq"),"0");
			
			User preUser = null;
			if(!pastName.equals("0")){
				preUser = UserLocalServiceUtil.getUserByScreenName(companyId, pastName);
			}
			User user = UserLocalServiceUtil.fetchUserByScreenName(companyId, newName);
			
			JSONObject obj = new JSONObject();
			Map<String, String> contentUserInfo = null;
			
			if (user == null) {
				obj.put("result", "none");
			} else {
				if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR)
						|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)
						||EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_MEMBER)){
					Role ownerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.CONTENT_OWNER);			// Owner Role Id 확인
					Role managerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.CONTENT_MANAGER);		// Manager Role Id 확인
					                           
					PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
					PermissionThreadLocal.setPermissionChecker(checker);
					
					if(type.equals("manager")){
						/*if (EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR)
								|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)
								|| EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_OWNER)) {
							obj.put("result", "admin");
						}else */if (UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, ownerRole.getRoleId(), Long.parseLong(contentSeq))) {	// Owner 체크
							obj.put("result", "owner");
						} else if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, managerRole.getRoleId(), Long.parseLong(contentSeq))) {	// Manager 체크
							obj.put("result", "manager");
						}
						else {
							contentUserInfo = new HashMap<String, String>();
							
							String pastMgrId="";
							if(preUser!=null && !pastName.equals("0")){
								pastMgrId = String.valueOf(preUser.getUserId());
							}
							contentUserInfo.put("pastMgrId", pastMgrId);
							contentUserInfo.put("userId", String.valueOf(user.getUserId()));
							contentUserInfo.put("userScreenName", user.getScreenName());
							contentUserInfo.put("userFullName", user.getFullName());
							contentUserInfo.put("userFirstName", user.getFirstName());
							contentUserInfo.put("userEmailAddress", user.getEmailAddress());
							contentUserInfo.put("userJobTitle", user.getJobTitle());
							
							obj.put("contentUserInfo", contentUserInfo);
							obj.put("result", "user");
						}
					}else if(type.equals("owner")){
						contentUserInfo = new HashMap<String, String>();
						
						contentUserInfo.put("pastOnwerId", String.valueOf(preUser.getUserId()));
						contentUserInfo.put("userId", String.valueOf(user.getUserId()));
						contentUserInfo.put("userScreenName", user.getScreenName());
						contentUserInfo.put("userFullName", user.getFullName());
						contentUserInfo.put("userFirstName", user.getFirstName());
						contentUserInfo.put("userEmailAddress", user.getEmailAddress());
						contentUserInfo.put("userJobTitle", user.getJobTitle());
						
						obj.put("contentUserInfo", contentUserInfo);
						obj.put("result", "user");
	
						if(contentUserInfo!=null){
							boolean projectYn = EdisonUserUtil.isProjectThan(user);
							obj.put("projectUser", projectYn);
						}
					}
				
				}else{
					obj.put("result","not siteMember");
				}
			}
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());	
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Content Owner Update
	 */
	@ResourceMapping(value="updateContentOwner")
	public void updateContentOwner(ResourceRequest request, ResourceResponse response){
		//content, auth 테이블 update
		try {
			Map params = RequestUtil.getParameterMap(request);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			long companyId = PortalUtil.getCompanyId(request);
			Long groupId = Long.parseLong(CustomUtil.strNull(params.get("groupId"), CustomUtil.strNull(PortalUtil.getScopeGroupId(request),"0")));
			
			long contentSeq =  Long.parseLong(CustomUtil.strNull(params.get("contentSeq"),"0"));
			long pastName = Long.parseLong(CustomUtil.strNull(params.get("pastOnwerId"),"0"));
			long newId = Long.parseLong(CustomUtil.strNull(params.get("ownerUserId"),"0"));
			String newName = CustomUtil.strNull(params.get("ownerUserName"));
			
			User requestUser = UserLocalServiceUtil.fetchUser(newId);
			
			
			if(requestUser != null){
				String projectYn = CustomUtil.strNull(params.get("projectYn"));
				
				//insertId, projectId update
				GeneralContentLocalServiceUtil.updateContentInsertId(groupId, contentSeq, newId, projectYn, 0);
				
				
				Role contentOwnerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_OWNER);		// Role Id 확인
				Role contentManagerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_MANAGER);		// CONTENT_MANAGER Role Id 확인
				
				//권한 등록
				//CUSTOM 권한 테이블 등록
				UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(newId, groupId, contentOwnerRole.getRoleId(), contentSeq);	// SOLVER OWNER CUSTOM ROLE 추가
				
				//SiteRole 추가
				EdisonUserUtil.addSiteRole(requestUser, groupId, EdisonRoleConstants.CONTENT_OWNER);	// SOLVER OWNER 권한 추가
				
				//기존 OWNER 권한 삭제
				//CUSTOM 권한 테이블 삭제
				UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(pastName, groupId, contentOwnerRole.getRoleId(), contentSeq);
				
				//Administrator, Site Administrator 가 아닐경우
				//권한 확인 후 GROUP, SiteRole 삭제
				User preUser = UserLocalServiceUtil.fetchUser(pastName);
				if(preUser!=null){
					if(!EdisonUserUtil.isRegularRole(preUser, EdisonRoleConstants.ADMINISTRATOR)&&!EdisonUserUtil.isSiteRole(preUser, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
						List<Long> contentOwnerCustomRoleList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(preUser.getUserId(), groupId, contentOwnerRole.getRoleId());
						List<Long> contentManagerCustomRoleList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(preUser.getUserId(), groupId, contentManagerRole.getRoleId());
						
						//솔버 OWNER 권한이 없을 경우 사이트 CONTENT_OWNER 권한 삭제
						if(contentOwnerCustomRoleList==null){
							EdisonUserUtil.deleteSiteRole(preUser, groupId, EdisonRoleConstants.CONTENT_OWNER);
						}
						
						//솔버 MANAGER 권한이 없을 경우 사이트 CONTENT_MANAGER 권한 삭제
						if(contentManagerCustomRoleList==null){
							EdisonUserUtil.deleteSiteRole(preUser, groupId, EdisonRoleConstants.CONTENT_MANAGER);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}
	
	/* content manager Update*/
	@ResourceMapping(value="updateContentManager")
	public void updateContentManager(ResourceRequest request, ResourceResponse response){
		try {
			Map params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId = PortalUtil.getCompanyId(request);
			Long groupId = Long.parseLong(CustomUtil.strNull(params.get("groupId"), CustomUtil.strNull(PortalUtil.getScopeGroupId(request),"0")));
			
			long contentSeq =  Long.parseLong(CustomUtil.strNull(params.get("contentSeq"),"0"));
			long newId = Long.parseLong(CustomUtil.strNull(params.get("managerUserId"),"0"));
			long pastName = Long.parseLong(CustomUtil.strNull(params.get("pastManagerId"),"0"));
			
			
			User requestUser = UserLocalServiceUtil.fetchUser(newId);
			if(requestUser != null){
				Role contentManagerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_MANAGER);		// Role Id 확인
				
				List<Map<String, String>> contentManagerList = UserGroupRoleCustomLocalServiceUtil.getUserList(groupId, contentManagerRole.getRoleId(), contentSeq);
				//content MANAGER add
				//MANAGER가 없을때
				if (contentManagerList == null && pastName == 0) {
					//SiteRole 추가
					Boolean addSiteRoleManager  = EdisonUserUtil.addSiteRole(requestUser, groupId, EdisonRoleConstants.CONTENT_MANAGER);	
					
					//CUSTOM 권한 테이블 등록
					UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(newId, groupId, contentManagerRole.getRoleId(), contentSeq);	
				}else{
					//content manager update
					//기존 MANAGER가 있을때
					//새로운 MANAGER 권한 등록
					 
					//SiteRole 추가
					Boolean addSiteRoleManager = EdisonUserUtil.addSiteRole(requestUser, groupId, EdisonRoleConstants.CONTENT_MANAGER);
					
					//CUSTOM 권한 테이블 등록
					UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(newId, groupId, contentManagerRole.getRoleId(), contentSeq);	
					
					//기존 OWNER 권한 삭제
					//CUSTOM 권한 테이블 삭제
					UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(pastName, groupId, contentManagerRole.getRoleId(), contentSeq);
					
					List<Map<String,String>> customList =  UserGroupRoleCustomLocalServiceUtil.getCustomList(pastName, groupId, contentManagerRole.getRoleId());
	
					User preUser = UserLocalServiceUtil.fetchUser(pastName);
					if(preUser != null){
						if (customList == null || customList.size() == 0) {	// CONTENT_MANAGER CUSTOM ROLE이 남아있는지 체크
							EdisonUserUtil.deleteSiteRole(preUser, groupId, EdisonRoleConstants.CONTENT_MANAGER);	// 없으면 삭제
						}
						
					}
				}
			}
			
		}catch (Exception e) {
			if(e instanceof EdisonException){
				System.out.println("EDISON  ERROR");
			}else{
				e.printStackTrace();
			}
		}
	}
	
	/* content manager delete*/
	@ResourceMapping(value="deleteContentManager")
	public void deleteContentManager(ResourceRequest request, ResourceResponse response){
		try {
			Map params = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId = PortalUtil.getCompanyId(request);
			Long groupId = Long.parseLong(CustomUtil.strNull(params.get("groupId"), CustomUtil.strNull(PortalUtil.getScopeGroupId(request),"0")));
			
			long contentSeq =  Long.parseLong(CustomUtil.strNull(params.get("contentSeq"),"0"));
			long managerId = Long.parseLong(CustomUtil.strNull(params.get("managerUserId"),"0"));
			
			User user = UserLocalServiceUtil.fetchUser(managerId);
			
			Role contentManagerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_MANAGER);		// Role Id 확인
			
			List<Map<String, String>> contentManagerList = UserGroupRoleCustomLocalServiceUtil.getUserList(groupId, contentManagerRole.getRoleId(), contentSeq);
			if (contentManagerList != null){
				//content manager delete
				
				//CUSTOM 권한 테이블 삭제
				UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(managerId, groupId, contentManagerRole.getRoleId(), contentSeq);
				
				List<Map<String,String>> customList =  UserGroupRoleCustomLocalServiceUtil.getCustomList(managerId, groupId, contentManagerRole.getRoleId());

				if (customList == null || customList.size() == 0) {	// CONTENT_MANAGER CUSTOM ROLE이 남아있는지 체크
					EdisonUserUtil.deleteSiteRole(user, groupId, EdisonRoleConstants.CONTENT_MANAGER);	// 없으면 삭제
				}
			}
		}catch (Exception e) {
			if(e instanceof EdisonException){
				System.out.println("EDISON  ERROR");
			}else{
				e.printStackTrace();
			}
		}
	}
}
