package com.search_filmography.domain.repository;

import com.search_filmography.domain.entity.Genre;
import com.search_filmography.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
