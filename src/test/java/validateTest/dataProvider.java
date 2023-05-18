package validateTest;

import org.framework.api.bo.MangaBO;
import org.framework.api.elements.comment.GetCommentRequest;
import org.framework.api.elements.comment.GetCommentResponse;
import org.framework.api.elements.registration.RegistrationUserRequest;
import org.framework.api.elements.registration.RegistrationUserResponse;
import org.framework.api.elements.token.GetTokenResponse;
import org.framework.hibernate.Hibernate;
import org.framework.hibernate.UserAndComments;
import org.framework.hibernate.entities.Comment;
import org.framework.hibernate.entities.RandomUser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class dataProvider {
    private UserAndComments userAndComments = Hibernate.getUserAndCommentObjectList();
    private MangaBO mangaBO = new MangaBO();
    private List<String> tokens = new ArrayList<>();
    private int UserNum = 0;
    private int CommentNum = 0;

    @DataProvider
    public Object[][] postUsersProvider() {
        int m = 3;

        List<RandomUser> randomUserList = userAndComments.getRandomUserList();
        Object[][] res = new Object[randomUserList.size()][m];


        for (int i = 0; i < randomUserList.size(); i++) {
            RandomUser user = randomUserList.get(i);
            res[i] = new Object[]{user.getUsername(), user.getEmail(), user.getPassword()};
        }

        return res;
    }

    @DataProvider
    public Object[][] postCommentsProvider(){
        int m = 3;

        List<Comment> commentList = userAndComments.getCommentList();
        Object[][] res = new Object[commentList.size()][m];

        for(int i = 0; i < commentList.size(); i++){
            Comment comment = commentList.get(i);
            res[i] = new Object[]{comment.getAuthor(), comment.getManga(), comment.getBody()};
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
        tokens.add(getTokenResponse.getToken().getAccess());
        UserNum++;
        System.out.println("" + UserNum +"- User - DONE");
    }

    @Test(dataProvider = "postCommentsProvider", dependsOnMethods = "testPostUser")
    public void testComment(String author, String manga, String body) throws IOException, URISyntaxException, InterruptedException {
        org.framework.api.elements.comment.Comment comment = new org.framework.api.elements.comment.Comment();
        comment.setAuthor(author);
        comment.setManga(manga);
        comment.setBody(body);

        GetCommentRequest getCommentRequest = new GetCommentRequest();
        getCommentRequest.setComment(comment);
        GetCommentResponse getCommentResponse;
        getCommentResponse = mangaBO.postComment(getCommentRequest, tokens.get(CommentNum));
        Assert.assertEquals(getCommentResponse.getCodeStatus(), 201);
        CommentNum++;
        System.out.println("" + CommentNum +"- Comment - DONE");
    }
}
