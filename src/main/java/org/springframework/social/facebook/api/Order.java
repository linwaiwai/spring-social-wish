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
public class Order extends FacebookObject {

	 
	private String orderId;

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
	 * @return the variantId
	 */
	public String getVariantId() {
		return variantId;
	}

	/**
	 * @param variantId the variantId to set
	 */
	public void setVariantId(String variantId) {
		this.variantId = variantId;
	}

	/**
	 * @return the buyerId
	 */
	public String getBuyerId() {
		return buyerId;
	}

	/**
	 * @param buyerId the buyerId to set
	 */
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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
	 * @return the shippingProvider
	 */
	public String getShippingProvider() {
		return shippingProvider;
	}

	/**
	 * @param shippingProvider the shippingProvider to set
	 */
	public void setShippingProvider(String shippingProvider) {
		this.shippingProvider = shippingProvider;
	}

	/**
	 * @return the trackingNumber
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}

	/**
	 * @param trackingNumber the trackingNumber to set
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	/**
	 * @return the shippedDate
	 */
	public String getShippedDate() {
		return shippedDate;
	}

	/**
	 * @param shippedDate the shippedDate to set
	 */
	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
	}

	/**
	 * @return the shipNote
	 */
	public String getShipNote() {
		return shipNote;
	}

	/**
	 * @param shipNote the shipNote to set
	 */
	public void setShipNote(String shipNote) {
		this.shipNote = shipNote;
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
	 * @return the orderTotal
	 */
	public String getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
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
	public Shipping getShippingDetail() {
		return shippingDetail;
	}

	/**
	 * @param shipping the shipping to set
	 */
	public void setShippingDetail(Shipping shippingDetail) {
		this.shippingDetail = shippingDetail;
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productImageUrl
	 */
	public String getProductImageUrl() {
		return productImageUrl;
	}

	/**
	 * @param productImageUrl the productImageUrl to set
	 */
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	/**
	 * @return the orderTime
	 */
	public String getOrderTime() {
		return orderTime;
	}

	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}


	/**
	 * @return the refundedBy
	 */
	public String getRefundedBy() {
		return refundedBy;
	}

	/**
	 * @param refundedBy the refundedBy to set
	 */
	public void setRefundedBy(String refundedBy) {
		this.refundedBy = refundedBy;
	}

	/**
	 * @return the refundedTime
	 */
	public String getRefundedTime() {
		return refundedTime;
	}

	/**
	 * @param refundedTime the refundedTime to set
	 */
	public void setRefundedTime(String refundedTime) {
		this.refundedTime = refundedTime;
	}

	/**
	 * @return the refundedReason
	 */
	public String getRefundedReason() {
		return refundedReason;
	}

	/**
	 * @param refundedReason the refundedReason to set
	 */
	public void setRefundedReason(String refundedReason) {
		this.refundedReason = refundedReason;
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
	 * @return the weRequiredDeliveryDate
	 */
	public String getWeRequiredDeliveryDate() {
		return weRequiredDeliveryDate;
	}

	/**
	 * @param weRequiredDeliveryDate the weRequiredDeliveryDate to set
	 */
	public void setWeRequiredDeliveryDate(String weRequiredDeliveryDate) {
		this.weRequiredDeliveryDate = weRequiredDeliveryDate;
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

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getProductLink() {
		return productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	private String transactionId;
	
	private String transactionDate;
	
	private String orderState;
	
	private String productId;

	private String productLink;
	
	private String variantId;
	
	private String buyerId;
	
	private String quantity;
	
	private String sku;
	
	private String size;
	
	private String color;
	
	private String state;
	
	private String shippingProvider;
	
	private String trackingNumber;
	
	private String shippedDate;
	
	private String shipNote;
	
	private String lastUpdated;
	
	private String orderTotal;
	
	private String daysToFulfill;
	
	private String hoursToFulfill;
	
	private String price;
	
	private String totalCost;
	
	private String shippedOn;
	
	private String confirmedDelivery;
	
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

	public String getShippedOn() {
		return shippedOn;
	}

	public void setShippedOn(String shippedOn) {
		this.shippedOn = shippedOn;
	}

	public String getConfirmedDelivery() {
		return confirmedDelivery;
	}

	public void setConfirmedDelivery(String confirmedDelivery) {
		this.confirmedDelivery = confirmedDelivery;
	}

	private String cost;
	
	private String shipping;
	
	private String shippingCost;

	private String productName;
	
	private String productImageUrl;
	
	private String orderTime;
	
	private Shipping shippingDetail;
	
	private String refundedBy;

	private String refundedTime;
	
	private String refundedReason;
	
	private String isWishExpress;
	
	private String weRequiredDeliveryDate;
	
	private String trackingConfirmed;

	private String trackingConfirmedDate;
	
	private String refundReason;
	
	private String refundDate;
	
	private String  refundResponsibility;
	
	private String refundResponsibilityAmount;
	
	
	
	
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

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}

	public String getRefundResponsibility() {
		return refundResponsibility;
	}

	public void setRefundResponsibility(String refundResponsibility) {
		this.refundResponsibility = refundResponsibility;
	}

	public String getRefundResponsibilityAmount() {
		return refundResponsibilityAmount;
	}

	public void setRefundResponsibilityAmount(String refundResponsibilityAmount) {
		this.refundResponsibilityAmount = refundResponsibilityAmount;
	}

	private String wishExpressDeliveryDeadline;
	
	  
}
