package org.kisti.edison.bestsimulation.portlet.statistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;

import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class EdisonStatisticsExecTimeController {


	private static Log log = LogFactoryUtil.getLog(EdisonStatisticsExecController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) throws PortalException, SystemException, WindowStateException {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		String toDay = CustomUtil.dateToStringFormat(new Date(), "yyyy-MM-dd");
		int preYear = Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyy"));
		String preDay = (preYear-1)+"-01-01";

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
					long selectGroupId = ParamUtil.getLong(request, "thisGroupId",0);				
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
		
		return "statistics/time"; 
	}

	@ResourceMapping(value="getStatisticsTime")
	public void getStatisticsTime(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, ParseException, IOException{
		Map params = RequestUtil.getParameterMap(request);

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	
			String startDt = CustomUtil.strNull(params.get("startDt"));
			String endDt = CustomUtil.strNull(params.get("endDt"));
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("visitSite"), "0"));
			
			List tableOrganigationList  = SimulationJobLocalServiceUtil.getStatisticsTimeTableOrganigation(groupId, startDt, endDt);

			JSONObject obj = new JSONObject();
			
			obj.put("tableOrganigationList", tableOrganigationList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
	}	
		
}
