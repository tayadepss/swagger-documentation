package personservice.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@PropertySources({
	@PropertySource("classpath:application.properties")
})
public class OpenApiConfig {
	
	@Bean
	OpenAPI getOpenApi(
			@Value("${openapi.service.title}") String serviceTitle,
			@Value("${openapi.service.url") String serviceUrl,
			@Value("${openapi.service.version}") String serviceVersion
			) {
				return new OpenAPI()
						.servers(List.of(new Server().url(serviceUrl)))
						.info(new Info().title(serviceTitle).version(serviceVersion));
		
	}

}
