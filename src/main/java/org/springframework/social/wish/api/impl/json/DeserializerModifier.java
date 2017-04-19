package org.springframework.social.wish.api.impl.json;

import org.springframework.social.wish.api.NestedDeserializer;
import org.springframework.social.wish.api.Product;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

public class DeserializerModifier<T> extends BeanDeserializerModifier {
	ObjectMapper objectMapper;
	String[]  modelTraversalPath;
	Class<?> c;
	public DeserializerModifier( ObjectMapper objectMapper, Class<?> c,  String[] modelTraversalPath){
		this.objectMapper = objectMapper;
		this.modelTraversalPath = modelTraversalPath;
		this.c = c;
	}
	 /**
     * {@inheritDoc}
     */
    @Override
    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        // If the bean being deserialized is a NestedCarModel, use the customer deserializer
    	 
        if ((beanDesc.getBeanClass().equals(c))) {
			return new NestedDeserializer<T>(deserializer, objectMapper,beanDesc.getBeanClass(), modelTraversalPath);
        }

        return super.modifyDeserializer(config, beanDesc, deserializer);
    }
}
