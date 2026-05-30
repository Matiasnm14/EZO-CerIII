package edu.upb.ezo.implementation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StereumRequest {
    private String country;
    private String amount;
    private String currency;
    private String network;
    private String charge_reason;
    private String reservation_validity_time;
    private Customer customer;
}
