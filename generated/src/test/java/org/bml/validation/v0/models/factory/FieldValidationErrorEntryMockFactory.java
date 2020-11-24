package org.bml.validation.v0.models.factory;

import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bml.validation.v0.models.FieldValidationErrorEntry;
import org.bml.validation.v0.models.FieldValidationErrorEntry.FieldValidationErrorEntryBuilder;
import org.bml.validation.v0.models.FieldValidationErrorType;
import org.bml.validation.v0.tool.TestSuppliers;

@Builder
@Accessors(fluent = true)
public class FieldValidationErrorEntryMockFactory implements Supplier<FieldValidationErrorEntry> {
  public static int MAX_GENERATED_LIST_SIZE = 50;

  public static FieldValidationErrorEntryMockFactory DEFAULT_FACTORY = builder().build();

  @Getter @Builder.Default private Supplier<String> message = messageDefaultSupplier();

  @Getter @Builder.Default
  private Supplier<FieldValidationErrorType> errors = errorsDefaultSupplier();

  public static Supplier<FieldValidationErrorEntry> defaultObjectSupplier() {
    return () -> DEFAULT_FACTORY.get();
  }

  public static Supplier<String> messageDefaultSupplier() {
    return TestSuppliers.stringRangeSupplier(
        Locale.ENGLISH,
        FieldValidationErrorEntry.MESSAGE_MIN_LENGTH,
        FieldValidationErrorEntry.MESSAGE_MAX_LENGTH);
  }

  public static Supplier<FieldValidationErrorType> errorsDefaultSupplier() {
    return new Supplier<FieldValidationErrorType>() {
      private final FieldValidationErrorType[] values = FieldValidationErrorType.values();

      private final Random random = new Random();

      public FieldValidationErrorType get() {
        return values[random.nextInt(values.length)];
      }
    };
  }

  public FieldValidationErrorEntry get() {
    FieldValidationErrorEntryBuilder builder = FieldValidationErrorEntry.builder();
    if (message != null) {
      String messageObject = message.get();
      if (messageObject != null) {
        builder.message(messageObject);
      }
    }
    if (errors != null) {
      FieldValidationErrorType errorsObject = errors.get();
      if (errorsObject != null) {
        builder.errors(errorsObject);
      }
    }
    return builder.build();
  }
}
