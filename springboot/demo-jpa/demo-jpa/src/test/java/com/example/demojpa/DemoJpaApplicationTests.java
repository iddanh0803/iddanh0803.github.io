package com.example.demojpa;

import com.example.demojpa.entity.Employee;
import com.example.demojpa.entity.Student;
import com.example.demojpa.repository.EmployeeRepository;
import com.example.demojpa.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoJpaApplicationTests {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Test
	void save_student() {
		Student student = new Student(null, "Duy Anh", "anh@gmail.com", 21);
		studentRepository.save(student);
	}

	@Test
	void save_students(){
		Student student = new Student(null, "gia linh", "linh@gmail.com", 22);
		Student students = new Student(null, "nguyen hoang", "hoang@gmail.com", 23);
		studentRepository.saveAll(List.of(students,student));
	}
	@Test
	void get_all_student(){
		List<Student> students = studentRepository.findAll();
		students.forEach(System.out::println);
	}

	@Test
	void get_by_id(){
		Student student = studentRepository.findById(1).orElse(null);
		System.out.println(student);
	}

	@Test
	void update_student(){
		Student student = studentRepository.findById(11).orElse(null);
		student.setName("Duy Anh");
		studentRepository.save(student);
	}

	@Test
	void delete_by_id(){
		// Xóa theo đối tượng
		Student student = studentRepository.findById(11).orElse(null);
		studentRepository.delete(student);
		// Xóa theo id
		studentRepository.deleteById(12);
	}
	@Test
	void find_by_email(){
		Optional student = studentRepository.findByEmail("anh@gmail.com");
		System.out.println(student);
	}
	@Test
	void save_all_student(){
		Faker faker = new Faker();
		for (int i = 0; i < 100; i++) {
			Student student = new Student(
					null,
					faker.name().fullName(),
					faker.internet().emailAddress(),
					faker.number().numberBetween(18,50)
			);
			studentRepository.save(student);
		}
	}
	@Test
	void find_by_department(){
		List<Employee> employees = employeeRepository.findByDepartment("");
		System.out.println(employees);
	}
	@Test
	void find_by_salary_greater_than(){
		List<Employee> employees = employeeRepository.findBySalaryGreaterThan(12.0);
		System.out.println(employees);
	}
	@Test
	void find_by_name(){
		List<Employee> employees = employeeRepository.findByName("name");
		System.out.println(employees);
	}
	@Test
	void find_by_name_containing_ignore_case(){
		List<Employee> employees = employeeRepository.findByNameContainingIgnoreCase("a");
		System.out.println(employees);
	}


}
