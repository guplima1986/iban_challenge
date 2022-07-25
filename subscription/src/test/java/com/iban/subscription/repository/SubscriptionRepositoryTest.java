package com.iban.subscription.repository;

import com.iban.core.model.Subscription;
import com.iban.core.repository.CampaingRepository;
import com.iban.core.repository.SubscriptionRepository;
import com.iban.subscription.util.SubscriptionCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@DisplayName("Tests for Subscription Repository")
class SubscriptionRepositoryTest {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private CampaingRepository campaingRepository;


    @Test
    @DisplayName("Save persists subscription when Successful")
    void save_Subscription_WhenSuccessful(){
        Subscription subscriptionToBeSaved = SubscriptionCreator.createSubscriptionToBeSaved();

        campaingRepository.save(subscriptionToBeSaved.getCampaign());

        Subscription subscriptionSaved = this.subscriptionRepository.save(subscriptionToBeSaved);

        Assertions.assertThat(subscriptionSaved).isNotNull();
        Assertions.assertThat(subscriptionSaved.getId()).isNotNull();
        Assertions.assertThat(subscriptionSaved.getEmail()).isEqualTo(subscriptionToBeSaved.getEmail());
    }
}
