package vn.techmaster.demo.dao;

import vn.techmaster.demo.dto.CourseDto;
import vn.techmaster.demo.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseDAO {
    List<Course> findAll();
    Optional<Course> findById(Integer id);

    void delete(Integer id);

    Course save(Course course);
}
