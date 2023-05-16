package org.framework.api.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CRUDComment {
    private ObjectMapper objectMapper = new ObjectMapper();
    public void postComment(String slugManga, String username, String text, String token) throws IOException, URISyntaxException, InterruptedException {
        String jsonBody = "{\"author\":\"" + username + "\",\"manga\":\"" + slugManga + "\",\"body\":\"" + text + "\"}";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .uri(new URL(
                        "http://127.0.0.1:8000/manga/" + slugManga + "/comment/"
                ).toURI())
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 201);
    }

    public void updateComment(String slugManga, String username, String text, String token, int id) throws IOException, URISyntaxException, InterruptedException {
        String jsonBody = "{\"author\":\"" + username + "\",\"manga\":\"" + slugManga + "\",\"body\":\"" + text + "\"}";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .uri(new URL(
                        "http://127.0.0.1:8000/manga/" + slugManga + "/comment/" + id +"/"
                ).toURI())
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 205);
    }
    public void deleteComment(String slugManga,String token, int id) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .uri(new URL(
                        "http://127.0.0.1:8000/manga/" + slugManga + "/comment/" + id +"/delete/"
                ).toURI())
                .DELETE().build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 204);
    }
}
