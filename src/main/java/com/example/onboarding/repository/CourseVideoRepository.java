package com.example.onboarding.repository;

import com.example.onboarding.entity.CoursePresentation;
import com.example.onboarding.entity.CourseVideo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseVideoRepository extends JpaRepository<CourseVideo, Long> {
    List<CourseVideo> getAllVideoByCourseId(Long courseId);

}
