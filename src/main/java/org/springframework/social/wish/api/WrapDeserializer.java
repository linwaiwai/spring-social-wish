package org.springframework.social.wish.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.social.wish.api.impl.json.WishModule;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeType;
public class WrapDeserializer<T> extends JsonDeserializer<T>   {

	private Class<?> classType;
	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new WishModule());
		
		jp.setCodec(mapper);
		if (jp.hasCurrentToken()) {
			JsonNode dataNode = jp.readValueAs(JsonNode.class);
			 mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE); 
			 mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
			if (dataNode != null) {
				if(dataNode.getNodeType().equals(JsonNodeType.OBJECT)) { 
					return mapper.readerFor(classType).readValue(dataNode);
				} else if (dataNode.getNodeType().equals(JsonNodeType.ARRAY)) { 
					List<T> tagList = new ArrayList<T>();
					for (JsonNode objNode : dataNode)  
			        {  
						tagList.add((T) mapper.readerFor(classType).readValue(objNode));
			        }  
				 
					return (T) tagList; 
				}
			} 
		}
		
		return null;
	}
	public Class<?> getClassType() {
		return classType;
	}
	public void setClassType(Class<?> classType) {
		this.classType = classType;
	}

}
