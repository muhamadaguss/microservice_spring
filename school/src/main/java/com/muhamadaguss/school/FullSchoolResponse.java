package com.muhamadaguss.school;

import com.muhamadaguss.school.entity.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {

    private String name;

    private String email;

    List<Student> students;
}
