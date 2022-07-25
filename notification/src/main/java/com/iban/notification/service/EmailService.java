package com.iban.notification.service;

import com.iban.core.model.dto.SubscriptionDto;
import com.iban.notification.domain.EmailDetails;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Data
@Log4j2
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public void createCampaignMessage(SubscriptionDto subscription){
        EmailDetails emailDetails = EmailDetails
                .builder()
                .recipient(subscription.getEmail())
                .subject("Campaign Subject")
                .messageBody("Campaign Message")
                .build();
        sendCampaignEmail(emailDetails);
    }

    private void sendCampaignEmail(EmailDetails email) {
        sendMail(email);
    }

    private void sendMail(EmailDetails details){

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMessageBody());
            mailMessage.setSubject(details.getSubject());
            log.info("Send Email");
            log.info(mailMessage.toString());
            log.info("Email Sent");
        } catch (MailException e) {
            log.error("ERROR: Send Email", e);
        }
    }

}
