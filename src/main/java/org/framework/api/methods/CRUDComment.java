package org.framework.api.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.framework.api.elements.comment.Comment;
import org.framework.api.elements.comment.GetCommentRequest;
import org.framework.api.elements.comment.GetCommentResponse;
import org.testng.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CRUDComment {
    private ObjectMapper objectMapper = new ObjectMapper();
    private Comment comment;
    public GetCommentResponse postComment(GetCommentRequest getCommentRequest, String token) throws IOException, URISyntaxException, InterruptedException {
        String jsonBody = "{\"author\":\"" + getCommentRequest.getComment().getAuthor() +
                "\",\"manga\":\"" + getCommentRequest.getComment().getManga() +
                "\",\"body\":\"" + getCommentRequest.getComment().getBody() + "\"}";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .uri(new URL(
                        "http://127.0.0.1:8000/manga/" + getCommentRequest.getComment().getManga() + "/comment/"
                ).toURI())
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 201);

        GetCommentResponse getCommentResponse = new GetCommentResponse();
        getCommentResponse.setCodeStatus(httpResponse.statusCode());

        comment = objectMapper.readValue(httpResponse.body()+ "", Comment.class);
        System.out.println("Comment Response - " + httpResponse.body());

        getCommentResponse.setComment(comment);
        return getCommentResponse;
    }

    public GetCommentResponse updateComment(GetCommentRequest getCommentRequest, String token) throws IOException, URISyntaxException, InterruptedException {
        String jsonBody = "{\"author\":\"" + getCommentRequest.getComment().getAuthor() +
                "\",\"manga\":\"" + getCommentRequest.getComment().getManga() +
                "\",\"body\":\"" + getCommentRequest.getComment().getBody() + "\"}";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .uri(new URL(
                        "http://127.0.0.1:8000/manga/" + getCommentRequest.getComment().getManga() +
                                "/comment/" + getCommentRequest.getComment().getId() +"/"
                ).toURI())
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 205);

        GetCommentResponse getCommentResponse = new GetCommentResponse();
        getCommentResponse.setCodeStatus(httpResponse.statusCode());

        comment = objectMapper.readValue(httpResponse.body()+ "", Comment.class);
        System.out.println("Comment update Response - " + httpResponse.body());

        getCommentResponse.setComment(comment);
        return getCommentResponse;
    }
    public GetCommentResponse deleteComment(GetCommentRequest getCommentRequest,String token) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .uri(new URL(
                        "http://127.0.0.1:8000/manga/" + getCommentRequest.getComment().getManga() +
                                "/comment/" + getCommentRequest.getComment().getId() +"/delete/"
                ).toURI())
                .DELETE().build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 204);

        GetCommentResponse getCommentResponse = new GetCommentResponse();
        getCommentResponse.setCodeStatus(httpResponse.statusCode());

        return getCommentResponse;
    }
}
