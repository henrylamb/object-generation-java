package org.objectGeneration.client;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface RequestSender {
    /**
     * Sends an HTTP request with a body to the specified URL using the provided token for authorization.
     *
     * @param url         The full URL to which the request is sent.
     * @param token       The authorization token to be used in the request headers.
     * @param requestBody The body of the request.
     * @return The HTTP response as a String.
     * @throws IOException          If an input or output exception occurs.
     * @throws InterruptedException If the request is interrupted.
     */
    HttpResponse<String> sendRequestBody(String url, String token, RequestBody requestBody) throws IOException, InterruptedException;
}
