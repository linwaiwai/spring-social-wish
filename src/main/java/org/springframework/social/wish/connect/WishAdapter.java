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
package org.springframework.social.wish.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.wish.api.base.Wish;

/**
 * Facebook ApiAdapter implementation.
 * @author Keith Donald
 */
public class WishAdapter implements ApiAdapter<Wish> {

	public boolean test(Wish facebook) {
		try {
			return facebook.testOperations().test();
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(Wish facebook, ConnectionValues values) {
//		User profile = facebook.fetchObject("me", User.class, "id", "name", "link");
		values.setProviderUserId("12345678");
		values.setDisplayName("Craig Walls");
		values.setProfileUrl("http://www.facebook.com/975041837");
		values.setImageUrl(facebook.getBaseGraphApiUrl() + "12345678" + "/picture");
	}

	public UserProfile fetchUserProfile(Wish api) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStatus(Wish api, String message) {
		// TODO Auto-generated method stub
		
	}

//	public UserProfile fetchUserProfile(Facebook facebook) {
//		User profile = facebook.userOperations().getUserProfile();
//		return new UserProfileBuilder().setId(profile.getId()).setName(profile.getName()).setFirstName(profile.getFirstName()).setLastName(profile.getLastName()).
//			setEmail(profile.getEmail()).build();
//	}
//	
//	public void updateStatus(Facebook facebook, String message) {
//		facebook.feedOperations().updateStatus(message);
//	}

}
