/**
 * 
 */
package br.com.nt.fabrictrack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * @author Neto
 *
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI fabricTracOpenAPI() {

	License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
	Info info = new Info().title("FabricTrack API").version("1.0").contact(null)
		.description("This API exposes endpoints to sales system.")
		.termsOfService("").license(mitLicense);
	
	return new OpenAPI().info(info);
    }
    
    
}
