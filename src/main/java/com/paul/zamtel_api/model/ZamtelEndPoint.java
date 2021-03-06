package com.paul.zamtel_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZamtelEndPoint {
    private String type;
    private Value value;

    public ZamtelEndPoint() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ZamtelAPI{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
