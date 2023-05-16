package org.framework.api.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.framework.api.elements.registration.RegistrationUserRequest;
import org.framework.api.elements.registration.User;
import org.framework.api.elements.token.GetTokenResponse;
import org.framework.api.elements.token.Token;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetUserToken {
    private ObjectMapper objectMapper = new ObjectMapper();
    public GetTokenResponse getToken(RegistrationUserRequest registrationUserRequest) throws IOException, URISyntaxException, InterruptedException {
        String jsonBody = "{ \"username\": \"" + registrationUserRequest.getUsername() + "\", " +
                "\"password\": \"" + registrationUserRequest.getPassword() + "\" " +
                "}";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .uri(new URL("http://127.0.0.1:8000/api/token/").toURI())
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);

        GetTokenResponse getTokenResponse = new GetTokenResponse();
        getTokenResponse.setCodeStatus(httpResponse.statusCode());

        Token token = objectMapper.readValue(httpResponse.body()+ "", Token.class);
        System.out.println("Token Response - " + httpResponse.body());

        getTokenResponse.setToken(token);
        return getTokenResponse;
    }
}
