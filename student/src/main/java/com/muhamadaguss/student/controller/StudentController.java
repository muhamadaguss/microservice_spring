package com.muhamadaguss.student.controller;

import com.muhamadaguss.student.entity.Student;
import com.muhamadaguss.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping(path = "/students",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(
            @RequestBody Student student
    ){
        service.saveStudent(student);
    }

    @GetMapping(path = "/students")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> allStudent = service.getAllStudent();
        return ResponseEntity.ok(allStudent);
    }

    @GetMapping(path = "/students/school/{school-id}")
    public ResponseEntity<List<Student>> getAllStudent(
            @PathVariable("school-id") Integer schoolId
    ){
        List<Student> allStudent = service.getAllStudentBySchool(schoolId);
        return ResponseEntity.ok(allStudent);
    }
}
