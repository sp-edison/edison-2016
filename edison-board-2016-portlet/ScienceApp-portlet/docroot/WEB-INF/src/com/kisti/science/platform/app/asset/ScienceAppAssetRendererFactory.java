package com.kisti.science.platform.app.asset;

import com.kisti.science.platform.app.model.ScienceApp;
import com.kisti.science.platform.app.service.ScienceAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ScienceAppAssetRenderer objects.
 */
public class ScienceAppAssetRendererFactory extends BaseAssetRendererFactory {

	/*
	 * @param classPK
	 * @param type
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 *
	 * @see com.liferay.portlet.asset.model.AssetRendererFactory#getAssetRenderer(long, int)
	 */
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		ScienceApp scienceApp = ScienceAppLocalServiceUtil.getScienceApp(classPK);
		return new ScienceAppAssetRenderer (scienceApp);
	}

	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRendererFactory#getClassName()
	 */
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.AssetRendererFactory#getType()
	 */
	@Override
	public String getType() {
		return TYPE;
	}

	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.BaseAssetRendererFactory#isLinkable()
	 */
	@Override
	public boolean isLinkable() {
		return true;
	}
	
	/*
	 * @return
	 *
	 * @see com.liferay.portlet.asset.model.BaseAssetRendererFactory#isCategorizable()
	 */
	@Override
	public boolean isCategorizable() {
		return true;
	}
	
	/** The Constant CLASS_NAME. */
	public static final String CLASS_NAME = ScienceApp.class.getName();
	
	/** The Constant TYPE. */
	public static final String TYPE = "scienceapp";
	    
}
