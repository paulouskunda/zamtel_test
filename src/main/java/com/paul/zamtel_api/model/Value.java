package com.paul.zamtel_api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private Long statusCode;
    private String message;

    public Value() {
    }

    public Long getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Value{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                '}';
    }
}