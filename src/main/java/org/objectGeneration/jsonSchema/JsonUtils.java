package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Generic method to deserialize JSON string to any type
    public static <T> T deserialize(Map<String, Object> map, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.convertValue(map, clazz);
    }

    // Alternative method using TypeReference for complex types (like collections)
    public static <T> T deserialize(Map<String, Object> map, TypeReference<T> typeRef) throws JsonProcessingException {
        return objectMapper.convertValue(map, typeRef);
    }
}

