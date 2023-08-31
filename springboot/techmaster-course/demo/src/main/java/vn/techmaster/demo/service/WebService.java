package vn.techmaster.demo.service;

import vn.techmaster.demo.dto.CourseDto;

import java.util.List;

public interface WebService {
    List<CourseDto> getAllCourse(String type, String name, String topic);
    CourseDto getCourseById(Integer id);
}
