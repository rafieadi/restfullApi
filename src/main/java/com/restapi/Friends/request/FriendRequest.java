package com.restapi.Friends.request;

import com.restapi.Friends.service.FriendRequestService.FriendRequestStatus;

public class FriendRequest {
    private String requestor;
    private String status;

    public FriendRequest(String requestor, String string) {
        this.requestor = requestor;
        this.status = string;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

