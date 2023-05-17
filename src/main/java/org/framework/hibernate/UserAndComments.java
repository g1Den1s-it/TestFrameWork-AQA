package org.framework.hibernate;

import lombok.Data;
import org.framework.hibernate.entities.Comment;
import org.framework.hibernate.entities.RandomUser;

import java.util.List;

@Data
public class UserAndComments {
    private List<RandomUser> randomUserList;
    private List<Comment> commentList;
}
