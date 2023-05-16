package org.framework.api.bo;

import org.framework.api.elements.comment.Comment;
import org.framework.api.elements.comment.GetCommentRequest;
import org.framework.api.elements.comment.GetCommentResponse;
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

    public GetCommentResponse postComment(GetCommentRequest getCommentRequest, String token) throws IOException, URISyntaxException, InterruptedException {
        GetCommentResponse getCommentResponse;
        getCommentResponse = CRUDComment.postComment(getCommentRequest, token);
        return getCommentResponse;
    }

    public GetCommentResponse updateComment(GetCommentRequest getCommentRequest,String token) throws IOException, URISyntaxException, InterruptedException {
        GetCommentResponse getCommentResponse;
        getCommentResponse = CRUDComment.updateComment(getCommentRequest, token);
        return getCommentResponse;
    }
    public GetCommentResponse deleteComment(GetCommentRequest getCommentRequest,String token) throws IOException, URISyntaxException, InterruptedException {
        GetCommentResponse getCommentResponse;
        getCommentResponse = CRUDComment.deleteComment(getCommentRequest, token);
        return getCommentResponse;
    }
}
