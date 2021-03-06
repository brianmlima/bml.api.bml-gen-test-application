package org.bml.validation.v0.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

/**
 * Generated by API Builder - https://www.apibuilder.io Service version: 0.0.1 apibuilder 0.15.11
 * app.apibuilder.io/bml/validation/0.0.1/bml_lombok
 *
 * <p>WARNING: not all features (notably unions) and data types work with the java generator yet.
 * please contact brianmlima@gmail.com
 *
 * <p>A response object for field validation errors
 */
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@EqualsAndHashCode
@Data
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FieldValidationResponse {
  private static final long serialVersionUID = 0L;

  public static final List<String> REQUIRED_FIELDS =
      Collections.unmodifiableList(
          new LinkedList<String>(Arrays.asList(Fields.status, Fields.message, Fields.errors)));

  /** Added By getListSizeStaticFields */
  public static final int ERRORS_MIN_SIZE = 0;

  /** Added By getListSizeStaticFields */
  public static final int ERRORS_MAX_SIZE = 32;

  /** Added By getSizeStaticFields */
  public static final int MESSAGE_MIN_LENGTH = 1;

  /** Added By getSizeStaticFields */
  public static final int MESSAGE_MAX_LENGTH = 512;

  /** The response status */
  @Getter(onMethod = @__(@JsonIgnore))
  @NotNull
  @JsonProperty(value = "status", required = true)
  @JsonInclude(JsonInclude.Include.ALWAYS)
  protected Integer status;

  /** The response message */
  @Getter(onMethod = @__(@JsonIgnore))
  @NotNull
  @Size(
      min = FieldValidationResponse.MESSAGE_MIN_LENGTH,
      max = FieldValidationResponse.MESSAGE_MAX_LENGTH)
  @JsonProperty(value = "message", required = true)
  @JsonInclude(JsonInclude.Include.ALWAYS)
  protected String message;

  /** A set of field validation errors */
  @Getter(onMethod = @__(@JsonIgnore))
  @Singular
  @NotNull
  @Size(
      min = FieldValidationResponse.ERRORS_MIN_SIZE,
      max = FieldValidationResponse.ERRORS_MAX_SIZE)
  @JsonProperty(value = "errors", required = true)
  @JsonInclude(JsonInclude.Include.ALWAYS)
  protected List<FieldValidationError> errors;
}
