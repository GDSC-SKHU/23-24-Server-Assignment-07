package com.gdsc.pracpaging.Service;

import com.gdsc.pracpaging.domain.Post;
import com.gdsc.pracpaging.dto.PageDto;
import com.gdsc.pracpaging.dto.PostDTO;
import com.gdsc.pracpaging.dto.PostPagingDto;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gdsc.pracpaging.repository.PostRepository;

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
    public PageDto<PostDTO> findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id"); //id를 기준으로.
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);
        Page<PostDTO> postDTOPages = postPages.map(postPage -> new PostDTO(postPage));

        PageDto<PostDTO> pageDto = new PageDto<>();
        pageDto.setContent(postDTOPages.getContent());
        pageDto.setTotalPages(postDTOPages.getTotalPages());
        pageDto.setTotalElements(postDTOPages.getTotalElements());

        return pageDto;
    }
}
