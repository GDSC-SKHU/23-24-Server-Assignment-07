package com.gdsc.paginationassignment.service;

import com.gdsc.paginationassignment.domain.Book;
import com.gdsc.paginationassignment.dto.BookDto;
import com.gdsc.paginationassignment.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public void save(BookDto bookDto) {
        Book book = Book.toEntity(bookDto);
        bookRepository.save(book);
    }
}
