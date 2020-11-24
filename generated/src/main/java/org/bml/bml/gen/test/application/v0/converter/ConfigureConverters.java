package org.bml.bml.gen.test.application.v0.converter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class ConfigureConverters implements WebMvcConfigurer {
  @Override
  public void addFormatters(final FormatterRegistry registry) {
    registry.addConverter(new StringToTestEnumerationConverter());
  }
}
