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

import org.springframework.social.facebook.api.Account;
import org.springframework.social.facebook.api.Achievement;
import org.springframework.social.facebook.api.AchievementType;
import org.springframework.social.facebook.api.Action;
import org.springframework.social.facebook.api.Album;
import org.springframework.social.facebook.api.ApplicationReference;
import org.springframework.social.facebook.api.Comment;
import org.springframework.social.facebook.api.CoverPhoto;
import org.springframework.social.facebook.api.Currency;
import org.springframework.social.facebook.api.Device;
import org.springframework.social.facebook.api.EducationExperience;
import org.springframework.social.facebook.api.Engagement;
import org.springframework.social.facebook.api.Event;
import org.springframework.social.facebook.api.EventInvitee;
import org.springframework.social.facebook.api.Experience;
import org.springframework.social.facebook.api.FamilyMember;
import org.springframework.social.facebook.api.FriendList;
import org.springframework.social.facebook.api.Group;
import org.springframework.social.facebook.api.GroupMemberReference;
import org.springframework.social.facebook.api.GroupMembership;
import org.springframework.social.facebook.api.ImageSource;
import org.springframework.social.facebook.api.Invitation;
import org.springframework.social.facebook.api.Location;
import org.springframework.social.facebook.api.MailingAddress;
import org.springframework.social.facebook.api.MessageTag;
import org.springframework.social.facebook.api.Order;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.PageParking;
import org.springframework.social.facebook.api.PagePaymentOptions;
import org.springframework.social.facebook.api.PageRestaurantServices;
import org.springframework.social.facebook.api.PageRestaurantSpecialties;
import org.springframework.social.facebook.api.PaymentPricePoint;
import org.springframework.social.facebook.api.PaymentPricePoints;
import org.springframework.social.facebook.api.Photo;
import org.springframework.social.facebook.api.Photo.Image;
import org.springframework.social.facebook.api.Place;
import org.springframework.social.facebook.api.PlaceTag;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.PostProperty;
import org.springframework.social.facebook.api.ProfilePictureSource;
import org.springframework.social.facebook.api.Reference;
import org.springframework.social.facebook.api.RestaurantServices;
import org.springframework.social.facebook.api.SecuritySettings;
import org.springframework.social.facebook.api.StoryAttachment;
import org.springframework.social.facebook.api.Tag;
import org.springframework.social.facebook.api.TestUser;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.UserIdForApp;
import org.springframework.social.facebook.api.UserInvitableFriend;
import org.springframework.social.facebook.api.UserTaggableFriend;
import org.springframework.social.facebook.api.Video;
import org.springframework.social.facebook.api.Video.VideoFormat;
import org.springframework.social.facebook.api.VideoUploadLimits;
import org.springframework.social.facebook.api.VoipInfo;
import org.springframework.social.facebook.api.WorkEntry;
import org.springframework.social.facebook.api.WorkEntry.Project;
import org.springframework.social.facebook.api.impl.json.PhotoMixin.ImageMixin;
import org.springframework.social.facebook.api.impl.json.VideoMixin.VideoFormatMixin;
import org.springframework.social.facebook.api.impl.json.WorkEntryMixin.ProjectMixin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Jackson module for setting up mixin annotations on Facebook model types. This enables the use of Jackson annotations without
 * directly annotating the model classes themselves.
 * @author Craig Walls
 */
public class FacebookResolveDataModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public FacebookResolveDataModule() {
		super("FacebookResolveDataModule");
	}
	
	
	@Override
	public void setupModule(SetupContext context) {
		String[] path = {"Order"}; 
		context.addBeanDeserializerModifier(new DeserializerModifier((ObjectMapper) context.getOwner(), path));
		 
	}
}
