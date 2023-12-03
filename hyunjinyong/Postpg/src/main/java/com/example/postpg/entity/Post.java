package com.example.postpg.entity;

import com.example.postpg.dto.PostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;


    public static Post toEntity(PostDTO postDTO){
        return Post.builder()
                .author(postDTO.getAuthor())
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .build();
    }

}
