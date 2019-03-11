package br.com.springboot.base.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *  Docket is a builder class to configure the generation of Swagger documentation, configured
 *  with DocumentationType.SWAGGER_2 to generate Swagger 2 compatible API documentation.
 *  select() method called on the Docket bean instance returns an ApiSelectorBuilder,
 *  which provides the apis() and paths() methods to filter the
 *  controllers and methods being documented using string predicates.
 * @return
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
