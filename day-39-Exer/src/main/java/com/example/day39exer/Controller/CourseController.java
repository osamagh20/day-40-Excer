package com.example.day39exer.Controller;

import com.example.day39exer.ApiResponse.ApiResponse;
import com.example.day39exer.Model.Course;
import com.example.day39exer.Model.Teacher;
import com.example.day39exer.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        List<Course> courses = courseService.findAll();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
    }

    @PostMapping("/link/{teacher_id}/{course_id}")
    public ResponseEntity linkCourseAndTeacher(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseService.linkCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Course link successfully"));
    }

    @GetMapping("/teacher-details/{course_id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer course_id){
        Teacher teacher =  courseService.getTeacherDetails(course_id);
        return ResponseEntity.status(200).body(teacher);
    }

}
