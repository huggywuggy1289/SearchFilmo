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
public class DramaGenreId implements Serializable {
    // 두개이상의 컬럼을 하나의 기본키로 지정할 경우 이렇게 만듬.
    private Long dramaId;
    private Long genreId;
}

