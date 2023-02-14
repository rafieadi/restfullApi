package com.restapi.Friends.response;

import java.util.List;

import com.restapi.Friends.request.FriendListRequest;

public class FriendListResponse {
    private List<FriendListRequest> friends;

    public FriendListResponse(List<FriendListRequest> friends) {
        this.friends = friends;
    }

    public List<FriendListRequest> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendListRequest> friends) {
        this.friends = friends;
    }
}


