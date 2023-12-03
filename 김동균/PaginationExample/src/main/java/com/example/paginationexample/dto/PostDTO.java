package com.example.paginationexample.dto;

import com.example.paginationexample.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    public static PostDTO of(Long id, String title, String content, String author) {
        return new PostDTO(id, title, content, author);
    }
}