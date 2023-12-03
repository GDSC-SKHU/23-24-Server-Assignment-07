package com.example.paginationexample.controller;

import com.example.paginationexample.dto.PostDto;
import com.example.paginationexample.dto.PostPagingDto;
import com.example.paginationexample.dto.TitleDto;
import com.example.paginationexample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void save (@RequestBody PostDto postDto) {
        postService.save(postDto);
    }
    @GetMapping
    public Page<PostDto> findAll(@RequestBody PostPagingDto postPagingDto) {
        return postService.findAllPosts(postPagingDto);
    }
    @GetMapping("/search-title")
    public Page<TitleDto> findALL(@RequestBody PostPagingDto postPagingDto) {
        return postService.updateAllTitle(postPagingDto);
    }

}
