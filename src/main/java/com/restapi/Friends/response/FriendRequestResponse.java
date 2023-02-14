package com.restapi.Friends.response;

public class FriendRequestResponse {
    private boolean success;

    public FriendRequestResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

