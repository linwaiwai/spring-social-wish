/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.api.impl;

import org.springframework.social.facebook.api.FacebookApi;
import org.springframework.social.facebook.api.Test;
import org.springframework.social.facebook.api.TestOperations;
import org.springframework.web.client.RestTemplate;

public class TestTemplate extends AbstractFacebookOperations implements TestOperations {

	private String appId;
	
	private RestTemplate restTemplate;

	private FacebookApi graphApi;

	/**
	 * @deprecated Construct with a GraphApi, RestTemplate, and appId instead.
	 * @param restTemplate the RestTemplate
	 * @param appId the app ID
	 */
	@Deprecated
	public TestTemplate(RestTemplate restTemplate, String appId) {
		this(null, restTemplate, appId);
	}
	
	public TestTemplate(FacebookApi graphApi, RestTemplate restTemplate, String appId) {
		super(false);
		this.graphApi = graphApi;
		this.restTemplate = restTemplate;
		this.appId = appId;
	}

	 
	public boolean test() {
//		MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
//		request.set("installed", "" + installed);
//		if (name != null) {
//			request.set("name", name);
//		}
//		
//		if (permissions != null) {
//			request.set("permissions", permissions);
//		}
//		RestOperations userRest = new FacebookTemplate(testUser1.getAccessToken()).restOperations();
//		
//		userRest.postForObject(graphApi.getBaseGraphApiUrl() + "{testUserId1}/friends/{testUserId2}", "", String.class, testUser1.getId(), testUser2.getId());
		Test test = restTemplate.getForObject("https://china-merchant.wish.com/api/v2/auth_test", Test.class);
		return true;
	}
	
//	public void sendConfirmFriends(TestUser testUser1, TestUser testUser2) {
//		RestOperations userRest = new FacebookTemplate(testUser1.getAccessToken()).restOperations();
//		
//		userRest.postForObject(graphApi.getBaseGraphApiUrl() + "{testUserId1}/friends/{testUserId2}", "", String.class, testUser1.getId(), testUser2.getId());
//	}
	
	public void deleteTestUser(String testUserId) {
		restTemplate.delete(graphApi.getBaseGraphApiUrl() + "{testUserId}", testUserId);
	}
	
}
