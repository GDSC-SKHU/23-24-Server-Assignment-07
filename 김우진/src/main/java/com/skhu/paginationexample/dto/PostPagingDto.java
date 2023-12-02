package com.skhu.paginationexample.dto;

import lombok.Data;

@Data
public class PostPagingDto {

    private Integer page;
    private Integer size;
    private String sort;
}
