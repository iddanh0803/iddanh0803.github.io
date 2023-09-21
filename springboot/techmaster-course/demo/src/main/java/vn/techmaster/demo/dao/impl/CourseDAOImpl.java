package vn.techmaster.demo.dao.impl;

import org.springframework.stereotype.Repository;
import vn.techmaster.demo.dao.CourseDAO;
import vn.techmaster.demo.database.CourseDB;
import vn.techmaster.demo.dto.CourseDto;
import vn.techmaster.demo.exception.ResourceNotFoundEx;
import vn.techmaster.demo.model.Course;

import java.util.List;
import java.util.Optional;

@Repository // sao lai la repository
public class CourseDAOImpl implements CourseDAO {
    @Override
    public List<Course> findAll() {
        return CourseDB.courseList;
    }

    @Override
    public Optional<Course> findById(Integer id) {
        return CourseDB.courseList.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }

    @Override
    public void delete(Integer id) {
        CourseDB.courseList.removeIf(course -> course.getId().equals(id));
    }

    @Override
    public Course save(Course course) {
        course.setId(createId());
        CourseDB.courseList.add(course);
        return course;
    }
    private Integer createId() {
        List<Course> courseList = CourseDB.courseList;
        return courseList.stream()
                .map(Course::getId)
                .mapToInt(Integer::valueOf)
                .max().orElse(0) + 1;
    }
}
