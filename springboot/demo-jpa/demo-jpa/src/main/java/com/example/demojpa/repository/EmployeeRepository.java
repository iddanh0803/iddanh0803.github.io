package com.example.demojpa.repository;

import com.example.demojpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryGreaterThan(Double salary);
    List<Employee> findByName(String name);
    List<Employee> findByNameContainingIgnoreCase(String name);
    List<Employee> findByNameStartWithPrefix(String prefix);
    List<Employee> findBySalaryBetween(Double minSalary, Double maxSalary);
    long countByDepartment(String department);
    List<Employee> findByNameAndDepartment(String name, String department);
    List<Employee> findByNameOrDepartment(String name , String department);
    List<Employee> findByJoiningDate(Date joiningDate );
}
