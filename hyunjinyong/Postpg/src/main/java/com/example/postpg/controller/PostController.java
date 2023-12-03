package com.example.postpg.controller;

import com.example.postpg.dto.PostAnonymous;
import com.example.postpg.dto.PostDTO;
import com.example.postpg.dto.PostPagingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.example.postpg.service.PostService;

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
    public Page<PostDTO> findAll(@RequestBody PostPagingDto postPagingDto){
        return postService.findAllPosts(postPagingDto);
    }

    @GetMapping("/secure-author")
    public Page<PostAnonymous> findALL(@RequestBody PostPagingDto postPagingDto) {
        return postService.updateAllPostAuthorToAnonymous(postPagingDto);
    }

}
