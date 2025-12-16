package com.search_filmography.domain.repository;

import com.search_filmography.domain.repository.FilmographyQueryRepositoryCustom;
import com.search_filmography.domain.dto.FilmographyResult;
import com.search_filmography.domain.entity.Movie;
import com.search_filmography.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmoAnchorRepository extends JpaRepository<Movie, Long>, FilmographyQueryRepositoryCustom {
}
