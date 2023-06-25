package com.company.controller;

import com.company.dto.CourseDTO;
import com.company.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody // to return JSON
@RequestMapping("/courses/api/v1")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
  // @ResponseBody
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
   }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{category}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("category") String categoryName){
        return courseService.getCoursesByCategory(categoryName);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") long courseId,@RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable("id")long id){
        courseService.deleteCourseById(id);
    }



}
