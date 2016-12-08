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
package org.springframework.social.facebook.connect;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;


/**
 * Facebook ApiAdapter implementation.
 * @author Keith Donald
 */
public class FacebookController extends ConnectController {
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	private final ConnectionRepository bconnectionRepository;
	public FacebookController(ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository) {
		super(connectionFactoryLocator, connectionRepository);
		this.bconnectionRepository = connectionRepository;
	}
	private void setNoCache(NativeWebRequest request) {
		HttpServletResponse response = request.getNativeResponse(HttpServletResponse.class);
		if (response != null) {
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 1L);
			response.setHeader("Cache-Control", "no-cache");
			response.addHeader("Cache-Control", "no-store");
		}
	}
	
	private void processFlash(WebRequest request, Model model) {
		convertSessionAttributeToModelAttribute(DUPLICATE_CONNECTION_ATTRIBUTE, request, model);
		convertSessionAttributeToModelAttribute(PROVIDER_ERROR_ATTRIBUTE, request, model);
		model.addAttribute(AUTHORIZATION_ERROR_ATTRIBUTE, sessionStrategy.getAttribute(request, AUTHORIZATION_ERROR_ATTRIBUTE));
		sessionStrategy.removeAttribute(request, AUTHORIZATION_ERROR_ATTRIBUTE);
	}

	private void convertSessionAttributeToModelAttribute(String attributeName, WebRequest request, Model model) {
		if (sessionStrategy.getAttribute(request, attributeName) != null) {
			model.addAttribute(attributeName, Boolean.TRUE);
			sessionStrategy.removeAttribute(request, attributeName);
		}
	}
	
	@Override
	@RequestMapping(value="/{providerId}", method=RequestMethod.GET)
	public String connectionStatus(@PathVariable String providerId, NativeWebRequest request, Model model) {
		setNoCache(request);
		processFlash(request, model);
		List<Connection<?>> connections = bconnectionRepository.findConnections(providerId);
		setNoCache(request);
		if (connections.isEmpty()) {
			return connectView(providerId); 
		} else {
			model.addAttribute("connections", connections);
			return "redirect:/#/hello";		
		}
	}
	
	
	

	 

}
