package com.gdsc.pagination.dto;

import com.gdsc.pagination.domain.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data // @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode
@NoArgsConstructor // 기본 생성자 자동 추가
public class PostDTO {

    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;


    public PostDTO(Post post) {
        this.id = post.getId();
        this.author = post.getAuthor();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdDate = post.getCreatedDate();

    }


}
