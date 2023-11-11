package com.example.onboarding.repository;

import com.example.onboarding.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> getAllByCourseId(Long courseId);

    Course setAccess(Long courseId);
}

