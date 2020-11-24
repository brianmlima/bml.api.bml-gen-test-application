package org.bml.bml.gen.test.application.v0.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Add json or yaml content negotiation for all endpoints.
 *
 * <p>Provides two {@link ObjectMapper}s {@link #jsonObjectMapper} & {@link #yamlObjectMapper}
 */
@Configuration
public class BmlGenTestApplicationBaseConfiuration implements WebMvcConfigurer {
  public static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("text/yaml");

  public static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("text/yml");

  @Primary
  @Bean(name = "jsonObjectMapper")
  public ObjectMapper jsonObjectMapper() {
    return new ObjectMapper().registerModule(new JavaTimeModule());
  }

  @Bean(name = "yamlObjectMapper")
  public ObjectMapper yamlObjectMapper() {
    return new ObjectMapper(new YAMLFactory()).registerModule(new JavaTimeModule());
  }

  @Override
  public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
    configurer
        .favorPathExtension(true)
        .favorParameter(false)
        .ignoreAcceptHeader(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType(MediaType.APPLICATION_JSON.getSubtype(), MediaType.APPLICATION_JSON)
        .mediaType(MEDIA_TYPE_YAML.getSubtype(), MEDIA_TYPE_YAML)
        .mediaType(MEDIA_TYPE_YML.getSubtype(), MEDIA_TYPE_YML);
  }

  @Override
  public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
    converters.add(new YamlMessageConverter());
  }

  public static class YamlMessageConverter extends MappingJackson2HttpMessageConverter {
    YamlMessageConverter() {
      // can use overloaded constructor to set supported MediaType
      super(
          new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER))
              .registerModule(new JavaTimeModule())
              .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false));
      this.setSupportedMediaTypes(ImmutableList.of(MEDIA_TYPE_YML, MEDIA_TYPE_YAML));
    }
  }
}
