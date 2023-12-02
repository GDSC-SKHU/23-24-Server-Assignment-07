package com.gdsc.paginationassignment.dto;

import com.gdsc.paginationassignment.domain.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String pictureURL;
    private Double rating;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.pictureURL = book.getPictureURL();
        this.rating = book.getRating();
    }
}
