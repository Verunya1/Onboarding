package com.example.onboarding.repository;

import com.example.onboarding.entity.Course;
import com.example.onboarding.entity.CoursePresentation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursePresentationRepository extends JpaRepository<CoursePresentation, Long> {
    List<CoursePresentation> getAllPresentationByCourseId(Long courseId);
}
