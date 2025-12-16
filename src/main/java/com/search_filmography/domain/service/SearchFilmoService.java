package com.search_filmography.domain.service;

import com.search_filmography.domain.dto.FilmographyResult;
import com.search_filmography.domain.entity.Drama;
import com.search_filmography.domain.entity.Genre;
import com.search_filmography.domain.entity.Movie;
import com.search_filmography.domain.entity.Role;
import com.search_filmography.domain.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@RequiredArgsConstructor
public class SearchFilmoService {

    private final FilmoAnchorRepository filmoAnchorRepository;
    private final GenreRepository genreRepository;

    // 영화+드라마 제목 및 역할명 검색
    public List<FilmographyResult> getFilmo(String title){
        return filmoAnchorRepository.findFilmoByTitle(title);
    }
}
