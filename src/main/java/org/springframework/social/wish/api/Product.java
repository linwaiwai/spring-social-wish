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

import java.util.List;
import java.util.Map; 
import org.dozer.DozerBeanMapper;
//import org.dozer.*;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.social.wish.api.TagDozerConverter;
//@JsonDeserialize(using=OrderDeserializer.class)
public class Product extends WishObject {
	
	public MultiValueMap<String, String> toRequestParameters() {
	 
		 
		BeanMappingBuilder builder = new BeanMappingBuilder() {
    		protected void configure() {
    			mapping(Product.class,  Map.class,  TypeMappingOptions.mapNull(false))
    			.fields("name","name")
    			.fields("description","description")
    			.fields("tags","tags",FieldsMappingOptions.customConverter(TagDozerConverter.class))
    			.fields("sku","sku")
    			.fields("color","color")
    			.fields("size","size")
    			.fields("inventory","inventory")
    			.fields("price","price")
    			.fields("shipping","shipping")
    			.fields("msrp","msrp")
    			.fields("shippingTime","shipping_time")
    			.fields("mainImage","main_image")
    			.fields("parentSku","parent_sku")
    			.fields("brand","brand")
    			.fields("landingPageUrl","landing_page_url")
    			.fields("upc","upc")
    			.fields("extraImages","extra_images");
    			 
    		}
	    };
	    DozerBeanMapper mapper = new DozerBeanMapper();
	    mapper.addMapping(builder);
	    @SuppressWarnings("unchecked")
		Map<String, String> destObject =  
			    mapper.map(this, Map.class);
		
	    String[] requiredFields = {
	    		"name","description","tags","sku","inventory","price","shipping"
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}
	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the inventory
	 */
	public String getInventory() {
		return inventory;
	}
	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(String inventory) {
		this.inventory = inventory;
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
	 * @return the shipping
	 */
	public String getShipping() {
		return shipping;
	}
	/**
	 * @param shipping the shipping to set
	 */
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	/**
	 * @return the msrp
	 */
	public String getMsrp() {
		return msrp;
	}
	/**
	 * @param msrp the msrp to set
	 */
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}
	/**
	 * @return the shippingTime
	 */
	public String getShippingTime() {
		return shippingTime;
	}
	/**
	 * @param shippingTime the shippingTime to set
	 */
	public void setShippingTime(String shippingTime) {
		this.shippingTime = shippingTime;
	}
	/**
	 * @return the mainImage
	 */
	public String getMainImage() {
		return mainImage;
	}
	/**
	 * @param mainImage the mainImage to set
	 */
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	/**
	 * @return the parentSku
	 */
	public String getParentSku() {
		return parentSku;
	}
	/**
	 * @param parentSku the parentSku to set
	 */
	public void setParentSku(String parentSku) {
		this.parentSku = parentSku;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the landingPageUrl
	 */
	public String getLandingPageUrl() {
		return landingPageUrl;
	}
	/**
	 * @param landingPageUrl the landingPageUrl to set
	 */
	
	public void setLandingPageUrl(String landingPageUrl) {
		this.landingPageUrl = landingPageUrl;
	}
	/**
	 * @return the upc
	 */
	public String getUpc() {
		return upc;
	}
	/**
	 * @param upc the upc to set
	 */
	public void setUpc(String upc) {
		this.upc = upc;
	}
	/**
	 * @return the extraImages
	 */
	public String getExtraImages() {
		return extraImages;
	}
	/**
	 * @param extraImages the extraImages to set
	 */
	public void setExtraImages(String extraImages) {
		this.extraImages = extraImages;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public List<Variant> getVariants() {
		return variants;
	}
	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}
	public String getCountOfWishes() {
		return countOfWishes;
	}
	public void setCountOfWishes(String countOfWishes) {
		this.countOfWishes = countOfWishes;
	}
	public String getCountOfSales() {
		return countOfSales;
	}
	public void setCountOfSales(String countOfSales) {
		this.countOfSales = countOfSales;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsPromoted() {
		return isPromoted;
	}
	public void setIsPromoted(String isPromoted) {
		this.isPromoted = isPromoted;
	}
	public String getReviewState() {
		return reviewState;
	}
	public void setReviewState(String reviewState) {
		this.reviewState = reviewState;
	}
	public String getCounterfeitReasons() {
		return counterfeitReasons;
	}
	public void setCounterfeitReasons(String counterfeitReasons) {
		this.counterfeitReasons = counterfeitReasons;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getDateUploaded() {
		return dateUploaded;
	}
	public void setDateUploaded(String dateUploaded) {
		this.dateUploaded = dateUploaded;
	}
	public String getWarningID() {
		return warningID;
	}
	public void setWarningID(String warningID) {
		this.warningID = warningID;
	}
	public String getWishExpressCountries() {
		return wishExpressCountries;
	}
	public void setWishExpressCountries(String wishExpressCountries) {
		this.wishExpressCountries = wishExpressCountries;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	private String countOfWishes;
	private String countOfSales;
	
	private String id;
	private String name;
	private String description;
	private List<Tag> tags;
	private String sku;
	private String color;
	private String size;
	private String inventory;
	private String price;
	private String shipping;
	private String msrp;
	private String cost;
	private String shippingTime;
	private String status;
	private String isPromoted;
	private String reviewState;
	private String counterfeitReasons;
	private String brandName;
	private String mainImage;
	private String parentSku;
	private String brand;
	private String landingPageUrl;
	private String upc;
	private String lastUpdated;
	private String dateUploaded;
	private String warningID;
	private String wishExpressCountries;
	private String extraImages;
	private List<Variant> variants;
	 
	 

 
	
 
	
	  
}
