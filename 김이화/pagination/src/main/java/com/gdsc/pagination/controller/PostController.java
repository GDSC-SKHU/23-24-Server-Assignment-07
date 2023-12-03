package com.gdsc.pagination.controller;


import com.gdsc.pagination.dto.PostDto;
import com.gdsc.pagination.dto.PostPagingDto;
import com.gdsc.pagination.dto.PostResponseDto;
import com.gdsc.pagination.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
