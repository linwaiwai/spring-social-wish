package org.springframework.social.wish.api;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.social.ApiException;
import org.springframework.social.wish.api.base.PagedList;
import org.springframework.social.wish.api.base.PagingParameters;
 

public interface  ProductOperations {
	abstract PagedList<Product> getProducts(PagingParameters pagedListParameters);
	abstract Map<String, ?> createDownloadJob() ; //  download all product
	abstract Map<String, ?> createDownloadJob( String since) ; // download products since ...
	abstract Map<String, ?> getDownloadJobStatusById( String jobId) ;
	
	abstract String downloadCVSFile( String linkId) ;  
	
	abstract List<Product> getAllProductFromCVS( File file ) ;
	
	abstract Product add( Product product) ; // return a product with id
	
	abstract Product get( String id, String parent_sku) ; // return a product with id
	
	abstract void update( Product product) ;  
	
	abstract void enable( String id, String parent_sku ) ;
	
	abstract void disable( String id, String parent_sku ) ;
	
	abstract void removeExtraImages( String id, String parent_sku ) ;
	
	abstract void updateShipping(ShippingPrice shippingPrice);
	
	abstract void updateMultiShipping( String id, Map<String,Float> country, String use_product_shipping_countries, String disabled_countries,String wish_express_countries);
	
	
}
