package edu.upb.ezo;
import edu.upb.ezo.implementation.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class EzoApplication implements CommandLineRunner {

	@Autowired
	private Ezo ezo;
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(EzoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		EzoAuthRequest request = new EzoAuthRequest();
		request.setUsername("root");
		request.setPassword("password");
		EzoAuthResponse response = ezo.auth(request);
		System.out.println(response);


		String token = response.getAccessToken();

		List<EzoPaisResponse> ezoPaisResponse = ezo.getList(token,"api/v1/pais", new ParameterizedTypeReference<List<EzoPaisResponse>>() {});

		for(EzoPaisResponse e : ezoPaisResponse){
			System.out.println(e);
		}

		List<EzoMetodoPagoResponse> metodoPagoResponses = ezo.getList(token,"pruebas/metodos-pagos", new ParameterizedTypeReference<List<EzoMetodoPagoResponse>>() {});
		for(EzoMetodoPagoResponse e : metodoPagoResponses){
			System.out.println(e);
		}


	}
}
