package com.example.demojpa.repository;

import com.example.demojpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // 1.
    List<Employee> findByDepartment(String department);

    @Query("select e from Employee e where e.department = ?1")
    List<Employee> findByDepartmentJPQL(String department);

    @Query("select e from Employee e where e.department = :department")
    List<Employee> findByDepartmentJPQL1(@Param("department") String department);

    @Query(value = "select * from employee e where e.department = ?1", nativeQuery = true)
    List<Employee> findByDepartmentNQ(String department);
    // 2.
    List<Employee> findBySalaryGreaterThan(Double salary);

    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> findBySalaryGreaterThan1(Double salary);

    @Query("select * from employee e where e.salary > ?1")
    List<Employee> findBySalaryGreaterThan2(Double salary);

    // 3.
    List<Employee> findByName(String name);

    @Query(value = "select * from employee e where e.name = ?1", nativeQuery = true)
    List<Employee> findByName1(String name);

    @Query("select e from Employee e where e.name = :name")
    List<Employee> findByName2(@Param("name") String name);
    // 4.
    List<Employee> findByNameContainingIgnoreCase(String name);

    @Query("select distinct e from Employee where e.name like '%?1  ' ")
    List<Employee> findByNameContainingIgnoreCase1(String name);

    @Query(value = "select distinct * from Employee where e.name like '%?1  ' ", nativeQuery = true)
    List<Employee> findByNameContainingIgnoreCase2(String name);
    // 5.
    List<Employee> findByNameStartWithPrefix(String prefix);

    @Query("select e from Employee e where e.name like '% ?1' ")
    List<Employee> findByNameStartWithPrefix1(String prefix);

    @Query(value = "select * from Employee e where e.name like '% ?1' ", nativeQuery = true)
    List<Employee> findByNameStartWithPrefix2(String prefix);
    // 6.
    List<Employee> findBySalaryBetween(Double minSalary, Double maxSalary);

    @Query("select e from Employee e where e.salary < ?1 & e.salary > ?2")
    List<Employee> findBySalaryBetween1(Double minSalary, Double maxSalary);

    @Query(value = "select * from employee e where e.salary < ?1 & e.salary > ?2", nativeQuery = true)
    List<Employee> findBySalaryBetween2(Double minSalary, Double maxSalary);
    // 7.
    long countByDepartment(String department);

    @Query
    long countByDepartment1(String department);
    // 8.
    List<Employee> findByNameAndDepartment(String name, String department);

    @Query("select e from Employee e where e.name = ?1 & e.department = ?2")
    List<Employee> findByNameAndDepartment1(String name, String department);

    @Query(value = "select * from employee e where e.name = ?1 & e.department = ?2",nativeQuery = true)
    List<Employee> findByNameAndDepartment2(String name, String department);
    // 9.
    List<Employee> findByNameOrDepartment(String name , String department);

    @Query("select e from Employee e where e.name = ?1 || e.dapartment = ?2")
    List<Employee> findByNameOrDepartment1(String name , String department);

    @Query(value = "select * from Employee e where e.name = ?1 || e.dapartment = ?2",nativeQuery = true)
    List<Employee> findByNameOrDepartment2(String name , String department);
    // 10.
    List<Employee> findByJoiningDate(Date joiningDate );

    @Query("select e from Employee e where e.joiningDate = ?1")
    List<Employee> findByJoiningDate1(Date joiningDate );

    @Query("select * from Employee e where e.joiningDate = ?1")
    List<Employee> findByJoiningDate2(Date joiningDate );
}
