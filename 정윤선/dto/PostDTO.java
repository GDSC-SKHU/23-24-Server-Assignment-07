package com.example.server07.dto;

import com.example.server07.entity.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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