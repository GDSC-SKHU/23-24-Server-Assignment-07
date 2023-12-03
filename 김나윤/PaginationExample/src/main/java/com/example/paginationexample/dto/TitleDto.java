package com.example.paginationexample.dto;

import com.example.paginationexample.entity.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TitleDto {

    private Long id;
    private String author;
    private String title;
    private String content;

    public TitleDto(Post post) {
        this.id = null;
        this.author = null;
        this.title = post.getTitle();
        this.content = null;
    }
}
