package org.springframework.social.wish.api;

import java.util.List;
 
import org.springframework.social.wish.api.base.PagingParameters;
 

public interface  VariantOperations {
	 
	 
	abstract Variant add( Variant variant) ; // return a product with id
	
	abstract Variant get( String sku) ; // return a product with id
	
	abstract void update( Variant variant) ;  
	
	abstract void enable( String sku ) ;
	
	abstract void disable( String sku ) ;
	
	abstract void changeSku( String sku, String new_sku ) ;
	
	abstract void updateInventory(String sku, String inventory);
	
	abstract List<Variant> multiGet(PagingParameters pagedListParameters);
}
