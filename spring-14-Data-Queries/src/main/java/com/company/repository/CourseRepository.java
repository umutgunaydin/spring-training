package com.company.repository;

import com.company.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category -- derived query
    List<Course> findByCategory(String category);


    //find all courses by category and order the entities by name -- derived query
    List<Course> findByCategoryOrderByName(String category);


    //checks if a course with the supplied name exists. return true if exists, false otherwise -- derived
    boolean existsByName(String name);

    //returns the count of courses for given category -- derived
    int countByCategory(String category);

    //find all courses that starts with the given course name string -- derived
    List<Course> findByNameStartingWith(String name);

    //find all courses by category and returns a stream -- derived
    Stream<Course> streamAllByCategory(String category);



}
