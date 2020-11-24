package org.bml.bml.gen.test.application.v0.controller;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.bml.bml.gen.test.application.v0.service.AccountService;
import org.bml.bml.gen.test.application.v0.service.ResponseModelGetAccountById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class AccountController {
  public static final String API_VERSION = "v0";

  public static final String RESOURCE_PATH = "/v0/accounts";

  private AccountService accountService;

  public AccountController(@Autowired final AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping(path = "/v0/accounts/{id}")
  public ResponseEntity getAccountById(
      @PathVariable(name = "id", required = true) @NotNull final UUID idIn) {
    //   *
    final ResponseModelGetAccountById responseModel = accountService.getAccountById(idIn);
    if (responseModel.account200() != null) {
      final int code = responseModel.account200().getStatusCode().value();
      if (code != 200) {
        throw new ApiImplementationException(
            String.format("account200 ResponseEntity<Account> code must be 200 found %s", code));
      }
      return responseModel.account200();
    }

    if (responseModel.fieldValidationResponse400() != null) {
      final int code = responseModel.fieldValidationResponse400().getStatusCode().value();
      if (code != 400) {
        throw new ApiImplementationException(
            String.format(
                "fieldValidationResponse400 ResponseEntity<FieldValidationResponse> code must be 400 found %s",
                code));
      }
      return responseModel.fieldValidationResponse400();
    }

    if (responseModel.unit401() != null) {
      final int code = responseModel.unit401().getStatusCode().value();
      if (code != 401) {
        throw new ApiImplementationException(
            String.format("unit401 ResponseEntity<Unit> code must be 401 found %s", code));
      }
      return responseModel.unit401();
    }

    if (responseModel.unit404() != null) {
      final int code = responseModel.unit404().getStatusCode().value();
      if (code != 404) {
        throw new ApiImplementationException(
            String.format("unit404 ResponseEntity<Unit> code must be 404 found %s", code));
      }
      return responseModel.unit404();
    }
    throw new ApiImplementationException();
  }
}
