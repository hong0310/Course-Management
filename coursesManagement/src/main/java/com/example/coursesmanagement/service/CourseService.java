package com.example.coursesmanagement.service;

import com.example.coursesmanagement.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAllCourses();

    Optional<Course> findCourse(long id);

    Course createCourse(Course course);

    Course editCourse(Course course);

    void deleteCourse(long id);
}
