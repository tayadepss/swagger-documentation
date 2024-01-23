package addressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition
public class SwaggerAddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerAddressServiceApplication.class, args);
	}
}

