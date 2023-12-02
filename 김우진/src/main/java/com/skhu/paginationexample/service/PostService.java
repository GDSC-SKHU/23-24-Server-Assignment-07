package com.skhu.paginationexample.service;

import com.skhu.paginationexample.domain.Post;
import com.skhu.paginationexample.dto.PostDto;
import com.skhu.paginationexample.dto.PostPagingDto;
import com.skhu.paginationexample.dto.Response.PostResponseDto;
import com.skhu.paginationexample.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(PostDto postDto) {
        Post post = Post.toEntity(postDto);
        postRepository.save(post);
    }

    @Transactional
    public PostResponseDto findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);

        return new PostResponseDto(postPages);
    }

}
