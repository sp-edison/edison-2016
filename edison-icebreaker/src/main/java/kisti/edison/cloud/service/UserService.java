/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package kisti.edison.cloud.service;

import kisti.edison.cloud.model.Role;
import kisti.edison.cloud.model.User;

import java.util.List;

/**
 * A service interface for accessing and modifying user data in the system.
 */
public interface UserService {

	// public User getCurrentUser();

	public User createUser(User user);

	public List<User> getAllUsers(String orderBy, String order);

	public List<User> queryUsers(String orderBy, String order, int startIndex, int maxResults);

	public int getUsersCount();

	public User getUser(String userid);

	public void deleteUser(String userid);

	public User updateUser(User user);

	public void updateUserSessionToken(Long id, String token);

	public void deleteUserSessionToken(Long id);

	public boolean isExist(String userid);

	public Role findRole(String name);

}
