package org.bml.validation.v0.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.lang.Integer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bml.validation.v0.models.factory.ConflictResourceExistsResponseMockFactory;
import org.bml.validation.v0.models.factory.FieldValidationErrorEntryMockFactory;
import org.bml.validation.v0.models.factory.FieldValidationErrorMockFactory;
import org.bml.validation.v0.models.factory.FieldValidationResponseMockFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ExercisePojosTests {
  @Test
  @DisplayName(
      "Exercising ConflictResourceExistsResponse Pojo, Checking mock factory,default builders, and checking required fields")
  void exerciseConflictResourceExistsResponsePojo() throws Exception {
    excersizePojo(
        ConflictResourceExistsResponse.class, ConflictResourceExistsResponseMockFactory.class, 2);
  }

  @Test
  @DisplayName(
      "Exercising FieldValidationError Pojo, Checking mock factory,default builders, and checking required fields")
  void exerciseFieldValidationErrorPojo() throws Exception {
    excersizePojo(FieldValidationError.class, FieldValidationErrorMockFactory.class, 2);
  }

  @Test
  @DisplayName(
      "Exercising FieldValidationErrorEntry Pojo, Checking mock factory,default builders, and checking required fields")
  void exerciseFieldValidationErrorEntryPojo() throws Exception {
    excersizePojo(FieldValidationErrorEntry.class, FieldValidationErrorEntryMockFactory.class, 2);
  }

  @Test
  @DisplayName(
      "Exercising FieldValidationResponse Pojo, Checking mock factory,default builders, and checking required fields")
  void exerciseFieldValidationResponsePojo() throws Exception {
    excersizePojo(FieldValidationResponse.class, FieldValidationResponseMockFactory.class, 3);
  }

  public static void excersizePojo(
      final Class objectClass, final Class factoryClass, final Integer numFields) throws Exception {
    final Object factoryBuilder = factoryClass.getDeclaredMethod("builder").invoke(null);
    final Object factory =
        factoryBuilder.getClass().getDeclaredMethod("build").invoke(factoryBuilder);
    Method get = null;
    try {
      get = factory.getClass().getDeclaredMethod("get");
    } catch (Exception e) {
      log.error("{} caught msg={}", e.getClass().getSimpleName(), e.getMessage(), e);
      throw e;
    }
    assertThat(String.format("{}", get.getClass().getSimpleName()), get, notNullValue());
    log.debug("Using {}.{}()", factory.getClass().getSimpleName(), "get");
    Object anObject = get.invoke(factory);
    assertThat(
        String.format("%s should not be null", anObject.getClass()), anObject, notNullValue());
    List<String> requiredFields =
        (List<String>) objectClass.getDeclaredField("REQUIRED_FIELDS").get(null);
    for (String field : requiredFields) {
      Method fieldGetter = anObject.getClass().getMethod(field);
      assertThat(
          String.format("%s.%s should not be null", anObject.getClass().getName(), field),
          fieldGetter.invoke(anObject),
          notNullValue());
    }
    final Class fieldsClass =
        Arrays.asList(objectClass.getDeclaredClasses()).stream()
            .filter(clazz -> clazz.getSimpleName().equals("Fields"))
            .findFirst()
            .orElse(null);
    assertThat(fieldsClass, notNullValue());
    Field[] declaredFields = Test.class.getDeclaredFields();
    List<Field> staticFields = new ArrayList<Field>();
    for (Field field : declaredFields) {
      if (Modifier.isStatic(field.getModifiers())) {
        staticFields.add(field);
      }
    }
    Method toBuilder = anObject.getClass().getDeclaredMethod("toBuilder");
    assertThat(
        String.format("{}.{}", get.getClass().getSimpleName(), toBuilder.getName()),
        toBuilder,
        notNullValue());
    Object builder = toBuilder.invoke(anObject);
    assertThat(builder, notNullValue());
    assertThat(builder.toString(), notNullValue());
    assertThat(builder.equals(builder), is(true));
    Method build = builder.getClass().getDeclaredMethod("build");
    assertThat(
        String.format("{}.{}", get.getClass().getSimpleName(), build.getName()),
        build,
        notNullValue());
    Object aDuplicateObject = build.invoke(builder);
    assertThat(aDuplicateObject, notNullValue());
    assertThat(anObject.equals(aDuplicateObject), is(true));
    assertThat(anObject.hashCode(), is(aDuplicateObject.hashCode()));
    assertThat(anObject.equals(new Object()), is(false));
    assertThat(anObject.toString(), notNullValue());
    Object anotherObject = get.invoke(factory);
    assertThat(anObject.equals(anotherObject), is(false));
  }
}
