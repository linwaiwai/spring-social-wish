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

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;



/**
 * Model class containing a Facebook user's profile information.
 * @author Craig Walls
 */
@SuppressWarnings("serial")
public class User extends FacebookObject implements Serializable {

	private String id;

	private String about;
	
	 

	private String bio;
	
	private String birthday;
	 
	
	private String email;
	
	 
	
	private String firstName;
	
	private String gender;
 
	
	private boolean installed;
	
	private String installType;
	
	private List<String> interestedIn;

	private boolean isIdentityVerified;
 
	private String lastName;

	private String link;

	private Locale locale;

 
	
	private String middleName;
	
	private List<String> meetingFor;

	private String name;
	
	private String nameFormat;
	
 

	private String political;

	private String quotes;

	private String relationshipStatus;

	private String religion;

 
	
	private int testGroup;
	
	private String thirdPartyId;

	private Float timezone;
	
	private Date updatedTime;

	private Boolean verified;

	private boolean viewerCanSendGift;
	
	private String website;

 
	
	User() {}
	
	public User(String id, String name, String firstName, String lastName, String gender, Locale locale) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.locale = locale;
	}

	/**
	 * The user's Facebook ID
	 * @return The user's Facebook ID
	 */
	public String getId() {
		return id;
	}
	
 
	
	/**
	 * The user's full name
	 * @return The user's full name
	 */
	public String getName() {
		return name;
	}

	/**
	 * The user's first name
	 * @return The user's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	public List<String> getMeetingFor() {
		return meetingFor;
	}

	/**
	 * The user's middle name
	 * @return The user's middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * The user's last name
	 * @return The user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the name format used to correctly handle Chinese, Japanese, Korean ordering
	 */
	public String getNameFormat() {
		return nameFormat;
	}
	
	/**
	 * The user's gender
	 * @return the user's gender
	 */
	public String getGender() {
		return gender;
	}

	public List<String> getInterestedIn() {
		return interestedIn;
	}
	
	/**
	 * The user's locale
	 * @return the user's locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * The user's email address.
	 * Available only with "email" permission.
	 * @return The user's email address
	 */
	public String getEmail() {
	    return email;
    }
	
	/**
	 * A link to the user's profile on Facebook.
	 * Available only if requested by an authenticated user.
	 * @return the user's profile link or null if requested anonymously
	 */
	public String getLink() {
		return link;
	}

	/**
	 * A link to the user's personal website. Available only with "user_website" permission.
	 * 
	 * @return a link to the user's personal website.
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * An anonymous, but unique identifier for the user. Available only if
	 * requested by an authenticated user.
	 * 
	 * @return the user's third-party ID or null if not available
	 */
	public String getThirdPartyId() {
		return thirdPartyId;
	}
	
	/**
	 * The user's timezone offset from UTC.
	 * Available only for the authenticated user.
	 * @return the user's timezone offset from UTC or null if the user isn't the authenticated user
	 */
	public Float getTimezone() {
		return timezone;
	}
	
	/**
	 * The last time the user's profile was updated.
	 * @return the time that the user's profile was updated
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}
	
	/**
	 * The user's account verification status.
	 * Available only if requested by an authenticated user.
	 * @return true if the profile has been verified, false if it has not, or null if not available.
	 */
	public Boolean isVerified() {
		return verified;
	}
	
	/**
	 * The user's brief about blurb.
	 * Available only with "user_about_me" permission for the authenticated user for the authenticated user's friends.
	 * @return the user's about blurb, if available.
	 */
	public String getAbout() {
		return about;
	}

	/**
	 * The user's bio.
	 * Available only with "user_about_me" permission for the authenticated user.
	 * @return the user's bio, if available.
	 */
	public String getBio() {
		return bio;
	}
	
	/**
	 * The user's birthday.
	 * Available only with "user_birthday" permission for the authentication user permission for the user's friends.
	 * @return the user's birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	
	 
	
	public boolean isIdentityVerified() {
		return isIdentityVerified;
	}
	
 

	/**
	 * The user's religion. 
	 * Available only with "user_religion_politics" permission.
	 * @return the user's religion, if available.
	 */
	public String getReligion() {
		return religion;
	}
	 
	/**
	 * The user's political affiliation. 
	 * Available only with "user_religion_politics" permission.
	 * @return the user's political affiliation, if available.
	 */
	public String getPolitical() {
		return political;
	}

	/**
	 * The user's quotations. 
	 * Available only with "user_about_me" permission.
	 * @return the user's quotations, if available.
	 */
	public String getQuotes() {
		return quotes;
	}

	/**
	 * The user's relationship status. 
	 * Available only with "user_relationships" permission.
	 * @return the user's relationship status, if available.
	 */
	public String getRelationshipStatus() {
		return relationshipStatus;
	}

  
	
	public int getTestGroup() {
		return testGroup;
	}

	public boolean viewerCanSendGift() {
		return viewerCanSendGift;
	}
	
	   
	/**
	 * @return true if the user has the calling application installed
	 */
	public boolean isInstalled() {
		return installed;
	}
	
	public String getInstallType() {
		return installType;
	}
   
	
}
