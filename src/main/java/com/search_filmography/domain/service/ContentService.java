package com.search_filmography.domain.service;

import com.search_filmography.domain.entity.Content;
import com.search_filmography.domain.repository.ContentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public String getContentUrl(Long id) {
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("url이 존재하지않습니다."));

        return content.getContentUrl();
    }
}
