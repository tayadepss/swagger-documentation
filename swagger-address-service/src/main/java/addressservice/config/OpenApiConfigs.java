package addressservice.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.extern.slf4j.Slf4j;

@OpenAPIDefinition
@Configuration
@Slf4j
@PropertySources({
	  @PropertySource("classpath:application.properties")
})
public class OpenApiConfigs {
  
	@Bean
  OpenAPI getOpenAPI(
      @Value("${openapi.service.title}") String serviceTitle,
      @Value("${openapi.service.version}") String serviceVersion,
      @Value("${openapi.service.url}") String url) {
	  
	  log.info("in OpenApiConfig.getOpenApi() method, service title:{}",serviceTitle);
	  return new OpenAPI()
        .servers(List.of(new Server().url(url)))
        .info(new Info().title(serviceTitle).version(serviceVersion));
  }
}
