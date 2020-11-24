package org.bml.validation.v0.models.factory;

import java.util.Locale;
import java.util.function.Supplier;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bml.validation.v0.models.ConflictResourceExistsResponse;
import org.bml.validation.v0.models.ConflictResourceExistsResponse.ConflictResourceExistsResponseBuilder;
import org.bml.validation.v0.tool.TestSuppliers;

@Builder
@Accessors(fluent = true)
public class ConflictResourceExistsResponseMockFactory
    implements Supplier<ConflictResourceExistsResponse> {
  public static int MAX_GENERATED_LIST_SIZE = 50;

  public static ConflictResourceExistsResponseMockFactory DEFAULT_FACTORY = builder().build();

  @Getter @Builder.Default private Supplier<Integer> status = statusDefaultSupplier();

  @Getter @Builder.Default private Supplier<String> message = messageDefaultSupplier();

  public static Supplier<ConflictResourceExistsResponse> defaultObjectSupplier() {
    return () -> DEFAULT_FACTORY.get();
  }

  public static Supplier<Integer> statusDefaultSupplier() {
    return TestSuppliers.integerSupplier();
  }

  public static Supplier<String> messageDefaultSupplier() {
    return TestSuppliers.stringRangeSupplier(
        Locale.ENGLISH,
        ConflictResourceExistsResponse.MESSAGE_MIN_LENGTH,
        ConflictResourceExistsResponse.MESSAGE_MAX_LENGTH);
  }

  public ConflictResourceExistsResponse get() {
    ConflictResourceExistsResponseBuilder builder = ConflictResourceExistsResponse.builder();
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
    return builder.build();
  }
}
