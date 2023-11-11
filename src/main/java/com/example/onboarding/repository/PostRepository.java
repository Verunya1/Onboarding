package com.example.onboarding.repository;

import com.example.onboarding.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> getAllByPostId(Long postId);
}
