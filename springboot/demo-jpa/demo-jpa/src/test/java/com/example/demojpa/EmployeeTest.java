package com.example.demojpa;

import com.example.demojpa.entity.Employee;
import com.example.demojpa.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findByDepartment(){
        List<Employee> employees = employeeRepository.findByDepartment("A");
        employees.forEach(System.out::println);

        List<Employee> employees1 = employeeRepository.findByDepartmentJPQL("A");
        employees1.forEach(System.out::println);

        List<Employee> employees2 = employeeRepository.findByDepartmentNQ("A");
        employees2.forEach(System.out::println);
    }
}
