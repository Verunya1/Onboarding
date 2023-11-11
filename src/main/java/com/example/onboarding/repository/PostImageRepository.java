package com.example.onboarding.repository;

import com.example.onboarding.entity.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {
    List<PostImage> getAllByPostId(Long postId); // - вероятно здесь надо просто вернуть одну фотку
}
