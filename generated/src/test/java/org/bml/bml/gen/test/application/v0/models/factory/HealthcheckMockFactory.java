package org.bml.bml.gen.test.application.v0.models.factory;

import java.util.Locale;
import java.util.function.Supplier;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bml.bml.gen.test.application.v0.models.Healthcheck;
import org.bml.bml.gen.test.application.v0.models.Healthcheck.HealthcheckBuilder;
import org.bml.bml.gen.test.application.v0.tool.TestSuppliers;

@Builder
@Accessors(fluent = true)
public class HealthcheckMockFactory implements Supplier<Healthcheck> {
  public static int MAX_GENERATED_LIST_SIZE = 50;

  public static HealthcheckMockFactory DEFAULT_FACTORY = builder().build();

  @Getter @Builder.Default private Supplier<String> status = statusDefaultSupplier();

  public static Supplier<Healthcheck> defaultObjectSupplier() {
    return () -> DEFAULT_FACTORY.get();
  }

  public static Supplier<String> statusDefaultSupplier() {
    return TestSuppliers.stringRangeSupplier(
        Locale.ENGLISH, Healthcheck.STATUS_MIN_LENGTH, Healthcheck.STATUS_MAX_LENGTH);
  }

  public Healthcheck get() {
    HealthcheckBuilder builder = Healthcheck.builder();
    if (status != null) {
      String statusObject = status.get();
      if (statusObject != null) {
        builder.status(statusObject);
      }
    }
    return builder.build();
  }
}
