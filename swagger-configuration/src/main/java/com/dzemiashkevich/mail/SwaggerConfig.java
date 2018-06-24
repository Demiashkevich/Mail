package com.dzemiashkevich.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(@Value("${swagger.title}") String title,
                      @Value("${swagger.description}") String description,
                      @Value("${swagger.version}") String version,
                      @Value("${swagger.contact.name}") String name,
                      @Value("${swagger.contact.url}") String url,
                      @Value("${swagger.contact.mail}") String mail) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo(title, description, version, name, url, mail));
    }

    private ApiInfo apiInfo(String title, String description, String version, String name, String url, String mail) {
        return new ApiInfoBuilder().title(title)
                                   .description(description)
                                   .version(version)
                                   .contact(new Contact(name, url, mail))
                                   .build();
    }

}
