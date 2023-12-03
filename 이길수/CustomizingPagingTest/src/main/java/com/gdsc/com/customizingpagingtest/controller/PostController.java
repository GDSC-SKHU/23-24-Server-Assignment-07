package com.gdsc.com.customizingpagingtest.controller;

import com.gdsc.com.customizingpagingtest.dto.PageDTO;
import com.gdsc.com.customizingpagingtest.dto.PostDTO;
import com.gdsc.com.customizingpagingtest.dto.PostPagingDTO;
import com.gdsc.com.customizingpagingtest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void save(@RequestBody PostDTO postDTO) {
        postService.save(postDTO);
    }

    @GetMapping
    public PageDTO findAll(@RequestBody PostPagingDTO postPagingDTO) {
        return postService.findAllPosts(postPagingDTO);
    }
}
