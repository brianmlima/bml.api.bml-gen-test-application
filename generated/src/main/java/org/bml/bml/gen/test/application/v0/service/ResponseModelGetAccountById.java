package org.bml.bml.gen.test.application.v0.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bml.bml.gen.test.application.v0.models.Account;
import org.bml.validation.v0.models.FieldValidationResponse;
import org.springframework.http.ResponseEntity;

@Builder(toBuilder = true)
@Accessors(fluent = true)
public class ResponseModelGetAccountById {
  @Getter(onMethod = @__(@JsonIgnore))
  ResponseEntity<Account> account200;

  @Getter(onMethod = @__(@JsonIgnore))
  ResponseEntity<FieldValidationResponse> fieldValidationResponse400;

  @Getter(onMethod = @__(@JsonIgnore))
  ResponseEntity<Void> unit401;

  @Getter(onMethod = @__(@JsonIgnore))
  ResponseEntity<Void> unit404;
}
