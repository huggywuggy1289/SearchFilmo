package com.search_filmography.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DateFormat;

@Getter
public class FilmographyResult {

    private Long id;
    private String title;
    private String type;
    private String roleName;

    private Integer releaseYear;
    private String genreName;

    public FilmographyResult(
            Long id, String title, String type, String roleName,
            Integer releaseYear, String genreName) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.roleName = roleName;
        this.releaseYear = releaseYear;
        this.genreName = genreName;
    }
}
