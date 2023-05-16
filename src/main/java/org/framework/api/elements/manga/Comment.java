package org.framework.api.elements.manga;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private String author;
    private String body;
    private String manga;
}
