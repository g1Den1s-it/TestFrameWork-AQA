package APITest;

import org.framework.Listeners.AllureListener;
import org.framework.api.bo.MangaBO;
import org.framework.api.elements.manga.GetMangaResponse;
import org.framework.api.elements.registration.RegistrationUserRequest;
import org.framework.api.elements.registration.RegistrationUserResponse;
import org.framework.api.elements.token.GetTokenResponse;
import org.framework.api.methods.GetUserToken;
import org.testng.annotations.Listeners;
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

        //set commnet to this manga
        String text = "Perfecto";
        mangaBO.postComment(
                getMangaResponse.getCardMangaList().get(1).getSlug(),
                registrationUserResponse.getUser().getUsername(),
                text,
                getTokenResponse.getToken().getAccess()
                );

        //update
        mangaBO.updateComment(
                getMangaResponse.getCardMangaList().get(1).getSlug(),
                registrationUserResponse.getUser().getUsername(),
                text,
                getTokenResponse.getToken().getAccess(),
                11
        );

        //delete
        mangaBO.deleteComment(
                getMangaResponse.getCardMangaList().get(1).getSlug(),
                getTokenResponse.getToken().getAccess(),
                11
        );
    }

}
