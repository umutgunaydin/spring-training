package com.company.repository;

import com.company.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    //display all departments in the Furniture Department
    List<Department> findByDepartment(String department);

    //display all departments in Health Division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);  // all are same
    List<Department> findByDivisionEquals(String division);

    //display all departments with division name ends with 'ics'
    List<Department> findByDivisionEndingWith(String division);

    //display top 3 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionIsContaining(String division);

    //native query
    @Query(value = "SELECT * FROM departments WHERE division IN ?1",nativeQuery = true)
    List<Department> retrieveDepartmentDivision(List<String> divisions);




}
