package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpeechToText {
    public enum SpeechToTextModel {
        @JsonProperty("OpenAiWhisper")
        OpenAiWhisper,
        @JsonProperty("GroqWhisper")
        GroqWhisper
    }

    private SpeechToTextModel model;
    private byte[] audioToTranscribe;
    private String language; // must be in the format of ISO-639-1, defaults to "en" (English)
    private AudioFormat format;
    private boolean toString;
    private boolean toCaptions;

    // Getters and Setters
}
