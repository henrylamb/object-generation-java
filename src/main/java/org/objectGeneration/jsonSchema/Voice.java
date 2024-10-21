package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Voice {
    public enum VoiceEnum {
        Alloy, Echo, Fable, Onyx, Nova, Shimmer
    }

    private VoiceEnum voice;

    // Getters and Setters
}

