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
package org.springframework.social.wish.api;

import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

//@JsonDeserialize(using=OrderDeserializer.class)
public class ShippingPrice extends WishObject {
	private String id;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the parent_sku
	 */
	public String getParentSku() {
		return parentSku;
	}
	/**
	 * @param parent_sku the parent_sku to set
	 */
	public void setParentSku(String parent_sku) {
		this.parentSku = parent_sku;
	}

	private String parentSku;
	
	private String country;
	
	private String price;
	
	private String useProductShipping;
	
	private String enabled;
	
	private String wishExpress;

	public MultiValueMap<String, String> toRequestParameters() {
	 
		 
		BeanMappingBuilder builder = new BeanMappingBuilder() {
    		protected void configure() {
    			mapping(ShippingPrice.class,  Map.class,  TypeMappingOptions.mapNull(false))
    			.fields("id","id")
    			.fields("parentSku","parent_sku")
    			.fields("country","country")
    			.fields("price","price")
    			.fields("useProductShipping","use_product_shipping")
    			.fields("enabled","enabled")
    			.fields("wishExpress","wish_express");
    		}
	    };
	    DozerBeanMapper mapper = new DozerBeanMapper();
	    mapper.addMapping(builder);
	    @SuppressWarnings("unchecked")
		Map<String, String> destObject =  
			    mapper.map(this, Map.class);
		
	    String[] requiredFields = {
	    		"country","price" 
	    };
	    for (String field : requiredFields){
	    	if (!destObject.containsKey(field))
	    		throw new WishApiException(WishErrors.LACK_REQUIRED_FIELD, "lack of required field:"+ field);	
	    }
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.setAll(destObject);
		
		
		
		return queryParameters;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the useProductShipping
	 */
	public String getUseProductShipping() {
		return useProductShipping;
	}

	/**
	 * @param useProductShipping the useProductShipping to set
	 */
	public void setUseProductShipping(String useProductShipping) {
		this.useProductShipping = useProductShipping;
	}

	/**
	 * @return the enabled
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the wishExpress
	 */
	public String getWishExpress() {
		return wishExpress;
	}

	/**
	 * @param wishExpress the wishExpress to set
	 */
	public void setWishExpress(String wishExpress) {
		this.wishExpress = wishExpress;
	}

	  
}
