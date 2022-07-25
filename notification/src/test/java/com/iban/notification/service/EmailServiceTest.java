package com.iban.notification.service;

import com.iban.core.model.Campaign;
import com.iban.core.model.Subscription;
import com.iban.core.model.dto.CampaingDto;
import com.iban.core.model.dto.SubscriptionDto;
import com.iban.core.model.enums.GenderEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.mail.MailException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
public class EmailServiceTest {

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Save subscription when successfull")
    void sendEmail_WhenSuccessfull(){

        SubscriptionDto dto = createSubscriptionDto();

        Assertions
                .assertThatCode( () -> emailService.createCampaignMessage(dto))
                .doesNotThrowAnyException();
    }

    private SubscriptionDto createSubscriptionDto() {
        SubscriptionDto subscription = new SubscriptionDto();
        CampaingDto campaign = new CampaingDto();
        campaign.setName("1");

        subscription.setCampaign(campaign);
        subscription.setConsent(false);
        subscription.setEmail("gustavo@teste.com");
        subscription.setGender(GenderEnum.MALE);
        subscription.setFirstName("Gustavo");
        subscription.setConsent(Boolean.FALSE);
        subscription.setDateOfBirth(LocalDate.of(1986, 06, 06));

        return subscription;
    }
}
