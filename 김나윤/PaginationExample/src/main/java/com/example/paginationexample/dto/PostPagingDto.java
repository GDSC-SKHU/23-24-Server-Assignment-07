package com.example.paginationexample.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostPagingDto {

    private int page;
    private int size;
    private String sort;
}
