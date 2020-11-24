package org.bml.bml.gen.test.application.v0.models.factory;

import java.util.Locale;
import java.util.UUID;
import java.util.function.Supplier;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bml.bml.gen.test.application.v0.models.Account;
import org.bml.bml.gen.test.application.v0.models.Account.AccountBuilder;
import org.bml.bml.gen.test.application.v0.tool.TestSuppliers;

@Builder
@Accessors(fluent = true)
public class AccountMockFactory implements Supplier<Account> {
  public static int MAX_GENERATED_LIST_SIZE = 50;

  public static AccountMockFactory DEFAULT_FACTORY = builder().build();

  @Getter @Builder.Default private Supplier<UUID> id = idDefaultSupplier();

  @Getter @Builder.Default private Supplier<String> name = nameDefaultSupplier();

  @Getter @Builder.Default private Supplier<Boolean> enabled = enabledDefaultSupplier();

  public static Supplier<Account> defaultObjectSupplier() {
    return () -> DEFAULT_FACTORY.get();
  }

  public static Supplier<UUID> idDefaultSupplier() {
    return TestSuppliers.UUIDSupplier();
  }

  public static Supplier<String> nameDefaultSupplier() {
    return TestSuppliers.stringRangeSupplier(
        Locale.ENGLISH, Account.NAME_MIN_LENGTH, Account.NAME_MAX_LENGTH);
  }

  public static Supplier<Boolean> enabledDefaultSupplier() {
    return TestSuppliers.booleanSupplier();
  }

  public Account get() {
    AccountBuilder builder = Account.builder();
    if (id != null) {
      UUID idObject = id.get();
      if (idObject != null) {
        builder.id(idObject);
      }
    }
    if (name != null) {
      String nameObject = name.get();
      if (nameObject != null) {
        builder.name(nameObject);
      }
    }
    if (enabled != null) {
      Boolean enabledObject = enabled.get();
      if (enabledObject != null) {
        builder.enabled(enabledObject);
      }
    }
    return builder.build();
  }
}
