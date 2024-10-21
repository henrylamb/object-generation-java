package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AudioFormat {
    public enum AudioFormatEnum {
        Text, SRT, VTT, JSON, VerboseJSON
    }

    private AudioFormatEnum format;

    // Getters and Setters
}
