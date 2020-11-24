package org.bml.validation.v0.models.factory;

import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bml.validation.v0.models.FieldValidationError;
import org.bml.validation.v0.models.FieldValidationResponse;
import org.bml.validation.v0.models.FieldValidationResponse.FieldValidationResponseBuilder;
import org.bml.validation.v0.tool.TestSuppliers;

@Builder
@Accessors(fluent = true)
public class FieldValidationResponseMockFactory implements Supplier<FieldValidationResponse> {
  public static int MAX_GENERATED_LIST_SIZE = 50;

  public static FieldValidationResponseMockFactory DEFAULT_FACTORY = builder().build();

  @Getter @Builder.Default private Supplier<Integer> status = statusDefaultSupplier();

  @Getter @Builder.Default private Supplier<String> message = messageDefaultSupplier();

  @Getter @Builder.Default
  private Supplier<List<FieldValidationError>> errors = errorsDefaultSupplier();

  public static Supplier<FieldValidationResponse> defaultObjectSupplier() {
    return () -> DEFAULT_FACTORY.get();
  }

  public static Supplier<Integer> statusDefaultSupplier() {
    return TestSuppliers.integerSupplier();
  }

  public static Supplier<String> messageDefaultSupplier() {
    return TestSuppliers.stringRangeSupplier(
        Locale.ENGLISH,
        FieldValidationResponse.MESSAGE_MIN_LENGTH,
        FieldValidationResponse.MESSAGE_MAX_LENGTH);
  }

  public static Supplier<List<FieldValidationError>> errorsDefaultSupplier() {
    return TestSuppliers.listSupplier(FieldValidationErrorMockFactory.DEFAULT_FACTORY, 32);
  }

  public FieldValidationResponse get() {
    FieldValidationResponseBuilder builder = FieldValidationResponse.builder();
    if (status != null) {
      Integer statusObject = status.get();
      if (statusObject != null) {
        builder.status(statusObject);
      }
    }
    if (message != null) {
      String messageObject = message.get();
      if (messageObject != null) {
        builder.message(messageObject);
      }
    }
    if (errors != null) {
      List<FieldValidationError> errorsObject = errors.get();
      if (errorsObject != null) {
        builder.errors(errorsObject);
      }
    }
    return builder.build();
  }
}
