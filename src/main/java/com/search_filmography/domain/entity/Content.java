package com.search_filmography.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Content {

    @Id
    @GeneratedValue // 기본키 지정안하면 오류남.
    private Long id;
    private String url;
}
