package com.example.paging2.dto;

import lombok.Data;

@Data
public class PostPagingDto {

    private int page;
    private int size;
    private String sort;
}
