package edu.upb.ezo.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StereumResponse {
    private BigDecimal amount;
    private String currency;
    private String network;
    private String id;
    private String qrBase64;
    private String paymentLink;
    private String transactionStatus;
    private boolean onMainNet;
    private String collectingAccount;
    private long expirationTime;
}
