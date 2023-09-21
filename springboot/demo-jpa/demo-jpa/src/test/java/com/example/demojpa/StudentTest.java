package com.example.demojpa;

import com.example.demojpa.entity.Student;
import com.example.demojpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void updateName(){
        studentRepository.updateName(1,"Duy Anh");

        Student student = studentRepository.findById(1).orElse(null);
        System.out.println(student);
    }

    @Test
    void deleteEmail(){
        studentRepository.deleteEmail("anh@gmail.com");
    }

    @Test
    void pagin(){
        Pageable pageable = PageRequest.of(1,5);
        Page<Student> page =  studentRepository.findAll(pageable);
        page.getContent().forEach(System.out::println);

        System.out.println();
        Page<Student> page1 = studentRepository.getAllStudent(pageable);
        page1.getContent().forEach(System.out::println);
    }

    @Test
    void sort(){
        List<Student> students = studentRepository.findByAgeGreaterThanOrderByAgeAsc(35);
        students.forEach(System.out::println);

        List<Student> students1 = studentRepository.findByAgeGreaterThanNQ(35);
        students.forEach(System.out::println);

        List<Student> students2 = studentRepository.findByAgeGreaterThan(35, Sort.by("age").ascending());
        students.forEach(System.out::println);
    }
}
