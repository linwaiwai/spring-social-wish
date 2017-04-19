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
package org.springframework.social.wish.api.impl.json;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.social.wish.api.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Annotated mixin to add Jackson annotations to {@link User}. 
 * @author Craig Walls
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class UserMixin extends WishObjectMixin {

	@JsonProperty("id")
	String id;
	
	@JsonProperty("about")
	String about;
	
	 
	
	@JsonProperty("name")
	String name;
	
	@JsonProperty("name_format")
	String nameFormat;
	
	@JsonProperty("first_name")
	String firstName;
	
	@JsonProperty("last_name")
	String lastName;
	
 
	
	@JsonProperty("gender")
	String gender;
	
	@JsonProperty("installed")
	boolean installed;
	
	@JsonProperty("install_type")
	String installType;
	
	@JsonProperty("locale")
	Locale locale;
	
	@JsonProperty("middle_name")
	String middleName;

 
	
	@JsonProperty("email")
	String email;
	
	@JsonProperty("link")
	String link;
	
	@JsonProperty("third_party_id")
	String thirdPartyId;
	
	@JsonProperty("timezone")
	Float timezone;
	
	@JsonProperty("updated_time")
	Date updatedTime;
	
	@JsonProperty("verified")
	Boolean verified; 
	
	@JsonProperty("bio")
	String bio;
	
	@JsonProperty("birthday")
	String birthday;
 
	
	@JsonProperty("interested_in")
	List<String> interestedIn;
 

	@JsonProperty("is_verified")
	boolean isIdentityVerified;
 
	
	@JsonProperty("meeting_for")
	List<String> meetingFor;
	
 

	@JsonProperty("religion")
	String religion;

	 
	
	@JsonProperty("political")
	String political;
	
	@JsonProperty("quotes")
	String quotes;
	
	@JsonProperty("relationship_status")
	String relationshipStatus;
	
  
	
	@JsonProperty("test_group")
	int testGroup;
	
	 
	
	@JsonProperty("viewer_can_send_gift")
	boolean viewerCanSendGift;
	
	@JsonProperty("website")
	String website;
	
 
 
}
