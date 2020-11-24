package org.bml.bml.gen.test.application.v0.tool;

import java.lang.IllegalArgumentException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomUtils;

@UtilityClass
public class ProbabilityTool {
  /**
   * Generated Method, also checks probability for range violation.
   *
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static boolean shouldNull(final double probability) {
    if (probability > 100 || probability < 0)
      throw new IllegalArgumentException(
          "probParam must be between 0 and 100 found " + probability);
    return RandomUtils.nextDouble(0, 100) <= probability;
  }

  /**
   * Generated Method, throws java.lang.IllegalArgumentException if probability argument is not
   * between inclusive 0 - 100
   *
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static void checkProbParamMethod(final double probability) {
    if (probability > 100 || probability < 0)
      throw new IllegalArgumentException(
          String.format("probParam must be between 0 and 100 found %s", probability));
  }
}
