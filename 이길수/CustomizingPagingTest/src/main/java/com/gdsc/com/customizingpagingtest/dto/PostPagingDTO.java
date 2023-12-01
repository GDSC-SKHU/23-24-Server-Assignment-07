package com.gdsc.com.customizingpagingtest.dto;

import lombok.Data;

@Data
public class PostPagingDTO {

    private int page;
    private int size;
    private String sort;
}
