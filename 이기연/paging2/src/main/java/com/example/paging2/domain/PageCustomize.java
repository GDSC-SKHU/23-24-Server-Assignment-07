package com.example.paging2.domain;

import com.example.paging2.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageCustomize {

    private List<PostDto> content;
    private int totalPages;
    private long totalElements;

}