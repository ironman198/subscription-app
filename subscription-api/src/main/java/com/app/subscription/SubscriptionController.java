package com.app.subscription;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.subscription.dtos.SubscriptionRequest;
import com.app.subscription.dtos.SubscriptionResponse;
import com.app.subscription.entities.Subscription;


@RestController
@CrossOrigin
@Validated
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscription")
    public ResponseEntity<SubscriptionResponse> addSubscription(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionService.saveSubscription(subscriptionRequest.toSubscription());
        return new ResponseEntity<>(new SubscriptionResponse(subscription), HttpStatus.OK);
    }

    @PutMapping("/subscription/{id}")
    public ResponseEntity<SubscriptionResponse> updateSubscription(@PathVariable String id, @Valid @RequestBody SubscriptionRequest updateRequest) {
        SubscriptionResponse event = subscriptionService.getSubscription(id)
                .map(existingSubscription -> update(existingSubscription, updateRequest))
                .map(subscriptionService::saveSubscription)
                .map(SubscriptionResponse::new)
                .orElseThrow();
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    private Subscription update(Subscription subscription, SubscriptionRequest updateRequest) {
    	subscription.setName(updateRequest.getName());
    	subscription.setEmail(updateRequest.getEmail());
    	subscription.setUserType(updateRequest.getUserType());
    	subscription.setCompany(updateRequest.getCompany());
    	subscription.setApplicationType(updateRequest.getApplicationType());
    	
        return subscription;
    }

    @GetMapping("/subscription")
    public ResponseEntity<List<SubscriptionResponse>> getSubscriptions() {
        List<SubscriptionResponse> response = subscriptionService.getAllSubscriptions()
                .stream()
                .map(SubscriptionResponse::new)
                .collect(toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/subscription/{id}")
    public ResponseEntity<SubscriptionResponse> getSubscription(@PathVariable String id) {
        SubscriptionResponse event = subscriptionService.getSubscription(id)
                .map(SubscriptionResponse::new)
                .orElseThrow();
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
}
