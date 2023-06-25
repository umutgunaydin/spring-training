package com.company.controller;

import com.company.dto.ResponseWrapper;
import com.company.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Company.V3")
                .body(new ResponseWrapper("courses successfully retrieved",courseService.getCourses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id")long id){
        return ResponseEntity
                .ok(new ResponseWrapper("course: "+id+" successfully retrieved",courseService.getCourseById(id)));
    }
}
















