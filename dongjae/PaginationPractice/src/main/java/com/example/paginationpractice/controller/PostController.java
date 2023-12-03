package com.example.paginationpractice.controller;

import com.example.paginationpractice.dto.PostDto;
import com.example.paginationpractice.dto.PostPagingDto;
import com.example.paginationpractice.dto.ResponseDto;
import com.example.paginationpractice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void save (@RequestBody PostDto request){
        postService.save(request);
    }

    @GetMapping
    public ResponseDto findAll(@RequestBody PostPagingDto request){
        return postService.findAllPosts(request);
    }
}
