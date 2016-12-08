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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.UncategorizedApiException;
 
import org.springframework.social.facebook.api.Facebook;
 
import org.springframework.social.facebook.api.OrderOperations;

import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;

import org.springframework.social.facebook.api.TestOperations;
import org.springframework.social.facebook.api.impl.json.FacebookModule;
import org.springframework.social.facebook.api.impl.json.FacebookResolveDataModule;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.HttpRequestDecorator;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * <p>This is the central class for interacting with Facebook.</p>
 * <p>
 * There are some operations, such as searching, that do not require OAuth
 * authentication. In those cases, you may use a {@link FacebookTemplate} that is
 * created through the default constructor and without any OAuth details.
 * Attempts to perform secured operations through such an instance, however,
 * will result in {@link NotAuthorizedException} being thrown.
 * </p>
 * @author Craig Walls
 */
public class FacebookTemplate extends AbstractOAuth2ApiBinding implements Facebook {

	private String appId;
	
 
	
	private OrderOperations orderOperations;
	
	private ObjectMapper objectMapper;

	private String applicationNamespace;

	private String apiVersion = "2";
	private String accessToken;



	private TestOperations testOperations;
	
	
	private static final class OAuth2TokenParameterRequestInterceptor implements ClientHttpRequestInterceptor {
		private final String accessToken;
		
		public OAuth2TokenParameterRequestInterceptor(String accessToken) {
			this.accessToken = accessToken;
		}
		
		private static Map<String, List<String>> getQueryParams(String url) {
		    try {
		        Map<String, List<String>> params = new HashMap<String, List<String>>();
		        String[] urlParts = url.split("\\?");
		        if (urlParts.length > 1) {
		            String query = urlParts[1];
		            for (String param : query.split("&")) {
		                String[] pair = param.split("=");
		                String key = URLDecoder.decode(pair[0], "UTF-8");
		                String value = "";
		                if (pair.length > 1) {
		                    value = URLDecoder.decode(pair[1], "UTF-8");
		                }

		                List<String> values = params.get(key);
		                if (values == null) {
		                    values = new ArrayList<String>();
		                    params.put(key, values);
		                }
		                values.add(value);
		            }
		        }

		        return params;
		    } catch (UnsupportedEncodingException ex) {
		        throw new AssertionError(ex);
		    }
		}
		
		public ClientHttpResponse intercept(final HttpRequest request, final byte[] body, ClientHttpRequestExecution execution) throws IOException {
			HttpRequest protectedResourceRequest = new HttpRequestDecorator(request) {
				@Override
				public URI getURI() {
					Map<String, List<String>> queryParams = OAuth2TokenParameterRequestInterceptor.getQueryParams(super.getURI().toString());
					if (!queryParams.containsKey("access_token"))
						return URI.create(super.getURI().toString() + (((super.getURI().getQuery() == null) ? "?" : "&") + "access_token=" + accessToken));
					else 
						return super.getURI();
				}
			};

			// LinkedIn doesn't accept the OAuth2 Bearer token authorization header.
			protectedResourceRequest.getHeaders().remove("Authorization"); 
			return execution.execute(protectedResourceRequest, body);
		}

	}
	
	
	
	private void registerOAuth2Interceptor(String accessToken) {
		List<ClientHttpRequestInterceptor> interceptors = getRestTemplate().getInterceptors();
		interceptors.add(new OAuth2TokenParameterRequestInterceptor(accessToken));
		getRestTemplate().setInterceptors(interceptors);
	}
	
	/**
	 * Create a new instance of FacebookTemplate.
	 * This constructor creates the FacebookTemplate using a given access token.
	 * @param accessToken An access token given by Facebook after a successful OAuth 2 authentication (or through Facebook's JS library).
	 */
	public FacebookTemplate(String accessToken) {
		
		this(accessToken, null);
		
	}

	public FacebookTemplate(String accessToken, String applicationNamespace) {
		
		this(accessToken, applicationNamespace, null);
		
//		registerOAuth2Interceptor(accessToken);
	}
	
	public FacebookTemplate(String accessToken, String applicationNamespace, String appId) {
		super(accessToken);
		this.applicationNamespace = applicationNamespace;
		this.appId = appId;
		this.accessToken = accessToken;
		initialize();
		registerOAuth2Interceptor(accessToken);
	}
	
	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}
	public URIBuilder withAccessToken(String uri) {
		return  URIBuilder.fromUri(uri).queryParam("access_token", accessToken);
	}
	
	/**
	 * Set the Graph API version (e.g., "2.5"). If set to null, the version will be left out of the request URLs to the
	 * Graph API.
	 * @param apiVersion the API version. Default is "2.5".
	 */
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	 
	
	public TestOperations testOperations() {
		return testOperations;
	}
	
	
	 
	public RestOperations restOperations() {
		return getRestTemplate();
	}
	
	 
	public OrderOperations orderOperations() {
		return orderOperations;
	}
	
	// low-level Graph API operations
	public <T> T fetchObject(String objectId, Class<T> type) {
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId).build();
		return getRestTemplate().getForObject(uri, type);
	}

	public <T> T fetchObject(String objectId, Class<T> type, String... fields) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		if(fields.length > 0) {
			String joinedFields = join(fields);
			queryParameters.set("fields", joinedFields);
		}		
		return fetchObject(objectId, type, queryParameters);
	}

	public <T> T fetchObject(String objectId, Class<T> type, MultiValueMap<String, String> queryParameters) {
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId).queryParams(queryParameters).build();
		return getRestTemplate().getForObject(uri, type);
	}

	
	
	public <T> PagedList<T> fetchConnections(String objectId, String connectionType, Class<T> type, String... fields) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		if(fields.length > 0) {
			String joinedFields = join(fields);
			queryParameters.set("fields", joinedFields);
		}		
		return fetchConnections(objectId, connectionType, type, queryParameters);
	}

	public <T> PagedList<T> fetchConnections(String objectId, String connectionType, Class<T> type, MultiValueMap<String, String> queryParameters) {
		String connectionPath = connectionType != null && connectionType.length() > 0 ? "/" + connectionType : "";
		URIBuilder uriBuilder = URIBuilder.fromUri(getBaseGraphApiUrl() +  (StringUtils.hasText(objectId) ? "/":"") + connectionPath).queryParams(queryParameters);
		JsonNode jsonNode = getRestTemplate().getForObject(uriBuilder.build(), JsonNode.class);
		return pagify(type, jsonNode);
		
	}

	public <T> PagedList<T> fetchPagedConnections(String objectId, String connectionType, Class<T> type, MultiValueMap<String, String> queryParameters) {
		String connectionPath = connectionType != null && connectionType.length() > 0 ? "/" + connectionType : "";
		URIBuilder uriBuilder = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + connectionPath).queryParams(queryParameters);
		JsonNode jsonNode = getRestTemplate().getForObject(uriBuilder.build(), JsonNode.class);
		return pagify(type, jsonNode);
	}

	public <T> PagedList<T> fetchConnections(String objectId, String connectionType, Class<T> type, MultiValueMap<String, String> queryParameters, String... fields) {
		if(fields.length > 0) {
			String joinedFields = join(fields);
			queryParameters.set("fields", joinedFields);
		}
		return fetchPagedConnections(objectId, connectionType, type, queryParameters);
	}

	/**
	 * Fetches the next {@link org.springframework.social.facebook.api.PagedList PagedList} of the current one.
	 * @param page source {@link org.springframework.social.facebook.api.PagedList PagedList} to fetch the next one.
	 * @param type type of the source {@link org.springframework.social.facebook.api.PagedList PagedList} and the next one.
	 * @param <T> the type of the source
	 * @return the next {@link org.springframework.social.facebook.api.PagedList PagedList} of the given one.
	 * It returns <code>null</code> if the next {@link org.springframework.social.facebook.api.PagedList PagedList} doesn't exist.
	 */
	public <T> PagedList<T> fetchNextPagedConnections(PagedList<T> page, Class<T> type) {
		if (null != page && null != page.getNextPage() && !"".equals(page.getNextPage().getFullUrl().trim())) {
			URIBuilder uriBuilder = URIBuilder.fromUri(page.getNextPage().getFullUrl());
			JsonNode jsonNode = getRestTemplate().getForObject(uriBuilder.build(), JsonNode.class);
			return pagify(type, jsonNode);
		}
		return null;
	}

	/**
	 * Fetchs the previous {@link org.springframework.social.facebook.api.PagedList PagedList} of the current one.
	 * @param page source {@link org.springframework.social.facebook.api.PagedList PagedList} to fetch the previous one.
	 * @param type type of the source {@link org.springframework.social.facebook.api.PagedList PagedList} and the previous one.
	 * @return the previous {@link org.springframework.social.facebook.api.PagedList PagedList} of the given one.
	 * @param <T> the type of the source
	 * It returns <code>null</code> if the previous {@link org.springframework.social.facebook.api.PagedList PagedList} doesn't exist.
	 */
	public <T> PagedList<T> fetchPreviousPagedConnections(PagedList<T> page, Class<T> type) {
		if (null != page && null != page.getPreviousPage() && !"".equals(page.getPreviousPage().getFullUrl().trim())) {
			URIBuilder uriBuilder = URIBuilder.fromUri(page.getPreviousPage().getFullUrl());
			JsonNode jsonNode = getRestTemplate().getForObject(uriBuilder.build(), JsonNode.class);
			return pagify(type, jsonNode);
		}
		return null;
	}
	
	private <T> PagedList<T> pagify(Class<T> type, JsonNode jsonNode) {
//		try{
			List<T> data = deserializeDataList(jsonNode.get("data"), type);	
		
		
		if (!jsonNode.has("paging")) {
			return new PagedList<T>(data, null, null);
		}
		
		JsonNode pagingNode = jsonNode.get("paging");
		PagingParameters previousPage = getPagedListParameters(pagingNode, "previous");
		PagingParameters nextPage = getPagedListParameters(pagingNode, "next");
		
		Integer totalCount = null;
		if (jsonNode.has("summary")) {
			JsonNode summaryNode = jsonNode.get("summary");
			if (summaryNode.has("total_count")) {
				totalCount = summaryNode.get("total_count").intValue();
			}
		}
		return new PagedList<T>(data, previousPage, nextPage, totalCount);

//		}catch(NullPointerException e){
//			return null;
//}
		
	}
	
	public String getBaseGraphApiUrl() {
		return "https://sandbox.merchant.wish.com/api/v"+apiVersion;
	}

//	public byte[] fetchImage(String objectId, String connectionType, ImageType type) {
//		return fetchImage(objectId, connectionType, type, null, null);
//	}
//
//	public byte[] fetchImage(String objectId, String connectionType, Integer width, Integer height) {
//		return fetchImage(objectId, connectionType, null, width, height);
//	}
//
//	private byte[] fetchImage(String objectId, String connectionType, ImageType type, Integer width, Integer height) {
//		URIBuilder uriBuilder = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + "/" + connectionType);
//		if (type != null) {
//		  uriBuilder.queryParam("type", type.toString().toLowerCase());
//		}
//		if (width != null) {
//			uriBuilder.queryParam("width", width.toString());
//		}
//		if (height != null) {
//			uriBuilder.queryParam("height", height.toString());
//		}
//		URI uri = uriBuilder.build();
//		ResponseEntity<byte[]> response = getRestTemplate().getForEntity(uri, byte[].class);
//		if(response.getStatusCode() == HttpStatus.FOUND) {
//			throw new UnsupportedOperationException("Attempt to fetch image resulted in a redirect which could not be followed. Add Apache HttpComponents HttpClient to the classpath " +
//					"to be able to follow redirects.");
//		}
//		return response.getBody();
//	}
	
	@SuppressWarnings("unchecked")
	public String publish(String objectId, String connectionType, MultiValueMap<String, Object> data) {
		MultiValueMap<String, Object> requestData = new LinkedMultiValueMap<String, Object>(data);
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + "/" + connectionType).build();
		Map<String, Object> response = getRestTemplate().postForObject(uri, requestData, Map.class);
		return (String) response.get("id");
	}
	
	public void post(String objectId, MultiValueMap<String, Object> data) {
		post(objectId, null, data);
	}
	
	public void post(String objectId, String connectionType, MultiValueMap<String, Object> data) {
		String connectionPath = connectionType != null ? "/" + connectionType : "";
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + connectionPath).build();
		getRestTemplate().postForObject(uri, new LinkedMultiValueMap<String, Object>(data), String.class);
	}
	
	public void delete(String objectId) {
		LinkedMultiValueMap<String, String> deleteRequest = new LinkedMultiValueMap<String, String>();
		deleteRequest.set("method", "delete");
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId).build();
		getRestTemplate().postForObject(uri, deleteRequest, String.class);
	}
	
	public void delete(String objectId, String connectionType) {
		LinkedMultiValueMap<String, String> deleteRequest = new LinkedMultiValueMap<String, String>();
		deleteRequest.set("method", "delete");
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + "/" + connectionType).build();
		getRestTemplate().postForObject(uri, deleteRequest, String.class);
	}
	
	public void delete(String objectId, String connectionType, MultiValueMap<String, String> data) {
		data.set("method", "delete");
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + "/" + connectionType).build();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(data, new HttpHeaders());
		getRestTemplate().exchange(uri, HttpMethod.POST, entity, String.class);
	}
	
	// AbstractOAuth2ApiBinding hooks
	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.DRAFT_10;
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new FacebookErrorHandler());
	}

	@Override
	protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
		objectMapper = Jackson2ObjectMapperBuilder.json().build();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
//		converter.setSupportedMediaTypes(Collections.singletonList(MediaTypes.HAL_JSON));
////		converter.setObjectMapper(objectMapper);
//		objectMapper = Jackson2ObjectMapperBuilder.json().build();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.registerModule(new FacebookModule());
		objectMapper.registerModule(new FacebookResolveDataModule());	
		return converter;
	}
	
	// private helpers
	private void initialize() {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();
	}
		
	private void initSubApis() {
	 
		testOperations = new TestTemplate(this, getRestTemplate(), appId);
		orderOperations = new OrderTemplate(this);
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> deserializeDataList(JsonNode jsonNode, final Class<T> elementType) {
		try {
			CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, elementType);
			return (List<T>) objectMapper.reader(listType).readValue(jsonNode.toString()); // TODO: EXTREMELY HACKY--TEMPORARY UNTIL I FIGURE OUT HOW JACKSON 2 DOES THIS
		} catch (IOException e) {
			throw new UncategorizedApiException("facebook", "Error deserializing data from Facebook: " + e.getMessage(), e);
		}
	}
	
	private String join(String[] strings) {
		StringBuilder builder = new StringBuilder();
		if(strings.length > 0) {
			builder.append(strings[0]);
			for (int i = 1; i < strings.length; i++) {
				builder.append("," + strings[i]);
			}
		}
		return builder.toString();
	}

 
 


}
