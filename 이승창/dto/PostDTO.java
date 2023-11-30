package com.gdsc.pracpaging.dto;

import com.gdsc.pracpaging.domain.Post;
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
