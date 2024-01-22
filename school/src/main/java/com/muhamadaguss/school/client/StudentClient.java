package com.muhamadaguss.school.client;

import com.muhamadaguss.school.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service",url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping(path = "/school/{school-id}")
    List<Student> findAllStudentBySchool(
            @PathVariable("school-id") Integer schoolId
    );
}
