package org.springframework.social.wish.api;


public class TagDeserializer extends WrapDeserializer<Tag>   {
	
	TagDeserializer(){
		super();
		this.setClassType(Tag.class);
	}

}
