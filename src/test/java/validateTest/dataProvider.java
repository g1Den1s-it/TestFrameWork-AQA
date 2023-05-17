package validateTest;

import org.framework.api.bo.MangaBO;
import org.framework.api.elements.registration.RegistrationUserRequest;
import org.framework.api.elements.registration.RegistrationUserResponse;
import org.framework.api.elements.token.GetTokenResponse;
import org.framework.hibernate.Hibernate;
import org.framework.hibernate.UserAndComments;
import org.framework.hibernate.entities.RandomUser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

public class dataProvider {
    private UserAndComments userAndComments = Hibernate.getUserAndCommentObjectList();
    private MangaBO mangaBO = new MangaBO();
    private Object[][] tokens = new Object[10][1];
    private int num = 0;

    @DataProvider
    public Object[][] postUsersProvider() {
        int n = 10;
        int m = 3;

        Object[][] res = new Object[n][m];
        List<RandomUser> randomUserList = userAndComments.getRandomUserList();

        for (int i = 0; i < randomUserList.size(); i++) {
            RandomUser user = randomUserList.get(i);
            res[i] = new Object[]{user.getUsername(), user.getEmail(), user.getPassword()};
        }

        return res;
    }

    @Test(dataProvider = "postUsersProvider")
    public void testPostUser(String username, String email, String password) throws IOException, URISyntaxException, InterruptedException {
        RegistrationUserRequest registrationUserRequest = new RegistrationUserRequest();
        registrationUserRequest.setUsername(username);
        registrationUserRequest.setEmail(email);
        registrationUserRequest.setPassword(password);


        RegistrationUserResponse registrationUserResponse  = mangaBO.createUser(registrationUserRequest);
        Assert.assertEquals(registrationUserResponse.getCodeStatus(),201);
        GetTokenResponse getTokenResponse = mangaBO.getToken(registrationUserRequest);
        Assert.assertEquals(getTokenResponse.getCodeStatus(), 200);
        tokens[num++] = new Object[]{getTokenResponse.getToken().getAccess()};
        System.out.println("" + num +" - " + getTokenResponse.getToken().getAccess());
    }

}
