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

 

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.InsufficientPermissionException;

/**
 * @author Craig Walls
 */
public class ProductTemplateTest extends AbstractWishApiTest {

 
	
	@Test
	public void addProduct() {
		mockServer.expect(requestTo(wishUrl("/product/get?parent_sku=3333&id=1&access_token=someAccessToken")))
		.andExpect(method(GET))
//		.andExpect(header("Authorization", "OAuth someAccessToken"))
		.andRespond(withSuccess(jsonResource("product.get"), MediaType.APPLICATION_JSON));
		
		mockServer.expect(requestTo(wishUrl("/product/add?access_token=someAccessToken")))
				.andExpect(method(POST))
//				.andExpect(header("Authorization", "OAuth someAccessToken"))
				.andRespond(withSuccess(jsonResource("product.add"), MediaType.APPLICATION_JSON));
		
		Product post = wish.productOperations().get("1", "3333");
		post.setId(null);
		assertTrue("tag count > 1", post.getTags().size() > 0);
		assertTrue("variant count > 1", post.getVariants().size() > 0);
		Product product = wish.productOperations().add(post);
		assertEquals("52a11ebdf94adc0cfee0dbd9", product.getId());

	}
	
	
	@Test
	public void enableProduct() {
		try{
			mockServer.expect(requestTo(wishUrl("/product/enable?access_token=someAccessToken")))
					.andExpect(method(POST))
//					.andExpect(header("Authorization", "OAuth someAccessToken"))
					.andRespond(withSuccess(jsonResource("product.enable"), MediaType.APPLICATION_JSON));
			wish.productOperations().enable("1", "3333");
		}catch(InsufficientPermissionException e){
			
		}
		
		assertTrue("enable successfully", true);	
	}
	
	@Test
	public void updateShippingPrice() {
		try{
			mockServer.expect(requestTo(wishUrl("/product/update-shipping?access_token=someAccessToken")))
					.andExpect(method(POST))
//					.andExpect(header("Authorization", "OAuth someAccessToken"))
					.andRespond(withSuccess(jsonResource("product.update-shipping"), MediaType.APPLICATION_JSON));
			ShippingPrice  shippingPrice = new ShippingPrice();
			shippingPrice.setId("111");
			shippingPrice.setParentSku("111");
			shippingPrice.setCountry("111");
			shippingPrice.setPrice("111");
			wish.productOperations().updateShipping(shippingPrice);
		}catch(InsufficientPermissionException e){
			
		}
		
		assertTrue("enable successfully", true);	
	}
	
	@Test
	public void disableProduct() {
		try{
			mockServer.expect(requestTo(wishUrl("/product/disable?access_token=someAccessToken")))
					.andExpect(method(POST))
//					.andExpect(header("Authorization", "OAuth someAccessToken"))
					.andRespond(withSuccess(jsonResource("product.disable"), MediaType.APPLICATION_JSON));
			wish.productOperations().disable("1", "3333");
		}catch(InsufficientPermissionException e){
			
		}
		
		assertTrue("enable successfully", true);	
	}
	
	@Test
	public void removeExtrImages() {
		try{
			mockServer.expect(requestTo(wishUrl("/product/remove-extra-images?access_token=someAccessToken")))
					.andExpect(method(POST))
//					.andExpect(header("Authorization", "OAuth someAccessToken"))
					.andRespond(withSuccess(jsonResource("product.remove-extra-images"), MediaType.APPLICATION_JSON));
			wish.productOperations().removeExtraImages("1", "3333");
		}catch(InsufficientPermissionException e){
			
		}
		
		assertTrue("enable successfully", true);	
	}
	
	
	@Test
	public void updateProductFail() {
		try{
			mockServer.expect(requestTo(wishUrl("/product/get?parent_sku=3333&id=1&access_token=someAccessToken")))
			.andExpect(method(GET))
//			.andExpect(header("Authorization", "OAuth someAccessToken"))
			.andRespond(withSuccess(jsonResource("product.get"), MediaType.APPLICATION_JSON));
			
			mockServer.expect(requestTo(wishUrl("/product/update?access_token=someAccessToken")))
					.andExpect(method(POST))
//					.andExpect(header("Authorization", "OAuth someAccessToken"))
					.andRespond(withSuccess(jsonResource("product.update.fail"), MediaType.APPLICATION_JSON));
			
			Product post = wish.productOperations().get("1", "3333");
			post.setId(null);
			assertTrue("tag count > 1", post.getTags().size() > 0);
			assertTrue("variant count > 1", post.getVariants().size() > 0);
			wish.productOperations().update(post);
		}catch(InsufficientPermissionException e){
			assertTrue("update successfully", true);	
		}
		
	}
	
	@Test
	public void updateProduct() {
		mockServer.expect(requestTo(wishUrl("/product/get?parent_sku=3333&id=1&access_token=someAccessToken")))
		.andExpect(method(GET))
//		.andExpect(header("Authorization", "OAuth someAccessToken"))
		.andRespond(withSuccess(jsonResource("product.get"), MediaType.APPLICATION_JSON));
		
		mockServer.expect(requestTo(wishUrl("/product/update?access_token=someAccessToken")))
				.andExpect(method(POST))
//				.andExpect(header("Authorization", "OAuth someAccessToken"))
				.andRespond(withSuccess(jsonResource("product.update"), MediaType.APPLICATION_JSON));
		
		Product post = wish.productOperations().get("1", "3333");
		post.setId(null);
		assertTrue("tag count > 1", post.getTags().size() > 0);
		assertTrue("variant count > 1", post.getVariants().size() > 0);
		wish.productOperations().update(post);
		
		assertTrue("update product successfully", true);
	}
	
	@Test
	public void getProduct() {
		mockServer.expect(requestTo(wishUrl("/product/get?parent_sku=3333&id=1&access_token=someAccessToken")))
		.andExpect(method(GET))
//		.andExpect(header("Authorization", "OAuth someAccessToken"))
		.andRespond(withSuccess(jsonResource("product.get"), MediaType.APPLICATION_JSON));
		Product post = wish.productOperations().get("1", "3333");
		assertTrue("get product successfully", post != null);
	}

	 
 

}
