package by.akimova.educationSystem.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022-2022.
 ****************************************************************************************/

@Configuration
@RequiredArgsConstructor
public class SpringFoxConfiguration {

    /*@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
*/
    @Bean
    public OpenAPI customOpenAPI(@Value("1.3.3") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("educationSystem")
                        .version(appVersion)
                        .contact(
                                new Contact()
                                        .name("Nasta")
                        )
                );
    }
}
