package org.framework.api.elements.manga;

import lombok.Data;

import java.util.List;

@Data
public class Manga {
    private Integer id;
    private String image;
    private String name;
    private String alternateName;
    private List<String> authors;
    private List<String> genres;
    private String type;
    private Integer year;
    private String official;
    private String status;
    private String description;
    private List<Chapter> chapters;
    private List<Comment> comments;
}
