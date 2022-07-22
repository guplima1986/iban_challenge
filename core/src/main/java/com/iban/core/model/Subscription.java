package com.iban.core.model;

import com.iban.core.model.enums.GenderEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private GenderEnum gender;

    @NotNull
    private String email;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private Boolean consent;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

}
