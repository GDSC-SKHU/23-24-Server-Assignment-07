package com.gdsc.pagination.controller;

import com.gdsc.pagination.dto.PostDTO;
import com.gdsc.pagination.dto.PostPagingDTO;
import com.gdsc.pagination.dto.ResponseDTO;
import com.gdsc.pagination.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseDTO findAll(@RequestBody PostPagingDTO postPagingDTO){
        return postService.findAllPosts(postPagingDTO);
    }
}