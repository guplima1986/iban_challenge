package com.iban.notification.event;

import com.iban.core.model.Constants;
import com.iban.core.model.dto.SubscriptionDto;
import com.iban.notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class SubscriptionConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = Constants.QUEUE)
    public void consumerMessageFromQueue(@Payload SubscriptionDto event) {
        emailService.createCampaignMessage(event);
    }

}
