package org.kisti.edison.orgcodesearch;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

@Controller
@RequestMapping("VIEW")
public class OrgCodeSearchController {
	protected static Log  log = LogFactoryUtil.getLog(OrgCodeSearchController.class);
	
	@RequestMapping//default
	public String view(RenderRequest renderRequest, RenderResponse response, ModelMap model) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String upCode = renderRequest.getParameter("up_code");
		String comSearchType = CustomUtil.strNull(renderRequest.getParameter("com_search_type"));
		
		List<Map<String,String>> codeList = EdisonExpndoUtil.getCodeListByUpCode(upCode, themeDisplay.getLocale());
		
		renderRequest.setAttribute("codeList", codeList);
		renderRequest.setAttribute("comSearchType", comSearchType);
		
		String jspPath = "orgcodesearch/org_code_search";
		return jspPath;
	}
}