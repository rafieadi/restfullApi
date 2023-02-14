package com.restapi.Friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.Friends.request.FriendListRequest;
import com.restapi.Friends.request.FriendRequest;
import com.restapi.Friends.request.FriendRequestRequest;
import com.restapi.Friends.response.FriendListResponse;
import com.restapi.Friends.response.FriendRequestListResponse;
import com.restapi.Friends.response.FriendRequestResponse;
import com.restapi.Friends.service.FriendRequestService;

@RestController
@RequestMapping("/friend-request")
public class FriendRequestController {
	@Autowired
    private FriendRequestService friendRequestService;

    public FriendRequestController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }
    
    @GetMapping("/listFriendReq")
    public FriendRequestListResponse listFriendRequests(@RequestBody FriendRequestRequest request) {
        List<FriendRequest> friendRequests = friendRequestService.listFriendRequests(request);
        return new FriendRequestListResponse(friendRequests);
    }
    
    @GetMapping("/listFriends")
    public FriendListResponse listFriends(@RequestBody FriendRequestRequest request) {
        List<FriendListRequest> friends = friendRequestService.listFriends(request);
        return new FriendListResponse(friends);
    }

    @PostMapping("/create")
    public FriendRequestResponse createFriendRequest(@RequestBody FriendRequestRequest request) {
        return friendRequestService.createFriendRequest(request);
    }
    
    @PostMapping("/accept")
    public FriendRequestResponse acceptFriendRequest(@RequestBody FriendRequestRequest request) {
        return friendRequestService.acceptFriendRequest(request);
    }
    
    @PostMapping("/reject")
    public FriendRequestResponse rejectFriendRequest(@RequestBody FriendRequestRequest request) {
        return friendRequestService.rejectFriendRequest(request);
    }
    
    
}

