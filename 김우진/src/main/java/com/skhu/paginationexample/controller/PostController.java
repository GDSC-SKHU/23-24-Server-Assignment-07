package com.skhu.paginationexample.controller;

import com.skhu.paginationexample.dto.PostDto;
import com.skhu.paginationexample.dto.PostPagingDto;
import com.skhu.paginationexample.dto.Response.PostResponseDto;
import com.skhu.paginationexample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void save (@RequestBody PostDto postDTO){
        postService.save(postDTO);
    }

    @GetMapping
    public PostResponseDto findAll(@RequestBody PostPagingDto postPagingDto){
        return postService.findAllPosts(postPagingDto);
    }
}
