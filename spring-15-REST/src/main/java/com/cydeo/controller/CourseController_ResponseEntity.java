package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.entity.Course;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {
    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Company.V2")
                .header("Operation", "Get List")
                .body(courseService.getCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<CourseDTO>> getCourseById(@PathVariable("category") String category) {
        return ResponseEntity.ok(courseService.getCoursesByCategory(category));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(course));
    }

    //void return in ResponseEntity
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id")long id){
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{}id")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") long id,@RequestBody CourseDTO course){
        courseService.updateCourse(id,course);
        return ResponseEntity.noContent().build();
    }

}
