package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendImage {
    private List<byte[]> imagesData;

    // Getters and Setters
}
