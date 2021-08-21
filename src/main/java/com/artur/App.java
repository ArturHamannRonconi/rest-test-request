package com.artur;

import java.net.URI;
import java.net.http.*;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;;

public class App
{
  public HttpResponse<String> get(String url)
  {
    HttpClient client = null;
    HttpRequest request = null;
    HttpResponse<String> response = null;

    try {
      client = HttpClient.newBuilder().build();
      request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(url))
        .timeout(Duration.ofSeconds(5))
        .build();

      response = client.send(request, BodyHandlers.ofString());      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return response;
  }
  public HttpResponse<String> get(String url, String... headers)
  {
    HttpClient client = null;
    HttpRequest request = null;
    HttpResponse<String> response = null;

    try {
      client = HttpClient.newBuilder().build();
      request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(url))
        .timeout(Duration.ofSeconds(5))
        .headers(headers)
        .build();

      response = client.send(request, BodyHandlers.ofString());      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return response;
  }

  public HttpResponse<String> post(String url, String bodyJson)
  {
    HttpClient client = null;
    HttpRequest request = null;
    HttpResponse<String> response = null;

    try {
      client = HttpClient.newBuilder().build();
      request = HttpRequest.newBuilder()
        .POST(BodyPublishers.ofString(bodyJson))
        .header("Content-Type", "application/json")
        .uri(URI.create(url))
        .timeout(Duration.ofSeconds(5))
        .build();

      response = client.send(request, BodyHandlers.ofString());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return response;
  }
}
