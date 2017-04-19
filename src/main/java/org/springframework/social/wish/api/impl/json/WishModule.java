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
package org.springframework.social.wish.api.impl.json;
 
import org.springframework.social.wish.api.Order;
import org.springframework.social.wish.api.Product;
import org.springframework.social.wish.api.Shipping;
import org.springframework.social.wish.api.Tag;
import org.springframework.social.wish.api.User;
import org.springframework.social.wish.api.Variant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Jackson module for setting up mixin annotations on Facebook model types. This enables the use of Jackson annotations without
 * directly annotating the model classes themselves.
 * @author Craig Walls
 */
public class WishModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public WishModule() {
		super("WishModule");
	}
	
	
	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(Order.class, OrderMixin.class);
		context.setMixInAnnotations(Shipping.class, ShippingMixin.class);
		context.setMixInAnnotations(Product.class, ProductMixin.class);  
		context.setMixInAnnotations(Tag.class, TagMixin.class);
		context.setMixInAnnotations(Variant.class, VariantMixin.class);
		context.setMixInAnnotations(User.class, UserMixin.class);
		
//		String[] path2 = {"Tag"}; 
//		context.addBeanDeserializerModifier(new DeserializerModifier<Tag>((ObjectMapper) context.getOwner(), Tag.class, path2));
		 
	}
	
}
