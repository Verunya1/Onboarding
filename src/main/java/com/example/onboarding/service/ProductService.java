package com.example.onboarding.service;

import com.example.onboarding.entity.Post;
import com.example.onboarding.entity.PostImage;
import com.example.onboarding.entity.Product;
import com.example.onboarding.entity.ProductImage;
import com.example.onboarding.repository.ProductImageRepository;
import com.example.onboarding.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final FileService fileService;

    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public Product saveProduct(Product product, MultipartFile file) throws IOException {
        product = productRepository.save(product);
        productImageRepository.save(new ProductImage(0L, product.getId(), fileService.saveImageProduct("img_product" + product.getId() + "_1", file)));
        return product;
    }
//    public void updateProduct(Long id) {
//        productImageRepository.deleteAll(productImageRepository.getAllByProductId(id));
//        productRepository.deleteById(id);
//    }
    public void deleteProduct(Long id) {
        productImageRepository.deleteAll(productImageRepository.getAllByProductId(id));
        productRepository.deleteById(id);
    }
    public Product getProductByID(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
