package com.iban.core.model.dto;

import com.iban.core.model.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto implements Serializable {

    private String firstName;
    private GenderEnum gender;
    private String email;
    private LocalDate dateOfBirth;
    private Boolean consent;
    private CampaingDto campaign;
}
