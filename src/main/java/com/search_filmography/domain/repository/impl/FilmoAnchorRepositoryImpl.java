package com.search_filmography.domain.repository.impl;

import com.search_filmography.domain.dto.FilmographyResult;
import com.search_filmography.domain.repository.FilmographyQueryRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmoAnchorRepositoryImpl implements FilmographyQueryRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    private static final Long ACTOR_ID_TARGET = 1L;
    private static final String MOVIE_YEAR_FUNCTION = "CAST(FUNCTION('YEAR', m.openDate) AS integer)";
    private static final String DRAMA_YEAR_FUNCTION = "CAST(FUNCTION('YEAR', d.openDate) AS integer)";
    private static final String MOVIE_GENRE_SUBQUERY =
            "(SELECT FUNCTION('GROUP_CONCAT', g.name) FROM MovieGenre mg JOIN mg.genre g WHERE mg.movie = m)";
    private static final String DRAMA_GENRE_SUBQUERY =
            "(SELECT FUNCTION('GROUP_CONCAT', g.name) FROM DramaGenre dg JOIN dg.genre g WHERE dg.drama = d)";


    @Override
    @Transactional(readOnly = true)
    public List<FilmographyResult> findFilmoByTitle(String title) {
        if (title == null || title.isBlank()) return new ArrayList<>();

        String movieJpql =
                "SELECT m.movie_id, m.title, 'Movie', r.role_name, " + MOVIE_YEAR_FUNCTION + ", " + MOVIE_GENRE_SUBQUERY +
                        " FROM Movie m JOIN Role r ON r.movie = m " +
                        " WHERE r.movie IS NOT NULL AND (m.title LIKE CONCAT('%', :title, '%') OR r.role_name LIKE CONCAT('%', :title, '%')) " +
                        " AND r.actor.id = :actorId";

        String dramaJpql =
                "SELECT d.drama_id, d.title, 'Drama', r.role_name, " + DRAMA_YEAR_FUNCTION + ", " + DRAMA_GENRE_SUBQUERY +
                        " FROM Drama d JOIN Role r ON r.drama = d " +
                        " WHERE r.drama IS NOT NULL AND (d.title LIKE CONCAT('%', :title, '%') OR r.role_name LIKE CONCAT('%', :title, '%')) " +
                        " AND r.actor.id = :actorId";

        List<Object[]> movieRawResults = em.createQuery(movieJpql, Object[].class)
                .setParameter("title", title)
                .setParameter("actorId", ACTOR_ID_TARGET)
                .getResultList();

        List<Object[]> dramaRawResults = em.createQuery(dramaJpql, Object[].class)
                .setParameter("title", title)
                .setParameter("actorId", ACTOR_ID_TARGET)
                .getResultList();

        List<FilmographyResult> results = new ArrayList<>();
        results.addAll(convertToFilmographyResult(movieRawResults));
        results.addAll(convertToFilmographyResult(dramaRawResults));

        return results;
    }

    private List<FilmographyResult> convertToFilmographyResult(List<Object[]> rawResults) {
        return rawResults.stream()
                .map(row -> new FilmographyResult(
                        (Long) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3],
                        (Integer) row[4],
                        (String) row[5]
                ))
                .collect(Collectors.toList());
    }
}