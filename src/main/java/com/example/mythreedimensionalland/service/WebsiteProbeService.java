package com.example.mythreedimensionalland.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author bjingban
 * @date 2026-09-29 23:45
 */
@Service
public class WebsiteProbeService {
    HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(3))
            .followRedirects(HttpClient.Redirect.NEVER)
            .build();

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://github.com"))
            .timeout(Duration.ofSeconds(5))
            .GET()
            .build();



    public void get() throws IOException, InterruptedException {
        long start = System.nanoTime();
        HttpResponse<InputStream> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofInputStream()
        );

        long elapseMs =
                TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);

        response.body().close();
        System.out.println(elapseMs);

    }
}
