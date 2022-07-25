package com.iban.subscription.util;

import com.iban.core.model.Campaign;
import com.iban.core.model.Subscription;
import com.iban.core.model.enums.GenderEnum;
import com.iban.core.requests.SubscriptionRequestBody;

import java.time.LocalDate;

public class SubscriptionCreator {

    public static Subscription createSubscriptionToBeSaved() {
        Subscription subscription = new Subscription();
        Campaign campaign = new Campaign();
        campaign.setId(1L);

        subscription.setCampaign(campaign);
        subscription.setConsent(false);
        subscription.setEmail("gustavo@teste.com");
        subscription.setGender(GenderEnum.MALE);
        subscription.setFirstName("Gustavo");
        subscription.setDateOfBirth(LocalDate.of(1986, 06, 06));

        return subscription;
    }

    public static SubscriptionRequestBody createSubscriptionRequestBody() {
        SubscriptionRequestBody subscription = new SubscriptionRequestBody();

        subscription.setCampaign(1);
        subscription.setConsent(false);
        subscription.setEmail("gustavo@teste.com");
        subscription.setGender("MALE");
        subscription.setFirstName("Gustavo");
        subscription.setDateOfBirth(LocalDate.of(1986, 06, 06));

        return subscription;
    }

    public static Subscription createValidSubscription() {
        Subscription subscription = new Subscription();
        Campaign campaign = new Campaign();
        campaign.setId(1L);

        subscription.setCampaign(campaign);
        subscription.setConsent(false);
        subscription.setEmail("gustavo@teste.com");
        subscription.setGender(GenderEnum.MALE);
        subscription.setFirstName("Gustavo");
        subscription.setDateOfBirth(LocalDate.of(1986, 06, 06));
        subscription.setId(1L);

        return subscription;
    }

}
