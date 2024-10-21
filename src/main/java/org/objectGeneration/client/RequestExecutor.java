package org.objectGeneration.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.objectGeneration.jsonSchema.Definition;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class RequestExecutor {

    public HttpResponse<String> executeRequest(Map<String, Object> currentGen, Definition def) throws IOException, InterruptedException {
        // Merge currentGen into the existing body
        if (def.getReq().getBody() == null) {
            def.getReq().setBody(currentGen);
        } else {
            def.getReq().getBody().putAll(currentGen);
        }

        // Marshal the body to JSON
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(def.getReq().getBody());

        // Build the HTTP request
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(def.getReq().getUrl()))
                .timeout(java.time.Duration.ofSeconds(10));

        // Set headers
        if (def.getReq().getHeaders() != null) {
            def.getReq().getHeaders().forEach(requestBuilder::header);
        }

        // Set authorization
        if (def.getReq().getAuthorization() != null) {
            requestBuilder.header("Authorization", def.getReq().getAuthorization());
        }

        // Set HTTP method and body
        String method = def.getReq().getMethod().toUpperCase();
        switch (method) {
            case "GET":
                requestBuilder.GET();
                break;
            case "POST":
                requestBuilder.POST(HttpRequest.BodyPublishers.ofString(body));
                break;
            case "PUT":
                requestBuilder.PUT(HttpRequest.BodyPublishers.ofString(body));
                break;
            case "DELETE":
                requestBuilder.DELETE();
                break;
            default:
                requestBuilder.method(method, HttpRequest.BodyPublishers.ofString(body));
                break;
        }

        // Execute the request
        HttpClient client = HttpClient.newHttpClient();
        return client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());
    }
}
