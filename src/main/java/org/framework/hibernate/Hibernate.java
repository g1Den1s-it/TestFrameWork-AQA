package org.framework.hibernate;

import org.framework.api.bo.MangaBO;
import org.framework.hibernate.entities.Comment;
import org.framework.hibernate.entities.RandomUser;
import org.hibernate.Session;

import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.framework.hibernate.HibernateUtil.getSessionFactory;

//        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
//        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.ALL);
//        java.util.logging.Logger.getLogger("org.hibernate.SQL").setLevel(java.util.logging.Level.ALL);
//        java.util.logging.Logger.getLogger("org.hibernate.type.descriptor.sql.BasicBinder").setLevel(java.util.logging.Level.ALL);

public class Hibernate {
    private static Generator generator = new Generator();
    private static Session session = getSessionFactory().getCurrentSession();
    public static void main(String[] args) {
        session.beginTransaction();


        //Create users and push to the test database
        int n = 10;
        RandomUser user;
        for(int i = 0; i <= n; i++){
            user = generator.generateRandomUser();
            if(isValid(user)){
                session.saveOrUpdate(user);
                //System.out.println("valid: " + user.getUsername() + " " + user.getPassword() + "  " + user.getEmail());
            }
        }
        //Create comments and push to the test database
        String manga = "otome-kaijuu-caramelize";
        Comment comment;
        Query query = session.createNativeQuery("SELECT username FROM random_user");
        List<String> users = query.getResultList();
        for(String queryUser : users){
            String username = (String) queryUser;
            comment = generator.randomComment(username, manga);
            session.save(comment);
        }

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
    public static UserAndComments getUserAndCommentObjectList(){
        session.beginTransaction();

        UserAndComments userAndComments = new UserAndComments();
        //get user fields
        Query userQuery = session.createNativeQuery("SELECT id, username, email, password, is_valid FROM random_user");
        List<Object[]> result = userQuery.getResultList();
        List<RandomUser> randomUsersList = new ArrayList<>();
        for (Object[] row : result) {
            BigInteger id = (BigInteger) row[0];
            String username = (String) row[1];
            String email = (String) row[2];
            String password = (String) row[3];
            Boolean isValid = (Boolean) row[4];

            RandomUser randomUser = new RandomUser();
            randomUser.setId(id);
            randomUser.setUsername(username);
            randomUser.setEmail(email);
            randomUser.setPassword(password);
            randomUser.setIsValid(isValid);

            randomUsersList.add(randomUser);
        }



        userAndComments.setRandomUserList(randomUsersList);
        //get comment fields
        Query commentQuery = session.createNativeQuery("SELECT id, manga, author, body, is_valid FROM comment");
        List<Comment> commentList = commentQuery.getResultList();
        userAndComments.setCommentList(commentList);

        session.getTransaction().commit();
        session.close();

        return userAndComments;
    }
    public static boolean isValid(RandomUser randomUser) {
        final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        final String USERNAME_REGEX = "^[A-Za-z0-9_-]{3,}$";
        final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

        final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
        final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);
        final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

        if (randomUser.getPassword() == null || randomUser.getEmail() == null || randomUser.getUsername() == null) {
            return false;
        }

        Matcher emailMatcher = EMAIL_PATTERN.matcher(randomUser.getEmail());
        Matcher usernameMatcher = USERNAME_PATTERN.matcher(randomUser.getUsername());
        Matcher passwordMatcher = PASSWORD_PATTERN.matcher(randomUser.getPassword());
        return emailMatcher.matches() && usernameMatcher.matches() && passwordMatcher.matches();
    }
}
