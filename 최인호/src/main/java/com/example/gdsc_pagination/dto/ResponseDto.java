package com.example.gdsc_pagination.dto;

import com.example.gdsc_pagination.domain.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor
public class ResponseDto {
    private List<Post> content;
    private int totalPages;
    private long totalElements;
    private int pageNumber;

    public ResponseDto(Page<Post> postPages){
        this.content = postPages.getContent();
        this.totalPages = postPages.getTotalPages();
        this.totalElements = postPages.getTotalElements();
        this.pageNumber = postPages.getNumber();
    }
}
