package com.gdsc.pracpaging.controller;

import com.gdsc.pracpaging.Service.PostService;
import com.gdsc.pracpaging.dto.PageDto;
import com.gdsc.pracpaging.dto.PostDTO;
import com.gdsc.pracpaging.dto.PostPagingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public PageDto<PostDTO> findAll(@RequestBody PostPagingDto postPagingDto){
        return postService.findAllPosts(postPagingDto);
    }
}
