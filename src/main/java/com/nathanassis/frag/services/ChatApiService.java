package com.nathanassis.frag.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

import com.nathanassis.frag.utils.Constants;

public final class ChatApiService {
    private static final HttpClient client = HttpClient.newHttpClient();

    private ChatApiService() {
    }

    public static CompletableFuture<String> sendMessage(String message) {
        String jsonBody = "{\"text\":\"" + message + "\"}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Constants.CHAT_API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenCompose(response -> {
                    int status = response.statusCode();
                    String body = response.body();
                    if (status >= 200 && status < 300) {
                        return CompletableFuture.completedFuture(body);
                    } else {
                        CompletableFuture<String> failed = new CompletableFuture<>();
                        failed.completeExceptionally(
                                new IOException("HTTP " + status + ": " + body));
                        return failed;
                    }
                });
    }
}
