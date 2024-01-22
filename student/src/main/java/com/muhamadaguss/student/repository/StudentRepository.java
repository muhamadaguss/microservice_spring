package com.muhamadaguss.student.repository;

import com.muhamadaguss.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findAllBySchoolId(Integer schoolId);
}
