package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DataType {
    public static final String OBJECT = "object";
    public static final String NUMBER = "number";
    public static final String INTEGER = "integer";
    public static final String STRING = "string";
    public static final String ARRAY = "array";
    public static final String NULL = "null";
    public static final String BOOLEAN = "boolean";
    public static final String MAP = "map";
    public static final String BYTE = "byte"; // This will be used for audio and image data selection. If this is selected as "byte" then either Image or Audio must not be null. If it is, nothing will occur, and an empty byte will be returned. The same is true if both are filled.

    private String dataType;

    // Getters and Setters
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}

