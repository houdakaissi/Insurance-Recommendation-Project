package com.example.demo.payload.response;

public class HelooResponse {
    private final String message;

    public HelooResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}