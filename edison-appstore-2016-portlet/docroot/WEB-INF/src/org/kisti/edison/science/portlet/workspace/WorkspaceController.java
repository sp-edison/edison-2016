package org.kisti.edison.science.portlet.workspace;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kisti.edison.exception.EdisonException;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.science.model.DeveloperInfo;
import org.kisti.edison.science.service.DeveloperInfoLocalServiceUtil;
import org.kisti.edison.science.service.DeveloperIpLocalServiceUtil;
import org.kisti.edison.science.service.DeveloperRequestLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonEmailSenderUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.HtmlFormUtils;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("VIEW")
public class WorkspaceController {
	
	private static Log log = LogFactory.getLog(WorkspaceController.class);

	private String filePreFix = EdisonFileConstants.WORKSPACE;
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model) throws SystemException, IOException, PortalException, SQLException{
		Map params = RequestUtil.getParameterMap(request);	
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = PortalUtil.getScopeGroupId(request);
		params.put("groupId", groupId);
		
		User user = PortalUtil.getUser(request);
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("userId", String.valueOf(user.getUserId()));
		userMap.put("screenName", user.getScreenName());
		userMap.put("name", user.getFirstName());
		userMap.put("emailAddress", user.getEmailAddress());

		String university = (String) user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY);
		String field = EdisonExpando.CDNM;
		String universityNm = EdisonExpndoUtil.getCommonCdSearchFieldValue(university, field, themeDisplay.getLocale());
		userMap.put("universityFieldNm", universityNm);
		userMap.put("majorField", CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR)));
		
		Portlet portlet = PortletLocalServiceUtil.getPortletById( PortalUtil.getCompanyId(request),  PortalUtil.getPortletId(request));	
		
//		List statusList = EdisonExpndoUtil.getCommonCdList("1202");
		List statusList = EdisonExpndoUtil.getCodeListByUpCode("1202", themeDisplay.getLocale());
		
		String selectStatus = GetterUtil.get(CustomUtil.strNull(params.get("selectStatus")), "");
		
		String statusOptionStr = HtmlFormUtils.makeCombo(statusList, selectStatus);
		params.put("userId", String.valueOf(user.getUserId()));
		
		model.addAttribute("statusOptionStr",	statusOptionStr);
		model.addAttribute("userMap",	userMap);
		
		if(EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR) || EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR)){				
			String groupName = GetterUtil.get(CustomUtil.strNull(params.get("groupName")), "");
			if(groupName != null & !groupName.equals("")) {
				model.addAttribute("groupName", groupName);
			}
			
			boolean copyParam = GetterUtil.getBoolean(params.get("edionCopyParam"));
			if(copyParam){
				model.addAttribute("params", params);
			}
			
			return "workspace/workspaceAdmin";
		}else{
			Map delevoperMap = DeveloperInfoLocalServiceUtil.getCustomDeveloperInfo(params, themeDisplay.getLocale());
			List ipList = DeveloperIpLocalServiceUtil.getListCustomDeveloperIp(params);
			
			if(delevoperMap != null){
//				statusList = EdisonExpndoUtil.getCommonCdList("1203");
				statusList = EdisonExpndoUtil.getCodeListByUpCode("1203", themeDisplay.getLocale());
				List requestList = DeveloperRequestLocalServiceUtil.getListCustomDeveloperRequest(params, themeDisplay.getLocale());
				String requestSortStr = HtmlFormUtils.makeCombo(statusList, CustomUtil.strNull(delevoperMap.get("requestStatus")));	// 공통 코드
				
				model.addAttribute("delevoperMap", 		delevoperMap);
				model.addAttribute("ipList", 		ipList);
				model.addAttribute("requestList", 		requestList);
				model.addAttribute("requestSortStr", 		requestSortStr);
				
				try{
					//접속방법 매뉴얼 파일 가지고 오기
					DLFolder folder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, "WORKSPACE_MANUAL");
					List<DLFileEntry> dfeList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folder.getFolderId());
					List fileList = new ArrayList();
					
					if(dfeList != null && dfeList.size() > 0){
						Map urlMap = null;
						for(int f=0;f < dfeList.size();f++){
							DLFileEntry dfe = dfeList.get(f);					
							urlMap = new HashMap();
							urlMap.put("fileEntryId", String.valueOf(dfe.getFileEntryId()));
							urlMap.put("fileRepositoryId", String.valueOf(dfe.getRepositoryId()));
							urlMap.put("fileUuid", String.valueOf(dfe.getUuid()));
							urlMap.put("fileTitle", dfe.getTitle());
							urlMap.put("fileUserId", String.valueOf(dfe.getUserId()));
							urlMap.put("fileExtension", String.valueOf(dfe.getExtension()));
							fileList.add(urlMap);					
						}
						model.addAttribute("manualFileList",fileList);
					}
				}catch (  NoSuchFolderException nsfe) {
					log.error(nsfe.toString());
				} 
				
      
				return "workspace/workspaceView";
			}else{
				//보안서약서 파일 가지고 오기
				DLFolder folder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, "WORKSPACE_SECURITY");
				List<DLFileEntry> dfeList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folder.getFolderId());
				List fileList = new ArrayList();
				if(dfeList != null && dfeList.size() > 0){
					Map urlMap = null;
					for(int f=0;f < dfeList.size();f++){
						DLFileEntry dfe = dfeList.get(f);					
						urlMap = new HashMap();
						urlMap.put("fileEntryId", String.valueOf(dfe.getFileEntryId()));
						urlMap.put("fileRepositoryId", String.valueOf(dfe.getRepositoryId()));
						urlMap.put("fileUuid", String.valueOf(dfe.getUuid()));
						urlMap.put("fileTitle", dfe.getTitle());
						urlMap.put("fileUserId", String.valueOf(dfe.getUserId()));
						urlMap.put("fileExtension", String.valueOf(dfe.getExtension()));
						fileList.add(urlMap);					
					}
					model.addAttribute("securityFileList",fileList);
				}
				return "workspace/workspaceRequest";
			}
			
		}
	}

	@Transactional
	@ResourceMapping(value="workspaceRequest")
	public void workspaceRequest(ResourceRequest request, ResourceResponse response)  throws PortalException, SystemException, MalformedURLException, IOException, SQLException{

		String resultCode = "200";
		Map params = RequestUtil.getParameterMap(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		params.put("groupId", groupId);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		User user = PortalUtil.getUser(request);
		PrintWriter writer = response.getWriter();
				
		Map<String, Object> requestParams = new HashMap <String, Object>(); 
		
		requestParams.put("userId", String.valueOf(user.getUserId()));
		requestParams.put("requestSort", CustomUtil.strNull(params.get("developerSort")));
		requestParams.put("requestNote", CustomUtil.strNull(params.get("rem")));
		requestParams.put("requestStatus", "1202001");
		requestParams.put("insertId", String.valueOf(user.getUserId()));
		

		DeveloperInfoLocalServiceUtil.insertCustomDeveloperInfo(params);
		
		if(params.get("ip1") instanceof String[] ){
			String[] ip1 = (String[]) params.get("ip1");
			String[] ip2 = (String[]) params.get("ip2");
			String[] ip3 = (String[]) params.get("ip3");
			String[] ip4 = (String[]) params.get("ip4");
			
			for(int i=0; i < ip1.length ; i++){
				Map ipMap = new HashMap();
				ipMap.putAll(params);
				ipMap.put("ip1", ip1[i]);
				ipMap.put("ip2", ip2[i]);
				ipMap.put("ip3", ip3[i]);
				ipMap.put("ip4", ip4[i]);
				DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(ipMap);	
			}
		}else{
			DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(params);
		}
		
		DeveloperRequestLocalServiceUtil.insertCustomDeveloperRequest(requestParams);

		writer.write(resultCode);
		
	}
	
	@ActionMapping(params="myaction=workspaceRequest")
	public void workspaceRequest(ActionRequest request, ActionResponse response, ModelMap model) throws PortalException, SystemException, PortletModeException, WindowStateException, IOException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		User user = PortalUtil.getUser(request);
		long groupId = PortalUtil.getScopeGroupId(request);
  
		if(EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_MEMBER)){

			UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);	
			Map<String, Object> params = RequestUtil.getParameterMap(upload);
			
			
			
	//		String field = EdisonExpando.CDNM+"_"+themeDisplay.getLocale();
	//		String universityNm = EdisonExpndoUtil.getCommonCdSearchFieldValue(university, field);
	
			params.put("userId", String.valueOf(user.getUserId()));
			params.put("groupId", groupId);
			params.put("screenName", user.getScreenName());
			params.put("emailAddress", user.getEmailAddress());
			String university = (String) user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY);
			params.put("universityField", university);
			String major = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR);
			params.put("majorField", major);
			params.put("firstName", user.getFirstName());
			
			
			DeveloperInfo developerInfo = DeveloperInfoLocalServiceUtil.insertCustomDeveloperInfo(params);
			
			
			
			Map requestParams = new HashMap(); 
			requestParams.put("userId", String.valueOf(user.getUserId()));
			requestParams.put("requestSort", CustomUtil.strNull(params.get("developerSort")));
			requestParams.put("requestNote", CustomUtil.strNull(params.get("rem")));
			requestParams.put("requestStatus", "1202001");
			requestParams.put("insertId", String.valueOf(user.getUserId()));
			requestParams.put("groupId", groupId);
			
			
			if(params.get("ip1") instanceof String[] ){
				String[] ip1 = (String[]) params.get("ip1");
				String[] ip2 = (String[]) params.get("ip2");
				String[] ip3 = (String[]) params.get("ip3");
				String[] ip4 = (String[]) params.get("ip4");
				
				for(int i=0; i < ip1.length ; i++){
					Map ipMap = new HashMap();
					ipMap.putAll(params);
					ipMap.put("ip1", ip1[i]);
					ipMap.put("ip2", ip2[i]);
					ipMap.put("ip3", ip3[i]);
					ipMap.put("ip4", ip4[i]);
					DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(ipMap);	
				}
			}else{
				DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(params);
			}
			
			DeveloperRequestLocalServiceUtil.insertCustomDeveloperRequest(requestParams);
			
			try {
				EdisonFileUtil.insertWorkspaceDocFile(request, upload, developerInfo.getUserId(), groupId, filePreFix, CustomUtil.strNull(String.valueOf(developerInfo.getUserId())), "addfile", CustomUtil.strNull(developerInfo.getScreenName()));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			response.setPortletMode(PortletMode.VIEW);
	
			//사이트매니저한테 워크스페이스를 신청하면 메일보내기
			//workspace 요청자 ID
			//전송완료:true, 전송실패:false
			EdisonEmailSenderUtil.emailWorkspaceRequestSubmit(request, user.getUserId()); //workspace 요청 -> 사이트매니저에게 메일 보내기
			
		}else{
			SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
		}
	}
	
	@ResourceMapping(value="workspaceConfirm")
	public void workspaceConfirm(ResourceRequest request, ResourceResponse response)  throws PortalException, SystemException, MalformedURLException, IOException, SQLException{
		String resultCode = "200";
		Map params = RequestUtil.getParameterMap(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		params.put("groupId", groupId);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		User user = PortalUtil.getUser(request);
		PrintWriter writer = response.getWriter();
		
		Map requestParams = new HashMap(); 
		
		requestParams.put("userId", String.valueOf(user.getUserId()));
		requestParams.put("requestSort", CustomUtil.strNull(params.get("developerSort")));
		requestParams.put("requestNote", CustomUtil.strNull(params.get("rem")));
		requestParams.put("requestStatus", "1202001");
		requestParams.put("insertId", String.valueOf(user.getUserId()));
		requestParams.put("groupId", groupId);
		
		log.info("ip : "+user.getLoginIP() );
		DeveloperInfoLocalServiceUtil.insertCustomDeveloperInfo(params);
		
		if(params.get("ip1") instanceof String[] ){
			String[] ip1 = (String[]) params.get("ip1");
			String[] ip2 = (String[]) params.get("ip2");
			String[] ip3 = (String[]) params.get("ip3");
			String[] ip4 = (String[]) params.get("ip4");
			
			for(int i=0; i < ip1.length ; i++){
				Map ipMap = new HashMap();
				ipMap.putAll(params);
				ipMap.put("ip1", ip1[i]);
				ipMap.put("ip2", ip2[i]);
				ipMap.put("ip3", ip3[i]);
				ipMap.put("ip4", ip4[i]);
				DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(ipMap);	
			}
		}else{
			DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(params);
		}
		requestParams.put("requestSeq", "0");
		DeveloperRequestLocalServiceUtil.insertCustomDeveloperRequest(requestParams);
		
		writer.write(resultCode);
		
	}
	
	@ResourceMapping(value="workspaceList")
	public void workspaceList(ResourceRequest request, ResourceResponse response)  throws PortalException, SystemException, MalformedURLException, IOException, SQLException{
		String resultCode = "200";
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		Map params = RequestUtil.getParameterMap(request);
		//{selectStatus=0, select_line=10, curPage=1, searchField=}
		String portletNameSpace = response.getNamespace();
		long groupId = PortalUtil.getScopeGroupId(request);
		params.put("groupId", groupId);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		User user = PortalUtil.getUser(request);
		PrintWriter writer = response.getWriter();
		
		int curPage = Integer.parseInt(CustomUtil.strNull(params.get("curPage"), "1"));
		int linePerPage = Integer.parseInt(CustomUtil.strNull(params.get("select_line"), "5"));
		int pagePerBlock = Integer.parseInt(CustomUtil.strNull(params.get("pagePerBlock"), "5"));		

		JSONArray json = new JSONArray();

		int totalCnt = (Integer) DeveloperInfoLocalServiceUtil.getCountCustomDeveloperInfo(params);
		params.put("curPage", curPage);
		params.put("linePerPage", linePerPage);
		
		String pagingStr = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"dataSearchList", totalCnt, curPage, linePerPage, pagePerBlock);
		
		List jobList = (List) DeveloperInfoLocalServiceUtil.getListCustomDeveloperInfo(params, themeDisplay.getLocale());
		json = JSONArray.fromObject(JSONSerializer.toJSON(jobList));
		
		StringBuffer responseBuffer = new StringBuffer();
		responseBuffer.append("{");
		responseBuffer.append("		\"dataList\":	");
		responseBuffer.append(					CustomUtil.strNull(json.toString()));	
		responseBuffer.append("		,\"pageList\":\""+pagingStr+"\"");
		responseBuffer.append("		,\"select_line\":\""+linePerPage+"\"");
		responseBuffer.append("		,\"totalCnt\":\""+totalCnt+"\"");		
		responseBuffer.append("}");
		
		writer.write(responseBuffer.toString());
		
		writer.close();
	}
	
	@RenderMapping(params = "myaction=workspaceView")
	public String workspaceView(final RenderRequest request, ModelMap model) throws PortalException, SystemException, MalformedURLException, IOException, SQLException{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map params = RequestUtil.getParameterMap(request);	            
		long groupId = PortalUtil.getScopeGroupId(request);
		boolean copyParam = GetterUtil.getBoolean(params.get("edionCopyParam"));
		if(copyParam){
			model.addAttribute("returnParams", params);
		}
		
		params.put("groupId", groupId);
		
		User user = PortalUtil.getUser(request);
		Map delevoperMap = DeveloperInfoLocalServiceUtil.getCustomDeveloperInfo(params, themeDisplay.getLocale());
		List ipList = DeveloperIpLocalServiceUtil.getListCustomDeveloperIp(params);
		
//		List statusList = EdisonExpndoUtil.getCommonCdList("1202");
		List statusList = EdisonExpndoUtil.getCodeListByUpCode("1202", themeDisplay.getLocale());
		
//		String statusOptionStr = HtmlFormUtils.makeCombo(statusList, CustomUtil.strNull(delevoperMap.get("requestStatus")), themeDisplay.getLocale());
		
		List fileList = EdisonFileUtil.getListWorkspaceDocFile(groupId, filePreFix, CustomUtil.strNull(delevoperMap.get("userId")));
		String groupName = GetterUtil.get(CustomUtil.strNull(params.get("groupName")), "");
		if(groupName != null & !groupName.equals("")) {
			model.addAttribute("groupName", groupName);
		}
		
		//기관명 Get
		String university = CustomUtil.strNull(delevoperMap.get("universityField"));
		String field = EdisonExpando.CDNM;
		String universityNm = EdisonExpndoUtil.getCommonCdSearchFieldValue(university, field, themeDisplay.getLocale());
		delevoperMap.put("universityFieldNm", universityNm);
		
		model.addAttribute("delevoperMap", delevoperMap);
		model.addAttribute("ipList", ipList);
		model.addAttribute("fileList", fileList);
		model.addAttribute("statusList", statusList);
//		model.addAttribute("statusOptionStr", statusOptionStr);
		
		if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR) || EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){////////관리자
			List requestList = (List) DeveloperRequestLocalServiceUtil.getListCustomDeveloperRequest(params, themeDisplay.getLocale());
			model.addAttribute("requestList", requestList);
			
			return "workspace/workspaceConfirm";
		}else{
			return "workspace/workspaceView";
		}
	}
	
	@ActionMapping(params = "myaction=developerConfirm" )
	public void developerConfirm(ActionRequest request, ActionResponse response) throws IOException, SystemException, PortalException, SQLException, PortletModeException, WindowStateException{
		UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);	
		Map params = RequestUtil.getParameterMap(upload);
		long groupId = PortalUtil.getScopeGroupId(upload);

		long companyId = PortalUtil.getCompanyId(request);
		
		boolean copyParam = GetterUtil.getBoolean(params.get("edionCopyParam"));
		if(copyParam){
			PortalUtil.copyRequestParameters(request, response);
		}
		
		params.put("groupId", groupId);
		
		User user  = PortalUtil.getUser(upload);
		ThemeDisplay themeDisplay = (ThemeDisplay)upload.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		User developerUser = null;
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(themeDisplay.getUser().getGroupId());
		
		developerUser = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), CustomUtil.strNull(params.get("screenName")));

		params.put("userId", String.valueOf(developerUser.getUserId()));
			
		DeveloperIpLocalServiceUtil.deleteCustomDeveloperIp(params);
			
		if(params.get("ip1") instanceof String[] ){
			String[] ip1 = (String[]) params.get("ip1");
			String[] ip2 = (String[]) params.get("ip2");
			String[] ip3 = (String[]) params.get("ip3");
			String[] ip4 = (String[]) params.get("ip4");
			
			for(int i=0; i < ip1.length ; i++){
				Map ipMap = new HashMap();
				ipMap.putAll(params);
				ipMap.put("ip1", ip1[i]);
				ipMap.put("ip2", ip2[i]);
				ipMap.put("ip3", ip3[i]);
				ipMap.put("ip4", ip4[i]);
				DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(ipMap);	
			}
		}else{
			DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(params);
		}
		
		params.put("updateId",user.getScreenName());
		
		DeveloperInfoLocalServiceUtil.updateCustomDeveloperInfo(params);
		DeveloperRequestLocalServiceUtil.insertCustomDeveloperRequest(params);
		String requestStatus = ParamUtil.get(upload, "requestStatus", "1202001");

		if((requestStatus.equals("1202002") || requestStatus.equals("1202005")) && !EdisonUserUtil.isSiteRole(developerUser, groupId, EdisonRoleConstants.DEVELOPER)) {	// 생성요청 승인, 추가요청 승인
			/*1202002 : 발급요청승인(Issued) 1202005 : 추가요청승인(Extension Issued)
			 * SolverOwner addSiteRole 
			 * DeveloperGroup addGroup
			 * */
			EdisonUserUtil.addGroup(developerUser, EdisonRoleConstants.DEVELOPER_GROUP);
			EdisonUserUtil.addSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_OWNER);
//			EdisonUserUtil.addSiteRole(developerUser, groupId, RoleConstants.DEVELOPER);
		} else if(requestStatus.equals("1202007")) {	// 삭제
			
			//하위 사이트 존재 여부
			boolean isChildrenSite = false;
			if(GroupLocalServiceUtil.getGroups(companyId, PortalUtil.getScopeGroupId(request), true).size()>0){
				isChildrenSite = true;
			}
			
			if(!isChildrenSite){
				
				//다른 사이트에서도 solver 관련된 권한이 없을 경우에는 developer group에서 삭제
				List<com.liferay.portal.model.Group> parentGroupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), 0, true);
				Group parentGroup = null;
				for(Group group:parentGroupList){
					if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){
						parentGroup = group;
						break;
					}
				}
				
				List<Group> groupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), parentGroup.getGroupId(), true);
				boolean siteSolverRole = false;
				for1:for(Group group:groupList){
					if(group.getGroupId()!=groupId){
						if(EdisonUserUtil.isSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_OWNER)){siteSolverRole=true;break for1;}
						if(EdisonUserUtil.isSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_MANAGER)){siteSolverRole=true;break for1;}
					}
				}
				
				if(!siteSolverRole){
					EdisonUserUtil.deleteGroup(developerUser, EdisonRoleConstants.DEVELOPER_GROUP);
				}
				
				// Solver Owner 권한 삭제
				EdisonUserUtil.deleteSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_OWNER);
			}
		}
		
		//워크스페이스 승인 내역을 개발자에게 전송
		//처리한 유저 Admin ID
		//처리 결과를 전송할 User ID
		//전송완료:true, 전송실패:false
		if(CustomUtil.strNull(params.get("mailSendYn")).equals("Y")){
			String message = EdisonExpndoUtil.getCommonCdSearchFieldValue(requestStatus, EdisonExpando.CDNM, themeDisplay.getLocale());
			EdisonEmailSenderUtil.emailWorkspaceConfirmtSubmit(request, user.getUserId(), developerUser.getUserId(), message); //email 승인하면 개발자에게 메일보내기
		}
		
		String groupName = ParamUtil.get(upload, "groupName", "");

		if(!groupName.equals("")) {
			PortletURL portletURL = PortletURLFactoryUtil.create(upload, PortalUtil.getPortletId(upload), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setParameter("groupName", groupName);
			portletURL.setPortletMode(LiferayPortletMode.VIEW);
			portletURL.setWindowState(LiferayWindowState.POP_UP);
			response.sendRedirect(portletURL.toString());
		} else {
			response.setPortletMode(PortletMode.VIEW);
		}
		
		/*보안 서약서 수정 기능 추가
		 * 기존 보안서약서 삭제 후 업로드
		 * */
		String fileName = upload.getFileName("addfile");
		if(!fileName.equals("") && fileName != null) {
			try {
				EdisonFileUtil.deleteWorkspaceDocFile(groupId, filePreFix, CustomUtil.strNull(String.valueOf(developerUser.getUserId())));
				EdisonFileUtil.insertWorkspaceDocFile(request, upload, developerUser.getUserId(), groupId, filePreFix, CustomUtil.strNull(String.valueOf(developerUser.getUserId())), "addfile", CustomUtil.strNull(developerUser.getScreenName()));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@ActionMapping(params = "myaction=developerUpdate" )
	public void developerUpdate(ActionRequest request, ActionResponse response) throws IOException, SystemException, PortalException, SQLException, PortletModeException, WindowStateException{
		UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);
		Map params = RequestUtil.getParameterMap(upload);
		long groupId = PortalUtil.getScopeGroupId(request);
		params.put("groupId", groupId);
		
		User user  = PortalUtil.getUser(request);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		User developerUser = null;
		
		boolean isUser = true;
			
		try{
			developerUser = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), CustomUtil.strNull(params.get("screenName")));
		}catch (NoSuchUserException ne) {
			isUser = false;
		}
		if(isUser){
		
			DeveloperIpLocalServiceUtil.deleteCustomDeveloperIp(params);
				
			if(params.get("ip1") instanceof String[] ){
				String[] ip1 = (String[]) params.get("ip1");
				String[] ip2 = (String[]) params.get("ip2");
				String[] ip3 = (String[]) params.get("ip3");
				String[] ip4 = (String[]) params.get("ip4");
					
				for(int i=0; i < ip1.length ; i++){
					Map ipMap = new HashMap();
					ipMap.putAll(params);
					ipMap.put("ip1", ip1[i]);
					ipMap.put("ip2", ip2[i]);
					ipMap.put("ip3", ip3[i]);
					ipMap.put("ip4", ip4[i]);
					DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(ipMap);	
				}
			}else{
				DeveloperIpLocalServiceUtil.insertCustomDeveloperIp(params);
			}
			
			params.put("updateId",user.getScreenName());
			
			DeveloperInfoLocalServiceUtil.updateCustomDeveloperInfo(params);
			DeveloperRequestLocalServiceUtil.insertCustomDeveloperRequest(params);
			
			String requestStatus = ParamUtil.get(upload, "requestStatus", "1202001");
			if((requestStatus.equals("1202002") || requestStatus.equals("1202005")) && !EdisonUserUtil.isSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_OWNER)) {	// 생성요청 승인, 추가요청 승인
				EdisonUserUtil.addGroup(developerUser, EdisonRoleConstants.DEVELOPER_GROUP);
				EdisonUserUtil.addSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_OWNER);
				
			} else if(requestStatus.equals("1202007")) {	// 삭제
				
				//다른 사이트에서도 solver 관련된 권한이 없을 경우에는 developer group에서 삭제
				List<com.liferay.portal.model.Group> parentGroupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), 0, true);
				Group parentGroup = null;
				for(Group group:parentGroupList){
					if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){
						parentGroup = group;
						break;
					}
				}
				
				List<Group> groupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), parentGroup.getGroupId(), true);
				boolean siteSolverRole = false;
				for1:for(Group group:groupList){
					if(group.getGroupId()!=groupId){
						if(EdisonUserUtil.isSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_OWNER)){siteSolverRole=true;break for1;}
						if(EdisonUserUtil.isSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_MANAGER)){siteSolverRole=true;break for1;}
					}
				}
				
				if(!siteSolverRole){
					EdisonUserUtil.deleteGroup(developerUser, EdisonRoleConstants.DEVELOPER_GROUP);
				}
				
				// Solver Owner 권한 삭제
				EdisonUserUtil.deleteSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_OWNER);
				
			}
		}
		
		String groupName = ParamUtil.get(upload, "groupName", "");

		if(!groupName.equals("")) {
			PortletURL portletURL = PortletURLFactoryUtil.create(upload, PortalUtil.getPortletId(upload), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setParameter("groupName", groupName);
			portletURL.setPortletMode(LiferayPortletMode.VIEW);
			portletURL.setWindowState(LiferayWindowState.POP_UP);
			response.sendRedirect(portletURL.toString());
		}else {
			response.setPortletMode(PortletMode.VIEW);
		}
		
		/*보안 서약서 수정 기능 추가
		 * 기존 보안서약서 삭제 후 업로드
		 * */
		String fileName = upload.getFileName("addfile");
		if(!fileName.equals("") && fileName != null) {
			try {
				EdisonFileUtil.deleteWorkspaceDocFile(groupId, filePreFix, CustomUtil.strNull(String.valueOf(developerUser.getUserId())));
				EdisonFileUtil.insertWorkspaceDocFile(request, upload, developerUser.getUserId(), groupId, filePreFix, CustomUtil.strNull(String.valueOf(developerUser.getUserId())), "addfile", CustomUtil.strNull(developerUser.getScreenName()));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@ActionMapping(params = "myaction=addRequest" )
	public void addRequest(ActionRequest request, ActionResponse response) throws IOException, SystemException, PortalException, SQLException, PortletModeException{
		Map params = RequestUtil.getParameterMap(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		params.put("groupId", groupId);
		
		User user  = PortalUtil.getUser(request);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);		
		params.put("insertId",user.getScreenName());
		
		DeveloperRequestLocalServiceUtil.insertCustomDeveloperRequest(params);
		response.setPortletMode(PortletMode.VIEW);
	}
	
	/**
	 * 워크스페이스 파일다운
	 * @throws SystemException 
	 * @throws PortalException 
	 **/
	@ResourceMapping(value="edisonFileDownload")
	public void edisonFileDownload(ResourceRequest request, ResourceResponse response) throws IOException, SQLException, PortalException, SystemException{

		Map paramsMap = RequestUtil.getParameterMap(request);
		long fileEntryId = Long.parseLong(CustomUtil.strNull(paramsMap.get("fileEntryId")));
		
		EdisonFileUtil.edisonFileDownload(response, fileEntryId);
	}
	
	
	/**
	 * 워크스페이스 삭제
	 * @throws PortletModeException 
	 */
	@ActionMapping(params = "myaction=deleteWorkSpace" )
	public void deleteWorkSpace(ActionRequest request, ActionResponse response) throws PortletModeException, WindowStateException{
		UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		//솔버 권한 확인 - 소유자, 관리자
		Map param = RequestUtil.getParameterMap(upload);
		long userId = GetterUtil.getLong(param.get("userId"));
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		String errorMsg = "";
		
		try {
//			Role solverOwnerRole = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), RoleConstants.SOLVER_OWNER);
//			List<Long> solverOwnerCustomRoleList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(userId, groupId, solverOwnerRole.getRoleId());
//			
//			Role solverManagerRole = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), RoleConstants.SOLVER_MANAGER);
//			List<Long> solverManagerCustomRoleList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(userId, groupId, solverManagerRole.getRoleId());
			//솔버관련 일시적으로 주석 처리
			/*if(solverOwnerCustomRoleList!=null){
				errorMsg +=LanguageUtil.get(themeDisplay.getLocale(), "edison-appstore-solver-owner", "")+" : ";
				String solverName = "";
				for(Long solverId:solverOwnerCustomRoleList){
					SolverPK solverPK = new SolverPK(solverId, groupId);
					Solver solver = SolverLocalServiceUtil.getSolver(solverPK);
					solverName+=solver.getSolver_name()+"    ";
				}
				errorMsg+=solverName;
				throw new EdisonException(0);
			}
			if(solverManagerCustomRoleList!=null){
				errorMsg +=LanguageUtil.get(themeDisplay.getLocale(), "edison-appstore-solver-manager", "")+" : ";
				String solverName = "";
				for(Long solverId:solverManagerCustomRoleList){
					SolverPK solverPK = new SolverPK(solverId, groupId);
					Solver solver = SolverLocalServiceUtil.getSolver(solverPK);
					solverName+=solver.getSolver_name()+"    ";
				}
				errorMsg+=solverName;
				throw new EdisonException(0);
			}*/
			
			
			//해당 사이트의 solver의 소유자 또는 관리자가 아닐경우에는 DATA 삭제
			DeveloperInfoLocalServiceUtil.deleteWorkSpace(userId, groupId);
			
			
			//다른 사이트에서도 solver 관련된 권한이 없을 경우에는 developer group에서 삭제
			List<com.liferay.portal.model.Group> parentGroupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), 0, true);
			Group parentGroup = null;
			for(Group group:parentGroupList){
				if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){
					parentGroup = group;
					break;
				}
			}
			
			List<Group> groupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), parentGroup.getGroupId(), true);
			boolean siteSolverRole = false;
			User user = UserLocalServiceUtil.getUser(userId);
			for1:for(Group group:groupList){
				if(group.getGroupId()!=groupId){
					if(EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SOLVER_OWNER)){siteSolverRole=true;break for1;}
					if(EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SOLVER_MANAGER)){siteSolverRole=true;break for1;}
				}
			}
			
			if(!siteSolverRole){
				EdisonUserUtil.deleteGroup(user, EdisonRoleConstants.DEVELOPER_GROUP);
			}
			
			// Solver Owner 권한 삭제
			EdisonUserUtil.deleteSiteRole(user, groupId, EdisonRoleConstants.SOLVER_OWNER);
			
			User developerUser = null;
			boolean isUser = true;
				
			try{
				developerUser = UserLocalServiceUtil.getUserById(themeDisplay.getCompanyId(), userId);
			}catch (NoSuchUserException ne) {
				isUser = false;
			}
			if(isUser){
				try {
					EdisonFileUtil.deleteWorkspaceDocFile(groupId, filePreFix, CustomUtil.strNull(String.valueOf(developerUser.getUserId())));
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			String groupName = ParamUtil.get(upload, "groupName", "");

			if(!groupName.equals("")) {
				PortletURL portletURL = PortletURLFactoryUtil.create(upload, PortalUtil.getPortletId(upload), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				
				portletURL.setParameter("groupName", groupName);
				portletURL.setPortletMode(LiferayPortletMode.VIEW);
				portletURL.setWindowState(LiferayWindowState.POP_UP);
				response.sendRedirect(portletURL.toString());
			}else {
				response.setPortletMode(PortletMode.VIEW);
			}
			SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
		} catch (SystemException e) {
			SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
			log.error(e);
		} catch (EdisonException e) {
			SessionErrors.add(request, errorMsg);
		} catch (PortalException e) {
			SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
			log.error(e);
		} catch (IOException e) {
			SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
			log.error(e);
		} catch (SQLException e) {
			SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
			log.error(e);
		}
	}
	
	/**
	 * Developer Role Check
	 * @throws SystemException 
	 * @throws PortalException 
	 **/
	@ResourceMapping(value="developerRoleCheck")
	public void developerRoleCheck(ResourceRequest request, ResourceResponse response) throws IOException, SQLException, PortalException, SystemException{
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = PortalUtil.getScopeGroupId(request);
		long userId = ParamUtil.get(request, "userId", 0L);
		Locale locale = PortalUtil.getLocale(request);
		
		long solverOwnerRoleId = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.SOLVER_OWNER).getRoleId();
		long solverManagerRoleId = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.SOLVER_MANAGER).getRoleId();
		
		/* Solver OWNER, MANAGER 권한이 있는 Solver가 있는지 체크 */
//		List<Long> ownerSolverIdList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(userId, groupId, solverOwnerRoleId);
//		List<Long> managerSolverIdList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(userId, groupId, solverManagerRoleId);
		
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
		/* Solver OWNER, MANAGER 권한이 있는 Solver 정보 가져오기 */
		//솔버관련 일시적으로 주석 처리
		/*if(ownerSolverIdList != null && ownerSolverIdList.size() > 0) {
			for (int i = 0; i < ownerSolverIdList.size(); i++) {
				SolverPK solverPK = new SolverPK(ownerSolverIdList.get(i), groupId);
				Solver solver = SolverLocalServiceUtil.getSolver(solverPK);
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("solverName", solver.getSolver_title(locale, true));
				resultMap.put("solverRole", RoleConstants.SOLVER_OWNER);
				resultList.add(resultMap);
			}
		}
		
		if(managerSolverIdList != null && managerSolverIdList.size() > 0) {
			for (int i = 0; i < managerSolverIdList.size(); i++) {
				SolverPK solverPK = new SolverPK(managerSolverIdList.get(i), groupId);
				Solver solver = SolverLocalServiceUtil.getSolver(solverPK);
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("solverName", solver.getSolver_title(locale, true));
				resultMap.put("solverRole", RoleConstants.SOLVER_MANAGER);
				resultList.add(resultMap);
			}
		}*/
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		JSONArray json = JSONArray.fromObject(JSONSerializer.toJSON(resultList));
		writer.write(json.toString());
	}
	
}
