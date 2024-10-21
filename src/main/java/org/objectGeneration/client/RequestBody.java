package org.objectGeneration.client;

import org.objectGeneration.jsonSchema.Definition;

public class RequestBody {
    private String prompt;
    private Definition definition;

    public RequestBody(String prompt, Definition definition) {
        this.prompt = prompt;
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "prompt='" + prompt + '\'' +
                ", definition=" + definition +
                '}';
    }

    // Getters and setters
    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }
}
