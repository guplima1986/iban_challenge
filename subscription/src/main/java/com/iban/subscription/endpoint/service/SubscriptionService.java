package com.iban.subscription.endpoint.service;

import com.iban.core.model.Constants;
import com.iban.core.model.Subscription;
import com.iban.core.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final RabbitTemplate publisher;

    public Subscription createSubscription(Subscription subscription) {
        Subscription save = subscriptionRepository.save(subscription);
        publisher.convertAndSend(Constants.QUEUE, save);
        return save;
    }

    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }
}
