package br.com.springboot.base.core.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;
import static springfox.documentation.builders.PathSelectors.*;
import static com.google.common.base.Predicates.*;

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
@EnableAutoConfiguration
public class SwaggerConfig {

    @Value("${swagger.oauth.url}")
    private String swaggerOAuthUrl;


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("springboot-base-oauth-server")
                .select()
                .paths(paths())
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .securitySchemes(Arrays.asList(oauth2()));
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

    private Predicate<String> paths() {
        return or(regex("/api/.*"));
    }

    @Bean
    SecurityScheme oauth2() {
        return new OAuthBuilder()
                .name("oauth2")
                .grantTypes(grantTypes())
                .scopes(scopes())
                .build();
    }

    List<AuthorizationScope> scopes() {
        return Arrays.asList(new AuthorizationScope("entity.read", "Read access on entity in my new API"));
    }

    List<GrantType> grantTypes() {
        ImplicitGrant implicitGrant = new ImplicitGrant(new LoginEndpoint(swaggerOAuthUrl),"access_code");

        return Arrays.asList(implicitGrant);
    }
}
