package org.objectGeneration.client;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class DefaultRequestSender implements RequestSender {

    private HttpClient client;

    public DefaultRequestSender() {
        this.client = HttpClient.newHttpClient();
    }

    @Override
    public HttpResponse<String> sendRequestBody(String baseURL, String token, RequestBody requestBody) throws IOException, InterruptedException {
        String url = baseURL + "/api/objectGen";

        // Serialize the request body to JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(requestBody);

        // Create an HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();

        // Send the request and return the response
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
