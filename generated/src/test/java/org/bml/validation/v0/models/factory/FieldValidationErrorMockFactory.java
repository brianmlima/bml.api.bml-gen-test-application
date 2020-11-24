package org.bml.validation.v0.models.factory;

import java.util.Locale;
import java.util.function.Supplier;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bml.validation.v0.models.FieldValidationError;
import org.bml.validation.v0.models.FieldValidationError.FieldValidationErrorBuilder;
import org.bml.validation.v0.tool.TestSuppliers;

@Builder
@Accessors(fluent = true)
public class FieldValidationErrorMockFactory implements Supplier<FieldValidationError> {
  public static int MAX_GENERATED_LIST_SIZE = 50;

  public static FieldValidationErrorMockFactory DEFAULT_FACTORY = builder().build();

  @Getter @Builder.Default private Supplier<String> path = pathDefaultSupplier();

  @Getter @Builder.Default private Supplier<String> message = messageDefaultSupplier();

  public static Supplier<FieldValidationError> defaultObjectSupplier() {
    return () -> DEFAULT_FACTORY.get();
  }

  public static Supplier<String> pathDefaultSupplier() {
    return TestSuppliers.stringRangeSupplier(
        Locale.ENGLISH, FieldValidationError.PATH_MIN_LENGTH, FieldValidationError.PATH_MAX_LENGTH);
  }

  public static Supplier<String> messageDefaultSupplier() {
    return TestSuppliers.stringRangeSupplier(
        Locale.ENGLISH,
        FieldValidationError.MESSAGE_MIN_LENGTH,
        FieldValidationError.MESSAGE_MAX_LENGTH);
  }

  public FieldValidationError get() {
    FieldValidationErrorBuilder builder = FieldValidationError.builder();
    if (path != null) {
      String pathObject = path.get();
      if (pathObject != null) {
        builder.path(pathObject);
      }
    }
    if (message != null) {
      String messageObject = message.get();
      if (messageObject != null) {
        builder.message(messageObject);
      }
    }
    return builder.build();
  }
}
