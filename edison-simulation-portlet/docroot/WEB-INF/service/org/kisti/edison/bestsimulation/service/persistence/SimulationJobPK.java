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
public class SimulationJobPK implements Comparable<SimulationJobPK>,
	Serializable {
	public long jobSeqNo;
	public String simulationUuid;
	public long groupId;

	public SimulationJobPK() {
	}

	public SimulationJobPK(long jobSeqNo, String simulationUuid, long groupId) {
		this.jobSeqNo = jobSeqNo;
		this.simulationUuid = simulationUuid;
		this.groupId = groupId;
	}

	public long getJobSeqNo() {
		return jobSeqNo;
	}

	public void setJobSeqNo(long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public String getSimulationUuid() {
		return simulationUuid;
	}

	public void setSimulationUuid(String simulationUuid) {
		this.simulationUuid = simulationUuid;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Override
	public int compareTo(SimulationJobPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (jobSeqNo < pk.jobSeqNo) {
			value = -1;
		}
		else if (jobSeqNo > pk.jobSeqNo) {
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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SimulationJobPK)) {
			return false;
		}

		SimulationJobPK pk = (SimulationJobPK)obj;

		if ((jobSeqNo == pk.jobSeqNo) &&
				(simulationUuid.equals(pk.simulationUuid)) &&
				(groupId == pk.groupId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(jobSeqNo) + String.valueOf(simulationUuid) +
		String.valueOf(groupId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("jobSeqNo");
		sb.append(StringPool.EQUAL);
		sb.append(jobSeqNo);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("simulationUuid");
		sb.append(StringPool.EQUAL);
		sb.append(simulationUuid);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("groupId");
		sb.append(StringPool.EQUAL);
		sb.append(groupId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}