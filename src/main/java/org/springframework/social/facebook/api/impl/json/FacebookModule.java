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
package org.springframework.social.facebook.api.impl.json;
 
import org.springframework.social.facebook.api.Order;
 
import org.springframework.social.facebook.api.Shipping;
 
import org.springframework.social.facebook.api.User;
 

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Jackson module for setting up mixin annotations on Facebook model types. This enables the use of Jackson annotations without
 * directly annotating the model classes themselves.
 * @author Craig Walls
 */
public class FacebookModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public FacebookModule() {
		super("FacebookModule");
	}
	
	
	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(Order.class, OrderMixin.class);
		context.setMixInAnnotations(Shipping.class, ShippingMixin.class);
		    
		
		context.setMixInAnnotations(User.class, UserMixin.class);
		  
		
	}
}
