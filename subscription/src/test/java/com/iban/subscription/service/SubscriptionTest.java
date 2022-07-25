package com.iban.subscription.service;

import com.iban.core.model.Campaign;
import com.iban.core.model.Subscription;
import com.iban.core.model.enums.GenderEnum;
import com.iban.core.repository.SubscriptionRepository;
import com.iban.subscription.endpoint.service.SubscriptionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
class SubscriptionTest {

    @Mock
    RabbitTemplate publisher;

    @InjectMocks
    private SubscriptionService subscriptionService;

    @Mock
    private SubscriptionRepository subscriptionRepositoryMock;

    private Subscription createSubscriptionMock(){
        Subscription subscription = new Subscription();
        Campaign campaign = new Campaign();
        campaign.setId(1L);

        subscription.setCampaign(campaign);
        subscription.setConsent(false);
        subscription.setEmail("gustavo@teste.com");
        subscription.setGender(GenderEnum.MALE);
        subscription.setFirstName("Gustavo");
        subscription.setDateOfBirth(LocalDate.of(1986,06, 06));
        subscription.setId(1L);
        return subscription;
    }

    @BeforeEach
    void setUp(){
        BDDMockito
                .when(subscriptionRepositoryMock.save(ArgumentMatchers.any(Subscription.class)))
                .thenReturn(createSubscriptionMock());
    }

    @Test
    @DisplayName("Save subscription when successfull")
    void save_ReturnsSubscription_WhenSuccessfull(){
        Subscription subscriptionToBeSaved = new Subscription();
        Campaign campaign = new Campaign();
        campaign.setId(1L);

        subscriptionToBeSaved.setCampaign(campaign);
        subscriptionToBeSaved.setConsent(false);
        subscriptionToBeSaved.setEmail("gustavo@teste.com");
        subscriptionToBeSaved.setGender(GenderEnum.MALE);
        subscriptionToBeSaved.setFirstName("Gustavo");
        subscriptionToBeSaved.setDateOfBirth(LocalDate.of(1986,06, 06));

        Subscription subscription = subscriptionService.createSubscription(subscriptionToBeSaved);

        Assertions
                .assertThat(subscription)
                .isNotNull()
                .isEqualTo(createSubscriptionMock());
    }

    @Test
    @DisplayName("Save subscription when successfull")
    void test(){
        Subscription subscriptionToBeSaved = new Subscription();
        Campaign campaign = new Campaign();
        campaign.setId(1L);

        subscriptionToBeSaved.setCampaign(campaign);
        subscriptionToBeSaved.setConsent(false);
        subscriptionToBeSaved.setEmail("gustavo@teste.com");
        subscriptionToBeSaved.setGender(GenderEnum.MALE);
        subscriptionToBeSaved.setFirstName("Gustavo");
        subscriptionToBeSaved.setDateOfBirth(LocalDate.of(1986,06, 06));

        Subscription subscription = subscriptionService.createSubscription(subscriptionToBeSaved);

        Assertions
                .assertThat(subscription)
                .isNotNull()
                .isEqualTo(createSubscriptionMock());
    }


}
