package org.bml.bml.gen.test.application.v0.models;

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
import org.bml.bml.gen.test.application.v0.models.factory.AccountFormMockFactory;
import org.bml.bml.gen.test.application.v0.models.factory.AccountMockFactory;
import org.bml.bml.gen.test.application.v0.models.factory.HealthcheckMockFactory;
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
      "Testing Validation on Account provided by org.bml.bml.gen.test.application.v0.models.factory.AccountMockFactory")
  public void testAccountValidation() {
    AccountMockFactory factory = AccountMockFactory.DEFAULT_FACTORY;
    assertThat(
        " factory instance of AccountMockFactory should not be null", factory, notNullValue());
    Account object = factory.get();
    Set<ConstraintViolation<Account>> constraintViolations;
    try {
      constraintViolations = validator.validate(object);
    } catch (Exception e) {
      log.error(
          "{} caught while validating instance of {} msg={}",
          e.getClass().getSimpleName(),
          Account.class.getName(),
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
      "Testing Validation on AccountForm provided by org.bml.bml.gen.test.application.v0.models.factory.AccountFormMockFactory")
  public void testAccountFormValidation() {
    AccountFormMockFactory factory = AccountFormMockFactory.DEFAULT_FACTORY;
    assertThat(
        " factory instance of AccountFormMockFactory should not be null", factory, notNullValue());
    AccountForm object = factory.get();
    Set<ConstraintViolation<AccountForm>> constraintViolations;
    try {
      constraintViolations = validator.validate(object);
    } catch (Exception e) {
      log.error(
          "{} caught while validating instance of {} msg={}",
          e.getClass().getSimpleName(),
          AccountForm.class.getName(),
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
      "Testing Validation on Healthcheck provided by org.bml.bml.gen.test.application.v0.models.factory.HealthcheckMockFactory")
  public void testHealthcheckValidation() {
    HealthcheckMockFactory factory = HealthcheckMockFactory.DEFAULT_FACTORY;
    assertThat(
        " factory instance of HealthcheckMockFactory should not be null", factory, notNullValue());
    Healthcheck object = factory.get();
    Set<ConstraintViolation<Healthcheck>> constraintViolations;
    try {
      constraintViolations = validator.validate(object);
    } catch (Exception e) {
      log.error(
          "{} caught while validating instance of {} msg={}",
          e.getClass().getSimpleName(),
          Healthcheck.class.getName(),
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
