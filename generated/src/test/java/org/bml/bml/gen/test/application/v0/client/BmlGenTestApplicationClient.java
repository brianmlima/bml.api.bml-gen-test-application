package org.bml.bml.gen.test.application.v0.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.bml.bml.gen.test.application.v0.models.Account;
import org.bml.validation.v0.models.FieldValidationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Accessors(fluent = true)
@Slf4j
public class BmlGenTestApplicationClient {
  @Getter private Config config;

  @Getter private AccountClient account;

  public BmlGenTestApplicationClient(final Config config) {
    this.config = config;
    this.account = new AccountClient(config);
  }

  private static final <T> Optional<T> read(
      final ObjectMapper objectMapper, final String content, final Class<T> clazz) {
    try {
      return Optional.of(objectMapper.readValue(content, clazz));
    } catch (IOException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  private static final <T> Optional<T> read(
      final ObjectMapper objectMapper, final String content, final TypeReference<T> clazz) {
    try {
      return Optional.of(objectMapper.readValue(content, clazz));
    } catch (IOException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  @Builder
  @Accessors(fluent = true)
  public static class Config {
    @Getter @NotNull private final WebClient webClient;

    @Getter @NotNull private final URI baseUri;

    @Getter @NotNull private final ObjectMapper objectMapper;
  }

  @Builder
  @Accessors(fluent = true)
  public static class ResponseModel<T> {
    @Getter @NotNull private final HttpStatus httpStatus;

    @Getter @NotNull private final ClientResponse.Headers headers;

    @Getter @NotNull private final T body;
  }

  @Accessors(fluent = true)
  @Slf4j
  public static class AccountClient {
    @Getter private Config config;

    @Getter private final GetAccountById getAccountById;

    public AccountClient(final Config config) {
      this.config = config;
      this.getAccountById = new GetAccountById(config);
    }

    public static class GetAccountById {
      @Getter private Config config;

      public GetAccountById(final Config config) {
        this.config = config;
      }

      public Mono<ResponseModel<BodyModel>> getAsync(final UUID id)
          throws URISyntaxException, UnsupportedEncodingException {
        return getAsync(config, id);
      }

      public static Mono<ResponseModel<BodyModel>> getAsync(final Config config, final UUID id)
          throws URISyntaxException, UnsupportedEncodingException {
        /** Encode url path paramters */
        final String idEncoded = URLEncoder.encode(id.toString(), "UTF-8");
        final String path = String.format("/v0/accounts/%s", idEncoded);
        final URI uri = new URI(config.baseUri().toString() + path);
        final Mono<ClientResponse> exchange =
            config.webClient().get().uri(uri).acceptCharset(StandardCharsets.UTF_8).exchange();
        return exchange.flatMap(
            (ClientResponse responseIn) -> {
              val httpStatusIn = responseIn.statusCode();
              val responseOut =
                  ResponseModel.<BodyModel>builder()
                      .httpStatus(httpStatusIn)
                      .headers(responseIn.headers());
              val bodyOut = BodyModel.builder();
              switch (httpStatusIn.value()) {
                case 200:
                  return responseIn
                      .bodyToMono(String.class)
                      .map(
                          (content) ->
                              responseOut
                                  .body(
                                      bodyOut
                                          .account200(
                                              read(config.objectMapper(), content, Account.class))
                                          .build())
                                  .build());
                case 400:
                  return responseIn
                      .bodyToMono(String.class)
                      .map(
                          (content) ->
                              responseOut
                                  .body(
                                      bodyOut
                                          .fieldValidationResponse400(
                                              read(
                                                  config.objectMapper(),
                                                  content,
                                                  FieldValidationResponse.class))
                                          .build())
                                  .build());
                case 401:
                  return Mono.create(
                      (sink) ->
                          sink.success(
                              responseOut
                                  .body(bodyOut.unit401(Optional.of(true)).build())
                                  .build()));
                case 404:
                  return Mono.create(
                      (sink) ->
                          sink.success(
                              responseOut
                                  .body(bodyOut.unit404(Optional.of(true)).build())
                                  .build()));
                default:
                  return responseIn
                      .bodyToMono(String.class)
                      .map(
                          (content) ->
                              responseOut
                                  .body(bodyOut.unexpected(Optional.of(content)).build())
                                  .build());
              }
            });
      }

      @Builder(toBuilder = true)
      @Accessors(fluent = true)
      public static class BodyModel {
        @Getter(onMethod = @__(@JsonIgnore))
        Optional<Account> account200 = Optional.empty();

        @Getter(onMethod = @__(@JsonIgnore))
        Optional<FieldValidationResponse> fieldValidationResponse400 = Optional.empty();

        @Getter(onMethod = @__(@JsonIgnore))
        Optional<Boolean> unit401 = Optional.empty();

        @Getter(onMethod = @__(@JsonIgnore))
        Optional<Boolean> unit404 = Optional.empty();

        @Getter(onMethod = @__(@JsonIgnore))
        Optional<String> unexpected = Optional.empty();
      }
    }
  }
}
