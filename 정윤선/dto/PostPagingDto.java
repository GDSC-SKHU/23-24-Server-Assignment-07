package com.example.server07.dto;

import lombok.Data;

@Data
public class PostPagingDto {
    private int page;
    private int size;
    private String sort;
}