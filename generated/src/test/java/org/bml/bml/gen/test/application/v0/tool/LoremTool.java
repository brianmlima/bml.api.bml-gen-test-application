package org.bml.bml.gen.test.application.v0.tool;

import com.thedeanda.lorem.LoremIpsum;
import java.util.Locale;
import lombok.experimental.UtilityClass;

/**
 * A handy tool for generating text with a little probabilistic sugar for nullable testing.
 * Delagates Currently to com.thedeanda.lorem.LoremIpsum. <b>Locale Currently not supported</b>,
 * always defaults to Latin but api is present so current usage will not break as support for
 * Locales is added.
 */
@UtilityClass
class LoremTool {
  public static final LoremIpsum LOREM = new LoremIpsum();

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getCity().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getCity(final Locale locale) {
    return LOREM.getCity();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getCity().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetCity(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getCity(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getCountry().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getCountry(final Locale locale) {
    return LOREM.getCountry();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getCountry().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetCountry(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getCountry(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getEmail().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getEmail(final Locale locale) {
    return LOREM.getEmail();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getEmail().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetEmail(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getEmail(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getFirstName().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getFirstName(final Locale locale) {
    return LOREM.getFirstName();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getFirstName().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetFirstName(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getFirstName(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getFirstNameMale().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getFirstNameMale(final Locale locale) {
    return LOREM.getFirstNameMale();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getFirstNameMale().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetFirstNameMale(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getFirstNameMale(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getFirstNameFemale().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getFirstNameFemale(final Locale locale) {
    return LOREM.getFirstNameFemale();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getFirstNameFemale().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetFirstNameFemale(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getFirstNameFemale(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getLastName().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getLastName(final Locale locale) {
    return LOREM.getLastName();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getLastName().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetLastName(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getLastName(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getName().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getName(final Locale locale) {
    return LOREM.getName();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getName().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetName(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getName(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getNameMale().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getNameMale(final Locale locale) {
    return LOREM.getNameMale();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getNameMale().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetNameMale(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getNameMale(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getNameFemale().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getNameFemale(final Locale locale) {
    return LOREM.getNameFemale();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getNameFemale().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetNameFemale(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getNameFemale(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getTitle(count).
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getTitle(final Locale locale, final int count) {
    return LOREM.getTitle(count);
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getTitle().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param count sets the count of X
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetTitle(
      final Locale locale, final int count, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getTitle(locale, count);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getTitle(min,max).
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param min sets the minimum
   * @param max sets the maximum
   */
  public static String getTitle(final Locale locale, final int min, final int max) {
    return LOREM.getTitle(min, max);
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getTitle().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param min sets the minimum
   * @param max sets the maximum
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetTitle(
      final Locale locale, final int min, final int max, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getTitle(locale, min, max);
  }

  /**
   * Generated Method, delagates Currently to
   * com.thedeanda.lorem.LoremIpsum.getHtmlParagraphs(min,max).
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param min sets the minimum
   * @param max sets the maximum
   */
  public static String getHtmlParagraphs(final Locale locale, final int min, final int max) {
    return LOREM.getHtmlParagraphs(min, max);
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getHtmlParagraphs().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param min sets the minimum
   * @param max sets the maximum
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetHtmlParagraphs(
      final Locale locale, final int min, final int max, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getHtmlParagraphs(locale, min, max);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getParagraphs(min,max).
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param min sets the minimum
   * @param max sets the maximum
   */
  public static String getParagraphs(final Locale locale, final int min, final int max) {
    return LOREM.getParagraphs(min, max);
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getParagraphs().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param min sets the minimum
   * @param max sets the maximum
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetParagraphs(
      final Locale locale, final int min, final int max, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getParagraphs(locale, min, max);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getUrl().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getUrl(final Locale locale) {
    return LOREM.getUrl();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getUrl().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetUrl(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getUrl(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getWords(count).
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getWords(final Locale locale, final int count) {
    return LOREM.getWords(count);
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getWords().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param count sets the count of X
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetWords(
      final Locale locale, final int count, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getWords(locale, count);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getWords(min,max).
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param min sets the minimum
   * @param max sets the maximum
   */
  public static String getWords(final Locale locale, final int min, final int max) {
    return LOREM.getWords(min, max);
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getWords().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param min sets the minimum
   * @param max sets the maximum
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetWords(
      final Locale locale, final int min, final int max, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getWords(locale, min, max);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getPhone().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getPhone(final Locale locale) {
    return LOREM.getPhone();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getPhone().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetPhone(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getPhone(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getStateAbbr().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getStateAbbr(final Locale locale) {
    return LOREM.getStateAbbr();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getStateAbbr().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetStateAbbr(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getStateAbbr(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getStateFull().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getStateFull(final Locale locale) {
    return LOREM.getStateFull();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getStateFull().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetStateFull(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getStateFull(locale);
  }

  /**
   * Generated Method, delagates Currently to com.thedeanda.lorem.LoremIpsum.getZipCode().
   *
   * @param locale Currently not supported, always defaults to Latin
   */
  public static String getZipCode(final Locale locale) {
    return LOREM.getZipCode();
  }

  /**
   * Generated Method, might want a null, Use the probability parameter to get nulls
   * probabilistically Delagates Currently to com.thedeanda.lorem.LoremIpsum.getZipCode().
   *
   * @param locale Currently not supported, always defaults to Latin
   * @param probability A 0.0 to 100.0 probability the return will be null
   * @throws IllegalArgumentException if the probability argument is not between inclusive 0 - 100
   */
  public static String probNullGetZipCode(final Locale locale, final double probability) {
    if (ProbabilityTool.shouldNull(probability)) return null;
    return getZipCode(locale);
  }
}
