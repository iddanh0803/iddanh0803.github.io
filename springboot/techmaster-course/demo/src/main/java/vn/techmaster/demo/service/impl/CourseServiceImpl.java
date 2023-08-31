package vn.techmaster.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.demo.dao.CourseDAO;
import vn.techmaster.demo.dao.UserDAO;
import vn.techmaster.demo.dao.impl.CourseDAOImpl;
import vn.techmaster.demo.dto.CourseDto;
import vn.techmaster.demo.exception.ResourceNotFoundEx;
import vn.techmaster.demo.model.Course;
import vn.techmaster.demo.model.User;
import vn.techmaster.demo.request.UpsertCourseRequest;
import vn.techmaster.demo.service.CourseService;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseDAO courseDAO;

    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDAO.findAll();
    }

    @Override
    public Course getCourseById(Integer id) {
       return courseDAO.findById(id)
               .orElseThrow(()-> new ResourceNotFoundEx("Not found course"));
    }

    @Override
    public void deleteCourse(Integer id) {
        Course course = courseDAO.findById(id)
                .orElseThrow(()-> new ResourceNotFoundEx("Not found course"));
        courseDAO.delete(id);
    }

    @Override
    public Course updateCourse(Integer id, UpsertCourseRequest request) {
        Course course = courseDAO.findById(id)
                .orElseThrow(()-> new ResourceNotFoundEx("Not found Ex"));
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setType(request.getType());
        course.setTopics(request.getTopics());
        course.setThumbnail(request.getThumbnail());
        course.setUserID(request.getUserId());
        return course;
    }

    @Override
    public Course createCourse(UpsertCourseRequest request) {
       Course course = Course.builder()
               .name(request.getName())
               .description(request.getDescription())
               .type(request.getType())
               .topics(request.getTopics())
               .thumbnail(request.getThumbnail())
               .userID(request.getUserId())
               .build();

        return courseDAO.save(course);
    }
}

