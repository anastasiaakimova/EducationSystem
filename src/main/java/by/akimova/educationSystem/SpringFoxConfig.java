package by.akimova.educationSystem;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*****************************************************************************************
 * Configuration for Swagger
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SpringFoxConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
