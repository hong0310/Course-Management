package com.example.coursesmanagement.controller;

import com.example.coursesmanagement.model.Course;
import com.example.coursesmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.findAllCourses();
    };

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") long id){
        Optional<Course> optionalCourse = courseService.findCourse(id);
        if (optionalCourse.isPresent()){
            Course course = optionalCourse.get();
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course inCourse){
        try {
            Course returnCourse = courseService.createCourse(inCourse);
            return new ResponseEntity<Course>(returnCourse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    };

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> editCourse(@PathVariable("id") long id, @RequestBody Course inCourse){
        Optional<Course> optionalCourse = courseService.findCourse(id);
        if (optionalCourse.isPresent()) {
            // Update
            Course course = optionalCourse.get();
            course.setCode(inCourse.getCode());
            course.setCourseName(inCourse.getCourseName());
            course.setDescription(inCourse.getDescription());

            Course updatedCourse = courseService.editCourse(course);
            return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable("id") long id){
        courseService.deleteCourse(id);
    }
}
