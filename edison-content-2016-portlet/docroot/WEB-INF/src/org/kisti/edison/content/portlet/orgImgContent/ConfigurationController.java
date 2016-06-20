package org.kisti.edison.content.portlet.orgImgContent;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletContext;

import org.kisti.edison.content.model.OrgImgContent;
import org.kisti.edison.content.service.OrgImgContentLocalServiceUtil;
import org.kisti.edison.content.service.persistence.OrgImgContentPK;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.RequestUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletConfigFactoryUtil;

public class ConfigurationController implements ConfigurationAction{
	
	@Override
	public void processAction(PortletConfig portletConfig, 
			ActionRequest actionRequest, 
			ActionResponse actionResponse)	throws Exception {
		
		Map param = RequestUtil.getParameterMap(actionRequest);
		String myaction = CustomUtil.strNull(param.get("myaction"));
		
		if(myaction.equals("modifyOption")){
			modifyOption(actionRequest,actionResponse,param);
		}else if(myaction.equals("modifyFileAdd")){
			modifyFileAdd(actionRequest,actionResponse,param);
		}else if(myaction.equals("modifyFileList")){
			modifyFileList(actionRequest,actionResponse,param);
		}
	}
	
	/**
	 * fileList update
	 * @param actionRequest
	 * @param response
	 * @param param
	 */
	public void modifyFileList(ActionRequest actionRequest, ActionResponse response,Map param){
		String mode = CustomUtil.strNull(param.get("mode"));
		
		long groupId = GetterUtil.getLong(param.get("groupId"));
		long orgImgSeq = GetterUtil.getLong(param.get("orgImgSeq"));
		
		if(mode.equals(Constants.UPDATE)){
			try {
				OrgImgContentLocalServiceUtil.updateOrgImgContentWithOrder(groupId, param);
				SessionMessages.add(actionRequest, EdisonMessageConstants.UPDATE_SUCCESS);
			} catch (Exception e) {
				SessionErrors.add(actionRequest, EdisonMessageConstants.UPDATE_ERROR);
				e.printStackTrace();
			}
		}else if(mode.equals(Constants.DELETE)){
			long fileEntryId = GetterUtil.getLong(param.get("fileEntryId"));
			long order = GetterUtil.getLong(param.get("order"));
			
			try {
				OrgImgContentLocalServiceUtil.deleteResetOrder(groupId, orgImgSeq, order,fileEntryId);
				SessionMessages.add(actionRequest, EdisonMessageConstants.DELETE_SUCCESS);
			} catch (Exception e) {
				SessionErrors.add(actionRequest, EdisonMessageConstants.DELETE_ERROR);
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * option update
	 * @param actionRequest
	 * @param response
	 * @param param
	 */
	public void modifyOption(ActionRequest actionRequest, ActionResponse response,Map param){
		String groupId = CustomUtil.strNull(param.get("groupId"));
		String items = CustomUtil.strNull(param.get("items"));
		String autoPlay = CustomUtil.strNull(param.get("autoPlay"));
		String rewindSpeed = CustomUtil.strNull(param.get("rewindSpeed"));
		
		PortletPreferences prefs = actionRequest.getPreferences();
		try {
			prefs.setValue(groupId+"_items", items);
			prefs.setValue(groupId+"_autoPlay", autoPlay);
			prefs.setValue(groupId+"_rewindSpeed", rewindSpeed);
			prefs.store();
			SessionMessages.add(actionRequest, EdisonMessageConstants.UPDATE_SUCCESS);
		}catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, EdisonMessageConstants.UPDATE_ERROR);
		}
	}
	
	/**
	 * Image Scroll File 추가
	 * @param actionRequest
	 * @param response
	 * @param param
	 */
	public void modifyFileAdd(ActionRequest actionRequest, ActionResponse response,Map param){
		long groupId = GetterUtil.getLong(param.get("groupId"));
		UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String preFix = "orgImgScroll_content";
		
		try {
			long orgImgSeq = CounterLocalServiceUtil.increment(OrgImgContent.class.getName());
			
			OrgImgContentPK orgImgContentPK = new OrgImgContentPK(orgImgSeq, groupId);
			OrgImgContent orgImgContent = OrgImgContentLocalServiceUtil.createOrgImgContent(orgImgContentPK);
			
			int totalCnt = OrgImgContentLocalServiceUtil.getOrgImgContentCountByGroupId(groupId);
			
			List<FileEntry> fileList = EdisonFileUtil.insertEdisonFile(
					actionRequest, 
					upload, 
					themeDisplay.getUserId(),
					groupId, 
					preFix, 
					String.valueOf(groupId),
					"orgFileImg","");
			
			if(fileList.size()!=1){
				for(FileEntry fileEntry: fileList){
					EdisonFileUtil.deleteSingleEdisonFile(fileEntry.getFileEntryId());
				}
				throw new Exception();
			}else{
				FileEntry fileEntry = fileList.get(0);
				long order = totalCnt +1;
				orgImgContent.setOrder(order);
				orgImgContent.setOrgNm(CustomUtil.strNull(param.get("orgNm")));
				orgImgContent.setOrgLink(CustomUtil.strNull(param.get("orgLink")));
				orgImgContent.setFileEntryId(fileEntry.getFileEntryId());
				orgImgContent.setInsertId(themeDisplay.getUserId());
				orgImgContent.setInsertDate(new Date());
				
				OrgImgContentLocalServiceUtil.addOrgImgContent(orgImgContent);
			}
			
			SessionMessages.add(actionRequest, EdisonMessageConstants.INSERT_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, EdisonMessageConstants.INSERT_ERROR);
		}
		
	}
	
	@Override
	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getSiteGroupId();
		List<Map<String, Object>> orgImgContnetList = OrgImgContentLocalServiceUtil.getOrgImgContentListByGroupId(groupId,themeDisplay);
		
		
		PortletPreferences prefs = renderRequest.getPreferences();
		
		renderRequest.setAttribute("items", prefs.getValue(groupId+"_items", "6"));
		renderRequest.setAttribute("autoPlay", prefs.getValue(groupId+"_autoPlay", "4000"));
		renderRequest.setAttribute("rewindSpeed", prefs.getValue(groupId+"_rewindSpeed", "3000"));
		renderRequest.setAttribute("orgImgContnetList", orgImgContnetList);
		renderRequest.setAttribute("groupId", groupId);
		renderRequest.setAttribute("orgNm", "");
		renderRequest.setAttribute("orgLink", "");
		
		
		
		PortletConfig selPortletConfig = getSelPortletConfig(renderRequest);

		String configTemplate = selPortletConfig.getInitParameter("config-template");
		
		if (Validator.isNotNull(configTemplate)) {
			return configTemplate;
		}

		String configJSP = selPortletConfig.getInitParameter("config-jsp");
		
		if (Validator.isNotNull(configJSP)) {
			return configJSP;
		}
		return "/configuration.jsp";

	}
	
	protected PortletConfig getSelPortletConfig(PortletRequest portletRequest)
			throws SystemException {

			ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			String portletResource = ParamUtil.getString(
				portletRequest, "portletResource");

			Portlet selPortlet = PortletLocalServiceUtil.getPortletById(
				themeDisplay.getCompanyId(), portletResource);

			ServletContext servletContext =
				(ServletContext)portletRequest.getAttribute(WebKeys.CTX);

			PortletConfig selPortletConfig = PortletConfigFactoryUtil.create(
				selPortlet, servletContext);

			return selPortletConfig;
		}
}
