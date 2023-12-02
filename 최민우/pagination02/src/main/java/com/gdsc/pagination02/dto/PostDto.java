package com.gdsc.pagination02.dto;

import com.gdsc.pagination02.entity.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

    private Long id;
    private String title;
    private String genre;
    private String director;

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.genre = post.getGenre();
        this.director = post.getDirector();
    }
}