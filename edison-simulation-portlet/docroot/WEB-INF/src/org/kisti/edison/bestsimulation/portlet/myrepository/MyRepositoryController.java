package org.kisti.edison.bestsimulation.portlet.myrepository;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.MyRepositoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("VIEW")
public class MyRepositoryController {

	private static Log log = LogFactoryUtil.getLog(MyRepositoryController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = PortalUtil.getUser(request);
			long groupId = themeDisplay.getScopeGroupId();
			long companyId = PortalUtil.getCompanyId(request);
			long repository = 1000000L;
			float repositoryPercent = 0F;
			
			long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();
			
			//하위 사이트 존재 여부
			boolean isChildrenSite = false;
			if(GroupLocalServiceUtil.getGroups(companyId, PortalUtil.getScopeGroupId(request), true).size()>0){
				isChildrenSite = true;
			}
			
			// parentGroupId가 0이면 포털 0이 아니면 분야 사이트
			if(parentGroupId == 0 && isChildrenSite) {
				List<Map<String,Object>> repositoryList = new ArrayList<Map<String,Object>>();
				
				// 유저의 가입된 사이트 정보를 가져옴
				List<Group> groupList = CustomUtil.getGroupIdASC(user.getMySiteGroups());
				
				for (Group group : groupList) {
					if(group.getParentGroupId() > 0) {
						Map<String, Object> repositoryInfoMap = new HashMap<String, Object>();
						
						repositoryInfoMap.put("groupName", group.getName());
						repositoryInfoMap.put("groupId", CustomUtil.strNull(group.getGroupId()));
						// 파일 정보 저장
						
						repositoryList.add(repositoryInfoMap);
					}
				}
				model.addAttribute("repositoryList", repositoryList);
				return "myrepository/total_view";
			} else {
				String highestRole = MyRepositoryUtil.getHighestRole(user.getUserId(), groupId);
				if(highestRole != null && !highestRole.equals("")) {
					Role role = RoleLocalServiceUtil.getRole(companyId, highestRole);
					repository = GetterUtil.get(CustomUtil.strNull(role.getExpandoBridge().getAttribute("Storagelimit"), "1000000"), 1000000L);
				}
				
				String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
				IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
				long userRepository = GetterUtil.get(SimulationLocalServiceUtil.getUserRepositorySize(icebreakerUrl, vcToken.getVcToken()), 0L);
				if(userRepository > repository) {
					repositoryPercent = 100;
				} else {
					repositoryPercent = (float) (userRepository * 100 / repository);
				}
				
				model.addAttribute("repositoryPercent", Math.abs(repositoryPercent));
				model.addAttribute("userRepository", MyRepositoryUtil.humanReadableByteCount(userRepository, false));
				model.addAttribute("repository", MyRepositoryUtil.humanReadableByteCount(repository, false));
				
				int userCpuRepository = checkCoreLimit(icebreakerUrl, user, vcToken.getVcToken(), groupId).getCurrentCores();
				int cpuRepository = getUserAssignmentCores(user, groupId);
				float cpuRepositoryPercent = 0F;
				if(userCpuRepository > cpuRepository) {
					cpuRepositoryPercent = 100;
				} else {
					cpuRepositoryPercent = (float) (userCpuRepository * 100 / cpuRepository);
				}
				
				model.addAttribute("cpuRepositoryPercent", Math.abs(cpuRepositoryPercent));
				model.addAttribute("userCpuRepository", userCpuRepository);
				model.addAttribute("cpuRepository", cpuRepository);
				return "myrepository/view"; 
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
			return "";
		}
	}
	
	@ResourceMapping(value ="getRepositoryInfo")
	public void getRepositoryInfo(ResourceRequest request, ResourceResponse response) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = PortalUtil.getUser(request);
		long groupId = ParamUtil.get(request, "groupId", themeDisplay.getScopeGroupId());
		long companyId = PortalUtil.getCompanyId(request);
		long repository = 1000000L;
		float repositoryPercent = 0F;
		int userCpuRepository = 0;
		
		Map<String, Object> repositoryInfoMap = new HashMap<String, Object>();
		
		String highestRole = MyRepositoryUtil.getHighestRole(user.getUserId(), groupId);
		if(highestRole != null && !highestRole.equals("")) {
			Role role = RoleLocalServiceUtil.getRole(companyId, highestRole);
			repository = GetterUtil.get(CustomUtil.strNull(role.getExpandoBridge().getAttribute("Storagelimit"), "1000000"), 1000000L);
		}
		
		String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
		IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
		long userRepository = GetterUtil.get(SimulationLocalServiceUtil.getUserRepositorySize(icebreakerUrl, vcToken.getVcToken()), 0L);
		if(userRepository > repository) {
			repositoryPercent = 100;
		} else {
			repositoryPercent = (float) (userRepository * 100 / repository);
		}
		
		repositoryInfoMap.put("groupId", groupId);
		// 파일 정보 저장
		repositoryInfoMap.put("repositoryPercent", Math.abs(repositoryPercent));
		repositoryInfoMap.put("userRepository", MyRepositoryUtil.humanReadableByteCount(userRepository, false));
		repositoryInfoMap.put("repository", MyRepositoryUtil.humanReadableByteCount(repository, false));
		// cpu 정보 저장
		
		int checkRoleNumber = checkCoreLimit(icebreakerUrl, user, vcToken.getVcToken(), groupId).getCurrentCores();
		if (checkRoleNumber > 0) {
			userCpuRepository = checkRoleNumber;
		}
		int cpuRepository = getUserAssignmentCores(user, groupId);
		float cpuRepositoryPercent = 0F;
		if(userCpuRepository > cpuRepository) {
			cpuRepositoryPercent = 100;
		} else {
			cpuRepositoryPercent = (float) (userCpuRepository * 100 / cpuRepository);
		}
		
		repositoryInfoMap.put("cpuRepositoryPercent", Math.abs(cpuRepositoryPercent));
		repositoryInfoMap.put("userCpuRepository", CustomUtil.strNull(userCpuRepository));
		repositoryInfoMap.put("cpuRepository", CustomUtil.strNull(cpuRepository));
		
		JSONObject obj = new JSONObject();
		
		obj.put("repositoryInfoMap", repositoryInfoMap);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}
	
	class CheckCoreResult{
		public CheckCoreResult(){
			checkCore = false;
		}
		private int currentCores;
		private int userAssignmentCores;
		private boolean checkCore;
		
		public boolean isCheckCore() {
			return checkCore;
		}
		public void setCheckCore(boolean checkCore) {
			this.checkCore = checkCore;
		}
		public int getCurrentCores() {
			return currentCores;
		}
		public void setCurrentCores(int currentCores) {
			this.currentCores = currentCores;
		}		
		public int getUserAssignmentCores() {
			return userAssignmentCores;
		}
		public void setUserAssignmentCores(int userAssignmentCores) {
			this.userAssignmentCores = userAssignmentCores;
		}
		
	}	
	
	protected int getUserAssignmentCores(User user, long groupId) throws NumberFormatException, SystemException, PortalException{
		int userAssignmentCores = 0;
		int tempCoreLimit = 0;
		
		if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)){
			//admin 갯수
			userAssignmentCores = Integer.parseInt(CustomUtil.strNull(RoleLocalServiceUtil.getRole(user.getCompanyId(), RoleConstants.ADMINISTRATOR).getExpandoBridge().getAttribute("coreLimit"), "1"));
		}else{
			if (EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.TEMP_USER)) {
				userAssignmentCores = Integer.parseInt(CustomUtil.strNull(RoleLocalServiceUtil.getRole(user.getCompanyId(), EdisonRoleConstants.TEMP_USER).getExpandoBridge().getAttribute("coreLimit"), "1"));
				
			} else {
				userAssignmentCores = Integer.parseInt(CustomUtil.strNull(RoleLocalServiceUtil.getRole(user.getCompanyId(), RoleConstants.USER).getExpandoBridge().getAttribute("coreLimit"), "1"));

				List<UserGroupRole> roleList = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId(), groupId);
				
				for(UserGroupRole userGroupRole : roleList){
					if(userGroupRole.getRole().getExpandoBridge().hasAttribute("coreLimit")){
						tempCoreLimit = Integer.parseInt(CustomUtil.strNull(userGroupRole.getRole().getExpandoBridge().getAttribute("coreLimit"), "0"));
						if(userAssignmentCores < tempCoreLimit){
							userAssignmentCores = tempCoreLimit;
						}
					}
				}
			}
		}
		
		return userAssignmentCores;
	}
	
	protected CheckCoreResult checkCoreLimit(String icebreakerUrl, User user, String vcToken, long groupId) throws Exception {
		//Current running and queueing core count check
		Map param = new HashMap();
		
		CheckCoreResult checkCoreResult = new CheckCoreResult();
		
		int userAssignmentCores = getUserAssignmentCores(user, groupId);
		
		JSONObject jsonResult = JSONObject.fromObject(JSONSerializer.toJSON((SimulationLocalServiceUtil.getCurrentAssignedCoresByUser(icebreakerUrl, vcToken))));
		
		int myUseCores = jsonResult.getInt("coresRunning") + jsonResult.getInt("coresQueued");
		
		checkCoreResult.setCurrentCores(myUseCores);
		checkCoreResult.setUserAssignmentCores(userAssignmentCores);
		
		return checkCoreResult;
	}
}
