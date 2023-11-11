package com.example.onboarding.service;

import com.example.onboarding.entity.Course;
import com.example.onboarding.entity.CoursePresentation;
import com.example.onboarding.entity.CourseVideo;
import com.example.onboarding.repository.CoursePresentationRepository;
import com.example.onboarding.repository.CourseRepository;
import com.example.onboarding.repository.CourseVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseVideoRepository courseVideoRepository;
    private final CoursePresentationRepository coursePresentationRepository;
    private final FileService fileService;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public List<CourseVideo> getAllVideos(Long id) {
        return courseVideoRepository.getAllByCourseId(id);
    }

    public Course saveVideoCourse(Course course, MultipartFile file) throws IOException {
        course = courseRepository.save(course);
        courseVideoRepository.save(new CourseVideo(0L, course.getId(), fileService.saveVideo("vid" + course.getId() + "_1", file)));
        return course;
    }

    public Course savePresentationCourse(Course course, MultipartFile file) throws IOException {
        course = courseRepository.save(course);
        coursePresentationRepository.save(new CoursePresentation(0L, course.getId(), fileService.savePresentation("pptx" + course.getId() + "_1", file)));
        return course;
    }

    public void deleteCourse(Long id) {
        courseVideoRepository.deleteAll(courseVideoRepository.getAllByCourseId(id));
        courseRepository.deleteById(id);
    }

    public Course getCourseByID(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public void setAccess(Long id) {
        courseRepository.setAccess(id).setAccess("Недоступен");
    }
}
