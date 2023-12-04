package com.gdsc.paging.controller;

import com.gdsc.paging.dto.PostDto;
import com.gdsc.paging.dto.PostPagingDto;
import com.gdsc.paging.dto.ResponseDto;
import com.gdsc.paging.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public void save (@RequestBody PostDto postDto){
        postService.save(postDto);
    }

    @GetMapping
    public ResponseDto findAll(@RequestBody PostPagingDto postPagingDto){
        return postService.findAllPosts(postPagingDto);
    }


}
