package com.gdsc.paginationassignment.service;

import com.gdsc.paginationassignment.domain.Book;
import com.gdsc.paginationassignment.dto.BookDto;
import com.gdsc.paginationassignment.dto.BookPagingDto;
import com.gdsc.paginationassignment.repository.BookRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Transactional(readOnly = true)
    public List<BookDto> findAllBooks(BookPagingDto bookPagingDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(bookPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(bookPagingDto.getPage(),bookPagingDto.getSize(), sort);

        Page<Book> bookPages = bookRepository.findAll(pageable);

        // content만 나오게 커스터마이징
        List<BookDto> bookDtoPages = bookPages.getContent().stream()
                .map(BookDto::new)
                .collect(Collectors.toList());
        return bookDtoPages;
    }
}
