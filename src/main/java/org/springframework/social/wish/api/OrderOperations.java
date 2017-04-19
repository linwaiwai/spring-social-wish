package org.springframework.social.wish.api;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.social.ApiException;
import org.springframework.social.wish.api.base.PagedList;
import org.springframework.social.wish.api.base.PagingParameters;
 

public interface  OrderOperations {

	abstract PagedList<Order> getOrders(PagingParameters pagedListParameters);
	abstract Map<String, ?> createDownloadJob() ; //  download all product
	abstract Map<String, ?> createDownloadJob( String since) ; // download products since ...
	abstract Map<String, ?> getDownloadJobStatusById( String jobId) ;  
	abstract String downloadCVSFile( String linkId) ;  
	abstract List<Order> getAllOrderFromCVS( File file ) ;
//	abstract List<Product> getAllProductFromCVS(File file);
}
