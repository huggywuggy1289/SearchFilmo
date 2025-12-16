package com.search_filmography.domain.repository;

import com.search_filmography.domain.dto.FilmographyResult;
import com.search_filmography.domain.entity.Drama;
import com.search_filmography.domain.entity.Genre;
import com.search_filmography.domain.entity.Movie;
import com.search_filmography.domain.entity.Role;

import java.util.List;
import java.util.Optional;

public interface FilmographyQueryRepositoryCustom {
    List<FilmographyResult> findFilmoByTitle(String title);       // 영화+드라마 제목과 배역명검색
}
