package com.example.paginationexample.service;

import com.example.paginationexample.domain.Post;
import com.example.paginationexample.dto.PostDTO;
import com.example.paginationexample.dto.PostPagingDto;
import com.example.paginationexample.dto.PostResponseDto;
import com.example.paginationexample.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(PostDTO postDTO) {
        Post post = Post.toEntity(postDTO);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public PostResponseDto findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id"); //정렬
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort); // 페이지랑 사이즈
        Page<Post> postPages = postRepository.findAll(pageable);
        return new PostResponseDto(postPages);
    }
}
