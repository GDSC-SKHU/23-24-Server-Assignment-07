package com.example.postpg.repository;

import com.example.postpg.entity.Post;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}