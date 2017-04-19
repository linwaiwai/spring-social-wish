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

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.InsufficientPermissionException;
import org.springframework.social.wish.api.base.PagingParameters;

/**
 * @author Craig Walls
 */
public class VariantTemplateTest extends AbstractWishApiTest {

 
	
	@Test
	public void addVariantTest() {
		mockServer.expect(requestTo(wishUrl("/variant/get?sku=3333&access_token=someAccessToken")))
		.andExpect(method(GET))
//		.andExpect(header("Authorization", "OAuth someAccessToken"))
		.andRespond(withSuccess(jsonResource("variant.get"), MediaType.APPLICATION_JSON));
		
		mockServer.expect(requestTo(wishUrl("/variant/add?access_token=someAccessToken")))
				.andExpect(method(POST))
//				.andExpect(header("Authorization", "OAuth someAccessToken"))
				.andRespond(withSuccess(jsonResource("variant.add"), MediaType.APPLICATION_JSON));
		
		Variant post = wish.variantOperations().get("3333");
		assertEquals("51e0a2c61111a236cfffe3a2", post.getId());
		post.setId(null);
		
		Variant product = wish.variantOperations().add(post);
		assertEquals("529e6c2cf94aaa0cfe02846f", product.getId());
	}
	
	@Test
	public void getVariantTest() {
		mockServer.expect(requestTo(wishUrl("/variant/get?sku=3333&access_token=someAccessToken")))
		.andExpect(method(GET))
//		.andExpect(header("Authorization", "OAuth someAccessToken"))
		.andRespond(withSuccess(jsonResource("variant.get"), MediaType.APPLICATION_JSON));
		
	 
		Variant post = wish.variantOperations().get("3333");
		assertEquals("51e0a2c61111a236cfffe3a2", post.getId());
	}
	
	@Test
	public void updateVariantTest() {
		mockServer.expect(requestTo(wishUrl("/variant/get?sku=3333&access_token=someAccessToken")))
		.andExpect(method(GET))
//		.andExpect(header("Authorization", "OAuth someAccessToken"))
		.andRespond(withSuccess(jsonResource("variant.get"), MediaType.APPLICATION_JSON));
		
		mockServer.expect(requestTo(wishUrl("/variant/update?access_token=someAccessToken")))
				.andExpect(method(POST))
//				.andExpect(header("Authorization", "OAuth someAccessToken"))
				.andRespond(withSuccess(jsonResource("variant.update"), MediaType.APPLICATION_JSON));
		
		Variant post = wish.variantOperations().get("3333");
		assertEquals("51e0a2c61111a236cfffe3a2", post.getId());
		post.setId(null);
		try {
			wish.variantOperations().update(post);	
		} catch (Exception e){
			assertTrue("enable failed", false);
		}
		assertTrue("enable successfully", true);
 
	}
	
	@Test
	public void multiGetTest() {
		try{
			mockServer.expect(requestTo(wishUrl("/variant/multi-get?start=0&limit=10&access_token=someAccessToken")))
					.andExpect(method(GET))
//					.andExpect(header("Authorization", "OAuth someAccessToken"))
					.andRespond(withSuccess(jsonResource("variant.multi-get"), MediaType.APPLICATION_JSON));
	    	PagingParameters pagedListParameters = new PagingParameters(10, 0, null, null);
	    	List<Variant> variants = wish.variantOperations().multiGet(pagedListParameters);
	    	assertTrue("mutiGetTest successfully", variants.size() > 1);
		}catch(Exception e){
			e.printStackTrace();
			assertTrue("mutiGetTest  failed", false);	
		}
		
		 
	}
	
	
	@Test
	public void changeSkuTest() {
		try{
			mockServer.expect(requestTo(wishUrl("/variant/change-sku?access_token=someAccessToken")))
					.andExpect(method(POST))
//					.andExpect(header("Authorization", "OAuth someAccessToken"))
					.andRespond(withSuccess(jsonResource("variant.change-sku"), MediaType.APPLICATION_JSON));
		 
			wish.variantOperations().changeSku("1111", "2222222");
		}catch(Exception e){
			assertTrue("change sku  failed", false);	
		}
		
		assertTrue("enable successfully", true);	
	}
	
	@Test
	public void enableVariantTest() {
		try{
			mockServer.expect(requestTo(wishUrl("/variant/enable?access_token=someAccessToken")))
					.andExpect(method(POST))
//					.andExpect(header("Authorization", "OAuth someAccessToken"))
					.andRespond(withSuccess(jsonResource("variant.enable"), MediaType.APPLICATION_JSON));
			wish.variantOperations().enable("3333");
		}catch(Exception e){
			assertTrue("enable failed", false);
		}
		
		assertTrue("enable successfully", true);	
	}
	
	@Test
	public void disableVariantTest() {
		try{
			mockServer.expect(requestTo(wishUrl("/variant/disable?access_token=someAccessToken")))
					.andExpect(method(POST))
//					.andExpect(header("Authorization", "OAuth someAccessToken"))
					.andRespond(withSuccess(jsonResource("variant.disable"), MediaType.APPLICATION_JSON));
			wish.variantOperations().disable("3333");
		}catch(InsufficientPermissionException e){
			
		}
		
		assertTrue("enable successfully", true);	
	}
	
 
	
	 
	
	 
	
 
	 
 

}
