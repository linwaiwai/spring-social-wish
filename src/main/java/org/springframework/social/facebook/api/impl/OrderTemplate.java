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
package org.springframework.social.facebook.api.impl;

import static org.springframework.social.facebook.api.impl.PagedListUtils.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.facebook.api.Comment;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.GraphApi;
import org.springframework.social.facebook.api.Order;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Product;
import org.springframework.social.facebook.api.Shipping;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import au.com.bytecode.opencsv.CSVReader;

import org.springframework.social.facebook.api.OrderOperations;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

class OrderTemplate implements OrderOperations {

	private final GraphApi graphApi;
	public OrderTemplate(GraphApi graphApi) {
		this.graphApi = graphApi;
	}

	
	public PagedList<Order> getOrders( PagingParameters pagedListParameters) {
		MultiValueMap<String, String> params = getPagingParameters(pagedListParameters);
		return graphApi.fetchConnections("", "order/multi-get", Order.class, params);
	}
	
	public Map<String, ?> createDownloadJob(){
		return graphApi.fetchObject("/order/create-download-job", Map.class);
	}
	
	public Map<String, ?> createDownloadJob(String since){
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("since", since);
		return graphApi.fetchObject("/order/create-download-job", Map.class, queryParameters);
	}
	
 
	
	public Map<String, ?> getDownloadJobStatusById(String jobId) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("job_id", jobId);
		return graphApi.fetchObject("/order/get-download-job-status", Map.class, queryParameters);
	}

	public String downloadCVSFile(String linkId) {
		// TODO Auto-generated method stub
		URL url = null;
		try {
			url = new URL(linkId);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		String[] parts = url.toString().split("\\?");
		
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath()
				+ "download/"+ FilenameUtils.getName(parts[0]);//这个download目录为啥建立在classes下的
//	    Path targetPath = new File(path).toPath();

	    try {
	    	FileUtils.copyURLToFile(url,  new File(path));
//	    	InputStream in = url.openStream();
//			Files.copy(in, targetPath,
//			        StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return path;
	}

	public List<Order> getAllOrderFromCVS(File file) {
		CSVReader reader;
		try {
			reader = new CSVReader(new FileReader(file));
			String [] nextLine;
			String [] headers = reader.readNext();
			List<HashMap<String, String>> products = new ArrayList<HashMap<String, String>>();
			while ((nextLine = reader.readNext()) != null) {
			   // nextLine[] is an array of values from the line
				
				Integer i = 0;
				HashMap<String, String> product = new HashMap<String ,String>(); 
				for ( String head : headers){
					product.put(head, nextLine[i]);
					i++;
				}
				products.add(product);
//				System.out.println(nextLine[0] + nextLine[1] + "etc...");
			}
			 
	    	BeanMappingBuilder builder = new BeanMappingBuilder() {
	    		protected void configure() {
	    			mapping(Map.class, Order.class,  TypeMappingOptions.mapNull(true))
	    			.fields("Transaction Date","transactionDate")
	    			.fields("Order Id","orderId")
	    			.fields("Transaction ID","transactionId")
	    			.fields("Order State","orderState")
	    			.fields("SKU","sku")
	    			.fields("Product","productName")
	    			.fields("Product ID","productId")
	    			.fields("Product Link","productLink")
	    			.fields("Product Image URL","productImageUrl")
	    			.fields("Size","size")
	    			.fields("Color","color")
	    			.fields("Price (each)","price")
	    			.fields("Cost (each)","cost")
	    			.fields("Shipping (each)","shipping")
	    			.fields("Shipping Cost (each)","shippingCost")
	    			.fields("Quantity","quantity")
	    			.fields("Total Cost","totalCost")
	    			.fields("Days to Fulfill","daysToFulfill")
	    			.fields("Hours to Fulfill","hoursToFulfill")
	    			.fields("Shipped on","shippedOn")
	    			.fields("Confirmed Delivery","confirmedDelivery")
	    			.fields("Provider","shippingProvider")
	    			.fields("Tracking","trackingNumber")
	    			.fields("Tracking Confirmed","trackingConfirmed")
	    			.fields("Tracking Confirmed Date","trackingConfirmedDate")
	    			.fields("Last Updated","lastUpdated")
	    			.fields("Shipping Address","shippingDetail.shippingAddress")
	    			.fields("Name","shippingDetail.name")
	    			.fields("First Name","shippingDetail.firstName")
	    			.fields("Last Name","shippingDetail.lastName")
	    			.fields("Street Address 1","shippingDetail.streetAddress1")
	    			.fields("Street Address 2","shippingDetail.streetAddress2")
	    			.fields("City","shippingDetail.city")
	    			.fields("State","shippingDetail.state")
	    			.fields("Zipcode","shippingDetail.zipcode")
	    			.fields("Country","shippingDetail.country")
	    			.fields("Phone Number","shippingDetail.phoneNumber")
	    			.fields("Country Code","shippingDetail.countryCode")
	    			.fields("% Refund Responsibility","refundResponsibility")
	    			.fields("Refund Responsibility Amount","refundResponsibilityAmount")
	    			.fields("Refund Date","refundDate")
	    			.fields("Refund Reason","refundReason")
	    			.fields("Is Wish Express","isWishExpress")
	    			.fields("Wish Express Delivery Deadline","wishExpressDeliveryDeadline");
		        	
		               
	    		}
		    };
		    DozerBeanMapper mapper = new DozerBeanMapper();
		    mapper.addMapping(builder);

		    List<Order> wproducts = new ArrayList<Order>(); 
			for (HashMap<String, String> product : products){
		    		Order destObject =  
		    			    mapper.map(product, Order.class);
		    		wproducts.add(destObject);
			}
			return wproducts;
			
		} catch (FileNotFoundException e) {
 
			e.printStackTrace();
		} catch (IOException e) {
	 
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	 

//	public Comment getComment(String commentId) {
//		return graphApi.fetchObject(commentId, Comment.class, ALL_FIELDS);
//	}
//
//	public String addComment(String objectId, String message) {
//		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
//		map.set("message", message);
//		return graphApi.publish(objectId, "comments", map);
//	}
//
//	public void deleteComment(String objectId) {
//		graphApi.delete(objectId);
//	}

	private static final String[] ALL_FIELDS =
		{ "id", "attachment", "can_comment", "can_remove", "comment_count", "created_time", "from", "like_count", "message", "parent", "user_likes" };
 



	 

}
