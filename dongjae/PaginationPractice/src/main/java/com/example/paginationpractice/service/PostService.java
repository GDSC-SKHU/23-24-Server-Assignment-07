package com.example.paginationpractice.service;

import com.example.paginationpractice.domain.Post;
import com.example.paginationpractice.dto.PostDto;
import com.example.paginationpractice.dto.PostPagingDto;
import com.example.paginationpractice.dto.ResponseDto;
import com.example.paginationpractice.repository.PostRepository;
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
    public void save(PostDto request) {
        Post post = Post.toEntity(request);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public ResponseDto findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);
        Page<Post> postPages = postRepository.findAll(pageable);

        return ResponseDto.of(postPages.getContent(), postPages.getTotalPages(), postPages.getTotalElements(), postPages.getNumber());
    }

}
