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
abstract class OrderMixin extends FacebookObjectMixin {

	@JsonProperty("order_id")
	String orderId;
	
	@JsonProperty("transaction_id")
	String transactionId;
	
	@JsonProperty("product_id")
	String productId;
	
	@JsonProperty("variant_id")
	String variantId;
	
	@JsonProperty("buyer_id")
	String buyerId;
	
	@JsonProperty("quantity")
	String quantity;
	
	@JsonProperty("sku")
	String sku;
	
	@JsonProperty("size")
	String size;
	
	@JsonProperty("color")
	String color;

	@JsonProperty("state")
	String state;
	
	@JsonProperty("shipping_provider")
	String shippingProvider;
	
	@JsonProperty("tracking_number")
	String trackingNumber;
	
	@JsonProperty("shipped_date")
	String shippedDate;
	
	@JsonProperty("ship_note")
	String shipNote;
	
	@JsonProperty("last_updated")
	String lastUpdated;
	
	@JsonProperty("order_total")
	String orderTotal;
	
//	@JsonProperty("days_to_fulfill")
//	String days_to_fulfill;
//	
//	@JsonProperty("hours_to_fulfill")
//	String hours_to_fulfill;
	
	@JsonProperty("price")
	String price;
	
	@JsonProperty("cost")
	String cost;
	
	@JsonProperty("shipping")
	String shipping;
	
//	@JsonProperty("shipping_cost")
//	String shipping_cost;

//	@JsonProperty("product_name")
//	String product_name;
	
	@JsonProperty("product_image_url")
	String productImageUrl;
	
	@JsonProperty("order_time")
	String orderTime;
	
	@JsonProperty("ShippingDetail")
	Shipping shippingDetail;
//	
//	@JsonProperty("refunded_by")
//	String refunded_by;

//	@JsonProperty("refunded_time")
//	String refunded_time;
	
	@JsonProperty("refunded_reason")
	String refundedReason;
	
	@JsonProperty("is_wish_express")
	String isWishExpress;
	
	@JsonProperty("we_required_delivery_date")
	String weRequiredDeliveryDate;
	
	@JsonProperty("tracking_confirmed")
	String trackingConfirmed;

	@JsonProperty("tracking_confirmed_date")
	String trackingConfirmedDate;
 
}
