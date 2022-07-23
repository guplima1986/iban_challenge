package com.iban.core.model.event;

import org.springframework.context.ApplicationEvent;

public class SubscriptionEvent extends ApplicationEvent {
    
    public SubscriptionEvent(Object source) {
        super(source);
    }
}
