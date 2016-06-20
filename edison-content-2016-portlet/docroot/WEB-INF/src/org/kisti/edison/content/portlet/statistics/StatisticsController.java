package org.kisti.edison.content.portlet.statistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.kisti.edison.content.service.AdvancedContentLocalServiceUtil;
import org.kisti.edison.content.service.GeneralContentLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.ExcelUtil;
import org.kisti.edison.util.PagingUtil;
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
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class StatisticsController {
	private static Log log = LogFactoryUtil.getLog(StatisticsController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
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
	return "/content";
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
		
	
	@ResourceMapping(value="getStatisticsContent")
	public void getStatisticsContent(ResourceRequest request, ResourceResponse response) throws IOException, SystemException, JSONException{
		Map params = RequestUtil.getParameterMap(request);

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("visitSite"), "0"));
			
			JSONObject obj = new JSONObject();
			
			obj.put("pieChartOrganigationList", AdvancedContentLocalServiceUtil.getAdvancedContentListByGroupId(groupId, themeDisplay.getLocale()));
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
	}
	
	
	@ResourceMapping(value ="retrieveListGeneral")
	public void retrieveListGeneral(ResourceRequest request, ResourceResponse response){
		try{
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			Long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId")));
			Long contentDiv = ParamUtil.getLong(request, "contentDiv",0);
			
			int currentPage = ParamUtil.get(request, "currentPage", 1);
			int listSize = ParamUtil.get(request, "searchLine", 5);
			int blockSize = 10;
			int start = ((currentPage - 1) * listSize);
			
			User user = null;
			if(themeDisplay.isSignedIn()){
				user = themeDisplay.getUser();
			}
			
			List<Map<String, Object>> dataList = GeneralContentLocalServiceUtil.getGeneralContentStsList(groupId, contentDiv, start, listSize*currentPage, themeDisplay.getLocale());
			int totalCount = GeneralContentLocalServiceUtil.getGeneralContentCountByGroupId(groupId, contentDiv, "",themeDisplay.getLocale());
			
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
	
	
	@ResourceMapping(value="excelDown")
	public void excelDown(ResourceRequest request, ResourceResponse response){
		Map params = RequestUtil.getParameterMap(request);
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
		try {		
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	
			Long contentDiv = ParamUtil.getLong(request, "contentDiv",0);
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("visitSite"), "0"));
	
			int total = GeneralContentLocalServiceUtil.getGeneralContentCountByGroupId(groupId, contentDiv, "", themeDisplay.getLocale());
			List tableOrganigationList  = GeneralContentLocalServiceUtil.getGeneralContentStsList(groupId, contentDiv, 0, total, themeDisplay.getLocale());
			
			String[] logical_names = {
					"제목",		"등록자",		"등록일자",		"조회수"
			};
			int[] widths = {
					100,				40,				40,					20
			};
			String[] physical_names = {
					"title",	"insertNm",	"insertDate",	"downloadCnt"
			};

			String downFileName = "ContentStatistics_"+CustomUtil.dateToStringFormat(new Date(), "yyyy.MM.dd");		
			ExcelUtil.excelDownload(httpResponse, logical_names, physical_names, widths, downFileName, tableOrganigationList);
			
		} catch (PortalException e) {
			log.error("PortalException");
		} catch (SystemException e) {
			log.error("SystemException");
		} catch (ParseException e) {
			log.error("ParseException");
		} catch (IOException e) {
			log.error("IOException");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
