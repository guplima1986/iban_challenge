package com.iban.subscription.endpoint.controller;

import com.iban.core.model.Subscription;
import com.iban.subscription.endpoint.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("subscriptions")
@RestController
public class SubscriptionController {

    private final SubscriptionService subscriptionService;


    @PostMapping
    public ResponseEntity<String> createSubscription(@RequestBody Subscription subscription){
        return ResponseEntity.ok(subscriptionService.createSubscription(subscription));
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> getAll(){
        return ResponseEntity.ok(subscriptionService.getAll());
    }

}
