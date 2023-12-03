package com.gdsc.pagination.dto;

import com.gdsc.pagination.domain.Post;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private List<Post> postList;

    public ResponseDTO(Page<Post> postPages) {
        this.postList = postPages.getContent();
    }

}
