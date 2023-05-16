package org.framework.api.elements.manga;

import lombok.Data;

import java.util.List;

@Data
public class GetMangaResponse {
    private Integer codeStatus;
    private List<CardManga> cardMangaList;
}
