package org.bml.bml.gen.test.application.v0.service;

import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface AccountService {
  /**
   * @param id java.util.UUID The Universally Unique Identifier for an existing account resource.
   *     See RFC 4122
   * @return ResponseEntity
   */
  ResponseModelGetAccountById getAccountById(@NotNull @Valid UUID id);
}
