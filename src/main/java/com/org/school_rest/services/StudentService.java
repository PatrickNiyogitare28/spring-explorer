package com.org.school_rest.services;

import com.org.school_rest.dto.StudentDto;
import com.org.school_rest.models.Student;

import java.util.List;

public interface StudentService {

    public Student save(StudentDto dto) ;
    public List<Student> getAll();
}