package br.com.springboot.base.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API")
                .description("\"Spring Boot REST API for Online Store\"")
                .version("1.0.0")
                .license("GNU General Public License 3.0")
                .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.pt-br.html\"")
                .contact(new Contact("Nick Kras Borges", "https://github.com/nickkrasborges2", "nickkrasborges2gmail.com"))
                .build();
    }
}
