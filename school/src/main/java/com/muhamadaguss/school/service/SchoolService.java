package com.muhamadaguss.school.service;

import com.muhamadaguss.school.FullSchoolResponse;
import com.muhamadaguss.school.client.StudentClient;
import com.muhamadaguss.school.entity.School;
import com.muhamadaguss.school.entity.Student;
import com.muhamadaguss.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;

    private final StudentClient client;

    public void saveSchool(School school){
        repository.save(school);
    }

    public List<School> getAllSchool(){
        return repository.findAll();
    }

    public FullSchoolResponse getSchoolWithStudents(Integer schoolId){
        School school = repository.findById(schoolId).orElse(
                School
                        .builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build()
        );

        List<Student> students = client.findAllStudentBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
