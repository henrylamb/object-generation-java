package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestFormat {
    public enum HTTPMethod {
        GET, POST, PUT, DELETE, PATCH
    }

    private String url;
    private HTTPMethod method;
    private Map<String, String> headers;
    private Map<String, Object> body;
    private String authorization;
    private List<String> requireFields;

    // Getters and Setters
}
