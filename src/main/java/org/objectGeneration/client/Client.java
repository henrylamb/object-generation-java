package org.objectGeneration.client;


import org.objectGeneration.jsonSchema.Definition;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Client {
    private String password;
    private String baseUrl;
    private HttpClient httpClient;
    private RequestSender requestSender;
    private ResponseProcessor responseProcessor;

    // Constructor
    public Client(String password, String baseUrl, HttpClient httpClient,
                  RequestSender requestSender, ResponseProcessor responseProcessor) {
        this.password = password;
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
        this.requestSender = requestSender;
        this.responseProcessor = responseProcessor;
    }

    // Equivalent of NewDefaultClient
    public static Client newDefaultClient(String password, String url) {
        return new Client(
                password,
                url,
                HttpClient.newHttpClient(),
                new DefaultRequestSender(),
                new ResponseProcessor()
        );
    }

    // SendRequest method
    public Response sendRequest(String prompt, Definition definition) throws IOException, InterruptedException {
        RequestBody requestBody = new RequestBody(prompt, definition);
        System.out.println("Sending request: " + requestBody);
        // Use the RequestSender to send the request
        HttpResponse<String> resp = requestSender.sendRequestBody(baseUrl, password, requestBody);

        // Process the response
        return responseProcessor.processResponse(resp);
    }

}
