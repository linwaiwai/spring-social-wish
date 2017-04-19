package org.springframework.social.wish.api;

import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
//import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Variant extends WishObject  {
	
	public MultiValueMap<String, String> toRequestParameters() {
		BeanMappingBuilder builder = new BeanMappingBuilder() {
    		protected void configure() {
    			mapping(Variant.class,  Map.class,  TypeMappingOptions.mapNull(false))
    			.fields("sku","sku")
    			.fields("inventory","inventory")
    			.fields("price","price")
    			.fields("shipping","shipping")
    			.fields("enabled","enabled")
    			.fields("size","size")
    			.fields("color","color")
    			.fields("msrp","msrp")
    			.fields("shippingTime","shipping_time")
    			.fields("mainImage","main_image");
    		}
	    };
	    DozerBeanMapper mapper = new DozerBeanMapper();
	    mapper.addMapping(builder);
	    @SuppressWarnings("unchecked")
		Map<String, String> destObject =  
			    mapper.map(this, Map.class);
		
//	    String[] requiredFields = {
//	    		"name","description","tags","sku","inventory","price","shipping"
//	    };
//	    for (String field : requiredFields){
//	    	if (!destObject.containsKey(field))
//	    		throw new WishApiException(WishErrors.LACK_REQUIRED_FIELD, "lack of required field:"+ field);	
//	    }
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.setAll(destObject);
		
		return queryParameters;	
	}
	 
	String sku;
	String inventory;
	String price;
	String shipping;	 
	String enabled;
	String size;
	String color;
	String msrp;
	String shippingTime;
	String mainImage;
	String productId;
	String allImages;
	String id;
	

	
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
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}


	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}


	/**
	 * @return the allImages
	 */
	public String getAllImages() {
		return allImages;
	}


	/**
	 * @param allImages the allImages to set
	 */
	public void setAllImages(String allImages) {
		this.allImages = allImages;
	}


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

	
}
