package org.springframework.social.facebook.api.impl.json;

import org.springframework.social.facebook.api.Order;
import org.springframework.social.facebook.api.OrderDeserializer;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

public class DeserializerModifier extends BeanDeserializerModifier {
	ObjectMapper objectMapper;
	String[]  modelTraversalPath;
	public DeserializerModifier( ObjectMapper objectMapper,  String[] modelTraversalPath){
		this.objectMapper = objectMapper;
		this.modelTraversalPath = modelTraversalPath;
	}
	 /**
     * {@inheritDoc}
     */
    @Override
    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        // If the bean being deserialized is a NestedCarModel, use the customer deserializer
        if (Order.class.equals(beanDesc.getBeanClass())) {
            
			
			return new OrderDeserializer(deserializer, objectMapper, modelTraversalPath);
        }

        return super.modifyDeserializer(config, beanDesc, deserializer);
    }
}
