package com.company.repository;

import com.company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // display all employees with email address
    List<Employee> findByEmail(String email);

    //display all employees with firstNAme and lastName
    // also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName,String email);

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

    @Query("SELECT employee FROM Employee employee WHERE employee.email='amcnee1@google.es' ")
    Employee retrieveEmployeeDetail();

    @Query("SELECT employee.salary FROM Employee employee WHERE employee.email='amcnee1@google.es' ")
    Integer retrieveEmployeeSalary();

    //Not equal -- JPQL
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like / Contains / Starts with / Ends with -- JPQL
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //LessThan -- JPQL
    @Query("SELECT e FROM Employee e WHERE e.salary<?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    // greater than - JPQL
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary>?1")
    List<String> retrieveEmployeeNamesSalaryGreaterThan(int salary);

    //between -- JPQL
    @Query("SELECT e FROM Employee e where e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1,int salary2);

    // before -- JPQL
    @Query("SELECT e FROM Employee e WHERE e.hireDate>?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    // null -- JPQL
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL ")
    List<Employee> retrieveEmployeeEmailIsNull();

    //sorting in asc -- JPQL
    @Query("SELECT e FROM Employee e ORDER BY e.salary ASC ")
    List<Employee> retrieveEmployeeSalaryOrderAsc();


    //native query *********
    //positional parameter
    @Query(value = "SELECT * FROM employees WHERE salary=?1",nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //native query *********
    //name parameter
    @Query(value = "SELECT * FROM employees WHERE salary= :salary",nativeQuery = true)
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);





}
