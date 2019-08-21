package com.sap.b1.eric.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket createRestAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sap.b1.eric."))
                .paths(PathSelectors.any()) //TODO: how to control the exposing of api?
                .build();
	}

	private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Eric's SpringBoot Study Project's API Document")
                .description("This is auto-generated api document for test only")
                .termsOfServiceUrl("")
                .contact(new Contact("Eric.Su", "", ""))
                .version("1.0")
                .build();
	}
}
