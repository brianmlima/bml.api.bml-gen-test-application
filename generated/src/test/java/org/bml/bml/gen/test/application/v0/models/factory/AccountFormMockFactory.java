package org.bml.bml.gen.test.application.v0.models.factory;

import java.util.Locale;
import java.util.function.Supplier;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bml.bml.gen.test.application.v0.models.AccountForm;
import org.bml.bml.gen.test.application.v0.models.AccountForm.AccountFormBuilder;
import org.bml.bml.gen.test.application.v0.tool.TestSuppliers;

@Builder
@Accessors(fluent = true)
public class AccountFormMockFactory implements Supplier<AccountForm> {
  public static int MAX_GENERATED_LIST_SIZE = 50;

  public static AccountFormMockFactory DEFAULT_FACTORY = builder().build();

  @Getter @Builder.Default private Supplier<String> name = nameDefaultSupplier();

  @Getter @Builder.Default private Supplier<Boolean> enabled = enabledDefaultSupplier();

  public static Supplier<AccountForm> defaultObjectSupplier() {
    return () -> DEFAULT_FACTORY.get();
  }

  public static Supplier<String> nameDefaultSupplier() {
    return TestSuppliers.stringRangeSupplier(
        Locale.ENGLISH, AccountForm.NAME_MIN_LENGTH, AccountForm.NAME_MAX_LENGTH);
  }

  public static Supplier<Boolean> enabledDefaultSupplier() {
    return TestSuppliers.booleanSupplier();
  }

  public AccountForm get() {
    AccountFormBuilder builder = AccountForm.builder();
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
