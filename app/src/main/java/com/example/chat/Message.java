package com.example.chat;

import java.util.Date;

public class Message {
    private String message;
    private boolean fromCurrentUser;
    private Date dateTime=new Date();

    public Message(String message, boolean fromCurrentUser) {
        this.message = message;
        this.fromCurrentUser = fromCurrentUser;
    }

    public Message(String message, boolean fromCurrentUser, Date dateTime) {
        this.message = message;
        this.fromCurrentUser = fromCurrentUser;
        this.dateTime = dateTime;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }

    public boolean isFromCurrentUser() {
        return fromCurrentUser;
    }
}
