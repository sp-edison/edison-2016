package org.kisti.edison.multiboard.controller.board;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
import javax.servlet.ServletContext;

import org.kisti.edison.multiboard.service.BoardDivLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.RequestUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletConfigFactoryUtil;

public class ConfigurationController implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)	throws Exception {
		Map param = RequestUtil.getParameterMap(actionRequest);
		String myaction = CustomUtil.strNull(param.get("myaction"));
//		System.out.println("myaction : " + myaction);
		if(myaction.equals("option")){
			preferenceOption(actionRequest,actionResponse);
		}else if(myaction.equals("boardDiv")){
			boardDiv(actionRequest,actionResponse);
		}
		
	}
	
	public void preferenceOption(ActionRequest actionRequest, ActionResponse actionResponse) throws ReadOnlyException, ValidatorException, IOException {
		PortletPreferences prefs = actionRequest.getPreferences();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);				
				
		Set es = prefs.getMap().entrySet();
		Iterator entries = null;
		if(es != null){
			entries = es.iterator();
		}
		while (entries.hasNext()) {
			Map.Entry<String, String[]> thisEntry = (Map.Entry) entries.next();
			String key = CustomUtil.strNull(thisEntry.getKey());
			prefs.reset(key);
		}
		
		String[] keyTextBox		= actionRequest.getParameterValues("keyTextBox");
		String[] valueTextBox	= actionRequest.getParameterValues("valueTextBox");
		String[] prefPortletId = null;
		
		if(keyTextBox != null){
			for(int i=0;i<keyTextBox.length;i++){
				if(CustomUtil.strNull(keyTextBox[i]).equals("")) continue;
												
				prefs.setValue(keyTextBox[i], String.valueOf(valueTextBox[i]));

			}
		}		
		prefs.store();
	}
	
	public void boardDiv(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
		String[] numberArray = actionRequest.getParameterValues("numberArray");
		
//		BoardDivLocalServiceUtil.removeAll();
		
		for (String number : numberArray) {
			long divCd = ParamUtil.get(actionRequest, "divCd_" + number, 0);
			String titleNmFist = ParamUtil.get(actionRequest, "titleNmFirst_" + number, "");
			String titleNmSecond = ParamUtil.get(actionRequest, "titleNmSecond_" + number, "");
			String contentNm = ParamUtil.get(actionRequest, "contentNm_" + number, "");
			String divNm = ParamUtil.get(actionRequest, "divNm_" + number, "");
			boolean fileUpLoadUseYn = ParamUtil.get(actionRequest, "fileUpLoadUseYn_" + number, false);
			boolean popupYn = ParamUtil.get(actionRequest, "popupYn_" + number, false);
			boolean replyYn = ParamUtil.get(actionRequest, "replyYn_" + number, false);
			
			BoardDivLocalServiceUtil.insertBoardDiv(divCd, titleNmFist, titleNmSecond, contentNm, divNm, fileUpLoadUseYn, popupYn, replyYn);
		}
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
		List<Map<String,Object>> boardDivList = BoardDivLocalServiceUtil.getAllBoardDivs();
		int boardDivCount = BoardDivLocalServiceUtil.getBoardDivsCount();
		
		renderRequest.setAttribute("boardDivCount", boardDivCount);
		renderRequest.setAttribute("boardDivList", boardDivList);
		
		PortletConfig selPortletConfig = getSelPortletConfig(renderRequest);

		String configTemplate = selPortletConfig.getInitParameter(
			"config-template");
		
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
