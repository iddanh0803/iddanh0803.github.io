package vn.techmaster.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.demo.database.TopicDB;
import vn.techmaster.demo.dto.CourseDto;
import vn.techmaster.demo.model.Course;
import vn.techmaster.demo.request.UpsertCourseRequest;
import vn.techmaster.demo.response.ErrorResponse;
import vn.techmaster.demo.service.CourseService;

import java.util.List;

@Controller
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    //API trả về view
    @GetMapping("/admin/courses")
    public String getCourseListPage(Model model) {
        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("courseList", courseList);
        return "admin/course/index";
    }

    @GetMapping("/admin/courses/create")
    public String getCourseCreatePage(Model model) {
        model.addAttribute("topicList", TopicDB.topicList);
        return "admin/course/create";
    }

    @GetMapping("/admin/courses/{id}")
    public String getCourseDetailPage(@PathVariable Integer id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        model.addAttribute("topicList", TopicDB.topicList);
        return "admin/course/detail";
    }


    //API trả về JSON
    // 1.Lấy danh sách tất cả khóa học
    @GetMapping("/api/v1/admin/courses")
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> courseList = courseService.getAllCourse();
        return ResponseEntity.ok(courseList);
    }
    // 2.Lấy chi tiết khóa học
    @GetMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<?> getCourseByID(@PathVariable Integer id){
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    // 3.Tạo khóa học
    @PostMapping("/api/v1/admin/courses")
    public ResponseEntity<?> createCourse(@Valid @RequestBody UpsertCourseRequest request){
        Course course = courseService.createCourse(request);
        return new  ResponseEntity<>(course, HttpStatus.CREATED);
        }

    // 4. Cập nhật thông tin khóa học
    @PutMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @Valid @RequestBody UpsertCourseRequest request){
        return ResponseEntity.ok(courseService.updateCourse(id,request));
    }
    // 5. Xóa khóa học
    @DeleteMapping("/api/v1/admin/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
