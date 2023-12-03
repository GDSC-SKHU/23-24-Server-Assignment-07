package com.gdsc.pagination.dto;

import lombok.Data;

@Data
public class PostPagingDTO {
    private int page;
    private int size;
    private String sort;
}
