package org.springframework.social.facebook.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.ApiException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public interface  OrderOperations {
	/**
	 * Retrieves comments for a given object.
	 * @param objectId the ID of the object
	 * @param pagedListParameters the parameters defining the bounds of the list to return.
	 * @return a list of {@link Comment}s for the specified object
	 * @throws ApiException if there is an error while communicating with Facebook.
	 */
	abstract PagedList<Order> getOrders(PagingParameters pagedListParameters);
	abstract Map<String, ?> createDownloadJob() ; //  download all product
	abstract Map<String, ?> createDownloadJob( String since) ; // download products since ...
	abstract Map<String, ?> getDownloadJobStatusById( String jobId) ;  
	abstract String downloadCVSFile( String linkId) ;  
	abstract List<Order> getAllOrderFromCVS( File file ) ;
//	abstract List<Product> getAllProductFromCVS(File file);
}
