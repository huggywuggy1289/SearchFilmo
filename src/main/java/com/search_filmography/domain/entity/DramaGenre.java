package com.search_filmography.domain.entity;

import com.search_filmography.domain.entity.id.DramaGenreId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DramaGenre {

    @EmbeddedId
    private DramaGenreId id;

    @ManyToOne
    @MapsId("dramaId")
    @JoinColumn(name = "drama_id")
    private Drama drama;

    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name = "genre_id")
    private Genre genre;
}

