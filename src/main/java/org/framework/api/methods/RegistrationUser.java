package org.framework.api.methods;

import org.framework.api.elements.registration.RegistrationUserRequest;
import org.framework.api.elements.registration.RegistrationUserResponse;
import org.framework.api.elements.registration.User;
import org.testng.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RegistrationUser {
    private ObjectMapper objectMapper = new ObjectMapper();
    public RegistrationUserResponse createUser(RegistrationUserRequest registrationUserRequest) throws IOException, URISyntaxException, InterruptedException {
        String jsonBody = "{ \"username\": \"" + registrationUserRequest.getUsername() + "\", " +
                "\"email\": \"" + registrationUserRequest.getEmail() + "\", " +
                "\"password\": \"" + registrationUserRequest.getPassword() + "\" " +
                "}";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .uri(new URL("http://127.0.0.1:8000/api/auth/users/").toURI())
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 201);

        RegistrationUserResponse registrationUserResponse = new RegistrationUserResponse();
        registrationUserResponse.setCodeStatus(httpResponse.statusCode());
        System.out.println("User Response - " + httpResponse.body());
        User user = objectMapper.readValue(httpResponse.body()+ "", User.class);
        registrationUserResponse.setUser(user);

        return registrationUserResponse;
    }
}

