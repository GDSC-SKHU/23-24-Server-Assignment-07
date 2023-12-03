package com.skhu.paginationexample.domain;

import com.skhu.paginationexample.dto.PostDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "POST_AUTHOR")
    private String author;

    @Column(name = "POST_TITLE")
    private String title;

    @Column(name = "POST_CONTENT")
    private String content;


    public static Post toEntity(PostDto postDTO){
        return Post.builder()
                .author(postDTO.getAuthor())
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .build();
    }
}