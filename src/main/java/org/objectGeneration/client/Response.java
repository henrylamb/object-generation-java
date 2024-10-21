package org.objectGeneration.client;

import java.util.Map;

public class Response {
    private Map<String, Object> data; // This data can then be marshalled into the appropriate object type.
    private double usdCost;

    // Getters and setters
    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public double getUsdCost() {
        return usdCost;
    }

    public void setUsdCost(double usdCost) {
        this.usdCost = usdCost;
    }
}
