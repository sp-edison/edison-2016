package org.kisti.edison.portlet.login.action;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;

public class ForgotIdAction extends BaseStrutsPortletAction  {
	@Override
	public String render(
			StrutsPortletAction originalStrutsPortletAction,PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {
		
		return "/portlet/login/forgot_id.jsp";
	}
}
