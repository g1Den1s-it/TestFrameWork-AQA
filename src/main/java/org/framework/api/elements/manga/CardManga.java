package org.framework.api.elements.manga;

import lombok.Data;

@Data
public class CardManga {
    private Integer id;
    private String image;
    private String name;
    private Integer year;
    private String slug;
}
