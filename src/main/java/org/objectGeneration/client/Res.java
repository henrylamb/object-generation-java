package org.objectGeneration.client;

import java.util.Map;

public class Res {
    private String value;
    private Map<String, Object> other;

    // Getters and setters
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, Object> getOther() {
        return other;
    }

    public void setOther(Map<String, Object> other) {
        this.other = other;
    }
}
