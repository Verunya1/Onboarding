package com.example.onboarding.service;

import com.example.onboarding.entity.Course;
import com.example.onboarding.entity.CourseVideo;
import com.example.onboarding.entity.Post;
import com.example.onboarding.entity.PostImage;
import com.example.onboarding.repository.CourseRepository;
import com.example.onboarding.repository.CourseVideoRepository;
import com.example.onboarding.repository.PostImageRepository;
import com.example.onboarding.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostImageRepository postImageRepository;
    private final FileService fileService;

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public List<Post> getAllPosts(Long id) {
        return postRepository.getAllByPostId(id); // хуйня не иначе
    }

    public Post savePost(Post post, MultipartFile file) throws IOException {
        post = postRepository.save(post);
        postImageRepository.save(new PostImage(0L, post.getId(), fileService.saveImagePost("img_post" + post.getId() + "_1", file)));
        return post;
    }

    public void deletePost(Long id) {
        postImageRepository.deleteAll(postImageRepository.getAllByPostId(id));
        postRepository.deleteById(id);
    }

    public Post getPostByID(Long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
