package com.gdsc.paginationassignment.domain;

import com.gdsc.paginationassignment.dto.BookDto;
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
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PICTURE_URL")
    private String pictureURL;

    @Column(name = "RATING")
    private Double rating;

    public static Book toEntity(BookDto bookDto) {
        return Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .pictureURL(bookDto.getPictureURL())
                .rating(bookDto.getRating())
                .build();
    }
}
