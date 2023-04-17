package com.app.subscription.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.subscription.entities.Subscription;

import java.util.List;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, String> {
    List<Subscription> findAll();
}
