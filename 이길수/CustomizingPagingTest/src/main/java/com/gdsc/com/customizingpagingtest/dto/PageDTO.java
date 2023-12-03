package com.gdsc.com.customizingpagingtest.dto;

import com.gdsc.com.customizingpagingtest.entity.Post;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDTO {

    private List<Post> content;
    private int totalPages;
    private long totalElements;

    public PageDTO(Page<Post> postPage) {
        this.content = postPage.getContent();
        this.totalPages = postPage.getTotalPages();
        this.totalElements = postPage.getTotalElements();
    }
}
