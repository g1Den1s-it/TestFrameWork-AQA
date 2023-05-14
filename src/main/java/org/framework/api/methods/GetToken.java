package org.framework.api.methods;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class GetToken {

    public String getSpotifyToken(String clientId, String clientSecret, String redirectUri, String code) {
        String tokenUrl = "https://accounts.spotify.com/api/token";
        HttpClient client = HttpClient.newHttpClient();

        // Build the request body
        String requestBody = "grant_type=authorization_code" +
                "&code=" + code +
                "&redirect_uri=" + redirectUri;

        // Build the request headers
        String auth = clientId + ":" + clientSecret;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + new String(encodedAuth);

        // Build the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(tokenUrl))
                .header("Authorization", authHeader)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Send the HTTP request and get the response
        HttpResponse<String> response;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }

        // Parse the response JSON and extract the access token
        String responseBody = response.body();
        String accessToken = "";
        try {
            JSONObject jsonObject = new JSONObject(responseBody);
            accessToken = jsonObject.getString("access_token");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        // Return the access token
        return accessToken;
    }
}

