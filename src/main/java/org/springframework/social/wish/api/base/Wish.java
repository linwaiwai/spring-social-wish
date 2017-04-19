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
package org.springframework.social.wish.api.base;

import org.springframework.social.ApiBinding;
import org.springframework.social.wish.api.OrderOperations;
import org.springframework.social.wish.api.ProductOperations;
import org.springframework.social.wish.api.TestOperations;
import org.springframework.social.wish.api.VariantOperations;
import org.springframework.social.wish.api.impl.WishTemplate;
import org.springframework.web.client.RestOperations;


/**
 * Interface specifying a basic set of operations for interacting with Facebook.
 * Implemented by {@link WishTemplate}.
 * @author Craig Walls
 */
public interface Wish extends WishApi, ApiBinding {
	
	TestOperations	testOperations();         
	
	OrderOperations  orderOperations();
	
	ProductOperations  productOperations();
	/**
	 * Returns the underlying {@link RestOperations} object allowing for consumption of Facebook endpoints that may not be otherwise covered by the API binding.
	 * The RestOperations object returned is configured to include an OAuth 2 "Authorization" header on all requests.
	 * @return RestOperations instrumented to include Authorization header on all requests
	 */
	RestOperations restOperations();
	
	VariantOperations variantOperations();
	
 

}
