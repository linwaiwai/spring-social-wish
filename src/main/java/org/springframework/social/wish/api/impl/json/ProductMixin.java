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

import java.util.List;

import org.springframework.social.wish.api.Tag;
import org.springframework.social.wish.api.TagDeserializer;
import org.springframework.social.wish.api.Variant;
import org.springframework.social.wish.api.VariantDeserializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
 
/**
 * Annotated mixin to add Jackson annotations to Album. 
 * @author Craig Walls
 */
@JsonRootName(value="Product")
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ProductMixin extends WishObjectMixin {
	
	@JsonProperty("name")
	String name;
	
	@JsonProperty("description")
	String description;
	
	@JsonProperty("product_id")
	String productId;
	
	@JsonDeserialize(using=TagDeserializer.class)
	@JsonProperty("tags")
	List<Tag> tags;
	
	@JsonProperty("sku")
	String sku;
	
	@JsonProperty("color")
	String color;
	
	@JsonProperty("size")
	String size;
	
	@JsonProperty("inventory")
	String inventory;
	
	@JsonProperty("price")
	String price;

	@JsonProperty("shipping")
	String shipping;
	
	@JsonProperty("msrp")
	String msrp;
	
	@JsonProperty("shipping_time")
	String shippingTime;
	
	@JsonProperty("main_image")
	String mainImage;
	
	@JsonProperty("parent_sku")
	String parentSku;
	
	@JsonProperty("brand")
	String brand;
	
	@JsonProperty("landing_page_url")
	String landingPageUrl;
	
	@JsonProperty("product_image_url")
	String productImageUrl;
	
	@JsonProperty("upc")
	String upc;
	
	@JsonProperty("extra_images")
	String extraImages;
	
	
	@JsonProperty("variants")
	@JsonDeserialize(using=VariantDeserializer.class)
	List<Variant> variants;
 
}
