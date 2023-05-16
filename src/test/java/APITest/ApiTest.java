package APITest;


import org.framework.api.bo.MangaBO;
import org.framework.api.elements.comment.Comment;
import org.framework.api.elements.comment.GetCommentRequest;
import org.framework.api.elements.comment.GetCommentResponse;
import org.framework.api.elements.manga.GetMangaResponse;
import org.framework.api.elements.registration.RegistrationUserRequest;
import org.framework.api.elements.registration.RegistrationUserResponse;
import org.framework.api.elements.token.GetTokenResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class ApiTest {
    private MangaBO mangaBO = new MangaBO();

    @Test
    public void EndToEndApiTest() throws IOException, URISyntaxException, InterruptedException {
        //registration
        RegistrationUserRequest registrationUserRequest = new RegistrationUserRequest();
        registrationUserRequest.setUsername("LEEqwe");
        registrationUserRequest.setEmail("leeqwe@lee.com");
        registrationUserRequest.setPassword("Q1w2e3r4t5y6_");

        RegistrationUserResponse registrationUserResponse;
        registrationUserResponse = mangaBO.createUser(registrationUserRequest);

        //get token
        GetTokenResponse getTokenResponse;
        getTokenResponse = mangaBO.getToken(registrationUserRequest);

        //get list of manga
        GetMangaResponse getMangaResponse;
        getMangaResponse = mangaBO.getMangaList();

        //set comment to this manga
        String text = "Perfecto";

        Comment commentRequest = new Comment();
        commentRequest.setAuthor(registrationUserResponse.getUser().getUsername());
        commentRequest.setBody(text);
        commentRequest.setManga(getMangaResponse.getCardMangaList().get(1).getSlug());

        GetCommentRequest getCommentRequest = new GetCommentRequest();
        getCommentRequest.setComment(commentRequest);
        getCommentRequest.setCodeStatus(201);

        GetCommentResponse getCommentResponse =  mangaBO.postComment(getCommentRequest, getTokenResponse.getToken().getAccess());
        //tests
        Assert.assertEquals(getCommentResponse.getCodeStatus(), getCommentRequest.getCodeStatus());
        Assert.assertEquals(getCommentResponse.getComment().getAuthor(), getCommentRequest.getComment().getAuthor());
        Assert.assertEquals(getCommentResponse.getComment().getManga(), getCommentRequest.getComment().getManga());
        Assert.assertEquals(getCommentResponse.getComment().getBody(), getCommentRequest.getComment().getBody());

        //update
        getCommentRequest.setComment(getCommentResponse.getComment());
        getCommentRequest.getComment().setBody("new text which i want to write");

        mangaBO.updateComment(getCommentRequest, getTokenResponse.getToken().getAccess());
        //tests
        Assert.assertEquals(getCommentResponse.getCodeStatus(), getCommentRequest.getCodeStatus());
        Assert.assertEquals(getCommentResponse.getComment().getAuthor(), getCommentRequest.getComment().getAuthor());
        Assert.assertEquals(getCommentResponse.getComment().getManga(), getCommentRequest.getComment().getManga());
        Assert.assertEquals(getCommentResponse.getComment().getBody(), getCommentRequest.getComment().getBody());

        //delete

        getCommentResponse = mangaBO.deleteComment(getCommentRequest, getTokenResponse.getToken().getAccess());
        //tests
        Assert.assertEquals(getCommentResponse.getCodeStatus(), 204);
    }

}
