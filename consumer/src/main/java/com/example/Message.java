package com.example;

/**
 * Created by amarendra on 16/3/17.
 */
public class Message {

    private Long id;
    private String message;

    public Message() {
    }

    public Message(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
