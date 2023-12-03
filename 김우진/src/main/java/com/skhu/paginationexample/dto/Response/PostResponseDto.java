package com.skhu.paginationexample.dto.Response;

import com.skhu.paginationexample.domain.Post;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class PostResponseDto {

    private List<Post> content;
    private int totalPage;
    private long totalElement;
    private long pageNumber;

    public PostResponseDto(Page<Post> pagePost) {
        this.content = pagePost.getContent();
        this.totalPage = pagePost.getTotalPages();
        this.totalElement = pagePost.getTotalElements();
        this.pageNumber = pagePost.getNumber();
    }

}
