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

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.wish.api.base.Wish;
import org.springframework.social.wish.api.impl.WishTemplate;


public class WishServiceProvider extends AbstractOAuth2ServiceProvider<Wish> {

	private String appNamespace;

	private static final Boolean IS_SANDBOX = true;
	private static final String API_VERSION = "2";

	private static final String GRAPH_API_URL = "https://graph.facebook.com/v" + "/";

	/**
	 * Creates a FacebookServiceProvider for the given application ID, secret,
	 * and namespace.
	 * 
	 * @param appId
	 *            The application's App ID as assigned by Facebook
	 * @param appSecret
	 *            The application's App Secret as assigned by Facebook
	 * @param appNamespace
	 *            The application's App Namespace as configured with Facebook.
	 *            Enables use of Open Graph operations.
	 */
	public WishServiceProvider(String appId, String appSecret, String appNamespace) {
		super(getOAuth2Template(appId, appSecret));
		this.appNamespace = appNamespace;
	}

	private static OAuth2Template getOAuth2Template(String appId, String appSecret) {
		OAuth2Template oAuth2Template = new WishOAuth2Template(appId, appSecret,
				"https://" + (IS_SANDBOX == true ? "sandbox." : "") + "merchant.wish.com" + "/oauth/authorize",
				"https://" + (IS_SANDBOX == true ? "sandbox." : "") + "merchant.wish.com" + "/api/v" + API_VERSION
						+ "/oauth/access_token");
		oAuth2Template.setUseParametersForClientAuthentication(true);
		return oAuth2Template;
	}

	public Wish getApi(String accessToken) {
		return new WishTemplate(accessToken, appNamespace);
	}

}
