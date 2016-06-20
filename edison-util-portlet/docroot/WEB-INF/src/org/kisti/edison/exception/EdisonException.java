/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.kisti.edison.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class EdisonException extends PortalException {

	private static final long serialVersionUID = 1L;

	public static final int PASSWORDS_DO_NOT_MATCH = 1;
	
	public static final int ADMINISTRATOR_NOT_LEAVE = 2;
	
	public static final int SITE_ADMINISTRATOR_NOT_EXIST = 3;
	
	public static final int SPYGLASS_URL_CUSTOM_FIELD_NOT_EXIST = 4;
	
	public static final int TEMP_USER_ROLE_THIS_FUNCTION_NOT_USE= 5;
	
	public static final int EDISON_PREFRESPROPS_UTIL_ERROR = 6;

	public EdisonException(int type) {
		_type = type;
	}

	public int getType() {
		return _type;
	}

	private int _type;

}