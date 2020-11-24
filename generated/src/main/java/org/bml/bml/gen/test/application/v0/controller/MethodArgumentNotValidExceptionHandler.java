package org.bml.bml.gen.test.application.v0.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;
import org.bml.validation.v0.models.FieldValidationError;
import org.bml.validation.v0.models.FieldValidationResponse;
import org.bml.validation.v0.models.FieldValidationResponse.FieldValidationResponseBuilder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class MethodArgumentNotValidExceptionHandler {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public FieldValidationResponse methodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();
    return processFieldErrors(fieldErrors);
  }

  private FieldValidationResponse processFieldErrors(final List<FieldError> fieldErrors) {
    final FieldValidationResponseBuilder responseBuilder =
        FieldValidationResponse.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .message("validation error");
    responseBuilder.errors(
        fieldErrors.stream()
            .map(
                fieldError ->
                    FieldValidationError.builder()
                        .path(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build())
            .collect(toList()));
    return responseBuilder.build();
  }
}
