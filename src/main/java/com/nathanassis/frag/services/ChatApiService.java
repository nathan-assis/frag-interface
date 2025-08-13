package com.nathanassis.frag.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nathanassis.frag.dto.ApiResponse;
import com.nathanassis.frag.utils.Constants;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public final class ChatApiService {
  private static final HttpClient client = HttpClient.newHttpClient();
  private static final ObjectMapper mapper = new ObjectMapper();

  private ChatApiService() {}

  public static CompletableFuture<ApiResponse> sendMessage(String message) {
    String jsonBody = "{\"text\":\"" + message + "\"}";

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(Constants.CHAT_API_URL))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
            .build();

    return client
        .sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenCompose(
            response -> {
              int status = response.statusCode();
              String body = response.body();
              if (status >= 200 && status < 300) {
                try {
                  ApiResponse apiResponse = mapper.readValue(body, ApiResponse.class);
                  return CompletableFuture.completedFuture(apiResponse);
                } catch (Exception e) {
                  CompletableFuture<ApiResponse> failed = new CompletableFuture<>();
                  failed.completeExceptionally(e);
                  return failed;
                }
              } else {
                CompletableFuture<ApiResponse> failed = new CompletableFuture<>();
                failed.completeExceptionally(new IOException("HTTP " + status + ": " + body));
                return failed;
              }
            });
  }
}
