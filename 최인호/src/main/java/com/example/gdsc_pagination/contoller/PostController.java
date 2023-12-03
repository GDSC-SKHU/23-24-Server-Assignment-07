package com.example.gdsc_pagination.contoller;

import com.example.gdsc_pagination.dto.PostDto;
import com.example.gdsc_pagination.dto.PostPagingDto;
import com.example.gdsc_pagination.dto.ResponseDto;
import com.example.gdsc_pagination.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseDto findAll(@RequestBody PostPagingDto postPagingDto){
        return postService.findAllPosts(postPagingDto);
    }
}
