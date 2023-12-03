package com.example.postpg.dto;

import com.example.postpg.entity.Post;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class PostAnonymous {
    private Long id;
    private String author;
    private String title;
    private String content;

    public PostAnonymous(Post post){
        this.id = post.getId();
        this.author = null;
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
