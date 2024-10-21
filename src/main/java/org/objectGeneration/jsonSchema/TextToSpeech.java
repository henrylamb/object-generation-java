package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TextToSpeech {
    public enum TextToSpeechModel {
        @JsonProperty("tts")
        OpenAiTTS
    }

    private TextToSpeechModel model;
    private String stringToAudio;
    private Voice voice;
    private AudioFormat format;

    // Getters and Setters
}
