package com.search_filmography.domain.controller;

import com.search_filmography.domain.dto.FilmographyResult;
import com.search_filmography.domain.entity.Genre;
import com.search_filmography.domain.entity.Role;
import com.search_filmography.domain.service.SearchFilmoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Collections;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class SearchFilmoController {

    private final SearchFilmoService searchFilmoService;

    @GetMapping({"/"})
    public String home() {
        return "index.html";
    }
    @GetMapping("/filmo/search")
    public String searchByTitle(@RequestParam(name="keyword", required=false) String keyword, Model model) {
        List<FilmographyResult> results = Collections.emptyList();

        if (keyword != null && !keyword.isBlank()) {
            results = searchFilmoService.getFilmo(keyword);
        }

        model.addAttribute("keyword", keyword);
        model.addAttribute("results", results);

        return "index";
    }
}