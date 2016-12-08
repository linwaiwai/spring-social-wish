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
package org.springframework.social.facebook.api;


//@JsonDeserialize(using=OrderDeserializer.class)
public class Product extends FacebookObject {

	 


	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the orderState
	 */
	public String getOrderState() {
		return orderState;
	}

	/**
	 * @param orderState the orderState to set
	 */
	public void setOrderState(String orderState) {
		this.orderState = orderState;
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
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
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
	 * @return the productLink
	 */
	public String getProductLink() {
		return productLink;
	}

	/**
	 * @param productLink the productLink to set
	 */
	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	/**
	 * @return the productImageURL
	 */
	public String getProductImageURL() {
		return productImageURL;
	}

	/**
	 * @param productImageURL the productImageURL to set
	 */
	public void setProductImageURL(String productImageURL) {
		this.productImageURL = productImageURL;
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
	 * @return the cost
	 */
	public String getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(String cost) {
		this.cost = cost;
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
	 * @return the shippingCost
	 */
	public String getShippingCost() {
		return shippingCost;
	}

	/**
	 * @param shippingCost the shippingCost to set
	 */
	public void setShippingCost(String shippingCost) {
		this.shippingCost = shippingCost;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the totalCost
	 */
	public String getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the daysToFulfill
	 */
	public String getDaysToFulfill() {
		return daysToFulfill;
	}

	/**
	 * @param daysToFulfill the daysToFulfill to set
	 */
	public void setDaysToFulfill(String daysToFulfill) {
		this.daysToFulfill = daysToFulfill;
	}

	/**
	 * @return the hoursToFulfill
	 */
	public String getHoursToFulfill() {
		return hoursToFulfill;
	}

	/**
	 * @param hoursToFulfill the hoursToFulfill to set
	 */
	public void setHoursToFulfill(String hoursToFulfill) {
		this.hoursToFulfill = hoursToFulfill;
	}

	/**
	 * @return the shippedOn
	 */
	public String getShippedOn() {
		return shippedOn;
	}

	/**
	 * @param shippedOn the shippedOn to set
	 */
	public void setShippedOn(String shippedOn) {
		this.shippedOn = shippedOn;
	}

	/**
	 * @return the confirmedDelivery
	 */
	public String getConfirmedDelivery() {
		return confirmedDelivery;
	}

	/**
	 * @param confirmedDelivery the confirmedDelivery to set
	 */
	public void setConfirmedDelivery(String confirmedDelivery) {
		this.confirmedDelivery = confirmedDelivery;
	}

	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * @return the tracking
	 */
	public String getTracking() {
		return tracking;
	}

	/**
	 * @param tracking the tracking to set
	 */
	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	/**
	 * @return the trackingConfirmed
	 */
	public String getTrackingConfirmed() {
		return trackingConfirmed;
	}

	/**
	 * @param trackingConfirmed the trackingConfirmed to set
	 */
	public void setTrackingConfirmed(String trackingConfirmed) {
		this.trackingConfirmed = trackingConfirmed;
	}

	/**
	 * @return the trackingConfirmedDate
	 */
	public String getTrackingConfirmedDate() {
		return trackingConfirmedDate;
	}

	/**
	 * @param trackingConfirmedDate the trackingConfirmedDate to set
	 */
	public void setTrackingConfirmedDate(String trackingConfirmedDate) {
		this.trackingConfirmedDate = trackingConfirmedDate;
	}

	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the streetAddress1
	 */
	public String getStreetAddress1() {
		return streetAddress1;
	}

	/**
	 * @param streetAddress1 the streetAddress1 to set
	 */
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	/**
	 * @return the streetAddress2
	 */
	public String getStreetAddress2() {
		return streetAddress2;
	}

	/**
	 * @param streetAddress2 the streetAddress2 to set
	 */
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	 * @return the lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the refundResponsibility
	 */
	public String getRefundResponsibility() {
		return refundResponsibility;
	}

	/**
	 * @param refundResponsibility the refundResponsibility to set
	 */
	public void setRefundResponsibility(String refundResponsibility) {
		this.refundResponsibility = refundResponsibility;
	}

	/**
	 * @return the refundResponsibilityAmount
	 */
	public String getRefundResponsibilityAmount() {
		return refundResponsibilityAmount;
	}

	/**
	 * @param refundResponsibilityAmount the refundResponsibilityAmount to set
	 */
	public void setRefundResponsibilityAmount(String refundResponsibilityAmount) {
		this.refundResponsibilityAmount = refundResponsibilityAmount;
	}

	/**
	 * @return the refundDate
	 */
	public String getRefundDate() {
		return refundDate;
	}

	/**
	 * @param refundDate the refundDate to set
	 */
	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}

	/**
	 * @return the refundReason
	 */
	public String getRefundReason() {
		return refundReason;
	}

	/**
	 * @param refundReason the refundReason to set
	 */
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	/**
	 * @return the isWishExpress
	 */
	public String getIsWishExpress() {
		return isWishExpress;
	}

	/**
	 * @param isWishExpress the isWishExpress to set
	 */
	public void setIsWishExpress(String isWishExpress) {
		this.isWishExpress = isWishExpress;
	}

	/**
	 * @return the wishExpressDeliveryDeadline
	 */
	public String getWishExpressDeliveryDeadline() {
		return wishExpressDeliveryDeadline;
	}

	/**
	 * @param wishExpressDeliveryDeadline the wishExpressDeliveryDeadline to set
	 */
	public void setWishExpressDeliveryDeadline(String wishExpressDeliveryDeadline) {
		this.wishExpressDeliveryDeadline = wishExpressDeliveryDeadline;
	}
	
	private String transactionDate;

	private String orderId;
	
	private String transactionId;
	
	private String orderState;
	
	private String sku;
	
	private String product;
	
	private String productId;
	
	private String productLink;
	
	private String productImageURL;
	
	private String size;
	
	private String color;
	
	private String price;
	
	private String cost;
	
	private String shipping;
	
	private String shippingCost;
	
	private String quantity;
	
	private String totalCost;
	
	private String daysToFulfill;
	
	private String hoursToFulfill;

	private String shippedOn;
	
	private String confirmedDelivery;
	
	private String provider;
	
	private String tracking;
	
	private String trackingConfirmed;

	private String trackingConfirmedDate;
	
	private String shippingAddress;
	
	private String name;
	
	private String firstName;
	
	private String lastName;

	private String streetAddress1;
	
	private String streetAddress2;
	
	private String city;
	
	private String state;
	
	private String zipcode;

	private String country;
	
	private String lastUpdated;
	
	private String phoneNumber;
	
	private String countryCode;
	
	private String refundResponsibility;

	private String refundResponsibilityAmount;
	
	private String refundDate;
	
	private String refundReason;
	
	private String isWishExpress;

	private String wishExpressDeliveryDeadline;
	
 
	
	  
}
