package com.springboot.restcrud.rest;

public class StudentErrorResponse {
    private int status;
    private String messages;
    private long timestamp;

    StudentErrorResponse()
    {

    }

    public StudentErrorResponse(int status, String messages, long timestamp) {
        this.status = status;
        this.messages = messages;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
