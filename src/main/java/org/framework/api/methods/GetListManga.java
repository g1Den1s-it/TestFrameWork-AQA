package org.framework.api.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.framework.api.elements.manga.GetMangaResponse;
import org.framework.api.elements.manga.CardManga;
import org.testng.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GetListManga {
    private ObjectMapper objectMapper = new ObjectMapper();
    public GetMangaResponse getManga() throws IOException, URISyntaxException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .uri(new URL("http://127.0.0.1:8000/manga/").toURI())
                .GET()
                .build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);

        GetMangaResponse getMangaResponse = new GetMangaResponse();
        getMangaResponse.setCodeStatus(httpResponse.statusCode());

        List<CardManga> cardManga = objectMapper.readValue(httpResponse.body() + "", new TypeReference<List<CardManga>>() {});

        getMangaResponse.setCardMangaList(cardManga);

        System.out.println("manga Response - " + httpResponse.body());

        return getMangaResponse;
    }
}
