package com.gdsc.pracpaging.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class PageDto<T> {
    private List<T> content;
    private int totalPages;
    private long totalElements;
}
