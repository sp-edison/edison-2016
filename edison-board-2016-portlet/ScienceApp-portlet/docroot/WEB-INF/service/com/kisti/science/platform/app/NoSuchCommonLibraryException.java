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

package com.kisti.science.platform.app;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Jerry H. Seo
 */
public class NoSuchCommonLibraryException extends NoSuchModelException {

	public NoSuchCommonLibraryException() {
		super();
	}

	public NoSuchCommonLibraryException(String msg) {
		super(msg);
	}

	public NoSuchCommonLibraryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCommonLibraryException(Throwable cause) {
		super(cause);
	}

}