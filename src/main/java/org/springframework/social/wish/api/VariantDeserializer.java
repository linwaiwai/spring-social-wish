package org.springframework.social.wish.api;

public class VariantDeserializer extends WrapDeserializer<Object>   {
 
	VariantDeserializer(){
		super();
		this.setClassType(Variant.class);
	}
}
