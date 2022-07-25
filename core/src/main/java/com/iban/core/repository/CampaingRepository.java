package com.iban.core.repository;

import com.iban.core.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaingRepository extends JpaRepository<Campaign, Long> {
}
