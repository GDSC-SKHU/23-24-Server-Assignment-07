package com.example.server07.service;

import com.example.server07.dto.PageDto;
import com.example.server07.dto.PostDTO;
import com.example.server07.dto.PostPagingDto;
import com.example.server07.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.server07.repository.PostRepository;

import java.util.List;

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

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);
        Page<PostDTO> postDTOPages = postPages.map(postPage -> new PostDTO(postPage));

        PageDto<PostDTO> pageDto = new PageDto<>();
        pageDto.setContent(postDTOPages.getContent());
        pageDto.setTotalPages(postDTOPages.getTotalPages());
        pageDto.setTotalElements(postDTOPages.getTotalElements());

        return pageDto;
    }

    public PageDto getPostsByPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("createdAt").descending());
        Page<Post> postPage = postRepository.findAll(pageable);

        List<Post> posts = postPage.getContent();
        int totalPages = Math.min(postPage.getTotalPages(), 100); // 최대 페이지 수를 100으로 제한

        return new PageDto(posts, page, page > 1, page < totalPages, totalPages);
    }

}
