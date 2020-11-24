package org.bml.validation.v0.models;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;
import org.bml.validation.v0.models.factory.ConflictResourceExistsResponseMockFactory;
import org.bml.validation.v0.models.factory.FieldValidationErrorEntryMockFactory;
import org.bml.validation.v0.models.factory.FieldValidationErrorMockFactory;
import org.bml.validation.v0.models.factory.FieldValidationResponseMockFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ExercisePojoValidationTests {
  private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  private <T> String constraintViolationsToLogString(
      final Set<ConstraintViolation<T>> constraintViolations) {
    return constraintViolations.stream()
        .map(
            (violation) ->
                String.format(
                    "{Package:'%s', Object:'%s' PropertyPath:'%s' Value:'%s' message:'%s'}",
                    StringEscapeUtils.escapeJson(violation.getRootBeanClass().getSimpleName()),
                    StringEscapeUtils.escapeJson(violation.getRootBeanClass().getSimpleName()),
                    StringEscapeUtils.escapeJson(violation.getPropertyPath().toString()),
                    StringEscapeUtils.escapeJson(violation.getInvalidValue().toString()),
                    StringEscapeUtils.escapeJson(violation.getMessage())))
        .collect(joining(", "));
  }

  @Test
  @DisplayName(
      "Testing Validation on ConflictResourceExistsResponse provided by org.bml.validation.v0.models.factory.ConflictResourceExistsResponseMockFactory")
  public void testConflictResourceExistsResponseValidation() {
    ConflictResourceExistsResponseMockFactory factory =
        ConflictResourceExistsResponseMockFactory.DEFAULT_FACTORY;
    assertThat(
        " factory instance of ConflictResourceExistsResponseMockFactory should not be null",
        factory,
        notNullValue());
    ConflictResourceExistsResponse object = factory.get();
    Set<ConstraintViolation<ConflictResourceExistsResponse>> constraintViolations;
    try {
      constraintViolations = validator.validate(object);
    } catch (Exception e) {
      log.error(
          "{} caught while validating instance of {} msg={}",
          e.getClass().getSimpleName(),
          ConflictResourceExistsResponse.class.getName(),
          e.getMessage(),
          e);
      throw e;
    }
    String constraintViolationErrors = constraintViolationsToLogString(constraintViolations);
    assertThat(
        String.format(
            "ConstraintViolations should be empty Found=%s Errors=%s",
            constraintViolations.size(), constraintViolationErrors),
        constraintViolations.isEmpty(),
        is(true));
  }

  @Test
  @DisplayName(
      "Testing Validation on FieldValidationError provided by org.bml.validation.v0.models.factory.FieldValidationErrorMockFactory")
  public void testFieldValidationErrorValidation() {
    FieldValidationErrorMockFactory factory = FieldValidationErrorMockFactory.DEFAULT_FACTORY;
    assertThat(
        " factory instance of FieldValidationErrorMockFactory should not be null",
        factory,
        notNullValue());
    FieldValidationError object = factory.get();
    Set<ConstraintViolation<FieldValidationError>> constraintViolations;
    try {
      constraintViolations = validator.validate(object);
    } catch (Exception e) {
      log.error(
          "{} caught while validating instance of {} msg={}",
          e.getClass().getSimpleName(),
          FieldValidationError.class.getName(),
          e.getMessage(),
          e);
      throw e;
    }
    String constraintViolationErrors = constraintViolationsToLogString(constraintViolations);
    assertThat(
        String.format(
            "ConstraintViolations should be empty Found=%s Errors=%s",
            constraintViolations.size(), constraintViolationErrors),
        constraintViolations.isEmpty(),
        is(true));
  }

  @Test
  @DisplayName(
      "Testing Validation on FieldValidationErrorEntry provided by org.bml.validation.v0.models.factory.FieldValidationErrorEntryMockFactory")
  public void testFieldValidationErrorEntryValidation() {
    FieldValidationErrorEntryMockFactory factory =
        FieldValidationErrorEntryMockFactory.DEFAULT_FACTORY;
    assertThat(
        " factory instance of FieldValidationErrorEntryMockFactory should not be null",
        factory,
        notNullValue());
    FieldValidationErrorEntry object = factory.get();
    Set<ConstraintViolation<FieldValidationErrorEntry>> constraintViolations;
    try {
      constraintViolations = validator.validate(object);
    } catch (Exception e) {
      log.error(
          "{} caught while validating instance of {} msg={}",
          e.getClass().getSimpleName(),
          FieldValidationErrorEntry.class.getName(),
          e.getMessage(),
          e);
      throw e;
    }
    String constraintViolationErrors = constraintViolationsToLogString(constraintViolations);
    assertThat(
        String.format(
            "ConstraintViolations should be empty Found=%s Errors=%s",
            constraintViolations.size(), constraintViolationErrors),
        constraintViolations.isEmpty(),
        is(true));
  }

  @Test
  @DisplayName(
      "Testing Validation on FieldValidationResponse provided by org.bml.validation.v0.models.factory.FieldValidationResponseMockFactory")
  public void testFieldValidationResponseValidation() {
    FieldValidationResponseMockFactory factory = FieldValidationResponseMockFactory.DEFAULT_FACTORY;
    assertThat(
        " factory instance of FieldValidationResponseMockFactory should not be null",
        factory,
        notNullValue());
    FieldValidationResponse object = factory.get();
    Set<ConstraintViolation<FieldValidationResponse>> constraintViolations;
    try {
      constraintViolations = validator.validate(object);
    } catch (Exception e) {
      log.error(
          "{} caught while validating instance of {} msg={}",
          e.getClass().getSimpleName(),
          FieldValidationResponse.class.getName(),
          e.getMessage(),
          e);
      throw e;
    }
    String constraintViolationErrors = constraintViolationsToLogString(constraintViolations);
    assertThat(
        String.format(
            "ConstraintViolations should be empty Found=%s Errors=%s",
            constraintViolations.size(), constraintViolationErrors),
        constraintViolations.isEmpty(),
        is(true));
  }

  private void testValidation() {}
}
