package com.iban.subscription.endpoint.service;

import com.iban.core.mapper.SubscriptionMapper;
import com.iban.core.model.Constants;
import com.iban.core.model.Subscription;
import com.iban.core.model.dto.SubscriptionDto;
import com.iban.core.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final RabbitTemplate publisher;

    public Subscription createSubscription(Subscription subscription) {
        Subscription save = subscriptionRepository.save(subscription);
        SubscriptionDto subscriptionDto = SubscriptionMapper.INSTANCE.subscriptionToSubscriptionDto(save);
        publisher.convertAndSend(Constants.QUEUE, subscriptionDto);
        return save;
    }
}
