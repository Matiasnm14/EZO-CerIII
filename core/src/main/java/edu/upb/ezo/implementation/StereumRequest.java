package edu.upb.ezo.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StereumRequest {
    private String country;
    private String amount;
    private String currency;
    private String network;
    private String idempotencyKey;
    private String chargeReason;
    private String reservationValidityTime;
    private Customer customer;
}
