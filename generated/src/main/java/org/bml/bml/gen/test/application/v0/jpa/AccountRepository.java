package org.bml.bml.gen.test.application.v0.jpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.bml.bml.gen.test.application.v0.models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Validated
@Repository
public interface AccountRepository
    extends org.springframework.data.repository.Repository<Account, UUID> {
  /**
   * Saves a given Account. Use the returned instance for further operations as the save operation
   * might have changed the Account instance completely.
   *
   * @param entity an Account to be saved. Must not be {@literal null}.
   * @return the saved Account. will never be {@literal null}.
   */
  Account save(@NotNull Account entity);

  /**
   * Saves all given entities.
   *
   * @param entities must not be {@literal null}.
   * @return the saved entities will never be {@literal null}.
   * @throws IllegalArgumentException in case the given model is {@literal null} or an empty
   *     Itterable.
   */
  List<Account> saveAll(@NotNull @NotEmpty Iterable<Account> entities);

  /**
   * Retrieves an model by its id.
   *
   * @param id must not be {@literal null}.
   * @return the model with the given id or {@literal Optional#empty()} if none found
   * @throws IllegalArgumentException if {@code id} is {@literal null}.
   */
  Optional<Account> findById(@NotNull UUID id);

  /**
   * Tests for model existence by its id.
   *
   * @param id must not be {@literal null}.
   * @return true if the model with the given id exists, false otherwise
   * @throws IllegalArgumentException if {@code id} is {@literal null}.
   */
  boolean existsById(@NotNull UUID id);

  /**
   * Specified by unique attribute field index = [name]
   *
   * @param name A unique human readable string name
   * @returns java.util.Optional<org.bml.bml.gen.test.application.v0.models.Account>
   */
  @Query("SELECT o FROM #{#entityName} o WHERE o.name=?1")
  Optional<Account> findByName(@NotNull String name);
}
