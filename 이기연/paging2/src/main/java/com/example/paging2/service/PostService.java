package com.example.paging2.service;


import com.example.paging2.domain.PageCustomize;
import com.example.paging2.domain.Post;
import com.example.paging2.dto.PostDto;
import com.example.paging2.dto.PostPagingDto;
import com.example.paging2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(PostDto postDto){
        Post post =Post.toEntity(postDto);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public PageCustomize findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);

       /* Page<PostDto> postDTOPages = postPages.map(postPage -> new PostDto(postPage));
        return postDTOPages;*/
        List<PostDto> postDtoList = postPages.map(PostDto::new).getContent();


        return PageCustomize.builder()
                .content(postDtoList)
                .totalPages(postPages.getTotalPages())
                .totalElements(postPages.getTotalElements())
                .build();

    }
}
