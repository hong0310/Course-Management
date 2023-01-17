package com.example.coursesmanagement;

import com.example.coursesmanagement.model.Course;
import com.example.coursesmanagement.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoursesManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursesManagementApplication.class, args);
    }

    // Test
//    @Bean
//    CommandLineRunner loadData(CourseRepository courseRepository){
//        return args -> {
//            Course course1 = new Course();
//            course1.setCode("CSE512");
//            course1.setCourseName("Machine Learning");
//            course1.setDescription("Machine Learning description");
//
//            courseRepository.save(course1);
//        };
//    }
}
