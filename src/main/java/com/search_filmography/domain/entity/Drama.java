package com.search_filmography.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.DateFormat;
import java.time.LocalDate;

@Entity
public class Drama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drama_id; // 드라마코드
    private String title; // 드라마제목
    private LocalDate openDate; // 개봉일

    // 접속 URL추가
    private String Url;
}
