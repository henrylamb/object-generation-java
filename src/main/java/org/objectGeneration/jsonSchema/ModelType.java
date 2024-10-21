package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ModelType {
    public static final String GPT3 = "Gpt3";
    public static final String GPT4 = "Gpt4";
    public static final String CLAUDE_SONNET = "ClaudeSonnet";
    public static final String CLAUDE_HAIKU = "ClaudeHaiku";
    public static final String LLAMA_70B = "Llama70b";
    public static final String GPT4_MINI = "Gpt4Mini";
    public static final String LLAMA_405B = "Llama405b";
    public static final String LLAMA_8B = "Llama8b";
    public static final String O1 = "o1-preview";
    public static final String O1_MINI = "o1-mini";
    public static final String GEMINI_FLASH = "GeminiFlash";
    public static final String GEMINI_PRO = "GeminiPro";
    public static final String LLAMA_8B_INSTANT = "Llama8bInstant";
    public static final String LLAMA_70B_VERSATILE = "Llama70bVersatile";
    public static final String LLAMA_1B = "Llama1B";
    public static final String LLAMA_3B = "Llama3B";
    public static final String DEFAULT = "Default";

    private String model;

    // Getters and Setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

