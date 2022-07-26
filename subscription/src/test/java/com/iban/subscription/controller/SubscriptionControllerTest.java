package com.iban.subscription.controller;

import com.iban.core.model.Campaign;
import com.iban.core.repository.CampaingRepository;
import com.iban.core.requests.SubscriptionRequestBody;
import com.iban.subscription.util.SubscriptionCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureTestDatabase
class SubscriptionControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private CampaingRepository campaingRepository;

    //@Test
    @DisplayName("save returns Subscription when successful")
    void save_ReturnsSubscription_WhenSuccessful(){
        SubscriptionRequestBody subscriptionRequestBody = SubscriptionCreator.createSubscriptionRequestBody();

        campaingRepository.save(new Campaign(1L, "Marketing"));

        ResponseEntity<SubscriptionRequestBody> subscriptionResponseEntity = testRestTemplate.postForEntity("/subscriptions", subscriptionRequestBody, SubscriptionRequestBody.class);

        Assertions.assertThat(subscriptionResponseEntity).isNotNull();
        Assertions.assertThat(subscriptionResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(subscriptionResponseEntity.getBody()).isNotNull();
        Assertions.assertThat(subscriptionResponseEntity.getBody().getCampaign()).isNotNull();

    }


}
