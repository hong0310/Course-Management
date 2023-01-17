package com.example.coursesmanagement.service;

import com.example.coursesmanagement.model.Course;
import com.example.coursesmanagement.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
class CourseServiceImpl implements CourseService{
    @Resource
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findCourse(long id) {
        return courseRepository.findById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional(readOnly = false)
    @Override
    public Course editCourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }
}
