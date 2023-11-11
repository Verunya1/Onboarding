package com.example.onboarding.repository;

import com.example.onboarding.entity.Post;
import com.example.onboarding.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
