package com.search_filmography.domain.entity;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movie_id; // 영화코드
    private String title; // 영화제목
    private LocalDate openDate; // 개봉일
    private Integer count; // 누적 관람객
    private Float rating; // 별점
    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> genres;

    // 접속 URL추가
    private String Url;
}
