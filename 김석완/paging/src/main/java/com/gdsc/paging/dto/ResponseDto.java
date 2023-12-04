package com.gdsc.paging.dto;

import com.gdsc.paging.domain.Post;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private List<Post> content;
    private int totalPages;
    private long totalElements;

    public ResponseDto(Page<Post> postPages) {
        this.content = postPages.getContent();
        this.totalPages = postPages.getTotalPages();
        this.totalElements = postPages.getTotalElements();
    }
}
