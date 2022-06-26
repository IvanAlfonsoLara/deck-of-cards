package org.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
	Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.regex("/card/.*")).build()
				.apiInfo(apiInfoMetaData());
	}

	private ApiInfo apiInfoMetaData() {

		return new ApiInfoBuilder().title("Deck of Cards").description("API Endpoint")
				.contact(new Contact("Iván Alfonso Lara", "", "alfonsolaraivan@gmail.com")).license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
	}

}