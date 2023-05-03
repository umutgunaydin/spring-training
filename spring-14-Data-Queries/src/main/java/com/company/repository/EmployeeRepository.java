package com.company.repository;

import com.company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // display all employees with email address
    List<Employee> findByEmail(String email);

    //display all employees with firstNAme and lastName
    // also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOOrEmail(String firstName,String lastName,String email);

    //display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where last name starts with ""
    List<Employee> findByLastNameStartingWith(String lastName);

    //display all employees with salaries higher than
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display all employees with salaries less than
    List<Employee> findBySalaryLessThan(Integer salary);

    // display all employees that has been hired between certain dates
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    //display all employees where salaries greater and equal to "" in order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);


    //display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //display all employees that do not have email address
    List<Employee> findByEmailIsNull();


}
