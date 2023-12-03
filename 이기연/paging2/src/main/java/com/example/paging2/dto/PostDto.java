package com.example.paging2.dto;

import com.example.paging2.domain.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

    private Long id;
    private String author;
    private String title;
    private String content;

    public PostDto(Post post){
        this.id=post.getId();
        this.author=post.getAuthor();
        this.title=post.getTitle();
        this.content=post.getContent();
    }
}
