package org.kisti.edison.content.portlet.siteMainLink;

import java.util.List;

import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

@Controller
@RequestMapping("VIEW")
public class SiteMainLinkController {
	
	private static Log log = LogFactoryUtil.getLog(SiteMainLinkController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			try {
				List<com.liferay.portal.model.Group> groupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId(), true);
				for(Group group:groupList){
					model.addAttribute(group.getName(), "/web"+group.getFriendlyURL());
				}
				
			} catch (SystemException e) {
				e.printStackTrace();
			}
	return "/contentList";
	}
}
