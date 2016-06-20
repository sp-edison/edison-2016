package org.kisti.edison.portlet.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.SendMailContent;
import org.kisti.edison.service.SendMailContentLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")   
public class emailController {
	private static Log log = LogFactoryUtil.getLog(emailController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response,ModelMap model){
		Map params = RequestUtil.getParameterMap(request);
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long companyId = PortalUtil.getCompanyId(request);
			long userId = PortalUtil.getUserId(request);
			
			model.addAttribute("currentPage", CustomUtil.strNull(params.get("currentPage"), "1"));
			model.addAttribute("searchValue", CustomUtil.strNull(params.get("searchValue")));
			model.addAttribute("listSize", CustomUtil.strNull(params.get("listSize"), "10"));
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "email/emailList";
	}
	
	@ResourceMapping(value="getSentMailList")
	public void getBoardDivBoards(ResourceRequest request, ResourceResponse response) throws SystemException, JSONException, IOException, PortalException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
		Map params = RequestUtil.getParameterMap(request);

		String searchValue = CustomUtil.strNull(params.get("searchValue"));
				
		int currentPage = Integer.parseInt(CustomUtil.strNull(params.get("currentPage"), "1"));
		int listSize = Integer.parseInt(CustomUtil.strNull(params.get("listSize"), "10"));
		int pagePerBlock = 5;
		int begin = ((currentPage - 1) * listSize);
		
		int totalCount = SendMailContentLocalServiceUtil.retrieveCountSentMailContent(params);
		
		List sendMailList = SendMailContentLocalServiceUtil.retrieveSentMailContentList(params, begin, listSize);
		

		String paging = PagingUtil.getPaging(request.getContextPath(), CustomUtil.strNull(params.get("methodName")), totalCount, currentPage, listSize, pagePerBlock);
		
		JSONObject obj = new JSONObject();
		
		obj.put("sendMailList", sendMailList);
		obj.put("seq", totalCount - ((currentPage - 1)*listSize));
		obj.put("paging", paging);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	@RenderMapping(params="myRender=getEmailRender")
	public String getEmailRender(RenderRequest request, RenderResponse response, ModelMap model) throws IOException{
		Map params = RequestUtil.getParameterMap(request);
		String mode = CustomUtil.strNull(params.get("mode"));
		try{
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			long companyId = themeDisplay.getCompanyId();
			
			if(mode.equals("view")){
				long sendMailId = Long.parseLong(CustomUtil.strNull(params.get("sendMailId"), "0"));
				SendMailContent sendMailContent = SendMailContentLocalServiceUtil.getSendMailContent(sendMailId);
				
				String selectSiteGroup = CustomUtil.strNull(sendMailContent.getSiteGroup());
				String selectUserGroup = CustomUtil.strNull(sendMailContent.getUserGroup());
				
				String[] siteGroups = null; 
				if(!selectSiteGroup.equals("")){
					siteGroups = CustomUtil.strNull(sendMailContent.getSiteGroup()).split(",");
				}
				String[] userGroups = null;
				if(!selectUserGroup.equals("")){
					userGroups = CustomUtil.strNull(sendMailContent.getUserGroup()).split(",");
				}
				
				List<Group> siteGroupList = new ArrayList<Group>();
				if(siteGroups != null){
					for(String siteGroup : siteGroups){
						long siteGroupId = Long.parseLong(siteGroup);
						Group getSiteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);
						siteGroupList.add(getSiteGroup);
					}
					model.addAttribute("siteGroupList", siteGroupList);
				}
				List<UserGroup> userGroupList = new ArrayList<UserGroup>();
				if(userGroups != null){
					for(String userGroup : userGroups){
						long userGroupId = Long.parseLong(userGroup);
						UserGroup getUserGroup = UserGroupLocalServiceUtil.getUserGroup(userGroupId);
						userGroupList.add(getUserGroup);
					}
					model.addAttribute("userGroupList", userGroupList);
				}
				User mailSenderUser = UserLocalServiceUtil.getUser(sendMailContent.getUserId());
				model.put("sendMailContent", sendMailContent) ;
				model.put("mailSender", mailSenderUser.getScreenName()) ;
			}else{
				List<Group> parentGroupList = GroupLocalServiceUtil.getGroups(companyId, 0, true);
				Group portalGroup = null;
				for(Group group:parentGroupList){
					if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){//포탈 groupId 구하기
						portalGroup = group;
						break;
					}
				}
				
				List<UserGroup> userGroupList =  UserGroupLocalServiceUtil.getUserGroups(companyId);
				List<Group> groupList = GroupLocalServiceUtil.getGroups(companyId, portalGroup.getGroupId(), true);//하위 그룹 리스트
				model.put("groupList", groupList) ;
				model.put("userGroupList", userGroupList) ;
				model.put("portalGroup", portalGroup) ;
			}
			
			model.put("searchValue", CustomUtil.strNull(params.get("searchValue"))) ;
			model.put("currentPage", CustomUtil.strNull(params.get("currentPage"))) ;
			model.put("listSize", CustomUtil.strNull(params.get("listSize"))) ;

		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		if(mode.equals("view")){
			return "email/emailView";
		}else{
			return "email/emailWrite";
		}
	}
	
	@ActionMapping(params="myAction=emailSend")
	public void emailSendAction(ActionRequest request, ActionResponse response, ModelMap model) throws IOException{
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Map params = RequestUtil.getParameterMap(request);
			long adminUserId = PortalUtil.getUserId(request);
			long companyId = PortalUtil.getCompanyId(request);
			long userId = PortalUtil.getUserId(request);
			String[] siteGroups = request.getParameterValues("siteGroup");
			String[] userGroups = request.getParameterValues("userGroup");
			
			EmailSendThread emailSendThread = new EmailSendThread(params, serviceContext, companyId, userId, adminUserId, siteGroups, userGroups);
			emailSendThread.start();
			
			SessionMessages.add(request, EdisonMessageConstants.MAIL_SEND_SUCCESS);
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("myRender", "getEmailRender");
			portletURL.setParameter("mode", "write");
			portletURL.setParameter("emailSubject", CustomUtil.strNull(params.get("emailSubject")));
			portletURL.setParameter("emailContent", CustomUtil.strNull(params.get("emailContent")));
			if(siteGroups != null) portletURL.setParameter("selectSiteGroups", siteGroups);
			if(userGroups != null) portletURL.setParameter("selectUserGroups", userGroups);
			response.sendRedirect(portletURL.toString());
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.MAIL_SEND_ERROR);
		}
	}
}


