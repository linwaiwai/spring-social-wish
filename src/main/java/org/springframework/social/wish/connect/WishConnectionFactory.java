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

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.wish.api.base.Wish;


public class WishConnectionFactory extends OAuth2ConnectionFactory<Wish> {
	@Override
	public boolean supportsStateParameter() {
		return false;
	}

	public WishConnectionFactory(String appId, String appSecret) {
		this(appId, appSecret, null);
	}
	

	public WishConnectionFactory(String appId, String appSecret, String appNamespace) {
		super("facebook", new WishServiceProvider(appId, appSecret, appNamespace), new WishAdapter());
	}

}
