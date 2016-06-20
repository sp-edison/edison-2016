package org.kisti.edison.portal.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class EdisonValidationAction extends BaseStrutsAction {
	private static Log log = LogFactoryUtil.getLog(EdisonValidationAction.class);
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws PortalException, SystemException{
		
		String data = ParamUtil.get(request, "data", "false");
		String checkDiv = ParamUtil.get(request, "checkDiv", "ID");
		String retVal = "false";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		
			try {
				writer = response.getWriter();
			} catch (IOException e) {
				log.error(e);
				e.printStackTrace();
			}
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = null;
			
			try {
				if(checkDiv.equals("ID")){
					user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), data);
				}else if(checkDiv.equals("EMAIL")){
					user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), data);
				}
			}catch (NoSuchUserException e) {
				retVal="true";
			}finally{
				writer.write(retVal);
			}
		return null;
	}
}
