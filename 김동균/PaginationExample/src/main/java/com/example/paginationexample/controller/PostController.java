package com.example.paginationexample.controller;

import com.example.paginationexample.dto.PostResponseDto;
import com.example.paginationexample.service.PostService;
import com.example.paginationexample.dto.PostDTO;
import com.example.paginationexample.dto.PostPagingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void save (@RequestBody PostDTO postDTO){
        postService.save(postDTO);
    }

    @GetMapping
    public PostResponseDto findAll(@RequestBody PostPagingDto postPagingDto){
        return postService.findAllPosts(postPagingDto);
    }
}
