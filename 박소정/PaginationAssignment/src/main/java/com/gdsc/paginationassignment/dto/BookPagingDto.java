package com.gdsc.paginationassignment.dto;

import lombok.Data;

@Data
public class BookPagingDto {
    private int page;
    private int size;
    private String sort;
}
