package com.iban.subscription;

import com.iban.core.model.Campaign;
import com.iban.core.repository.CampaingRepository;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({ "com.iban.core.model"})
@EnableJpaRepositories({"com.iban.core.repository"})
@EnableRabbit
public class SubscriptionApplication implements CommandLineRunner {

	@Autowired
	private CampaingRepository campaingRepository;

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		campaingRepository.save(new Campaign(null, "Health"));
		campaingRepository.save(new Campaign(null, "Sports"));
		campaingRepository.save(new Campaign(null, "Travel"));

	}
}
