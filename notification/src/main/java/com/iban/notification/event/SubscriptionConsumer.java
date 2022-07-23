package com.iban.notification.event;

import com.google.gson.Gson;
import com.iban.core.model.Constants;
import com.iban.core.model.Subscription;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class SubscriptionConsumer {

    @RabbitListener(queues = Constants.QUEUE)
    public void consumerMessageFromQueue(@Payload String event) {
        Subscription subscription = new Gson().fromJson(event, Subscription.class);

        System.out.println("CRIAR EVENTO " + subscription);
    }
}
