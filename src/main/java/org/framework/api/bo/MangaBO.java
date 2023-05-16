package org.framework.api.bo;

import org.framework.api.elements.manga.GetMangaResponse;
import org.framework.api.elements.registration.RegistrationUserRequest;
import org.framework.api.elements.registration.RegistrationUserResponse;
import org.framework.api.elements.token.GetTokenResponse;
import org.framework.api.methods.CRUDComment;
import org.framework.api.methods.GetListManga;
import org.framework.api.methods.GetUserToken;
import org.framework.api.methods.RegistrationUser;

import java.io.IOException;
import java.net.URISyntaxException;

public class MangaBO {
    private CRUDComment CRUDComment = new CRUDComment();

    public RegistrationUserResponse createUser(RegistrationUserRequest registrationUserRequest) throws IOException, URISyntaxException, InterruptedException {
        RegistrationUser registrationUser = new RegistrationUser();
        RegistrationUserResponse registrationUserResponse;
        registrationUserResponse = registrationUser.createUser(registrationUserRequest);
        return registrationUserResponse;
    }

    public GetTokenResponse getToken(RegistrationUserRequest registrationUserRequest) throws IOException, URISyntaxException, InterruptedException {
        GetUserToken getUserToken = new GetUserToken();
        GetTokenResponse getTokenResponse;
        getTokenResponse = getUserToken.getToken(registrationUserRequest);
        return getTokenResponse;
    }

    public GetMangaResponse getMangaList() throws IOException, URISyntaxException, InterruptedException {
        GetListManga getListManga = new GetListManga();
        GetMangaResponse getMangaResponse;
        getMangaResponse = getListManga.getManga();
        return getMangaResponse;
    }

    public void postComment(String slugManga, String username, String text, String token) throws IOException, URISyntaxException, InterruptedException {
        CRUDComment.postComment(slugManga, username, text, token);
    }

    public void updateComment(String slugManga, String username, String text, String token, int id) throws IOException, URISyntaxException, InterruptedException {
        CRUDComment.updateComment(slugManga, username, text, token, id);
    }
    public void deleteComment(String slugManga,String token, int id) throws IOException, URISyntaxException, InterruptedException {
        CRUDComment.deleteComment(slugManga, token, id);
    }
}
