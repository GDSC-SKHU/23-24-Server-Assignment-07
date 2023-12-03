package com.gdsc.pagination.repository;


import com.gdsc.pagination.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
