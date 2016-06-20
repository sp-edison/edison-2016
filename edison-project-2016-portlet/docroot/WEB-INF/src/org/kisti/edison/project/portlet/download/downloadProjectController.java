package org.kisti.edison.project.portlet.download;

import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Controller
@RequestMapping("VIEW")
public class downloadProjectController {
	
	private static Log log = LogFactoryUtil.getLog(downloadProjectController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		
		return "download/view";
	}
	
}

