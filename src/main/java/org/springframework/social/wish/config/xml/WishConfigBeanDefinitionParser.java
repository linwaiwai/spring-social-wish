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
package org.springframework.social.wish.config.xml;

import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.security.provider.SocialAuthenticationService;
import org.springframework.social.wish.config.support.WishApiHelper;
import org.springframework.social.wish.connect.WishConnectionFactory;
import org.springframework.social.wish.security.WishAuthenticationService;

/**
 * Implementation of {@link AbstractConnectionFactoryBeanDefinitionParser} that creates a {@link WishConnectionFactory}.
 * @author Craig Walls
 */
class WishConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

	public WishConfigBeanDefinitionParser() {
		super(WishConnectionFactory.class, WishApiHelper.class);
	}
	
	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return WishAuthenticationService.class;
	}
	
	@Override
	protected BeanDefinition getConnectionFactoryBeanDefinition(String appId, String appSecret, Map<String, Object> allAttributes) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(WishConnectionFactory.class).addConstructorArgValue(appId).addConstructorArgValue(appSecret);
		if (allAttributes.containsKey("app-namespace")) {
			builder.addConstructorArgValue(allAttributes.get("app-namespace"));
		}
		return builder.getBeanDefinition();
	}

}
