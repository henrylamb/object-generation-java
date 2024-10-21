package org.objectGeneration.client;

import java.util.HashMap;
import java.util.Map;

public class ReqFormat {
    private String method;
    private String url;
    private Map<String, Object> body;
    private Map<String, String> headers;
    private String authorization;

    // Constructor
    public ReqFormat() {
        this.headers = new HashMap<>();
        this.body = new HashMap<>();
    }

    // Getters and setters
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
}
