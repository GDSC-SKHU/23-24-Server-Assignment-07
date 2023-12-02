package com.gdsc.paginationassignment.controller;

import com.gdsc.paginationassignment.dto.BookDto;
import com.gdsc.paginationassignment.dto.BookPagingDto;
import com.gdsc.paginationassignment.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "BookStore", description = "BookStore API")
@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    @Operation(summary = "책 프로필 생성", description = "책 프로필 하나를 생성합니다.")
    public void save(
            @Parameter(required = true, description = "책 프로필 생성 요청")
            @RequestBody BookDto bookDto) {
        bookService.save(bookDto);
    }

    @GetMapping
    @Operation(summary = "페이징된 책 목록 조회", description = "원하는 만큼 페이징된 책 프로필을 조회합니다.")
    public List<BookDto> findAll(
            @Parameter(required = true, description = "페이징 설정")
            @RequestBody BookPagingDto bookPagingDto) {
        return bookService.findAllBooks(bookPagingDto);
    }
}
