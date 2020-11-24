package org.bml.validation.v0.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ExerciseEnumTests {
  @Test
  @DisplayName("Exercising FieldValidationErrorType Enum, Checking...")
  void exerciseFieldValidationErrorTypeEnum() throws Exception {
    FieldValidationErrorType.Converters.ToString toStringConverter =
        new FieldValidationErrorType.Converters.ToString();
    FieldValidationErrorType.Converters.ToEnum toEnumConverter =
        new FieldValidationErrorType.Converters.ToEnum();
    for (FieldValidationErrorType value : FieldValidationErrorType.values()) {
      assertThat(value.apiValue(), notNullValue());
      assertThat(value.apiValue().isEmpty(), is(false));
      assertThat(value.toString(), notNullValue());
      assertThat(value.toString().isEmpty(), is(false));
      assertThat(value.toString(), is(value.apiValue()));
      assertThat(FieldValidationErrorType.fromApiValue(value.apiValue()), is(value));
      assertThat(toStringConverter.convert(value), is(value.apiValue()));
      assertThat(toEnumConverter.convert(value.apiValue()), is(value));
    }
  }
}
