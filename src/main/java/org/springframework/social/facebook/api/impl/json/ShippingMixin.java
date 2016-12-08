 

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

import org.springframework.social.facebook.api.Shipping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
 
/**
 * Annotated mixin to add Jackson annotations to Album. 
 * @author Craig Walls
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ShippingMixin extends FacebookObjectMixin {

	@JsonProperty("phone_number")
	String phoneNumber;
	
	@JsonProperty("city")
	String city;
	
	@JsonProperty("state")
	String state;
	
	@JsonProperty("name")
	String name;
	
	@JsonProperty("country")
	String country;
	 
	@JsonProperty("street_address2")
	String streetAddress2;
	
	@JsonProperty("street_address1")
	String streetAddress1;
	
	@JsonProperty("zipcode")
	String zipcode;
	
	
}
