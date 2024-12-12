package com.example.day39exer.Controller;

import com.example.day39exer.ApiResponse.ApiResponse;
import com.example.day39exer.Model.Teacher;
import com.example.day39exer.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        List<Teacher> teachers = teacherService.findAllTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted successfully"));
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
        Teacher teacher = teacherService.getTeacherDetails(id);
        return ResponseEntity.status(200).body(teacher);
    }
}
