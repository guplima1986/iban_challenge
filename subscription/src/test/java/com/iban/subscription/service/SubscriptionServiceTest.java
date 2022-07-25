package com.iban.subscription.service;

import com.iban.core.model.Campaign;
import com.iban.core.model.Subscription;
import com.iban.core.model.enums.GenderEnum;
import com.iban.core.repository.SubscriptionRepository;
import com.iban.subscription.endpoint.service.SubscriptionService;
import com.iban.subscription.util.SubscriptionCreator;
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
class SubscriptionServiceTest {

    @Mock
    RabbitTemplate publisher;

    @InjectMocks
    private SubscriptionService subscriptionService;

    @Mock
    private SubscriptionRepository subscriptionRepositoryMock;

    @BeforeEach
    void setUp(){
        BDDMockito
                .when(subscriptionRepositoryMock.save(ArgumentMatchers.any(Subscription.class)))
                .thenReturn(SubscriptionCreator.createValidSubscription());
    }

    @Test
    @DisplayName("Save subscription when successfull")
    void save_ReturnsSubscription_WhenSuccessfull(){
        Subscription subscription = subscriptionService
                                            .createSubscription(SubscriptionCreator.createSubscriptionToBeSaved());

        Assertions
                .assertThat(subscription)
                .isNotNull()
                .isEqualTo(SubscriptionCreator.createValidSubscription());
    }

}
