package com.iban.subscription.endpoint.controller;

import com.iban.core.mapper.SubscriptionMapper;
import com.iban.core.model.Subscription;
import com.iban.core.requests.SubscriptionRequestBody;
import com.iban.subscription.endpoint.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("subscriptions")
@RestController
public class SubscriptionController {

    private final SubscriptionService subscriptionService;


    @PostMapping
    public ResponseEntity<SubscriptionRequestBody> createSubscription(@RequestBody SubscriptionRequestBody subscriptionRequestBody){
        Subscription subscription = SubscriptionMapper.INSTANCE.subscriptionRequestBodyToSubscription(subscriptionRequestBody);
        Subscription subscriptionSaved = subscriptionService.createSubscription(subscription);
        return new ResponseEntity<>(SubscriptionMapper.INSTANCE.subscriptionToSubscriptionRequestBody(subscriptionSaved), HttpStatus.CREATED);
    }

}
