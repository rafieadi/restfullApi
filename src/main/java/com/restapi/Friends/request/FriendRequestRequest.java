package com.restapi.Friends.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restapi.Friends.service.FriendRequestService.FriendRequestStatus;

public class FriendRequestRequest {
	
	@JsonProperty("requestor")
    private String requestor;
    
    @JsonProperty("to")
    private String to;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("status")
    private FriendRequestStatus status;

    public void FriendRequest(String requestor, FriendRequestStatus status) {
        this.requestor = requestor;
        this.status = status;
    }
    
    public void FriendListRequest(String to) {
        this.to = to;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

	public FriendRequestStatus getStatus() {
		return status;
	}

	public void setStatus(FriendRequestStatus status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}

