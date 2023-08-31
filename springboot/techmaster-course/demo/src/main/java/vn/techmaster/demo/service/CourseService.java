package vn.techmaster.demo.service;

import vn.techmaster.demo.dto.CourseDto;
import vn.techmaster.demo.model.Course;
import vn.techmaster.demo.request.UpsertCourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    Course getCourseById(Integer id);
    
    Course updateCourse(Integer id, UpsertCourseRequest request);

    Course createCourse(UpsertCourseRequest request);
    void deleteCourse(Integer id);
}
