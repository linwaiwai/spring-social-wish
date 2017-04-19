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
package org.springframework.social.wish.api.impl;

import static org.springframework.social.wish.api.impl.PagedListUtils.*;

import java.util.List;
import java.util.Map;

import org.springframework.social.wish.api.Variant;
import org.springframework.social.wish.api.VariantOperations;
import org.springframework.social.wish.api.base.WishApi;
//import org.springframework.social.wish.api.base.PagedList;
import org.springframework.social.wish.api.base.PagingParameters;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


class VariantTemplate implements VariantOperations {

	private final WishApi wishApi;
	public VariantTemplate(WishApi wishApi) {
		this.wishApi = wishApi;
	}

	 

	public Variant add(Variant variant) {
		return wishApi.post("/variant/add", Variant.class, variant.toRequestParameters());
	}

	 

	public Variant get(String sku) {
 
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("sku", sku);
		return wishApi.fetchObject("/variant/get", Variant.class, queryParameters);
	}

 

	public void enable(String sku) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("sku", sku);
		wishApi.post("/variant/enable", Map.class, queryParameters);
		
	}


	public void disable(String sku) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("sku", sku);
		wishApi.post("/variant/disable", Map.class, queryParameters);
	}


	public void changeSku(String sku, String new_sku) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("sku", sku);
		queryParameters.set("new_sku", new_sku);
		wishApi.post("/variant/change-sku", Map.class, queryParameters);
	}
 
	

	public void update(Variant variant) {
		wishApi.post("/variant/update", Map.class, variant.toRequestParameters());
	}



	public void updateInventory(String sku, String inventory) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("inventory", inventory);
		wishApi.post("/variant/update-inventory", Map.class, queryParameters);
		
	}

	public List<Variant> multiGet(PagingParameters pagedListParameters) {
		MultiValueMap<String, String> params = getPagingParameters(pagedListParameters);
		return wishApi.fetchConnections("", "variant/multi-get", Variant.class, params);
	}
	
	private static final String[] ALL_FIELDS =
		{ "id", "attachment", "can_comment", "can_remove", "comment_count", "created_time", "from", "like_count", "message", "parent", "user_likes" };
  


	 

}
