package com.search_filmography.domain.entity;

import jakarta.persistence.*;

import java.text.DateFormat;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id; // 배역코드
    private String role_name; // 배역명

    // FK관계
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "drama_id")
    private Drama drama;

}
