package com.muhamadaguss.student.service;

import com.muhamadaguss.student.entity.Student;
import com.muhamadaguss.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentBySchool(Integer schoolId){
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
