package com.app.subscription.dtos;

import com.app.subscription.entities.Subscription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.KebabCaseStrategy.class)
@Data
public class SubscriptionResponse {
	private String id;
    private String name;
    private String email;
    private UserType userType;
    private String company;
    private ApplicationType applicationType;
    
    public SubscriptionResponse(Subscription subscription) {
    	this.id = subscription.getId();
    	this.name = subscription.getName();
    	this.email = subscription.getEmail();
    	this.userType = subscription.getUserType();
    	this.company = subscription.getCompany();
    	this.applicationType = subscription.getApplicationType();
    }
}
