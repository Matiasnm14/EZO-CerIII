package edu.upb.ezo.implementation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StereumResponse {
    private int amount;
    private String currency;
    private String POLYGON;
    private String id;
    private String qr_base64;
    private String payment_link;
    private String transaction_status;
    private boolean on_main_net;
    private String collecting_account;
    private long expiration_time;
}
