package com.iban.notification.event;

import com.google.gson.Gson;
import com.iban.core.model.Constants;
import com.iban.core.model.Subscription;
import com.iban.notification.domain.EmailDetails;
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
    public void consumerMessageFromQueue(@Payload String event) {
        Subscription subscription = new Gson().fromJson(event, Subscription.class);
        createCampaignMessage(subscription);
    }

    private void createCampaignMessage(Subscription subscription){
        EmailDetails emailDetails = new EmailDetails()
                .builder()
                .recipient(subscription.getEmail())
                .subject("Campaign Subject")
                .messageBody("Campaign Message")
                .build();
        sendCampaignEmail(emailDetails);
    }
    private void sendCampaignEmail(EmailDetails email) {
        emailService.sendMail(email);
    }
}
