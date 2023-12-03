package com.example.postpg.dto;

import com.example.postpg.entity.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDTO {

    private Long id;
    private String author;
    private String title;
    private String content;

    public PostDTO(Post post){
        this.id = post.getId();
        this.author = post.getAuthor();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}