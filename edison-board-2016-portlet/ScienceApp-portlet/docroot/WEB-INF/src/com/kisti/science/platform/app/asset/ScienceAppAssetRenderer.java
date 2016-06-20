package com.kisti.science.platform.app.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import science.platform.model.SpUser;
import science.platform.service.SpUserLocalServiceUtil;

import com.kisti.science.platform.app.model.ScienceApp;
import com.kisti.science.platform.app.service.permission.ScienceAppPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

// TODO: Auto-generated Javadoc
/**
 * The Class ScienceAppAssetRenderer.
 */
public class ScienceAppAssetRenderer extends BaseAssetRenderer {
	
	/** The _science app. */
	private ScienceApp _scienceApp = null;
	private Locale _locale = null;
	
	/**
	 * Instantiates a new science app asset renderer.
	 *
	 * @param scienceApp the science app
	 */
	public ScienceAppAssetRenderer (ScienceApp scienceApp) {
		this._scienceApp = scienceApp;
	}
	
	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getClassName()
	 */
	@Override
	public String getClassName() {
		return this._scienceApp.getClass().getName();
	}

	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getClassPK()
	 */
	@Override
	public long getClassPK() {
		return this._scienceApp.getPrimaryKey();
	}

	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getGroupId()
	 */
	@Override
	public long getGroupId() {
		return this._scienceApp.getGroupId();
	}

	/*
	 * @param locale
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getSummary(java.util.Locale)
	 */
	@Override
	public String getSummary(Locale locale) {
		return this._scienceApp.getName()+":"+this._scienceApp.getVersion();
	}

	/*
	 * @param locale
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getTitle(java.util.Locale)
	 */
	@Override
	public String getTitle(Locale locale) {
		return this._scienceApp.getName() + " ver. "+ this._scienceApp.getVersion()+"\n"+this._scienceApp.getTitle(locale);
	}

	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getUserId()
	 */
	@Override
	public long getUserId() {
		return this._scienceApp.getUserId();
	}

//	@Override
//	public String renderActions(RenderRequest renderRequest,
//			RenderResponse renderResponse) throws Exception {
//		this._locale = renderRequest.getLocale();
//		return this.render(renderRequest, renderResponse, super.TEMPLATE_FULL_CONTENT);
//	}

	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getUserName()
	 */
	@Override
	public String getUserName() {
		long authorId = this._scienceApp.getAuthorId();
		
		SpUser spAuthor;
		try {
			spAuthor = SpUserLocalServiceUtil.getSpUser(authorId);
		} catch (PortalException e) {
			e.printStackTrace();
			return null;
		} catch (SystemException e) {
			return null;
		}
		
		
		return spAuthor.getSpUserFullName(this._locale);
	}

	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRenderer#getUuid()
	 */
	@Override
	public String getUuid() {
		return this._scienceApp.getUuid();
	}

	/*
	 * @param request
	 * @param response
	 * @param template
	 * @return
	 * @throws Exception
	 *
	 * @see com.liferay.portlet.asset.model.AssetRenderer#render(javax.portlet.RenderRequest, javax.portlet.RenderResponse, java.lang.String)
	 */
	@Override
	public String render(RenderRequest request, RenderResponse response, String template)
		    throws Exception {
	    if (template.equals(TEMPLATE_FULL_CONTENT)) {
	        request.setAttribute("SCIENCEAPP_ENTRY", this._scienceApp);
		        //return "/html/scienceapp/" + template + ".jsp";
	        return "/html/scienceapp/jspf/view_scienceapp.jsp";
	    }
	    else {
	    	return null;
	    }
	}
	
	/**
	 *  
	 *
	 * @param themeDisplay the theme display
	 * @return Also see @see com.liferay.portlet.asset.model.BaseAssetRenderer#getIconPath(com.liferay.portal.theme.ThemeDisplay).
	 */
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		// TODO Auto-generated method stub
		return super.getIconPath(themeDisplay);
	}

	/*
	 * @param permissionChecker
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 *
	 * @see com.liferay.portlet.asset.model.BaseAssetRenderer#hasEditPermission(com.liferay.portal.security.permission.PermissionChecker)
	 */
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker)
			throws PortalException, SystemException {
		return ScienceAppPermission.contains(permissionChecker, this._scienceApp.getScienceAppId(), ActionKeys.UPDATE);
	}

	/*
	 * @param permissionChecker
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 *
	 * @see com.liferay.portlet.asset.model.BaseAssetRenderer#hasViewPermission(com.liferay.portal.security.permission.PermissionChecker)
	 */
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
			throws PortalException, SystemException {
		return ScienceAppPermission.contains(permissionChecker, this._scienceApp.getScienceAppId(), ActionKeys.VIEW);
	}

}
