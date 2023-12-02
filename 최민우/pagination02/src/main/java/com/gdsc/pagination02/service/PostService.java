package com.gdsc.pagination02.service;

import com.gdsc.pagination02.dto.PostDto;
import com.gdsc.pagination02.dto.PostPagingDto;
import com.gdsc.pagination02.entity.Post;
import com.gdsc.pagination02.repository.PostRepository;
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
    public void save(PostDto postDto) {
        Post post = Post.toEntity(postDto);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public Page<PostDto> findAllPosts(PostPagingDto postPagingDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);
        Page<Post> postPages = postRepository.findAll(pageable);
        Page<PostDto> postDtoPages = postPages.map(postPage -> new PostDto(postPage));
        return postDtoPages;
    }
}