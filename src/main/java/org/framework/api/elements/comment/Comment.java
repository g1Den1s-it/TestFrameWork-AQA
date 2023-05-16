package org.framework.api.elements.comment;

import lombok.Data;

@Data
public class Comment {
    private int id;
    private String author;
    private String body;
    private String manga;
}
