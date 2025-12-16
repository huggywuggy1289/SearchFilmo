package com.search_filmography.domain.entity;

import com.search_filmography.domain.entity.id.MovieGenreId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieGenre {

    @EmbeddedId
    private MovieGenreId id;

    // MovieGenre (movie_id PK, genre_id PK)
    // DramaGenre (drama_id PK, genre_id PK)
    // >>> 이렇게 두개의 PK가 FK이자 식별관계이고 두개밖에 필득 없을경우이자
    // 한마디로 교차테이블을 엔티티로 만들어야하는 경우
    // @ManyToMany가 아니라 @IdClass 또는 @EmbeddedId + @ManyToOne 두 개로 구현
    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id") // 영화코드(FK)
    private Movie movie;

    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name = "genre_id") // 장르코드(FK)
    private Genre genre;

}
