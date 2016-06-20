package org.kisti.edison.portal.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class EdisonLoginPostAction extends Action {
	private static Log _log = LogFactoryUtil.getLog(EdisonLoginPostAction.class);
	
	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.Action#Action()
	 */
	public EdisonLoginPostAction() {
		super();
	}

	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.Action#run(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		try {
			User user = PortalUtil.getUser(request);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(checker);
			
			boolean isTempUser = EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.TEMP_USER);
			/*
			 * GPLUS
			 * Temp_User 일 경우 해당 되는 분야의 가상실험실로 이동
			 */
			if(isTempUser){
				Long expandGroupId = Long.parseLong((String) user.getExpandoBridge().getAttribute(EdisonExpando.USER_VISIT_SITE));
				Group group = GroupLocalServiceUtil.getGroup(expandGroupId);
				String layoutUrl = "";
				List<com.liferay.portal.model.Layout> layoutList = LayoutLocalServiceUtil.getLayouts(expandGroupId, false);
				
				for(Layout layout: layoutList){
					if(StringUtil.upperCase(layout.getFriendlyURL()).equals("/VIRTUAL-CLASS")){
						layoutUrl = layout.getFriendlyURL();
						break;
					}
				}
				String classId = user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID).toString();
				String redirectUrl = "/web"+group.getFriendlyURL()+layoutUrl+"?classId="+classId;
				response.sendRedirect(redirectUrl);
			}else{
				String redirectUrl = "";
				/**
				 * GPLUS 
				 * 1.개인정보 동의 시점이 1년이 지났을 경우 개인정보 동의 페이지로 이동
				 */
				String useAgreeDate = CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_TERMS_OF_USE_DATE));
				
				boolean portalAgreeStatus = true;
				
				if(useAgreeDate.equals("")){
					portalAgreeStatus = false;
				}else{
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					df.setTimeZone(TimeZoneUtil.getDefault());
					Date agreeDate = df.parse(df.format(user.getExpandoBridge().getAttribute(EdisonExpando.USER_TERMS_OF_USE_DATE)));
					
					int betweenDay = DateUtil.getDaysBetween(DateUtil.newDate(), agreeDate, TimeZoneUtil.getDefault());						
					
					if(betweenDay>365){
						portalAgreeStatus = false;
					}
				}
				
				
				if(!portalAgreeStatus){
					redirectUrl = PropsUtil.get(PropsKeys.COMPANY_DEFAULT_HOME_URL)+"/-/portalagree/view";
					response.sendRedirect(redirectUrl);
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
			e.printStackTrace();
		} 
	}

}