package com.example.paginationpractice.dto;

import com.example.paginationpractice.domain.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto {

    private List<Post> content;
    private int totalPages;
    private long totalElements;
    private int pageNumber;

    public static ResponseDto of(List<Post> content, int totalPages, long totalElements, int pageNumber) {
        return new ResponseDto(content, totalPages, totalElements, pageNumber);
    }

}
