package org.bml.bml.gen.test.application.v0.config;

import java.net.URISyntaxException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerUiConfig {
  /**
   * In order to locate the openapi files swagger-ui needs to know the host. Sorry I did not build
   * it. Defaults to http://localhost:8080
   */
  private String host;

  /**
   * @param host In order to locate the openapi files swagger-ui needs to know the host. Sorry I did
   *     not build it. Defaults to http://localhost:8080
   */
  public SwaggerUiConfig(
      @Value("${bml-gen-test-application.host:http://localhost:8080") final String host) {
    this.host = host;
  }

  /** Sets up the base Doclet for SpringFox Swagger-ui. */
  @Bean
  public Docket api() {
    return new Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2)
        .host(host)
        .forCodeGeneration(true)
        .select()
        .apis(springfox.documentation.builders.RequestHandlerSelectors.any())
        .build();
  }

  @Bean
  @Primary
  public SwaggerResourcesProvider swaggerResourcesProvider() {
    return () -> {
      List<SwaggerResource> resources = new java.util.ArrayList<>();
      try {
        resources.add(getSwaggerResource("/bml-gen-test-application/BmlGenTestApplication.yml"));
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
      return resources;
    };
  }

  private SwaggerResource getSwaggerResource(final String file) throws URISyntaxException {
    SwaggerResource r = new SwaggerResource();
    r.setName(fileToResourceName(file));
    r.setSwaggerVersion("3.0.2");
    r.setLocation(file);
    return r;
  }

  private String fileToResourceName(final String file) {
    return StringUtils.join(
        file.substring(file.lastIndexOf('/') + 1, file.lastIndexOf('.')).split("(?=\\p{Upper})"),
        " ");
  }
}
