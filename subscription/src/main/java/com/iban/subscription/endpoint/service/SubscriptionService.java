package com.iban.subscription.endpoint.service;

import com.iban.core.model.Subscription;
import com.iban.core.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ApplicationEventPublisher publisher;

    public String createSubscription(Subscription subscription) {
        Subscription save = subscriptionRepository.save(subscription);
        publisher.publishEvent(save);
        return "Subscription successful";
    }

    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }
}
