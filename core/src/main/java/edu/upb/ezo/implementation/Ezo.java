package edu.upb.ezo.implementation;


import edu.upb.ezo.service.exception.NotDataFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.Duration;
import java.util.List;


@Slf4j
@Service
public class Ezo {
    @Value("${sistema1.url-base}")
    private String urlBase;
    @Value("${sistema1.connect-timeout}")
    private int connectTimeout = 10000;
    @Value("${sistema1.read-timeout}")
    private int readTimeout = 40000;

    public EzoAuthResponse auth(EzoAuthRequest request) throws Exception {
        RestClient restClient = create();

        ResponseEntity<EzoAuthResponse> response;
        try {
            response = restClient.post()
                    .uri(urlBase + "/api/v1/auth")
                    .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    .header("Accept", MediaType.APPLICATION_JSON_VALUE)
                    .body(request)
                    .retrieve()
                    .toEntity(EzoAuthResponse.class);
        } catch (NotDataFoundException e) {
            log.error("NotDataFoundException. {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Exception. ", e);
            throw e;
        }

        if (!response.getStatusCode().is2xxSuccessful()) {
            log.error("Se genero error: {}", response.getStatusCode().value());
            throw new Exception("Se genero error");
        }

        return response.getBody();
    }

    public <T> List<T> getList(String token, String url, ParameterizedTypeReference<List<T>> responseType) throws Exception {
        RestClient restClient = create();

        ResponseEntity<List<T>> response;
        try {
            response = restClient.get()
                    .uri(urlBase + "/" + url)
                    .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    .header("Accept", MediaType.APPLICATION_JSON_VALUE)
                    .header("Authorization", "Bearer " + token)
                    .retrieve()
                    .toEntity(responseType);

        } catch (NotDataFoundException e) {
            log.error("NotDataFoundException. {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Exception. ", e);
            throw e;
        }

        if (!response.getStatusCode().is2xxSuccessful()) {
            log.error("Se generó error: {}", response.getStatusCode().value());
            throw new Exception("Se generó error en la petición HTTP");
        }

        return response.getBody();
    }



    private RestClient create() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(Duration.ofMillis(connectTimeout));
        clientHttpRequestFactory.setReadTimeout(Duration.ofMillis(readTimeout));

        return RestClient.builder().requestFactory(clientHttpRequestFactory).build();
    }
}
