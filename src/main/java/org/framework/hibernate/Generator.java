package org.framework.hibernate;

import org.apache.commons.lang3.RandomStringUtils;
import org.framework.hibernate.entities.Comment;
import org.framework.hibernate.entities.RandomUser;

import java.util.Random;

public class Generator {
    private static final String[] domains = {"example.com", "test.com", "demo.com"};

    public RandomUser generateRandomUser() {
        RandomUser randomUser = new RandomUser();

        // Generate random domain
        int domainIndex = getRandomIndex(domains.length);

        // Generate unique username
        String uniqueId = generateUniqueId();
        String username = "user_" + uniqueId;
        randomUser.setUsername(username);

        // Set random values for email and password
//        user.setId();
        randomUser.setEmail(username + "@" + domains[domainIndex]);
        randomUser.setPassword(generateRandomPassword());

        return randomUser;
    }

    private static int getRandomIndex(int max) {
        return (int) (Math.random() * max);
    }

    private static String generateUniqueId() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    private static String generateRandomPassword() {
        int passwordLength = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        boolean useSymbols = false;
        String generatedPassword = RandomStringUtils.random(passwordLength, useLetters, useNumbers);
        return generatedPassword;
    }


    public Comment randomComment(String username, String manga){
        Random random = new Random();

        Comment comment = new Comment();
        comment.setManga(manga);
        comment.setAuthor(username);

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(56);

        for (int i = 0; i < 56; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }
        comment.setBody(sb.toString());

        return comment;
    }
}
