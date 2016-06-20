package org.kisti.edison.project.portlet.uses;

import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

@Controller
@RequestMapping("VIEW")
public class UsesStatisticsController {
	
	private static Log log = LogFactoryUtil.getLog(UsesStatisticsController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		return "statistics/uses";
	}
	
	
}
