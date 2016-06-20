package org.kisti.edison.hook;

import org.kisti.edison.model.EdisonExpando;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

public class HookExpandoUtil extends OrderByComparator{
	
	@Override
	public int compare(Object obj1, Object obj2) {
		int tableId = 0;
		try {
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			ExpandoTable table =  ExpandoTableLocalServiceUtil.getTable(companyId, ExpandoTable.class.getName(), EdisonExpando.TALBE_NAME);
			tableId = (int) table.getClassNameId();
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		return tableId;
	}
}