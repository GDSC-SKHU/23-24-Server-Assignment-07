package com.gdsc.com.customizingpagingtest.service;

import com.gdsc.com.customizingpagingtest.dto.PageDTO;
import com.gdsc.com.customizingpagingtest.dto.PostDTO;
import com.gdsc.com.customizingpagingtest.dto.PostPagingDTO;
import com.gdsc.com.customizingpagingtest.entity.Post;
import com.gdsc.com.customizingpagingtest.repository.PostRepository;
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
    public void save(PostDTO postDTO) {
        Post post = Post.toEntity(postDTO);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public PageDTO findAllPosts(PostPagingDTO postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);

        return new PageDTO(postPages);
    }
}