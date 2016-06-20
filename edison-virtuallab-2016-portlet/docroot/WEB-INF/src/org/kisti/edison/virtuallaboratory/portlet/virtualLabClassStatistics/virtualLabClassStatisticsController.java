package org.kisti.edison.virtuallaboratory.portlet.virtualLabClassStatistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.ExcelUtil;
import org.kisti.edison.util.HtmlFormUtils;
import org.kisti.edison.util.PagingUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.portlet.virtualLabClassStudentManagement.virtualLabClassStudentManagementController;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("VIEW")
public class virtualLabClassStatisticsController {
	private static Log log = LogFactoryUtil.getLog(virtualLabClassStudentManagementController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response,ModelMap model){
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		String toDay = CustomUtil.dateToStringFormat(new Date(), "yyyy-MM-dd");
		int preYear = Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyy"));
		String preDay = (preYear-1)+"-01-01";

		
		List<Map<String, String>> orgList = EdisonExpndoUtil.getCodeListByUpCode("1501", themeDisplay.getLocale());
		String orgListStr = HtmlFormUtils.makeCombo(orgList, "");	// 공통 코드		

		String visitSite ="";		
		try{
			Group thisGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getSiteGroupId());			
			boolean isPortalMain = true;			
			
			if(thisGroup.getParentGroupId() > 0){//child site
				isPortalMain = false;
				visitSite = String.valueOf(themeDisplay.getSiteGroupId());
			}else{
				//하위 사이트 존재 여부
				boolean isChildrenSite = false;
				if(GroupLocalServiceUtil.getGroups(companyId, PortalUtil.getScopeGroupId(request), true).size()>0){
					isChildrenSite = true;
				}
				
				if(isChildrenSite){
					long selectGroupId = ParamUtil.getLong(request, "groupId",0);				
					Group selectGroup = null;
					
					if(selectGroupId == 0){
						selectGroup = thisGroup;
					}else{
						selectGroup = GroupLocalServiceUtil.getGroup(selectGroupId);	
					}

					if(selectGroupId != 0){
						Group group = GroupLocalServiceUtil.getGroup(selectGroupId);
						themeDisplay.getUser().getExpandoBridge().setAttribute(EdisonExpando.USER_VISIT_SITE,selectGroup.getName());				
					}
					
					//TABS VALUE CREATE
					List<com.liferay.portal.model.Group> parentGroupList = GroupLocalServiceUtil.getGroups(companyId, 0, true);
					Group parentGroup = null;
					for(Group group:parentGroupList){
						if(group.getName().toUpperCase().equals("GUEST")){
							parentGroup = group;
							break;
						}
					}
					
					String groupName = "";
					int groupCnt = 0;
					String groupId = "";
					
					if(themeDisplay.isSignedIn()){
						visitSite = themeDisplay.getUser().getExpandoBridge().getAttribute(EdisonExpando.USER_VISIT_SITE).toString();
					}else{
						visitSite = themeDisplay.getSiteGroupName();
					}
									
					List<Group> groupList = CustomUtil.getGroupIdASC(GroupLocalServiceUtil.getGroups(companyId, parentGroup.getGroupId(), true));

					for(Group group:groupList){
						if(groupCnt==0){
							groupName += group.getName();
							groupId += group.getGroupId();
							groupCnt++;
						}else{
							groupName += ","+group.getName();
							groupId += ","+group.getGroupId();
						}
						
						if(visitSite.equals(group.getName())){
							visitSite = Long.toString(group.getGroupId());
						}
					}

					if(visitSite.equals("") && groupList.size() > 0){
						visitSite = Long.toString(groupList.get(0).getGroupId());
					}
					
					model.addAttribute("tabNames", groupName);
					model.addAttribute("tabsValues", groupId);
				}else{
					isPortalMain = false;
					visitSite = Long.toString(PortalUtil.getScopeGroupId(request));
				}
				
				
			}

			model.addAttribute("isPortalMain", isPortalMain);
			model.addAttribute("visitSite", visitSite);
			
		}catch(Exception e){
			e.printStackTrace();
		}		

		model.addAttribute("preDay", preDay);
		model.addAttribute("toDay", toDay);
		model.addAttribute("orgListStr", orgListStr);
		return "virtualLabClassStatistics/virtualClassStatistics";
	}
	
	//탭 이벤트 저장
	@ActionMapping(params="myaction=saveClickTabSatis")
	public void saveClickTab(ActionRequest request, ActionResponse response){
		try{
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map param = RequestUtil.getParameterMap(request);
			long groupId = ParamUtil.getLong(request, "groupId",0);
			
			if(themeDisplay.isSignedIn()) {
				if(groupId!=0){
					Group group = GroupLocalServiceUtil.getGroup(groupId);
					themeDisplay.getUser().getExpandoBridge().setAttribute(EdisonExpando.USER_VISIT_SITE,group.getName());
				}
			}
			long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonvirtuallabclassstatistics_WAR_edisonvirtuallab2016portlet");
			PortletURL url = PortletURLFactoryUtil.create(request, "edisonvirtuallabclassstatistics_WAR_edisonvirtuallab2016portlet", plid, "");
			url.setParameter("groupId", CustomUtil.strNull(groupId));
			response.sendRedirect(url.toString());
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
	}
	
	@ResourceMapping(value ="classStatisticsList" ) //하위사이트 groupId로 각 리스트 가져오기
	public void classStatisticsList(ResourceRequest request, ResourceResponse response) throws IOException{
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			Map<String, Object> params = RequestUtil.getParameterMap(request);
			
			params.put("languageId", themeDisplay.getLocale().toString());
		
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("visitSite"),String.valueOf(PortalUtil.getScopeGroupId(request))));
			long userId = PortalUtil.getUserId(request);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			int curPage = Integer.parseInt(CustomUtil.strNull(params.get("curPage"), "1"));
			int linePerPage = Integer.parseInt(CustomUtil.strNull(params.get("select_line"), "10"));
			int pagePerBlock = 5;
			int begin = linePerPage * (curPage - 1);
			
			params.put("userId", userId);
			params.put("groupId", groupId);
			params.put("begin", String.valueOf(begin));
			params.put("end", String.valueOf(linePerPage));
			List<Map<String, Object>> statisticsDataList = VirtualLabClassLocalServiceUtil.getVirtualClassStatisticsList(params, themeDisplay.getLocale());
			int statisticsCount = VirtualLabClassLocalServiceUtil.getCountVirtualClassStatistics(params, themeDisplay.getLocale()); //총 개수
			
			String pagingStr = PagingUtil.getPaging(request.getContextPath(), response.getNamespace()+"dataSearchList", statisticsCount, curPage, linePerPage, pagePerBlock);

			int totalCnt = statisticsCount;
			
			JSONObject obj = new JSONObject();
			obj.put("dataList", statisticsDataList);
			obj.put("pageList", pagingStr);
			obj.put("select_line", linePerPage);
			obj.put("curPage", curPage);
			obj.put("totalCnt", totalCnt);
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@ResourceMapping(value="classStatisticsExcelDownLoad")
	public void surveyExcelDownLoad(ResourceRequest request, ResourceResponse response)  throws IOException{
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
		
		try {
			Map params = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("visitSite"),String.valueOf(PortalUtil.getScopeGroupId(request))));
			params.put("groupId", groupId);
			params.put("languageId", themeDisplay.getLocale().toString());
			
			List resultList = VirtualLabClassLocalServiceUtil.getVirtualClassStatisticsExcelList(params, themeDisplay.getLocale());
			
			String[] logical_names = {
					"대학교/기관",		"클래스명",		"지도교수",		"활용SW", 
					"학생 수",			"실행학생 수",	"수업코드",		"실행수",	"CPU Time"
			};
			int[] widths = {
					20,				40,				10,					100,
					10,				10,				10,					10,			10
			};
			
			String[] physical_names = {
					"university",	"classTitle",	"virtualLabPersonName",	"scienceAppTitle",
					"registerStudentCnt",	"executeStudentcount",	"classId",	"executeCount",	"avgerageRuntime"
			};
	
			String downFileName = "VirtualClassStatistics_"+CustomUtil.dateToStringFormat(new Date(), "yyyy.MM.dd");		
			
			ExcelUtil.excelDownload(httpResponse, logical_names, physical_names, widths, downFileName, resultList);
			//The method makeHSSFWorkbook(String[], String[], int[], String, List)
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
