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
package org.springframework.social.wish.security;

import org.springframework.social.security.provider.OAuth2AuthenticationService;
import org.springframework.social.wish.api.base.Wish;
import org.springframework.social.wish.connect.WishConnectionFactory;

public class WishAuthenticationService extends OAuth2AuthenticationService<Wish> {

	public WishAuthenticationService(String apiKey, String appSecret) {
		super(new WishConnectionFactory(apiKey, appSecret));
	}

	public WishAuthenticationService(String apiKey, String appSecret, String appNamespace) {
		super(new WishConnectionFactory(apiKey, appSecret, appNamespace));
	}

}
