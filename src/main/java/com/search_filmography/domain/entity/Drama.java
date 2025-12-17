package com.search_filmography.domain.entity;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.time.LocalDate;

@Entity
public class Drama extends Content {
    @Column(name = "drama_id", unique = true)
    private Long drama_id; // 드라마코드
    private String title; // 드라마제목
    private LocalDate openDate; // 개봉일
}
