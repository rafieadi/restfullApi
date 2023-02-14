package com.restapi.Friends.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.Friends.entity.FriendRequestEntity;
import com.restapi.Friends.service.FriendRequestService.FriendRequestStatus;

public interface FriendRequestRepository extends JpaRepository<FriendRequestEntity, Long> {
    Optional<FriendRequestEntity> findByRequestorAndTo(String requestor, String to);
    List<FriendRequestEntity> findByTo(String email);
    List<FriendRequestEntity> findByRequestor(String email);
}

