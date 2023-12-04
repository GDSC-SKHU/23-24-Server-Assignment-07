package com.gdsc.paging.service;

import com.gdsc.paging.domain.Post;
import com.gdsc.paging.dto.PostDto;
import com.gdsc.paging.dto.PostPagingDto;
import com.gdsc.paging.dto.ResponseDto;
import com.gdsc.paging.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void save(PostDto postDto){
        Post post = Post.toEntity(postDto);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public ResponseDto findAllPosts(PostPagingDto postPagingDto){

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()),"id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(),sort);
        Page<Post> postPages = postRepository.findAll(pageable);
        return new ResponseDto(postPages);
    }
}
