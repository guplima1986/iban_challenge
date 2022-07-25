package com.iban.subscription.repository;

import com.iban.core.model.Campaign;
import com.iban.core.model.Subscription;
import com.iban.core.model.enums.GenderEnum;
import com.iban.core.repository.CampaingRepository;
import com.iban.core.repository.SubscriptionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

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
        Subscription subscription = new Subscription();
        Campaign campaign = new Campaign();
        campaign.setId(1L);

        campaingRepository.save(campaign);

        subscription.setCampaign(campaign);
        subscription.setConsent(false);
        subscription.setEmail("gustavo@teste.com");
        subscription.setGender(GenderEnum.MALE);
        subscription.setFirstName("Gustavo");
        subscription.setDateOfBirth(LocalDate.of(1986,06, 06));
        subscription.setId(1L);

        Subscription subscriptionSaved = this.subscriptionRepository.save(subscription);

        Assertions.assertThat(subscriptionSaved).isNotNull();

        Assertions.assertThat(subscriptionSaved.getId()).isNotNull();

        Assertions.assertThat(subscriptionSaved.getEmail()).isEqualTo(subscription.getEmail());
    }
}
