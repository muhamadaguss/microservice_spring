package com.muhamadaguss.school.controller;

import com.muhamadaguss.school.FullSchoolResponse;
import com.muhamadaguss.school.entity.School;
import com.muhamadaguss.school.service.SchoolService;
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
public class SchoolController {

    private final SchoolService service;

    @PostMapping(path = "/schools",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(
            @RequestBody School student
    ){
        service.saveSchool(student);
    }

    @GetMapping(path = "/schools")
    public ResponseEntity<List<School>> getAllStudent(){
        List<School> allSchool = service.getAllSchool();
        return ResponseEntity.ok(allSchool);
    }

    @GetMapping(path = "/schools/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> getAllStudent(
            @PathVariable("school-id") Integer schoolId
    ){
        FullSchoolResponse allSchool = service.getSchoolWithStudents(schoolId);
        return ResponseEntity.ok(allSchool);
    }
}
