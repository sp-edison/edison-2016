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

package org.kisti.edison.bestsimulation.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author EDISON
 * @generated
 */
public class SimulationJobStatusPK implements Comparable<SimulationJobStatusPK>,
	Serializable {
	public long statusSeq;
	public long groupId;
	public String simulationUuid;
	public String jobUuid;

	public SimulationJobStatusPK() {
	}

	public SimulationJobStatusPK(long statusSeq, long groupId,
		String simulationUuid, String jobUuid) {
		this.statusSeq = statusSeq;
		this.groupId = groupId;
		this.simulationUuid = simulationUuid;
		this.jobUuid = jobUuid;
	}

	public long getStatusSeq() {
		return statusSeq;
	}

	public void setStatusSeq(long statusSeq) {
		this.statusSeq = statusSeq;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getSimulationUuid() {
		return simulationUuid;
	}

	public void setSimulationUuid(String simulationUuid) {
		this.simulationUuid = simulationUuid;
	}

	public String getJobUuid() {
		return jobUuid;
	}

	public void setJobUuid(String jobUuid) {
		this.jobUuid = jobUuid;
	}

	@Override
	public int compareTo(SimulationJobStatusPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (statusSeq < pk.statusSeq) {
			value = -1;
		}
		else if (statusSeq > pk.statusSeq) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (groupId < pk.groupId) {
			value = -1;
		}
		else if (groupId > pk.groupId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = simulationUuid.compareTo(pk.simulationUuid);

		if (value != 0) {
			return value;
		}

		value = jobUuid.compareTo(pk.jobUuid);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SimulationJobStatusPK)) {
			return false;
		}

		SimulationJobStatusPK pk = (SimulationJobStatusPK)obj;

		if ((statusSeq == pk.statusSeq) && (groupId == pk.groupId) &&
				(simulationUuid.equals(pk.simulationUuid)) &&
				(jobUuid.equals(pk.jobUuid))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(statusSeq) + String.valueOf(groupId) +
		String.valueOf(simulationUuid) + String.valueOf(jobUuid)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("statusSeq");
		sb.append(StringPool.EQUAL);
		sb.append(statusSeq);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("groupId");
		sb.append(StringPool.EQUAL);
		sb.append(groupId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("simulationUuid");
		sb.append(StringPool.EQUAL);
		sb.append(simulationUuid);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("jobUuid");
		sb.append(StringPool.EQUAL);
		sb.append(jobUuid);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}