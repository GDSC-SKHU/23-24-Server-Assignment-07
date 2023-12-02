package com.gdsc.pagination02.controller;

import com.gdsc.pagination02.dto.PostDto;
import com.gdsc.pagination02.dto.PostPagingDto;
import com.gdsc.pagination02.service.PostService;
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
    public Page<PostDto> findAll(@RequestBody PostPagingDto postPagingDto) {
        return postService.findAllPosts(postPagingDto);
    }
}