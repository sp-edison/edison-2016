package org.kisti.edison.bestsimulation.portlet.statistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletResponse;

import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;
import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.ExcelUtil;
import org.kisti.edison.util.HtmlFormUtils;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class EdisonStatisticsAppController {

	private static Log log = LogFactoryUtil.getLog(EdisonStatisticsExecController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) throws PortalException, SystemException, WindowStateException {
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
		model.addAttribute("orgListStr", orgListStr);
		
		return "statistics/sw"; 
	}

	@ResourceMapping(value="getStatisticsSw")
	public void getStatisticsSw(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, ParseException, IOException{
		Map params = RequestUtil.getParameterMap(request);

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	
			String startDt = CustomUtil.strNull(params.get("startDt"));
			String endDt = CustomUtil.strNull(params.get("endDt"));
			long universityId = Long.parseLong(CustomUtil.strNull(params.get("scienceApp_affiliation_id"), "0"));
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("visitSite"), "0"));
			long entryId = AssetEntryLocalServiceUtil.fetchEntry(Group.class.getName(), groupId).getEntryId();
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(group.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			long columnId = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.USER_UNIVERSITY).getColumnId();
			long vocabularyId = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getCompany().getGroupId(), EdisonAssetCategory.GLOBAL_DOMAIN).getVocabularyId();
			
			List tableOrganigationList  = SimulationJobLocalServiceUtil.getStatisticsSwTableOrganigation(entryId, vocabularyId, columnId, themeDisplay.getLanguageId(), startDt, endDt, universityId);

			List barChartDateList  = SimulationJobLocalServiceUtil.getStatisticsSwBarChartDate(entryId, vocabularyId, columnId, startDt, endDt, universityId);
			
			JSONObject obj = new JSONObject();
			
			obj.put("tableOrganigationList", tableOrganigationList);
			obj.put("pieChartOrganigationList", tableOrganigationList);
			obj.put("barChartDateList", barChartDateList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
	}	
	
	@ResourceMapping(value="excelDown")
	public void excelDown(ResourceRequest request, ResourceResponse response){
		Map params = RequestUtil.getParameterMap(request);
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
		try {		
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	
			String startDt = CustomUtil.strNull(params.get("startDt"));
			String endDt = CustomUtil.strNull(params.get("endDt"));
			long universityId = Long.parseLong(CustomUtil.strNull(params.get("scienceApp_affiliation_id"), "0"));
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("visitSite"), "0"));
			long entryId = AssetEntryLocalServiceUtil.fetchEntry(Group.class.getName(), themeDisplay.getSiteGroupId()).getEntryId();
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(group.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			long columnId = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.USER_UNIVERSITY).getColumnId();
			long vocabularyId = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getCompany().getGroupId(), EdisonAssetCategory.GLOBAL_DOMAIN).getVocabularyId();
	
			List tableOrganigationList  = SimulationJobLocalServiceUtil.getStatisticsSwTableOrganigation(entryId, vocabularyId, columnId, themeDisplay.getLanguageId(), startDt, endDt, universityId);
			
			String university = LanguageUtil.get(themeDisplay.getLocale(), "edison-create-account-field-title-university");
			String regCnt = LanguageUtil.get(themeDisplay.getLocale(), "edison-science-appstore-view-regist-count");
			
			String[] logical_names = {
					university,		regCnt
			};
			int[] widths = {
					50,								20
			};
			String[] physical_names = {
					"scienceApp_affiliation_id_name",	"cnt"
			};

			String downFileName = "SWStatistics_"+CustomUtil.dateToStringFormat(new Date(), "yyyy.MM.dd");		
			ExcelUtil.excelDownload(httpResponse, logical_names, physical_names, widths, downFileName, tableOrganigationList);
			
		} catch (PortalException e) {
			log.error("PortalException");
		} catch (SystemException e) {
			log.error("SystemException");
		} catch (ParseException e) {
			log.error("ParseException");
		} catch (IOException e) {
			log.error("IOException");
		}
	}
	
	
	/**
	 * SELECT 박스 조회
	 * @param request
	 * @param response
	 * @throws ParseException 
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws NumberFormatException 
	 * @throws JSONException 
	 * @throws IOException
	 * @throws SQLException
	 */
	@ResourceMapping(value ="searchSelect" )
	public void searchSelect(ResourceRequest request, ResourceResponse response) throws NumberFormatException, PortalException, SystemException, ParseException, IOException{
		Map params = RequestUtil.getParameterMap(request);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List dataList = new ArrayList();
		
		String status = CustomUtil.strNull(params.get("status"));
		long groupId = Long.parseLong(CustomUtil.strNull(params.get("visitSite"), "0"));
		
		if(status.equals("uni")){
			dataList = (List) SimulationJobLocalServiceUtil.getListVirtualLabSearchUni(groupId, themeDisplay.getLanguageId(), Long.parseLong(CustomUtil.strNull(params.get("jobUniversityField"), "0")));
		}else if(status.equals("cyb")){
			dataList = (List) SimulationJobLocalServiceUtil.getListVirtualClassSearchLab(groupId, themeDisplay.getLanguageId(), Long.parseLong(CustomUtil.strNull(params.get("jobVirtualLabId"), "0")));
		}

		JSONObject obj = new JSONObject();
		
		obj.put("dataList", dataList);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}	
		
}
