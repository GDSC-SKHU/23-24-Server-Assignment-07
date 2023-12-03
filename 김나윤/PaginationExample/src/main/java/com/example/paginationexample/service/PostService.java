package com.example.paginationexample.service;

import com.example.paginationexample.dto.PostDto;
import com.example.paginationexample.dto.PostPagingDto;
import com.example.paginationexample.dto.TitleDto;
import com.example.paginationexample.entity.Post;
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
    public void save(PostDto postDto) {
        Post post = Post.toEntity(postDto);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public Page<PostDto> findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()),"id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);

        Page<PostDto> postDtoPages = postPages.map(postPage -> new PostDto(postPage));
        return postDtoPages;
    }

    @Transactional
    public Page<TitleDto> updateAllTitle(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()),"id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);

        Page<TitleDto> titleDtos = postPages.map(postPage -> new TitleDto(postPage));
        return titleDtos;
    }

}
