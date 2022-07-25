package com.iban.subscription.controller;

import com.iban.core.model.Subscription;
import com.iban.subscription.endpoint.controller.SubscriptionController;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SubscriptionControllerTest {

    @InjectMocks
    private SubscriptionController subscriptionController;

    @Mock
    private SubscriptionService subscriptionServiceMock;

    @BeforeEach
    void setUp() {

        BDDMockito
                .when(subscriptionServiceMock.createSubscription(ArgumentMatchers.any(Subscription.class)))
                .thenReturn(SubscriptionCreator.createValidSubscription());
    }


    @Test
    @DisplayName("Save and return subscription when Successful")
    void save_returnSubscription_whenSuccessful() {

        Subscription subscription = subscriptionController
                                    .createSubscription(SubscriptionCreator.createSubscriptionRequestBody())
                                    .getBody();

        Assertions.assertThat(subscription)
                                .isNotNull()
                                .isEqualTo(SubscriptionCreator.createValidSubscription());

    }


}
