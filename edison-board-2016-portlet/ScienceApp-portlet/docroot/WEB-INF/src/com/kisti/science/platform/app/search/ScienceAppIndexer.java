package com.kisti.science.platform.app.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.kisti.science.platform.app.service.constants.ScienceAppConstants;
import com.kisti.science.platform.app.model.ScienceApp;
import com.kisti.science.platform.app.service.ScienceAppLocalServiceUtil;
import com.kisti.science.platform.app.service.permission.ScienceAppPermission;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

// TODO: Auto-generated Javadoc
/**
 * The Class ScienceAppIndexer.
 */
public class ScienceAppIndexer extends BaseIndexer {
		
		/**
		 * Instantiates a new science app indexer.
		 */
		public ScienceAppIndexer() {
			setFilterSearch(true);
			setPermissionAware(true);
		}

		/*
		 * @param permissionChecker
		 * @param entryClassName
		 * @param entryClassPK
		 * @param actionId
		 * @return
		 * @throws Exception
		 *
		 * @see com.liferay.portal.kernel.search.BaseIndexer#hasPermission(com.liferay.portal.security.permission.PermissionChecker, java.lang.String, long, java.lang.String)
		 */
		@Override
		public boolean hasPermission(PermissionChecker permissionChecker,
				String entryClassName, long entryClassPK, String actionId)
				throws Exception {

			return ScienceAppPermission.contains(permissionChecker,
					entryClassPK, ActionKeys.VIEW);
		}

		/*
		 * @param obj
		 * @throws Exception
		 *
		 * @see com.liferay.portal.kernel.search.BaseIndexer#doDelete(java.lang.Object)
		 */
		@Override
		protected void doDelete(Object obj) throws Exception {

			ScienceApp scienceApp = (ScienceApp) obj;
			Document document = new DocumentImpl();

			document.addUID(PORTLET_ID, scienceApp.getPrimaryKey());

			String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
			SearchEngineUtil.deleteDocument(searchEngineId, scienceApp.getCompanyId(), document.get(Field.UID), true);
		}

		/*
		 * @param obj
		 * @return
		 * @throws Exception
		 *
		 * @see com.liferay.portal.kernel.search.BaseIndexer#doGetDocument(java.lang.Object)
		 */
		@Override
		protected Document doGetDocument(Object obj) throws Exception {

			ScienceApp scienceApp = (ScienceApp) obj;
			long groupId = getSiteGroupId(scienceApp.getGroupId());
			long scopeGroupId = scienceApp.getGroupId();
			String description = scienceApp.getName();

			Document document = getBaseModelDocument(PORTLET_ID, scienceApp);

			document.addKeyword(Field.GROUP_ID, groupId);
			document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
			document.addText(Field.DESCRIPTION, description);

			return document;
		}

		/*
		 * @param obj
		 * @throws Exception
		 *
		 * @see com.liferay.portal.kernel.search.BaseIndexer#doReindex(java.lang.Object)
		 */
		@Override
		protected void doReindex(Object obj) throws Exception {

			ScienceApp scienceApp = (ScienceApp) obj;
			
			if (scienceApp.isApproved()){ 
				String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
				SearchEngineUtil.updateDocument(searchEngineId, scienceApp.getCompanyId(), getDocument(scienceApp), true);
			}
		}

		/*
		 * @param className
		 * @param classPK
		 * @throws Exception
		 *
		 * @see com.liferay.portal.kernel.search.BaseIndexer#doReindex(java.lang.String, long)
		 */
		@Override
		protected void doReindex(String className, long classPK) throws Exception {

			ScienceApp scienceApp = ScienceAppLocalServiceUtil.getScienceApp(classPK);

			doReindex(scienceApp);
		}

		/*
		 * @param ids
		 * @throws Exception
		 *
		 * @see com.liferay.portal.kernel.search.BaseIndexer#doReindex(java.lang.String[])
		 */
		@Override
		protected void doReindex(String[] ids) throws Exception {

			long companyId = GetterUtil.getLong(ids[0]);

			doReindexAll(companyId);
		}

		/**
		 * Do reindex all.
		 *
		 * @param companyId the company id
		 * @throws Exception the exception
		 */
		private void doReindexAll(long companyId) throws Exception {

			int count = ScienceAppLocalServiceUtil.getScienceAppsCount();

			int pages = count / Indexer.DEFAULT_INTERVAL;

			for (int i = 0; i <= pages; i++) {
				int start = (i * Indexer.DEFAULT_INTERVAL);
				int end = start + Indexer.DEFAULT_INTERVAL;

				reindexScienceApps(companyId, start, end);
			}
		}

		/**
		 * Reindex science apps.
		 *
		 * @param companyId the company id
		 * @param start the start
		 * @param end the end
		 * @throws Exception the exception
		 */
		protected void reindexScienceApps(long companyId, int start, int end)
				throws Exception {

			List<ScienceApp> scienceApps = ScienceAppLocalServiceUtil.getScienceAppListByStage(ScienceAppConstants.IN_SERVICE);

			if (scienceApps.isEmpty()) {
				return;
			}

			Collection<Document> documents = new ArrayList<Document>();

			for (ScienceApp scienceApp : scienceApps) {
				Document document = getDocument(scienceApp);

				documents.add(document);
			}

			String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
			SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents, true);
		}

		/*
		 * @param searchContext
		 * @return
		 *
		 * @see com.liferay.portal.kernel.search.BaseIndexer#getPortletId(com.liferay.portal.kernel.search.SearchContext)
		 */
		@Override
		protected String getPortletId(SearchContext searchContext) {

			return PORTLET_ID;
		}

		/*
		 * @param document
		 * @param locale
		 * @param snippet
		 * @param portletURL
		 * @return
		 *
		 * @see com.liferay.portal.kernel.search.BaseIndexer#doGetSummary(com.liferay.portal.kernel.search.Document, java.util.Locale, java.lang.String, javax.portlet.PortletURL)
		 */
		public Summary doGetSummary(Document document, Locale locale,
				String snippet, PortletURL portletURL) {

			String title = document.get(Field.TITLE);

			String content = snippet;

			if (Validator.isNull(snippet)) {
				content = document.get(Field.DESCRIPTION);

				if (Validator.isNull(content)) {
					content = StringUtil.shorten(document.get(Field.CONTENT), 200);
				}
			}

			String scienceAppId = document.get(Field.ENTRY_CLASS_PK);

			portletURL.setParameter("mvcPath", "/html/scienceapp/jspf/view_scienceapp.jsp");
			portletURL.setParameter("scienceAppId", scienceAppId);

			return new Summary(title, content, portletURL);
		}

		/*
		 * @return
		 *
		 * @see com.liferay.portal.kernel.search.Indexer#getPortletId()
		 */
		@Override
		public String getPortletId() {
			
			return PORTLET_ID;
		}

		/*
		 * @return
		 *
		 * @see com.liferay.portal.kernel.search.Indexer#getClassNames()
		 */
		public String[] getClassNames() {

			return CLASS_NAMES;
		}

		/** The Constant CLASS_NAMES. */
		public static final String[] CLASS_NAMES = { ScienceApp.class.getName() };

		/** The Constant PORTLET_ID. */
		public static final String PORTLET_ID = "science-app-manager";

}
