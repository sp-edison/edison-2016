package org.kisti.edison.bestsimulation.portlet.monitoring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.kisti.edison.bestsimulation.model.Simulation;
import org.kisti.edison.bestsimulation.model.SimulationJob;
import org.kisti.edison.bestsimulation.model.SimulationJobData;
import org.kisti.edison.bestsimulation.service.SimulationJobDataLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK;
import org.kisti.edison.bestsimulation.service.persistence.SimulationPK;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.science.model.PortTypeAnalyzerLink;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.model.ScienceAppOutputPorts;
import org.kisti.edison.science.service.PortTypeAnalyzerLinkLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppInputPortsLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppOutputPortsLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("VIEW")
public class MonitoringController {
	private static Log log = LogFactoryUtil.getLog(MonitoringController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map param = RequestUtil.getParameterMap(request);
		
		try{
			String visitSite ="";
			long visitSiteGroupId =0L;
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
							model.addAttribute("visitSite", Long.toString(group.getGroupId()));
							visitSiteGroupId = group.getGroupId();
						}
						
					}
				}
				model.addAttribute("tabNames", groupName);
				model.addAttribute("tabsValues", groupId);
				
				net.sf.json.JSONObject json = new net.sf.json.JSONObject();
				json.putAll(GroupMap);
				model.addAttribute("groupMap", json.toString());
				model.addAttribute("parentGroupId", parentGroupId);
				
			}else{
				//상세 사이트 일경우 Tab Not View
				model.addAttribute("visitSite", PortalUtil.getScopeGroupId(request));
				model.addAttribute("parentGroupId", parentGroupId);
			}
			
			//DATA 조회
			long selectedGroupId = GetterUtil.getLong(param.get("selectedGroupId"),0L);
			if(selectedGroupId==0L){
				selectedGroupId = visitSiteGroupId==0L?PortalUtil.getScopeGroupId(request):visitSiteGroupId;
			}
			
			//search parameterset - jobVirtualLabId - jobClassId
			Long jobVirtualLabId = ParamUtil.getLong(request, "jobVirtualLabId", 0L);
			Long jobClassId = ParamUtil.getLong(request, "jobClassId", 0L);
			boolean virtualLabDefaultUserSearch = false;
			
			//search parameterset - userId
			long userId = ParamUtil.getLong(request, "userId", 0L);
			User user = themeDisplay.getUser();
			//관리자 - 조회
			boolean deleteMonitoring = false;
			if(EdisonUserUtil.isPowerUserThan(user)){
				if(!EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)){
					if(!EdisonUserUtil.isSiteRole(user, selectedGroupId, RoleConstants.SITE_ADMINISTRATOR)){
						userId = user.getUserId();
					}else{
						//분야별 관리자 일경우 해당 분야의 모니터링 정보 삭제 가능
						deleteMonitoring = true;
					}
				}else{
					//포털 관리자 일경우 분야에 상관 없이 모니터링 정보 삭제 가능
					deleteMonitoring = true;
				}
			}else{
				//현재 접속한 userId를 추가
				userId = user.getUserId();
			}
			
			long classSearchUser = ParamUtil.getLong(request, "classSearchUser", 0L);
			//class에서 특정 유저에 대하여 모니터링을 조회 하는 경우
			if(classSearchUser!=0L){
				userId = classSearchUser;
				User classUser = UserLocalServiceUtil.getUser(classSearchUser);
				if(!EdisonUserUtil.isRegularRole(classUser, EdisonRoleConstants.TEMP_USER)){
					//class 에서 일반 유저를 조회 할 경우 조회 조건에서 jobVirtualLabId 와 jobClassId를 제거 한다.
					virtualLabDefaultUserSearch = true;
				}
				model.addAttribute("classSearchUser", classSearchUser);
			}
			
			model.addAttribute("deleteMonitoring", deleteMonitoring);
			
			//search parameterset - searchValue
			String searchValue = CustomUtil.strNull(param.get("searchValue"));
			
			//search parameterset - searchValue
			long jobStatus = GetterUtil.getLong(param.get("jobStatus"),0L);
			
			//Paging Set
			int currentPage = ParamUtil.get(request, "currentPage", 1);
			int listSize = ParamUtil.get(request, "searchLine", 10);
			int blockSize = 10;
			int start = ((currentPage - 1) * listSize);
			int totalCount = 0;
			
			if(virtualLabDefaultUserSearch){
				totalCount = SimulationJobLocalServiceUtil.getMonitoringCount(selectedGroupId, userId, 0, 0, searchValue, jobStatus);
			}else{
				totalCount = SimulationJobLocalServiceUtil.getMonitoringCount(selectedGroupId, userId, jobVirtualLabId, jobClassId, searchValue, jobStatus);
			}
					
					
			
			String portletNameSpace = themeDisplay.getPortletDisplay().getNamespace();
			//PAGEING 에서 Liferay에서 제공 하는 service를 통하여 조회 할 경우 end값은 listSize*currentPage
			//CustomQuery에서 조회 할 경우에는 listSiz가 들어간다.
			
			String paging = PagingUtil.getPaging(request.getContextPath(), portletNameSpace+"pageSearch", totalCount,currentPage, listSize, blockSize);
			List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
			
			if(virtualLabDefaultUserSearch){
				dataList = SimulationJobLocalServiceUtil.getMonitoringList(selectedGroupId, userId, 0, 0, searchValue, jobStatus, start, listSize);
			}else{ 
				dataList = SimulationJobLocalServiceUtil.getMonitoringList(selectedGroupId, userId, jobVirtualLabId, jobClassId, searchValue, jobStatus, start, listSize);
			}
			model.addAttribute("dataList", dataList);
			model.addAttribute("paging", paging);
			model.addAttribute("seq", totalCount - ((currentPage - 1)*listSize));
			model.addAttribute("selectedGroupId", selectedGroupId);
			model.addAttribute("jobVirtualLabId", jobVirtualLabId);
			model.addAttribute("jobClassId", jobClassId);
			model.addAttribute("tabViewYn",tabViewYn);
			model.addAttribute("tabUseStr",tabUseStr);
			
			//userId 조회 가능 여부 확인
			//userIdSearchStatus
			boolean userIdSearchStatus = false; 
			if(deleteMonitoring||jobVirtualLabId!=0L){
				userIdSearchStatus = true;
			}
			
			model.addAttribute("userIdSearchStatus", userIdSearchStatus);
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "monitoring/monitoring"; 
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
	
	//작업중지 API
	@ResourceMapping(value = "stopAPICall")
	public void stopAPICall(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, MalformedURLException, IOException, ParseException{
		Map param = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = ParamUtil.getLong(request, "groupId",0);
		User user = themeDisplay.getUser();
		String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
		String jobUuid = CustomUtil.strNull(param.get("jobUuid"));
		
		String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
		IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
		
		int result = SimulationLocalServiceUtil.cancleJob(icebreakerUrl, vcToken.getVcToken(), simulationUuid, jobUuid);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(Integer.toString(result));
	}
	
	//모니터링 job status update
	@ResourceMapping(value = "updateJobStatus")
	public void updateJobStatus(ResourceRequest request,ResourceResponse response) throws PortalException, SystemException{
		Map param = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
		String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
		long groupId = ParamUtil.getLong(request, "groupId",0);
		
		long jobStatus = ParamUtil.getLong(request, "jobStatus",0);
		SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, groupId);
		SimulationJob simulationJob = SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
		simulationJob.setJobStatus(jobStatus);
		SimulationJobLocalServiceUtil.updateSimulationJob(simulationJob);
	}
	
	//에러보기
	@ResourceMapping(value = "errorAPICall")
	public void errorView(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, IOException, ParseException{
		Map param = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = ParamUtil.getLong(request, "groupId",0);
		String jobUuid = CustomUtil.strNull(param.get("jobUuid"));
		User user = themeDisplay.getUser();
		String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
		IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
		
		String result = SimulationLocalServiceUtil.errorView(icebreakerUrl, vcToken.getVcToken(), jobUuid);
		result = result.replaceAll("[\"\']", " ");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(result);
	}
	
	//scienceApp 중간 파일 조회
	@ResourceMapping(value = "scienceAppMiddleFile")
	public void scienceAppMiddleFile(ResourceRequest request, ResourceResponse response) throws NumberFormatException, SystemException, IOException, PortalException, ParseException{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = themeDisplay.getPlid();
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
		
		long scienceAppId = ParamUtil.getLong(request, "scienceAppId",0);
		long groupId = ParamUtil.getLong(request, "groupId",0);
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("fileState", false);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		ScienceAppOutputPorts outputPorts = ScienceAppOutputPortsLocalServiceUtil.fetchScienceAppOutputPorts(scienceAppId);
		if(outputPorts != null) {
			String outputPortsJson = outputPorts.getOutputPorts();
			if(outputPortsJson != null && !outputPortsJson.equals("")) {
				JSONObject outputObj = JSONObject.fromObject(JSONSerializer.toJSON(outputPortsJson));
				Iterator<String> itr = outputObj.keys();
				while (itr.hasNext()) {
					String key = itr.next();
					if(StringUtil.toUpperCase(key).equals("TEMP")) {
						JSONObject jsonPort = outputObj.getJSONObject(key);
						long analyzer_id = GetterUtil.get(jsonPort.get("default-analyzer-id"), 0L);
						
						if(analyzer_id > 0) {
							Map<String,Object> portMap = new HashMap<String, Object>();
							
							String portName = GetterUtil.get(jsonPort.get("name"), key);
							portMap.put("portName", portName);
							String form = GetterUtil.get(jsonPort.get("form"), "");
							String fileName = GetterUtil.get(jsonPort.get("file-name"), "");
							
							PortTypeAnalyzerLink portTypeAnalyzerLink = PortTypeAnalyzerLinkLocalServiceUtil.fetchPortTypeAnalyzerLink(analyzer_id);
							if(portTypeAnalyzerLink != null) {
								long analyzerId = GetterUtil.getLong(portTypeAnalyzerLink.getAnalyzerId(), 0L);
								ScienceApp analyzerApp = ScienceAppLocalServiceUtil.getScienceApp(analyzerId);
								portMap.put("token", AuthTokenUtil.getToken(httpRequest,plid, analyzerApp.getExeFileName()));
								portMap.put("scienceAppId", scienceAppId );
								portMap.put("editorType", analyzerApp.getEditorType());
								portMap.put("name", analyzerApp.getName() );
								portMap.put("title", analyzerApp.getTitle(themeDisplay.getLocale()));
								portMap.put("exeFileName", analyzerApp.getExeFileName() );
								portMap.put("fileListType", StringUtil.toUpperCase(form));
								portMap.put("fileListValue", fileName);
								portMap.put("plid", plid);
								portMap.put("groupId", groupId);
							}
							
							long port_type_id = GetterUtil.get(jsonPort.get("port-type-id"), 0L);
							portMap.put("port_type_id", port_type_id);
							boolean mandatory = GetterUtil.get(jsonPort.get("mandatory"), false);
							portMap.put("mandatory", mandatory);
							jsonObj.put("portMap", portMap);
							jsonObj.put("fileState", true);
						}
						break;
					}
				}
			}
		}
		writer.write(jsonObj.toString());
	}
	
	//중간 그래프 확인
	@RenderMapping(params = "myaction=middleGraphView")
	public String middleGraphView(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			
			long groupId = ParamUtil.getLong(request, "groupId",0);
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			String jobUuid = CustomUtil.strNull(param.get("jobUuid"));
			String fileName = CustomUtil.strNull(param.get("fileName"));
			String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
			
			
			IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
			String result = SimulationLocalServiceUtil.retrieveFileId(icebreakerUrl, vcToken.getVcToken(), jobUuid, fileName);
			
			SimulationPK simulationPK = new SimulationPK(simulationUuid, groupId);
			Simulation simulation =  SimulationLocalServiceUtil.getSimulation(simulationPK);
			
			if (!CustomUtil.strNull(result).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				model.addAttribute("fileId", (String) jsonObj.get("id"));
			}
			
			model.addAttribute("jobUuid", jobUuid);
			model.addAttribute("scienceAppNm", simulation.getScienceAppName());
			model.addAttribute("selectedGroupId", groupId);
			model.addAttribute("jobTitle", simulation.getSimulationTitle());

		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "monitoring/middleGraphView";
	}
	
	//scienceApp 중간 파일 조회
	@ResourceMapping(value = "middleFileData")
	public void middleFileData(ResourceRequest request, ResourceResponse response) throws IOException, PortalException, SystemException, ParseException{
		Map param = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = ParamUtil.getLong(request, "groupId",0);
		String fileId = CustomUtil.strNull(param.get("fileId"));
		
		String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
		User user = themeDisplay.getUser();
		IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
		
		String fileContent = SimulationLocalServiceUtil.getResultRead(icebreakerUrl, vcToken.getVcToken(), fileId);
		PrintWriter writer = response.getWriter();
		
		//Data sampling
		int sampling_size = 100;
		String[] lines = fileContent.split("\n");
		String sampling_data = "";
		int sampling_count = 0;
		if(lines.length > sampling_size){
			int sampling_step = lines.length / sampling_size;
			int sampling_exp = lines.length % sampling_size;
			int i=0;
			while(i<lines.length){
				sampling_data += lines[i] +"\n";
				sampling_count++;
				i += sampling_step;
				if(sampling_exp>0){
					sampling_exp--;
					i++;
				}
			}
		}
		else{
			sampling_data = fileContent;
		}

		writer.write(sampling_data);
	}
	
	//결과 파일 다운로드
	@RenderMapping(params = "myaction=resultDownLoad")
	public String resultDownLoad(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long groupId = ParamUtil.getLong(request, "groupId",0);
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			User user = themeDisplay.getUser();
			IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
			String jobUuid = CustomUtil.strNull(param.get("jobUuid"));
			
			String result = SimulationLocalServiceUtil.retrievePostProcessor(icebreakerUrl, vcToken.getVcToken(), jobUuid);
			if (!CustomUtil.strNull(result).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				HashMap resultMap = null;
				List resultList = new ArrayList();
				
				for (int i = 0; i < jsonArray.size(); i++) {
					resultMap = new HashMap();
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					
					resultMap.put("fileName",comandObj.getString("name"));
					resultMap.put("fileId", comandObj.getString("id"));
					
					resultMap.put("filePureSize", comandObj.getDouble("size"));
					resultMap.put("fileSize", CustomUtil.fileVolumeCalc(String.valueOf(comandObj.getDouble("size"))));
					resultMap.put("jobUuid", jobUuid);
	
					resultList.add(resultMap);
				}
				Comparator<HashMap> kdComp = new Comparator<HashMap>() {
					@Override
					public int compare(HashMap o1, HashMap o2) {
						String s1 = o1.get("fileName").toString();
						String s2 = o2.get("fileName").toString();
						
						int n1=s1.length(), n2=s2.length();
						for (int i1=0, i2=0; i1<n1 && i2<n2; i1++, i2++) {
							char c1 = s1.charAt(i1);
							char c2 = s2.charAt(i2);
							if (c1 != c2) {
								c1 = Character.toUpperCase(c1);
								c2 = Character.toUpperCase(c2);
								if (c1 != c2) {
									c1 = Character.toLowerCase(c1);
									c2 = Character.toLowerCase(c2);
									if (c1 != c2) {
										return c1 - c2;
									}
								}
							}
						}
						return n1 - n2;
					}
				};
				
				Collections.sort(resultList, kdComp);
				model.addAttribute("resultList", resultList);
			}else{
				model.addAttribute("file_state", "false");
			}
			model.addAttribute("selectedGroupId", groupId);
			String publicIceBreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL_PUBLIC);
			
//			model.addAttribute("icebreakerUrl", publicIceBreakerUrl);
			model.addAttribute("icebreakerUrl", icebreakerUrl);
			
			
			// 임시 : Result.zip File ID
			String resultFileStr = SimulationLocalServiceUtil.retrieveRemoteDir(icebreakerUrl, vcToken.getVcToken(), jobUuid, "/");
			if (!CustomUtil.strNull(resultFileStr).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(resultFileStr));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				
				root1:for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					if( comandObj.getString("name").equals("result.zip")){
						model.addAttribute("zipFileId",comandObj.getString("id"));
						break root1;
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "monitoring/resultDownView";
	}
	
	//시뮬레이션 조회
	@ResourceMapping(value = "searchJobList")
	public void searchJobList(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, IOException, ParseException{
		Map param = RequestUtil.getParameterMap(request);
		long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
		String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
		long groupId = ParamUtil.getLong(request, "groupId",0);
		boolean jobStatusSearch = ParamUtil.getBoolean(request, "jobStatusSearch", false);
		
		response.setContentType("application/json; charset=UTF-8");
		JSONObject jsonObj = null;
		
		if(jobSeqNo==0){
			List<Map<String, Object>> resultList = SimulationJobLocalServiceUtil.getMonitoringJobList(groupId, simulationUuid);
			jsonObj = new JSONObject();
			jsonObj.put("dataList", resultList);
		}else{
			Map<String, Object> resultMap = SimulationJobLocalServiceUtil.getMonitoringJob(groupId, simulationUuid, jobSeqNo);
			jsonObj = new JSONObject();
			jsonObj.put("data", resultMap);
			
			if(jobStatusSearch){
				String jobUuid = CustomUtil.strNull(resultMap.get("jobUuid"));
				//simulationStatus 확인 - 20151228 - GPLUS
				//SimulationJobStatusLocalServiceUtil.getSimulationJobStatusBySimulationUuidASMonitoring(jobSeqNo,groupId, simulationUuid, jobUuid);
			}
		}
		
		PrintWriter out = response.getWriter();
		out.write(jsonObj.toString());
	}
	
	//시뮬레이션 job paramter 조회
	@ResourceMapping(value = "searchJobParam")
	public void searchJobParam(ResourceRequest request,ResourceResponse response) throws SystemException, IOException, PortalException, ParseException{
		Map param = RequestUtil.getParameterMap(request);
		
		String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
		long groupId = ParamUtil.getLong(request, "groupId",0);
		long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
		String jobUuid = ParamUtil.get(request, "jobUuid","");
		
		response.setContentType("application/json; charset=UTF-8");
		
		com.liferay.portal.kernel.json.JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
		//시뮬레이션 JOB 조회
		Map<String,Object> simulationJobMap = SimulationJobLocalServiceUtil.getMonitoringJob(groupId, simulationUuid, jobSeqNo);
		
		jsonObj.put("jobStatus", CustomUtil.strNull(simulationJobMap.get("jobStatus")));
		jsonObj.put("jobSubmitDt", CustomUtil.strNull(simulationJobMap.get("jobSubmitDt")));
		jsonObj.put("jobEndDt", CustomUtil.strNull(simulationJobMap.get("jobEndDt")));
		jsonObj.put("stayDt", CustomUtil.strNull(simulationJobMap.get("stayDt")));
		jsonObj.put("executeDt", CustomUtil.strNull(simulationJobMap.get("executeDt")));
		
		long scienceAppId = GetterUtil.get(simulationJobMap.get("scienceAppId"), 0L);

		if(scienceAppId > 0) {
			jsonObj.put("inputPorts", ScienceAppInputPortsLocalServiceUtil.getInputPortsJsonString(scienceAppId));
		} else {
			jsonObj.put("inputPorts", "");
		}
		
		SimulationJobData simulationJobData = SimulationJobDataLocalServiceUtil.fetchSimulationJobData(jobUuid);
		
		if(simulationJobData != null) {
			jsonObj.put("simulationJobData", simulationJobData.getJobData());
		} else {
			jsonObj.put("simulationJobData", "");
		}
		
		PrintWriter out = response.getWriter();
		out.write(jsonObj.toString());
	}
	
	//모니터링 삭제
	@ResourceMapping(value = "deleteJob")
	public void deleteJob(ResourceRequest request,ResourceResponse response) throws PortalException, SystemException, IOException{
		Map param = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
		long groupId = ParamUtil.getLong(request, "groupId",0);
		long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
		User user = themeDisplay.getUser();
		
		String returnResult = SimulationJobLocalServiceUtil.deleteMonitoring(simulationUuid, groupId, jobSeqNo, user);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(returnResult);
	}
	
	//후처리기 조회
	@ResourceMapping(value = "searchJobPostProcessor")
	public void searchJobPostProcessor(ResourceRequest request,ResourceResponse response) throws PortalException, SystemException, IOException{
		Map param = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY); 
		long plid = themeDisplay.getPlid();
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
		String resultMsg = "SUCCESS";
		long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
		String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
		String jobUuid = CustomUtil.strNull(param.get("jobUuid"));
		long groupId = ParamUtil.getLong(request, "groupId",0);
		List<Map<String, Object>> portMapList = null;
		String outputPort = "";
		
		SimulationPK simulationPK = new SimulationPK(simulationUuid, groupId);
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationPK);
		
		long scienceAppId = GetterUtil.get(simulation.getScienceAppId(), 0L);
		
		if(scienceAppId > 0L) {
			outputPort = ScienceAppOutputPortsLocalServiceUtil.getOutputPortsJsonString(scienceAppId);
		}
		
		if(outputPort != null && !outputPort.equals("")) {
			JSONObject outputPortJson = JSONObject.fromObject(JSONSerializer.toJSON(outputPort));
			Iterator<String> itr = outputPortJson.keys();
			portMapList = new ArrayList<Map<String, Object>>();
			while (itr.hasNext()) {
				String names = itr.next();
				if(!StringUtil.toUpperCase(names).equals("TEMP")) {
					JSONObject jsonPort = outputPortJson.getJSONObject(names);
					long analyzer_id = GetterUtil.get(jsonPort.get("default-analyzer-id"), 0L);
					
					if(analyzer_id > 0) {
						Map<String,Object> portMap = new HashMap<String, Object>();
						
						String portName = GetterUtil.get(jsonPort.get("name"), names);
						portMap.put("portName", portName);
						String form = GetterUtil.get(jsonPort.get("form"), "");
						String fileName = GetterUtil.get(jsonPort.get("file-name"), "");
						
						PortTypeAnalyzerLink portTypeAnalyzerLink = PortTypeAnalyzerLinkLocalServiceUtil.fetchPortTypeAnalyzerLink(analyzer_id);
						if(portTypeAnalyzerLink != null) {
							long analyzerId = GetterUtil.getLong(portTypeAnalyzerLink.getAnalyzerId(), 0L);
							ScienceApp analyzerApp = ScienceAppLocalServiceUtil.getScienceApp(analyzerId);
							portMap.put("token", AuthTokenUtil.getToken(httpRequest,plid, analyzerApp.getExeFileName()));
							portMap.put("scienceAppId", scienceAppId );
							portMap.put("editorType", analyzerApp.getEditorType());
							portMap.put("name", analyzerApp.getName() );
							portMap.put("title", analyzerApp.getTitle(themeDisplay.getLocale()));
							portMap.put("exeFileName", analyzerApp.getExeFileName() );
							portMap.put("jobUuid", jobUuid);
							portMap.put("fileListType", StringUtil.toUpperCase(form));
							portMap.put("fileListValue", fileName);
							portMap.put("jobSeqNo", jobSeqNo);
							portMap.put("plid", plid);
							portMap.put("groupId", groupId);
							
						} else {
							resultMsg = "FAILED";
						}
						
						long port_type_id = GetterUtil.get(jsonPort.get("port-type-id"), 0L);
						portMap.put("port_type_id", port_type_id);
						boolean mandatory = GetterUtil.get(jsonPort.get("mandatory"), false);
						portMap.put("mandatory", mandatory);
						portMapList.add(portMap);
						
					}
				}
			}
		}
		
		JSONObject obj = new JSONObject();
		obj.put("outputPortJson", outputPort);
		obj.put("portMapList", portMapList);
		obj.put("resultMsg", resultMsg);

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());

	}
	
	@RenderMapping(params = "myaction=postJmole")
	public String postJmoleView(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
			String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
			long groupId = ParamUtil.getLong(request, "groupId",0);
			
			User user = themeDisplay.getUser();
			
			SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, groupId);
			SimulationJob simulationJob =  SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
			
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
			
			String result = SimulationLocalServiceUtil.retrievePostProcessor(icebreakerUrl, vcToken.getVcToken(), simulationJob.getJobUuid());
			
			if (!CustomUtil.strNull(result).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				HashMap<String,Object> resultMap = null;
				List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
				for (int i = 0; i < jsonArray.size(); i++) {
					resultMap = new HashMap<String,Object>();
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					resultMap.put("fileName", comandObj.getString("name"));
					resultMap.put("fileId", comandObj.getString("id"));
					resultMap.put("fileSize", comandObj.getInt("size"));
					resultList.add(resultMap);
				}
				Comparator<HashMap> kdComp = new Comparator<HashMap>() {
					@Override
					public int compare(HashMap o1, HashMap o2) {
						String s1 = o1.get("fileName").toString();
						String s2 = o2.get("fileName").toString();
						
						int n1=s1.length(), n2=s2.length();
						for (int i1=0, i2=0; i1<n1 && i2<n2; i1++, i2++) {
							char c1 = s1.charAt(i1);
							char c2 = s2.charAt(i2);
							if (c1 != c2) {
								c1 = Character.toUpperCase(c1);
								c2 = Character.toUpperCase(c2);
								if (c1 != c2) {
									c1 = Character.toLowerCase(c1);
									c2 = Character.toLowerCase(c2);
									if (c1 != c2) {
										return c1 - c2;
									}
								}
							}
						}
						return n1 - n2;
					}
				};
				
				Collections.sort(resultList, kdComp); 
				
				model.addAttribute("resultList", resultList);
				String fileId = CustomUtil.strNull(param.get("fileId"));
				model.addAttribute("fileId", fileId);
				
				//JSP 에서는 화면에 icebreakerUrl을 PUBLIC URL 로 전송
				String publicIceBreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL_PUBLIC);
				model.addAttribute("icebreakerUrl",publicIceBreakerUrl);
				
				model.addAttribute("jobSeqNo",jobSeqNo);
				model.addAttribute("simulationUuid",simulationUuid);
				model.addAttribute("groupId",groupId);
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "postprocess/jMoleList";
	}
	
	@RenderMapping(params = "myaction=postOneDplot")
	public String postOnewDplotView(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
			String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
			long groupId = ParamUtil.getLong(request, "groupId",0);
			
			User user = themeDisplay.getUser();
			
			SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, groupId);
			// JOB 기본 정보 조회
			SimulationJob simulationJob =  SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
			
			SimulationPK simulationPK = new SimulationPK(simulationUuid, groupId);
			Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationPK);
			
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
			
			model.addAttribute("scienceAppNm",simulation.getScienceAppName());
			model.addAttribute("jobTitle",simulationJob.getJobTitle());
			
			String result = SimulationLocalServiceUtil.retrievePostProcessor(icebreakerUrl, vcToken.getVcToken(), simulationJob.getJobUuid());
	
			if (!CustomUtil.strNull(result).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				HashMap<String,Object> resultMap = null;
				List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
				for (int i = 0; i < jsonArray.size(); i++) {
					resultMap = new HashMap<String,Object>();
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					// only oneD
					if (comandObj.getString("name").substring(
									comandObj.getString("name").length() - 4,
									comandObj.getString("name").length()).equals("oneD")) {
						resultMap.put("fileName",comandObj.getString("name"));
						resultMap.put("fileId", comandObj.getString("id"));
						resultMap.put("fileSize", comandObj.getInt("size"));
						resultMap.put("fileContent", SimulationLocalServiceUtil.getResultRead(icebreakerUrl, vcToken.getVcToken(), comandObj.getString("id")));
	
						resultList.add(resultMap);
					}
				}
				Comparator<HashMap> kdComp = new Comparator<HashMap>() {
					@Override
					public int compare(HashMap o1, HashMap o2) {
						String s1 = o1.get("fileName").toString();
						String s2 = o2.get("fileName").toString();
						
						int n1=s1.length(), n2=s2.length();
						for (int i1=0, i2=0; i1<n1 && i2<n2; i1++, i2++) {
							char c1 = s1.charAt(i1);
							char c2 = s2.charAt(i2);
							if (c1 != c2) {
								c1 = Character.toUpperCase(c1);
								c2 = Character.toUpperCase(c2);
								if (c1 != c2) {
									c1 = Character.toLowerCase(c1);
									c2 = Character.toLowerCase(c2);
									if (c1 != c2) {
										return c1 - c2;
									}
								}
							}
						}
						return n1 - n2;
					}
				};
				
				Collections.sort(resultList, kdComp); 
				model.addAttribute("resultList", resultList);
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "postprocess/oneDplotList";
	}
	
	@RenderMapping(params = "myaction=postImageViewer")
	public String postImageViewer(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
			String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
			long groupId = ParamUtil.getLong(request, "groupId",0);
			
			User user = themeDisplay.getUser();
			
			SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, groupId);
			// JOB 기본 정보 조회
			SimulationJob simulationJob =  SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
			
			SimulationPK simulationPK = new SimulationPK(simulationUuid, groupId);
			Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationPK);
			
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
			
			model.addAttribute("scienceAppNm",simulation.getScienceAppName());
			model.addAttribute("jobTitle",simulationJob.getJobTitle());
			
			String result = SimulationLocalServiceUtil.retrievePostProcessor(icebreakerUrl, vcToken.getVcToken(), simulationJob.getJobUuid());
			
			if (!CustomUtil.strNull(result).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				HashMap<String,Object> resultMap = null;
				List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
				
				Pattern p = Pattern.compile("\\.(jpg|jpeg|png|gif|bmp|tif|tiff)$", Pattern.CASE_INSENSITIVE);
				Matcher m;
				for (int i = 0; i < jsonArray.size(); i++) {
					resultMap = new HashMap<String,Object>();
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					String fileName =comandObj.getString("name").toLowerCase();  
					// 이미지 파일만 리스트에 보이도록 한다 => 확장자 파일 관리하는 알고리즘 개발 완료시까지 임시로 indexof 사용
					m = p.matcher( fileName );
					if(m.find())
					{
						resultMap.put("fileName",
								comandObj.getString("name"));
						resultMap.put("fileId", comandObj.getString("id"));
						resultMap.put("fileSize", comandObj.getInt("size"));
	
						//resultMap.put("fileContent", SimulationLocalServiceUtil.getResultRead(icebreakerUrl, vcToken.getVcToken(), comandObj.getString("id")));
	
						resultList.add(resultMap);
					}
				}
				
				Comparator<HashMap> kdComp = new Comparator<HashMap>() {
					@Override
					public int compare(HashMap o1, HashMap o2) {
						String s1 = o1.get("fileName").toString();
						String s2 = o2.get("fileName").toString();
						
						int n1=s1.length(), n2=s2.length();
						for (int i1=0, i2=0; i1<n1 && i2<n2; i1++, i2++) {
							char c1 = s1.charAt(i1);
							char c2 = s2.charAt(i2);
							if (c1 != c2) {
								c1 = Character.toUpperCase(c1);
								c2 = Character.toUpperCase(c2);
								if (c1 != c2) {
									c1 = Character.toLowerCase(c1);
									c2 = Character.toLowerCase(c2);
									if (c1 != c2) {
										return c1 - c2;
									}
								}
							}
						}
						return n1 - n2;
					}
				};
				
				Collections.sort(resultList, kdComp); 
				model.addAttribute("resultList", resultList);
			}
			
			
			//JSP 에서는 화면에 icebreakerUrl을 PUBLIC URL 로 전송
			String publicIceBreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL_PUBLIC);
			model.addAttribute("icebreakerUrl", publicIceBreakerUrl);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}	
		return "postprocess/imageViewerList";
	}
	
	@RenderMapping(params = "myaction=postWebGLViewer")
	public String postWebGLViewer(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
			String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
			long groupId = ParamUtil.getLong(request, "groupId",0);
			
			User user = themeDisplay.getUser();
			
			SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, groupId);
			// JOB 기본 정보 조회
			SimulationJob simulationJob =  SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
			
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
			String result = SimulationLocalServiceUtil.retrievePostProcessor(icebreakerUrl, vcToken.getVcToken(), simulationJob.getJobUuid());
			
			Pattern p = Pattern.compile("\\.(html|htm)$", Pattern.CASE_INSENSITIVE);
			Matcher m;
			String resultFilePath = "";
			if (!CustomUtil.strNull(result).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				HashMap<String,Object> resultMap = null;
				List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();

				// 미리 결과 파일을 전송해둔다.
				resultFilePath = SimulationLocalServiceUtil.getResultFile(icebreakerUrl, vcToken.getVcToken(), simulationJob.getJobUuid(), "result.zip");
				
				for (int i = 0; i < jsonArray.size(); i++) {
					resultMap = new HashMap<String,Object>();
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					
					//SimulationLocalServiceUtil.getFilePath(icebreakerUrl, vcToken.toString(), simulationUuid, comandObj.getString("id"), comandObj.getString("name"));
					
					// HTML 관련 파일만 리스트에 보이도록 한다 => 확장자 파일 관리하는 알고리즘 개발 완료시까지 임시로 indexof 사용
					String fileName = comandObj.getString("name").toLowerCase();
					m = p.matcher( fileName );
					if(m.find())
					{
						resultMap.put("fileName",comandObj.getString("name"));
						resultMap.put("fileId", comandObj.getString("id"));
						resultMap.put("fileSize", comandObj.getInt("size"));
	
						//resultMap.put("fileContent", SimulationLocalServiceUtil.getResultRead(icebreakerUrl, vcToken.getVcToken(), comandObj.getString("id")));
						resultList.add(resultMap);
					}
				}
				
				Comparator<HashMap> kdComp = new Comparator<HashMap>() {
					@Override
					public int compare(HashMap o1, HashMap o2) {
						String s1 = o1.get("fileName").toString();
						String s2 = o2.get("fileName").toString();
						
						int n1=s1.length(), n2=s2.length();
						for (int i1=0, i2=0; i1<n1 && i2<n2; i1++, i2++) {
							char c1 = s1.charAt(i1);
							char c2 = s2.charAt(i2);
							if (c1 != c2) {
								c1 = Character.toUpperCase(c1);
								c2 = Character.toUpperCase(c2);
								if (c1 != c2) {
									c1 = Character.toLowerCase(c1);
									c2 = Character.toLowerCase(c2);
									if (c1 != c2) {
										return c1 - c2;
									}
								}
							}
						}
						return n1 - n2;
					}
				};
				
				Collections.sort(resultList, kdComp); 
				model.addAttribute("resultList", resultList);
				model.addAttribute("resultFilePath", resultFilePath);
				
				
			}
			
			//JSP 에서는 화면에 icebreakerUrl을 PUBLIC URL 로 전송
			String publicIceBreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL_PUBLIC);
			model.addAttribute("icebreakerUrl",publicIceBreakerUrl);
			model.addAttribute("vcToken",vcToken.getVcToken());
			model.addAttribute("simulationUuid",simulationUuid);
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "postprocess/webGLViewerList";
	}
	
	@RenderMapping(params = "myaction=postTextViewer")
	public String postTextViewer(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
			String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
			long groupId = ParamUtil.getLong(request, "groupId",0);
			
			User user = themeDisplay.getUser();
			
			SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, groupId);
			// JOB 기본 정보 조회
			SimulationJob simulationJob =  SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
			
			SimulationPK simulationPK = new SimulationPK(simulationUuid, groupId);
			Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationPK);
			
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
			
			model.addAttribute("scienceAppNm",simulation.getScienceAppName());
			model.addAttribute("jobTitle",simulationJob.getJobTitle());
	
			String result = SimulationLocalServiceUtil.retrievePostProcessor(icebreakerUrl, vcToken.getVcToken(), simulationJob.getJobUuid());
			
			Pattern p = Pattern.compile("\\.(jpg|jpeg|png|gif|bmp|tif|tiff)$", Pattern.CASE_INSENSITIVE);
			Matcher m;
			
			if (!CustomUtil.strNull(result).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				HashMap<String,Object> resultMap = null;
				List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
				for (int i = 0; i < jsonArray.size(); i++) {
					resultMap = new HashMap<String,Object>();
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					// HTML 관련 파일만 리스트에 보이도록 한다 => 확장자 파일 관리하는 알고리즘 개발 완료시까지 임시로 indexof 사용
					String fileName = comandObj.getString("name").toLowerCase();
					// 이미지 파일만 리스트에 보이도록 한다 => 확장자 파일 관리하는 알고리즘 개발 완료시까지 임시로 indexof 사용
					m = p.matcher( fileName );
					if(!m.find())
					{
						resultMap.put("fileName",comandObj.getString("name"));
						resultMap.put("fileId", comandObj.getString("id"));
						resultMap.put("fileSize", comandObj.getInt("size"));
		
						//resultMap.put("fileContent", SimulationLocalServiceUtil.getResultRead(icebreakerUrl, vcToken.getVcToken(), comandObj.getString("id")));
						resultList.add(resultMap);
					}
				}
				
				Comparator<HashMap> kdComp = new Comparator<HashMap>() {
					@Override
					public int compare(HashMap o1, HashMap o2) {
						String s1 = o1.get("fileName").toString();
						String s2 = o2.get("fileName").toString();
						
						int n1=s1.length(), n2=s2.length();
						for (int i1=0, i2=0; i1<n1 && i2<n2; i1++, i2++) {
							char c1 = s1.charAt(i1);
							char c2 = s2.charAt(i2);
							if (c1 != c2) {
								c1 = Character.toUpperCase(c1);
								c2 = Character.toUpperCase(c2);
								if (c1 != c2) {
									c1 = Character.toLowerCase(c1);
									c2 = Character.toLowerCase(c2);
									if (c1 != c2) {
										return c1 - c2;
									}
								}
							}
						}
						return n1 - n2;
					}
				};
				
				Collections.sort(resultList, kdComp); 
				model.addAttribute("resultList", resultList);
			}
			
			//JSP 에서는 화면에 icebreakerUrl을 PUBLIC URL 로 전송
			String publicIceBreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL_PUBLIC);
			model.addAttribute("icebreakerUrl",publicIceBreakerUrl);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "postprocess/textViewerList";
	}
	
	@ResourceMapping(value ="exeSearch")
	public void exeSearchUrl(ResourceRequest request, ResourceResponse response){
		try{
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long simulationPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonbestsimulation_WAR_edisonsimulationportlet");
			PortletURL simulationUrl = PortletURLFactoryUtil.create(request,"edisonbestsimulation_WAR_edisonsimulationportlet", simulationPlid, PortletRequest.RENDER_PHASE);
			simulationUrl.setWindowState(LiferayWindowState.MAXIMIZED);

			simulationUrl.setParameter("directGroupId", CustomUtil.strNull(param.get("groupId")));
			simulationUrl.setParameter("directScienceAppId", CustomUtil.strNull(param.get("scienceAppId")));
			simulationUrl.setParameter("directJobUuid", CustomUtil.strNull(param.get("jobUuid")));
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(simulationUrl.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	
	@ResourceMapping(value ="postTextViewer")
	public void postTextViewer(ResourceRequest request, ResourceResponse response){
		File tempFile = null;
		try{
			Map param = RequestUtil.getParameterMap(request);
			String icebreakerURL = CustomUtil.strNull(param.get("icebreakerURL"))+"/api/file/download?id=";
			String fileId = CustomUtil.strNull(param.get("fileId"));
			
			URL remoteFileURL = new URL(icebreakerURL+fileId);
			URLConnection uCon =  remoteFileURL.openConnection();
			InputStream is = uCon.getInputStream();
			
			tempFile = FileUtil.createTempFile(is);
			
			FileReader reader = new FileReader(tempFile);
			BufferedReader bufferReader = new BufferedReader(reader);
			String read="";
			StringBuffer readBuffer = new StringBuffer();
			int lineIndex=0;
			int areaIndex=0;
			int diviceIndex=1000;
			
			List fileAreaList = new ArrayList();
			while((read=bufferReader.readLine())!=null){
				readBuffer.append(read+"\r\n");
				if(lineIndex==diviceIndex){
					fileAreaList.add(areaIndex,readBuffer);
					
					
					readBuffer = new StringBuffer();
					areaIndex++;
					diviceIndex+=500;
				}
				lineIndex++;
			}
			
			if(areaIndex==0){
				fileAreaList.add(areaIndex,readBuffer);
			}
			
			JSONArray jsonArray=  JSONArray.fromObject(fileAreaList);
			FileUtil.delete(tempFile);
			
//			tempFile.delete();
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
//			out.write(FileUtil.read(tempFile));
			out.write(jsonArray.toString());
			
			reader.close();
			bufferReader.close();
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}finally{
			FileUtil.delete(tempFile);
		}
	}
}
