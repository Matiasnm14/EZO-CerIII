package edu.upb.ezo.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.Duration;

@Slf4j
@Service
public class StereumApi {
//    private final String urlBase = "https://stereum.upb.edu";

    @Value("${stereum.url-base}")
    private String urlBase;
    @Value("${stereum.connect-timeout}")
    private int connectTimeout;
    @Value("${stereum.read-timeout}")
    private int readTimeout;
    @Value("${stereum.api.key}")
    private String apiKey;


    public StereumResponse post(StereumRequest request) throws Exception {
        RestClient restClient = create();

        ResponseEntity<StereumResponse> response;
        try {
            response = restClient.post()
                    .uri(urlBase + "/api/v1/transactions/create-charge")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("x-api-key", apiKey)
                    .body(request)
                    .retrieve()
                    .toEntity(StereumResponse.class);
        } catch (Exception e) {
            throw new Exception("Error en la autenticación con Stereum: " + e.getMessage());
        }

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new Exception("Error en la autenticación con Stereum: " + response.getStatusCode());
        }

        return response.getBody();
    }

//    public String get(String id){
//        RestClient restClient = create();
//
//        ResponseEntity<StereumResponse> response;
//        try {
//            response = restClient.get()
//                    .uri(urlBase + "/api/v1/transactions/"+id+"/verify")
//                    .header("Content-Type", "application/json")
//                    .header("Accept", "application/json")
//                    .header("x-api-key", "e6444ca8-e106-4b26-b4c3-b88d34371bf8")
//                    .retrieve()
//                    .toEntity(StereumResponse.class);
//        } catch (Exception e) {
//            throw new Exception("Error en la autenticación con Stereum: " + e.getMessage());
//        }
//
//        if (!response.getStatusCode().is2xxSuccessful()) {
//            throw new Exception("Error en la autenticación con Stereum: " + response.getStatusCode());
//        }
//
//        return response.getBody();
//    }

    private RestClient create() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(Duration.ofMillis(connectTimeout));
        clientHttpRequestFactory.setReadTimeout(Duration.ofMillis(readTimeout));

        return RestClient.builder().requestFactory(clientHttpRequestFactory).build();
    }

}
