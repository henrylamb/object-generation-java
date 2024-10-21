package org.objectGeneration.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.objectGeneration.jsonSchema.Definition;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Map;

public class RequestSenderUtil {

    public Res sendRequest(Definition def, Map<String, Object> currentGen) {
        RequestExecutor executor = new RequestExecutor();

        try {
            HttpResponse<String> response = executor.executeRequest(currentGen, def);
            return extractValue(response);
        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to execute request: " + e.getMessage());
            return null;
        }
    }

    private Res extractValue(HttpResponse<String> response) throws IOException {
        if (response.statusCode() != 200) {
            throw new IOException("Request failed with status: " + response.statusCode());
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Res.class);
    }
}
