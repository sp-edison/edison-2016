package org.kisti.edison.sitejoin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.service.DeveloperRequestLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppManagerLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabUserLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.membershippolicy.SiteMembershipPolicyUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class MySiteJoinController {
	protected static Log  log = LogFactoryUtil.getLog(MySiteJoinController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) throws ParseException {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			
			User user = themeDisplay.getUser();
			Comparator<Group> sort = new Comparator<Group>() {
				public int compare(Group o1Group, Group o2Group) {
					long o1 = o1Group.getGroupId();
					long  o2 = o2Group.getGroupId();
					return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1);
				}
			};
			List<Group> childStieGroupList = ListUtil.sort(GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), PortalUtil.getScopeGroupId(request), true),sort);
			
			List<Map<String, Object>> userSiteGroupList = new ArrayList<Map<String, Object>>();
			
			Map<String, Object> userSiteGroup = null;
			
			for(Group childSite : childStieGroupList){
				userSiteGroup = new HashMap<String, Object>();
				userSiteGroup.put("groupId", String.valueOf(childSite.getGroupId()));
				userSiteGroup.put("groupNm", LanguageUtil.get(themeDisplay.getLocale(), String.valueOf(childSite.getName())));
				userSiteGroup.put("groupType", String.valueOf(childSite.getType()));
				
				Boolean userHasGroup = GroupLocalServiceUtil.hasUserGroup(user.getUserId(), childSite.getGroupId()); 
				Boolean userSiteMember = SiteMembershipPolicyUtil.isMembershipAllowed(user.getUserId(), childSite.getGroupId());
				
				String status = "";
				if(!userHasGroup && userSiteMember){
					if(childSite.getType() == GroupConstants.TYPE_SITE_OPEN){
						status = "join";
					}
				}else{
					if(childSite.getType() == GroupConstants.TYPE_SITE_OPEN
						|| childSite.getType() == GroupConstants.TYPE_SITE_RESTRICTED
						&& GroupLocalServiceUtil.hasUserGroup(user.getUserId(), childSite.getGroupId(), false)
						&& !SiteMembershipPolicyUtil.isMembershipRequired(user.getUserId(), childSite.getGroupId())){
							status = "leave";
					}
				}
				
				userSiteGroup.put("memberStatus", status);
				userSiteGroup.put("groupMemberCount", UserLocalServiceUtil.getGroupUsersCount(childSite.getGroupId()));

				userSiteGroupList.add(userSiteGroup);
			}
			
			model.addAttribute("userSiteGroupList", userSiteGroupList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sitejoin/view";
	}

	
	@ResourceMapping(value ="getCheckOwner")
	public void getCheckOwner(ResourceRequest request, ResourceResponse response){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			long companyId = PortalUtil.getCompanyId(request);

			Role virtaulLabOwnerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);		// Role Id 확인
			Role virtaulClassOwnerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);		// Role Id 확인

			Map param = RequestUtil.getParameterMap(request);
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"),"0"));
			int totalCnt = UserGroupRoleCustomLocalServiceUtil.getSiteLeaveOwnerTotalCnt(themeDisplay.getUserId(), virtaulLabOwnerRole.getRoleId(), groupId, virtaulClassOwnerRole.getRoleId());

			JSONObject json = new JSONObject();
			json.put("totalCnt", String.valueOf(totalCnt));
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	/*
	 *  사이언스 앱 매니저 삭제
	 * */
	@ResourceMapping(value ="deleteAppManagerId")
	public void deleteAppManagerId(ResourceRequest request, ResourceResponse response){
		
		try{
			Map param = RequestUtil.getParameterMap(request);
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"),"0"));
			Long userId =  Long.parseLong(CustomUtil.strNull(param.get("userIds"),"0"));

			if(groupId != 0 && userId != 0){
				//groupID 추가필요
				
				List<Map<String, Object>> getAppManagerList = ScienceAppManagerLocalServiceUtil.getScienceAppManagerList(userId, groupId);
				
				if(getAppManagerList != null){
					for(Map<String, Object> appManager : getAppManagerList){
						
						Long userIds = Long.parseLong(CustomUtil.strNull(appManager.get("userId")));
						Long scienceAppId = Long.parseLong(CustomUtil.strNull(appManager.get("scienceAppId")));
						
						ScienceAppManagerLocalServiceUtil.removeByAppIdAndUserId(scienceAppId, userIds);
					}
				}
			}
			
			JSONObject json = new JSONObject();
			json.put("result", "done");

			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	/*
	 * 콘텐츠, 가상실험실, 가상클래스 매니저 삭제
	 * */
	@ResourceMapping(value ="deleteAuthManagerId")
	public void deleteAuthManagerId(ResourceRequest request, ResourceResponse response){
		try{
			Map param = RequestUtil.getParameterMap(request);
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"),"0"));
			Long userId =  Long.parseLong(CustomUtil.strNull(param.get("userIds"),"0"));

			long companyId = PortalUtil.getCompanyId(request);
			Role contentManagerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_MANAGER);		// Role Id 확인
			Role virtaulLabManagerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);		// Role Id 확인
			Role virtaulClassManagerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);		// Role Id 확인
			
			/*48002
			20606
			20608*/
			
			
			if(groupId != 0 && userId != 0){
				
				//content manager delete
				List<Long> contentManagerCustomIdList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(userId, groupId, contentManagerRole.getRoleId());
				if(contentManagerCustomIdList != null){
					for(Long contentManagerCustomId : contentManagerCustomIdList){
						UserGroupRoleCustomLocalServiceUtil.deleteUserGroupRoleCustomManager(userId, groupId, contentManagerRole.getRoleId(), contentManagerCustomId);
					}
				}
				
				//virtual lab manager delete
				List<Long> labManagerCustomIdList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(userId, groupId, virtaulLabManagerRole.getRoleId());
				if(labManagerCustomIdList != null){
					for(Long labManagerCustomId : labManagerCustomIdList){
						UserGroupRoleCustomLocalServiceUtil.deleteUserGroupRoleCustomManager(userId, groupId, virtaulLabManagerRole.getRoleId(), labManagerCustomId);
					}
				}

				//virtual class manager delete
				List<Long> classManagerCustomIdList = UserGroupRoleCustomLocalServiceUtil.getCustomIdList(userId, groupId, virtaulClassManagerRole.getRoleId());
				if(classManagerCustomIdList != null){
					for(Long classManagerCustomId : classManagerCustomIdList){
						UserGroupRoleCustomLocalServiceUtil.deleteUserGroupRoleCustomManager(userId, groupId, virtaulClassManagerRole.getRoleId(), classManagerCustomId);
					}
				}
				
				
				//수강중인 클래스에서 학생상태 삭제
				List<Map<String, Object>> classStudentList = VirtualLabUserLocalServiceUtil.getUserGroupClassUser(userId, groupId);
				if(classStudentList != null){
					for(Map<String, Object> classStudent : classStudentList){
						VirtualLabUserLocalServiceUtil.deleteVirtualLabUser(Long.parseLong(CustomUtil.strNull(classStudent.get("virtualLabUserId"),"0")));		
						
					}
				}
				
				
				//workspace 삭제요청상태로 수정
				DeveloperRequestLocalServiceUtil.updateDeveloperRequestStatus(userId, groupId, "1202007");
			}
			
			
			JSONObject json = new JSONObject();
			json.put("result", "done");
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	
	
	@ActionMapping(params="myaction=siteLeave")
	public void siteLeave(ActionRequest request, ActionResponse response) throws IOException{
		try {
	
			long groupId = ParamUtil.getLong(request, "groupId");

			long[] removeUserIds = StringUtil.split(ParamUtil.getString(request, "removeUserIds"), 0L);
			removeUserIds = filterRemoveUserIds(groupId, removeUserIds);
			
			if(removeUserIds != null && removeUserIds.length  == 1){
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
				UserServiceUtil.unsetGroupUsers(groupId, removeUserIds, serviceContext);
				
			}
			SessionMessages.add(request, EdisonMessageConstants.DELETE_SUCCESS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			SessionErrors.add(request, EdisonMessageConstants.DELETE_ERROR);
		}
	}
	


	
	@ActionMapping(params="myaction=siteJoin")
	public void siteJoin(ActionRequest request, ActionResponse response) throws IOException{
		try {
			
			long groupId = ParamUtil.getLong(request, "groupId");
			long[] addUserIds = StringUtil.split(ParamUtil.getString(request, "addUserIds"), 0L);
			addUserIds = filterAddUserIds(groupId, addUserIds);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			UserServiceUtil.addGroupUsers(groupId, addUserIds, serviceContext);
			
			if(addUserIds != null && addUserIds.length == 1){
				User user = UserLocalServiceUtil.getUser(addUserIds[0]);
				EdisonUserUtil.addSiteRole(user, groupId, EdisonRoleConstants.SITE_MEMBER);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@RenderMapping(params = "myaction=siteLeaveOwnerView")
	public String siteLeaveOwnerView(RenderRequest request, ModelMap model){
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long companyId = PortalUtil.getCompanyId(request);
			Role contentOwnerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.CONTENT_OWNER);		// Role Id 확인
			Role virtaulClassOwnerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);		// Role Id 확인
			Role virtaulLabOwnerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);		// Role Id 확인

			String languageId = themeDisplay.getLanguageId();

			Map param = RequestUtil.getParameterMap(request);
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"),"0"));
			Long userId =  Long.parseLong(CustomUtil.strNull(param.get("userIds"),"0"));
			
			//Content Owner Check
			List<Map<String,String>> contentOwnerList =  UserGroupRoleCustomLocalServiceUtil.getContentOwnerList(userId, contentOwnerRole.getRoleId(),groupId, languageId);
			
			//Virtual Class Owner Check
			List<Map<String,String>> virtualClassOwnerList = UserGroupRoleCustomLocalServiceUtil.getVirtaulClassOwnerList(userId, virtaulClassOwnerRole.getRoleId(),groupId, languageId);
			
			//Virtual Lab Owner Check
			List<Map<String,String>> virtualLabOwnerList = UserGroupRoleCustomLocalServiceUtil.getVirtualLabOwnerList(userId, virtaulLabOwnerRole.getRoleId(), groupId, languageId);
			
			//Solver Owner Check
			List<ScienceApp> getUserOwnerScienceAPPList = ScienceAppLocalServiceUtil.getScienceAppListByAuthorId(userId);
			List<Map<String,String>> scienceAppOwnerList = new ArrayList<Map<String,String>>();
			Map<String,String> scienceAppOwner = null;
			for(ScienceApp userSciecneApp : getUserOwnerScienceAPPList){
				scienceAppOwner = new HashMap<String, String>();
				
				scienceAppOwner.put("groupId", String.valueOf(userSciecneApp.getGroupId()));
				scienceAppOwner.put("scienceAppId", String.valueOf(userSciecneApp.getScienceAppId()));
				scienceAppOwner.put("title", userSciecneApp.getTitle(languageId));
				scienceAppOwner.put("version", userSciecneApp.getVersion());
				
				scienceAppOwnerList.add(scienceAppOwner);
			}
			
			model.addAttribute("contentOwnerList", contentOwnerList);
			model.addAttribute("virtualClassOwnerList", virtualClassOwnerList);
			model.addAttribute("virtualLabOwnerList", virtualLabOwnerList);
			model.addAttribute("scienceAppOwnerList", scienceAppOwnerList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sitejoin/siteOwnerView";
	}
	
	
	protected long[] filterAddUserIds(long groupId, long[] userIds)throws Exception {

		Set<Long> filteredUserIds = new HashSet<Long>(userIds.length);
	
		for (long userId : userIds) {
			if (!UserLocalServiceUtil.hasGroupUser(groupId, userId)) {
				filteredUserIds.add(userId);
			}
		}
	
		return ArrayUtil.toArray(filteredUserIds.toArray(new Long[filteredUserIds.size()]));
	}

	protected long[] filterRemoveUserIds(long groupId, long[] userIds)
		throws Exception {

		Set<Long> filteredUserIds = new HashSet<Long>(userIds.length);

		for (long userId : userIds) {
			if (UserLocalServiceUtil.hasGroupUser(groupId, userId)) {
				filteredUserIds.add(userId);
			}
		}

		return ArrayUtil.toArray(filteredUserIds.toArray(new Long[filteredUserIds.size()]));
	}
	
	
	
}
