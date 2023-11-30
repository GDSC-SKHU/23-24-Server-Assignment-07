package com.example.gdsc_pagination.service;

import com.example.gdsc_pagination.domain.Post;
import com.example.gdsc_pagination.dto.PostDto;
import com.example.gdsc_pagination.dto.PostPagingDto;
import com.example.gdsc_pagination.dto.ResponseDto;
import com.example.gdsc_pagination.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(PostDto postDTO) {
        Post post = Post.toEntity(postDTO);
        postRepository.save(post);
    }


    @Transactional(readOnly = true)
    public ResponseDto findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id"); //정렬
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort); // 페이지랑 사이즈
        Page<Post> postPages = postRepository.findAll(pageable);
        return new ResponseDto(postPages);


    }
}
