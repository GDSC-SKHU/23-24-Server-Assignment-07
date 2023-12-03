package com.gdsc.pagination.dto;

import com.gdsc.pagination.domain.Post;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private List<Post> content;
    private int totalPages;
    private long totalElemets;
    private int pageNumber;

    public PostResponseDto(Page<Post> postPages) {
        this.content = postPages.getContent();
        this.totalPages = postPages.getTotalPages();
        this.totalElemets = postPages.getTotalElements();
        this.pageNumber = postPages.getNumber();


    }
}
