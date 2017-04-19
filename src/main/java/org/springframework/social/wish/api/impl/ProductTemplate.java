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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.wish.api.Order;
import org.springframework.social.wish.api.Product;
import org.springframework.social.wish.api.ProductOperations;
import org.springframework.social.wish.api.ShippingPrice;
import org.springframework.social.wish.api.TagDozerConverter;
import org.springframework.social.wish.api.base.WishApi;
import org.springframework.social.wish.api.base.PagedList;
import org.springframework.social.wish.api.base.PagingParameters;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import au.com.bytecode.opencsv.CSVReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingOptions;

class ProductTemplate implements ProductOperations {

	private final WishApi wishApi;
	public ProductTemplate(WishApi wishApi) {
		this.wishApi = wishApi;
	}

	public PagedList<Product> getProducts(PagingParameters pagedListParameters){
		MultiValueMap<String, String> params = getPagingParameters(pagedListParameters);
		return wishApi.fetchConnections("", "product/multi-get", Product.class, params);
	}
	
	public Map<String, ?> createDownloadJob(){
		return wishApi.fetchObject("/product/create-download-job", Map.class);
	}
	
	public Map<String, ?> createDownloadJob(String since){
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("since", since);
		return wishApi.fetchObject("/product/create-download-job", Map.class, queryParameters);
	}
	
	public Map<String, ?> getDownloadJobStatusById(String jobId) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("job_id", jobId);
		return wishApi.fetchObject("/product/get-download-job-status", Map.class, queryParameters);
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
		
		String path = 
//				Thread.currentThread().getContextClassLoader()
//				.getResource("").getPath()
				"/Users/linwaiwai/Documents/workspace/dianguanjia/" + "download/"+ FilenameUtils.getName(parts[0]);//这个download目录为啥建立在classes下的
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

	public List<Product> getAllProductFromCVS(File file) {
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
	    			mapping(Map.class, Product.class,  TypeMappingOptions.mapNull(true))
	    			.fields("Product ID","id")
	    			.fields("Product Name","name")
	    			.fields("Description","description")
	    			.fields("# of Wishes","countOfWishes")
	    			.fields("# of Sales","countOfSales")
	    			.fields("Parent SKU","parentSku")
	    			.fields("UPC","upc")
	    			.fields("Landing Page URL","landingPageUrl")
//	    			.fields("Variation ID","") // don’t know how to use 
	    			.fields("SKU","sku")
	    			.fields("Color","color")
	    			.fields("MSRP","msrp")
	    			.fields("Cost","cost")
	    			.fields("Price","price")
	    			.fields("Shipping","shipping")
	    			.fields("Inventory","inventory")
	    			.fields("Shipping Time","shippingTime")
	    			.fields("Status","status")
	    			.fields("Is Promoted","isPromoted")
	    			.fields("Review State","reviewState")
	    			.fields("Counterfeit Reasons","counterfeitReasons")
	    			.fields("Image URL","mainImage")
	    			.fields("Extra Images","extraImages")
	    			.fields("Tags","tags",FieldsMappingOptions.customConverter(TagDozerConverter.class))
	    			.fields("Brand Name","brandName")
	    			.fields("Last Updated","lastUpdated")
	    			.fields("Date Uploaded","dateUploaded")
	    			.fields("Warning ID","warningID")
	    			.fields("Wish Express Countries","wishExpressCountries");
	    			 
	    		}
		    };
		    DozerBeanMapper mapper = new DozerBeanMapper();
		    mapper.addMapping(builder);

		    List<Product> wproducts = new ArrayList<Product>(); 
			for (HashMap<String, String> product : products){
		    		Product destObject =  
		    			    mapper.map(product, Product.class);
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


	public Product add(Product product) {
		return wishApi.post("/product/add", Product.class, product.toRequestParameters());
	}

	 

	public Product get(String id, String parent_sku) {
 
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		if (parent_sku != null)
			queryParameters.set("parent_sku", parent_sku);
		if (id != null)
			queryParameters.set("id", id);
		return wishApi.fetchObject("/product/get", Product.class, queryParameters);
	}


	public void update(Product product) {
		wishApi.post("/product/update", Map.class, product.toRequestParameters());
	}


	public void enable(String id, String parent_sku) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("parent_sku", parent_sku);
		queryParameters.set("id", id);
		wishApi.post("/product/enable", Map.class, queryParameters);
		
	}


	public void disable(String id, String parent_sku) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("parent_sku", parent_sku);
		queryParameters.set("id", id);
		wishApi.post("/product/disable", Map.class, queryParameters);
	}


	public void removeExtraImages(String id, String parent_sku) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.set("parent_sku", parent_sku);
		queryParameters.set("id", id);
		wishApi.post("/product/remove-extra-images", Map.class, queryParameters);
	}


	public void updateShipping(ShippingPrice shippingPrice) {
		wishApi.post("/product/update-shipping", Map.class, shippingPrice.toRequestParameters());
	}


	public boolean updateShipping(String id, String parent_sku, String country) {
		// TODO Auto-generated method stub
		return false;
	}
 
	
	private static final String[] ALL_FIELDS =
		{ "id", "attachment", "can_comment", "can_remove", "comment_count", "created_time", "from", "like_count", "message", "parent", "user_likes" };
	public void updateMultiShipping(String id, Map<String, Float> country, String use_product_shipping_countries,
			String disabled_countries, String wish_express_countries) {
		// TODO Auto-generated method stub
		
	}
	



	 

}
