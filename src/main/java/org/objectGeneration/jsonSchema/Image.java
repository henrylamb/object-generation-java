package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
    public enum ImageModel {
        @JsonProperty("OpenAiDalle2")
        OpenAiDalle2,
        @JsonProperty("OpenAiDalle3")
        OpenAiDalle3
    }

    public enum ImageSize {
        @JsonProperty("256x256")
        CreateImageSize256x256,
        @JsonProperty("512x512")
        CreateImageSize512x512,
        @JsonProperty("1024x1024")
        CreateImageSize1024x1024,
        @JsonProperty("1792x1024")
        CreateImageSize1792x1024,
        @JsonProperty("1024x1792")
        CreateImageSize1024x1792
    }

    private ImageModel model;
    private ImageSize size;

    // Getters and Setters
}
