package com.example.onboarding.repository;


import com.example.onboarding.entity.PostImage;
import com.example.onboarding.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImage> getAllByProductId(Long postId);
}
