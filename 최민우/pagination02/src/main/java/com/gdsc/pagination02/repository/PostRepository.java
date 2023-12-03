package com.gdsc.pagination02.repository;

import com.gdsc.pagination02.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}