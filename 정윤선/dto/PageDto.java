package com.example.server07.dto;

import com.example.server07.entity.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageDto<T> {
    private List<T> content;
    private int totalPages;
    private long totalElements;
    public PageDto(List<Post> posts, int page, boolean b, boolean b1, int totalPages) {

    }
}
