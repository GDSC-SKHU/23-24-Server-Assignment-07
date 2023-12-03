package com.example.paginationexample.dto;


import com.example.paginationexample.domain.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private List<Post> content;
    private int totalPages;
    private long totalElements;
    private int pageNumber;
    private boolean existNextPage;

    public PostResponseDto(Page<Post> postPages) {
        this.content = postPages.getContent();
        this.totalPages = postPages.getTotalPages();
        this.totalElements = postPages.getTotalElements();
        this.pageNumber = postPages.getNumber();
        this.existNextPage = postPages.hasNext();
    }
}