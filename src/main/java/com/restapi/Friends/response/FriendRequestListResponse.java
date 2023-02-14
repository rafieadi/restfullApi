package com.restapi.Friends.response;

import java.util.List;

import com.restapi.Friends.request.FriendRequest;

public class FriendRequestListResponse {
    private List<FriendRequest> requests;

    public FriendRequestListResponse(List<FriendRequest> requests) {
        this.requests = requests;
    }

    public List<FriendRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<FriendRequest> requests) {
        this.requests = requests;
    }
}

