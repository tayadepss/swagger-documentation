package apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class SwaggerApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApiGatewayApplication.class, args);
	}

}
