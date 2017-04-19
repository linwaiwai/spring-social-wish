package org.springframework.social.wish.api;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

import org.springframework.social.wish.api.impl.json.WishModule;


public class NestedDeserializer< T> extends StdDeserializer<T> implements ResolvableDeserializer {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2625144607859882817L;

	/**
     * The default {@link JsonDeserializer}, created by Jackson, that we will delegate to for deserialization of the json.
     */
    private final JsonDeserializer<?> defaultJsonDeserializer;

    /**
     * The {@link ObjectMapper} used to create tree data.
     */
    private final ObjectMapper objectMapper;

    /**
     * The json path to the data that maps to the {@link NestedCarModel} object.
     */
    private final String[] modelTraversalPath;

    /**
     * The {@link JsonFactory} used to create {@link JsonParser} instances.
     */
    private final JsonFactory jsonFactory;

	private Class<?> c;

    /**
     *
     * @param defaultJsonDeserializer
     *          The {@link JsonDeserializer} that will be used to delegate deserialization to
     * @param objectMapper2
     *          Used to create tree data
     * @param modelTraversalPath
     *          The json path to the data that maps to the {@link NestedCarModel} object.
     */
    public NestedDeserializer(JsonDeserializer<?> defaultJsonDeserializer, ObjectMapper objectMapper2, Class<?>c, String[] modelTraversalPath) {
        super(c);
        this.c = c;
        this.defaultJsonDeserializer = defaultJsonDeserializer;
        this.objectMapper = objectMapper2;
        this.modelTraversalPath = modelTraversalPath;
        this.jsonFactory = new JsonFactory();
    }

    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings({ "deprecation", "unchecked" })
	@Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        // Iterate down the json tree until we get to the content portion...the portion that maps to the NestedCarModel
        for(String nodePath : modelTraversalPath) {
            if (node.findValue(nodePath) != null)
            	node = node.findValue(nodePath);
//            if(node == null) {
//                throw new IllegalStateException("Unexpected json traversal path format!");
//            }
        }
        // Close the original parser since we don't need it anymore
//        jsonParser.close();
//
       
//		if (jp.hasCurrentToken()) {
//			JsonNode dataNode = jp.readValueAs(JsonNode.class);
//			if (dataNode != null) {
//				if(dataNode.getNodeType().equals(JsonNodeType.OBJECT)) { // OLD STYLE, SUPPORTED IN GRAPH API 2.3
//					return (Map<Integer,List<MessageTag>>) mapper.reader(new TypeReference<Map<Integer,List<MessageTag>>>() {}).readValue(dataNode);
//			
        String treeString = objectMapper.writeValueAsString(objectMapper.treeToValue(node, Object.class));
        // Create a new parser where the root of the json is the NestedCarModel portion
//        JsonParser newParser = jsonFactory.createParser(treeString);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE); 
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.registerModule(new WishModule());
//		newParser.setCodec(mapper);
		return (T) mapper.readValue(treeString, c);
        // Queue the first token for the deserialization (NOTE: this is important--you get a NullPointerException without it)
//		return   (T) mapper.readValue(c);
//		return  mapper.readerFor(c).readValue(dataNode.toString()); 
    }

    /**
     * {@inheritDoc}
     */
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        ((ResolvableDeserializer) defaultJsonDeserializer).resolve(deserializationContext);
    }
}