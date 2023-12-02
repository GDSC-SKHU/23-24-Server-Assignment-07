package com.gdsc.paginationassignment.controller;

import com.gdsc.paginationassignment.dto.BookDto;
import com.gdsc.paginationassignment.dto.BookPagingDto;
import com.gdsc.paginationassignment.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public void save(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);
    }

    @GetMapping
    public List<BookDto> findAll(@RequestBody BookPagingDto bookPagingDto) {
        return bookService.findAllBooks(bookPagingDto);
    }
}
