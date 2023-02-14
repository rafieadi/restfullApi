package com.restapi.Friends.request;

public class FriendListRequest {
    
    private String to;

    public FriendListRequest(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
