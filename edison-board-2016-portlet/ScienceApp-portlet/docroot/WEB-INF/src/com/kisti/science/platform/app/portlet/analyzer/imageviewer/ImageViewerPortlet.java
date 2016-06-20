package com.kisti.science.platform.app.portlet.analyzer.imageviewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ImageViewerPortlet extends MVCPortlet 
{
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
		System.err.println(portletId);
		/*
		try 
		{
			//초기 배포시 사이언스앱 정보를 확인하여 등록
			if(!ScienceAppLocalServiceUtil.existApp(portletId))
				ScienceAppLocalServiceUtil.createScienceApp(portletId, ScienceAppConstants.APP_TYPE_ANALYZER);
			
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				
			long jobSeqNo = ParamUtil.getLong(request, "jobSeqNo",0);
			String simulationUuid = CustomUtil.strNull(param.get("simulationUuid"));
			long groupId = ParamUtil.getLong(request, "groupId",0);
			
			if( simulationUuid != null  && groupId != 0)
			{
				User user = themeDisplay.getUser();
				
				SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, groupId);
				// JOB 기본 정보 조회
				SimulationJob simulationJob =  SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
				
				SimulationPK simulationPK = new SimulationPK(simulationUuid, groupId);
				Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationPK);
				
				String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
				IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
				
				String result = SimulationLocalServiceUtil.retrievePostProcessor(icebreakerUrl, vcToken.getVcToken(), simulationJob.getJobUuid());
				
				if (!CustomUtil.strNull(result).equals("")) 
				{
					JSONObject jsonObj = new JSONObject(result);
					org.json.JSONArray jsonArray = jsonObj.getJSONArray("files");
					HashMap<String,Object> resultMap = null;
					List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
					
					Pattern p = Pattern.compile("\\.(jpg|jpeg|png|gif|bmp|tif|tiff)$", Pattern.CASE_INSENSITIVE);
					Matcher m;
					for (int i = 0; i < jsonArray.length(); i++) 
					{
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

					Collections.sort(resultList, AnalyzerUtil.getSortedComparator());
					
					request.setAttribute("resultList",resultList);
					request.setAttribute("solverNm",simulation.getSolverName());
					request.setAttribute("jobTitle",simulationJob.getJobTitle() );
				}
				
				//JSP 에서는 화면에 icebreakerUrl을 PUBLIC URL 로 전송
				String publicIceBreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL_PUBLIC);
				request.setAttribute("icebreakerUrl", publicIceBreakerUrl );
			}					
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			log.error(e);
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}	
		*/
		
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> resultMap = new HashMap<String,Object>();		
		resultMap.put("fileName", "test01");
		resultMap.put("fileId", "https://www.edison.re.kr/documents/10194/0/move.gif/fc265bf3-01cc-4bb6-af27-2abae340c752?version=1.0&t=1463969650608");
		resultList.add(resultMap);
		
		resultMap = new HashMap<String,Object>();		
		resultMap.put("fileName", "test02");
		resultMap.put("fileId", "https://www.edison.re.kr/documents/10194/0/shot.gif/727e9cd4-1d32-461e-b323-37070f650994?version=1.0&t=1463969651000");
		resultList.add(resultMap);
		request.setAttribute("resultList",resultList);
		
		String viewTemplate = getInitParameter("view-template");
		PortletContext portletContext = getPortletContext();
		PortletRequestDispatcher portletRequestDispatcher = portletContext.getRequestDispatcher(viewTemplate);
		portletRequestDispatcher.include(request, response);
	}
}
