/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package org.kisti.edison.virtuallaboratory.service.persistence;

/**
 * @author EDISON
 */
public interface VirtualLabFinder {
	public java.util.List<java.lang.Object[]> getVirtualLabAuthList(
		long groupId, long userId);

	public java.util.List<java.lang.Object[]> getVirtualLabClassRegisterList(
		long groupId, long userId);

	public java.lang.Object[] getVirtualLabClassRegisterInfo(long classId,
		long userId, long groupId);

	public java.util.List<java.lang.Object[]> getListVirtualLab(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale);

	public int getCountVirtualLab(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale);

	public java.util.List<java.lang.Object[]> getListVirtualLabClass(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale);

	public java.util.List<java.lang.Object[]> getListVirtualLabClass2(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale);

	public int getCountVirtualLabClass(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale);

	public int getCountVirtualLabClass2(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale);
}