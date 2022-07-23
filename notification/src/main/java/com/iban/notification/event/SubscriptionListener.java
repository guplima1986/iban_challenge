package com.iban.notification.event;

import com.iban.core.model.event.SubscriptionEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class SubscriptionListener implements ApplicationListener<SubscriptionEvent> {

    @Override
    public void onApplicationEvent(SubscriptionEvent event) {
        System.out.println("CRIAR EVENTO " + event.toString());
    }
}
