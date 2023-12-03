package com.gdsc.pagination02.entity;

import com.gdsc.pagination02.dto.PostDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "DIRECTOR")
    private String director;

    public static Post toEntity(PostDto postDto) {
        return Post.builder()
                .title(postDto.getTitle())
                .genre(postDto.getGenre())
                .director(postDto.getDirector())
                .build();
    }
}