package com.iban.core.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class SubscriptionRequestBody {

    @Schema(description = "This is the client name", example = "Willian Rockeford")
    private String firstName;

    @Schema(description = "This is the client gender", example = "MALE or FEMALE")
    private String gender;

    @Schema(description = "This is the client email", example = "willian@rockeford.com")
    @NotNull(message = "The field 'EMAIL' can not be null")
    private String email;

    @Schema(description = "This is the client date of birth", example = "1986-06-30")
    @NotNull(message = "The field 'DATEOFBIRTH' can not be null")
    private LocalDate dateOfBirth;

    @Schema(description = "This is the client consent", example = "TRUE or FALSE")
    @NotNull(message = "The field 'CONSENT' can not be null")
    private Boolean consent;

    @Schema(description = "This is the campaing number identification", example = "12")
    @NotNull(message = "The field 'CAMPAIGN' can not be null")
    private Integer campaign;
}
