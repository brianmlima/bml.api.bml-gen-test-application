package org.bml.bml.gen.test.application.v0.converter;

import org.bml.bml.gen.test.application.v0.models.TestEnumeration;
import org.springframework.core.convert.converter.Converter;

public class StringToTestEnumerationConverter implements Converter<String, TestEnumeration> {
  @Override
  public TestEnumeration convert(final String apiValue) {
    return TestEnumeration.fromApiValue(apiValue);
  }
}
