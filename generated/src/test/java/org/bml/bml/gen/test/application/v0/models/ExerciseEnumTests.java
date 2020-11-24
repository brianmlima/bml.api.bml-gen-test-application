package org.bml.bml.gen.test.application.v0.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ExerciseEnumTests {
  @Test
  @DisplayName("Exercising TestEnumeration Enum, Checking...")
  void exerciseTestEnumerationEnum() throws Exception {
    TestEnumeration.Converters.ToString toStringConverter =
        new TestEnumeration.Converters.ToString();
    TestEnumeration.Converters.ToEnum toEnumConverter = new TestEnumeration.Converters.ToEnum();
    for (TestEnumeration value : TestEnumeration.values()) {
      assertThat(value.apiValue(), notNullValue());
      assertThat(value.apiValue().isEmpty(), is(false));
      assertThat(value.toString(), notNullValue());
      assertThat(value.toString().isEmpty(), is(false));
      assertThat(value.toString(), is(value.apiValue()));
      assertThat(TestEnumeration.fromApiValue(value.apiValue()), is(value));
      assertThat(toStringConverter.convert(value), is(value.apiValue()));
      assertThat(toEnumConverter.convert(value.apiValue()), is(value));
    }
  }
}
