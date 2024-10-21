package org.objectGeneration.client;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;

public class ResponseProcessor {

    // ProcessResponse processes the response and returns the parsed Response object
    public Response processResponse(HttpResponse<String> response) throws IOException {
        if (response.statusCode() != 200) {
            throw new IOException("Received non-200 response code: " + response.statusCode());
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Response.class);
    }
}
