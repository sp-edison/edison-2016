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

package org.kisti.edison.science.Exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ScienceAppException extends PortalException {
	
	public static final int EXISTS_NAME_VERSION_DATABASE = 1;
	
	public static final int FAIL_VALIDATION_SCIENCE_APP_NAME = 2;
	
	public static final int SCIENCE_APP_NO_AUTH = 3;
	
	public static final int SCIENCE_APP_FILE_NOT_SUPPORT_OS = 4;

	public ScienceAppException() {
		super();
	}

	public ScienceAppException(int type) {
		_type = type;
	}
	
	public int getType() {
		return _type;
	}

	private int _type;

	public ScienceAppException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ScienceAppException(Throwable cause) {
		super(cause);
	}

}