package com.example.postpg.service;

import com.example.postpg.dto.PostAnonymous;
import com.example.postpg.dto.PostDTO;
import com.example.postpg.dto.PostPagingDto;
import com.example.postpg.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.postpg.repository.PostRepository;


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
    public Page<PostDTO> findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);

        Page<PostDTO> postDTOPages = postPages.map(postPage -> new PostDTO(postPage));
        return postDTOPages;
    }



    @Transactional
    public Page<PostAnonymous> updateAllPostAuthorToAnonymous(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);
        Page<PostAnonymous> postAnonymous = postPages.map(postPage -> new PostAnonymous(postPage));
        return postAnonymous;
    }
}
