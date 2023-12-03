package com.example.paging2.controller;

import com.example.paging2.domain.PageCustomize;
import com.example.paging2.dto.PostDto;
import com.example.paging2.dto.PostPagingDto;
import com.example.paging2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void save(@RequestBody PostDto postDto){
        postService.save(postDto);
    }

    @GetMapping
    public PageCustomize findAll(@RequestBody PostPagingDto postPagingDto){
        return postService.findAllPosts(postPagingDto);
    }
}
