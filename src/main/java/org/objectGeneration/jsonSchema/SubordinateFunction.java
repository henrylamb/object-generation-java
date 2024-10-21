package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubordinateFunction {
    private String name;
    private Definition definition;

    // Getters and Setters
}
