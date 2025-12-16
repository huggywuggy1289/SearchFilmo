package com.search_filmography.domain.entity.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieGenreId implements Serializable {

    private Long movieId;
    private Long genreId;
}
