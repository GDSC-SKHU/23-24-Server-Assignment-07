package com.gdsc.com.customizingpagingtest.repository;

import com.gdsc.com.customizingpagingtest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
