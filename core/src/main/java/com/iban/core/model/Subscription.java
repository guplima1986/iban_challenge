package com.iban.core.model;

import com.iban.core.model.enums.GenderEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class Subscription implements Serializable {

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
