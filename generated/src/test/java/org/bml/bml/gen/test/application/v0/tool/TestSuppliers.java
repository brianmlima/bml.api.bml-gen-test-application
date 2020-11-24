package org.bml.bml.gen.test.application.v0.tool;

import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Math;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
public class TestSuppliers {
  public static <T> Supplier<T> recallSupplier(final Supplier<T> supplier) {
    return new RecallSupplier(supplier);
  }

  public static <T> ProbabilityNullSupplier<T> wrapProbNull(
      final Supplier<T> supplier, final double probability) {
    return new ProbabilityNullSupplier(supplier, probability);
  }

  public static <T> Supplier<List<T>> listSupplier(final Supplier<T> supplier, final int maxSize) {
    return new ListSupplier(supplier, maxSize);
  }

  public static Supplier<String> stringRangeSupplier(
      final Locale locale, final int min, final int max) {
    if (max < min)
      throw new IllegalArgumentException(
          String.format("max param can not be less than min param. min={} max={}", min, max));
    if (min == 0 && max == 0)
      throw new IllegalArgumentException("max param and min param can not both be 0");
    if (min < 0)
      throw new IllegalArgumentException(
          String.format("min aram can not be less than 0. min={} max={}", min, max));
    if (max < 0)
      throw new IllegalArgumentException(
          String.format("max aram can not be less than 0. min={} max={}", min, max));
    return () -> {
      int requestWordCount = (int) Math.ceil(max / Languages.ENGLISH_AVG_WORD_LENGTH);
      final String[] words = LoremTool.getWords(locale, requestWordCount).split("[ ]");
      final int randStringLength = RandomUtils.nextInt(min, max);
      final StringBuilder buff = new StringBuilder();
      for (String word : words) {
        if (buff.length() <= randStringLength) {
          buff.append(' ').append(word);
        } else {
          break;
        }
      }
      String returnValue =
          (buff.length() > randStringLength)
              ? buff.toString().substring(0, randStringLength).trim()
              : buff.toString().trim();
      log.trace("Returning Lorem String length={} text=\"{}\"", returnValue.length(), returnValue);
      return returnValue;
    };
  }

  public static Supplier<UUID> UUIDSupplier() {
    return new UUIDSupplier();
  }

  public static Supplier<Boolean> booleanSupplier() {
    return new BooleanSupplier();
  }

  public static Supplier<LocalDate> localDateSupplier() {
    return new LocalDateSupplier();
  }

  public static Supplier<Integer> integerSupplier() {
    return new IntegerSupplier();
  }

  public static class BooleanSupplier implements Supplier<Boolean> {
    Random random = new Random();

    public Boolean get() {
      return random.nextBoolean();
    }
  }

  @Accessors(fluent = true)
  public static class RecallSupplier<T> implements Supplier<T> {
    @Getter private final Supplier<T> supplier;

    @Getter private T lastValue;

    public RecallSupplier(final Supplier<T> supplier) {
      this.supplier = supplier;
    }

    public T get() {
      lastValue = supplier.get();
      return lastValue;
    }
  }

  @Accessors(fluent = true)
  public static class ProbabilityNullSupplier<T> implements Supplier<T> {
    @Getter private final Supplier<T> supplier;

    /** A 0.0 to 100.0 probability the return will be null */
    @Getter private final double probability;

    public ProbabilityNullSupplier(final Supplier<T> supplier, final double probability) {
      this.supplier = supplier;
      this.probability = probability;
    }

    public T get() {
      if (ProbabilityTool.shouldNull(probability)) return null;
      T result = supplier.get();
      log.trace("Returning {} class instance={}", result.getClass().getSimpleName(), result);
      return result;
    }
  }

  public static class LocalDateSupplier implements Supplier<LocalDate> {
    Random random = new Random();

    public LocalDate get() {
      long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
      long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
      long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
      return LocalDate.ofEpochDay(randomDay);
    }
  }

  public static class IntegerSupplier implements Supplier<Integer> {
    Random random = new Random();

    public Integer get() {
      return random.nextInt();
    }
  }

  public static class UUIDSupplier implements Supplier<UUID> {
    public UUID get() {
      return UUID.randomUUID();
    }
  }

  public static class ListSupplier<T> implements Supplier<List<T>> {
    private final Supplier<T> supplier;

    private final int maxSize;

    Random random = new Random();

    public ListSupplier(final Supplier<T> supplier, final int maxSize) {
      this.supplier = supplier;
      this.maxSize = maxSize;
    }

    /**
     * WARNING: we are catching an exception to fix the recursion bug in models that refrence
     * themselves.
     */
    public List<T> get() {
      int size = random.nextInt(maxSize);
      List<T> list = new ArrayList<T>(maxSize);
      try {
        for (int c = 1; c < size; c++) {
          list.add(supplier.get());
        } // WARNING: we are catching an exception to fix the recursion bug in models that refrence
          // themselves.
      } catch (Exception e) {
        return list;
      }
      return list;
    }
  }
}
