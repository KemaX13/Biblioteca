
package com.example.biblioteca_back.exception;

public class SuccessResponse<T> {
    private String message;

    public SuccessResponse(String message, T data) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
