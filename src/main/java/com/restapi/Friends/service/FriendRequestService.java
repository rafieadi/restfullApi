package com.restapi.Friends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.restapi.Friends.entity.FriendRequestEntity;
import com.restapi.Friends.repository.FriendRequestRepository;
import com.restapi.Friends.request.FriendListRequest;
import com.restapi.Friends.request.FriendRequest;
import com.restapi.Friends.request.FriendRequestRequest;
import com.restapi.Friends.response.FriendRequestListResponse;
import com.restapi.Friends.response.FriendRequestResponse;



@Service
public class FriendRequestService {
    
    @Autowired
    private FriendRequestRepository friendRequestRepository;
    
    public enum FriendRequestStatus {
        pending,
        accepted,
        rejected
    }
    
    private Map<String, List<String>> friends = new HashMap<>();

    public FriendRequestService(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }
    
    public List<FriendRequest> listFriendRequests(FriendRequestRequest request) {
        List<FriendRequestEntity> friendRequests = friendRequestRepository.findByTo(request.getEmail().toString());
        List<FriendRequest> requests = new ArrayList<>();
        for (FriendRequestEntity friendRequest : friendRequests) {
            requests.add(new FriendRequest(friendRequest.getRequestor(), friendRequest.getStatus().toLowerCase()));
        }
        return requests;
    }
    
    public List<FriendListRequest> listFriends(FriendRequestRequest request) {
    	List<FriendRequestEntity> emailFriends = friendRequestRepository.findByRequestor(request.getEmail().toString());
        List<FriendListRequest> friendList = new ArrayList<>();
        for (FriendRequestEntity friend : emailFriends) {
             friendList.add(new FriendListRequest(friend.getTo()));
        }
        return friendList;
    }



    public FriendRequestResponse createFriendRequest(FriendRequestRequest request) {
        FriendRequestEntity friendRequest = new FriendRequestEntity();
        friendRequest.setRequestor(request.getRequestor());
        friendRequest.setTo(request.getTo());
        friendRequest.setStatus(FriendRequestStatus.pending.toString());

        friendRequest = friendRequestRepository.save(friendRequest);

        return new FriendRequestResponse(true);
    }
    
    public FriendRequestResponse acceptFriendRequest(FriendRequestRequest request) {
        Optional<FriendRequestEntity> friendRequest = friendRequestRepository.findByRequestorAndTo(request.getRequestor(), request.getTo());
        if (friendRequest.isPresent()) {
            FriendRequestEntity friendRequestEntity = friendRequest.get();
            friendRequestEntity.setStatus(FriendRequestStatus.accepted.toString());
            friendRequestRepository.save(friendRequestEntity);
            return new FriendRequestResponse(true);
        } else {
            return new FriendRequestResponse(false);
        }
    }
    
    public FriendRequestResponse rejectFriendRequest(FriendRequestRequest request) {
        Optional<FriendRequestEntity> friendRequest = friendRequestRepository.findByRequestorAndTo(request.getRequestor(), request.getTo());
        if (friendRequest.isPresent()) {
            FriendRequestEntity friendRequestEntity = friendRequest.get();
            friendRequestEntity.setStatus(FriendRequestStatus.rejected.toString());
            friendRequestRepository.save(friendRequestEntity);
            return new FriendRequestResponse(true);
        } else {
            return new FriendRequestResponse(false);
        }
    }
    
}
